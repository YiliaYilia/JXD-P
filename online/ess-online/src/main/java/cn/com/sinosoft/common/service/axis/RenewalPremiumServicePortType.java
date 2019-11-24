/**
 * RenewalPremiumServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public interface RenewalPremiumServicePortType extends java.rmi.Remote {
    public BasicOutputModel doPremiumPayTerminate(String operator, String systemCode, String policyCode, String paymentReferenceNo, String dueDate) throws java.rmi.RemoteException;
    public BasicOutputModel getPremiumDueDetail(String operator, String systemCode, String policyCode, String paymentReferenceNo, String dueDate) throws java.rmi.RemoteException;
    public BasicOutputModel doPremiumPayInitiate(String operator, String systemCode, String policyCode, String paymentReferenceNo, String dueDate) throws java.rmi.RemoteException;
    public BasicOutputModel getPremiumPayDetail(String operator, String systemCode, String policyCode, String paymentReferenceNo, String dueDate) throws java.rmi.RemoteException;
    public BasicOutputModel getInActivePolicyDetail(String operator, String systemCode, String policyCode) throws java.rmi.RemoteException;
    public BasicOutputModel doPremiumPayCheck(String operator, String systemCode, String policyCode, String paymentReferenceNo, String dueDate) throws java.rmi.RemoteException;
    public BasicOutputModel getRenewalPremiumList(String operator, String systemCode, String payStatus, String startDate, String endDate, String agentCode, String policyCode, String applicantName) throws java.rmi.RemoteException;
    public BasicOutputModel doPremiumPay(String operator, String systemCode, String policyCode, String paymentReferenceNo, String dueDate, String payDate, String payAmount, String bankBranchCode, String bankAccountNumber, String online_pay_code) throws java.rmi.RemoteException;
    public BasicOutputModel getInActivePolicyList(String operator, String systemCode, String startDate, String endDate, String agentCode, String policyCode, String applicantName) throws java.rmi.RemoteException;
}
