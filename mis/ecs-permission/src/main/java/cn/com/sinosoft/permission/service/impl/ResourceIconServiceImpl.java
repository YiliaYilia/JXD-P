/**
 * File Name:ResourceIconServiceImpl.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月18日下午6:03:06
 */
package cn.com.sinosoft.permission.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.domain.system.GeResourcesIcon;
import cn.com.sinosoft.permission.service.ResourceIconService;

/**描述：<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月18日下午6:03:06 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
@Component
public class ResourceIconServiceImpl extends GenericHibernateDao<GeResourcesIcon, String> 
	implements ResourceIconService{

	/**方法名称：geResourcesIconsAll <br>
	 * 描述：获取所有的资源图标 <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月18日下午6:03:46 
	 * @see cn.com.sinosoft.permission.service.ResourceIconService#geResourcesIconsAll() 
	 * @return
	 */
	public List<GeResourcesIcon> geResourcesIconsAll() {
		return getAll(entityClass,true);
	}

}
