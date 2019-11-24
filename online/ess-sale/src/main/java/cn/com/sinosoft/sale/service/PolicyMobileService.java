package cn.com.sinosoft.sale.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.Page2;
import cn.com.sinosoft.domain.sale.GeMobileCustomer;

public interface PolicyMobileService {

	public List<GeMobileCustomer> getOrderByNo(String orderNo);
	public Page2 findAllOrders(String hql,Page2 page2);

	public GeMobileCustomer getByCustomerid(String customerno);
	
}
