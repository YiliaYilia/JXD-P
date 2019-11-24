package cn.com.sinosoft.domain.yinbaotongWAB;
/**
 * 被保人信息
 * @author lwy
 */
public class LCInsured {
	private String PartyKey;//不必填写的被保人编码
	private String Name;//姓名
	private String Sex;//性别
	private String Birthday;//生日
	private String IDType;//证件类型
	private String IDNo;//证件号
	private String IDEffDate;//证件开始日期
	private String IDExpDate;//证件截止日期
	private String JobCode;//被保险人职业代码
	private String Nationality;//被保人国籍
	private String HomePhone;//被保人家庭电话
	private String InsureCompanyPhone;//被保人工作电话
	private String InsuredMobile;//被保人手机
	private String HomeAddress;//被保人
	private String HomeZipCode;//被保人家庭地址邮编
	private String MailAddress;
	private String MailZipCode;
	private String Email;
	private String RelaToMain;
	private String AppntInsuredSame;
	private String RelaToAppnt;
	private Risks Risks;//被保险人险种信息
	
	
	private String AddressStateTC; //国家 CN
	private String AddressState;	//省
	private String City;			//市
	private String TaxPayer;       //中国纳税标志  1:仅为中国税收居民  2:仅为非居民 3:既是中国税收居民 又其他国家（地区）税收居民
	
	
	public LCInsured() {
		super();
	}

	public LCInsured(String partyKey, String name, String sex, String birthday,
			String iDType, String iDNo, String iDEffDate, String iDExpDate,
			String jobCode, String nationality, String homePhone,
			String insureCompanyPhone, String insuredMobile,
			String homeAddress, String homeZipCode, String mailAddress,
			String mailZipCode, String email, String relaToMain,
			String appntInsuredSame, String relaToAppnt,String addressStateTC,
			String addressState, String city, String  taxPayer,
			Risks risks) {
		super();
		PartyKey = partyKey;
		Name = name;
		Sex = sex;
		Birthday = birthday;
		IDType = iDType;
		IDNo = iDNo;
		IDEffDate = iDEffDate;
		IDExpDate = iDExpDate;
		JobCode = jobCode;
		Nationality = nationality;
		HomePhone = homePhone;
		InsureCompanyPhone = insureCompanyPhone;
		InsuredMobile = insuredMobile;
		HomeAddress = homeAddress;
		HomeZipCode = homeZipCode;
		MailAddress = mailAddress;
		MailZipCode = mailZipCode;
		Email = email;
		RelaToMain = relaToMain;
		AppntInsuredSame = appntInsuredSame;
		RelaToAppnt = relaToAppnt;
		AddressStateTC = addressStateTC;
		AddressState = addressState;
		City = city;
		TaxPayer = taxPayer;
		Risks = risks;
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

	public String getTaxPayer() {
		return TaxPayer;
	}

	public void setTaxPayer(String taxPayer) {
		TaxPayer = taxPayer;
	}

	public String getPartyKey() {
		return PartyKey;
	}
	public void setPartyKey(String partyKey) {
		PartyKey = partyKey;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	public String getIDType() {
		return IDType;
	}
	public void setIDType(String iDType) {
		IDType = iDType;
	}
	public String getIDNo() {
		return IDNo;
	}
	public void setIDNo(String iDNo) {
		IDNo = iDNo;
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
	public String getJobCode() {
		return JobCode;
	}
	public void setJobCode(String jobCode) {
		JobCode = jobCode;
	}
	public String getNationality() {
		return Nationality;
	}
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	public String getHomePhone() {
		return HomePhone;
	}
	public void setHomePhone(String homePhone) {
		HomePhone = homePhone;
	}
	public String getInsureCompanyPhone() {
		return InsureCompanyPhone;
	}
	public void setInsureCompanyPhone(String insureCompanyPhone) {
		InsureCompanyPhone = insureCompanyPhone;
	}
	public String getInsuredMobile() {
		return InsuredMobile;
	}
	public void setInsuredMobile(String insuredMobile) {
		InsuredMobile = insuredMobile;
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
	public String getAppntInsuredSame() {
		return AppntInsuredSame;
	}
	public void setAppntInsuredSame(String appntInsuredSame) {
		AppntInsuredSame = appntInsuredSame;
	}
	public String getRelaToAppnt() {
		return RelaToAppnt;
	}
	public void setRelaToAppnt(String relaToAppnt) {
		RelaToAppnt = relaToAppnt;
	}
	public Risks getRisks() {
		return Risks;
	}
	public void setRisks(Risks risks) {
		Risks = risks;
	}
	public String getRelaToMain() {
		return RelaToMain;
	}
	public void setRelaToMain(String relaToMain) {
		RelaToMain = relaToMain;
	}
	
}
