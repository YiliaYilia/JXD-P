package cn.com.sinosoft.domain.soap.response.acceptinsurance;

import java.io.Serializable;

public class BaseInfo implements Serializable{
	private String bankCode;
	private String zoneNo;
	private String brNo;
	private String transrNo;
	private String functionFlag;
	private String tellerNo;
	private String bankDate;
	private String bankTime;
	private String insuID;
	
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getZoneNo() {
		return zoneNo;
	}
	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getTransrNo() {
		return transrNo;
	}
	public void setTransrNo(String transrNo) {
		this.transrNo = transrNo;
	}
	public String getFunctionFlag() {
		return functionFlag;
	}
	public void setFunctionFlag(String functionFlag) {
		this.functionFlag = functionFlag;
	}
	public String getTellerNo() {
		return tellerNo;
	}
	public void setTellerNo(String tellerNo) {
		this.tellerNo = tellerNo;
	}
	public String getBankDate() {
		return bankDate;
	}
	public void setBankDate(String bankDate) {
		this.bankDate = bankDate;
	}
	public String getBankTime() {
		return bankTime;
	}
	public void setBankTime(String bankTime) {
		this.bankTime = bankTime;
	}
	public String getInsuID() {
		return insuID;
	}
	public void setInsuID(String insuID) {
		this.insuID = insuID;
	}
}
