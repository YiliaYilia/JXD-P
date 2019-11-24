/**
 * BankMsgModifyInterfaceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class BankMsgModifyInterfaceLocator extends org.apache.axis.client.Service implements BankMsgModifyInterface {

    public BankMsgModifyInterfaceLocator() {
    }


    public BankMsgModifyInterfaceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BankMsgModifyInterfaceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BankMsgModifyInterfaceHttpSoap12Endpoint
    private String BankMsgModifyInterfaceHttpSoap12Endpoint_address = "http://10.46.70.19:8080/peri/services/BankMsgModifyInterface.BankMsgModifyInterfaceHttpSoap12Endpoint/";

    public String getBankMsgModifyInterfaceHttpSoap12EndpointAddress() {
        return BankMsgModifyInterfaceHttpSoap12Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private String BankMsgModifyInterfaceHttpSoap12EndpointWSDDServiceName = "BankMsgModifyInterfaceHttpSoap12Endpoint";

    public String getBankMsgModifyInterfaceHttpSoap12EndpointWSDDServiceName() {
        return BankMsgModifyInterfaceHttpSoap12EndpointWSDDServiceName;
    }

    public void setBankMsgModifyInterfaceHttpSoap12EndpointWSDDServiceName(String name) {
        BankMsgModifyInterfaceHttpSoap12EndpointWSDDServiceName = name;
    }

    public BankMsgModifyInterfacePortType getBankMsgModifyInterfaceHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BankMsgModifyInterfaceHttpSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBankMsgModifyInterfaceHttpSoap12Endpoint(endpoint);
    }

    public BankMsgModifyInterfacePortType getBankMsgModifyInterfaceHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            BankMsgModifyInterfaceSoap12BindingStub _stub = new BankMsgModifyInterfaceSoap12BindingStub(portAddress, this);
            _stub.setPortName(getBankMsgModifyInterfaceHttpSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBankMsgModifyInterfaceHttpSoap12EndpointEndpointAddress(String address) {
        BankMsgModifyInterfaceHttpSoap12Endpoint_address = address;
    }


    // Use to get a proxy class for BankMsgModifyInterfaceHttpSoap11Endpoint
    private String BankMsgModifyInterfaceHttpSoap11Endpoint_address = "http://10.46.70.19:8080/peri/services/BankMsgModifyInterface.BankMsgModifyInterfaceHttpSoap11Endpoint/";

    public String getBankMsgModifyInterfaceHttpSoap11EndpointAddress() {
        return BankMsgModifyInterfaceHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private String BankMsgModifyInterfaceHttpSoap11EndpointWSDDServiceName = "BankMsgModifyInterfaceHttpSoap11Endpoint";

    public String getBankMsgModifyInterfaceHttpSoap11EndpointWSDDServiceName() {
        return BankMsgModifyInterfaceHttpSoap11EndpointWSDDServiceName;
    }

    public void setBankMsgModifyInterfaceHttpSoap11EndpointWSDDServiceName(String name) {
        BankMsgModifyInterfaceHttpSoap11EndpointWSDDServiceName = name;
    }

    public BankMsgModifyInterfacePortType getBankMsgModifyInterfaceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BankMsgModifyInterfaceHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBankMsgModifyInterfaceHttpSoap11Endpoint(endpoint);
    }

    public BankMsgModifyInterfacePortType getBankMsgModifyInterfaceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            BankMsgModifyInterfaceSoap11BindingStub _stub = new BankMsgModifyInterfaceSoap11BindingStub(portAddress, this);
            _stub.setPortName(getBankMsgModifyInterfaceHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBankMsgModifyInterfaceHttpSoap11EndpointEndpointAddress(String address) {
        BankMsgModifyInterfaceHttpSoap11Endpoint_address = address;
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
            if (BankMsgModifyInterfacePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                BankMsgModifyInterfaceSoap12BindingStub _stub = new BankMsgModifyInterfaceSoap12BindingStub(new java.net.URL(BankMsgModifyInterfaceHttpSoap12Endpoint_address), this);
                _stub.setPortName(getBankMsgModifyInterfaceHttpSoap12EndpointWSDDServiceName());
                return _stub;
            }
            if (BankMsgModifyInterfacePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                BankMsgModifyInterfaceSoap11BindingStub _stub = new BankMsgModifyInterfaceSoap11BindingStub(new java.net.URL(BankMsgModifyInterfaceHttpSoap11Endpoint_address), this);
                _stub.setPortName(getBankMsgModifyInterfaceHttpSoap11EndpointWSDDServiceName());
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
        if ("BankMsgModifyInterfaceHttpSoap12Endpoint".equals(inputPortName)) {
            return getBankMsgModifyInterfaceHttpSoap12Endpoint();
        }
        else if ("BankMsgModifyInterfaceHttpSoap11Endpoint".equals(inputPortName)) {
            return getBankMsgModifyInterfaceHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.sinosoft.com", "BankMsgModifyInterface");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "BankMsgModifyInterfaceHttpSoap12Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "BankMsgModifyInterfaceHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("BankMsgModifyInterfaceHttpSoap12Endpoint".equals(portName)) {
            setBankMsgModifyInterfaceHttpSoap12EndpointEndpointAddress(address);
        }
        else 
if ("BankMsgModifyInterfaceHttpSoap11Endpoint".equals(portName)) {
            setBankMsgModifyInterfaceHttpSoap11EndpointEndpointAddress(address);
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
