package cn.com.sinosoft.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GePayList;
import cn.com.sinosoft.web.service.facade.GePayListService;
@Service
public class GePayListServiceImpl extends GenericHibernateDao<GePayList, Integer> implements GePayListService {

	@Override
	public void savePayList(GePayList gePayList) {
		super.save(gePayList);
	}

	@Override
	public List<GePayList> getPayList(String transaction_id) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("microordercode", transaction_id);
		return this.find(queryRule);
	}

}
