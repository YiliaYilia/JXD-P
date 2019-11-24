package cn.com.sinosoft.web.util;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述：http调用工具类
 * 作者：fenghj <br>
 */
public class HttpClientUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

	
	/**
	 * 方法名称: service<br>
	 * 描述：调用http方法接口
	 * 作者: fenghj
	 * @param soapRequest 请求报文
	 * @return 服务方返回值
	 */
	public static Object service(String url,Map<String, String> parmeters){
		
		String result = null;
		PostMethod postMethod = new PostMethod(url);
		
		for(String key:parmeters.keySet()){
			String value = parmeters.get(key).toString();
			logger.info("传入参数",key+":"+value);
			postMethod.addParameter(key,value);
		}

		try {
			//设置POST方法请求超时
			postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
			HttpClient httpClient = new HttpClient();
			HttpConnectionManagerParams managerParams = httpClient.getHttpConnectionManager().getParams();
			//设置连接超时时间(单位毫秒)
			managerParams.setConnectionTimeout(30000);
			//设置读数据超时时闄(单位毫秒)
			managerParams.setSoTimeout(600000);
			//对HttpClient对象，发出postMethod请求
			int statusCode = httpClient.executeMethod(postMethod);
			if (statusCode != HttpStatus.SC_OK){
				String errorMessage = "调用服务错误 : "	+ postMethod.getStatusLine();
				logger.error(errorMessage);
				throw new IllegalStateException(errorMessage);
			}
			result = postMethod.getResponseBodyAsString();
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally {
			postMethod.releaseConnection();
		}
		return result;
	}
}
