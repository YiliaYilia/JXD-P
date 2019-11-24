package cn.com.sinosoft.msl.service.impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.core.exception.BaseException;
import cn.com.sinosoft.core.exception.enumerate.ExceptionGrade;
import cn.com.sinosoft.core.utils.DateUtil;
import cn.com.sinosoft.core.utils.DateUtils;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.ess.protal.common.ConfigProp;
import cn.com.sinosoft.msl.model.insurancePolicy.request.Body;
import cn.com.sinosoft.msl.service.PaymentService;
import cn.com.sinosoft.msl.service.SalesPolicyService;
import cn.com.sinosoft.sale.service.OrderService;

@Component
@Service("PaymentServices")
public class PaymentServiceImpl implements PaymentService {
	public static Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
	
	private static final DecimalFormat decimalFormat = new DecimalFormat("00000000");
	private static final SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
	private static final Random random = new Random();

	/**
	 * 订单流水号生产
	 * @return
	 */
	public String  getFlowNo(){
		return format.format(new Date())+decimalFormat.format(random.nextInt(100000000));//交易流水号
	}
	
	@Autowired
	private OrderService orderService;
	
	@Override
	public GeOrder getOrder(String orderCode) {
		return orderService.findGeOrderByOrderCode(orderCode);
	}

	/**
	 * 承保
	 * @param order
	 * @return 承保成功返回success,承保失败返回fail
	 */
	public String insurePolicy(GeOrder order){
		//承保
		String returnStr="fail";
		GePolicy policy=null;
		Set<GePolicy> policySet=order.getPolicys();
		Iterator<GePolicy> it=policySet.iterator();
		while(it.hasNext()){
			policy=it.next();
		}
		
		Body body=new Body();
		body.setTranSchnl("0");
		body.setZoneNo(policy.getAreacodepro());
		body.setOldTranNo(policy.getOldlpolicyno());
		body.setProposalPrtNo(order.getOrdercode());
		body.setContNo(policy.getPolicycode());
		body.setSysRefNumber(order.getCircpaymentno());
		body.setChannelCd(order.getPaymentplatform());
		body.setPayType(order.getPayway());
		body.setPayDate(DateUtil.DateToString(order.getPaytime(), "yyyyMMdd"));
		body.setPayTime(DateUtil.DateToString(order.getPaytime(), "HHmmss"));
		body.setSubPrem(order.getOrderamount()+"");
		try {
			SalesPolicyService.insurancePolicy(body);
			returnStr="success";
		} catch (BaseException e) {
			e.printStackTrace();
			returnStr="fail";
		}
		return  returnStr;	
	}
	
	
//	@Override
//	public synchronized String updateOrderAndInsurePolicy(Map map) {
//		//支付宝非手机端异步通知              承保、修改订单信息
//		String commonParam=(String)map.get("extra_common_param");
//		String outTradeNo=(String)map.get("out_trade_no");
//		String tradeNo=(String)map.get("trade_no");//支付宝交易号
//		String payTime=(String)map.get("gmt_payment");//交易付款时间
//		GeOrder order=null;
//		//修改订单信息
//		if(null == commonParam){
//			//支付宝手机网页支付
//			
//		}else{
//			//支付宝非手机网页支付
//			String[] arrayStr=commonParam.split(",");
//			String payWay=arrayStr[0];
//			String orderCode=arrayStr[1];
//			order=orderService.findGeOrderByOrderCode(orderCode);
//			if(order == null){
//				//不存在的情况，但还是写上
//				return "success";
//			}
//			if(!"1".equals(order.getPaystatus())){
//				GePolicy policy=null;
//				Set<GePolicy> policySet=order.getPolicys();
//				Iterator<GePolicy> it=policySet.iterator();
//				while(it.hasNext()){
//					policy=it.next();
//					policy.setPaymentstatus("1");
//					policy.setPlatforminvaliddate(DateUtil.StringToDate(payTime));
//					policy.setUpdatetime(new Date());
//				}
//				order.setPolicys(policySet);
//				order.setCircpaymentno(tradeNo);
//				order.setPaytime(DateUtil.StringToDate(payTime));
//				order.setPaystatus("1");
//				order.setPayway(payWay);
//				order.setPaymentplatform("2");
//				orderService.updateOrder(order);
//				order=orderService.findGeOrderByFlowNoAndPayStatus(outTradeNo,"3");
//			}
//			GePolicy policy=null;
//			Set<GePolicy> policySet=order.getPolicys();
//			Iterator<GePolicy> it=policySet.iterator();
//			while(it.hasNext()){
//				policy=it.next();
//			}
//			
//			if(!outTradeNo.equals(order.getFlowno())){
//				//同一订单多次支付    支付保中同步通知快于异步通知，这里只打印日志，留待与同步通知校验，留作证据
//				String comment="订单号："+order.getOrdercode()+"重复支付，买家帐号:"+(String)map.get("buyer_emai")
//						+",在支付宝中的交易流水号为："+(String)map.get("trade_no")
//						+",支付日期为："+payTime;
//				
//				logger.info(comment);
//				return "success";
//			}
//			
//			if("1".equals(order.getPaystatus()) && outTradeNo.equals(order.getFlowno()) && "1".equals(policy.getStatus())){
//				//该笔订单已经支付成功,支付宝同步通知比异步通知快。且已承保
//				return "success";
//			}
//			
//			if("0".equals(policy.getStatus())){
//				//1.同步通知已经修改订单状态为支付成功，但未承保。2.用户支付成功后，支付宝还未来得及回调页面
//				if("success".equals(this.insurePolicy(order))){
//					policy.setStatus("1");
//					policy.setUpdatetime(new Date());
//					order.setPolicys(policySet);
//					orderService.updateOrder(order);
//					return "success";
//				}
//			}
//		}
//		return "fail";
//	}
//	@Override
//	public String updateOrderAndInsurePolicyMobile(Document document) {
//		String outTradeNo=document.selectSingleNode( "//notify/out_trade_no").getText();
//		String tradeNo=document.selectSingleNode( "//notify/trade_no").getText();//支付宝交易号
//		String payTime=document.selectSingleNode( "//notify/gmt_payment").getText();//交易付款时间
//		GeOrder order=orderService.findGeOrderByFlowNoAndPayStatus(outTradeNo,"3");
//		if(!"1".equals(order.getPaystatus())){
//			GePolicy policy=null;
//			Set<GePolicy> policySet=order.getPolicys();
//			Iterator<GePolicy> it=policySet.iterator();
//			while(it.hasNext()){
//				policy=it.next();
//				policy.setPaymentstatus("1");
//				policy.setPlatforminvaliddate(DateUtil.StringToDate(payTime));
//				policy.setUpdatetime(new Date());
//			}
//			order.setPolicys(policySet);
//			order.setCircpaymentno(tradeNo);
//			order.setPaytime(DateUtil.StringToDate(payTime));
//			order.setPaystatus("1");
//			order.setPayway("21");
//			order.setPaymentplatform("2");
//			orderService.updateOrder(order);
//			order=orderService.findGeOrderByFlowNoAndPayStatus(outTradeNo,"3");
//		}
//		if("success".equals(this.insurePolicy(order))){
//			//修改保单状态为承保，修改订单状态改为已支付等其他信息  
//			GePolicy policy=null;
//			Set<GePolicy> policySet=order.getPolicys();
//			Iterator<GePolicy> it=policySet.iterator();
//			while(it.hasNext()){
//				policy=it.next();
//				policy.setStatus("1");
//				policy.setUpdatetime(new Date());
//			}
//			order.setPolicys(policySet);
//			orderService.updateOrder(order);
//			return "success";
//		}
//		return "fail";
//	}
//
//	@Override
//	public  void zhifubaoUpdateOrder(GeOrder order,Map map) {
//		//支付宝同步通知修改定订单状态
//		String commonParam=(String)map.get("extra_common_param");
//		String outTradeNo=(String)map.get("out_trade_no");
//		if(null != commonParam && !"".equals(commonParam)){
//			String[] arrayStr=commonParam.split(",");
//			String payWay=arrayStr[0];
//			String orderCode=arrayStr[1];
//			if(!orderCode.equals(order.getOrdercode())){
//				logger.info("支付宝同步通知返回的订单号和当前的订单号不一致！");
//				System.out.println("支付宝同步通知返回的订单号和当前的订单号不一致！");
//				return ;
//			}
//			GeOrder geOrder=orderService.getOrderByOrderCode(orderCode);
//			if("1".equals(geOrder.getPaystatus()) && outTradeNo.equals(order.getFlowno())){
//				//该笔订单已经支付成功       这种情况不存在    支付宝同步通知比异步通知快
//				return;
//			}
//			if("1".equals(geOrder.getPaystatus()) && !outTradeNo.equals(order.getFlowno())){
//				//同意订单多次支付
//				String comment=geOrder.getPaymentComment()+"；该笔订单重复支付，买家帐号:"+(String)map.get("buyer_emai")
//						+",在支付宝中的交易流水号为："+(String)map.get("trade_no")
//						+",交易日期为："+DateUtil.DateToString(new Date(), "yyyy-MM-dd");
//				geOrder.setPaymentComment(comment);
//				orderService.updateOrder(geOrder);
//				logger.info("订单号："+geOrder.getOrdercode()+","+comment);
//				return;
//			}
//			
//			if("3".equals(geOrder.getPaystatus())){
//				geOrder.setPaystatus("1");
//				geOrder.setCircpaymentno((String)map.get("trade_no"));
//				geOrder.setPaytime(new Date());
//				geOrder.setPaymentplatform("2");
//				geOrder.setPayway(payWay);
//				geOrder.setFlowno(outTradeNo);
//				orderService.updateOrder(geOrder);
//			}
//		}else{
//			//支付宝手机网页支付
//			//支付宝支付更新订单信息
//			GeOrder geOrder=orderService.findGeOrderByFlowNo((String)map.get("out_trade_no"));
//			if("3".equals(geOrder.getPaystatus())){
//				String trade_no=(String) map.get("trade_no");
//				geOrder.setCircpaymentno(trade_no);
//				geOrder.setPaytime(new Date());
//				geOrder.setPaystatus("1");
//				geOrder.setPayway("21");
//				geOrder.setPaymentplatform("2");
//				orderService.updateOrder(order);
//			}
//		}
//		
//		
//	}
	
	@Override
	public  synchronized String wxUpdateOrderAndInsurePolicy(Map map) {
		//微信支付传的商户订单号为本GeOrder中的订单号
		//微信支付更新订单信息
		GeOrder order=orderService.findGeOrderByOrderCode((String)map.get("out_trade_no"));
		if(order == null){
			return "success";
		}
		if(!"1".equals(order.getPaystatus())){
			//支付成功
			String endTimeStr=(String)map.get("time_end");
			Date endTime=endTimeStr==null?null:DateUtils.toDate(endTimeStr, "yyyyMMddHHmmss");
			String transactionId=(String) map.get("transaction_id");
			order.setCircpaymentno(transactionId);
			order.setPaytime(endTime);
			order.setPaystatus("1");
			String tradeType=(String)map.get("trade_type");
			if("JSAPI".equals(tradeType)){
				order.setPayway("10");
			}else if("NATIVE".equals(tradeType)){
				order.setPayway("11");
			}
			order.setPaymentplatform("1");
			orderService.updateOrder(order);
			order=orderService.findGeOrderByOrderCode((String)map.get("out_trade_no"));
		}
		GePolicy policy=null;
		Set<GePolicy> policySet=order.getPolicys();
		Iterator<GePolicy> it=policySet.iterator();
		while(it.hasNext()){
			policy=it.next();
		}
		
		if("1".equals(policy.getStatus())){
			return "success";
		}
		
		if(!"1".equals(policy.getStatus())){	
			if("success".equals(this.insurePolicy(order))){
				policy.setStatus("1");
				policy.setPlatforminvaliddate(order.getPaytime());
				policy.setPaymentstatus("1");
				policy.setUpdatetime(new Date());
				order.setPolicys(policySet);
				
				orderService.updateOrder(order);
				return "success";
			}
		}
		return "fail";
	}
		
	
	
//	/*@Override
//	public synchronized void zhifubaoMobileUpdateOrder(Map map) {
//		//支付宝支付更新订单信息
//		GeOrder order=orderService.findGeOrderByFlowNo((String)map.get("out_trade_no"));
//		if("0".equals(order.getPaystatus())){
//			String trade_no=(String) map.get("trade_no");
//			order.setCircpaymentno(trade_no);
//			order.setPaytime(new Date());
//			order.setPaystatus("1");
//			order.setPayway("21");
//			order.setPaymentplatform("2");
//			orderService.updateOrder(order);
//		}
//		
//	}*/
	
	@Override
	public  String paySuccess(String orderCode) {
		String env=ConfigProp.getString("env");
		if("0".equals(env) || "1".equals(env)){
			return "success";
		}
		GeOrder order=orderService.findGeOrderByOrderCodeAndPayStatus(orderCode, "1");
		if(order != null){
			//支付成功
			return "success";
		}
		return "fail";
	}
	
	@Override
	public GeOrder updateOrder(GeOrder order,String payType,String bankCode)throws BaseException {
		GeOrder geOrder=orderService.findGeOrderByOrderCodeAndPayStatus(order.getOrdercode(), "0");
		Date createDate=geOrder.getCreatedate();
		Date endDate=DateUtil.addMinute(createDate, 45);
		if(endDate.before(new Date())){
			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2018","支付时间超时");
		}
		geOrder.setPayway(payType);
		geOrder.setBankcode(bankCode);
		geOrder.setFlowno(this.getFlowNo());
		geOrder.setPaystatus("3");
		orderService.updateOrder(geOrder);
		return geOrder;
	}

	@Override
	public synchronized String insurePolicy(String orderCode)throws BaseException {
		GeOrder order=null;
		String env=ConfigProp.getString("env");
		if("0".equals(env) || "1".equals(env)){
			order=orderService.getOrderByOrderCode(orderCode);
		}else{			
			order=orderService.findGeOrderByOrderCodeAndPayStatus(orderCode, "1");
		}
		if(order == null){
			//支付失败
			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2019","您还未成功支付，请选择其他支付方式进行支付");
		}
		GePolicy policy=null;
		Set<GePolicy> policySet=order.getPolicys();
		Iterator<GePolicy> it=policySet.iterator();
		while(it.hasNext()){
			policy=it.next();
		}
		if("1".equals(policy.getStatus())){
			//已经承保
			return "success";
		}
		if("0".equals(policy.getStatus())){
			//承保
			Body body=new Body();
			body.setTranSchnl("0");
			body.setZoneNo(policy.getAreacodepro());
			body.setOldTranNo(policy.getOldlpolicyno());
			body.setProposalPrtNo(order.getOrdercode());
			body.setContNo(policy.getPolicycode());
			body.setSysRefNumber(order.getCircpaymentno());
			body.setChannelCd(order.getPaymentplatform());
			body.setPayType(order.getPayway());
			body.setPayDate(DateUtil.DateToString(order.getPaytime(), "yyyyMMdd"));
			body.setPayTime(DateUtil.DateToString(order.getPaytime(), "HHmmss"));
			body.setSubPrem(order.getOrderamount()+"");
			try {
				SalesPolicyService.insurancePolicy(body);
			} catch (BaseException e) {
				e.printStackTrace();
				return "fail";
			}
			
			//更新订单表
			Iterator<GePolicy> its=policySet.iterator();
			while(its.hasNext()){
				policy=its.next();
				policy.setStatus("1");
				policy.setUpdatetime(new Date());
			}
			order.setPolicys(policySet);
			
			orderService.updateOrder(order);
			
			return  "success";
		}
		return "fail";
	}

	
	@Override
	public GeOrder updateOrderStatus(GeOrder order) {
		GeOrder geOrder=orderService.findGeOrderByOrderCodeAndPayStatus(order.getOrdercode(), "3");
		if(geOrder == null){
			//已支付成功
			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2023","您已支付成功");
		}
		geOrder.setPaystatus("0");
		orderService.updateOrder(geOrder);
		return geOrder;
		
	}
	
	@Override
	public GeOrder unPaidOrder(GeOrder order)throws BaseException {
		GeOrder geOrder=orderService.findGeOrderByOrderCodeAndPayStatus(order.getOrdercode(), "0");
		return geOrder;
	}
	
//	@Override
//	public void updateOrderPay(GeOrder order) {
//		GeOrder geOrder=orderService.findGeOrderByOrderCodeAndPayStatus(order.getOrdercode(), "0");
//		if(null == geOrder){
//			return ;
//		}
//		geOrder.setPaystatus("3");
//		orderService.updateOrder(geOrder);
//	}

	@Override
	public void updateOrderUnPaid(GeOrder order) {
		GeOrder geOrder=orderService.findGeOrderByOrderCodeAndPayStatus(order.getOrdercode(), "3");
		if(null == geOrder){
			return ;
		}
		geOrder.setPaystatus("0");
		orderService.updateOrder(geOrder);
	}

	
//	@Override
//	public GeOrder updateOrderFlowNo(GeOrder order) {
//		order.setFlowno(this.getFlowNo());
//		orderService.updateOrder(order);
//		return order;
//	}
public static void main(String[] args) {
	System.out.println(StringUtils.substring("20140528132222", 0, 8));
	System.out.println(StringUtils.substring("20140528132222", 8, 14));
//	DateUtils.toDate("20150603150247", "yyyyMMddHHmmss")
	System.out.println(DateUtil.StringToDate("20140603151422","yyyyMMddHHmmss"));
}

















	

}

