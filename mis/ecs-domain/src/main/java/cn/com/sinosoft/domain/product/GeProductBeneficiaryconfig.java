package cn.com.sinosoft.domain.product;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * GeProductBeneficiaryconfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_product_beneficiaryconfig")
public class GeProductBeneficiaryconfig implements java.io.Serializable {

	// Fields

	private String beneficiaryconfigno;
	private String benname;
	private String bensex;
	private String benbirthday;
	private String benidtype;
	private String benidnumber;
	private String benaddress;
	private String benzipcode;
	private String benemail;
	private String bencomphone;
	private String benhomephone;
	private String benmobilephone;
	private String benorder;
	private String benrate;
	private String bentype;
	private String benrelationtopins;
	private String benrelationtopinsconfig;
	private String bensexconfig;
	private String benidtypeconfig;
	/**
	 * 关联产品配置主表
	 */
	private GeProductMain geProductMain;

	// Constructors

	/** default constructor */
	public GeProductBeneficiaryconfig() {
	}


	// Property accessors
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "BENEFICIARYCONFIGNO", unique = true, nullable = false)
	public String getBeneficiaryconfigno() {
		return this.beneficiaryconfigno;
	}

	public void setBeneficiaryconfigno(String beneficiaryconfigno) {
		this.beneficiaryconfigno = beneficiaryconfigno;
	}

	@Column(name = "BENNAME", nullable = false, length = 10)
	public String getBenname() {
		return this.benname;
	}

	public void setBenname(String benname) {
		this.benname = benname;
	}

	@Column(name = "BENGENDER", nullable = false, length = 1)
	public String getBensex() {
		return this.bensex;
	}

	public void setBensex(String bengender) {
		this.bensex = bengender;
	}

	
	@Column(name = "BENBIRTHDAY", nullable = false, length = 10)
	public String getBenbirthday() {
		return this.benbirthday;
	}

	public void setBenbirthday(String benbirthday) {
		this.benbirthday = benbirthday;
	}

	@Column(name = "BENIDTYPE", nullable = false, length = 10)
	public String getBenidtype() {
		return this.benidtype;
	}

	public void setBenidtype(String benidtype) {
		this.benidtype = benidtype;
	}

	@Column(name = "BENIDNUMBER", nullable = false, length = 10)
	public String getBenidnumber() {
		return this.benidnumber;
	}

	public void setBenidnumber(String benidnumber) {
		this.benidnumber = benidnumber;
	}

	@Column(name = "BENADDRESS")
	public String getBenaddress() {
		return this.benaddress;
	}

	public void setBenaddress(String benaddress) {
		this.benaddress = benaddress;
	}

	@Column(name = "BENZIPCODE", length = 10)
	public String getBenzipcode() {
		return this.benzipcode;
	}

	public void setBenzipcode(String benzipcode) {
		this.benzipcode = benzipcode;
	}

	@Column(name = "BENEMAIL", length = 10)
	public String getBenemail() {
		return this.benemail;
	}

	public void setBenemail(String benemail) {
		this.benemail = benemail;
	}

	@Column(name = "BENCOMPHONE", length = 10)
	public String getBencomphone() {
		return this.bencomphone;
	}

	public void setBencomphone(String bencomphone) {
		this.bencomphone = bencomphone;
	}

	@Column(name = "BENHOMEPHONE", length = 10)
	public String getBenhomephone() {
		return this.benhomephone;
	}

	public void setBenhomephone(String benhomephone) {
		this.benhomephone = benhomephone;
	}

	@Column(name = "BENMOBILEPHONE", length = 10)
	public String getBenmobilephone() {
		return this.benmobilephone;
	}

	public void setBenmobilephone(String benmobilephone) {
		this.benmobilephone = benmobilephone;
	}

	@Column(name = "BENORDER", length = 10)
	public String getBenorder() {
		return this.benorder;
	}

	public void setBenorder(String benorder) {
		this.benorder = benorder;
	}

	@Column(name = "BENRATE", length = 10)
	public String getBenrate() {
		return this.benrate;
	}

	public void setBenrate(String benrate) {
		this.benrate = benrate;
	}

	@Column(name = "BENTYPE", length = 10)
	public String getBentype() {
		return this.bentype;
	}

	public void setBentype(String bentype) {
		this.bentype = bentype;
	}

	@Column(name = "BENRELATIONTOPINS", length = 10)
	public String getBenrelationtopins() {
		return this.benrelationtopins;
	}

	public void setBenrelationtopins(String benrelationtopins) {
		this.benrelationtopins = benrelationtopins;
	}

	@Column(name = "BENRELATIONTOPINSCONFIG", length = 200)
	public String getBenrelationtopinsconfig() {
		return this.benrelationtopinsconfig;
	}

	public void setBenrelationtopinsconfig(String benrelationtopinsconfig) {
		this.benrelationtopinsconfig = benrelationtopinsconfig;
	}

	@Column(name = "BENGENDERCONFIG", length = 200)
	public String getBensexconfig() {
		return this.bensexconfig;
	}

	public void setBensexconfig(String bengenderconfig) {
		this.bensexconfig = bengenderconfig;
	}

	@Column(name = "BENIDTYPECONFIG", length = 200)
	public String getBenidtypeconfig() {
		return this.benidtypeconfig;
	}

	public void setBenidtypeconfig(String benidtypeconfig) {
		this.benidtypeconfig = benidtypeconfig;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COREPRODUCTCODE", nullable = false)
	public GeProductMain getGeProductMain() {
		return geProductMain;
	}

	public void setGeProductMain(GeProductMain geProductMain) {
		this.geProductMain = geProductMain;
	}

}