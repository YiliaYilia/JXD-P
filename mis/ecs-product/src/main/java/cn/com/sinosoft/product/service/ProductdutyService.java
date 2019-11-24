package cn.com.sinosoft.product.service;
// ���ù��� Hibernate Tools 3.2.4.GA (sinosoft version) ��ɣ������ֹ��޸ġ�

import java.util.List;

import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeProductduty;

/**
 * 描述：产品责任信息操作<br>
 * 作者：yuas <br>
 * 修改日期：2014年1月14日上午9:30:43 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 */
public interface ProductdutyService {

	/**
	 * 方法名称：findGeProductdutyByQueryRule <br>
	 * 描述： 查询产品责任信息<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:31:06 
	 * @see cn.com.sinosoft.product.service.ProductdutyService#findGeProductdutyByQueryRule(cn.com.sinosoft.core.hibernate.QueryRule) 
	 * @param queryRule
	 * @return
	 */
	public List<GeProductduty> findGeProductdutyByQueryRule(
			QueryRule queryRule);

	/**
	 * 方法名称：findBySerialNo <br>
	 * 描述：主键查询产品责任信息 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:31:24 
	 * @see cn.com.sinosoft.product.service.ProductdutyService#findBySerialNo(java.lang.String) 
	 * @param pk
	 * @return
	 */
	public GeProductduty findBySerialNo(String pk);

	/**
	 * 方法名称：addGeProductduty <br>
	 * 描述：添加产品责任信息<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:31:37 
	 * @see cn.com.sinosoft.product.service.ProductdutyService#addGeProductduty(cn.com.sinosoft.domain.product.GeProductduty) 
	 * @param duty
	 */
	public void addGeProductduty(GeProductduty duty);

	/**
	 * 方法名称：deleteGeProductduty <br>
	 * 描述：删除产品责任信息 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:31:51 
	 * @see cn.com.sinosoft.product.service.ProductdutyService#deleteGeProductduty(java.lang.String) 
	 * @param pk
	 */
	public void deleteGeProductduty(String pk);

	/**
	 * 方法名称：deleteGeProductduty <br>
	 * 描述：删除产品责任信息 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:32:04 
	 * @see cn.com.sinosoft.product.service.ProductdutyService#deleteGeProductduty(cn.com.sinosoft.domain.product.GeProductduty) 
	 * @param duty
	 */
	public void deleteGeProductduty(GeProductduty duty);

	/**
	 * 方法名称：deleteByProductId <br>
	 * 描述： 根据产品ID，删除产品责任信息<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:32:24 
	 * @see cn.com.sinosoft.product.service.ProductdutyService#deleteByProductId(java.lang.String) 
	 * @param productId
	 */
	public void deleteByProductId(String productId);

	/**
	 * 方法名称：updateGeProductduty <br>
	 * 描述：修改产品责任信息 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:32:45 
	 * @see cn.com.sinosoft.product.service.ProductdutyService#updateGeProductduty(cn.com.sinosoft.domain.product.GeProductduty) 
	 * @param duty
	 */
	public void updateGeProductduty(GeProductduty duty);

}