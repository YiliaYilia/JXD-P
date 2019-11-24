/**
 * File Name:BaseException.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月22日下午3:38:15
 */
package cn.com.sinosoft.core.exception;

import cn.com.sinosoft.core.exception.enumerate.ExceptionGrade;

/**描述：异常基类<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月22日下午3:38:15 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class BaseException extends RuntimeException{
	/**默认异常等级为一般性异常*/
	private ExceptionGrade exceptionGrade = ExceptionGrade.GENERAL;
	private Throwable throwable;
	/**异常代码*/
	private String exceptionCode;
	/**异常信息*/
	private String exceptionDesc;
	
	
	
	
	/**
	 * 
	 */
	public BaseException() {
		
	}




	/**
	 * @param exceptionGrade
	 */
	public BaseException(ExceptionGrade exceptionGrade) {
		this.exceptionGrade = exceptionGrade;
		
	}

	


	/**
	 * @param exceptionGrade
	 * @param throwable
	 */
	public BaseException(ExceptionGrade exceptionGrade, Throwable throwable) {
		this.exceptionGrade = exceptionGrade;
		this.throwable = throwable;
		
	}



	

	/**
	 * @param exceptionGrade
	 * @param throwable
	 * @param exceptionCode
	 */
	public BaseException(ExceptionGrade exceptionGrade, Throwable throwable,
			String exceptionCode) {
		this.exceptionGrade = exceptionGrade;
		this.throwable = throwable;
		this.exceptionCode = exceptionCode;
	}




	/**
	 * @param exceptionGrade
	 * @param throwable
	 * @param exceptionCode
	 * @param exceptionDesc
	 */
	public BaseException(ExceptionGrade exceptionGrade, Throwable throwable,
			String exceptionCode, String exceptionDesc) {
		this.exceptionGrade = exceptionGrade;
		this.throwable = throwable;
		this.exceptionCode = exceptionCode;
		this.exceptionDesc = exceptionDesc;
	}




	public ExceptionGrade getExceptionGrade() {
		return exceptionGrade;
	}




	public void setExceptionGrade(ExceptionGrade exceptionGrade) {
		this.exceptionGrade = exceptionGrade;
	}




	public Throwable getThrowable() {
		return throwable;
	}




	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}




	public String getExceptionCode() {
		return exceptionCode;
	}




	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}




	public String getExceptionDesc() {
		return exceptionDesc;
	}




	public void setExceptionDesc(String exceptionDesc) {
		this.exceptionDesc = exceptionDesc;
	}
	
	
	
	
	
	
	
}
