/**
 * File Name:Detail.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:shixiu
 * @version:v1.0
 * Createdate:2014-3-12下午02:49:02
 */
package cn.com.sinosoft.ess.protal.model.DailyBills.request;

import javax.xml.bind.annotation.XmlElement;

/**描述：<br>
 * 作者：shixiu <br>
 * 修改日期：2014-3-12下午02:49:02 <br>
 * E-mail: lishixiu14015@sinosoft.com.cn <br> 
 */
public class Detail {
	
	// 保单号
	private String contNo;
	
	//保费，单位分
	private String prem;
	@XmlElement(name="ContNo")
	public String getContNo() {
		return contNo;
	}

	public void setContNo(String contNo) {
		this.contNo = contNo;
	}
	@XmlElement(name="Prem")
	public String getPrem() {
		return prem;
	}

	public void setPrem(String prem) {
		this.prem = prem;
	}
	
}
