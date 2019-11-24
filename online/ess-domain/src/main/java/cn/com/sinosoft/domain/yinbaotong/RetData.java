package cn.com.sinosoft.domain.yinbaotong;
/**
 * 返回内容基本信息
 * @author lwy
 */
public class RetData {
	private String BankDate;
	private String BankTime;
	private String BankCode;
	private String ZoneNo;
	private String BrNo;
	private String TellerNo;
	private String TransrNo;
	private String FunctionFlag;
	private String InsuID;
	private String SourceType;
	private String BkSaleName;
	private String BkSaleCertNo;
	private String RealBrNo;
	private String Flag;
	private String Desc;
	private String PolNumber;
	
	
	public RetData() {
		super();
	}
	public RetData(String bankDate, String bankTime, String bankCode,
			String zoneNo, String brNo, String tellerNo, String transrNo,
			String functionFlag, String insuID, String sourceType,
			String bkSaleName, String bkSaleCertNo, String realBrNo,
			String flag, String desc, String polNumber) {
		super();
		BankDate = bankDate;
		BankTime = bankTime;
		BankCode = bankCode;
		ZoneNo = zoneNo;
		BrNo = brNo;
		TellerNo = tellerNo;
		TransrNo = transrNo;
		FunctionFlag = functionFlag;
		InsuID = insuID;
		SourceType = sourceType;
		BkSaleName = bkSaleName;
		BkSaleCertNo = bkSaleCertNo;
		RealBrNo = realBrNo;
		Flag = flag;
		Desc = desc;
		PolNumber = polNumber;
	}
	public String getBankDate() {
		return BankDate;
	}
	public void setBankDate(String bankDate) {
		BankDate = bankDate;
	}
	public String getBankTime() {
		return BankTime;
	}
	public void setBankTime(String bankTime) {
		BankTime = bankTime;
	}
	public String getBankCode() {
		return BankCode;
	}
	public void setBankCode(String bankCode) {
		BankCode = bankCode;
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
		return TellerNo;
	}
	public void setTellerNo(String tellerNo) {
		TellerNo = tellerNo;
	}
	public String getTransrNo() {
		return TransrNo;
	}
	public void setTransrNo(String transrNo) {
		TransrNo = transrNo;
	}
	public String getFunctionFlag() {
		return FunctionFlag;
	}
	public void setFunctionFlag(String functionFlag) {
		FunctionFlag = functionFlag;
	}
	public String getInsuID() {
		return InsuID;
	}
	public void setInsuID(String insuID) {
		InsuID = insuID;
	}
	public String getSourceType() {
		return SourceType;
	}
	public void setSourceType(String sourceType) {
		SourceType = sourceType;
	}
	public String getBkSaleName() {
		return BkSaleName;
	}
	public void setBkSaleName(String bkSaleName) {
		BkSaleName = bkSaleName;
	}
	public String getBkSaleCertNo() {
		return BkSaleCertNo;
	}
	public void setBkSaleCertNo(String bkSaleCertNo) {
		BkSaleCertNo = bkSaleCertNo;
	}
	public String getRealBrNo() {
		return RealBrNo;
	}
	public void setRealBrNo(String realBrNo) {
		RealBrNo = realBrNo;
	}
	public String getFlag() {
		return Flag;
	}
	public void setFlag(String flag) {
		Flag = flag;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	public String getPolNumber() {
		return PolNumber;
	}
	public void setPolNumber(String polNumber) {
		PolNumber = polNumber;
	}
}
