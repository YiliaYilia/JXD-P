package cn.com.sinosoft.msl.model.underWriting.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"type","grade","name","sex","birthday","iDType","govtTermDate","iDNo","lot","relaToInsured"})
public class Beneficiary {

	/*受益人类别*/
	private String type="";
	/*受益顺序*/
	private String grade="";
	/*姓名*/
	private String name="";
	/*性别*/
	private String sex="";
	/*出生日期(yyyyMMdd)*/
	private String birthday="";
	/* 证件类型*/
	private String iDType="";
	/*证件有效期*/
	private String govtTermDate="";
	/*证件号码 */
	private String iDNo="";
	/*受益比例(整数，百分比)*/
	private String lot="";
	/*与主被保人关系*/
	private String relaToInsured="";
	
	@XmlElement(name="Type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@XmlElement(name="Grade")
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@XmlElement(name="Name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(name="Sex")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@XmlElement(name="Birthday")
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@XmlElement(name="IDType")
	public String getiDType() {
		return iDType;
	}
	
	public void setiDType(String iDType) {
		this.iDType = iDType;
	}
	@XmlElement(name="GovtTermDate")
	public String getGovtTermDate() {
		return govtTermDate;
	}
	public void setGovtTermDate(String govtTermDate) {
		this.govtTermDate = govtTermDate;
	}
	@XmlElement(name="IDNo")
	public String getiDNo() {
		return iDNo;
	}
	public void setiDNo(String iDNo) {
		this.iDNo = iDNo;
	}
	@XmlElement(name="Lot")
	public String getLot() {
		return lot;
	}
	public void setLot(String lot) {
		this.lot = lot;
	}
	@XmlElement(name="RelaToInsured")
	public String getRelaToInsured() {
		return relaToInsured;
	}
	public void setRelaToInsured(String relaToInsured) {
		this.relaToInsured = relaToInsured;
	}
	
	
	
}
