package cn.com.sinosoft.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeProductflowdefine;
import cn.com.sinosoft.product.service.ProductFlowDefineService;

/**
 * 描述：流程定义业务处理类<br>
 * 作者：honghui <br>
 * 修改日期：2014年1月2日下午1:26:37 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 */
@Component
public class ProductFlowDefineServiceImpl extends GenericHibernateDao<GeProductflowdefine, String> implements ProductFlowDefineService {
	
	/**
	 * 方法名称：getGeProductflowdefineByName<br>
	 * 描述：根据流程名称分页查询流程数据<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月2日下午12:13:43<br>
	 * @see cn.com.sinosoft.product.service.ProductFlowDefineService#getGeProductflowdefineByName(java.lang.String, int, int)
	 * @param productflowname
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<GeProductflowdefine> getGeProductflowdefineByName(
			String productflowname, int pageNumber, int pageSize) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addLike("productflowname", "%"+productflowname+"%");
		queryRule.addDescOrder("updatetime");
		return this.find(entityClass,queryRule, pageNumber, pageSize);
	}

	/**方法名称：getGeProductflowdefines <br>
	 * 描述：获取所有的流程定义 <br>
	 * 作者：honghui <br>
	 * 修改日期：2014年1月2日下午1:25:19 
	 * @see cn.com.sinosoft.product.service.ProductFlowDefineService#getGeProductflowdefines() 
	 * @return
	 */
	public List<GeProductflowdefine> getGeProductflowdefines() {
		return this.getAll(entityClass, false);
	}

	/**方法名称：getGeProductflowdefine <br>
	 * 描述：通过主键获取流程定义实体 <br>
	 * 作者：honghui <br>
	 * 修改日期：2014年1月3日上午10:59:18 
	 * @see cn.com.sinosoft.product.service.ProductFlowDefineService#getGeProductflowdefine(java.lang.String) 
	 * @param pk
	 * @return
	 */
	public GeProductflowdefine getGeProductflowdefine(String pk) {
		return this.get(pk);
	}
	
	/**
	 * 方法名称：addGeProductflowdefine<br>
	 * 描述：保存流程<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月6日下午8:32:59<br>
	 * @see cn.com.sinosoft.product.service.ProductFlowDefineService#addGeProductflowdefine(cn.com.sinosoft.domain.product.GeProductflowdefine)
	 * @param geProductflowdefine
	 */
	@ECSOperator(operator="添加流程")
	public void addGeProductflowdefine(GeProductflowdefine geProductflowdefine) {
		this.save(geProductflowdefine);
	}
}
