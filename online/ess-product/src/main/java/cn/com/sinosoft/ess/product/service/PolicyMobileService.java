package cn.com.sinosoft.ess.product.service;

import cn.com.sinosoft.domain.user.MobileCustomer;


public interface PolicyMobileService {
	public MobileCustomer getPolicyMobileMainAll(String id);
	public String savePolicy(MobileCustomer customer);
	
}
