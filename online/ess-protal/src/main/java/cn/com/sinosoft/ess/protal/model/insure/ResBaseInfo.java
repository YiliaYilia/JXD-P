package cn.com.sinosoft.ess.protal.model.insure;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**描述：<br>
 * 作者：JCZ <br>
 * 修改日期：2014-3-12上午11:13:55 <br>
 * E-mail: jinchengze@sinosoft.com.cn <br> 
 */
@XmlType(name="Head")
public class ResBaseInfo {
	/** 交易结果代码,0成功，1失败*/
	private String flag;
	/**交易结果描述*/
	private String desc;
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
