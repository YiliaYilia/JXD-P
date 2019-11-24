/**
 * File Name:ProductFlowPageElementDefineServiceImpl.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2014年1月5日下午3:46:47
 */
package cn.com.sinosoft.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.domain.product.GeProductflowpageelementdefine;
import cn.com.sinosoft.product.service.ProductFlowPageElementDefineService;

/**描述：<br>
 * 作者：honghui <br>
 * 修改日期：2014年1月5日下午3:46:47 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
@Component
public class ProductFlowPageElementDefineServiceImpl extends GenericHibernateDao<GeProductflowpageelementdefine, String> implements ProductFlowPageElementDefineService {

	/**方法名称：getGeProductflowpageelementdefine <br>
	 * 描述：获取产品流程定义节点 <br>
	 * 作者：honghui <br>
	 * 修改日期：2014年1月5日下午3:47:54 
	 * @see cn.com.sinosoft.product.service.ProductFlowPageElementDefineService#getGeProductflowpageelementdefine(java.lang.String) 
	 * @param pk
	 * @return
	 */
	public GeProductflowpageelementdefine getGeProductflowpageelementdefine(
			String pk) {
		return this.get(pk);
	}

	/**
	 * 方法名称：getAllProductflowpageelementdefines<br>
	 * 描述：获得所有页面节点<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月6日下午6:03:01<br>
	 * @see cn.com.sinosoft.product.service.ProductFlowPageElementDefineService#getAllProductflowpageelementdefines()
	 * @return
	 */
	public List<GeProductflowpageelementdefine> getAllProductflowpageelementdefines() {
		return this.getAll(entityClass, true);
	}
}
