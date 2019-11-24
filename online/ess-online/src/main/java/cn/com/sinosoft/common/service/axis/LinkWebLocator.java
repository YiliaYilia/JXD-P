/**
 * LinkWebLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

import java.io.IOException;
import java.util.Properties;

public class LinkWebLocator extends org.apache.axis.client.Service implements cn.com.sinosoft.common.service.axis.LinkWeb {
	private static Properties pro = new Properties();
	static{
		try {
			pro.load(ClientBindQueryLocator.class.getResourceAsStream("/config/webServiceClient.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public LinkWebLocator() {
    }


    public LinkWebLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LinkWebLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LinkWebSoap
    private java.lang.String LinkWebSoap_address = pro.getProperty("LinkWebLocatorURL");

    public java.lang.String getLinkWebSoapAddress() {
        return LinkWebSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LinkWebSoapWSDDServiceName = "LinkWebSoap";

    public java.lang.String getLinkWebSoapWSDDServiceName() {
        return LinkWebSoapWSDDServiceName;
    }

    public void setLinkWebSoapWSDDServiceName(java.lang.String name) {
        LinkWebSoapWSDDServiceName = name;
    }

    public cn.com.sinosoft.common.service.axis.LinkWebSoap_PortType getLinkWebSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LinkWebSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLinkWebSoap(endpoint);
    }

    public cn.com.sinosoft.common.service.axis.LinkWebSoap_PortType getLinkWebSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.common.service.axis.LinkWebSoap_BindingStub _stub = new cn.com.sinosoft.common.service.axis.LinkWebSoap_BindingStub(portAddress, this);
            _stub.setPortName(getLinkWebSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLinkWebSoapEndpointAddress(java.lang.String address) {
        LinkWebSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.com.sinosoft.common.service.axis.LinkWebSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.common.service.axis.LinkWebSoap_BindingStub _stub = new cn.com.sinosoft.common.service.axis.LinkWebSoap_BindingStub(new java.net.URL(LinkWebSoap_address), this);
                _stub.setPortName(getLinkWebSoapWSDDServiceName());
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
        if ("LinkWebSoap".equals(inputPortName)) {
            return getLinkWebSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("com.skandia.linkwebService", "LinkWeb");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("com.skandia.linkwebService", "LinkWebSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LinkWebSoap".equals(portName)) {
            setLinkWebSoapEndpointAddress(address);
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
