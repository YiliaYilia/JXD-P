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


@Entity
@Table(name = "ge_accountinfo")
public class GeAccountInfo {

	private String id;
	private String accountno;
	private double scale;
	private GePolicy policy;
	private String accountname;
	private String accountcode;
	

	@Column(name = "ACCOUNTCODE")
	public String getAccountcode() {
		return accountcode;
	}
	public void setAccountcode(String accountcode) {
		this.accountcode = accountcode;
	}
	@Column(name = "ACCOUNTNAME")
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	@ManyToOne(targetEntity = GePolicy.class)
	@JoinColumn(name = "POLICYNO")
	@Cascade(value={CascadeType.SAVE_UPDATE})
	public GePolicy getPolicy() {
		return policy;
	}
	public void setPolicy(GePolicy policy) {
		this.policy = policy;
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

	@Column(name = "ACCOUNTNO")
	public String getAccountno() {
		return accountno;
	}
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	@Column(name = "SCALE")
	public double getScale() {
		return scale;
	}
	public void setScale(double scale) {
		this.scale = scale;
	}
	
	
}
