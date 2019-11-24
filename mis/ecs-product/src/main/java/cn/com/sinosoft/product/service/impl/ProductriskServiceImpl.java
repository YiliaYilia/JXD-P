package cn.com.sinosoft.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeProductrisk;
import cn.com.sinosoft.product.service.DutyService;
import cn.com.sinosoft.product.service.ProductService;
import cn.com.sinosoft.product.service.ProductdutyService;
import cn.com.sinosoft.product.service.ProductriskService;
import cn.com.sinosoft.product.service.RiskService;

/**
 * 描述：产品险种操作类<br>
 * 作者：yuas <br>
 * 修改日期：2014年1月14日上午9:22:10 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 */
@Component
public class ProductriskServiceImpl extends GenericHibernateDao<GeProductrisk, String> implements ProductriskService {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductdutyService ProductdutyService;
	
	@Autowired
	private RiskService RiskService;
	
	@Autowired
	private DutyService DutyService;
	
	/**根据主键查找
	 * 方法名称：get <br>
	 * 描述： 根据主键查找 <br>
	 * 作者：partrick <br>
	 * 修改日期：2014年1月11日下午4:30:05 
	 * @see cn.com.sinosoft.core.hibernate.GenericHibernateDao#get(java.io.Serializable) 
	 * @param pk
	 * @return
	 */
	public GeProductrisk get(String pk){
		return super.get(pk);
	}

	/**
	 * 方法名称：findGeProductriskByCoreProductCode <br>
	 * 描述：根据产品查找产品险种信息 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:22:58 
	 * @see cn.com.sinosoft.product.service.ProductriskService#findGeProductriskByCoreProductCode(java.lang.String) 
	 * @param coreProductCode
	 * @return
	 */
	public List<GeProductrisk> findGeProductriskByCoreProductCode(String coreProductCode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("geProductMain.coreproductcode", coreProductCode);
		queryRule.addDescOrder("seqindex");
		List<GeProductrisk>  productRiskList = super.find(GeProductrisk.class, queryRule);
		return productRiskList;
	}

	/**
	 * 方法名称：findByRiskCode <br>
	 * 描述： 根据产品险种代码查询产品险种信息<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:23:40 
	 * @see cn.com.sinosoft.product.service.ProductriskService#findByRiskCode(java.lang.String) 
	 * @param code
	 * @return
	 */
	public GeProductrisk findByRiskCode(String code) {
		QueryRule q = QueryRule.getInstance();
		q.addEqual("productriskcode", code);
		return super.findUnique(q);
	}
	/**
	 * 方法名称：deleteByPK <br>
	 * 描述： 根据主键删除<br>
	 * 作者：lihengjun <br>
	 * 修改日期：2014年1月13日下午5:57:21 
	 * @see cn.com.sinosoft.core.hibernate.GenericHibernateDao#deleteByPK(java.io.Serializable) 
	 * @param pk
	 */
	@ECSOperator(operator = "根据主键删除产品险种信息")
	public void deleteByPK(String pk){
		super.deleteByPK(pk);
	}
	
	/**
	 * 方法名称：addGeProductrisk <br>
	 * 描述： 添加产品险种<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:24:21 
	 * @see cn.com.sinosoft.product.service.ProductriskService#addGeProductrisk(cn.com.sinosoft.domain.product.GeProductrisk) 
	 * @param risk
	 */
	@ECSOperator(operator = "添加产品险种")
	public void addGeProductrisk(GeProductrisk risk) {
		super.save(risk);
	}

	/**
	 * 方法名称：deleteGeProductrisk <br>
	 * 描述：删除产品险种 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:24:42 
	 * @see cn.com.sinosoft.product.service.ProductriskService#deleteGeProductrisk(java.lang.String) 
	 * @param code
	 */
	@ECSOperator(operator = "删除产品险种")
	public void deleteGeProductrisk(String code) {
		GeProductrisk entity = findByRiskCode(code);
		super.delete(entity);
	}

	/**
	 * 方法名称：findByQueryRule <br>
	 * 描述： 查询产品险种<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:25:03 
	 * @see cn.com.sinosoft.product.service.ProductriskService#findByQueryRule(cn.com.sinosoft.core.hibernate.QueryRule) 
	 * @param qu
	 * @return
	 */
	public List<GeProductrisk> findByQueryRule(QueryRule qu) {
		return super.find(qu);
	}

	/**
	 * 方法名称：deleteGeProductrisk <br>
	 * 描述： 删除产品险种<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:25:21 
	 * @see cn.com.sinosoft.product.service.ProductriskService#deleteGeProductrisk(cn.com.sinosoft.domain.product.GeProductrisk) 
	 * @param risk
	 */
	@ECSOperator(operator = "删除产品险种")
	public void deleteGeProductrisk(GeProductrisk risk) {
		super.delete(risk);
	}

	/**
	 * 方法名称：deleteByProductId <br>
	 * 描述：根据产品id，删除产品险种 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:25:40 
	 * @see cn.com.sinosoft.product.service.ProductriskService#deleteByProductId(java.lang.String) 
	 * @param productId
	 */
	@ECSOperator(operator = "删除产品险种")
	public void deleteByProductId(String productId) {
		QueryRule q = QueryRule.getInstance();
		q.addEqual("geProductMain.coreproductcode", productId);
		List<GeProductrisk> list = find(q);
		
		for (GeProductrisk GeProductrisk : list) {
			delete(GeProductrisk);
		}
	}

	/**
	 * 方法名称：updateGeProductrisk <br>
	 * 描述： 修改产品险种<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:26:01 
	 * @see cn.com.sinosoft.product.service.ProductriskService#updateGeProductrisk(cn.com.sinosoft.domain.product.GeProductrisk) 
	 * @param risk
	 */
	@ECSOperator(operator = "修改产品险种")
	public void updateGeProductrisk(GeProductrisk risk) {
		super.update(risk);
	}

	/**
	 * 方法名称：findByserialNo <br>
	 * 描述： <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:26:19 
	 * @see cn.com.sinosoft.product.service.ProductriskService#findByserialNo(java.lang.String) 
	 * @param serialNo
	 * @return
	 */
	public GeProductrisk findByserialNo(String serialNo) {
		QueryRule q = QueryRule.getInstance();
		q.addEqual("productriskno", serialNo);
		List<GeProductrisk> list = findByQueryRule(q);
		if(list.size()>0)
			return list.get(0);
		else
			return null;
	}

}
