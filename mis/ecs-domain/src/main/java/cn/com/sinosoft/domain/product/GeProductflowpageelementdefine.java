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
 * GeProductflowpageeelementdefine entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_productflowpageeledefine")
public class GeProductflowpageelementdefine implements java.io.Serializable {

	// Fields

	private String productflowpageelementdefineno;
	private String elementname;
	private String handleurl;
	private Date createtime;
	private Date updatetime;
	private String operator;
	
	private List<GeProductflowpageElement> geProductflowpageElements = new ArrayList<GeProductflowpageElement>(0);

	// Constructors

	/** default constructor */
	public GeProductflowpageelementdefine() {
	}

	/** minimal constructor */
	public GeProductflowpageelementdefine(
			String productflowpageeelementdefineno) {
		this.productflowpageelementdefineno = productflowpageeelementdefineno;
	}

	/** full constructor */
	public GeProductflowpageelementdefine(
			String productflowpageelementdefineno, String elementname,
			String handleurl, Date createtime, Date updatetime, String operator) {
		this.productflowpageelementdefineno = productflowpageelementdefineno;
		this.elementname = elementname;
		this.handleurl = handleurl;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.operator = operator;
	}

	// Property accessors
	@Id
	@Column(name = "PAGEEELEMENTDEFINENO", unique = true, nullable = false)
	public String getProductflowpageelementdefineno() {
		return this.productflowpageelementdefineno;
	}

	public void setProductflowpageelementdefineno(
			String productflowpageelementdefineno) {
		this.productflowpageelementdefineno = productflowpageelementdefineno;
	}

	@Column(name = "ELEMENTNAME", length = 50)
	public String getElementname() {
		return this.elementname;
	}

	public void setElementname(String elementname) {
		this.elementname = elementname;
	}

	@Column(name = "HANDLEURL", length = 200)
	public String getHandleurl() {
		return this.handleurl;
	}

	public void setHandleurl(String handleurl) {
		this.handleurl = handleurl;
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

	@OneToMany(fetch=FetchType.LAZY,mappedBy="geProductflowpageelementdefine")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeProductflowpageElement> getGeProductflowpageElements() {
		return geProductflowpageElements;
	}

	public void setGeProductflowpageElements(
			List<GeProductflowpageElement> geProductflowpageElements) {
		this.geProductflowpageElements = geProductflowpageElements;
	}

}