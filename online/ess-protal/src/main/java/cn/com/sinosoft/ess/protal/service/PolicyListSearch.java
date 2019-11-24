package cn.com.sinosoft.ess.protal.service;

import java.io.UnsupportedEncodingException;

import org.dom4j.Element;

import cn.com.sinosoft.ess.protal.common.Data;
import cn.com.sinosoft.ess.protal.common.PraseXml;

public class PolicyListSearch {

	//组装xml报文
	public String requestXML(String coustomerId){
		PraseXml parseXML  = new PraseXml();
		try {
			parseXML.initXmlByFile(Data.getProjectLocalPath()+"/global/xml/SurrenderPolicy.xml");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element element=parseXML.getElement();
		Element cCommand = element.element("ClientInfo");
		cCommand.elementText(coustomerId);
		//....
		return element.asXML();
	}
	
	//解析xml报文
	
	public String responseXML(String result){
		PraseXml parseXML = new PraseXml();
		parseXML.initXmlByText(result);
		Element element=parseXML.getElement();
		Element eCommand = element.element("InputData");
		String ContNo = eCommand.elementText("ContNo");
		return null;
	}
}
