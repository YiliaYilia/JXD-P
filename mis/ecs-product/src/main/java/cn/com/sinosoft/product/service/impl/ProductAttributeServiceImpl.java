package cn.com.sinosoft.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.domain.product.GeProductAttribute;
import cn.com.sinosoft.domain.system.GeArea;
import cn.com.sinosoft.product.service.ProductAttributeService;
import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;

/**
 * 描述：产品属性处理<br>
 * 作者：Liaojiping <br>
 * 修改日期：2013-12-31下午05:54:55 <br>
 * E-mail:<br>
 */
@Component
public class ProductAttributeServiceImpl  extends GenericHibernateDao<GeProductAttribute, String> implements ProductAttributeService{
    
	/**
	 * 方法名称：getGeProductAttributeAll <br>
	 * 描述： 获取所有的产品属性<br>
	 * 作者：liaojiping <br>
	 * 修改日期：2013-12-31下午05:56:39 
	 * @see cn.com.sinosoft.product.service.ProductAttributeService#getGeProductAttributeAll() 
	 * @return
	 */
	public List<GeProductAttribute> getGeProductAttributeAll() {
		return this.getAll(entityClass,true);
	}
    
	/**
	 * 方法名称：existGeProductAttr <br>
	 * 描述： 查看是否存在产品属性<br>
	 * 作者：liaojiping <br>
	 * 修改日期：2014-1-3下午12:03:32 
	 * @see cn.com.sinosoft.product.service.ProductAttributeService#existGeProductAttr(java.lang.String) 
	 * @param productAttrId
	 * @return
	 */
	public boolean existGeProductAttr(String productAttrId){
		return super.exists(productAttrId);
	}
	
	/**
	 * 方法名称：addGeProductAttr <br>
	 * 描述： 添加产品属性<br>
	 * 作者：liaoJiping <br>
	 * 修改日期：2014-1-3下午01:58:20 
	 * @see cn.com.sinosoft.product.service.ProductAttributeService#addGeProductAttr(cn.com.sinosoft.domain.product.GeProductAttribute) 
	 * @param geProductAttr
	 */
	@ECSOperator(operator="添加产品属性")
	public void addGeProductAttr(GeProductAttribute geProductAttr){
		super.save(geProductAttr);
	}
	
	/**
	 * 方法名称：updateGeProductAttr <br>
	 * 描述：更新产品属性信息
	 * 作者: liaojiping
	 * 修改日期：2014-1-3下午05:14:49 
	 * @see cn.com.sinosoft.product.service.ProductAttributeService#updateGeProductAttr(cn.com.sinosoft.domain.product.GeProductAttribute) 
	 * @param geProductAttr
	 */
	@ECSOperator(operator="修改产品属性")
	public void updateGeProductAttr(GeProductAttribute geProductAttr){
		update(geProductAttr);
	}
	
	/**
	 * 方法名称：getGeProductAttrChild <br>
	 * 描述：获取产品属性的子节点<br>
	 * 作者：liaojiping <br>
	 * 修改日期：2014-1-3下午05:17:11 
	 * @see cn.com.sinosoft.product.service.ProductAttributeService#getGeProductAttrChild(java.lang.String) 
	 * @param parentId
	 * @return
	 */
	public List<GeProductAttribute> getGeProductAttrChild(String parentId){
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("attrparent",parentId);
		queryRule.addAscOrder("seqindex");
	//	queryRule.addDescOrder("seqindex");
		return find(queryRule);
	}
	
	/**
	 * 方法名称：deleteGeProductAttr <br>
	 * 描述：删除产品属性 <br>
	 * 作者：liaojiping <br>
	 * 修改日期：2014-1-3下午05:24:52 
	 * @see cn.com.sinosoft.product.service.ProductAttributeService#deleteGeProductAttr(java.lang.String) 
	 * @param pk
	 */
	@ECSOperator(operator="删除产品属性")
	public void deleteGeProductAttr(String pk){
		deleteByPK(pk);
	}
}
