package cn.com.sinosoft.domain.product;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * GeProductflowpageElement entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_productflowpage_element")
public class GeProductflowpageElement implements java.io.Serializable {

	// Fields

	private String pageelementno;
	private Long defaultseqindex;
	private Date createtime;
	private Date updatetime;
	private String operator;
	private String required;
	private GeProductflowPage geProductflowPage;
	private GeProductflowpageelementdefine geProductflowpageelementdefine;

	// Constructors

	/** default constructor */
	public GeProductflowpageElement() {
	}

	/** minimal constructor */
	public GeProductflowpageElement(String pageelementno) {
		this.pageelementno = pageelementno;
	}

	/** full constructor */
	public GeProductflowpageElement(String pageelementno, Long defaultseqindex,
			Date createtime, Date updatetime, String operator, String required) {
		this.pageelementno = pageelementno;
		this.defaultseqindex = defaultseqindex;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.operator = operator;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "PAGEELEMENTNO", unique = true, nullable = false)
	public String getPageelementno() {
		return this.pageelementno;
	}

	public void setPageelementno(String pageelementno) {
		this.pageelementno = pageelementno;
	}

	@Column(name = "DEFAULTSEQINDEX", precision = 8, scale = 0)
	public Long getDefaultseqindex() {
		return this.defaultseqindex;
	}

	public void setDefaultseqindex(Long defaultseqindex) {
		this.defaultseqindex = defaultseqindex;
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

	@Column(name = "OPERATOR", length = 50)
	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Column(name = "REQUIRED", length = 2)
	public String getRequired() {
		return this.required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	
	
	@ManyToOne
	@JoinColumn(name="FLOWPAGENO")
	public GeProductflowPage getGeProductflowPage() {
		return geProductflowPage;
	}

	public void setGeProductflowPage(GeProductflowPage geProductflowPage) {
		this.geProductflowPage = geProductflowPage;
	}

	@ManyToOne(targetEntity=GeProductflowpageelementdefine.class)
	@JoinColumn(name="PAGEEELEMENTDEFINENO")
	public GeProductflowpageelementdefine getGeProductflowpageelementdefine() {
		return geProductflowpageelementdefine;
	}

	public void setGeProductflowpageelementdefine(
			GeProductflowpageelementdefine geProductflowpageelementdefine) {
		this.geProductflowpageelementdefine = geProductflowpageelementdefine;
	}

}