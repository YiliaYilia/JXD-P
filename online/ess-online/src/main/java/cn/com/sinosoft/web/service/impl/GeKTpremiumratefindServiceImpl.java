package cn.com.sinosoft.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GeKTpremiumrate;
import cn.com.sinosoft.domain.sale.GeRXpremiumrate;
import cn.com.sinosoft.web.service.facade.GeKTpremiumratefindService;
@Component
public class GeKTpremiumratefindServiceImpl extends GenericHibernateDao<GeKTpremiumrate, Integer> implements GeKTpremiumratefindService {
	private static final Logger log = LoggerFactory.getLogger(GeKTpremiumratefindServiceImpl.class);
	@Override
	public GeKTpremiumrate findKTpremiumrate(String insuredage) {
		QueryRule query=QueryRule.getInstance();
		query.addEqual("insuredage",insuredage);
		log.info("------查询康泰费率");
		return super.findUnique(query);
	}
	

}
