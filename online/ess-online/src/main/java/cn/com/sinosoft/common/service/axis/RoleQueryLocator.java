/**
 * RoleQueryLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

import java.io.IOException;
import java.util.Properties;

public class RoleQueryLocator extends org.apache.axis.client.Service implements cn.com.sinosoft.common.service.axis.RoleQuery {
	private static Properties pro = new Properties();
	static{
		try {
			pro.load(ClientBindQueryLocator.class.getResourceAsStream("/config/webServiceClient.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public RoleQueryLocator() {
    }


    public RoleQueryLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RoleQueryLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RoleQueryHttpSoap11Endpoint
    private java.lang.String RoleQueryHttpSoap11Endpoint_address = pro.getProperty("RoleQueryLocatorURL_11");

    public java.lang.String getRoleQueryHttpSoap11EndpointAddress() {
        return RoleQueryHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RoleQueryHttpSoap11EndpointWSDDServiceName = "RoleQueryHttpSoap11Endpoint";

    public java.lang.String getRoleQueryHttpSoap11EndpointWSDDServiceName() {
        return RoleQueryHttpSoap11EndpointWSDDServiceName;
    }

    public void setRoleQueryHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        RoleQueryHttpSoap11EndpointWSDDServiceName = name;
    }

    public cn.com.sinosoft.common.service.axis.RoleQueryPortType getRoleQueryHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RoleQueryHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRoleQueryHttpSoap11Endpoint(endpoint);
    }

    public cn.com.sinosoft.common.service.axis.RoleQueryPortType getRoleQueryHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.common.service.axis.RoleQuerySoap11BindingStub _stub = new cn.com.sinosoft.common.service.axis.RoleQuerySoap11BindingStub(portAddress, this);
            _stub.setPortName(getRoleQueryHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRoleQueryHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        RoleQueryHttpSoap11Endpoint_address = address;
    }


    // Use to get a proxy class for RoleQueryHttpSoap12Endpoint
    private java.lang.String RoleQueryHttpSoap12Endpoint_address =  pro.getProperty("RoleQueryLocatorURL_12");

    public java.lang.String getRoleQueryHttpSoap12EndpointAddress() {
        return RoleQueryHttpSoap12Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RoleQueryHttpSoap12EndpointWSDDServiceName = "RoleQueryHttpSoap12Endpoint";

    public java.lang.String getRoleQueryHttpSoap12EndpointWSDDServiceName() {
        return RoleQueryHttpSoap12EndpointWSDDServiceName;
    }

    public void setRoleQueryHttpSoap12EndpointWSDDServiceName(java.lang.String name) {
        RoleQueryHttpSoap12EndpointWSDDServiceName = name;
    }

    public cn.com.sinosoft.common.service.axis.RoleQueryPortType getRoleQueryHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RoleQueryHttpSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRoleQueryHttpSoap12Endpoint(endpoint);
    }

    public cn.com.sinosoft.common.service.axis.RoleQueryPortType getRoleQueryHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.common.service.axis.RoleQuerySoap12BindingStub _stub = new cn.com.sinosoft.common.service.axis.RoleQuerySoap12BindingStub(portAddress, this);
            _stub.setPortName(getRoleQueryHttpSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRoleQueryHttpSoap12EndpointEndpointAddress(java.lang.String address) {
        RoleQueryHttpSoap12Endpoint_address = address;
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
            if (cn.com.sinosoft.common.service.axis.RoleQueryPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.common.service.axis.RoleQuerySoap11BindingStub _stub = new cn.com.sinosoft.common.service.axis.RoleQuerySoap11BindingStub(new java.net.URL(RoleQueryHttpSoap11Endpoint_address), this);
                _stub.setPortName(getRoleQueryHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
            if (cn.com.sinosoft.common.service.axis.RoleQueryPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.common.service.axis.RoleQuerySoap12BindingStub _stub = new cn.com.sinosoft.common.service.axis.RoleQuerySoap12BindingStub(new java.net.URL(RoleQueryHttpSoap12Endpoint_address), this);
                _stub.setPortName(getRoleQueryHttpSoap12EndpointWSDDServiceName());
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
        if ("RoleQueryHttpSoap11Endpoint".equals(inputPortName)) {
            return getRoleQueryHttpSoap11Endpoint();
        }
        else if ("RoleQueryHttpSoap12Endpoint".equals(inputPortName)) {
            return getRoleQueryHttpSoap12Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.sinosoft.com", "RoleQuery");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "RoleQueryHttpSoap11Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "RoleQueryHttpSoap12Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RoleQueryHttpSoap11Endpoint".equals(portName)) {
            setRoleQueryHttpSoap11EndpointEndpointAddress(address);
        }
        else 
if ("RoleQueryHttpSoap12Endpoint".equals(portName)) {
            setRoleQueryHttpSoap12EndpointEndpointAddress(address);
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
