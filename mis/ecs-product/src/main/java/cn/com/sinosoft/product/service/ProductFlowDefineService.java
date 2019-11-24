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
import java.util.Map;
import java.util.Set;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.product.GeProductflowdefine;

/**描述：后台用户业务处理类<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月16日下午11:26:22 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public interface ProductFlowDefineService {
	
	/**
	 * 方法名称：getGeProductflowdefineByName<br>
	 * 描述：根据流程名称分页查询流程数据<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月2日下午12:10:44<br>
	 * @param productflowname 流程名称
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<GeProductflowdefine> getGeProductflowdefineByName(String productflowname,int pageNumber,int pageSize);
	
	/**
	 * 方法名称: getGeProductflowdefines<br>
	 * 描述：获取所有的流程定义
	 * 作者: honghui
	 * 修改日期：2014年1月2日下午1:25:01
	 * @return
	 */
	public List<GeProductflowdefine> getGeProductflowdefines();
	
	/**
	 * 方法名称: getGeProductflowdefine<br>
	 * 描述：通过主键获取流程定义实体
	 * 作者: honghui
	 * 修改日期：2014年1月3日上午10:58:52
	 * @param pk
	 * @return
	 */
	public GeProductflowdefine getGeProductflowdefine(String pk);
	
	/**
	 * 方法名称：addGeProductflowdefine<br>
	 * 描述：保存流程<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月6日下午8:31:49<br>
	 * @param geProductflowdefine
	 */
	public void addGeProductflowdefine(GeProductflowdefine geProductflowdefine);
}
