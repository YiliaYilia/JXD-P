/**
 * File Name:TranDataYB.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:shixiu
 * @version:v1.0
 * Createdate:2014-3-12上午10:35:59
 */
package cn.com.sinosoft.ess.protal.model.bank.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**描述：<br>
 * 作者：shixiu <br>
 * 修改日期：2014-3-12上午10:35:59 <br>
 * E-mail: lishixiu14015@sinosoft.com.cn <br> 
 */

@XmlRootElement(name="TranData")
public class TranDataYB {
	
	private BaseInfoYB baseInfoYB;
	
	private LCContYB lCContYB;

	public BaseInfoYB getBaseInfoYB() {
		return baseInfoYB;
	}
	@XmlElement(name="Head")
	public void setBaseInfoYB(BaseInfoYB baseInfoYB) {
		this.baseInfoYB = baseInfoYB;
	}
	public LCContYB getlCContYB() {
		return lCContYB;
	}
	@XmlElement(name="Body")
	public void setlCContYB(LCContYB lCContYB) {
		this.lCContYB = lCContYB;
	}

	
}
