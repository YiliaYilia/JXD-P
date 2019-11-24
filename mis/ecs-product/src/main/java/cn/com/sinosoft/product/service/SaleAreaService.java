package cn.com.sinosoft.product.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeSaleArea;

public interface SaleAreaService {

	public List<GeSaleArea> findByQuery(QueryRule query);

	public void deleteByCoreProduct(String coreproductcode);

	public void add(GeSaleArea geSaleArea);

	public void update(GeSaleArea geSaleArea);

	public GeSaleArea findByPk(String pk);

	public void delete(GeSaleArea geSaleArea);

}
