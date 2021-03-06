//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.03 at 09:15:54 AM MESZ 
//


package eu.wisebed.ns.wiseml._1;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for interpolation.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="interpolation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="linear"/>
 *     &lt;enumeration value="polynomial"/>
 *     &lt;enumeration value="cubic"/>
 *     &lt;enumeration value="spline"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "interpolation")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2010-06-03T09:15:54+02:00",
		comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public enum Interpolation {

	@XmlEnumValue("none")
	NONE("none"),
	@XmlEnumValue("linear")
	LINEAR("linear"),
	@XmlEnumValue("polynomial")
	POLYNOMIAL("polynomial"),
	@XmlEnumValue("cubic")
	CUBIC("cubic"),
	@XmlEnumValue("spline")
	SPLINE("spline");

	private final String value;

	Interpolation(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static Interpolation fromValue(String v) {
		for (Interpolation c : Interpolation.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
