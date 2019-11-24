package cn.com.sinosoft.web.service.impl;

import org.springframework.stereotype.Service;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.domain.sale.GeMobileCustomerChange;
import cn.com.sinosoft.web.service.facade.MobileCustomerChangeService;

@Service
public class MobileCustomerChangeServiceImpl extends GenericHibernateDao<GeMobileCustomerChange, Integer> implements MobileCustomerChangeService {
	public void add(GeMobileCustomerChange geMobileCustomerChange){
		this.save(geMobileCustomerChange);
	}

	
}
