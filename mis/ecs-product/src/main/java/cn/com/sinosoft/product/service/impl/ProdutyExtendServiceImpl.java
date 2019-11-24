package cn.com.sinosoft.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeProductrisk;
import cn.com.sinosoft.domain.product.GeProdutyExtend;
import cn.com.sinosoft.product.service.ProdutyExtendService;

@Component
public class ProdutyExtendServiceImpl extends GenericHibernateDao<GeProdutyExtend, String> implements ProdutyExtendService {

	public List<GeProdutyExtend> findByQuery(QueryRule Query) {
		return super.find(Query);
	}
	/**
	 * 方法名称：deleteByDutyId <br>
	 * 描述：根据产品责任主键删除产品责任 <br>
	 * 作者：lihengjun <br>
	 * 修改日期：2014年1月15日下午1:37:49 
	 * @see cn.com.sinosoft.product.service.ProdutyExtendService#deleteByDutyId(java.lang.String) 
	 * @param dutyId
	 */
	@ECSOperator(operator="根据产品责任主键删除产品责任")
	public void deleteByDutyId(String dutyId) {
		
		QueryRule q  = QueryRule.getInstance();
		q.addEqual("geProductduty.productdutyno", dutyId);
		List<GeProdutyExtend> list = find(q);
		for (GeProdutyExtend geProdutyExtend : list) {
			delete(geProdutyExtend);
		}
	}

	public void add(GeProdutyExtend geProdutyExtend) {
		super.save(geProdutyExtend);
	}
	@ECSOperator(operator="更新产品责任")
	public void update(GeProdutyExtend geProdutyExtend) {
		super.update(geProdutyExtend);
	}

	public GeProdutyExtend findByPk(String attributeno) {
		return this.get(attributeno);
	}
	@ECSOperator(operator="删除产品责任")
	public void delete(GeProdutyExtend geProdutyExtend) {
		super.delete(geProdutyExtend);
	}

}
