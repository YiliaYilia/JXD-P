package cn.com.sinosoft.web.service.impl;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.web.service.facade.ChangeBanNumUpdateOrderService;
@Component
public class ChangeBanNumUpdateOrderServiceImpl extends GenericHibernateDao<GeOrder,String> implements ChangeBanNumUpdateOrderService {

	@Override
	public void updateOrder(GeOrder order) {
		super.update(order);
	}

	@Override
	public GeOrder getOrderbypolicyno(String policyno) {
		QueryRule query=QueryRule.getInstance();
		query.addEqual("policyno",policyno);
		return super.findUnique(query);
	}
	

}
