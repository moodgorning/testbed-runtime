
package eu.wisebed.api.rs;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "ReservationConflictFault", targetNamespace = "urn:RSService")
public class ReservervationConflictExceptionException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ReservervationConflictException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public ReservervationConflictExceptionException(String message, ReservervationConflictException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public ReservervationConflictExceptionException(String message, ReservervationConflictException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: eu.wisebed.api.rs.ReservervationConflictException
     */
    public ReservervationConflictException getFaultInfo() {
        return faultInfo;
    }

}
