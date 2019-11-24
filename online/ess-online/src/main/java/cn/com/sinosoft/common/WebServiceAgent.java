package cn.com.sinosoft.common;

import java.net.URL;
import java.rmi.RemoteException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WebServiceAgent {
	private final static Logger logger = LoggerFactory.getLogger(WebServiceAgent.class);

	public String getResult(String inputXML,String method,String URL){
		Call call = getCall(URL);
		call.setOperationName(method);//接口名
		try {
			return (String) call.invoke(new Object[] {inputXML});
		} catch (RemoteException e) {
			logger.error("调用getGrpAcceptanceAC接口错误"+e);
		}
		return null;
	}
	public Call getCall(String targetEendPoint){
		Call call = null;
		try{
		//System.setProperty("javax.net.ssl.trustStore","d://xcClient.truststore");//证书目录
		//System.setProperty("javax.net.ssl.trustStorePassword", "123456");
		 Service service = new Service();
		 	 call = (Call) service.createCall();
		 			call.getMessageContext().setUsername("jxtest");		//用户名。
		 			call.getMessageContext().setPassword("jxtest");		//密码
		 			call.setTargetEndpointAddress(new URL(targetEendPoint));
		 		
		 	return call;
		}catch(Exception e){
			e.printStackTrace();
		}
		return call;
	}
	
}
