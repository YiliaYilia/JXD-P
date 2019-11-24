package cn.com.sinosoft.user.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.system.GeAccountSwitch;

public interface GeAccountSwitchService {
	@SuppressWarnings("unchecked")
	public abstract Page<GeAccountSwitch> findList(String policynum,int pageNumber, int pageSize);
	
	public abstract Page<GeAccountSwitch> findList1(GeAccountSwitch geAccountSwitch,int pageNumber, int pageSize);
	
	public abstract List<GeAccountSwitch> findAll();
	
	public abstract List<GeAccountSwitch> findAll(GeAccountSwitch geAccountSwitch);
}
