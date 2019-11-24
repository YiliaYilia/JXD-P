package cn.com.sinosoft.ess.protal.common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 类说明:   XML文件操作工具类
 * @author 		  E-mail:
 * @version	1.0   Jan 28, 2010 5:13:19 PM
 */
public class PraseXml {
	private static final Logger logger = LoggerFactory.getLogger(PraseXml.class);
	private Document document = null;
	private Element element = null;
	private XMLWriter xmlWriter = null;
	
	
	/**
	 * 构造方法
	 */
	public PraseXml() {
		super();
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("utf-8");
			xmlWriter = new XMLWriter(format);
		} catch (UnsupportedEncodingException e) {
			logger.error("初始化PraseXmlUtil出错", e);
		}
	}

	/**
	 * 通过路径获取xml
	 * @param xmlPath	xml路径
	 */
	public void initXmlByFile(String xmlPath){
		try{
			SAXReader reader = new SAXReader();
			document = reader.read(new File(xmlPath));
			document.setXMLEncoding("GBK");
			element = document.getRootElement();
		}catch(Exception e){
			logger.error("初始化出错：" + xmlPath, e);
		}
	}
	
	/**
	 * 通过字符串初始化xml
	 * @param xmlText
	 */
	public void initXmlByText(String xmlText){
		try{
			document = DocumentHelper.parseText(xmlText);
			document.setXMLEncoding("GBK");
			element = document.getRootElement();
		}catch(Exception e){
			logger.error("初始化出错：" + xmlText, e);
		}
	}
	
	/**
	 * 通过字符串初始化xml
	 * @param xmlText
	 */
	public void initXmlByText(String xmlText,String code){
		try{
			document = DocumentHelper.parseText(xmlText);
			document.setXMLEncoding(code);
			element = document.getRootElement();
		}catch(Exception e){
			logger.error("初始化出错：" + xmlText, e);
		}
	}
	
	/**
	 * 初始化xml输入流
	 * @param in
	 */
	public void initXmlByInputStream(InputStream in){
		try{
			SAXReader reader = new SAXReader();
			this.document = reader.read(in);
			document.setXMLEncoding("GBK");
			element = document.getRootElement();
		}catch(Exception e){
			logger.error("初始化出错：", e);
		}
	}
	/**
	 * 获取XMLDocument对象
	 * @return
	 */
	public Document getDocument(){
		return document;
	}
	
	/**
	 * 获取根节点
	 * @return
	 */
	public Element getElement(){
		return element;
	}
	
	/**
	 * 获取指定节点下的所有子节点
	 * @param element	指定节点
	 * @return			该节点所有子节点的集合
	 */
	public List treeWalkElement(Element element){
		try {
			List elements = new ArrayList();
			Iterator iter = element.elementIterator();
			while (iter.hasNext()){
				Element childElement = (Element)iter.next();
				elements.add(childElement);
			}
			return elements;
		} catch (Exception e) {
			logger.error("获取" + element.getName() + "节点下的所有子节点出错", e);
			return null;
		}
	}
	
	/**
	 * 获取指定节点的所有属性
	 * @param element	指定节点
	 * @return			该节点所有属性的集合
	 */
	public List treeWalkAttribute(Element element){
		try {
			List attributes = new ArrayList();
			Iterator iter = element.attributeIterator();
			while (iter.hasNext()){
				Attribute att = (Attribute)iter.next();
				attributes.add(att);
			}
			return attributes;
		} catch (Exception e) {
			logger.error("获取" + element.getName() + "节点的所有属性出错", e);
			return null;
		}
	}
	
	/**
	 * 获取指定节点的值
	 * @param elementPath	节点名称
	 * @return
	 */
	public String getElementValue(String elementPath){
		try{
			return element.selectSingleNode(elementPath).getText();
		}catch (Exception e) {
			logger.error("获取节点值出错，节点名称：" + elementPath);
			return null;
		}
	}
	
	/**
	 * 向该nodeName下添加多条多个子节点和节点值(值多行)
	 * @param nodeName			节点名称
	 * @param flag				各条记录标志
	 * @param subNodeNames		子节点名称
	 * @param data				子节点值
	 * @return
	 */
	public String addMulData(String nodeName, String flag, String[] subNodeNames, String[][] data){
		try {
			if(subNodeNames.length != data[0].length){
				logger.error("节点名称和节点值个数不匹对");
				return null;
			}
			Element ele = element.element(nodeName);
			Element flagEle = null;
			for(int i = 0; i < data.length; i++){
				flagEle = ele.addElement(flag);
				for(int j = 0; j < subNodeNames.length; j++){
					flagEle.addElement(subNodeNames[j]).setText(data[i][j]);
				}
			}
			xmlWriter.write(document);
			return document.asXML();
		} catch (Exception e) {
			logger.error("向该nodeName下添加多条多个子节点和节点值(值多行)出错，节点名称：" + nodeName, e);
			return null;
		}
	}
	
	/**
	 * 向指定节点下添加多个子节点和值
	 * @param nodeName		指定节点名称
	 * @param subNodeNames	子节点名称
	 * @param data			子节点值
	 * @return				XML文档（字符串）
	 */
	public String addData(String nodeName, String[] subNodeNames, String[] data){
		try{
			if(subNodeNames.length != data.length){
				logger.error("节点名称和节点值个数不匹对");
				return null;
			}
			Element ele = element.element(nodeName);
			for(int i = 0; i < subNodeNames.length; i++){
				ele.addElement(subNodeNames[i]).setText(data[i]);
			}
			xmlWriter.write(document);
			return document.asXML();
		}catch (Exception e) {
			logger.error("向指定节点下添加多个子节点和值出错，节点名称：" + nodeName, e);
			return null;
		}
	}
	
	/**
	 * 向指定节点添加属性和值
	 * @param nodeName			指定节点名称
	 * @param attributeNames	属性名称
	 * @param attributeValues	属性值
	 * @return					XML文档（字符串）
	 */
	public String addAttribute(String nodeName, String[] attributeNames, String[] attributeValues){
		try {
			if(attributeNames.length != attributeValues.length){
				logger.error("属性名称和属性值个数不匹对");
				return null;
			}
			Element ele = element.element(nodeName);
			for(int i = 0; i < attributeNames.length; i++){
				ele.addAttribute(attributeNames[i], attributeValues[i]);
			}
			xmlWriter.write(document);
			return document.asXML();
		} catch (Exception e) {
			logger.error("向指定节点添加属性和值出错，节点名称：" + nodeName, e);
			return null;
		}
	}
	
	/**
	 * 保存XML文件
	 * @param fileName	文件名称
	 * @return			true-成功 false-失败
	 */
	public boolean saveXML(String fileName){
		try{
			xmlWriter.setWriter(new FileWriter(fileName));
			xmlWriter.write(document);
			xmlWriter.flush();
			logger.info("成功保存文件" + fileName);
			return true;
		}catch (Exception e) {
			logger.error("保存XML文件出错：" + fileName, e);
			return false;
		}finally{
			if(xmlWriter != null){
				try {
					xmlWriter.close();
					xmlWriter = null;
				} catch (IOException e) {
					logger.error("关闭" + fileName + "出错", e);
				}
			}
		}
	}
	public static void main(String[] args) {
		PraseXml p = new PraseXml();
		p.initXmlByInputStream(PraseXml.class.getResourceAsStream("accidentRisk.xml"));
		System.out.println(p.getDocument().asXML());
//		Element root = p.getElement();
//		Element e = root.element("Content");
//		e.addElement("IDType").setText("8");
//		e.addElement("IDNo").setText("15464164162");
//		e.addElement("ContNo").setText("10881101110000001098");
		System.out.println("===========");
		System.out.println(p.getDocument().asXML());
		String[] subNodeNames = new String[]{"IDType", "IDNo", "ContNo"};
		String[] data = new String[]{"8","15464164162","10881101110000001098"};
		p.addData("Content", subNodeNames, data);
		System.out.println("1"+p.getDocument().asXML());
//		System.out.println(p.getElementValue("Config"));
//		System.out.println(p.getElementValue("ThreadPool/sleepTime"));
	}
}

