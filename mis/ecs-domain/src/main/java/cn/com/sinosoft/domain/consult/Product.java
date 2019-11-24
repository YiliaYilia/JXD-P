package cn.com.sinosoft.domain.consult;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PRODUCT", schema = "MIS")
public class Product implements java.io.Serializable {

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
	private String updatedate;
	private String limitsameindinsuredamount;
	private BigDecimal sameindinsuredamountmax;
	private String specialagreement;
	private String operatorname;
	private String remark;
	private String isinvoice;
	private String isonline;

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(String productname) {
		this.productname = productname;
	}

	/** full constructor */
	public Product(String productname, String coreproductsimplename, String businessarea, String mininsurednum,
			String maxinsurednum, String minbeneficiarynum, String maxbeneficiarynum, String issupportpins,
			String minpinsurednum, String maxpinsurednum, String ispaper, String issupportbeneficiary,
			String issupportemergency, String effectdatetype, Date specifystartdate, Date specifyenddate,
			String delaydays, String mineffectdatelimited, String maxeffectdatelimited, String productstatus,
			String productflow, Date createdate, String updatedate, String limitsameindinsuredamount,
			BigDecimal sameindinsuredamountmax, String specialagreement, String operatorname, String remark,
			String isinvoice, String isonline) {
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
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
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

	@Temporal(TemporalType.DATE)
	@Column(name = "SPECIFYSTARTDATE", length = 7)
	public Date getSpecifystartdate() {
		return this.specifystartdate;
	}

	public void setSpecifystartdate(Date specifystartdate) {
		this.specifystartdate = specifystartdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SPECIFYENDDATE", length = 7)
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

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATEDATE", length = 7)
	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Column(name = "UPDATEDATE")
	public String getUpdatedate() {
		return this.updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	@Column(name = "LIMITSAMEINDINSUREDAMOUNT", length = 2)
	public String getLimitsameindinsuredamount() {
		return this.limitsameindinsuredamount;
	}

	public void setLimitsameindinsuredamount(String limitsameindinsuredamount) {
		this.limitsameindinsuredamount = limitsameindinsuredamount;
	}

	@Column(name = "SAMEINDINSUREDAMOUNTMAX", precision = 22, scale = 0)
	public BigDecimal getSameindinsuredamountmax() {
		return this.sameindinsuredamountmax;
	}

	public void setSameindinsuredamountmax(BigDecimal sameindinsuredamountmax) {
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

	@Column(name = "REMARK", length = 10)
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

}