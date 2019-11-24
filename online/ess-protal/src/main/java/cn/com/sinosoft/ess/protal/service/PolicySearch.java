package cn.com.sinosoft.ess.protal.service;

import java.io.UnsupportedEncodingException;

import org.dom4j.Element;

import cn.com.sinosoft.ess.protal.common.Data;
import cn.com.sinosoft.ess.protal.common.PraseXml;

public class PolicySearch {

	public String requestXML(String policyNo){
		PraseXml parseXML  = new PraseXml();
		try {
			parseXML.initXmlByFile(Data.getProjectLocalPath()+"/global/xml/SurrenderPolicy.xml");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element element=parseXML.getElement();
		Element cCommand = element.element("ClientInfo");
		cCommand.elementText(policyNo);
		//....
		System.out.println(element.asXML());
		return element.asXML();
		
	}
	
	public String responseXML(String result){
		PraseXml parseXML = new PraseXml();
		parseXML.initXmlByText(result);
		Element element=parseXML.getElement();
		Element eCommand = element.element("InputData");
		String ContNo = eCommand.elementText("ContNo");
		return null;
	}
}
