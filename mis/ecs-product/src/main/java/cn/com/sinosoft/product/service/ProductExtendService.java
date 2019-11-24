package cn.com.sinosoft.product.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeProductExtend;

public interface ProductExtendService {

	public List<GeProductExtend> findByQuery(QueryRule query);

	public void deleteByCoreProduct(String coreproductcode);

	public void add(GeProductExtend geProductExtend);

	public void update(GeProductExtend geProductExtend);

	public GeProductExtend findByPk(String pk);

	public void delete(GeProductExtend geProductExtend);

}
