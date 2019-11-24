package cn.com.sinosoft.dto;

import java.util.Date;

/**
 * 描述：调用afterpay传递的DTO，用于更改数据库状态<br>
 * 作者：liyang <br>
 * 修改日期：2014-1-7下午05:52:46 <br>
 * E-mail:  <br>
 */
public class AfterPayDTO {
	private Date paytime;//支付时间
	private String paystatus;//支付状态0未支付1已支付2支付失败
	private String payway;//1:网上支付 2:电话支付 3:线下支付
	private String gatewayrno;//支付网关订单号
	private String bankcode;
	private String bankorderno;//银行订单号
	private String encodemsg;//支付网关返回加密信息
	private String signmsg;//支付网关返回签名信息
	private String systemsn;//支付网关系统流水号
	private String paymentplatform;//支付平台 0财付通1支付宝
	
	private String policyno;//保单号
	private String orderno;//订单号
	
	
	public String getPolicyno() {
		return policyno;
	}
	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public Date getPaytime() {
		return paytime;
	}
	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}
	public String getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(String paystatus) {
		this.paystatus = paystatus;
	}
	public String getPayway() {
		return payway;
	}
	public void setPayway(String payway) {
		this.payway = payway;
	}
	public String getGatewayrno() {
		return gatewayrno;
	}
	public void setGatewayrno(String gatewayrno) {
		this.gatewayrno = gatewayrno;
	}
	public String getBankcode() {
		return bankcode;
	}
	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}
	public String getBankorderno() {
		return bankorderno;
	}
	public void setBankorderno(String bankorderno) {
		this.bankorderno = bankorderno;
	}
	public String getEncodemsg() {
		return encodemsg;
	}
	public void setEncodemsg(String encodemsg) {
		this.encodemsg = encodemsg;
	}
	public String getSignmsg() {
		return signmsg;
	}
	public void setSignmsg(String signmsg) {
		this.signmsg = signmsg;
	}
	public String getSystemsn() {
		return systemsn;
	}
	public void setSystemsn(String systemsn) {
		this.systemsn = systemsn;
	}
	public String getPaymentplatform() {
		return paymentplatform;
	}
	public void setPaymentplatform(String paymentplatform) {
		this.paymentplatform = paymentplatform;
	}
	
	
	
}
