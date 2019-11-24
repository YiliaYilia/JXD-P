/**
 * File Name:BancassuranceXmlParserImpl.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:wangpengfei
 * @version:v1.0
 * Createdate:2014-3-10上午09:42:07
 */
package cn.com.sinosoft.ess.protal.parser.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import cn.com.sinosoft.ess.protal.parser.BancassuranceXmlParser;

/**描述：银保报文封装、解析基础类<br>
 * 作者：wangpengfei <br>
 * 修改日期：2014-3-10上午09:42:07 <br>
 * E-mail: wangpengfei14079@sinosoft.com.cn <br> 
 */
public class BancassuranceXmlParserImpl implements BancassuranceXmlParser{

	/**方法名称：unmarshal <br>
	 * 描述： <br>
	 * 作者：wangpengfei <br>
	 * 修改日期：2014-3-10上午09:42:23 
	 * @see cn.com.sinosoft.ess.protal.parser.BancassuranceXmlParser#unmarshal(java.lang.String) 
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public Object unmarshal(String xml,Class clazz) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(clazz);  
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object object = unmarshaller.unmarshal(new ByteArrayInputStream(xml.getBytes("UTF-8")));
		return object;
	}

	/**方法名称：marshal <br>
	 * 描述： <br>
	 * 作者：wangpengfei <br>
	 * 修改日期：2014-3-10上午09:42:23 
	 * @see cn.com.sinosoft.ess.protal.parser.BancassuranceXmlParser#marshal(cn.com.sinosoft.ess.protal.model.AcordServiceContext) 
	 * @param acordServiceContext
	 * @return
	 * @throws Exception
	 */
	public String marshal(Object object)
			throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());  
        Marshaller marshaller = jaxbContext.createMarshaller(); 
        // 指定XML 头一行信息不生成
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true); 
        // 设定XML投头的格式
        marshaller.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"GBK\"?>");
        //设置编码
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
        // 用来指定是否使用换行和缩排对已编组XML数据进行格式化的属性名称   
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
        
        OutputStream outputStream = new ByteArrayOutputStream();
        marshaller.marshal(object,outputStream); 
		return outputStream.toString();
	}

}
