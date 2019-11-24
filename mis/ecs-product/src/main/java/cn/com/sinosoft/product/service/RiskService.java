package cn.com.sinosoft.product.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeRisk;

/**
 * 描述：险种业务操作类<br>
 * 作者：yuas <br>
 * 修改日期：2014年1月7日下午3:13:45 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 */
public interface RiskService {

	/**
	 * 方法名称: getRiskByPage<br>
	 * 描述：分页查询险种 
	 * 作者: yuas 
	 * 修改日期：2014年1月7日下午3:16:12
	 * 
	 * @param geRisk
	 * @param page
	 * @param rows
	 * @return
	 */
	public Page<GeRisk> getRiskByPage(GeRisk geRisk, int page, int rows);

	/**
	 * 方法名称：addGeRisk <br>
	 * 描述： 添加险种信息<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:41:38 
	 * @see cn.com.sinosoft.product.service.RiskService#addGeRisk(cn.com.sinosoft.domain.product.GeRisk) 
	 * @param geRisk
	 */
	public void addGeRisk(GeRisk geRisk);

	/**
	 * 方法名称：findGeRiskByQueryRule <br>
	 * 描述： 查询险种信息<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:42:05 
	 * @see cn.com.sinosoft.product.service.RiskService#findGeRiskByQueryRule(cn.com.sinosoft.core.hibernate.QueryRule) 
	 * @param queryRule
	 * @return
	 */
	public List<GeRisk> findGeRiskByQueryRule(QueryRule queryRule);

	/**
	 * 方法名称：findGeRiskByRiskCode <br>
	 * 描述： 查询险种信息<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:42:15 
	 * @see cn.com.sinosoft.product.service.RiskService#findGeRiskByRiskCode(java.lang.String) 
	 * @param riskCode
	 * @return
	 */
	public GeRisk findGeRiskByRiskCode(String riskCode);

	/**
	 * 方法名称：updateGeRisk <br>
	 * 描述：修改险种信息 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:21:41 
	 * @see cn.com.sinosoft.product.service.RiskService#updateGeRisk(cn.com.sinosoft.domain.product.GeRisk) 
	 * @param geRisk
	 */
	public void updateGeRisk(GeRisk geRisk);
	
}
