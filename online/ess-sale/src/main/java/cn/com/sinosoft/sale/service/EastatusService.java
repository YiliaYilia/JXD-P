package cn.com.sinosoft.sale.service;


import cn.com.sinosoft.domain.sale.GeEaccoutStatus;

public interface EastatusService {

	public GeEaccoutStatus findStatus();
	
	public void saveStatus(GeEaccoutStatus eaccoutStatus);
}
