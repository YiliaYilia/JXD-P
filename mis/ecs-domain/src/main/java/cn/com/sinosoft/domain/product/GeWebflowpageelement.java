package cn.com.sinosoft.domain.product;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * GeWebflowpageelement entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_webflowpageelement")
public class GeWebflowpageelement implements java.io.Serializable {

	// Fields

	private String webflowpageelementno;
	private String webflowpageelementcode; 
	private String status;
	private Long seqindex;
	private Date createtime;
	private Date updatetime;
	private String webflowpageelementname;
	private String handleurl;
	
	private GeProductMain geProductMain;
	
	private GeWebflowpage geWebflowpage;
	// Constructors

	/** default constructor */
	public GeWebflowpageelement() {
	}

	

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "WEBFLOWPAGEELEMENTNO", unique = true, nullable = false)
	public String getWebflowpageelementno() {
		return this.webflowpageelementno;
	}

	public void setWebflowpageelementno(String webflowpageelementno) {
		this.webflowpageelementno = webflowpageelementno;
	}

	
	
	@Column(name = "WEBFLOWPAGEELEMENTCODE", length = 255)
	public String getWebflowpageelementcode() {
		return webflowpageelementcode;
	}



	public void setWebflowpageelementcode(String webflowpageelementcode) {
		this.webflowpageelementcode = webflowpageelementcode;
	}



	@Column(name = "STATUS", length = 2)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "SEQINDEX", precision = 8, scale = 0)
	public Long getSeqindex() {
		return this.seqindex;
	}

	public void setSeqindex(Long seqindex) {
		this.seqindex = seqindex;
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

	
	
	


	@Column(name = "HANDLEURL", length = 255)
	public String getHandleurl() {
		return handleurl;
	}


	public void setHandleurl(String handleurl) {
		this.handleurl = handleurl;
	}

	@Column(name = "WEBFLOWPAGEELEMENTNAME", length = 255)
	public String getWebflowpageelementname() {
		return webflowpageelementname;
	}
	
	
	public void setWebflowpageelementname(String webflowpageelementname) {
		this.webflowpageelementname = webflowpageelementname;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="WEBFLOWPAGENO")
	public GeWebflowpage getGeWebflowpage() {
		return geWebflowpage;
	}



	public void setGeWebflowpage(GeWebflowpage geWebflowpage) {
		this.geWebflowpage = geWebflowpage;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COREPRODUCTCODE")
	public GeProductMain getGeProductMain() {
		return geProductMain;
	}

	public void setGeProductMain(GeProductMain geProductMain) {
		this.geProductMain = geProductMain;
	}

	
	
}