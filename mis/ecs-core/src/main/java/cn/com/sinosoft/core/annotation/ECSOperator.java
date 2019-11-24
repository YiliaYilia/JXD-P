/**
 * File Name:ECSOperator.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月27日下午12:06:18
 */
package cn.com.sinosoft.core.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**描述：操作注解<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月27日下午12:06:18 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ECSOperator {
	
	public String operator();
}
