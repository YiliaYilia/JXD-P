package cn.com.sinosoft.domain.sell;

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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * GeBeneficiary entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_beneficiary")
public class GeBeneficiary implements java.io.Serializable {

	// Fields

	private String beneficiaryno;
	private String benname;
	private String bensex;
	private Date benbirthday;
	private String benidtype;
	private String benidnumber;
	private String benaddress;
	private String benzipcode;
	private String benemail;
	private String bencomphone;
	private String benhomephone;
	private String benmobilephone;
	private String beninterestpercent;
	private String benorder;
	private String benrate;
	private String bentype;
	private String benrelationtopins;

	
	private GePolicy policy;
	// Constructors

	/** default constructor */
	public GeBeneficiary() {
	}

	/** minimal constructor */
	public GeBeneficiary(String beneficiaryno) {
		this.beneficiaryno = beneficiaryno;
	}

	/** full constructor */
	public GeBeneficiary(String beneficiaryno,  String benname,
			String bensex, Date benbirthday, String benidtype,
			String benidnumber, String benaddress, String benzipcode,
			String benemail, String bencomphone, String benhomephone,
			String benmobilephone, String beninterestpercent, String benorder,
			String benrate, String bentype, String benrelationtopins) {
		this.beneficiaryno = beneficiaryno;
		this.benname = benname;
		this.bensex = bensex;
		this.benbirthday = benbirthday;
		this.benidtype = benidtype;
		this.benidnumber = benidnumber;
		this.benaddress = benaddress;
		this.benzipcode = benzipcode;
		this.benemail = benemail;
		this.bencomphone = bencomphone;
		this.benhomephone = benhomephone;
		this.benmobilephone = benmobilephone;
		this.beninterestpercent = beninterestpercent;
		this.benorder = benorder;
		this.benrate = benrate;
		this.bentype = bentype;
		this.benrelationtopins = benrelationtopins;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "BENEFICIARYNO", unique = true, nullable = false)
	public String getBeneficiaryno() {
		return this.beneficiaryno;
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

	public void setBeneficiaryno(String beneficiaryno) {
		this.beneficiaryno = beneficiaryno;
	}

	@Column(name = "BENNAME", length = 50)
	public String getBenname() {
		return this.benname;
	}

	public void setBenname(String benname) {
		this.benname = benname;
	}

	@Column(name = "BENSEX", length = 2)
	public String getBensex() {
		return this.bensex;
	}

	public void setBensex(String bensex) {
		this.bensex = bensex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BENBIRTHDAY", length = 19)
	public Date getBenbirthday() {
		return this.benbirthday;
	}

	public void setBenbirthday(Date benbirthday) {
		this.benbirthday = benbirthday;
	}

	@Column(name = "BENIDTYPE", length = 10)
	public String getBenidtype() {
		return this.benidtype;
	}

	public void setBenidtype(String benidtype) {
		this.benidtype = benidtype;
	}

	@Column(name = "BENIDNUMBER", length = 50)
	public String getBenidnumber() {
		return this.benidnumber;
	}

	public void setBenidnumber(String benidnumber) {
		this.benidnumber = benidnumber;
	}

	@Column(name = "BENADDRESS")
	public String getBenaddress() {
		return this.benaddress;
	}

	public void setBenaddress(String benaddress) {
		this.benaddress = benaddress;
	}

	@Column(name = "BENZIPCODE", length = 6)
	public String getBenzipcode() {
		return this.benzipcode;
	}

	public void setBenzipcode(String benzipcode) {
		this.benzipcode = benzipcode;
	}

	@Column(name = "BENEMAIL", length = 50)
	public String getBenemail() {
		return this.benemail;
	}

	public void setBenemail(String benemail) {
		this.benemail = benemail;
	}

	@Column(name = "BENCOMPHONE", length = 20)
	public String getBencomphone() {
		return this.bencomphone;
	}

	public void setBencomphone(String bencomphone) {
		this.bencomphone = bencomphone;
	}

	@Column(name = "BENHOMEPHONE", length = 20)
	public String getBenhomephone() {
		return this.benhomephone;
	}

	public void setBenhomephone(String benhomephone) {
		this.benhomephone = benhomephone;
	}

	@Column(name = "BENMOBILEPHONE", length = 20)
	public String getBenmobilephone() {
		return this.benmobilephone;
	}

	public void setBenmobilephone(String benmobilephone) {
		this.benmobilephone = benmobilephone;
	}

	@Column(name = "BENINTERESTPERCENT", length = 10)
	public String getBeninterestpercent() {
		return this.beninterestpercent;
	}

	public void setBeninterestpercent(String beninterestpercent) {
		this.beninterestpercent = beninterestpercent;
	}

	@Column(name = "BENORDER", length = 10)
	public String getBenorder() {
		return this.benorder;
	}

	public void setBenorder(String benorder) {
		this.benorder = benorder;
	}

	@Column(name = "BENRATE", length = 10)
	public String getBenrate() {
		return this.benrate;
	}

	public void setBenrate(String benrate) {
		this.benrate = benrate;
	}

	@Column(name = "BENTYPE", length = 10)
	public String getBentype() {
		return this.bentype;
	}

	public void setBentype(String bentype) {
		this.bentype = bentype;
	}

	@Column(name = "BENRELATIONTOPINS", length = 10)
	public String getBenrelationtopins() {
		return this.benrelationtopins;
	}

	public void setBenrelationtopins(String benrelationtopins) {
		this.benrelationtopins = benrelationtopins;
	}

}