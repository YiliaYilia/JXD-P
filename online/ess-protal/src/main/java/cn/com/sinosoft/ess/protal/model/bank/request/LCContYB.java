/**
 * File Name:LCCont.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:shixiu
 * @version:v1.0
 * Createdate:2014-3-12上午10:32:13
 */
package cn.com.sinosoft.ess.protal.model.bank.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**描述：保单信息<br>
 * 作者：shixiu <br>
 * 修改日期：2014-3-12上午10:32:13 <br>
 * E-mail: lishixiu14015@sinosoft.com.cn <br> 
 */

@XmlType(name="Body")
public class LCContYB {
	
	//原核保交易流水号
	private String oldTranNo;
	
	//保单合同印刷号 (单证)，电商平台同订单号
	private String contPrtNo;
	
	//投保单(印刷)号，电商平台同订单号
	private String proposalPrtNo;
	
	//保单号
	private String contNo;
	@XmlElement(name="OldTranNo")
	public String getOldTranNo() {
		return oldTranNo;
	}

	public void setOldTranNo(String oldTranNo) {
		this.oldTranNo = oldTranNo;
	}
	@XmlElement(name="ContPrtNo")
	public String getContPrtNo() {
		return contPrtNo;
	}

	public void setContPrtNo(String contPrtNo) {
		this.contPrtNo = contPrtNo;
	}
	@XmlElement(name="ProposalPrtNo")
	public String getProposalPrtNo() {
		return proposalPrtNo;
	}

	public void setProposalPrtNo(String proposalPrtNo) {
		this.proposalPrtNo = proposalPrtNo;
	}
	@XmlElement(name="ContNo")
	public String getContNo() {
		return contNo;
	}

	public void setContNo(String contNo) {
		this.contNo = contNo;
	}
	
}
