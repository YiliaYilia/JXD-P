package cn.com.sinosoft.domain.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CUSTOMER_INFO")
public class MobileCustomer implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;// 主键
	private String coustomerid;// 客户号
	private String name;// 客户姓名
	private String idtype;// 证件类型
	private String idnumber;// 证件号码
	private String sex;// 性别 M/F
	private String birthday;// 生日
	private String email;// 邮箱
	private String address;// 地址
	private String postcode;// 邮编
	private String telphone;// 电话
	private String mobile;// 手机
	private String state;// 用户状态
	private String password;// 密码
	private String microid;// 微信号

//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_INFO")
//	@SequenceGenerator(name = "CUSTOMER_INFO", sequenceName = "SEQ_CUSTOMER_INFO_ID")
	@Id
	@GeneratedValue(generator="CUSTOMER_INFO")
	@GenericGenerator(name="CUSTOMER_INFO",strategy="uuid")
	@Column(name = "ID", unique = true, nullable = false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "COUSTOMERID")
	public String getCoustomerid() {
		return coustomerid;
	}

	public void setCoustomerid(String coustomerid) {
		this.coustomerid = coustomerid;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "IDTYPE")
	public String getIdtype() {
		return idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	@Column(name = "IDNUMBER")
	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	@Column(name = "SEX")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "BIRTHDAY")
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "POSTCODE")
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Column(name = "TELPHONE")
	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	@Column(name = "MOBILE")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "STATE")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "MICROID")
	public String getMicroid() {
		return microid;
	}

	public void setMicroid(String microid) {
		this.microid = microid;
	}

}
