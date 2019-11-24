package cn.com.sinosoft.domain.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * GeProductduty entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_productduty")
public class GeProductduty implements java.io.Serializable {

	// Fields

	private String productdutyno;
	private String productdutycode;
	private String productdutyname;
	private Long period;
	private String periodtype;
	private String premium;
	private Long insuredamount;
	private Long maxriskinsuredamount;
	private String dutyserialno;
	private Long seqindex;
	private String iseditable;
	private String saleflag;
	private Date createtime;
	private Date updatetime;
	
	private GeProductrisk geProductrisk;
	
	private GeProductMain geProductMain;
	
	/** 属产品责任扩展 */
	private List<GeProdutyExtend> geProdutyExtends = new ArrayList<GeProdutyExtend>(0);

	// Constructors

	/** default constructor */
	public GeProductduty() {
	}

	/** minimal constructor */
	public GeProductduty(String productdutyno, String productdutycode,
			String productdutyname) {
		this.productdutyno = productdutyno;
		this.productdutycode = productdutycode;
		this.productdutyname = productdutyname;
	}

	/** full constructor */
	public GeProductduty(String productdutyno, String productdutycode,
			String productdutyname, Long period, String periodtype,
			String premium, Long insuredamount, Long maxriskinsuredamount,
			String dutyserialno, Long seqindex,
			String iseditable, String saleflag, Date createtime,
			Date updatetime) {
		this.productdutyno = productdutyno;
		this.productdutycode = productdutycode;
		this.productdutyname = productdutyname;
		this.period = period;
		this.periodtype = periodtype;
		this.premium = premium;
		this.insuredamount = insuredamount;
		this.maxriskinsuredamount = maxriskinsuredamount;
		this.dutyserialno = dutyserialno;
		this.seqindex = seqindex;
		this.iseditable = iseditable;
		this.saleflag = saleflag;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "PRODUCTDUTYNO", unique = true, nullable = false)
	public String getProductdutyno() {
		return this.productdutyno;
	}

	public void setProductdutyno(String productdutyno) {
		this.productdutyno = productdutyno;
	}

	@Column(name = "PRODUCTDUTYCODE", nullable = false)
	public String getProductdutycode() {
		return this.productdutycode;
	}

	public void setProductdutycode(String productdutycode) {
		this.productdutycode = productdutycode;
	}

	@Column(name = "PRODUCTDUTYNAME", nullable = false, length = 250)
	public String getProductdutyname() {
		return this.productdutyname;
	}

	public void setProductdutyname(String productdutyname) {
		this.productdutyname = productdutyname;
	}

	@Column(name = "PERIOD", precision = 8, scale = 0)
	public Long getPeriod() {
		return this.period;
	}

	public void setPeriod(Long period) {
		this.period = period;
	}

	@Column(name = "PERIODTYPE", length = 2)
	public String getPeriodtype() {
		return this.periodtype;
	}

	public void setPeriodtype(String periodtype) {
		this.periodtype = periodtype;
	}

	@Column(name = "PREMIUM", length = 50)
	public String getPremium() {
		return this.premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	@Column(name = "INSUREDAMOUNT", precision = 8, scale = 0)
	public Long getInsuredamount() {
		return this.insuredamount;
	}

	public void setInsuredamount(Long insuredamount) {
		this.insuredamount = insuredamount;
	}

	@Column(name = "MAXRISKINSUREDAMOUNT", precision = 8, scale = 0)
	public Long getMaxriskinsuredamount() {
		return this.maxriskinsuredamount;
	}

	public void setMaxriskinsuredamount(Long maxriskinsuredamount) {
		this.maxriskinsuredamount = maxriskinsuredamount;
	}

	@Column(name = "DUTYSERIALNO", length = 50)
	public String getDutyserialno() {
		return this.dutyserialno;
	}

	public void setDutyserialno(String dutyserialno) {
		this.dutyserialno = dutyserialno;
	}

	@Column(name = "SEQINDEX", precision = 8, scale = 0)
	public Long getSeqindex() {
		return this.seqindex;
	}

	public void setSeqindex(Long seqindex) {
		this.seqindex = seqindex;
	}

	@Column(name = "ISEDITABLE", length = 2)
	public String getIseditable() {
		return this.iseditable;
	}

	public void setIseditable(String iseditable) {
		this.iseditable = iseditable;
	}

	@Column(name = "SALEFLAG", length = 2)
	public String getSaleflag() {
		return this.saleflag;
	}

	public void setSaleflag(String saleflag) {
		this.saleflag = saleflag;
	}

	
	@Column(name = "CREATETIME", length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	
	@Column(name = "UPDATETIME", length = 19)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	@ManyToOne
	@JoinColumn(name="PRODUCTRISKSERIALNO")
	public GeProductrisk getGeProductrisk() {
		return geProductrisk;
	}

	public void setGeProductrisk(GeProductrisk geProductrisk) {
		this.geProductrisk = geProductrisk;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "geProductduty")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeProdutyExtend> getGeProdutyExtends() {
		return geProdutyExtends;
	}

	public void setGeProdutyExtends(List<GeProdutyExtend> geProdutyExtends) {
		this.geProdutyExtends = geProdutyExtends;
	}
	
	@ManyToOne
	@JoinColumn(name="COREPRODUCTCODE")
	public GeProductMain getGeProductMain() {
		return geProductMain;
	}

	public void setGeProductMain(GeProductMain geProductMain) {
		this.geProductMain = geProductMain;
	}

}