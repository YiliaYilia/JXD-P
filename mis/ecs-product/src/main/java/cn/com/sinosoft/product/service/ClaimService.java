package cn.com.sinosoft.product.service;

import java.util.List;
import java.util.Set;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.product.GeClaimManagement;
import cn.com.sinosoft.domain.system.GeDepartment;

public interface ClaimService {
	
	public Page<GeClaimManagement> getClaim(Set<GeDepartment> departments,GeClaimManagement geClaim,int page,int rows);
	
	public Page<GeClaimManagement> getClaim(GeClaimManagement geClaim,int page,int rows);

	public GeClaimManagement getClaimByClaimNo(String claimManagementNo);

	public void updateClaimRemark(GeClaimManagement claim);
	
	public List<GeClaimManagement> findbyquery(GeClaimManagement claim,Set<GeDepartment> departments);
	
	public void completionDepartmentForClaim();
	
	public void updateClaim(GeClaimManagement claim);
}
