package cn.com.sinosoft.domain.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * GeInsurancePlan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_insurance_plan")
public class GeInsurancePlan implements java.io.Serializable {

	// Fields

	private String insuranceplanno;
	private String planname;
	private String initialcost;
	private String initialcosttype;
	private String paytype;
	private String investment;
	
	private GeProductMain geProductMain;
	
	private List<GeInsurancePlanAccount> geInsurancePlanAccounts = new ArrayList<GeInsurancePlanAccount>(0);
	private List<GeInsurancePlanAccountScore>  geInsurancePlanAccountScores = new ArrayList<GeInsurancePlanAccountScore>();
	// Constructors

	/** default constructor */
	public GeInsurancePlan() {
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "INSURANCEPLANNO", unique = true, nullable = false)
	public String getInsuranceplanno() {
		return this.insuranceplanno;
	}

	public void setInsuranceplanno(String insuranceplanno) {
		this.insuranceplanno = insuranceplanno;
	}

	

	@Column(name = "PLANNAME", nullable = false, length = 100)
	public String getPlanname() {
		return this.planname;
	}

	public void setPlanname(String planname) {
		this.planname = planname;
	}

	@Column(name = "INITIALCOST", nullable = false, length = 10)
	public String getInitialcost() {
		return this.initialcost;
	}

	public void setInitialcost(String initialcost) {
		this.initialcost = initialcost;
	}
	
	@Column(name = "INITIALCOSTTYPE", nullable = false, length = 10)
	public String getInitialcosttype() {
		return initialcosttype;
	}

	public void setInitialcosttype(String initialcosttype) {
		this.initialcosttype = initialcosttype;
	}

	@Column(name = "PAYTYPE", nullable = false, length = 10)
	public String getPaytype() {
		return this.paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	@Column(name = "INVESTMENT", length = 10)
	public String getInvestment() {
		return this.investment;
	}

	public void setInvestment(String investment) {
		this.investment = investment;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COREPRODUCTCODE")
	public GeProductMain getGeProductMain() {
		return geProductMain;
	}

	public void setGeProductMain(GeProductMain geProductMain) {
		this.geProductMain = geProductMain;
	}

	@OneToMany(fetch=FetchType.LAZY,mappedBy="geInsurancePlan")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeInsurancePlanAccount> getGeInsurancePlanAccounts() {
		return geInsurancePlanAccounts;
	}

	public void setGeInsurancePlanAccounts(
			List<GeInsurancePlanAccount> geInsurancePlanAccounts) {
		this.geInsurancePlanAccounts = geInsurancePlanAccounts;
	}

	@OneToMany(fetch=FetchType.LAZY,mappedBy="geInsurancePlan")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeInsurancePlanAccountScore> getGeInsurancePlanAccountScores() {
		return geInsurancePlanAccountScores;
	}

	public void setGeInsurancePlanAccountScores(
			List<GeInsurancePlanAccountScore> geInsurancePlanAccountScores) {
		this.geInsurancePlanAccountScores = geInsurancePlanAccountScores;
	}
	
	

	
}