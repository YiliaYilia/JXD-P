/**
 * File Name:MappingObject.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:wangpengfei
 * @version:v1.0
 * Createdate:2014-3-11下午08:21:41
 */
package cn.com.sinosoft.ess.protal.config;

/**描述：<br>
 * 作者：wangpengfei <br>
 * 修改日期：2014-3-11下午08:21:41 <br>
 * E-mail: wangpengfei14079@sinosoft.com.cn <br> 
 */
public class MappingObject {
	
	private Class requestObjectClass; 
	private Class resultObjectClass;
	private Class resultEntityClass;
	private Boolean needConvertorResultObjectToEntities;
	private Boolean needConvertorRequestEntityToObject;
	
	/**
	 * 构造报文对象映射
	 * @param requestObjectClass 请求报文对象Class
	 * @param resultObjectClass 响应报文对象Class
	 * @param resultEntityClass 响应实体对象Class
	 * @param needConvertorResultObjectToEntities 是否需要将返回报文对象转换为实体对象
	 * @param needConvertorRequestEntityToObject  是否需要将请求报文实体转换为报文对象
	 */
	public MappingObject(Class requestObjectClass, Class resultObjectClass,Class resultEntityClass,Boolean needConvertorRequestEntityToObject,Boolean needConvertorResultObjectToEntities) {
		this.requestObjectClass = requestObjectClass;
		this.resultObjectClass = resultObjectClass;
		this.resultEntityClass = resultEntityClass;
		this.needConvertorRequestEntityToObject = needConvertorRequestEntityToObject;
		this.needConvertorResultObjectToEntities = needConvertorResultObjectToEntities;
	}
	public Class getRequestObjectClass() {
		return requestObjectClass;
	}
	public void setRequestObjectClass(Class requestObjectClass) {
		this.requestObjectClass = requestObjectClass;
	}
	public Class getResultObjectClass() {
		return resultObjectClass;
	}
	public void setResultObjectClass(Class resultObjectClass) {
		this.resultObjectClass = resultObjectClass;
	}
	public Class getResultEntityClass() {
		return resultEntityClass;
	}
	public void setResultEntityClass(Class resultEntityClass) {
		this.resultEntityClass = resultEntityClass;
	}
	public Boolean getNeedConvertorResultObjectToEntities() {
		return needConvertorResultObjectToEntities;
	}
	public void setNeedConvertorResultObjectToEntities(
			Boolean needConvertorResultObjectToEntities) {
		this.needConvertorResultObjectToEntities = needConvertorResultObjectToEntities;
	}
	public Boolean getNeedConvertorRequestEntityToObject() {
		return needConvertorRequestEntityToObject;
	}
	public void setNeedConvertorRequestEntityToObject(
			Boolean needConvertorRequestEntityToObject) {
		this.needConvertorRequestEntityToObject = needConvertorRequestEntityToObject;
	}
	

}
