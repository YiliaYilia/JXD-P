package cn.com.sinosoft.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.core.utils.StringUtils;
import cn.com.sinosoft.domain.system.GeChannel;
import cn.com.sinosoft.user.service.GeChannelService;

@Component
public class GeChannelServiceImpl extends GenericHibernateDao<GeChannel, String> implements GeChannelService{

	@Override
	public Page<GeChannel> findChannelList(GeChannel geChannel, int pageNumber,
			int pageSize) {
		QueryRule queryRule = QueryRule.getInstance();
		if(geChannel!=null){
			if(!StringUtils.isEmpty(geChannel.getChannelCode())){
				queryRule.addLike("channelCode", "%"+geChannel.getChannelCode()+"%");
			}
			if(!StringUtils.isEmpty(geChannel.getChannelName())){
				queryRule.addLike("channelName", "%"+geChannel.getChannelName()+"%");
			}
			if(!StringUtils.isEmpty(geChannel.getDeptCode())){
				queryRule.addLike("deptCode", "%"+geChannel.getDeptCode()+"%");
			}
		}
		return this.find(queryRule, pageNumber, pageSize);
	}

	@Override
	public boolean deleteChannelData(String id) {
		this.deleteByPK(id);
		return true;
	}

	@Override
	public GeChannel getChannelById(String id) {
		return super.get(id);
	}

	@Override
	public boolean addChannelData(GeChannel geChannel) {
		this.save(geChannel);
		return true;
	}

	@Override
	public boolean updateChannelData(GeChannel geChannel) {
		this.update(geChannel);
		return true;
	}

	@Override
	public List<GeChannel> getChannel(String policyName, String channelCode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("policyName", policyName);
		queryRule.addEqual("channelCode", channelCode);
		return this.find(queryRule);
	}
	
	public List<GeChannel> getChannelByUpdae(String policyName, String channelCode,String id) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("policyName", policyName);
		queryRule.addEqual("channelCode", channelCode);
		queryRule.addNotEqual("id", id);
		return this.find(queryRule);
	}

}
