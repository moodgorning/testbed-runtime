//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.03 at 09:15:54 AM MESZ 
//


package eu.wisebed.ns.wiseml._1;

import javax.annotation.Generated;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://wisebed.eu/ns/wiseml/1.0}setup.properties" minOccurs="0"/>
 *         &lt;element ref="{http://wisebed.eu/ns/wiseml/1.0}defaults" minOccurs="0"/>
 *         &lt;group ref="{http://wisebed.eu/ns/wiseml/1.0}node" maxOccurs="unbounded"/>
 *         &lt;group ref="{http://wisebed.eu/ns/wiseml/1.0}link" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"origin",
		"timeinfo",
		"interpolation",
		"coordinateType",
		"description",
		"defaults",
		"node",
		"link"
})
@XmlRootElement(name = "setup")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
		comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class Setup {

	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	protected Coordinate origin;

	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	protected Timeinfo timeinfo;

	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	protected Interpolation interpolation;

	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	protected String coordinateType;

	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	protected String description;

	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	protected Defaults defaults;

	@XmlElement(required = true)
	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	protected List<Setup.Node> node;

	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	protected List<Setup.Link> link;

	/**
	 * Gets the value of the origin property.
	 *
	 * @return possible object is {@link Coordinate }
	 */
	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	public Coordinate getOrigin() {
		return origin;
	}

	/**
	 * Sets the value of the origin property.
	 *
	 * @param value allowed object is {@link Coordinate }
	 */
	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	public void setOrigin(Coordinate value) {
		this.origin = value;
	}

	/**
	 * Gets the value of the timeinfo property.
	 *
	 * @return possible object is {@link Timeinfo }
	 */
	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	public Timeinfo getTimeinfo() {
		return timeinfo;
	}

	/**
	 * Sets the value of the timeinfo property.
	 *
	 * @param value allowed object is {@link Timeinfo }
	 */
	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	public void setTimeinfo(Timeinfo value) {
		this.timeinfo = value;
	}

	/**
	 * Gets the value of the interpolation property.
	 *
	 * @return possible object is {@link Interpolation }
	 */
	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	public Interpolation getInterpolation() {
		return interpolation;
	}

	/**
	 * Sets the value of the interpolation property.
	 *
	 * @param value allowed object is {@link Interpolation }
	 */
	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	public void setInterpolation(Interpolation value) {
		this.interpolation = value;
	}

	/**
	 * Gets the value of the coordinateType property.
	 *
	 * @return possible object is {@link String }
	 */
	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	public String getCoordinateType() {
		return coordinateType;
	}

	/**
	 * Sets the value of the coordinateType property.
	 *
	 * @param value allowed object is {@link String }
	 */
	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	public void setCoordinateType(String value) {
		this.coordinateType = value;
	}

	/**
	 * Gets the value of the description property.
	 *
	 * @return possible object is {@link String }
	 */
	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 *
	 * @param value allowed object is {@link String }
	 */
	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the defaults property.
	 *
	 * @return possible object is {@link Defaults }
	 */
	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	public Defaults getDefaults() {
		return defaults;
	}

	/**
	 * Sets the value of the defaults property.
	 *
	 * @param value allowed object is {@link Defaults }
	 */
	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	public void setDefaults(Defaults value) {
		this.defaults = value;
	}

	/**
	 * Gets the value of the node property.
	 * <p/>
	 * <p/>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
	 * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the
	 * node property.
	 * <p/>
	 * <p/>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getNode().add(newItem);
	 * </pre>
	 * <p/>
	 * <p/>
	 * <p/>
	 * Objects of the following type(s) are allowed in the list {@link Setup.Node }
	 */
	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	public List<Setup.Node> getNode() {
		if (node == null) {
			node = new ArrayList<Setup.Node>();
		}
		return this.node;
	}

	/**
	 * Gets the value of the link property.
	 * <p/>
	 * <p/>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
	 * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the
	 * link property.
	 * <p/>
	 * <p/>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getLink().add(newItem);
	 * </pre>
	 * <p/>
	 * <p/>
	 * <p/>
	 * Objects of the following type(s) are allowed in the list {@link Setup.Link }
	 */
	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	public List<Setup.Link> getLink() {
		if (link == null) {
			link = new ArrayList<Setup.Link>();
		}
		return this.link;
	}


	/**
	 * <p>Java class for anonymous complex type.
	 * <p/>
	 * <p>The following schema fragment specifies the expected content contained within this class.
	 * <p/>
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;extension base="{http://wisebed.eu/ns/wiseml/1.0}link.properties">
	 *       &lt;attribute name="source" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
	 *       &lt;attribute name="target" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
	 *     &lt;/extension>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	public static class Link
			extends LinkProperties {

		@XmlAttribute(required = true)
		@XmlSchemaType(name = "anySimpleType")
		@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
				comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
		protected String source;

		@XmlAttribute(required = true)
		@XmlSchemaType(name = "anySimpleType")
		@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
				comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
		protected String target;

		/**
		 * Gets the value of the source property.
		 *
		 * @return possible object is {@link String }
		 */
		@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
				comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
		public String getSource() {
			return source;
		}

		/**
		 * Sets the value of the source property.
		 *
		 * @param value allowed object is {@link String }
		 */
		@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
				comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
		public void setSource(String value) {
			this.source = value;
		}

		/**
		 * Gets the value of the target property.
		 *
		 * @return possible object is {@link String }
		 */
		@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
				comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
		public String getTarget() {
			return target;
		}

		/**
		 * Sets the value of the target property.
		 *
		 * @param value allowed object is {@link String }
		 */
		@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
				comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
		public void setTarget(String value) {
			this.target = value;
		}

	}


	/**
	 * <p>Java class for anonymous complex type.
	 * <p/>
	 * <p>The following schema fragment specifies the expected content contained within this class.
	 * <p/>
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;extension base="{http://wisebed.eu/ns/wiseml/1.0}node.properties">
	 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
	 *     &lt;/extension>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
			comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
	public static class Node
			extends NodeProperties {

		@XmlAttribute(required = true)
		@XmlSchemaType(name = "anySimpleType")
		@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
				comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
		protected String id;

		/**
		 * Gets the value of the id property.
		 *
		 * @return possible object is {@link String }
		 */
		@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
				comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
		public String getId() {
			return id;
		}

		/**
		 * Sets the value of the id property.
		 *
		 * @param value allowed object is {@link String }
		 */
		@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
				comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
		public void setId(String value) {
			this.id = value;
		}

	}

}
