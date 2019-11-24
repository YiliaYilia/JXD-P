/**
 * File Name:ContInfo.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:JCZ
 * @version:v1.0
 * Createdate:2014-3-12下午02:49:33
 */
package cn.com.sinosoft.ess.protal.model.insure;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import cn.com.sinosoft.ess.protal.model.LCAppnt;
import cn.com.sinosoft.ess.protal.model.LCBnf;
import cn.com.sinosoft.ess.protal.model.LCInsured;
import cn.com.sinosoft.ess.protal.model.NodeNumber;

/**描述：<br>
 * 作者：JCZ <br>
 * 修改日期：2014-3-12下午02:49:33 <br>
 * E-mail: jinchengze@sinosoft.com.cn <br> 
 */
public class ResContInfo {
	// 交易渠道 0：柜面 1：网销 8：自助终端 10：个人营销，11电商渠道
	private String transChnl;
	//保单号
	private String contNo;
	//交易流水号
	private String transNo;
	//投保单(印刷)号
	private String proposalPrtNo;
	//柜员号
	private String tellerNo;
	//营销人员代码
	private String bankManagerCode;
	//营销人员姓名
	private String bankManagerName;
	//
	private String agentManageCode;
	//总保费(分)
	private String prem;
	//首期追加保费(分)
	private String firstAddPrem;
	//总保费大写
	private String premText;
	//总保额，单位分
	private String amnt;
	//总保额大写
	private String amntText;
	//自动续保标志
	private String renewalPermit;
	//银行帐号
	private String bankAccNo;
	//生存金领取方式
	private String getIntv;
	//年金领取起始年龄
	private String payOutStart;
	//自动垫交标志
	private String autoPayFlag;
	//FA编码
	private String axaAgentCode;
	//代理人编码
	private String agentCode;
	//代理人姓名
	private String agentName;
	//代理人组别编码
	private String agentGrpCode;
	//代理人组别
	private String agentGrpName;
	//代理机构编码
	private String agentCom;
	//代理机构名称
	private String agentComName;
	//地区代码
	private String zoneNo;
	//网点代码
	private String nodeNo;
	//柜员资质开关
	private String tellerFlag;
	//柜员姓名
	private String tellerName;
	//承保公司编码
	private String comCode;
	//承保公司地址
	private String comLocation;
	//承保公司名称
	private String comName;
	//承保公司邮编
	private String comZipCode;
	//承保公司电话
	private String comPhone;
	//投资日期标志
	private String AccTimeFlag;
	//贷款合同号
	private String contractNo;
	//贷款账号
	private String loanAccountNo;
	//贷款产品代码
	private String loanProductCode;
	//借款金额
	private String loanAmount;
	//贷款起始日期
	private String loanStartDate;
	//贷款到期日期
	private String LoanEndDate;
	//保险合同生效日期
	private String contractEffDate;
	//保险合同到期日期
	private String contractEndDate;
	//是否大额单
	private String highPremFlag;
	//被保人健康告知号节点
	private String tellCode;
	//借款金额
	private String tellText;
	//投保人健康告知号节点
	private String appTellCode;
	//投保人健康告知具体内容
	private String appTellText;
	//投保人常规告知号节点
	private String appComFlag;
	//投保人常规告知具体内容
	private String appCom;
	//被保人常规告知号节点
	private String insuComFlag;
	//被保人常规告知具体内容
	private String insuCom;
	/**投保人信息*/
	private LCAppntReq LCAppnt;
	private List<LCInsuredReq> LCInsureds;	//被保人信息
	private List<LCBnfReq> LCBnfs;			//受益人信息
	private List<ResRisk> risks;			//险种
	
	@XmlElement(name="TransChnl")
	public String getTransChnl() {
		return transChnl;
	}
	public void setTransChnl(String transChnl) {
		this.transChnl = transChnl;
	}
	@XmlElement(name="ContNo")
	public String getContNo() {
		return contNo;
	}
	public void setContNo(String contNo) {
		this.contNo = contNo;
	}
	@XmlElement(name="TransNo")
	public String getTransNo() {
		return transNo;
	}
	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}
	@XmlElement(name="ProposalPrtNo")
	public String getProposalPrtNo() {
		return proposalPrtNo;
	}
	public void setProposalPrtNo(String proposalPrtNo) {
		this.proposalPrtNo = proposalPrtNo;
	}
	@XmlElement(name="TellerNo")
	public String getTellerNo() {
		return tellerNo;
	}
	public void setTellerNo(String tellerNo) {
		this.tellerNo = tellerNo;
	}
	@XmlElement(name="BankManagerCode")
	public String getBankManagerCode() {
		return bankManagerCode;
	}
	public void setBankManagerCode(String bankManagerCode) {
		this.bankManagerCode = bankManagerCode;
	}
	@XmlElement(name="BankManagerName")
	public String getBankManagerName() {
		return bankManagerName;
	}
	public void setBankManagerName(String bankManagerName) {
		this.bankManagerName = bankManagerName;
	}
	@XmlElement(name="AgentManageCode")
	public String getAgentManageCode() {
		return agentManageCode;
	}
	public void setAgentManageCode(String agentManageCode) {
		this.agentManageCode = agentManageCode;
	}
	@XmlElement(name="Prem")
	public String getPrem() {
		return prem;
	}
	public void setPrem(String prem) {
		this.prem = prem;
	}
	@XmlElement(name="FirstAddPrem")
	public String getFirstAddPrem() {
		return firstAddPrem;
	}
	public void setFirstAddPrem(String firstAddPrem) {
		this.firstAddPrem = firstAddPrem;
	}
	@XmlElement(name="PremText")
	public String getPremText() {
		return premText;
	}
	public void setPremText(String premText) {
		this.premText = premText;
	}
	@XmlElement(name="Amnt")
	public String getAmnt() {
		return amnt;
	}
	public void setAmnt(String amnt) {
		this.amnt = amnt;
	}
	@XmlElement(name="AmntText")
	public String getAmntText() {
		return amntText;
	}
	public void setAmntText(String amntText) {
		this.amntText = amntText;
	}
	@XmlElement(name="RenewalPermit")
	public String getRenewalPermit() {
		return renewalPermit;
	}
	public void setRenewalPermit(String renewalPermit) {
		this.renewalPermit = renewalPermit;
	}
	@XmlElement(name="BankAccNo")
	public String getBankAccNo() {
		return bankAccNo;
	}
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}
	@XmlElement(name="GetIntv")
	public String getGetIntv() {
		return getIntv;
	}
	public void setGetIntv(String getIntv) {
		this.getIntv = getIntv;
	}
	@XmlElement(name="PayOutStart")
	public String getPayOutStart() {
		return payOutStart;
	}
	public void setPayOutStart(String payOutStart) {
		this.payOutStart = payOutStart;
	}
	@XmlElement(name="AutoPayFlag")
	public String getAutoPayFlag() {
		return autoPayFlag;
	}
	public void setAutoPayFlag(String autoPayFlag) {
		this.autoPayFlag = autoPayFlag;
	}
	@XmlElement(name="AXAAgentCode")
	public String getAxaAgentCode() {
		return axaAgentCode;
	}
	public void setAxaAgentCode(String axaAgentCode) {
		this.axaAgentCode = axaAgentCode;
	}
	@XmlElement(name="AgentCode")
	public String getAgentCode() {
		return agentCode;
	}
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
	@XmlElement(name="AgentName")
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	@XmlElement(name="AgentGrpCode")
	public String getAgentGrpCode() {
		return agentGrpCode;
	}
	public void setAgentGrpCode(String agentGrpCode) {
		this.agentGrpCode = agentGrpCode;
	}
	@XmlElement(name="AgentGrpName")
	public String getAgentGrpName() {
		return agentGrpName;
	}
	public void setAgentGrpName(String agentGrpName) {
		this.agentGrpName = agentGrpName;
	}
	@XmlElement(name="AgentCom")
	public String getAgentCom() {
		return agentCom;
	}
	public void setAgentCom(String agentCom) {
		this.agentCom = agentCom;
	}
	@XmlElement(name="AgentComName")
	public String getAgentComName() {
		return agentComName;
	}
	public void setAgentComName(String agentComName) {
		this.agentComName = agentComName;
	}
	@XmlElement(name="AgentComName")
	public String getZoneNo() {
		return zoneNo;
	}
	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}
	@XmlElement(name="NodeNo")
	public String getNodeNo() {
		return nodeNo;
	}
	public void setNodeNo(String nodeNo) {
		this.nodeNo = nodeNo;
	}
	@XmlElement(name="TellerFlag")
	public String getTellerFlag() {
		return tellerFlag;
	}
	public void setTellerFlag(String tellerFlag) {
		this.tellerFlag = tellerFlag;
	}
	@XmlElement(name="TellerFlag")
	public String getTellerName() {
		return tellerName;
	}
	public void setTellerName(String tellerName) {
		this.tellerName = tellerName;
	}
	@XmlElement(name="ComCode")
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	@XmlElement(name="ComLocation")
	public String getComLocation() {
		return comLocation;
	}
	public void setComLocation(String comLocation) {
		this.comLocation = comLocation;
	}
	
	
	@XmlElement(name="ComName")
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	@XmlElement(name="ComZipCode")
	public String getComZipCode() {
		return comZipCode;
	}
	public void setComZipCode(String comZipCode) {
		this.comZipCode = comZipCode;
	}
	@XmlElement(name="ComPhone")
	public String getComPhone() {
		return comPhone;
	}
	public void setComPhone(String comPhone) {
		this.comPhone = comPhone;
	}
	@XmlElement(name="AccTimeFlag")
	public String getAccTimeFlag() {
		return AccTimeFlag;
	}
	public void setAccTimeFlag(String accTimeFlag) {
		AccTimeFlag = accTimeFlag;
	}
	@XmlElement(name="ContractNo")
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	@XmlElement(name="LoanAccountNo")
	public String getLoanAccountNo() {
		return loanAccountNo;
	}
	public void setLoanAccountNo(String loanAccountNo) {
		this.loanAccountNo = loanAccountNo;
	}
	@XmlElement(name="LoanProductCode")
	public String getLoanProductCode() {
		return loanProductCode;
	}
	public void setLoanProductCode(String loanProductCode) {
		this.loanProductCode = loanProductCode;
	}
	@XmlElement(name="LoanProductCode")
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	@XmlElement(name="LoanStartDate")
	public String getLoanStartDate() {
		return loanStartDate;
	}
	public void setLoanStartDate(String loanStartDate) {
		this.loanStartDate = loanStartDate;
	}
	@XmlElement(name="LoanEndDate")
	public String getLoanEndDate() {
		return LoanEndDate;
	}
	public void setLoanEndDate(String loanEndDate) {
		LoanEndDate = loanEndDate;
	}
	@XmlElement(name="ContractEffDate")
	public String getContractEffDate() {
		return contractEffDate;
	}
	public void setContractEffDate(String contractEffDate) {
		this.contractEffDate = contractEffDate;
	}
	@XmlElement(name="ContractEndDate")
	public String getContractEndDate() {
		return contractEndDate;
	}
	public void setContractEndDate(String contractEndDate) {
		this.contractEndDate = contractEndDate;
	}
	@XmlElement(name="HighPremFlag")
	public String getHighPremFlag() {
		return highPremFlag;
	}
	public void setHighPremFlag(String highPremFlag) {
		this.highPremFlag = highPremFlag;
	}
	@XmlElement(name="TellCode")
	public String getTellCode() {
		return tellCode;
	}
	public void setTellCode(String tellCode) {
		this.tellCode = tellCode;
	}
	@XmlElement(name="TellText")
	public String getTellText() {
		return tellText;
	}
	public void setTellText(String tellText) {
		this.tellText = tellText;
	}
	@XmlElement(name="AppTellCode")
	public String getAppTellCode() {
		return appTellCode;
	}
	public void setAppTellCode(String appTellCode) {
		this.appTellCode = appTellCode;
	}
	@XmlElement(name="AppTellText")
	public String getAppTellText() {
		return appTellText;
	}
	public void setAppTellText(String appTellText) {
		this.appTellText = appTellText;
	}
	@XmlElement(name="AppComFlag")
	public String getAppComFlag() {
		return appComFlag;
	}
	public void setAppComFlag(String appComFlag) {
		this.appComFlag = appComFlag;
	}
	@XmlElement(name="AppCom")
	public String getAppCom() {
		return appCom;
	}
	public void setAppCom(String appCom) {
		this.appCom = appCom;
	}
	@XmlElement(name="InsuComFlag")
	public String getInsuComFlag() {
		return insuComFlag;
	}
	public void setInsuComFlag(String insuComFlag) {
		this.insuComFlag = insuComFlag;
	}
	@XmlElement(name="InsuCom")
	public String getInsuCom() {
		return insuCom;
	}
	public void setInsuCom(String insuCom) {
		this.insuCom = insuCom;
	}
	@XmlElement(name="Appnt")
	public LCAppntReq getLCAppnt() {
		return LCAppnt;
	}
	public void setLCAppnt(LCAppntReq lCAppnt) {
		LCAppnt = lCAppnt;
	}
	@XmlElement(name = "Insured") 
	public List<LCInsuredReq> getLCInsureds() {
		return LCInsureds;
	}
	public void setLCInsureds(List<LCInsuredReq> lCInsureds) {
		LCInsureds = lCInsureds;
	}
	@XmlElement(name = "Bnf") 
	public List<LCBnfReq> getLCBnfs() {
		return LCBnfs;
	}
	public void setLCBnfs(List<LCBnfReq> lCBnfs) {
		LCBnfs = lCBnfs;
	}
	@XmlElement(name = "Risk")
	public List<ResRisk> getRisks() {
		return risks;
	}
	public void setRisks(List<ResRisk> risks) {
		this.risks = risks;
	}
	
}
