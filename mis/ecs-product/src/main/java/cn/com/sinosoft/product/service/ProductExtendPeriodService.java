package cn.com.sinosoft.product.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeProductExtendPeriod;

public interface ProductExtendPeriodService {

	public List<GeProductExtendPeriod> findByQuery(QueryRule query);

	public void deleteByCoreProduct(String coreproductcode);

	public void add(GeProductExtendPeriod geProductExtend);

	public void update(GeProductExtendPeriod geProductExtend);

	public GeProductExtendPeriod findByPk(String pk);

	public void delete(GeProductExtendPeriod geProductExtend);

}
