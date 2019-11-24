package cn.com.sinosoft.domain.payment;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * 保单支付信息日志表
 * @author LiYanhong
 *
 */
@Entity
@Table(name = "PROPOSAL_PAYMENT")
public class ProposalPayment implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2902122006996991401L;
	private String payId;
	private String merId;
	private String orderNo;//订单号
	private String flowno;//流水号
	private String transType;
	private String openBankId;
	private String cardType;
	private String userName;
	private String cardNo;
	private String certType;
	private String certId;
	private String curyId;
	private String transAmt;
	private String purpose;
	private String priv1;
	private String version;
	private String gateId;
	private String responseCode;
	private String transStat;
	private String tranSdate;
	private String transTime;
	private String creatDate;
	private String creatTime;
	private String proposalNo;
	private String messageStr;
	private String payNo;
	private String systemssn;
	private String reserved01;
	private String reserved02;
	private String settDate;
	private String openId;
	private String extend1;
	private String extend2;
	private String extend3;
	private String errorType;
	private String descriptionStr;
	private Date errorDate;
	private String payAccount;
	private String payBank;
	
	public ProposalPayment(){}

	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PAYID",unique = true, nullable = false,length = 32)
	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	@Column(name = "MERID", length = 15)
	public String getMerId() {
		return merId;
	}

	public void setMerId(String merId) {
		this.merId = merId;
	}
	
	@Column(name = "ORDERNO", length = 16)
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	@Column(name = "flowno", length = 30)
	public String getFlowno() {
		return flowno;
	}

	public void setFlowno(String flowno) {
		this.flowno = flowno;
	}

	@Column(name = "TRANSTYPE", length = 4)
	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	@Column(name = "OPENBANKID", length = 4)
	public String getOpenBankId() {
		return openBankId;
	}

	public void setOpenBankId(String openBankId) {
		this.openBankId = openBankId;
	}

	@Column(name = "CARDTYPE", length = 1)
	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	@Column(name = "USRNAME", length = 20)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "CARDNO", length = 25)
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	@Column(name = "CERTTYPE", length = 2)
	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	@Column(name = "CERTID", length = 25)
	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	@Column(name = "CURYID", length = 3)
	public String getCuryId() {
		return curyId;
	}

	public void setCuryId(String curyId) {
		this.curyId = curyId;
	}

	@Column(name = "TRANSAMT", length = 12)
	public String getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}

	@Column(name = "PURPOSE", length = 25)
	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Column(name = "PRIV1", length = 60)
	public String getPriv1() {
		return priv1;
	}

	public void setPriv1(String priv1) {
		this.priv1 = priv1;
	}

	@Column(name = "VARSION", length = 8)
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Column(name = "GATEID", length = 4)
	public String getGateId() {
		return gateId;
	}

	public void setGateId(String gateId) {
		this.gateId = gateId;
	}

	@Column(name = "RESPONSECODE", length = 2)
	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	@Column(name = "TRANSSTAT", length = 4)
	public String getTransStat() {
		return transStat;
	}

	public void setTransStat(String transStat) {
		this.transStat = transStat;
	}

	@Column(name = "TRANSDATE", length = 8)
	public String getTranSdate() {
		return tranSdate;
	}

	public void setTranSdate(String tranSdate) {
		this.tranSdate = tranSdate;
	}

	@Column(name = "TRANSTIME", length = 6)
	public String getTransTime() {
		return transTime;
	}

	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}

	@Column(name = "CREATDATE", length = 8)
	public String getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}

	@Column(name = "CREATTIME", length = 6)
	public String getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

	@Column(name = "PROPOSALNO", length = 100)
	public String getProposalNo() {
		return proposalNo;
	}

	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}

	@Column(name = "MESSAGESTR", length = 200)
	public String getMessageStr() {
		return messageStr;
	}

	public void setMessageStr(String messageStr) {
		this.messageStr = messageStr;
	}

	@Column(name = "PAYNO", length = 100)
	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	@Column(name = "SYSTEMSSN", length = 100)
	public String getSystemssn() {
		return systemssn;
	}

	public void setSystemssn(String systemssn) {
		this.systemssn = systemssn;
	}

	@Column(name = "RESERVED01", length = 200)
	public String getReserved01() {
		return reserved01;
	}

	public void setReserved01(String reserved01) {
		this.reserved01 = reserved01;
	}

	@Column(name = "RESERVED02", length = 200)
	public String getReserved02() {
		return reserved02;
	}

	public void setReserved02(String reserved02) {
		this.reserved02 = reserved02;
	}

	@Column(name = "SETTDATE", length = 20)
	public String getSettDate() {
		return settDate;
	}

	public void setSettDate(String settDate) {
		this.settDate = settDate;
	}

	@Column(name = "OPENID", length = 30)
	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	@Column(name = "EXTEND1", length = 20)
	public String getExtend1() {
		return extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	@Column(name = "EXTEND2", length = 20)
	public String getExtend2() {
		return extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

	@Column(name = "EXTEND3", length = 20)
	public String getExtend3() {
		return extend3;
	}

	public void setExtend3(String extend3) {
		this.extend3 = extend3;
	}

	@Column(name = "ERRORTYPE", length = 20)
	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	@Column(name = "DESCRIPTIONSTR", length = 100)
	public String getDescriptionStr() {
		return descriptionStr;
	}

	public void setDescriptionStr(String descriptionStr) {
		this.descriptionStr = descriptionStr;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ERRORDATE")
	public Date getErrorDate() {
		return errorDate;
	}

	public void setErrorDate(Date errorDate) {
		this.errorDate = errorDate;
	}

	@Column(name = "PAYACCOUNT")
	public String getPayAccount() {
		return payAccount;
	}

	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}

	@Column(name = "PAYBANK")
	public String getPayBank() {
		return payBank;
	}

	public void setPayBank(String payBank) {
		this.payBank = payBank;
	}
	
	
	
}
