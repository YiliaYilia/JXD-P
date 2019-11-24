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
 * GeProductEmergencyConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_product_emergency_config")
public class GeProductEmergencyConfig implements java.io.Serializable {

	// Fields

	private String emergencyconfigno;
	private String emername;
	private String mobile;
	private String emeremail;
	private GeProductMain geProductMain;


	// Constructors

	/** default constructor */
	public GeProductEmergencyConfig() {
	}

	/** minimal constructor */
	public GeProductEmergencyConfig(String emergencyconfigno,
			GeProductMain geProductMain) {
		this.emergencyconfigno = emergencyconfigno;
		this.geProductMain = geProductMain;
	}

	/** full constructor */
	public GeProductEmergencyConfig(String emergencyconfigno, String emername,
			String mobile, String emeremail, GeProductMain geProductMain) {
		this.emergencyconfigno = emergencyconfigno;
		this.emername = emername;
		this.mobile = mobile;
		this.emeremail = emeremail;
		this.geProductMain = geProductMain;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "EMERGENCYCONFIGNO", unique = true, nullable = false)
	public String getEmergencyconfigno() {
		return this.emergencyconfigno;
	}

	public void setEmergencyconfigno(String emergencyconfigno) {
		this.emergencyconfigno = emergencyconfigno;
	}

	@Column(name = "EMERNAME", length = 1)
	public String getEmername() {
		return this.emername;
	}

	public void setEmername(String emername) {
		this.emername = emername;
	}

	@Column(name = "MOBILE", length = 20)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "EMEREMAIL", length = 1)
	public String getEmeremail() {
		return this.emeremail;
	}

	public void setEmeremail(String emeremail) {
		this.emeremail = emeremail;
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