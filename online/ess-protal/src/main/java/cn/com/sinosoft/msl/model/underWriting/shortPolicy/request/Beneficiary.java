package cn.com.sinosoft.msl.model.underWriting.shortPolicy.request;

import java.util.Date;

public class Beneficiary {
	private String customerno;
	private String name;
	private String idNo;
	private String idType;
	private String indx;
	private Date birthday;
	private String fraction;
	private String gender;
	private String grade;
	private String relationWithInsured;
	private String type;
	
	public String getCustomerno() {
		return customerno;
	}
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIndx() {
		return indx;
	}
	public void setIndx(String indx) {
		this.indx = indx;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getFraction() {
		return fraction;
	}
	public void setFraction(String fraction) {
		this.fraction = fraction;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getRelationWithInsured() {
		return relationWithInsured;
	}
	public void setRelationWithInsured(String relationWithInsured) {
		this.relationWithInsured = relationWithInsured;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Beneficiary(Date birthday, String customerno, String fraction,
			String gender, String grade, String idNo, String idType,
			String indx, String name, String relationWithInsured, String type) {
		super();
		this.birthday = birthday;
		this.customerno = customerno;
		this.fraction = fraction;
		this.gender = gender;
		this.grade = grade;
		this.idNo = idNo;
		this.idType = idType;
		this.indx = indx;
		this.name = name;
		this.relationWithInsured = relationWithInsured;
		this.type = type;
	}
	
	public Beneficiary(){
		super();
	}
}
