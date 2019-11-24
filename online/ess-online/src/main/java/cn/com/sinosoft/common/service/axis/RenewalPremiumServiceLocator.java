/**
 * RenewalPremiumServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class RenewalPremiumServiceLocator extends org.apache.axis.client.Service implements RenewalPremiumService {

    public RenewalPremiumServiceLocator() {
    }


    public RenewalPremiumServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RenewalPremiumServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RenewalPremiumServiceHttpSoap12Endpoint
    private String RenewalPremiumServiceHttpSoap12Endpoint_address = "http://10.46.70.19:8080/peri/services/RenewalPremiumService.RenewalPremiumServiceHttpSoap12Endpoint/";

    public String getRenewalPremiumServiceHttpSoap12EndpointAddress() {
        return RenewalPremiumServiceHttpSoap12Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private String RenewalPremiumServiceHttpSoap12EndpointWSDDServiceName = "RenewalPremiumServiceHttpSoap12Endpoint";

    public String getRenewalPremiumServiceHttpSoap12EndpointWSDDServiceName() {
        return RenewalPremiumServiceHttpSoap12EndpointWSDDServiceName;
    }

    public void setRenewalPremiumServiceHttpSoap12EndpointWSDDServiceName(String name) {
        RenewalPremiumServiceHttpSoap12EndpointWSDDServiceName = name;
    }

    public RenewalPremiumServicePortType getRenewalPremiumServiceHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RenewalPremiumServiceHttpSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRenewalPremiumServiceHttpSoap12Endpoint(endpoint);
    }

    public RenewalPremiumServicePortType getRenewalPremiumServiceHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            RenewalPremiumServiceSoap12BindingStub _stub = new RenewalPremiumServiceSoap12BindingStub(portAddress, this);
            _stub.setPortName(getRenewalPremiumServiceHttpSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRenewalPremiumServiceHttpSoap12EndpointEndpointAddress(String address) {
        RenewalPremiumServiceHttpSoap12Endpoint_address = address;
    }


    // Use to get a proxy class for RenewalPremiumServiceHttpSoap11Endpoint
    private String RenewalPremiumServiceHttpSoap11Endpoint_address = "http://10.46.70.19:8080/peri/services/RenewalPremiumService.RenewalPremiumServiceHttpSoap11Endpoint/";

    public String getRenewalPremiumServiceHttpSoap11EndpointAddress() {
        return RenewalPremiumServiceHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private String RenewalPremiumServiceHttpSoap11EndpointWSDDServiceName = "RenewalPremiumServiceHttpSoap11Endpoint";

    public String getRenewalPremiumServiceHttpSoap11EndpointWSDDServiceName() {
        return RenewalPremiumServiceHttpSoap11EndpointWSDDServiceName;
    }

    public void setRenewalPremiumServiceHttpSoap11EndpointWSDDServiceName(String name) {
        RenewalPremiumServiceHttpSoap11EndpointWSDDServiceName = name;
    }

    public RenewalPremiumServicePortType getRenewalPremiumServiceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RenewalPremiumServiceHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRenewalPremiumServiceHttpSoap11Endpoint(endpoint);
    }

    public RenewalPremiumServicePortType getRenewalPremiumServiceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            RenewalPremiumServiceSoap11BindingStub _stub = new RenewalPremiumServiceSoap11BindingStub(portAddress, this);
            _stub.setPortName(getRenewalPremiumServiceHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRenewalPremiumServiceHttpSoap11EndpointEndpointAddress(String address) {
        RenewalPremiumServiceHttpSoap11Endpoint_address = address;
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
            if (RenewalPremiumServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                RenewalPremiumServiceSoap12BindingStub _stub = new RenewalPremiumServiceSoap12BindingStub(new java.net.URL(RenewalPremiumServiceHttpSoap12Endpoint_address), this);
                _stub.setPortName(getRenewalPremiumServiceHttpSoap12EndpointWSDDServiceName());
                return _stub;
            }
            if (RenewalPremiumServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                RenewalPremiumServiceSoap11BindingStub _stub = new RenewalPremiumServiceSoap11BindingStub(new java.net.URL(RenewalPremiumServiceHttpSoap11Endpoint_address), this);
                _stub.setPortName(getRenewalPremiumServiceHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
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
        String inputPortName = portName.getLocalPart();
        if ("RenewalPremiumServiceHttpSoap12Endpoint".equals(inputPortName)) {
            return getRenewalPremiumServiceHttpSoap12Endpoint();
        }
        else if ("RenewalPremiumServiceHttpSoap11Endpoint".equals(inputPortName)) {
            return getRenewalPremiumServiceHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.sinosoft.com", "RenewalPremiumService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "RenewalPremiumServiceHttpSoap12Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "RenewalPremiumServiceHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("RenewalPremiumServiceHttpSoap12Endpoint".equals(portName)) {
            setRenewalPremiumServiceHttpSoap12EndpointEndpointAddress(address);
        }
        else 
if ("RenewalPremiumServiceHttpSoap11Endpoint".equals(portName)) {
            setRenewalPremiumServiceHttpSoap11EndpointEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
