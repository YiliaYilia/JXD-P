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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * GeWebflow entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_webflow")
public class GeWebflow implements java.io.Serializable {

	// Fields

	private String webflowno;
	private String webflowcode;
	private Date createtime;
	private Date updatetime;
	private GeProductMain geProductMain;
	private String flowname;
	private List<GeWebflowpage> geWebflowpages = new ArrayList<GeWebflowpage>(0);
	

	// Constructors

	/** default constructor */
	public GeWebflow() {
	}


	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "WEBFLOWNO", unique = true, nullable = false)
	public String getWebflowno() {
		return this.webflowno;
	}

	public void setWebflowno(String webflowno) {
		this.webflowno = webflowno;
	}

	@Column(name = "WEBFLOWCODE", nullable = false)
	public String getWebflowcode() {
		return this.webflowcode;
	}

	public void setWebflowcode(String webflowcode) {
		this.webflowcode = webflowcode;
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
	
	

	@Column(name = "FLOWNAME", length = 255)
	public String getFlowname() {
		return flowname;
	}


	public void setFlowname(String flowname) {
		this.flowname = flowname;
	}


	@OneToMany(fetch=FetchType.LAZY,mappedBy="geWebflow")
	@Cascade(value={CascadeType.SAVE_UPDATE})
	public List<GeWebflowpage> getGeWebflowpages() {
		return geWebflowpages;
	}

	public void setGeWebflowpages(List<GeWebflowpage> geWebflowpages) {
		this.geWebflowpages = geWebflowpages;
	}


	@OneToOne
	@JoinColumn(name="COREPRODUCTCODE")
	public GeProductMain getGeProductMain() {
		return geProductMain;
	}
	
	public void setGeProductMain(GeProductMain geProductMain) {
		this.geProductMain = geProductMain;
	}
	

}