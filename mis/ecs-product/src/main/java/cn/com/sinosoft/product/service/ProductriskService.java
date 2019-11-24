package cn.com.sinosoft.product.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeProductrisk;

/**
 * 描述：产品险种操作类<br>
 * 作者：yuas <br>
 * 修改日期：2014年1月14日上午9:22:10 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 */
public interface ProductriskService {
	/**
	 * 根据主键查找
	 * 方法名称：get <br>
	 * 描述： 根据主键查找 <br>
	 * 作者：partrick <br>
	 * 修改日期：2014年1月11日下午4:30:05 
	 * @see cn.com.sinosoft.core.hibernate.GenericHibernateDao#get(java.io.Serializable) 
	 * @param pk
	 * @return
	 */
	public GeProductrisk get(String pk);

	/**
	 * 方法名称：findGeProductriskByCoreProductCode <br>
	 * 描述：根据产品查找产品险种信息 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:22:58 
	 * @see cn.com.sinosoft.product.service.ProductriskService#findGeProductriskByCoreProductCode(java.lang.String) 
	 * @param coreProductCode
	 * @return
	 */
	public List<GeProductrisk> findGeProductriskByCoreProductCode(String coreProductCode);

	/**
	 * 方法名称：findByRiskCode <br>
	 * 描述： 根据产品险种代码查询产品险种信息<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:23:40 
	 * @see cn.com.sinosoft.product.service.ProductriskService#findByRiskCode(java.lang.String) 
	 * @param code
	 * @return
	 */
	public GeProductrisk findByRiskCode(String code);

	/**
	 * 方法名称：addGeProductrisk <br>
	 * 描述： 添加产品险种<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:24:21 
	 * @see cn.com.sinosoft.product.service.ProductriskService#addGeProductrisk(cn.com.sinosoft.domain.product.GeProductrisk) 
	 * @param risk
	 */
	public void addGeProductrisk(GeProductrisk risk);

	/**
	 * 方法名称：deleteGeProductrisk <br>
	 * 描述：删除产品险种 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:24:42 
	 * @see cn.com.sinosoft.product.service.ProductriskService#deleteGeProductrisk(java.lang.String) 
	 * @param code
	 */
	public void deleteGeProductrisk(String code);

	/**
	 * 方法名称：deleteGeProductrisk <br>
	 * 描述： 删除产品险种<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:25:21 
	 * @see cn.com.sinosoft.product.service.ProductriskService#deleteGeProductrisk(cn.com.sinosoft.domain.product.GeProductrisk) 
	 * @param risk
	 */
	public void deleteGeProductrisk(GeProductrisk risk);

	/**
	 * 方法名称：findByQueryRule <br>
	 * 描述： 查询产品险种<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:25:03 
	 * @see cn.com.sinosoft.product.service.ProductriskService#findByQueryRule(cn.com.sinosoft.core.hibernate.QueryRule) 
	 * @param qu
	 * @return
	 */
	public List<GeProductrisk> findByQueryRule(QueryRule qu);

	/**
	 * 方法名称：deleteByProductId <br>
	 * 描述：根据产品id，删除产品险种 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:25:40 
	 * @see cn.com.sinosoft.product.service.ProductriskService#deleteByProductId(java.lang.String) 
	 * @param productId
	 */
	public void deleteByProductId(String productId);

	/**
	 * 方法名称：updateGeProductrisk <br>
	 * 描述： 修改产品险种<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:26:01 
	 * @see cn.com.sinosoft.product.service.ProductriskService#updateGeProductrisk(cn.com.sinosoft.domain.product.GeProductrisk) 
	 * @param risk
	 */
	public void updateGeProductrisk(GeProductrisk risk);

	/**
	 * 方法名称：findByserialNo <br>
	 * 描述： <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:26:19 
	 * @see cn.com.sinosoft.product.service.ProductriskService#findByserialNo(java.lang.String) 
	 * @param serialNo
	 * @return
	 */
	public GeProductrisk findByserialNo(String serialNo);
	
	/**
	 * 方法名称：deleteByPK <br>
	 * 描述： 根据主键删除<br>
	 * 作者：lihengjun <br>
	 * 修改日期：2014年1月13日下午5:57:21 
	 * @see cn.com.sinosoft.core.hibernate.GenericHibernateDao#deleteByPK(java.io.Serializable) 
	 * @param pk
	 */
	public void deleteByPK(String pk);
}