/**
 * File Name:ResourceService.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月17日上午10:51:11
 */
package cn.com.sinosoft.web.service.facade;

import cn.com.sinosoft.domain.user.GeResources;


/**
 * 资源业务处理
 * @author Yunxia.Guo
 *
 */
public interface ResourceService { 
	
	
	/**
	 * 根据资源编码查看资源是否存在
	 * @param pk
	 * @return
	 */
	public GeResources get(String pk);
}
