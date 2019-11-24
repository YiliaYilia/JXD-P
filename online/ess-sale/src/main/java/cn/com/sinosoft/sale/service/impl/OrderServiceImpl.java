package cn.com.sinosoft.sale.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
//import cn.com.sinosoft.domain.card.GeCardSaleRecord;
//import cn.com.sinosoft.domain.product.GeRiskSurvey;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.sale.service.OrderService;

@Component
public class OrderServiceImpl extends GenericHibernateDao<GeOrder, String> implements OrderService {

//	/**
//	 * 方法名称：getOrderByOrderNo <br>
//	 * 描述：通过主键获取订单 <br>
//	 * 作者：liyang <br> 
//	 * 修改日期：2014-1-7下午06:02:48 
//	 * @see cn.com.sinosoft.sale.service.OrderService#getOrderByOrderNo(java.lang.String) 
//	 * @param orderno
//	 * @return
//	 */
//	public GeOrder getOrderByOrderNo(String orderno) {
//		return super.get(orderno);
//	}
//	/**
//	 * 方法名称: getOrderByUserAndOrderNo<br>
//	 * 描述：通过保单号获取保单 撤单专用
//	 * 作者: wfx
//	 * @param orderno
//	 * @param userid
//	 * @return
//	 */
//	public GeOrder getOrderByUserAndOrderNo(String userid,String orderno,String date,String businessType) {
//		
//		QueryRule queryRule = QueryRule.getInstance();
//		queryRule.addEqual("orderno", orderno);
//		queryRule.addEqual("userid", userid);
//		queryRule.addEqual("businessType", businessType);
//		Date start = DateUtils.toDate(date+" 00:00:00", DateUtils.YYYY_MM_DD_HMS);
//		queryRule.addGreaterEqual("submittime", start);
//		Date end = DateUtils.toDate(date+" 23:59:59", DateUtils.YYYY_MM_DD_HMS);
//		queryRule.addLessEqual("submittime", end);
//		List<GeOrder> olt = super.find(queryRule);
//		if(olt!=null && olt.size()>0){
//			for(GeOrder order:olt){
//				return order;
//			}
//		}
//		return null;
//	}
//
//	/**
//	 * 方法名称：updateOrder <br>
//	 * 描述：更新订单 <br>
//	 * 作者：liyang <br>
//	 * 修改日期：2014-1-7下午06:07:16 
//	 * @see cn.com.sinosoft.sale.service.OrderService#updateOrder(cn.com.sinosoft.domain.sale.GeOrder) 
//	 * @param order
//	 */
//
//	public void savePolicy(GePolicy gePolicy) {
//		// TODO Auto-generated method stub
//		super.save(gePolicy);
//	}
//
//	
//
//	
//	public Page2 findAllOrders(final String hql, final Page2 page) {
//		SQLQuery query = getSession().createSQLQuery(hql);
//		page.setRecordCount(query.list().size());   
//		query.setFirstResult((page.getCurrentPage()-1)*page.getPageSize());
//		query.setMaxResults(page.getPageSize());
//		page.setResult(query.list());   
//		return page;  
//	}
//	
//	public List findAllOrders(final String hql) {
//		SQLQuery query = getSession().createSQLQuery(hql);
//		return query.list();  
//	}
//	
	/**
	 * 查询前一天不是未支付，已撤单的单子
	 * @param orderNo
	 * @return
	 */
	public List<GeOrder> findGeOrderList(){
		QueryRule queryRule = QueryRule.getInstance();
		/*queryRule.addNotEqual("paystatus", "0");
		queryRule.addNotEqual("paystatus", "2");
		queryRule.addSql("PAYTIME between trunc(sysdate-1) and trunc(sysdate)-0.00001");*/
		queryRule.addSql("SUBMITTIME between trunc(sysdate-1) and trunc(sysdate)-0.00001");
		return super.find(queryRule);
	}
//
//
//
//	
//	public GeOrder getOrderById(String orderId) {
//		QueryRule queryRule = QueryRule.getInstance();
//		queryRule.addEqual("ordercode", orderId);
//		List<GeOrder> lst = super.find(queryRule);
//		if(lst!=null && lst.size()>0){
//			for(GeOrder order:lst){
//				return order;
//			}
//		}
//		return null;
//	}
//	
//	public GeOrder getOrderByNo(String orderNo) {
//		QueryRule queryRule = QueryRule.getInstance();
//		queryRule.addEqual("orderno", orderNo);
//		List<GeOrder> lst = super.find(queryRule);
//		if(lst!=null && lst.size()>0){
//			for(GeOrder order:lst){
//				return order;
//			}
//		}
//		return null;
//	}
//	
//	public GeOrder getOrderByBankNo(String bankorderNo) {
//		QueryRule queryRule = QueryRule.getInstance();
//		queryRule.addEqual("bankorderno", bankorderNo);
//		List<GeOrder> lst = super.find(queryRule);
//		if(lst!=null && lst.size()>0){
//			for(GeOrder order:lst){
//				return order;
//			}
//		}
//		return null;
//	}

	public void updateOrder(GeOrder order) {
		super.update(order);
	}
//	
//	/**
//	 * 查询前一天所有已对账已支付订单
//	 */
//	public  List<GePolicy> getPolicyforBatch(String date) {
//
//		List <GePolicy> policys =new ArrayList<GePolicy>();
//		QueryRule queryRule =QueryRule.getInstance();
//		Date start = DateUtils.toDate(date+" 00:00:00", DateUtils.YYYY_MM_DD_HMS);
//		queryRule.addGreaterEqual("createdate", start);
//		Date end = DateUtils.toDate(date+" 23:59:59", DateUtils.YYYY_MM_DD_HMS);
//		queryRule.addLessEqual("createdate", end);
//		queryRule.addEqual("paystatus", "1");
//		queryRule.addEqual("status", "1");
//		List<GeOrder> orderl= super.find(queryRule);
//		for(GeOrder order:orderl){
//			Set<GePolicy> policyset =order.getPolicys();
//			policys.addAll(policyset);
//		}
//		return policys;
//		
//	}
//	/**
//	 * 查询前一天所有未支付订单
//	 */
//	public  List<GePolicy> getPolicyforBatchTwo(String date) {
//
//		List <GePolicy> policys =new ArrayList<GePolicy>();
//		QueryRule queryRule =QueryRule.getInstance();
//		Date start = DateUtils.toDate(date+" 00:00:00", DateUtils.YYYY_MM_DD_HMS);
//		queryRule.addGreaterEqual("createdate", start);
//		Date end = DateUtils.toDate(date+" 23:59:59", DateUtils.YYYY_MM_DD_HMS);
//		queryRule.addLessEqual("createdate", end);
//
//		//queryRule.addEqual("paystatus", "0");
//		queryRule.addNotEqual("paystatus", "1");
//		List<GeOrder> orderl= super.find(queryRule);
//		for(GeOrder order:orderl){
//			Set<GePolicy> policyset =order.getPolicys();
//			policys.addAll(policyset);
//		}
//		return policys;
//		
//	}
//	
//	
//
//	public static void main(String[] args) {
//		OrderServiceImpl orderImp = new OrderServiceImpl();
////		List policy = orderImp.getPolicyforBatch();
////		System.out.println(policy.size());
//		
//		GeOrder order = orderImp.getOrderById("4028811b43ae6e210143ae78cd4c0006");
//		System.out.println(order.getBankcode());
//	}
	public GeOrder findGeOrderByOrderCode(String orderCode) {
		Query query=getSession().createQuery("from GeOrder where ordercode='"+orderCode+"'");
		return (GeOrder)query.uniqueResult();
	}
//	public void saveSaleRecord(GeCardSaleRecord geCardSaleRecord) {
//		save(geCardSaleRecord);
//	}
	/**
	 * 方法名称:  saveOrder<br>
	 * 描述：
	 * 作者: wufx
	 * 修改日期：2014年9月12日下午3:32:19 
	 * @return
	 */
	public void saveOrder(GeOrder order) {
		super.save(order);
	}
	/**
	 * 方法名称:  getOrderByOrderCode<br>
	 * 描述：
	 * 作者: wufx
	 * 修改日期：2014年9月12日下午3:32:20 
	 * @return
	 */
	public GeOrder getOrderByOrderCode(String orderCode) {
		if(orderCode==null){
			return null;
		}
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("ordercode", orderCode);
		List<GeOrder> lst = super.find(queryRule);
		if(lst!=null && lst.size()>0){
			for(GeOrder order:lst){
				return order;
			}
		}
		return null;
	}
	
//	@Override
//	public List<GeOrder> getGeOrderByDate() {
//		QueryRule queryRule = QueryRule.getInstance();
//		queryRule.addEqual("businessType", "3");
//		Date start = DateUtils.toDate(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD)+" 00:00:00", DateUtils.YYYY_MM_DD_HMS);
//		queryRule.addGreaterEqual("submittime", start);
//		Date end = DateUtils.toDate(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD)+" 23:59:59", DateUtils.YYYY_MM_DD_HMS);
//		queryRule.addLessEqual("submittime", end);
//		List<GeOrder> olt = super.find(queryRule);
//		return olt;
//	}
//
//	@Override
//	public List<GeOrder> findGeOrderByDateAndType(String date,String businessType) {
//		QueryRule queryRule = QueryRule.getInstance();
//		queryRule.addEqual("businessType", businessType);
//		queryRule.addEqual("paystatus", "1");
//		Date start = DateUtils.toDate(date+" 00:00:00", DateUtils.YYYY_MM_DD_HMS);
//		queryRule.addGreaterEqual("submittime", start);
//		Date end = DateUtils.toDate(date+" 23:59:59", DateUtils.YYYY_MM_DD_HMS);
//		queryRule.addLessEqual("submittime", end);
//		return super.find(queryRule);
//	}
	@Override
	public List<GeOrder> findGeOrderByProductcode(String productcode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("coreproductcode", productcode);
		queryRule.addEqual("paystatus", "1");
		List<GeOrder> geolders=super.find(queryRule);
		System.out.println(geolders.size());
		return geolders;
	}
//	@Override
//	public GeOrder findGeOrderByFlowNo(String flowNo) {
//		QueryRule queryRule = QueryRule.getInstance();
//		queryRule.addEqual("flowno", flowNo);
//		List<GeOrder> lst = super.find(queryRule);
//		if(lst!=null && lst.size()>0){
//			for(GeOrder order:lst){
//				return order;
//			}
//		}
//		return null;
//	}
//	
	////====================onlineSales=================
	@Override
	public GeOrder findGeOrderByOrderCodeAndPayStatus(String orderCode,
			String payStatus) {
		if(null == orderCode && null==payStatus){
			return null;
		}
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("ordercode", orderCode);
		queryRule.addEqual("paystatus", payStatus);
		List<GeOrder> lst = super.find(queryRule);
		if(lst!=null && lst.size()>0){
			return lst.get(0);
		}
		return null;
	}
//	@Override
//	public GeOrder findGeOrderByFlowNoAndPayStatus(String flowNo,
//			String payStatus) {
//		if(null == flowNo && null==payStatus){
//			return null;
//		}
//		QueryRule queryRule = QueryRule.getInstance();
//		queryRule.addEqual("flowno", flowNo);
//		queryRule.addEqual("paystatus", payStatus);
//		List<GeOrder> lst = super.find(queryRule);
//		if(lst!=null && lst.size()>0){
//			return lst.get(0);
//		}
//		return null;
//	}

	@Override
	public List<Double> findSumBookMoney() {
		String hql = "select sum(nvl(g.bookmoney,0)) from GeOrder g where g.paystatus=?";
		Object [] values = new Object[1];
		values[0]= "1";
		return this.findByHql(hql, values);
	}

	@Override
	public boolean findPolicyByOpenidAndCode(String openId, String preferentialcode) {
		Query query=getSession().createQuery("from GePolicy g where g.preferentialcode='"+preferentialcode+"' and g.openid='"+openId+"'");
		if(null != query.uniqueResult()){
			return true;
		} else {
			return false;
		}
		
		
		/*String hql = "from GePolicy g where g.preferentialcode=? and g.openid=?";
		Object [] values = new Object[2];
		values[0]= preferentialcode;
		values[1]= openId;
		List list = this.findByHql(hql, values);
		if(null != list && list.size()>0){
			return true;
		} else{
			return false;
		}*/
		
	}

	@Override
	public void merge(GeOrder order) {
		// TODO Auto-generated method stub
//		super.merge(order);
	}
	
}
