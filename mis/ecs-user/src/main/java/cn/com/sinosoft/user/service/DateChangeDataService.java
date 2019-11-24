package cn.com.sinosoft.user.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.system.DateChangeData;

public interface DateChangeDataService {

	@SuppressWarnings("unchecked")
	public abstract Page<DateChangeData> findList(DateChangeData dateChangeData,int pageNumber,int pageSizee);

	public abstract List<DateChangeData> finList(DateChangeData changeData);
}