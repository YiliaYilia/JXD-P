/**
 * PolPayDetailLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

import java.io.IOException;
import java.util.Properties;

public class PolPayDetailLocator extends org.apache.axis.client.Service implements cn.com.sinosoft.common.service.axis.PolPayDetail {
	private static Properties pro = new Properties();
	static{
		try {
			pro.load(PolListQueryInterfaceLocator.class.getResourceAsStream("/config/webServiceClient.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public PolPayDetailLocator() {
    }


    public PolPayDetailLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PolPayDetailLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PolPayDetailHttpSoap12Endpoint
    private java.lang.String PolPayDetailHttpSoap12Endpoint_address = pro.getProperty("PolPayDetail_12");

    public java.lang.String getPolPayDetailHttpSoap12EndpointAddress() {
        return PolPayDetailHttpSoap12Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PolPayDetailHttpSoap12EndpointWSDDServiceName = "PolPayDetailHttpSoap12Endpoint";

    public java.lang.String getPolPayDetailHttpSoap12EndpointWSDDServiceName() {
        return PolPayDetailHttpSoap12EndpointWSDDServiceName;
    }

    public void setPolPayDetailHttpSoap12EndpointWSDDServiceName(java.lang.String name) {
        PolPayDetailHttpSoap12EndpointWSDDServiceName = name;
    }

    public cn.com.sinosoft.common.service.axis.PolPayDetailPortType getPolPayDetailHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PolPayDetailHttpSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPolPayDetailHttpSoap12Endpoint(endpoint);
    }

    public cn.com.sinosoft.common.service.axis.PolPayDetailPortType getPolPayDetailHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.common.service.axis.PolPayDetailSoap12BindingStub _stub = new cn.com.sinosoft.common.service.axis.PolPayDetailSoap12BindingStub(portAddress, this);
            _stub.setPortName(getPolPayDetailHttpSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPolPayDetailHttpSoap12EndpointEndpointAddress(java.lang.String address) {
        PolPayDetailHttpSoap12Endpoint_address = address;
    }


    // Use to get a proxy class for PolPayDetailHttpSoap11Endpoint
    private java.lang.String PolPayDetailHttpSoap11Endpoint_address = pro.getProperty("PolPayDetail_12");

    public java.lang.String getPolPayDetailHttpSoap11EndpointAddress() {
        return PolPayDetailHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PolPayDetailHttpSoap11EndpointWSDDServiceName = "PolPayDetailHttpSoap11Endpoint";

    public java.lang.String getPolPayDetailHttpSoap11EndpointWSDDServiceName() {
        return PolPayDetailHttpSoap11EndpointWSDDServiceName;
    }

    public void setPolPayDetailHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        PolPayDetailHttpSoap11EndpointWSDDServiceName = name;
    }

    public cn.com.sinosoft.common.service.axis.PolPayDetailPortType getPolPayDetailHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PolPayDetailHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPolPayDetailHttpSoap11Endpoint(endpoint);
    }

    public cn.com.sinosoft.common.service.axis.PolPayDetailPortType getPolPayDetailHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.common.service.axis.PolPayDetailSoap11BindingStub _stub = new cn.com.sinosoft.common.service.axis.PolPayDetailSoap11BindingStub(portAddress, this);
            _stub.setPortName(getPolPayDetailHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPolPayDetailHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        PolPayDetailHttpSoap11Endpoint_address = address;
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
            if (cn.com.sinosoft.common.service.axis.PolPayDetailPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.common.service.axis.PolPayDetailSoap12BindingStub _stub = new cn.com.sinosoft.common.service.axis.PolPayDetailSoap12BindingStub(new java.net.URL(PolPayDetailHttpSoap12Endpoint_address), this);
                _stub.setPortName(getPolPayDetailHttpSoap12EndpointWSDDServiceName());
                return _stub;
            }
            if (cn.com.sinosoft.common.service.axis.PolPayDetailPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.common.service.axis.PolPayDetailSoap11BindingStub _stub = new cn.com.sinosoft.common.service.axis.PolPayDetailSoap11BindingStub(new java.net.URL(PolPayDetailHttpSoap11Endpoint_address), this);
                _stub.setPortName(getPolPayDetailHttpSoap11EndpointWSDDServiceName());
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
        if ("PolPayDetailHttpSoap12Endpoint".equals(inputPortName)) {
            return getPolPayDetailHttpSoap12Endpoint();
        }
        else if ("PolPayDetailHttpSoap11Endpoint".equals(inputPortName)) {
            return getPolPayDetailHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.sinosoft.com", "PolPayDetail");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "PolPayDetailHttpSoap12Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "PolPayDetailHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PolPayDetailHttpSoap12Endpoint".equals(portName)) {
            setPolPayDetailHttpSoap12EndpointEndpointAddress(address);
        }
        else 
if ("PolPayDetailHttpSoap11Endpoint".equals(portName)) {
            setPolPayDetailHttpSoap11EndpointEndpointAddress(address);
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
