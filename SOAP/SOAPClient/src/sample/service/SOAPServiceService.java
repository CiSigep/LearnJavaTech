/**
 * SOAPServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sample.service;

public interface SOAPServiceService extends javax.xml.rpc.Service {
    public java.lang.String getSOAPServiceAddress();

    public sample.service.SOAPService getSOAPService() throws javax.xml.rpc.ServiceException;

    public sample.service.SOAPService getSOAPService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
