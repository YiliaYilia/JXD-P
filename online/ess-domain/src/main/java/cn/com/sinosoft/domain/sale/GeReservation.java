package cn.com.sinosoft.domain.sale;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
    




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

//import cn.com.sinosoft.domain.card.GeCardSaleRecord;

@Entity
@Table(name = "ge_Reservation")
public class GeReservation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
		/*订单编号*/
		private String reservationNo;

		/*订单号*/
		private String ordercode;
		/*第三方支付平台交易流水号*/
		private String circpaymentno;
		/*用户编号*/
		private String userid;
		/*订单金额*/
		private Double orderamount;
		/*支付完成时间*/
		private Date paytime;
		/**
		 * 0：未支付，1:支付成功，2：未支付的已撤单，3：支付中，4：交易可疑，5，支付失败,6支付成功且退款成功的已撤单,7退款中(退款接收成功，退款处理中，退款可疑)
		 * 可撤单状态：0,1,3,4,5,
		 * 
		 */
		private String paystatus;
		/*支付类型
			1.微信公众号支付（10）
			2.微信扫码（11）
			3．支付宝手机支付（21）
			4．支付宝网银支付（22）
			5．支付宝即时到账（20
		*/
		private String payway;
		
		private String invoiceflag;
		private String invoicetitle;
		private Date submittime;
		/**
		 * 0：未对账，1:对账成功，2：对账失败，3本地成功，支付接口失败
		 */
		private String status;
		private String gatewayrno;
		/**
		 * 银行订单号
		 */
		private String bankorderno;
		private String surcharge;
		private String flowno;
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
		/*
		登录方式
			1.移动端（MiniSite）
			2.桌面端(WebSite)
		*/
		private String datasourse;
		private String encodemsg;
		private String signmsg;
		private String systemssn;
		/*证件号*/
		private String agentidentitycode;
		/**
		 * 0是财付通，1是支付宝，3是工行支付,2 工行特色支付
		 */
		private String paymentplatform;
		private String bankcode;
		private String bankno;
		private String bankcardname;// 持卡人姓名

		private String refundComment;// 退款描述
		private String paymentComment; // 支付描述

		/**
		 *	官方网站001
		 * 官方微信公众号003
		 */
		
		private String channelCode; // 渠道代码
		private String channelName; // 渠道名称
		
		
		private String coreproductcode;// 产品代码
		private String productname;// 产品名称
		

		private List<GePolicy> policys = new ArrayList<GePolicy>() ;
//		private GeCardSaleRecord cardSaleRecord;
		
		/*阅读告知的勾选状态*/
		private boolean readInformStatus;
		
		/**
		 * 桌面版01
		 * 移动版02
		 * 微信版03
		 */
		private String loginWay;
		
		/*确认按钮的点击状态*/
		private boolean insureButtonStatus;
		
		/*营销员编号*/
		private String saleManCode;

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

		
		public GeReservation() {
			super();
		}

		public GeReservation(String reservationNo, String ordercode,
				String circpaymentno, String userid, Double orderamount,
				Date paytime, String paystatus, String payway,
				String invoiceflag, String invoicetitle, Date submittime,
				String status, String gatewayrno, String bankorderno,
				String surcharge, String flowno, String refundmentflag,
				Date createdate, String recipientname, String recipientmobile,
				String zipcode, String recipientaddress, Date senddate,
				String flag, String distributionstatus, String usertype,
				String datasourse, String encodemsg, String signmsg,
				String systemssn, String agentidentitycode,
				String paymentplatform, String bankcode, String bankno,
				String bankcardname, String refundComment,
				String paymentComment, String channelCode, String channelName,
				String coreproductcode, String productname,
				List<GePolicy> policys, 
//				GeCardSaleRecord cardSaleRecord,
				boolean readInformStatus, String loginWay,
				boolean insureButtonStatus, String saleManCode,
				String businessType) {
			super();
			this.reservationNo = reservationNo;
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
			this.policys = policys;
//			this.cardSaleRecord = cardSaleRecord;
			this.readInformStatus = readInformStatus;
			this.loginWay = loginWay;
			this.insureButtonStatus = insureButtonStatus;
			this.saleManCode = saleManCode;
			this.businessType = businessType;
		}

		// Constructors
		/** default constructor */
//		public GeOrder() {
//		}
//
//		/** minimal constructor */
//		public GeOrder(String orderno, String userid, Double orderamount, String paystatus, Date submittime, String status) {
//			this.orderno = orderno;
//			this.userid = userid;
//			this.orderamount = orderamount;
//			this.paystatus = paystatus;
//			this.submittime = submittime;
//			this.status = status;
//		}
//
//		/** full constructor */
//		public GeOrder(String orderno, String circpaymentno, String userid, Double orderamount, Date paytime, String paystatus, String payway, String invoiceflag, String invoicetitle, Date submittime, String status, String gatewayrno, String bankorderno, String surcharge, String flowno, String refundmentflag, Date createdate, String recipientname, String recipientmobile, String zipcode,
//				String recipientaddress, Date senddate, String flag, String distributionstatus, String usertype, String datasourse, String encodemsg, String signmsg, String systemssn, String agentidentitycode, String paymentplatform, String bankcardname, String bankcode, String paytype, Date termstart, Date termend, String channelCode, String channelName, String coreproductcode, String productname) {
//			this.orderno = orderno;
//			this.circpaymentno = circpaymentno;
//			this.userid = userid;
//			this.orderamount = orderamount;
//			this.paytime = paytime;
//			this.paystatus = paystatus;
//			this.payway = payway;
//			this.invoiceflag = invoiceflag;
//			this.invoicetitle = invoicetitle;
//			this.submittime = submittime;
//			this.status = status;
//			this.gatewayrno = gatewayrno;
//			this.bankorderno = bankorderno;
//			this.surcharge = surcharge;
//			this.flowno = flowno;
//			this.refundmentflag = refundmentflag;
//			this.createdate = createdate;
//			this.recipientname = recipientname;
//			this.recipientmobile = recipientmobile;
//			this.zipcode = zipcode;
//			this.recipientaddress = recipientaddress;
//			this.senddate = senddate;
//			this.flag = flag;
//			this.distributionstatus = distributionstatus;
//			this.usertype = usertype;
//			this.datasourse = datasourse;
//			this.encodemsg = encodemsg;
//			this.signmsg = signmsg;
//			this.systemssn = systemssn;
//			this.agentidentitycode = agentidentitycode;
//			this.paymentplatform = paymentplatform;
//			this.bankcardname = bankcardname;
//			this.bankcode = bankcode;
//			// this.paytype=paytype;
//
//			this.channelCode = channelCode;
//			this.channelName = channelName;
//			this.coreproductcode = coreproductcode;
//			this.productname = productname;
//		}

		@Id
		@GenericGenerator(name = "idGenerator", strategy = "uuid")
		@GeneratedValue(generator = "idGenerator")
		@Column(name = "RESERVATIONNO", nullable = false)
		public String getReservationNo() {
			return reservationNo;
		}

		public void setReservationNo(String reservationNo) {
			this.reservationNo = reservationNo;
		}		
		
		
		

//		@OneToOne()
//		@JoinColumn(name = "CARDSALERECORDNO")
//		@Cascade(value = { CascadeType.SAVE_UPDATE })
//		public GeCardSaleRecord getCardSaleRecord() {
//			return cardSaleRecord;
//		}
//
//		public void setCardSaleRecord(GeCardSaleRecord cardSaleRecord) {
//			this.cardSaleRecord = cardSaleRecord;
//		}

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
		
		@Column(name = "ReadInformStatus")
		public boolean isreadInformStatus() {
			return readInformStatus;
		}

		public void setReadInformStatus(boolean readInformStatus) {
			this.readInformStatus = readInformStatus;
		}
		@Column(name = "LOGIN_WAY")
		public String getLoginWay() {
			return loginWay;
		}

		public void setLoginWay(String loginWay) {
			this.loginWay = loginWay;
		}
		@Column(name = "InsureButtonStatus")
		public boolean isInsureButtonStatus() {
			return insureButtonStatus;
		}

		public void setInsureButtonStatus(boolean insureButtonStatus) {
			this.insureButtonStatus = insureButtonStatus;
		}
		@Column(name = "SaleManCode")
		public String getSaleManCode() {
			return saleManCode;
		}

		public void setSaleManCode(String saleManCode) {
			this.saleManCode = saleManCode;
		}

		public boolean isReadInformStatus() {
			return readInformStatus;
		}
		
		@ManyToMany(targetEntity=cn.com.sinosoft.domain.sale.GePolicy.class,mappedBy="geReservations"
				)
		@Cascade(value = { CascadeType.SAVE_UPDATE })
		//@JoinTable(name="GE_RESERVATION_POLICY",
		//joinColumns=@JoinColumn(name="RESERVATIONNO",referencedColumnName="reservationNo"),
		//inverseJoinColumns=@JoinColumn(name="POLICYNO",referencedColumnName="policyno"))
		public List<GePolicy> getPolicys() {
			return policys;
		}

		public void setPolicys(List<GePolicy> policys) {
			this.policys = policys;
		}		
		

}
