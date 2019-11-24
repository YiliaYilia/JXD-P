package cn.com.sinosoft.domain.product;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;

/**
 * @desc 追加投资
 * @author kathy.han
 * 
 */
@Entity
@Table(name = "GE_INVESTMENT")
public class GeInvestment implements java.io.Serializable {

	
	private String ID;		
	private String policyNo;  //保单号
	private String applicantName;//投保人
	private String accountBank; //开户行
	private String bankCardId;	//银行卡号
	private Date createTime; //操作时间
	private String amount;	//追加金额
	
	@Transient
	private  transient Date startTime; //查询开始时间
	@Transient
	private transient Date endTime;//查询截止时间
	
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "ID", unique = true, nullable = false)
	public String getID() {
		return ID;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	@Column(name = "policyno")
	public String getPolicyNo() {
		return policyNo;
	}
	
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	
	@Column(name = "applicantname")
	public String getApplicantName() {
		return applicantName;
	}
	
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	
	
	@Column(name = "accountbank")
	public String getAccountBank() {
		return accountBank;
	}
	
	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}
	
	@Column(name = "bankcardid")
	public String getBankCardId() {
		return bankCardId;
	}
	
	public void setBankCardId(String bankCardId) {
		this.bankCardId = bankCardId;
	}
	
	
	@Column(name = "createtime")
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Column(name = "amount")
	public String getAmount() {
		return amount;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Transient
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	@Transient
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
}

