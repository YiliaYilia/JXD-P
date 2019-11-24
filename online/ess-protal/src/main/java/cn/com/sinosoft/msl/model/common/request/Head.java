package cn.com.sinosoft.msl.model.common.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="Head",propOrder={"tranDate","tranTime","transrNo","funcFlag","sysCode"})
public class Head {
	
	private String tranDate;	/**系统交易日期yyyymmdd 非空*/
	private String tranTime;	/**系统交易时间hhddss非空*/
	private String transrNo;	/**交易流水号*/
	private String funcFlag;	/**交易码 非空*/
	private String sysCode;	    /**交易单位*/
	
	
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
	@XmlElement(name="TranNo")
	public String getTransrNo() {
		return transrNo;
	}
	public void setTransrNo(String transrNo) {
		this.transrNo = transrNo;
	}
	
	@XmlElement(name="FuncFlag")
	public String getFuncFlag() {
		return funcFlag;
	}
	public void setFuncFlag(String funcFlag) {
		this.funcFlag = funcFlag;
	}
	
	@XmlElement(name="SysCode")
	public String getSysCode() {
		return sysCode;
	}
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}
	
	

}
