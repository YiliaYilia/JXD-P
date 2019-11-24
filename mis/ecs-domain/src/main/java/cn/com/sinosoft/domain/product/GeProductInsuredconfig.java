package cn.com.sinosoft.domain.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * GeProductInsuredconfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_product_insuredconfig")
public class GeProductInsuredconfig implements java.io.Serializable {

	// Fields

	private String insuredconfigno;
	private GeProductMain geProductMain;
	private String insname;
	private String inssex;
	private String insbirthday;
	private String insidtype;
	private String insidnumber;
	private String insaddress;
	private String inszipcode;
	private String insemail;
	private String inscomphone;
	private String inshomephone;
	private String insmobilephone;
	private String insoccupation;
	private String insoccupationtypeconfig;
	private String insrelationtoapp;
	private String insrelationtoappconfig;
	private String insismoreins;
	private String finsrelationtoappconfig;
	private Long sameindinsuredamount;
	private String insidtypeconfig;
	private String inssexconfig;
	private String insuredtype;
	private String inagestart;
	private String inageend;
	private String inagestartattr;
	private String inageendattr;
	private String insageflag;
	/** 属性geProInsuredOccupations */
	private List<GeProInsuredOccupation> geProInsuredOccupations = new ArrayList<GeProInsuredOccupation>(
			0);

	// Constructors

	/** default constructor */
	public GeProductInsuredconfig() {
	}

	/** minimal constructor */
	public GeProductInsuredconfig(String insuredconfigno,
			GeProductMain geProductMain, String insname, String inssex,
			String insbirthday, String insidtype, String insidnumber) {
		this.insuredconfigno = insuredconfigno;
		this.geProductMain = geProductMain;
		this.insname = insname;
		this.inssex = inssex;
		this.insbirthday = insbirthday;
		this.insidtype = insidtype;
		this.insidnumber = insidnumber;
	}

	/** full constructor */
	public GeProductInsuredconfig(String insuredconfigno,
			GeProductMain geProductMain, String insname, String inssex,
			String insbirthday, String insidtype, String insidnumber,
			String insaddress, String inszipcode, String insemail,
			String inscomphone, String inshomephone, String insmobilephone,
			String insoccupation, String insoccupationtypeconfig,
			String insrelationtoapp, String insrelationtoappconfig,
			String insismoreins, String finsrelationtoappconfig,
			Long sameindinsuredamount, String insidtypeconfig,
			String inssexconfig, String insuredtype, String inagestart,
			String inageend, String inagestartattr, String inageendattr,
			String insageflag) {
		this.insuredconfigno = insuredconfigno;
		this.geProductMain = geProductMain;
		this.insname = insname;
		this.inssex = inssex;
		this.insbirthday = insbirthday;
		this.insidtype = insidtype;
		this.insidnumber = insidnumber;
		this.insaddress = insaddress;
		this.inszipcode = inszipcode;
		this.insemail = insemail;
		this.inscomphone = inscomphone;
		this.inshomephone = inshomephone;
		this.insmobilephone = insmobilephone;
		this.insoccupation = insoccupation;
		this.insoccupationtypeconfig = insoccupationtypeconfig;
		this.insrelationtoapp = insrelationtoapp;
		this.insrelationtoappconfig = insrelationtoappconfig;
		this.insismoreins = insismoreins;
		this.finsrelationtoappconfig = finsrelationtoappconfig;
		this.sameindinsuredamount = sameindinsuredamount;
		this.insidtypeconfig = insidtypeconfig;
		this.inssexconfig = inssexconfig;
		this.insuredtype = insuredtype;
		this.inagestart = inagestart;
		this.inageend = inageend;
		this.inagestartattr = inagestartattr;
		this.inageendattr = inageendattr;
		this.insageflag = insageflag;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "INSUREDCONFIGNO", unique = true, nullable = false)
	public String getInsuredconfigno() {
		return this.insuredconfigno;
	}

	public void setInsuredconfigno(String insuredconfigno) {
		this.insuredconfigno = insuredconfigno;
	}

	@Column(name = "INSNAME", nullable = false, length = 1)
	public String getInsname() {
		return this.insname;
	}

	public void setInsname(String insname) {
		this.insname = insname;
	}

	@Column(name = "INSSEX", nullable = false, length = 1)
	public String getInssex() {
		return this.inssex;
	}

	public void setInssex(String inssex) {
		this.inssex = inssex;
	}

	@Column(name = "INSBIRTHDAY", nullable = false, length = 1)
	public String getInsbirthday() {
		return this.insbirthday;
	}

	public void setInsbirthday(String insbirthday) {
		this.insbirthday = insbirthday;
	}

	@Column(name = "INSIDTYPE", nullable = false, length = 1)
	public String getInsidtype() {
		return this.insidtype;
	}

	public void setInsidtype(String insidtype) {
		this.insidtype = insidtype;
	}

	@Column(name = "INSIDNO", nullable = false, length = 1)
	public String getInsidnumber() {
		return this.insidnumber;
	}

	public void setInsidnumber(String insidnumber) {
		this.insidnumber = insidnumber;
	}

	@Column(name = "INSADDRESS", length = 1)
	public String getInsaddress() {
		return this.insaddress;
	}

	public void setInsaddress(String insaddress) {
		this.insaddress = insaddress;
	}

	@Column(name = "INSZIPCODE", length = 1)
	public String getInszipcode() {
		return this.inszipcode;
	}

	public void setInszipcode(String inszipcode) {
		this.inszipcode = inszipcode;
	}

	@Column(name = "INSEMAIL", length = 1)
	public String getInsemail() {
		return this.insemail;
	}

	public void setInsemail(String insemail) {
		this.insemail = insemail;
	}

	@Column(name = "INSCOMPHONE", length = 1)
	public String getInscomphone() {
		return this.inscomphone;
	}

	public void setInscomphone(String inscomphone) {
		this.inscomphone = inscomphone;
	}

	@Column(name = "INSHOMEPHONE", length = 1)
	public String getInshomephone() {
		return this.inshomephone;
	}

	public void setInshomephone(String inshomephone) {
		this.inshomephone = inshomephone;
	}

	@Column(name = "INSMOBILEPHONE", length = 1)
	public String getInsmobilephone() {
		return this.insmobilephone;
	}

	public void setInsmobilephone(String insmobilephone) {
		this.insmobilephone = insmobilephone;
	}

	@Column(name = "INSOCCUPATION", length = 1)
	public String getInsoccupation() {
		return this.insoccupation;
	}

	public void setInsoccupation(String insoccupation) {
		this.insoccupation = insoccupation;
	}

	@Column(name = "INSOCCUPATIONTYPECONFIG", length = 200)
	public String getInsoccupationtypeconfig() {
		return this.insoccupationtypeconfig;
	}

	public void setInsoccupationtypeconfig(String insoccupationtypeconfig) {
		this.insoccupationtypeconfig = insoccupationtypeconfig;
	}

	@Column(name = "INSRELATIONTOAPP", length = 1)
	public String getInsrelationtoapp() {
		return this.insrelationtoapp;
	}

	public void setInsrelationtoapp(String insrelationtoapp) {
		this.insrelationtoapp = insrelationtoapp;
	}

	@Column(name = "INSRELATIONTOAPPCONFIG", length = 200)
	public String getInsrelationtoappconfig() {
		return this.insrelationtoappconfig;
	}

	public void setInsrelationtoappconfig(String insrelationtoappconfig) {
		this.insrelationtoappconfig = insrelationtoappconfig;
	}

	@Column(name = "ISMOREINS", length = 1)
	public String getInsismoreins() {
		return this.insismoreins;
	}

	public void setInsismoreins(String insismoreins) {
		this.insismoreins = insismoreins;
	}

	@Column(name = "FINSRELATIONTOAPPCONFIG", length = 200)
	public String getFinsrelationtoappconfig() {
		return this.finsrelationtoappconfig;
	}

	public void setFinsrelationtoappconfig(String finsrelationtoappconfig) {
		this.finsrelationtoappconfig = finsrelationtoappconfig;
	}

	@Column(name = "SAMEINDINSUREDAMOUNT", precision = 8, scale = 0)
	public Long getSameindinsuredamount() {
		return this.sameindinsuredamount;
	}

	public void setSameindinsuredamount(Long sameindinsuredamount) {
		this.sameindinsuredamount = sameindinsuredamount;
	}

	@Column(name = "INSIDTYPECONFIG", length = 200)
	public String getInsidtypeconfig() {
		return this.insidtypeconfig;
	}

	public void setInsidtypeconfig(String insidtypeconfig) {
		this.insidtypeconfig = insidtypeconfig;
	}

	@Column(name = "INSSEXCONFIG", length = 200)
	public String getInssexconfig() {
		return this.inssexconfig;
	}

	public void setInssexconfig(String inssexconfig) {
		this.inssexconfig = inssexconfig;
	}

	@Column(name = "INSUREDTYPE", length = 2)
	public String getInsuredtype() {
		return this.insuredtype;
	}

	public void setInsuredtype(String insuredtype) {
		this.insuredtype = insuredtype;
	}

	@Column(name = "INAGESTART", length = 50)
	public String getInagestart() {
		return this.inagestart;
	}

	public void setInagestart(String inagestart) {
		this.inagestart = inagestart;
	}

	@Column(name = "INAGEEND", length = 50)
	public String getInageend() {
		return this.inageend;
	}

	public void setInageend(String inageend) {
		this.inageend = inageend;
	}

	@Column(name = "INAGESTARTATTR", length = 50)
	public String getInagestartattr() {
		return this.inagestartattr;
	}

	public void setInagestartattr(String inagestartattr) {
		this.inagestartattr = inagestartattr;
	}

	@Column(name = "INAGEENDATTR", length = 50)
	public String getInageendattr() {
		return this.inageendattr;
	}

	public void setInageendattr(String inageendattr) {
		this.inageendattr = inageendattr;
	}

	@Column(name = "INAGEFLAG", length = 50)
	public String getInsageflag() {
		return this.insageflag;
	}

	public void setInsageflag(String insageflag) {
		this.insageflag = insageflag;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COREPRODUCTCODE")
	public GeProductMain getGeProductMain() {
		return geProductMain;
	}

	public void setGeProductMain(GeProductMain geProductMain) {
		this.geProductMain = geProductMain;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "geProductInsuredconfig")
	public List<GeProInsuredOccupation> getGeProInsuredOccupations() {
		return geProInsuredOccupations;
	}

	public void setGeProInsuredOccupations(
			List<GeProInsuredOccupation> geProInsuredOccupations) {
		this.geProInsuredOccupations = geProInsuredOccupations;
	}

}