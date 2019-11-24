package cn.com.sinosoft.msl.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.core.exception.BaseException;
import cn.com.sinosoft.core.exception.enumerate.ExceptionGrade;
import cn.com.sinosoft.msl.model.common.request.Head;





/**
 * 描述：网销在线投保和保费试算的接口<br>
 * 作者：CaryXu <br>
 * 修改日期：2015-04-29 14:02:22 <br>
 * E-mail: Xukaizhen@sinosoft.com.cn <br>
 */
public class SalesPolicyService {
	private static final Logger logger = LoggerFactory.getLogger(SalesPolicyService.class);
	
	private static final SimpleDateFormat formatDate=new SimpleDateFormat("yyyyMMdd");
	private static final SimpleDateFormat formatTime=new SimpleDateFormat("hhmmss");
	private static final DecimalFormat decimalFormat = new DecimalFormat("000");
	private static final SimpleDateFormat format=new SimpleDateFormat("yyyyMMddhhmmssSSS");
	
	private static final Random random = new Random();

	
	
	//公共Head部分
	public static Head getHead(){
		Head head=new Head();
		Date now=new Date();
		head.setTranDate(formatDate.format(now));//交易日期[yyyyMMdd]
		head.setTranTime(formatTime.format(now));//交易时间[hhmmss]
		head.setTransrNo(format.format(now)+decimalFormat.format(random.nextInt(1000)));//交易流水号
		head.setSysCode("EBS");//前端系统代码,系统缩写 
		return head ;
	}
	/**
	 *  核保
	 */
	public static cn.com.sinosoft.msl.model.underWriting.response.Body underWriting(cn.com.sinosoft.msl.model.underWriting.request.Body body) throws BaseException {
		cn.com.sinosoft.msl.model.underWriting.request.TranDataReq tranData = new cn.com.sinosoft.msl.model.underWriting.request.TranDataReq();
		Head head = WechatPolicyService.getHead();
		head.setFuncFlag("1001");
		tranData.setHead(head);
		tranData.setBody(body);
		cn.com.sinosoft.msl.model.underWriting.response.TranDataRes res = InterfaceAssemblyService.underWriting(tranData);
		if ("0".equals(res.getHead().getFlag())){
			logger.info("调用核保接口成功");
			return res.getBody();
		}else{
			logger.info("调用核保接口失败，失败原因【"+res.getHead().getDesc()+"】");
			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", res.getHead().getDesc());
		}
	} 
   /**
    * 承保
    */
	public static boolean insurancePolicy(cn.com.sinosoft.msl.model.insurancePolicy.request.Body body) throws BaseException {
		cn.com.sinosoft.msl.model.insurancePolicy.request.TranDataReq tranData = new cn.com.sinosoft.msl.model.insurancePolicy.request.TranDataReq();
		Head head = WechatPolicyService.getHead();
		head.setFuncFlag("1002");
		tranData.setHead(head);
		tranData.setBody(body);
		cn.com.sinosoft.msl.model.insurancePolicy.response.TranDataRes res = InterfaceAssemblyService.insurancePolicy(tranData);
		if ("0".equals(res.getHead().getFlag())){
			logger.info("调用承保接口成功");
			return true;
		}else{
			logger.info("调用承保接口失败，失败原因【"+res.getHead().getDesc()+"】");
			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", res.getHead().getDesc());
		}
	}
//	/**
//	 * 查询客户信息
//	 */
//	public static cn.com.sinosoft.msl.model.customerInfo.response.Body queryCustomerInfo(String customerNo,String customerName,String iDNo) throws BaseException {
//		cn.com.sinosoft.msl.model.customerInfo.request.TranDataReq tranData = new cn.com.sinosoft.msl.model.customerInfo.request.TranDataReq();
//		Head head = WechatPolicyService.getHead();
//		head.setFuncFlag("WC019");
//		cn.com.sinosoft.msl.model.customerInfo.request.Body body = new cn.com.sinosoft.msl.model.customerInfo.request.Body();
//		body.setCustomerName(customerName);
//		body.setCustomerNo(customerNo);
//		body.setiDNo(iDNo);
//		tranData.setHead(head);
//		tranData.setBody(body);
//		cn.com.sinosoft.msl.model.customerInfo.response.TranDataRes res = InterfaceAssemblyService.queryCustomerInfo(tranData);
//		if ("0".equals(res.getHead().getFlag())){
//			logger.info("调用查询用户信息接口成功");
//			return res.getBody();
//		}else{
//			logger.info("调用查询用户信息接口失败，失败原因【"+res.getHead().getDesc()+"】");
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", res.getHead().getDesc());
//		}
//	}
//	/**
//	 * 查询营销员
//	 */
//	public static cn.com.sinosoft.msl.model.salesMan.response.Body querySalesMan(String   agentCode) throws BaseException {
//		cn.com.sinosoft.msl.model.salesMan.request.TranDataReq tranData = new cn.com.sinosoft.msl.model.salesMan.request.TranDataReq();
//		Head head = WechatPolicyService.getHead();
//		head.setFuncFlag("WC018");
//		cn.com.sinosoft.msl.model.salesMan.request.Body  body = new cn.com.sinosoft.msl.model.salesMan.request.Body ();
//		body.setAgentCode(agentCode);
//		tranData.setHead(head);
//		tranData.setBody(body);
//		cn.com.sinosoft.msl.model.salesMan.response.TranDataRes res = InterfaceAssemblyService.querySalesMan(tranData);
//		if ("0".equals(res.getHead().getFlag())){
//			logger.info("调用查询营销员信息接口成功");
//			return res.getBody();
//		}else{
//			logger.info("调用查询营销员信息接口失败，失败原因【"+res.getHead().getDesc()+"】");
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", res.getHead().getDesc());
//		}
//	}
	
}

