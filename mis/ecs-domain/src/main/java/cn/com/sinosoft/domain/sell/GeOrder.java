package cn.com.sinosoft.domain.sell;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * GeOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_order")
public class GeOrder implements java.io.Serializable {

	// Fields

	private String orderno;
	private String ordercode;
	private String circpaymentno;
	private String userid;
	private Double orderamount;
	private Date paytime;
	private String paystatus;
	private String payway;
	private String invoiceflag;
	private String invoicetitle;
	private Date submittime;
	private String status;
	private String gatewayrno;//微信订单号
	private String bankorderno;
	private String surcharge;
	private String flowno;
	private String refundmentflag;
	private Date createdate;
	private String recipientname;//被保人姓名
	private String recipientmobile;
	private String zipcode;
	private String recipientaddress;
	private Date senddate;
	private String flag;
	private String distributionstatus;
	private String usertype;
	private String datasourse;
	private String encodemsg;
	private String signmsg;
	private String systemssn;
	private String agentidentitycode;
	private String paymentplatform;
	private String charityflag;

	
	private String bankcode;
	private String bankno;
	private String bankcardname;// 持卡人姓名

	private String refundComment;// 退款描述
	private String paymentComment; // 支付描述
	private String agentno; // 支付描述

	/**
	 *	官方网站001
	 * 官方微信公众号003
	 */
	private String channelCode; // 渠道代码
	private String channelName; // 渠道名称
	
	private Date starttime;
	private Date endtime;
	
	private String deptid;//组织机构
	
	private String coreproductcode;// 产品代码
	private String productname;// 产品名称
	
	private String healthflag; //勾选的状态
	private String applicantname;//投保人姓名
	private String policyno;
	private Set<GePolicy> policys;

	// Constructors
	/** default constructor */
	public GeOrder() {
	}

	/** minimal constructor */
	public GeOrder(String orderno, String userid, Double orderamount,
			String paystatus, Date submittime, String status) {
		this.orderno = orderno;
		this.userid = userid;
		this.orderamount = orderamount;
		this.paystatus = paystatus;
		this.submittime = submittime;
		this.status = status;
	}

	/** full constructor */
	public GeOrder(String orderno, String circpaymentno, String userid,
			Double orderamount, Date paytime, String paystatus, String payway,
			String invoiceflag, String invoicetitle, Date submittime,
			String status, String gatewayrno, String bankorderno,
			String surcharge, String flowno, String refundmentflag,
			Date createdate, String recipientname, String recipientmobile,
			String zipcode, String recipientaddress, Date senddate,
			String flag, String distributionstatus, String usertype,
			String datasourse, String encodemsg, String signmsg,
			String systemssn, String agentidentitycode, String paymentplatform) {
		this.orderno = orderno;
		this.circpaymentno = circpaymentno;
		this.userid = userid;
		this.orderamount = orderamount;
		this.paytime = paytime;
		this.paystatus = paystatus;
		this.payway = payway;
		this.invoiceflag = invoiceflag;
		this.invoicetitle = invoicetitle;
		this.submittime = submittime;
		this.status = status;
		this.gatewayrno = gatewayrno;
		this.bankorderno = bankorderno;
		this.surcharge = surcharge;
		this.flowno = flowno;
		this.refundmentflag = refundmentflag;
		this.createdate = createdate;
		this.recipientname = recipientname;
		this.recipientmobile = recipientmobile;
		this.zipcode = zipcode;
		this.recipientaddress = recipientaddress;
		this.senddate = senddate;
		this.flag = flag;
		this.distributionstatus = distributionstatus;
		this.usertype = usertype;
		this.datasourse = datasourse;
		this.encodemsg = encodemsg;
		this.signmsg = signmsg;
		this.systemssn = systemssn;
		this.agentidentitycode = agentidentitycode;
		this.paymentplatform = paymentplatform;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "ORDERNO", unique = true, nullable = false)
	public String getOrderno() {
		return this.orderno;
	}

	@ManyToMany(targetEntity = GePolicy.class)
	@JoinTable(name = "GE_ORDER_POLICY", joinColumns = { @JoinColumn(name = "ORDERNO") }, inverseJoinColumns = { @JoinColumn(name = "POLICYNO") })
	@Cascade(value={CascadeType.SAVE_UPDATE})
	public Set<GePolicy> getPolicys() {
		return policys;
	}

	public void setPolicys(Set<GePolicy> policys) {
		this.policys = policys;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	
	@Column(name = "ORDERCODE", length = 50)
	public String getOrdercode() {
		return ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	@Column(name = "CIRCPAYMENTNO", length = 50)
	public String getCircpaymentno() {
		return this.circpaymentno;
	}

	public void setCircpaymentno(String circpaymentno) {
		this.circpaymentno = circpaymentno;
	}

	@Column(name = "USERID", nullable = true)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "ORDERAMOUNT", nullable = false, precision = 16)
	public Double getOrderamount() {
		return this.orderamount;
	}

	public void setOrderamount(Double orderamount) {
		this.orderamount = orderamount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PAYTIME", length = 19)
	public Date getPaytime() {
		return this.paytime;
	}

	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

	@Column(name = "PAYSTATUS", nullable = false, length = 2)
	public String getPaystatus() {
		return this.paystatus;
	}

	public void setPaystatus(String paystatus) {
		this.paystatus = paystatus;
	}

	@Column(name = "PAYWAY", length = 2)
	public String getPayway() {
		return this.payway;
	}

	public void setPayway(String payway) {
		this.payway = payway;
	}

	@Column(name = "INVOICEFLAG", length = 2)
	public String getInvoiceflag() {
		return this.invoiceflag;
	}

	public void setInvoiceflag(String invoiceflag) {
		this.invoiceflag = invoiceflag;
	}

	@Column(name = "INVOICETITLE")
	public String getInvoicetitle() {
		return this.invoicetitle;
	}

	public void setInvoicetitle(String invoicetitle) {
		this.invoicetitle = invoicetitle;
	}

	@Temporal(TemporalType.TIMESTAMP) 
	@Column(name = "SUBMITTIME", nullable = false, length = 19)
	public Date getSubmittime() {
		return this.submittime;
	}

	public void setSubmittime(Date submittime) {
		this.submittime = submittime;
	}

	@Column(name = "STATUS", nullable = false, length = 2)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "GATEWAYRNO", length = 64)
	public String getGatewayrno() {
		return this.gatewayrno;
	}

	public void setGatewayrno(String gatewayrno) {
		this.gatewayrno = gatewayrno;
	}

	@Column(name = "BANKORDERNO", length = 64)
	public String getBankorderno() {
		return this.bankorderno;
	}

	public void setBankorderno(String bankorderno) {
		this.bankorderno = bankorderno;
	}

	@Column(name = "SURCHARGE", length = 10)
	public String getSurcharge() {
		return this.surcharge;
	}

	public void setSurcharge(String surcharge) {
		this.surcharge = surcharge;
	}

	@Column(name = "FLOWNO", length = 30)
	public String getFlowno() {
		return this.flowno;
	}

	public void setFlowno(String flowno) {
		this.flowno = flowno;
	}

	@Column(name = "REFUNDMENTFLAG", length = 1)
	public String getRefundmentflag() {
		return this.refundmentflag;
	}

	public void setRefundmentflag(String refundmentflag) {
		this.refundmentflag = refundmentflag;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATEDATE", length = 10)
	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Column(name = "RECIPIENTNAME", length = 30)
	public String getRecipientname() {
		return this.recipientname;
	}

	public void setRecipientname(String recipientname) {
		this.recipientname = recipientname;
	}

	@Column(name = "RECIPIENTMOBILE", length = 30)
	public String getRecipientmobile() {
		return this.recipientmobile;
	}

	public void setRecipientmobile(String recipientmobile) {
		this.recipientmobile = recipientmobile;
	}

	@Column(name = "ZIPCODE", length = 6)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "RECIPIENTADDRESS", length = 300)
	public String getRecipientaddress() {
		return this.recipientaddress;
	}

	public void setRecipientaddress(String recipientaddress) {
		this.recipientaddress = recipientaddress;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SENDDATE", length = 10)
	public Date getSenddate() {
		return this.senddate;
	}

	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}

	@Column(name = "FLAG", length = 10)
	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Column(name = "DISTRIBUTIONSTATUS", length = 2)
	public String getDistributionstatus() {
		return this.distributionstatus;
	}

	public void setDistributionstatus(String distributionstatus) {
		this.distributionstatus = distributionstatus;
	}

	@Column(name = "USERTYPE")
	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Column(name = "DATASOURSE", length = 2)
	public String getDatasourse() {
		return this.datasourse;
	}

	public void setDatasourse(String datasourse) {
		this.datasourse = datasourse;
	}

	@Column(name = "ENCODEMSG", length = 2000)
	public String getEncodemsg() {
		return this.encodemsg;
	}

	public void setEncodemsg(String encodemsg) {
		this.encodemsg = encodemsg;
	}

	@Column(name = "SIGNMSG", length = 2000)
	public String getSignmsg() {
		return this.signmsg;
	}

	public void setSignmsg(String signmsg) {
		this.signmsg = signmsg;
	}

	@Column(name = "SYSTEMSSN", length = 200)
	public String getSystemssn() {
		return this.systemssn;
	}

	public void setSystemssn(String systemssn) {
		this.systemssn = systemssn;
	}

	@Column(name = "AGENTIDENTITYCODE", length = 200)
	public String getAgentidentitycode() {
		return this.agentidentitycode;
	}

	public void setAgentidentitycode(String agentidentitycode) {
		this.agentidentitycode = agentidentitycode;
	}

	@Column(name = "PAYMENTPLATFORM", length = 2)
	public String getPaymentplatform() {
		return this.paymentplatform;
	}

	public void setPaymentplatform(String paymentplatform) {
		this.paymentplatform = paymentplatform;
	}

	@Column(name = "BANKCODE")
	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	@Column(name = "BANKNO")
	public String getBankno() {
		return bankno;
	}

	public void setBankno(String bankno) {
		this.bankno = bankno;
	}

	@Column(name = "BANKCARDNAME")
	public String getBankcardname() {
		return bankcardname;
	}

	public void setBankcardname(String bankcardname) {
		this.bankcardname = bankcardname;
	}

	@Column(name = "REFUNDCOMMENT")
	public String getRefundComment() {
		return refundComment;
	}

	public void setRefundComment(String refundComment) {
		this.refundComment = refundComment;
	}

	@Column(name = "PAYMENTCOMMENT")
	public String getPaymentComment() {
		return paymentComment;
	}

	public void setPaymentComment(String paymentComment) {
		this.paymentComment = paymentComment;
	}

	@Column(name = "CHANNEL_CODE")
	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	@Column(name = "CHANNEL_NAME")
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	@Column(name = "COREPRODUCTCODE")
	public String getCoreproductcode() {
		return coreproductcode;
	}

	public void setCoreproductcode(String coreproductcode) {
		this.coreproductcode = coreproductcode;
	}

	@Column(name = "PRODUCTNAME")
	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	@Column(name = "HEALTHFLAG")
	public String getHealthflag() {
		return healthflag;
	}

	public void setHealthflag(String healthflag) {
		this.healthflag = healthflag;
	}
	@Column(name = "applicantname")
	public String getApplicantname() {
		return applicantname;
	}

	public void setApplicantname(String applicantname) {
		this.applicantname = applicantname;
	}
	@Column(name = "policyno")
	public String getPolicyno() {
		return policyno;
	}

	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}
	@Column(name = "starttime")
	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	@Column(name = "endtime")
	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	@Column(name = "charityflag")
	public String getCharityflag() {
		return charityflag;
	}

	public void setCharityflag(String charityflag) {
		this.charityflag = charityflag;
	}

	@Column(name = "agentno")
	public String getAgentno() {
		return agentno;
	}

	public void setAgentno(String agentno) {
		this.agentno = agentno;
	}

	@Column(name = "deptid")
	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	//////////////////////////
	
	
}