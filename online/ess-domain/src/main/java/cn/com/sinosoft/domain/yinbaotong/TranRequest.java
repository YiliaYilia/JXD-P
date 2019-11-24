package cn.com.sinosoft.domain.yinbaotong;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"baseInfo","lCCont","OLifEExtension","retData","chkDetails"})  
public class TranRequest {
	private BaseInfo baseInfo;//基本信息
	private LCCont lCCont;//保单信息
	private OLifEExtension oLifEExtension;//未知报文返回信息
	private RetData retData;//返回基本信息
	private ChkDetails chkDetails;//保单集合信息
	
	@XmlElement(name="baseInfo")
	public BaseInfo getBaseInfo() {
		return baseInfo;
	}
	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}
	@XmlElement(name="lCCont")
	public LCCont getlCCont() {
		return lCCont;
	}
	public void setlCCont(LCCont lCCont) {
		this.lCCont = lCCont;
	}
	@XmlElement(name="OLifEExtension")
	public OLifEExtension getOLifEExtension() {
		return oLifEExtension;
	}
	public void setOLifEExtension(OLifEExtension oLifEExtension) {
		this.oLifEExtension = oLifEExtension;
	}
	@XmlElement(name="retData")
	public RetData getRetData() {
		return retData;
	}
	public void setRetData(RetData retData) {
		this.retData = retData;
	}
	public TranRequest(BaseInfo baseInfo, LCCont lCCont,
			OLifEExtension oLifEExtension, RetData retData) {
		super();
		this.baseInfo = baseInfo;
		this.lCCont = lCCont;
		oLifEExtension = oLifEExtension;
		this.retData = retData;
	}
	public TranRequest() {
		super();
	}
	@XmlElement(name="chkDetails")
	public ChkDetails getChkDetails() {
		return chkDetails;
	}
	public void setChkDetails(ChkDetails chkDetails) {
		this.chkDetails = chkDetails;
	}
	
	
}
