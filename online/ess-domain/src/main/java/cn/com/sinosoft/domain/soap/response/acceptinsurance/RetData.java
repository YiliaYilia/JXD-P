package cn.com.sinosoft.domain.soap.response.acceptinsurance;

import java.io.Serializable;

public class RetData implements Serializable {
	/**状态 1成功 0失败*/
	private String flag;
	/**错误描述*/
	private String desc;
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
