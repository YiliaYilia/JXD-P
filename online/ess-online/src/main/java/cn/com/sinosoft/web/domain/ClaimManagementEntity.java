package cn.com.sinosoft.web.domain;

import java.util.Set;

import cn.com.sinosoft.domain.sale.GeClaimRider;

/**
 * 理赔 
 * @author GHY
 */
public class ClaimManagementEntity {
	
	private String claimManagementNo;		
	private String policyCode;				//保单号
	private String name;					//申请人
	private String flowNo;					//流水号
	private String claimManagementType;		//索赔类别（住院津贴1 ，医疗报销2,重大疾病3，伤残4，身故5）
	private String startDate;				//出险日期
	private String startCause;				//出险原因
	private String occupation;				//职业
	private String phone;					//电话
	private String isInsure;				//是否在其他保险公司有人身保险（是Y 否N）
	private String corporationName;			//公司名称
	private String insureDate;				//投保日期
	private String insuranceInfo;			//购买险种名称以及保额
	private String openId;					//微信id
	private String state;					//状态（01报案成功、02已提交有附件、03已退回、04审核中、05已完成）
	private String amount;					//理赔额
	private String insrelationApp;			//与被保险人关系
	private String updateDate;				//修改日期
	private String commitType;				//提交方式 (01柜台提交、02微信提交、03邮箱提交)
	private String payType;					//支付方式（01银行转账、02微信支付）
	private String remark;					//备注
	private String createDate;				//申请日期
	private String languageState;
	private String languageClaimManagementType;
	private Set<GeClaimRider> geClaimRider;
	
	public Set<GeClaimRider> getGeClaimRider() {
		return geClaimRider;
	}
	public void setGeClaimRider(Set<GeClaimRider> geClaimRider) {
		this.geClaimRider = geClaimRider;
	}
	public String getClaimManagementNo() {
		return claimManagementNo;
	}
	public void setClaimManagementNo(String claimManagementNo) {
		this.claimManagementNo = claimManagementNo;
	}
	public String getPolicyCode() {
		return policyCode;
	}
	public void setPolicyCode(String policyCode) {
		this.policyCode = policyCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlowNo() {
		return flowNo;
	}
	public void setFlowNo(String flowNo) {
		this.flowNo = flowNo;
	}
	public String getClaimManagementType() {
		return claimManagementType;
	}
	public void setClaimManagementType(String claimManagementType) {
		this.claimManagementType = claimManagementType;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStartCause() {
		return startCause;
	}
	public void setStartCause(String startCause) {
		this.startCause = startCause;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIsInsure() {
		return isInsure;
	}
	public void setIsInsure(String isInsure) {
		this.isInsure = isInsure;
	}
	public String getCorporationName() {
		return corporationName;
	}
	public void setCorporationName(String corporationName) {
		this.corporationName = corporationName;
	}
	public String getInsureDate() {
		return insureDate;
	}
	public void setInsureDate(String insureDate) {
		this.insureDate = insureDate;
	}
	public String getInsuranceInfo() {
		return insuranceInfo;
	}
	public void setInsuranceInfo(String insuranceInfo) {
		this.insuranceInfo = insuranceInfo;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getInsrelationApp() {
		return insrelationApp;
	}
	public void setInsrelationApp(String insrelationApp) {
		this.insrelationApp = insrelationApp;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getCommitType() {
		return commitType;
	}
	public void setCommitType(String commitType) {
		this.commitType = commitType;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getLanguageState() {
		return languageState;
	}
	public void setLanguageState(String languageState) {
		this.languageState = languageState;
	}
	public String getLanguageClaimManagementType() {
		return languageClaimManagementType;
	}
	public void setLanguageClaimManagementType(String languageClaimManagementType) {
		this.languageClaimManagementType = languageClaimManagementType;
	}
}
