package cn.com.sinosoft.msl.model.insurancePolicy.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"tranSchnl","zoneNo","oldTranNo","proposalPrtNo","contNo","sysRefNumber",
		"channelCd","payType","payDate","payTime","subPrem"})
public class Body {

	/*渠道代码*/
	private String tranSchnl="";
	/*地区编码,城市级编码*/
	private String zoneNo="";
	/*原核保交易流水号*/
	private String oldTranNo="";
	/*订单号*/
	private String proposalPrtNo="";
	/*保单号*/
	private String contNo="";
	/*第三方支付平台交易流水号*/
	private String sysRefNumber="";
	/*支付平台*/
	private String channelCd="";
	/*支付方式*/
	private String payType="";
	/*支付日期 YYYYMMDD*/
	private String payDate="";
	/*支付时间 HHMMSS*/
	private String payTime="";
	/*总保费*/
	private String subPrem="";
	
	@XmlElement(name="TranSchnl")
	public String getTranSchnl() {
		return tranSchnl;
	}
	public void setTranSchnl(String tranSchnl) {
		this.tranSchnl = tranSchnl;
	}
	@XmlElement(name="ZoneNo")
	public String getZoneNo() {
		return zoneNo;
	}
	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}
	@XmlElement(name="OldTranNo")
	public String getOldTranNo() {
		return oldTranNo;
	}
	
	public void setOldTranNo(String oldTranNo) {
		this.oldTranNo = oldTranNo;
	}
	@XmlElement(name="ProposalPrtNo")
	public String getProposalPrtNo() {
		return proposalPrtNo;
	}
	public void setProposalPrtNo(String proposalPrtNo) {
		this.proposalPrtNo = proposalPrtNo;
	}
	@XmlElement(name="ContNo")
	public String getContNo() {
		return contNo;
	}
	public void setContNo(String contNo) {
		this.contNo = contNo;
	}
	@XmlElement(name="SYS_REF_NUMBER")
	public String getSysRefNumber() {
		return sysRefNumber;
	}
	public void setSysRefNumber(String sysRefNumber) {
		this.sysRefNumber = sysRefNumber;
	}
	@XmlElement(name="CHANNEL_CD")
	public String getChannelCd() {
		return channelCd;
	}
	public void setChannelCd(String channelCd) {
		this.channelCd = channelCd;
	}
	@XmlElement(name="PAY_TYPE")
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	@XmlElement(name="PAY_Date")
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	@XmlElement(name="PAY_TIME")
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	@XmlElement(name="SUBPREM")
	public String getSubPrem() {
		return subPrem;
	}
	public void setSubPrem(String subPrem) {
		this.subPrem = subPrem;
	}
	
	
}
