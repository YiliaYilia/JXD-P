package cn.com.sinosoft.web.service.facade;

import java.util.List;

import cn.com.sinosoft.common.service.axis.WeChatQueryModel;
import cn.com.sinosoft.domain.sale.GeOrder;

public interface OrderQueryService {
	
	public List<GeOrder> getTodayOrderList(String openId);

	public WeChatQueryModel getTodayOrderInfo(String tOrderCode);
	
	public GeOrder getLocalOrderInfo(String tOrderCode);
	
	public List<GeOrder> todayOrder(String openId) ;
	
	public void updateStatus(GeOrder geOrder);
	
	public List<GeOrder> getAllOrder();
	
}
