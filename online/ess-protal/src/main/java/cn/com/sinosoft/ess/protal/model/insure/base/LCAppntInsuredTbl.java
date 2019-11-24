package cn.com.sinosoft.ess.protal.model.insure.base;

import javax.xml.bind.annotation.XmlElement;

/**
 * 描述：投被保人<br>
 * 作者：GHY <br>
 * 修改日期：2014-3-11下午04:03:41 <br>
 * E-mail: gaohongyang13607@sinosoft.com.cn <br>
 */
public class LCAppntInsuredTbl {
	
	private String customerNo;				//客户号
	private String name;					//投保人姓名
	private String sex;						//投保人性别
	private String birthday;				//投保人出生日期
	private String identifytype ;			//投保人证件类型
	private String identifynumber ;			//投保人证件号码
	private String visaExpDate;				//件到日期 默认为空
	private String occupationcode;			//职业代码 默认为空	
	private String occupationname;			//职业类别
	private String nationality ;			//国籍 默认为空
	private String stature;					//身高(cm)
	private String weight;					//体重(g) 
	private String marriage;				//婚姻标志 默认为空   婚否(N/Y)
	private String dist;					//省
	private String city;					//市
	private String address;					//地址
	private String zipcode;					//邮寄地址邮编
	private String mobile ;					//手机
	private String homephone;				//家庭电话
	private String email;					//电子邮箱
	private String insrelationapp;			//与被保人关系 本人
	
	@XmlElement(name="CustomerNo")
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
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
	public String getIdentifytype() {
		return identifytype;
	}
	public void setIdentifytype(String identifytype) {
		this.identifytype = identifytype;
	}
	
	@XmlElement(name="IDNo")
	public String getIdentifynumber() {
		return identifynumber;
	}
	public void setIdentifynumber(String identifynumber) {
		this.identifynumber = identifynumber;
	}
	
	@XmlElement(name="GovtTermDate")
	public String getVisaExpDate() {
		return visaExpDate;
	}
	public void setVisaExpDate(String visaExpDate) {
		this.visaExpDate = visaExpDate;
	}
	
	@XmlElement(name="JobCode")
	public String getOccupationcode() {
		return occupationcode;
	}
	public void setOccupationcode(String occupationcode) {
		this.occupationcode = occupationcode;
	}
	
	@XmlElement(name="JobType")
	public String getOccupationname() {
		return occupationname;
	}
	public void setOccupationname(String occupationname) {
		this.occupationname = occupationname;
	}
	
	@XmlElement(name="Nationality")
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	@XmlElement(name="Stature")
	public String getStature() {
		return stature;
	}
	public void setStature(String stature) {
		this.stature = stature;
	}
	
	@XmlElement(name="Weight")
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	@XmlElement(name="MaritalStatus")
	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	
	@XmlElement(name="Dist")
	public String getDist() {
		return dist;
	}
	public void setDist(String dist) {
		this.dist = dist;
	}
	
	@XmlElement(name="City")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@XmlElement(name="Address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@XmlElement(name="ZipCode")
	public String getzipCode() {
		return zipcode;
	}
	public void setzipCode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	@XmlElement(name="Mobile")
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@XmlElement(name="Phone")
	public String getHomephone() {
		return homephone;
	}
	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}
	
	@XmlElement(name="Email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@XmlElement(name="RelaToInsured")
	public String getInsrelationapp() {
		return insrelationapp;
	}
	public void setInsrelationapp(String insrelationapp) {
		this.insrelationapp = insrelationapp;
	}
}
