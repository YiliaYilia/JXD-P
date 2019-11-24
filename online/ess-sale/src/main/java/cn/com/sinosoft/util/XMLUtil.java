package cn.com.sinosoft.util;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.Collection;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import cn.com.sinosoft.domain.soap.NodeNumber;


public class XMLUtil {

	/**
	 * 方法名称：creatXML<br>
	 * 描述：根据实体bean 生成xml并返回xml的字符串形式<br>
	 * 修改作者：leeyao<br>
	 * 修改日期：2013年8月22日20:06:33<br>
	 * @param obj 实体bean
	 * @return 生成的xml的字符串形式
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public  static String creatXML(Object obj) throws  IllegalArgumentException, IllegalAccessException{
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Document document = DocumentHelper.createDocument();
		Element RootElement = createRootElement(clazz.getSimpleName(),document);
		for(Field field:fields){
			createChildElement(RootElement, field, obj);
		}
//		return document.asXML();
		return formatXML(document, "GBK");
	}
	
    /** 
     * 格式化XML文档 
     * 
     * @param document xml文档 
     * @param charset    字符串的编码 
     * @return 格式化后XML字符串 
     */ 
    public static String formatXML(Document document, String charset) { 
            OutputFormat format = OutputFormat.createCompactFormat(); 
            format.setEncoding(charset); 
            StringWriter sw = new StringWriter(); 
            XMLWriter xw = new XMLWriter(sw, format); 
            try { 
                    xw.write(document); 
                    xw.flush(); 
                    xw.close(); 
            } catch (IOException e) { 
            	e.printStackTrace();
            } 
            return sw.toString(); 
    }
    
	/**
	 * 方法名称: createChildElement<br>
	 * 描述：变量实体bean 生成 xml
	 * 作者: wanhonghui
	 * 修改日期：2013年8月15日下午5:46:06
	 * @param element
	 * @param field
	 * @param obj
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void createChildElement(Element element ,Field field,Object obj) throws IllegalArgumentException, IllegalAccessException{
		field.setAccessible(true);
		if(isComplexType(field)){
			if(isArray(field) || isCollection(field)){
				NodeNumber number = field.getAnnotation(NodeNumber.class);
				Element childElement = null;
				if(isArray(field)){
					Object[] objs = (Object[])field.get(obj);
					String name = field.getName();
					name=name.substring(0, 1).toUpperCase()+name.substring(1);
					childElement = element.addElement(name);
					if(number != null && number.isShowNumber()){
						Element numberElement = childElement.addElement(number.nodeName());
						numberElement.setText(String.valueOf(objs.length));
					}
					if(objs.length>0){
						for(Object ob:objs){
							Element childElementObject = childElement.addElement(ob.getClass().getSimpleName());
							Field[] fields = ob.getClass().getDeclaredFields();
							for(Field f:fields){
								createChildElement(childElementObject,f,ob);
							}
						}
					}
					
				}
				if(isCollection(field)){
					field.setAccessible(true);
					Collection collection = (Collection)field.get(obj);
					String name = field.getName();
					name=name.substring(0, 1).toUpperCase()+name.substring(1);
					childElement = element.addElement(name);
					if(number != null && number.isShowNumber()){
						Element numberElement = childElement.addElement(number.nodeName());
						numberElement.setText(String.valueOf(collection.size()));
					}
					
					if(collection.size()>0){
						for(Object ob:collection){
							Element childElementObject = childElement.addElement(ob.getClass().getSimpleName());
							Field[] fields = ob.getClass().getDeclaredFields();
							for(Field f:fields){
								createChildElement(childElementObject,f,ob);
							}
						}
					}
				}
			}
			else{ //一般的复合类型
				field.setAccessible(true);
				Object o = field.get(obj);
				String name = field.getName();
				
				name=name.substring(0, 1).toUpperCase()+name.substring(1);
				Element childElement = element.addElement(name);
				if(o != null){
					Field[] fields = o.getClass().getDeclaredFields();
					for(Field f:fields){
						createChildElement(childElement,f,o);	
					}
				}
				
			}
			
		}
		else{
			String name = field.getName();
			name=name.substring(0, 1).toUpperCase()+name.substring(1);
			Element childElement = element.addElement(name);
			if(field.get(obj) == null){
				childElement.setText("");
			}
			else{
				childElement.setText(String.valueOf(field.get(obj)));
			}
		}
	}
	
	
	
	/**
	 * 方法名称: createRootElement<br>
	 * 描述：创建一个根节点
	 * 作者: wanhonghui
	 * 修改日期：2013年8月15日下午2:39:34
	 * @param nodeName
	 * @param document
	 * @return
	 */
	public static Element createRootElement(String nodeName,Document document){
		//添加根元素
        Element messageElement = document.addElement(nodeName);
        return messageElement;
	}
	
	
	
	/**
	 * 方法名称: isComplexType<br>
	 * 描述：判断是否为复合类型
	 * 作者: wanhonghui
	 * 修改日期：2013年8月15日下午2:25:52
	 * @param field
	 * @return false：基本类型 true：复合类型
	 */
	public static boolean isComplexType(Field field){
		Class clazz = field.getType();
		if(byte.class.isAssignableFrom(clazz) || Byte.class.isAssignableFrom(clazz)
				||char.class.isAssignableFrom(clazz)||Character.class.isAssignableFrom(clazz)
				||short.class.isAssignableFrom(clazz)||Short.class.isAssignableFrom(clazz)
				||int.class.isAssignableFrom(clazz) || Integer.class.isAssignableFrom(clazz)
				||long.class.isAssignableFrom(clazz)||Long.class.isAssignableFrom(clazz)
				||float.class.isAssignableFrom(clazz)||Float.class.isAssignableFrom(clazz)
				||double.class.isAssignableFrom(clazz)||Double.class.isAssignableFrom(clazz)
				||boolean.class.isAssignableFrom(clazz)||Boolean.class.isAssignableFrom(clazz)
				||String.class.isAssignableFrom(clazz)){
			return false;
		}
		return true;
	}
	
	/**
	 * 方法名称: isArray<br>
	 * 描述：字段是否是一个数组
	 * 作者: wanhonghui
	 * 修改日期：2013年8月15日下午2:54:15
	 * @param field
	 * @return
	 */
	public static boolean isArray(Field field){
		if(field.getType().isArray()){
			return true;
		}
		return false;
	}
	/**
	 * 方法名称: isCollection<br>
	 * 描述：是否是一个集合类型
	 * 作者: wanhonghui
	 * 修改日期：2013年8月15日下午2:55:38
	 * @param field
	 * @return
	 */
	public static boolean isCollection(Field field){
		if(Collection.class.isAssignableFrom(field.getType())){
			return true;
		}
		return false;
	}
	
}
