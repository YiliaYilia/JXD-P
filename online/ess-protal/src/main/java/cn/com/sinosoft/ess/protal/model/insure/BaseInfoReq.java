package cn.com.sinosoft.ess.protal.model.insure;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 描述：信息头<br>
 * 作者：GHY <br>
 * 修改日期：2014-3-12下午02:58:08 <br>
 * E-mail: gaohongyang13607@sinosoft.com.cn <br>
 */
@XmlType(name="Head")
public class BaseInfoReq {
	
	private String bankDate;	/**系统交易日期yyyymmdd 非空*/
	private String bankTime;	/**系统交易时间hhddss非空*/
	private String bankCode;	/**银行编码 默认为空  银行代码 如：011工行，012广发,013电商平台*/
	private String ZoneNo;		/**地区码  默认为空*/
	private String transrNo;	/**订单号 非空  交易流水号*/
	private String functionFlag;/**交易码 非空*/
	private String tellerNo;	/**柜员 默认为空  交易单位(银行/农信社/经代公司),013电商平台*/
	private String tranSchnl;	/**渠道代码,11电商渠道 */
	
	@XmlElement(name="TranDate")
	public String getBankDate() {
		return bankDate;
	}
	public void setBankDate(String bankDate) {
		this.bankDate = bankDate;
	}
	
	@XmlElement(name="TranTime")
	public String getBankTime() {
		return bankTime;
	}
	public void setBankTime(String bankTime) {
		this.bankTime = bankTime;
	}
	
	@XmlElement(name="BankCode")
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	@XmlElement(name="ZoneNo")
	public String getZoneNo() {
		return ZoneNo;
	}
	public void setZoneNo(String zoneNo) {
		ZoneNo = zoneNo;
	}
	
	@XmlElement(name="TranSchnl")
	public String getTranSchnl() {
		return tranSchnl;
	}
	public void setTranSchnl(String tranSchnl) {
		this.tranSchnl = tranSchnl;
	}
	@XmlElement(name="TranCom")
	public String getTellerNo() {
		return tellerNo;
	}
	public void setTellerNo(String tellerNo) {
		this.tellerNo = tellerNo;
	}
	
	@XmlElement(name="TranNo")
	public String getTransrNo() {
		return transrNo;
	}
	public void setTransrNo(String transrNo) {
		this.transrNo = transrNo;
	}
	
	@XmlElement(name="FuncFlag")
	public String getFunctionFlag() {
		return functionFlag;
	}
	public void setFunctionFlag(String functionFlag) {
		this.functionFlag = functionFlag;
	}
	
}
