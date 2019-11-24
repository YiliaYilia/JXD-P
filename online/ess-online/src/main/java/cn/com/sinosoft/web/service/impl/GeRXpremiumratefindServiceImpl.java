package cn.com.sinosoft.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GeRXpremiumrate;
import cn.com.sinosoft.web.service.facade.GeRXpremiumratefindService;
@Component
public class GeRXpremiumratefindServiceImpl extends GenericHibernateDao<GeRXpremiumrate, Integer> implements GeRXpremiumratefindService {
	private static final Logger log = LoggerFactory.getLogger(GeRXpremiumratefindServiceImpl.class);
	@Override
	public GeRXpremiumrate findRXpremiumrate(String insuredage) {
		QueryRule query=QueryRule.getInstance();
		query.addEqual("insuredage",insuredage);
		log.info("------查询瑞享费率");
		return super.findUnique(query);
	}
	

}
