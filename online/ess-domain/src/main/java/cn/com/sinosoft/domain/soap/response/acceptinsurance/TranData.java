package cn.com.sinosoft.domain.soap.response.acceptinsurance;

import java.io.Serializable;

public class TranData implements Serializable {
	private RetData retData;
	private BaseInfo baseInfo;
	private LCCont lcCont;
	public RetData getRetData() {
		return retData;
	}
	public void setRetData(RetData retData) {
		this.retData = retData;
	}
	public BaseInfo getBaseInfo() {
		return baseInfo;
	}
	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}
	public LCCont getLcCont() {
		return lcCont;
	}
	public void setLcCont(LCCont lcCont) {
		this.lcCont = lcCont;
	}
	
}
