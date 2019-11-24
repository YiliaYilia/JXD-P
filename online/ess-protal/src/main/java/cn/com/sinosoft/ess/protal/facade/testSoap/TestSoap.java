package cn.com.sinosoft.ess.protal.facade.testSoap;

import java.io.File;
import java.net.URLDecoder;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

public class TestSoap {
	
	public static String getSoap(String filename) {
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File(getProjectLocalPath() + "/WEB-INF/classes/testSoap/" + filename));
			return document.asXML();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getProjectLocalPath() {
		try {
			String path = TestSoap.class.getResource("").getFile();
			path = URLDecoder.decode(path, "UTF-8");
			path = path.substring(0,path.lastIndexOf("/WEB-INF"));
			String temp = path.substring(0, 5);
			if("file:".equalsIgnoreCase(temp)) {
				path = path.substring(5);
			}
			return path;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}