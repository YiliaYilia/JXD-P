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
 * GeAddresseeConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_addressee_config")
public class GeAddresseeConfig implements java.io.Serializable {

	// Fields

	private String addresseeconfigno;
	private GeProductMain geProductMain;
	private String consigneename;
	private String telephone;
	private String fixedphone;
	private String province;
	private String city;
	private String county;
	private String consigneeaddress;
	private String zipcode;
	private String email;
	private String consigneeconfig;
	private String remark;

	// Constructors

	/** default constructor */
	public GeAddresseeConfig() {
	}

	/** minimal constructor */
	public GeAddresseeConfig(String addresseeconfigno, GeProductMain geProductMain) {
		this.addresseeconfigno = addresseeconfigno;
		this.geProductMain = geProductMain;
	}

	/** full constructor */
	public GeAddresseeConfig(String addresseeconfigno, String consigneename,
			String telephone, String fixedphone, String province, String city,
			String county, String consigneeaddress, String zipcode,
			String email, String consigneeconfig, String remark,
			GeProductMain geProductMain) {
		this.addresseeconfigno = addresseeconfigno;
		this.consigneename = consigneename;
		this.telephone = telephone;
		this.fixedphone = fixedphone;
		this.province = province;
		this.city = city;
		this.county = county;
		this.consigneeaddress = consigneeaddress;
		this.zipcode = zipcode;
		this.email = email;
		this.consigneeconfig = consigneeconfig;
		this.remark = remark;
		this.geProductMain = geProductMain;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "ADDRESSEECONFIGNO", unique = true, nullable = false)
	public String getAddresseeconfigno() {
		return this.addresseeconfigno;
	}

	public void setAddresseeconfigno(String addresseeconfigno) {
		this.addresseeconfigno = addresseeconfigno;
	}

	@Column(name = "CONSIGNEENAME", length = 10)
	public String getConsigneename() {
		return this.consigneename;
	}

	public void setConsigneename(String consigneename) {
		this.consigneename = consigneename;
	}

	@Column(name = "TELEPHONE", length = 10)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "FIXEDPHONE", length = 10)
	public String getFixedphone() {
		return this.fixedphone;
	}

	public void setFixedphone(String fixedphone) {
		this.fixedphone = fixedphone;
	}

	@Column(name = "PROVINCE", length = 10)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "CITY", length = 10)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "COUNTY", length = 10)
	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Column(name = "CONSIGNEEADDRESS", length = 10)
	public String getConsigneeaddress() {
		return this.consigneeaddress;
	}

	public void setConsigneeaddress(String consigneeaddress) {
		this.consigneeaddress = consigneeaddress;
	}

	@Column(name = "ZIPCODE", length = 10)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "EMAIL", length = 10)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "CONSIGNEECONFIG", length = 10)
	public String getConsigneeconfig() {
		return this.consigneeconfig;
	}

	public void setConsigneeconfig(String consigneeconfig) {
		this.consigneeconfig = consigneeconfig;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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