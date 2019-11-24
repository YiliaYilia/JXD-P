/**
 * File Name:BillNum.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:shixiu
 * @version:v1.0
 * Createdate:2014-3-12下午02:47:37
 */
package cn.com.sinosoft.ess.protal.model.DailyBills.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 *描述：日终对账应答报文Body<br>
 * 作者：shixiu <br>
 * 修改日期：2014-3-20下午02:01:43 <br>
 * E-mail: lishixiu14015@sinosoft.com.cn <br>
 */

@XmlType(name="Body")
public class BillNum {
	
	//总条数
	private String count;
	
	private List<Detail> detail;
	@XmlElement(name="Count")
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
	@XmlElement(name="Detail")
	public List<Detail> getDetail() {
		return detail;
	}

	public void setDetail(List<Detail> detail) {
		this.detail = detail;
	}

	
}
