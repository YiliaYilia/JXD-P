/**
 * BankMsgModifyInterfacePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public interface BankMsgModifyInterfacePortType extends java.rmi.Remote {
    public BankMsgModifyModel modifyBankCardMsg(String polno, String bankAccountNumber, String accountHolderName, String bankBranchName) throws java.rmi.RemoteException;
    public BankMsgModifyModel modifyBankMsg(String polno, String bankAccountNumber, String accountHolderName, String bankBranchName, String bankAccountProvince, String bankAccountCity, String bankFullName) throws java.rmi.RemoteException;
}
