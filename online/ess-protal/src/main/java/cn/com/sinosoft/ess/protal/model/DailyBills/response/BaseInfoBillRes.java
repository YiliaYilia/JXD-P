/**
 * File Name:BaseInfoCDRes.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:shixiu
 * @version:v1.0
 * Createdate:2014-3-12下午01:53:34
 */
package cn.com.sinosoft.ess.protal.model.DailyBills.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**描述：<br>
 * 作者：shixiu <br>
 * 修改日期：2014-3-12下午01:53:34 <br>
 * E-mail: lishixiu14015@sinosoft.com.cn <br> 
 */

@XmlType(name="Head")
public class BaseInfoBillRes {
	//交易结果代码,0成功，1失败	
	private String flag;
	
	//交易结果描述
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
