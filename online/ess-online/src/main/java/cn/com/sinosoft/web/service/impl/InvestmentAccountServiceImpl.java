package cn.com.sinosoft.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.common.service.axis.AccountVO;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GeAccount;
import cn.com.sinosoft.web.service.facade.InvestmentAccountService;
/**
 * 操作投连险账户表
 * @author Administrator
 *
 */
@Service
public class InvestmentAccountServiceImpl extends GenericHibernateDao<GeAccount, Integer>  implements InvestmentAccountService {
	
	/**
	 * 对比更新账户库存账户列表
	 * @param accountVOs	接口返回账户
	 */
	public void mergeAccount(AccountVO[] accountVOs){
		ArrayList listSource = new ArrayList();
		HashMap hm = new HashMap();
		for(AccountVO avo:accountVOs){
			listSource.add(avo.getIvmtAcctCode());
			hm.put(avo.getIvmtAcctCode(), avo.getIvmtAcctName());
		}
		List<GeAccount> listGA = this.findAccounts();
		for(int i=0;i<listGA.size();i++){
			listSource.remove(listGA.get(i).getAccountcode());
		}
		if(listSource.size()>0){
			for(int i=0;i<listSource.size();i++){
			this.InsertAccount(listSource.get(i).toString(), hm.get(listSource.get(i)).toString());
			}
		}
	}
	
	/**
	 * 通过账户代码查询账户信息
	 * @param accountCode
	 * @return
	 */
	public List<GeAccount> findAccount(String accountCode){
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("accountcode", accountCode);
		return this.find(queryRule);
	}

	/**
	 * 插入账户信息
	 * @param accountCode
	 * @param accountName
	 */
	public void InsertAccount(String accountCode,String accountName){
		GeAccount ga = new GeAccount();
		ga.setAccountcode(accountCode);
		ga.setAccountname(accountName);
		this.save(ga);		
	}
	
	/**
	 * 查询全表
	 * @return
	 */
	public List<GeAccount> findAccounts(){
		QueryRule queryRule = QueryRule.getInstance();
		return this.find(queryRule);
	}
}
