package cn.com.sinosoft.domain.yinbaotong;
/**
 * 投保人资料
 * @author lwy
 */
public class LCAppnt {
	private String AppntPartyKey;
	private String AppntName;//投保人姓名
	private String AppntSex;
	private String AppntBirthday;
	private String AppntIDType;
	private String AppntIDNo;
	private String IDEffDate;
	private String IDExpDate;
	private String Nationality;
	private String AppntPhone;
	private String AppntOfficePhone;
	private String AppntMobile;
	private String HomeAddress;
	private String HomeZipCode;
	private String MailAddress;
	private String MailZipCode;
	private String Email;
	private String JobCode;
	private String EstAnnualSalary;
	private String FamilyEstSalary;
	private String LiveZone;//客户类型
	private String AddressStateTC;
	private String AddressState;
	private String City;
	private String RelaToInsured;
	private String TaxPayer;  //1:仅为中国税收居民 2:仅为非居民 3:既是中国税收居民 又其他国家（地区）税收居民
	
	public String getTaxPayer() {
		return TaxPayer;
	}
	public void setTaxPayer(String taxPayer) {
		TaxPayer = taxPayer;
	}
	public LCAppnt() {
		super();
	}
	public LCAppnt(String appntPartyKey, String appntName, String appntSex,
			String appntBirthday, String appntIDType, String appntIDNo,
			String iDEffDate, String iDExpDate, String nationality,
			String appntPhone, String appntOfficePhone, String appntMobile,
			String homeAddress, String homeZipCode, String mailAddress,
			String mailZipCode, String email, String jobCode,
			String estAnnualSalary, String familyEstSalary, String liveZone,
			String addressStateTC, String addressState, String city,
			String relaToInsured ,String taxPayer
			) {
		super();
		AppntPartyKey = appntPartyKey;
		AppntName = appntName;
		AppntSex = appntSex;
		AppntBirthday = appntBirthday;
		AppntIDType = appntIDType;
		AppntIDNo = appntIDNo;
		IDEffDate = iDEffDate;
		IDExpDate = iDExpDate;
		Nationality = nationality;
		AppntPhone = appntPhone;
		AppntOfficePhone = appntOfficePhone;
		AppntMobile = appntMobile;
		HomeAddress = homeAddress;
		HomeZipCode = homeZipCode;
		MailAddress = mailAddress;
		MailZipCode = mailZipCode;
		Email = email;
		JobCode = jobCode;
		EstAnnualSalary = estAnnualSalary;
		FamilyEstSalary = familyEstSalary;
		LiveZone = liveZone;
		AddressStateTC = addressStateTC;
		AddressState = addressState;
		City = city;
		RelaToInsured = relaToInsured;
		TaxPayer = taxPayer;
	}
	public String getAppntPartyKey() {
		return AppntPartyKey;
	}
	public void setAppntPartyKey(String appntPartyKey) {
		AppntPartyKey = appntPartyKey;
	}
	public String getAppntName() {
		return AppntName;
	}
	public void setAppntName(String appntName) {
		AppntName = appntName;
	}
	public String getAppntSex() {
		return AppntSex;
	}
	public void setAppntSex(String appntSex) {
		AppntSex = appntSex;
	}
	public String getAppntBirthday() {
		return AppntBirthday;
	}
	public void setAppntBirthday(String appntBirthday) {
		AppntBirthday = appntBirthday;
	}
	public String getAppntIDType() {
		return AppntIDType;
	}
	public void setAppntIDType(String appntIDType) {
		AppntIDType = appntIDType;
	}
	public String getAppntIDNo() {
		return AppntIDNo;
	}
	public void setAppntIDNo(String appntIDNo) {
		AppntIDNo = appntIDNo;
	}
	public String getIDEffDate() {
		return IDEffDate;
	}
	public void setIDEffDate(String iDEffDate) {
		IDEffDate = iDEffDate;
	}
	public String getIDExpDate() {
		return IDExpDate;
	}
	public void setIDExpDate(String iDExpDate) {
		IDExpDate = iDExpDate;
	}
	public String getNationality() {
		return Nationality;
	}
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	public String getAppntPhone() {
		return AppntPhone;
	}
	public void setAppntPhone(String appntPhone) {
		AppntPhone = appntPhone;
	}
	public String getAppntOfficePhone() {
		return AppntOfficePhone;
	}
	public void setAppntOfficePhone(String appntOfficePhone) {
		AppntOfficePhone = appntOfficePhone;
	}
	public String getAppntMobile() {
		return AppntMobile;
	}
	public void setAppntMobile(String appntMobile) {
		AppntMobile = appntMobile;
	}
	public String getHomeAddress() {
		return HomeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		HomeAddress = homeAddress;
	}
	public String getHomeZipCode() {
		return HomeZipCode;
	}
	public void setHomeZipCode(String homeZipCode) {
		HomeZipCode = homeZipCode;
	}
	public String getMailAddress() {
		return MailAddress;
	}
	public void setMailAddress(String mailAddress) {
		MailAddress = mailAddress;
	}
	public String getMailZipCode() {
		return MailZipCode;
	}
	public void setMailZipCode(String mailZipCode) {
		MailZipCode = mailZipCode;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getJobCode() {
		return JobCode;
	}
	public void setJobCode(String jobCode) {
		JobCode = jobCode;
	}
	public String getEstAnnualSalary() {
		return EstAnnualSalary;
	}
	public void setEstAnnualSalary(String estAnnualSalary) {
		EstAnnualSalary = estAnnualSalary;
	}
	public String getFamilyEstSalary() {
		return FamilyEstSalary;
	}
	public void setFamilyEstSalary(String familyEstSalary) {
		FamilyEstSalary = familyEstSalary;
	}
	public String getLiveZone() {
		return LiveZone;
	}
	public void setLiveZone(String liveZone) {
		LiveZone = liveZone;
	}
	public String getAddressStateTC() {
		return AddressStateTC;
	}
	public void setAddressStateTC(String addressStateTC) {
		AddressStateTC = addressStateTC;
	}
	public String getAddressState() {
		return AddressState;
	}
	public void setAddressState(String addressState) {
		AddressState = addressState;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getRelaToInsured() {
		return RelaToInsured;
	}
	public void setRelaToInsured(String relaToInsured) {
		RelaToInsured = relaToInsured;
	}
	
}
