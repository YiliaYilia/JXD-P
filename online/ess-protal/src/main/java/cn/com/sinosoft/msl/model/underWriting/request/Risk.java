package cn.com.sinosoft.msl.model.underWriting.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"riskCode","mainRiskCode","prem","mult","amnt","payIntv","insuYearFlag","insuYear","payEndYearFlag","payEndYear"})
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Risk {
	/*险种代码*/
	private String riskCode="";
	/*主险险种代码*/
	private String mainRiskCode="";
	/*保险费(分)*/
	private String prem="";
	/*投保份数，默认1份*/
	private String mult="";
	/*保额(分)*/
	private String amnt="";
	/*缴费频次*/
	private String payIntv="";
	/*保险年期年龄标志*/
	private String insuYearFlag="";
	/*保险年期年龄*/
	private String insuYear="";
	/*缴费年期年龄标志*/
	private String payEndYearFlag="";
	/*缴费年期年龄*/
	private String payEndYear="";
	
	@XmlElement(name="RiskCode")
	public String getRiskCode() {
		return riskCode;
	}
	
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	@XmlElement(name="MainRiskCode")
	public String getMainRiskCode() {
		return mainRiskCode;
	}
	public void setMainRiskCode(String mainRiskCode) {
		this.mainRiskCode = mainRiskCode;
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
	@XmlElement(name="Amnt")
	public String getAmnt() {
		return amnt;
	}
	public void setAmnt(String amnt) {
		this.amnt = amnt;
	}
	@XmlElement(name="PayIntv")
	public String getPayIntv() {
		return payIntv;
	}
	public void setPayIntv(String payIntv) {
		this.payIntv = payIntv;
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
