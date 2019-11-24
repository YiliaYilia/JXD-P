/**
 * PolicyBasicQueryLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

import java.io.IOException;
import java.util.Properties;

public class PolicyBasicQueryLocator extends org.apache.axis.client.Service implements cn.com.sinosoft.common.service.axis.PolicyBasicQuery{
	
	private static Properties pro = new Properties();
	static{
		try {
			pro.load(PolListQueryInterfaceLocator.class.getResourceAsStream("/config/webServiceClient.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public PolicyBasicQueryLocator() {
    }


    public PolicyBasicQueryLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PolicyBasicQueryLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PolicyBasicQueryHttpSoap11Endpoint
    private java.lang.String PolicyBasicQueryHttpSoap11Endpoint_address = pro.getProperty("PolicyBasicQueryLocatorURL_11");

    public java.lang.String getPolicyBasicQueryHttpSoap11EndpointAddress() {
        return PolicyBasicQueryHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PolicyBasicQueryHttpSoap11EndpointWSDDServiceName = "PolicyBasicQueryHttpSoap11Endpoint";

    public java.lang.String getPolicyBasicQueryHttpSoap11EndpointWSDDServiceName() {
        return PolicyBasicQueryHttpSoap11EndpointWSDDServiceName;
    }

    public void setPolicyBasicQueryHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        PolicyBasicQueryHttpSoap11EndpointWSDDServiceName = name;
    }

    public cn.com.sinosoft.common.service.axis.PolicyBasicQueryPortType getPolicyBasicQueryHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PolicyBasicQueryHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPolicyBasicQueryHttpSoap11Endpoint(endpoint);
    }

    public cn.com.sinosoft.common.service.axis.PolicyBasicQueryPortType getPolicyBasicQueryHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.common.service.axis.PolicyBasicQuerySoap11BindingStub _stub = new cn.com.sinosoft.common.service.axis.PolicyBasicQuerySoap11BindingStub(portAddress, this);
            _stub.setPortName(getPolicyBasicQueryHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPolicyBasicQueryHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        PolicyBasicQueryHttpSoap11Endpoint_address = address;
    }


    // Use to get a proxy class for PolicyBasicQueryHttpSoap12Endpoint
    private java.lang.String PolicyBasicQueryHttpSoap12Endpoint_address = pro.getProperty("PolicyBasicQueryLocatorURL_12");

    public java.lang.String getPolicyBasicQueryHttpSoap12EndpointAddress() {
        return PolicyBasicQueryHttpSoap12Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PolicyBasicQueryHttpSoap12EndpointWSDDServiceName = "PolicyBasicQueryHttpSoap12Endpoint";

    public java.lang.String getPolicyBasicQueryHttpSoap12EndpointWSDDServiceName() {
        return PolicyBasicQueryHttpSoap12EndpointWSDDServiceName;
    }

    public void setPolicyBasicQueryHttpSoap12EndpointWSDDServiceName(java.lang.String name) {
        PolicyBasicQueryHttpSoap12EndpointWSDDServiceName = name;
    }

    public cn.com.sinosoft.common.service.axis.PolicyBasicQueryPortType getPolicyBasicQueryHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PolicyBasicQueryHttpSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPolicyBasicQueryHttpSoap12Endpoint(endpoint);
    }

    public cn.com.sinosoft.common.service.axis.PolicyBasicQueryPortType getPolicyBasicQueryHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.common.service.axis.PolicyBasicQuerySoap12BindingStub _stub = new cn.com.sinosoft.common.service.axis.PolicyBasicQuerySoap12BindingStub(portAddress, this);
            _stub.setPortName(getPolicyBasicQueryHttpSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPolicyBasicQueryHttpSoap12EndpointEndpointAddress(java.lang.String address) {
        PolicyBasicQueryHttpSoap12Endpoint_address = address;
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
            if (cn.com.sinosoft.common.service.axis.PolicyBasicQueryPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.common.service.axis.PolicyBasicQuerySoap11BindingStub _stub = new cn.com.sinosoft.common.service.axis.PolicyBasicQuerySoap11BindingStub(new java.net.URL(PolicyBasicQueryHttpSoap11Endpoint_address), this);
                _stub.setPortName(getPolicyBasicQueryHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
            if (cn.com.sinosoft.common.service.axis.PolicyBasicQueryPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.common.service.axis.PolicyBasicQuerySoap12BindingStub _stub = new cn.com.sinosoft.common.service.axis.PolicyBasicQuerySoap12BindingStub(new java.net.URL(PolicyBasicQueryHttpSoap12Endpoint_address), this);
                _stub.setPortName(getPolicyBasicQueryHttpSoap12EndpointWSDDServiceName());
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
        if ("PolicyBasicQueryHttpSoap11Endpoint".equals(inputPortName)) {
            return getPolicyBasicQueryHttpSoap11Endpoint();
        }
        else if ("PolicyBasicQueryHttpSoap12Endpoint".equals(inputPortName)) {
            return getPolicyBasicQueryHttpSoap12Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.sinosoft.com", "PolicyBasicQuery");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "PolicyBasicQueryHttpSoap11Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "PolicyBasicQueryHttpSoap12Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PolicyBasicQueryHttpSoap11Endpoint".equals(portName)) {
            setPolicyBasicQueryHttpSoap11EndpointEndpointAddress(address);
        }
        else 
if ("PolicyBasicQueryHttpSoap12Endpoint".equals(portName)) {
            setPolicyBasicQueryHttpSoap12EndpointEndpointAddress(address);
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
