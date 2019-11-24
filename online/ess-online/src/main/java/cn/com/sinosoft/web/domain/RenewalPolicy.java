package cn.com.sinosoft.web.domain;

import java.util.List;

public class RenewalPolicy {
	
	private String no;
	private String mainRiskName;
	private String policyCode;
	private String applicantName;
	private String dueDate;
	private String availablePayDay;
	private String dueAmount;
	private String billingStatus;
	private String payDate;
	private String cycleTermNo;
	private String policyStatus;
	private List<PolicyCoverInformation> policyCoverInformationList;
	
	
	
	public RenewalPolicy() {
		
	}
	
	public RenewalPolicy(String no, String mainRiskName, String policyCode,
			String applicantName, String dueDate, String availablePayDay,
			String dueAmount, String billingStatus, String payDate,
			String cycleTermNo, String policyStatus,
			List<PolicyCoverInformation> policyCoverInformationList) {
		super();
		this.no = no;
		this.mainRiskName = mainRiskName;
		this.policyCode = policyCode;
		this.applicantName = applicantName;
		this.dueDate = dueDate;
		this.availablePayDay = availablePayDay;
		this.dueAmount = dueAmount;
		this.billingStatus = billingStatus;
		this.payDate = payDate;
		this.cycleTermNo = cycleTermNo;
		this.policyStatus = policyStatus;
		this.policyCoverInformationList = policyCoverInformationList;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getMainRiskName() {
		return mainRiskName;
	}
	public void setMainRiskName(String mainRiskName) {
		this.mainRiskName = mainRiskName;
	}
	public String getPolicyCode() {
		return policyCode;
	}
	public void setPolicyCode(String policyCode) {
		this.policyCode = policyCode;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getAvailablePayDay() {
		return availablePayDay;
	}
	public void setAvailablePayDay(String availablePayDay) {
		this.availablePayDay = availablePayDay;
	}
	public String getDueAmount() {
		return dueAmount;
	}
	public void setDueAmount(String dueAmount) {
		this.dueAmount = dueAmount;
	}
	public String getBillingStatus() {
		return billingStatus;
	}
	public void setBillingStatus(String billingStatus) {
		this.billingStatus = billingStatus;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getCycleTermNo() {
		return cycleTermNo;
	}
	public void setCycleTermNo(String cycleTermNo) {
		this.cycleTermNo = cycleTermNo;
	}
	public String getPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}
	public List<PolicyCoverInformation> getPolicyCoverInformationList() {
		return policyCoverInformationList;
	}
	public void setPolicyCoverInformationList(
			List<PolicyCoverInformation> policyCoverInformationList) {
		this.policyCoverInformationList = policyCoverInformationList;
	}
	
	
	
	
	
	

}
