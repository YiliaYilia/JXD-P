/**
 * File Name:Rule.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月16日下午2:51:18
 */
package cn.com.sinosoft.core.hibernate;

import java.io.Serializable;

/**描述：hibernate 查询规则 实体类<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月16日下午2:51:18 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class Rule implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**查询类型，请查考QueryRule常量 */
	private String queryType;
	/**需要查询实体属性名称*/
	private String propertyName;
	/**查询参数*/
	private Object[] values;
	
	
	
	public Rule(String queryType, String propertyName) {
		this.queryType = queryType;
		this.propertyName = propertyName;
	}
	
	public Rule(String queryType, String propertyName, Object[] values) {
		this.queryType = queryType;
		this.propertyName = propertyName;
		this.values = values;
	}
	public String getQueryType() {
		return queryType;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public Object[] getValues() {
		return values;
	}
	
	

}
