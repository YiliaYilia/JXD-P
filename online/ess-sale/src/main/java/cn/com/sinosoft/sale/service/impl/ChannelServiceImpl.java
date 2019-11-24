package cn.com.sinosoft.sale.service.impl;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GeChannel;
import cn.com.sinosoft.sale.service.ChannelService;

@Component
public class ChannelServiceImpl  extends GenericHibernateDao<GeChannel,String> implements ChannelService {

	@Override
	public GeChannel findChannel(String channelCode,String policyName) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("channelCode", channelCode);
		queryRule.addEqual("policyName", policyName);
		return super.findUnique(queryRule);
	}

	@Override
	public GeChannel findChannel(String channelCode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("channelCode", channelCode);
		return super.findUnique(queryRule);
	}
}
