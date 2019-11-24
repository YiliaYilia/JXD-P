/**
 * File Name:ReflectUtil.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月16日下午6:22:51
 */
package cn.com.sinosoft.core.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**描述：反射工具类<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月16日下午6:22:51 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class ReflectUtil {
	/**
	 * 方法名称: getSuperClassGenricType<br>
	 * 描述：获取泛型类型
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午6:24:25
	 * @param clazz
	 * @return
	 */
	public static Class getSuperClassGenricType(Class clazz){
		return getSuperClassGenricType(clazz, 0);
	}

	/**
	 * 方法名称: getSuperClassGenricType<br>
	 * 描述：获取泛型类型
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午6:24:40
	 * @param clazz
	 * @param index
	 * @return
	 */
	public static Class getSuperClassGenricType(Class clazz, int index){
	    Type genType = clazz.getGenericSuperclass();
	    if (!(genType instanceof ParameterizedType)) {
	      return Object.class;
	    }
	    Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
	    if ((index >= params.length) || (index < 0)) {

	      return Object.class;
	    }
	    if (!(params[index] instanceof Class)) {
	      return Object.class;
	    }
	    return ((Class)params[index]);
	 }
	
	/**
	 * 方法名称: getAnnotation<br>
	 * 描述：获取注解
	 * 作者: honghui
	 * 修改日期：2013年12月27日下午3:06:09
	 * @param obj
	 * @param annotationClass
	 * @return
	 */
	public static Annotation getAnnotation(Object obj ,Class annotationClass){
		return obj.getClass().getAnnotation(annotationClass);
	}
	
	/**
	 * 方法名称: getAnnotation<br>
	 * 描述：获取注解类型
	 * 作者: honghui
	 * 修改日期：2013年12月27日下午3:35:35
	 * @param method
	 * @param annotationClass
	 * @return
	 */
	public static Annotation getAnnotation(Method method ,Class annotationClass){
		return method.getAnnotation(annotationClass);
	}
	
	/**
	 * 方法名称: getMethodByName<br>
	 * 描述：通过名称获取方法
	 * 作者: honghui
	 * 修改日期：2013年12月27日下午3:34:07
	 * @param obj
	 * @param name
	 * @param types
	 * @return 返回方法，如果异常，返回空
	 */
	public static Method getMethodByName(Object obj,String name ,Class... types){
		try {
			return  obj.getClass().getMethod(name,types);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

}
