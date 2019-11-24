package cn.com.sinosoft.domain.soap.requset.acceptinsurance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 描述：头信息<br>
 * 作者：wanhonghui <br>
 * 修改日期：2013年8月15日上午11:05:35 <br>
 * E-mail:  wanhonghui@sinosoft.com.cn<br>
 */
public class BaseInfo {
	/**系统交易日期yyyymmdd 非空*/
	private String bankDate;
	/**系统交易时间hhddss非空*/
	private String bankTime;
	/**银行编码 默认为空*/
	private String bankCode;
	/**地区码  默认为空*/
	private String ZoneNo;
	/**网点编码 默认为空*/
	private String BrNo;
	/**柜员 默认为空*/
	private String tellerNo;
	/**订单号 非空*/
	private String transrNo;
	/**交易码 非空*/
	private String functionFlag;
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
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getZoneNo() {
		return ZoneNo;
	}
	public void setZoneNo(String zoneNo) {
		ZoneNo = zoneNo;
	}
	public String getBrNo() {
		return BrNo;
	}
	public void setBrNo(String brNo) {
		BrNo = brNo;
	}
	public String getTellerNo() {
		return tellerNo;
	}
	public void setTellerNo(String tellerNo) {
		this.tellerNo = tellerNo;
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
	
	
	
	
}
