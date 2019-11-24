package cn.com.sinosoft.web.msl.sales;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import cn.com.sinosoft.domain.yinbaotongWKB.BaseInfo;
import cn.com.sinosoft.domain.yinbaotongWKB.LCAppnt;
import cn.com.sinosoft.domain.yinbaotongWKB.LCCont;
import cn.com.sinosoft.domain.yinbaotongWKB.LCInsured;
import cn.com.sinosoft.domain.yinbaotongWKB.Risk;
import cn.com.sinosoft.ess.config.service.GeDepartmentService;
import cn.com.sinosoft.ess.product.service.CodeTurnBankService;
import cn.com.sinosoft.ess.product.service.CommonApplicantService;
import cn.com.sinosoft.msl.service.InsurePolicyService;
import cn.com.sinosoft.sale.service.ChannelService;
import cn.com.sinosoft.sale.service.OrderService;
import cn.com.sinosoft.util.WKBLongPolicyUtil;
import cn.com.sinosoft.web.domain.Token;
import cn.com.sinosoft.web.entity.WeiXinUserEntity;
import cn.com.sinosoft.web.msl.BaseAction;
import cn.com.sinosoft.web.service.impl.WeiXinServiceImpl;

@ParentPackage(value = "ECS-STRUTS")
public class WKBPolicyAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static Logger logger = LoggerFactory.getLogger(WKBPolicyAction.class);
	
	@Autowired
	private InsurePolicyService insurePolicyService;
	
	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private CodeTurnBankService CodeTurnBank;
	
	
	private GeApplicantInsured applicantInsured;//投保人
	
	private GeApplicantInsured recognizee;//被保人
	
	private GePolicy policy;//保单

	private GeOrder order;//订单
	
	private GeCommonApplicant commonApplicant;//常用投保人
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	private static SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy年MM月dd日");
	
	private static SimpleDateFormat dateLine = new SimpleDateFormat("yyyy-MM-dd");
	
	private static DecimalFormat df = new DecimalFormat("######0.00"); 
	
	private static Properties pro = new Properties();
	static{
		try {
			pro.load(new InputStreamReader(WKBLongPolicyUtil.class.getResourceAsStream("/config/SecondPeriod.properties"), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	CommonApplicantService cas;
	
	
	
	@Autowired
	private GeDepartmentService depser;
	
	@Override
	protected void processResultBusiness(boolean resultSuccess,
			String resultCode, String resultDescription) {
		
	}
	
	/**
	 * 加载稳康宝首页
	 * @return
	 */
	@Action(value = "WKBHomePage", results = {
		@Result(name="success", location="/WEB-INF/jsp/page/WKBpolicy/index.jsp"),
		@Result(name="error", location="/WEB-INF/jsp/page/WKBpolicy/wkbError.jsp")
		})
	public String loadHomePage (){
		String openId =null;
		HttpSession session  = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("openId")!=null){
			openId = (String)session.getAttribute("openId");
		}
		if(openId==null||openId.length()==0){
			WeiXinServiceImpl weixin = new WeiXinServiceImpl();
			openId=weixin.getOpenId(request);
		}
		String brNo = request.getParameter("brNo");
		if(brNo==null||brNo.length()==0){
			brNo="A0000";
		}
		String imgUrl=null;
		GeChannel channel = channelService.findChannel(brNo,"TAWENKB-R");
		if(channel!=null){
			imgUrl =channel.getImgUrl();
		}else{
			channel = channelService.findChannel("A0000","TAWENKB-R");
			if(null != channel){
				imgUrl = channel.getImgUrl();
			}
		}
		if(null != imgUrl && imgUrl.contains("picture")){
			imgUrl = imgUrl.substring(imgUrl.indexOf("picture"));
		}
		session.setAttribute("channel", channel);
		request.setAttribute("imgUrl",  imgUrl);
		logger.info("openId:"+openId+"合作伙伴代码:"+brNo+" 产品图片地址："+imgUrl);
		if(openId!=null&&openId.length()>0){
			session.setAttribute("brNo", brNo);//将获取的realBrNo(渠道编码)放置seesion域中
			session.setAttribute("openId", openId);//将获取的openId放置seesion域中
			//获取是否关注
//			Token token = Token.getToken();
//	        String access_token = token.getAccessToken();
//	        WeiXinServiceImpl weixin = new WeiXinServiceImpl();
//	        WeiXinUserEntity weixinUser = new WeiXinUserEntity();
//	        weixinUser.setJSON(weixin.getUserData(access_token, openId));//获取用户信息
//	        logger.info("#######access_token+: " + access_token);
//	        //1为关注 0为未关注
//	        Integer subscribe = weixinUser.getSubscribe();
//	        logger.info("关注状态: " + subscribe);
//	        if(null == subscribe || "".equals(subscribe)){
//	        	subscribe = 0;
//	        }
//        	session.setAttribute("subscribe", subscribe);
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
	 * 稳康宝试算保费
	 * @return
	 */
	@Action(value = "WKBPolicyCalculate", results = {
			@Result(name="success",type="json"),
			@Result(name="fail",type="json")
			})
	public String policyPolicyCalculate(){
		HttpSession session  = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");//取openId
		try {
			//取值
			String birthday = sdf.format(applicantInsured.getBirthday());
			String sex = applicantInsured.getSex();
			String amnt = df.format(policy.getSumamount());
			String unitcount = policy.getUnitcount();
			String brNo = (String)session.getAttribute("brNo");
			if(brNo==null||brNo.length()==0){
				brNo="A0000";
			}
			//调用银保通试算接口
			List<String> sumpremium =WKBLongPolicyUtil.calculate(birthday, sex, amnt,pro.getProperty("yinbaotong"),unitcount,brNo);
			if(sumpremium.get(0).matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")){//如果算出保费
				policy.setSumbasepremium(Double.valueOf(sumpremium.get(0)));//将总保费赋值给保单实体
				policy.setMainpolicypre(Double.valueOf(sumpremium.get(1)));//主险保费
				policy.setAdditionalpolicypre(Double.valueOf(sumpremium.get(2)));	//附加险保费
				session.setAttribute("policyPre", policy);
				logger.info("保费试算成功，openId:"+openId+"合作伙伴代码"+brNo);
			}else{
				logger.error("保费试算失败："+sumpremium+",openId:"+openId+"合作伙伴代码"+brNo);
			}
		} catch (Exception e) {
			logger.error("policyPolicyCalculate方法"+openId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 点击投保进入信息录入页
	 * 
	 * @return
	 */
	@Action(value = "wkbFill", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/WKBpolicy/fillinfo.jsp"),
			@Result(name="error", location="/WEB-INF/jsp/page/WKBpolicy/wkbError.jsp")
			})
	public String wkbFill(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try {
			session.setAttribute("policy1", policy);//保额保费优惠码
			session.setAttribute("applicantInsured1", applicantInsured);//首页被保人数据
			String sex = textChange(applicantInsured.getSex(),"sex");
			String birthday = dateLine.format(applicantInsured.getBirthday());
			String idno = applicantInsured.getIdentifynumber();
			if(openId!=null && openId.length()>0){
				GeCommonApplicant comappList = cas.findComApplicant(openId,applicantInsured.getIdentifynumber(),"I");
				if(comappList!=null){
					request.setAttribute("comAppList", comappList);//常用投保人
					request.setAttribute("comBirthday", dateSdf.format(comappList.getBirthday()));//常用投保人
				}
			}
			GeChannel channel = (GeChannel) session.getAttribute("channel");
			if(null != channel){
				request.setAttribute("isAgentCode", channel.getIsAgentcode());//推荐人是否必填
			}
			request.setAttribute("sex", sex);//性别
			request.setAttribute("birthday", birthday);//生日
			request.setAttribute("idno", idno);//证件号码
			resultBusiness(true);
		} catch (Exception e) {
			logger.error("wjxFill方法"+openId+":"+ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	
	
	
	
	
	/**
	 * 提交投保录入并加载投保告知
	 * @return
	 */
	@Action(value = "WKBInsureInput", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/WKBpolicy/notice.jsp"),
			@Result(name="error", location="/WEB-INF/jsp/page/WKBpolicy/wkbError.jsp")
			})
	public String WJXInsureInput(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try {
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
			logger.info(openId+"：提交投保信息成功");
		} catch (Exception e) {
			logger.info("insureInput方法"+openId+"："+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 * 加载投保确认
	 * @return
	 */
	@Action(value = "WKBInsureConfirm", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/WKBpolicy/confirminfo.jsp"),
			@Result(name="error", location="/WEB-INF/jsp/page/WKBpolicy/wkbError.jsp")
			})
	public String insureConfirm(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		String flag = "";
		try {
			GePolicy policy = (GePolicy)session.getAttribute("policy");
			GePolicy policyI = (GePolicy)session.getAttribute("policy1");
			GeApplicantInsured applicantInsured = (GeApplicantInsured)session.getAttribute("applicantInsured");
			String bankCode = policy.getBankAccountNumber();
			if(bankCode!=null&&!bankCode.equals("")){
				flag = "1";
			}else{
				flag = "0";
			}
			request.setAttribute("flag",flag);//续保标准
			request.setAttribute("identifytype1", textChange(applicantInsured.getIdentifytype(), "idType"));//投保人证件类型
			request.setAttribute("sex1", applicantInsured.getSex());//投保人性别
			request.setAttribute("birthday1",dateSdf.format(applicantInsured.getBirthday()));//投保人生日
			request.setAttribute("policy", policy);
			request.setAttribute("policyI", policyI);
			request.setAttribute("applicantInsured", applicantInsured);
			logger.info(openId+"："+"健康提交标识成功");
			resultBusiness(true);
		} catch (Exception e) {
			logger.info("insureConfirm方法"+openId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	
	/**
	 * 提交核保(点击下一步)
	 * @return
	 */
	@Action(value = "WKBinsureSubmit")
	public void insureSubmit(){
		String resultsjon = null;
		String deptid = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		String ActyNo = (String) session.getAttribute("ActyNo");//取得活动码
			GePolicy policy = (GePolicy)session.getAttribute("policy");
			try {
			GePolicy policyPre = (GePolicy)session.getAttribute("policyPre");
			GePolicy policy1 = (GePolicy)session.getAttribute("policy1");//首页实体：保额保费,优惠码
			GeApplicantInsured applicantInsured = (GeApplicantInsured)session.getAttribute("applicantInsured");
			GeApplicantInsured recognizee = (GeApplicantInsured)session.getAttribute("applicantInsured1");//首页实体：被保人生日性别
			GeCommonApplicant comapp = (GeCommonApplicant)session.getAttribute("commonApplicant");
			String unitcount = policyPre.getUnitcount();
			String insuYearFlag =null;
			String insuYear = null;
			if(unitcount.equals("1")){
				 insuYearFlag = "4";
				 insuYear = "30";
			}else if(unitcount.equals("2")){
				insuYearFlag = "2";
				 insuYear = "80";
			}
			String bankAccountNumber = policy.getBankAccountNumber();//续保银行账号
			String brNo = (String)session.getAttribute("brNo");
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
			policy.setOpenid(openId);
			policy.setDeptid(deptid);
			policy.setUnitcount(unitcount);
			policy.setSumamount(policy1.getSumamount());//取保额
			policy.setSumbasepremium(policy1.getSumbasepremium());//取保费
			policy.setMainpolicypre(policyPre.getMainpolicypre());
			policy.setAdditionalpolicypre(policyPre.getAdditionalpolicypre());
			policy.setInsuretime(new Date());//投保时间
			policy.setSource("TAWENKB-R");
			policy.setProdoctcode("TAWENKB-R");//产品编号
			policy.setRiskcode("TAWENKB-R");//险种代码
			policy.setOriginate("0");//官网直销
			policy.setApplicantname(applicantInsured.getName());//投保人姓名
			policy.setApplicantaddress(applicantInsured.getAddress());//投保人地址
			policy.setInsuredname(applicantInsured.getName());//被保人姓名
			policy.setClasscode("1");//1代表主险
			policy.setPolicyterm("1");
			policy.setPolicytermtype("年");
			policy.setProductname("瑞泰稳康宝两全保险");
			policy.setCondition("0");//未对账
			policy.setIslegalflag("2");//法定受益人
			policy.setAgentcode(policy.getAgentcode()==null?"":policy.getAgentcode().toUpperCase());//推荐人码
			policy.setPreferentialcode(policy1.getPreferentialcode()==null?"":policy1.getPreferentialcode().toUpperCase());//优惠码
			
			applicantInsured.setFlag("1");//投保人
			applicantInsured.setInsrelationapp("1");//投保人与被保人关系本人
			recognizee.setBirthday(applicantInsured.getBirthday());
			recognizee.setSex(textChange(applicantInsured.getSex(),"sex1"));
			recognizee.setIdentifynumber(applicantInsured.getIdentifynumber());
			recognizee.setIdentifytype(applicantInsured.getIdentifytype());
			recognizee.setName(applicantInsured.getName());
			recognizee.setFlag("2");//被保人
			recognizee.setInsrelationapp("8");//被保人与投保人关系本人
			applicantInsured.setSex(recognizee.getSex());
			Set<GeApplicantInsured> applicantInsureds = new HashSet<GeApplicantInsured>();
			applicantInsureds.add(recognizee);
			applicantInsureds.add(applicantInsured);
			//核保
			LCCont lCCont = new LCCont();
			if(bankAccountNumber!=null&&bankAccountNumber.length()>0){//如果存在续保
				lCCont.setBankAccNo(bankAccountNumber);
				lCCont.setRenewalPermit("Y");
			}
			
			
			//银行代扣部分
			lCCont.setBillingType(policy.getBillingType());//是否银行代扣
			lCCont.setBankProvince(policy.getBankProvince());//开户行省
			lCCont.setBankCity(policy.getBankCity());//开户市
			lCCont.setAccName(applicantInsured.getName());//银行账户姓名
			lCCont.setBankBranchName("");
//			if(policy.getBillingType().equals("Y")){
			
				String bankBranchCode = policy.getBankBranchCode();
				lCCont.setAccBankCode(bankBranchCode);//银行编码
				//银行编码转银行名称存库
				if(bankBranchCode!=null&&bankBranchCode.length()>0){
					String bank = CodeTurnBank.codeTurnbank(bankBranchCode);
					policy.setBank(bank);
				}
//			}else{
//				lCCont.setAccBankCode("MSG01");//银行编码
//			}
			
			List<Risk> risk = new ArrayList<Risk>();
			Risk risk1 = new Risk();//被保险人险种信息(主险)
			Risk risk2 = new Risk();//被保险人险种信息(附加险)
			risk1.setCValiDate("");//生效日期
			risk1.setAmnt(df.format(policy.getSumamount()));//保额
			risk1.setPrem(df.format(policyPre.getMainpolicypre()));//主险保费
			risk1.setRiskCode("TAWENKB-R");
			risk1.setMainRiskCode("TAWENKB-R");
			risk1.setInsuYearFlag(insuYearFlag);//保障期间标志
			risk1.setInsuYear(insuYear);//保障期间
			risk2.setCValiDate("");//生效日期
			risk2.setAmnt(df.format(policy.getSumamount()));//保额
			risk2.setPrem(df.format(policyPre.getAdditionalpolicypre()));//附加险保费
			risk2.setRiskCode("WKBAR");
			risk2.setMainRiskCode("TAWENKB-R");
			risk2.setInsuYearFlag(insuYearFlag);//保障期间标志
			risk2.setInsuYear(insuYear);//保障期间
			risk.add(risk1);
			risk.add(risk2);
			LCInsured lCInsured = new LCInsured();//被保人信息
			lCInsured.setName(recognizee.getName());//被保人姓名
			lCInsured.setBirthday(sdf.format(recognizee.getBirthday()));//被保人生日
			lCInsured.setSex(recognizee.getSex());//被保人性别
			lCInsured.setIDType(recognizee.getIdentifytype());//被保人证件类型
			lCInsured.setIDNo(recognizee.getIdentifynumber());//被保人证件号、
			lCInsured.setRelaToAppnt("SF");//与投保人关系(本人)
			LCAppnt lcAppnt = new LCAppnt();//投保人信息
			lcAppnt.setAppntName(applicantInsured.getName());//投保人姓名
			lcAppnt.setAppntSex(applicantInsured.getSex());//投保人性别
			lcAppnt.setAppntIDType(applicantInsured.getIdentifytype());//投保人证件类型
			lcAppnt.setAppntIDNo(applicantInsured.getIdentifynumber());//投保人证件号
			lcAppnt.setAppntBirthday(sdf.format(applicantInsured.getBirthday()));//投保人生日
			lcAppnt.setAppntMobile(applicantInsured.getMobile());//投保人手机
			lcAppnt.setEmail(applicantInsured.getEmail());//投保人邮箱
			lcAppnt.setHomeAddress(applicantInsured.getAddress());//投保人地址
			lcAppnt.setRelaToInsured("SF");//与被保人关系(本人)
			
			BaseInfo baseInfo = new BaseInfo();
			baseInfo.setZoneNo("MSG01");//渠道编码
			baseInfo.setBrNo(brNo);//推荐码
			baseInfo.setActyNo(ActyNo);
			//调用核保接口
			String sumpremium = WKBLongPolicyUtil.underwriting(pro.getProperty("yinbaotong"),risk, lCInsured, lcAppnt,lCCont,baseInfo);
			if(sumpremium.equals("1")){//核保成功
				policy.setStatus("1");//核保成功
				logger.info("openId:"+openId+"核保成功："+" 投保人"+applicantInsured.getName()+" 证件号"+applicantInsured.getIdentifynumber());
				resultsjon = "{\"flag\":\"0\",\"content\":\"核保成功\"}";
			}else if (sumpremium.equals("2")) {
					policy.setStatus("5");//人核
					logger.info("openId:"+openId+"人工核保："+" 投保人"+sumpremium+applicantInsured.getName()+" 证件号"+applicantInsured.getIdentifynumber());
					resultsjon = "{\"flag\":\"2\",\"content\":\"需要人工核保"+sumpremium+"\"}";
			}else{
				policy.setStatus("2");//核保失败
				logger.info("openId:"+openId+"核保失败："+" 投保人"+sumpremium+applicantInsured.getName()+" 证件号"+applicantInsured.getIdentifynumber());
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
			order.setProductname("瑞泰稳康宝两全保险");
			order.setLoginWay("03");//微信版
			order.setCoreproductcode("TAWENKB-R");//产品代码
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
			order.setBillingType(policy.getBillingType()); //支付方式
			order.setBankBranchCode(policy.getBankBranchCode());//代扣银行代码
			order.setBankProvince(policy.getBankProvince());//开户行省
			order.setBankCity(policy.getBankCity());//开户市
			order.setBankBranchName(policy.getBank());
			if(sumpremium.equals("2")){
				order.setOrderstatus("5");
			}else if(sumpremium.equals("1")){
				order.setOrderstatus("6");
			}
			if(comapp!=null){
				cas.saveComApplicant(comapp);//保存常用投保人
			}
			orderService.saveOrder(order);//保存状态
			logger.info("订单状态保存成功"+" 投保人"+applicantInsured.getName()+" 证件号"+applicantInsured.getIdentifynumber()+" 订单号"+ordercode);
			session.removeAttribute("commonApplicant");
			/**
			 * 订单对象的初始化完成
			 */
//			session.setAttribute("recognizee", recognizee);
//			session.setAttribute("applicantInsured", applicantInsured);
//			session.setAttribute("policy", policy);
			session.removeAttribute("recognizee");
			session.removeAttribute("applicantInsured");
			session.removeAttribute("applicantInsured1");
			session.removeAttribute("policy1");
			session.removeAttribute("policy");
			session.setAttribute("ordercode", ordercode);//将订单号存入seesion用作承保后状态更改
		}catch (Exception e) {
			logger.info("核保异常"+" 投保人"+applicantInsured.getName()+" openid"+openId+"："+" 证件号"+applicantInsured.getIdentifynumber()+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			resultsjon = "{\"flag\":\"1\",\"content\":\"核保异常\"}";
			e.printStackTrace();
		}finally{
			super.renderJson(resultsjon);
		}
		
	}
	
	
	
	/**
	 * 跳转人工核保告知页
	 * @return
	 */
	@Action(value = "WKBtoBankSuccess", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/WKBpolicy/bankSuccess.jsp"),
			@Result(name="fail", location="/WEB-INF/jsp/page/WKBpolicy/wkbError.jsp")
			})
	public String toBankSuccess(){
		//取openId
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		String source = request.getParameter("source");//取来源，判断长短险
			try{
				String ordercode = (String)session.getAttribute("ordercode");
				GeOrder order = orderService.getOrderByOrderCode(ordercode);//从库里取出订单实体
				String productname = order.getProductname();//产品名称
				String orderamount = df.format(order.getOrderamount());//订单金额
				String paydate = dateSdf.format(new Date());//支付日期
				request.setAttribute("productname", productname);
				request.setAttribute("orderamount", orderamount);
				request.setAttribute("paydate", paydate);
				logger.error("跳转人工核保告知页成功，openId:"+openId);
				return SUCCESS;
			}catch (Exception e) {
				logger.error("跳转人工核保告知页异常，openId:"+openId);
				e.printStackTrace();
				return ERROR;
			}
	}
	
	
	
	/**
	 * 承保并跳转至支付成功页面
	 * @return
	 */
	@Action(value = "WKBtoSuccess", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/WKBpolicy/success.jsp"),
			@Result(name="fail", location="/WEB-INF/jsp/page/WKBpolicy/wkbError.jsp")
			})
	public String toSuccess(){
		//取openId
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		String source = request.getParameter("source");//取来源，判断长短险
		if(source.equals("TAWENKB-R")){
			try{
				String ordercode = (String)session.getAttribute("ordercode");
				GeOrder order = orderService.getOrderByOrderCode(ordercode);//从库里取出订单实体
				String productname = order.getProductname();//产品名称
				String orderamount = df.format(order.getOrderamount());//订单金额
				String paydate = dateSdf.format(new Date());//支付日期
				request.setAttribute("productname", productname);
				request.setAttribute("orderamount", orderamount);
				request.setAttribute("paydate", paydate);
				logger.error("承保成功，openId:"+openId);
				return SUCCESS;
			}catch (Exception e) {
				logger.error("承保或更改状态异常，openId:"+openId);
				e.printStackTrace();
				return ERROR;
			}
		}else{
			logger.error("来源取值异常");
			return ERROR;
		}
	}
	
	/**
	 *测试环境跳过支付进行承保并，成功后跳转至支付成功页面
	 * @return
	 */
	@Action(value = "WKBtoTestSuccess", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/WKBpolicy/success.jsp"),
			@Result(name="fail", location="/WEB-INF/jsp/page/WKBpolicy/wkbError.jsp")
			})
	public String WKBtoTestSuccess(){
		//取openId
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		String source = request.getParameter("source");//取来源，判断长短险
		if(source.equals("TAWENKB-R")){
			String flag = WKBlongAcceptance((String) session.getAttribute("ordercode"),openId);
			try{
				String ordercode = (String)session.getAttribute("ordercode");
				GeOrder order = orderService.getOrderByOrderCode(ordercode);//从库里取出订单实体
				String productname = order.getProductname();//产品名称
				String orderamount = df.format(order.getOrderamount());//订单金额
				String paydate = dateSdf.format(new Date());//支付日期
				request.setAttribute("productname", productname);
				request.setAttribute("orderamount", orderamount);
				request.setAttribute("paydate", paydate);
				logger.info("承保成功，openId:"+openId);
				if(flag.equals("1")){
					return SUCCESS;
				}else{
					return FAIL;
				}	
			}catch (Exception e) {
				logger.error("承保或更改状态异常，openId:"+openId);
				e.printStackTrace();
				return ERROR;
			}
		}else{
			logger.error("来源取值异常");
			return ERROR;
		}
	}
	
	/**
	 * 
	 *测试环境跳过支付进行承保并，成功后跳转至支付成功页面
	 * @return
	 */
	@Action(value = "WKBtoTestSuccessContinue", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/WKBpolicy/success.jsp"),
			@Result(name="fail", location="/WEB-INF/jsp/page/WKBpolicy/wkbError.jsp")
			})
	public String WKBtoTestSuccessContinue(){
		//取openId
		HttpSession session = ServletActionContext.getRequest().getSession();
		String orderCode = request.getParameter("orderCode");
		String openId = (String) session.getAttribute("openId");
		String source = request.getParameter("source");//取来源，判断长短险
		if(source.equals("TAWENKB-R")){
			String flag = WKBlongAcceptance(orderCode,openId);
			try{
//				String ordercode = (String)session.getAttribute("ordercode");
				GeOrder order = orderService.getOrderByOrderCode(orderCode);//从库里取出订单实体
				String productname = order.getProductname();//产品名称
				String orderamount = df.format(order.getOrderamount());//订单金额
				String paydate = dateSdf.format(new Date());//支付日期
				request.setAttribute("productname", productname);
				request.setAttribute("orderamount", orderamount);
				request.setAttribute("paydate", paydate);
				logger.info("承保成功，openId:"+openId);
				if(flag.equals("1")){
					return SUCCESS;
				}else{
					return FAIL;
				}	
			}catch (Exception e) {
				logger.error("承保或更改状态异常，openId:"+openId);
				e.printStackTrace();
				return ERROR;
			}
		}else{
			logger.error("来源取值异常");
			return ERROR;
		}
	}
	
	public String WKBlongAcceptance(String ordercode,String openId){
		String ActyNo = "";//取得活动码
		String flag = "0";
		//承保
		GeApplicantInsured recognizee = null;
		GeApplicantInsured applicantInsured = null;
		GeOrder order = orderService.getOrderByOrderCode(ordercode);//从库里取出订单实体
		Set<GePolicy> policys = order.getPolicys();
		Iterator<GePolicy> it = policys.iterator();
		GePolicy policy = it.next();
		String brNo = order.getBrNo();
		if(brNo==null||brNo.length()==0){
			brNo = "A0000";
		}
		try{
			String status = policy.getStatus();//查看保单状态
			if(status.equals("1")){//如果此保单状态为核保成功
				Set<GeApplicantInsured> applicantInsureds = policy.getApplicantInsureds();
				Iterator<GeApplicantInsured> it1 = applicantInsureds.iterator();
				while(it1.hasNext()){
					GeApplicantInsured next = it1.next();
					if(next.getFlag().equals("1")){
						applicantInsured = next;
					}else if(next.getFlag().equals("2")){
						recognizee = next;
					}
				}
				String bank = policy.getBank();//续保银行
				String bankAccountNumber = policy.getBankAccountNumber();//续保银行账号
				LCCont lCCont = new LCCont();
				if(bank!=null&&bankAccountNumber!=null&&bank.length()>0&&bankAccountNumber.length()>0){//如果存在续保
					lCCont.setBankAccNo(bankAccountNumber);//续保银行
					lCCont.setRenewalPermit("Y");//自动续保标志
				}
			
				String unitcount = policy.getUnitcount();
				String insuYearFlag =null;
				String insuYear = null;
				if(unitcount.equals("1")){
					 insuYearFlag = "4";
					 insuYear = "30";
				}else if(unitcount.equals("2")){
					insuYearFlag = "2";
					 insuYear = "80";
				}
				List<Risk> risk = new ArrayList<Risk>();
				Risk risk1 = new Risk();//被保险人险种信息(主险)
				Risk risk2 = new Risk();//被保险人险种信息(附加险)
				risk1.setCValiDate("");//生效日期
				risk1.setAmnt(df.format(policy.getSumamount()));//保额
				risk1.setPrem(df.format(policy.getMainpolicypre()));//保费
				risk1.setRiskCode("TAWENKB-R");
				risk1.setMainRiskCode("TAWENKB-R");
				risk1.setInsuYearFlag(insuYearFlag);//保障期间标志
				risk1.setInsuYear(insuYear);//保障期间
				risk2.setCValiDate("");//生效日期
				risk2.setAmnt(df.format(policy.getSumamount()));//保额
				risk2.setPrem(df.format(policy.getAdditionalpolicypre()));//保费
				risk2.setRiskCode("WKBAR");
				risk2.setMainRiskCode("TAWENKB-R");
				risk2.setInsuYearFlag(insuYearFlag);//保障期间标志
				risk2.setInsuYear(insuYear);//保障期间
				risk.add(risk1);
				risk.add(risk2);
				LCInsured lCInsured = new LCInsured();//被保人信息
				lCInsured.setName(recognizee.getName());//被保人姓名
				lCInsured.setBirthday(sdf.format(recognizee.getBirthday()));//被保人生日
				lCInsured.setSex(recognizee.getSex());//被保人性别
				lCInsured.setIDType(recognizee.getIdentifytype());//被保人证件类型
				lCInsured.setIDNo(recognizee.getIdentifynumber());//被保人证件号
				lCInsured.setRelaToAppnt("SF");//与投保人关系(本人)
				LCAppnt lcAppnt = new LCAppnt();//投保人信息
				lcAppnt.setAppntName(applicantInsured.getName());//投保人姓名
				lcAppnt.setAppntSex(applicantInsured.getSex());//投保人性别
				lcAppnt.setAppntIDType(applicantInsured.getIdentifytype());//投保人证件类型
				lcAppnt.setAppntIDNo(applicantInsured.getIdentifynumber());//投保人证件号
				lcAppnt.setAppntBirthday(sdf.format(applicantInsured.getBirthday()));//投保人生日
				lcAppnt.setAppntMobile(applicantInsured.getMobile());//投保人手机
				lcAppnt.setEmail(applicantInsured.getEmail());//投保人邮箱
				lcAppnt.setHomeAddress(applicantInsured.getAddress());
				lcAppnt.setRelaToInsured("SF");//与被保人关系(本人)
				lCCont.setAccBankCode("MSG01");//渠道编码
				BaseInfo baseInfo = new BaseInfo();
				baseInfo.setZoneNo("MSG01");//渠道编码
				baseInfo.setBrNo(brNo);//推荐码
				baseInfo.setActyNo(ActyNo);//活动码
				Map<String, String> map = WKBLongPolicyUtil.approved(pro.getProperty("yinbaotong"), risk, lCInsured, lcAppnt,lCCont,baseInfo);
				flag = map.get("flag");
				policy.setBrNo(brNo);
				if(flag.equals("1")){//承保成功
					policy.setStatus("3");//承保成功
					order.setFlowno(map.get("filowno"));//流水号
					order.setPolicyno(map.get("policycode"));//订单表中的保单号
					policy.setPolicycode(map.get("policycode"));//保单号
					policy.setFlowno(map.get("filowno"));
					policy.setTakeeffecttime(sdf.parse(map.get("takeeffecttime")));//保单生效时间
					order.setFlag("3");//承保成功
					logger.info("承保成功，openId："+openId);
				}else if(flag.equals("0")){
					policy.setStatus("4");//承保失败
					order.setFlag("4");//承保失败
					logger.error("承保失败，desc："+map.get("desc")+"   openId："+openId);
				}
			}else if(status.equals("4")){//记录为承保失败的单子
				flag = "0";//暂不处理
			}else if(status.equals("3")){//记录为承保成功的单子 
				flag = "1";
			}
		}catch (Exception e) {
			logger.error("承保或更改状态异常，openId:"+openId);
			e.printStackTrace();
		}finally{
			order.setPaytime(new Date());//支付时间
			order.setPaystatus("1");//支付成功
			//policy.setApplicantcode(map.get("circpaymentno"));
			policys.clear();
			policys.add(policy);
			order.setPolicys(policys);
			orderService.updateOrder(order);//更改状态
		}
		return flag;
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
		}else{
			return "error";
		}
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
	
}
