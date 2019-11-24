/**
 * PolicyWeChatQueryLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

import java.io.IOException;
import java.util.Properties;

public class PolicyWeChatQueryLocator extends org.apache.axis.client.Service implements cn.com.sinosoft.common.service.axis.PolicyWeChatQuery {


	private static Properties pro = new Properties();
	static{
		try {
			pro.load(PolListQueryInterfaceLocator.class.getResourceAsStream("/config/webServiceClient.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



    public PolicyWeChatQueryLocator() {
    }


    public PolicyWeChatQueryLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PolicyWeChatQueryLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PolicyWeChatQueryHttpSoap11Endpoint
    private java.lang.String PolicyWeChatQueryHttpSoap11Endpoint_address = pro.getProperty("PolicyWeChatQueryLocatorURL_11");

    public java.lang.String getPolicyWeChatQueryHttpSoap11EndpointAddress() {
        return PolicyWeChatQueryHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PolicyWeChatQueryHttpSoap11EndpointWSDDServiceName = "PolicyWeChatQueryHttpSoap11Endpoint";

    public java.lang.String getPolicyWeChatQueryHttpSoap11EndpointWSDDServiceName() {
        return PolicyWeChatQueryHttpSoap11EndpointWSDDServiceName;
    }

    public void setPolicyWeChatQueryHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        PolicyWeChatQueryHttpSoap11EndpointWSDDServiceName = name;
    }

    public cn.com.sinosoft.common.service.axis.PolicyWeChatQueryPortType getPolicyWeChatQueryHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PolicyWeChatQueryHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPolicyWeChatQueryHttpSoap11Endpoint(endpoint);
    }

    public cn.com.sinosoft.common.service.axis.PolicyWeChatQueryPortType getPolicyWeChatQueryHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.common.service.axis.PolicyWeChatQuerySoap11BindingStub _stub = new cn.com.sinosoft.common.service.axis.PolicyWeChatQuerySoap11BindingStub(portAddress, this);
            _stub.setPortName(getPolicyWeChatQueryHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPolicyWeChatQueryHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        PolicyWeChatQueryHttpSoap11Endpoint_address = address;
    }


    // Use to get a proxy class for PolicyWeChatQueryHttpSoap12Endpoint
    private java.lang.String PolicyWeChatQueryHttpSoap12Endpoint_address =  pro.getProperty("PolicyWeChatQueryLocatorURL_12");

    public java.lang.String getPolicyWeChatQueryHttpSoap12EndpointAddress() {
        return PolicyWeChatQueryHttpSoap12Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PolicyWeChatQueryHttpSoap12EndpointWSDDServiceName = "PolicyWeChatQueryHttpSoap12Endpoint";

    public java.lang.String getPolicyWeChatQueryHttpSoap12EndpointWSDDServiceName() {
        return PolicyWeChatQueryHttpSoap12EndpointWSDDServiceName;
    }

    public void setPolicyWeChatQueryHttpSoap12EndpointWSDDServiceName(java.lang.String name) {
        PolicyWeChatQueryHttpSoap12EndpointWSDDServiceName = name;
    }

    public cn.com.sinosoft.common.service.axis.PolicyWeChatQueryPortType getPolicyWeChatQueryHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PolicyWeChatQueryHttpSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPolicyWeChatQueryHttpSoap12Endpoint(endpoint);
    }

    public cn.com.sinosoft.common.service.axis.PolicyWeChatQueryPortType getPolicyWeChatQueryHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.common.service.axis.PolicyWeChatQuerySoap12BindingStub _stub = new cn.com.sinosoft.common.service.axis.PolicyWeChatQuerySoap12BindingStub(portAddress, this);
            _stub.setPortName(getPolicyWeChatQueryHttpSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPolicyWeChatQueryHttpSoap12EndpointEndpointAddress(java.lang.String address) {
        PolicyWeChatQueryHttpSoap12Endpoint_address = address;
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
            if (cn.com.sinosoft.common.service.axis.PolicyWeChatQueryPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.common.service.axis.PolicyWeChatQuerySoap11BindingStub _stub = new cn.com.sinosoft.common.service.axis.PolicyWeChatQuerySoap11BindingStub(new java.net.URL(PolicyWeChatQueryHttpSoap11Endpoint_address), this);
                _stub.setPortName(getPolicyWeChatQueryHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
            if (cn.com.sinosoft.common.service.axis.PolicyWeChatQueryPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.common.service.axis.PolicyWeChatQuerySoap12BindingStub _stub = new cn.com.sinosoft.common.service.axis.PolicyWeChatQuerySoap12BindingStub(new java.net.URL(PolicyWeChatQueryHttpSoap12Endpoint_address), this);
                _stub.setPortName(getPolicyWeChatQueryHttpSoap12EndpointWSDDServiceName());
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
        if ("PolicyWeChatQueryHttpSoap11Endpoint".equals(inputPortName)) {
            return getPolicyWeChatQueryHttpSoap11Endpoint();
        }
        else if ("PolicyWeChatQueryHttpSoap12Endpoint".equals(inputPortName)) {
            return getPolicyWeChatQueryHttpSoap12Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.sinosoft.com", "PolicyWeChatQuery");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "PolicyWeChatQueryHttpSoap11Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "PolicyWeChatQueryHttpSoap12Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PolicyWeChatQueryHttpSoap11Endpoint".equals(portName)) {
            setPolicyWeChatQueryHttpSoap11EndpointEndpointAddress(address);
        }
        else
if ("PolicyWeChatQueryHttpSoap12Endpoint".equals(portName)) {
            setPolicyWeChatQueryHttpSoap12EndpointEndpointAddress(address);
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
