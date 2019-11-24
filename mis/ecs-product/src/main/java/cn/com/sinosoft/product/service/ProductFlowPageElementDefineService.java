/**
 * File Name:ProductFlowPageElementDefineService.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2014年1月5日下午3:45:44
 */
package cn.com.sinosoft.product.service;

import java.util.List;

import cn.com.sinosoft.domain.product.GeProductflowpageelementdefine;

/**描述：产品流程节点定义服务类<br>
 * 作者：honghui <br>
 * 修改日期：2014年1月5日下午3:45:44 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public interface ProductFlowPageElementDefineService {
	
	public GeProductflowpageelementdefine getGeProductflowpageelementdefine(String pk);

	/**
	 * 方法名称：getAllProductflowpageelementdefines<br>
	 * 描述：获得所有页面节点<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月6日下午6:02:22<br>
	 * @return
	 */
	public List<GeProductflowpageelementdefine> getAllProductflowpageelementdefines();
}
