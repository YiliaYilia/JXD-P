package cn.com.sinosoft.web.msl.sales;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
import cn.com.sinosoft.domain.system.GeDepartment;
import cn.com.sinosoft.domain.yinbaotong.BaseInfo;
import cn.com.sinosoft.domain.yinbaotong.LCAppnt;
import cn.com.sinosoft.domain.yinbaotong.LCCont;
import cn.com.sinosoft.domain.yinbaotong.LCInsured;
import cn.com.sinosoft.domain.yinbaotong.Risk;
import cn.com.sinosoft.ess.config.service.GeDepartmentService;
import cn.com.sinosoft.ess.product.service.CodeTurnBankService;
import cn.com.sinosoft.ess.product.service.CommonApplicantService;
import cn.com.sinosoft.msl.service.InsurePolicyService;
import cn.com.sinosoft.sale.service.ChannelService;
import cn.com.sinosoft.sale.service.JobCodeService;
import cn.com.sinosoft.sale.service.OrderService;
import cn.com.sinosoft.util.WABLongPolicyUtil;
import cn.com.sinosoft.util.WJBLongPolicyUtil;
import cn.com.sinosoft.web.msl.BaseAction;
import cn.com.sinosoft.web.service.facade.GeGeographicalAreafindService;
import cn.com.sinosoft.web.service.impl.WeiXinServiceImpl;

@ParentPackage(value = "ECS-STRUTS")
public class WJBPolicyAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;

	public static Logger logger = LoggerFactory.getLogger(WJBPolicyAction.class);
	
	@Autowired
	private JobCodeService JobCodeService;
	
	@Autowired
	GeGeographicalAreafindService GeGeographicalAreafindService;
	
	@Autowired
	private InsurePolicyService insurePolicyService;
	
	private GeApplicantInsured applicantInsured;//投保人
	
	private GeApplicantInsured recognizee;//被保人
	
	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private CodeTurnBankService CodeTurnBank;
	
	private GePolicy policy;//保单

	private GeOrder order;//订单
	
	private GeCommonApplicant commonApplicant;//常用投保人
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	private static SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy年MM月dd日");
	
	private static SimpleDateFormat dateLine = new SimpleDateFormat("yyyy-MM-dd");
	
	private static DecimalFormat df = new DecimalFormat("######0.00"); 
	
	private static Properties pro = new Properties();
	
	private static Properties pro1 = new Properties();
	static{
		try {
			pro.load(new InputStreamReader(WJBLongPolicyUtil.class.getResourceAsStream("/config/SecondPeriod.properties"), "UTF-8"));
			pro1.load(new InputStreamReader(WABLongPolicyUtil.class.getResourceAsStream("/config/DepartmentAddress.properties"), "UTF-8"));
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
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 加载稳驾保首页
	 * @return
	 */
	@Action(value = "WJBHomePage", results = {
		@Result(name="success", location="/WEB-INF/jsp/page/WJBpolicy/index.jsp"),
		@Result(name="error", location="/WEB-INF/jsp/page/WJBpolicy/wjbError.jsp")
		})
	public String loadHomePage (){
		String openId =null;
		//String openId = "oipGbs6aOJCQcO0jGszXYVdAmp_I";
		HttpSession session  = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("openId")!=null){
			openId = (String)session.getAttribute("openId");
		}
		if(openId==null||openId.length()==0){
			openId = WeiXinServiceImpl.getOpenId(request);
		}
		String brNo = request.getParameter("brNo");
		if(brNo==null||brNo.length()==0){
			brNo="A0000";
		}
		String imgUrl=null;
		GeChannel channel = channelService.findChannel(brNo,"WENJIABAO");
		if(channel!=null){
			imgUrl =channel.getImgUrl();
		}else{
			channel = channelService.findChannel("A0000","WENJIABAO");
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
			session.setAttribute("openId", openId);
			session.setAttribute("brNo", brNo);//将获取的realBrNo(渠道编码)放置seesion域中
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
	 * 稳驾保试算保费
	 * @return
	 */
	@Action(value = "WJBPolicyCalculate", results = {
			@Result(name="success",type="json"),
			@Result(name="fail",type="json")
			})
	public String policyPolicyCalculate(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) ServletActionContext.getRequest().getSession().getAttribute("openId");//取openId
		try {
			//取值
			String birthday = sdf.format(applicantInsured.getBirthday());
			String sex = applicantInsured.getSex();
			String amnt = df.format(policy.getSumamount());   //保额
			String payment_time =  policy.getPayYear(); //交费期间 3 5 10 20
			String time =  request.getParameter("time")==null?"":request.getParameter("time");	//保障期间  30年  至75
			String insuYearFlag = null;
			if("30".equals(time)){
				insuYearFlag = "4";
				session.setAttribute("time1", "30年");
			}else if("75".equals(time)){
				insuYearFlag = "2";
				session.setAttribute("time1", "至75周岁");
			}
			String brNo = (String)session.getAttribute("brNo");
			if(brNo==null||brNo.length()==0){
				brNo="A0000";
			}
			//调用银保通试算接口
			String sumpremium = WJBLongPolicyUtil.calculate(birthday, sex,applicantInsured.getIdentifynumber(), amnt,pro.getProperty("yinbaotong"),brNo, payment_time, insuYearFlag);
			if(sumpremium.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")){//如果算出保费
				policy.setSumbasepremium(Double.valueOf(sumpremium));//将总保费赋值给保单实体
				session.setAttribute("insuYearFlag", insuYearFlag); //交费期间    4 年交   2到某一年龄
				session.setAttribute("payEndYear", payment_time);   //交费期间  3 5 10 20
				logger.info("稳驾保保费试算成功，投保人生日"+birthday+"openId:"+openId+"合作伙伴代码"+brNo);
			}else{
				logger.error("稳驾保保费试算失败：投保人生日"+birthday+",openId:"+openId+"合作伙伴代码"+brNo);
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
	@Action(value = "wjbFill", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/WJBpolicy/fillinfo.jsp"),
			@Result(name="error", location="/WEB-INF/jsp/page/WJBpolicy/wjbError.jsp")
			})
	public String wjbFill(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try {
			session.setAttribute("policy1", policy);//保额保费优惠码
			session.setAttribute("applicantInsured1", applicantInsured);//首页被保人数据
			String sex = textChange(applicantInsured.getSex(),"sex");
			String birthday = dateLine.format(applicantInsured.getBirthday());
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
			request.setAttribute("sex", sex);//性别
			request.setAttribute("birthday", birthday);//生日
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
	@Action(value = "WJBInsureInput", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/WJBpolicy/notice.jsp"),
			@Result(name="error", location="/WEB-INF/jsp/page/WJBpolicy/wjbError.jsp")
			})
	public String WJBInsureInput(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		//取职业编码
		String industry = request.getParameter("industry"); //行业
		String job = request.getParameter("job");	//职业
		//转职业编码
		String jobCode = JobCodeService.findJobCode(industry, job,"WENJIABAO");	//职业编码
		logger.info("职业编码转换成功,openId:"+openId+"--行业:"+industry+"--职业:"+job+"--职业编码:"+jobCode);
		session.setAttribute("jobCode", jobCode);
		//取职业标识yfCode
		String yfCode = request.getParameter("yfCode")==null?"":request.getParameter("yfCode"); //职业标识
		if(!"Y".equals(yfCode)){  
			yfCode = jobChange(jobCode);
		}
		session.setAttribute("yfCode", yfCode);
		//取得省市
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String conty = request.getParameter("conty");
		String adressText = request.getParameter("detail_addr");
		adressText = conty+"区/县"+adressText;
		//省市转换编码
		String state_code = GeGeographicalAreafindService.findArea_code(province, "1");
		String city_code = GeGeographicalAreafindService.findArea_code(city, "2");
		
		applicantInsured.setProvince(province);
		applicantInsured.setCity(city);
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
					logger.info("常用投保人信息保存成功"+" openId:"+openId +" 身份证"+applicantInsured.getIdentifynumber());
				}
			}
			session.setAttribute("policy", policy);
			session.setAttribute("applicantInsured", applicantInsured);
			session.setAttribute("state_code", state_code);
			session.setAttribute("city_code", city_code);
			session.setAttribute("adressText", adressText);
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
	@Action(value = "WJBInsureConfirm", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/WJBpolicy/confirminfo.jsp"),
			@Result(name="fail", location="/WEB-INF/jsp/page/WJBpolicy/wjbError.jsp")
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
	@Action(value = "WJBinsureSubmit")
	public void insureSubmit(){
		String resultsjon = null;
		String deptid = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try {
			String payEndYear = (String) session.getAttribute("payEndYear");                      //交费期间 3 5 10 20
			String insuYearFlag = (String) session.getAttribute("insuYearFlag");			//缴费年期年龄标志  2:缴至某确定年龄  4:年缴 
			String adressText = (String) session.getAttribute("adressText");  //详细地址
			String state_code = (String) session.getAttribute("state_code");	//省编码
			String city_code = (String) session.getAttribute("city_code");		//市编码
			String jobCode = (String) session.getAttribute("jobCode");		//职业编码
			String yfCode = (String) session.getAttribute("yfCode");		//是否为4职业
			String ActyNo = (String) session.getAttribute("ActyNo");//取得活动码
			GePolicy policy = (GePolicy)session.getAttribute("policy");
			GePolicy policy1 = (GePolicy)session.getAttribute("policy1");//首页实体：保额保费,优惠码
			GeApplicantInsured applicantInsured = (GeApplicantInsured)session.getAttribute("applicantInsured");
			GeApplicantInsured recognizee = (GeApplicantInsured)session.getAttribute("applicantInsured1");//首页实体：被保人生日性别
			GeCommonApplicant comapp = (GeCommonApplicant)session.getAttribute("commonApplicant");
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
//			policy.setBrNo(brNo);
			policy.setLCAProvince(state_code);
			policy.setLCACity(city_code);
			policy.setLCIProvince(state_code);
			policy.setLCICity(city_code);
			policy.setJobFlag(yfCode); 			//是否为4职业  Y/N
			policy.setJobCode(jobCode);			//被保人职业编码
			policy.setPayYear(payEndYear);			//交费期间 3 5 10 20
			policy.setPayYeartag(insuYearFlag);	//缴费年期年龄标志  2:缴至某确定年龄  4:年缴 
			policy.setDeptid(deptid);
			policy.setSumamount(policy1.getSumamount());//取保额
			policy.setSumbasepremium(policy1.getSumbasepremium());//取保费
			policy.setInsuretime(new Date());//投保时间
			policy.setSource("WENJIABAO");
			policy.setProdoctcode("WENJIABAO");//产品编号
			policy.setRiskcode("WENJIABAO");//险种代码
			policy.setOriginate("0");//官网直销
			policy.setApplicantname(applicantInsured.getName());//投保人姓名
			policy.setApplicantaddress(applicantInsured.getAddress());//投保人地址
			policy.setInsuredname(applicantInsured.getName());//被保人姓名
			policy.setClasscode("1");//1代表主险
			if("4".equals(insuYearFlag)){
				policy.setPolicyterm("30");
			}else if("2".equals(insuYearFlag)){
				policy.setPolicyterm("75");
			}
			policy.setPolicytermtype("年");
			policy.setProductname("瑞泰稳驾保两全保险");
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
			//银行编码转银行名称存库
			String bankBranchCode = policy.getBankBranchCode();
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
			lCCont.setSpecContent(yfCode);	//是否为4职业 
			//银行代扣部分
			lCCont.setBankProvince(policy.getBankProvince());
			lCCont.setBankCity(policy.getBankCity());
			lCCont.setBillingType(policy.getBillingType());//是否银行代扣
			lCCont.setAccBankCode(bankBranchCode);//银行编码
			lCCont.setAccName(applicantInsured.getName());
			
			Risk risk = new Risk();//被保险人险种信息
			risk.setCValiDate("");//生效日期
			risk.setAmnt(df.format(policy.getSumamount()));//保额
			risk.setPrem(df.format(policy.getSumbasepremium()));//保费
			LCInsured lCInsured = new LCInsured();//被保人信息
			lCInsured.setName(recognizee.getName());//被保人姓名
			lCInsured.setBirthday(sdf.format(recognizee.getBirthday()));//被保人生日
			lCInsured.setSex(recognizee.getSex());//被保人性别
			lCInsured.setIDType(recognizee.getIdentifytype());//被保人证件类型
			lCInsured.setIDNo(recognizee.getIdentifynumber());//被保人证件号、
			lCInsured.setRelaToAppnt("SF");//与投保人关系(本人)
			lCInsured.setAddressState(state_code); //被保人省编码
			lCInsured.setCity(city_code); //被保人市编码
			lCInsured.setHomeAddress(adressText);//被保险人家庭详细地址
			lCInsured.setJobCode(jobCode);	//被保人职业编码
			
			LCAppnt lcAppnt = new LCAppnt();//投保人信息
			lcAppnt.setAppntName(applicantInsured.getName());//投保人姓名
			lcAppnt.setAppntSex(applicantInsured.getSex());//投保人性别
			lcAppnt.setAppntIDType(applicantInsured.getIdentifytype());//投保人证件类型
			lcAppnt.setAppntIDNo(applicantInsured.getIdentifynumber());//投保人证件号
			lcAppnt.setAppntBirthday(sdf.format(applicantInsured.getBirthday()));//投保人生日
			lcAppnt.setAppntMobile(applicantInsured.getMobile());//投保人手机
			lcAppnt.setEmail(applicantInsured.getEmail());//投保人邮箱
			lcAppnt.setHomeAddress(adressText);//投保人详细地址
			lcAppnt.setAddressState(state_code); //投保人省编码
			lcAppnt.setCity(city_code);	//投保人市编码
			lcAppnt.setRelaToInsured("SF");//与被保人关系(本人)
			lcAppnt.setJobCode(jobCode);	//投保人职业编码
			
			BaseInfo baseInfo = new BaseInfo();
			baseInfo.setZoneNo("MSG01");//渠道编码
			baseInfo.setBrNo(brNo);//推荐码
			baseInfo.setActyNo(ActyNo);
			//调用核保接口
			String sumpremium = WJBLongPolicyUtil.underwriting(pro.getProperty("yinbaotong"),risk, lCInsured, lcAppnt,lCCont,baseInfo,insuYearFlag,payEndYear);
			if(sumpremium.equals("1")){//核保成功
				policy.setStatus("1");//核保成功
				logger.info("openId:"+openId+"核保成功："+" 投保人"+applicantInsured.getName()+" 证件号"+applicantInsured.getIdentifynumber());
				resultsjon = "{\"flag\":\"0\",\"content\":\"核保成功\"}";
			}else if (sumpremium.equals("2")) {
				policy.setStatus("5");//人核
				logger.info("openId:"+openId+"人工核保："+" 投保人"+sumpremium+applicantInsured.getName()+" 证件号"+applicantInsured.getIdentifynumber());
				resultsjon = "{\"flag\":\"2\",\"content\":\"需要人工核保"+sumpremium+"\"}";
			}else {
				policy.setStatus("2");//核保失败
				logger.debug("openId:"+openId+"核保失败："+" 投保人"+sumpremium+applicantInsured.getName()+" 证件号"+applicantInsured.getIdentifynumber());
				resultsjon = "{\"flag\":\"1\",\"content\":\""+sumpremium+"\"}";
			}
			//创建订单对象
			GeOrder order = insurePolicyService.insureInput(policy, applicantInsureds);
			policy.setFlowno(lCCont.getProposalContNo());
			order.setFlowno(lCCont.getProposalContNo());
			order.setPaymentplatform("1");//支付平台：微信
			order.setChannelCode("003");//登录途径，微信公众号
			order.setHealthFlag("N");//健康告知选择
			String ordercode = OrderHelper.getOrderNumber("RT","004");//获取订单号
			order.setOrdercode(ordercode);
			order.setOrderamount(policy.getSumbasepremium());
			order.setPaystatus("0");//待支付
			order.setSubmittime(new Date());//提交时间
			order.setStatus("0");//未对账
			order.setProductname("瑞泰稳驾保两全保险");
			order.setLoginWay("03");//微信版
			order.setCoreproductcode("WENJIABAO");//产品代码
			order.setPayway("10");//微信支付
			order.setBrNo(brNo);
			order.setDeptid(deptid);
			order.setOrderamount(policy.getSumbasepremium());//订单金额
			order.setUserid(openId);
			order.setChannelCode("0");
			order.setChannelName("官网直销");
			order.setPreferentialcode(policy.getPreferentialcode());//优惠码
			order.setAgentNo(policy.getAgentcode());//保存推荐人编码
			order.setRecipientmobile(applicantInsured.getMobile());//投保人电话
			//存投被保人姓名
			order.setApplicantname(policy.getApplicantname());
			order.setRecipientname(policy.getInsuredname());
			//存开户行地址
			order.setBankBranchCode(policy.getBankBranchCode());
			order.setBankCity(policy.getBankCity());
			order.setBankProvince(policy.getBankProvince());
			order.setDeptid(deptid);
			order.setBankBranchName(policy.getBank());
			//是否银行代扣
			order.setBillingType(policy.getBillingType()); //支付方式
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
			session.setAttribute("recognizee", recognizee);
			session.setAttribute("applicantInsured", applicantInsured);
			session.setAttribute("policy", policy);
			session.setAttribute("ordercode", ordercode);//将订单号存入seesion用作承保后状态更改
		}catch (Exception e) {
			logger.info("核保异常"+" 投保人"+applicantInsured.getName()+" openid"+openId+"："+" 证件号"+applicantInsured.getIdentifynumber()+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			resultsjon = "{\"flag\":\"1\",\"content\":\"核保异常\"}";
			e.printStackTrace();
		}finally{
			session.removeAttribute("recognizee");
			session.removeAttribute("applicantInsured");
			session.removeAttribute("applicantInsured1");
			session.removeAttribute("policy1");
			session.removeAttribute("policy");
			super.renderJson(resultsjon);
		}
		
	}
	
	/**
	 * 跳转人工核保告知页
	 * @return
	 */
	@Action(value = "WJBtoBankSuccess", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/WJBpolicy/bankSuccess.jsp"),
			@Result(name="fail", location="/WEB-INF/jsp/page/WJBpolicy/wjbError.jsp")
			})
	public String toBankSuccess(){
		//取openId
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
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
	 * 跳转至支付成功页面
	 * @return
	 */
	@Action(value = "WJBtoSuccess", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/WJBpolicy/success.jsp"),
			@Result(name="error", location="/WEB-INF/jsp/page/WJBpolicy/wjbError.jsp")
			})
	public String toSuccess(){
		//取openId
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
			try{
				String source = request.getParameter("source");//取来源，判断长短险
				if(source.equals("WENJIABAO")){
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
				}else{
					logger.error("来源取值异常");
					return ERROR;
				}
			}catch (Exception e) {
				logger.error("承保或更改状态异常");
				e.printStackTrace();
				return ERROR;
			}
	}
	
	
	/**
	 * 测试承保并跳转至支付成功页面
	 * @return
	 */
	@Action(value = "WJBtoTestSuccess", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/WJBpolicy/success.jsp"),
			@Result(name="error", location="/WEB-INF/jsp/page/WJBpolicy/wjbError.jsp")
			})
	public String toTestSuccess(){
		//取openId
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
			try{
				String source = request.getParameter("source");//取来源，判断长短险
				if(source.equals("WENJIABAO")){
					String flag = WJBlongAcceptance((String) session.getAttribute("ordercode"),openId);
					
					String ordercode = (String)session.getAttribute("ordercode");
					GeOrder order = orderService.getOrderByOrderCode(ordercode);//从库里取出订单实体
					String productname = order.getProductname();//产品名称
					String orderamount = df.format(order.getOrderamount());//订单金额
					String paydate = dateSdf.format(new Date());//支付日期
					request.setAttribute("productname", productname);
					request.setAttribute("orderamount", orderamount);
					request.setAttribute("paydate", paydate);
					if(flag.equals("1")){
						logger.error("承保成功，openId:"+openId);
						return SUCCESS;
					}else{
						return ERROR;
					}
				}else{
					logger.error("来源取值异常");
					return ERROR;
				}
			}catch (Exception e) {
				logger.error("承保或更改状态异常");
				e.printStackTrace();
				return ERROR;
			}
	}

	public String WJBlongAcceptance(String ordercode,String openId){
		String ActyNo = "";//取得活动码
		String flag = "0";
		//稳驾保长险承保
		GeApplicantInsured recognizee = null;
		GeApplicantInsured applicantInsured = null;
		GeOrder order = orderService.getOrderByOrderCode(ordercode);//从库里取出订单实体
		Set<GePolicy> policys = order.getPolicys();
		Iterator<GePolicy> it = policys.iterator();
		GePolicy policy = it.next();
		String payEndYear = policy.getPayYear();   //缴费期限
		String payEndYearFlag = policy.getPayYeartag(); //缴费年期年龄标志  2:缴至某确定年龄  4:年缴 
		String jobCode = policy.getJobCode();	//职业编码
		String jobFlag = policy.getJobFlag();	//是否为4职业 
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
				String addressText = applicantInsured.getAddress().replaceFirst(applicantInsured.getProvince()+applicantInsured.getCity(),"");//详细地址
				String bankAccountNumber = policy.getBankAccountNumber();//续保银行账号
				LCCont lCCont = new LCCont();
				lCCont.setSpecContent(jobFlag); //是否为4职业
				lCCont.setBankAccNo(bankAccountNumber);//续保银行
				lCCont.setRenewalPermit("Y");//自动续保标志
				lCCont.setAccBankCode(order.getBankBranchCode());
				lCCont.setBankProvince(order.getBankProvince());
				lCCont.setBankCity(order.getBankCity());
					//银行代扣部分
				lCCont.setAccName(applicantInsured.getName());
				
				Risk risk = new Risk();//被保险人险种信息
				risk.setCValiDate("");//生效日期
				risk.setAmnt(df.format(policy.getSumamount()));//保额
				risk.setPrem(df.format(policy.getSumbasepremium()));//保费
				LCInsured lCInsured = new LCInsured();//被保人信息
				lCInsured.setName(recognizee.getName());//被保人姓名
				lCInsured.setBirthday(sdf.format(recognizee.getBirthday()));//被保人生日
				lCInsured.setSex(recognizee.getSex());//被保人性别
				lCInsured.setIDType(recognizee.getIdentifytype());//被保人证件类型
				lCInsured.setIDNo(recognizee.getIdentifynumber());//被保人证件号
				lCInsured.setRelaToAppnt("SF");//与投保人关系(本人)
				lCInsured.setAddressState(policy.getLCIProvince()); //被保人省编码
				lCInsured.setCity(policy.getLCICity()); //被保人市编码
				lCInsured.setHomeAddress(addressText);//被保险人家庭详细地址
				lCInsured.setJobCode(jobCode);//被保人职业编码
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
				lcAppnt.setHomeAddress(addressText); //投保人详细地址
				lcAppnt.setAddressState(policy.getLCAProvince()); //投保人省编码
				lcAppnt.setCity(policy.getLCACity());	//投保人市编码
				lcAppnt.setJobCode(jobCode);//投保人职业编码
				BaseInfo baseInfo = new BaseInfo();
				baseInfo.setZoneNo("MSG01");//渠道编码
				baseInfo.setBrNo(brNo);//推荐码
				baseInfo.setActyNo(ActyNo);//活动码
				Map<String, String> map = WJBLongPolicyUtil.approved(pro.getProperty("yinbaotong"), risk, lCInsured, lcAppnt,lCCont,baseInfo, payEndYearFlag, payEndYear);
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
					logger.error("承保成功，openId："+openId);
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
			policys.clear();
			policys.add(policy);
			order.setPolicys(policys);
			orderService.updateOrder(order);//更改状态
		}
		return flag;
	}
	
	
	
	/**
	 * 根据推荐人编码锁定省市
	 */
	@Action(value="wjbDepartToArea")
	public void existDepartment(){
		logger.info("根据组织机构返回省市地址");
		String resultsjon = null;
		String stateName = null;
		String cityName = null;
		String deptCode = request.getParameter("agentCode");
		String deptCode1 = deptCode.substring(0, 2).toUpperCase();
		boolean boo = depser.findByDeptCode(deptCode1);
		if(boo){
			GeDepartment geDepartment = depser.findDepart(deptCode1);
			String contactAddress = geDepartment.getContactAddress(); 
			logger.info("查询组织机构"+deptCode1+"联系地址为"+contactAddress);
			String onlyCity = pro1.getProperty("WJBonlyCity"); //只在本市出售的城市列表
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
		logger.info("查询组织机构返回json："+resultsjon);
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
	 * 特殊职业标识
	 * @param jobCode T1001_2家庭主妇  T1002_2退休人员  Y1003_3待业人员
	 * @return
	 */
	public static String jobChange(String jobCode){
		if("T1001_2".equals(jobCode) || "T1002_2".equals(jobCode) || "Y1003_3".equals(jobCode)){
			return "Y";
		}else{
			return "N";
		}
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
