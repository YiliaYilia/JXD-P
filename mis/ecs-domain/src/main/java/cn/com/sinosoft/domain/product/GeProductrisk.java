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
 * GeProductrisk entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_productrisk")
public class GeProductrisk implements java.io.Serializable {

	// Fields

	private String productriskno;
	private String productriskcode;
	private String productriskname;
	private String riskcode;
	private Long seqindex;
	private String isshowproductduty;
	private String saleflag;
	private Date createtime;
	private Date updatetime;
	
	private GeProductMain geProductMain;
	
	/** 属产品险种责任 */
	private List<GeProductduty> geProductdutys = new ArrayList<GeProductduty>(0);

	// Constructors

	/** default constructor */
	public GeProductrisk() {
	}

	/** minimal constructor */
	public GeProductrisk(String productriskno, String productriskcode) {
		this.productriskno = productriskno;
		this.productriskcode = productriskcode;
	}

	/** full constructor */
	public GeProductrisk(String productriskno, String productriskcode,
			String productriskname, String riskcode, Long seqindex,
			String isshowproductduty, String saleflag, Date createtime,
			Date updatetime) {
		this.productriskno = productriskno;
		this.productriskcode = productriskcode;
		this.productriskname = productriskname;
		this.riskcode = riskcode;
		this.seqindex = seqindex;
		this.isshowproductduty = isshowproductduty;
		this.saleflag = saleflag;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "PRODUCTRISKNO", unique = true, nullable = false)
	public String getProductriskno() {
		return this.productriskno;
	}

	public void setProductriskno(String productriskno) {
		this.productriskno = productriskno;
	}

	@Column(name = "PRODUCTRISKCODE", nullable = false)
	public String getProductriskcode() {
		return this.productriskcode;
	}

	public void setProductriskcode(String productriskcode) {
		this.productriskcode = productriskcode;
	}

	@Column(name = "PRODUCTRISKNAME")
	public String getProductriskname() {
		return this.productriskname;
	}

	public void setProductriskname(String productriskname) {
		this.productriskname = productriskname;
	}

	@Column(name = "RISKCODE", length = 50)
	public String getRiskcode() {
		return this.riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode;
	}

	@Column(name = "SEQINDEX", precision = 8, scale = 0)
	public Long getSeqindex() {
		return this.seqindex;
	}

	public void setSeqindex(Long seqindex) {
		this.seqindex = seqindex;
	}

	@Column(name = "ISSHOWPRODUCTDUTY", length = 2)
	public String getIsshowproductduty() {
		return this.isshowproductduty;
	}

	public void setIsshowproductduty(String isshowproductduty) {
		this.isshowproductduty = isshowproductduty;
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
	@JoinColumn(name="COREPRODUCTCODE")
	public GeProductMain getGeProductMain() {
		return geProductMain;
	}

	public void setGeProductMain(GeProductMain geProductMain) {
		this.geProductMain = geProductMain;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "geProductrisk")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeProductduty> getGeProductdutys() {
		return geProductdutys;
	}

	public void setGeProductdutys(List<GeProductduty> geProductdutys) {
		this.geProductdutys = geProductdutys;
	}

	
	
}