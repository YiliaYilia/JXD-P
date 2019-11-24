package cn.com.sinosoft.web.service.facade;

import java.util.List;
import java.util.Map;

import cn.com.sinosoft.common.service.axis.BankMsgModifyModel;
import cn.com.sinosoft.common.service.axis.BasicOutputModel;
import cn.com.sinosoft.domain.sale.BankAccount;
import cn.com.sinosoft.domain.sale.RenewalBankData;
import cn.com.sinosoft.web.domain.RenewalPolicy;
import cn.com.sinosoft.web.domain.RenewalPolicyPaymentRecords;
import net.sf.json.JSONObject;

public interface RenewalService {
	public List<RenewalPolicy> queryRenewalPolicy(String methodName, String systemCode, String premiumMode, String applicantCode);
	public List<RenewalPolicyPaymentRecords> queryRenewalPolicyPaymentRecords(String systemCode, String payStatus, String startDate, String endDate, String policyCode);

	public List<RenewalBankData> queryBank();
	public BasicOutputModel doPaymentStatus(String operator, String systemCode, String policyCode, String paymentReferenceNo, String dueDate);

	public BasicOutputModel policyHangUp(String operator, String systemCode, String policyCode, String paymentReferenceNo, String dueDate);

	public Map<String,String> renewalPay(String operator, String systemCode, String policyCode, String paymentReferenceNo, String dueDate, String payDate, String payAmount, String bankBranchCode, String bankAccountNumber, String online_pay_code,String appntname,String bankBranchName,String bankstate);
	public String postForJson(Map<String,Object> jsonString);

	public Map<String,Object> getJsonString(String coustomerip, String paytype, String paychannel, String paymode, String paycode, double order_money, String bankaccountname, String accountcode, String bank_code, String bankname, String customerid, String tel, String reckonaccount, String backcode, String policyjson);

	public String checkResultPoll(String policycode,String payresult);
}
