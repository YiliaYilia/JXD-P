package cn.com.sinosoft.sale.service;

import cn.com.sinosoft.domain.sale.GeInvestment;
/**
 * 追加
 * @author GHY
 *
 */
public interface InvestmentService {
	
	/**
	 * 保存追加投资信息
	 * @param geInvestment
	 */
	public void saveInvestment(GeInvestment geInvestment);
	
	/**
	 * 通过保单保查询是否存在
	 * @param policyNo
	 * @return
	 */
	public boolean isExistByPolicyNo(String policyNo);
	
}
