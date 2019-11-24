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
@Table(name = "ge_insurance_plan_account")
public class GeInsurancePlanAccount implements java.io.Serializable {

	// Fields

	private String accountno;
	private String accountcode;
	private String accountname;
	private Date createtime;
	private String operator;
	

	private GeInsurancePlan geInsurancePlan;

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "ACCOUNTNO", unique = true, nullable = false)
	public String getAccountno() {
		return this.accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	@Column(name = "ACCOUNTCODE")
	public String getAccountcode() {
		return this.accountcode;
	}

	public void setAccountcode(String accountcode) {
		this.accountcode = accountcode;
	}

	@Column(name = "ACCOUNTNAME", nullable = false, length = 100)
	public String getAccountname() {
		return this.accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	
	@Column(name = "CREATETIME", length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(name = "OPERATOR", length = 50)
	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
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