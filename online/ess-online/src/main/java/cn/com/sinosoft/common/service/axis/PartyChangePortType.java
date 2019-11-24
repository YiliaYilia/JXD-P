/**
 * PartyChangePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2 May 03, 2005 (02:20:24 EDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public interface PartyChangePortType extends java.rmi.Remote {
    public cn.com.sinosoft.common.service.axis.PartyChangeReturnModel getPartyChangeDetail(cn.com.sinosoft.common.service.axis.PartyChangeModel pcm) throws java.rmi.RemoteException;

	public CRSInterfaceModel dealPartyTaxType(String partyCode, String taxType,String operate, String callBy,String country) throws java.rmi.RemoteException;
}
