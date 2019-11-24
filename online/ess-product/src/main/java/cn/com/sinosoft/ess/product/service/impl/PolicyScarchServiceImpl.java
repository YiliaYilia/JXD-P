package cn.com.sinosoft.ess.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.ess.product.service.PolicySearchService;
@Component
public class PolicyScarchServiceImpl extends GenericHibernateDao<GePolicy, String> implements PolicySearchService {

	@Override
	public List<GePolicy> getPolicy(String openId) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("openid", openId);
		queryRule.addEqual("status", "3");
		queryRule.addEqual("charityflag", "0");
		queryRule.addDescOrder("insuretime");
		return super.find(queryRule);
	}

	
	@Override
	public GePolicy getPolicyInfo(String policyCode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("policycode", policyCode);
		return super.findUnique(queryRule);
	}


	@Override
	public GePolicy getPolicyInfoByPolicyNo(String policyNo) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("policycode", policyNo);
		return super.findUnique(queryRule);
	}

	
	
}
