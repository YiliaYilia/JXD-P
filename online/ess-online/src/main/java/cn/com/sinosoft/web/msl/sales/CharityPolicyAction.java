package cn.com.sinosoft.web.msl.sales;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
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

import com.opensymphony.xwork2.ActionContext;

import cn.com.sinosoft.common.OrderHelper;
import cn.com.sinosoft.core.utils.DateUtils;
import cn.com.sinosoft.core.utils.JsonUtils;
import cn.com.sinosoft.core.utils.StringUtils;
import cn.com.sinosoft.domain.sale.GeApplicantInsured;
import cn.com.sinosoft.domain.sale.GeChildlist;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.domain.yinbaotong.BaseInfo;
import cn.com.sinosoft.domain.yinbaotong.LCAppnt;
import cn.com.sinosoft.domain.yinbaotong.LCCont;
import cn.com.sinosoft.domain.yinbaotong.LCInsured;
import cn.com.sinosoft.domain.yinbaotong.Risk;
import cn.com.sinosoft.msl.service.CharityPolicyService;
import cn.com.sinosoft.msl.service.InsurePolicyService;
import cn.com.sinosoft.sale.service.OrderService;
import cn.com.sinosoft.util.LongPolicyUtil;
import cn.com.sinosoft.web.msl.BaseAction;
import cn.com.sinosoft.web.service.impl.WeiXinServiceImpl;
import net.sf.json.JsonConfig;
@ParentPackage(value = "ECS-STRUTS")
public class CharityPolicyAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static Logger logger = LoggerFactory.getLogger(CharityPolicyAction.class);
	
	private GeApplicantInsured applicantInsured;//投保人 

	@Autowired
	private CharityPolicyService charityPolicyService;
	
	@Autowired
	private InsurePolicyService insurePolicyService;
	
	@Autowired
	OrderService orderService;


	private GeChildlist geChildlist; // 被捐赠人
	


	private GePolicy policy;//保单
	
	private GeOrder order;
	
	private String donationFlag; //少儿重疾保障捐赠勾选
	
	private String helpStudyFlag; //助学捐赠

	@Override
	protected void processResultBusiness(boolean resultSuccess,
			String resultCode, String resultDescription) {
		
	}
	
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
	 * 查找符合条件的儿童
	 * @param geChildlist
	 * @return
	 */
	public GeChildlist getChild(GeChildlist geChildlist){
		GeChildlist geChildOne = null;
		//String id = null;
		//ChildObject childObject = ChildObject.getInstance();
		//Set<String> childSet = childObject.getChildSet();
		List<GeChildlist> matchpeople = charityPolicyService.findGeChildlist(geChildlist);
		if(matchpeople!=null && matchpeople.size()>0){
			int number = new Random().nextInt(matchpeople.size());
			//取出被保人
			geChildOne = matchpeople.get(number);
//			for(GeChildlist child:matchpeople){
//				if(childSet.contains(geChildOne.getApplicantinsuredno())){
//					geChildOne = child;
//					id = null;
//				}else{
//					id = geChildOne.getApplicantinsuredno();
//					break;
//				}
//			}
//			if(id == null){
//				geChildOne = null;
//			}else{
//				childSet.add(id);
//			}
		}
		return geChildOne;
}
	/**
	 * 加载慈善项目详情页
	 * @return
	 */
	@Action(value = "charityPolicyDetails", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/charity/product.jsp")
			})
	public String details(){
		return SUCCESS;
	}
	
	/**
	 * 加载慈善项目首页
	 * @return
	 */
	@Action(value = "charityPolicyHome", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/charity/index.jsp")
			})
	public String home(){
		new WeiXinServiceImpl();
		String openId = WeiXinServiceImpl.getOpenId(request);
//		String openId="oipGbs2t1U4EYgFBePg9H2FonuaA";
		ServletActionContext.getRequest().getSession().setAttribute("openId", openId);//将获取的openId放置seesion域中
		try {
			logger.info("加载慈善项目首页: "+openId);
			resultBusiness(true);
		} catch (Exception e) {
			logger.info(openId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 进入被捐赠儿童随机匹配页
	 * @return
	 */
	@Action(value = "matchRecognizee", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/charity/insured.jsp"),
			@Result(name="fail", location="/WEB-INF/jsp/....jsp")
			})
	public String match(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try {
			//查询被保人基本信息
			GeChildlist geChildOne = getChild(geChildlist);
			if(geChildOne!=null){
				ActionContext.getContext().put("matchpeople", geChildOne);
				String birthday = geChildOne.getBirthday();
				geChildOne.setAge(setAge(birthday));
				session.setAttribute("childInfo", geChildOne);
				if(!StringUtils.isEmpty(geChildOne.getSex())){
						ActionContext.getContext().put("sex",  textChange(geChildOne.getSex(),"sex"));
				}else{
					ActionContext.getContext().put("sex", "");
				}
			}else{
				request.setAttribute("text","1");
			}
			resultBusiness(true);
		}catch (Exception e) {
			logger.info(openId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	//计算年龄
	public int setAge(String birthday) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthdayDate= sdf.parse(birthday);
		Date date = new Date();
		long day = (date.getTime()-birthdayDate.getTime())/(24*60*60*1000);
		int age = (int)(day/365);
		return age;
	}
	/**
	 * 再次匹配
	 * @return
	 */
	@Action(value = "otherMatchRecognizee", results = {
			@Result(name="success",type="json"),
			@Result(name="fail",type="json")
			})
	public void otherMatch(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try{
			//查询被保人基本信息
			GeChildlist geChildOne = getChild(geChildlist);
			if(geChildOne!=null){
				String birthday = geChildOne.getBirthday();
				geChildOne.setAge(setAge(birthday));
				session.setAttribute("childInfo", geChildOne);
				JsonConfig jsonConfig = new JsonConfig();
				renderJson(JsonUtils.convertObject(geChildOne,jsonConfig));
			}else{
				JsonConfig jsonConfig = new JsonConfig();
				GeChildlist child = new GeChildlist();
				renderJson(JsonUtils.convertObject(child,jsonConfig));
			}
		}catch(Exception e){
			logger.error(openId+"："+e.getMessage()); 
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 加载赠险选择页面
	 * @return
	 */
	@Action(value = "policyChoice", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/charity/choose.jsp")
			})
	public String choice(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		GeChildlist geChild = (GeChildlist) session.getAttribute("childInfo");
		session.setAttribute("childInfo", geChild);
		try {
			logger.info("加载赠险选择页面: "+openId);
			resultBusiness(true);
		} catch (Exception e) {
			logger.info(openId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 加载试算页面
	 * @return
	 */
	@Action(value = "policyCalculate", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/charity/fill.jsp")
			})
	public String Calculate(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try {
			GeChildlist geChild = (GeChildlist) session.getAttribute("childInfo");
			request.setAttribute("donationFlag",donationFlag);
			session.setAttribute("donationFlag", donationFlag);
			request.setAttribute("helpStudyFlag",helpStudyFlag);
			session.setAttribute("helpStudyFlag", helpStudyFlag);
			request.setAttribute("grade",geChild.getGrade()); //年级
			request.setAttribute("tuition",geChild.getTuition()); //学费
			String birth = geChild.getBirthday();
			String birthday = birth.replace("-", "");
			String sex = geChild.getSex();
			String amnt = "100000.00";
			if(donationFlag.equals("1")){
			//调用银保通试算接口
			String sumpremium = LongPolicyUtil.calculate(birthday, sex, amnt,pro.getProperty("yinbaotong"));
			if(sumpremium.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")){//如果算出保费
				//2015.10.12——2015.12.31 进行优惠
				sumpremium = setActyPay(birth,sumpremium,amnt);
				request.setAttribute("sumpremium",sumpremium);
				logger.info("默认保费试算成功，openId:"+openId);
			}else{
				logger.error("默认保费试算失败："+sumpremium+",openId:"+openId);
			}
			}else{
				request.setAttribute("sumpremium","0");
			}
			List<Double> list = orderService.findSumBookMoney();
			if(list!=null && list.size()>0){
				if(list.get(0)!=null){
					Double a = list.get(0);	
					double b = a%30000;
					String sumBookMoney=String.valueOf(b);
					request.setAttribute("sumBookMoney",sumBookMoney);
					System.out.println(sumBookMoney);
				}else{
					request.setAttribute("sumBookMoney","0.00");
				}
			}else{
				request.setAttribute("sumBookMoney","0.00");	
			}
			logger.info("加载试算页面: "+openId);
			resultBusiness(true);
		} catch (Exception e) {
			logger.info(openId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	//设置优惠价格
	public String setActyPay(String birth,String sumpremium,String amnt) throws ParseException{
		Date startDate = DateUtils.toDate("2015-10-9");
		Date endDate = DateUtils.toDate("2116-01-01");
		Date date = new Date();
		if(date.getTime() > startDate.getTime() && date.getTime() < endDate.getTime()){
			int age = setAge(birth);
			double i_sumpremium =  Double.parseDouble(sumpremium);
			double d_amnt = Double.parseDouble(amnt)/100000;//份数
			if(age >=3 && age < 18){
				sumpremium = (i_sumpremium - d_amnt*10)+"".trim();
			}
			if(age >=0 && age < 3){
				sumpremium = (i_sumpremium - d_amnt*15)+"".trim();
			}
		}
		
		return sumpremium;
	}
	
	/**
	 * 是否是优惠时间段
	 * @return
	 */
	public boolean isActy(){
		Date startDate = DateUtils.toDate("2015-10-9");
		Date endDate = DateUtils.toDate("2116-01-01");
		Date date = new Date();
		if(date.getTime() > startDate.getTime() && date.getTime() < endDate.getTime()){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 计算赠险保费
	 * @return
	 */
	@Action(value = "charityPolicyCalculate", results = {
			@Result(name="success",type="json"),
			@Result(name="fail",type="json")
			})
	public void charityPolicyCalculate(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try{
			//试算保费
			GeChildlist geChild = (GeChildlist) session.getAttribute("childInfo");
			//生日为String 类型  需处理
			String birth = geChild.getBirthday();
			String birthday = birth.replace("-", "");
			String sex = geChild.getSex();
			String amnt = df.format(policy.getSumamount());
			//调用银保通试算接口
			String sumpremium = LongPolicyUtil.calculate(birthday, sex, amnt,pro.getProperty("yinbaotong"));
			if(sumpremium.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")){//如果算出保费
				//2015.10.12——2015.12.31 进行优惠
				sumpremium = setActyPay(birth, sumpremium, amnt);
				policy.setSumbasepremium(Double.valueOf(sumpremium));//将总保费赋值给保单实体
				//用于份数回显
				String fill_count = (String)  session.getAttribute("fill_count");
				String sex2 = (String) session.getAttribute("sex2");
				String birthday2 = (String) session.getAttribute("birthday2");
				String identifytype2 = (String) session.getAttribute("identifytype2");
				if(!"".equals(fill_count) && null != fill_count){
					policy.setUnitcount(fill_count);
					session.removeAttribute("fill_count");
				}
				if(!"".equals(sex2) && null != sex2){
					policy.setSource(sex2);//代替性别
					session.removeAttribute("sex2");
				}
				if(!"".equals(birthday2) && null != birthday2){
					policy.setProdoctcode(birthday2);//代替生日
					session.removeAttribute("birthday2");
				}
				if(!"".equals(identifytype2) && null != identifytype2){
					policy.setRiskcode(identifytype2);//代替类别
					session.removeAttribute("identifytype2");
				}
				JsonConfig jsonConfig = new JsonConfig();
				renderJson(JsonUtils.convertObject(policy,jsonConfig));
				logger.info("保费试算成功，openId:"+openId);
			}else{
				logger.error("保费试算失败："+sumpremium+",openId:"+openId);
			}
			
			
		}catch(Exception e){
			logger.error(openId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
		}
	}
	
	/**
	 * 提交捐赠录入并跳转到捐赠行动单
	 * @return
	 */
	@Action(value = "charityPolicyInsure", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/charity/actlist.jsp"),
			@Result(name="fail", location="/WEB-INF/jsp/....jsp")
			})
	public String insureInput(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try {
			session.setAttribute("policy", policy);
			session.setAttribute("applicantInsured", applicantInsured);
			logger.info(openId+"：提交捐赠信息成功");
			//捐赠行动单显示内容
			//1、捐赠人信息
			request.setAttribute("applicantInsured", applicantInsured);
			request.setAttribute("identifytype1", textChange(applicantInsured.getIdentifytype(), "idType"));//投保人证件类型
			request.setAttribute("name1",applicantInsured.getName());
			request.setAttribute("sex1", textChange(applicantInsured.getSex(),"sex"));//投保人性别
			request.setAttribute("birthday1",dateSdf.format(applicantInsured.getBirthday()));//投保人生日
			session .setAttribute("sex2", textChange(applicantInsured.getSex(),"sex"));
			session .setAttribute("birthday2",dateSdf.format(applicantInsured.getBirthday()));
			session.setAttribute("identifytype2", textChange(applicantInsured.getIdentifytype(), "idType"));
			//2、被捐赠人信息
			GeChildlist geChild = (GeChildlist) session.getAttribute("childInfo");
			request.setAttribute("name2",geChild.getName());
			request.setAttribute("sex2", textChange(geChild.getSex(),"sex"));
			request.setAttribute("age2", geChild.getAge());
			//3\4
			Double sumamounts=0.00;
			if(policy.getSumamount()!=null){
				sumamounts = policy.getSumamount();
				session.setAttribute("sumamounts", df.format(sumamounts));
				double d_amnt = sumamounts/100000;//份数
				session.setAttribute("fill_count",(int)d_amnt+"".trim());//份数回显
			}
			request.setAttribute("sumamounts", df.format(sumamounts));
			Double sumMoney = null;
			if(policy.getSumbasepremium()!=null){
				request.setAttribute("sumbasepremium", df.format(policy.getSumbasepremium()));
				sumMoney = policy.getSumbasepremium();
			}	
			if(policy.getStipend()!=null){
				sumMoney +=  policy.getStipend();
				request.setAttribute("stipend", df.format(policy.getStipend()));
			}else{
				request.setAttribute("stipend", "0.00");
			}
			if(policy.getBookmoney()!=null){
				sumMoney +=  policy.getBookmoney();
				request.setAttribute("bookmoney", df.format(policy.getBookmoney()));
			}else{
				request.setAttribute("bookmoney", "0.00");
			}
			request.setAttribute("sumMoney", df.format(sumMoney));
			String donationFlag = (String) session.getAttribute("donationFlag");
			request.setAttribute("donationFlag", donationFlag);
			String helpStudyFlag = (String) session.getAttribute("helpStudyFlag");
			request.setAttribute("helpStudyFlag", helpStudyFlag);
			
		} catch (Exception e) {
			logger.info(openId+"："+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 提交核保并支付
	 * @return
	 */
	@Action(value = "charityPolicyInsureSubmit")
	public void insureSubmit(){
		String resultsjon = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try {
			String donationFlag = (String) session.getAttribute("donationFlag");
			GePolicy policy = (GePolicy)session.getAttribute("policy");
			GeApplicantInsured applicantInsured = (GeApplicantInsured)session.getAttribute("applicantInsured");//投保人
			GeChildlist geChild = (GeChildlist) session.getAttribute("childInfo");//被保人
			//检查此儿童是否已被承保
//			GeChildlist child = charityPolicyService.getChildlist(geChild);
			GeChildlist child =null;
			logger.debug("保额:"+child.getAmount());
			if(child.getAmount()>0.00){
				resultsjon = "{\"flag\":\"1\",\"content\":\"该儿童已被承保\"}";
			}else{
				String identifynumber = applicantInsured.getIdentifynumber();
				Date birthday = applicantInsured.getBirthday();
				String name = applicantInsured.getName();
				String identifytype = applicantInsured.getIdentifytype();
				String sex = applicantInsured.getSex();
				policy.setSumamount(policy.getSumamount());//取保额
				policy.setSumbasepremium(policy.getSumbasepremium());//取保费
				policy.setInsuretime(new Date());//投保时间
				policy.setSource("tuanxian");
				policy.setProdoctcode("HEALTHGD");//产品编号
				policy.setRiskcode("HEALTHGD");//险种代码
				policy.setOriginate("0");//官网直销
				policy.setApplicantname(name);//投保人姓名
				policy.setApplicantaddress(applicantInsured.getAddress());//投保人地址
				policy.setInsuredname(geChild.getName());//被保人姓名
				policy.setClasscode("1");//1代表主险
				policy.setPolicyterm("1");
				policy.setPolicytermtype("年");
				policy.setProductname("瑞泰成长卫士少儿重大疾病保险");
				policy.setCondition("0");//未对账
				policy.setIslegalflag("2");//法定受益人
				policy.setStipend(policy.getStipend());//助学金
				policy.setBookmoney(policy.getBookmoney());//赠书金
				policy.setOpenid(openId);
				policy.setCharityflag("0");
				//关系需要改
				applicantInsured.setFlag("1");//投保人
				applicantInsured.setInsrelationapp("C");//与被保人关系:其他
				GeApplicantInsured recognizee = new GeApplicantInsured();
				//生日需要处理 缺少字段
				SimpleDateFormat sdformat=new SimpleDateFormat("yyyy-MM-dd");
			    Date cd=sdformat.parse(geChild.getBirthday());
				recognizee.setBirthday(cd);
				recognizee.setName(geChild.getName());
				recognizee.setSex(geChild.getSex());
				recognizee.setIdentifytype(geChild.getIdentifytype());
				recognizee.setIdentifynumber(geChild.getIdentifynumber());
				
				recognizee.setFlag("2");//被保人
				recognizee.setInsrelationapp("99");//被保人与投保人关系:其他
				//-----
				Set<GePolicy> policys1=new HashSet<GePolicy>();
				policys1.add(policy);
				applicantInsured.setPolicy(policys1);
				recognizee.setPolicy(policys1);
				//-----
				Set<GeApplicantInsured> applicantInsureds = new HashSet<GeApplicantInsured>();
				applicantInsureds.add(recognizee);
				applicantInsureds.add(applicantInsured);
				if(donationFlag.equals("1")){
				//核保
					LCCont lCCont = new LCCont();
					lCCont.setAccBankCode("MSG02");
					lCCont.setBankAccNo("888888");
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
					//lCInsured.setRelaToAppnt("CH");//与投保人关系
					lCInsured.setRelaToAppnt("CR");//与投保人关系
					LCAppnt lcAppnt = new LCAppnt();//投保人信息
					lcAppnt.setAppntName(name);//投保人姓名
					lcAppnt.setAppntSex(sex);//投保人性别
					lcAppnt.setAppntIDType(identifytype);//投保人证件类型
					lcAppnt.setAppntIDNo(identifynumber);//投保人证件号
					lcAppnt.setAppntBirthday(sdf.format(birthday));//投保人生日
					lcAppnt.setAppntMobile(applicantInsured.getMobile());//投保人手机
					lcAppnt.setEmail(applicantInsured.getEmail());//投保人邮箱
					lcAppnt.setHomeAddress(applicantInsured.getAddress());//投保人地址
					//lcAppnt.setRelaToInsured("PA");//与被保人关系
					lcAppnt.setRelaToInsured("CR");//与被保人关系
					BaseInfo baseInfo = new BaseInfo(); 
					baseInfo.setZoneNo("MSG02");
					baseInfo.setBrNo("A0000");
					if(isActy()){
						baseInfo.setActyNo("discont2");
					} else {
						baseInfo.setActyNo("");
					}
					//调用核保接口
					String sumpremium = LongPolicyUtil.underwriting(pro.getProperty("yinbaotong"),risk, lCInsured, lcAppnt,lCCont,baseInfo);
					if(sumpremium.equals("1")){//核保成功
						policy.setStatus("1");//核保成功
						logger.info("openId:"+openId+"核保成功");
						resultsjon = "{\"flag\":\"0\",\"content\":\"核保成功\"}";
					}else{
						policy.setStatus("2");//核保失败
						logger.debug("openId:"+openId+"核保失败："+sumpremium);
						resultsjon = "{\"flag\":\"1\",\"content\":\""+sumpremium+"\"}";
					}
					//创建订单对象
					GeOrder order = insurePolicyService.insureInput(policy, applicantInsureds);
					order.setPaymentplatform("1");//支付平台：微信
					order.setChannelCode("003");//登录途径，微信公众号
					String ordercode = OrderHelper.getOrderNumber("RT","002");//获取订单号
					order.setOrdercode(ordercode);
					order.setOrderamount(policy.getSumbasepremium());
					//order.setFlowno(filowno);//交易流水号
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
					//存投被保人姓名
					order.setApplicantname(policy.getApplicantname());
					order.setRecipientname(recognizee.getName());
					order.setStipend(policy.getStipend());//助学金
					order.setBookmoney(policy.getBookmoney());//赠书金
					order.setOpenid(openId);
					order.setCharityflag("0");
					orderService.saveOrder(order);
					session.setAttribute("recognizee", recognizee);
					session.setAttribute("applicantInsured", applicantInsured);
					session.setAttribute("policy", policy);
					session.setAttribute("ordercode", ordercode);
				}else{
					GeOrder order = new GeOrder();
					order.setPaymentplatform("1");//支付平台：微信
					order.setChannelCode("003");//登录途径，微信公众号
					String ordercode = OrderHelper.getOrderNumber("RT","003");//获取订单号
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
					//存投被保人姓名
					order.setApplicantname(policy.getApplicantname());
					order.setRecipientname(recognizee.getName());
					order.setStipend(policy.getStipend());//助学金
					order.setBookmoney(policy.getBookmoney());//赠书金
					order.setOpenid(openId);
					order.setCharityflag("0");
					orderService.saveOrder(order);
					session.setAttribute("recognizee", recognizee);
					session.setAttribute("applicantInsured", applicantInsured);
					session.setAttribute("policy", policy);
					session.setAttribute("ordercode", ordercode);//将订单号存入seesion用作承保后状态更改
					logger.info("openId:"+openId+"订单保存成功");
					resultsjon = "{\"flag\":\"0\",\"content\":\"订单保存成功\"}";
				}
				session.removeAttribute("fill_count");
			}
	
		}catch (Exception e) {
			logger.info(openId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			resultsjon = "{\"flag\":\"1\",\"content\":\"核保异常\"}";
			e.printStackTrace();
		}finally{
			logger.info(openId+":"+resultsjon);
			super.renderJson(resultsjon);
		}
	}
	
	/**
	 * 异步承保并跳转至成功页面
	 * @return
	 */
	@Action(value = "toCharitySuccess", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/charity/success.jsp"),
			@Result(name="fail", location="/WEB-INF/jsp/xxx.jsp")
			})
	public String toCharitySuccess(){
		//取openId
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		String source = request.getParameter("source");//取来源，判断长短险
		if(source.equals("tuanxian")){
			try{
				String donationFlag = (String) session.getAttribute("donationFlag");
				request.setAttribute("donationFlag", donationFlag);
				String helpStudyFlag = (String) session.getAttribute("helpStudyFlag");
				request.setAttribute("helpStudyFlag", helpStudyFlag);
				GePolicy policy = (GePolicy)session.getAttribute("policy");
				if(donationFlag.equals("1")){
					//更新GE_CHILDLIST保额
					//updateSumamount(ordercode);
					String productname = policy.getProductname();//产品名称
					String orderamount = df.format(policy.getSumbasepremium());//订单金额
					request.setAttribute("productname", productname);
					request.setAttribute("orderamount", orderamount);
				}
				Double sumMoney = null;
				if(policy.getSumbasepremium()!=null){
					request.setAttribute("sumbasepremium", df.format(policy.getSumbasepremium()));
					sumMoney = policy.getSumbasepremium();
				}
				
				if(policy.getStipend()!=null){
					sumMoney +=  policy.getStipend();
					request.setAttribute("stipend", df.format(policy.getStipend()));
				}
				if(policy.getBookmoney()!=null){
					sumMoney +=  policy.getBookmoney();
					request.setAttribute("bookmoney", df.format(policy.getBookmoney()));
				}
				request.setAttribute("sumMoney", df.format(sumMoney));//总金额
				String paydate = dateSdf.format(new Date());//支付日期
				request.setAttribute("paydate", paydate);
				
				return SUCCESS;
				
			}catch (Exception e) {
				logger.error("跳转成功页或更新保额异常，openId:"+openId);
				e.printStackTrace();
				return ERROR;
			}
		}else{
			logger.error("入参异常,为空值");
			return ERROR;
		}
	}
	/**
	 * 测试环境方法
	 * @return
	 */
	@Action(value = "toTestCharitySuccess", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/charity/success.jsp"),
			@Result(name="fail", location="/WEB-INF/jsp/xxx.jsp")
			})
	public String toTestCharitySuccess(){
		//取openId
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		String source = request.getParameter("source");//取来源，判断长短险
		if(source.equals("tuanxian")){
			try{
				String donationFlag = (String) session.getAttribute("donationFlag");
				request.setAttribute("donationFlag", donationFlag);
				String helpStudyFlag = (String) session.getAttribute("helpStudyFlag");
				request.setAttribute("helpStudyFlag", helpStudyFlag);
				GePolicy policy = (GePolicy)session.getAttribute("policy");
				if(donationFlag.equals("1")){
					String ordercode = (String)session.getAttribute("ordercode");
					/*============测试环境中加入承保==============*/
					String flag = longAcceptance(ordercode,openId);
					if("1".equals(flag)){
						logger.error("#####承保成功##### :"+ordercode);
					}else{
						logger.error("#####承保失败##### :"+ordercode);
					}
					/*=======================================*/
					//更新GE_CHILDLIST保额
					updateSumamount(ordercode);
					String productname = policy.getProductname();//产品名称
					String orderamount = df.format(policy.getSumbasepremium());//订单金额
					request.setAttribute("productname", productname);
					request.setAttribute("orderamount", orderamount);
				}
				Double sumMoney = null;
				if(policy.getSumbasepremium()!=null){
					request.setAttribute("sumbasepremium", df.format(policy.getSumbasepremium()));
					sumMoney = policy.getSumbasepremium();
				}
				
				if(policy.getStipend()!=null){
					sumMoney +=  policy.getStipend();
					request.setAttribute("stipend", df.format(policy.getStipend()));
				}
				if(policy.getBookmoney()!=null){
					sumMoney +=  policy.getBookmoney();
					request.setAttribute("bookmoney", df.format(policy.getBookmoney()));
				}
				request.setAttribute("sumMoney", df.format(sumMoney));//总金额
				String paydate = dateSdf.format(new Date());//支付日期
				request.setAttribute("paydate", paydate);
				
				return SUCCESS;
				
			}catch (Exception e) {
				logger.error("跳转成功页或更新保额异常，openId:"+openId);
				e.printStackTrace();
				return ERROR;
			}
		}else{
			logger.error("入参异常,为空值");
			return ERROR;
		}
	}
	
	/**
	 * 测试环境中跑同步承保
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
		if(isActy()){
			if(ordercode.startsWith("RT002")){
				ActyNo = "discont2";
			}
		}
		
		//长险承保
		GeApplicantInsured recognizee = null;
		GeApplicantInsured applicantInsured = null;
		GeOrder order = orderService.getOrderByOrderCode(ordercode);//从库里取出订单实体
		Set<GePolicy> policys = order.getPolicys();
		Iterator<GePolicy> it = policys.iterator();
		GePolicy policy = it.next();
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
				LCAppnt lcAppnt = new LCAppnt();//投保人信息
				lcAppnt.setAppntName(applicantInsured.getName());//投保人姓名
				lcAppnt.setAppntSex(applicantInsured.getSex());//投保人性别
				lcAppnt.setAppntIDType(applicantInsured.getIdentifytype());//投保人证件类型
				lcAppnt.setAppntIDNo(applicantInsured.getIdentifynumber());//投保人证件号
				lcAppnt.setAppntBirthday(sdf.format(applicantInsured.getBirthday()));//投保人生日
				lcAppnt.setAppntMobile(applicantInsured.getMobile());//投保人手机
				lcAppnt.setEmail(applicantInsured.getEmail());//投保人邮箱
				lcAppnt.setHomeAddress(applicantInsured.getAddress());
				lcAppnt.setRelaToInsured("PA");//与被保人关系(父母)
				lCCont.setAccBankCode("MSG02");//渠道编码
				BaseInfo baseInfo = new BaseInfo();
				baseInfo.setZoneNo("MSG02");//渠道编码
				baseInfo.setBrNo("A0000");//推荐码
				baseInfo.setActyNo(ActyNo);//活动码
				Map<String, String> map = LongPolicyUtil.approved(pro.getProperty("yinbaotong"), risk, lCInsured, lcAppnt,lCCont,baseInfo);
				flag = map.get("flag");
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
	
	/**
	 * 更新被保人保额
	 * @param ordercode
	 */
	public void updateSumamount(String ordercode){
		GeApplicantInsured recognizee = null;
		GeOrder order = orderService.getOrderByOrderCode(ordercode);//从库里取出订单实体
		Set<GePolicy> policys = order.getPolicys();
		Iterator<GePolicy> it = policys.iterator();
		GePolicy policy = it.next();
		try{
			Set<GeApplicantInsured> applicantInsureds = policy.getApplicantInsureds();
			Iterator<GeApplicantInsured> it1 = applicantInsureds.iterator();
			while(it1.hasNext()){
				GeApplicantInsured next = it1.next();
				if(next.getFlag().equals("2")){
					recognizee = next;
				}
			}
			
			String identifynumber = recognizee.getIdentifynumber(); //被保人的证件类型
			//更新GE_CHILDLIST保额
			List<GeChildlist> geChildOne = charityPolicyService.findGeChildOne(identifynumber);
				GeChildlist geChild = geChildOne.get(0);
				if(geChild.getAmount()!=null){
					double amt = Double.valueOf(geChild.getAmount());
					geChild.setAmount(policy.getSumamount()+amt);
				}else{
					geChild.setAmount(policy.getSumamount());
				}
				charityPolicyService.updateAmount(geChild);
				//更新结束	
		}catch (Exception e) {
			logger.error("更新被保人保额异常");
			e.printStackTrace();
		}
	}
	

	
	/**
	 * 跳转到荣誉证书页
	 * @return
	 */
	@Action(value = "honorCertificate", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/charity/honor.jsp"),
			@Result(name="fail", location="/WEB-INF/jsp/....jsp")
			})
	public String honorList(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		//String openId = (String) session.getAttribute("openId");
		try {
			String  name = request.getParameter("name")==null?"":new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			String  sumamounts = (String)session.getAttribute("sumamounts");
			String  sumbasepremium1 = request.getParameter("sumbasepremium")==null?"":new String(request.getParameter("sumbasepremium").getBytes("ISO-8859-1"),"UTF-8");
			String  sumamount1 = request.getParameter("sumamount")==null?"":new String(request.getParameter("sumamount").getBytes("ISO-8859-1"),"UTF-8");
			String  ordercode1 = request.getParameter("ordercode")==null?"":new String(request.getParameter("ordercode").getBytes("ISO-8859-1"),"UTF-8");
			String  stipend1 = request.getParameter("stipend")==null?"":new String(request.getParameter("stipend").getBytes("ISO-8859-1"),"UTF-8");
			String  bookmoney1 = request.getParameter("bookmoney")==null?"":new String(request.getParameter("bookmoney").getBytes("ISO-8859-1"),"UTF-8");
			String  sumMoney1 = request.getParameter("sumMoney")==null?"":new String(request.getParameter("sumMoney").getBytes("ISO-8859-1"),"UTF-8");
			boolean tag = true;//页面展示标识
			Double getStipend = null;
			if(!StringUtils.isEmpty(name)){
				request.setAttribute("sumamounts", sumamounts);
				request.setAttribute("name", name);
				request.setAttribute("sumbasepremium", sumbasepremium1);
				request.setAttribute("sumamount", sumamount1);
				request.setAttribute("ordercode", ordercode1);
				request.setAttribute("stipend", stipend1);
				request.setAttribute("bookmoney", bookmoney1);
				request.setAttribute("sumMoney", sumMoney1);
			}else{
				GeApplicantInsured applicantInsured = (GeApplicantInsured)session.getAttribute("applicantInsured");
				GePolicy policy = (GePolicy)session.getAttribute("policy");
				String ordercode = (String) session.getAttribute("ordercode");
				String sumbasepremium = df.format(policy.getSumbasepremium());//保费
				if("0.00".equals(sumbasepremium)){
					sumbasepremium = "";
				}
				/*String sumamount = df.format(policy.getSumamount());//淇濋
				if("0.00".equals(sumamount)){
					sumamount = "";
				}*/
				Double sumMoney = null;
				if(policy.getSumbasepremium()!=null){
					sumMoney = policy.getSumbasepremium();
				}
				
				if(policy.getStipend()!=null){
					sumMoney +=  policy.getStipend();
					request.setAttribute("stipend", df.format(policy.getStipend()));
				}
				if(policy.getBookmoney()!=null){
					sumMoney +=  policy.getBookmoney();
					request.setAttribute("bookmoney", df.format(policy.getBookmoney()));
				}
				request.setAttribute("sumMoney", df.format(sumMoney));//总金额
				request.setAttribute("name",  applicantInsured.getName());
				request.setAttribute("sumbasepremium", sumbasepremium);
				//request.setAttribute("sumamount", sumamount);
				request.setAttribute("ordercode", ordercode);
				getStipend = policy.getStipend();
				request.setAttribute("stipend", getStipend);
				ActionContext.getContext().put("stipend", getStipend);
			}
			if(null == getStipend && null == sumamounts){
				tag = false;
			}
			request.setAttribute("sumamount", sumamounts);
			request.setAttribute("tag", tag);
			session.removeAttribute("order");
			session.removeAttribute("policy");
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
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
				return "临时身份证/户口本";
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

	public CharityPolicyService getCharityPolicyService() {
		return charityPolicyService;
	}


	public void setCharityPolicyService(CharityPolicyService charityPolicyService) {
		this.charityPolicyService = charityPolicyService;
	}


	public GeChildlist getGeChildlist() {
		return geChildlist;
	}


	public void setGeChildlist(GeChildlist geChildlist) {
		this.geChildlist = geChildlist;
	}
	
	public GePolicy getPolicy() {
		return policy;
	}


	public void setPolicy(GePolicy policy) {
		this.policy = policy;
	}
	
	public GeApplicantInsured getApplicantInsured() {
		return applicantInsured;
	}


	public void setApplicantInsured(GeApplicantInsured applicantInsured) {
		this.applicantInsured = applicantInsured;
	}
	
	public InsurePolicyService getInsurePolicyService() {
		return insurePolicyService;
	}


	public void setInsurePolicyService(InsurePolicyService insurePolicyService) {
		this.insurePolicyService = insurePolicyService;
	}


	public OrderService getOrderService() {
		return orderService;
	}


	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}


	public GeOrder getOrder() {
		return order;
	}


	public void setOrder(GeOrder order) {
		this.order = order;
	}


	public String getDonationFlag() {
		return donationFlag;
	}


	public void setDonationFlag(String donationFlag) {
		this.donationFlag = donationFlag;
	}


	public String getHelpStudyFlag() {
		return helpStudyFlag;
	}


	public void setHelpStudyFlag(String helpStudyFlag) {
		this.helpStudyFlag = helpStudyFlag;
	}

}
