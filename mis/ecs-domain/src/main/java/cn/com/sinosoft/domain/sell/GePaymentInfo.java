package cn.com.sinosoft.domain.sell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ge_paymentinfo")
public class GePaymentInfo {

	private String id;
	private String paytype;
	private double premiumeach;
	private GePolicy policy;
	private String investment;
	
	

	@Column(name = "INVESTMENT")
	public String getInvestment() {
		return investment;
	}
	public void setInvestment(String investment) {
		this.investment = investment;
	}
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "ID", unique = true, nullable = false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@OneToOne 
	@JoinColumn(name="POLICYNO")
	@Cascade(value={CascadeType.SAVE_UPDATE})
	public GePolicy getPolicy() {
		return policy;
	}
	public void setPolicy(GePolicy policy) {
		this.policy = policy;
	}
	@Column(name = "PAYTYPE")
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	@Column(name = "PREMIUMEACH", precision = 14)
	public double getPremiumeach() {
		return premiumeach;
	}
	public void setPremiumeach(double premiumeach) {
		this.premiumeach = premiumeach;
	}
	
	
	
}
