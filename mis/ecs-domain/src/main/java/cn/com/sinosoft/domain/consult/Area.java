package cn.com.sinosoft.domain.consult;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "AREA", schema = "MIS")
public class Area implements java.io.Serializable {
	/**
	 * Area.java 
	 */
	private static final long serialVersionUID = 2779339903677796156L;
	private Long id;
	private String code;
	private String name;
	private String citycode;


	/** default constructor */
	public Area() {
		
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CODE", nullable = false, length = 6)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "NAME", nullable = false, length = 40)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "CITYCODE", nullable = false, length = 6)
	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

}