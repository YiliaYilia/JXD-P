/**
 * LifeADTPLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

import java.io.IOException;
import java.util.Properties;

public class LifeADTPLocator extends org.apache.axis.client.Service implements cn.com.sinosoft.common.service.axis.LifeADTP {

	private static Properties pro = new Properties();
	static{
		try {
			pro.load(ClientBindQueryLocator.class.getResourceAsStream("/config/webServiceClient.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public LifeADTPLocator() {
    }


    public LifeADTPLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LifeADTPLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LifeADTPHttpSoap11Endpoint
    private java.lang.String LifeADTPHttpSoap11Endpoint_address = pro.getProperty("LifeADTPLocatorURL_11");

    public java.lang.String getLifeADTPHttpSoap11EndpointAddress() {
        return LifeADTPHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LifeADTPHttpSoap11EndpointWSDDServiceName = "LifeADTPHttpSoap11Endpoint";

    public java.lang.String getLifeADTPHttpSoap11EndpointWSDDServiceName() {
        return LifeADTPHttpSoap11EndpointWSDDServiceName;
    }

    public void setLifeADTPHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        LifeADTPHttpSoap11EndpointWSDDServiceName = name;
    }

    public cn.com.sinosoft.common.service.axis.LifeADTPPortType getLifeADTPHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LifeADTPHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLifeADTPHttpSoap11Endpoint(endpoint);
    }

    public cn.com.sinosoft.common.service.axis.LifeADTPPortType getLifeADTPHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.common.service.axis.LifeADTPSoap11BindingStub _stub = new cn.com.sinosoft.common.service.axis.LifeADTPSoap11BindingStub(portAddress, this);
            _stub.setPortName(getLifeADTPHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLifeADTPHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        LifeADTPHttpSoap11Endpoint_address = address;
    }


    // Use to get a proxy class for LifeADTPHttpSoap12Endpoint
    private java.lang.String LifeADTPHttpSoap12Endpoint_address = pro.getProperty("LifeADTPLocatorURL_12");

    public java.lang.String getLifeADTPHttpSoap12EndpointAddress() {
        return LifeADTPHttpSoap12Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LifeADTPHttpSoap12EndpointWSDDServiceName = "LifeADTPHttpSoap12Endpoint";

    public java.lang.String getLifeADTPHttpSoap12EndpointWSDDServiceName() {
        return LifeADTPHttpSoap12EndpointWSDDServiceName;
    }

    public void setLifeADTPHttpSoap12EndpointWSDDServiceName(java.lang.String name) {
        LifeADTPHttpSoap12EndpointWSDDServiceName = name;
    }

    public cn.com.sinosoft.common.service.axis.LifeADTPPortType getLifeADTPHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LifeADTPHttpSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLifeADTPHttpSoap12Endpoint(endpoint);
    }

    public cn.com.sinosoft.common.service.axis.LifeADTPPortType getLifeADTPHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.common.service.axis.LifeADTPSoap12BindingStub _stub = new cn.com.sinosoft.common.service.axis.LifeADTPSoap12BindingStub(portAddress, this);
            _stub.setPortName(getLifeADTPHttpSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLifeADTPHttpSoap12EndpointEndpointAddress(java.lang.String address) {
        LifeADTPHttpSoap12Endpoint_address = address;
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
            if (cn.com.sinosoft.common.service.axis.LifeADTPPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.common.service.axis.LifeADTPSoap11BindingStub _stub = new cn.com.sinosoft.common.service.axis.LifeADTPSoap11BindingStub(new java.net.URL(LifeADTPHttpSoap11Endpoint_address), this);
                _stub.setPortName(getLifeADTPHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
            if (cn.com.sinosoft.common.service.axis.LifeADTPPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.common.service.axis.LifeADTPSoap12BindingStub _stub = new cn.com.sinosoft.common.service.axis.LifeADTPSoap12BindingStub(new java.net.URL(LifeADTPHttpSoap12Endpoint_address), this);
                _stub.setPortName(getLifeADTPHttpSoap12EndpointWSDDServiceName());
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
        if ("LifeADTPHttpSoap11Endpoint".equals(inputPortName)) {
            return getLifeADTPHttpSoap11Endpoint();
        }
        else if ("LifeADTPHttpSoap12Endpoint".equals(inputPortName)) {
            return getLifeADTPHttpSoap12Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.sinosoft.com", "LifeADTP");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "LifeADTPHttpSoap11Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "LifeADTPHttpSoap12Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LifeADTPHttpSoap11Endpoint".equals(portName)) {
            setLifeADTPHttpSoap11EndpointEndpointAddress(address);
        }
        else 
if ("LifeADTPHttpSoap12Endpoint".equals(portName)) {
            setLifeADTPHttpSoap12EndpointEndpointAddress(address);
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
