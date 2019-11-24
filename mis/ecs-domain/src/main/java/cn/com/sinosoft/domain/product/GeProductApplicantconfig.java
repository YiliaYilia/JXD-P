package cn.com.sinosoft.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * GeProductApplicantconfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_product_applicantconfig")
public class GeProductApplicantconfig implements java.io.Serializable {

	// Fields

	private String applicantconfigno;
	private GeProductMain geProductMain;
	private String appname;
	private String appsex;
	private String appbirthday;
	private String appidtype;
	private String appidnumber;
	private String appaddress;
	private String appzipcode;
	private String appemail;
	private String appcomphone;
	private String apphomephone;
	private String appmobilephone;
	private String appsexconfig;
	private String appidtypeconfig;
	private String appagestart;
	private String appageend;
	private String appagestartattr;
	private String appageendattr;
	private String appageflag;

	// Constructors

	/** default constructor */
	public GeProductApplicantconfig() {
	}

	/** minimal constructor */
	public GeProductApplicantconfig(String applicantconfigno, String appname,
			String appsex, String appbirthday, String appidtype,
			String appidnumber, GeProductMain geProductMain) {
		this.applicantconfigno = applicantconfigno;
		this.appname = appname;
		this.appsex = appsex;
		this.appbirthday = appbirthday;
		this.appidtype = appidtype;
		this.appidnumber = appidnumber;
		this.geProductMain = geProductMain;
	}

	/** full constructor */
	public GeProductApplicantconfig(String applicantconfigno, String appname,
			String appsex, String appbirthday, String appidtype,
			String appidnumber, String appaddress, String appzipcode,
			String appemail, String appcomphone, String apphomephone,
			String appmobilephone, String appsexconfig, String appidtypeconfig,
			String appagestart, String appageend, String appagestartattr,
			String appageendattr, String appageflag, GeProductMain geProductMain) {
		this.applicantconfigno = applicantconfigno;
		this.appname = appname;
		this.appsex = appsex;
		this.appbirthday = appbirthday;
		this.appidtype = appidtype;
		this.appidnumber = appidnumber;
		this.appaddress = appaddress;
		this.appzipcode = appzipcode;
		this.appemail = appemail;
		this.appcomphone = appcomphone;
		this.apphomephone = apphomephone;
		this.appmobilephone = appmobilephone;
		this.appsexconfig = appsexconfig;
		this.appidtypeconfig = appidtypeconfig;
		this.appagestart = appagestart;
		this.appageend = appageend;
		this.appagestartattr = appagestartattr;
		this.appageendattr = appageendattr;
		this.appageflag = appageflag;
		this.geProductMain = geProductMain;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "APPLICANTCONFIGNO", unique = true, nullable = false)
	public String getApplicantconfigno() {
		return this.applicantconfigno;
	}

	public void setApplicantconfigno(String applicantconfigno) {
		this.applicantconfigno = applicantconfigno;
	}

	@Column(name = "APPNAME", nullable = false, length = 1)
	public String getAppname() {
		return this.appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	@Column(name = "APPSEX", nullable = false, length = 1)
	public String getAppsex() {
		return this.appsex;
	}

	public void setAppsex(String appsex) {
		this.appsex = appsex;
	}

	@Column(name = "APPBIRTHDAY", nullable = false, length = 1)
	public String getAppbirthday() {
		return this.appbirthday;
	}

	public void setAppbirthday(String appbirthday) {
		this.appbirthday = appbirthday;
	}

	@Column(name = "APPIDTYPE", nullable = false, length = 1)
	public String getAppidtype() {
		return this.appidtype;
	}

	public void setAppidtype(String appidtype) {
		this.appidtype = appidtype;
	}

	@Column(name = "APPIDNO", nullable = false, length = 1)
	public String getAppidnumber() {
		return this.appidnumber;
	}

	public void setAppidnumber(String appidnumber) {
		this.appidnumber = appidnumber;
	}

	@Column(name = "APPADDRESS", length = 1)
	public String getAppaddress() {
		return this.appaddress;
	}

	public void setAppaddress(String appaddress) {
		this.appaddress = appaddress;
	}

	@Column(name = "APPZIPCODE", length = 1)
	public String getAppzipcode() {
		return this.appzipcode;
	}

	public void setAppzipcode(String appzipcode) {
		this.appzipcode = appzipcode;
	}

	@Column(name = "APPEMAIL", length = 1)
	public String getAppemail() {
		return this.appemail;
	}

	public void setAppemail(String appemail) {
		this.appemail = appemail;
	}

	@Column(name = "APPCOMPHONE", length = 1)
	public String getAppcomphone() {
		return this.appcomphone;
	}

	public void setAppcomphone(String appcomphone) {
		this.appcomphone = appcomphone;
	}

	@Column(name = "APPHOMEPHONE", length = 1)
	public String getApphomephone() {
		return this.apphomephone;
	}

	public void setApphomephone(String apphomephone) {
		this.apphomephone = apphomephone;
	}

	@Column(name = "APPMOBILEPHONE", length = 1)
	public String getAppmobilephone() {
		return this.appmobilephone;
	}

	public void setAppmobilephone(String appmobilephone) {
		this.appmobilephone = appmobilephone;
	}

	@Column(name = "APPSEXCONFIG", length = 250)
	public String getAppsexconfig() {
		return this.appsexconfig;
	}

	public void setAppsexconfig(String appsexconfig) {
		this.appsexconfig = appsexconfig;
	}

	@Column(name = "APPIDTYPECONFIG", length = 250)
	public String getAppidtypeconfig() {
		return this.appidtypeconfig;
	}

	public void setAppidtypeconfig(String appidtypeconfig) {
		this.appidtypeconfig = appidtypeconfig;
	}

	@Column(name = "APPAGESTART", length = 50)
	public String getAppagestart() {
		return this.appagestart;
	}

	public void setAppagestart(String appagestart) {
		this.appagestart = appagestart;
	}

	@Column(name = "APPAGEEND", length = 50)
	public String getAppageend() {
		return this.appageend;
	}

	public void setAppageend(String appageend) {
		this.appageend = appageend;
	}

	@Column(name = "APPAGESTARTATTR", length = 50)
	public String getAppagestartattr() {
		return this.appagestartattr;
	}

	public void setAppagestartattr(String appagestartattr) {
		this.appagestartattr = appagestartattr;
	}

	@Column(name = "APPAGEENDATTR", length = 50)
	public String getAppageendattr() {
		return this.appageendattr;
	}

	public void setAppageendattr(String appageendattr) {
		this.appageendattr = appageendattr;
	}

	@Column(name = "APPAGEFLAG", length = 50)
	public String getAppageflag() {
		return this.appageflag;
	}

	public void setAppageflag(String appageflag) {
		this.appageflag = appageflag;
	}


	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COREPRODUCTCODE")
	public GeProductMain getGeProductMain() {
		return geProductMain;
	}

	public void setGeProductMain(GeProductMain geProductMain) {
		this.geProductMain = geProductMain;
	}

}