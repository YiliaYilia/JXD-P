/**
 * File Name:JsonUtils.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月22日下午5:39:57
 */
package cn.com.sinosoft.core.utils;

import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**描述：json工具类<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月22日下午5:39:57 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class JsonUtils {
	/**
	 * 方法名称: convertObject<br>
	 * 描述：把对象类型转换成json格式
	 * 作者: honghui
	 * 修改日期：2013年12月22日下午5:40:53
	 * @return
	 */
	public static String convertObject(Object object){
		JSONObject json = JSONObject.fromObject(object);
		return json.toString();
	}
	
	/**
	 * 方法名称: convertObject<br>
	 * 描述：把对象类型转换成json格式
	 * 作者: honghui
	 * 修改日期：2013年12月22日下午7:30:29
	 * @param object
	 * @param jsonConfig
	 * @return
	 */
	public static String convertObject(Object object,JsonConfig jsonConfig){
		JSONObject json = JSONObject.fromObject(object,jsonConfig);
		return json.toString();
	}
	
	
	/**
	 * 方法名称: convertArray<br>
	 * 描述：把对象类型转换成数组json
	 * 作者: honghui
	 * 修改日期：2013年12月22日下午6:55:06
	 * @param object
	 * @return
	 */
	public static String convertArray(Object object){
		JSONArray jsonArray =  JSONArray.fromObject(object);
		return jsonArray.toString();
	}
	
	/**
	 * 方法名称: convertArray<br>
	 * 描述：把对象类型转换成数组json
	 * 作者: honghui
	 * 修改日期：2013年12月22日下午7:30:23
	 * @param object
	 * @param jsonConfig
	 * @return
	 */
	public static String convertArray(Object object,JsonConfig jsonConfig){
		JSONArray jsonArray =  JSONArray.fromObject(object,jsonConfig);
		return jsonArray.toString();
	}
	
	/**
	 * 方法名称: convertObject<br>
	 * 描述：JSON字符串转换对象
	 * 作者: honghui
	 * 修改日期：2014年1月8日下午4:29:14
	 * @param val
	 * @param clazz
	 * @return
	 */
	public static <T> T convertObject(String val,Class<T> clazz,Map<String, Class> map){
		
		 T t=(T)JSONObject.toBean(JSONObject.fromObject(val),clazz , map);
	        return t;
	}
}
