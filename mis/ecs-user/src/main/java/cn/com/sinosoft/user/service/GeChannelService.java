package cn.com.sinosoft.user.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.system.GeChannel;

public interface GeChannelService {
	
	public abstract Page<GeChannel> findChannelList(GeChannel geChannel,int pageNumber, int pageSize);
	
	public abstract boolean deleteChannelData(String id);
	
	public abstract GeChannel getChannelById(String id);
	
	public abstract boolean addChannelData(GeChannel geChannel);
	
	public abstract boolean updateChannelData(GeChannel geChannel);
	
	public abstract List<GeChannel> getChannel(String policyName,String channelCode);
	
	public abstract List<GeChannel> getChannelByUpdae(String policyName, String channelCode,String id);

}
