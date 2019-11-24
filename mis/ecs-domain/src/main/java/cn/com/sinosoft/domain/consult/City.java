package cn.com.sinosoft.domain.consult;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * City entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CITY", schema = "MIS")
public class City implements java.io.Serializable {


	/**
	 * City.java 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String code;
	private String name;
	private String provincecode;

	// Constructors

	/** default constructor */
	public City() {
	}
	

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, precision = 11, scale = 0)
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

	@Column(name = "PROVINCECODE", nullable = false, length = 6)
	public String getProvincecode() {
		return this.provincecode;
	}

	public void setProvincecode(String provincecode) {
		this.provincecode = provincecode;
	}
}