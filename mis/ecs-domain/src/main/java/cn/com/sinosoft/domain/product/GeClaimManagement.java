package cn.com.sinosoft.domain.product;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

/**
 * 理赔 
 * @author ZXX
 */
@Entity
@Table(name = "GE_CLAIM_MANAGEMENT")
public class GeClaimManagement implements java.io.Serializable {

	private static final long serialVersionUID = 5346759699505948157L;
	
	private String claimManagementNo;		
	private String policyCode;				//保单号
	private String name;					//申请人
	private String flowNo;					//流水号
	private String claimManagementType;		//索赔类别（住院津贴1 ，医疗报销2,重大疾病3，伤残4，身故5）
	private Date startDate;					//出险日期
	private String startCause;				//出险原因
	private String occupation;				//职业
	private String phone;					//电话
	private String isInsure;				//是否在其他保险公司有人身保险（是Y 否N）
	private String corporationName;			//公司名称
	private Date insureDate;				//投保日期
	private String insuranceInfo;			//购买险种名称以及保额
	private String openId;					//微信id
	private String state;					//状态（01已报案、02已提交、03已退回、04审核中、05已完成）
	private Date createDate;                //申请时间
	private String amount;					//理赔额
	private String insrelationApp;			//与被保险人关系
	private Date updateDate;				//修改日期
	private String commitType;				//提交方式 (01柜台提交、02微信提交、03邮箱提交)
	private String payType;					//支付方式（01银行转账、02微信支付）
	private String remark;                  //备注

	private String insuredName;				//被保险人姓名
	private String insuredIdNo;				//被保险人证件号
	
	private Set<GeClaimRider> geClaimRider;
	
	private Date starttime;               //开始时间
	private Date endtime;                 //结束时间
	private String deptid;                //机构代码
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "CLAIMMANAGEMENTNO", unique = true, nullable = false)
	public String getClaimManagementNo() {
		return claimManagementNo;
	}
	public void setClaimManagementNo(String claimManagementNo) {
		this.claimManagementNo = claimManagementNo;
	}
	
	@Column(name = "POLICYCODE")
	public String getPolicyCode() {
		return policyCode;
	}
	public void setPolicyCode(String policyCode) {
		this.policyCode = policyCode;
	}
	
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "FLOWNO")
	public String getFlowNo() {
		return flowNo;
	}
	public void setFlowNo(String flowNo) {
		this.flowNo = flowNo;
	}
	
	@Column(name = "CLAIMMANAGEMENTTYPE", length = 1)
	public String getClaimManagementType() {
		return claimManagementType;
	}
	public void setClaimManagementType(String claimManagementType) {
		this.claimManagementType = claimManagementType;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STARTDATE")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Column(name = "STARTCAUSE")
	public String getStartCause() {
		return startCause;
	}
	public void setStartCause(String startCause) {
		this.startCause = startCause;
	}
	
	@Column(name = "OCCUPATION")
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	@Column(name = "PHONE")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "ISINSURE", length = 1)
	public String getIsInsure() {
		return isInsure;
	}
	public void setIsInsure(String isInsure) {
		this.isInsure = isInsure;
	}
	
	@Column(name = "CORPORATIONNAME")
	public String getCorporationName() {
		return corporationName;
	}
	public void setCorporationName(String corporationName) {
		this.corporationName = corporationName;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INSUREDATE")
	public Date getInsureDate() {
		return insureDate;
	}
	public void setInsureDate(Date insureDate) {
		this.insureDate = insureDate;
	}
	
	@Column(name = "INSURANCEINFO")
	public String getInsuranceInfo() {
		return insuranceInfo;
	}
	public void setInsuranceInfo(String insuranceInfo) {
		this.insuranceInfo = insuranceInfo;
	}
	
	@Column(name = "OPENID")
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
	@Column(name = "STATE", length = 2)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDATE")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Column(name = "AMOUNT")
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	@Column(name = "INSRELATIONAPP")
	public String getInsrelationApp() {
		return insrelationApp;
	}
	public void setInsrelationApp(String insrelationApp) {
		this.insrelationApp = insrelationApp;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATEDATE")
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@OneToMany(mappedBy="claimManagement")
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	//@Fetch(FetchMode.JOIN)
	public Set<GeClaimRider> getGeClaimRider() {
		return geClaimRider;
	}
	public void setGeClaimRider(Set<GeClaimRider> geClaimRider) {
		this.geClaimRider = geClaimRider;
	}
	
	@Column(name = "COMMITTYPE")
	public String getCommitType() {
		return commitType;
	}
	public void setCommitType(String commitType) {
		this.commitType = commitType;
	}
	
	@Column(name = "PAYTYPE")
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STARTTIME")
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ENDTIME")
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	
	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "INSUREDNAME")
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	
	@Column(name = "INSUREDIDNO")
	public String getInsuredIdNo() {
		return insuredIdNo;
	}
	public void setInsuredIdNo(String insuredIdNo) {
		this.insuredIdNo = insuredIdNo;
	}
	
	@Column(name = "deptid")
	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	
}

