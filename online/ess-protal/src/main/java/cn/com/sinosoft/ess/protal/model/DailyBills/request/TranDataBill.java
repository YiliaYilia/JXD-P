/**
 * File Name:TranDataBill.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:shixiu
 * @version:v1.0
 * Createdate:2014-3-12下午02:53:02
 */
package cn.com.sinosoft.ess.protal.model.DailyBills.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**描述：日终对账请求报文<br>
 * 作者：shixiu <br>
 * 修改日期：2014-3-12下午02:53:02 <br>
 * E-mail: lishixiu14015@sinosoft.com.cn <br> 
 */

@XmlRootElement(name="TranData")
public class TranDataBill {
	
	private BaseInfoBill baseInfoBill;
	
	private BillNum billNum;

	@XmlElement(name="Head")
	public BaseInfoBill getBaseInfoBill() {
		return baseInfoBill;
	}

	public void setBaseInfoBill(BaseInfoBill baseInfoBill) {
		this.baseInfoBill = baseInfoBill;
	}

	@XmlElement(name="Body")
	public BillNum getBillNum() {
		return billNum;
	}

	public void setBillNum(BillNum billNum) {
		this.billNum = billNum;
	}
	
	
}
