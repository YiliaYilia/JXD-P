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
import cn.com.sinosoft.domain.msl.remote.MslRegion;
import cn.com.sinosoft.domain.sale.GeApplicantInsured;
import cn.com.sinosoft.domain.sale.GeChannel;
import cn.com.sinosoft.domain.sale.GeCommonApplicant;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;
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
import cn.com.sinosoft.sale.service.OrderService;
import cn.com.sinosoft.util.LongPolicyUtil;
import cn.com.sinosoft.web.msl.BaseAction;
import cn.com.sinosoft.web.service.facade.GeGeographicalAreafindService;
import cn.com.sinosoft.web.service.impl.WeiXinServiceImpl;
@ParentPackage(value = "ECS-STRUTS")
public class LongPolicyAction extends BaseAction{
	
	@Autowired
	GeGeographicalAreafindService GeGeographicalAreafindService;
	
	@Autowired
	private InsurePolicyService insurePolicyService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private GeDepartmentService depser;
	
	private static final long serialVersionUID = 1L;
	
	public static Logger logger = LoggerFactory.getLogger(LongPolicyAction.class);
	
	private List<GeOrder> orderList = new ArrayList<GeOrder>();
	
	private GeApplicantInsured recognizee;//被保人
	
	private GeApplicantInsured applicantInsured;//投保人
	
	@Autowired
	private	CommonApplicantService cas;
	
	private GeCommonApplicant commonApplicant;//常用投保人
	
	private GePolicy policy;//保单

	private GeOrder order;
	
	@Autowired
	private CodeTurnBankService CodeTurnBank;
	
	private int isBack = 0;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	private static SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy年MM月dd日");
	
	private static DecimalFormat df = new DecimalFormat("######0.00");   
	
	private static Properties pro = new Properties();
	static{
		try {
			pro.load(new InputStreamReader(LongPolicyUtil.class.getResourceAsStream("/config/SecondPeriod.properties"), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 被保人常住地的可选项
	 */
	private List<MslRegion> provinceList = new ArrayList<MslRegion>();
	
	/**
	 * 显示的保额"10,20,30"
	 */
	private List<String> policyAmountList = new ArrayList<String>();
	
	/**
	 * 显示的保险期间"3,5,10"
	 * 天/月/年 保存到Policy对象中显示
	 */
	private List<String> periodNumberList = new ArrayList<String>();
	
	/**
	 * 显示的保险期间"3,5,10"
	 * 天/月/年 保存到Policy对象中显示
	 */
	private List<String> periodTypeList = new ArrayList<String>();
	
	/**
	 * 省份默认项
	 */
	private MslRegion inputRegion;
	
	@Override
	protected void processResultBusiness(boolean resultSuccess,
			String resultCode, String resultDescription) {
		
	}
	
	
	/**
	 * 加载长险首页
	 * @return
	 */
	@Action(value = "longPolicyHome", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/growup/index.jsp"),
			@Result(name="error", location="/WEB-INF/jsp/page/growup/error.jsp")
			})
	public String home(){
		String openId =null;
		//String openId ="lks"; //测试
		HttpSession session  = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("openId")!=null){
			openId = (String)session.getAttribute("openId");
		}
		if(openId==null||openId.length()==0){
			openId = WeiXinServiceImpl.getOpenId(request);
		}
		if(openId!=null&&openId.length()>0){
			String brNo = request.getParameter("brNo");
			if(brNo==null||brNo.length()==0){
				brNo="A0000";
				logger.info(openId+" brNo第一次赋值："+brNo);
			}
			//关闭专属链接
			String longPolicyForbidBrNos = pro.getProperty("longPolicyForbidBrNo");
			if(longPolicyForbidBrNos != null && !"".equals(longPolicyForbidBrNos)){
				for(String longPolicyForbidBrNo:longPolicyForbidBrNos.split(",")){
					if(brNo.equals(longPolicyForbidBrNo)){
						try {
							response.sendError(response.SC_NOT_FOUND);
						} catch (IOException e) {
							logger.info(e.getMessage());
							return ERROR;
						}
					}
				}
			}
			String imgUrl=null;
			GeChannel channel = channelService.findChannel(brNo,"HEALTHGD");
			if(channel!=null){
				imgUrl =channel.getImgUrl();
			}else{
				channel = channelService.findChannel("A0000","HEALTHGD");
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
			session.setAttribute("openId", openId);//将获取的openId放置seesion域中
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
	 * 加载长险优惠首页
	 * @return
	 */
	@Action(value = "longPreferentialHome", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/growup/index-promotion.jsp"),
			@Result(name="error", location="/WEB-INF/jsp/page/growup/error.jsp")
			})
	public String preferentialHome(){
//		WeiXinServiceImpl weixin = new WeiXinServiceImpl();
//		String openId = weixin.getOpenId(request);
//		ServletActionContext.getRequest().getSession().setAttribute("openId", openId);//将获取的openId放置seesion域中
//		return SUCCESS;
		
		String openId = null;
		HttpSession session  = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("openId")!=null){
			openId = (String)session.getAttribute("openId");
		}
		if(openId==null||openId.length()==0){
			openId = WeiXinServiceImpl.getOpenId(request);
		}
		if(openId!=null&&openId.length()>0){
			String brNo = request.getParameter("brNo");
			if(brNo==null||brNo.length()==0){
				brNo="WH006";
				logger.info(openId+" brNo优惠活动第一次赋值："+brNo);
			}
			logger.info("openId:"+openId+"优惠活动伙伴代码:"+brNo);
			session.setAttribute("openId", openId);//将获取的openId放置seesion域中
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
	 * 加载长险活动宣称页湖北
	 * @return
	 */
	@Action(value = "PreferentialIntroduce", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/growup/index-introduce.jsp")
			})
	public String introduce(){
		return SUCCESS;
	}
	/**
	 * 加载长险活动宣传页总部
	 * @return
	 */
	@Action(value = "PreferentialIntroducetotal", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/growup/index-introducetotal.jsp")
			})
	public String introducetotal(){
		return SUCCESS;
	}
	
	
	/**
	 * 计算长险保费
	 * @return
	 */
	@Action(value = "longPolicyCalculate", results = {
			@Result(name="success",type="json"),
			@Result(name="fail",type="json")
			})
	public String longPolicyCalculate(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String)session.getAttribute("openId");//取openId
		try{
			//试算保费
			String birthday = sdf.format(recognizee.getBirthday());
			String sex = recognizee.getSex();
			String amnt = df.format(policy.getSumamount());
			String brNo = (String)session.getAttribute("brNo");
			if(brNo==null||brNo.length()==0){
				brNo="A0000";
				logger.info(openId+" brNo第二次赋值："+brNo);
			}
			//调用银保通试算接口
			String sumpremium = LongPolicyUtil.calculate(birthday, sex, amnt,pro.getProperty("yinbaotong"),brNo);
			if(sumpremium.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")){//如果算出保费
				policy.setSumbasepremium(Double.valueOf(sumpremium));//将总保费赋值给保单实体
				logger.info("保费试算成功，openId:"+openId+"合作伙伴代码"+brNo);
			}else{
				logger.error("保费试算失败："+sumpremium+",openId:"+openId+"合作伙伴代码"+brNo);
			}
		}catch(Exception e){
			logger.error(openId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 加载投保录入(点击立即投保)
	 * @return
	 */
	@Action(value = "longPolicyInsure", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/growup/fill.jsp"),
			@Result(name="error", location="/WEB-INF/jsp/page/growup/error.jsp")
			})
	public String insure(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try {
			String ActyNo = request.getParameter("ActyNo")!=null?request.getParameter("ActyNo"):"";//取得活动码
			String brNoGYX = request.getParameter("brNo")!=null?request.getParameter("brNo"):"";
			logger.info("brNoGYX:"+brNoGYX);
			session.setAttribute("ActyNo", ActyNo);//放入session留做承保核保用
			session.setAttribute("policy1", policy);//保额保费
			session.setAttribute("recognizee1", recognizee);//被保人生日性别
			String brNo = (String)session.getAttribute("brNo");
			logger.info("openId:"+openId+"合作伙伴代码:"+brNo);
			String sex = textChange(recognizee.getSex(),"sex");
			String birthday = dateSdf.format(recognizee.getBirthday());
			GeChannel channel = (GeChannel) session.getAttribute("channel");
			if(openId!=null && openId.length()>0){
			List<GeCommonApplicant> comAppList = cas.findComApplicantListByOpenId(openId);
				if(comAppList!=null){
					request.setAttribute("comAppList", comAppList);//常用投保人
				}
			}
			if(null != channel){
				request.setAttribute("isAgentCode", channel.getIsAgentcode());//推荐人是否必填
			}
			request.setAttribute("sex", sex);//被保人性别
			request.setAttribute("birthday", birthday);//被保人生日
			request.setAttribute("brNo",brNo); //渠道编码
			resultBusiness(true);
		}catch (Exception e) {
			logger.error(openId+" : "+ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 加载投保录入(点击立即投保)
	 * @return
	 */
	@Action(value = "insurePromotion", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/growup/fill-promotion.jsp"),
			@Result(name="error", location="/WEB-INF/jsp/page/growup/error.jsp")
			})
	public String insurePromotion(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try {
			String ActyNo = request.getParameter("ActyNo")!=null?request.getParameter("ActyNo"):"";//取得活动码
			session.setAttribute("ActyNo", ActyNo);//放入session留做承保核保用
			session.setAttribute("policy1", policy);//保额保费优惠码
			session.setAttribute("recognizee1", recognizee);//被保人生日性别
			String sex = textChange(recognizee.getSex(),"sex");
			String birthday = dateSdf.format(recognizee.getBirthday());
			request.setAttribute("sex", sex);//被保人性别
			request.setAttribute("birthday", birthday);//被保人生日
			resultBusiness(true);
		}catch (Exception e) {
			logger.error(openId+" : "+ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 提交投保录入并加载健康告知(下一步：健康告知)
	 * @return
	 */
	@Action(value = "longPolicyInsureInput", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/growup/notice.jsp"),
			@Result(name="error", location="/WEB-INF/jsp/page/growup/error.jsp")
			})
	public String insureInput(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try {
			//取得省市
			String province = request.getParameter("province");
			String city = request.getParameter("city");
			String conty = request.getParameter("conty");
			String adressText = request.getParameter("address");
			adressText = conty+"区/县"+adressText;
			//省市转换编码
			String state_code = GeGeographicalAreafindService.findArea_code(province, "1");
			String city_code = GeGeographicalAreafindService.findArea_code(city, "2");
			applicantInsured.setProvince(province);
			applicantInsured.setCity(city);
			if(commonApplicant!=null){
//				如果是常用投保人
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
			//将其它信息持久化至
			session.setAttribute("policy", policy);
			session.setAttribute("recognizee", recognizee);
			session.setAttribute("applicantInsured", applicantInsured);
			session.setAttribute("state_code", state_code);
			session.setAttribute("city_code", city_code);
			session.setAttribute("adressText", adressText);
			logger.info(openId+"：提交投保信息成功");
		} catch (Exception e) {
			logger.info(openId+"："+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	
	/**
	 * 加载投保确认
	 * @return
	 */
	@Action(value = "longPolicyInsureConfirm", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/growup/sure.jsp"),
			@Result(name="error", location="/WEB-INF/jsp/page/growup/error.jsp")
			})
	public String insureConfirm(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		//String HealthFlag = ServletActionContext.getRequest().getParameter("HealthFlag");
		String flag = "";
		String flag1 = "";
		try {
			GePolicy policy = (GePolicy)session.getAttribute("policy");
			GeApplicantInsured applicantInsured = (GeApplicantInsured)session.getAttribute("applicantInsured");
			GeApplicantInsured recognizee = (GeApplicantInsured)session.getAttribute("recognizee");
			GeApplicantInsured recognizee1 = (GeApplicantInsured)session.getAttribute("recognizee1");
			GePolicy policyI = (GePolicy)session.getAttribute("policy1");
			String bankCode = policy.getBankAccountNumber();
			if(bankCode!=null&&!bankCode.equals("")){
				flag = "1";
			}else{
				flag = "0";
			}
			String agentCode = policy.getAgentcode();
			if(agentCode!=null&&!agentCode.equals("")){
				flag1 = "1";
			}else{
				flag1 = "0";
			}
			
			request.setAttribute("flag",flag);
			request.setAttribute("flag1",flag1);
			request.setAttribute("insrelationapp",textChange(recognizee.getInsrelationapp(),"relation"));//被保人与投保人的关系
			request.setAttribute("identifytype1", textChange(applicantInsured.getIdentifytype(), "idType"));//投保人证件类型
			request.setAttribute("identifytype2", textChange(recognizee.getIdentifytype(), "idType"));//投保人证件类型
			request.setAttribute("sex1", textChange(applicantInsured.getSex(),"sex"));//投保人性别
			request.setAttribute("sex2", textChange(recognizee1.getSex(),"sex"));
			request.setAttribute("birthday2",dateSdf.format(recognizee1.getBirthday()));
			request.setAttribute("birthday1",dateSdf.format(applicantInsured.getBirthday()));//投保人生日
			request.setAttribute("policy", policy);
			request.setAttribute("policyI", policyI);
			request.setAttribute("applicantInsured", applicantInsured);
			request.setAttribute("recognizee", recognizee);
			logger.info(openId+"："+"健康提交标识成功");
			resultBusiness(true);
		} catch (Exception e) { 
			logger.info(openId+"："+e.getMessage());
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
	@Action(value = "longPolicyInsureSubmit")
	public void insureSubmit(){
		String resultsjon = null;
		String deptid = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		String ActyNo = (String) session.getAttribute("ActyNo");//取得活动码
		try {
			GePolicy policy = (GePolicy)session.getAttribute("policy");
			GePolicy policy1 = (GePolicy)session.getAttribute("policy1");//首页实体：保额保费,优惠码
			String adressText = (String) session.getAttribute("adressText");  //详细地址
			String state_code = (String) session.getAttribute("state_code");	//省编码
			String city_code = (String) session.getAttribute("city_code");		//市编码
			GeApplicantInsured applicantInsured = (GeApplicantInsured)session.getAttribute("applicantInsured");
			GeApplicantInsured recognizee = (GeApplicantInsured)session.getAttribute("recognizee");
			GeApplicantInsured recognizee1 = (GeApplicantInsured)session.getAttribute("recognizee1");//首页实体：被保人生日性别
			GeCommonApplicant comapp = (GeCommonApplicant)session.getAttribute("commonApplicant");
			String bankAccountNumber = policy.getBankAccountNumber();//续保银行账号
			String brNo = (String)session.getAttribute("brNo");
			if(null == brNo || "A0000".equals(brNo)){
				//截取推荐人编码作为渠道
				brNo = subCode(policy.getAgentcode());
				logger.info(openId+" brNo第三次赋值："+brNo);
			}
			if(brNo==null||brNo.length()==0){
				String deptidhHead = policy.getDeptid();
				if(deptidhHead!=null&&deptidhHead.length()>0){
					deptid = depser.findDepart(deptidhHead).getDeptid(); //加入机构代码
				}else{
					deptid =depser.findRootDepart().getDeptid();
				}
			}else if("A0000".equals(brNo)){
				deptid =depser.findRootDepart().getDeptid();
			}else{
				boolean depFlag = depser.findByDeptCode(brNo.substring(0,2).toUpperCase());
				if(depFlag){
					deptid = depser.findDepart(brNo.substring(0,2).toUpperCase()).getDeptid();
				}else{
					deptid =depser.findRootDepart().getDeptid();
				}
			}
			policy.setDeptid(deptid);
			policy.setBrNo(brNo);
//			policy.setContnumber(policy1.getContnumber());
			policy.setSumamount(policy1.getSumamount());//取保额
			policy.setSumbasepremium(policy1.getSumbasepremium());//取保费
			policy.setInsuretime(new Date());//投保时间
			policy.setSource("changxian");
			policy.setProdoctcode("HEALTHGD");//产品编号
			policy.setRiskcode("HEALTHGD");//险种代码
			policy.setOriginate("0");//官网直销
			policy.setApplicantname(applicantInsured.getName());//投保人姓名
			policy.setApplicantaddress(applicantInsured.getAddress());//投保人地址
			policy.setInsuredname(recognizee.getName());//被保人姓名
			policy.setClasscode("1");//1代表主险
			policy.setPolicyterm("1");
			policy.setPolicytermtype("年");
			policy.setProductname("瑞泰成长卫士少儿重大疾病保险");
			policy.setCondition("0");//未对账
			policy.setIslegalflag("2");//法定受益人
			policy.setAgentcode(policy.getAgentcode()==null?"":policy.getAgentcode().toUpperCase());//推荐人码
			policy.setPreferentialcode(policy1.getPreferentialcode()==null?"":policy1.getPreferentialcode().toUpperCase());//优惠码
			logger.info(openId+" policy赋值完毕");
			applicantInsured.setFlag("1");//投保人
			applicantInsured.setInsrelationapp("B");//投保人与被保人关系:父母
			recognizee.setBirthday(recognizee1.getBirthday());
			recognizee.setSex(recognizee1.getSex());
			recognizee.setFlag("2");//被保人
			recognizee.setInsrelationapp("3");//被保人与投保人关系:子女
			Set<GeApplicantInsured> applicantInsureds = new HashSet<GeApplicantInsured>();
			applicantInsureds.add(recognizee);
			applicantInsureds.add(applicantInsured);
			//核保
			LCCont lCCont = new LCCont();
			if(bankAccountNumber!=null&&bankAccountNumber.length()>0){//如果存在续保
				//银行编码转银行名称存库
				
				String bankBranchCode = policy.getBankBranchCode();
				if(bankBranchCode!=null&&bankBranchCode.length()>0){
					String bank = CodeTurnBank.codeTurnbank(bankBranchCode);
					policy.setBank(bank);
				}
				lCCont.setBankAccNo(bankAccountNumber);
				lCCont.setRenewalPermit("Y");
				lCCont.setAccBankCode(policy.getBankBranchCode());
				lCCont.setBankProvince(policy.getBankProvince());
				lCCont.setBankCity(policy.getBankCity());
			}else{
				lCCont.setAccBankCode("MSG01");//渠道编码
			}
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
			lCInsured.setRelaToAppnt("CH");//与投保人关系(子女)
			lCInsured.setAddressState(state_code); //被保人省编码
			lCInsured.setCity(city_code); //被保人市编码
			lCInsured.setHomeAddress(adressText);//被保险人家庭详细地址
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
			lcAppnt.setRelaToInsured("PA");//与被保人关系(父母)
			BaseInfo baseInfo = new BaseInfo();
			baseInfo.setZoneNo("MSG01");//渠道编码
			baseInfo.setBrNo(brNo);//推荐码
			baseInfo.setActyNo(ActyNo);
			logger.info(openId+" 核保接口调用开始");
			//调用核保接口
			String sumpremium = LongPolicyUtil.underwriting(pro.getProperty("yinbaotong"),risk, lCInsured, lcAppnt,lCCont,baseInfo);
			if(sumpremium.equals("1")){//核保成功
				policy.setStatus("1");//核保成功
				logger.info("openId:"+openId+"核保成功");
				resultsjon = "{\"flag\":\"0\",\"content\":\"核保成功\"}";
			}else{
				policy.setStatus("2");//核保失败
				logger.error("openId:"+openId+"核保失败："+sumpremium);
				resultsjon = "{\"flag\":\"1\",\"content\":\""+sumpremium+"\"}";
			}
			//创建订单对象
			logger.info("创建订单对象");
			GeOrder order = insurePolicyService.insureInput(policy, applicantInsureds);
			order.setPaymentplatform("1");//支付平台：微信
			order.setChannelCode("003");//登录途径，微信公众号
			order.setHealthFlag("N");//健康告知选择
			String ordercode = OrderHelper.getOrderNumber("RT","000");//获取订单号
			if(ActyNo.equals("discont1")){
				ordercode = OrderHelper.getOrderNumber("RT","001");//获取订单号
			}
			logger.info("订单号："+ordercode);
//			order.setContnumber(policy.getContnumber());
			order.setOrdercode(ordercode);
			order.setOrderamount(policy.getSumbasepremium());
			order.setPaystatus("0");//待支付
			order.setSubmittime(new Date());//提交时间
			order.setStatus("0");//未对账
			order.setProductname("瑞泰成长卫士少儿重大疾病保险");
			order.setLoginWay("03");//微信版
			order.setCoreproductcode("HEALTHGD");//产品代码
			order.setPayway("10");//微信支付
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
			order.setBankBranchName(policy.getBank());
			order.setBankBranchCode(policy.getBankBranchCode());
			order.setBankCity(policy.getBankCity());
			order.setBankProvince(policy.getBankProvince());
			order.setBrNo(brNo);
			order.setDeptid(deptid);
//			order.setRenewalflag(policy.getRenewalflag());//成长卫士续保标识
			logger.info("order存库");
			if(comapp!=null){
				cas.saveComApplicant(comapp);//保存常用投保人
				session.removeAttribute("commonApplicant");
			}
			
			logger.info("openId:"+openId+"订单信息加入合作伙伴代码"+brNo);
			orderService.saveOrder(order);//保存状态
			/**
			 * 订单对象的初始化完成
			 */
			logger.info("ordercode0"+ordercode);
			session.setAttribute("ordercode", ordercode);//将订单号存入seesion用作承保后状态更改
			session.removeAttribute("recognizee");
			session.removeAttribute("applicantInsured");
			session.removeAttribute("recognizee1");
			session.removeAttribute("policy1");
			session.removeAttribute("policy");
		}catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			resultsjon = "{\"flag\":\"1\",\"content\":\"核保异常\"}";
			e.printStackTrace();
		}finally{
			super.renderJson(resultsjon);
		}
		
	}
	
	
	/**
	 * 承保并跳转至支付成功页面
	 * @return
	 */
	@Action(value = "toSuccess", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/growup/success.jsp"),
			@Result(name="error", location="/WEB-INF/jsp/page/growup/error.jsp")
			})
	public String toSuccess(){
		//取openId
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		String source = request.getParameter("source");//取来源，判断长短险
		if(source.equals("changxian")){
			try{
				String ordercode = (String)session.getAttribute("ordercode");
				logger.info("ordercode:"+ordercode);
				GeOrder order = orderService.getOrderByOrderCode(ordercode);//从库里取出订单实体
				logger.info("Order:"+order);
				String productname = order.getProductname();//产品名称
				String orderamount = df.format(order.getOrderamount());//订单金额
				String paydate = dateSdf.format(new Date());//支付日期
				request.setAttribute("productname", productname);
				request.setAttribute("orderamount", orderamount);
				request.setAttribute("paydate", paydate);
				return SUCCESS;
			}catch (Exception e) {
				logger.error("承保或更改状态异常，openId:"+openId);
				e.printStackTrace();
				return ERROR;
			}
		}else if(source.equals("duanxian")){
			logger.error("入参异常,入短险");
			return ERROR;
		}else{
			logger.error("入参异常,为空值");
			return ERROR;
		}
	}
	
	
	/**
	 * 承保并跳转至支付成功页面 (测试用)
	 * @return
	 */
	@Action(value = "toTestSuccess", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/growup/success.jsp"),
			@Result(name="error", location="/WEB-INF/jsp/page/growup/error.jsp")
			})
	public String toTestSuccess(){
		//取openId
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		String source = request.getParameter("source");//取来源，判断长短险
		if(source.equals("changxian")){
			String flag = longAcceptance((String) session.getAttribute("ordercode"),openId);
			try{
				String ordercode = (String)session.getAttribute("ordercode");
				logger.info("ordercode:"+ordercode);
				GeOrder order = orderService.getOrderByOrderCode(ordercode);//从库里取出订单实体
				logger.info("Order:"+order);
				String productname = order.getProductname();//产品名称
				String orderamount = df.format(order.getOrderamount());//订单金额
				String paydate = dateSdf.format(new Date());//支付日期
				request.setAttribute("productname", productname);
				request.setAttribute("orderamount", orderamount);
				request.setAttribute("paydate", paydate);
				if(flag.equals("1")){
					return SUCCESS;
				}else{
					return ERROR;
				}
			}catch (Exception e) {
				logger.error("承保或更改状态异常，openId:"+openId);
				e.printStackTrace();
				return ERROR;
			}
		}else if(source.equals("duanxian")){
			logger.error("入参异常,入短险");
			return ERROR;
		}else{
			logger.error("入参异常,为空值");
			return ERROR;
		}
	}

	/**
	 * 长险承保方法
	 * @param ordercode
	 * @param openId
	 * @return 1承保成功，0承保失败
	 */
	public String longAcceptance(String ordercode,String openId){
		String ActyNo = "";//取得活动码
		String flag = "0";
		if(ordercode.startsWith("RT001")){
			ActyNo = "discont1";
		}
		//长险承保
		GeApplicantInsured recognizee = null;
		GeApplicantInsured applicantInsured = null;
		GeOrder order = orderService.getOrderByOrderCode(ordercode);//从库里取出订单实体
		Set<GePolicy> policys = order.getPolicys();
		Iterator<GePolicy> it = policys.iterator();
		GePolicy policy = it.next();
		String brNo = order.getBrNo();
		if(brNo==null||brNo.length()==0){
			brNo =  subCode(policy.getAgentcode());
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
				String code = policy.getBankBranchCode();//续保银行
				String bankAccountNumber = policy.getBankAccountNumber();//续保银行账号
				LCCont lCCont = new LCCont();
				if(code!=null&&bankAccountNumber!=null&&code.length()>0&&bankAccountNumber.length()>0){//如果存在续保
					lCCont.setBankAccNo(bankAccountNumber);//续保银行
					lCCont.setRenewalPermit("Y");//自动续保标志
					lCCont.setAccBankCode(order.getBankBranchCode());
					lCCont.setBankProvince(order.getBankProvince());
					lCCont.setBankCity(order.getBankCity());
				}else{
					lCCont.setAccBankCode("MSG01");//渠道编码
				}
				
				String addressText = applicantInsured.getAddress().replaceFirst(applicantInsured.getProvince()+applicantInsured.getCity(),"");//详细地址
				String state_code = GeGeographicalAreafindService.findArea_code(applicantInsured.getProvince(), "1");
				String city_code = GeGeographicalAreafindService.findArea_code(applicantInsured.getCity(), "2");
				
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
				lCInsured.setRelaToAppnt("CH");//与投保人关系(子女)
				lCInsured.setAddressState(state_code); //被保人省编码
				lCInsured.setCity(city_code); //被保人市编码
				lCInsured.setHomeAddress(addressText);//被保险人家庭详细地址
				
				LCAppnt lcAppnt = new LCAppnt();//投保人信息
				lcAppnt.setAppntName(applicantInsured.getName());//投保人姓名
				lcAppnt.setAppntSex(applicantInsured.getSex());//投保人性别
				lcAppnt.setAppntIDType(applicantInsured.getIdentifytype());//投保人证件类型
				lcAppnt.setAppntIDNo(applicantInsured.getIdentifynumber());//投保人证件号
				lcAppnt.setAppntBirthday(sdf.format(applicantInsured.getBirthday()));//投保人生日
				lcAppnt.setAppntMobile(applicantInsured.getMobile());//投保人手机
				lcAppnt.setEmail(applicantInsured.getEmail());//投保人邮箱
				lcAppnt.setHomeAddress(addressText); //投保人详细地址
				lcAppnt.setAddressState(state_code); //投保人省编码
				lcAppnt.setCity(city_code);	//投保人市编码
				lcAppnt.setRelaToInsured("PA");//与被保人关系(父母)
				
				BaseInfo baseInfo = new BaseInfo();
				baseInfo.setZoneNo("MSG01");//渠道编码
				baseInfo.setBrNo(brNo);//推荐码
				baseInfo.setActyNo(ActyNo);//活动码
				Map<String, String> map = LongPolicyUtil.approved(pro.getProperty("yinbaotong"), risk, lCInsured, lcAppnt,lCCont,baseInfo);
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
	
	
	/**
	 * 截取推荐人编码前5位作为渠道 如果没有默认为A0000
	 */
	public static String subCode(String agentCode){
		String code = "A0000";
		if(null != agentCode){
			if(agentCode.length()>=5){
				boolean isWord=agentCode.substring(0, 2).matches("[a-zA-Z]+");
				if(isWord){
					code = agentCode.substring(0, 5).toUpperCase();
				}
			}
		} 
		return code;
	}

	@Override
	public String getResultCode() {
		return super.getResultCode();
	}

	@Override
	public String getResultDescription() {
		return super.getResultDescription();
	}

	@Override
	public boolean getResultSuccess() {
		return super.getResultSuccess();
	}

	@Override
	public void setResultCode(String resultCode) {
		super.setResultCode(resultCode);
	}

	@Override
	public void setResultDescription(String resultDescription) {
		super.setResultDescription(resultDescription);
	}

	@Override
	public void setResultSuccess(boolean resultSuccess) {
		super.setResultSuccess(resultSuccess);
	}

	public List<GeOrder> getOrderList() {
		return orderList;
	}


	public void setOrderList(List<GeOrder> orderList) {
		this.orderList = orderList;
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


	public List<MslRegion> getProvinceList() {
		return provinceList;
	}


	public void setProvinceList(List<MslRegion> provinceList) {
		this.provinceList = provinceList;
	}

	public List<String> getPolicyAmountList() {
		return policyAmountList;
	}

	public void setPolicyAmountList(List<String> policyAmountList) {
		this.policyAmountList = policyAmountList;
	}

	public List<String> getPeriodNumberList() {
		return periodNumberList;
	}


	public void setPeriodNumberList(List<String> periodNumberList) {
		this.periodNumberList = periodNumberList;
	}


	public List<String> getPeriodTypeList() {
		return periodTypeList;
	}


	public void setPeriodTypeList(List<String> periodTypeList) {
		this.periodTypeList = periodTypeList;
	}


	public void setInsurePolicyService(InsurePolicyService insurePolicyService) {
		this.insurePolicyService = insurePolicyService;
	}

	public MslRegion getInputRegion() {
		return inputRegion;
	}


	public void setInputRegion(MslRegion inputRegion) {
		this.inputRegion = inputRegion;
	}


	public int getIsBack() {
		return isBack;
	}


	public void setIsBack(int isBack) {
		this.isBack = isBack;
	}


	public GeApplicantInsured getRecognizee() {
		return recognizee;
	}


	public void setRecognizee(GeApplicantInsured recognizee) {
		this.recognizee = recognizee;
	}


	public GeApplicantInsured getApplicantInsured() {
		return applicantInsured;
	}


	public void setApplicantInsured(GeApplicantInsured applicantInsured) {
		this.applicantInsured = applicantInsured;
	}

	public GeCommonApplicant getCommonApplicant() {
		return commonApplicant;
	}


	public void setCommonApplicant(GeCommonApplicant commonApplicant) {
		this.commonApplicant = commonApplicant;
	}

}
