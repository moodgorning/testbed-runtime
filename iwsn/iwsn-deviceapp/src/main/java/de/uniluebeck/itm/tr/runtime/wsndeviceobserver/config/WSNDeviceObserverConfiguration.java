//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.11.13 at 05:09:13 PM MEZ 
//


package de.uniluebeck.itm.tr.runtime.wsndeviceobserver.config;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSNDeviceObserverConfiguration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSNDeviceObserverConfiguration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mapping" type="{http://itm.uniluebeck.de/tr/runtime/wsndeviceobserver/config}Mapping" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="configuration" type="{http://itm.uniluebeck.de/tr/runtime/wsndeviceobserver/config}Configuration" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSNDeviceObserverConfiguration", propOrder = {
    "mapping",
    "configuration"
})
@XmlRootElement(name = "wsnDeviceObserver")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-11-13T05:09:13+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class WSNDeviceObserverConfiguration {

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-11-13T05:09:13+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected List<Mapping> mapping;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-11-13T05:09:13+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected List<Configuration> configuration;

    /**
     * Gets the value of the mapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Mapping }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-11-13T05:09:13+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public List<Mapping> getMapping() {
        if (mapping == null) {
            mapping = new ArrayList<Mapping>();
        }
        return this.mapping;
    }

    /**
     * Gets the value of the configuration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the configuration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConfiguration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Configuration }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-11-13T05:09:13+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public List<Configuration> getConfiguration() {
        if (configuration == null) {
            configuration = new ArrayList<Configuration>();
        }
        return this.configuration;
    }

}
