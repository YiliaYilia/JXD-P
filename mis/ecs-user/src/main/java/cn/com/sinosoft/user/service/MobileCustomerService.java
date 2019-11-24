package cn.com.sinosoft.user.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.system.MobileCustomer;

public interface MobileCustomerService {
	
	public Page<MobileCustomer> getMobileCustomerByNameAndIdNumber(MobileCustomer mobileCustomer,int pageNumber, int pageSize);
	
	public List<MobileCustomer> getMobileCustomer();
	
	public int updateCustomer(String name,String openId);

	public int bindingCustomer(String name,String idType,String idNumber,String openId);
}