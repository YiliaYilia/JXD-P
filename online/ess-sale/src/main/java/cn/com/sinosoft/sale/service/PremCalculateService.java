package cn.com.sinosoft.sale.service;

import cn.com.sinosoft.domain.sale.GePolicy;

public interface PremCalculateService {
	
	public void getSumPrem(GePolicy gePolicy,int copies,int period,String periodUnit);
	
	public String getPolicyPremByPeriod(int period,String periodUnit);
	
	public int convertEffDate(int period);
	
	public String getStandardPeriod(int period);
}
