/**
 * PolicyWeChatQueryPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public interface PolicyWeChatQueryPortType extends java.rmi.Remote {
    public cn.com.sinosoft.common.service.axis.PartyChangeModel getPartyInfo(java.lang.String partyCode) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.WeChatQueryModel getWeChatQuery(java.lang.String polCoverNoteNum) throws java.rmi.RemoteException;
}
