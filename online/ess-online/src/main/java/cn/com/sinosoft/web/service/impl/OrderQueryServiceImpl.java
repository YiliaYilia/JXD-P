package cn.com.sinosoft.web.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import cn.com.sinosoft.common.service.axis.PolicyWeChatQueryLocator;
import cn.com.sinosoft.common.service.axis.PolicyWeChatQueryPortType;
import cn.com.sinosoft.common.service.axis.WeChatQueryModel;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.web.service.facade.OrderQueryService;

@Component
public class OrderQueryServiceImpl extends GenericHibernateDao<GeOrder, String>implements OrderQueryService {

	private static Log logger = LogFactory.getLog(OrderQueryServiceImpl.class);
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 

	/***
	 * 查询微信未支付订单列表
	 * 
	 */
	@Override
	public List<GeOrder> getTodayOrderList(String openId) {
		logger.info("订单查询开始，openId：" + openId);
		Date[] values = new Date[2];
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date starttime = calendar.getTime();
		Date endtime = new Date();
		values[0]=starttime;
		values[1]=endtime;
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("openid", openId);
		queryRule.addEqual("billingType", "N");
		queryRule.addEqual("paystatus", "0");
//		queryRule.addEqual("coreproductcode", "TAWENKB-R");
		queryRule.addBetween("submittime", values);
		queryRule.addSql("1=1 and this_.coreproductcode =('TAWENKB-R' or 'WENAIBAO' or 'WENJIABAO' or 'RUIXANKANG')");
		
		List<GeOrder> orderList = find(queryRule);
		List<GeOrder> result =new ArrayList<GeOrder>();
		for (GeOrder geOrder : orderList) {
			for (GePolicy gePolicy : geOrder.getPolicys()) {
				if(gePolicy.getStatus().equals("1")) {
					 result.add(geOrder);
				}
			}
			
		}
		logger.info("订单查询结束，openId：" + openId);
		return result;
	}

	/**
	 * 查询人工核保为银行代扣的订单
	 */

	@Override
	public List<GeOrder> todayOrder(String openId) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("openid", openId);
		queryRule.addEqual("billingType", "Y");
//		queryRule.addEqual("coreproductcode", "TAWENKB-R");
		queryRule.addSql("1=1 and this_.coreproductcode =('TAWENKB-R' or 'WENAIBAO' or 'WENJIABAO' or 'RUIXANKANG')");
		List<GeOrder> resultT = super.find(queryRule);
		List<GeOrder> find =new ArrayList<GeOrder>();
		for (GeOrder geOrder : resultT) {
			for (GePolicy gePolicy : geOrder.getPolicys()) {
//				System.out.println(gePolicy.getStatus());
				if(gePolicy.getStatus().equals("5")) {
					find.add(geOrder);
				}
			}
			
		}
		for (int i = 0; i < find.size(); i++) {
			GeOrder geOrder = find.get(i);
			if (!geOrder.getOrderstatus().equals("3") && !geOrder.getOrderstatus().equals("4")) {
				try { 
					// 更新订单状态
					PolicyWeChatQueryLocator service = new PolicyWeChatQueryLocator();
					WeChatQueryModel result = new WeChatQueryModel();
					PolicyWeChatQueryPortType portType = service.getPolicyWeChatQueryHttpSoap11Endpoint();
					result = portType.getWeChatQuery(geOrder.getFlowno());
					if (result!= null && result.getCode().toString().equals("0")) {
						logger.info("订单详情查询返回内容:");
						logger.info("polCoverNoteNum：" + result.getPolCoverNoteNum() + ",policyNum:"
								+ result.getPolicyNum() + ",inceptionDate:" + result.getInceptionDate() + ",expireDate:"
								+ result.getExpireDate() + ",transferGUID:" + result.getTransferGUID() + ",polStatus:"
								+ result.getPolStatus() + ",code:" + result.getCode() + ",contenct:"
								+ result.getContenct());
						String orderStatus = result.getPolStatus();
						String inceptionDate = result.getInceptionDate(); //生效日期
						if (orderStatus.equals("CH") || orderStatus.equals("S2") || orderStatus.equals("S3")||orderStatus.equals("01")) {
							geOrder.setOrderstatus("1");// 1.核保中
						}
						if (orderStatus.equals("03")) {
							geOrder.setOrderstatus("2");// 2.缴费中
//							geOrder.setPaystatus("10");// 10.银行处理中
						}
						if (orderStatus.equals("03(fail)")) {
							geOrder.setOrderstatus("2");// 2.缴费中
							geOrder.setPaystatus("5");// 2.支付失败
						}
						if (orderStatus.equals("03(success)")) {
							geOrder.setOrderstatus("3");// 3.已承保
							geOrder.setPaystatus("1");// 2.缴费中
							geOrder.setPolicyno(result.getPolicyNum());
							for (GePolicy policy : geOrder.getPolicys()) {
								policy.setPolicycode(result.getPolicyNum());
								policy.setStatus("3");
								policy.setTakeeffecttime(sdf.parse(inceptionDate));
							}
						}
						if (orderStatus.equals("05") || orderStatus.equals("06")) {
							geOrder.setOrderstatus("3");// 3.已承保
							geOrder.setPaystatus("1");// 缴费成功
							geOrder.setPolicyno(result.getPolicyNum());
							for (GePolicy policy : geOrder.getPolicys()) {
								policy.setPolicycode(result.getPolicyNum());
								policy.setStatus("3");
								policy.setTakeeffecttime(sdf.parse(inceptionDate));
							}
						}
						if (orderStatus.equals("02")) {
							geOrder.setPaystatus("5");// 2.支付失败
							geOrder.setOrderstatus("4");// 4.投保失败
						}
						updateStatus(geOrder);
						logger.info("状态更新完成，投保单号:"+geOrder.getFlowno());
					} else {
						logger.info("订单详情查询接口返回code="+result.getCode()+"，描述信息="+result.getContenct()+"，投保单号" + geOrder.getFlowno());
					}
				} catch (Exception e) {
					logger.error("订单详情查询接口异常，投保单号" + geOrder.getFlowno());
					e.printStackTrace();
				}
			}
		}
		return find;
	}

	/***
	 * 查询订单详细
	 * 
	 */
	@Override
	public WeChatQueryModel getTodayOrderInfo(String tOrderCode) {
		PolicyWeChatQueryLocator service = new PolicyWeChatQueryLocator();
		WeChatQueryModel result = new WeChatQueryModel();
		try {
			PolicyWeChatQueryPortType portType = service.getPolicyWeChatQueryHttpSoap11Endpoint();
			logger.info("向核心查询订单详情，投保单号" + tOrderCode);
			result = portType.getWeChatQuery(tOrderCode);
			if (result != null) {
				logger.info("订单详情查询返回内容:");
				logger.info("polCoverNoteNum：" + result.getPolCoverNoteNum() + ",policyNum:" + result.getPolicyNum()
						+ ",inceptionDate:" + result.getInceptionDate() + ",expireDate:" + result.getExpireDate()
						+ ",transferGUID:" + result.getTransferGUID() + ",polStatus:" + result.getPolStatus() + ",code:"
						+ result.getCode() + ",contenct:" + result.getContenct());
			} else {
				logger.error("订单详情查询接口返回空，投保单号" + tOrderCode);
			}
		} catch (Exception e) {
			logger.error("订单详情查询异常，投保单号" + tOrderCode);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 查询订单详细（本地库）
	 * 
	 */
	public GeOrder getLocalOrderInfo(String tOrderCode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("flowno", tOrderCode);
		return super.findUnique(queryRule);
	}

	/**
	 * 查询本地库非最终状态下的订单
	 * 
	 */
	public List<GeOrder> getAllOrder() {
		logger.info(new Date() + "定时任务，从核心更新银行代扣订单状态任务开始执行");
		QueryRule queryRule = QueryRule.getInstance();
//		queryRule.addEqual("coreproductcode", "TAWENKB-R");
		queryRule.addEqual("billingType", "Y");
		queryRule.addNotEqual("orderstatus", "3");
		queryRule.addNotEqual("orderstatus", "4");
		queryRule.addSql("1=1 and this_.coreproductcode =('TAWENKB-R' or 'WENAIBAO' or 'WENJIABAO' or 'RUIXANKANG')");
		List<GeOrder> find = super.find(queryRule);
		for (int i = 0; i < find.size(); i++) {
			GeOrder geOrder = find.get(i);
				try {
					// 更新订单状态
					PolicyWeChatQueryLocator service = new PolicyWeChatQueryLocator();
					WeChatQueryModel result = new WeChatQueryModel();
					PolicyWeChatQueryPortType portType = service.getPolicyWeChatQueryHttpSoap11Endpoint();
					logger.info("定时任务，订单详情查询传入投保单号:"+geOrder.getFlowno());
					result = portType.getWeChatQuery(geOrder.getFlowno());
					if (result != null && "0".equals(result.getCode().toString())) {
						logger.info("定时任务，订单详情查询返回内容:");
						logger.info("polCoverNoteNum：" + result.getPolCoverNoteNum() + ",policyNum:"
								+ result.getPolicyNum() + ",inceptionDate:" + result.getInceptionDate() + ",expireDate:"
								+ result.getExpireDate() + ",transferGUID:" + result.getTransferGUID() + ",polStatus:"
								+ result.getPolStatus() + ",code:" + result.getCode() + ",contenct:"
								+ result.getContenct());
						String orderStatus = result.getPolStatus();
						String inceptionDate = result.getInceptionDate(); //生效日期
						if (orderStatus.equals("CH") || orderStatus.equals("S2") || orderStatus.equals("S3")||orderStatus.equals("01")) {
							geOrder.setOrderstatus("1");// 1.核保中
						}
						if (orderStatus.equals("03")) {
							geOrder.setOrderstatus("2");// 2.缴费中
//							geOrder.setPaystatus("10");// 10.银行处理中
						}
						if (orderStatus.equals("03(fail)")) {
							geOrder.setOrderstatus("2");// 2.缴费中
							geOrder.setPaystatus("5");// 2.支付失败
						}
						if (orderStatus.equals("03(success)")) {
							geOrder.setOrderstatus("3");// 3.已承保
							geOrder.setPaystatus("1");// 2.缴费中
							geOrder.setPolicyno(result.getPolicyNum());
							for (GePolicy policy : geOrder.getPolicys()) {
								policy.setPolicycode(result.getPolicyNum());
								policy.setStatus("3");
								policy.setTakeeffecttime(sdf.parse(inceptionDate));
							}
						}
						if (orderStatus.equals("05") || orderStatus.equals("06")) {
							geOrder.setOrderstatus("3");// 3.已承保
							geOrder.setPaystatus("1");// 缴费成功
							geOrder.setPolicyno(result.getPolicyNum());
							for (GePolicy policy : geOrder.getPolicys()) {
								policy.setPolicycode(result.getPolicyNum());
								policy.setStatus("3");
								policy.setTakeeffecttime(sdf.parse(inceptionDate));
							}
						}
						if (orderStatus.equals("02")) {
							geOrder.setPaystatus("5");// 2.支付失败
							geOrder.setOrderstatus("4");// 4.投保失败
						}
						updateStatus(geOrder);
						logger.info("定时任务，状态更新完成，投保单号:"+geOrder.getFlowno());
					} else {
						logger.error("定时任务，订单详情查询借口返回code="+result.getCode()+"，描述信息="+result.getContenct()+"，投保单号" + geOrder.getFlowno());
					}
				} catch (Exception e) {
					logger.error("定时任务，订单详情查询借口异常，投保单号" + geOrder.getFlowno());
					e.printStackTrace();
				}
		}
		logger.info(new Date() + "定时任务，从核心更新银行代扣订单状态任务结束执行");
		return find;
	}

	@Override
	public void updateStatus(GeOrder geOrder) {
		super.update(geOrder);
	}

	
}
