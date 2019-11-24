package cn.com.sinosoft.web.service.impl;

import org.springframework.stereotype.Service;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.user.GE_ACCOUNT_MAP;
import cn.com.sinosoft.web.service.facade.GE_ACCOUNT_MAPService;

@Service
public class GE_ACCOUNT_MAPServiceImpl extends GenericHibernateDao<GE_ACCOUNT_MAP, String> implements GE_ACCOUNT_MAPService {

	public GE_ACCOUNT_MAP getOne(String name, String value) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual(name,value);
		return this.findUnique(queryRule);
	}
}
