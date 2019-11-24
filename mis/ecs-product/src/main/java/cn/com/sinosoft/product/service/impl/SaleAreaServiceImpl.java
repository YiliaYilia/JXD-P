package cn.com.sinosoft.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeSaleArea;
import cn.com.sinosoft.product.service.SaleAreaService;

@Component
public class SaleAreaServiceImpl extends GenericHibernateDao<GeSaleArea, String> implements SaleAreaService {

	public List<GeSaleArea> findByQuery(QueryRule query) {
		return super.find(query);
	}
	/**
	 * 方法名称：deleteByCoreProduct <br>
	 * 描述：根据产品代码删除服务区域 <br>
	 * 作者：lihengjun <br>
	 * 修改日期：2014年1月15日下午1:43:15 
	 * @see cn.com.sinosoft.product.service.SaleAreaService#deleteByCoreProduct(java.lang.String) 
	 * @param coreproductcode
	 */
	@ECSOperator(operator="根据产品代码删除服务区域")
	public void deleteByCoreProduct(String coreproductcode) {
		QueryRule q  = QueryRule.getInstance();
		q.addEqual("geProductMain.coreproductcode", coreproductcode);
		List<GeSaleArea> list = find(q);
		for (GeSaleArea geSaleArea : list) {
			this.delete(geSaleArea);
		}
	}
	@ECSOperator(operator="添加服务区域")
	public void add(GeSaleArea geSaleArea) {
		super.save(geSaleArea);
	}
	@ECSOperator(operator="更新服务区域")
	public void update(GeSaleArea geSaleArea) {
		super.update(geSaleArea);
	}

	public GeSaleArea findByPk(String attributeno) {
		return this.get(attributeno);
	}
	@ECSOperator(operator="删除服务区域")
	public void delete(GeSaleArea geSaleArea) {
		super.delete(geSaleArea);
	}


}
