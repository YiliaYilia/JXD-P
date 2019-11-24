package cn.com.sinosoft.zhifubao.util;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;


import cn.com.sinosoft.common.PaymentConfigProp;
import cn.com.sinosoft.weixin.client.TenpayHttpClient;
import cn.com.sinosoft.zhifubao.util.MD5;


public class AlipayNotify {

    private static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";

    
    public static boolean verify(Map<String, String> params) {
    	

    	String responseTxt = "true";
		if(params.get("notify_id") != null) {
			String notify_id = params.get("notify_id");
			responseTxt = verifyResponse(notify_id);
		}
	    String sign = "";
	    if(params.get("sign") != null) {sign = params.get("sign");}
	    boolean isSign = getSignVeryfy(params, sign);

        if (isSign && responseTxt.equals("true")) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean verifyReturn(Map<String, String> params) {
	    String sign = "";
	    if(params.get("sign") != null) {sign = params.get("sign");}
	    //??????
	    boolean isSign = getSignVeryfy(params, sign, true);

        if (isSign) {
            return true;
        } else {
            return false;
        }
    }
	private static boolean getSignVeryfy(Map<String, String> Params, String sign) {
    	Map<String, String> sParaNew = AlipayCore.paraFilter(Params);
        String preSignStr = AlipayCore.createLinkString(sParaNew);
        boolean isSign = false;
        if(PaymentConfigProp.getString("zhifubao_sign_type").equals("MD5") ) {
        	isSign = MD5.verify(preSignStr, sign, PaymentConfigProp.getString("zhifubao_key"), "UTF-8");
        }
        return isSign;
    }

    private static String verifyResponse(String notify_id) {

        String partner = PaymentConfigProp.getString("zhifubao_partner");
        String veryfy_url = HTTPS_VERIFY_URL + "partner=" + partner + "&notify_id=" + notify_id;
        System.out.println("签名请求参数地址："+veryfy_url);

        return checkUrl(veryfy_url);
    }

    private static String checkUrl(String urlvalue) {
        String inputLine = "";
      try {
        TenpayHttpClient httpClient = new TenpayHttpClient();
		// 通信对象
		httpClient.setTimeOut(30);
		// 设置请求内容
		httpClient.setReqContent(urlvalue);
		// 后台调用
		httpClient.call();
        inputLine = httpClient.getResContent();
    } catch (Exception e) {
        e.printStackTrace();
        inputLine = "";
    }

      System.out.println("验证签名的结果值："+inputLine);
        return inputLine;
    }
    
    public static boolean verifyNotify(Map<String, String> params) throws Exception {
    	
    	String responseTxt = "true";
    	try {
	    	Document document = DocumentHelper.parseText(params.get("notify_data"));
	    	String notify_id = document.selectSingleNode( "//notify/notify_id" ).getText();
			responseTxt = verifyResponse(notify_id);
    	} catch(Exception e) {
    		responseTxt = e.toString();
    	}
    	
	    String sign = "";
	    if(params.get("sign") != null) {sign = params.get("sign");}
	    boolean isSign = getSignVeryfy(params, sign,false);

        if (isSign && responseTxt.equals("true")) {
            return true;
        } else {
            return false;
        }
    }
    
	private static boolean getSignVeryfy(Map<String, String> Params, String sign, boolean isSort) {
		String signType=PaymentConfigProp.getString("zhifubao_sign_type");
		String key=PaymentConfigProp.getString("zhifubao_key");
    	Map<String, String> sParaNew = AlipayCore.paraFilter(Params);
    	String preSignStr = "";
    	if(isSort) {
    		preSignStr = AlipayCore.createLinkString(sParaNew);
    	} else {
    		preSignStr = AlipayCore.createLinkStringNoSort(sParaNew);
    	}
        boolean isSign = false;
        if(signType.equals("MD5") ) {
        	isSign = MD5.verify(preSignStr, sign, key, "UTF-8");
        }
       /* if(AlipayConfig.sign_type.equals("0001")){
        	isSign = RSA.verify(preSignStr, sign, AlipayConfig.ali_public_key, AlipayConfig.input_charset);
        }*/
        return isSign;
    }
}
