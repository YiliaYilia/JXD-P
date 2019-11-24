package cn.com.sinosoft.ess.product.service;
import java.util.List;

import cn.com.sinosoft.domain.sale.GeOrder;
public interface OrderSearchService {
	public List<GeOrder> getOrder(String openId);
}
