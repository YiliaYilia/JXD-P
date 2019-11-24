package cn.com.sinosoft.sale.service;

import java.util.List;
import java.util.Map;

import cn.com.sinosoft.core.hibernate.Page2;
//import cn.com.sinosoft.domain.card.GeCardSaleRecord;
//import cn.com.sinosoft.domain.product.GeProductMain;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;
//import cn.com.sinosoft.dto.SaleDto;
import cn.com.sinosoft.ess.protal.model.insure.ResTranData;
//import cn.com.sinosoft.sale.business.underwrite.Underwrite;
//import cn.com.sinosoft.sale.business.underwrite.impl.EVULUnderwrite;

public interface OrderService {

//	/**
//	 * 方法名称: getOrderByOrderNo<br>
//	 * 描述：通过保单号获取保单
//	 * 作者: liyang
//	 * 修改日期：2014-1-7下午06:00:46
//	 * @param orderno
//	 * @return
//	 */
//	GeOrder getOrderByOrderNo(String orderno);
//	/**
//	 * 方法名称: getOrderByUserAndOrderNo<br>
//	 * 描述：通过保单号获取保单 撤单专用
//	 * 作者: wfx
//	 * @param orderno
//	 * @param userid
//	 * @return
//	 */
//	public GeOrder getOrderByUserAndOrderNo(String userid,String orderno,String date,String businessType);
//	
//	public GeOrder getOrderByBankNo(String bankorderNo);
	
	/**
	 * 方法名称: updateOrder<br>
	 * 描述：更新订单
	 * 作者: liyang
	 * 修改日期：2014-1-7下午06:06:55
	 * @param order
	 */
	public void updateOrder(GeOrder order);
//	public GeOrder getOrderById(String orderId);
//	public GeOrder getOrderByNo(String orderNo);
//	public Page2 findAllOrders(String hql,Page2 page2);
//	public List findAllOrders(final String hql);
//
//	
	/**
	 * 查询前一天支付成功的单子
	 * @param orderNo
	 * @return
	 */
	public List<GeOrder> findGeOrderList();
//	
//
//	public List<GePolicy> getPolicyforBatch(String date);
//	public  List<GePolicy> getPolicyforBatchTwo(String date) ;
//	
	/**
	 * 描述:根据订单号查询订单
	 */
	public GeOrder findGeOrderByOrderCode(String orderCode);
	/**
	 * 保存订单
	 */
	public void saveOrder(GeOrder geOrder);
	public GeOrder getOrderByOrderCode(String orderCode);
//	
//	public List<GeOrder> getGeOrderByDate();
//	
//	/**
//	 * 
//	 * @param date
//	 * @param businessType
//	 * @return 
//	 */
//	public List<GeOrder> findGeOrderByDateAndType(String date,String businessType);
//	
	/**
	 * 查询已经付费成功状态为1的order对象集合,需要参数为productcode
	 */
	public List<GeOrder> findGeOrderByProductcode(String productcode);
//	
//	/**
//	 * 根据流水号查询订单信息
//	 * @param flowNo
//	 * @return
//	 */
//	public GeOrder findGeOrderByFlowNo(String flowNo);
//	
//	
//	
//////====================onlineSales=================
	/**
	 * 根据订单号和支付状态查询订单信息
	 * @param orderCode
	 * @param payStatus
	 * @return
	 */
	public GeOrder findGeOrderByOrderCodeAndPayStatus(String orderCode,String payStatus);
//	
//	/**
//	 * 根据流水号和支付状态查询订单信息
//	 * @param flowNo
//	 * @return
//	 */
//	public GeOrder findGeOrderByFlowNoAndPayStatus(String flowNo,String payStatus);
//	
//	
	public List<Double> findSumBookMoney();
	
	/**
	 * 通过openId 和 活动编号获取保单信息
	 * @param openId
	 * @param preferentialcode
	 * @return
	 */
	public boolean findPolicyByOpenidAndCode(String openId,String preferentialcode);
	
	public abstract void merge(GeOrder paramGeOrder);
}
