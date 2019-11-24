package cn.com.sinosoft.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GeProductAttribute entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_product_attribute")
public class GeProductAttribute implements java.io.Serializable {

	// Fields

	private String attrid;
	private String attrname;
	private Long seqindex;
	private String attrdescription;
	private String attrnoteinfo;
	private String attrparent;

	// Constructors

	/** default constructor */
	public GeProductAttribute() {
	}

	/** minimal constructor */
	public GeProductAttribute(String attrid, String attrname, String attrparent) {
		this.attrid = attrid;
		this.attrname = attrname;
		this.attrparent = attrparent;
	}

	/** full constructor */
	public GeProductAttribute(String attrid, String attrname, Long seqindex,
			String attrdescription, String attrnoteinfo, String attrparent) {
		this.attrid = attrid;
		this.attrname = attrname;
		this.seqindex = seqindex;
		this.attrdescription = attrdescription;
		this.attrnoteinfo = attrnoteinfo;
		this.attrparent = attrparent;
	}

	// Property accessors
	@Id
	@Column(name = "ATTRID", unique = true, nullable = false, length = 32)
	public String getAttrid() {
		return this.attrid;
	}

	public void setAttrid(String attrid) {
		this.attrid = attrid;
	}

	@Column(name = "ATTRNAME", nullable = false, length = 100)
	public String getAttrname() {
		return this.attrname;
	}

	public void setAttrname(String attrname) {
		this.attrname = attrname;
	}

	@Column(name = "SEQINDEX", precision = 8, scale = 0)
	public Long getSeqindex() {
		return this.seqindex;
	}

	public void setSeqindex(Long seqindex) {
		this.seqindex = seqindex;
	}

	@Column(name = "ATTRDESCRIPTION", length = 500)
	public String getAttrdescription() {
		return this.attrdescription;
	}

	public void setAttrdescription(String attrdescription) {
		this.attrdescription = attrdescription;
	}

	@Column(name = "ATTRNOTEINFO", length = 500)
	public String getAttrnoteinfo() {
		return this.attrnoteinfo;
	}

	public void setAttrnoteinfo(String attrnoteinfo) {
		this.attrnoteinfo = attrnoteinfo;
	}

	@Column(name = "ATTRPARENT", nullable = false, length = 32)
	public String getAttrparent() {
		return this.attrparent;
	}

	public void setAttrparent(String attrparent) {
		this.attrparent = attrparent;
	}

}