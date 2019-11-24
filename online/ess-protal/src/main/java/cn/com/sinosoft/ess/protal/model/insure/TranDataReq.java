package cn.com.sinosoft.ess.protal.model.insure;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 描述：核保数据解析<br>
 * 作者：GHY <br>
 * 修改日期：2014-3-12上午11:09:57 <br>
 * E-mail: gaohongyang13607@sinosoft.com.cn <br>
 */
@XmlRootElement(name="TranData")
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
public class TranDataReq {
	
	/**基本头信息*/
	private BaseInfoReq baseInfo;
	/**保单信息*/
	private LCContReq lCCont;
	
	@XmlElement(name="Head")
	public BaseInfoReq getBaseInfo() {
		return baseInfo;
	}
	
	public void setBaseInfo(BaseInfoReq baseInfo) {
		this.baseInfo = baseInfo;
	}
	
	@XmlElement(name="Body")
	public LCContReq getlCCont() {
		return lCCont;
	}
	
	public void setlCCont(LCContReq lCCont) {
		this.lCCont = lCCont;
	}
	
	
}
