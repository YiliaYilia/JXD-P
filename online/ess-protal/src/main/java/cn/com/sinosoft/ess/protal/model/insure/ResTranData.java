package cn.com.sinosoft.ess.protal.model.insure;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**描述：<br>
 * 作者：JCZ <br>
 * 修改日期：2014-3-12下午02:49:33 <br>
 * E-mail: jinchengze@sinosoft.com.cn <br> 
 */
@XmlRootElement(name="TranData")
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
public class ResTranData {
	
	/**基本头信息*/
	private ResBaseInfo baseInfo;
	/**保单信息*/
	private ResContInfo contInfo;
	
	@XmlElement(name="Head")
	public ResBaseInfo getBaseInfo() {
		return baseInfo;
	}
	
	public void setBaseInfo(ResBaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}
	@XmlElement(name="Body")
	public ResContInfo getContInfo() {
		return contInfo;
	}

	public void setContInfo(ResContInfo contInfo) {
		this.contInfo = contInfo;
	}
	
}
