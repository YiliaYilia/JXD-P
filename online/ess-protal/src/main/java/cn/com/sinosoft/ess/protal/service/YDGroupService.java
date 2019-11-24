package cn.com.sinosoft.ess.protal.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.core.utils.PropertityUtil;
import cn.com.sinosoft.ess.protal.common.Data;
import cn.com.sinosoft.ess.protal.common.PraseXml;
import cn.com.sinosoft.ess.protal.payment.CryptoUtil;
import cn.com.sinosoft.ess.protal.webservice.Axis2ClientUtils;



public class YDGroupService {	
	private static final Logger logger = LoggerFactory.getLogger(YDGroupService.class);
	
	
	
	/**本地测试环境*/
	private static final String PRO_DEBUG="debug";
	/**登录地址*/
	private static final String PRO_LOGIN_URL = "LoginAdress";
	/**注册用户名，手机号验证地址*/
	private static final String PRO_CHECKUSERNAME_URL="CheckUserNameAdress";
	/**注册，更新地址*/
	private static final String PRO_MODIFYRREGISTERADRESS_URL= "ModifyrRegisterAdress";
	/**查询用户信息地址*/
	private static final String PRO_QUERYUSERINFOADRESS_URL= "QueryUserInfoAdress";
	/**session客服、官网同步地址*/
	private static final String PRO_SESSIONSYNCHRONIZEDADRESS_C_URL="SessionSynchronizedAdress_c";
	private static final String PRO_SESSIONSYNCHRONIZEDADRESS_W_URL="SessionSynchronizedAdress_w";
	
	/**客服返回字符编码*/
	private static String BASIC_DEBUG=null;
	private static String BASIC_LOGIN_URL = null;
	private static String BASIC_CHECKUSERNAME_URL = null;
	private static String BASIC_MODIFYRREGISTERADRESS_URL = null;
	private static String BASIC_QUERYUSERINFOADRESS_URL=null;
	
	private static String BASIC_SESSIONSYNCHRONIZEDADRESS_C_URL = null;
	private static String BASIC_SESSIONSYNCHRONIZEDADRESS_W_URL = null;
	static{
		//读取文件初始化WebService参数
		PropertityUtil.init("config/portal.properties");
		BASIC_DEBUG=PropertityUtil.get(YDGroupService.PRO_DEBUG);
		BASIC_LOGIN_URL = PropertityUtil.get(YDGroupService.PRO_LOGIN_URL);
		BASIC_CHECKUSERNAME_URL = PropertityUtil.get(YDGroupService.PRO_CHECKUSERNAME_URL);
		BASIC_MODIFYRREGISTERADRESS_URL= PropertityUtil.get(YDGroupService.PRO_MODIFYRREGISTERADRESS_URL);
		BASIC_QUERYUSERINFOADRESS_URL=PropertityUtil.get(YDGroupService.PRO_QUERYUSERINFOADRESS_URL);
		BASIC_SESSIONSYNCHRONIZEDADRESS_C_URL = PropertityUtil.get(YDGroupService.PRO_SESSIONSYNCHRONIZEDADRESS_C_URL);
		BASIC_SESSIONSYNCHRONIZEDADRESS_W_URL = PropertityUtil.get(YDGroupService.PRO_SESSIONSYNCHRONIZEDADRESS_W_URL);
		
	
	}
	/**
	 * 客户自动登录
	 * @param customerId	用户名
	 * @return		flag:结果标志0-失败	1-成功	desc:结果信息
	 * 				null-异常
	 */
	public Map autoLogin(String userName,String password,String channel,String userType,String signature){
		Map m = new HashMap();
		try{
			String URL = BASIC_LOGIN_URL;				
			// 填入各个表单域的值
	        NameValuePair[] data = { new NameValuePair("userName", userName),new NameValuePair("password", password),new NameValuePair("channel", channel),new NameValuePair("userType", userType),new NameValuePair("signature", signature) };
	        //走本次测试
	        String returnJson=null;
	        if("1".equals(BASIC_DEBUG)){
	        	returnJson = "{\"successFlag\":\"0\",\"errCode\":\"0\",\"errMsg\":\"\",\"userID\":\"20001\"}";
	        	logger.info("本地测试"); 	
	        }else if("0".equals(BASIC_DEBUG)){
	        	returnJson =  httpClientForm(URL, data);
	        	logger.info("正式环境"); 
	        }
			logger.info("登录返回json报文："+returnJson);
			JSONObject dataJson = new JSONObject(returnJson);
			String successFlag = dataJson.getString("successFlag");//结果标志
			m.put("successFlag", successFlag);
			if("-1".equals(successFlag)){//失败
				String errMsg = dataJson.getString("errMsg");//失败信息
				String errCode = dataJson.getString("errCode");//错误代码
				m.put("errMsg", errMsg);
				m.put("errCode", errCode);
				logger.info("客户登录失败："+errMsg);	
			}else if("0".equals(successFlag)){//成功
				String userId = dataJson.getString("userID");
				logger.info("客户"+userId+"登录成功。");
				m.put("userId", userId);
			}
		}catch(Exception e){
			logger.error("客户登录异常!", e);
		}
		return m;
	}
	
	public Map modifyRegister(Map map){
		Map m=new HashMap();
		try{
			String URL = BASIC_MODIFYRREGISTERADRESS_URL;
			// 填入各个表单域的值
	        NameValuePair[] data = { 
	        		new NameValuePair("userId", (String)map.get("userId")),
	        		new NameValuePair("userName", (String)map.get("userName")),
	        		new NameValuePair("password", (String)map.get("password")),
				    new NameValuePair("regDate", (String)map.get("regDate")),
				    new NameValuePair("email", (String)map.get("email")),
				    new NameValuePair("mobile", (String)map.get("mobile")),
				    new NameValuePair("realName", (String)map.get("realName")),
				    new NameValuePair("certType", (String)map.get("certType")),
				    new NameValuePair("certId", (String)map.get("certId")),
				    new NameValuePair("gender", (String)map.get("gender")),
				    new NameValuePair("birth", (String)map.get("birth")),
				    new NameValuePair("regAge", (String)map.get("regAge")),
				    new NameValuePair("telephone1", (String)map.get("telephone1")),
				    new NameValuePair("telephone2", (String)map.get("telephone2")),
				    new NameValuePair("telephone3", (String)map.get("telephone3")),
				    new NameValuePair("job1", (String)map.get("job1")),
				    new NameValuePair("job2", (String)map.get("job2")),
				    new NameValuePair("job3", (String)map.get("job3")),
				    new NameValuePair("income", (String)map.get("income")),
				    new NameValuePair("city1", (String)map.get("city1")),
				    new NameValuePair("city2", (String)map.get("city2")),
				    new NameValuePair("city3", (String)map.get("city3")),
				    new NameValuePair("userStatus", (String)map.get("userStatus")),
				    new NameValuePair("authStatus", (String)map.get("authStatus")),
				    new NameValuePair("scisId", (String)map.get("scisId")),
					new NameValuePair("userType", (String)map.get("userType")),
				    new NameValuePair("emailAuthFlag", (String)map.get("emailAuthFlag")),
	        		new NameValuePair("channel", (String)map.get("channel")),
	        		new NameValuePair("opType", (String)map.get("opType")),
				    new NameValuePair("signature", (String)map.get("signature"))	   
				   
	        };
	        /**returnXML是json格式，需修改*/
	        String returnJson=null;
	        if("1".equals(BASIC_DEBUG)){
	        	returnJson =  "{\"successFlag\":\"0\",\"errCode\":\"0\",\"errMsg\":\"\",\"userID\":\"24535\"}";
		        logger.info("本地测试"); 	
	        }else if("0".equals(BASIC_DEBUG)){
	        	 returnJson = httpClientForm(URL, data);
	        	logger.info("正式环境"); 
	        }
	        logger.info("客户注册修改返回报文:"+returnJson);
			JSONObject dataJson = new JSONObject(returnJson);
			String successFlag = dataJson.getString("successFlag");//结果标志
			if("-1".equals(successFlag)){//失败
				String errMsg = dataJson.getString("errMsg");//失败信息
				String errCode = dataJson.getString("errCode");//错误代码
				m.put("errMsg", errMsg);
				m.put("errCode", errCode);
				m.put("successFlag", successFlag);
			}else if("0".equals(successFlag)){//成功
				String userId = dataJson.getString("userID");//客服平台唯一用户编号
				logger.info("修改注册信息成功");
				m.put("userId", userId);
				m.put("successFlag", successFlag);
			}
			//3、将返回结果组装成Map				
			return m;
		}catch(Exception e){
			logger.error("客户数据查询异常!", e);
			return m;
		}
	}
	/*
	 * 	会员信息查询接口
	 */
	public Map queryUserInfo(String userId,String userName, String userType,String  channel,String signature){
		Map m=new HashMap();
		try{
			String URL = BASIC_QUERYUSERINFOADRESS_URL;
			// 填入各个表单域的值
	        NameValuePair[] data = { new NameValuePair("userId", userId),new NameValuePair("userName", userName),new NameValuePair("userType", userType),new NameValuePair("channel", channel),new NameValuePair("signature", signature) };
	        String returnJson=null;
	        if("1".equals(BASIC_DEBUG)){
	        	returnJson = "{\"userId\":\"24109\",\"userName\":\"Test1212\",\"regDate\":\"2014-01-15 23:04:30\",\"email\":\"aaa@aaa.com\",\"mobile\":\"13232323232\",\"realName\":\"贺明侠\",\"certType\":\"0\",\"certId\":\"372930197807110046\",\"gender\":\"2\",\"birth\":\"1978-07-11 00:00:00\",\"regAge\":\"\",\"telephone1\":\"\",\"telephone2\":\"\",\"telephone3\":\"\",\"job1\":\"-1\",\"job2\":\"-1\",\"job3\":\"-1\",\"income\":\"-1\",\"city1\":\"-1\",\"city2\":\"-1\",\"city3\":\"-1\",\"userStatus\":\"1\",\"authStatus\":\"2\",\"scisId\":\"\",\"userType\":\"1\",\"emailAuthFlag\":\"0\",\"successFlag\":\"0\",\"errCode\":\"\",\"errMsg\":\"\"}";
		        logger.info("本地测试"); 	
	        }else if("0".equals(BASIC_DEBUG)){
	        	 returnJson = httpClientForm(URL, data);
	        	logger.info("正式环境"); 
	        }
	       logger.info("会员信息查询接口返回报文："+returnJson);
	        JSONObject dataJson = new JSONObject(returnJson);	
			String successFlag = dataJson.getString("successFlag");//结果标志
			if("0".equals(successFlag)){				
				m.put("userId", dataJson.getString("userId"));
				m.put("userName",  dataJson.getString("userName"));//用户名
				m.put("regDate", dataJson.getString("regDate"));//注册日期
				m.put("email", dataJson.getString("email"));//电子邮箱
				m.put("mobile",  dataJson.getString("mobile"));//手机号码
				m.put("realName", dataJson.getString("realName"));//真实姓名
				m.put("certType", dataJson.getString("certType"));//证件类型
				m.put("certId",  dataJson.getString("certId"));//证件号码
				m.put("gender", dataJson.getString("gender"));//性别
				m.put("birth", dataJson.getString("birth"));//生日
				m.put("regAge",  dataJson.getString("regAge"));//注册年龄
				m.put("telephone1", dataJson.getString("telephone1"));//固定电话1
				m.put("telephone2", dataJson.getString("telephone2"));
				m.put("telephone3",  dataJson.getString("telephone3"));
				m.put("job1", dataJson.getString("job1"));//职业1
				m.put("job2", dataJson.getString("job2"));
				m.put("job3",  dataJson.getString("job3"));
				m.put("income", dataJson.getString("income"));//收入状况
				m.put("city1", dataJson.getString("city1"));//所在城市1
				m.put("city2",  dataJson.getString("city2"));
				m.put("city3", dataJson.getString("city3"));
				m.put("userStatus", dataJson.getString("userStatus"));//用户状态1-正常，2-锁定，3-注销，4-有效，0-未激活
				m.put("authStatus",  dataJson.getString("authStatus"));//认证状态1-已认证，2-未认证，默认为 1
				m.put("scisId", dataJson.getString("scisId"));//scis号
				m.put("userType", dataJson.getString("userType"));//用户类型1-个人，2-企业经办，3-中介
				m.put("emailAuthFlag",  dataJson.getString("emailAuthFlag"));//邮箱认证标记0-未认证，1-认证
				m.put("successFlag", successFlag);
				logger.info("会员信息查询接口返回结果："+" 成功 ");
			}else{
				String  errMsg = dataJson.getString("errMsg");
				String  errCode = dataJson.getString("errCode");
				m.put("errMsg", errMsg);
				m.put("errCode", errCode);
				m.put("successFlag", successFlag);
				logger.info("会员信息查询接口返回失败结果："+errMsg+" 错误码："+errCode);			
			}            
		}catch(Exception e){
			logger.error("会员信息查询接口返回异常",e);
		}
		return m;
	}

	public Map checkUserName(String userName,String userType,String channel,String signature){
		try{
			Map m=new HashMap();
			String URL = BASIC_CHECKUSERNAME_URL;
			// 填入各个表单域的值
	        NameValuePair[] data = { new NameValuePair("userName", userName),new NameValuePair("userType", userType),new NameValuePair("channel", channel),new NameValuePair("signature", signature) };
	        String returnJson =null;
	        if("1".equals(BASIC_DEBUG)){
	        	returnJson = "{\"successFlag\":\"0\",\"errCode\":\"\",\"errMsg\":\"\",\"userDup\":\"1\"}" ;
		        logger.info("本地测试"); 	
	        }else if("0".equals(BASIC_DEBUG)){
	        	returnJson = httpClientForm(URL, data);
	        	logger.info("正式环境"); 
	        }
	        logger.info("注册信息验证接口返回报文："+returnJson);
	        JSONObject dataJson = new JSONObject(returnJson);	
	        String successFlag = dataJson.getString("successFlag");//结果标志
			String errMsg = dataJson.getString("errMsg");//失败信息
			String errCode = dataJson.getString("errCode");//错误代码
			String userDup = dataJson.getString("userDup");//是否重复
			//3、将返回结果组装成Map
			m.put("successFlag", successFlag);		
			m.put("errMsg", errMsg);
			m.put("errCode", errCode);
			m.put("userDup", userDup);
			return m;
		}catch(Exception e){
			//ECLog.error("客户数据查询异常!", e);
			return null;
		}
	}
	
	
	private static String httpClientForm(String URL,NameValuePair[] data){
		String result = null;
		MultiThreadedHttpConnectionManager manager = new MultiThreadedHttpConnectionManager();
		HttpClient httpclient = new HttpClient(manager);  
	    try {
	       PostMethod post = new PostMethod(URL);  
	       post.setRequestBody(data);
	       //使用POST方法    
	    httpclient.executeMethod(post);        
        int code = post.getStatusCode();    
        if (code != HttpStatus.SC_OK){  
          return null;
        }  
        //打印返回的信息   
        InputStream res = post.getResponseBodyAsStream();  
        result = getByInputStream(res,"UTF-8");
        //释放连接   
        post.releaseConnection();  
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return result;
	}


	private static String getByInputStream(InputStream in,String encode){
		BufferedReader bufferReader;
		try {
			InputStreamReader reader = null;
			if(encode == null){
				reader = new InputStreamReader(in);
			} else {
				reader = new InputStreamReader(in,encode);
			}
			bufferReader = new BufferedReader(reader);
			StringBuffer buffer = new StringBuffer();
			while(true){
					String line = bufferReader.readLine();
					if(line == null){
						break;
					}
					buffer.append(line);
			}
			bufferReader.close();
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
