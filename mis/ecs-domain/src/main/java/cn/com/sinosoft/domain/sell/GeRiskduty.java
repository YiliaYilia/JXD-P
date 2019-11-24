package cn.com.sinosoft.domain.sell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * GeRiskduty entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_riskduty")
public class GeRiskduty implements java.io.Serializable {

	// Fields

	private String riskdutyno;
	private String riskcode;
	private String dutycode;
	private String dutydesc;
	private String amount;
	private String premium;
	private String amountdesc;

	private GePolicy policy;
	
	// Constructors

	/** default constructor */
	public GeRiskduty() {
	}

	/** minimal constructor */
	public GeRiskduty(String riskdutyno) {
		this.riskdutyno = riskdutyno;
	}

	/** full constructor */
	public GeRiskduty(String riskdutyno,  String riskcode,
			String dutycode, String dutydesc, String amount, String premium,
			String amountdesc) {
		this.riskdutyno = riskdutyno;
		this.riskcode = riskcode;
		this.dutycode = dutycode;
		this.dutydesc = dutydesc;
		this.amount = amount;
		this.premium = premium;
		this.amountdesc = amountdesc;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "RISKDUTYNO", unique = true, nullable = false)
	public String getRiskdutyno() {
		return this.riskdutyno;
	}

	@ManyToOne 
	@JoinColumn(name="POLICYNO")
	@Cascade(value={CascadeType.SAVE_UPDATE})
	public GePolicy getPolicy() {
		return policy;
	}

	public void setPolicy(GePolicy policy) {
		this.policy = policy;
	}

	public void setRiskdutyno(String riskdutyno) {
		this.riskdutyno = riskdutyno;
	}


	@Column(name = "RISKCODE", length = 50)
	public String getRiskcode() {
		return this.riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode;
	}

	@Column(name = "DUTYCODE", length = 50)
	public String getDutycode() {
		return this.dutycode;
	}

	public void setDutycode(String dutycode) {
		this.dutycode = dutycode;
	}

	@Column(name = "DUTYDESC")
	public String getDutydesc() {
		return this.dutydesc;
	}

	public void setDutydesc(String dutydesc) {
		this.dutydesc = dutydesc;
	}

	@Column(name = "AMOUNT", length = 50)
	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Column(name = "PREMIUM", length = 50)
	public String getPremium() {
		return this.premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	@Column(name = "AMOUNTDESC")
	public String getAmountdesc() {
		return this.amountdesc;
	}

	public void setAmountdesc(String amountdesc) {
		this.amountdesc = amountdesc;
	}

}