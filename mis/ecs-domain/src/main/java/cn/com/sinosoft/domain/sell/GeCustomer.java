package cn.com.sinosoft.domain.sell;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * GeCustomer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_customer")
public class GeCustomer implements java.io.Serializable {

	// Fields

	private String customerno;
	private String customeraccount;
	private String customerlevel;
	private String customername;
	private String securitypwd;
	private String pwd;
	private String email;
	private String mobliephone;
	private String identifytype;
	private String identifynumber;
	private String sex;
	private Date birthday;
	private String marriagestatus;
	private String areacode;
	private String industry;
	private String income;
	private String homephone;
	private String officephone;
	private String provinces;
	private String city;
	private String area;
	private String contactaddress;
	private String zipcode;
	private String usersource;
	private String health;
	private String status;
	private String activecode;
	private Double integral;
	private Date createtime;
	private String flag;
	private Date logintime;
	private Long loginnum;

	
	// Constructors

	/** default constructor */
	public GeCustomer() {
	}

	/** minimal constructor */
	public GeCustomer(String customerno, String customeraccount,
			String customerlevel, String securitypwd, String pwd,
			String identifytype, String identifynumber, String sex,
			Date birthday) {
		this.customerno = customerno;
		this.customeraccount = customeraccount;
		this.customerlevel = customerlevel;
		this.securitypwd = securitypwd;
		this.pwd = pwd;
		this.identifytype = identifytype;
		this.identifynumber = identifynumber;
		this.sex = sex;
		this.birthday = birthday;
	}

	/** full constructor */
	public GeCustomer(String customerno, String customeraccount,
			String customerlevel, String customername, String securitypwd,
			String pwd, String email, String mobliephone, String identifytype,
			String identifynumber, String sex, Date birthday,
			String marriagestatus, String areacode, String industry,
			String income, String homephone, String officephone,
			String provinces, String city, String area, String contactaddress,
			String zipcode, String usersource, String health, String status,
			String activecode, Double integral, Date createtime, String flag,
			Date logintime, Long loginnum) {
		this.customerno = customerno;
		this.customeraccount = customeraccount;
		this.customerlevel = customerlevel;
		this.customername = customername;
		this.securitypwd = securitypwd;
		this.pwd = pwd;
		this.email = email;
		this.mobliephone = mobliephone;
		this.identifytype = identifytype;
		this.identifynumber = identifynumber;
		this.sex = sex;
		this.birthday = birthday;
		this.marriagestatus = marriagestatus;
		this.areacode = areacode;
		this.industry = industry;
		this.income = income;
		this.homephone = homephone;
		this.officephone = officephone;
		this.provinces = provinces;
		this.city = city;
		this.area = area;
		this.contactaddress = contactaddress;
		this.zipcode = zipcode;
		this.usersource = usersource;
		this.health = health;
		this.status = status;
		this.activecode = activecode;
		this.integral = integral;
		this.createtime = createtime;
		this.flag = flag;
		this.logintime = logintime;
		this.loginnum = loginnum;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "CUSTOMERNO", unique = true, nullable = false)
	public String getCustomerno() {
		return this.customerno;
	}

	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}

	@Column(name = "CUSTOMERACCOUNT", nullable = false)
	public String getCustomeraccount() {
		return this.customeraccount;
	}

	public void setCustomeraccount(String customeraccount) {
		this.customeraccount = customeraccount;
	}

	@Column(name = "CUSTOMERLEVEL", nullable = false, length = 50)
	public String getCustomerlevel() {
		return this.customerlevel;
	}

	public void setCustomerlevel(String customerlevel) {
		this.customerlevel = customerlevel;
	}

	@Column(name = "CUSTOMERNAME", length = 50)
	public String getCustomername() {
		return this.customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	@Column(name = "SECURITYPWD", nullable = false, length = 50)
	public String getSecuritypwd() {
		return this.securitypwd;
	}

	public void setSecuritypwd(String securitypwd) {
		this.securitypwd = securitypwd;
	}

	@Column(name = "PWD", nullable = false, length = 50)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "MOBLIEPHONE", length = 20)
	public String getMobliephone() {
		return this.mobliephone;
	}

	public void setMobliephone(String mobliephone) {
		this.mobliephone = mobliephone;
	}

	@Column(name = "IDENTIFYTYPE", nullable = false, length = 2)
	public String getIdentifytype() {
		return this.identifytype;
	}

	public void setIdentifytype(String identifytype) {
		this.identifytype = identifytype;
	}

	@Column(name = "IDENTIFYNUMBER", nullable = false, length = 50)
	public String getIdentifynumber() {
		return this.identifynumber;
	}

	public void setIdentifynumber(String identifynumber) {
		this.identifynumber = identifynumber;
	}

	@Column(name = "SEX", nullable = false, length = 2)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY", nullable = false, length = 19)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "MARRIAGESTATUS", length = 2)
	public String getMarriagestatus() {
		return this.marriagestatus;
	}

	public void setMarriagestatus(String marriagestatus) {
		this.marriagestatus = marriagestatus;
	}

	@Column(name = "AREACODE", length = 50)
	public String getAreacode() {
		return this.areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	@Column(name = "INDUSTRY", length = 50)
	public String getIndustry() {
		return this.industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@Column(name = "INCOME", length = 10)
	public String getIncome() {
		return this.income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	@Column(name = "HOMEPHONE", length = 20)
	public String getHomephone() {
		return this.homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	@Column(name = "OFFICEPHONE", length = 20)
	public String getOfficephone() {
		return this.officephone;
	}

	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}

	@Column(name = "PROVINCES", length = 10)
	public String getProvinces() {
		return this.provinces;
	}

	public void setProvinces(String provinces) {
		this.provinces = provinces;
	}

	@Column(name = "CITY", length = 10)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "AREA", length = 10)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "CONTACTADDRESS", length = 500)
	public String getContactaddress() {
		return this.contactaddress;
	}

	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}

	@Column(name = "ZIPCODE", length = 6)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "USERSOURCE", length = 2)
	public String getUsersource() {
		return this.usersource;
	}

	public void setUsersource(String usersource) {
		this.usersource = usersource;
	}

	@Column(name = "HEALTH", length = 2)
	public String getHealth() {
		return this.health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	@Column(name = "STATUS", length = 2)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "ACTIVECODE", length = 50)
	public String getActivecode() {
		return this.activecode;
	}

	public void setActivecode(String activecode) {
		this.activecode = activecode;
	}

	@Column(name = "INTEGRAL", precision = 14)
	public Double getIntegral() {
		return this.integral;
	}

	public void setIntegral(Double integral) {
		this.integral = integral;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATETIME", length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(name = "FLAG", length = 10)
	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LOGINTIME", length = 19)
	public Date getLogintime() {
		return this.logintime;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}

	@Column(name = "LOGINNUM", precision = 10, scale = 0)
	public Long getLoginnum() {
		return this.loginnum;
	}

	public void setLoginnum(Long loginnum) {
		this.loginnum = loginnum;
	}

}