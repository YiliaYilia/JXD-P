package cn.com.sinosoft.sale.service;

import cn.com.sinosoft.domain.sale.GeChannel;

public interface ChannelService {

	public GeChannel findChannel(String channelCode,String policyName);
	public GeChannel findChannel(String channelCode);
}
