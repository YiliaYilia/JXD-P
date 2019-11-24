//package cn.com.sinosoft.ess.protal.service;
//
//import java.io.UnsupportedEncodingException;
//
//import org.dom4j.Element;
//
//
//import cn.com.sinosoft.ess.protal.common.Data;
//import cn.com.sinosoft.ess.protal.common.PraseXml;
//
///**
// * 保单绑定收发报文解析方法
// * @author sinosoft
// *
// */
//public class PolicyBinding {
//	public String requestXML(String name,String idType,String idNo){
//		PraseXml parseXML  = new PraseXml();
//		try {
//			parseXML.initXmlByFile(Data.getProjectLocalPath()+"/global/xml/SurrenderPolicy.xml");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Element element=parseXML.getElement();
//		Element cCommand = element.element("ClientInfo");
//		cCommand.elementText(name);
//		//....
//		return element.asXML();
//	}
//	public Object responseXML(String result,MobileCustomer m){
//		PraseXml parseXML = new PraseXml();
//		parseXML.initXmlByText(result);
//		Element element=parseXML.getElement();
//		Element eCommand = element.element("InputData");
//		String ContNo = eCommand.elementText("ContNo");
//		m.setId(ContNo);
//		return m;
//	}
//}
