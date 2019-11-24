package cn.com.sinosoft.domain.sell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * GeApplicantinsured entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "GE_CHILDLIST")
public class GeChildlist implements java.io.Serializable {

	// Fields

	private String applicantinsuredno;
	private String name;
	private String sex;
	private String birthday;
	private String identifytype;
	private String identifynumber;
	private String zipcode;
	private String mobile;
	private String email;
	private String address;
	private String flag;
	private String remark;
	private String province;
	private String city;
	private String area;
	private String amount;
	private String createdate;
	private String updatedate;
	private String imageurl;
	private String age;
	// Constructors


	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "APPLICANTINSUREDNO", unique = true, nullable = false)
	public String getApplicantinsuredno() {
		return this.applicantinsuredno;
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

	@Column(name = "BIRTHDAY", length = 19)
	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
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
	
	@Column(name = "province")
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	@Column(name = "city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "area")
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	@Column(name = "amount")
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	@Column(name = "createdate")
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
	@Column(name = "updatedate")
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	@Column(name = "imageurl")
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	@Column(name = "age")
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	
	
	
	
}