package cn.com.sinosoft.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.zxing.WriterException;

import cn.com.sinosoft.domain.payment.GePaymentTypeInfo;
//import cn.com.sinosoft.domain.payment.ProposalPaymentLog;
import cn.com.sinosoft.domain.sale.GeOrder;

public interface PayService {
	
	/**
	 * 微信jsapi支付        
	 * 1.根据该用户的openId,订单信息调用预支付接口，获取JSAPI发起支付所需的参数
	 * 2.保存【保单支付信息日志表】和【支付请求和结果信息日志表】
	 * 3.返回JSAPI发起支付所需的参数
	 * @param orderCode
	 * @param request
	 * @return
	 * @throws SocketException 
	 */
	SortedMap<String, Object>  wxJSAPIPrePaymentTradingCard(String openId,GeOrder order,HttpServletRequest request) throws SocketException;
//	
//	/**
//	 * 微信Native支付        
//	 * 1.根据订单信息调用预支付接口，获取Native二维码链接，
//	 * 2.保存【保单支付信息日志表】和支付请求信息到【支付请求和结果信息日志表】
//	 * 3.返回Native支付的二维码链接
//	 * 保存支付请求和返回数据信息     支付记录
//	 * @param orderCode
//	 * @param request
//	 * @return
//	 * @throws SocketException 
//	 * @throws IOException 
//	 */
//	String wxNativePrePaymentTradingCard(GeOrder order,HttpServletRequest request) throws WriterException, IOException;
	
	/**
	 * 更新【保单支付信息日志表】中【responseCode】状态 和保存 结果信息到【支付请求和结果信息日志表】
	 * @param map
	 */
	void updateProposalPaymentAndSaveProposalPaymentLog(Map map);
	
	
//	/**
//	 * 支付宝支付调用第三方接口
//	 * 根据支付方式调用支付宝第三方接口，获取发起支付的参数
//	 * @param order
//	 * @throws Exception 
//	 */
//	String zhifubaoPay(GeOrder order) throws Exception;
//	
//	/**
//	 * 解析支付宝返回参数包括同步通知和异步通知的参数
//	 * @param response
//	 * @param request
//	 * @throws UnsupportedEncodingException 
//	 */
//	Map<String,String> zhifubaoPayParam(HttpServletRequest request) throws UnsupportedEncodingException;
	

	/**
	 * 获取五种支付方式发起支付需要的参数
	 * 1.支付方式为“10”：调用微信公众号预支付接口
	 * 2.支付方式为“11”：调用微信扫码预支付接口
	 * 3.支付方式为“20、21、22”：调用支付宝支付接口
	 * 4.返回正式发起支付所需的参数
	 * @param order
	 * @param openId
	 * @return
	 * @throws SocketException 
	 * @throws IOException 
	 * @throws WriterException 
	 * @throws Exception 
	 */
	String pay(GeOrder order,String openId,HttpServletRequest request) throws SocketException, WriterException, IOException, Exception;
	
	/**
	 * 根据订单中的登录方式查询【ge_paymentTypeInfo】表中该种登录方式支持的支付方式
	 * @param payWay
	 * @return
	 */
	List<GePaymentTypeInfo>   PayWay(GeOrder order);
}
