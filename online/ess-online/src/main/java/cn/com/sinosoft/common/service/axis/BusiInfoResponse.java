package cn.com.sinosoft.common.service.axis;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "return")
public class BusiInfoResponse {
	private String retCode;//failed success
	private String retMsg;
	
	public BusiInfoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BusiInfoResponse(String retCode, String retMsg) {
		super();
		this.retCode = retCode;
		this.retMsg = retMsg;
	}

	public String getRetCode() {
		return retCode;
	}
	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	@Override
	public String toString() {
		return "BusiInfoResponse [retCode=" + retCode + ", retMsg=" + retMsg
				+ "]";
	}
	
}
