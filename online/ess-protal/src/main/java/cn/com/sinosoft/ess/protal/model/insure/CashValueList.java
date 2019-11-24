/**
 * File Name:CashValueList.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:JCZ
 * @version:v1.0
 * Createdate:2014-3-13下午02:01:33
 */
package cn.com.sinosoft.ess.protal.model.insure;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;


/**描述：<br>
 * 作者：JCZ <br>
 * 修改日期：2014-3-13下午02:01:33 <br>
 * E-mail: jinchengze@sinosoft.com.cn <br> 
 */
public class CashValueList  {
	private List<CashValue> cashValue;

	@XmlElement(name="CashValue")
	public List<CashValue> getCashValue() {
		return cashValue;
	}

	public void setCashValue(List<CashValue> cashValue) {
		this.cashValue = cashValue;
	}
	
	/*public CashValue getCashValue() {
		return cashValue;
	}

	public void setCashValue(CashValue cashValue) {
		this.cashValue = cashValue;
	}
	*/
}
