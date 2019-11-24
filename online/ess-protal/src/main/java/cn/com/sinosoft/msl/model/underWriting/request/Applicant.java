package cn.com.sinosoft.msl.model.underWriting.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 投保人信息
 * @author lyh
 *
 */
@XmlType(propOrder={"name","sex","birthday","iDType","govtTermDate","iDNo","appntZoneNo","address","zipCode","areaCode",
"phone","extNumber","mobile","email","relaToInsured"})
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Applicant {
	
	/*姓名*/
	private String name="";
	
	/*性别 */
	private String sex="";
	
	/*出生日期(yyyyMMdd)*/
	private String birthday="";
	
	/*证件类型 */
	private String iDType="" ;
	
	/*证件有效期-*/
	private String govtTermDate="" ;
	
	/*证件号码 */
	private String iDNO="";
	
	/*居住地编码，所属省代码*/
	private String appntZoneNo="";
	
	/*地址*/
	private String address="";
	
	/*邮编*/
	private String zipCode="";
	
	/*固话区号*/
	private String areaCode="";
	
	/*固话号码*/
	private String phone="";
	
	/*固话分机号*/
	private String extNumber="";
	
	/*手机号码*/
	private String mobile="";
	
	/*电子邮件*/
	private String email="";
	
	/*与主被保人关系*/
	private String relaToInsured="";
	
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
		return iDNO;
	}
	public void setiDNo(String iDNo) {
		this.iDNO = iDNo;
	}
	@XmlElement(name="AppntZoneNo")
	public String getAppntZoneNo() {
		return appntZoneNo;
	}
	public void setAppntZoneNo(String appntZoneNo) {
		this.appntZoneNo = appntZoneNo;
	}
	@XmlElement(name="Address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@XmlElement(name="ZipCode")
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@XmlElement(name="AreaCode")
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	@XmlElement(name="Phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@XmlElement(name="ExtNumber")
	public String getExtNumber() {
		return extNumber;
	}
	public void setExtNumber(String extNumber) {
		this.extNumber = extNumber;
	}
	@XmlElement(name="Mobile")
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@XmlElement(name="Email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement(name="RelaToInsured")
	public String getRelaToInsured() {
		return relaToInsured;
	}
	public void setRelaToInsured(String relaToInsured) {
		this.relaToInsured = relaToInsured;
	}
	
	
	
}
