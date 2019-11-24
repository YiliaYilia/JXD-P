package cn.com.sinosoft.web.service.facade;

import cn.com.sinosoft.domain.sale.GeOrder;

public interface ChangeBanNumUpdateOrderService {
	GeOrder getOrderbypolicyno(String policyno);
	
	void updateOrder(GeOrder order);
	
}
