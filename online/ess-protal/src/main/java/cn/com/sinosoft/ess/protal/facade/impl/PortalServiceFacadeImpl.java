/**
 * File Name:PortalServiceFacadeImpl.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:wangpengfei
 * @version:v1.0
 * Createdate:2014-3-11下午04:01:20
 */
package cn.com.sinosoft.ess.protal.facade.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.ess.protal.config.ServiceTradeTypeEnum;
import cn.com.sinosoft.ess.protal.facade.AcordServiceContext;
import cn.com.sinosoft.ess.protal.facade.PortalServiceFacade;
import cn.com.sinosoft.ess.protal.facade.testSoap.TestSoap;
import cn.com.sinosoft.ess.protal.model.DailyBills.request.BaseInfoBill;
import cn.com.sinosoft.ess.protal.model.DailyBills.request.BillNum;
import cn.com.sinosoft.ess.protal.model.DailyBills.request.Detail;
import cn.com.sinosoft.ess.protal.model.DailyBills.request.TranDataBill;
import cn.com.sinosoft.ess.protal.model.DailyBills.response.TranDataBillRes;
import cn.com.sinosoft.ess.protal.model.bank.request.BaseInfoYB;
import cn.com.sinosoft.ess.protal.model.bank.request.LCContYB;
import cn.com.sinosoft.ess.protal.model.bank.request.TranDataYB;
import cn.com.sinosoft.ess.protal.model.insure.ResContInfo;
import cn.com.sinosoft.ess.protal.model.insure.ResTranData;
import cn.com.sinosoft.ess.protal.model.insure.TranDataReq;
import cn.com.sinosoft.ess.protal.model.revoke.request.BaseInfoCD;
import cn.com.sinosoft.ess.protal.model.revoke.request.GuaranteeSlip;
import cn.com.sinosoft.ess.protal.model.revoke.request.TranDataCD;
import cn.com.sinosoft.ess.protal.model.revoke.response.TranDataCDRes;
import cn.com.sinosoft.ess.protal.parser.BancassuranceXmlParser;
import cn.com.sinosoft.ess.protal.parser.impl.BancassuranceXmlParserImpl;
import cn.com.sinosoft.ess.protal.webservice.Axis2ClientUtils;
import cn.com.sinosoft.ess.protal.webservice.Axis2ClientUtils2;

/**描述：<br>
 * 作者：wangpengfei <br>
 * 修改日期：2014-3-11下午04:01:20 <br>
 * E-mail: wangpengfei14079@sinosoft.com.cn <br> 
 */
@Component
public class PortalServiceFacadeImpl implements PortalServiceFacade {
	
	private static final Logger logger = LoggerFactory.getLogger(PortalServiceFacadeImpl.class);
	
	private static final String REMOTE_SERVICE_NAME = "service";
	
	private static BancassuranceXmlParser parser = new BancassuranceXmlParserImpl();
	
	/**方法名称：sendObjectToBancassurance <br>
	 * 描述： <br>
	 * 作者：wangpengfei <br>
	 * 修改日期：2014-3-11下午04:13:20 
	 * @see cn.com.sinosoft.ess.protal.facade.PortalServiceFacade#sendObjectToBancassurance(cn.com.sinosoft.ess.protal.facade.AcordServiceContext) 
	 * @param acordServiceContext
	 * @return
	 */
	public AcordServiceContext sendObjectToBancassurance(AcordServiceContext acordServiceContext ,String productcode) {
		//请求报文转换
		String requestXML = null;
		try {
			requestXML = parser.marshal(acordServiceContext.getRequestObject());
		} catch (Exception e) {
			logger.error("将请求对象转换为请求报文时出现异常：",e);
			e.printStackTrace();
		}
		logger.info("客户端传入数据报文：");
		logger.info(requestXML);
		//服务调用
		String resultXML =null;
		ResourceBundle rb = ResourceBundle.getBundle("config/config");
		if("0".equals(rb.getString("isDebug"))){
		//if(productcode.equals("NPACA")||productcode.equals("AA")||productcode.equals("FTA")||productcode.equals("BCIB")||productcode.equals("JEB")||productcode.equals("BSPG7")){
			resultXML = Axis2ClientUtils.callBancassuranceRemoteService(REMOTE_SERVICE_NAME, requestXML);
			logger.info("银保通返回数据报文（正式）：");
			logger.info(resultXML);
		}else{
			logger.info("银保通返回数据报文（测试）：");
			resultXML = TestSoap.getSoap("1001001.xml");
			logger.info(resultXML);
		}
		
		//响应报文转换
		Object resultObject = null;
		try {
			 resultObject = parser.unmarshal(resultXML, acordServiceContext.getResponseObjectClass());
		} catch (Exception e) {
			logger.error("将返回报文转换为对象时出现异常：",e);
			e.printStackTrace();
		}
		//设置返回结果
		acordServiceContext.setResultObject(resultObject);
		
		return acordServiceContext;
	}
	
	/**
	 * 核保
	 * @param tranData
	 * @return
	 */
	public ResTranData InsureMarshal(TranDataReq tranData,String productcode){
		PortalServiceFacadeImpl PortalServiceFacadeImpl = new PortalServiceFacadeImpl();
		String funcFlag = ServiceTradeTypeEnum.TRANDATA_HEAD_FUNCFLAG_1.tradeType();
		Object requestObject = tranData;
		
		AcordServiceContext acordServiceContext = new AcordServiceContext(funcFlag, requestObject);
		//请求银保通进行核保
		acordServiceContext = PortalServiceFacadeImpl.sendObjectToBancassurance(acordServiceContext,productcode );
		//响应报文处理
		ResTranData resTranDataTbl = (ResTranData)acordServiceContext.getResultObject();
		ResContInfo rbi = resTranDataTbl.getContInfo();
		return resTranDataTbl;
	}

	/**
	 * 银保通签单交易接口
	 * @author duyulong 2014-03-21
	 * @param tranDataYB
	 * @return
	 */
	public ResTranData tranDataYB(TranDataYB tranDataYB,String productcode){
		logger.info("**银保通签单交易接口开始调用**");
		try{
			String funcFlag = ServiceTradeTypeEnum.TRANDATA_HEAD_FUNCFLAG_2.tradeType();
			Object requestObject = tranDataYB;
			AcordServiceContext acordServiceContext = new AcordServiceContext(funcFlag, requestObject);
			AcordServiceContext r = sendObjectToBancassurance(acordServiceContext ,productcode);
			
			ResTranData resTranDataTbl = (ResTranData)r.getResultObject();
			logger.info("**银保通签单交易接口调用成功**");
			logger.info("交易结果描述(desc)："+resTranDataTbl.getBaseInfo().getDesc());
			logger.info("交易结果代码(flag)："+resTranDataTbl.getBaseInfo().getFlag());
			return resTranDataTbl;
			
		}catch(Exception e){
			logger.error("**银保通签单交易接口调用异常**",e);
		}
		logger.info("**银保通签单交易接口结束调用**");
		return null;
	}
	
	
	
	
	/**
	 * 描述：银保通日终对账接口
	 * @author duyulong 2014-03-19
	 * @param tranDataBill
	 */
	public TranDataBillRes tranDataBill(TranDataBill tranDataBill){
		
		logger.info("**银保通日终对账接口开始调用**");
		try{
			String funcFlag = ServiceTradeTypeEnum.TRANDATA_HEAD_FUNCFLAG_3.tradeType();
			Object requestObject = tranDataBill;
			AcordServiceContext acordServiceContext = new AcordServiceContext(funcFlag, requestObject);
			AcordServiceContext r = sendObjectToBancassurance(acordServiceContext ,"");
			
			TranDataBillRes tranDataBillRes = (TranDataBillRes)r.getResultObject();
			logger.info("**银保通日终对账接口调用成功**");
			logger.info("交易结果描述(desc)："+tranDataBillRes.getBaseInfoBillRes().getDesc());
			logger.info("交易结果代码(flag)："+tranDataBillRes.getBaseInfoBillRes().getFlag());
			return tranDataBillRes;
		}catch(Exception e){
			logger.error("**银保通日终对账接口调用异常**",e);
		}
		logger.info("**银保通日终对账接口结束调用**");
		return null;
	}
	
	
	/**
	 * 描述：银保通银保通当日撤单接口
	 * @author duyulong 2014-03-19
	 * @param tranDataCD
	 */
	public TranDataCDRes tranDataCD(TranDataCD tranDataCD){
		
		logger.info("**银保通当日撤单接口开始调用**");
		try{
			String funcFlag = ServiceTradeTypeEnum.TRANDATA_HEAD_FUNCFLAG_4.tradeType();
			Object requestObject = tranDataCD;
			AcordServiceContext acordServiceContext = new AcordServiceContext(funcFlag, requestObject);
			AcordServiceContext r = sendObjectToBancassurance(acordServiceContext ,"");
			
			//接口返回结果转为实体类TranDataCDRes
			TranDataCDRes tranDataCDRes = (TranDataCDRes)r.getResultObject();
			logger.info("**银保通当日撤单接口调用成功**");
			logger.info("交易结果描述(desc)："+tranDataCDRes.getBaseInfoCDRes().getDesc());
			logger.info("交易结果代码(flag)："+tranDataCDRes.getBaseInfoCDRes().getFlag());
			return tranDataCDRes;
		}catch(Exception e){
			logger.error("**银保通当日撤单接口调用异常**",e);
		}
		logger.info("**银保通当日撤单接口结束调用**");
		return null;
	}


	
}
