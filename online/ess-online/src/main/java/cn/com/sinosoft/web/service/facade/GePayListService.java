package cn.com.sinosoft.web.service.facade;

import java.util.List;

import cn.com.sinosoft.domain.sale.GePayList;

public interface GePayListService {
	public void savePayList(GePayList gePayList);
	public List<GePayList> getPayList(String transaction_id);
}
