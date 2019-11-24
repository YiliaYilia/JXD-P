package cn.com.sinosoft.ess.protal.model;

import java.util.List;


/**
 * 描述：险种<br>
 * 作者：wanhonghui <br>
 * 修改日期：2013年8月15日下午1:13:22 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 */
public class Risk {
	/**险种编码 非空*/
	private String riskCode;
	/**主险编码 非空*/
	private String mainRiskCode;
	/**险种类型 默认为空*/
	private String riskType;
	/** 险种名称 默认为空*/
	private String riskName;
	/**保额 */
	private String amnt;
	/**费率 默认为空-*/
	private String rate;
	/**保单生效日 非空*/
	private String cValiDate;
	/**缴别 默认为空*/
	private String rank;
	/**保费*/
	private String prem;
	/**份数 非空 */
	private String mult;
	/**交费方式 默认为空*/
	private String payIntv;
	/**扣款间隔  默认为空*/
	private String costIntv;
	/**扣款时间默认为空*/
	private String costDate;
	/** 特别说明默认为空*/
	private String specContent;
	/**交费类型  默认为空*/
	private String payEndYearFlag;
	/**默认为空*/
	private String payEndYear;
	/**默认为空*/
	private String getYearFlag;
	/**默认为空*/
	private String getYear;
	/**默认为空*/
	private String insuYearFlag;
	/**默认为空 */
	private String insuYear;
	/**领取方式 默认为空*/
	private String getIntv;
	/**开始领取年龄 默认为空*/
	private String getStart;
	/**结束领取年龄 默认为空*/
	private String getEnd;
	/**领取银行编码 默认为空*/
	private String getBankCode;
	/**领取银行账户 默认为空*/
	private String getBankAccNo;
	/**领取银行户名 默认为空*/
	private String getAccName;
	/**垫交标志 默认为空*/
	private String autoPayFlag;
	/**红利分配标记 默认为空*/
	private String bonusPayMode;
	/**减额交清标志 默认为空*/
	private String subFlag;
	/**投资账户 默认为空*/
	@NodeNumber(isShowNumber=true,nodeName="AccountCount")
	private List<Account> accounts;
	/**满期领取金领取方式 默认为空*/
	private String fullBonusGetMode;
	/**初始费用率  默认为空*/
	private String firstRate;
	/**保证利率  默认为空*/
	private String sureRate;
	/**计划号  默认为空*/
	private String schemeNo;
	/**定期额外保险费  默认为空*/
	private String regularAddPrem;
	/**不定期额外保险费  默认为空*/
	private String irregularAddPrem;
	/**
	 * 有效时间类型YMD
	 */
	private String validDateType;
	/**
	 * 有效时间
	 */
	private String validDate;
	
	public String getValidDateType() {
		return validDateType;
	}
	public void setValidDateType(String validDateType) {
		this.validDateType = validDateType;
	}
	public String getValidDate() {
		return validDate;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getMainRiskCode() {
		return mainRiskCode;
	}
	public void setMainRiskCode(String mainRiskCode) {
		this.mainRiskCode = mainRiskCode;
	}
	public String getRiskType() {
		return riskType;
	}
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}
	public String getRiskName() {
		return riskName;
	}
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
	public String getAmnt() {
		return amnt;
	}
	public void setAmnt(String amnt) {
		this.amnt = amnt;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getcValiDate() {
		return cValiDate;
	}
	public void setcValiDate(String cValiDate) {
		this.cValiDate = cValiDate;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getPrem() {
		return prem;
	}
	public void setPrem(String prem) {
		this.prem = prem;
	}
	public String getMult() {
		return mult;
	}
	public void setMult(String mult) {
		this.mult = mult;
	}
	public String getPayIntv() {
		return payIntv;
	}
	public void setPayIntv(String payIntv) {
		this.payIntv = payIntv;
	}
	public String getCostIntv() {
		return costIntv;
	}
	public void setCostIntv(String costIntv) {
		this.costIntv = costIntv;
	}
	public String getCostDate() {
		return costDate;
	}
	public void setCostDate(String costDate) {
		this.costDate = costDate;
	}
	public String getSpecContent() {
		return specContent;
	}
	public void setSpecContent(String specContent) {
		this.specContent = specContent;
	}
	public String getPayEndYearFlag() {
		return payEndYearFlag;
	}
	public void setPayEndYearFlag(String payEndYearFlag) {
		this.payEndYearFlag = payEndYearFlag;
	}
	public String getPayEndYear() {
		return payEndYear;
	}
	public void setPayEndYear(String payEndYear) {
		this.payEndYear = payEndYear;
	}
	public String getGetYearFlag() {
		return getYearFlag;
	}
	public void setGetYearFlag(String getYearFlag) {
		this.getYearFlag = getYearFlag;
	}
	public String getGetYear() {
		return getYear;
	}
	public void setGetYear(String getYear) {
		this.getYear = getYear;
	}
	public String getInsuYearFlag() {
		return insuYearFlag;
	}
	public void setInsuYearFlag(String insuYearFlag) {
		this.insuYearFlag = insuYearFlag;
	}
	public String getInsuYear() {
		return insuYear;
	}
	public void setInsuYear(String insuYear) {
		this.insuYear = insuYear;
	}
	public String getGetIntv() {
		return getIntv;
	}
	public void setGetIntv(String getIntv) {
		this.getIntv = getIntv;
	}
	public String getGetStart() {
		return getStart;
	}
	public void setGetStart(String getStart) {
		this.getStart = getStart;
	}
	public String getGetEnd() {
		return getEnd;
	}
	public void setGetEnd(String getEnd) {
		this.getEnd = getEnd;
	}
	public String getGetBankCode() {
		return getBankCode;
	}
	public void setGetBankCode(String getBankCode) {
		this.getBankCode = getBankCode;
	}
	public String getGetBankAccNo() {
		return getBankAccNo;
	}
	public void setGetBankAccNo(String getBankAccNo) {
		this.getBankAccNo = getBankAccNo;
	}
	public String getGetAccName() {
		return getAccName;
	}
	public void setGetAccName(String getAccName) {
		this.getAccName = getAccName;
	}
	public String getAutoPayFlag() {
		return autoPayFlag;
	}
	public void setAutoPayFlag(String autoPayFlag) {
		this.autoPayFlag = autoPayFlag;
	}
	public String getBonusPayMode() {
		return bonusPayMode;
	}
	public void setBonusPayMode(String bonusPayMode) {
		this.bonusPayMode = bonusPayMode;
	}
	public String getSubFlag() {
		return subFlag;
	}
	public void setSubFlag(String subFlag) {
		this.subFlag = subFlag;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public String getFullBonusGetMode() {
		return fullBonusGetMode;
	}
	public void setFullBonusGetMode(String fullBonusGetMode) {
		this.fullBonusGetMode = fullBonusGetMode;
	}
	public String getFirstRate() {
		return firstRate;
	}
	public void setFirstRate(String firstRate) {
		this.firstRate = firstRate;
	}
	public String getSureRate() {
		return sureRate;
	}
	public void setSureRate(String sureRate) {
		this.sureRate = sureRate;
	}
	public String getSchemeNo() {
		return schemeNo;
	}
	public void setSchemeNo(String schemeNo) {
		this.schemeNo = schemeNo;
	}
	public String getRegularAddPrem() {
		return regularAddPrem;
	}
	public void setRegularAddPrem(String regularAddPrem) {
		this.regularAddPrem = regularAddPrem;
	}
	public String getIrregularAddPrem() {
		return irregularAddPrem;
	}
	public void setIrregularAddPrem(String irregularAddPrem) {
		this.irregularAddPrem = irregularAddPrem;
	}
	
}
