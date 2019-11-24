package cn.com.sinosoft.weixin.util;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.jdom.JDOMException;

import cn.com.sinosoft.weixin.client.TenpayHttpClient;
import cn.com.sinosoft.core.utils.PropertyFileUtils;



public class PaymentUtil {
	
	private static final DecimalFormat amtFormat = new DecimalFormat("#.00");

	private static String getConfig(String key,String fileName){
		PropertyFileUtils.init(PaymentUtil.class.getClassLoader().getResource("payconfig/" + fileName));
		return PropertyFileUtils.getConfig(key);
	}

	public static String unicodeToGB(String s) {
		if(s==null||s.equals(null)){
			return "";
		}else{
			StringBuffer sb = new StringBuffer();
			StringTokenizer st = new StringTokenizer(s, "\\u");
			while (st.hasMoreTokens()) {
				sb.append((char) Integer.parseInt(st.nextToken(), 16));
			}
			return sb.toString();
		}

	}


	public static String toUnicodeString(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				sb.append("\\u" + Integer.toHexString(c));
			}
		}
		return sb.toString();
	}

	public static String readUrl(String key){
		String returnStr="";
		try {
			InputStream is = PaymentUtil.class.getClassLoader()
					.getResourceAsStream("Config.properties");
			Properties p = new Properties();
			p.load(is);

			returnStr = p.getProperty(key);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnStr;
	}
	

	public static Map<String,String> analyRespose(String a){
		Map<String,String> m = new HashMap<String, String>();
		
		String aa[] = a.split("&");
		
		for (int i = 0; i < aa.length; i++) {
			m.put(aa[i].substring(0, aa[i].indexOf("=")), aa[i].substring(aa[i].indexOf("=")+1));
		}
		
		return m;
	}
	

	public static String transport(String url, String message) {
		StringBuffer sb = new StringBuffer();
		try {
			URL urls = new URL(url);
			HttpURLConnection uc = (HttpURLConnection) urls.openConnection();
			uc.setRequestMethod("POST");
			uc.setRequestProperty("content-type",
					"application/x-www-form-urlencoded");
			uc.setRequestProperty("charset", "UTF-8");
			uc.setDoOutput(true);
			uc.setDoInput(true);
			uc.setReadTimeout(30000);
			uc.setConnectTimeout(30000);
			OutputStream os = uc.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.write(message.getBytes("utf-8"));
			dos.flush();
			os.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					uc.getInputStream(), "utf-8"));
			String readLine = "";
			while ((readLine = in.readLine()) != null) {
				sb.append(readLine);
			}
			in.close();
		} catch (Exception e) {
			e.getMessage();
		}
		return sb.toString();
	}

	public static String gettransport(String url, String message) {
		StringBuffer sb = new StringBuffer();
		try {
			URL urls = new URL(url);
			HttpURLConnection uc = (HttpURLConnection) urls.openConnection();
			uc.setRequestMethod("POST");
			uc.setRequestProperty("content-type",
					"application/x-www-form-urlencoded");
			uc.setRequestProperty("charset", "UTF-8");
			uc.setDoOutput(true);
			uc.setDoInput(true);
			uc.setReadTimeout(30000);
			uc.setConnectTimeout(30000);
			OutputStream os = uc.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.write(message.getBytes("UTF-8"));
			dos.flush();
			os.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					uc.getInputStream()));
			String readLine = "";
			while ((readLine = in.readLine()) != null) {
				sb.append(readLine);
			}
			in.close();
		} catch (Exception e) {
			e.getMessage();
		}
		return sb.toString();
	}
	
/*	
	public static String checkKeyd(String plainData,String MerId){
		
		chinapay.PrivateKey key=new chinapay.PrivateKey();
		chinapay.SecureLink t;
		boolean flag;
		
		String ChkValue2;
		flag=key.buildKey(MerId,0,getUrl(getConfig("MerPrk.key","config.properties")).toString().replace("file:", ""));
		//flag=key.buildKey(MerId,0,"C:\\Users\\michael\\Workspaces\\MyEclipse 10\\fosun\\src\\MerPrk_uat.key");
		if (flag==false)
		{
		System.out.println("build key error!!1111");
		return null;
		}
		t=new chinapay.SecureLink (key);
		
		String plainDataBase64 = new String(Base64.encode(plainData.toString().getBytes()));
		ChkValue2 = t.Sign(plainDataBase64) ; //
		return ChkValue2;
		
	}
	*/
	private static URL getUrl(String fileName){
		return PaymentUtil.class.getClassLoader().getResource("payconfig/" + fileName);
	}
	
/*
	public static boolean checkkey(String ChkValue2,String plainData){
		
		chinapay.PrivateKey key=new chinapay.PrivateKey();
		chinapay.SecureLink t;
		boolean flag;
		boolean flag1;
		flag=key.buildKey("999999999999999",0,getUrl(getConfig("PgPubk.key","config.properties")).toString().replace("file:", ""));
		//PayAction.class.getClassLoader().getResource(ReadConfig.get("RcvCertFile")).getPath()
		//flag=key.buildKey("999999999999999",0,"C:\\Users\\michael\\Workspaces\\MyEclipse 10\\fosun\\src\\PgPubk.key");
		if (flag==false)
		{
		String msg="build key error!";
		System.out.println(msg);
		return false;
		}
		t=new chinapay.SecureLink (key);
		flag1 = t. verifyAuthToken (plainData, ChkValue2) ; 
		
		return flag1;
	}*/
	

	public static String formatPayNum(String amt){
		amt = amtFormat.format(Double.valueOf(amt)).replace(".", "");
		return amt;
	}
	
	public static String createSign(SortedMap parameters,String key) {
		StringBuffer sb = new StringBuffer();
		Set es = parameters.entrySet();
		Iterator it = es.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			String k = (String)entry.getKey();
			String v = (String)entry.getValue();
			if(null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + key);
		String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
		System.out.println("加密后sign的值："+sign);
		return sign;
		
		
	}
	
 /*
    private static Map<String, String> buildRequestPara(Map<String, String> sParaTemp,String sign) {

        Map<String, String> sPara = AlipayCore.paraFilter(sParaTemp);

        String mysign = buildRequestMysign(sPara,sign);

        sPara.put("sign", mysign);
        if(!sPara.get("service").equals("alipay.wap.trade.create.direct") && ! sPara.get("service").equals("alipay.wap.auth.authAndExecute")) {
            sPara.put("sign_type", "MD5");
        }


        return sPara;
    }
/*
	public static String buildRequestMysign(Map<String, String> sPara,String sign) {
    	String prestr = AlipayCore.createLinkString(sPara); 
        String mysign = "";
        if("MD5".equals("MD5") ) {
        	mysign = MD5.sign(prestr, sign, "UTF-8");
        }
        return mysign;
    }
	
/*
    public static String buildRequest(Map<String, String> sParaTemp, String strMethod, String Url,String sign) {
        Map<String, String> sPara = buildRequestPara(sParaTemp,sign);
        List<String> keys = new ArrayList<String>(sPara.keySet());

        StringBuffer sbHtml = new StringBuffer();
        String name = "";
        String value = "";
        for (int i = 0; i < keys.size(); i++) {
            name = (String) keys.get(i);
            value = (String) sPara.get(name);
            
            sbHtml.append(name + "=" + value + "&");
        }

        return Url+sbHtml.substring(0,sbHtml.length()-1);
    }
    */
/*
    public static String buildRequest(String url, String strParaFileName, String strFilePath,Map<String, String> sParaTemp,String sign) throws Exception {

        Map<String, String> sPara = buildRequestPara(sParaTemp,sign);

        HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler.getInstance();

        HttpRequest request = new HttpRequest(HttpResultType.BYTES);

        request.setCharset("UTF-8");

        request.setParameters(generatNameValuePair(sPara));
        request.setUrl(url+"_input_charset="+"UTF-8");

        HttpResponse response = httpProtocolHandler.execute(request,strParaFileName,strFilePath);
        if (response == null) {
            return null;
        }
        
        String strResult = response.getStringResult();

        return strResult;
    }
    */
/*
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
//    		if(singtype.equals("0001")) {
//    			res_data = RSA.decrypt(res_data, AlipayConfig.private_key, AlipayConfig.input_charset);
//    		}
    		
    		Document document = DocumentHelper.parseText(res_data);
    		request_token = document.selectSingleNode( "//direct_trade_create_res/request_token" ).getText();
    	}
    	return request_token;
    }
    
  /*
    private static NameValuePair[] generatNameValuePair(Map<String, String> properties) {
        NameValuePair[] nameValuePair = new NameValuePair[properties.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            nameValuePair[i++] = new NameValuePair(entry.getKey(), entry.getValue());
        }

        return nameValuePair;
    }
    
/*
	public static String query_timestamp(String url,String partner,String input_charset) throws MalformedURLException,DocumentException, IOException {

        String strUrl = url + "service=query_timestamp&partner=" + partner + "&_input_charset=" +input_charset;
        StringBuffer result = new StringBuffer();

        SAXReader reader = new SAXReader();
//        
//        TenpayHttpClient httpClient = new TenpayHttpClient();
//
//		httpClient.setTimeOut(30);
//		httpClient.setReqContent(strUrl);
//		httpClient.call();
//		httpClient.getResContent();
        
        HttpURLConnection httpsClient = HttpClientUtil.getHttpURLConnection(strUrl);

        Document doc = reader.read(httpsClient.getInputStream());
        httpsClient.disconnect();

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
    }*/
	

	public static String getRequestURL(SortedMap parameters,String key,String gateUrl) throws UnsupportedEncodingException {
		
		String sign=createSign(parameters,key);
		
		StringBuffer sb = new StringBuffer();
		Set es = parameters.entrySet();
		Iterator it = es.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			String k = (String)entry.getKey();
			String v = (String)entry.getValue();
			
			if(!"spbill_create_ip".equals(k)) {
				sb.append(k + "=" + URLEncoder.encode(v, "UTF-8") + "&");
			} else {
				sb.append(k + "=" + v.replace(".", "%2E") + "&");
			}
		}
		
		sb.append("sign="+sign);
		

		String reqPars = sb.toString();
		
		return gateUrl+ "?" + reqPars;
		
	}
	

	public static String getwapRequestURL(SortedMap parameters,String key) throws UnsupportedEncodingException {
		
		String sign=createSign(parameters,key);
		
		StringBuffer sb = new StringBuffer();
		Set es = parameters.entrySet();
		Iterator it = es.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			String k = (String)entry.getKey();
			String v = (String)entry.getValue();
			
			if(!"desc".equals(k)) {
				sb.append(k + "=" + v + "&");
			} else {
				sb.append(k + "=" + URLEncoder.encode(v, "UTF-8") + "&");
			}
		}
		
		sb.append("sign="+sign.toUpperCase());

		String reqPars = sb.toString();
		
		return reqPars;
		
	}
	
	public static String getwxRequestURL(SortedMap parameters,String key) throws UnsupportedEncodingException {
		
		String sign=createSign(parameters,key);
		
		StringBuffer sb = new StringBuffer();
		Set es = parameters.entrySet();
		Iterator it = es.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			String k = (String)entry.getKey();
			String v = (String)entry.getValue();
			
	
				sb.append(k + "=" + URLEncoder.encode(v, "UTF-8") + "&");
			
		}
		
		sb.append("sign="+sign.toUpperCase());
		
		String reqPars = sb.toString();
		
		return reqPars;
		
	}	

	public static boolean isTenpaySign(SortedMap parameters,String key) {
		StringBuffer sb = new StringBuffer();
		Set es = parameters.entrySet();
		Iterator it = es.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			String k = (String)entry.getKey();
			String v = (String)entry.getValue();
			if(!"sign".equals(k) && null != v && !"".equals(v)) {
				sb.append(k + "=" + v + "&");
			}
		}

		sb.append("key=" + key);

		String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toLowerCase();
		
		String tenpaySign = getParameter(parameters,"sign").toLowerCase();

		return tenpaySign.equals(sign);
	}

	public static String getParameter(SortedMap parameters,String parameter) {
		String s = (String)parameters.get(parameter); 
		return (null == s) ? "" : s;
	}
	

	public static SortedMap doParse(SortedMap<String,String> parameters,String content) throws JDOMException, IOException {
		String xmlContent = content;
		
		Map m = XMLUtil.doXMLParse(xmlContent);
		
		Iterator it = m.keySet().iterator();
		while(it.hasNext()) {
			String k = (String) it.next();
			String v = (String) m.get(k);
			parameters.put(k, v);
		}
		
		return parameters;
	}
	

	public static String strReplace(String str, String old_str, String new_str) 
	{
		String tmpstr = str;
		int found_pos = tmpstr.indexOf(old_str);
		while (found_pos>=0)
		{

			tmpstr = tmpstr.substring(0,found_pos) + new_str + tmpstr.substring(found_pos + old_str.length(),tmpstr.length());			
			found_pos = tmpstr.indexOf(old_str,found_pos+new_str.length());
		}		
		return tmpstr;
	}
	

    public static Map<String, Object> parseJSON2Map(String jsonStr){  
        Map<String, Object> map = new HashMap<String, Object>();  
        JSONObject json = JSONObject.fromObject(jsonStr);  
        for(Object k : json.keySet()){  
            Object v = json.get(k);   
            if(v instanceof JSONArray){  
                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();  
                Iterator<JSONObject> it = ((JSONArray)v).iterator();  
                while(it.hasNext()){  
                    JSONObject json2 = it.next();  
                    list.add(parseJSON2Map(json2.toString()));  
                }  
                map.put(k.toString(), list);  
            } else {  
                map.put(k.toString(), v);  
            }  
        }  
        return map;  
    }  
	public static String maptoString(Map<String,String> map){
		StringBuffer sb = new StringBuffer();
		Set<Entry<String, String>> s = map.entrySet();
		Iterator<Entry<String, String>> it = s.iterator();
		String k = "";
		String v = "";
		while(it.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>)it.next();
			k = (String)entry.getKey();
			v = (String)entry.getValue();
			sb.append(k + "=" + v + "&");
		}
		return sb.toString();
	}
	public static Map<String,String> readStringXmlOut(String xml) {
        Document doc = null;
         try {
           doc = DocumentHelper.parseText(xml); 
            Map<String, String>  callBackQueryHashMap = new HashMap<String,String>();
			Element element = doc.getRootElement();
			List elements = element.elements();
			for (int i = 0; i < elements.size(); i++) {
				Element el = (Element)elements.get(i);
				List e = el.elements();
				for (int y = 0; y < e.size(); y++) {
					Element p = (Element)e.get(y);
					callBackQueryHashMap.put(p.getName().toLowerCase()+y, p.getStringValue());
				}
				callBackQueryHashMap.put(el.getName().toLowerCase(), el.getStringValue());
			}
			return callBackQueryHashMap;
         } catch (DocumentException e) {
             e.printStackTrace();
         } catch (Exception e) {
            e.printStackTrace();
	         }
	         return null;
     }
	
	public static void main(String args[]){
		//https://mapi.alipay.com/gateway.do?service=notify_verify&partner=2088201564862550&notify_id=79d65ad5b0da7d10f397543fe8274a922a
			
		/*	
	        TenpayHttpClient httpClient = new TenpayHttpClient();
			
					httpClient.setTimeOut(30);
					httpClient.setReqContent("https://mapi.alipay.com/gateway.do?service=notify_verify&partner=2088201564862550&notify_id=79d65ad5b0da7d10f397543fe8274a922a");
					httpClient.call();
					System.out.println(httpClient.getResContent());*/
//					String aa=(String)null;
//					System.out.println(aa);
					
					SortedMap<String,Object>  map=new TreeMap<String,Object>();
					map.put("appId", "wxf7976813f2c4c421");
					map.put("nonceStr", (Util.getRandomStringByLength(32)).toUpperCase());
					map.put("package", "dfdsfasd");
					map.put("signType", "MD5");
					map.put("timeStamp", Util.getTimeStamp());
					System.out.println(PaymentUtil.createSign(map, "Cdehpq1234Pqlsdjfol56712werfaerd"));
	}
	
}
