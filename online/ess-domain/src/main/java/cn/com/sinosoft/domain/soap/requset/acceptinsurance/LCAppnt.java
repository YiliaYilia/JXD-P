package cn.com.sinosoft.domain.soap.requset.acceptinsurance;
/**
 * 描述：投保人信息<br>
 * 作者：wanhonghui <br>
 * 修改日期：2013年8月15日上午11:25:27 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 */
public class LCAppnt {
	/**投保人姓名 非空*/
	private String appntName;
	/**投保人性别 非空*/
	private String appntSex;
	/**投保人出生日期 非空 */
	private String  appntBirthday;
	/**投保人证件类型 非空*/
	private String appntIDType ;
	/**投保人证件号码 非空 */
	private String appntIDNo ;
	/**件到日期 默认为空*/
	private String  visaExpDate;
	/**是否提供证件复印件 默认为空*/
	private String appntIDCardCopy ;
	/**婚姻标志 默认为空*/
	private String  marriage;
	/**职业代码 默认为空*/
	private String  jobCode;
	/**年收入 默认为空*/
	private String yIncome ;
	/**国籍 默认为空*/
	private String nationality ;
	/**办公电话*/
	private String appntPhone ;
	/**手机 非空*/
	private String appntMobile ;
	/**家庭电话*/
	private String appntHomePhone;
	/**传真 默认为空*/
	private String fax;
	/**电子邮箱*/
	private String eMail;
	/**邮寄地址*/
	private String mailAddress;
	/**邮寄地址邮编*/
	private String mailZipCode;
	/**默认为空*/
	private String mailAddressAdd;
	/**招商银行研发中心C座四楼*/
	private String homeAddress;
	/**家庭地址邮编*/
	private String homeZipCode;
	/**默认为空 */
	private String homeAddressAdd;
	/**默认为空 */
	private String companyAddress;
	/**默认为空 */
	private String companyAddressAdd;
	/** 默认为空 */
	private String companyZipCode;
	/**与被保人关系 本人*/
	private String relaToInsured;
	/**服务地区*/
	private String serviceAddress ;
	/**职业告知标志 Y 有职业告知 N 无职业告知*/
	private String jobNotice ;
	
	/**网上自助交易标识 默认为空*/
	private String onlineSelfTrans;

	public String getAppntName() {
		return appntName;
	}

	public void setAppntName(String appntName) {
		this.appntName = appntName;
	}

	public String getAppntSex() {
		return appntSex;
	}

	public void setAppntSex(String appntSex) {
		this.appntSex = appntSex;
	}

	public String getAppntBirthday() {
		return appntBirthday;
	}

	public void setAppntBirthday(String appntBirthday) {
		this.appntBirthday = appntBirthday;
	}

	public String getAppntIDType() {
		return appntIDType;
	}

	public void setAppntIDType(String appntIDType) {
		this.appntIDType = appntIDType;
	}

	public String getAppntIDNo() {
		return appntIDNo;
	}

	public void setAppntIDNo(String appntIDNo) {
		this.appntIDNo = appntIDNo;
	}

	public String getVisaExpDate() {
		return visaExpDate;
	}

	public void setVisaExpDate(String visaExpDate) {
		this.visaExpDate = visaExpDate;
	}

	public String getAppntIDCardCopy() {
		return appntIDCardCopy;
	}

	public void setAppntIDCardCopy(String appntIDCardCopy) {
		this.appntIDCardCopy = appntIDCardCopy;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getyIncome() {
		return yIncome;
	}

	public void setyIncome(String yIncome) {
		this.yIncome = yIncome;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAppntPhone() {
		return appntPhone;
	}

	public void setAppntPhone(String appntPhone) {
		this.appntPhone = appntPhone;
	}

	public String getAppntMobile() {
		return appntMobile;
	}

	public void setAppntMobile(String appntMobile) {
		this.appntMobile = appntMobile;
	}

	public String getAppntHomePhone() {
		return appntHomePhone;
	}

	public void setAppntHomePhone(String appntHomePhone) {
		this.appntHomePhone = appntHomePhone;
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

	public String getRelaToInsured() {
		return relaToInsured;
	}

	public void setRelaToInsured(String relaToInsured) {
		this.relaToInsured = relaToInsured;
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

	public String getOnlineSelfTrans() {
		return onlineSelfTrans;
	}

	public void setOnlineSelfTrans(String onlineSelfTrans) {
		this.onlineSelfTrans = onlineSelfTrans;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	
	
	
}
