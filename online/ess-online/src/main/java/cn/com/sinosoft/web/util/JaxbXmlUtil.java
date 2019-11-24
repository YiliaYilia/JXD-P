package cn.com.sinosoft.web.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;

public class JaxbXmlUtil {
	public static final String DEFAULT_ENCODING = "UTF-8";

	/**
	 * pojo转换成xml 默认编码UTF-8
	 * 
	 * @param obj
	 *            待转化的对象
	 * @return xml格式字符串
	 * @throws Exception
	 *             JAXBException
	 */
	public static String convertToXml(Object obj) throws Exception {
		return convertToXml(obj, DEFAULT_ENCODING);
	}

	/**
	 * pojo转换成xml
	 * 
	 * @param obj
	 *            待转化的对象
	 * @param encoding
	 *            编码
	 * @return xml格式字符串
	 * @throws Exception
	 *             JAXBException
	 */
	public static String convertToXml(Object obj, String encoding)
			throws Exception {
		String result = null;

		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller marshaller = context.createMarshaller();
		// 指定是否使用换行和缩排对已编组 XML 数据进行格式化的属性名称。
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

		StringWriter writer = new StringWriter();
		marshaller.marshal(obj, writer);
		result = writer.toString();

		return result;
	}

	/**
	 * xml转换成JavaBean
	 * 
	 * @param xml
	 *            xml格式字符串
	 * @param t
	 *            待转化的对象
	 * @return 转化后的对象
	 * @throws Exception
	 *             JAXBException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T convertToJavaBean(String xml, Class<T> t)
			throws Exception {
		T obj = null;
		JAXBContext context = JAXBContext.newInstance(t);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		obj = (T) unmarshaller.unmarshal(new StringReader(xml));
		return obj;
	}
	
	 public static <T> T xmlToBean(String xml, String elementName, Class<T> cls)  
	    {  
	        T object = null;  
	        try  
	        {  
	            Document document = DocumentHelper.parseText(xml);  
	            //如果不是SOAP返回的报文，是XML字符串则不需要这行代码  
	            String beanXml = document.getRootElement().element("Body").element(  
	                    elementName).asXML();  
	  
	            OMElement omElement = new StAXOMBuilder(new ByteArrayInputStream(  
	                    beanXml.getBytes("UTF-8"))).getDocumentElement();  
	              
	            System.out.println("gyx"+omElement);
	        }  
	        catch (Exception e)  
	        {  
	            e.printStackTrace();  
	        }  
	        return object;  
	    }  
	/**
	 * 向指定位置发送报文   默认编码UTF-8
	 * @param xmlStr
	 * @param url
	 * @return
	 */
	public static Map sendXml(String xmlStr, String url){
		return sendXml(xmlStr,url,DEFAULT_ENCODING);
	}

	/**
	 * 向指定位置发送报文
	 * @param xmlStr
	 * @param url
	 * @param encoding 指定编码
	 * @return
	 */
	public static Map sendXml(String xmlStr, String url,String encoding) {
		RequestEntity entity = null;
		String xml = null;
		try {
			entity = new StringRequestEntity(xmlStr, "text/xml", encoding);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		PostMethod post = new PostMethod(url);// 请求地址
		post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,encoding);
		post.setRequestEntity(entity);// 这里添加xml字符串
		// 指定请求内容的类型
		post.setRequestHeader("Content-type", "text/xml; charset="+encoding);
		HttpClient httpclient = new HttpClient();// 创建 HttpClient 的实例
		Map retMap = new HashMap();
		try {
			int result = httpclient.executeMethod(post);
			xml = post.getResponseBodyAsString();
			post.releaseConnection();// 释放连接
			retMap.put("code", result);
			retMap.put("message", xml);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retMap;
	}
}
