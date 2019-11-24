package cn.com.sinosoft.web.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.web.service.facade.ChangebankfindWechatPolicyService;
@Component
public class ChangebankfindWechatPolicyServiceImpl extends GenericHibernateDao<GeOrder,String> implements ChangebankfindWechatPolicyService {
	private final static Logger logger = LoggerFactory.getLogger(ChangebankfindWechatPolicyServiceImpl.class);
	@Override
	public List findpolicybypolicyNo(String policyNo) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addLike("policyno", "%"+policyNo+"%");
		logger.info("------------------"+policyNo);
		return super.find(queryRule);
	}
}
