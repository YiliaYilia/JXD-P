package cn.com.sinosoft.domain.sale;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * GePolicy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_policy")
public class GePolicy implements java.io.Serializable {

	// Fields

	/**
	 * GePolicy.java
	 */
	private static final long serialVersionUID = 1L;

	/* 保单编号 */
	private String policyno;
	/* 投保书号 */
	private String applicantcode;
	/* 保单号（承保后取得） */
	private String policycode;
	/* 产品编号 */
	private String prodoctcode;
	// 险种代码
	private String riskcode;
	// 险种类型编号
	private String classcode;
	// 保单服务区域
	private String areacode;
	// 承保公司
	private String salecom;
	/* 投保日期（==核保时间） */
	private Date insuretime;
	// 投保人名
	private String applicantname;
	// 投保人地址
	private String applicantaddress;
	// 被保人姓名
	private String insuredname;
	// 被保人地址
	private String insuredaddress;
	// 续保标志
	private String renewalflag;
	// 原保单号
	private String oldlpolicyno;
	// 生效日期
	private Date takeeffecttime;
	// 终止日期
	private Date deadlinetime;
	// 份数
	private String unitcount;
	// 保障期间
	private String policyterm;
	// 保障期间单位
	private String policytermtype;
	// 保障期间价值
	private String policytermvalue;
	// 最大保额
	private String maxinsuranceamount;
	/* 保险金额 */
	private Double sumamount;
	/* 总保费 */
	private Double sumbasepremium;
	// 总折扣(保费折扣)
	private Double discount;
	// 总折扣金额
	private Double sumdiscount;
	// 总保险费
	private Double sumpremium;
	// 总附加险保费
	private Double sumsubpremium;
	private String ispaper;
	private String eleaddress;
	private String businessarea;
	// 支付日期
	private Date platforminvaliddate;
	private Date inputdate;// 签单时间
	private String islegalflag;//受益人：1 本人 2 法定  3指定
	//保单状态1.核保成功 2.核保失败 3.承保成功 4.承保失败 5.人工核保
	private String status;
	//更新时间
	private Date updatetime;
	// 推荐人编码
	private String agentcode;
	// 代理人协议号
	private String agreementno;
	// 推荐人姓名
	private String agentname;
	// 代理人所在机构名称
	private String departmentname;
	// 标志位
	private String flag;
	// 投保地区(省)
	private String areacodepro;
	// 市
	private String areacodeprocity;
	// 折扣ID
	private String discountid;
	// 支付状态
	private String paymentstatus;
	private String ivrpassword;
	// 推销人姓名
	private String promoteName;
	// 推销人电话号码
	private String promotePhone;
	
//	private String contnumber;//投保份数
	
	private String flowno;//交易流水号，银保通来自100交易
	
	private GeOrder order;
	private List<GeReservation> geReservations = new ArrayList<GeReservation>();
	private Set<GeRiskduty> riskDuties;
	private Set<GeBeneficiary> beneficiaries;
	private Set<GeApplicantInsured> applicantInsureds;
	private GePaymentInfo paymentInfo;
	private Set<GeAccountInfo> accountInfos;
	// 缴费期限
	private String payYear;
	// 缴费年期标志
	private String payYeartag;
	// 缴费价值
	private String payYearValue;
	// 银保通保单失效回调时间
	private Date ybcancledate;
	// 航班号
	private String vehicleOrVessel;
	//优惠码
	private String preferentialcode;
	// 航班起飞时间
	private Date contractEfftime;

	//创建时间
	private Date createDate;
	private String bank;// 续保缴费
	private String bankAccountNumber;// 续保缴费账号
	private String source;// 来源：长短险
	private String originate;// 渠道，经销商，0：官网直销
	
	private String productname;//产品名称
	
	private String condition;//对账状态  0：未对账，1:对账成功，2：对账失败
	
	private Double stipend; //助学金
	
	private Double bookmoney; //赠书金
	
	private Double mainpolicypre; //主险保费
	
	private Double additionalpolicypre; //附加险保费

	private String openid;
	private String charityflag;
	
	private String brNo;//合作渠道代码
	
	
	//银行代扣部分
	private String billingType; //支付方式    微信支付N,银行代扣Y
	private String bankBranchName;//银行分行的名称
	private String bankBranchCode;//银行编码
	private String bankProvince; //开户行省
	private String bankCity;//开户行市
	
	
	private String deptid;
	/** default constructor */
	
	private String jobCode; 	//职业编码
	private String jobFlag;		//是否为4职业  Y  /  N
	
	private String lCBnfCount;		//受益人个数
	private String bnfName1;  		//受益人1 姓名
	private String bnfSex1;  		//受益人1 性别
	private String bnfBirthday1;	//受益人1 出生日期
	private String bnfIDNo1;		//受益人1 身份证号
	private String bnfLot1;			//受益人1 收益比例
	private String bnfName2; 		//受益人2 姓名
	private String bnfSex2;  		//受益人2 性别
	private String bnfBirthday2;	//受益人2 出生日期
	private String bnfIDNo2;		//受益人2 身份证号
	private String bnfLot2;			//受益人2 收益比例
	private String bnfName3; 		//受益人3 姓名
	private String bnfSex3;  		//受益人3 性别
	private String bnfBirthday3;	//受益人3 出生日期
	private String bnfIDNo3;		//受益人3 身份证号
	private String bnfLot3;			//受益人3 收益比例
	/**投保人地址省编码*/
	private String LCAProvince;		
	/**投保人地址市编码*/
	private String LCACity;		
	/**被保人地址省编码*/
	private String LCIProvince;	
	/**被保人地址市编码*/
	private String LCICity;		
	
	private String relationToInsured1;	//受益人1与被保人关系
	private String relationToInsured2;	//受益人2与被保人关系
	private String relationToInsured3;	//受益人3与被保人关系
	
	
	

	public GePolicy() {
	}
//	@Column(name="CONTNUMBER")
//	public String getContnumber() {
//		return contnumber;
//	}
//
//	public void setContnumber(String contnumber) {
//		this.contnumber = contnumber;
//	}

	@Column(name = "BANK")
	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	@Column(name = "BANKACCOUNTNUMBER")
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	@Column(name = "SOURCE")
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "ORIGINATE")
	public String getOriginate() {
		return originate;
	}

	public void setOriginate(String originate) {
		this.originate = originate;
	}

	@Column(name = "PAYYEAR", length = 10)
	public String getPayYear() {
		return payYear;
	}

	public void setPayYear(String payYear) {
		this.payYear = payYear;
	}

	@Column(name = "PAYTYPETAG", length = 10)
	public String getPayYeartag() {
		return payYeartag;
	}

	public void setPayYeartag(String payYeartag) {
		this.payYeartag = payYeartag;
	}

	@Column(name = "PAYTYPEVALUE", length = 20)
	public String getPayYearValue() {
		return payYearValue;
	}

	public void setPayYearValue(String payYearValue) {
		this.payYearValue = payYearValue;
	}

	@Column(name = "IVRPASSWORD", length = 50)
	public String getIvrpassword() {
		return ivrpassword;
	}

	public void setIvrpassword(String ivrpassword) {
		this.ivrpassword = ivrpassword;
	}

	@OneToOne(mappedBy = "policy")
	@Cascade(CascadeType.SAVE_UPDATE)
	public GePaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(GePaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	/** minimal constructor */
	public GePolicy(String policyno, String applicantcode) {
		this.policyno = policyno;
		this.applicantcode = applicantcode;
	}

	/** full constructor */
	

	public GePolicy(String policyno, String applicantcode, String policycode,
			String prodoctcode, String riskcode, String classcode,
			String areacode, String salecom, Date insuretime,
			String applicantname, String applicantaddress, String insuredname,
			String insuredaddress, String renewalflag, String oldlpolicyno,
			Date takeeffecttime, Date deadlinetime, String unitcount,
			String policyterm, String policytermtype, String policytermvalue,
			String maxinsuranceamount, Double sumamount, Double sumbasepremium,
			Double discount, Double sumdiscount, Double sumpremium,
			Double sumsubpremium, String ispaper, String eleaddress,
			String businessarea, Date platforminvaliddate, Date inputdate,
			String islegalflag, String status, Date updatetime,
			String agentcode, String agreementno, String agentname,
			String departmentname, String flag, String areacodepro,
			String areacodeprocity, String discountid, String paymentstatus,
			String ivrpassword, String promoteName, String promotePhone,
			String flowno, GeOrder order, List<GeReservation> geReservations,
			Set<GeRiskduty> riskDuties, Set<GeBeneficiary> beneficiaries,
			Set<GeApplicantInsured> applicantInsureds,
			GePaymentInfo paymentInfo, Set<GeAccountInfo> accountInfos,
			String payYear, String payYeartag, String payYearValue,
			Date ybcancledate, String vehicleOrVessel, String preferentialcode,
			Date contractEfftime, Date createDate, String bank,
			String bankAccountNumber, String source, String originate,
			String productname, String condition, Double stipend,
			Double bookmoney, String openid,String bankCity,String bankProvince,String contnumber) {
		this.policyno = policyno;
		this.applicantcode = applicantcode;
		this.policycode = policycode;
		this.prodoctcode = prodoctcode;
		this.riskcode = riskcode;
		this.classcode = classcode;
		this.areacode = areacode;
		this.salecom = salecom;
		this.insuretime = insuretime;
		this.applicantname = applicantname;
		this.applicantaddress = applicantaddress;
		this.insuredname = insuredname;
		this.insuredaddress = insuredaddress;
		this.renewalflag = renewalflag;
		this.oldlpolicyno = oldlpolicyno;
		this.takeeffecttime = takeeffecttime;
		this.deadlinetime = deadlinetime;
		this.unitcount = unitcount;
		this.policyterm = policyterm;
		this.policytermtype = policytermtype;
		this.policytermvalue = policytermvalue;
		this.maxinsuranceamount = maxinsuranceamount;
		this.sumamount = sumamount;
		this.sumbasepremium = sumbasepremium;
		this.discount = discount;
		this.sumdiscount = sumdiscount;
		this.sumpremium = sumpremium;
		this.sumsubpremium = sumsubpremium;
		this.ispaper = ispaper;
		this.eleaddress = eleaddress;
		this.businessarea = businessarea;
		this.platforminvaliddate = platforminvaliddate;
		this.inputdate = inputdate;
		this.islegalflag = islegalflag;
		this.status = status;
		this.updatetime = updatetime;
		this.agentcode = agentcode;
		this.agreementno = agreementno;
		this.agentname = agentname;
		this.departmentname = departmentname;
		this.flag = flag;
		this.areacodepro = areacodepro;
		this.areacodeprocity = areacodeprocity;
		this.discountid = discountid;
		this.paymentstatus = paymentstatus;
		this.ivrpassword = ivrpassword;
		this.promoteName = promoteName;
		this.promotePhone = promotePhone;
		this.flowno = flowno;
		this.order = order;
		this.geReservations = geReservations;
		this.riskDuties = riskDuties;
		this.beneficiaries = beneficiaries;
		this.applicantInsureds = applicantInsureds;
		this.paymentInfo = paymentInfo;
		this.accountInfos = accountInfos;
		this.payYear = payYear;
		this.payYeartag = payYeartag;
		this.payYearValue = payYearValue;
		this.ybcancledate = ybcancledate;
		this.vehicleOrVessel = vehicleOrVessel;
		this.preferentialcode = preferentialcode;
		this.contractEfftime = contractEfftime;
		this.createDate = createDate;
		this.bank = bank;
		this.bankAccountNumber = bankAccountNumber;
		this.source = source;
		this.originate = originate;
		this.productname = productname;
		this.condition = condition;
		this.stipend = stipend;
		this.bookmoney = bookmoney;
		this.openid = openid;
		this.bankCity=bankCity;
		this.bankProvince=bankProvince;
//		this.contnumber=contnumber;
	}


	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "POLICYNO", nullable = false)
	public String getPolicyno() {
		return this.policyno;
	}

	@OneToMany(mappedBy = "policy")
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	public Set<GeBeneficiary> getBeneficiaries() {
		return beneficiaries;
	}

	@OneToMany(mappedBy = "policy", fetch = FetchType.LAZY)
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	public Set<GeAccountInfo> getAccountInfos() {
		return accountInfos;
	}

	public void setAccountInfos(Set<GeAccountInfo> accountInfos) {
		this.accountInfos = accountInfos;
	}

	public void setBeneficiaries(Set<GeBeneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	@OneToMany(mappedBy = "policy", fetch = FetchType.LAZY)
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	public Set<GeRiskduty> getRiskDuties() {
		return riskDuties;
	}

	public void setRiskDuties(Set<GeRiskduty> riskDuties) {
		this.riskDuties = riskDuties;
	}

	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}

	@Column(name = "APPLICANTCODE", length = 50)
	public String getApplicantcode() {
		return this.applicantcode;
	}

	public void setApplicantcode(String applicantcode) {
		this.applicantcode = applicantcode;
	}

	@Column(name = "POLICYCODE", length = 50)
	public String getPolicycode() {
		return this.policycode;
	}

	public void setPolicycode(String policycode) {
		this.policycode = policycode;
	}

	@Column(name = "PRODOCTCODE", length = 50)
	public String getProdoctcode() {
		return this.prodoctcode;
	}

	public void setProdoctcode(String prodoctcode) {
		this.prodoctcode = prodoctcode;
	}

	@Column(name = "RISKCODE", length = 50)
	public String getRiskcode() {
		return this.riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode;
	}

	@Column(name = "CLASSCODE", length = 50)
	public String getClasscode() {
		return this.classcode;
	}

	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}

	@Column(name = "AREACODE", length = 50)
	public String getAreacode() {
		return this.areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	@Column(name = "SALECOM", length = 50)
	public String getSalecom() {
		return this.salecom;
	}

	public void setSalecom(String salecom) {
		this.salecom = salecom;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INSURETIME", length = 19)
	public Date getInsuretime() {
		return this.insuretime;
	}

	public void setInsuretime(Date insuretime) {
		this.insuretime = insuretime;
	}

	@Column(name = "APPLICANTNAME", length = 50)
	public String getApplicantname() {
		return this.applicantname;
	}

	public void setApplicantname(String applicantname) {
		this.applicantname = applicantname;
	}

	@Column(name = "APPLICANTADDRESS", length = 500)
	public String getApplicantaddress() {
		return this.applicantaddress;
	}

	public void setApplicantaddress(String applicantaddress) {
		this.applicantaddress = applicantaddress;
	}

	@Column(name = "INSUREDNAME", length = 50)
	public String getInsuredname() {
		return this.insuredname;
	}

	public void setInsuredname(String insuredname) {
		this.insuredname = insuredname;
	}

	@Column(name = "INSUREDADDRESS", length = 500)
	public String getInsuredaddress() {
		return this.insuredaddress;
	}

	public void setInsuredaddress(String insuredaddress) {
		this.insuredaddress = insuredaddress;
	}

	@Column(name = "RENEWALFLAG", length = 2)
	public String getRenewalflag() {
		return this.renewalflag;
	}

	public void setRenewalflag(String renewalflag) {
		this.renewalflag = renewalflag;
	}

	@Column(name = "OLDLPOLICYNO", length = 50)
	public String getOldlpolicyno() {
		return this.oldlpolicyno;
	}

	public void setOldlpolicyno(String oldlpolicyno) {
		this.oldlpolicyno = oldlpolicyno;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TAKEEFFECTTIME", length = 19)
	public Date getTakeeffecttime() {
		return this.takeeffecttime;
	}

	public void setTakeeffecttime(Date takeeffecttime) {
		this.takeeffecttime = takeeffecttime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DEADLINETIME", length = 19)
	public Date getDeadlinetime() {
		return this.deadlinetime;
	}

	public void setDeadlinetime(Date deadlinetime) {
		this.deadlinetime = deadlinetime;
	}

	@Column(name = "UNITCOUNT", length = 10)
	public String getUnitcount() {
		return this.unitcount;
	}

	public void setUnitcount(String unitcount) {
		this.unitcount = unitcount;
	}

	@Column(name = "POLICYTERM", length = 10)
	public String getPolicyterm() {
		return this.policyterm;
	}

	public void setPolicyterm(String policyterm) {
		this.policyterm = policyterm;
	}

	@Column(name = "POLICYTERMTYPE", length = 2)
	public String getPolicytermtype() {
		return policytermtype;
	}

	public void setPolicytermtype(String policytermtype) {
		this.policytermtype = policytermtype;
	}

	@Column(name = "POLICYTERMVALUE", length = 20)
	public String getPolicytermvalue() {
		return policytermvalue;
	}

	public void setPolicytermvalue(String policytermvalue) {
		this.policytermvalue = policytermvalue;
	}

	@Column(name = "MAXINSURANCEAMOUNT", length = 10)
	public String getMaxinsuranceamount() {
		return this.maxinsuranceamount;
	}

	public void setMaxinsuranceamount(String maxinsuranceamount) {
		this.maxinsuranceamount = maxinsuranceamount;
	}

	@Column(name = "SUMAMOUNT", precision = 14)
	public Double getSumamount() {
		return this.sumamount;
	}

	public void setSumamount(Double sumamount) {
		this.sumamount = sumamount;
	}

	@Column(name = "SUMBASEPREMIUM", precision = 14)
	public Double getSumbasepremium() {
		return this.sumbasepremium;
	}

	public void setSumbasepremium(Double sumbasepremium) {
		this.sumbasepremium = sumbasepremium;
	}

	@Column(name = "DISCOUNT", precision = 8, scale = 4)
	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@Column(name = "SUMDISCOUNT", precision = 14)
	public Double getSumdiscount() {
		return this.sumdiscount;
	}

	public void setSumdiscount(Double sumdiscount) {
		this.sumdiscount = sumdiscount;
	}

	@Column(name = "SUMPREMIUM", precision = 14)
	public Double getSumpremium() {
		return this.sumpremium;
	}

	public void setSumpremium(Double sumpremium) {
		this.sumpremium = sumpremium;
	}

	@Column(name = "SUMSUBPREMIUM", precision = 14)
	public Double getSumsubpremium() {
		return this.sumsubpremium;
	}

	public void setSumsubpremium(Double sumsubpremium) {
		this.sumsubpremium = sumsubpremium;
	}

	@Column(name = "ISPAPER", length = 2)
	public String getIspaper() {
		return this.ispaper;
	}

	public void setIspaper(String ispaper) {
		this.ispaper = ispaper;
	}

	@Column(name = "ELEADDRESS")
	public String getEleaddress() {
		return this.eleaddress;
	}

	public void setEleaddress(String eleaddress) {
		this.eleaddress = eleaddress;
	}

	@Column(name = "BUSINESSAREA", length = 50)
	public String getBusinessarea() {
		return this.businessarea;
	}

	public void setBusinessarea(String businessarea) {
		this.businessarea = businessarea;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PLATFORMINVALIDDATE", length = 19)
	public Date getPlatforminvaliddate() {
		return this.platforminvaliddate;
	}

	public void setPlatforminvaliddate(Date platforminvaliddate) {
		this.platforminvaliddate = platforminvaliddate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INPUTDATE", length = 19)
	public Date getInputdate() {
		return this.inputdate;
	}

	public void setInputdate(Date inputdate) {
		this.inputdate = inputdate;
	}

	@Column(name = "ISLEGALFLAG", length = 2)
	public String getIslegalflag() {
		return this.islegalflag;
	}

	public void setIslegalflag(String islegalflag) {
		this.islegalflag = islegalflag;
	}

	@Column(name = "STATUS", length = 2)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATETIME", length = 19)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	@Column(name = "AGENTCODE", length = 50)
	public String getAgentcode() {
		return this.agentcode;
	}

	public void setAgentcode(String agentcode) {
		this.agentcode = agentcode;
	}

	@Column(name = "AGREEMENTNO", length = 50)
	public String getAgreementno() {
		return this.agreementno;
	}

	public void setAgreementno(String agreementno) {
		this.agreementno = agreementno;
	}

	@Column(name = "AGENTNAME", length = 50)
	public String getAgentname() {
		return this.agentname;
	}

	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}

	@Column(name = "DEPARTMENTNAME", length = 50)
	public String getDepartmentname() {
		return this.departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	@Column(name = "FLAG", length = 10)
	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Column(name = "AREACODEPRO", length = 10)
	public String getAreacodepro() {
		return this.areacodepro;
	}

	public void setAreacodepro(String areacodepro) {
		this.areacodepro = areacodepro;
	}

	@Column(name = "AREACODEPROCITY", length = 10)
	public String getAreacodeprocity() {
		return areacodeprocity;
	}

	public void setAreacodeprocity(String areacodeprocity) {
		this.areacodeprocity = areacodeprocity;
	}

	@Column(name = "DISCOUNTID", length = 50)
	public String getDiscountid() {
		return this.discountid;
	}

	public void setDiscountid(String discountid) {
		this.discountid = discountid;
	}

	@Column(name = "PAYMENTSTATUS", length = 2)
	public String getPaymentstatus() {
		return this.paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	@Column(name = "PROMOTENAME", length = 50)
	public String getPromoteName() {
		return promoteName;
	}

	public void setPromoteName(String promoteName) {
		this.promoteName = promoteName;
	}

	@Column(name = "PROMOTEPHONE", length = 50)
	public String getPromotePhone() {
		return promotePhone;
	}

	public void setPromotePhone(String promotePhone) {
		this.promotePhone = promotePhone;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "YBCANCLEDATE", length = 19)
	public Date getYbcancledate() {
		return ybcancledate;
	}

	public void setYbcancledate(Date ybcancledate) {
		this.ybcancledate = ybcancledate;
	}

	@Column(name = "VEHICLEORVESSEL", length = 100)
	public String getVehicleOrVessel() {
		return vehicleOrVessel;
	}

	public void setVehicleOrVessel(String vehicleOrVessel) {
		this.vehicleOrVessel = vehicleOrVessel;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CONTRACTEFFTIME", length = 19)
	public Date getContractEfftime() {
		return contractEfftime;
	}

	public void setContractEfftime(Date contractEfftime) {
		this.contractEfftime = contractEfftime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDATE")
	public Date getCreateTime() {
		return createDate;
	}

	public void setCreateTime(Date createDate) {
		this.createDate = createDate;
	}

	@ManyToMany(mappedBy = "policy", targetEntity = cn.com.sinosoft.domain.sale.GeApplicantInsured.class)
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	public Set<GeApplicantInsured> getApplicantInsureds() {
		return applicantInsureds;
	}

	public void setApplicantInsureds(Set<GeApplicantInsured> applicantInsureds) {
		this.applicantInsureds = applicantInsureds;
	}

	@ManyToMany(targetEntity = cn.com.sinosoft.domain.sale.GeReservation.class)
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	@JoinTable(name = "GE_RESERVATION_POLICY", joinColumns = @JoinColumn(name = "POLICYNO", referencedColumnName = "policyno"), inverseJoinColumns = @JoinColumn(name = "RESERVATIONNO", referencedColumnName = "reservationNo"))
	public List<GeReservation> getGeReservations() {
		return geReservations;
	}

	public void setGeReservations(List<GeReservation> geReservations) {
		this.geReservations = geReservations;
	}

	@ManyToOne(targetEntity = cn.com.sinosoft.domain.sale.GeOrder.class)
	// 外键订单号
	@JoinColumn(name = "ORDERNO")
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	public GeOrder getOrder() {
		return order;
	}

	public void setOrder(GeOrder order) {
		this.order = order;
	}
	@Column(name = "FLOWNO")
	public String getFlowno() {
		return flowno;
	}

	public void setFlowno(String flowno) {
		this.flowno = flowno;
	}
	@Column(name = "Productname")
	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}
	@Column(name ="RECONDITION")
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	@Column(name = "preferentialcode")
	public String getPreferentialcode() {
		return preferentialcode;
	}

	public void setPreferentialcode(String preferentialcode) {
		this.preferentialcode = preferentialcode;
	}
	
	@Column(name = "STIPEND")
	public Double getStipend() {
		return stipend;
	}

	public void setStipend(Double stipend) {
		this.stipend = stipend;
	}
	@Column(name = "BOOKMONEY")
	public Double getBookmoney() {
		return bookmoney;
	}

	public void setBookmoney(Double bookmoney) {
		this.bookmoney = bookmoney;
	}
	@Column(name = "OPENID")
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Column(name = "CHARITYFLAG")
	public String getCharityflag() {
		return charityflag;
	}

	public void setCharityflag(String charityflag) {
		this.charityflag = charityflag;
	}

	@Column(name = "BRNO")
	public String getBrNo() {
		return brNo;
	}

	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	
	@Column(name = "MAINPOLICYPRE")
	public Double getMainpolicypre() {
		return mainpolicypre;
	}

	public void setMainpolicypre(Double mainpolicypre) {
		this.mainpolicypre = mainpolicypre;
	}
	
	@Column(name = "ADDITIONALPOLICYPRE")
	public Double getAdditionalpolicypre() {
		return additionalpolicypre;
	}

	public void setAdditionalpolicypre(Double additionalpolicypre) {
		this.additionalpolicypre = additionalpolicypre;
	}
	
	@Column(name = "DEPTID")
	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	@Column(name = "BILLINGTYPE")
	public String getBillingType() {
		return billingType;
	}

	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

	@Column(name = "BANKBRANCHNAME")
	public String getBankBranchName() {
		return bankBranchName;
	}

	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}

	@Column(name = "BANKPROVINCE")
	public String getBankProvince() {
		return bankProvince;
	}

	public void setBankProvince(String bankProvince) {
		this.bankProvince = bankProvince;
	}

	@Column(name = "BANKCITY")
	public String getBankCity() {
		return bankCity;
	}

	public void setBankCity(String bankCity){
		this.bankCity = bankCity;
	}

	@Column(name = "BANKBRANCHCODE")
	public String getBankBranchCode() {
		return bankBranchCode;
	}

	public void setBankBranchCode(String bankBranchCode) {
		this.bankBranchCode = bankBranchCode;
	}
	
	@Column(name = "JOBCODE", length = 20)
	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	
	@Column(name = "JOBFLAG", length = 20)
	public String getJobFlag() {
		return jobFlag;
	}
	
	public void setJobFlag(String jobFlag) {
		this.jobFlag = jobFlag;
	}
	
	
	@Column(name = "BNFNAME1", length = 20)
	public String getBnfName1() {
		return bnfName1;
	}

	public void setBnfName1(String bnfName1) {
		this.bnfName1 = bnfName1;
	}

	@Column(name = "BNFSEX1", length = 20)
	public String getBnfSex1() {
		return bnfSex1;
	}

	public void setBnfSex1(String bnfSex1) {
		this.bnfSex1 = bnfSex1;
	}
	
	@Column(name = "BNFBIRTHDAY1")
	public String getBnfBirthday1() {
		return bnfBirthday1;
	}

	public void setBnfBirthday1(String bnfBirthday1) {
		this.bnfBirthday1 = bnfBirthday1;
	}

	@Column(name = "BNFIDNO1", length = 20)
	public String getBnfIDNo1() {
		return bnfIDNo1;
	}

	public void setBnfIDNo1(String bnfIDNo1) {
		this.bnfIDNo1 = bnfIDNo1;
	}

	@Column(name = "BNFLOT1", length = 20)
	public String getBnfLot1() {
		return bnfLot1;
	}

	public void setBnfLot1(String bnfLot1) {
		this.bnfLot1 = bnfLot1;
	}

	@Column(name = "BNFNAME2", length = 20)
	public String getBnfName2() {
		return bnfName2;
	}

	public void setBnfName2(String bnfName2) {
		this.bnfName2 = bnfName2;
	}

	@Column(name = "BNFSEX2", length = 20)
	public String getBnfSex2() {
		return bnfSex2;
	}

	public void setBnfSex2(String bnfSex2) {
		this.bnfSex2 = bnfSex2;
	}

	@Column(name = "BNFBIRTHDAY2")
	public String getBnfBirthday2() {
		return bnfBirthday2;
	}

	public void setBnfBirthday2(String bnfBirthday2) {
		this.bnfBirthday2 = bnfBirthday2;
	}

	@Column(name = "BNFIDNO2", length = 20)
	public String getBnfIDNo2() {
		return bnfIDNo2;
	}

	public void setBnfIDNo2(String bnfIDNo2) {
		this.bnfIDNo2 = bnfIDNo2;
	}

	@Column(name = "BNFLOT2", length = 20)
	public String getBnfLot2() {
		return bnfLot2;
	}

	public void setBnfLot2(String bnfLot2) {
		this.bnfLot2 = bnfLot2;
	}

	@Column(name = "BNFNAME3", length = 20)
	public String getBnfName3() {
		return bnfName3;
	}

	public void setBnfName3(String bnfName3) {
		this.bnfName3 = bnfName3;
	}

	@Column(name = "BNFSEX3", length = 20)
	public String getBnfSex3() {
		return bnfSex3;
	}

	public void setBnfSex3(String bnfSex3) {
		this.bnfSex3 = bnfSex3;
	}

	@Column(name = "BNFBIRTHDAY3")
	public String getBnfBirthday3() {
		return bnfBirthday3;
	}

	public void setBnfBirthday3(String bnfBirthday3) {
		this.bnfBirthday3 = bnfBirthday3;
	}

	@Column(name = "BNFIDNO3", length = 20)
	public String getBnfIDNo3() {
		return bnfIDNo3;
	}

	public void setBnfIDNo3(String bnfIDNo3) {
		this.bnfIDNo3 = bnfIDNo3;
	}

	@Column(name = "BNFLOT3", length = 20)
	public String getBnfLot3() {
		return bnfLot3;
	}

	public void setBnfLot3(String bnfLot3) {
		this.bnfLot3 = bnfLot3;
	}

	@Column(name = "LCAPROVINCE")
	public String getLCAProvince() {
		return LCAProvince;
	}

	public void setLCAProvince(String lCAProvince) {
		LCAProvince = lCAProvince;
	}
	
	@Column(name = "LCACITY")
	public String getLCACity() {
		return LCACity;
	}

	public void setLCACity(String lCACity) {
		LCACity = lCACity;
	}

	@Column(name = "LCIPROVINCE")
	public String getLCIProvince() {
		return LCIProvince;
	}

	public void setLCIProvince(String lCIProvince) {
		LCIProvince = lCIProvince;
	}

	@Column(name = "LCICITY")
	public String getLCICity() {
		return LCICity;
	}

	public void setLCICity(String lCICity) {
		LCICity = lCICity;
	}

	@Column(name = "LCBNFCOUNT")
	public String getlCBnfCount() {
		return lCBnfCount;
	}

	public void setlCBnfCount(String lCBnfCount) {
		this.lCBnfCount = lCBnfCount;
	}
	@Column(name = "RELATIONTOINSURED1")
	public String getRelationToInsured1() {
		return relationToInsured1;
	}

	public void setRelationToInsured1(String relationToInsured1) {
		this.relationToInsured1 = relationToInsured1;
	}
	@Column(name = "RELATIONTOINSURED2")
	public String getRelationToInsured2() {
		return relationToInsured2;
	}

	public void setRelationToInsured2(String relationToInsured2) {
		this.relationToInsured2 = relationToInsured2;
	}
	@Column(name = "RELATIONTOINSURED3")
	public String getRelationToInsured3() {
		return relationToInsured3;
	}

	public void setRelationToInsured3(String relationToInsured3) {
		this.relationToInsured3 = relationToInsured3;
	}
}