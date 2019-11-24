package cn.com.sinosoft.web.service.impl;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GeneticAssays;
import cn.com.sinosoft.web.service.facade.GeneticAssaysService;

@Component
public class GeneticAssaysServiceImpl extends GenericHibernateDao<GeneticAssays, String> implements GeneticAssaysService  {

	@Override
	public void saveGeneticAssays(GeneticAssays assays) {
		this.save(assays);
	}

	
	
	@Override
	public boolean GeneticAssaysCheck(String openid) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("openid", openid);
		return this.exists(queryRule);
		 
	}

}
