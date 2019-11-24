package cn.com.sinosoft.msl.model.common.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="Head",propOrder = {"flag","desc"})
public class Head {
	
	private String flag;	/**交易结果代码,0成功，1失败。若查询结果为空，则返回0，Body节点下无内容。若客户号在核心不存在，返回2，其他失败返回1*/
	private String desc;	/**交易结果描述*/
	
	@XmlElement(name="Flag")
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	@XmlElement(name="Desc")
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
