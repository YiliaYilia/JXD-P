package cn.com.sinosoft.web.service.facade;

import java.util.List;

import cn.com.sinosoft.common.service.axis.AccountVO;
import cn.com.sinosoft.domain.sale.GeAccount;

public interface InvestmentAccountService {

	/**
	 * 对比账户列表并更新
	 * @param accountVOs
	 */
	void mergeAccount(AccountVO[] accountVOs);
	/**
	 * 通过账户代码查询账户信息
	 * @param accountCode
	 * @return
	 */
	List<GeAccount> findAccount(String accountCode);
	
	/**
	 * 插入账户信息
	 * @param accountCode
	 * @param accountName
	 */
	void InsertAccount(String accountCode,String accountName);
}
