/**
 * PartyChangeLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2 May 03, 2005 (02:20:24 EDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

import java.io.IOException;
import java.util.Properties;

public class PartyChangeLocator extends org.apache.axis.client.Service implements cn.com.sinosoft.common.service.axis.PartyChange {
	
	private static Properties pro = new Properties();
	static{
		try {
			pro.load(PartyChangeLocator.class.getResourceAsStream("/config/webServiceClient.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    public PartyChangeLocator() {
    }


    public PartyChangeLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PartyChangeLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PartyChangeHttpSoap12Endpoint
    private java.lang.String PartyChangeHttpSoap12Endpoint_address = pro.getProperty("PartyChangeLocatorURL_12");

    public java.lang.String getPartyChangeHttpSoap12EndpointAddress() {
        return PartyChangeHttpSoap12Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PartyChangeHttpSoap12EndpointWSDDServiceName = "PartyChangeHttpSoap12Endpoint";

    public java.lang.String getPartyChangeHttpSoap12EndpointWSDDServiceName() {
        return PartyChangeHttpSoap12EndpointWSDDServiceName;
    }

    public void setPartyChangeHttpSoap12EndpointWSDDServiceName(java.lang.String name) {
        PartyChangeHttpSoap12EndpointWSDDServiceName = name;
    }

    public cn.com.sinosoft.common.service.axis.PartyChangePortType getPartyChangeHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PartyChangeHttpSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPartyChangeHttpSoap12Endpoint(endpoint);
    }

    public cn.com.sinosoft.common.service.axis.PartyChangePortType getPartyChangeHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.common.service.axis.PartyChangeSoap12BindingStub _stub = new cn.com.sinosoft.common.service.axis.PartyChangeSoap12BindingStub(portAddress, this);
            _stub.setPortName(getPartyChangeHttpSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPartyChangeHttpSoap12EndpointEndpointAddress(java.lang.String address) {
        PartyChangeHttpSoap12Endpoint_address = address;
    }


    // Use to get a proxy class for PartyChangeHttpSoap11Endpoint
    private java.lang.String PartyChangeHttpSoap11Endpoint_address = pro.getProperty("PartyChangeLocatorURL_11");

    public java.lang.String getPartyChangeHttpSoap11EndpointAddress() {
        return PartyChangeHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PartyChangeHttpSoap11EndpointWSDDServiceName = "PartyChangeHttpSoap11Endpoint";

    public java.lang.String getPartyChangeHttpSoap11EndpointWSDDServiceName() {
        return PartyChangeHttpSoap11EndpointWSDDServiceName;
    }

    public void setPartyChangeHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        PartyChangeHttpSoap11EndpointWSDDServiceName = name;
    }

    public cn.com.sinosoft.common.service.axis.PartyChangePortType getPartyChangeHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PartyChangeHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPartyChangeHttpSoap11Endpoint(endpoint);
    }

    public cn.com.sinosoft.common.service.axis.PartyChangePortType getPartyChangeHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.common.service.axis.PartyChangeSoap11BindingStub _stub = new cn.com.sinosoft.common.service.axis.PartyChangeSoap11BindingStub(portAddress, this);
            _stub.setPortName(getPartyChangeHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPartyChangeHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        PartyChangeHttpSoap11Endpoint_address = address;
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
            if (cn.com.sinosoft.common.service.axis.PartyChangePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.common.service.axis.PartyChangeSoap12BindingStub _stub = new cn.com.sinosoft.common.service.axis.PartyChangeSoap12BindingStub(new java.net.URL(PartyChangeHttpSoap12Endpoint_address), this);
                _stub.setPortName(getPartyChangeHttpSoap12EndpointWSDDServiceName());
                return _stub;
            }
            if (cn.com.sinosoft.common.service.axis.PartyChangePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.common.service.axis.PartyChangeSoap11BindingStub _stub = new cn.com.sinosoft.common.service.axis.PartyChangeSoap11BindingStub(new java.net.URL(PartyChangeHttpSoap11Endpoint_address), this);
                _stub.setPortName(getPartyChangeHttpSoap11EndpointWSDDServiceName());
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
        if ("PartyChangeHttpSoap12Endpoint".equals(inputPortName)) {
            return getPartyChangeHttpSoap12Endpoint();
        }
        else if ("PartyChangeHttpSoap11Endpoint".equals(inputPortName)) {
            return getPartyChangeHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.sinosoft.com", "PartyChange");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "PartyChangeHttpSoap12Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "PartyChangeHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        if ("PartyChangeHttpSoap12Endpoint".equals(portName)) {
            setPartyChangeHttpSoap12EndpointEndpointAddress(address);
        }
        if ("PartyChangeHttpSoap11Endpoint".equals(portName)) {
            setPartyChangeHttpSoap11EndpointEndpointAddress(address);
        }
        else { // Unknown Port Name
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
