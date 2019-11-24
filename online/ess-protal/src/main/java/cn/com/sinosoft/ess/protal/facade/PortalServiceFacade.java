/**
 * File Name:PortalServiceFacade.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:wangpengfei
 * @version:v1.0
 * Createdate:2014-3-11下午03:55:47
 */
package cn.com.sinosoft.ess.protal.facade;

import cn.com.sinosoft.ess.protal.model.DailyBills.request.TranDataBill;
import cn.com.sinosoft.ess.protal.model.DailyBills.response.TranDataBillRes;
import cn.com.sinosoft.ess.protal.model.bank.request.TranDataYB;
import cn.com.sinosoft.ess.protal.model.insure.ResTranData;
import cn.com.sinosoft.ess.protal.model.insure.TranDataReq;
import cn.com.sinosoft.ess.protal.model.revoke.request.TranDataCD;
import cn.com.sinosoft.ess.protal.model.revoke.response.TranDataCDRes;


/**描述：<br>
 * 作者：wangpengfei <br>
 * 修改日期：2014-3-11下午03:55:47 <br>
 * E-mail: wangpengfei14079@sinosoft.com.cn <br> 
 */
public interface PortalServiceFacade {
	
	/**
	 * 方法名称: sendObjectToBancassurance<br>
	 * 描述：用于与银保通进行接口通讯，发送接收报文
	 * 作者: wangpengfei
	 * 修改日期：2014-3-11下午04:10:16
	 * @param acordServiceContext 服务对象上下文
	 * @return
	 */
	public AcordServiceContext sendObjectToBancassurance(AcordServiceContext acordServiceContext,String productcode);
	
	/**
	 * 银保通当日撤单接口
	 * @param tranDataCD
	 * @return 
	 */
	public TranDataCDRes tranDataCD(TranDataCD tranDataCD);
	
	/**
	 * 银保通日终对账接口
	 * @param tranDataBill
	 * @return
	 */
	public TranDataBillRes tranDataBill(TranDataBill tranDataBill);
	
	
	/**
	 * 核保
	 * @param tranData
	 * @return
	 */
	public ResTranData InsureMarshal(TranDataReq tranData,String productcode);
	
	/**
	 * 银保通签单交易接口
	 * @param tranDataYB
	 * @return
	 */
	public ResTranData tranDataYB(TranDataYB tranDataYB,String productcode);
}
