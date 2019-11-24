package cn.com.sinosoft.sale.service;

import java.util.List;

import cn.com.sinosoft.domain.sale.GeClaimManagement;

public interface ClaimManagementService {

	/**
	 * 保存理赔
	 */
	public void saveClaimManagement(GeClaimManagement claimManagement);
	
	/**
	 * 是否存在未处理的保单号
	 * 通过openId、保单号、索赔类别查询
	 * @return
	 */
	public boolean isPolicyCode(GeClaimManagement claimManagement);
	
	/**
	 * 查询理赔对象
	 * @return
	 */
	public List<GeClaimManagement> findClaimList(GeClaimManagement claimManagement);
	
}
