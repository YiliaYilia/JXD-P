package cn.com.sinosoft.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * GeProInsuredOccupation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_pro_insured_occupation")
public class GeProInsuredOccupation implements java.io.Serializable {

	// Fields

	private String insuredserialoccupationno;
	/** 属性被保人配置 */
	private GeProductInsuredconfig geProductInsuredconfig;
	private String occupationcode;

	// Constructors

	/** default constructor */
	public GeProInsuredOccupation() {
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "INSUREDSERIALOCCUPATIONNO", unique = true, nullable = false)
	public String getInsuredserialoccupationno() {
		return this.insuredserialoccupationno;
	}

	public void setInsuredserialoccupationno(String insuredserialoccupationno) {
		this.insuredserialoccupationno = insuredserialoccupationno;
	}


	@Column(name = "OCCUPATIONCODE", nullable = false, length = 50)
	public String getOccupationcode() {
		return this.occupationcode;
	}

	public void setOccupationcode(String occupationcode) {
		this.occupationcode = occupationcode;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INSUREDSERIALNO")
	public GeProductInsuredconfig getGeProductInsuredconfig() {
		return geProductInsuredconfig;
	}

	public void setGeProductInsuredconfig(
			GeProductInsuredconfig geProductInsuredconfig) {
		this.geProductInsuredconfig = geProductInsuredconfig;
	}

}