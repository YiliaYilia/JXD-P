package cn.com.sinosoft.ess.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.ess.product.service.OrderSearchService;
@Component
public class OrderScarchServiceImpl extends GenericHibernateDao<GeOrder, String> implements OrderSearchService {

	@Override
	public List<GeOrder> getOrder(String openId) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("openid", openId);
		queryRule.addEqual("paystatus", "1");
		queryRule.addDescOrder("submittime");
		return super.find(queryRule);
	}

}
