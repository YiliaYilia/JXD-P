/**
 * File Name:AcordTransactionContext.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:wangpengfei
 * @version:v1.0
 * Createdate:2014-3-7上午10:31:04
 */
package cn.com.sinosoft.ess.protal.facade;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.ess.protal.config.MappingObject;
import cn.com.sinosoft.ess.protal.config.ServiceObjectMappingDefinition;
import cn.com.sinosoft.ess.protal.facade.impl.PortalServiceFacadeImpl;

/**描述：用于存放保单相关对象的上下文容器<br>
 * 作者：wangpengfei <br>
 * 修改日期：2014-3-7上午10:31:04 <br>
 * E-mail: wangpengfei14079@sinosoft.com.cn <br> 
 */
public class AcordServiceContext extends HashMap<String,Object>{

	private static final Logger logger = LoggerFactory.getLogger(PortalServiceFacadeImpl.class);
	
	private static final long serialVersionUID = 5463598345209882312L;
	
	private String funcFlag;
	private Object requestObject;
	private Object resultObject;
	private Class responseObjectClass;
	
	/**
	 * 
	 * @param funcFlag
	 * @param requestObject
	 */
	public AcordServiceContext(String funcFlag, Object requestObject) {
		this.funcFlag = funcFlag;
		MappingObject mappingObject = ServiceObjectMappingDefinition.serviceObjectMapping.get(funcFlag);
		if(mappingObject.getNeedConvertorRequestEntityToObject()){
			//对象转换
			this.requestObject = requestObjectConvertor(requestObject);
		}else{
			this.requestObject = requestObject;
		}
		
	}
	
	/**
	 * 方法名称: requestObjectConvertor<br>
	 * 描述：
	 * 作者: wangpengfei
	 * 修改日期：2014-3-11下午07:40:23
	 * @param requestObject 请求对象
	 * @return 转换后的报文对象
	 */
	private Object requestObjectConvertor(Object requestObject){
		MappingObject mappingObject = ServiceObjectMappingDefinition.serviceObjectMapping.get(funcFlag);
		Object dest = null;
		try {
			dest = mappingObject.getRequestObjectClass().newInstance();
		} catch (InstantiationException e) {
			logger.error("实例化对象时，出现异常:",e);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			logger.error("实例化对象时，出现异常:",e);
			e.printStackTrace();
		}
		try {
			BeanUtils.copyProperties(dest, requestObject);
		} catch (IllegalAccessException e) {
			logger.error("拷贝对象属性时，出现异常:",e);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			logger.error("拷贝对象属性时，出现异常:",e);
			e.printStackTrace();
		}
		return dest;
	}
	
	/**
	 * 方法名称: resultObjectConvertor<br>
	 * 描述：
	 * 作者: wangpengfei
	 * 修改日期：2014-3-11下午07:41:42
	 * @param resultObject 响应报文对象
	 * @return 响应对象
	 */
	private Object resultObjectConvertor(Object resultObject){
		MappingObject mappingObject = ServiceObjectMappingDefinition.serviceObjectMapping.get(funcFlag);
		Object dest = null;
		try {
			dest = mappingObject.getResultEntityClass().newInstance();
		} catch (InstantiationException e) {
			logger.error("实例化对象时，出现异常:",e);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			logger.error("实例化对象时，出现异常:",e);
			e.printStackTrace();
		}
		try {
			BeanUtils.copyProperties(dest, resultObject);
		} catch (IllegalAccessException e) {
			logger.error("拷贝对象属性时，出现异常:",e);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			logger.error("拷贝对象属性时，出现异常:",e);
			e.printStackTrace();
		}
		return dest;
	}
	
	public String getFuncFlag() {
		return funcFlag;
	}
	public void setFuncFlag(String funcFlag) {
		this.funcFlag = funcFlag;
	}
	public Object getRequestObject() {
		return requestObject;
	}
	public void setRequestObject(Object requestObject) {
		this.requestObject = requestObject;
	}
	public Object getResultObject() {
		//检查是否需要转换
		MappingObject mappingObject = ServiceObjectMappingDefinition.serviceObjectMapping.get(funcFlag);
		if(mappingObject.getNeedConvertorResultObjectToEntities()){
			//对象转换
			resultObject = resultObjectConvertor(resultObject);
		}
		return resultObject;
	}
	public void setResultObject(Object resultObject) {
		this.resultObject = resultObject;
	}
	public Class getResponseObjectClass() {
		MappingObject mappingObject = ServiceObjectMappingDefinition.serviceObjectMapping.get(funcFlag);
		responseObjectClass = mappingObject.getResultObjectClass();
		return responseObjectClass;
	}
	public void setResponseObjectClass(Class responseObjectClass) {
		this.responseObjectClass = responseObjectClass;
	}
	
	
}
