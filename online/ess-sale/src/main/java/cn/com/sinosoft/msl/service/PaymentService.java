package cn.com.sinosoft.msl.service;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;

import cn.com.sinosoft.domain.payment.GePaymentTypeInfo;
import cn.com.sinosoft.domain.sale.GeOrder;

/**
 * 描述：支付方式, 第三方支付平台<br>
 * 作者：CaryXu <br>
 * 修改日期：2015年4月30日 12:39:41 <br>
 * E-mail: Xukaizhen@sinosoft.com.cn <br>
 */
public interface PaymentService {
	
	/**
	 * 根据订单号查询订单
	 * @param orderCode
	 * @return
	 */
	GeOrder getOrder(String orderCode);
//	
//	/**
//	 * 承保
//	 * @param order
//	 * @return
//	 */
//	public String insurePolicy(GeOrder order);
//	
//	/**
//	 * 支付宝手机端异步通知修改订单信息和承保
//	 * @param document
//	 * @return
//	 */
//	String updateOrderAndInsurePolicyMobile(Document document);
//	/**
//	 * 更新订单表和承保
//	 * @param map
//	 */
//	String updateOrderAndInsurePolicy(Map map);

	/**
	 * 微信支付更新订单状态并承保
	 * @param geOrder
	 */
	String  wxUpdateOrderAndInsurePolicy(Map map);
	
//	/**
//	 * 支付宝支付更新订单状态  ,根据公共参数是否为空来判断是支付宝手机支付还是支付宝非手机支付
//	 * @param map
//	 * @return
//	 */
//	void zhifubaoUpdateOrder(GeOrder order,Map map);
//	
//	/**
//	 * 支付宝手机网站支付更新订单状态
//	 * @param map
//	 */
////	void zhifubaoMobileUpdateOrder(Map map);
	
	/**
	 * 判断是否付款成功，如果付款成功，则承保 返回true
	 * @param orderCode
	 * @return
	 */
	String paySuccess(String orderCode);
	
	/**
	 * 1.根据订单号，查询订单状态为未支付的订单
	 * 2.校验该笔订单是否超过45分钟（核保时间开始计算, 45分钟内用户必须完成付款.）
	 * 3.未超时，则设置支付方式，订单流水号，和订单状态为支付中。
	 * 4.将以上更新的订单数据保存到数据库。
	 * 5.返回该笔订单的最新信息
	 * @param order
	 */
	GeOrder updateOrder(GeOrder order,String payType,String bankCode);
//	
//	/**
//	 * 设置订单状态为支付中
//	 * 1.根据订单号、订单状态为未支付查询订单
//	 * 2.如果订单不为空设置订单为支付中
//	 * @param order
//	 * @return
//	 */
//	void updateOrderPay(GeOrder order);
	
	/**
	 * 设置订单状态为未支付
	 * 1.根据订单号、订单状态为支付中查询订单
	 * 2.如果订单不为空设置订单为未支付
	 * @param order
	 * @return
	 */
	void updateOrderUnPaid(GeOrder order);
	
	/**
	 * 承保
	 * @param orderCode
	 * @return
	 */
	String insurePolicy(String orderCode);

	/**
	 * 更新订单的流水号
	 */
//	GeOrder updateOrderFlowNo(GeOrder order);
	
	GeOrder updateOrderStatus(GeOrder order);
	
	/**
	 * 根据订单号查询未支付的订单
	 * @param order
	 * @return
	 */
	GeOrder unPaidOrder(GeOrder order);
	
}
