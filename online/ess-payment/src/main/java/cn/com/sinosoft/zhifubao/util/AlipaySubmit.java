package cn.com.sinosoft.zhifubao.util;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.NameValuePair;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


import cn.com.sinosoft.common.PaymentConfigProp;
import cn.com.sinosoft.zhifubao.httpClient.HttpProtocolHandler;
import cn.com.sinosoft.zhifubao.httpClient.HttpRequest;
import cn.com.sinosoft.zhifubao.httpClient.HttpResponse;
import cn.com.sinosoft.zhifubao.httpClient.HttpResultType;
import cn.com.sinosoft.zhifubao.util.MD5;

public class AlipaySubmit {

    private static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";

	public static String buildRequestMysign(Map<String, String> sPara) {
    	String prestr = AlipayCore.createLinkString(sPara);
        String mysign = "";
        String signType=PaymentConfigProp.getString("zhifubao_sign_type");
        if(signType.equals("MD5") ) {
        	mysign = MD5.sign(prestr, PaymentConfigProp.getString("zhifubao_key"), "UTF-8");
        }
/*        if(signType.equals("0001") ){
        	mysign = RSA.sign(prestr, PaymentConfigProp.getString("zhifubao_private_key"), "UTF-8");
        }*/
        return mysign;
    }
	
	
	

	

    private static Map<String, String> buildRequestPara(Map<String, String> sParaTemp) {

        Map<String, String> sPara = AlipayCore.paraFilter(sParaTemp);

        String mysign = buildRequestMysign(sPara);

        sPara.put("sign", mysign);
        if(! sPara.get("service").equals("alipay.wap.trade.create.direct") && ! sPara.get("service").equals("alipay.wap.auth.authAndExecute")) {
        	sPara.put("sign_type", PaymentConfigProp.getString("zhifubao_sign_type"));
        }
        

        return sPara;
    }
    


    public static String buildRequest(Map<String, String> sParaTemp, String strMethod, String strButtonName) {
        Map<String, String> sPara = buildRequestPara(sParaTemp); 
        List<String> keys = new ArrayList<String>(sPara.keySet());

        StringBuffer sbHtml = new StringBuffer();

        sbHtml.append("<meta http-equiv='content-type' content='text/html; charset=utf-8'><form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + ALIPAY_GATEWAY_NEW
                      + "_input_charset=" + "UTF-8" + "\" method=\"" + strMethod
                      + "\">");

        for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            String value = (String) sPara.get(name);
            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }


        sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");
        sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");
        System.out.println("支付宝发起请求的结果："+sbHtml.toString());
        return sbHtml.toString();
    }
    

    public static String buildRequest(Map<String, String> sParaTemp, String strMethod, String strButtonName, String strParaFileName) {

        Map<String, String> sPara = buildRequestPara(sParaTemp);
        List<String> keys = new ArrayList<String>(sPara.keySet());

        StringBuffer sbHtml = new StringBuffer();

        sbHtml.append("<meta http-equiv='content-type' content='text/html; charset=utf-8'><form id=\"alipaysubmit\" name=\"alipaysubmit\"  enctype=\"multipart/form-data\" action=\"" + ALIPAY_GATEWAY_NEW
                      + "_input_charset=" + "UTF-8" + "\" method=\"" + strMethod
                      + "\">");

        for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            String value = (String) sPara.get(name);

            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }
        
        sbHtml.append("<input type=\"file\" name=\"" + strParaFileName + "\" />");


        sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");

        return sbHtml.toString();
    }
    

    public static String buildRequest(String strParaFileName, String strFilePath,Map<String, String> sParaTemp) throws Exception {
 
        Map<String, String> sPara = buildRequestPara(sParaTemp);

        HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler.getInstance();

        HttpRequest request = new HttpRequest(HttpResultType.BYTES);
      
        request.setCharset("UTF-8");

        request.setParameters(generatNameValuePair(sPara));
        request.setUrl(ALIPAY_GATEWAY_NEW+"_input_charset="+"UTF-8");

        HttpResponse response = httpProtocolHandler.execute(request,strParaFileName,strFilePath);
        if (response == null) {
            return null;
        }
        
        String strResult = response.getStringResult();

        return strResult;
    }


    private static NameValuePair[] generatNameValuePair(Map<String, String> properties) {
        NameValuePair[] nameValuePair = new NameValuePair[properties.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            nameValuePair[i++] = new NameValuePair(entry.getKey(), entry.getValue());
        }

        return nameValuePair;
    }
    

	public static String query_timestamp(String payType) throws MalformedURLException,
                                                        DocumentException, IOException {

		String strUrl ="";
		String partner=PaymentConfigProp.getString("zhifubao_partner");
		if("20".equals(payType) || "22".equals(payType)){ 
			 strUrl = ALIPAY_GATEWAY_NEW + "service=query_timestamp&partner=" + partner+ "&_input_charset" +"UTF-8";
		}else if("21".equals(payType)){
			strUrl = ALIPAY_GATEWAY_NEW + "service=query_timestamp&partner=" +partner;
		}
        StringBuffer result = new StringBuffer();

        SAXReader reader = new SAXReader();
        Document doc = reader.read(new URL(strUrl).openStream());

        List<Node> nodeList = doc.selectNodes("//alipay/*");

        for (Node node : nodeList) {
            if (node.getName().equals("is_success") && node.getText().equals("T")) {
            
                List<Node> nodeList1 = doc.selectNodes("//response/timestamp/*");
                for (Node node1 : nodeList1) {
                    result.append(node1.getText());
                }
            }
        }

        return result.toString();
    }
	

    public static String buildRequest(String ALIPAY_GATEWAY_NEW, Map<String, String> sParaTemp, String strMethod, String strButtonName) {
    	
        Map<String, String> sPara = buildRequestPara(sParaTemp);
        List<String> keys = new ArrayList<String>(sPara.keySet());

        StringBuffer sbHtml = new StringBuffer();

        sbHtml.append("<meta http-equiv='content-type' content='text/html; charset=utf-8'><form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + ALIPAY_GATEWAY_NEW
                      + "_input_charset=" +"UTF-8" + "\" method=\"" + strMethod
                      + "\">");

        for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            String value = (String) sPara.get(name);

            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }

        sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");
        sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");
        System.out.println("支付宝支付结果："+sbHtml.toString());
        return sbHtml.toString();
    }
	
	/*//根据以上优化
    public static Map<String, String> buildRequest(Map<String, String> sParaTemp) {
    	
        Map<String, String> sPara = buildRequestPara(sParaTemp);
        List<String> keys = new ArrayList<String>(sPara.keySet());

        StringBuffer sbHtml = new StringBuffer();

        sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + ALIPAY_GATEWAY_NEW
                      + "_input_charset=" +"UTF-8" + "\" method=\"" + strMethod
                      + "\">");

        for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            String value = (String) sPara.get(name);

            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }

        sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");
        sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");
        System.out.println("支付宝支付结果："+sbHtml.toString());
        return sbHtml.toString();
        return sPara;
    }*/

    public static String buildRequest(String ALIPAY_GATEWAY_NEW, Map<String, String> sParaTemp, String strMethod, String strButtonName, String strParaFileName) {
        Map<String, String> sPara = buildRequestPara(sParaTemp);
        List<String> keys = new ArrayList<String>(sPara.keySet());

        StringBuffer sbHtml = new StringBuffer();

        sbHtml.append("<meta http-equiv='content-type' content='text/html; charset=utf-8'><form id=\"alipaysubmit\" name=\"alipaysubmit\"  enctype=\"multipart/form-data\" action=\"" + ALIPAY_GATEWAY_NEW
                      + "_input_charset=" + "UTF-8" + "\" method=\"" + strMethod
                      + "\">");

        for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            String value = (String) sPara.get(name);

            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }
        
        sbHtml.append("<input type=\"file\" name=\"" + strParaFileName + "\" />");


        sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");

        return sbHtml.toString();
    }
    

    public static String buildRequest(String ALIPAY_GATEWAY_NEW, String strParaFileName, String strFilePath,Map<String, String> sParaTemp) throws Exception {
    
        Map<String, String> sPara = buildRequestPara(sParaTemp);

        HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler.getInstance();

        HttpRequest request = new HttpRequest(HttpResultType.BYTES);
     
        request.setCharset("UTF-8");

        request.setParameters(generatNameValuePair(sPara));
        request.setUrl(ALIPAY_GATEWAY_NEW+"_input_charset="+"UTF-8");

        HttpResponse response = httpProtocolHandler.execute(request,strParaFileName,strFilePath);
        if (response == null) {
            return null;
        }
        
        String strResult = response.getStringResult();

        return strResult;
    }

    
    

    public static String getRequestToken(String text) throws Exception {
    	String request_token = "";

    	String[] strSplitText = text.split("&");

    	Map<String, String> paraText = new HashMap<String, String>();
        for (int i = 0; i < strSplitText.length; i++) {

        	int nPos = strSplitText[i].indexOf("=");
        	
    		int nLen = strSplitText[i].length();
    		
    		String strKey = strSplitText[i].substring(0, nPos);
    		
    		String strValue = strSplitText[i].substring(nPos+1,nLen);
    		
    		paraText.put(strKey, strValue);
        }

    	if (paraText.get("res_data") != null) {
    		String res_data = paraText.get("res_data");
    		/*if(AlipayConfig.sign_type.equals("0001")) {
    			res_data = RSA.decrypt(res_data, AlipayConfig.private_key, AlipayConfig.input_charset);
    		}*/
    		Document document = DocumentHelper.parseText(res_data);
    		request_token = document.selectSingleNode( "//direct_trade_create_res/request_token" ).getText();
    	}
    	System.out.println("支付宝手机支付授权令牌："+request_token);
    	return request_token;
    }
    
   
	
	
}
