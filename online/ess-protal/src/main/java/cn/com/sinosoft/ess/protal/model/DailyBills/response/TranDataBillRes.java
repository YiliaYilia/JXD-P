/**
 * File Name:TranDataCDRes.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:shixiu
 * @version:v1.0
 * Createdate:2014-3-12下午01:48:33
 */
package cn.com.sinosoft.ess.protal.model.DailyBills.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**描述：<br>
 * 作者：shixiu <br>
 * 修改日期：2014-3-12下午01:48:33 <br>
 * E-mail: lishixiu14015@sinosoft.com.cn <br> 
 */

@XmlRootElement(name="TranData")
public class TranDataBillRes {
	
	private BaseInfoBillRes baseInfoBillRes;
	
	private BillNum billNum;
	
	@XmlElement(name="Head")
	public BaseInfoBillRes getBaseInfoBillRes() {
		return baseInfoBillRes;
	}

	public void setBaseInfoBillRes(BaseInfoBillRes baseInfoBillRes) {
		this.baseInfoBillRes = baseInfoBillRes;
	}
	
	@XmlElement(name="Body")
	public BillNum getBillNum() {
		return billNum;
	}

	public void setBillNum(BillNum billNum) {
		this.billNum = billNum;
	}
	
	
	
}
