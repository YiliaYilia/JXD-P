package cn.com.sinosoft.ess.protal.webservice;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.core.exception.BaseException;
import cn.com.sinosoft.core.exception.enumerate.ExceptionGrade;
import cn.com.sinosoft.core.utils.PropertityUtil;
import cn.com.sinosoft.core.utils.StringUtils;
import cn.com.sinosoft.ess.protal.common.PortalProp;
import cn.com.sinosoft.ess.protal.util.XMLUtil;

/**
 * 描述：基于AXIS2的WebService客户端调用<br>
 * 作者：wangpengfei <br>
 * 修改日期：2014-3-6上午09:09:28 <br>
 * E-mail: wangpengfei14079@sinosoft.com.cn <br>
 */
public class Axis2ClientUtils2 {

	private static final Logger logger = LoggerFactory.getLogger(Axis2ClientUtils2.class);

	// properties文件属性名称
	/** WebService地址 */
	private static final String PRO_NAME_BANCASSURANCE_WEBSERVICE_URL = "BancassuranceWebServiceURL";
	/** WebService 名称空间 */
	private static final String PRO_NAME_BANCASSURANCE_WEBSERVICE_NAMESPACE = "BancassuranceWebServiceNamespace";

	// WebService
	private static String BASIC_HTTP_BINDING_SERVICE_ADDRESS = null;
	private static String BASIC_HTTP_BINDING_SERVICE_NAMESPACE = null;

	static {
		// 读取文件初始化WebService参数
		PropertityUtil.init("config/portal.properties");
		BASIC_HTTP_BINDING_SERVICE_ADDRESS = PropertityUtil.get(Axis2ClientUtils2.PRO_NAME_BANCASSURANCE_WEBSERVICE_URL);
		BASIC_HTTP_BINDING_SERVICE_NAMESPACE = PropertityUtil.get(Axis2ClientUtils2.PRO_NAME_BANCASSURANCE_WEBSERVICE_NAMESPACE);
	}

	/**
	 * 方法名称: callBancassuranceRemoteService<br>
	 * 描述：调用银保远程接口服务
	 * 作者: wangpengfei
	 * 修改日期：2014-3-6下午04:49:42
	 * 
	 * @param method 远程方法名称
	 * @param requsetXML XML请求报文
	 * @return XML响应报文
	 */
	public static String callBancassuranceRemoteService(String remoteURL, String nameSpace, String methodName, String requestXML) throws BaseException {
		try {
			logger.debug("start +++请求地址：" + remoteURL + "\n命名空间：" + nameSpace + "\n方法名：" + methodName);
			logger.debug("请求报文：" + XMLUtil.formatXML(requestXML));
		} catch (Exception e) {
			logger.debug("格式化请求报文出错:", e);
			throw new BaseException(ExceptionGrade.SEVERITY, e, "1", "格式化请求报文出错");
		}

		//String responseXML = (String) callRemoteService(remoteURL, nameSpace, methodName, new Object[] { requestXML }, new Class[] { String.class });
		String responseXML = callBancassuranceRemoteService2(remoteURL, nameSpace, methodName, requestXML);
		try {
			logger.debug("响应报文：" + (StringUtils.isBlank(responseXML) ? responseXML : XMLUtil.formatXML(responseXML)));
		} catch (Exception e) {
			logger.debug("响应报文：" + responseXML);
			logger.error("格式化请求报文出错:", e);
			logger.debug("end +++请求地址：" + remoteURL + "\n命名空间：" + nameSpace + "\n方法名：" + methodName);
			throw new BaseException(ExceptionGrade.SEVERITY, e, "1", "格式化返回报文出错");
		}
		logger.debug("end +++请求地址：" + remoteURL + "\n命名空间：" + nameSpace + "\n方法名：" + methodName);
		return responseXML;
	}

	/**
	 * 方法名称: callRemoteService<br>
	 * 描述：调用远程WebService方法接口
	 * 作者: wangpengfei
	 * 修改日期：2014-3-6上午09:09:36
	 * 
	 * @param webServiceURL 远程WebService地址
	 * @param webServiceNamespace 远程WebService名称空间
	 * @param method 远程方法名称
	 * @param parameters 参数列表
	 * @param returnClasses 返回值类型
	 * @return 服务方返回值
	 */
	public static Object callRemoteService(String webServiceURL, String webServiceNamespace, String method, Object[] parameters, @SuppressWarnings("rawtypes") Class[] returnClasses) throws BaseException {
		Object result = null;
		// 使用RPC方式调用WebService
		RPCServiceClient serviceClient = null;
		try {
			serviceClient = new RPCServiceClient();
		} catch (AxisFault e) {
			logger.error("RPCServiceClient初始化出错：", e);
			throw new BaseException(ExceptionGrade.SEVERITY, e, "1", "RPCServiceClient初始化出错");
		}

		Options options = serviceClient.getOptions();
		// 指定调用WebService的URL
		EndpointReference targetEPR = new EndpointReference(webServiceURL);
		options.setTo(targetEPR);
		options.setProperty(HTTPConstants.REUSE_HTTP_CLIENT, true);
	    //设置客户端关闭连接  
	    options.setProperty(HTTPConstants.HEADER_CONNECTION, HTTPConstants.HEADER_CONNECTION_CLOSE);  
		options.setTimeOutInMilliSeconds(30000);
		// 指定要调用的远程方法及WSDL文件的命名空间.....
		QName opAddEntry = new QName(webServiceNamespace, method);
		try {
			// invokeBlocking方法有三个参数，其中第一个参数的类型是QName对象，表示要调用的方法名；
			// 第二个参数表示要调用的WebService方法的参数值，参数类型为Object[]；
			// 第三个参数表示WebService方法的返回值类型的Class对象，参数类型为Class[]。
			// 当方法没有参数时，invokeBlocking方法的第二个参数值不能是null，而要使用new Object[]{}
			// 如果被调用的WebService方法没有返回值，应使用RPCServiceClient类的invokeRobust方法，
			// 该方法只有两个参数，它们的含义与invokeBlocking方法的前两个参数的含义相同
			result = serviceClient.invokeBlocking(opAddEntry, parameters, returnClasses)[0];			
		} catch (AxisFault e) {
			logger.error("RPCServiceClient出错：", e);
			throw new BaseException(ExceptionGrade.SEVERITY, e, "1", "RPCServiceClient出错");
		}finally{
			try {
				if(serviceClient!=null){
					serviceClient.cleanupTransport();
					serviceClient.cleanup();
					logger.error("serviceClient"+webServiceURL+"释放链接成功");	
				}				
			} catch (AxisFault e1) {
				logger.error("serviceClient"+webServiceURL+"释放链接失败！",e1);
				throw new BaseException(ExceptionGrade.SEVERITY, e1, "1", "释放链接失败");
			}
		}
		return result;
	}
	

	
	/**
	 * 方法名称: callBancassuranceRemoteService<br>
	 * 描述：调用影像系统远程接口服务
	 * 作者: wangpengfei
	 * 修改日期：2014-3-6下午04:49:42
	 * 
	 * @param method 远程方法名称
	 * @param requsetXML XML请求报文
	 * @return XML响应报文
	 */
	public static String callBancassuranceRemoteService2(String remoteURL, String nameSpace, String methodName, String requestStr) throws BaseException {
		

		logger.debug("请求地址：" + remoteURL + "\n命名空间：" + nameSpace + "\n方法名：" + methodName);
		logger.debug("请求报文：" + requestStr);
		String responseStr="";

		Service service = new Service();
		service.setTypeMappingVersion("1.2");
		try {
			Call call = (Call)service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(remoteURL));
			call.setOperationName(new QName(nameSpace,methodName));		
			call.setTimeout(Integer.parseInt(PortalProp.getString("outTime")));
			responseStr =(String) call.invoke(new Object[]{requestStr});
		} catch (ServiceException e) {		
			logger.error("系统繁忙：9002：", e);
			throw new BaseException(ExceptionGrade.SEVERITY, e, "1", "系统繁忙：9002");
		}catch (MalformedURLException e) {
			logger.error("系统繁忙：9002：", e);
			throw new BaseException(ExceptionGrade.SEVERITY, e, "1", "系统繁忙：9002");
		}catch (RemoteException e) {
			logger.error("系统繁忙：9002：", e);
			throw new BaseException(ExceptionGrade.SEVERITY, e, "1", "系统繁忙：9002");
		}
		return responseStr;
		
	}
	
	/**
	 * 方法名称: callBancassuranceRemoteService<br>
	 * 描述：调用Image接口服务
	 * 作者: 
	 * 修改日期：2014-3-6下午04:49:42
	 * 
	 * @param method 远程方法名称
	 * @param requsetXML XML请求报文
	 * @return XML响应报文
	 */
	public static String callBancassuranceRemoteService4Image(String remoteURL, String nameSpace, String methodName, String requestStr) throws BaseException {
		logger.debug("请求地址：" + remoteURL + "\n命名空间：" + nameSpace + "\n方法名：" + methodName);
		logger.debug("请求报文：" + requestStr);
		String responseStr = (String) callRemoteService(remoteURL, nameSpace, methodName, new Object[] { requestStr }, new Class[] { String.class });
		return responseStr;
	}
}
