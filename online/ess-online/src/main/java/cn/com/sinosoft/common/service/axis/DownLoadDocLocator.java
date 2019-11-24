/**
 * DownLoadDocLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

import java.io.IOException;
import java.util.Properties;

public class DownLoadDocLocator extends org.apache.axis.client.Service implements cn.com.sinosoft.common.service.axis.DownLoadDoc {
	private static Properties pro=new Properties();
	static{
		try {
			pro.load(DownLoadDocLocator.class.getResourceAsStream("/config/webServiceClient.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    public DownLoadDocLocator() {
    }


    public DownLoadDocLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DownLoadDocLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DownLoadDocHttpSoap11Endpoint
    private java.lang.String DownLoadDocHttpSoap11Endpoint_address=pro.getProperty("DownLoadDocHttpSoap11Endpoint_address");
  
    public java.lang.String getDownLoadDocHttpSoap11EndpointAddress() {
        return DownLoadDocHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DownLoadDocHttpSoap11EndpointWSDDServiceName = "DownLoadDocHttpSoap11Endpoint";

    public java.lang.String getDownLoadDocHttpSoap11EndpointWSDDServiceName() {
        return DownLoadDocHttpSoap11EndpointWSDDServiceName;
    }

    public void setDownLoadDocHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        DownLoadDocHttpSoap11EndpointWSDDServiceName = name;
    }

    public cn.com.sinosoft.common.service.axis.DownLoadDocPortType getDownLoadDocHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DownLoadDocHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDownLoadDocHttpSoap11Endpoint(endpoint);
    }

    public cn.com.sinosoft.common.service.axis.DownLoadDocPortType getDownLoadDocHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.common.service.axis.DownLoadDocSoap11BindingStub _stub = new cn.com.sinosoft.common.service.axis.DownLoadDocSoap11BindingStub(portAddress, this);
            _stub.setPortName(getDownLoadDocHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDownLoadDocHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        DownLoadDocHttpSoap11Endpoint_address = address;
    }


    // Use to get a proxy class for DownLoadDocHttpSoap12Endpoint
    private java.lang.String DownLoadDocHttpSoap12Endpoint_address = pro.getProperty("DownLoadDocHttpSoap12Endpoint_address");

    public java.lang.String getDownLoadDocHttpSoap12EndpointAddress() {
        return DownLoadDocHttpSoap12Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DownLoadDocHttpSoap12EndpointWSDDServiceName = "DownLoadDocHttpSoap12Endpoint";

    public java.lang.String getDownLoadDocHttpSoap12EndpointWSDDServiceName() {
        return DownLoadDocHttpSoap12EndpointWSDDServiceName;
    }

    public void setDownLoadDocHttpSoap12EndpointWSDDServiceName(java.lang.String name) {
        DownLoadDocHttpSoap12EndpointWSDDServiceName = name;
    }

    public cn.com.sinosoft.common.service.axis.DownLoadDocPortType getDownLoadDocHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DownLoadDocHttpSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDownLoadDocHttpSoap12Endpoint(endpoint);
    }

    public cn.com.sinosoft.common.service.axis.DownLoadDocPortType getDownLoadDocHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.sinosoft.common.service.axis.DownLoadDocSoap12BindingStub _stub = new cn.com.sinosoft.common.service.axis.DownLoadDocSoap12BindingStub(portAddress, this);
            _stub.setPortName(getDownLoadDocHttpSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDownLoadDocHttpSoap12EndpointEndpointAddress(java.lang.String address) {
        DownLoadDocHttpSoap12Endpoint_address = address;
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
            if (cn.com.sinosoft.common.service.axis.DownLoadDocPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.common.service.axis.DownLoadDocSoap11BindingStub _stub = new cn.com.sinosoft.common.service.axis.DownLoadDocSoap11BindingStub(new java.net.URL(DownLoadDocHttpSoap11Endpoint_address), this);
                _stub.setPortName(getDownLoadDocHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
            if (cn.com.sinosoft.common.service.axis.DownLoadDocPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.sinosoft.common.service.axis.DownLoadDocSoap12BindingStub _stub = new cn.com.sinosoft.common.service.axis.DownLoadDocSoap12BindingStub(new java.net.URL(DownLoadDocHttpSoap12Endpoint_address), this);
                _stub.setPortName(getDownLoadDocHttpSoap12EndpointWSDDServiceName());
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
        if ("DownLoadDocHttpSoap11Endpoint".equals(inputPortName)) {
            return getDownLoadDocHttpSoap11Endpoint();
        }
        else if ("DownLoadDocHttpSoap12Endpoint".equals(inputPortName)) {
            return getDownLoadDocHttpSoap12Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.sinosoft.com", "DownLoadDoc");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "DownLoadDocHttpSoap11Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "DownLoadDocHttpSoap12Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DownLoadDocHttpSoap11Endpoint".equals(portName)) {
            setDownLoadDocHttpSoap11EndpointEndpointAddress(address);
        }
        else 
if ("DownLoadDocHttpSoap12Endpoint".equals(portName)) {
            setDownLoadDocHttpSoap12EndpointEndpointAddress(address);
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
