/**
 * File Name:BeanUtils.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月19日上午10:07:36
 */
package cn.com.sinosoft.core.utils;

import org.springframework.beans.BeanUtils;


/**描述：实体bean工具类<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月19日上午10:07:36 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class ECSBeanUtils {
	
	/**
	 * 方法名称: copyProperties<br>
	 * 描述：拷贝对象
	 * 作者: honghui
	 * 修改日期：2014年1月10日下午4:53:34
	 * @param source 源对象
	 * @param target 目标对象
	 */
	public static void copyProperties(Object source,Object target){
		copyProperties(source,target,null);
	}
	
	/**
	 * 方法名称: copyProperties<br>
	 * 描述：
	 * 作者: honghui
	 * 修改日期：2014年1月10日下午4:54:17
	 * @param source 源对象
	 * @param target 目标对象
	 * @param ignoreProperties 数组类型 忽略的字段
	 */
	public static void copyProperties(Object source,Object target,String...  ignoreProperties){
		if(ignoreProperties != null){
			BeanUtils.copyProperties(source, target, ignoreProperties);
		}
		else{
			BeanUtils.copyProperties(source, target);
		}
		
	}
	
}
