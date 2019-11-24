package cn.com.sinosoft.user.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.system.GeMobileCustomerChange;


public interface MobileCustomerChangeService {
	public Page<GeMobileCustomerChange> getAllOfPaging(GeMobileCustomerChange geMobileCustomerChange,int pageNumber, int pageSize);
	public List<GeMobileCustomerChange> getAll();
}
