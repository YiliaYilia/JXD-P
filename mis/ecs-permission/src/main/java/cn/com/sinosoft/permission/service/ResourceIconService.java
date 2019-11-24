/**
 * File Name:ResourceIconService.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月18日下午6:01:26
 */
package cn.com.sinosoft.permission.service;

import java.util.List;

import cn.com.sinosoft.domain.system.GeResourcesIcon;

/**描述:资源图标业务处理类<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月18日下午6:01:26 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public interface ResourceIconService {
	/**
	 * 方法名称: geResourcesIconsAll<br>
	 * 描述：获取所有资源图标
	 * 作者: honghui
	 * 修改日期：2013年12月18日下午6:02:16
	 * @return
	 */
	public List<GeResourcesIcon> geResourcesIconsAll();
}
