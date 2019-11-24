/**
 * PolListQueryInterfacePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public interface PolListQueryInterfacePortType extends java.rmi.Remote {
    public cn.com.sinosoft.common.service.axis.PolicyInformation getPolicyDetailByPatryCode(java.lang.String partyCode, java.lang.String roleCode) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.PolicyInformation getPolicyDetail(java.lang.String name, java.lang.String cardType, java.lang.String cardNum) throws java.rmi.RemoteException;
}
