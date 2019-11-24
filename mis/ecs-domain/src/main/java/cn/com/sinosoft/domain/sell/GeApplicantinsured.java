package cn.com.sinosoft.domain.sell;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * GeApplicantinsured entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_applicantinsured")
public class GeApplicantinsured implements java.io.Serializable {

	// Fields

	private String applicantinsuredno;
	private String name;
	private String sex;
	private Date birthday;
	private String identifytype;
	private String identifynumber;
	private String zipcode;
	private String companyphone;
	private String homephone;
	private String mobile;
	private String email;
	private String address;
	private String occupationname;
	private String occupationcode;
	private String occupationmname;
	private String occupationmcode;
	private String occupationsname;
	private String occupationscode;
	private String partyflag;
	private String insrelationapp;
	private String flag;
	private String remark;
	private String mailaddress;

	@Column(name = "MAILADDRESS")
	public String getMailaddress() {
		return mailaddress;
	}

	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}

	private Set<GePolicy> policy;
	
	// Constructors

	/** default constructor */
	public GeApplicantinsured() {
	}

	/** minimal constructor */
	public GeApplicantinsured(String applicantinsuredno2) {
		this.applicantinsuredno = applicantinsuredno2;
	}

	/** full constructor */
	public GeApplicantinsured(String applicantinsuredno2,
			 String sex, Date birthday,
			String identifytype, String identifynumber, String zipcode,
			String companyphone, String homephone, String mobile, String email,
			String address, String occupationname, String occupationcode,
			String occupationmname, String occupationmcode,
			String occupationsname, String occupationscode, String partyflag,
			String insrelationapp, String flag, String remark) {
		this.applicantinsuredno = applicantinsuredno2;
		this.sex = sex;
		this.birthday = birthday;
		this.identifytype = identifytype;
		this.identifynumber = identifynumber;
		this.zipcode = zipcode;
		this.companyphone = companyphone;
		this.homephone = homephone;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.occupationname = occupationname;
		this.occupationcode = occupationcode;
		this.occupationmname = occupationmname;
		this.occupationmcode = occupationmcode;
		this.occupationsname = occupationsname;
		this.occupationscode = occupationscode;
		this.partyflag = partyflag;
		this.insrelationapp = insrelationapp;
		this.flag = flag;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "APPLICANTINSUREDNO", unique = true, nullable = false)
	public String getApplicantinsuredno() {
		return this.applicantinsuredno;
	}
 
	
	@ManyToMany(targetEntity = GePolicy.class)
	@JoinTable(name = "GE_POLICY_APPLICANTINSURED", joinColumns = {@JoinColumn(name = "APPLICANTINSUREDNO") }, inverseJoinColumns = { @JoinColumn(name = "POLICYNO") })
	@Cascade({CascadeType.SAVE_UPDATE})
	public Set<GePolicy> getPolicy() {
		return policy;
	}

	public void setPolicy(Set<GePolicy> policy) {
		this.policy = policy;
	}

	public void setApplicantinsuredno(String applicantinsuredno) {
		this.applicantinsuredno = applicantinsuredno;
	}

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SEX", length = 2)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY", length = 19)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "IDENTIFYTYPE", length = 10)
	public String getIdentifytype() {
		return this.identifytype;
	}

	public void setIdentifytype(String identifytype) {
		this.identifytype = identifytype;
	}

	@Column(name = "IDENTIFYNUMBER", length = 50)
	public String getIdentifynumber() {
		return this.identifynumber;
	}

	public void setIdentifynumber(String identifynumber) {
		this.identifynumber = identifynumber;
	}

	@Column(name = "ZIPCODE", length = 6)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "COMPANYPHONE", length = 20)
	public String getCompanyphone() {
		return this.companyphone;
	}

	public void setCompanyphone(String companyphone) {
		this.companyphone = companyphone;
	}

	@Column(name = "HOMEPHONE", length = 20)
	public String getHomephone() {
		return this.homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	@Column(name = "MOBILE", length = 20)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "OCCUPATIONNAME")
	public String getOccupationname() {
		return this.occupationname;
	}

	public void setOccupationname(String occupationname) {
		this.occupationname = occupationname;
	}

	@Column(name = "OCCUPATIONCODE", length = 50)
	public String getOccupationcode() {
		return this.occupationcode;
	}

	public void setOccupationcode(String occupationcode) {
		this.occupationcode = occupationcode;
	}

	@Column(name = "OCCUPATIONMNAME")
	public String getOccupationmname() {
		return this.occupationmname;
	}

	public void setOccupationmname(String occupationmname) {
		this.occupationmname = occupationmname;
	}

	@Column(name = "OCCUPATIONMCODE", length = 50)
	public String getOccupationmcode() {
		return this.occupationmcode;
	}

	public void setOccupationmcode(String occupationmcode) {
		this.occupationmcode = occupationmcode;
	}

	@Column(name = "OCCUPATIONSNAME")
	public String getOccupationsname() {
		return this.occupationsname;
	}

	public void setOccupationsname(String occupationsname) {
		this.occupationsname = occupationsname;
	}

	@Column(name = "OCCUPATIONSCODE", length = 50)
	public String getOccupationscode() {
		return this.occupationscode;
	}

	public void setOccupationscode(String occupationscode) {
		this.occupationscode = occupationscode;
	}

	@Column(name = "PARTYFLAG", length = 2)
	public String getPartyflag() {
		return this.partyflag;
	}

	public void setPartyflag(String partyflag) {
		this.partyflag = partyflag;
	}

	@Column(name = "INSRELATIONAPP", length = 10)
	public String getInsrelationapp() {
		return this.insrelationapp;
	}

	public void setInsrelationapp(String insrelationapp) {
		this.insrelationapp = insrelationapp;
	}

	@Column(name = "FLAG", length = 10)
	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}