package cn.com.sinosoft.web.msl.sales;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.common.OrderHelper;
import cn.com.sinosoft.domain.sale.GeApplicantInsured;
import cn.com.sinosoft.domain.sale.GeChannel;
import cn.com.sinosoft.domain.sale.GeCommonApplicant;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.domain.system.GeDepartment;
import cn.com.sinosoft.domain.yinbaotongWAB.BaseInfo;
import cn.com.sinosoft.domain.yinbaotongWAB.LCAppnt;
import cn.com.sinosoft.domain.yinbaotongWAB.LCBnf;
import cn.com.sinosoft.domain.yinbaotongWAB.LCBnfs;
import cn.com.sinosoft.domain.yinbaotongWAB.LCCont;
import cn.com.sinosoft.domain.yinbaotongWAB.LCInsured;
import cn.com.sinosoft.domain.yinbaotongWAB.Risk;
import cn.com.sinosoft.ess.config.service.GeDepartmentService;
import cn.com.sinosoft.ess.product.service.CodeTurnBankService;
import cn.com.sinosoft.ess.product.service.CommonApplicantService;
import cn.com.sinosoft.msl.service.InsurePolicyService;
import cn.com.sinosoft.sale.service.ChannelService;
import cn.com.sinosoft.sale.service.OrderService;
import cn.com.sinosoft.sale.service.JobCodeService;
import cn.com.sinosoft.util.RXAKLongPolicyUtil;
import cn.com.sinosoft.web.msl.BaseAction;
import cn.com.sinosoft.web.service.facade.GeGeographicalAreafindService;
import cn.com.sinosoft.web.service.facade.IdPhotoDataService;
import cn.com.sinosoft.web.service.impl.WeiXinServiceImpl;
import cn.com.sinosoft.domain.user.IdPhotoData;


@ParentPackage(value = "ECS-STRUTS")
public class RXAKPolicyAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;

	public static Logger logger = LoggerFactory.getLogger(RXAKPolicyAction.class);
	
	private static Properties pro = new Properties();
	
	private static Properties pro1 = new Properties();
	
	private static Properties pro2 = new Properties();
	
	@Autowired
	private JobCodeService JobCodeService;
	
	@Autowired
	GeGeographicalAreafindService GeGeographicalAreafindService;
	
	@Autowired
	private InsurePolicyService insurePolicyService;
	
	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private CodeTurnBankService CodeTurnBank;
	
	@Autowired
	private IdPhotoDataService IdPhotoDataService;
	
	private GeApplicantInsured applicantInsured;//投保人
	
	private GeApplicantInsured recognizee;//被保人
	
	private GePolicy policy;//保单

	private GeOrder order;//订单
	
	private GeCommonApplicant commonApplicant;//常用投保人
	
	private IdPhotoData idPhotoData;		//证件照数据

	private LCBnf lcbnf;	//受益人1
	
	private LCBnf lcbnf2;	//受益人2

	private LCBnf lcbnf3;	//受益人3

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	private static SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy年MM月dd日");
	
	private static SimpleDateFormat dateLine = new SimpleDateFormat("yyyy-MM-dd");
	
	private static SimpleDateFormat uploadate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static DecimalFormat df = new DecimalFormat("######0.00"); 
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	CommonApplicantService cas;
	
	@Autowired
	private GeDepartmentService depser;
	
	static{
		try {
			pro.load(new InputStreamReader(RXAKPolicyAction.class.getResourceAsStream("/config/SecondPeriod.properties"), "UTF-8"));
			pro1.load(new InputStreamReader(RXAKPolicyAction.class.getResourceAsStream("/config/DepartmentAddress.properties"), "UTF-8"));
			pro2.load(new InputStreamReader(RXAKPolicyAction.class.getResourceAsStream("/config/App.properties"), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 加载瑞享安康首页
	 * @return
	 */
	@Action(value = "RXAKHomePage", results = {
		@Result(name="success", location="/WEB-INF/jsp/page/RXAKpolicy/index.jsp"),
		@Result(name="error", location="/WEB-INF/jsp/page/RXAKpolicy/error.jsp")
		}) 
	public String loadHomePage (){
		//String openId =null;
		String openId = "oipGbs6aOJCQcO0jGszXYVdAmp_I";
//		String openId ="RXAK";		//测试
		HttpSession session  = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("openId")!=null){
			openId = (String)session.getAttribute("openId");
		}
		if(openId==null||openId.length()==0){
			openId=WeiXinServiceImpl.getOpenId(request);
		}
		String brNo = request.getParameter("brNo");
		if(brNo==null||brNo.length()==0){
			brNo="A0000";
		}
		String imgUrl=null;
		GeChannel channel = channelService.findChannel(brNo,"RUIXANKANG");
		if(channel!=null){
			imgUrl =channel.getImgUrl();
		}else{
			channel = channelService.findChannel("A0000","RUIXANKANG");
			if(null != channel){
				imgUrl = channel.getImgUrl();
			}
		}
		if(null != imgUrl && imgUrl.contains("picture")){
			imgUrl = imgUrl.substring(imgUrl.indexOf("picture"));
		}
		session.setAttribute("channel", channel);
		request.setAttribute("imgUrl",  imgUrl);
		logger.info("瑞享安康首页加载## openId:"+openId+"合作伙伴代码:"+brNo+" 产品图片地址："+imgUrl);
		if(openId!=null&&openId.length()>0){
			session.setAttribute("brNo", brNo);//将获取的realBrNo(渠道编码)放置seesion域中
			session.setAttribute("openId", openId);//将获取的openId放置seesion域中
			try {
				resultBusiness(true);
			} catch (Exception e) {
				logger.info(e.getMessage());
				logger.error(ExceptionUtils.getStackTrace(e));
				e.printStackTrace();
				resultBusiness(false, "9000","系统异常");
				return ERROR;
			}
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	
	/**
	 * 瑞享安康试算保费
	 * @return
	 */
	@Action(value = "RXAKPolicyCalculate", results = {
			@Result(name="success",type="json"),
			@Result(name="fail",type="json")
			})
	public String policyPolicyCalculate(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) ServletActionContext.getRequest().getSession().getAttribute("openId");//取openId
		try {
			//取值
			String birthday = sdf.format(recognizee.getBirthday()); //被保人生日 
			String sex = recognizee.getSex();	//被保人性别
			String amnt = df.format(policy.getSumamount());   //保额
			String PayEndYear  =  policy.getPayYear(); //缴费期间 趸交 3 5 10 20
			String age = request.getParameter("age"); //被保人年龄
			String RelaToAppnt = null; //投被保人关系
			if(Integer.parseInt(age)<18){
				RelaToAppnt = "PA";
			}else{
				RelaToAppnt = "SF";
			}
			String brNo = (String)session.getAttribute("brNo");
			if(brNo==null||brNo.length()==0){
				brNo="A0000";
			}
			//调用银保通试算接口
			String sumpremium = RXAKLongPolicyUtil.calculate(birthday, sex, amnt,pro.getProperty("yinbaotong"),brNo, PayEndYear,RelaToAppnt);
			if(sumpremium.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")){//如果算出保费
				policy.setSumbasepremium(Double.valueOf(sumpremium));//将总保费赋值给保单实体
				session.setAttribute("age", age);//年龄存入session,填写信息页使用
				logger.info("瑞享安康试算保费成功，投保人生日"+birthday+"##"+sumpremium+"##openId:"+openId+"合作伙伴代码:"+brNo);
			}else{
				if(sumpremium.contains("保费超限")){
					policy.setSumbasepremium(0.001);//保费超限标识
				}
				if(sumpremium.contains("需要体检")){
					policy.setSumbasepremium(0.002);//需要体检标识
				}
				logger.info("瑞享安康试算保费失败：投保人生日"+birthday+"##"+sumpremium+"##openId:"+openId+"合作伙伴代码:"+brNo);
			}
		} catch (Exception e) {
			logger.error("瑞享安康试算保费方法异常"+openId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 点击投保进入信息录入页
	 * @return
	 */
	@Action(value = "rxakFill", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/RXAKpolicy/fillinfo.jsp"),
			@Result(name="error", location="/WEB-INF/jsp/page/RXAKpolicy/error.jsp")
			})
	public String fill(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try {
			session.setAttribute("index_policy", policy);//保额保费
			session.setAttribute("index_recognizee", recognizee);//首页被保人数据 生日 性别
			String sex = textChange(recognizee.getSex(),"sex");
			String birthday = dateLine.format(recognizee.getBirthday());
			if(openId!=null && openId.length()>0){
				List<GeCommonApplicant> comAppList = cas.findComApplicantListByOpenId(openId);
					if(comAppList!=null){
						request.setAttribute("comAppList", comAppList);//常用投保人
					}
			}
			GeChannel channel = (GeChannel) session.getAttribute("channel");
			if(null != channel){
				request.setAttribute("isAgentCode", channel.getIsAgentcode());//推荐人是否必填
			}
			session.setAttribute("sex", sex);//性别
			session.setAttribute("birthday", birthday);//生日
			logger.info("瑞享安康点击立即投保按钮进去录入信息页成功");
			resultBusiness(true);
		} catch (Exception e) {
			logger.error("瑞享安康点击投保方法异常:"+openId+":"+ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 录入信息后加载到确认页面
	 * @return
	 */
	@Action(value = "RXAKInsureInput", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/RXAKpolicy/confirminfo.jsp"),
			@Result(name="error", location="/WEB-INF/jsp/page/RXAKpolicy/error.jsp")
			})
	public String insureInput(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try {
			String recognizee_age = (String) session.getAttribute("age"); //被保人年龄
			String lCBnfCount = request.getParameter("lCBnfCount");
			policy.setlCBnfCount(lCBnfCount);
			if(Integer.parseInt(recognizee_age) < 18){ //小于18岁 投被保人 不是同一人
				String recognizee_industry = request.getParameter("recognizee_industry");
				String recognizee_job = request.getParameter("recognizee_job");
				String recognizee_province = request.getParameter("recognizee_province");
				String recognizee_city = request.getParameter("recognizee_city");
				String recognizee_jobCode = JobCodeService.findJobCode(recognizee_industry, recognizee_job,"WENJIABAO");	//职业编码
				logger.info("瑞享安康被保人职业编码转换成功,openId:"+openId+"--行业:"+recognizee_industry+"--职业:"+recognizee_job+"--职业编码:"+recognizee_jobCode);
				session.setAttribute("recognizee_jobCode", recognizee_jobCode);
				session.setAttribute("recognizee_province", recognizee_province);
				session.setAttribute("recognizee_city", recognizee_city);
			}
			String applicantInsured_industry = request.getParameter("applicantInsured_industry");
			String applicantInsured_job = request.getParameter("applicantInsured_job");
			String applicantInsured_province = request.getParameter("applicantInsured_province");
			String applicantInsured_city = request.getParameter("applicantInsured_city");
			String applicantInsured_jobCode = JobCodeService.findJobCode(applicantInsured_industry, applicantInsured_job,"WENJIABAO");
			logger.info("瑞享安康投保人职业编码转换成功,openId:"+openId+"--行业:"+applicantInsured_industry+"--职业:"+applicantInsured_job+"--职业编码:"+applicantInsured_jobCode);
			session.setAttribute("applicantInsured_jobCode", applicantInsured_jobCode);
			session.setAttribute("applicantInsured_province", applicantInsured_province);
			session.setAttribute("applicantInsured_city", applicantInsured_city);
			//指定受益人部分
			if("3".equals(policy.getIslegalflag())){
				System.out.println(policy.getlCBnfCount());
				logger.info("瑞享安康,openId:"+openId+"--受益人类型:"+policy.getIslegalflag()+"--受益人个数:"+policy.getlCBnfCount());
				String lCBnf_industry = request.getParameter("lCBnf_industry");
				String lCBnf_job = request.getParameter("lCBnf_job");
				String lCBnf_province = request.getParameter("lCBnf_province");
				String lCBnf_city = request.getParameter("lCBnf_city");
				String lCBnf_jobCode = JobCodeService.findJobCode(lCBnf_industry, lCBnf_job,"WENJIABAO");
				logger.info("瑞享安康受益人一职业编码转换成功,openId:"+openId+"--行业:"+lCBnf_industry+"--职业:"+lCBnf_job+"--职业编码:"+lCBnf_jobCode);
				session.setAttribute("lCBnf_jobCode", lCBnf_jobCode);
				session.setAttribute("lCBnf_province", lCBnf_province);
				session.setAttribute("lCBnf_city", lCBnf_city);
				if("2".equals(policy.getlCBnfCount())){
					String lCBnf2_industry = request.getParameter("lCBnf2_industry");
					String lCBnf2_job = request.getParameter("lCBnf2_job");
					String lCBnf2_province = request.getParameter("lCBnf2_province");
					String lCBnf2_city = request.getParameter("lCBnf2_city");
					String lCBnf2_jobCode = JobCodeService.findJobCode(lCBnf2_industry, lCBnf2_job,"WENJIABAO");
					logger.info("瑞享安康受益人二职业编码转换成功,openId:"+openId+"--行业:"+lCBnf2_industry+"--职业:"+lCBnf2_job+"--职业编码:"+lCBnf2_jobCode);
					session.setAttribute("lCBnf2_jobCode", lCBnf2_jobCode);
					session.setAttribute("lCBnf2_province", lCBnf2_province);
					session.setAttribute("lCBnf2_city", lCBnf2_city);
				}
				if("3".equals(policy.getlCBnfCount())){
					String lCBnf2_industry = request.getParameter("lCBnf2_industry");
					String lCBnf2_job = request.getParameter("lCBnf2_job");
					String lCBnf2_province = request.getParameter("lCBnf2_province");
					String lCBnf2_city = request.getParameter("lCBnf2_city");
					String lCBnf2_jobCode = JobCodeService.findJobCode(lCBnf2_industry, lCBnf2_job,"WENJIABAO");
					logger.info("瑞享安康受益人二职业编码转换成功,openId:"+openId+"--行业:"+lCBnf2_industry+"--职业:"+lCBnf2_job+"--职业编码:"+lCBnf2_jobCode);
					session.setAttribute("lCBnf2_jobCode", lCBnf2_jobCode);
					session.setAttribute("lCBnf2_province", lCBnf2_province);
					session.setAttribute("lCBnf2_city", lCBnf2_city);
					String lCBnf3_industry = request.getParameter("lCBnf3_industry");
					String lCBnf3_job = request.getParameter("lCBnf3_job");
					String lCBnf3_province = request.getParameter("lCBnf3_province");
					String lCBnf3_city = request.getParameter("lCBnf3_city");
					String lCBnf3_jobCode = JobCodeService.findJobCode(lCBnf3_industry, lCBnf3_job,"WENJIABAO");
					logger.info("瑞享安康受益人三职业编码转换成功,openId:"+openId+"--行业:"+lCBnf3_industry+"--职业:"+lCBnf3_job+"--职业编码:"+lCBnf3_jobCode);
					session.setAttribute("lCBnf3_jobCode", lCBnf3_jobCode);
					session.setAttribute("lCBnf3_province", lCBnf3_province);
					session.setAttribute("lCBnf3_city", lCBnf3_city);
				}
			}
			if(commonApplicant!=null){
			//如果是常用被保人
				if(commonApplicant.getFlag().equals("on")){
					commonApplicant.setOpenid(openId);
					commonApplicant.setName(applicantInsured.getName());
					commonApplicant.setIdtype(applicantInsured.getIdentifytype());
					commonApplicant.setIdno(applicantInsured.getIdentifynumber());
					commonApplicant.setSex(applicantInsured.getSex());
					commonApplicant.setBirthday(applicantInsured.getBirthday());
					commonApplicant.setMobile(applicantInsured.getMobile());
					commonApplicant.setEmail(applicantInsured.getEmail());
					commonApplicant.setFlag("1");
					session.setAttribute("commonApplicant", commonApplicant);
				}
			}
			session.setAttribute("policy", policy);			
			session.setAttribute("applicantInsured", applicantInsured);
			session.setAttribute("recognizee", recognizee);
			session.setAttribute("idPhotoData", idPhotoData);
			session.setAttribute("lcbnf", lcbnf);
			session.setAttribute("lcbnf2", lcbnf2);
			session.setAttribute("lcbnf3", lcbnf3);
			logger.info(openId+"：瑞享安康提交个人信息成功");
		} catch (Exception e) {
			logger.error("瑞享安康提交个人信息方法异常"+openId+"："+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 * 瑞享安康跳转到告知页面
	 * @return
	 */
	@Action(value = "RXAKtoNotice", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/RXAKpolicy/notice.jsp"),
			@Result(name="error", location="/WEB-INF/jsp/page/RXAKpolicy/error.jsp")
			})
	public String toNotice(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try {
			logger.info(openId+"：瑞享安康告知标识成功");
			resultBusiness(true);
		} catch (Exception e) {
			logger.error("瑞享安康告知方法异常"+openId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 跳转人工核保告知页
	 * @return
	 */
	@Action(value = "RXAKToBankSuccess", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/RXAKpolicy/bankSuccess.jsp"),
			@Result(name="fail", location="/WEB-INF/jsp/page/RXAKpolicy/error.jsp")
			})
	public String toBankSuccess(){
		//取openId
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		String ordercode = (String)session.getAttribute("ordercode");
			try{
				GeOrder order = orderService.getOrderByOrderCode(ordercode);//从库里取出订单实体
				String productname = order.getProductname();//产品名称
				String orderamount = df.format(order.getOrderamount());//订单金额
				String paydate = dateSdf.format(new Date());//支付日期
				request.setAttribute("productname", productname);
				request.setAttribute("orderamount", orderamount);
				request.setAttribute("paydate", paydate);
				logger.info("瑞享安康跳转人工核保告知页成功，openId:"+openId+",订单号:"+ordercode);
				return SUCCESS;
			}catch (Exception e) {
				logger.error("瑞享安康跳转人工核保告知页异常，openId:"+openId+",订单号:"+ordercode);
				e.printStackTrace();
				return ERROR;
			}
	}
	
	/**
	 * 提交核保(点击下一步)
	 * @return
	 */
	@Action(value = "RXAKinsureSubmit")
	public void insureSubmit(){
		String resultsjon = null;
		String deptid = null;
		String ActyNo = "";
		String recognizee_province_code = null;
		String recognizee_city_code = null;
		String recognizee_jobCode = null;//被保人职业编码
		String recognizee_name = null;   //被保人姓名
		String recognizee_adress = null; //被保人详细地址
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try {
			logger.info("瑞享安康开始进行核保，openId:"+openId);
			GePolicy index_policy = (GePolicy)session.getAttribute("index_policy"); //首页保额 保费
			GeApplicantInsured index_recognizee = (GeApplicantInsured)session.getAttribute("index_recognizee");//首页实体：被保人生日性别
			GeCommonApplicant comapp = (GeCommonApplicant)session.getAttribute("commonApplicant");  //常用投保人
			GePolicy policy = (GePolicy)session.getAttribute("policy");  //保单
			GeApplicantInsured applicantInsured = (GeApplicantInsured)session.getAttribute("applicantInsured"); //投保人
			GeApplicantInsured recognizee = (GeApplicantInsured)session.getAttribute("recognizee");	//被保人
			IdPhotoData idPhotoData =  (IdPhotoData)session.getAttribute("idPhotoData");	//证件照
			LCBnf lcbnf =  (LCBnf)session.getAttribute("lcbnf"); //受益人
			LCBnf lcbnf2 =  (LCBnf)session.getAttribute("lcbnf2");
			LCBnf lcbnf3 =  (LCBnf)session.getAttribute("lcbnf3");
			String brNo = (String)session.getAttribute("brNo");
			String recognizee_age = (String)session.getAttribute("age");
			String applicantInsured_jobCode = (String) session.getAttribute("applicantInsured_jobCode");
			String applicantInsured_province = (String) session.getAttribute("applicantInsured_province");
			String applicantInsured_city = (String) session.getAttribute("applicantInsured_city");
			String applicantInsured_province_code = GeGeographicalAreafindService.findArea_code(applicantInsured_province, "1");
			String applicantInsured_city_code = GeGeographicalAreafindService.findArea_code(applicantInsured_city, "2");
			String applicantInsured_adress = applicantInsured.getAddress().replaceFirst(applicantInsured_province+applicantInsured_city,"");
			if(Integer.parseInt(recognizee_age)<18){
				recognizee_jobCode = (String) session.getAttribute("recognizee_jobCode");
				String recognizee_province = (String) session.getAttribute("recognizee_province");
				String recognizee_city = (String) session.getAttribute("recognizee_city");
				recognizee_province_code = GeGeographicalAreafindService.findArea_code(recognizee_province, "1");
				recognizee_city_code = GeGeographicalAreafindService.findArea_code(recognizee_city, "2");
				recognizee_name = recognizee.getName();
				recognizee_adress = recognizee.getAddress().replaceFirst(recognizee_province+recognizee_city,"");
				recognizee.setIdentifynumber(recognizee.getIdentifynumber());
				recognizee.setIdentifytype(recognizee.getIdentifytype());
				recognizee.setName(recognizee_name);
				recognizee.setFlag("2");//被保人
				recognizee.setInsrelationapp("3");//被保人与投保人关系本人   3子女
				applicantInsured.setInsrelationapp("B");//投保人与被保人关系本人
			}else{
				recognizee_province_code = applicantInsured_province_code;
				recognizee_city_code = applicantInsured_city_code;
				recognizee_jobCode = applicantInsured_jobCode;
				recognizee_name = applicantInsured.getName();
				recognizee_adress = applicantInsured.getAddress().replaceFirst(applicantInsured_province+applicantInsured_city,"");
				recognizee.setIdentifynumber(applicantInsured.getIdentifynumber());
				recognizee.setIdentifytype(applicantInsured.getIdentifytype());
				recognizee.setName(recognizee_name);
				recognizee.setFlag("2");//被保人
				recognizee.setInsrelationapp("8");//被保人与投保人关系本人   8本人
				applicantInsured.setInsrelationapp("1");//投保人与被保人关系本人
			}
			if(null == brNo || "A0000".equals(brNo)){
				//截取推荐人编码作为渠道
				brNo = LongPolicyAction.subCode(policy.getAgentcode());
			}
			if(brNo==null||brNo.length()==0){
				String deptidhHead = policy.getDeptid();
				if(deptidhHead!=null&&deptidhHead.length()>0){
					deptid = depser.findDepart(deptidhHead).getDeptid(); //加入机构代码
				}else{
					deptid =depser.findRootDepart().getDeptid();
				}
			}else if(brNo=="A0000"){
				deptid =depser.findRootDepart().getDeptid();
			}else{
				boolean depFlag = depser.findByDeptCode(brNo.substring(0,2).toUpperCase());
				if(depFlag){
					deptid = depser.findDepart(brNo.substring(0,2).toUpperCase()).getDeptid();
				}else{
					deptid =depser.findRootDepart().getDeptid();
				}
			}
			policy.setLCAProvince(applicantInsured_province_code);
			policy.setLCACity(applicantInsured_city_code);
			policy.setBrNo(brNo);
			policy.setLCIProvince(recognizee_province_code);
			policy.setLCICity(recognizee_city_code);
			policy.setJobFlag("N");				//职业标识
			policy.setJobCode(recognizee_jobCode);			//被保人职业编码
			policy.setPayYear(index_policy.getPayYear());			//交费期间 10 20
			policy.setPayYeartag("4");	//缴费年期年龄标志  2:缴至某确定年龄  4:年缴 
			policy.setPolicyterm("106"); 	//保障期限	至70/75/80/100岁     
			policy.setOpenid(openId);
			policy.setDeptid(deptid);
			policy.setSumamount(index_policy.getSumamount());//取保额
			policy.setSumbasepremium(index_policy.getSumbasepremium());//取保费
			policy.setMainpolicypre(index_policy.getMainpolicypre());
			policy.setAdditionalpolicypre(index_policy.getAdditionalpolicypre());
			policy.setInsuretime(new Date());//投保时间
			policy.setSource("RUIXANKANG");
			policy.setProdoctcode("RUIXANKANG");//产品编号
			policy.setRiskcode("RUIXANKANG");//险种代码
			policy.setOriginate("0");//官网直销
			policy.setApplicantname(applicantInsured.getName());//投保人姓名
			policy.setApplicantaddress(applicantInsured.getAddress());//投保人地址
			policy.setInsuredname(recognizee_name);//被保人姓名
			policy.setClasscode("1");//1代表主险
			policy.setPolicytermtype("年");
			policy.setProductname("瑞泰瑞享安康重大疾病保险");
			policy.setCondition("0");//未对账
			policy.setIslegalflag(policy.getIslegalflag());// 受益人 2法定  3指定
			policy.setAgentcode(policy.getAgentcode()==null?"":policy.getAgentcode().toUpperCase());//推荐人码
			policy.setPreferentialcode(policy.getPreferentialcode()==null?"":policy.getPreferentialcode().toUpperCase());//优惠码
			
			recognizee.setBirthday(index_recognizee.getBirthday());
			recognizee.setSex(index_recognizee.getSex());
			applicantInsured.setFlag("1");//投保人
			applicantInsured.setSex(applicantInsured.getSex());
			Set<GeApplicantInsured> applicantInsureds = new HashSet<GeApplicantInsured>();
			applicantInsureds.add(recognizee);
			applicantInsureds.add(applicantInsured);
			
			//银行编码转银行名称存库
			String bankBranchCode = request.getParameter("policy_bank");
			policy.setBankBranchCode(bankBranchCode);
			String bankAccountNumber = request.getParameter("policy_bankAccountNumber");
			policy.setBankAccountNumber(bankAccountNumber);
			String policy_bankProvince = request.getParameter("policy_bankProvince");
			policy.setBankProvince(policy_bankProvince);
			String policy_bankCity = request.getParameter("policy_bankCity");
			policy.setBankCity(policy_bankCity);
			if(bankBranchCode!=null&&bankBranchCode.length()>=0){
				String bank = CodeTurnBank.codeTurnbank(bankBranchCode);
				policy.setBank(bank);
			}
			
			//核保
			LCCont lCCont = new LCCont();
			if(bankAccountNumber!=null&&bankAccountNumber.length()>0){//如果存在续保
				lCCont.setBankAccNo(bankAccountNumber);
				lCCont.setRenewalPermit("Y");
			}else{
				lCCont.setAccBankCode("MSG01");//渠道编码
			}
			//银行代扣部分
			lCCont.setBankProvince(policy.getBankProvince());
			lCCont.setBankCity(policy.getBankCity());
			lCCont.setBillingType("Y");//是否银行代扣
			lCCont.setAccBankCode(bankBranchCode);//银行编码
			lCCont.setAccName(applicantInsured.getName());
			Risk risk = new Risk();//被保险人险种信息
			risk.setCValiDate("");//生效日期
			risk.setAmnt(df.format(policy.getSumamount()));//保额
			risk.setPrem(df.format(policy.getSumbasepremium()));//保费
			risk.setBeneficiaryIndicator("2".equals(policy.getIslegalflag())?"Y":"N");   //受益人2法定Y  3指定N
		
			LCInsured lCInsured = new LCInsured();//被保人信息
			lCInsured.setName(recognizee_name);//被保人姓名
			lCInsured.setBirthday(sdf.format(recognizee.getBirthday()));//被保人生日
			lCInsured.setSex(recognizee.getSex());//被保人性别
			lCInsured.setIDType(recognizee.getIdentifytype());//被保人证件类型
			lCInsured.setIDNo(recognizee.getIdentifynumber());//被保人证件号、
			lCInsured.setAddressState(policy.getLCAProvince()); //被保人省编码
			lCInsured.setCity(policy.getLCACity()); //被保人市编码
			lCInsured.setHomeAddress(recognizee_adress);//被保险人家庭详细地址
			lCInsured.setJobCode(recognizee_jobCode);	//被保人职业编码
			lCInsured.setEmail(recognizee.getEmail());
			lCInsured.setInsuredMobile(recognizee.getMobile());
			LCAppnt lcAppnt = new LCAppnt();//投保人信息
			if(Integer.parseInt(recognizee_age)<18){
				lCInsured.setIDExpDate(textChange(idPhotoData.getRecognizee_endTime(), "idNoEndTime") );
				lCInsured.setRelaToAppnt("PA");//与投保人关系(父母)
				lcAppnt.setRelaToInsured("PA");//与被保人关系(父母)
				lCInsured.setAppntInsuredSame("N");//投被保人是否同一人
			}else{
				lCInsured.setIDExpDate(textChange(idPhotoData.getApplicantInsured_endTime(), "idNoEndTime"));
				lCInsured.setRelaToAppnt("SF");//与投保人关系(本人)
				lcAppnt.setRelaToInsured("SF");//与被保人关系(本人)
				lCInsured.setAppntInsuredSame("Y");//投被保人是否同一人
			}
			
			lcAppnt.setAppntName(applicantInsured.getName());//投保人姓名
			lcAppnt.setAppntSex(applicantInsured.getSex());//投保人性别
			lcAppnt.setAppntIDType(applicantInsured.getIdentifytype());//投保人证件类型
			lcAppnt.setAppntIDNo(applicantInsured.getIdentifynumber());//投保人证件号
			lcAppnt.setAppntBirthday(sdf.format(applicantInsured.getBirthday()));//投保人生日
			lcAppnt.setAppntMobile(applicantInsured.getMobile());//投保人手机
			lcAppnt.setEmail(applicantInsured.getEmail());//投保人邮箱
			lcAppnt.setHomeAddress(applicantInsured_adress);//投保人详细地址
			lcAppnt.setAddressState(applicantInsured_province_code); //投保人省编码
			lcAppnt.setCity(applicantInsured_city_code);	//投保人市编码
			lcAppnt.setJobCode(applicantInsured_jobCode);	//投保人职业编码
			lcAppnt.setIDExpDate(textChange(idPhotoData.getApplicantInsured_endTime(), "idNoEndTime"));
			
			BaseInfo baseInfo = new BaseInfo();
			baseInfo.setZoneNo("MSG01");//渠道编码
			baseInfo.setBrNo(brNo);//推荐码
			baseInfo.setActyNo(ActyNo);
			//受益人
			LCBnfs lcbnfs = new LCBnfs();
			List<LCBnf> lCBnf = new ArrayList<LCBnf>();
			if("2".equals(policy.getIslegalflag())){//法定受益人
				lcbnfs.setLCBnfCount("0");
			}else if("3".equals(policy.getIslegalflag())){//指定受益人
				LCBnf lbf1 = new LCBnf();
				lcbnfs.setLCBnfCount(policy.getlCBnfCount());
				//受益人信息
				String lCBnf_jobCode = (String) session.getAttribute("lCBnf_jobCode");
				String lCBnf_province = (String) session.getAttribute("lCBnf_province");
				String lCBnf_city = (String) session.getAttribute("lCBnf_city");
				
				lbf1.setName(policy.getBnfName1()); //受益人姓名
				lbf1.setSex(policy.getBnfSex1());  	//受益人性别
				lbf1.setBirthday(policy.getBnfBirthday1().replace("-", "")); //受益人出生日期
				lbf1.setIDType(lcbnf.getIDType());		//受益人证件类型
				lbf1.setIDNo(policy.getBnfIDNo1());			//受益人证件号码
				lbf1.setBnfLot(changeBnfLot(policy.getBnfLot1()));     //受益人受益比例
				lbf1.setRelationToInsured(policy.getRelationToInsured1());//受益人与被保人关系
				lbf1.setBnfMobile(lcbnf.getBnfMobile());
				lbf1.setJobCode(lCBnf_jobCode);
				lbf1.setIDExpDate(textChange(lcbnf.getIDExpDate(), "idNoEndTime"));
				lbf1.setAddressState(GeGeographicalAreafindService.findArea_code(lCBnf_province, "1"));
				lbf1.setCity(GeGeographicalAreafindService.findArea_code(lCBnf_city, "2"));
				lbf1.setAddress(lcbnf.getAddress().replaceFirst(lCBnf_province+lCBnf_city, ""));
				lCBnf.add(lbf1);
				if("2".equals(policy.getlCBnfCount())){
					String lCBnf2_jobCode = (String) session.getAttribute("lCBnf2_jobCode");
					String lCBnf2_province = (String) session.getAttribute("lCBnf2_province");
					String lCBnf2_city = (String) session.getAttribute("lCBnf2_city");
					LCBnf lbf2 = new LCBnf();
					lcbnfs.setLCBnfCount(policy.getlCBnfCount());
					lbf2.setName(policy.getBnfName2()); //受益人姓名
					lbf2.setSex(policy.getBnfSex2());  	//受益人性别
					lbf2.setBirthday(policy.getBnfBirthday2().replace("-", "")); //受益人出生日期
					lbf2.setIDType(lcbnf2.getIDType());		//受益人证件类型
					lbf2.setIDNo(policy.getBnfIDNo2());			//受益人证件号码
					lbf2.setBnfLot(changeBnfLot(policy.getBnfLot2()));     //受益人受益比例
					lbf2.setRelationToInsured(policy.getRelationToInsured2());
					lbf2.setBnfMobile(lcbnf2.getBnfMobile());
					lbf2.setJobCode(lCBnf2_jobCode);
					lbf2.setIDExpDate(textChange(lcbnf2.getIDExpDate(), "idNoEndTime"));
					lbf2.setAddressState(GeGeographicalAreafindService.findArea_code(lCBnf2_province, "1"));
					lbf2.setCity(GeGeographicalAreafindService.findArea_code(lCBnf2_city, "2"));
					lbf2.setAddress(lcbnf2.getAddress().replaceFirst(lCBnf2_province+lCBnf2_city, ""));
					lCBnf.add(lbf2);
				}else if("3".equals(policy.getlCBnfCount())){
					String lCBnf2_jobCode = (String) session.getAttribute("lCBnf2_jobCode");
					String lCBnf2_province = (String) session.getAttribute("lCBnf2_province");
					String lCBnf2_city = (String) session.getAttribute("lCBnf2_city");
					String lCBnf3_jobCode = (String) session.getAttribute("lCBnf3_jobCode");
					String lCBnf3_province = (String) session.getAttribute("lCBnf3_province");
					String lCBnf3_city = (String) session.getAttribute("lCBnf3_city");
					lcbnfs.setLCBnfCount(policy.getlCBnfCount());
					LCBnf lbf2 = new LCBnf();
					lbf2.setName(policy.getBnfName2()); //受益人姓名
					lbf2.setSex(policy.getBnfSex2());  	//受益人性别
					lbf2.setBirthday(policy.getBnfBirthday2().replace("-", "")); //受益人出生日期
					lbf2.setIDType(lcbnf2.getIDType());		//受益人证件类型
					lbf2.setIDNo(policy.getBnfIDNo2());			//受益人证件号码
					lbf2.setBnfLot(changeBnfLot(policy.getBnfLot2()));     //受益人受益比例
					lbf2.setRelationToInsured(policy.getRelationToInsured2());
					lbf2.setBnfMobile(lcbnf2.getBnfMobile());
					lbf2.setJobCode(lCBnf2_jobCode);
					lbf2.setIDExpDate(textChange(lcbnf2.getIDExpDate(), "idNoEndTime"));
					lbf2.setAddressState(GeGeographicalAreafindService.findArea_code(lCBnf2_province, "1"));
					lbf2.setCity(GeGeographicalAreafindService.findArea_code(lCBnf2_city, "2"));
					lbf2.setAddress(lcbnf2.getAddress().replaceFirst(lCBnf2_province+lCBnf2_city, ""));
					lCBnf.add(lbf2);
					LCBnf lbf3 = new LCBnf();
					lbf3.setName(policy.getBnfName3()); //受益人姓名
					lbf3.setSex(policy.getBnfSex3());  	//受益人性别
					lbf3.setBirthday(policy.getBnfBirthday3().replace("-", "")); //受益人出生日期
					lbf3.setIDType(lcbnf3.getIDType());		//受益人证件类型
					lbf3.setIDNo(policy.getBnfIDNo3());			//受益人证件号码
					lbf3.setBnfLot(changeBnfLot(policy.getBnfLot3()));     //受益人受益比例
					lbf3.setRelationToInsured(policy.getRelationToInsured3());
					lbf3.setBnfMobile(lcbnf3.getBnfMobile());
					lbf3.setJobCode(lCBnf3_jobCode);
					lbf3.setIDExpDate(textChange(lcbnf3.getIDExpDate(), "idNoEndTime"));
					lbf3.setAddressState(GeGeographicalAreafindService.findArea_code(lCBnf3_province, "1"));
					lbf3.setCity(GeGeographicalAreafindService.findArea_code(lCBnf3_city, "2"));
					lbf3.setAddress(lcbnf3.getAddress().replaceFirst(lCBnf3_province+lCBnf3_city, ""));
					lCBnf.add(lbf3);
				}
				//循环添加受益人默认值
				for(LCBnf lc : lCBnf){
					lc.setBnfType("");
					lc.setBnfNo("");
					lc.setBnfGrade("1");
					lc.setBnfPartyKey("");
					lc.setIDEffDate("");
					lc.setBnfHomePhone("");
					lc.setBnfCompanyPhone("");
					lc.setBnfAppSame("N"); //受益人与被保人是否是同一人
					lc.setBnfInsuredSame("N");//受益人与投保人是否是同一人
					lc.setRelaToAppnt("");
					lc.setHomeAddress("");
					lc.setHomeZipCode("");
					lc.setMailAddress("");
					lc.setMailZipCode("");
					lc.setEmail("");
					lc.setAddressStateTC("CHN");
					lc.setMsgCode("");
					lc.setBelongToInsured("");
				}
			}
			
			lcbnfs.setLCBnf(lCBnf);
			//调用核保接口
			String sumpremium = RXAKLongPolicyUtil.underwriting(pro.getProperty("yinbaotong"),risk, lCInsured, lcAppnt,lCCont,baseInfo,lcbnfs,policy.getPayYear());
			if (sumpremium.equals("2")) {
				policy.setStatus("5");//人核
				logger.info("瑞享安康openId:"+openId+"人工核保：投保人"+applicantInsured.getName()+" 证件号"+applicantInsured.getIdentifynumber());
				resultsjon = "{\"flag\":\"2\",\"content\":\"需要人工核保"+sumpremium+"\"}";
			}else{
				policy.setStatus("2");//核保失败
				logger.info("瑞享安康openId:"+openId+"核保失败：投保人"+applicantInsured.getName()+" 证件号"+applicantInsured.getIdentifynumber());
				resultsjon = "{\"flag\":\"1\",\"content\":\""+sumpremium+"\"}";
			}
			
			//创建订单对象
			GeOrder order = insurePolicyService.insureInput(policy, applicantInsureds);
			policy.setFlowno(lCCont.getProposalContNo());
			order.setFlowno(lCCont.getProposalContNo());
			order.setPaymentplatform("1");//支付平台：微信
			order.setChannelCode("003");//登录途径，微信公众号
			order.setHealthFlag("N");//健康告知选择
			String ordercode = OrderHelper.getOrderNumber("RT","005");//获取订单号
			order.setOrdercode(ordercode);
			order.setOrderamount(policy.getSumbasepremium());
			order.setPaystatus("0");//待支付
			order.setSubmittime(new Date());//提交时间
			order.setStatus("0");//未对账
			order.setProductname("瑞泰瑞享安康重大疾病保险");
			order.setLoginWay("03");//微信版
			order.setCoreproductcode("RUIXANKANG");//产品代码
			order.setPayway("10");//微信支付
			order.setOrderamount(policy.getSumbasepremium());//订单金额
			order.setUserid(openId);
			order.setBrNo(brNo);
			order.setDeptid(deptid);
			order.setChannelCode("0");
			order.setChannelName("官网直销");
			order.setPreferentialcode(policy.getPreferentialcode());//优惠码
			order.setAgentNo(policy.getAgentcode());//保存推荐人编码
			order.setRecipientmobile(applicantInsured.getMobile());//投保人电话
			//存投被保人姓名
			order.setApplicantname(policy.getApplicantname());
			order.setRecipientname(policy.getInsuredname());
			order.setOpenid(openId);//openId
			//是否银行代扣
			order.setBillingType("Y"); //支付方式
			order.setBankBranchCode(policy.getBankBranchCode());//代扣银行代码
			order.setBankProvince(policy.getBankProvince());//开户行省
			order.setBankCity(policy.getBankCity());//开户市
			order.setBankBranchName(policy.getBank());
			if("2".equals(sumpremium)){
				order.setOrderstatus("5");
				//使用Media_id 下载图片 app_front app_contrary  rec_front  rec_contrary
				String app_front = (String) session.getAttribute("app_front");
				String app_contrary = (String) session.getAttribute("app_contrary");
				String applicantInsured_frontal = downloadMedia(app_front, applicantInsured.getIdentifynumber(), "app_front", lCCont.getProposalContNo());
				String applicantInsured_reverse =downloadMedia(app_contrary, applicantInsured.getIdentifynumber(), "app_contrary", lCCont.getProposalContNo());
				//证件照片
				IdPhotoData idPhoto = new IdPhotoData();
				idPhoto.setPolicyCode("瑞泰瑞享安康重大疾病保险");
				idPhoto.setUploadTime(uploadate.format(new Date()));
				idPhoto.setApplicantInsured_name(applicantInsured.getName()); //投保人姓名
				idPhoto.setApplicantInsured_idType(applicantInsured.getIdentifytype()); //投保人证件类型
				idPhoto.setApplicantInsured_IdNo(applicantInsured.getIdentifynumber()); //投保人证件号码
				idPhoto.setApplicantInsured_endTime(idPhotoData.getApplicantInsured_endTime());//
				idPhoto.setApplicantInsured_frontal(applicantInsured_frontal);  //照片地址 正
				idPhoto.setApplicantInsured_reverse(applicantInsured_reverse); //照片地址 反
				idPhoto.setProposalContNo(lCCont.getProposalContNo()); //投保单号
				if(Integer.parseInt(recognizee_age)<18){
					String rec_front = (String) session.getAttribute("rec_front");
					String rec_contrary = (String) session.getAttribute("rec_contrary");
					String recognizee_frontal = downloadMedia(rec_front, recognizee.getIdentifynumber(), "rec_front", lCCont.getProposalContNo());
					String recognizee_reverse =downloadMedia(rec_contrary, recognizee.getIdentifynumber(), "rec_contrary", lCCont.getProposalContNo());
					idPhoto.setRecognizee_name(recognizee_name);
					idPhoto.setRecognizee_idType(recognizee.getIdentifytype());
					idPhoto.setRecognizee_IdNo(recognizee.getIdentifynumber());
					idPhoto.setRecognizee_endTime(idPhotoData.getRecognizee_endTime());
					idPhoto.setRecognizee_frontal(recognizee_frontal);
					idPhoto.setRecognizee_reverse(recognizee_reverse);
					session.removeAttribute("rec_front");
					session.removeAttribute("rec_contrary");
				}else{
					idPhoto.setRecognizee_name(applicantInsured.getName());
					idPhoto.setRecognizee_idType(applicantInsured.getIdentifytype());
					idPhoto.setRecognizee_IdNo(applicantInsured.getIdentifynumber());
					idPhoto.setRecognizee_endTime(idPhotoData.getApplicantInsured_endTime());
					idPhoto.setRecognizee_frontal(applicantInsured_frontal);
					idPhoto.setRecognizee_reverse(applicantInsured_reverse);
				}
				session.removeAttribute("app_front");
				session.removeAttribute("app_contrary");
				IdPhotoDataService.saveIdPhotoData(idPhoto); //保存照片
				logger.info("瑞享安康证件照片保存成功openId:"+openId+"--投保人:"+applicantInsured.getName());
			}else if("1".equals(sumpremium)){
				order.setOrderstatus("6");
			}
			if(comapp!=null){
				cas.saveComApplicant(comapp);//保存常用投保人
			}
			orderService.saveOrder(order);//保存状态
			logger.info("瑞享安康订单状态保存成功,openId:"+openId+" 投保人"+applicantInsured.getName()+" 证件号"+applicantInsured.getIdentifynumber()+" 订单号"+ordercode);
			/**
			 * 订单对象的初始化完成
			 */
			if(policy.getStatus().equals("5")) {
				session.removeAttribute("commonApplicant");
				session.removeAttribute("index_policy");
				session.removeAttribute("index_recognizee");
				session.removeAttribute("policy");
				session.removeAttribute("applicantInsured");
				session.removeAttribute("recognizee");
				session.removeAttribute("idPhotoData");
				session.removeAttribute("lcbnf");
				session.removeAttribute("lcbnf2");
				session.removeAttribute("lcbnf3");
				session.setAttribute("ordercode", ordercode);//将订单号存入seesion用作承保后状态更改
			}
		}catch (Exception e) {
			logger.error("瑞享安康核保异常,openId:"+openId+" 投保人"+applicantInsured.getName()+" openid"+openId+"："+" 证件号"+applicantInsured.getIdentifynumber()+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			resultsjon = "{\"flag\":\"1\",\"content\":\"核保异常\"}";
			e.printStackTrace();
		}finally{
			super.renderJson(resultsjon);
		}
	}
	
	
	
	
	
	/**
	 * 根据meadia_id下载图片  放入session中 核保通过 在进行下载
	 */
	@Action(value = "RXAKMedia")
	public void Media(){
		String resultsjon = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try {
			String meadia_id = request.getParameter("media_id");
			String type = request.getParameter("type"); //app_front app_contrary  rec_front  rec_contrary
			session.setAttribute(type, meadia_id);
			resultsjon = "{\"flag\":\"1\",\"content\":\"上传成功\"}";
			logger.info("瑞享安康openId:"+openId+"图片类型:"+type+"--图片media_id:"+meadia_id);
		} catch (Exception e) {
			resultsjon = "{\"flag\":\"2\",\"content\":\"上传失败，系统繁忙\"}";
			logger.error("瑞享安康保存图片media_id异常openId:"+openId);
			e.printStackTrace();
		}finally{
			super.renderJson(resultsjon);
		}
	}
	
	/**
	 * 下载图片
	 * @param meadia_id
	 * @param idNO
	 * @param type
	 * @param TransrNo
	 * @return
	 */
	public String downloadMedia(String meadia_id ,String idNO ,String type,String TransrNo){
		String mediaPath = null; //图片地址
		String filePath = pro1.getProperty("RXAKIdPhotoData");  //保存路径
		String mediaName = TransrNo+"_"+idNO+"_"+type;   //图片名字
		WeiXinServiceImpl weixin = new WeiXinServiceImpl();
		mediaPath = weixin.downloadMedia(meadia_id,filePath,mediaName);
		mediaPath = pro1.getProperty("RXAKPath")+mediaPath.replaceFirst(pro2.getProperty("mediaPath"), "");
		logger.info("瑞享安康证件照下载成功,filePath:"+filePath+"  mediaName:"+mediaName+" mediaPath:"+mediaPath+" meadia_id:"+meadia_id);
		return mediaPath;
	}
	
	
	/**
	 * 根据推荐人编码锁定省市
	 */
	@Action(value="rxakDepartToArea")
	public void existDepartment(){
		logger.info("瑞享安康根据组织机构返回省市地址");
		String resultsjon = null;
		String stateName = null;
		String cityName = null;
		String deptCode = request.getParameter("agentCode");
		String deptCode1 = deptCode.substring(0, 2).toUpperCase();
		boolean boo = depser.findByDeptCode(deptCode1);
		if(boo){
			GeDepartment geDepartment = depser.findDepart(deptCode1);
			String contactAddress = geDepartment.getContactAddress(); 
			logger.info("瑞享安康-查询组织机构"+deptCode1+"联系地址为"+contactAddress);
			String onlyCity = pro1.getProperty("RXAKonlyCity"); //只在本市出售的城市列表
			stateName = findStateAndCityName(contactAddress, "1"); //获取省地址
			if(onlyCity.contains(contactAddress)){
				contactAddress = contactAddress.replaceFirst(stateName,"");
				cityName = findStateAndCityName(contactAddress, "2"); //获取市地址
				resultsjon = "{\"flag\":\"0\",\"content\":\""+deptCode1+"\",\"stateName\":\""+stateName+"\",\"cityName\":\""+cityName+"\"}";
			}else{
				resultsjon = "{\"flag\":\"1\",\"content\":\""+deptCode1+"\",\"stateName\":\""+stateName+"\"}";
			}
		}else{
			resultsjon = "{\"flag\":\"2\",\"content\":\"推荐人编码填写有误\"}";
		}
		super.renderJson(resultsjon);
		logger.info("瑞享安康-查询组织机构返回json："+resultsjon);
	}
	
	
	/**
	 * 输入地址返回省 市 名称
	 * @param address
	 * @param area_status
	 * @return
	 */
	public String findStateAndCityName(String address ,String area_status){
		String name = null;
		boolean flag = false;
		for(int i=1;i<address.length();i++){
			name = address.substring(0,i);
			String state_code = GeGeographicalAreafindService.findArea_code(name, area_status);
			if(state_code !=null){
				flag = true;
				break;
			}
		}
		if(flag){
			logger.info(name);
			return name;
		}else{
			return address;
		}
	}
	
	
	/**
	 * 受益比例 25  转 0.25  100转 1
	 * @param bnfLot
	 * @return
	 */
	public static String changeBnfLot(String bnfLot){
		double DBnfLot = Double.parseDouble(bnfLot)/100;
		String BnfLot =  String.format("%.2f", DBnfLot).toString();
		if("1.00".equals(BnfLot)){
			BnfLot = "1";
		}
		return BnfLot;
	}
	
	
	public static String textChange(String str,String type){
		if(type.equals("sex")){
			if(str.equals("M")){
				return "男";
			}else if(str.equals("F")){
				return "女";
			}else{
				return "error";
			}
		}else if(type.equals("sex1")){
			if(str.equals("男")){
				return "M";
			}else if(str.equals("女")){
				return "F";
			}else{
				return "error";
			}
		}else if(type.equals("idType")){
			if(str.equals("I")){
				return "身份证";
			}else if(str.equals("P")){
				return "护照";
			}else if(str.equals("S")){
				return "军官证/士兵证";
			}else if(str.equals("M")){
				return "回乡证";
			}else if(str.equals("O")){
				return "户口本";
			}else if(str.equals("H")){
				return "港澳通行证";
			}else if(str.equals("T")){
				return "台胞证";
			}else{
				return "error";
			}
		}else if(type.equals("relation")){
			if(str.equals("CH")){
				return "子女";
			}else if(str.equals("PA")){
				return "父母";
			}else if(str.equals("EM")){
				return "雇佣";			
			}else if(str.equals("SF")){
				return "本人";
			}else if(str.equals("ES")){
				return "法定";
			}else if(str.equals("GF")){
				return "（外）祖父母";
			}else{
				return "error";
			}
		}else if(("idNoEndTime").equals(type)){
			if(("长期有效").equals(str)){
				return "99991231";
			}else{
				if(!"".equals(str) || str != null){
					Date date = null;
					try {
						date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
						return sdf.format(date);
					} catch (ParseException e) {
						logger.error("证件有效期转换异常");
						e.printStackTrace();
					}
				}
				return str;
			}
		}else{
			return "error";
		}
	}

	@Override
	protected void processResultBusiness(boolean resultSuccess,
			String resultCode, String resultDescription) {
		
	}
	
	public GeApplicantInsured getApplicantInsured() {
		return applicantInsured;
	}

	public void setApplicantInsured(GeApplicantInsured applicantInsured) {
		this.applicantInsured = applicantInsured;
	}

	public GePolicy getPolicy() {
		return policy;
	}

	public void setPolicy(GePolicy policy) {
		this.policy = policy;
	}

	public GeOrder getOrder() {
		return order;
	}

	public void setOrder(GeOrder order) {
		this.order = order;
	}

	public GeCommonApplicant getCommonApplicant() {
		return commonApplicant;
	}

	public void setCommonApplicant(GeCommonApplicant commonApplicant) {
		this.commonApplicant = commonApplicant;
	}

	public GeApplicantInsured getRecognizee() {
		return recognizee;
	}

	public void setRecognizee(GeApplicantInsured recognizee) {
		this.recognizee = recognizee;
	}
	

	public IdPhotoData getIdPhotoData() {
		return idPhotoData;
	}


	public void setIdPhotoData(IdPhotoData idPhotoData) {
		this.idPhotoData = idPhotoData;
	}
	

	public LCBnf getLcbnf() {
		return lcbnf;
	}


	public void setLcbnf(LCBnf lcbnf) {
		this.lcbnf = lcbnf;
	}
	
	public LCBnf getLcbnf2() {
		return lcbnf2;
	}


	public void setLcbnf2(LCBnf lcbnf2) {
		this.lcbnf2 = lcbnf2;
	}


	public LCBnf getLcbnf3() {
		return lcbnf3;
	}


	public void setLcbnf3(LCBnf lcbnf3) {
		this.lcbnf3 = lcbnf3;
	}

}
