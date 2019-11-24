package cn.com.sinosoft.msl.model.underWriting.shortPolicy.request;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/*@Entity
@Table(name = "T_POLICYINFO")*/

public class InsuraPerson implements Serializable{
	
	private static final long serialVersionUID = 287757362L;
	private String insId;//主键
	private String name;//姓名
	private String gender;//性别 1-男 0-女
	private String idType;//证件类型
	private String idNo;//证件号码
	private Date birthday;//出生日期
	private String mobile;//手机号码
	private String provinceId;//常驻地区省
	private String cityId;//常驻地区（默认为省会所在市级代码）
	private String countryId;//常驻地区
	private String addr;//联系地址
	private String zipcode;//邮编
	private String email;//电子邮箱
    private String annualSalary;//年收入
    private String married;//婚姻状况
    private String telArea;//固定区号
    private String telExt;//固定分机号
    private String telNo;//固定电话号码
    private String workType;//行业代码
    private String idExpiryDate;
    private String occupationCode;//职业代码（B2B渠道固定为A1001_1）
    private String peotype;//类型1-投保人 2-被保人 3-受益人 4-紧急联系人5-推荐人
    private String relationWithInsured;//投被保人关系
    private String id;
    
	
    public String getInsId() {
		return insId;
	}
	public void setInsId(String insId) {
		this.insId = insId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@XmlElement(name="province")
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(String annualSalary) {
		this.annualSalary = annualSalary;
	}
	public String getMarried() {
		return married;
	}
	public void setMarried(String married) {
		this.married = married;
	}
	public String getTelArea() {
		return telArea;
	}
	public void setTelArea(String telArea) {
		this.telArea = telArea;
	}
	public String getTelExt() {
		return telExt;
	}
	public void setTelExt(String telExt) {
		this.telExt = telExt;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public String getIdExpiryDate() {
		return idExpiryDate;
	}
	public void setIdExpiryDate(String idExpiryDate) {
		this.idExpiryDate = idExpiryDate;
	}
	public String getOccupationCode() {
		return occupationCode;
	}
	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}
	public String getPeotype() {
		return peotype;
	}
	public void setPeotype(String peotype) {
		this.peotype = peotype;
	}
	public String getRelationWithInsured() {
		return relationWithInsured;
	}
	public void setRelationWithInsured(String relationWithInsured) {
		this.relationWithInsured = relationWithInsured;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	//投保人信息构造类
	public InsuraPerson(Date birthday, String gender, String idNo, String idType,
			String mobile, String name, String occupationCode, String provinceId,
			String workType, String relationWithInsured ) {
		super();
		this.birthday = birthday;
		this.gender = gender;
		this.idNo = idNo;
		this.idType = idType;
		this.mobile = mobile;
		this.name = name;
		this.occupationCode = occupationCode;
		this.provinceId = provinceId;
		this.workType = workType;
		this.relationWithInsured = relationWithInsured;
	}
	
	//被保人信息构造类
		public InsuraPerson(String addr, Date birthday,
				String email, String gender, String idNo, 
				String idType, String married,  String mobile,
				String name, String occupationCode, String provinceId,
				String telArea, String telExt, String telNo, 
				String workType,  String zipcode ) {
			super();
			this.addr = addr;
			this.birthday = birthday;
			this.email = email;
			this.gender = gender;
			this.idNo = idNo;
			this.idType = idType;
			this.married = married;
			this.mobile = mobile;
			this.name = name;
			this.occupationCode = occupationCode;
			this.provinceId = provinceId;
			this.telArea = telArea;
			this.telExt = telExt;
			this.telNo = telNo;
			this.workType = workType;
			this.zipcode = zipcode;
		}
	
	//推荐人信息构造类
	public InsuraPerson(String id,String name){
		super();
		this.id = id;
		this.name = name;
	}
	
	public InsuraPerson(){
		super();
	}
}
