/**
 * File Name:BancassuranceXmlParser.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:wangpengfei
 * @version:v1.0
 * Createdate:2014-3-10上午10:01:18
 */
package cn.com.sinosoft.ess.protal.parser;


/**描述：<br>
 * 作者：wangpengfei <br>
 * 修改日期：2014-3-10上午10:01:18 <br>
 * E-mail: wangpengfei14079@sinosoft.com.cn <br> 
 */
public interface BancassuranceXmlParser {

	/**
	 * 方法名称: unmarshal<br>
	 * 描述：
	 * 作者: wangpengfei
	 * 修改日期：2014-3-10下午08:33:52
	 * @param xml
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public Object unmarshal(String xml,Class clazz) throws Exception;
	
	/**
	 * 方法名称: marshal<br>
	 * 描述：
	 * 作者: wangpengfei
	 * 修改日期：2014-3-10下午08:35:12
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public String marshal(Object object) throws Exception;
}
