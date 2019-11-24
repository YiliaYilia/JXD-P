package cn.com.sinosoft.sale.service.impl;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GeJobCode;
import cn.com.sinosoft.sale.service.JobCodeService;

@Component
public class JobCodeServiceImpl extends GenericHibernateDao<GeJobCode,String> implements JobCodeService {

	@Override
	public String findJobCode(String industry, String job , String policyName) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("industry", industry);
		queryRule.addEqual("job", job);
		queryRule.addEqual("policyName", policyName);
		return super.findUnique(queryRule).getJobCode();
	}

}
