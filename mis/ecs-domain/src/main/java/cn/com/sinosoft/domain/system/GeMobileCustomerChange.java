package cn.com.sinosoft.domain.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CUSTOMER_INFO_CHANGE")
public class GeMobileCustomerChange implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String id;// 主键
	private String coustomerid;// 客户号
	private String name;// 客户姓名
	private String idnumber;// 证件号码
	private String idtype;// 证件类型   
	private String email;// 邮箱
	private String address;// 地址
	private String postcode;// 邮编
	private String mobile;// 手机
	private String microid;// openId
	private String updatetime;	// 修改时间
	private String companyAddress;//机构所在地
	private String starttime;//开始时间
	private String endtime;//结束时间
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
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

	@Column(name = "MOBILE")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "MICROID")
	public String getMicroid() {
		return microid;
	}

	public void setMicroid(String microid) {
		this.microid = microid;
	}

	@Column(name = "UPDATETIME")
	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	@Column(name = "COMPANYADDRESS")
	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	@Column(name = "idnumber")
	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	@Column(name = "IDTYPE")
	public String getIdtype() {
		return idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}
	
	@Column(name = "STARTTIME")
	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	@Column(name = "ENDTIME")
	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
}
