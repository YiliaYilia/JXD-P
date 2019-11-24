package cn.com.sinosoft.domain.msl.remote;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="TWRK_ADMIN_DIVISION")
public class MslRegion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	@Id
	@Column(name = "SeqNo", nullable = false)
	@GenericGenerator(name = "idGenerator", strategy = "native")
	@GeneratedValue(generator = "idGenerator")
	private Integer serialNo;
	/**
	 * 省份名称
	 */
	@Column(name = "PROV_NM", nullable = false)
	private String provinceName;
	
	/**
	 * 省份代码
	 */
	@Column(name = "PROV_CD", nullable = false)
	private Integer provinceCode;
	
	/**
	 * 城市名称
	 */
	@Column(name = "CITY_NM", nullable = false)
	private String cityName;
	
	/**
	 * 城市代码
	 */
	@Column(name = "CITY_CD", nullable = false)
	private Integer cityCode;
	
	/**
	 * 区县名称
	 */
	@Column(name = "CNTY_NM", nullable = false)
	private String countyName;
	
	/**
	 * 区县代码
	 */
	@Column(name = "CNTY_CD", nullable = false)
	private Integer countyCode;

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Integer getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(Integer provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public Integer getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(Integer countyCode) {
		this.countyCode = countyCode;
	}

	
	
	
}
