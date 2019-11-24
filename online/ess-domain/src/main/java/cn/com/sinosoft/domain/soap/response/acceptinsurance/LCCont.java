package cn.com.sinosoft.domain.soap.response.acceptinsurance;

import java.io.Serializable;

public class LCCont implements Serializable {
	/**保单号 失败时为空*/
	private String contNo;

	public String getContNo() {
		return contNo;
	}

	public void setContNo(String contNo) {
		this.contNo = contNo;
	}
}
