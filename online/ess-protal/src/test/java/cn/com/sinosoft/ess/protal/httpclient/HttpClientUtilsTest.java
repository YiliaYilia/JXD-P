/**
 * File Name:HttpClientUtilsTest.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:wangpengfei
 * @version:v1.0
 * Createdate:2014-3-6下午12:40:09
 */
package cn.com.sinosoft.ess.protal.httpclient;

import junit.framework.TestCase;


/**描述：HttpClientUtils单元测试类<br>
 * 作者：wangpengfei <br>
 * 修改日期：2014-3-6下午12:40:09 <br>
 * E-mail: wangpengfei14079@sinosoft.com.cn <br> 
 */
public class HttpClientUtilsTest  extends TestCase {
	
	/**
	 * 方法名称: testHttpServlet<br>
	 * 描述：
	 * 作者: wangpengfei
	 * 修改日期：2014-3-6上午09:08:51
	 */
	public void testHttpServlet() {
		Object r = HttpClientUtils.callRemoteServiceURL("wpf");
		System.out.println(r);
	}
}