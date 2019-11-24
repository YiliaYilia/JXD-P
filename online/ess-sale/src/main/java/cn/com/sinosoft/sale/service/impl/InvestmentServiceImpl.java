package cn.com.sinosoft.sale.service.impl;

import java.util.Date;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.utils.DateUtils;
import cn.com.sinosoft.domain.sale.GeInvestment;
import cn.com.sinosoft.sale.service.InvestmentService;

@Component
public class InvestmentServiceImpl extends GenericHibernateDao<GeInvestment, String> implements InvestmentService {

	@Override
	public void saveInvestment(GeInvestment geInvestment) {
		super.save(geInvestment);
		
	}
	@Override
	public boolean isExistByPolicyNo(String policyNo) {
		//String sql = "from GeInvestment g where g.policyNo='"+policyNo+"' and to_char(g.createTime,'"+DateUtils.DEFAULT+"') = '"+DateUtils.format(new Date(), DateUtils.DEFAULT)+"'";
		String sql = "from GeInvestment g where g.policyNo='"+policyNo+"' and DATE_FORMAT(g.createTime,'%Y-%m-%d') = '"+DateUtils.format(new Date(), DateUtils.DEFAULT)+"'";
		Query query=getSession().createQuery(sql);
		return query.list().size()>0;
	}
}
