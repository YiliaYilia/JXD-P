package cn.com.sinosoft.domain.yinbaotongWAB;
/**
 * 基本信息
 * @author lwy
 */
public class BaseInfo {
	private String BankDate;//银行交易日期
	private String BankTime;//银行交易时间
	private String BankCode;//银行代码
	private String ZoneNo;//地区代码
	private String BrNo;//网点代码
	private String TellerNo;//柜员代码
	private String TransrNo;//交易流水号
	private String FunctionFlag;//处理标志102：新契约核保，试算  100：新契约缴费承保  806:对账
	private String InsuID;//保险公司代码
	private String Operator;//可为空
	private String SourceType;//销售渠道
	private String BkSaleName;//销售人员姓名
	private String BkSaleCode;//销售人员代码
	private String BkSaleCertNo;//销售人员资格证号
	private String ActyNo;//活动码
	private String BalanceFlag;//对账时需设定，默认值0
	private String BankNode;//对账时用，默认MSG01
	
	public BaseInfo() {
		super();
	}
	public BaseInfo(String bankDate, String bankTime, String bankCode,
			String zoneNo, String brNo, String tellerNo, String transrNo,
			String functionFlag, String insuID, String operator,
			String sourceType, String bkSaleName, String bkSaleCode,
			String bkSaleCertNo) {
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
		Operator = operator;
		SourceType = sourceType;
		BkSaleName = bkSaleName;
		BkSaleCode = bkSaleCode;
		BkSaleCertNo = bkSaleCertNo;
	}
	public BaseInfo(String bankDate, String bankTime, String bankCode,
			String zoneNo, String brNo, String tellerNo, String transrNo,
			String functionFlag, String insuID, String operator,
			String sourceType, String bkSaleName, String bkSaleCode,
			String bkSaleCertNo,String actyNo) {
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
		Operator = operator;
		SourceType = sourceType;
		BkSaleName = bkSaleName;
		BkSaleCode = bkSaleCode;
		BkSaleCertNo = bkSaleCertNo;
		ActyNo = actyNo;
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
	public String getOperator() {
		return Operator;
	}
	public void setOperator(String operator) {
		Operator = operator;
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
	public String getBkSaleCode() {
		return BkSaleCode;
	}
	public void setBkSaleCode(String bkSaleCode) {
		BkSaleCode = bkSaleCode;
	}
	public String getBkSaleCertNo() {
		return BkSaleCertNo;
	}
	public void setBkSaleCertNo(String bkSaleCertNo) {
		BkSaleCertNo = bkSaleCertNo;
	}
	public String getBalanceFlag() {
		return BalanceFlag;
	}
	public void setBalanceFlag(String balanceFlag) {
		BalanceFlag = balanceFlag;
	}
	public String getBankNode() {
		return BankNode;
	}
	public void setBankNode(String bankNode) {
		BankNode = bankNode;
	}
	public String getActyNo() {
		return ActyNo;
	}
	public void setActyNo(String actyNo) {
		ActyNo = actyNo;
	}
}
