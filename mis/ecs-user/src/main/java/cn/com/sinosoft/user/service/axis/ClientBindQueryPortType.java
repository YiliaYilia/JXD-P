/**
 * ClientBindQueryPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.user.service.axis;

public interface ClientBindQueryPortType extends java.rmi.Remote {
    public cn.com.sinosoft.user.service.axis.ClientBindModel getClientBindDetail(String idType, String idNo, String clientName) throws java.rmi.RemoteException;
}
