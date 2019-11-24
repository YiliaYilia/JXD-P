package cn.com.sinosoft.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.web.service.facade.OrderQueryService;

public class OrderOueryCheckImpl {

	@Autowired
	OrderQueryService orderQuery;

	/**
	 * 查询非最终状态的订单 与核心批处理更改状态
	 * 
	 */
	public void OrderStatusCheck() {
		orderQuery.getAllOrder();
	}
}
