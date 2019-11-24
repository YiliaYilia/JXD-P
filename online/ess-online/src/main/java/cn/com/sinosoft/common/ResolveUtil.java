package cn.com.sinosoft.common;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * 解析配置文件
 * @author sinosoft
 *
 */
public class ResolveUtil {
	 private ResourceBundle resourceBundle; 
	 public ResolveUtil(String propertyFileName) { 
		 ResourceBundle resourceBundle = ResourceBundle.getBundle(propertyFileName); 
	 } 
	 public String getString(String key) { 
	     if (key == null || key.equals("") || key.equals("null")) { 
	         return ""; 
	     } 
	     String result = ""; 
	     try { 
	         result = resourceBundle.getString(key); 
	     } catch (MissingResourceException e) { 
	         e.printStackTrace(); 
	     } 
	     return result; 
	 } 

}
