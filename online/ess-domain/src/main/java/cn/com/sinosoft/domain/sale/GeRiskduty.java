package cn.com.sinosoft.domain.sale;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * GeRiskduty entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_riskduty")
public class GeRiskduty implements java.io.Serializable {

	// Fields

	private String riskdutyno; // 险种责任编号
	private String riskcode; // 险种代码
	private String dutycode; // 责任编码
	private String dutydesc; // 责任描述
	private String amount; // 责任保额(分)
	private String premium; // 责任保费(分)
	private String amountdesc; // 责任保额描述

	private String mainRiskCode; // 主险代码
	private String tranRiskCode; // 险种编码
	private String riskName; // 险种名称
	private Date polApplyDate; // 投保日期
	private Date signDate; // 承保日期
	private Date cvaliDate; // 起保日期
	private Date insuEndDate; // 保险责任终止日期

	private String mult; // 投保份数
	private String payIntv; // 缴费频次
	private String payMode; // 缴费形式
	private String insuYearFlag; // 保险年龄年期标志
	private String insuYear; // 保险年龄年期
	private String payEndYearFlag; // 缴费年期类型
	private String payEndYear; // 缴费年期年龄

	private GePolicy policy;

	// Constructors

	/** default constructor */
	public GeRiskduty() {
	}

	/** minimal constructor */
	public GeRiskduty(String riskdutyno) {
		this.riskdutyno = riskdutyno;
	}

	/** full constructor */
	public GeRiskduty(String riskdutyno, String riskcode, String dutycode, String dutydesc, String amount, String premium, String amountdesc, String mainRiskCode, String tranRiskCode, String riskName, Date polApplyDate, Date signDate, Date cvaliDate, Date insuEndDate, String mult, String payIntv, String payMode, String insuYearFlag, String insuYear, String payEndYearFlag, String payEndYear) {
		this.riskdutyno = riskdutyno;
		this.riskcode = riskcode;
		this.dutycode = dutycode;
		this.dutydesc = dutydesc;
		this.amount = amount;
		this.premium = premium;
		this.amountdesc = amountdesc;
		this.mainRiskCode = mainRiskCode;
		this.tranRiskCode = tranRiskCode;
		this.riskName = riskName;
		this.polApplyDate = polApplyDate;
		this.signDate = signDate;
		this.cvaliDate = cvaliDate;
		this.insuEndDate = insuEndDate;
		this.mult = mult;
		this.payIntv = payIntv;
		this.payMode = payMode;
		this.insuYearFlag = insuYearFlag;
		this.insuYear = insuYear;
		this.payEndYearFlag = payEndYearFlag;
		this.payEndYear = payEndYear;

	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "RISKDUTYNO", nullable = false)
	public String getRiskdutyno() {
		return this.riskdutyno;
	}

	@ManyToOne
	@JoinColumn(name = "POLICYNO")
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	public GePolicy getPolicy() {
		return policy;
	}

	public void setPolicy(GePolicy policy) {
		this.policy = policy;
	}

	public void setRiskdutyno(String riskdutyno) {
		this.riskdutyno = riskdutyno;
	}

	@Column(name = "RISKCODE", length = 50)
	public String getRiskcode() {
		return this.riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode;
	}

	@Column(name = "DUTYCODE", length = 50)
	public String getDutycode() {
		return this.dutycode;
	}

	public void setDutycode(String dutycode) {
		this.dutycode = dutycode;
	}

	@Column(name = "DUTYDESC")
	public String getDutydesc() {
		return this.dutydesc;
	}

	public void setDutydesc(String dutydesc) {
		this.dutydesc = dutydesc;
	}

	@Column(name = "AMOUNT", length = 50)
	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Column(name = "PREMIUM", length = 50)
	public String getPremium() {
		return this.premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	@Column(name = "AMOUNTDESC")
	public String getAmountdesc() {
		return this.amountdesc;
	}

	public void setAmountdesc(String amountdesc) {
		this.amountdesc = amountdesc;
	}

	@Column(name = "MAINRISKCODE")
	public String getMainRiskCode() {
		return mainRiskCode;
	}

	public void setMainRiskCode(String mainRiskCode) {
		this.mainRiskCode = mainRiskCode;
	}

	@Column(name = "TRANRISKCODE")
	public String getTranRiskCode() {
		return tranRiskCode;
	}

	public void setTranRiskCode(String tranRiskCode) {
		this.tranRiskCode = tranRiskCode;
	}

	@Column(name = "RISKNAME")
	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	@Column(name = "POLAPPLYDATE")
	public Date getPolApplyDate() {
		return polApplyDate;
	}

	public void setPolApplyDate(Date polApplyDate) {
		this.polApplyDate = polApplyDate;
	}

	@Column(name = "SIGNDATE")
	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	@Column(name = "CVALIDATE")
	public Date getCvaliDate() {
		return cvaliDate;
	}

	public void setCvaliDate(Date cvaliDate) {
		this.cvaliDate = cvaliDate;
	}

	@Column(name = "INSUENDDATE")
	public Date getInsuEndDate() {
		return insuEndDate;
	}

	public void setInsuEndDate(Date insuEndDate) {
		this.insuEndDate = insuEndDate;
	}

	@Column(name = "MULT")
	public String getMult() {
		return mult;
	}

	public void setMult(String mult) {
		this.mult = mult;
	}

	@Column(name = "PAYINTV")
	public String getPayIntv() {
		return payIntv;
	}

	public void setPayIntv(String payIntv) {
		this.payIntv = payIntv;
	}

	@Column(name = "PAYMODE")
	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	@Column(name = "INSUYEARFLAG")
	public String getInsuYearFlag() {
		return insuYearFlag;
	}

	public void setInsuYearFlag(String insuYearFlag) {
		this.insuYearFlag = insuYearFlag;
	}

	@Column(name = "INSUYEAR")
	public String getInsuYear() {
		return insuYear;
	}

	public void setInsuYear(String insuYear) {
		this.insuYear = insuYear;
	}

	@Column(name = "PAYENDYEARFLAG")
	public String getPayEndYearFlag() {
		return payEndYearFlag;
	}

	public void setPayEndYearFlag(String payEndYearFlag) {
		this.payEndYearFlag = payEndYearFlag;
	}

	@Column(name = "PAYENDYEAR")
	public String getPayEndYear() {
		return payEndYear;
	}

	public void setPayEndYear(String payEndYear) {
		this.payEndYear = payEndYear;
	}
}