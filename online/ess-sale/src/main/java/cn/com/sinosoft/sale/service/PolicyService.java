package cn.com.sinosoft.sale.service;

import java.util.List;

import cn.com.sinosoft.domain.sale.GePolicy;

public interface PolicyService {

	public boolean findPolicyByOpenidAndCode(String openId,String preferentialcode);
	
	public List<GePolicy> findGePolicyList();
}
