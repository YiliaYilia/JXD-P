package cn.com.sinosoft.domain.sale;

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

	// wanglaiping
	private String accountType;// 银行卡类型
	private String accountBankName;// 银行名称
	private String accountBankProviceCode;// 开户省份代码
	private String accountBankCityCode;// 开户城市代码
	private String accountBankProviceName;// 开户省份
	private String accountBankCityName;// 开户城市

	@Column(name = "ACCOUNTTYPE")
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Column(name = "ACCOUNTBANKNAME")
	public String getAccountBankName() {
		return accountBankName;
	}

	public void setAccountBankName(String accountBankName) {
		this.accountBankName = accountBankName;
	}

	@Column(name = "ACCOUNTBANKPROVICECODE")
	public String getAccountBankProviceCode() {
		return accountBankProviceCode;
	}

	public void setAccountBankProviceCode(String accountBankProviceCode) {
		this.accountBankProviceCode = accountBankProviceCode;
	}

	@Column(name = "ACCOUNTBANKCITYCODE")
	public String getAccountBankCityCode() {
		return accountBankCityCode;
	}

	public void setAccountBankCityCode(String accountBankCityCode) {
		this.accountBankCityCode = accountBankCityCode;
	}

	@Column(name = "ACCOUNTBANKPROVICENAME")
	public String getAccountBankProviceName() {
		return accountBankProviceName;
	}

	public void setAccountBankProviceName(String accountBankProviceName) {
		this.accountBankProviceName = accountBankProviceName;
	}

	@Column(name = "ACCOUNTBANKCITYNAME")
	public String getAccountBankCityName() {
		return accountBankCityName;
	}

	public void setAccountBankCityName(String accountBankCityName) {
		this.accountBankCityName = accountBankCityName;
	}

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

	@ManyToOne(targetEntity = cn.com.sinosoft.domain.sale.GePolicy.class)
	@JoinColumn(name = "POLICYNO")
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	public GePolicy getPolicy() {
		return policy;
	}

	public void setPolicy(GePolicy policy) {
		this.policy = policy;
	}

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "ID", nullable = false)
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
