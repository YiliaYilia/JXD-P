/**
 * File Name:ResourceService.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月17日上午10:51:11
 */
package cn.com.sinosoft.permission.service;

import java.util.List;

import cn.com.sinosoft.domain.system.GeResources;

/**描述：资源业务处理<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月17日上午10:51:11 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public interface ResourceService {
	/**
	 * 方法名称: getGeResourcesAll<br>
	 * 描述：获取所有的资源
	 * 作者: honghui
	 * 修改日期：2013年12月17日上午10:51:47
	 * @return 返回所有的资源
	 */
	public List<GeResources> getGeResourcesAll();
	
	/**
	 * 方法名称: getGeResourcesRoot<br>
	 * 描述：获取所有的根资源
	 * 作者: honghui
	 * 修改日期：2013年12月17日下午3:25:05
	 * @return
	 */
	public List<GeResources> getGeResourcesRoot();
	

	/**
	 * 方法名称: addGeResources<br>
	 * 描述：添加资源
	 * 作者: honghui
	 * 修改日期：2013年12月19日下午5:36:02
	 * @param geResources
	 */
	public void addGeResources(GeResources geResources);
	
	/**
	 * 方法名称: updateGeResources<br>
	 * 描述：修改资源
	 * 作者: honghui
	 * 修改日期：2013年12月19日下午8:42:27
	 * @param geResources
	 */
	public void updateGeResources(GeResources geResources);
	
	/**
	 * 方法名称: deleteGeResources<br>
	 * 描述：删除资源
	 * 作者: honghui
	 * 修改日期：2013年12月19日下午8:43:03
	 * @param pk
	 */
	public void deleteGeResources(String pk);
	
	/**
	 * 方法名称: existResources<br>
	 * 描述：根据资源编码查看资源是否存在
	 * 作者: honghui
	 * 修改日期：2013年12月20日下午2:04:05
	 * @param resourceCode
	 */
	public GeResources get(String pk);
	
	public boolean existResources(String resourceCode);
	
	/**
	 * 方法名称: getResource<br>
	 * 描述：获取单个资源
	 * 作者: honghui
	 * 修改日期：2013年12月24日下午4:56:20
	 * @param pk
	 * @return
	 */
	public GeResources getResource(String pk);
}
