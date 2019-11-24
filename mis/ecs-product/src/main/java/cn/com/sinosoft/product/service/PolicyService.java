package cn.com.sinosoft.product.service;

import java.util.List;
import java.util.Set;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.sell.GePolicy;
import cn.com.sinosoft.domain.system.GeDepartment;

public interface PolicyService {
	
	public Page<GePolicy> getPolicy(Set<GeDepartment> departments,GePolicy gePolicy,int page,int rows);
	
	public Page<GePolicy> getPolicy(GePolicy gePolicy,int page,int rows);
	
	public Page<GePolicy> getCharityPolicy(GePolicy gePolicy,int page,int rows);
	
	public GePolicy getPolicyByPolicyno(String policyno);
	
	public List<GePolicy> getAllPolicy(String policycode,String productname,String applicantname,String status,String starttime,String endtime,String agentcode,String brno,String deptid,Set<GeDepartment> departments);
	
	public List<GePolicy> getAllPolicy(String policycode,String productname,String applicantname,String status,String starttime,String endtime,String agentcode,String brno,String deptid);
	
	public List<GePolicy> getAllCharityPolicy(String policycode,String productname,String applicantname,String status,String starttime,String endtime);
}
