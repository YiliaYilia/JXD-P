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
 * GeWebflowpage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_webflowpage")
public class GeWebflowpage implements java.io.Serializable {

	// Fields

	private String webflowpageno;
	private String webflowpagecode;
	private Long seqindex;
	private Date createtime;
	private Date updatetime;
	private String isshow;
	private GeWebflow geWebflow;
	private String pagename;
	private List<GeWebflowpageelement> geWebflowpageelements = new ArrayList<GeWebflowpageelement>(0);

	// Constructors

	/** default constructor */
	public GeWebflowpage() {
	}

	
	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "WEBFLOWPAGENO", unique = true, nullable = false)
	public String getWebflowpageno() {
		return this.webflowpageno;
	}

	public void setWebflowpageno(String webflowpageno) {
		this.webflowpageno = webflowpageno;
	}

	@Column(name = "WEBFLOWPAGECODE")
	public String getWebflowpagecode() {
		return this.webflowpagecode;
	}

	public void setWebflowpagecode(String webflowpagecode) {
		this.webflowpagecode = webflowpagecode;
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

	@Column(name = "PAGENAME", length = 255)
	public String getPagename() {
		return pagename;
	}


	public void setPagename(String pagename) {
		this.pagename = pagename;
	}


	@Column(name = "ISSHOW", length = 2)
	public String getIsshow() {
		return this.isshow;
	}

	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}

	@OneToMany(fetch = FetchType.LAZY,mappedBy="geWebflowpage")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeWebflowpageelement> getGeWebflowpageelements() {
		return geWebflowpageelements;
	}

	public void setGeWebflowpageelements(
			List<GeWebflowpageelement> geWebflowpageelements) {
		this.geWebflowpageelements = geWebflowpageelements;
	}

	@ManyToOne
	@JoinColumn(name="WEBFLOWNO")
	public GeWebflow getGeWebflow() {
		return geWebflow;
	}


	public void setGeWebflow(GeWebflow geWebflow) {
		this.geWebflow = geWebflow;
	}

	
}