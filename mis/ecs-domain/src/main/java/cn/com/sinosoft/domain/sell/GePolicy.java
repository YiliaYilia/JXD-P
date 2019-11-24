package cn.com.sinosoft.domain.sell;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	private String policyno;
	private String applicantcode;
	private String policycode;
	//private String prodoctcode;
	private String riskcode;
	private String classcode;
	private String areacode;
	private String salecom;
	private Date insuretime;
	private String applicantname;      //投保人姓名
	private String applicantaddress;   //投保人地址
	private String insuredname;       //被保人姓名
	private String insuredaddress;    //被保人地址
	private String renewalflag;
	private String oldlpolicyno;
	private Date takeeffecttime;
	private Date deadlinetime;
	private String unitcount;
	private String policyterm;
	private String maxinsuranceamount;
	private Double sumamount;
	private Double sumbasepremium;
	private Double discount;
	private Double sumdiscount;
	private Double sumpremium;
	private Double sumsubpremium;
	private String ispaper;
	private String eleaddress;
	private String businessarea;
	private Date platforminvaliddate;
	private Date inputdate;
	private String islegalflag;
	private String status;
	private Date updatetime;
	private String agentcode;
	private String agreementno;
	private String agentname;
	private String departmentname;
	private String flag;
	private String areacodepro;
	private String discountid;
	private String paymentstatus;
	private String condition; //对账状态0未对账 ，1对账成功，2对账失败
	private String productname; //
	private String preferentialcode; //
	private String flowno; //
	private String bank; //
	private String bankaccountnumber; //
	private Date starttime;
	private Date endtime;
	private String charityflag;
	private String brno;  //渠道编码
	private String deptid;//机构代码
	
//	private GeProductMain geProductMain;
	private Set<GeOrder> orders;
	private Set<GeRiskduty> riskDuties;
	private Set<GeBeneficiary> beneficiaries;
	private Set<GeApplicantinsured> applicantinsureds;
	private GePaymentInfo paymentInfo;
	private Set<GeAccountInfo> accountInfos;
	// Constructors

	
	
	/** default constructor */
	public GePolicy() {
	}

	@OneToOne(mappedBy="policy",targetEntity=GePaymentInfo.class)
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
			String insuredaddress, String renewalflag,
			String oldlpolicyno, Date takeeffecttime, Date deadlinetime,
			String unitcount, String policyterm, String maxinsuranceamount,
			Double sumamount, Double sumbasepremium, Double discount,
			Double sumdiscount, Double sumpremium, Double sumsubpremium,
			String ispaper, String eleaddress, String businessarea,
			Date platforminvaliddate, Date inputdate, String islegalflag,
			String status, Date updatetime, String agentcode,
			String agreementno, String agentname, String departmentname,
			String flag, String areacodepro, String discountid,
			String paymentstatus) {
		this.policyno = policyno;
		this.applicantcode = applicantcode;
		this.policycode = policycode;
		//this.prodoctcode = prodoctcode;
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
		this.discountid = discountid;
		this.paymentstatus = paymentstatus;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "POLICYNO", unique = true, nullable = false)
	public String getPolicyno() {
		return this.policyno;
	}

	
	@ManyToMany( mappedBy = "policy", targetEntity = GeApplicantinsured.class)
	@Cascade(value={CascadeType.SAVE_UPDATE})
	public Set<GeApplicantinsured> getApplicantinsureds() {
		return applicantinsureds;
	}

	public void setApplicantinsureds(Set<GeApplicantinsured> applicantinsureds) {
		this.applicantinsureds = applicantinsureds;
	}

	@OneToMany(mappedBy="policy",targetEntity = GeBeneficiary.class)
	@Cascade(value={CascadeType.SAVE_UPDATE})
	public Set<GeBeneficiary> getBeneficiaries() {
		return beneficiaries;
	}
	@OneToMany(mappedBy="policy",targetEntity = GeAccountInfo.class)
	@Cascade(value={CascadeType.SAVE_UPDATE})
	public Set<GeAccountInfo> getAccountInfos() {
		return accountInfos;
	}

	public void setAccountInfos(Set<GeAccountInfo> accountInfos) {
		this.accountInfos = accountInfos;
	}

	public void setBeneficiaries(Set<GeBeneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	@OneToMany(mappedBy="policy" ,targetEntity = GeRiskduty.class)
	@Cascade(value={CascadeType.SAVE_UPDATE})
	public Set<GeRiskduty> getRiskDuties() {
		return riskDuties;
	}

	public void setRiskDuties(Set<GeRiskduty> riskDuties) {
		this.riskDuties = riskDuties;
	}

	@ManyToMany(mappedBy = "policys", targetEntity = GeOrder.class)
	@Cascade({CascadeType.SAVE_UPDATE})
	public Set<GeOrder> getOrders() {
		return orders;
	}

	public void setOrders(Set<GeOrder> orders) {
		this.orders = orders;
	}

	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}

	@Column(name = "APPLICANTCODE", nullable = false, length = 50)
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

//	@Column(name = "PRODOCTCODE", length = 50)
//	public String getProdoctcode() {
//		return this.prodoctcode;
//	}
//
//	public void setProdoctcode(String prodoctcode) {
//		this.prodoctcode = prodoctcode;
//	}

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

	@Temporal(TemporalType.DATE)
	@Column(name = "PLATFORMINVALIDDATE", length = 19)
	public Date getPlatforminvaliddate() {
		return this.platforminvaliddate;
	}

	public void setPlatforminvaliddate(Date platforminvaliddate) {
		this.platforminvaliddate = platforminvaliddate;
	}

	@Temporal(TemporalType.DATE)
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

	@Temporal(TemporalType.DATE)
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

	@Column(name = "RECONDITION")
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	@Column(name = "PRODUCTNAME")
	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}
	@Column(name = "starttime")
	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	@Column(name = "endtime")
	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	@Column(name = "preferentialcode")
	public String getPreferentialcode() {
		return preferentialcode;
	}

	public void setPreferentialcode(String preferentialcode) {
		this.preferentialcode = preferentialcode;
	}
	@Column(name = "flowno")
	public String getFlowno() {
		return flowno;
	}

	public void setFlowno(String flowno) {
		this.flowno = flowno;
	}
	
	@Column(name = "bank")
	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}
	@Column(name = "bankaccountnumber")
	public String getBankaccountnumber() {
		return bankaccountnumber;
	}

	public void setBankaccountnumber(String bankaccountnumber) {
		this.bankaccountnumber = bankaccountnumber;
	}

	@Column(name = "charityflag")
	public String getCharityflag() {
		return charityflag;
	}

	public void setCharityflag(String charityflag) {
		this.charityflag = charityflag;
	}
	
	@Column(name = "brno")
	public String getBrno() {
		return brno;
	}

	public void setBrno(String brno) {
		this.brno = brno;
	}

	@Column(name = "deptid")
	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

}