package cn.com.sinosoft.product.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.sell.GePayList;

public interface PayListService {
	public Page<GePayList> getPayList(GePayList gePayList,int page,int rows );
	public List<GePayList> getAllPayList(String policyno,String orderid,String applicantname,String isback,String starttime,String endtime);
}
