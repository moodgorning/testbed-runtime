/**********************************************************************************************************************
 * Copyright (c) 2010, Institute of Telematics, University of Luebeck                                                 *
 * All rights reserved.                                                                                               *
 *                                                                                                                    *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the   *
 * following conditions are met:                                                                                      *
 *                                                                                                                    *
 * - Redistributions of source code must retain the above copyright notice, this list of conditions and the following *
 *   disclaimer.                                                                                                      *
 * - Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the        *
 *   following disclaimer in the documentation and/or other materials provided with the distribution.                 *
 * - Neither the name of the University of Luebeck nor the names of its contributors may be used to endorse or promote*
 *   products derived from this software without specific prior written permission.                                   *
 *                                                                                                                    *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, *
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE      *
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,         *
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE *
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF    *
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY   *
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.                                *
 **********************************************************************************************************************/

package de.uniluebeck.itm.tr.snaa.cmdline.server;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import de.uniluebeck.itm.tr.snaa.dummy.DummySNAA;
import de.uniluebeck.itm.tr.snaa.federator.FederatorSNAA;
import de.uniluebeck.itm.tr.snaa.jaas.JAASSNAA;
import de.uniluebeck.itm.tr.snaa.shibboleth.ShibbolethSNAA;
import de.uniluebeck.itm.tr.snaa.wisebed.WisebedSnaaFederator;
import eu.wisebed.testbed.api.snaa.authorization.IUserAuthorization;
import eu.wisebed.testbed.api.snaa.v1.*;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import java.io.FileReader;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("restriction")
public class Server {

	private static final Logger log = LoggerFactory.getLogger(Server.class);

	private static final String shibbolethSecretUserKeyUrl = "https://gridlab23.unibe.ch/portal/SNA/secretUserKey";

	private static SNAA federator;

	private static HttpServer server;

	private enum FederatorType {
		GENERIC, WISEBED
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		String propertyFile = null;

		// create the command line parser
		CommandLineParser parser = new PosixParser();
		Options options = new Options();
		options.addOption("f", "file", true, "The properties file");
		options.addOption("v", "verbose", false, "Verbose logging output");
		options.addOption("h", "help", false, "Help output");

		try {
			CommandLine line = parser.parse(options, args);

			if (line.hasOption('v')) {
				org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.DEBUG);
			}

			if (line.hasOption('h')) {
				usage(options);
			}

			if (line.hasOption('f')) {
				propertyFile = line.getOptionValue('f');
			} else {
				throw new Exception("Please supply -f");
			}

		} catch (Exception e) {
			log.error("Invalid command line: " + e, e);
			usage(options);
		}

		Properties props = new Properties();
		props.load(new FileReader(propertyFile));
		startFromProperties(props);

		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				log.info("Received shutdown signal. Shutting down...");
				server.stop(3);
			}
		}));

	}

	private static void startFromProperties(Properties props) throws Exception {
		int port = Integer.parseInt(props.getProperty("config.port", "8080"));

		startHttpServer(port);

		Set<String> snaaNames = parseCSV(props.getProperty("config.snaas", ""));

		String type, urnprefix, path;
		for (String snaaName : snaaNames) {

			type = props.getProperty(snaaName + ".type", "");
			path = props.getProperty(snaaName + ".path", "/snaa/" + snaaName);

			if ("dummy".equals(type)) {

				urnprefix = props.getProperty(snaaName + ".urnprefix", "urn:default:" + snaaName);
				startDummySNAA(path, urnprefix);

			} else if ("shibboleth".equals(type)) {

				urnprefix = props.getProperty(snaaName + ".urnprefix", "urn:default:" + snaaName);
				String secretAuthkeyUrl = props.getProperty(snaaName + ".secret_user_key_url",
						shibbolethSecretUserKeyUrl
				);
				String authorizationClassName = props.getProperty(snaaName + ".authorization_class",
						"eu.wisebed.testbed.api.snaa.authorization.AlwaysAllowAuthorization"
				);

				startShibbolethSNAA(path, urnprefix, secretAuthkeyUrl, getAuthorizationModule(authorizationClassName));

			} else if ("jaas".equals(type)) {

				urnprefix = props.getProperty(snaaName + ".urnprefix", "urn:default:" + snaaName);
				String jaasModuleName = props.getProperty(snaaName + ".module", null);
				String jaasConfigFile = props.getProperty(snaaName + ".configfile", null);
				String authorizationClassName = props.getProperty(snaaName + ".authorization_class",
						"eu.wisebed.testbed.api.snaa.authorization.AlwaysAllowAuthorization"
				);

				if (jaasConfigFile == null) {
					throw new Exception(("Supply a value for " + snaaName + ".configfile"));
				}

				if (jaasModuleName == null) {
					throw new Exception(("Supply a value for " + snaaName + ".module"));
				}

				startJAASSNAA(path, urnprefix, jaasModuleName, jaasConfigFile,
						getAuthorizationModule(authorizationClassName)
				);

			} else if ("wisebed-federator".equals(type) || "federator".equals(type)) {
				FederatorType fedType = FederatorType.GENERIC;
				String secretAuthkeyUrl = null;

				if ("wisebed-federator".equals(type)) {
					fedType = FederatorType.WISEBED;
					secretAuthkeyUrl = props.getProperty(props.getProperty(snaaName + ".secret_user_key_url", ""));
				}

				// endpoint url -> set<urnprefix>
				Map<String, Set<String>> federatedUrnPrefixes = new HashMap<String, Set<String>>();

				Set<String> federates = parseCSV(props.getProperty(snaaName + ".federates", ""));
				for (String federatedName : federates) {

					Set<String> urnPrefixes = parseCSV(props.getProperty(snaaName + "." + federatedName
							+ ".urnprefixes"
					)
					);
					String endpointUrl = props.getProperty(snaaName + "." + federatedName + ".endpointurl",
							shibbolethSecretUserKeyUrl
					);

					federatedUrnPrefixes.put(endpointUrl, urnPrefixes);

				}

				startFederator(fedType, path, secretAuthkeyUrl, federatedUrnPrefixes);

			} else {
				log.error("Found unknown type " + type + " for snaa name " + snaaName + ". Ignoring...");
			}

		}
	}

	private static IUserAuthorization getAuthorizationModule(String className) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		return (IUserAuthorization) Class.forName(className).newInstance();
	}

	private static void startJAASSNAA(String path, String urnprefix, String jaasModuleName, String jaasConfigFile,
									  IUserAuthorization authorization) {

		log.debug("Starting JAAS SNAA, path [" + path + "], prefix[" + urnprefix + "], jaasConfigFile["
				+ jaasConfigFile + "], jaasModuleName[" + jaasModuleName + "], authorization[" + authorization + "]"
		);

		System.setProperty("java.security.auth.login.config", jaasConfigFile);

		JAASSNAA jaasSnaa = new JAASSNAA(urnprefix, jaasModuleName, authorization);

		HttpContext context = server.createContext(path);
		Endpoint endpoint = Endpoint.create(jaasSnaa);
		endpoint.publish(context);

		log.debug("Started JAAS SNAA on " + server.getAddress() + path);
	}

	private static void startDummySNAA(String path, String prefix) {

		DummySNAA dummySNAA = new DummySNAA();

		HttpContext context = server.createContext(path);
		Endpoint endpoint = Endpoint.create(dummySNAA);
		endpoint.publish(context);

		log.info("Started dummy SNAA on " + server.getAddress() + path);

	}

	private static void startShibbolethSNAA(String path, String prefix, String secretKeyURL,
											IUserAuthorization authorization) {

		log.debug("Starting Shibboleth SNAA, path [" + path + "], prefix[" + prefix + "], secretKeyURL[" + secretKeyURL
				+ "], authorization[" + authorization + "]"
		);

		Set<String> prefixes = new HashSet<String>();
		prefixes.add(prefix);

		ShibbolethSNAA shibSnaa = new ShibbolethSNAA(prefixes, secretKeyURL, authorization);

		HttpContext context = server.createContext(path);
		Endpoint endpoint = Endpoint.create(shibSnaa);
		endpoint.publish(context);

		log.debug("Started shibboleth SNAA on " + server.getAddress() + path);

	}

	private static void startFederator(FederatorType type, String path, String secretAuthKeyURL,
									   Map<String, Set<String>>... prefixSets) {

		// union the prefix sets to one set
		Map<String, Set<String>> prefixSet = new HashMap<String, Set<String>>();
		for (Map<String, Set<String>> p : prefixSets) {
			prefixSet.putAll(p);
		}

		// Debug
		{
			log.debug("Starting Federator with the following prefixes: ");
			for (Entry<String, Set<String>> entry : prefixSet.entrySet()) {
				log.debug("Prefix: url=" + entry.getKey() + ", prefixes: "
						+ Arrays.toString(entry.getValue().toArray())
				);
			}
		}

		switch (type) {
			case GENERIC:
				federator = new FederatorSNAA(prefixSet);
				break;
			case WISEBED:
				federator = new WisebedSnaaFederator(prefixSet, secretAuthKeyURL);
				break;
		}

		HttpContext context = server.createContext(path);
		Endpoint endpoint = Endpoint.create(federator);
		endpoint.publish(context);

		log.debug("Started " + type + " federator SNAA on " + server.getAddress() + path);

	}

	private static void startHttpServer(int port) throws Exception {

		server = HttpServer.create(new InetSocketAddress(port), 5);
		// bind to a maximum of three threads which should be enough for an snaa system
		server.setExecutor(new ThreadPoolExecutor(
				1,
				3,
				60L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>(),
				new ThreadFactoryBuilder().setNameFormat("SNAA-Thread %d").build()
		)
		);
		server.start();

	}

	private static Set<String> parseCSV(String str) {
		String[] split = str.split(",");
		Set<String> trimmedSplit = new HashSet<String>();
		for (String string : split) {
			trimmedSplit.add(string.trim());
		}
		return trimmedSplit;
	}

	private static void usage(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("de.uniluebeck.itm.tr.snaa.cmdline.Main", options);
		System.exit(1);
	}

	@SuppressWarnings("unused")
	private static void callShibbAsWS() throws MalformedURLException, SNAAExceptionException,
			AuthenticationExceptionException {

		SNAAService service = new SNAAService(new URL("http://localhost:8080/snaa/shib1"), new QName(
				"http://testbed.wisebed.eu/api/snaa/v1/", "SNAAService"
		)
		);
		SNAA port = service.getPort(SNAA.class);

		AuthenticationTriple auth1 = new AuthenticationTriple();
		auth1.setUrnPrefix("urn:wisebed:shib1");
		auth1.setUsername("pfisterer@wisebed1.itm.uni-luebeck.de");
		auth1.setPassword("xxx");

		List<AuthenticationTriple> authTriples = new ArrayList<AuthenticationTriple>();
		authTriples.add(auth1);
		port.authenticate(authTriples);
		Action action = new Action();
		action.setAction("sth");
		port.isAuthorized(new ArrayList<SecretAuthenticationKey>(), action);

	}

	@SuppressWarnings("unused")
	private static void callFederatorAsWS() throws MalformedURLException, SNAAExceptionException,
			AuthenticationExceptionException {

		SNAAService service = new SNAAService(new URL("http://localhost:8080/snaa/fed1"), new QName(
				"http://testbed.wisebed.eu/api/snaa/v1/", "SNAAService"
		)
		);
		SNAA port = service.getPort(SNAA.class);

		List<AuthenticationTriple> authTriples = new ArrayList<AuthenticationTriple>();

		AuthenticationTriple auth1 = new AuthenticationTriple();
		auth1.setUrnPrefix("urn:wisebed:shib1");
		auth1.setUsername("bimschas@wisebed1.itm.uni-luebeck.de");
		auth1.setPassword("xxx");
		authTriples.add(auth1);

		AuthenticationTriple auth2 = new AuthenticationTriple();
		auth2.setUrnPrefix("urn:wisebed:dummy1");
		auth2.setUsername("bimschas@wisebed1.itm.uni-luebeck.de");
		auth2.setPassword("xxx");
		authTriples.add(auth2);

		AuthenticationTriple auth3 = new AuthenticationTriple();
		auth3.setUrnPrefix("urn:wisebed:dummy2");
		auth3.setUsername("bimschas@wisebed1.itm.uni-luebeck.de");
		auth3.setPassword("xxx");
		authTriples.add(auth3);

		AuthenticationTriple auth4 = new AuthenticationTriple();
		auth4.setUrnPrefix("urn:wisebed:shib2");
		auth4.setUsername("bimschas@wisebed1.itm.uni-luebeck.de");
		auth4.setPassword("xxx");
		authTriples.add(auth4);

		try {
			List<SecretAuthenticationKey> keys = port.authenticate(authTriples);
			log.info("Got authentication keys: " + keys);
			Action action = new Action();
			action.setAction("sth");
			boolean b = port.isAuthorized(new ArrayList<SecretAuthenticationKey>(), action);
			log.info("Is authorized: " + b);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	private static void callFederatorJVMInternal() {

		try {
			federator.authenticate(new ArrayList<AuthenticationTriple>());
		} catch (SNAAExceptionException e) {
			e.printStackTrace();
		} catch (AuthenticationExceptionException e) {
			e.printStackTrace();
		}

		try {
			Action action = new Action();
			action.setAction("sth");
			federator.isAuthorized(new ArrayList<SecretAuthenticationKey>(), action);
		} catch (SNAAExceptionException e) {
			e.printStackTrace();
		}

	}

}
