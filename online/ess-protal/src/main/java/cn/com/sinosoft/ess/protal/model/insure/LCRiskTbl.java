package cn.com.sinosoft.ess.protal.model.insure;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import cn.com.sinosoft.ess.protal.model.insure.base.RiskTbl;


/**
 * 描述：险种<br>
 * 作者：jcz <br>
 * 修改日期：2014-3-11 16:03:49 <br>
 * E-mail: jinchengze@sinosoft.com.cn <br>
 */
public class LCRiskTbl  extends RiskTbl{
	/**终缴日期*/
	private String payEndDate;
	/**扣款间隔  */
	private String costIntv;
	/**扣款时间*/
	private String costDate;
	/**交至日期(yyyyMMdd)*/
	private String payToDate;
	/**领取年龄年期标志*/
	private String getYearFlag;
	/**起领日期(yyyyMMdd)*/
	private String getStartDate;
	/**领取年龄*/
	private String getYear;
	/**领取方式 */
	private String getIntv;
	/**领取银行编码 */
	private String getBankCode;
	/**领取银行账户 */
	private String getBankAccNo;
	/**领取银行户名 */
	private String getAccName;
	/**自动垫交标志*/
	private String autoPayFlag;
	/**红利领取方式*/
	private String bonusGetMode;
	/**减额交清标志*/
	private String subFlag;
	/**满期领取金领取方式 */
	private String fullBonusGetMode;
	/**投资账户 默认为空*/
	private List<CashValue> cashValues;
	/** 特别约定*/
	private String specContent;
	
	@XmlElement(name="PayEndDate")
	public String getPayEndDate() {
		return payEndDate;
	}
	public void setPayEndDate(String payEndDate) {
		this.payEndDate = payEndDate;
	}
	@XmlElement(name="CostIntv")
	public String getCostIntv() {
		return costIntv;
	}
	public void setCostIntv(String costIntv) {
		this.costIntv = costIntv;
	}
	@XmlElement(name="CostDate")
	public String getCostDate() {
		return costDate;
	}
	public void setCostDate(String costDate) {
		this.costDate = costDate;
	}
	@XmlElement(name="PayToDate")
	public String getPayToDate() {
		return payToDate;
	}
	public void setPayToDate(String payToDate) {
		this.payToDate = payToDate;
	}
	@XmlElement(name="GetYearFlag")
	public String getGetYearFlag() {
		return getYearFlag;
	}
	public void setGetYearFlag(String getYearFlag) {
		this.getYearFlag = getYearFlag;
	}
	@XmlElement(name="GetStartDate")
	public String getGetStartDate() {
		return getStartDate;
	}
	public void setGetStartDate(String getStartDate) {
		this.getStartDate = getStartDate;
	}
	@XmlElement(name="GetYear")
	public String getGetYear() {
		return getYear;
	}
	public void setGetYear(String getYear) {
		this.getYear = getYear;
	}
	@XmlElement(name="GetIntv")
	public String getGetIntv() {
		return getIntv;
	}
	public void setGetIntv(String getIntv) {
		this.getIntv = getIntv;
	}
	@XmlElement(name="GetBankCode")
	public String getGetBankCode() {
		return getBankCode;
	}
	public void setGetBankCode(String getBankCode) {
		this.getBankCode = getBankCode;
	}
	@XmlElement(name="GetBankAccNo")
	public String getGetBankAccNo() {
		return getBankAccNo;
	}
	public void setGetBankAccNo(String getBankAccNo) {
		this.getBankAccNo = getBankAccNo;
	}
	@XmlElement(name="GetAccName")
	public String getGetAccName() {
		return getAccName;
	}
	public void setGetAccName(String getAccName) {
		this.getAccName = getAccName;
	}
	@XmlElement(name="AutoPayFlag")
	public String getAutoPayFlag() {
		return autoPayFlag;
	}
	public void setAutoPayFlag(String autoPayFlag) {
		this.autoPayFlag = autoPayFlag;
	}
	@XmlElement(name="BonusGetMode")
	public String getBonusGetMode() {
		return bonusGetMode;
	}
	public void setBonusGetMode(String bonusGetMode) {
		this.bonusGetMode = bonusGetMode;
	}
	@XmlElement(name="SubFlag")
	public String getSubFlag() {
		return subFlag;
	}
	public void setSubFlag(String subFlag) {
		this.subFlag = subFlag;
	}
	@XmlElement(name="FullBonusGetMode")
	public String getFullBonusGetMode() {
		return fullBonusGetMode;
	}
	public void setFullBonusGetMode(String fullBonusGetMode) {
		this.fullBonusGetMode = fullBonusGetMode;
	}
	@XmlElement(name="CashValues")
	public List<CashValue> getCashValues() {
		return cashValues;
	}
	public void setCashValues(List<CashValue> cashValues) {
		this.cashValues = cashValues;
	}
	@XmlElement(name="SpecContent")
	public String getSpecContent() {
		return specContent;
	}
	public void setSpecContent(String specContent) {
		this.specContent = specContent;
	}
	
	
}
