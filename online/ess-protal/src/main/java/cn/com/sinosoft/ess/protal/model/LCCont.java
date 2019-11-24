package cn.com.sinosoft.ess.protal.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;


/**
 * 描述：保单信息<br>
 * 作者：wanhonghui <br>
 * 修改日期：2013年8月15日上午11:13:00 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 */
//@XmlType(name="Body")
public class LCCont {
	/**保单号 非空*/
	private String proposalContNo;
	/**投保日期 非空*/
	private String polApplyDate;
	/**账户名称 默认为空*/
	private String accName;
	/**缴费卡开户行 默认为空*/
	private String accBankCode;
	/**交费账号 默认为空*/
	private String bankAccNo;
	/**保单递送方式 默认为空*/
	private String getPolMode;
	/**投递地址选项 默认为空*/
	private String deliveryAddrType;
	/**保单密码 默认为空*/
	private String password;
	/**印刷号 默认为空*/
	private String prtNo;
	/**发票印刷号码 默认为空*/
	private String tempFeeNo;
	/**代理人编码 默认为空*/
	private String agentCode;
	/**代理人姓名 默认为空*/
	private String agentName;
	/**代理人组别 默认为空 */
	private String agentType;
	/**预留  默认为空*/
	private String agentGroup;
	/**销售人员编码 默认为空 */
	private String bankSeller;
	/**销售人员姓名 默认为空*/
	private String sellerName;
	/**销售人员组别 默认为空*/
	private String sellerType;
	/**短信服务 默认为空*/
	private String msgService;
	/**客户回访类型 默认为空*/
	private String customerFollowupMethod;
	/**首付投资时间选择 默认为空*/
	private String investDateFlag;
	/**定投金额 默认为空*/
	private String regularInvAmt;
	/**定投缴别 默认为空*/
	private String regularInvRank;
	/**投保人风险等级 默认为空*/
	private String appRiskRank;
	/**被保人(未成年)在其他公司个人累计寿险保额 默认为空*/
	private String insCovSumAmt;
	/**投保人信息*/
	private LCAppnt LCAppnt;
	/**被保人信息*/
	@NodeNumber(isShowNumber=true,nodeName="LCInsuredCount")
	private List<LCInsured> LCInsureds;
	/**受益人信息*/
	@NodeNumber(isShowNumber=true,nodeName="LCBnfCount")
	private List<LCBnf> LCBnfs;
	
	@XmlElement(name="ProposalPrtNo")
	public String getProposalContNo() {
		return proposalContNo;
	}
	public void setProposalContNo(String proposalContNo) {
		this.proposalContNo = proposalContNo;
	}
	@XmlElement(name="PolApplyDate")
	public String getPolApplyDate() {
		return polApplyDate;
	}
	public void setPolApplyDate(String polApplyDate) {
		this.polApplyDate = polApplyDate;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getAccBankCode() {
		return accBankCode;
	}
	public void setAccBankCode(String accBankCode) {
		this.accBankCode = accBankCode;
	}
	public String getBankAccNo() {
		return bankAccNo;
	}
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}
	public String getGetPolMode() {
		return getPolMode;
	}
	public void setGetPolMode(String getPolMode) {
		this.getPolMode = getPolMode;
	}
	public String getDeliveryAddrType() {
		return deliveryAddrType;
	}
	public void setDeliveryAddrType(String deliveryAddrType) {
		this.deliveryAddrType = deliveryAddrType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPrtNo() {
		return prtNo;
	}
	public void setPrtNo(String prtNo) {
		this.prtNo = prtNo;
	}
	public String getTempFeeNo() {
		return tempFeeNo;
	}
	public void setTempFeeNo(String tempFeeNo) {
		this.tempFeeNo = tempFeeNo;
	}
	public String getAgentCode() {
		return agentCode;
	}
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAgentType() {
		return agentType;
	}
	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}
	public String getAgentGroup() {
		return agentGroup;
	}
	public void setAgentGroup(String agentGroup) {
		this.agentGroup = agentGroup;
	}
	public String getBankSeller() {
		return bankSeller;
	}
	public void setBankSeller(String bankSeller) {
		this.bankSeller = bankSeller;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerType() {
		return sellerType;
	}
	public void setSellerType(String sellerType) {
		this.sellerType = sellerType;
	}
	public String getMsgService() {
		return msgService;
	}
	public void setMsgService(String msgService) {
		this.msgService = msgService;
	}
	public String getCustomerFollowupMethod() {
		return customerFollowupMethod;
	}
	public void setCustomerFollowupMethod(String customerFollowupMethod) {
		this.customerFollowupMethod = customerFollowupMethod;
	}
	public String getInvestDateFlag() {
		return investDateFlag;
	}
	public void setInvestDateFlag(String investDateFlag) {
		this.investDateFlag = investDateFlag;
	}
	public String getRegularInvAmt() {
		return regularInvAmt;
	}
	public void setRegularInvAmt(String regularInvAmt) {
		this.regularInvAmt = regularInvAmt;
	}
	public String getRegularInvRank() {
		return regularInvRank;
	}
	public void setRegularInvRank(String regularInvRank) {
		this.regularInvRank = regularInvRank;
	}
	public String getAppRiskRank() {
		return appRiskRank;
	}
	public void setAppRiskRank(String appRiskRank) {
		this.appRiskRank = appRiskRank;
	}
	public String getInsCovSumAmt() {
		return insCovSumAmt;
	}
	public void setInsCovSumAmt(String insCovSumAmt) {
		this.insCovSumAmt = insCovSumAmt;
	}
	@XmlElement(name="Appnt")
	public LCAppnt getLCAppnt() {
		return LCAppnt;
	}
	public void setLCAppnt(LCAppnt lCAppnt) {
		LCAppnt = lCAppnt;
	}
	@XmlElementWrapper(name = "LCInsureds") 
    @XmlElement(name = "Insured") 
	public List<LCInsured> getLCInsureds() {
		return LCInsureds;
	}
	public void setLCInsureds(List<LCInsured> lCInsureds) {
		LCInsureds = lCInsureds;
	}
	//@XmlElementWrapper(name = "LCBnfs") 
    @XmlElement(name = "Bnf") 
	public List<LCBnf> getLCBnfs() {
		return LCBnfs;
	}
	public void setLCBnfs(List<LCBnf> lCBnfs) {
		LCBnfs = lCBnfs;
	}

	
	
}
