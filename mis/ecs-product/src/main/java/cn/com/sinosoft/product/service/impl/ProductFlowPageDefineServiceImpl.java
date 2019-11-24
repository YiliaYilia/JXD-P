package cn.com.sinosoft.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.domain.product.GeProductflowpagedefine;
import cn.com.sinosoft.product.service.ProductFlowPageDefineService;

/**
 * 描述：流程页面处理实现类<br>
 * 作者：Leeyao<br>
 * 修改日期：2014年1月2日下午4:57:28<br>
 * E-mail: liysz0441@sinosoft.com.cn<br>
 */
@Component
public class ProductFlowPageDefineServiceImpl extends GenericHibernateDao<GeProductflowpagedefine, String> implements ProductFlowPageDefineService {

	/**
	 * 方法名称：getGeProductflowpagedefines<br>
	 * 描述：获取所有流程页面<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月2日下午4:57:09<br>
	 * @see cn.com.sinosoft.product.service.ProductFlowPageDefineService#getGeProductflowpagedefines()
	 * @return
	 */
	public List<GeProductflowpagedefine> getGeProductflowpagedefines() {
		return this.getAll(entityClass, false);
	}
	
	/**
	 * 方法名称：getGeProductflowpagedefineByPK<br>
	 * 描述：根据id获得流程页面<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月15日下午6:24:40<br>
	 * @see cn.com.sinosoft.product.service.ProductFlowPageDefineService#getGeProductflowpagedefineByPK(java.lang.String)
	 * @param pk
	 * @return
	 */
	public GeProductflowpagedefine getGeProductflowpagedefineByPK(String pk) {
		return this.get(pk);
	}
}
