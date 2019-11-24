package cn.com.sinosoft.domain.yinbaotong;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"bankCode","tranDate","zoneNo","brNo","funcFlag","transrNo","polNo","tranAmnt","confirmFlag"})  
public class ChkDetail {
	private String BankCode;//银行代码
	private String TranDate;//
	private String ZoneNo;
	private String BrNo;
	private String FuncFlag;
	private String TransrNo;//交易流水号
	private String PolNo;
	private String TranAmnt;
	private String ConfirmFlag;
	
	@XmlElement(name="BankCode")
	public String getBankCode() {
		return BankCode;
	}
	public void setBankCode(String BankCode) {
		this.BankCode = BankCode;
	}
	
	@XmlElement(name="TranDate")
	public String getTranDate() {
		return TranDate;
	}
	public void setTranDate(String TranDate) {
		this.TranDate = TranDate;
	}
	
	@XmlElement(name="ZoneNo")
	public String getZoneNo() {
		return ZoneNo;
	}
	public void setZoneNo(String ZoneNo) {
		this.ZoneNo = ZoneNo;
	}
	
	@XmlElement(name="BrNo")
	public String getBrNo() {
		return BrNo;
	}
	public void setBrNo(String BrNo) {
		this.BrNo = BrNo;
	}
	
	@XmlElement(name="FuncFlag")
	public String getFuncFlag() {
		return FuncFlag;
	}
	public void setFuncFlag(String FuncFlag) {
		this.FuncFlag = FuncFlag;
	}
	
	@XmlElement(name="TransrNo")
	public String getTransrNo() {
		return TransrNo;
	}
	public void setTransrNo(String TransrNo) {
		this.TransrNo = TransrNo;
	}
	
	@XmlElement(name="PolNo")
	public String getPolNo() {
		return PolNo;
	}
	public void setPolNo(String PolNo) {
		this.PolNo = PolNo;
	}
	
	@XmlElement(name="TranAmnt")
	public String getTranAmnt() {
		return TranAmnt;
	}
	public void setTranAmnt(String TranAmnt) {
		this.TranAmnt = TranAmnt;
	}
	@XmlElement(name="ConfirmFlag")
	public String getConfirmFlag() {
		return ConfirmFlag;
	}
	public void setConfirmFlag(String ConfirmFlag) {
		this.ConfirmFlag = ConfirmFlag;
	}
	public ChkDetail(String BankCode, String TranDate, String ZoneNo,
			String BrNo, String FuncFlag, String TransrNo, String PolNo,
			String TranAmnt, String ConfirmFlag) {
		super();
		this.BankCode = BankCode;
		this.TranDate = TranDate;
		this.ZoneNo = ZoneNo;
		this.BrNo = BrNo;
		this.FuncFlag = FuncFlag;
		this.TransrNo = TransrNo;
		this.PolNo = PolNo;
		this.TranAmnt = TranAmnt;
		this.ConfirmFlag = ConfirmFlag;
	}
	public ChkDetail() {
		super();
	}
	
}
