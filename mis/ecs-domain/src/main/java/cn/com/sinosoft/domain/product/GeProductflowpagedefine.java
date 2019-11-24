package cn.com.sinosoft.domain.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * GeProductflowpagedefine entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_productflowpagedefine")
public class GeProductflowpagedefine implements java.io.Serializable {

	// Fields

	private String productflowpagedefineno;
	private String pagename;
	private Date createtime;
	private Date updatetime;
	private String operator;
	private List<GeProductflowPage> geProductflowPages = new ArrayList<GeProductflowPage>(0);

	// Constructors

	/** default constructor */
	public GeProductflowpagedefine() {
	}

	/** minimal constructor */
	public GeProductflowpagedefine(String productflowpagedefineno,
			String pagename, Date createtime, Date updatetime) {
		this.productflowpagedefineno = productflowpagedefineno;
		this.pagename = pagename;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}

	/** full constructor */
	public GeProductflowpagedefine(String productflowpagedefineno,
			String pagename, Date createtime, Date updatetime, String operator) {
		this.productflowpagedefineno = productflowpagedefineno;
		this.pagename = pagename;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.operator = operator;
	}

	// Property accessors
	@Id
	@Column(name = "PRODUCTFLOWPAGEDEFINENO", unique = true, nullable = false)
	public String getProductflowpagedefineno() {
		return this.productflowpagedefineno;
	}

	public void setProductflowpagedefineno(String productflowpagedefineno) {
		this.productflowpagedefineno = productflowpagedefineno;
	}

	@Column(name = "PAGENAME", nullable = false, length = 50)
	public String getPagename() {
		return this.pagename;
	}

	public void setPagename(String pagename) {
		this.pagename = pagename;
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

	@Column(name = "OPERATOR", length = 50)
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