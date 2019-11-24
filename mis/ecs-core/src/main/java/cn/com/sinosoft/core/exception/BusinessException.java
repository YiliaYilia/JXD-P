/**
 * File Name:BusinessException.java
 * @Description: 
 * Copyright Sinosoft Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2014年1月19日上午11:18:38
 */
package cn.com.sinosoft.core.exception;

import cn.com.sinosoft.core.exception.enumerate.ExceptionGrade;

/**描述：业务异常<br>
 * 作者：honghui <br>
 * 修改日期：2014年1月19日上午11:18:38 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class BusinessException extends BaseException{

	/**
	 * 
	 */
	public BusinessException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param exceptionGrade
	 * @param throwable
	 * @param exceptionCode
	 * @param exceptionDesc
	 */
	public BusinessException(ExceptionGrade exceptionGrade,
			Throwable throwable, String exceptionCode, String exceptionDesc) {
		super(exceptionGrade, throwable, exceptionCode, exceptionDesc);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param exceptionGrade
	 * @param throwable
	 * @param exceptionCode
	 */
	public BusinessException(ExceptionGrade exceptionGrade,
			Throwable throwable, String exceptionCode) {
		super(exceptionGrade, throwable, exceptionCode);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param exceptionGrade
	 * @param throwable
	 */
	public BusinessException(ExceptionGrade exceptionGrade, Throwable throwable) {
		super(exceptionGrade, throwable);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param exceptionGrade
	 */
	public BusinessException(ExceptionGrade exceptionGrade) {
		super(exceptionGrade);
		// TODO Auto-generated constructor stub
	}
	
}
