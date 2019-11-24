/**
 * LinkWebSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public interface LinkWebSoap_PortType extends java.rmi.Remote {
    public cn.com.sinosoft.common.service.axis.LoginMsg login(java.lang.String clientNbr, java.lang.String password) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.ReturnMsg getsp_createNBWithOut1StPremium(java.lang.String sessionId, java.lang.String theInput) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.PolicyBaseInfoMsg getPolicyBaseInfo(java.lang.String sessionId, java.lang.String clientNbr) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.PolicyBaseInfoForDistMsg getPolicyBaseInfoForDist(java.lang.String sessionId, java.lang.String clientNbr) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.PolicyDetailMsg getPolicyDetail(java.lang.String sessionId, java.lang.String policyNbr) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.ReturnMsg revisionPinCode(java.lang.String sessionId, java.lang.String clientNbr, java.lang.String oldPass, java.lang.String newPass, java.lang.String comfirmNewPass) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.ReturnMsg saveTopUpPolicy(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String ivmtAcctType, java.lang.String topValue, cn.com.sinosoft.common.service.axis.TopupAccountVO[] acctList) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.PolicyAssessmentMsg getPolicyAssessment(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String date) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.PolicyTransactionMsg getPolicyTransactionInfo(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String startDate, java.lang.String endDate, java.lang.String lob) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.PersonalInfoMsg getPersonalInfo(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String role) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.ReturnMsg savePersonalInfo(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String role, cn.com.sinosoft.common.service.axis.PersonalInfoVO personalInfoVO) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.TopUpPolicyMsg getTopUpPolicy(java.lang.String sessionId, java.lang.String policyNbr) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.ReturnMsg saveSwitchPolicy(java.lang.String sessionId, java.lang.String policyNbr, cn.com.sinosoft.common.service.axis.SwitchAccountVO[] alSwitch) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.ReturnMsg saveAuthorizedDistributor(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String baseInfoAuthorizeYN, java.lang.String transRecordAuthorizeYN) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.ReturnMsg savePsByAccount(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String amtOrPercent, cn.com.sinosoft.common.service.axis.PSAccountVO[] surrenderValue) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.ReturnMsg savePartialSurrender(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String amtOrPercent, java.lang.String surrenderValue, java.lang.String reason) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.SurrenderDetailMsg getSurrenderPolicy(java.lang.String sessionId, java.lang.String policyNbr) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.PerformanceRep1Msg getPerformanceRep1(java.lang.String sessionId, java.lang.String productCode, java.lang.String[] alIvmtAcctID, java.lang.String startDate, java.lang.String endDate) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.ReturnMsg saveSurrenderPolicy(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String reason) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.AnnualReportMsg getAnnualReport(java.lang.String sessionId, java.lang.String clientNbr) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.DoPrintAnnualReportMsg doPrintAnnualReport(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String annulRepID) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.ProductMsg getProductList(java.lang.String sessionId, java.lang.String clientNbr) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.ProductInvestmentAccountMsg getProductInvestmentAccount(java.lang.String sessionId, java.lang.String productCode) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.PerformanceRep2Msg getPerformanceRep2(java.lang.String sessionId, java.lang.String productCode, java.lang.String ivmtAcctID, java.lang.String startDate, java.lang.String endDate) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.UnitPriceMsg getUnitPrice(java.lang.String sessionId, java.lang.String productCode) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.PolicyIssuedStatusMsg getPolicyIssuedStatus(java.lang.String sessionId, java.lang.String clientNbr) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.ClaimSettlementMsg getClaimSettlement(java.lang.String sessionId, java.lang.String clientNbr) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.ChangedPolicyMsg getChangedPolicy(java.lang.String sessionId, java.lang.String policyNbr) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.SubDistributorsListMsg getSubDistributorsList(java.lang.String sessionId, java.lang.String clientNbr) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.SubDistributorPolicyInfoMsg getSubDistributorPolicyInfo(java.lang.String sessionId, java.lang.String distributorCode) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.CommissionMsg getCommission(java.lang.String sessionId, java.lang.String clientNbr, java.lang.String startDate, java.lang.String endDate) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.CommissionMsg getCommissions(java.lang.String sessionId, java.lang.String distributorCode) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.ReturnMsg logout(java.lang.String sessionId, java.lang.String clientNbr) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.PolicyBaseInfoForFAMsg getPolicyBaseInfoForFA(java.lang.String sessionId, java.lang.String clientNbr) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.TransactionDetailMsg getPolicyTransactionDetail(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String transactionSeqNbr) throws java.rmi.RemoteException;
    public cn.com.sinosoft.common.service.axis.ProductRulesMsg getProductRules() throws java.rmi.RemoteException;
}
