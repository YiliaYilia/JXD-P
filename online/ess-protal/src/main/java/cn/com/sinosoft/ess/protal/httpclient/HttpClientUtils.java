package cn.com.sinosoft.ess.protal.httpclient;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述：<br>
 * 作者：wangpengfei <br>
 * 修改日期：2014-3-6上午09:10:39 <br>
 * E-mail: wangpengfei14079@sinosoft.com.cn <br>
 */
public class HttpClientUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

	public static String BasicHttpBinding_Service_address = "http://localhost:8080/icbc/servler/ICBCServlet";
	
	/**
	 * 方法名称: callRemoteServiceURL<br>
	 * 描述：调用远程WebService方法接口
	 * 作者: wangpengfei
	 * 修改日期：2014-3-6上午09:10:50
	 * @param soapRequest 请求报文
	 * @return 服务方返回值
	 */
	public static Object callRemoteServiceURL(String soapRequest){
		//预先定义好Soap XML请求数据 
		String result = null;
		//定义丄1�7个PostMethod，这时需要指定web服务的Url;
		PostMethod postMethod = new PostMethod(BasicHttpBinding_Service_address);
		try {
			//设置POST方法请求超时
			postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
			byte[] b = soapRequest.getBytes("utf-8");
			InputStream inputStream = new ByteArrayInputStream(b, 0, b.length);
			RequestEntity re = new InputStreamRequestEntity(inputStream,b.length, "application/soap+xml; charset=utf-8");
			//把Soap请求数据添加到PostMethod丄1�7
			postMethod.setRequestEntity(re);
			HttpClient httpClient = new HttpClient();
			HttpConnectionManagerParams managerParams = httpClient.getHttpConnectionManager().getParams();
			//设置连接超时时间(单位毫秒)
			managerParams.setConnectionTimeout(30000);
			//设置读数据超时时闄1�7(单位毫秒)
			managerParams.setSoTimeout(600000);
			//对HttpClient对象，发出postMethod请求
			int statusCode = httpClient.executeMethod(postMethod);
			if (statusCode != HttpStatus.SC_OK){
				String errorMessage = "调用webservice错误 : "	+ postMethod.getStatusLine();
				logger.error(errorMessage);
				throw new IllegalStateException(errorMessage);
			}
			result = postMethod.getResponseBodyAsString();
			inputStream.close();
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
