package cn.com.sinosoft.ess.protal.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.com.sinosoft.ess.protal.httpclient.HttpClientUtils;
import cn.com.sinosoft.ess.protal.payment.CryptoUtil;
import cn.com.sinosoft.ess.protal.payment.MD5Util;
import junit.framework.TestCase;

public class CustomerManageTest  extends TestCase{
	
	public void testUserLogin() {
		String key= "eService@icbc-axa#201312";  
		String userName = "Test1111";
		String password = "Test1111";
		String channel = "1";//"电商平台登陆渠道";
		String userType ="1";//"个人";
		String  signature = userName+password+channel+userType+"70D1E461A79DEF2F08C77EED95AFC5C6";
		//userName+password+channel+userType+md5Str;
		//加密
		try {
			if(!"".equals(userName)){
				userName = CryptoUtil.TripleDesEncode(userName);
			}
			if(!"".equals(password)){
				password = CryptoUtil.TripleDesEncode(password);
			}
			if(!"".equals(channel)){
				channel = CryptoUtil.TripleDesEncode(channel);
			}
			if(!"".equals(userType)){
				userType = CryptoUtil.TripleDesEncode(userType);
			}
			
			signature = CryptoUtil.MD5(signature);
			System.out.println("signature:"+signature);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map returnMap = new HashMap();
		YDGroupService jt = new YDGroupService();
		Map customerMap =jt.autoLogin(userName,password,channel,userType,signature);//
		String rflag = customerMap.get("successFlag").toString();
		String userId = customerMap.get("userId").toString();
		String successFlag = "2";
		if(customerMap == null){
			successFlag = "2";
		}else{
			if("0".equals(rflag)){//  成功
				successFlag = "0";
			}else if("-1".equals(rflag)){//失败
				successFlag = "-1";
			}else{//异常
				successFlag = "2";
			}
		}
		returnMap.put("successFlag", successFlag);
		returnMap.put("userId", userId);
		String flag = returnMap.get("successFlag").toString();
		if("0".equals(flag)){//成功
			String username = returnMap.get("userName").toString();
			System.out.println("userId:"+userId+",username:"+username+"登录成功");
		}else{
			System.out.println("登录失败");
		}
	}
	
	
	
	public void testcheckUserName(){
		//String userName ="chendongjun11";
		//String userName ="chendongjun00";
		String userName ="18600761235";
		//String userName="18600761295";
		String userType = "1";
		String channel = "1";
		String signature = userName+userType+channel+"70D1E461A79DEF2F08C77EED95AFC5C6";
		signature = CryptoUtil.MD5(signature);
		CustomerManage cm=new CustomerManage();
		Map returnMap = cm.checkUserNameServlet(userName,userType,channel,signature);
		String flag = returnMap.get("successFlag").toString();
		if("0".equals(flag)){//成功
			System.out.println("该用户名未被使用");
		}else{
			System.out.println("该用户名被使用");
		}
	}
	
	public void testcheckUser(){
		String userId ="chendongjun11";
		//String userName ="chendongjun00";
		String userName ="";
		//String userName="18600761295";
		String userType = "1";
		String channel = "1";
		String signature = userId+userName+userType+channel+"70D1E461A79DEF2F08C77EED95AFC5C6";
		signature = CryptoUtil.MD5(signature);
		CustomerManage cm=new CustomerManage();
		Map returnMap = cm.checkUserNameServlet(userName,userType,channel,signature);
		String flag = returnMap.get("successFlag").toString();
		if("0".equals(flag)){//成功
			System.out.println("该用户名未被使用");
		}else{
			System.out.println("该用户名被使用");
		}
	}
	
	public void testmodifyRegister() {
		Map map = new HashMap();
		String key= "eService@icbc-axa#201312";  
		//注册时userid null
		String userId ="24533";
		String userName ="chendongjun11";
		String password = "cdj8325450";
		String regDate = "";//注册日期
		String email = "cdj7268@qq.com";
		String mobile ="18600761295";
		String realName = "陈冬君";
		String certType ="0";//证件类型
		String certId = "340505199010181035";
		String gender = "1";//性别
		String birth = "1990-10-18";
		String regAge = "";//注册年龄
		String telephone1 ="";
		String telephone2 ="";
		String telephone3 = "";
		String job1 = "";
		String job2 = "";
		String job3 = "";
		String income = "";
		String city1 = "";
		String city2 = "";
		String city3 = "";
		String userStatus = "";//用户状态
		String authStatus ="";//认证状态
		String scisId = "";//scis号
		String userType = "1";
		String emailAuthFlag = "";//邮箱认证标记
		String channel = "1";
		String opType = "2";//操作类型 1 注册 2 已注册用户信息更新

		
		String signature =userId+userName+password+regDate+email+mobile
				+realName+certType+certId +gender+birth+regAge+telephone1+telephone2+telephone3
				+job1+job2+job3+income+city1+city2+city3+userStatus+authStatus
				+scisId+userType+emailAuthFlag+channel+opType+"70D1E461A79DEF2F08C77EED95AFC5C6";	
		try {
			if(!"".equals(userName)){
				userName = CryptoUtil.TripleDesEncode(userName);
			}
			if(!"".equals(userType)){
				userType = CryptoUtil.TripleDesEncode(userType);
			}
			if(!"".equals(channel)){
				channel = CryptoUtil.TripleDesEncode(channel);
			}
			if(!"".equals(userId)){
				userId = CryptoUtil.TripleDesEncode(userId);
			}
			if(!"".equals(password)){
				password = CryptoUtil.TripleDesEncode(password);
			}
			if(!"".equals(regDate)){
				regDate = CryptoUtil.TripleDesEncode(regDate);
			}
			if(!"".equals(email)){
				email = CryptoUtil.TripleDesEncode(email);
			}
			if(!"".equals(mobile)){
				mobile = CryptoUtil.TripleDesEncode(mobile);
			}
			if(!"".equals(realName)){
				realName = CryptoUtil.TripleDesEncode(realName);
			}
			if(!"".equals(certType)){
				certType = CryptoUtil.TripleDesEncode(certType);
			}
			if(!"".equals(certId)){
				certId = CryptoUtil.TripleDesEncode(certId);
			}
			if(!"".equals(gender)){
				gender = CryptoUtil.TripleDesEncode(gender);
			}
			if(!"".equals(birth)){
				birth = CryptoUtil.TripleDesEncode(birth);
			}
			if(!"".equals(regAge)){
				regAge = CryptoUtil.TripleDesEncode(regAge);
			}
			if(!"".equals(telephone1)){
				telephone1 = CryptoUtil.TripleDesEncode(telephone1);
			}
			if(!"".equals(telephone2)){
				telephone2 = CryptoUtil.TripleDesEncode(telephone2);
			}
			if(!"".equals(telephone3)){
				telephone3 = CryptoUtil.TripleDesEncode(telephone3);
			}
			if(!"".equals(job1)){
				job1 = CryptoUtil.TripleDesEncode(job1);
			}
			if(!"".equals(job2)){
				job2 = CryptoUtil.TripleDesEncode(job2);
			}
			if(!"".equals(job3)){
				job3 = CryptoUtil.TripleDesEncode(job3);
			}
			if(!"".equals(income)){
				income = CryptoUtil.TripleDesEncode(income);
			}
			if(!"".equals(city1)){
				city1 = CryptoUtil.TripleDesEncode(city1);
			}
			if(!"".equals(city2)){
				city2 = CryptoUtil.TripleDesEncode(city2);
			}
			if(!"".equals(city3)){
				city3 = CryptoUtil.TripleDesEncode(city3);
			}
			if(!"".equals(userStatus)){
				userStatus = CryptoUtil.TripleDesEncode(userStatus);
			}
			if(!"".equals(authStatus)){
				authStatus = CryptoUtil.TripleDesEncode(authStatus);
			}
			if(!"".equals(scisId)){
				scisId = CryptoUtil.TripleDesEncode(scisId);
			}
			if(!"".equals(emailAuthFlag)){
				emailAuthFlag = CryptoUtil.TripleDesEncode(emailAuthFlag);
			}
			if(!"".equals(opType)){
				opType = CryptoUtil.TripleDesEncode(opType);
			}
			signature = CryptoUtil.MD5(signature);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("userName", userName);
		map.put("userType", userType);
		map.put("channel", channel);
		map.put("signature", signature);
		map.put("userId", userId);
		map.put("password", password);
		map.put("regDate", regDate);
		map.put("email", email);
		map.put("mobile", mobile);
		map.put("realName", realName);
		map.put("certType", certType);
		map.put("certId", certId);
		map.put("gender", gender);
		map.put("birth", birth);
		map.put("regAge", regAge);
		map.put("telephone1", telephone1);
		map.put("telephone2", telephone2);
		map.put("telephone3", telephone3);
		map.put("job1", job1);
		map.put("job2", job2);
		map.put("job3", job3);
		map.put("income", income);
		map.put("city1", city1);
		map.put("city2", city2);
		map.put("city3", city3);
		map.put("userStatus", userStatus);
		map.put("authStatus", authStatus);
		map.put("scisId", scisId);
		map.put("emailAuthFlag", emailAuthFlag);
		map.put("opType", opType);
		CustomerManage cm = new CustomerManage();
		Map returnMap = cm.modifyRegisterServlet(map);
		if("0".equals(returnMap.get("successFlag"))){//成功
			System.out.println("注册成功");
		}else{//失败
			System.out.println("注册失败");
		}
	}
	/**
	 * 会员信息查询接口
	 */
	public void testQueryUserInfo(){
		//String userId= "24109";
		String userId= "24109";//(不可空)
		String userName="Test1212";//(不可空)
		String userType="1";
		String channel="1";
		String signature=userId+userName+userType+channel+"70D1E461A79DEF2F08C77EED95AFC5C6";
		//userId+userName+userType+channel+md5Str
		signature = CryptoUtil.MD5(signature);
		CustomerManage cm = new CustomerManage();
		cm.queryUserInfo(userId,userName,userType,channel,signature);
	}

}
