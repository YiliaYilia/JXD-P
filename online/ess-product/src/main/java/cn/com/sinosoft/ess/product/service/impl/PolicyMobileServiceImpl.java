package cn.com.sinosoft.ess.product.service.impl;

import java.util.List;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.user.MobileCustomer;
import cn.com.sinosoft.ess.product.service.PolicyMobileService;

public class PolicyMobileServiceImpl  extends GenericHibernateDao<MobileCustomer, String> implements PolicyMobileService{
	public MobileCustomer getPolicyMobileMainAll(String id){
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("", id);
		List<MobileCustomer> policyList = this.find(queryRule);
		if(policyList.size()>0){
			return policyList.get(0);
		}
		return null;
	}
	public String savePolicy(MobileCustomer customer){
		this.save(customer);
		return "";
	}
	
}
