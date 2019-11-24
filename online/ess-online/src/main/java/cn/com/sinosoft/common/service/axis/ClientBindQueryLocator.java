/**
 * ClientBindQueryLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

import java.io.IOException;
import java.util.Properties;

public class ClientBindQueryLocator extends org.apache.axis.client.Service implements cn.com.sinosoft.common.service.axis.ClientBindQuery {
	
	private static Properties pro = new Properties();
	static{
		try {
			pro.load(ClientBindQueryLocator.class.getResourceAsStream("/config/webServiceClient.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
    public ClientBindQueryLocator() {
    }


    public ClientBindQueryLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ClientBindQueryLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ClientBindQueryHttpSoap12Endpoint
    private java.lang.String ClientBindQueryHttpSoap12Endpoint_address = pro.getProperty("ClientBindQueryLocatorURL_12");

    public java.lang.String getClientBindQueryHttpSoap12EndpointAddress() {
        return ClientBindQueryHttpSoap12Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ClientBindQueryHttpSoap12EndpointWSDDServiceName = "ClientBindQueryHttpSoap12Endpoint";

    public java.lang.String getClientBindQueryHttpSoap12EndpointWSDDServiceName() {
        return ClientBindQueryHttpSoap12EndpointWSDDServiceName;
    }

    public void setClientBindQueryHttpSoap12EndpointWSDDServiceName(java.lang.String name) {
        ClientBindQueryHttpSoap12EndpointWSDDServiceName = name;
    }

    public cn.com.sinosoft.common.service.axis.ClientBindQueryPortType getClientBindQueryHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ClientBindQueryHttpSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getClientBindQueryHttpSoap12Endpoint(endpoint);
    }

    public cn.com.sinosoft.common.service.axis.ClientBindQueryPortType getClientBindQueryHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.common.service.axis.ClientBindQuerySoap12BindingStub _stub = new cn.com.sinosoft.common.service.axis.ClientBindQuerySoap12BindingStub(portAddress, this);
            _stub.setPortName(getClientBindQueryHttpSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setClientBindQueryHttpSoap12EndpointEndpointAddress(java.lang.String address) {
        ClientBindQueryHttpSoap12Endpoint_address = address;
    }


    // Use to get a proxy class for ClientBindQueryHttpSoap11Endpoint
    private java.lang.String ClientBindQueryHttpSoap11Endpoint_address = pro.getProperty("ClientBindQueryLocatorURL_11");

    public java.lang.String getClientBindQueryHttpSoap11EndpointAddress() {
        return ClientBindQueryHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ClientBindQueryHttpSoap11EndpointWSDDServiceName = "ClientBindQueryHttpSoap11Endpoint";

    public java.lang.String getClientBindQueryHttpSoap11EndpointWSDDServiceName() {
        return ClientBindQueryHttpSoap11EndpointWSDDServiceName;
    }

    public void setClientBindQueryHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        ClientBindQueryHttpSoap11EndpointWSDDServiceName = name;
    }

    public cn.com.sinosoft.common.service.axis.ClientBindQueryPortType getClientBindQueryHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ClientBindQueryHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getClientBindQueryHttpSoap11Endpoint(endpoint);
    }

    public cn.com.sinosoft.common.service.axis.ClientBindQueryPortType getClientBindQueryHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.common.service.axis.ClientBindQuerySoap11BindingStub _stub = new cn.com.sinosoft.common.service.axis.ClientBindQuerySoap11BindingStub(portAddress, this);
            _stub.setPortName(getClientBindQueryHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setClientBindQueryHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        ClientBindQueryHttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.com.sinosoft.common.service.axis.ClientBindQueryPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.common.service.axis.ClientBindQuerySoap12BindingStub _stub = new cn.com.sinosoft.common.service.axis.ClientBindQuerySoap12BindingStub(new java.net.URL(ClientBindQueryHttpSoap12Endpoint_address), this);
                _stub.setPortName(getClientBindQueryHttpSoap12EndpointWSDDServiceName());
                return _stub;
            }
            if (cn.com.sinosoft.common.service.axis.ClientBindQueryPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.common.service.axis.ClientBindQuerySoap11BindingStub _stub = new cn.com.sinosoft.common.service.axis.ClientBindQuerySoap11BindingStub(new java.net.URL(ClientBindQueryHttpSoap11Endpoint_address), this);
                _stub.setPortName(getClientBindQueryHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ClientBindQueryHttpSoap12Endpoint".equals(inputPortName)) {
            return getClientBindQueryHttpSoap12Endpoint();
        }
        else if ("ClientBindQueryHttpSoap11Endpoint".equals(inputPortName)) {
            return getClientBindQueryHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.sinosoft.com", "ClientBindQuery");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "ClientBindQueryHttpSoap12Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "ClientBindQueryHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ClientBindQueryHttpSoap12Endpoint".equals(portName)) {
            setClientBindQueryHttpSoap12EndpointEndpointAddress(address);
        }
        else 
if ("ClientBindQueryHttpSoap11Endpoint".equals(portName)) {
            setClientBindQueryHttpSoap11EndpointEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
