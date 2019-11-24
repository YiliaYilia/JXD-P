package cn.com.sinosoft.dto.sell;

import java.util.List;

public class AccountDto{
	
  private String total;
  private List<AccountRow> rows;

  public String getTotal()
  {
    return this.total; }

  public void setTotal(String total) {
    this.total = total; }

  public List<AccountRow> getRows() {
    return this.rows; }

  public void setRows(List<AccountRow> rows) {
    this.rows = rows;
  }

  public static class AccountRow  {
	  private String orderno;//主键
		private String ordercode;//订单号
		private String circpaymentno;//交易流水号，100接口返回
		private String userid;//用户的openId
		private Double orderamount;//保额
		private Double prem;//保费
		private String applicantname;//投保人姓名
		private String applicantPhone;//投保人手机
		private String insuredname;//被保人姓名
		private String agentcode;//推荐人编码
		private String prodoctcode;//产品编号：天天保:TATIANB02
		private String paytime;//交易时间
		private String flowno;//交易流水号 
		private String refundmentflag;//退款标识
		private String payBank;//付款银行
		private String refundComment;// 退款描述
		private String paymentComment; // 支付描述
		private String channelCode; // 渠道代码
		private String channelName; // 渠道名称
		private String productname;// 产品名称
		private String exceptioncode;
		public String getOrderno() {
			return orderno;
		}
		public void setOrderno(String orderno) {
			this.orderno = orderno;
		}
		public String getOrdercode() {
			return ordercode;
		}
		public void setOrdercode(String ordercode) {
			this.ordercode = ordercode;
		}
		public String getCircpaymentno() {
			return circpaymentno;
		}
		public void setCircpaymentno(String circpaymentno) {
			this.circpaymentno = circpaymentno;
		}
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public Double getOrderamount() {
			return orderamount;
		}
		public void setOrderamount(Double orderamount) {
			this.orderamount = orderamount;
		}
		public double getPrem() {
			return prem;
		}
		public void setPrem(double prem) {
			this.prem = prem;
		}
		public String getApplicantname() {
			return applicantname;
		}
		public void setApplicantname(String applicantname) {
			this.applicantname = applicantname;
		}
		public String getApplicantPhone() {
			return applicantPhone;
		}
		public void setApplicantPhone(String applicantPhone) {
			this.applicantPhone = applicantPhone;
		}
		public String getInsuredname() {
			return insuredname;
		}
		public void setInsuredname(String insuredname) {
			this.insuredname = insuredname;
		}
		public String getAgentcode() {
			return agentcode;
		}
		public void setAgentcode(String agentcode) {
			this.agentcode = agentcode;
		}
		public String getProdoctcode() {
			return prodoctcode;
		}
		public void setProdoctcode(String prodoctcode) {
			this.prodoctcode = prodoctcode;
		}
		public String getPaytime() {
			return paytime;
		}
		public void setPaytime(String paytime) {
			this.paytime = paytime;
		}
		public String getFlowno() {
			return flowno;
		}
		public void setFlowno(String flowno) {
			this.flowno = flowno;
		}
		public String getRefundmentflag() {
			return refundmentflag;
		}
		public void setRefundmentflag(String refundmentflag) {
			this.refundmentflag = refundmentflag;
		}
		public String getPayBank() {
			return payBank;
		}
		public void setPayBank(String payBank) {
			this.payBank = payBank;
		}
		public String getRefundComment() {
			return refundComment;
		}
		public void setRefundComment(String refundComment) {
			this.refundComment = refundComment;
		}
		public String getPaymentComment() {
			return paymentComment;
		}
		public void setPaymentComment(String paymentComment) {
			this.paymentComment = paymentComment;
		}
		public String getChannelCode() {
			return channelCode;
		}
		public void setChannelCode(String channelCode) {
			this.channelCode = channelCode;
		}
		public String getChannelName() {
			return channelName;
		}
		public void setChannelName(String channelName) {
			this.channelName = channelName;
		}
		public String getProductname() {
			return productname;
		}
		public void setProductname(String productname) {
			this.productname = productname;
		}
		public String getExceptioncode() {
			return exceptioncode;
		}
		public void setExceptioncode(String exceptioncode) {
			this.exceptioncode = exceptioncode;
		}
		
		
  }
}