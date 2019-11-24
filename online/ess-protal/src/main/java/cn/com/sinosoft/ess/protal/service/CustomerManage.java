package cn.com.sinosoft.ess.protal.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.utils.PropertityUtil;
import cn.com.sinosoft.ess.protal.payment.CryptoUtil;

@Component
public class CustomerManage {	
	private static final Logger logger = LoggerFactory.getLogger(YDGroupService.class);
	/**
	 * 登录
	 * 
	 */
	public boolean jituanAutoLogin(HttpServletRequest request) {
		Map returnMap =  customerLogin(request);
		String flag = returnMap.get("successFlag").toString();
		if("0".equals(flag)){//成功
			String userId = returnMap.get("userId").toString();
			request.getSession().setAttribute("userId", userId);
			return true;
		}else{
			String errMsg = returnMap.get("errMsg").toString();
			String errCode = returnMap.get("errCode").toString();
			logger.info("登录失败，错误码："+errCode+"错误信息:"+errMsg);
			return false;
		}
	}
	
	/**
	 * 登录
	 * 
	 */
	public Map customerLogin(HttpServletRequest request) {
		Map returnMap =  new HashMap();
		try {
			String userName = request.getParameter("userName")==null?"":request.getParameter("userName");
			String password = request.getParameter("password")==null?"":request.getParameter("password");
			String channel = request.getParameter("channel")==null?"":request.getParameter("channel");
			String userType = request.getParameter("userType")==null?"":request.getParameter("userType");
			PropertityUtil.init("config/pwd.properties");
	    	String md5Str = PropertityUtil.get("md5");
			String signature = userName+password+channel+userType+md5Str;
			//加密
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
			returnMap =  autoLoginCustomerIDServlet(userName,password,channel,userType,signature);
		} catch (Exception e) {
			returnMap.put("successFlag", "-1");
			returnMap.put("errMsg","登录发生异常,请联系客服!");
			returnMap.put("errCode","-1");
			e.printStackTrace();
		}
		return returnMap;
	}
	
	/*
	 * 集团跳转自动登录
	 */
	public Map autoLoginCustomerIDServlet(String userName,String password,String channel,String userType,String signature){
		YDGroupService jt = new YDGroupService();
		Map loginResult = jt.autoLogin(userName,password,channel,userType,signature);//
		return loginResult;
	}
	

//	public Map customerRegister(Map registdata) {
//	
//		Map map = new HashMap();
//		//注册时userid null
//		String userId = "";
//		String userName = registdata.get("username").toString();
//		String password =  registdata.get("password").toString();
//		String regDate = "";//注册日期
//		String email = registdata.get("email").toString();
//		String mobile =registdata.get("mobile").toString();
//		String realName = registdata.get("realName").toString();
//		String certType =registdata.get("idtype").toString();
//		String certId = registdata.get("idnumber").toString();
//		String gender = registdata.get("sex").toString();//性别
//		String birth = registdata.get("birth").toString();
//		String regAge = "";//注册年龄
//		String telephone1 ="";
//		String telephone2 ="";
//		String telephone3 = "";
//		String job1 = "";
//		String job2 = "";
//		String job3 = "";
//		String income = "";
//		String city1 = "";
//		String city2 = "";
//		String city3 = "";
//		String userStatus = "";//用户状态
//		String authStatus ="";//认证状态
//		String scisId = "";//scis号
//		String userType = "1";
//		String emailAuthFlag = "";//邮箱认证标记
//		String channel = "1";
//		String opType = "1";//操作类型 1 注册 2 已注册用户信息更新
//		PropertityUtil.init("config/pwd.properties");
//    	String md5Str = PropertityUtil.get("md5");
//		
//		String signature =userId+userName+password+regDate+email+mobile
//				+realName+certType+certId +gender+birth+regAge+telephone1+telephone2+telephone3
//				+job1+job2+job3+income+city1+city2+city3+userStatus+authStatus
//				+scisId+userType+emailAuthFlag+channel+opType+md5Str;	
//		try {
//			if(!"".equals(userName)){
//				userName = CryptoUtil.TripleDesEncode(userName);
//			}
//			if(!"".equals(userType)){
//				userType = CryptoUtil.TripleDesEncode(userType);
//			}
//			if(!"".equals(channel)){
//				channel = CryptoUtil.TripleDesEncode(channel);
//			}
//			if(!"".equals(userId)){
//				userId = CryptoUtil.TripleDesEncode(userId);
//			}
//			if(!"".equals(password)){
//				password = CryptoUtil.TripleDesEncode(password);
//			}
//			if(!"".equals(regDate)){
//				regDate = CryptoUtil.TripleDesEncode(regDate);
//			}
//			if(!"".equals(email)){
//				email = CryptoUtil.TripleDesEncode(email);
//			}
//			if(!"".equals(mobile)){
//				mobile = CryptoUtil.TripleDesEncode(mobile);
//			}
//			if(!"".equals(realName)){
//				realName = CryptoUtil.TripleDesEncode(realName);
//			}
//			if(!"".equals(certType)){
//				certType = CryptoUtil.TripleDesEncode(certType);
//			}
//			if(!"".equals(certId)){
//				certId = CryptoUtil.TripleDesEncode(certId);
//			}
//			if(!"".equals(gender)){
//				gender = CryptoUtil.TripleDesEncode(gender);
//			}
//			if(!"".equals(birth)){
//				birth = CryptoUtil.TripleDesEncode(birth);
//			}
//			if(!"".equals(regAge)){
//				regAge = CryptoUtil.TripleDesEncode(regAge);
//			}
//			if(!"".equals(telephone1)){
//				telephone1 = CryptoUtil.TripleDesEncode(telephone1);
//			}
//			if(!"".equals(telephone2)){
//				telephone2 = CryptoUtil.TripleDesEncode(telephone2);
//			}
//			if(!"".equals(telephone3)){
//				telephone3 = CryptoUtil.TripleDesEncode(telephone3);
//			}
//			if(!"".equals(job1)){
//				job1 = CryptoUtil.TripleDesEncode(job1);
//			}
//			if(!"".equals(job2)){
//				job2 = CryptoUtil.TripleDesEncode(job2);
//			}
//			if(!"".equals(job3)){
//				job3 = CryptoUtil.TripleDesEncode(job3);
//			}
//			if(!"".equals(income)){
//				income = CryptoUtil.TripleDesEncode(income);
//			}
//			if(!"".equals(city1)){
//				city1 = CryptoUtil.TripleDesEncode(city1);
//			}
//			if(!"".equals(city2)){
//				city2 = CryptoUtil.TripleDesEncode(city2);
//			}
//			if(!"".equals(city3)){
//				city3 = CryptoUtil.TripleDesEncode(city3);
//			}
//			if(!"".equals(userStatus)){
//				userStatus = CryptoUtil.TripleDesEncode(userStatus);
//			}
//			if(!"".equals(authStatus)){
//				authStatus = CryptoUtil.TripleDesEncode(authStatus);
//			}
//			if(!"".equals(scisId)){
//				scisId = CryptoUtil.TripleDesEncode(scisId);
//			}
//			if(!"".equals(emailAuthFlag)){
//				emailAuthFlag = CryptoUtil.TripleDesEncode(emailAuthFlag);
//			}
//			if(!"".equals(opType)){
//				opType = CryptoUtil.TripleDesEncode(opType);
//			}
//			signature = CryptoUtil.MD5(signature);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		map.put("userName", userName);
//		map.put("userType", userType);
//		map.put("channel", channel);
//		map.put("signature", signature);
//		map.put("userId", userId);
//		map.put("password", password);
//		map.put("regDate", regDate);
//		map.put("email", email);
//		map.put("mobile", mobile);
//		map.put("realName", realName);
//		map.put("certType", certType);
//		map.put("certId", certId);
//		map.put("gender", gender);
//		map.put("birth", birth);
//		map.put("regAge", regAge);
//		map.put("telephone1", telephone1);
//		map.put("telephone2", telephone2);
//		map.put("telephone3", telephone3);
//		map.put("job1", job1);
//		map.put("job2", job2);
//		map.put("job3", job3);
//		map.put("income", income);
//		map.put("city1", city1);
//		map.put("city2", city2);
//		map.put("city3", city3);
//		map.put("userStatus", userStatus);
//		map.put("authStatus", authStatus);
//		map.put("scisId", scisId);
//		map.put("emailAuthFlag", emailAuthFlag);
//		map.put("opType", opType);
//		CustomerManage cm = new CustomerManage();
//		Map returnMap = cm.modifyRegisterServlet(map);
//		return returnMap;
//	}
//	
	/**
	 * 注册信息修改
	 * @param request
	 * @throws Exception 
	 */
	public Map modifyRegister(HttpServletRequest request) {
		
		Map map = new HashMap();
		String userId="";
		String userName = request.getParameter("userName")==null?"":request.getParameter("userName");
		String password = request.getParameter("password")==null?"":request.getParameter("password");
		String regDate = "";
		String email = request.getParameter("email")==null?"":request.getParameter("email");
		String mobile = request.getParameter("mobile")==null?"":request.getParameter("mobile");
		String realName = request.getParameter("realName")==null?"":request.getParameter("realName");
		String certType = request.getParameter("certType")==null?"":request.getParameter("certType");
		String certId = request.getParameter("certId")==null?"":request.getParameter("certId");
		String gender = request.getParameter("gender")==null?"":request.getParameter("gender");
		String registOrupdate = request.getParameter("registOrupdate")==null?"":request.getParameter("registOrupdate");
		
		if("F".equals(gender)){
			gender="1";
		}else{
			gender="2";
		}
		String birth = request.getParameter("birth")==null?"":request.getParameter("birth");
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
		String opType = "1";//操作类型 1 注册 2 已注册用户信息更新
		if("update".equals(registOrupdate)){
			opType="2";
			userId =(String) request.getSession().getAttribute("userId");
			userName=(String) request.getSession().getAttribute("userName");
			password=(String) request.getSession().getAttribute("password");
			telephone1 = request.getParameter("telephone1")==null?"":request.getParameter("telephone1");
			city1 = request.getParameter("city1")==null?"":request.getParameter("city1");
			city2 = request.getParameter("city2")==null?"":request.getParameter("city2");
			city3 = request.getParameter("city3")==null?"":request.getParameter("city3");
	
		}
		
		PropertityUtil.init("config/pwd.properties");
    	String md5Str = PropertityUtil.get("md5");
		
		String signature =userId+userName+password+regDate+email+mobile
				+realName+certType+certId +gender+birth+regAge+telephone1+telephone2+telephone3
				+job1+job2+job3+income+city1+city2+city3+userStatus+authStatus
				+scisId+userType+emailAuthFlag+channel+opType+md5Str;

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
		return returnMap;
	}
	/**
	 * 
	 * @param userId
	 * @param userName
	 * @param userType
	 * @param channel
	 * @param signature
	 */
	public Map queryUserInfo(String userId,String userName,String userType,String channel,String signature){
		YDGroupService jt = new YDGroupService();
		Map map= jt.queryUserInfo(userId,userName,userType,channel,signature);
		return map;
	}
	
	
	public Map modifyRegisterServlet(Map map){
		Map returnMap = new HashMap();
		YDGroupService jt = new YDGroupService();
		Map customerMap = jt.modifyRegister(map);
		String rflag = customerMap.get("successFlag").toString();
		String successFlag = "2";
		if(customerMap == null){
			successFlag = "2";
		}else{
			if("0".equals(rflag)){//  成功
				successFlag = "0";
				String userid = customerMap.get("userId").toString();
				returnMap.put("userId", userid);
			}else if("-1".equals(rflag)){//失败
				successFlag = "-1";
				returnMap.put("errCode", customerMap.get("errCode"));
				returnMap.put("errMsg", customerMap.get("errMsg"));
			}else{//异常
				successFlag = "2";
				returnMap.put("errMsg", "系统错误！");
			}
		}
		returnMap.put("successFlag", successFlag);
		return returnMap;
	}

	/**
	 * session   客服调电商
	 */
	public Map sessioSynchronizedBackServlet(HttpServletRequest request ) throws Exception{
		String userId = request.getParameter("userId")==null?"":request.getParameter("userId");
		String decodeUserId = CryptoUtil.TripleDesDecode(userId);
		String userName = request.getParameter("userName")==null?"":request.getParameter("userName");
		String decodeUserName = CryptoUtil.TripleDesDecode(userName);
		//String dse_sessionId = request.getParameter("dse_sessionId")==null?"":request.getParameter("dse_sessionId");
		String signature = request.getParameter("signature")==null?"":request.getParameter("signature");
		PropertityUtil.init("config/pwd.properties");
    	String md5Str = PropertityUtil.get("md5");
		String signature_t =CryptoUtil.MD5(decodeUserId+decodeUserName+md5Str);
		System.out.println("电商userId报文："+decodeUserId);
		System.out.println("电商userName报文："+decodeUserName);
		System.out.println("电商signature报文："+signature);
		System.out.println("电商signature_t报文："+signature_t);
		Map map =new HashMap();
		if(signature_t.equals(signature)&&signature!=null){
			//String userIdFromSession = (String)request.getSession().getAttribute("userId");
			//System.out.println("decodeUserId.equals(userIdFromSession):"+decodeUserId.equals(userIdFromSession));
				request.getSession().setAttribute("userId", decodeUserId);
				map.put("key", "0");
				map.put("massage", "");
				map.put("userName", decodeUserName);
			
		}else{
			map.put("key", "1");
			map.put("massage", "同步失败");
		}
		return map;

	}
	
	/**
	 * 注册信息验证
	 */
	public String checkUserName(HttpServletRequest request){
		String userName = request.getParameter("userName")==null?"":request.getParameter("userName");
		String userType = request.getParameter("userType")==null?"":request.getParameter("userType");
		String channel = request.getParameter("channel")==null?"":request.getParameter("channel");
		String signature = userName+userType+channel;
		Map returnMap = checkUserNameServlet(userName,userType,channel,signature);
		String flag = returnMap.get("successFlag").toString();
		if("0".equals(flag)){//成功
			return "success";
		}else{
			String errCode = returnMap.get("errCode").toString();
			String errMsg = returnMap.get("errMsg").toString();
			String userDup = returnMap.get("userDup").toString();
			return "failed";
		}
	}
	public Map checkUserNameServlet(String userName,String userType,String channel,String signature){
		Map returnMap = new HashMap();
		YDGroupService jt = new YDGroupService();
		Map customerMap = jt.checkUserName(userName,userType,channel,signature);
		String rflag = customerMap.get("successFlag").toString();
		String successFlag = "2";
		if(customerMap == null){
			successFlag = "2";
		}else{
			if("0".equals(rflag)){//  成功
				successFlag = "0";
			}else if("-1".equals(rflag)){//失败
				successFlag = "-1";
				String errCode = customerMap.get("errCode").toString();
				String errMsg = customerMap.get("errMsg").toString();
				String userDup = customerMap.get("userDup").toString();
				returnMap.put("errMsg", errMsg);
				returnMap.put("errCode", errCode);
				returnMap.put("userDup", userDup);
			}else{//异常
				successFlag = "2";
			}
		}
		returnMap.put("successFlag", successFlag);
		return returnMap;
	}
//	/**
//	 * 判断账户名是否存在
//	 * @param request
//	 * @return
//	 * 			 0 --账户名不存在
//	 * 			 1 --账户名存在
//	 * 			 2 --异常
//	 */
//	public int checkCustomerID(String customerId){
//		DbAccess db = new  DbAccess();
//		List paraList = new ArrayList();
//		paraList.add(customerId);
//		String sql = "select customerid from customer where customerid=?";
//		String result[][]  = db.executeQuery(sql,paraList);//判断账户是否在本系统已注册
//		if(result == null){
//			return 2;
//		}else{
//			if(result.length == 0){//账户名不存在
//				return 0;
//			}else{
//				return 1;
//			}
//		}
//	} 
	
//	/**
//	 * 判断集团账户名是否存在
//	 * 
//	 * @param request
//	 * @return
//	 * 			 0 --账户名不存在
//	 * 			 1 --账户名存在
//	 * 			 
//	 */
//	public int checkCustomer(CustomerImpl cus){
//		Map returnMap =  checkCustomerIDService(cus);
//		if("1".equals(returnMap.get("retrunFlag"))){
//			return 1;
//		}else{
//			return 0;
//		}
//		
//	} 
//
//	
//	/*
//	 * 通过客户号查询集团客户信息
//	 * 返回帐号状态和信息
//	 */
//	public Map checkCustomerIDService(CustomerImpl cus){
//		Map returnMap = new HashMap();
//		YDGroupService jt = new YDGroupService();
//		Map customerMap = jt.customerQuery(cus);//
//		String rflag = customerMap.get("flag").toString();
//		String retrunFlag = "2";
//		if(customerMap == null){
//			retrunFlag = "2";
//		}else{
//			if("1001".equals(rflag)){//账户名存在
//				retrunFlag = "1";
//			}else if("1002".equals(rflag)||"1005".equals(rflag)){//账户名不存在
//				retrunFlag = "0";
//			}else if("1000".equals(rflag)){//异常
//				retrunFlag = "2";
//			}
//		}
//		returnMap.put("retrunFlag", retrunFlag);
//		if(customerMap != null){
//		returnMap.put("customer", customerMap.get("Customer_JT"));
//		}
//		return returnMap;
//	} 
//	
//	
	
//	/*
//	 * 插入从集团返回的客户
//	 * return 1 成功 0失败
//	 */
//	public boolean createCustomer_YG(Map m){
//		CustomerImpl ci = (CustomerImpl) m.get("Customer_JT");
//		String customerId = ci.getCUSTOMERID();
//		if(customerId.endsWith("sgcc.com.cn")||customerId.endsWith("sgcc.com")){
//			ci.setCUSTOMERTYPE("1");
//		}else{
//			ci.setCUSTOMERTYPE("0");
//		}
//		if(ci.create()){
//			ECLog.info(customerId+"同步英大e家账户成功");
//			return true;
//		}else{
//			ECLog.info(customerId+"同步英大e家账户异常");
//			return false;
//		}
//	}
//	
//	/*
//	 * 更新从集团返回的客户
//	 * return 1 成功 0失败
//	 */
//	public boolean updateCustomer_YG(Map m){
//		CustomerImpl ci = (CustomerImpl) m.get("Customer_JT");
//		String customerId = ci.getCUSTOMERID();
//		if(customerId.endsWith("sgcc.com.cn")||customerId.endsWith("sgcc.com")){
//			ci.setCUSTOMERTYPE("1");
//		}else{
//			ci.setCUSTOMERTYPE("0");
//		}
//		if(ci.update()){
//			ECLog.info(customerId+"同步英大e家账户成功");
//			return true;
//		}else{
//			ECLog.info(customerId+"同步英大e家账户异常");
//			return false;
//		}
//	}
//	
//	
//	
//	/**
//	 * 注册英大e家账户
//	 * @param request
//	 * @return
//	 * * 		-1 --系统异常
//	 * 			 0 --注册账户失败
//	 * 			 1 --注册账户成功
//	 * 			 2 --账户名已存在
//	 * 			 3 --验证码错误
//	 * 			 4 --两次密码不一致
//	 * 			 5 --密码与用户名相同
//	 */
//	public int regist(HttpServletRequest request){
//		try{
//			CustomerImpl ci = new CustomerImpl();
//			Md5 m = new Md5();
//			Map data = Data.getParameters(request);
//			String customerId  = (String) data.get("customerId");
//			String password  = (String) data.get("password");
//			String password1  =	(String) data.get("password1");
//			String rand = (String) data.get("rand");
//			String Session_img = (String) data.get("getImg2");
//			if(!rand.equalsIgnoreCase(Session_img)){//判断验证码
//				return 3;
//			}
//			if(!password.equals(password1)){
//				return 4;
//			}
//			if(customerId.equals(password)){//密码不能与注册名相同
//				return 5;
//			}
//			CustomerImpl cus =new CustomerImpl();
//			cus.setEMAIL(customerId);
//			int flag= checkCustomer(cus);
//			if(flag==0){//判断是否存在该账户名
//				String encryptPwd = m.encrypt(password);
//				ci.setCUSTOMERID(customerId);
//				ci.setPASSWORD(encryptPwd);
//				ci.setEMAIL(customerId);
//				ci.setMAKEDATE(DateAndTime.getCurrentDateTime());
//				if(customerId.endsWith("sgcc.com.cn")||customerId.endsWith("sgcc.com")){
//					ci.setCUSTOMERTYPE("1");
//				}else{
//					ci.setCUSTOMERTYPE("0");
//				}
//				int retrunFlag = 0;
//				YDGroupService jt = new YDGroupService();
//				Map customerMap = jt.customerCreate(ci);
//				if(customerMap == null){
//					retrunFlag = 0;
//				}else{
//					String rflag = customerMap.get("flag").toString();
//					if("1001".equals(rflag)){//
//						if(ci.create()){
//							request.getSession().setAttribute("CustomerID", customerId);
//							ECLog.info(customerId+"注册英大e家账户成功");
//							MailSenderUtil.sendEmail(customerId, "英大e家园会员注册", GlobalValue.registerEmail(customerId, password));
//							retrunFlag = 1;
//						}else{
//							retrunFlag = 0;
//							ECLog.info(customerId+"注册英大e家账户失败");
//						}	
//					}else {//异常
//						retrunFlag = 0;
//						ECLog.info(customerId+"注册英大e家账户失败");
//					}
//				}
//				return retrunFlag;
//			}else if(flag==1){//集团已注册
//				return 2;
//			}else{
//				return -1;
//			}
//		}catch(Exception e){ 
//			ECLog.error("注册英大e家账户出错",e);
//			return -1;
//		}
//	}
//
//	public int createCustomer(HttpServletRequest request,CustomerImpl ci){
//		if(ci.create()){
//			return 1;
//		}else{
//			return 0;
//		}
//	}
//	/**
//	 * 登录
//	 * @param request
//	 * @return
//	 * 			-1 --系统异常
//	 * 			 0 --登录失败，账户名不存在
//	 * 			 1 --登录成功
//	 * 			 2 --验证码错误
//	 *           3 --账号和密码不匹配
//	 */
//	public int login(HttpServletRequest request){
//		try{
//			Map data = Data.getParameters(request);
//			String customerId  = (String) data.get("customerId");
//			String password  = (String) data.get("password");
//			String rand = (String) data.get("rand");
//			String Session_img = (String) data.get("getImg2");
//			if(!rand.equalsIgnoreCase(Session_img)){//判断验证码
//				return 2;
//			}
//			int flag = checkCustomerID(customerId);
//			CustomerImpl cus =new CustomerImpl();
//			cus.setCUSTOMERID(customerId);
//			cus.setPASSWORD(password);
//			YDGroupService jt = new YDGroupService();
//			boolean verify_flag =jt.UserVerify(cus);
//			if(verify_flag){//判断账户名是否存在
//				cus.clear();
//				cus.setCUSTOMERID(customerId);
//				Map customerMap = jt.customerQuery(cus);//
//				CustomerImpl ci =  (CustomerImpl) customerMap.get("Customer_JT");
//				request.getSession().setAttribute("CustomerID", customerId);
//				if(flag==0){
//					ci.create();
//				}else if(flag==1){
//					ci.update();
//				}
//					return 1;
//			}else{
//					return 3;
//			}
//			
//		}catch(Exception e){
//			ECLog.error("登录出错",e);
//			return -1;
//		}
//	}
//	
//	/**
//	 * 重置密码
//	 * @param request
//	 * @return
//	 * 			-1 --系统异常
//	 * 			 0 --重置密码失败
//	 * 			 1 --重置密码成功
//	 * 			 2 --账户名不存在
//	 * 			 3 --验证码错误
//	 * 	         4 --邮件发送失败
//	 */
//	public int resetPassword(HttpServletRequest request){
//		try{
//			DbAccess db = new  DbAccess();
//			Md5 m = new Md5();
//			List paraList = new ArrayList();
//			Map data = Data.getParameters(request);
//			String customerId  = (String) data.get("customerId");
//			String rand = (String) data.get("rand");
//			String Session_img = (String) data.get("getImg2");
//			String password = "";
//			if(!rand.equalsIgnoreCase(Session_img)){//判断验证码
//				return 3;//验证码错误
//			}
//			CustomerImpl cus =new CustomerImpl();
//			cus.setCUSTOMERID(customerId);
//			Map returnMap =  checkCustomerIDService(cus);
//			
//			int tag  =  Integer.parseInt((String) returnMap.get("retrunFlag"));
//			
//			if(tag==1){//判断是否存在该账户名
//				password = setRandomPWD();
//				String encryptPwd = m.encrypt(password);
//				CustomerImpl ci = new CustomerImpl();
//				YDGroupService jt = new YDGroupService();
//				ci.setCUSTOMERID(customerId);
//				ci.setPASSWORD(encryptPwd);
//				ci.setFpsd(password);
//				Map customerMap = jt.customerUP(ci);//
//				String rflag = customerMap.get("flag").toString();
//				if("1001".equals(rflag)){//成功
//					paraList.add(encryptPwd);
//					paraList.add(customerId);
//					System.out.println(password);
//					String sql = "update customer set password = ? where customerid=?";
//					boolean flag = db.execute(sql, paraList);
//					if(flag){
//						//设密码功能需要使用国网的邮件接口，重设密码是将系统随机生成的6位随机数字发送到用户邮箱						
//						String para = GlobalValue.resetPasswordEmail(customerId, password);
//						MailSenderUtil.sendEmail(customerId,"英大e家园会员重置密码",para);
//						return 1;//修改密码成功
//					}else{
//						return 0;
//					}	
//					}else {//异常
//					return 0;//重置密码失败
//				}
//			}else if(tag==0){
//				return 2;//账户名不存在
//			}else{
//				return -1;
//			}
//		}catch(Exception e){ 
//			ECLog.error("重置密码出错",e);
//			return -1;
//		}
//	}
//	
//	/**
//	 * 修改密码
//	 * @param request
//	 * @return
//	 * 			-1 --系统异常
//	 * 			 0 --修改失败
//	 * 			 1 --修改成功
//	 * 			 2 --原始密码错误
//	 * 			 3 --新密码与原始密码一致
//	 * 			 4 --验证码错误
//	 *			 5 --密码与用户名相同
//	 */
//	public int setPassword(HttpServletRequest request){
//		try{
//			DbAccess db = new  DbAccess();
//			List paraList = new ArrayList();
//			Md5 m = new Md5();
//			Map data = Data.getParameters(request);
//			String id = null;
//			String customerId  = (String) data.get("CustomerID");
//			String oldpassword = (String) data.get("oldpassword");
//			String newpassword = (String) data.get("newpassword");
//			String rand = (String) data.get("rand");
//			String Session_img = (String) data.get("getImg2");
//			if(!rand.equalsIgnoreCase(Session_img)){//判断验证码
//				return 4;
//			}
//			if(newpassword.equals(oldpassword)){
//				return 3;
//			}
//			if(newpassword.equals(customerId)){
//				return 5;
//			}
//			paraList.add(customerId);
//			String sql = "select id,password from customer where customerid=?";
//			String result[][]  = db.executeQuery(sql,paraList);//查询该登录名的ID
//			id = result[0][0];
//			CustomerImpl cus =new CustomerImpl();
//			cus.setCUSTOMERID(customerId);
//			cus.setPASSWORD(oldpassword);
//			YDGroupService jt = new YDGroupService();
//			boolean verify_flag =jt.UserVerify(cus);
//			if(verify_flag){//判断原始密码是否正确
//				String newencryptPwd = m.encrypt(newpassword);
//				cus.clear();
//				cus.setID(id);
//				cus.setPASSWORD(newencryptPwd);
//				cus.setCUSTOMERID(customerId);
//				cus.setFpsd(newpassword);
//				Map customerMap2 = jt.customerUP(cus);//更新集团客户密码信息
//				String rflag = customerMap2.get("flag").toString();
//				if("1001".equals(rflag)){
//					//修改本地库
//					if(cus.update()){
//						return 1;
//					}else{
//						return 0;
//					}
//				}else {
//					return 0;//修改密码失败
//				}
//			}else{
//				return 2;	
//			}
//		}catch(Exception e){ 
//			ECLog.error("修改个人信息出错",e);
//			return -1;
//		}
//			
//	}
//	
//	/**
//	 * 修改个人信息
//	 * @param request
//	 * @return
//	 * 			-1 --系统异常
//	 * 			 0 --修改失败
//	 * 			 1 --修改成功(邮箱已修改)
//	 * 			 2 --修改成功(邮箱未修改)
//	 * 			 3 --账户名已存在
//	 * 			 4 --验证码错误
//	 *           5 --邮件发送失败
//	 */
//	public int updateInfo(HttpServletRequest request){
//		try{
//			CustomerImpl ci = new CustomerImpl();
//			DbAccess db = new  DbAccess();
//			List paraList = new ArrayList();
//			Map data = Data.getParameters(request);
//			String id = null;
//			String customerId  = (String) data.get("CustomerID");
//			String email  = (String) data.get("email");
//			String telephone  = (String) data.get("telephone");
//			String province  = (String) data.get("province");
//			String city  = (String) data.get("city");
//			String county  = (String) data.get("county");
//			String address  = (String) data.get("address");
//			String zipcode  = (String) data.get("zipcode");
//			String rand = (String) data.get("rand");
//			String Session_img = (String) data.get("getImg2");
//			if(!rand.equalsIgnoreCase(Session_img)){//判断验证码
//				return 4;
//			}
//			paraList.add(customerId);
//			String sql = "select id ,email from customer where customerid=?";
//			String result[][]  = db.executeQuery(sql,paraList);//查询该登录名的ID
//			id = result[0][0];
//			//更新个人信息
//			ci.setID(id);
//			ci.setCUSTOMERID(customerId);
//			ci.setMOBILE(telephone);
//			ci.setPROVINCE(province);
//			ci.setCITY(city);
//			ci.setCOUNTY(county);
//			ci.setADDRESS(address);
//			ci.setZIPCODE(zipcode);
//			ci.setEMAIL(email);
//			ci.setMODIFYDATE(DateAndTime.getCurrentDate());			
//			if(email.equals(result[0][1])){//判断邮箱地址是否修改				
//				YDGroupService jt = new YDGroupService();
//				Map customerMap2 = jt.customerUP(ci);//更新集团客户
//				String rflag = customerMap2.get("flag").toString();
//				if("1001".equals(rflag)){//
//					if(ci.update()){
//						request.getSession().setAttribute("CustomerID", customerId);
//						return 2;
//					}else{
//						return 0;
//					}
//				}else {//异常
//					return 0;
//				}
//			}else{
//				CustomerImpl cus =new CustomerImpl();
//				cus.setEMAIL(email);
//				int email_flag =checkCustomer(cus);
//				if(email_flag==0){//判断是否存在该账户名
//					ci.setCUSTOMERID(customerId);
//					YDGroupService jt = new YDGroupService();
//					Map customerMap2 = jt.customerUP(ci);//更新集团客户信息
//					String rflag = customerMap2.get("flag").toString();
//					if("1001".equals(rflag)){	
//						if(ci.update()){
//							request.getSession().setAttribute("CustomerID", customerId);
//							//修改个人信息功能需要使用国网的邮件接口，修改个人信息是将新用户名发送到用户邮箱
//							String para = GlobalValue.renameEmail(email);
//							MailSenderUtil.sendEmail(email,"英大e家园会员修改邮箱",para);
//							//修改本地库
//							return 2;
//						}else{
//							return 0;
//						}	
//					}else {//异常
//						return 0;
//					}
//				}else if(email_flag==1){
//					return 3;
//				}else{
//					return -1;
//				}
//			}
//		}catch(Exception e){ 
//			ECLog.error("修改个人信息出错",e);
//			return -1;
//		}
//	}
//	
	/**
	 * 生成随机6位数密码
	 * @param request
	 * @return
	 */
	public static String setRandomPWD(){
		Random r = new Random();
		String x = "";
		while(x.length()<6){
			int i = r.nextInt(10);
			x = x + String.valueOf(i);
		}
		return x;
	}
	
}
