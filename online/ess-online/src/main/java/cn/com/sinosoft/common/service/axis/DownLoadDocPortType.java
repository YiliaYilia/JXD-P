/**
 * DownLoadDocPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public interface DownLoadDocPortType extends java.rmi.Remote {
    public void main(java.lang.String[] args) throws java.rmi.RemoteException;
    public byte[] getDoc(java.lang.String policyNo, java.lang.String tPrintId) throws java.rmi.RemoteException;
}
