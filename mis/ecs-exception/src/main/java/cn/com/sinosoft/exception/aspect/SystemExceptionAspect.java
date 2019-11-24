/**
 * File Name:SystemExceptionAspect.java
 * @Description: 
 * Copyright Sinosoft Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2014年1月19日上午11:31:00
 */
package cn.com.sinosoft.exception.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.exception.BaseException;
import cn.com.sinosoft.core.exception.PersistenceException;

/**描述：系统异常切面<br>
 * 作者：honghui <br>
 * 修改日期：2014年1月19日上午11:31:00 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
@Aspect
@Component
public class SystemExceptionAspect {
	private static final  Logger logger  =  LoggerFactory.getLogger(SystemExceptionAspect.class );
	
	
	@AfterThrowing(pointcut="execution(* cn.com.sinosoft..*ServiceImpl.*(..))",throwing="be")
	public void exceptionCatch(BaseException be){
		
		switch (be.getExceptionGrade()) {
		case GENERAL:{ //一般
			logger.warn("警告",be.getThrowable());
			break;
		}
			
		case SEVERITY:{ //严重
			logger.error("系统异常",be.getThrowable());
			break;
		}
		case DISASTER :{ //灾难
			logger.error("系统异常",be.getThrowable());
			break;
		}
		default:
			break;
		}
	}

}
