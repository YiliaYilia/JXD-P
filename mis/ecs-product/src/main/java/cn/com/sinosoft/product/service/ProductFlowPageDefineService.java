/**
 * File Name:GEUserService.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月16日下午11:26:22
 */
package cn.com.sinosoft.product.service;

import java.util.List;

import cn.com.sinosoft.domain.product.GeProductflowpagedefine;

/**
 * 描述：流程页面处理类<br>
 * 作者：Leeyao<br>
 * 修改日期：2014年1月2日下午4:53:02<br>
 * E-mail: liysz0441@sinosoft.com.cn<br>
 */
public interface ProductFlowPageDefineService {
	
	/**
	 * 方法名称：getGeProductflowpagedefines<br>
	 * 描述：获取所有流程页面<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月2日下午4:54:44<br>
	 * @return
	 */
	public List<GeProductflowpagedefine> getGeProductflowpagedefines();
	
	/**
	 * 方法名称：getGeProductflowpagedefineByPK<br>
	 * 描述：根据id获得流程页面<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月6日下午8:00:48<br>
	 * @return
	 */
	public GeProductflowpagedefine getGeProductflowpagedefineByPK(String pk);
}
