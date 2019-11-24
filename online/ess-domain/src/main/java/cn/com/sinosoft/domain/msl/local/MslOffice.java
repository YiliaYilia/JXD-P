package cn.com.sinosoft.domain.msl.local;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="MSL_Office_Info")
public class MslOffice implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	@Id
	@Column(name = "SerialNo", nullable = false)
	@GenericGenerator(name = "idGenerator", strategy = "native")
	@GeneratedValue(generator = "idGenerator")
	private String serialNo;
	/**
	 * 省名称
	 */
	@Column(name = "PROV_NM", nullable = false)
	private String provinceName;
	/**
	 * 市名称
	 */
	@Column(name = "CITY_NM", nullable = false)
	private String cityName;
	/**
	 *  （市）地区行政代码
	 */
	@Column(name = "CITY_CD", nullable = false)
	private String zoneNo;

	/**
	 * 服务网点名称
	 */
	@Column(name = "MSL_NM", nullable = false)
	private String name;
	
	/**
	 * 负责人
	 */
	@Column(name = "MSL_MANAGER", nullable = false)
	private String personInCharge;
	
	/**
	 * 服务网点地址
	 */
	@Column(name = "MSL_ADDRESS", nullable = false)
	private String address;
	
	/**
	 * 联系电话
	 */
	@Column(name = "MSL_TEL", nullable = false)
	private String phone;
	
	/**
	 * 传真
	 */
	@Column(name = "MSL_FAX", nullable = false)
	private String fax;
	
	/**
	 * 邮政编码
	 */
	@Column(name = "MSL_ZIPCODE", nullable = false)
	private String postalCode;
	
	/**
	 * 创建时间: 插入记录时的时间
	 */
	@Column(name = "CREATETIME", nullable = false)
	private Date createTime;
	
	/**
	 * 修改时间: 每次更新的时间
	 */
	@Column(name = "MODIFYTIME", nullable = false)
	private Date modifyTime;

	
	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPersonInCharge() {
		return personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	
	
	
	
}
