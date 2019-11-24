package cn.com.sinosoft.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.zxing.WriterException;
import cn.com.sinosoft.common.PaymentConfigProp;
import cn.com.sinosoft.core.exception.BaseException;
import cn.com.sinosoft.core.exception.enumerate.ExceptionGrade;
import cn.com.sinosoft.core.utils.DateUtil;
import cn.com.sinosoft.core.utils.IPAddressUtils;
import cn.com.sinosoft.domain.payment.GePaymentTypeInfo;
import cn.com.sinosoft.domain.payment.ProposalPayment;
import cn.com.sinosoft.domain.payment.ProposalPaymentLog;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.ess.protal.common.ConfigProp;
import cn.com.sinosoft.service.PayService;
import cn.com.sinosoft.service.PaymentTypeInfoService;
import cn.com.sinosoft.service.ProposalPaymentLogService;
import cn.com.sinosoft.service.ProposalPaymentService;
import cn.com.sinosoft.weixin.client.HttpClient;
import cn.com.sinosoft.weixin.util.PaymentUtil;
import cn.com.sinosoft.weixin.util.Util;
import cn.com.sinosoft.weixin.util.XMLUtil;
import cn.com.sinosoft.zhifubao.util.AlipayNotify;
import cn.com.sinosoft.zhifubao.util.AlipaySubmit;
import cn.com.sinosoft.zhifubao.util.UtilDate;

@Component
public class PayServiceImpl implements PayService{
	@Autowired
	private  ProposalPaymentService proposalPaymentService;
	@Autowired
	private  ProposalPaymentLogService proposalPaymentLogService;
	@Autowired
	private PaymentTypeInfoService paymentTypeInfoService;
	
	/**
	 * 微信支付主要逻辑代码
	 */
	@Override
	public String pay(GeOrder order, String openId,HttpServletRequest request) throws Exception {
		String resultStr = null;
		String payWay=order.getPayway();
		if("10".equals(payWay)){
			//微信公众号支付
			SortedMap<String, Object> map=this.wxJSAPIPrePaymentTradingCard(openId, order,request);
			resultStr=(String)map.get("appId")+","+(String)map.get("nonceStr")+","+
					  (String)map.get("package")+","+(String)map.get("paySign")+","+
					  (String)map.get("signType")+","+(String)map.get("timeStamp");
		}else if("11".equals(payWay)){
			//微信扫码支付
			//resultStr=this.wxNativePrePaymentTradingCard(order,request);
		}else if("20".equals(payWay) || "21".equals(payWay) || "22".equals(payWay)){
			//20 : 支付保即时到账      21:支付宝手机网页支付     22:支付宝网银支付
			//resultStr=this.zhifubaoPay(order);
		}
		return resultStr;
	}

	@Override
	public SortedMap<String, Object> wxJSAPIPrePaymentTradingCard(String openId,GeOrder order,HttpServletRequest request) throws BaseException{
		String appId=PaymentConfigProp.getString("weixin_Appid");
		String noifyUrl=PaymentConfigProp.getString("weixin_NoifyUrl");
		String mchId=PaymentConfigProp.getString("weixin_Mch_id");
		String key=PaymentConfigProp.getString("weixin_key");//密钥
		
		//根据API给的签名规则进行签名

		SortedMap<String,Object>  httpReq=new TreeMap<String,Object>();
		httpReq.put("appid", appId);
		//httpReq.put("attach", "");//附加数据，非必填项
		httpReq.put("body", order.getProductname());//产品名称
		httpReq.put("mch_id",mchId);//商户号
		httpReq.put("nonce_str", Util.getRandomStringByLength(32));
		httpReq.put("notify_url", noifyUrl);////通知地址
		httpReq.put("openid", openId);//openId
		httpReq.put("out_trade_no", order.getOrdercode());//商户订单号
		httpReq.put("spbill_create_ip", IPAddressUtils.getIpAddr(request)); //来源ip
		String amount="";
		if("2".equals(ConfigProp.getString("env"))){
			amount="1";
		}else if("3".equals(ConfigProp.getString("env"))){
			Double sumMoney=order.getOrderamount();
			if(order.getStipend()!=null){
				sumMoney +=  order.getStipend();
			}
			if(order.getBookmoney()!=null){
				sumMoney +=  order.getBookmoney();
			}
			amount=(int) (sumMoney*100)+"";
		}
		httpReq.put("total_fee", amount);//交易金额
		httpReq.put("trade_type", "JSAPI");//交易类型
		//httpReq.put("time_expire", tradingEndTime);
		httpReq.put("sign", "");
		SortedMap<String, Object> httpRes=HttpClient.sendPost(httpReq, key, "wexin_unifiedorder");
		if(httpRes == null){
			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2015", "发送请求，返回参数为空");
		}
		SortedMap<String,Object>  map=new TreeMap<String,Object>();
		if("SUCCESS".equals((String)httpRes.get("return_code")) && "SUCCESS".equals((String)httpRes.get("result_code"))){
			map.put("appId", appId);
			map.put("nonceStr", (Util.getRandomStringByLength(32)).toUpperCase());
			map.put("package", "prepay_id="+httpRes.get("prepay_id"));
			map.put("signType", "MD5");
			map.put("timeStamp", Util.getTimeStamp());
			String sign=PaymentUtil.createSign(map,key);
			map.put("paySign", sign);
		}
		//支付记录
		Date now=new Date();
		String reqStr=XMLUtil.mapToXmlString(httpReq);
		
		//请求信息保存数据库
		//支付记录
//		boolean insert=false;
//		ProposalPayment proposalPayment=proposalPaymentService.getProposalPaymentByOrderCode(order.getOrdercode());
//		if(proposalPayment == null){
//			insert=true;
//			proposalPayment = new ProposalPayment();
//		}
//		
//		proposalPayment.setMerId(mchId);
//		proposalPayment.setOrderNo(order.getOrdercode());
//		proposalPayment.setFlowno(order.getFlowno());
//		proposalPayment.setTransType("JSAPI");
//		proposalPayment.setCertType("1");
//		proposalPayment.setCertId(order.getAgentidentitycode());
//		proposalPayment.setCuryId("CNY");
//		proposalPayment.setTransAmt(order.getOrderamount()+"");
//		proposalPayment.setPurpose("支付记录");
//		proposalPayment.setTranSdate(DateUtil.DateToString(now, "yyyy-MM-dd"));
//		proposalPayment.setTransTime(DateUtil.DateToString(now, "HH:mm:ss"));
//		proposalPayment.setProposalNo(policy.getPolicycode());
//		proposalPayment.setMessageStr(reqStr);
//		proposalPayment.setCreatDate(DateUtil.DateToString(now, "yyyy-MM-dd"));
//		proposalPayment.setCreatTime(DateUtil.DateToString(now, "HH:mm:ss"));
		//预订单请求失败
//		if("FAIL".equals((String)httpRes.get("return_code"))){
//			proposalPayment.setResponseCode("01");
//			proposalPayment.setMessageStr((String)httpRes.get("return_msg"));
//		}else if("SUCCESS".equals(httpRes.get("return_code")) && "FAIL".equals(httpRes.get("result_code"))){
//			proposalPayment.setResponseCode("01");
//			proposalPayment.setMessageStr((String)httpRes.get("err_code_des"));
//		}
		
//		//支付请求数据
//		ProposalPaymentLog  proposalPaymentLog = new ProposalPaymentLog();
//		proposalPaymentLog.setMerId(mchId);
//		proposalPaymentLog.setOrderNo(order.getOrdercode());
//		proposalPaymentLog.setFlowNo(order.getFlowno());
//		proposalPaymentLog.setTransType("JSAPI");
//		proposalPaymentLog.setCertType("1");
//		proposalPaymentLog.setCertId(order.getAgentidentitycode());
//		proposalPaymentLog.setCuryId("CNY");
//		proposalPaymentLog.setTransAmt(order.getOrderamount()+"");
//		proposalPaymentLog.setPurpose("支付请求数据");
//		proposalPaymentLog.setTranSdate(DateUtil.DateToString(now, "yyyy-MM-dd"));
//		proposalPaymentLog.setTransTime(DateUtil.DateToString(now, "HH:mm:ss"));
//		proposalPaymentLog.setProposalNo(policy.getPolicycode());
//		proposalPaymentLog.setMessageStr(reqStr);
//		proposalPaymentLog.setCreatDate(DateUtil.DateToString(now, "yyyy-MM-dd"));
//		proposalPaymentLog.setCreatTime(DateUtil.DateToString(now, "HH:mm:ss"));
//		
//		if(insert){
//			proposalPaymentService.saveProposalPayment(proposalPayment);
//		}else{
//			proposalPaymentService.updateProposalPayment(proposalPayment);
//		}
//		proposalPaymentLogService.saveProposalPaymentLog(proposalPaymentLog);
		return map;
	}



//	@Override
//	public String wxNativePrePaymentTradingCard(GeOrder order,HttpServletRequest request) throws WriterException, IOException {
//		String codeUrl = null;
//		String appId=PaymentConfigProp.getString("weixin_Appid");
//		String noifyUrl=PaymentConfigProp.getString("weixin_NoifyUrl");
//		String mchId=PaymentConfigProp.getString("weixin_Mch_id");
//		String key=PaymentConfigProp.getString("weixin_key");//密钥
//		Set<GePolicy> policySet=order.getPolicys();
//		Iterator<GePolicy> it=policySet.iterator();
//		GePolicy policy=null;
//		while(it.hasNext()){
//			policy=it.next();
//		}
//		String tradingEndTime=DateUtil.DateToString(DateUtil.addMinute(order.getCreatedate(), 45), "yyyyMMddHHmmss");
//		
//		String tradeType="NATIVE";
//		SortedMap<String,Object>  httpReq=new TreeMap<String,Object>();
//		httpReq.put("appid", appId);
//		httpReq.put("attach", "微信");
//		httpReq.put("body", order.getProductname());//商品名称
//		httpReq.put("mch_id", mchId);
//		httpReq.put("nonce_str", Util.getRandomStringByLength(32));
//		httpReq.put("notify_url", noifyUrl);
//		httpReq.put("out_trade_no", order.getOrdercode());
//		httpReq.put("spbill_create_ip", IPAddressUtils.getIpAddr(request));
//		String amount="";
//		if("2".equals(ConfigProp.getString("env"))){
//			amount="1";
//		}else if("3".equals(ConfigProp.getString("env"))){
//			amount=(int) (order.getOrderamount()*100)+"";
//		}
//		httpReq.put("total_fee", amount);
//		httpReq.put("trade_type", tradeType);
//		httpReq.put("product_id", order.getCoreproductcode());
//		httpReq.put("time_expire", tradingEndTime);
//		httpReq.put("sign", "");
//		
//		SortedMap<String, Object> httpRes=HttpClient.sendPost(httpReq, key, "wexin_unifiedorder");
//		
//		if(httpRes == null){
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2016", "NATIVE预支付发送请求，返回参数为空");
//		}
//		
//		Date now=new Date();
//		String reqStr=XMLUtil.mapToXmlString(httpReq);
//		//请求信息保存数据库
//		//支付记录
//		boolean insert=false;
//		ProposalPayment proposalPayment=proposalPaymentService.getProposalPaymentByOrderCode(order.getOrdercode());
//		if(proposalPayment == null){
//			insert=true;
//			proposalPayment = new ProposalPayment();
//		}
//		proposalPayment.setMerId(mchId);
//		proposalPayment.setOrderNo(order.getOrdercode());
//		proposalPayment.setFlowno(order.getFlowno());
//		proposalPayment.setTransType("NATIVE");
//		proposalPayment.setCertType("1");
//		proposalPayment.setCertId(order.getAgentidentitycode());
//		proposalPayment.setCuryId("CNY");
//		proposalPayment.setTransAmt(order.getOrderamount()+"");
//		proposalPayment.setPurpose("支付记录");
//		proposalPayment.setTranSdate(DateUtil.DateToString(now, "yyyy-MM-dd"));
//		proposalPayment.setTransTime(DateUtil.DateToString(now, "HH:mm:ss"));
//		proposalPayment.setProposalNo(policy.getPolicycode());
//		proposalPayment.setMessageStr(reqStr);
//		proposalPayment.setCreatDate(DateUtil.DateToString(now, "yyyy-MM-dd"));
//		proposalPayment.setCreatTime(DateUtil.DateToString(now, "HH:mm:ss"));
//		//预订单请求失败
//		if("FAIL".equals((String)httpRes.get("return_code"))){
//			proposalPayment.setResponseCode("01");
//			proposalPayment.setMessageStr((String)httpRes.get("return_msg"));
//		}else if("SUCCESS".equals(httpRes.get("return_code")) && "FAIL".equals(httpRes.get("result_code"))){
//			proposalPayment.setResponseCode("01");
//			proposalPayment.setMessageStr((String)httpRes.get("err_code_des"));
//		}
//		if(insert){
//			proposalPaymentService.saveProposalPayment(proposalPayment);
//		}else{
//			proposalPaymentService.updateProposalPayment(proposalPayment);
//		}
//		
//		
//		//支付请求数据
//		ProposalPaymentLog  proposalPaymentLog = new ProposalPaymentLog();
//		proposalPaymentLog.setMerId(mchId);
//		proposalPaymentLog.setOrderNo(order.getOrdercode());
//		proposalPaymentLog.setFlowNo(order.getFlowno());
//		proposalPaymentLog.setTransType("NATIVE");
//		proposalPaymentLog.setCertType("1");
//		proposalPaymentLog.setCertId(order.getAgentidentitycode());
//		proposalPaymentLog.setCuryId("CNY");
//		proposalPaymentLog.setTransAmt(order.getOrderamount()+"");
//		proposalPaymentLog.setPurpose("支付请求数据");
//		proposalPaymentLog.setTranSdate(DateUtil.DateToString(now, "yyyy-MM-dd"));
//		proposalPaymentLog.setTransTime(DateUtil.DateToString(now, "HH:mm:ss"));
//		proposalPaymentLog.setProposalNo(policy.getPolicycode());
//		proposalPaymentLog.setMessageStr(reqStr);
//		proposalPayment.setCreatDate(DateUtil.DateToString(now, "yyyy-MM-dd"));
//		proposalPayment.setCreatTime(DateUtil.DateToString(now, "HH:mm:ss"));
//		
//		proposalPaymentLogService.saveProposalPaymentLog(proposalPaymentLog);
//
//		
//		if("SUCCESS".equals(httpRes.get("return_code")) && "SUCCESS".equals(httpRes.get("result_code"))){
//			//预支付请求成功
//			// 获取返回参数
//			codeUrl=(String)httpRes.get("code_url");//微信二维码地址 
//		}
//		return codeUrl;
//	}
//
//

	@Override
	public synchronized void updateProposalPaymentAndSaveProposalPaymentLog(Map map) {
		ProposalPayment  proposalPayment=proposalPaymentService.getProposalPaymentByFlowNo((String)map.get("out_trade_no"));
		if(proposalPayment == null || ("00").equals(proposalPayment)){
			return;
		}
		ProposalPaymentLog proposalPaymentLog=proposalPaymentLogService.getProposalPaymentLogByFlowNo((String)map.get("out_trade_no"));
		if(proposalPayment != null){
			ProposalPaymentLog  proposalPaymentLogNew = new ProposalPaymentLog();
			if("FAIL".equals(map.get("return_code"))){
				proposalPayment.setResponseCode("01");
				proposalPaymentLogNew.setResponseCode("01");
			}else if("SUCCESS".equals(map.get("return_code")) && "FAIL".equals(map.get("result_code"))){
				proposalPayment.setResponseCode("01");
				proposalPaymentLogNew.setResponseCode("01");
			}else if("SUCCESS".equals(map.get("return_code")) && "SUCCESS".equals(map.get("result_code"))){
				proposalPayment.setResponseCode("00");
				proposalPaymentLogNew.setResponseCode("00");
			}else if("TRADE_SUCCESS".equals(map.get("trade_status"))){
				proposalPayment.setResponseCode("00");
				proposalPaymentLogNew.setResponseCode("00");
			}else if(!"TRADE_SUCCESS".equals(map.get("trade_status"))){
				proposalPayment.setResponseCode("00");
				proposalPaymentLogNew.setResponseCode("01");
			}
			proposalPaymentService.updateProposalPayment(proposalPayment);
			
			//返回数据
			Date  now = new Date();
			proposalPaymentLogNew.setMerId(proposalPaymentLog.getMerId());
			proposalPaymentLogNew.setOrderNo(proposalPaymentLog.getOrderNo());
			proposalPaymentLogNew.setFlowNo(proposalPaymentLog.getFlowNo());
			proposalPaymentLogNew.setTransType(proposalPaymentLog.getTransType());
			proposalPaymentLogNew.setCertType(proposalPaymentLog.getCertType());
			proposalPaymentLogNew.setCertId(proposalPaymentLog.getCertId());
			proposalPaymentLogNew.setCuryId(proposalPaymentLog.getCuryId());
			proposalPaymentLogNew.setTransAmt(proposalPaymentLog.getTransAmt());
			proposalPaymentLogNew.setPurpose("返回结果数据");
			proposalPaymentLogNew.setTranSdate(DateUtil.DateToString(now, "yyyy-MM-dd"));
			proposalPaymentLogNew.setTransTime(DateUtil.DateToString(now, "HH:mm:ss"));
			proposalPaymentLogNew.setProposalNo(proposalPaymentLog.getProposalNo());
			proposalPaymentLogNew.setMessageStr(XMLUtil.mapToXmlString(map));
			proposalPaymentLogNew.setCreatDate(DateUtil.DateToString(now, "yyyy-MM-dd"));
			proposalPaymentLogNew.setCreatTime(DateUtil.DateToString(now, "HH:mm:ss"));
			
			proposalPaymentLogService.saveProposalPaymentLog(proposalPaymentLogNew);
		}
		
		
	}


//
//	@Override
//	public String zhifubaoPay(GeOrder order) throws Exception {
//		Set<GePolicy> policySet=order.getPolicys();
//		Iterator<GePolicy> it=policySet.iterator();
//		GePolicy policy=null;
//		while(it.hasNext()){
//			policy=it.next();
//		}
//		String payWay=order.getPayway();
//		Map<String, String> sParaTemp = new HashMap<String, String>();
//		Date endTime =DateUtil.addMinute(order.getCreatedate(), Integer.parseInt(PaymentConfigProp.getString("paytime_out")));
//		long payCloseTime=DateUtil.getMinuteDistanceNow(endTime);
//		String sellerEmail=PaymentConfigProp.getString("zhifubao_seller_email");
//		String partner=PaymentConfigProp.getString("zhifubao_partner");
//		String totalFee="";
//		String returnStr="";
//		if("2".equals(ConfigProp.getString("env"))){
//			totalFee="0.01";
//		}else if("3".equals(ConfigProp.getString("env"))){
//			totalFee=order.getOrderamount()+"";
//		}
//		//把请求参数打包成数组
//		//把请求参数打包成数组
//		if("20".equals(payWay) || "22".equals(payWay)){
//			
//			//支付宝即时到帐   和 银行支付
//			//服务器异步通知页面路径
//			String notify_url = PaymentConfigProp.getString("zhifubao_notifyUrl");
//			//需http://格式的完整路径，不能加?id=123这类自定义参数
//
//			//页面跳转同步通知页面路径
//			String return_url = PaymentConfigProp.getString("zhifubao_returnUrl");
//			//需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/
//			
//			sParaTemp.put("service", "create_direct_pay_by_user");
//	        sParaTemp.put("partner", partner);
//	        sParaTemp.put("seller_email", sellerEmail);
//	        
//	        sParaTemp.put("_input_charset", "UTF-8");
//			sParaTemp.put("payment_type", "1");//支付类型
//			sParaTemp.put("notify_url", notify_url);
//			sParaTemp.put("return_url", return_url);
//			sParaTemp.put("out_trade_no",order.getFlowno());
//			sParaTemp.put("subject", order.getOrdercode());	//订单号
//			sParaTemp.put("total_fee", totalFee);
//			sParaTemp.put("it_b_pay",payCloseTime+"m");//超市时间
//			
//	        if("22".equals(payWay)){
//	        	 sParaTemp.put("paymethod", "bankPay");
//	        	 sParaTemp.put("defaultbank", order.getBankcode());//支付网银类型
//	        	 sParaTemp.put("extra_common_param", "22,"+order.getOrdercode());
//	        }
//	        if("20".equals(payWay)){
//	        	 sParaTemp.put("extra_common_param", "20,"+order.getOrdercode());
//	        	 
//	        }
//	        sParaTemp.put("sign_type", PaymentConfigProp.getString("zhifubao_sign_type"));
//
//	        returnStr = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
//			
//		}else if("21".equals(payWay)){
//			
//			String signType=PaymentConfigProp.getString("zhifubao_sign_type");
//			//支付宝手机支付
//			//支付宝网关地址
//			String ALIPAY_GATEWAY_NEW = "http://wappaygw.alipay.com/service/rest.htm?";
//
//			////////////////////////////////////调用授权接口alipay.wap.trade.create.direct获取授权码token//////////////////////////////////////
//
//			//req_data详细信息
//			
//			//服务器异步通知页面路径
//			String notify_url =PaymentConfigProp.getString("zhifubao_notifyUrl");
//			//需http://格式的完整路径，不能加?id=123这类自定义参数
//
//			//页面跳转同步通知页面路径
//			String call_back_url = PaymentConfigProp.getString("zhifubao_returnMobileUrl");
//			//需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/
//
//			//操作中断返回地址
//			String merchant_url = PaymentConfigProp.getString("zhifubao_merchantUrl");
//			//用户付款中途退出返回商户的地址。需http://格式的完整路径，不允许加?id=123这类自定义参数
//			
//		
//			//请求业务参数详细
//			String req_dataToken = "<direct_trade_create_req>" +
//					"<notify_url>" + notify_url + "</notify_url>" +
//					"<call_back_url>" + call_back_url + "</call_back_url>" +
//					"<seller_account_name>" + sellerEmail + "</seller_account_name>" +
//					"<out_trade_no>" + order.getFlowno() + "</out_trade_no>" +
//					"<subject>" + order.getOrdercode() + "</subject>" +
//					"<total_fee>" + totalFee + "</total_fee>" +
//					"<pay_expire>"+String.valueOf(payCloseTime)+"</pay_expire>"+
////					"<merchant_url>" + merchant_url + "</merchant_url>" +
//					"</direct_trade_create_req>";
//			//必填
//			
//			//////////////////////////////////////////////////////////////////////////////////
//			
//			//把请求参数打包成数组
//			Map<String, String> sParaTempToken = new HashMap<String, String>();
//			sParaTempToken.put("service", "alipay.wap.trade.create.direct");
//			sParaTempToken.put("partner",partner);
//			sParaTempToken.put("_input_charset","UTF-8");
//			sParaTempToken.put("sec_id", signType);
//			sParaTempToken.put("format", "xml");
//			sParaTempToken.put("v","2.0");
//			sParaTempToken.put("req_id", UtilDate.getOrderNum());//请求号
//			sParaTempToken.put("req_data", req_dataToken);
//			
//			//建立请求
//			String sHtmlTextToken = AlipaySubmit.buildRequest(ALIPAY_GATEWAY_NEW,"", "",sParaTempToken);
//			//URLDECODE返回的信息
//			sHtmlTextToken = URLDecoder.decode(sHtmlTextToken,"UTF-8");
//			
//			//获取token
//			String request_token = AlipaySubmit.getRequestToken(sHtmlTextToken);
//			//out.println(request_token);
//			
//			////////////////////////////////////根据授权码token调用交易接口alipay.wap.auth.authAndExecute//////////////////////////////////////
//			
//			//业务详细
//			String req_data = "<auth_and_execute_req><request_token>" + request_token + "</request_token></auth_and_execute_req>";
//			//必填
//			
//			//把请求参数打包成数组
//			sParaTemp.put("service", "alipay.wap.auth.authAndExecute");
//			sParaTemp.put("partner", partner);
//			sParaTemp.put("_input_charset", "UTF-8");
//			sParaTemp.put("sec_id", signType);
//			sParaTemp.put("format", "xml");
//			sParaTemp.put("v", "2.0");
//			sParaTemp.put("req_data", req_data);
//			//建立请求
//			returnStr = AlipaySubmit.buildRequest(ALIPAY_GATEWAY_NEW, sParaTemp, "get", "确认");
//		}
//		
//		//交易记录存储数据库
//		Date now=new Date();
//		//请求信息保存数据库
//		//支付记录
//		boolean insert=false;
//		ProposalPaymentLog  proposalPaymentLog = new ProposalPaymentLog();
//		ProposalPayment proposalPayment=proposalPaymentService.getProposalPaymentByOrderCode(order.getOrdercode());
//		if(proposalPayment == null){
//			insert=true;
//			proposalPayment = new ProposalPayment();
//		}
//		proposalPayment.setMerId(partner);
//		proposalPayment.setOrderNo(order.getOrdercode());
//		proposalPayment.setFlowno(order.getFlowno());
//		proposalPayment.setFlowno(order.getFlowno());
//		if("20".equals(payWay)){
//			//支付宝即时到帐 
//			proposalPayment.setTransType("支付宝即时到帐 ");
//			proposalPaymentLog.setTransType("支付宝即时到帐");
//		}else if("21".equals(payWay)){
//			//手机网站支付
//			proposalPayment.setTransType("支付宝手机网站支付");
//			proposalPaymentLog.setTransType("支付宝手机网站支付");
//		}else if("22".equals(payWay)){
//			//支付宝网银支付
//			proposalPayment.setTransType("支付宝网银支付 ");
//			proposalPaymentLog.setTransType("支付宝网银支付 ");
//		}
//		
//		proposalPayment.setCertType("1");
//		proposalPayment.setCertId(order.getAgentidentitycode());
//		proposalPayment.setCuryId("CNY");
//		proposalPayment.setTransAmt(totalFee);
//		proposalPayment.setPurpose("支付记录");
//		proposalPayment.setTranSdate(DateUtil.DateToString(now, "yyyy-MM-dd"));
//		proposalPayment.setTransTime(DateUtil.DateToString(now, "HH:mm:ss"));
//		proposalPayment.setProposalNo(policy.getPolicycode());
//		proposalPayment.setMessageStr(returnStr);
//		proposalPayment.setCreatDate(DateUtil.DateToString(now, "yyyy-MM-dd"));
//		proposalPayment.setCreatTime(DateUtil.DateToString(now, "HH:mm:ss"));
//		//预订单请求失败
//		
//		if(insert){
//			proposalPaymentService.saveProposalPayment(proposalPayment);
//		}else{
//			proposalPaymentService.updateProposalPayment(proposalPayment);
//		}
//		
//		
//		//支付请求数据
//		
//		proposalPaymentLog.setMerId(partner);
//		proposalPaymentLog.setOrderNo(order.getOrdercode());
//		proposalPaymentLog.setFlowNo(order.getFlowno());
//		proposalPaymentLog.setCertType("1");
//		proposalPaymentLog.setCertId(order.getAgentidentitycode());
//		proposalPaymentLog.setCuryId("CNY");
//		proposalPaymentLog.setTransAmt(totalFee);
//		proposalPaymentLog.setPurpose("支付请求数据");
//		proposalPaymentLog.setTranSdate(DateUtil.DateToString(now, "yyyy-MM-dd"));
//		proposalPaymentLog.setTransTime(DateUtil.DateToString(now, "HH:mm:ss"));
//		proposalPaymentLog.setProposalNo(policy.getPolicycode());
//		proposalPaymentLog.setMessageStr(returnStr);
//		proposalPaymentLog.setCreatDate(DateUtil.DateToString(now, "yyyy-MM-dd"));
//		proposalPaymentLog.setCreatTime(DateUtil.DateToString(now, "HH:mm:ss"));
//		
//		proposalPaymentLogService.saveProposalPaymentLog(proposalPaymentLog);
//		
//		return returnStr;
//	}
//
//
//
//	@Override
//	public Map<String,String> zhifubaoPayParam(HttpServletRequest request){
//		//获取支付宝POST过来反馈信息
//		Map<String,String> params = new HashMap<String,String>();
//		Map requestParams = request.getParameterMap();
//		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
//			String name = (String) iter.next();
//			String[] values = (String[]) requestParams.get(name);
//			String valueStr = "";
//			for (int i = 0; i < values.length; i++) {
//				valueStr = (i == values.length - 1) ? valueStr + values[i]
//						: valueStr + values[i] + ",";
//			}
//			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
//			try {
//				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
//			} catch (UnsupportedEncodingException e) {
//				throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2021", "将支付宝返回参数转成UTF-8格式时报错");
//			}
//			params.put(name, valueStr);
//		}
//		return params;
//	}

	@Override
	public List<GePaymentTypeInfo> PayWay(GeOrder order) {
		return paymentTypeInfoService.findByLoginWayCode(order.getLoginWay());
	}



	
}
