package cn.com.sinosoft.domain.sale;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

//import cn.com.sinosoft.domain.card.GeCardSaleRecord;

/**
 * GeOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_order")
public class GeOrder implements java.io.Serializable{

	// Fields

	private String orderno;
	private String ordercode;
	private String circpaymentno;
	private String userid;
	private Double orderamount;//订单金额=保费
	private Date paytime;
	/**
	 * 0：未支付，1:支付成功，2：未支付的已撤单，3：支付中，4：交易可疑，5，支付失败,6支付成功且退款成功的已撤单,7退款中(退款接收成功，
	 * 退款处理中，退款可疑) 可撤单状态：0,1,3,4,5,
	 * 
	 */
	private String paystatus;
	/**
	 * 支付类型，存编号
	 *	微信公众号支付（10）
	 *  微信扫码（11）
	 *	支付宝手机支付（21）
	 *	支付宝网银支付（22）
	 *	支付宝即时到账（20）
	 */
	private String payway;
	private String invoiceflag;
	private String invoicetitle;
	private Date submittime;
	/**
	 * 0：未对账，1:对账成功，2：对账失败，3本地成功，支付接口失败
	 */
	private String status;
	private String gatewayrno;//微信订单号
	private String giftStatus;//捐款进度
	private String bookStatus;//捐书进度
	/**
	 * 银行订单号
	 */
	private String bankorderno;
	private String surcharge;
	private String flowno;//交易流水号     为了避免支付宝无法选择其他支付方式支付的问题
	private String refundmentflag;
	private Date createdate;
	private String recipientname;
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
	private String preferentialcode;
	/**
	 * 1.微信
	 * 2.支付宝
	 */
	private String paymentplatform;
	private String bankcode;
	private String bankno;
	private String bankcardname;// 持卡人姓名

	private String refundComment;// 退款描述
	private String paymentComment; // 支付描述

	/**
	 * 官方网站001
	 * 官方微信公众号003
	 */
	private String channelCode; // 渠道代码
	private String channelName; // 渠道名称
	
	
	private String coreproductcode;// 产品代码
	private String productname;// 产品名称
	private String healthFlag;//健康标示
	private String applicantname;//投保人姓名
	private String policyno;//保单号
	private Double stipend; //助学金
	
	private Double bookmoney; //赠书金

	private String openid;
	private String charityflag;
	private Set<GePolicy> policys;
	private String agentNo;//推荐人编码
	private String brNo;
	private String deptid;
	private String contnumber;//投保份数
	
	@Column(name="contnumber")
	public String getContnumber() {
		return contnumber;
	}

	public void setContnumber(String contnumber) {
		this.contnumber = contnumber;
	}

	//银行代扣部分
	private String billingType; //支付方式（微信支付还是银行代收）
	private String bankBranchName;//银行分行的名称
	private String bankBranchCode;//银行编码
	private String bankProvince; //开户行省
	private String bankCity;//开户行市
	
//	private String renewalflag;//成长卫士续保标识
//	
//	@Column(name="RENEWALFLAG")
//	public String getRenewalflag() {
//		return renewalflag;
//	}
//
//	public void setRenewalflag(String renewalflag) {
//		this.renewalflag = renewalflag;
//	}

	/**
	 * 1,5.核保中  2.缴费中  3.已承保  4.投保失败 6.核保成功待支付
	 */
	private String orderstatus;
	@Column(name = "ORDER_STATUS")
	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	/**
	 * 桌面版01
	 * 移动版02
	 * 微信版03
	 */
	private String loginWay;

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


	public GeOrder(String orderno, String ordercode, String circpaymentno,
			String userid, Double orderamount, Date paytime, String paystatus,
			String payway, String invoiceflag, String invoicetitle,
			Date submittime, String status, String gatewayrno,
			String bankorderno, String surcharge, String flowno,
			String refundmentflag, Date createdate, String recipientname,
			String recipientmobile, String zipcode, String recipientaddress,
			Date senddate, String flag, String distributionstatus,
			String usertype, String datasourse, String encodemsg,
			String signmsg, String systemssn, String agentidentitycode,
			String preferentialcode, String paymentplatform, String bankcode,
			String bankno, String bankcardname, String refundComment,
			String paymentComment, String channelCode, String channelName,
			String coreproductcode, String productname, String healthFlag,
			String applicantname, String policyno, Double stipend,
			Double bookmoney, String openid, String charityflag,
			Set<GePolicy> policys, String loginWay, String businessType,
			String brNo,String bankCity,String bankProvince,String contnumber) {
		this.orderno = orderno;
		this.ordercode = ordercode;
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
		this.preferentialcode = preferentialcode;
		this.paymentplatform = paymentplatform;
		this.bankcode = bankcode;
		this.bankno = bankno;
		this.bankcardname = bankcardname;
		this.refundComment = refundComment;
		this.paymentComment = paymentComment;
		this.channelCode = channelCode;
		this.channelName = channelName;
		this.coreproductcode = coreproductcode;
		this.productname = productname;
		this.healthFlag = healthFlag;
		this.applicantname = applicantname;
		this.policyno = policyno;
		this.stipend = stipend;
		this.bookmoney = bookmoney;
		this.openid = openid;
		this.charityflag = charityflag;
		this.policys = policys;
		this.loginWay = loginWay;
		this.businessType = businessType;
		this.brNo = brNo;
		this.bankCity=bankCity;
		this.bankProvince=bankProvince;
		this.contnumber=contnumber;
//		this.renewalflag=renewalflag;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "ORDERNO", nullable = false)
	public String getOrderno() {
		return this.orderno;
	}
	
	@OneToMany(targetEntity = cn.com.sinosoft.domain.sale.GePolicy.class)
	@JoinTable(name = "GE_ORDER_POLICY", joinColumns = { @JoinColumn(name = "ORDERNO") }, inverseJoinColumns = { @JoinColumn(name = "POLICYNO") })
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	@Fetch(FetchMode.JOIN)
	public Set<GePolicy> getPolicys() {
		return policys;
	}

//	@OneToOne()
//	@JoinColumn(name = "CARDSALERECORDNO")
//	@Cascade(value = { CascadeType.SAVE_UPDATE })
//	public GeCardSaleRecord getCardSaleRecord() {
//		return cardSaleRecord;
//	}
//
//	public void setCardSaleRecord(GeCardSaleRecord cardSaleRecord) {
//		this.cardSaleRecord = cardSaleRecord;
//	}

	@Column(name = "BANKNO")
	public String getBankno() {
		return bankno;
	}

	public void setBankno(String bankno) {
		this.bankno = bankno;
	}

	@Column(name = "ORDERCODE")
	public String getOrdercode() {
		return ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public void setPolicys(Set<GePolicy> policys) {
		this.policys = policys;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	@Column(name = "BANKCODE", length = 20)
	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
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

	@Temporal(TemporalType.TIMESTAMP)
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDATE")
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SENDDATE")
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

	@Column(name = "BANKCARDNAME", length = 30)
	public String getBankcardname() {
		return bankcardname;
	}

	public void setBankcardname(String bankcardname) {
		this.bankcardname = bankcardname;
	}

	@Column(name = "CHANNEL_CODE", length = 100)
	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	@Column(name = "CHANNEL_NAME", length = 100)
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

	@Column(name = "PRODUCTNAME", length = 100)
	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	private String businessType;

	@Column(name = "BUSINESSTYPE", length = 20)
	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	@Column(name = "LOGIN_WAY", length = 30)
	public String getLoginWay() {
		return loginWay;
	}

	public void setLoginWay(String loginWay) {
		this.loginWay = loginWay;
	}
	@Column(name = "HealthFlag", length = 2)
	public String getHealthFlag() {
		return healthFlag;
	}

	public void setHealthFlag(String healthFlag) {
		this.healthFlag = healthFlag;
	}
	
	@Column(name = "Applicantname", length = 30)
	public String getApplicantname() {
		return applicantname;
	}

	public void setApplicantname(String applicantname) {
		this.applicantname = applicantname;
	}
	@Column(name = "policyno", length = 30)
	public String getPolicyno() {
		return policyno;
	}

	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}
	@Column(name = "preferentialcode")
	public String getPreferentialcode() {
		return preferentialcode;
	}

	public void setPreferentialcode(String preferentialcode) {
		this.preferentialcode = preferentialcode;
	}
	@Column(name = "STIPEND")
	public Double getStipend() {
		return stipend;
	}

	public void setStipend(Double stipend) {
		this.stipend = stipend;
	}
	@Column(name = "BOOKMONEY")
	public Double getBookmoney() {
		return bookmoney;
	}

	public void setBookmoney(Double bookmoney) {
		this.bookmoney = bookmoney;
	}
	@Column(name = "OPENID")
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Column(name = "CHARITYFLAG")
	public String getCharityflag() {
		return charityflag;
	}

	public void setCharityflag(String charityflag) {
		this.charityflag = charityflag;
	}
	@Column(name = "AGENTNO")
	public String getAgentNo() {
		return agentNo;
	}

	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}
	@Column(name = "GIFTSTATUS")
	public String getGiftStatus() {
		return giftStatus;
	}
	
	public void setGiftStatus(String giftStatus) {
		this.giftStatus = giftStatus;
	}
	@Column(name = "BOOKSTATUS")
	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	
	@Column(name = "BRNO")
	public String getBrNo() {
		return brNo;
	}

	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}

	@Column(name = "DEPTID")
	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	
	@Column(name = "BILLINGTYPE")
	public String getBillingType() {
		return billingType;
	}

	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

	@Column(name = "BANKBRANCHNAME")
	public String getBankBranchName() {
		return bankBranchName;
	}

	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
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
	
	@Column(name = "BANKBRANCHCODE")
	public String getBankBranchCode() { 
		return bankBranchCode;
	}

	public void setBankBranchCode(String bankBranchCode) {
		this.bankBranchCode = bankBranchCode;
	}
	
}