package cn.com.sinosoft.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * GeProductOtherconfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_product_otherconfig")
public class GeProductOtherconfig implements java.io.Serializable {

	// Fields

	private String otherconfigno;
	private String otherconfigname;
	private String otherconfigcode;
	private String otherconfigtype;
	private String otherconfigcontent;

	private GeProductMain geProductMain;
	// Constructors

	/** default constructor */
	public GeProductOtherconfig() {
	}

	/** minimal constructor */
	public GeProductOtherconfig(String otherconfigno) {
		this.otherconfigno = otherconfigno;
	}

	/** full constructor */
	public GeProductOtherconfig(String otherconfigno,
			String otherconfigname, String otherconfigcode,
			String otherconfigtype, String otherconfigcontent) {
		this.otherconfigno = otherconfigno;
		this.otherconfigname = otherconfigname;
		this.otherconfigcode = otherconfigcode;
		this.otherconfigtype = otherconfigtype;
		this.otherconfigcontent = otherconfigcontent;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "OTHERCONFIGNO", unique = true, nullable = false)
	public String getOtherconfigno() {
		return this.otherconfigno;
	}

	public void setOtherconfigno(String otherconfigno) {
		this.otherconfigno = otherconfigno;
	}

	@Column(name = "OTHERCONFIGNAME", length = 50)
	public String getOtherconfigname() {
		return this.otherconfigname;
	}

	public void setOtherconfigname(String otherconfigname) {
		this.otherconfigname = otherconfigname;
	}

	@Column(name = "OTHERCONFIGCODE", length = 50)
	public String getOtherconfigcode() {
		return this.otherconfigcode;
	}

	public void setOtherconfigcode(String otherconfigcode) {
		this.otherconfigcode = otherconfigcode;
	}

	@Column(name = "OTHERCONFIGTYPE", length = 50)
	public String getOtherconfigtype() {
		return this.otherconfigtype;
	}

	public void setOtherconfigtype(String otherconfigtype) {
		this.otherconfigtype = otherconfigtype;
	}

	@Column(name = "OTHERCONFIGCONTENT", length = 65535)
	public String getOtherconfigcontent() {
		return this.otherconfigcontent;
	}

	public void setOtherconfigcontent(String otherconfigcontent) {
		this.otherconfigcontent = otherconfigcontent;
	}

	@ManyToOne
	@JoinColumn(name="COREPRODUCTCODE")
	public GeProductMain getGeProductMain() {
		return geProductMain;
	}

	public void setGeProductMain(GeProductMain geProductMain) {
		this.geProductMain = geProductMain;
	}

}