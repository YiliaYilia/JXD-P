package cn.com.sinosoft.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeProductExtendPeriod;
import cn.com.sinosoft.product.service.ProductExtendPeriodService;

@Component
public class ProductExtendPeriodServiceImpl extends GenericHibernateDao<GeProductExtendPeriod, String> implements ProductExtendPeriodService {

	public List<GeProductExtendPeriod> findByQuery(QueryRule query) {
		return super.find(query);
	}

	/**方法名称：deleteByCoreProduct <br>
	 * 描述： <br>
	 * 作者：zlc <br>
	 * 修改日期：2014-3-25下午3:53:23 
	 * @see cn.com.sinosoft.product.service.ProductExtendPeriodService#deleteByCoreProduct(java.lang.String) 
	 * @param coreproductcode
	 */
	@ECSOperator(operator="根据产品代码删除 产品扩展信息")
	public void deleteByCoreProduct(String coreproductcode) {
		QueryRule q  = QueryRule.getInstance();
		q.addEqual("geProductMain.coreproductcode", coreproductcode);
		List<GeProductExtendPeriod> list = find(q);
		for (GeProductExtendPeriod geProductExtend : list) {
			super.delete(geProductExtend);
		}
	}

	public void add(GeProductExtendPeriod geProductExtend) {
		super.save(geProductExtend);
	}

	public void update(GeProductExtendPeriod geProductExtend) {
		super.update(geProductExtend);
	}

	public GeProductExtendPeriod findByPk(String attributeno) {
		return this.get(attributeno);
	}

	public void delete(GeProductExtendPeriod geProductExtend) {
		super.delete(geProductExtend);
	}


}
