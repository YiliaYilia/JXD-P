package cn.com.sinosoft.sale.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page2;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GeMobileCustomer;
import cn.com.sinosoft.sale.service.PolicyMobileService;

@Component
public class PolicyMobileServiceImpl extends GenericHibernateDao<GeMobileCustomer, String> implements PolicyMobileService {

	public List<GeMobileCustomer> getOrderByNo(String orderNo) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("microid", orderNo);
		queryRule.addEqual("deleteTag", "00");
		List<GeMobileCustomer> lst = super.find(queryRule);
		if(lst!=null && lst.size()>0){
			return lst;
		}else{
			return null;
		}
	}

	public Page2 findAllOrders(String hql, Page2 page2) {
		// TODO Auto-generated method stub
		return null;
	}

	public GeMobileCustomer getByCustomerid(String coustomerid) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("coustomerid",coustomerid);
		return findUnique(queryRule);
	}


}
