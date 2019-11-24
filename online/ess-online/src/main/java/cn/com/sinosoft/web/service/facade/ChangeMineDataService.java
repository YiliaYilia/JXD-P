package cn.com.sinosoft.web.service.facade;

import cn.com.sinosoft.domain.user.ChangeMineData;


public interface ChangeMineDataService {
	public abstract void saveOrUpdate(String propertyName, Object value,
			ChangeMineData changeMineData);
}
