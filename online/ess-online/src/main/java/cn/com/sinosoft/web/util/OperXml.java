package cn.com.sinosoft.web.util;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class OperXml {
	public static Node selectSingleNode(String express, Object source) {//���ҽڵ㣬�����ص�һ����������ڵ�
        Node result=null;
        XPathFactory xpathFactory=XPathFactory.newInstance();
        XPath xpath=xpathFactory.newXPath();
        try {
            result=(Node) xpath.evaluate(express, source, XPathConstants.NODE);
        } catch (XPathExpressionException e){
            e.printStackTrace();
        }
        
        return result;
    }
    
    public static NodeList selectNodes(String express, Object source){//���ҽڵ㣬���ط�������Ľڵ㼯��
        NodeList result=null;
        XPathFactory xpathFactory=XPathFactory.newInstance();
        XPath xpath=xpathFactory.newXPath();
        try {
            result=(NodeList) xpath.evaluate(express, source, XPathConstants.NODESET);
        } catch (XPathExpressionException e){
            e.printStackTrace();
        }
        
        return result;
    }
    public static void output(Node node){//��node��XML�ַ����������̨
        TransformerFactory transFactory=TransformerFactory.newInstance();
        try {
            Transformer transformer = transFactory.newTransformer();
            transformer.setOutputProperty("encoding", "gb2312");
            transformer.setOutputProperty("indent", "yes");

            DOMSource source=new DOMSource();
            source.setNode(node);
            StreamResult result=new StreamResult();
            result.setOutputStream(System.out);
            
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e){
            e.printStackTrace();
        }   
    }

    public static void saveXml(String fileName, Document doc) {//��Document������ļ�
        TransformerFactory transFactory=TransformerFactory.newInstance();
        try {
            Transformer transformer = transFactory.newTransformer();
            transformer.setOutputProperty("indent", "yes");

            DOMSource source=new DOMSource();
            source.setNode(doc);
            StreamResult result=new StreamResult();
            FileOutputStream temp1= new FileOutputStream(fileName);
            result.setOutputStream(temp1);
            
            transformer.transform(source, result);
            try {
				temp1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } catch (TransformerConfigurationException e){
            e.printStackTrace();
        } catch (TransformerException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }   
    }
    /**
	 * @param args

	/*<?xml version="1.0" encoding="UTF-8"?>
	<books>
	 <book id="B01">
	  <name>哈里波特</name>
	  <price>10</price>
	  <memo>这是一本很好看的书。</memo>
	 </book>
	 <book id="B02">
	  <name>三国演义</name>
	  <price>10</price>
	  <memo>四大名著之一。</memo>
	 </book>
	 <book id="B03">
	  <name>水浒</name>
	  <price>6</price>
	  <memo>四大名著之一。</memo>
	 </book>
	 <book id="B04">
	  <name>红楼</name>
	  <price>5</price>
	  <memo>四大名著之一。</memo>
	 </book>
	</books>  */



}
