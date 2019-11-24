package cn.com.sinosoft.ess.protal.model.insure.base;

import javax.xml.bind.annotation.XmlElement;


/**
 * 描述：险种<br>
 * 作者：GHY <br>
 * 修改日期：2014-3-12下午02:06:34 <br>
 * E-mail: gaohongyang13607@sinosoft.com.cn <br>
 */
public class RiskTbl {
	private String riskCode;			//险种代码
	private String riskName;			//险种名称
	private String mainRiskCode;		//主险代码
	private String tranRiskCode;		//险种编码
	private String polApplyDate;		//投保日期
	private String signDate;			//承保日期
	private String cvaliDate;			//起保日期
	private String insuEndDate;			//保险责任终止日期
	private String amnt;				//保额(分)
	private String prem;				//保险费(分)
	private String mult;				//投保份数
	private String payIntv;				//缴费频次
	private String payMode;				//缴费形式
	private String insuYearFlag;		//保险年龄年期标志
	private String insuYear;			//保险年龄年期
	private String payEndYearFlag;		//缴费年期类型
	private String payEndYear;			//缴费年期年龄
	
	@XmlElement(name="RiskCode")
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	
	@XmlElement(name="RiskName")
	public String getRiskName() {
		return riskName;
	}
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
	
	@XmlElement(name="MainRiskCode")
	public String getMainRiskCode() {
		return mainRiskCode;
	}
	public void setMainRiskCode(String mainRiskCode) {
		this.mainRiskCode = mainRiskCode;
	}
	
	@XmlElement(name="TranRiskCode")
	public String getTranRiskCode() {
		return tranRiskCode;
	}
	public void setTranRiskCode(String tranRiskCode) {
		this.tranRiskCode = tranRiskCode;
	}
	
	@XmlElement(name="PolApplyDate")
	public String getPolApplyDate() {
		return polApplyDate;
	}
	public void setPolApplyDate(String polApplyDate) {
		this.polApplyDate = polApplyDate;
	}
	
	@XmlElement(name="SignDate")
	public String getSignDate() {
		return signDate;
	}
	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}
	
	@XmlElement(name="CValiDate")
	public String getCvaliDate() {
		return cvaliDate;
	}
	public void setCvaliDate(String cvaliDate) {
		this.cvaliDate = cvaliDate;
	}
	
	@XmlElement(name="InsuEndDate")
	public String getInsuEndDate() {
		return insuEndDate;
	}
	public void setInsuEndDate(String insuEndDate) {
		this.insuEndDate = insuEndDate;
	}
	
	@XmlElement(name="Amnt")
	public String getAmnt() {
		return amnt;
	}
	public void setAmnt(String amnt) {
		this.amnt = amnt;
	}
	
	@XmlElement(name="Prem")
	public String getPrem() {
		return prem;
	}
	public void setPrem(String prem) {
		this.prem = prem;
	}
	
	@XmlElement(name="Mult")
	public String getMult() {
		return mult;
	}
	public void setMult(String mult) {
		this.mult = mult;
	}
	
	@XmlElement(name="PayIntv")
	public String getPayIntv() {
		return payIntv;
	}
	public void setPayIntv(String payIntv) {
		this.payIntv = payIntv;
	}
	
	@XmlElement(name="PayMode")
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	
	@XmlElement(name="InsuYearFlag")
	public String getInsuYearFlag() {
		return insuYearFlag;
	}
	public void setInsuYearFlag(String insuYearFlag) {
		this.insuYearFlag = insuYearFlag;
	}
	
	@XmlElement(name="InsuYear")
	public String getInsuYear() {
		return insuYear;
	}
	public void setInsuYear(String insuYear) {
		this.insuYear = insuYear;
	}
	
	@XmlElement(name="PayEndYearFlag")
	public String getPayEndYearFlag() {
		return payEndYearFlag;
	}
	public void setPayEndYearFlag(String payEndYearFlag) {
		this.payEndYearFlag = payEndYearFlag;
	}
	
	@XmlElement(name="PayEndYear")
	public String getPayEndYear() {
		return payEndYear;
	}
	public void setPayEndYear(String payEndYear) {
		this.payEndYear = payEndYear;
	}
	
	
}
