//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.02 at 10:09:33 AM MEZ 
//


package de.uniluebeck.itm.tr.runtime.wsnapp.xml;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Configuration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Configuration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Configuration")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-02T10:09:33+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class Configuration {

    @XmlAttribute
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-02T10:09:33+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String key;
    @XmlAttribute
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-02T10:09:33+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String value;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-02T10:09:33+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-02T10:09:33+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-02T10:09:33+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-02T10:09:33+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setValue(String value) {
        this.value = value;
    }

}
