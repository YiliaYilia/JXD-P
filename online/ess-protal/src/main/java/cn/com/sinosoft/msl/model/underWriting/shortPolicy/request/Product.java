package cn.com.sinosoft.msl.model.underWriting.shortPolicy.request;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Product {
	private String autoRenewInd;//
	private String billingAmt;//缴纳金额（精度9.2）值与投保保费（premium）一致
	private String code;//产品代码
	private Date effDate;//保单生效日期  与乘坐交通工具出发日期一致，不晚于投保日期
	private String illustration;//
	private String intro;//
	private String name;//产品名称
	private int period;//保险期间 与主险相同
	private String periodUnit;//保险期间类型 与主险相同
	private List<Policy> policyList;//险种
	private String premTerm;//缴费期间 固定值0 趸交
	private String premType;//缴费频率 固定值0 趸交
	private double premium;//投保保费（各险种保费之和）
	private double sumins;//保额
	private String type;//
	public String getAutoRenewInd() {
		return autoRenewInd;
	}
	public void setAutoRenewInd(String autoRenewInd) {
		this.autoRenewInd = autoRenewInd;
	}
	public String getBillingAmt() {
		return billingAmt;
	}
	public void setBillingAmt(String billingAmt) {
		this.billingAmt = billingAmt;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getEffDate() {
		return effDate;
	}
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}
	public String getIllustration() {
		return illustration;
	}
	public void setIllustration(String illustration) {
		this.illustration = illustration;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getPeriodUnit() {
		return periodUnit;
	}
	public void setPeriodUnit(String periodUnit) {
		this.periodUnit = periodUnit;
	}
    @XmlElement(name = "policy")
	public List<Policy> getPolicyList() {
		return policyList;
	}
	public void setPolicy(List<Policy> policyList) {
		this.policyList = policyList;
	}
	public String getPremTerm() {
		return premTerm;
	}
	public void setPremTerm(String premTerm) {
		this.premTerm = premTerm;
	}
	public String getPremType() {
		return premType;
	}
	public void setPremType(String premType) {
		this.premType = premType;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	public double getSumins() {
		return sumins;
	}
	public void setSumins(double sumins) {
		this.sumins = sumins;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Product(String autoRenewInd, String billingAmt, String code,
			Date effDate,int period, List<Policy> policyList, String periodUnit, 
			String premType, double premium, double sumins) {
		super();
		this.autoRenewInd = autoRenewInd;
		this.billingAmt = billingAmt;
		this.code = code;
		this.effDate = effDate;
		this.period = period;
		this.periodUnit = periodUnit;
		this.policyList = policyList;
		this.premType = premType;
		this.premium = premium;
		this.sumins = sumins;
	}
	
	public Product(){
		super();
	}
}
