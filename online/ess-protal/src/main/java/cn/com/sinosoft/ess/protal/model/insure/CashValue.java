/**
 * File Name:CashValue.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:JCZ
 * @version:v1.0
 * Createdate:2014-3-12上午11:13:55
 */
package cn.com.sinosoft.ess.protal.model.insure;

import javax.xml.bind.annotation.XmlElement;

/**描述：<br>
 * 作者：JCZ <br>
 * 修改日期：2014-3-12上午11:13:55 <br>
 * E-mail: jinchengze@sinosoft.com.cn <br> 
 */
public class CashValue {
	/**年度*/
	private String endYear;
	/**现金价值，单位分*/
	private String cash;
	
	@XmlElement(name="EndYear")
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	@XmlElement(name="Cash")
	public String getCash() {
		return cash;
	}
	public void setCash(String cash) {
		this.cash = cash;
	}

}
