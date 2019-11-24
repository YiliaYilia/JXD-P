package cn.com.sinosoft.weixin.client;

import java.util.SortedMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.common.PaymentConfigProp;
import cn.com.sinosoft.weixin.util.ClientResponseHandler;
import cn.com.sinosoft.weixin.util.PaymentUtil;
import cn.com.sinosoft.weixin.util.XMLUtil;

public class HttpClient {
	public static Logger logger = LoggerFactory.getLogger(HttpClient.class);
	public static SortedMap<String, Object>  sendPost(SortedMap<String, Object> parameters,String key,String url){
		TenpayHttpClient thc = new TenpayHttpClient();
		thc.setMethod("POST");
		String sign=PaymentUtil.createSign(parameters,key);
		parameters.put("sign", sign);
		String strReq=XMLUtil.mapToXmlString(parameters);
		logger.info("##微信请求参数："+strReq);
		String httpUrl=PaymentConfigProp.getString(url);
		logger.info("##微信请求地址："+httpUrl);
		thc.call(httpUrl, strReq);
		ClientResponseHandler queryRes = new ClientResponseHandler();
		try {
			String responseStr=thc.getResContent();
			logger.info("##微信预支付请求返回的参数："+responseStr);
			queryRes.setContent(responseStr);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return  queryRes.getAllParameters();
	}
	
	

	
	
}
