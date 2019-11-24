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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * GeProductflowPage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_productflow_page")
public class GeProductflowPage implements java.io.Serializable {

	// Fields

	private String flowpageno;
	private Long defaultseqindex;
	private Date createtime;
	private Date updatetime;
	private String operator;
	private String required;
	
	private GeProductflowdefine geProductflowdefine;
	private GeProductflowpagedefine geProductflowpagedefine;
	
	private List<GeProductflowpageElement> geProductflowpageElements = new ArrayList<GeProductflowpageElement>(0);
	
	
	// Constructors

	/** default constructor */
	public GeProductflowPage() {
	}

	/** minimal constructor */
	public GeProductflowPage(String flowpageno, String operator) {
		this.flowpageno = flowpageno;
		this.operator = operator;
	}

	/** full constructor */
	public GeProductflowPage(String flowpageno, Long defaultseqindex,
			Date createtime, Date updatetime, String operator, String required) {
		this.flowpageno = flowpageno;
		this.defaultseqindex = defaultseqindex;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.operator = operator;
		this.required = required;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "FLOWPAGENO", unique = true, nullable = false)
	public String getFlowpageno() {
		return this.flowpageno;
	}

	public void setFlowpageno(String flowpageno) {
		this.flowpageno = flowpageno;
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

	@Column(name = "OPERATOR", nullable = false, length = 50)
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

	@ManyToOne(targetEntity=GeProductflowdefine.class)
	@JoinColumn(name="PRODUCTFLOWDEFINENO")
	public GeProductflowdefine getGeProductflowdefine() {
		return geProductflowdefine;
	}

	public void setGeProductflowdefine(GeProductflowdefine geProductflowdefine) {
		this.geProductflowdefine = geProductflowdefine;
	}
	
	@ManyToOne(targetEntity=GeProductflowpagedefine.class)
	@JoinColumn(name="PRODUCTFLOWPAGEDEFINENO")
	public GeProductflowpagedefine getGeProductflowpagedefine() {
		return geProductflowpagedefine;
	}

	public void setGeProductflowpagedefine(
			GeProductflowpagedefine geProductflowpagedefine) {
		this.geProductflowpagedefine = geProductflowpagedefine;
	}
	
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="geProductflowPage")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeProductflowpageElement> getGeProductflowpageElements() {
		return geProductflowpageElements;
	}

	public void setGeProductflowpageElements(
			List<GeProductflowpageElement> geProductflowpageElements) {
		this.geProductflowpageElements = geProductflowpageElements;
	}

}