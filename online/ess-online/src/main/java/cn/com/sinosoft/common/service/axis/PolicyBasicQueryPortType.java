/**
 * PolicyBasicQueryPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public interface PolicyBasicQueryPortType extends java.rmi.Remote {
    public java.lang.String[] getAdditionalRisk(java.lang.String policyNum) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.BasicQuery getPolBasicQuery(java.lang.String policyNo) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.InvestmentModel[] getInvestmentInformation(java.lang.String policyNum) throws java.rmi.RemoteException;
}