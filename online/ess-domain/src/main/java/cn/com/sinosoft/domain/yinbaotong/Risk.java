package cn.com.sinosoft.domain.yinbaotong;
/**
 * 被保险人险种信息#
 * @author lwy
 *
 */
public class Risk {
	private String RiskCode;	//险种代码
	private String MainRiskCode;//主险险种代码
	private String BankRiskCode; //
	private String RiskType; //险种类型 1主险 0附加
	private String Amnt;    //保额
	private String Rate;	//费率或交费标准
	private String CValiDate; //生效日期(保单申请日)
	private String Rank;  //档次
	private String Prem; //保险费
	private String Mult; //投保份数
	private String PayIntv; //交费间隔 
	private String CostIntv; //扣款间隔 
	private String CostDate; //扣款时间
	private String Years;	//
	private String SpecContent;
	private String PayEndYearFlag;
	private String PayEndYear; //缴费年期/年龄
	private String PayoutStart;
	private String PayoutEnd;
	private String GetYearFlag;
	private String GetYear;
	private String InsuYearFlag;
	private String InsuYear;
	private String GetIntv;
	private String GetBankCode;
	private String GetBankAccNo;
	private String GetAccName;
	private String AutoPayFlag;
	private String BonusPayMode;
	private String SubFlag;
	private String BonusGetMode;
	private Accounts Accounts;//险种交费帐户信息
	private String HealthFlag;
	private String OccupationFlag;
	private String BeneficiaryIndicator;
	private String FinanceIndicator;
	private LCBnfs LCBnfs;//险种受益人信息
	
	public Risk() {
		super();
	}

	public Risk(String riskCode, String mainRiskCode, String bankRiskCode,
			String riskType, String amnt, String rate, String cValiDate,
			String rank, String prem, String mult, String payIntv,
			String costIntv, String costDate, String years, String specContent,
			String payEndYearFlag, String payEndYear, String payoutStart,
			String payoutEnd, String getYearFlag, String getYear,
			String insuYearFlag, String insuYear, String getIntv,
			String getBankCode, String getBankAccNo, String getAccName,
			String autoPayFlag, String bonusPayMode, String subFlag,
			String bonusGetMode, Accounts accounts, String healthFlag,
			String occupationFlag, String beneficiaryIndicator,
			String financeIndicator, LCBnfs lCBnfs) {
		super();
		RiskCode = riskCode;
		MainRiskCode = mainRiskCode;
		BankRiskCode = bankRiskCode;
		RiskType = riskType;
		Amnt = amnt;
		Rate = rate;
		CValiDate = cValiDate;
		Rank = rank;
		Prem = prem;
		Mult = mult;
		PayIntv = payIntv;
		CostIntv = costIntv;
		CostDate = costDate;
		Years = years;
		SpecContent = specContent;
		PayEndYearFlag = payEndYearFlag;
		PayEndYear = payEndYear;
		PayoutStart = payoutStart;
		PayoutEnd = payoutEnd;
		GetYearFlag = getYearFlag;
		GetYear = getYear;
		InsuYearFlag = insuYearFlag;
		InsuYear = insuYear;
		GetIntv = getIntv;
		GetBankCode = getBankCode;
		GetBankAccNo = getBankAccNo;
		GetAccName = getAccName;
		AutoPayFlag = autoPayFlag;
		BonusPayMode = bonusPayMode;
		SubFlag = subFlag;
		BonusGetMode = bonusGetMode;
		Accounts = accounts;
		HealthFlag = healthFlag;
		OccupationFlag = occupationFlag;
		BeneficiaryIndicator = beneficiaryIndicator;
		FinanceIndicator = financeIndicator;
		LCBnfs = lCBnfs;
	}




	public String getRank() {
		return Rank;
	}


	public void setRank(String rank) {
		Rank = rank;
	}


	public String getMult() {
		return Mult;
	}


	public void setMult(String mult) {
		Mult = mult;
	}


	public String getRiskCode() {
		return RiskCode;
	}

	public void setRiskCode(String riskCode) {
		RiskCode = riskCode;
	}

	public String getMainRiskCode() {
		return MainRiskCode;
	}

	public void setMainRiskCode(String mainRiskCode) {
		MainRiskCode = mainRiskCode;
	}

	public String getBankRiskCode() {
		return BankRiskCode;
	}

	public void setBankRiskCode(String bankRiskCode) {
		BankRiskCode = bankRiskCode;
	}

	public String getRiskType() {
		return RiskType;
	}

	public void setRiskType(String riskType) {
		RiskType = riskType;
	}

	public String getAmnt() {
		return Amnt;
	}

	public void setAmnt(String amnt) {
		Amnt = amnt;
	}

	public String getRate() {
		return Rate;
	}

	public void setRate(String rate) {
		Rate = rate;
	}

	public String getCValiDate() {
		return CValiDate;
	}

	public void setCValiDate(String cValiDate) {
		CValiDate = cValiDate;
	}

	public String getPrem() {
		return Prem;
	}

	public void setPrem(String prem) {
		Prem = prem;
	}

	public String getPayIntv() {
		return PayIntv;
	}

	public void setPayIntv(String payIntv) {
		PayIntv = payIntv;
	}

	public String getCostIntv() {
		return CostIntv;
	}

	public void setCostIntv(String costIntv) {
		CostIntv = costIntv;
	}

	public String getCostDate() {
		return CostDate;
	}

	public void setCostDate(String costDate) {
		CostDate = costDate;
	}

	public String getYears() {
		return Years;
	}

	public void setYears(String years) {
		Years = years;
	}

	public String getSpecContent() {
		return SpecContent;
	}

	public void setSpecContent(String specContent) {
		SpecContent = specContent;
	}

	public String getPayEndYearFlag() {
		return PayEndYearFlag;
	}

	public void setPayEndYearFlag(String payEndYearFlag) {
		PayEndYearFlag = payEndYearFlag;
	}

	public String getPayEndYear() {
		return PayEndYear;
	}

	public void setPayEndYear(String payEndYear) {
		PayEndYear = payEndYear;
	}

	public String getPayoutStart() {
		return PayoutStart;
	}

	public void setPayoutStart(String payoutStart) {
		PayoutStart = payoutStart;
	}

	public String getPayoutEnd() {
		return PayoutEnd;
	}

	public void setPayoutEnd(String payoutEnd) {
		PayoutEnd = payoutEnd;
	}

	public String getGetYearFlag() {
		return GetYearFlag;
	}

	public void setGetYearFlag(String getYearFlag) {
		GetYearFlag = getYearFlag;
	}

	public String getGetYear() {
		return GetYear;
	}

	public void setGetYear(String getYear) {
		GetYear = getYear;
	}

	public String getInsuYearFlag() {
		return InsuYearFlag;
	}

	public void setInsuYearFlag(String insuYearFlag) {
		InsuYearFlag = insuYearFlag;
	}

	public String getInsuYear() {
		return InsuYear;
	}

	public void setInsuYear(String insuYear) {
		InsuYear = insuYear;
	}

	public String getGetIntv() {
		return GetIntv;
	}

	public void setGetIntv(String getIntv) {
		GetIntv = getIntv;
	}

	public String getGetBankCode() {
		return GetBankCode;
	}

	public void setGetBankCode(String getBankCode) {
		GetBankCode = getBankCode;
	}

	public String getGetBankAccNo() {
		return GetBankAccNo;
	}

	public void setGetBankAccNo(String getBankAccNo) {
		GetBankAccNo = getBankAccNo;
	}

	public String getGetAccName() {
		return GetAccName;
	}

	public void setGetAccName(String getAccName) {
		GetAccName = getAccName;
	}

	public String getAutoPayFlag() {
		return AutoPayFlag;
	}

	public void setAutoPayFlag(String autoPayFlag) {
		AutoPayFlag = autoPayFlag;
	}

	public String getBonusPayMode() {
		return BonusPayMode;
	}

	public void setBonusPayMode(String bonusPayMode) {
		BonusPayMode = bonusPayMode;
	}

	public String getSubFlag() {
		return SubFlag;
	}

	public void setSubFlag(String subFlag) {
		SubFlag = subFlag;
	}

	public String getBonusGetMode() {
		return BonusGetMode;
	}

	public void setBonusGetMode(String bonusGetMode) {
		BonusGetMode = bonusGetMode;
	}

	public Accounts getAccounts() {
		return Accounts;
	}

	public void setAccounts(Accounts accounts) {
		Accounts = accounts;
	}

	public String getHealthFlag() {
		return HealthFlag;
	}

	public void setHealthFlag(String healthFlag) {
		HealthFlag = healthFlag;
	}

	public String getOccupationFlag() {
		return OccupationFlag;
	}

	public void setOccupationFlag(String occupationFlag) {
		OccupationFlag = occupationFlag;
	}

	public String getBeneficiaryIndicator() {
		return BeneficiaryIndicator;
	}

	public void setBeneficiaryIndicator(String beneficiaryIndicator) {
		BeneficiaryIndicator = beneficiaryIndicator;
	}

	public String getFinanceIndicator() {
		return FinanceIndicator;
	}

	public void setFinanceIndicator(String financeIndicator) {
		FinanceIndicator = financeIndicator;
	}

	public LCBnfs getLCBnfs() {
		return LCBnfs;
	}

	public void setLCBnfs(LCBnfs lCBnfs) {
		LCBnfs = lCBnfs;
	}
	
	
}
