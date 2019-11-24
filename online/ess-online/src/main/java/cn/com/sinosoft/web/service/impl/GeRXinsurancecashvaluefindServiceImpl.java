package cn.com.sinosoft.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GeRXinsurancecashvalue;
import cn.com.sinosoft.web.service.facade.GeRXinsurancecashvaluefindService;
@Component
public class GeRXinsurancecashvaluefindServiceImpl extends GenericHibernateDao<GeRXinsurancecashvalue, Integer>
		implements GeRXinsurancecashvaluefindService {
	private static final Logger log = LoggerFactory.getLogger(GeRXinsurancecashvaluefindServiceImpl.class);
	@Override
	public GeRXinsurancecashvalue findRXinsurancecashvalue(String paymentperiod, String sex, String insuredage,String endyear) {
		QueryRule query=QueryRule.getInstance();
		query.addEqual("paymentperiod",paymentperiod);
		query.addEqual("sex",sex);
		query.addEqual("insuredage",insuredage);
		query.addEqual("endyear",endyear);
		log.info("------查询瑞享现金价值");
		return super.findUnique(query);
	}

}
