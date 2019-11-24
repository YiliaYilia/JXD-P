/**
 * File Name:PersistenceException.java
 * @Description: 
 * Copyright Sinosoft Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2014年1月19日上午10:35:15
 */
package cn.com.sinosoft.core.exception;

import cn.com.sinosoft.core.exception.enumerate.ExceptionGrade;

/**描述：持久化异常，默认异常为严重<br>
 * 作者：honghui <br>
 * 修改日期：2014年1月19日上午10:35:15 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class PersistenceException extends BaseException {
	
	/**
	 * 
	 */
	public PersistenceException() {
		super();
	}

	/**
	 * @param exceptionGrade
	 * @param throwable
	 * @param exceptionCode
	 * @param exceptionDesc
	 */
	public PersistenceException(ExceptionGrade exceptionGrade,
			Throwable throwable, String exceptionCode, String exceptionDesc) {
		super(exceptionGrade, throwable, exceptionCode, exceptionDesc);
	}

	/**
	 * @param exceptionGrade
	 * @param throwable
	 * @param exceptionCode
	 */
	public PersistenceException(ExceptionGrade exceptionGrade,
			Throwable throwable, String exceptionCode) {
		super(exceptionGrade, throwable, exceptionCode);
	}

	/**
	 * @param exceptionGrade
	 * @param throwable
	 */
	public PersistenceException(ExceptionGrade exceptionGrade,
			Throwable throwable) {
		super(exceptionGrade, throwable);
	}

	/**
	 * @param exceptionGrade
	 */
	public PersistenceException(ExceptionGrade exceptionGrade) {
		super(exceptionGrade);
	}
	
	
	
	
}
