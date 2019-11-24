/**
 * File Name:StringUtils.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月16日下午2:38:38
 */
package cn.com.sinosoft.core.utils;

/**描述：字符串工具类<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月16日下午2:38:38 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class StringUtils {
	/**
	 * 方法名称: isEmpty<br>
	 * 描述：判断是否为空字符串，如果为NULL也返回true
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:09:02
	 * @param value
	 * @return 是否为空字符串，如果为NULL也返回true
	 */
	public static boolean isEmpty(String value){
		if(value == null) {
			return true;
		}
		else{
			if("".equals(value)){
				return true;
			}
		}
		return false;
	}

	  public static boolean isBlank(String str) {
	        int strLen;
	        if (str == null || (strLen = str.length()) == 0) {
	            return true;
	        }
	        for (int i = 0; i < strLen; i++) {
	            if ((Character.isWhitespace(str.charAt(i)) == false)) {
	                return false;
	            }
	        }
	        return true;
	    }

}
