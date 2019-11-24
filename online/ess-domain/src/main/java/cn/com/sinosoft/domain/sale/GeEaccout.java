package cn.com.sinosoft.domain.sale;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * 存储对账异常的保单，1支付成功承保失败 2支付成功，承保成功，对账失败
 * @author lwy
 *
 */

@Entity
@Table(name = "GEACCOUNT")
public class GeEaccout implements java.io.Serializable{
	private String orderno;//主键
	private String ordercode;//订单号
	private String circpaymentno;//微信订单号
	private String userid;//用户的openId
	private Double orderamount;//保额
	private double prem;//保费
	private String applicantname;//投保人姓名
	private String applicantPhone;//投保人手机
	private String insuredname;//被保人姓名
	private String agentcode;//推荐人编码
	private String prodoctcode;//产品编号：天天保:TATIANB02
	private String paytime;//交易时间
	private String flowno;//交易流水号,银保通100接口返回
	private String refundmentflag;//退款标识
	private String payBank;//付款银行
	private String refundComment;// 退款描述
	private String paymentComment; // 支付描述
	private String channelCode; // 渠道代码
	private String channelName; // 渠道名称
	private String productname;// 产品名称
	private String exceptionCode;//异常编码 1支付成功承保失败
	

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

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "ORDERNO", nullable = false)
	public String getOrderno() {
		return this.orderno;
	}

	@Column(name = "ORDERCODE")
	public String getOrdercode() {
		return ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}


	public void setOrderno(String orderno) {
		this.orderno = orderno;
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


	@Column(name = "CHANNELCODE", length = 100)
	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	@Column(name = "CHANNELNAME", length = 100)
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}


	@Column(name = "PRODUCTNAME", length = 100)
	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

//	private String businessType;
//
//	@Column(name = "BUSINESSTYPE", length = 20)
//	public String getBusinessType() {
//		return businessType;
//	}
//
//	public void setBusinessType(String businessType) {
//		this.businessType = businessType;
//	}
//	@Column(name = "payType", length = 30)
//	public String getPayType() {
//		return payBank;
//	}
//
//	public void setPayType(String payType) {
//		this.payBank = payType;
//	}
	@Column(name = "PAYTIME", length = 30)
	public String getPaytime() {
		return paytime;
	}
	public void setPaytime(String paytime) {
		this.paytime = paytime;
	}
	
	@Column(name = "PREM", length = 30)
	public double getPrem() {
		return prem;
	}

	public void setPrem(double prem) {
		this.prem = prem;
	}
	@Column(name = "APPLICANTNAME", length = 30)
	public String getApplicantname() {
		return applicantname;
	}

	public void setApplicantname(String applicantname) {
		this.applicantname = applicantname;
	}
	@Column(name = "APPLICANTPHONE", length = 30)
	public String getApplicantPhone() {
		return applicantPhone;
	}

	public void setApplicantPhone(String applicantPhone) {
		this.applicantPhone = applicantPhone;
	}
	@Column(name = "INSUREDNAME", length = 30)
	public String getInsuredname() {
		return insuredname;
	}

	public void setInsuredname(String insuredname) {
		this.insuredname = insuredname;
	}
	@Column(name = "AGENTCODE", length = 30)
	public String getAgentcode() {
		return agentcode;
	}

	public void setAgentcode(String agentcode) {
		this.agentcode = agentcode;
	}

	@Column(name = "PRODOCTCODE", length = 30)
	public String getProdoctcode() {
		return prodoctcode;
	}

	public void setProdoctcode(String prodoctcode) {
		this.prodoctcode = prodoctcode;
	}

	@Column(name = "payBank", length = 100)
	public String getPayBank() {
		return payBank;
	}

	public void setPayBank(String payBank) {
		this.payBank = payBank;
	}
	
	@Column(name = "exceptionCode", length = 100)
	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}


	
}
