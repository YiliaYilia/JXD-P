/**
 * File Name:BaseInfoYB.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:shixiu
 * @version:v1.0
 * Createdate:2014-3-12上午10:21:32
 */
package cn.com.sinosoft.ess.protal.model.bank.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**描述：交易信息<br>
 * 作者：shixiu <br>
 * 修改日期：2014-3-12上午10:21:32 <br>
 * E-mail: lishixiu14015@sinosoft.com.cn <br> 
 */

@XmlType(name="Head")
public class BaseInfoYB {
	
	//交易日期[yyyyMMdd]
	private String tranDate;
	
	// -交易时间[hhmmss]
	private String tranTime;
	
	// 交易单位(银行/农信社/经代公司),013电商平台
	private String tranCom;
	
	//银行代码 如：011工行，012广发，013电商平台
	private String bankCode;
	
	//地区编码，城市级代码
	private String zoneNo;
	
	// 交易流水号
	private String tranNo;
	
	// 交易代码
	private String funcFlag;
	
	//渠道代码,11电商渠道
	private String tranSchnl;

	@XmlElement(name="TranDate")
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	@XmlElement(name="TranTime")
	public String getTranTime() {
		return tranTime;
	}

	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}
	@XmlElement(name="TranCom")
	public String getTranCom() {
		return tranCom;
	}

	public void setTranCom(String tranCom) {
		this.tranCom = tranCom;
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
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}
	@XmlElement(name="TranNo")
	public String getTranNo() {
		return tranNo;
	}

	public void setTranNo(String tranNo) {
		this.tranNo = tranNo;
	}
	@XmlElement(name="FuncFlag")
	public String getFuncFlag() {
		return funcFlag;
	}

	public void setFuncFlag(String funcFlag) {
		this.funcFlag = funcFlag;
	}
	@XmlElement(name="TranSchnl")
	public String getTranSchnl() {
		return tranSchnl;
	}

	public void setTranSchnl(String tranSchnl) {
		this.tranSchnl = tranSchnl;
	}
	
	
}
