/**
 * ClientBindQuery.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public interface ClientBindQuery extends javax.xml.rpc.Service {
    public java.lang.String getClientBindQueryHttpSoap12EndpointAddress();

    public cn.com.sinosoft.common.service.axis.ClientBindQueryPortType getClientBindQueryHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException;

    public cn.com.sinosoft.common.service.axis.ClientBindQueryPortType getClientBindQueryHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getClientBindQueryHttpSoap11EndpointAddress();

    public cn.com.sinosoft.common.service.axis.ClientBindQueryPortType getClientBindQueryHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException;

    public cn.com.sinosoft.common.service.axis.ClientBindQueryPortType getClientBindQueryHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
