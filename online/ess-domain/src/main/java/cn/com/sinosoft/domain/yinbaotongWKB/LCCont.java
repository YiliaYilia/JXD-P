package cn.com.sinosoft.domain.yinbaotongWKB;
/**
 * 保单信息
 * @author lwy
 */
public class LCCont {
	private String ContNo;//保单号
	private String ProposalContNo;//投保书号，可与流水号相同
	private String PolApplyDate;//投保日期，当日即可
	private String AccName;//账户姓名，可以与投保人一致，报文例子中为：开心保包
	private String AccBankCode;//银行编码
	private String BankAccNo;//银行账户
	private String PayIntv;//缴费间隔
	private String PayMode;
	private String SumPrem;
	private String EffDate;
	private String ExPayMode;
	private String GetPolMode;
	private String SpecContent;
	private String PrtNo;
	private String TempFeeNo;
	private String AgentCode;
	private String AgentGroup;
	private String AgentName;
	private String CurrencyTypeCode;
	private String CashEXF;
	private String InvestDateInd;
	private String PremOffsetMethod;
	private String RenewalPermit;//续保标记
	private String cValiDate;
	private String Prem;
	private String BillingType; //支付方式（微信支付还是银行代收）
	private String BankBranchName;//银行分行的名称
	private String BankProvince; //开户行省
	private String BankCity;//开户行市
	
	private LCAppnt lCAppnt;//投保人信息 
	private LCInsureds lCInsureds;//被保人及受益人
	
	//银行代扣增加字段
	
	public LCCont() {
		super();
	}
	public LCCont(String ContNo, String proposalContNo, String polApplyDate,
			String accName, String accBankCode, String bankAccNo,
			String payIntv, String payMode, String sumPrem, String effDate,
			String exPayMode, String getPolMode, String specContent,
			String prtNo, String tempFeeNo, String agentCode,
			String agentGroup, String agentName, String currencyTypeCode,
			String cashEXF, String investDateInd, String premOffsetMethod,
			String renewalPermit,String billingType,String bankBranchName,
			String bankProvince,String bankCity,
			LCAppnt lCAppnt,LCInsureds lCInsureds) {
		super();
		this.ContNo = ContNo;
		ProposalContNo = proposalContNo;
		PolApplyDate = polApplyDate;
		AccName = accName;
		AccBankCode = accBankCode;
		BankAccNo = bankAccNo;
		PayIntv = payIntv;
		PayMode = payMode;
		SumPrem = sumPrem;
		EffDate = effDate;
		ExPayMode = exPayMode;
		GetPolMode = getPolMode;
		SpecContent = specContent;
		PrtNo = prtNo;
		TempFeeNo = tempFeeNo;
		AgentCode = agentCode;
		AgentGroup = agentGroup;
		AgentName = agentName;
		CurrencyTypeCode = currencyTypeCode;
		CashEXF = cashEXF;
		InvestDateInd = investDateInd;
		PremOffsetMethod = premOffsetMethod;
		RenewalPermit = renewalPermit;
		BillingType = billingType;
		BankBranchName = bankBranchName;
		BankProvince = bankProvince;
		BankCity = bankCity;
		this.lCAppnt = lCAppnt;
		this.lCInsureds = lCInsureds;
	}
	public String getContNo() {
		return ContNo;
	}
	public void setContNo(String ContNo) {
		this.ContNo = ContNo;
	}
	public String getProposalContNo() {
		return ProposalContNo;
	}
	public void setProposalContNo(String proposalContNo) {
		ProposalContNo = proposalContNo;
	}
	public String getPolApplyDate() {
		return PolApplyDate;
	}
	public void setPolApplyDate(String polApplyDate) {
		PolApplyDate = polApplyDate;
	}
	public String getAccName() {
		return AccName;
	}
	public void setAccName(String accName) {
		AccName = accName;
	}
	public String getAccBankCode() {
		return AccBankCode;
	}
	public void setAccBankCode(String accBankCode) {
		AccBankCode = accBankCode;
	}
	public String getBankAccNo() {
		return BankAccNo;
	}
	public void setBankAccNo(String bankAccNo) {
		BankAccNo = bankAccNo;
	}
	public String getPayIntv() {
		return PayIntv;
	}
	public void setPayIntv(String payIntv) {
		PayIntv = payIntv;
	}
	public String getPayMode() {
		return PayMode;
	}
	public void setPayMode(String payMode) {
		PayMode = payMode;
	}
	public String getSumPrem() {
		return SumPrem;
	}
	public void setSumPrem(String sumPrem) {
		SumPrem = sumPrem;
	}
	public String getEffDate() {
		return EffDate;
	}
	public void setEffDate(String effDate) {
		EffDate = effDate;
	}
	public String getExPayMode() {
		return ExPayMode;
	}
	public void setExPayMode(String exPayMode) {
		ExPayMode = exPayMode;
	}
	public String getGetPolMode() {
		return GetPolMode;
	}
	public void setGetPolMode(String getPolMode) {
		GetPolMode = getPolMode;
	}
	public String getSpecContent() {
		return SpecContent;
	}
	public void setSpecContent(String specContent) {
		SpecContent = specContent;
	}
	public String getPrtNo() {
		return PrtNo;
	}
	public void setPrtNo(String prtNo) {
		PrtNo = prtNo;
	}
	public String getTempFeeNo() {
		return TempFeeNo;
	}
	public void setTempFeeNo(String tempFeeNo) {
		TempFeeNo = tempFeeNo;
	}
	public String getAgentCode() {
		return AgentCode;
	}
	public void setAgentCode(String agentCode) {
		AgentCode = agentCode;
	}
	public String getAgentGroup() {
		return AgentGroup;
	}
	public void setAgentGroup(String agentGroup) {
		AgentGroup = agentGroup;
	}
	public String getAgentName() {
		return AgentName;
	}
	public void setAgentName(String agentName) {
		AgentName = agentName;
	}
	public String getCurrencyTypeCode() {
		return CurrencyTypeCode;
	}
	public void setCurrencyTypeCode(String currencyTypeCode) {
		CurrencyTypeCode = currencyTypeCode;
	}
	public String getCashEXF() {
		return CashEXF;
	}
	public void setCashEXF(String cashEXF) {
		CashEXF = cashEXF;
	}
	public String getInvestDateInd() {
		return InvestDateInd;
	}
	public void setInvestDateInd(String investDateInd) {
		InvestDateInd = investDateInd;
	}
	public String getPremOffsetMethod() {
		return PremOffsetMethod;
	}
	public void setPremOffsetMethod(String premOffsetMethod) {
		PremOffsetMethod = premOffsetMethod;
	}
	public String getRenewalPermit() {
		return RenewalPermit;
	}
	public void setRenewalPermit(String renewalPermit) {
		RenewalPermit = renewalPermit;
	}
	public LCAppnt getlCAppnt() {
		return lCAppnt;
	}
	public void setlCAppnt(LCAppnt lCAppnt) {
		this.lCAppnt = lCAppnt;
	}
	public LCInsureds getlCInsureds() {
		return lCInsureds;
	}
	public void setlCInsureds(LCInsureds lCInsureds) {
		this.lCInsureds = lCInsureds;
	}
	public String getcValiDate() {
		return cValiDate;
	}
	public void setcValiDate(String cValiDate) {
		this.cValiDate = cValiDate;
	}
	public String getPrem() {
		return Prem;
	}
	public void setPrem(String prem) {
		Prem = prem;
	}
	
	public String getBillingType() {
		return BillingType;
	}
	public void setBillingType(String billingType) {
		BillingType = billingType;
	}
	public String getBankBranchName() {
		return BankBranchName;
	}
	public void setBankBranchName(String bankBranchName) {
		BankBranchName = bankBranchName;
	}
	public String getBankProvince() {
		return BankProvince;
	}
	public void setBankProvince(String bankProvince) {
		BankProvince = bankProvince;
	}
	public String getBankCity() {
		return BankCity;
	}
	public void setBankCity(String bankCity) {
		BankCity = bankCity;
	}
	
	
	
	
	
}
