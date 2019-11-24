/**
 * File Name:Axis2ClientUtilsTest.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:wangpengfei
 * @version:v1.0
 * Createdate:2014-3-6下午12:38:30
 */
package cn.com.sinosoft.ess.protal.webservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import cn.com.sinosoft.ess.protal.common.PraseXml;

import junit.framework.TestCase;



/**描述：Axis2ClientUtils单元测试类<br>
 * 作者：wangpengfei <br>
 * 修改日期：2014-3-6下午12:38:30 <br>
 * E-mail: wangpengfei14079@sinosoft.com.cn <br> 
 */
public class Axis2ClientUtilsTest extends TestCase {
		
	/**
	 * 方法名称: testCallBancassuranceRemoteService<br>
	 * 描述：
	 * 作者: wangpengfei
	 * 修改日期：2014-3-6上午09:08:48
	 */
	public void testCallBancassuranceRemoteService1() {
		String requestXML=null;
		//银保通核保交易请求报文
		// InputStream ins =new FileInputStream(new File("main/resources/xml/银保通核保交易请求报文.xml"));
		//当日对账请求报文
		// InputStream ins =new FileInputStream(new File("main/resources/xml/当日对账请求报文.xml"));
		//当日撤单请求报文
		try{
			//银保通核保交易请求报文
			InputStream ins =ClassLoader.getSystemResourceAsStream("银保通核保交易请求报文.xml");
			//当日对账请求报文
			// InputStream ins =ClassLoader.getSystemResourceAsStream("当日对账请求报文.xml");
			//当日撤单请求报文
			// InputStream ins =ClassLoader.getSystemResourceAsStream("当日撤单请求报文.xml");
			
			PraseXml p =new PraseXml();
			p.initXmlByInputStream(ins);
			requestXML= p.getDocument().asXML();
		}catch (Exception e) {
			e.printStackTrace();
		}
		//"hebao",
		Object r = Axis2ClientUtils.callBancassuranceRemoteService("service",requestXML);       
		System.out.println(r);
	}
	
	public void testCallBancassuranceRemoteService2() {
		String requestXML=null;
		//银保通核保交易请求报文
		// InputStream ins =new FileInputStream(new File("main/resources/xml/银保通核保交易请求报文.xml"));
		//当日对账请求报文
		// InputStream ins =new FileInputStream(new File("main/resources/xml/当日对账请求报文.xml"));
		//当日撤单请求报文
		try{
			InputStream ins =ClassLoader.getSystemResourceAsStream("银保通核保交易请求报文.xml");
			 int a =ins.available();
			 byte[] bs= new byte[a];
			 ins.read(bs);
			 StringBuffer buff= new StringBuffer(new String(bs));
			 requestXML= buff.toString();
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		String r = (String)Axis2ClientUtils.callBancassuranceRemoteService("service",new Object[]{requestXML},new Class[]{String.class});       
		System.out.println(r);
	}
}
