package cn.com.sinosoft.domain.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;


/**
 * GeProductflowdefine entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_productflowdefine")
public class GeProductflowdefine implements java.io.Serializable {

	// Fields

	private String productflowdefineno;
	private String productflowname;
	private Date createtime;
	private Date updatetime;
	private String operator;
	private List<GeProductflowPage> geProductflowPages = new ArrayList<GeProductflowPage>(0);

	// Constructors

	/** default constructor */
	public GeProductflowdefine() {
	}

	/** full constructor */
	public GeProductflowdefine(String productflowdefineno,
			String productflowname, Date createtime, Date updatetime,
			String operator) {
		this.productflowdefineno = productflowdefineno;
		this.productflowname = productflowname;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.operator = operator;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "PRODUCTFLOWDEFINENO", unique = true, nullable = false)
	public String getProductflowdefineno() {
		return this.productflowdefineno;
	}

	public void setProductflowdefineno(String productflowdefineno) {
		this.productflowdefineno = productflowdefineno;
	}

	@Column(name = "PRODUCTFLOWNAME", nullable = false, length = 50)
	public String getProductflowname() {
		return this.productflowname;
	}

	public void setProductflowname(String productflowname) {
		this.productflowname = productflowname;
	}

	@Column(name = "CREATETIME", nullable = false, length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(name = "UPDATETIME", nullable = false, length = 19)
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

	@OneToMany(fetch=FetchType.LAZY,mappedBy="geProductflowdefine")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeProductflowPage> getGeProductflowPages() {
		return geProductflowPages;
	}

	public void setGeProductflowPages(List<GeProductflowPage> geProductflowPages) {
		this.geProductflowPages = geProductflowPages;
	}
	
	

}