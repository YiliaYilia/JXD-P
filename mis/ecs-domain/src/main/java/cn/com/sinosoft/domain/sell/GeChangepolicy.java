package cn.com.sinosoft.domain.sell;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ge_changepolicy")
public class GeChangepolicy implements java.io.Serializable {
	private String id;
	private String policyno;// 保单号
	private String bank;// 银行名称
	private String bankcode;// 银行编码
	private String bankaccountnumber;// 银行账号
	private String bankProvince;// 开户行省
	private String bankCity;// 开户行市
	private String applicantname;// 投保人姓名
	private String bankC;// 新的银行名称
	private String bankaccountnumberC;// 新的银行账号
	private Date updateTime;// 修改时间
	private String modifyc;// 修改状态

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

	@Column(name = "POLICYNO")
	public String getPolicyno() {
		return policyno;
	}

	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}

	@Column(name ="BANK")
	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	@Column(name = "BANKCODE")
	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	@Column(name = "BANKACCOUNTNUMBER")
	public String getBankaccountnumber() {
		return bankaccountnumber;
	}

	public void setBankaccountnumber(String bankaccountnumber) {
		this.bankaccountnumber = bankaccountnumber;
	}

	@Column(name = "BANKPROVINCE")
	public String getBankProvince() {
		return bankProvince;
	}

	public void setBankProvince(String bankProvince) {
		this.bankProvince = bankProvince;
	}

	@Column(name = "BANKCITY")
	public String getBankCity() {
		return bankCity;
	}

	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	@Column(name = "APPLICANTNAME")
	public String getApplicantname() {
		return applicantname;
	}

	public void setApplicantname(String applicantname) {
		this.applicantname = applicantname;
	}

	@Column(name = "BANKC")
	public String getBankC() {
		return bankC;
	}

	public void setBankC(String bankC) {
		this.bankC = bankC;
	}

	@Column(name = "BANKACCOUNTNUMBERC")
	public String getBankaccountnumberC() {
		return bankaccountnumberC;
	}

	public void setBankaccountnumberC(String bankaccountnumberC) {
		this.bankaccountnumberC = bankaccountnumberC;
	}

	@Column(name = "UPDATETIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "MODIFYC")
	public String getModifyc() {
		return modifyc;
	}

	public void setModifyc(String modifyc) {
		this.modifyc = modifyc;
	}
	

	public GeChangepolicy(String policyno, String bank, String bankcode, String bankaccountnumber, String bankProvince,
			String bankCity, String applicantname, String bankC, String bankaccountnumberC, Date updateTime,
			String modifyc, String id) {
		super();
		this.policyno = policyno;
		this.bank = bank;
		this.bankcode = bankcode;
		this.bankaccountnumber = bankaccountnumber;
		this.bankProvince = bankProvince;
		this.bankCity = bankCity;
		this.applicantname = applicantname;
		this.bankC = bankC;
		this.bankaccountnumberC = bankaccountnumberC;
		this.updateTime = updateTime;
		this.modifyc = modifyc;
		this.id = id;
	}

	public GeChangepolicy() {
		super();
	}

}
