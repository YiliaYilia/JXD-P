/**
 * PolListQueryInterfaceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.product.axis.domain;

import java.io.IOException;
import java.util.Properties;

public class PolListQueryInterfaceLocator extends org.apache.axis.client.Service implements cn.com.sinosoft.product.axis.domain.PolListQueryInterface {
	private static Properties pro = new Properties();
	static{
		try {
			pro.load(PolListQueryInterfaceLocator.class.getResourceAsStream("/config/webServiceClient.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public PolListQueryInterfaceLocator() {
    }


    public PolListQueryInterfaceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PolListQueryInterfaceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PolListQueryInterfaceHttpSoap12Endpoint
    private java.lang.String PolListQueryInterfaceHttpSoap12Endpoint_address = pro.getProperty("PolListQueryInterfaceLocatorURL_12");

    public java.lang.String getPolListQueryInterfaceHttpSoap12EndpointAddress() {
        return PolListQueryInterfaceHttpSoap12Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PolListQueryInterfaceHttpSoap12EndpointWSDDServiceName = "PolListQueryInterfaceHttpSoap12Endpoint";

    public java.lang.String getPolListQueryInterfaceHttpSoap12EndpointWSDDServiceName() {
        return PolListQueryInterfaceHttpSoap12EndpointWSDDServiceName;
    }

    public void setPolListQueryInterfaceHttpSoap12EndpointWSDDServiceName(java.lang.String name) {
        PolListQueryInterfaceHttpSoap12EndpointWSDDServiceName = name;
    }

    public cn.com.sinosoft.product.axis.domain.PolListQueryInterfacePortType getPolListQueryInterfaceHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PolListQueryInterfaceHttpSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPolListQueryInterfaceHttpSoap12Endpoint(endpoint);
    }

    public cn.com.sinosoft.product.axis.domain.PolListQueryInterfacePortType getPolListQueryInterfaceHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.product.axis.domain.PolListQueryInterfaceSoap12BindingStub _stub = new cn.com.sinosoft.product.axis.domain.PolListQueryInterfaceSoap12BindingStub(portAddress, this);
            _stub.setPortName(getPolListQueryInterfaceHttpSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPolListQueryInterfaceHttpSoap12EndpointEndpointAddress(java.lang.String address) {
        PolListQueryInterfaceHttpSoap12Endpoint_address = address;
    }


    // Use to get a proxy class for PolListQueryInterfaceHttpSoap11Endpoint
    private java.lang.String PolListQueryInterfaceHttpSoap11Endpoint_address =  pro.getProperty("PolListQueryInterfaceLocatorURL_11");

    public java.lang.String getPolListQueryInterfaceHttpSoap11EndpointAddress() {
        return PolListQueryInterfaceHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PolListQueryInterfaceHttpSoap11EndpointWSDDServiceName = "PolListQueryInterfaceHttpSoap11Endpoint";

    public java.lang.String getPolListQueryInterfaceHttpSoap11EndpointWSDDServiceName() {
        return PolListQueryInterfaceHttpSoap11EndpointWSDDServiceName;
    }

    public void setPolListQueryInterfaceHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        PolListQueryInterfaceHttpSoap11EndpointWSDDServiceName = name;
    }

    public cn.com.sinosoft.product.axis.domain.PolListQueryInterfacePortType getPolListQueryInterfaceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PolListQueryInterfaceHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPolListQueryInterfaceHttpSoap11Endpoint(endpoint);
    }

    public cn.com.sinosoft.product.axis.domain.PolListQueryInterfacePortType getPolListQueryInterfaceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.product.axis.domain.PolListQueryInterfaceSoap11BindingStub _stub = new cn.com.sinosoft.product.axis.domain.PolListQueryInterfaceSoap11BindingStub(portAddress, this);
            _stub.setPortName(getPolListQueryInterfaceHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPolListQueryInterfaceHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        PolListQueryInterfaceHttpSoap11Endpoint_address = address;
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
            if (cn.com.sinosoft.product.axis.domain.PolListQueryInterfacePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.product.axis.domain.PolListQueryInterfaceSoap12BindingStub _stub = new cn.com.sinosoft.product.axis.domain.PolListQueryInterfaceSoap12BindingStub(new java.net.URL(PolListQueryInterfaceHttpSoap12Endpoint_address), this);
                _stub.setPortName(getPolListQueryInterfaceHttpSoap12EndpointWSDDServiceName());
                return _stub;
            }
            if (cn.com.sinosoft.product.axis.domain.PolListQueryInterfacePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.product.axis.domain.PolListQueryInterfaceSoap11BindingStub _stub = new cn.com.sinosoft.product.axis.domain.PolListQueryInterfaceSoap11BindingStub(new java.net.URL(PolListQueryInterfaceHttpSoap11Endpoint_address), this);
                _stub.setPortName(getPolListQueryInterfaceHttpSoap11EndpointWSDDServiceName());
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
        if ("PolListQueryInterfaceHttpSoap12Endpoint".equals(inputPortName)) {
            return getPolListQueryInterfaceHttpSoap12Endpoint();
        }
        else if ("PolListQueryInterfaceHttpSoap11Endpoint".equals(inputPortName)) {
            return getPolListQueryInterfaceHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.sinosoft.com", "PolListQueryInterface");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "PolListQueryInterfaceHttpSoap12Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "PolListQueryInterfaceHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PolListQueryInterfaceHttpSoap12Endpoint".equals(portName)) {
            setPolListQueryInterfaceHttpSoap12EndpointEndpointAddress(address);
        }
        else 
if ("PolListQueryInterfaceHttpSoap11Endpoint".equals(portName)) {
            setPolListQueryInterfaceHttpSoap11EndpointEndpointAddress(address);
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
