/**
 * File Name:ExceptionGrade.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月22日下午3:52:02
 */
package cn.com.sinosoft.core.exception.enumerate;

/**描述：异常等级<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月22日下午3:52:02 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public enum ExceptionGrade {
	/**一般异常*/
	GENERAL("3"), 
	/**严重异常*/
	SEVERITY("2"),
	/**灾难性异常*/
	DISASTER("1");
	
	
	/**异常等级*/
	private String exceptionLevel;
	
	private ExceptionGrade(String exceptionLevel){
		this.exceptionLevel = exceptionLevel;
	}
	/**
	 * 方法名称: getExceptionLevel<br>
	 * 描述：获取异常等级
	 * 作者: honghui
	 * 修改日期：2013年12月22日下午3:58:29
	 */
	public String getExceptionLevel(){
		return this.exceptionLevel;
	}
	
	
	

}
