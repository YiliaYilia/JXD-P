package cn.com.sinosoft.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeProductExtend;
import cn.com.sinosoft.product.service.ProductExtendService;

@Component
public class ProductExtendServiceImpl extends GenericHibernateDao<GeProductExtend, String> implements ProductExtendService {

	public List<GeProductExtend> findByQuery(QueryRule query) {
		return super.find(query);
	}
	/**
	 * 方法名称：deleteByCoreProduct <br>
	 * 描述：根据产品代码删除 产品扩展信息 <br>
	 * 作者：lihengjun <br>
	 * 修改日期：2014年1月15日下午1:34:40 
	 * @see cn.com.sinosoft.product.service.ProductExtendService#deleteByCoreProduct(java.lang.String) 
	 * @param coreproductcode
	 */
	@ECSOperator(operator="根据产品代码删除 产品扩展信息")
	public void deleteByCoreProduct(String coreproductcode) {
		QueryRule q  = QueryRule.getInstance();
		q.addEqual("geProductMain.coreproductcode", coreproductcode);
		List<GeProductExtend> list = find(q);
		for (GeProductExtend geProductExtend : list) {
			super.delete(geProductExtend);
		}
	}

	public void add(GeProductExtend geProductExtend) {
		super.save(geProductExtend);
	}

	public void update(GeProductExtend geProductExtend) {
		super.update(geProductExtend);
	}

	public GeProductExtend findByPk(String attributeno) {
		return this.get(attributeno);
	}

	public void delete(GeProductExtend geProductExtend) {
		super.delete(geProductExtend);
	}


}
