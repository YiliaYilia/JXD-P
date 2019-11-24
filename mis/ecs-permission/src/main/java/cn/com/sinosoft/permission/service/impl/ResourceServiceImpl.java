/**
 * File Name:ResourceServiceImpl.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月17日上午10:52:39
 */
package cn.com.sinosoft.permission.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.system.GeResources;
import cn.com.sinosoft.permission.service.ResourceService;

/**描述：资源业务处理<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月17日上午10:52:39 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
@Component
public class ResourceServiceImpl extends GenericHibernateDao<GeResources, String>
	implements ResourceService{

	/**方法名称：getGeResourcesAll <br>
	 * 描述：获取所有的资源 <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月17日上午10:53:50 
	 * @see cn.com.sinosoft.permission.service.ResourceService#getGeResourcesAll() 
	 * @return 返回所有资源
	 */
	public List<GeResources> getGeResourcesAll() {
		return this.getAll(entityClass,true);
	}

	/**方法名称：getGeResourcesRoot <br>
	 * 描述： 获取所有的根资源 <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月17日下午3:25:58 
	 * @see cn.com.sinosoft.permission.service.ResourceService#getGeResourcesRoot() 
	 * @return
	 */
	public List<GeResources> getGeResourcesRoot() {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("resourcesparent", "0");
		queryRule.addEqual("resourcestype", "M");
		return find(queryRule);
	}

	/**方法名称：addGeResources <br>
	 * 描述：添加资源 <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月19日下午5:36:42 
	 * @see cn.com.sinosoft.permission.service.ResourceService#addGeResources(cn.com.sinosoft.domain.system.GeResources) 
	 * @param geResources
	 */
	@ECSOperator(operator="添加资源")
	public void addGeResources(GeResources geResources) {
		this.save(geResources);
	}

	/**方法名称：updateGeResources <br>
	 * 描述： 修改资源<br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月19日下午8:43:19 
	 * @see cn.com.sinosoft.permission.service.ResourceService#updateGeResources(cn.com.sinosoft.domain.system.GeResources) 
	 * @param geResources
	 */
	@ECSOperator(operator="修改资源")
	public void updateGeResources(GeResources geResources) {
		update(geResources);
	}

	/**方法名称：deleteGeResources <br>
	 * 描述： 删除资源<br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月19日下午8:43:19 
	 * @see cn.com.sinosoft.permission.service.ResourceService#deleteGeResources(java.lang.String) 
	 * @param pk
	 */
	@ECSOperator(operator="删除资源")
	public void deleteGeResources(String pk) {
		deleteByPK(pk);
	}

	/**方法名称：existResources <br>
	 * 描述： 根据资源编码，查看资源是否存在<br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月20日下午2:04:37 
	 * @see cn.com.sinosoft.permission.service.ResourceService#existResources(java.lang.String) 
	 * @param resourceCode
	 */
	public GeResources get(String pk){
		return super.get(pk);
	}
	
	
	public boolean existResources(String resourceCode) {
		return super.exists(resourceCode);
	}

	/**方法名称：getResource <br>
	 * 描述：获取单个资源 <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月24日下午4:57:22 
	 * @see cn.com.sinosoft.core.hibernate.GenericHibernateDao#get(java.io.Serializable) 
	 * @param paramPK
	 * @return
	 */
	public GeResources getResource(String paramPK) {
		return super.get(paramPK);
	}
	
	
	
	
	
	

}
