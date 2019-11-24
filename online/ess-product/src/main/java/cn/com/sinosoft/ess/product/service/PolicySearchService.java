package cn.com.sinosoft.ess.product.service;
import java.util.List;
import cn.com.sinosoft.domain.sale.GePolicy;


public interface PolicySearchService {
	
	public List<GePolicy> getPolicy(String openId);
	public GePolicy getPolicyInfo(String policyCode);
	public GePolicy getPolicyInfoByPolicyNo(String policyNo);
}
