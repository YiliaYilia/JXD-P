package cn.com.sinosoft.product.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.product.GeInvestment;

public interface InvestmentService {
	
	public Page<GeInvestment> getInvestmentList(GeInvestment geInvestment,int page,int rows);

	public List<GeInvestment> getAllInvestment(GeInvestment geInvestment);


}
