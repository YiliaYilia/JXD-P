package cn.com.sinosoft.ess.protal.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 描述：被保人信息<br>
 * 作者：wanhonghui <br>
 * 修改日期：2013年8月15日下午12:03:44 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 */
@XmlType(name="Insured")
public class LCInsured {
	/**被保人姓名 非空*/
	private String name;
	/** 性别 非空*/
	private String sex;
	/**出生日期 非空*/
	private String birthday;
	/**证件类型 非空*/
	private String iDType;
	/**证件号码 非空 */
	private String iDNo;
	/**证件有效期 非空 */
	private String visaExpDate;
	/**默认为空 */
	private String iDCardCopy;
	/**国籍 默认为空*/
	private String nationality;
	/**默认为空*/
	private String yIncome;
	/**默认为空*/
	private String height;
	/**默认为空 */
	private String weight;
	/**默认为空*/
	private String jobCode;
	/**默认为空*/
	private String marriage;
	/**默认为空 */
	private String mailAddress;
	/**默认为空*/
	private String mailZipCode;
	/**默认为空*/
	private String mailAddressAdd;
	/**默认为空*/
	private String homeAddress;
	/**默认为空*/
	private String homeZipCode;
	/**默认为空*/
	private String homeAddressAdd;
	/**默认为空*/
	private String companyAddress;
	/**默认为空*/
	private String companyAddressAdd;
	/**默认为空*/
	private String companyZipCode;
	/**默认为空*/
	private String companyPhone;
	/**默认为空 */
	private String homePhone;
	/**被保人手机号码 非空*/
	private String mobile;
	/**默认为空*/
	private String fax;
	/**默认为空*/
	private String eMail;
	/**默认为空*/
	private String relaToMain;
	/**默认为空*/
	private String relaToAppnt;
	/**健康告知*/
	private String healthFlag;
	/**服务地区*/
	private String serviceAddress;
	/**职业告知标志 Y 有职业告知 N 无职业告知*/
	private String jobNotice;
	/**责任*/
	@NodeNumber(isShowNumber=true,nodeName="RiskCount")
	private List<Risk> risks;
	
	@XmlElement(name="Name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getiDType() {
		return iDType;
	}
	public void setiDType(String iDType) {
		this.iDType = iDType;
	}
	public String getiDNo() {
		return iDNo;
	}
	public void setiDNo(String iDNo) {
		this.iDNo = iDNo;
	}
	public String getVisaExpDate() {
		return visaExpDate;
	}
	public void setVisaExpDate(String visaExpDate) {
		this.visaExpDate = visaExpDate;
	}
	public String getiDCardCopy() {
		return iDCardCopy;
	}
	public void setiDCardCopy(String iDCardCopy) {
		this.iDCardCopy = iDCardCopy;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getyIncome() {
		return yIncome;
	}
	public void setyIncome(String yIncome) {
		this.yIncome = yIncome;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getMailZipCode() {
		return mailZipCode;
	}
	public void setMailZipCode(String mailZipCode) {
		this.mailZipCode = mailZipCode;
	}
	public String getMailAddressAdd() {
		return mailAddressAdd;
	}
	public void setMailAddressAdd(String mailAddressAdd) {
		this.mailAddressAdd = mailAddressAdd;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getHomeZipCode() {
		return homeZipCode;
	}
	public void setHomeZipCode(String homeZipCode) {
		this.homeZipCode = homeZipCode;
	}
	public String getHomeAddressAdd() {
		return homeAddressAdd;
	}
	public void setHomeAddressAdd(String homeAddressAdd) {
		this.homeAddressAdd = homeAddressAdd;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyAddressAdd() {
		return companyAddressAdd;
	}
	public void setCompanyAddressAdd(String companyAddressAdd) {
		this.companyAddressAdd = companyAddressAdd;
	}
	public String getCompanyZipCode() {
		return companyZipCode;
	}
	public void setCompanyZipCode(String companyZipCode) {
		this.companyZipCode = companyZipCode;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getRelaToMain() {
		return relaToMain;
	}
	public void setRelaToMain(String relaToMain) {
		this.relaToMain = relaToMain;
	}
	public String getRelaToAppnt() {
		return relaToAppnt;
	}
	public void setRelaToAppnt(String relaToAppnt) {
		this.relaToAppnt = relaToAppnt;
	}
	public String getHealthFlag() {
		return healthFlag;
	}
	public void setHealthFlag(String healthFlag) {
		this.healthFlag = healthFlag;
	}
	public String getServiceAddress() {
		return serviceAddress;
	}
	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}
	public String getJobNotice() {
		return jobNotice;
	}
	public void setJobNotice(String jobNotice) {
		this.jobNotice = jobNotice;
	}
	public List<Risk> getRisks() {
		return risks;
	}
	public void setRisks(List<Risk> risks) {
		this.risks = risks;
	}
	
}
