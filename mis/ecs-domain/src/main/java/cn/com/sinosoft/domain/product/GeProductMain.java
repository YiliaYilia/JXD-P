package cn.com.sinosoft.domain.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * GeProductMain entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_product_main")
public class GeProductMain implements java.io.Serializable {

	// Fields

	private String coreproductcode;
	private String productname;
	private String coreproductsimplename;
	private String businessarea;
	private String mininsurednum;
	private String maxinsurednum;
	private String minbeneficiarynum;
	private String maxbeneficiarynum;
	private String issupportpins;
	private String minpinsurednum;
	private String maxpinsurednum;
	private String ispaper;
	private String issupportbeneficiary;
	private String issupportemergency;
	private String effectdatetype;
	private Date specifystartdate;
	private Date specifyenddate;
	private String delaydays;
	private String mineffectdatelimited;
	private String maxeffectdatelimited;
	private String productstatus;
	private String productflow;
	private Date createdate;
	private Date updatedate;
	private String limitsameindinsuredamount;
	private Long sameindinsuredamountmax;
	private String specialagreement;
	private String operatorname;
	private String remark;
	private String isinvoice;
	private String isonline;
	private String paytype;//缴费方式
	
	private GeWebflow geWebflow;
	/** 属性geWebFlowPageElements */
	private List<GeWebflowpageelement> geWebFlowPageElements = new ArrayList<GeWebflowpageelement>(0);
	private List<GeInsurancePlan> geInsurancePlans = new ArrayList<GeInsurancePlan>(0);
	private List<GeProductOtherconfig> geProductOtherconfigs =new ArrayList<GeProductOtherconfig>(0);
	private List<GeRiskSurvey> geRiskSurveys = new ArrayList<GeRiskSurvey>(0);
	private List<GeProductInformbook> geProductInformbooks = new ArrayList<GeProductInformbook>(0);
	/**
	 * 服务区域
	 */
	private List<GeSaleArea> geSaleAreas = new ArrayList<GeSaleArea>(0);
	
	
	/** 属产品险种配置 */
	private List<GeProductrisk> geProductRisks = new ArrayList<GeProductrisk>(0);
	
	/** 属性产品责任 */
	private List<GeProductduty> geProductduties = new ArrayList<GeProductduty>(0);
	
	
	/** 属性产品扩展字段 -保险年限*/
	private List<GeProductExtend> geProductExtends = new ArrayList<GeProductExtend>(0);
	
	/** 属性产品扩展字段 -保险期间*/
	private List<GeProductExtendPeriod> geProductExtendsPeriods = new ArrayList<GeProductExtendPeriod>(0);
	
	
	//产品投保人配置信息
	private GeProductApplicantconfig geProductApplicantconfig;
	//产品被保人配置信息
	private GeProductInsuredconfig geProductInsuredconfig;
	//产品受益人配置信息
	private GeProductBeneficiaryconfig geProductBeneficiaryconfig;
	//产品紧急联系人配置信息
	private GeProductEmergencyConfig geProductEmergencyConfig;
	//产品收件人（包含地址）配置信息
	private GeAddresseeConfig geAddresseeConfig;
	
	// Constructors

	/** default constructor */
	public GeProductMain() {
	}

	/** minimal constructor */
	public GeProductMain(String coreproductcode, String productname,
			Date updatedate) {
		this.coreproductcode = coreproductcode;
		this.productname = productname;
		this.updatedate = updatedate;
	}

	/** full constructor */
	public GeProductMain(String coreproductcode, String productname,
			String coreproductsimplename, String businessarea,
			String mininsurednum, String maxinsurednum,
			String minbeneficiarynum, String maxbeneficiarynum,
			String issupportpins, String minpinsurednum, String maxpinsurednum,
			String ispaper, String issupportbeneficiary,
			String issupportemergency, String effectdatetype,
			Date specifystartdate, Date specifyenddate, String delaydays,
			String mineffectdatelimited, String maxeffectdatelimited,
			String productstatus, String productflow, Date createdate,
			Date updatedate, String limitsameindinsuredamount,
			Long sameindinsuredamountmax, String specialagreement,
			String operatorname, String remark, String isinvoice,
			String isonline,String paytype) {
		this.coreproductcode = coreproductcode;
		this.productname = productname;
		this.coreproductsimplename = coreproductsimplename;
		this.businessarea = businessarea;
		this.mininsurednum = mininsurednum;
		this.maxinsurednum = maxinsurednum;
		this.minbeneficiarynum = minbeneficiarynum;
		this.maxbeneficiarynum = maxbeneficiarynum;
		this.issupportpins = issupportpins;
		this.minpinsurednum = minpinsurednum;
		this.maxpinsurednum = maxpinsurednum;
		this.ispaper = ispaper;
		this.issupportbeneficiary = issupportbeneficiary;
		this.issupportemergency = issupportemergency;
		this.effectdatetype = effectdatetype;
		this.specifystartdate = specifystartdate;
		this.specifyenddate = specifyenddate;
		this.delaydays = delaydays;
		this.mineffectdatelimited = mineffectdatelimited;
		this.maxeffectdatelimited = maxeffectdatelimited;
		this.productstatus = productstatus;
		this.productflow = productflow;
		this.createdate = createdate;
		this.updatedate = updatedate;
		this.limitsameindinsuredamount = limitsameindinsuredamount;
		this.sameindinsuredamountmax = sameindinsuredamountmax;
		this.specialagreement = specialagreement;
		this.operatorname = operatorname;
		this.remark = remark;
		this.isinvoice = isinvoice;
		this.isonline = isonline;
		this.paytype  = paytype;
	}

	// Property accessors
	@Id
	@Column(name = "COREPRODUCTCODE", unique = true, nullable = false)
	public String getCoreproductcode() {
		return this.coreproductcode;
	}

	public void setCoreproductcode(String coreproductcode) {
		this.coreproductcode = coreproductcode;
	}

	@Column(name = "PRODUCTNAME", nullable = false, length = 100)
	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	@Column(name = "COREPRODUCTSIMPLENAME", length = 50)
	public String getCoreproductsimplename() {
		return this.coreproductsimplename;
	}

	public void setCoreproductsimplename(String coreproductsimplename) {
		this.coreproductsimplename = coreproductsimplename;
	}

	@Column(name = "BUSINESSAREA", length = 50)
	public String getBusinessarea() {
		return this.businessarea;
	}

	public void setBusinessarea(String businessarea) {
		this.businessarea = businessarea;
	}

	@Column(name = "MININSUREDNUM", length = 2)
	public String getMininsurednum() {
		return this.mininsurednum;
	}

	public void setMininsurednum(String mininsurednum) {
		this.mininsurednum = mininsurednum;
	}

	@Column(name = "MAXINSUREDNUM", length = 2)
	public String getMaxinsurednum() {
		return this.maxinsurednum;
	}

	public void setMaxinsurednum(String maxinsurednum) {
		this.maxinsurednum = maxinsurednum;
	}

	@Column(name = "MINBENEFICIARYNUM", length = 2)
	public String getMinbeneficiarynum() {
		return this.minbeneficiarynum;
	}

	public void setMinbeneficiarynum(String minbeneficiarynum) {
		this.minbeneficiarynum = minbeneficiarynum;
	}

	@Column(name = "MAXBENEFICIARYNUM", length = 2)
	public String getMaxbeneficiarynum() {
		return this.maxbeneficiarynum;
	}

	public void setMaxbeneficiarynum(String maxbeneficiarynum) {
		this.maxbeneficiarynum = maxbeneficiarynum;
	}

	@Column(name = "ISSUPPORTPINS", length = 2)
	public String getIssupportpins() {
		return this.issupportpins;
	}

	public void setIssupportpins(String issupportpins) {
		this.issupportpins = issupportpins;
	}

	@Column(name = "MINPINSUREDNUM", length = 2)
	public String getMinpinsurednum() {
		return this.minpinsurednum;
	}

	public void setMinpinsurednum(String minpinsurednum) {
		this.minpinsurednum = minpinsurednum;
	}

	@Column(name = "MAXPINSUREDNUM", length = 2)
	public String getMaxpinsurednum() {
		return this.maxpinsurednum;
	}

	public void setMaxpinsurednum(String maxpinsurednum) {
		this.maxpinsurednum = maxpinsurednum;
	}

	@Column(name = "ISPAPER", length = 2)
	public String getIspaper() {
		return this.ispaper;
	}

	public void setIspaper(String ispaper) {
		this.ispaper = ispaper;
	}

	@Column(name = "ISSUPPORTBENEFICIARY", length = 2)
	public String getIssupportbeneficiary() {
		return this.issupportbeneficiary;
	}

	public void setIssupportbeneficiary(String issupportbeneficiary) {
		this.issupportbeneficiary = issupportbeneficiary;
	}

	@Column(name = "ISSUPPORTEMERGENCY", length = 2)
	public String getIssupportemergency() {
		return this.issupportemergency;
	}

	public void setIssupportemergency(String issupportemergency) {
		this.issupportemergency = issupportemergency;
	}

	@Column(name = "EFFECTDATETYPE", length = 2)
	public String getEffectdatetype() {
		return this.effectdatetype;
	}

	public void setEffectdatetype(String effectdatetype) {
		this.effectdatetype = effectdatetype;
	}

	
	@Column(name = "SPECIFYSTARTDATE", length = 19)
	public Date getSpecifystartdate() {
		return this.specifystartdate;
	}

	public void setSpecifystartdate(Date specifystartdate) {
		this.specifystartdate = specifystartdate;
	}

	
	@Column(name = "SPECIFYENDDATE", length = 19)
	public Date getSpecifyenddate() {
		return this.specifyenddate;
	}

	public void setSpecifyenddate(Date specifyenddate) {
		this.specifyenddate = specifyenddate;
	}

	@Column(name = "DELAYDAYS", length = 3)
	public String getDelaydays() {
		return this.delaydays;
	}

	public void setDelaydays(String delaydays) {
		this.delaydays = delaydays;
	}

	@Column(name = "MINEFFECTDATELIMITED", length = 3)
	public String getMineffectdatelimited() {
		return this.mineffectdatelimited;
	}

	public void setMineffectdatelimited(String mineffectdatelimited) {
		this.mineffectdatelimited = mineffectdatelimited;
	}

	@Column(name = "MAXEFFECTDATELIMITED", length = 3)
	public String getMaxeffectdatelimited() {
		return this.maxeffectdatelimited;
	}

	public void setMaxeffectdatelimited(String maxeffectdatelimited) {
		this.maxeffectdatelimited = maxeffectdatelimited;
	}

	@Column(name = "PRODUCTSTATUS", length = 2)
	public String getProductstatus() {
		return this.productstatus;
	}

	public void setProductstatus(String productstatus) {
		this.productstatus = productstatus;
	}

	@Column(name = "PRODUCTFLOW", length = 200)
	public String getProductflow() {
		return this.productflow;
	}

	public void setProductflow(String productflow) {
		this.productflow = productflow;
	}

	
	@Column(name = "CREATEDATE", length = 10)
	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	
	@Column(name = "UPDATEDATE", nullable = false, length = 19)
	public Date getUpdatedate() {
		return this.updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	@Column(name = "LIMITSAMEINDINSUREDAMOUNT", length = 2)
	public String getLimitsameindinsuredamount() {
		return this.limitsameindinsuredamount;
	}

	public void setLimitsameindinsuredamount(String limitsameindinsuredamount) {
		this.limitsameindinsuredamount = limitsameindinsuredamount;
	}

	@Column(name = "SAMEINDINSUREDAMOUNTMAX", precision = 8, scale = 0)
	public Long getSameindinsuredamountmax() {
		return this.sameindinsuredamountmax;
	}

	public void setSameindinsuredamountmax(Long sameindinsuredamountmax) {
		this.sameindinsuredamountmax = sameindinsuredamountmax;
	}

	@Column(name = "SPECIALAGREEMENT", length = 500)
	public String getSpecialagreement() {
		return this.specialagreement;
	}

	public void setSpecialagreement(String specialagreement) {
		this.specialagreement = specialagreement;
	}

	@Column(name = "OPERATORNAME", length = 50)
	public String getOperatorname() {
		return this.operatorname;
	}

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "ISINVOICE", length = 2)
	public String getIsinvoice() {
		return this.isinvoice;
	}

	public void setIsinvoice(String isinvoice) {
		this.isinvoice = isinvoice;
	}

	@Column(name = "ISONLINE", length = 2)
	public String getIsonline() {
		return this.isonline;
	}

	public void setIsonline(String isonline) {
		this.isonline = isonline;
	}

	@Column(name = "PAYTYPE", nullable = false, length = 10)
	public String getPaytype() {
		return this.paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="geProductMain")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public GeWebflow getGeWebflow() {
		return geWebflow;
	}

	public void setGeWebflow(GeWebflow geWebflow) {
		this.geWebflow = geWebflow;
	}


	@OneToOne(fetch=FetchType.LAZY,mappedBy="geProductMain")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public GeProductApplicantconfig getGeProductApplicantconfig() {
		return geProductApplicantconfig;
	}

	public void setGeProductApplicantconfig(
			GeProductApplicantconfig geProductApplicantconfig) {
		this.geProductApplicantconfig = geProductApplicantconfig;
	}


	@OneToOne(fetch=FetchType.LAZY,mappedBy="geProductMain")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public GeProductBeneficiaryconfig getGeProductBeneficiaryconfig() {
		return geProductBeneficiaryconfig;
	}

	
	public void setGeProductBeneficiaryconfig(
			GeProductBeneficiaryconfig geProductBeneficiaryconfig) {
		this.geProductBeneficiaryconfig = geProductBeneficiaryconfig;
	}


	@OneToOne(fetch=FetchType.LAZY,mappedBy="geProductMain")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public GeProductInsuredconfig getGeProductInsuredconfig() {
		return geProductInsuredconfig;
	}


	
	public void setGeProductInsuredconfig(
			GeProductInsuredconfig geProductInsuredconfig) {
		this.geProductInsuredconfig = geProductInsuredconfig;
	}

	@OneToOne(fetch=FetchType.LAZY,mappedBy="geProductMain")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public GeProductEmergencyConfig getGeProductEmergencyConfig() {
		return geProductEmergencyConfig;
	}



	public void setGeProductEmergencyConfig(
			GeProductEmergencyConfig geProductEmergencyConfig) {
		this.geProductEmergencyConfig = geProductEmergencyConfig;
	}

	@OneToOne(fetch=FetchType.LAZY,mappedBy="geProductMain")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public GeAddresseeConfig getGeAddresseeConfig() {
		return geAddresseeConfig;
	}

	public void setGeAddresseeConfig(GeAddresseeConfig geAddresseeConfig) {
		this.geAddresseeConfig = geAddresseeConfig;
	}
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="geProductMain")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeInsurancePlan> getGeInsurancePlans() {
		return geInsurancePlans;
	}

	public void setGeInsurancePlans(List<GeInsurancePlan> geInsurancePlans) {
		this.geInsurancePlans = geInsurancePlans;
	}
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="geProductMain")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeProductOtherconfig> getGeProductOtherconfigs() {
		return geProductOtherconfigs;
	}

	public void setGeProductOtherconfigs(
			List<GeProductOtherconfig> geProductOtherconfigs) {
		this.geProductOtherconfigs = geProductOtherconfigs;
	}
	
	

	@OneToMany(fetch=FetchType.LAZY, mappedBy="geProductMain")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeRiskSurvey> getGeRiskSurveys() {
		return geRiskSurveys;
	}

	public void setGeRiskSurveys(List<GeRiskSurvey> geRiskSurveys) {
		this.geRiskSurveys = geRiskSurveys;
	}
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="geProductMain")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeProductInformbook> getGeProductInformbooks() {
		return geProductInformbooks;
	}

	public void setGeProductInformbooks(
			List<GeProductInformbook> geProductInformbooks) {
		this.geProductInformbooks = geProductInformbooks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "geProductMain")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeProductrisk> getGeProductRisks() {
		return geProductRisks;
	}

	public void setGeProductRisks(List<GeProductrisk> geProductRisks) {
		this.geProductRisks = geProductRisks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "geProductMain")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeProductduty> getGeProductduties() {
		return geProductduties;
	}

	public void setGeProductduties(List<GeProductduty> geProductduties) {
		this.geProductduties = geProductduties;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "geProductMain")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeWebflowpageelement> getGeWebFlowPageElements() {
		return geWebFlowPageElements;
	}

	public void setGeWebFlowPageElements(
			List<GeWebflowpageelement> geWebFlowPageElements) {
		this.geWebFlowPageElements = geWebFlowPageElements;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "geProductMain")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeProductExtend> getGeProductExtends() {
		return geProductExtends;
	}

	public void setGeProductExtends(List<GeProductExtend> geProductExtends) {
		this.geProductExtends = geProductExtends;
	}
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "geProductMain")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeProductExtendPeriod> getGeProductExtendsPeriods() {
		return geProductExtendsPeriods;
	}

	public void setGeProductExtendsPeriods(
			List<GeProductExtendPeriod> geProductExtendsPeriods) {
		this.geProductExtendsPeriods = geProductExtendsPeriods;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "geProductMain")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeSaleArea> getGeSaleAreas() {
		return geSaleAreas;
	}

	public void setGeSaleAreas(List<GeSaleArea> geSaleAreas) {
		this.geSaleAreas = geSaleAreas;
	}
	
}