package cn.com.sinosoft.domain.product;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * GeInsurancePlanAccount entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_insurance_plan_accountscore")
public class GeInsurancePlanAccountScore implements java.io.Serializable {
	private String scoreno;
	private String scorecode;
	
	private String capacityname;
	private String capacitycode;
	
	private int maxscore;
	private int minscore;
	
	private String accounts;
	
	private GeInsurancePlan geInsurancePlan;

	
	
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "SCORENO", unique = true, nullable = false)
	public String getScoreno() {
		return scoreno;
	}


	public void setScoreno(String scoreno) {
		this.scoreno = scoreno;
	}

	@Column(name = "SCORECODE")
	public String getScorecode() {
		return scorecode;
	}


	public void setScorecode(String scorecode) {
		this.scorecode = scorecode;
	}

	@Column(name = "CAPACITYNAME")
	public String getCapacityname() {
		return capacityname;
	}


	public void setCapacityname(String capacityname) {
		this.capacityname = capacityname;
	}


	@Column(name = "CAPACITYCODE")
	public String getCapacitycode() {
		return capacitycode;
	}


	public void setCapacitycode(String capacitycode) {
		this.capacitycode = capacitycode;
	}

	@Column(name = "MAXSCORE")
	public int getMaxscore() {
		return maxscore;
	}


	public void setMaxscore(int maxscore) {
		this.maxscore = maxscore;
	}

	@Column(name = "MINSCORE")
	public int getMinscore() {
		return minscore;
	}


	public void setMinscore(int minscore) {
		this.minscore = minscore;
	}


	@Column(name = "ACCOUNTS")
	public String getAccounts() {
		return accounts;
	}


	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}


	@ManyToOne
	@JoinColumn(name="INSURANCEPLANNO")
	public GeInsurancePlan getGeInsurancePlan() {
		return geInsurancePlan;
	}

	
	public void setGeInsurancePlan(GeInsurancePlan geInsurancePlan) {
		this.geInsurancePlan = geInsurancePlan;
	}

	
	
	
	

}