package cn.com.sinosoft.msl.model.underWriting.shortPolicy.request;

import java.util.Date;
import java.util.Map;

public class Policy {
	private String code;
	private Date effDate;
	private Map<String,String> extraAttrs;
//	private String name;//主险名称
	private String period;//主险保险期间  
	private String periodUnit;//主险保险期间类型   固定值D
	private String premTerm;//主险缴费期间   固定值0，趸交
	private String premType;//主险缴费频率   固定值0，趸交
	private double premium;//主险投保保费，精度8.2
	private double sumins;//主险投保保额，精度9.2
	
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
	public Map<String, String> getExtraAttrs() {
		return extraAttrs;
	}
	public void setExtraAttrs(Map<String, String> extraAttrs) {
		this.extraAttrs = extraAttrs;
	}
/*	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}*/
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getPeriodUnit() {
		return periodUnit;
	}
	public void setPeriodUnit(String periodUnit) {
		this.periodUnit = periodUnit;
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
	
	public Policy(String code, Date effDate, Map<String, String> extraAttrs,
			String period, String periodUnit, String premTerm,
			String premType, double premium, double sumins) {
		super();
		this.code = code;
		this.effDate = effDate;
		this.extraAttrs = extraAttrs;
		this.period = period;
		this.periodUnit = periodUnit;
		this.premTerm = premTerm;
		this.premType = premType;
		this.premium = premium;
		this.sumins = sumins;
	}
	
	public Policy() {
		super();
	}
}
