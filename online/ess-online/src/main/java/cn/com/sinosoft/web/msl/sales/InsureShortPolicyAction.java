package cn.com.sinosoft.web.msl.sales;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.ess.config.service.GeDepartmentService;
import cn.com.sinosoft.ess.protal.common.PortalProp;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.Entry;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.ExtraAttrs;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.InsurancePolicy;
import cn.com.sinosoft.msl.service.shortPolicy.InsureShortPolicyService;
import cn.com.sinosoft.sale.service.OrderService;
import cn.com.sinosoft.web.msl.BaseAction;
import cn.com.sinosoft.web.service.impl.WeiXinServiceImpl;

/**
 * 短险在线投保流程
 */
@ParentPackage(value = "ECS-STRUTS")
public class InsureShortPolicyAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	public static Logger logger = LoggerFactory.getLogger(InsureShortPolicyAction.class);
	static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private InsureShortPolicyService insureShortPolicyService;
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private GeDepartmentService depser;
	
	/**
	 * 已售份数：动态查询电商系统后台状态为已支付的保单
	 */
	private List<GeOrder> orderList = new ArrayList<GeOrder>();

	private GeApplicantInsured applicantInsured;

	private GePolicy policy;

	private GeOrder order;

	private int isBack = 0;

	private String strBirthday;

	/**
	 * 被保人常住地的可选项
	 */
	private List<MslRegion> provinceList = new ArrayList<MslRegion>();

	/**
	 * 显示的保额"10,20,30"
	 */
	private List<String> policyAmountList = new ArrayList<String>();

	/**
	 * 显示的保险期间"3,5,10" 天/月/年 保存到Policy对象中显示
	 */
	private List<String> periodNumberList = new ArrayList<String>();

	/**
	 * 显示的保险期间"3,5,10" 天/月/年 保存到Policy对象中显示
	 */
	private List<String> periodTypeList = new ArrayList<String>();

	/**
	 * 省份默认项
	 */
	private MslRegion inputRegion;

	/**
	 * 加载短险首页
	 */
	@Action(value = "shortProduct", results = {
			@Result(name = "success", location = "/WEB-INF/jsp/page/transfer/index.jsp"),
			@Result(name = "error", location = "/WEB-INF/jsp/page/transfer/error.jsp") })
	public String product() {
		String openId = null;
		HttpSession session  = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("openId")!=null){
			openId = (String)session.getAttribute("openId");
		}
		if(openId==null||openId.length()==0){
			WeiXinServiceImpl weixin = new WeiXinServiceImpl();
			openId = weixin.getOpenId(request);
		}
//		openId = "oipGbs9ck-qldsZUXQiv7YUQSh-A";//高洪洋openId
		if(openId!=null&&openId.length()>0){
			ServletActionContext.getRequest().getSession().setAttribute("openId", openId);//将获取的openId放置seesion域中
			try {
				logger.info("InsureShortPolicyAction.shortProduct: " + openId);
			} catch (Exception e) {
				logger.info("openId:"+openId+"  "+e.getMessage());
				logger.error(ExceptionUtils.getStackTrace(e));
				e.printStackTrace();
				return ERROR;
			}
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	/**
	 * 加载投保输入页
	 */
	@Action(value = "insureShortPolicyInput", results = {
			@Result(name = "success", location = "/WEB-INF/jsp/page/transfer/fill.jsp"),
			@Result(name = "fail", location = "/WEB-INF/jsp/....jsp") })
	public String insureInput() {
		String openId = (String) ServletActionContext.getRequest().getSession().getAttribute("openId");
		try {
			 GePolicy policyI = (GePolicy)this.session.get("InsurePolicy.PolicyI");
			 String deadlinetime = df.format(policyI.getDeadlinetime());
			 request.setAttribute("deadlinetime", deadlinetime);
			logger.info("InsureShortPolicyAction.insureInput: " + openId);
		} catch (Exception e) {
			logger.info("openId:"+openId+"  "+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 提交投保录入(点击下一步)
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Action(value = "insureShortPolicyConfirm", results = {
			@Result(name = "success", type = "json"),
			@Result(name = "fail", type = "json") })
	public String insureShortPolicyConfirm() {
		String openId = (String) ServletActionContext.getRequest().getSession().getAttribute("openId");
		try {
			logger.info("InsurePolicyAction.InsureConfirm: " + openId);
			GePolicy policyI = (GePolicy) session.get("InsurePolicy.PolicyI");
			// 生效日期
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
			Date dateEff = sdf1.parse(sdf1.format(policyI.getTakeeffecttime()));
			policy.setTakeeffecttime(dateEff);
			// 终止日期
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateEff);
			if(policyI.getPolicytermtype().equals("D")){
				calendar.add(Calendar.DAY_OF_YEAR, Integer.parseInt(policyI.getPolicyterm()));
			}else if(policyI.getPolicytermtype().equals("M")){
				calendar.add(Calendar.DAY_OF_YEAR, 30 * Integer.parseInt(policyI.getPolicyterm()));
			}else{
				calendar.add(Calendar.YEAR, Integer.parseInt(policyI.getPolicyterm()));
			}
//			calendar.add(Calendar.SECOND, -1);
			Date dateEnd = calendar.getTime();
			policy.setDeadlinetime(dateEnd);
			// 产品编号
			policy.setProdoctcode(policyI.getProdoctcode());
			// 保障期间
			policy.setPolicyterm(policyI.getPolicyterm());
			// 保障期间单位
			policy.setPolicytermtype(policyI.getPolicytermtype());
			// 份数
			policy.setUnitcount(policyI.getUnitcount());
			// 保险金额
			policy.setSumamount(policyI.getSumamount());
			// 总保费
			policy.setSumbasepremium(policyI.getSumbasepremium());
			// 总保费
			policy.setSumpremium(policyI.getSumbasepremium());
			
			policy.setProductname("瑞泰天天保公共交通工具意外伤害保险");//保单表中的产品名称字段
			// 将被投保人信息、保单信息存入订单对相中
			order = insureShortPolicyService.insureInput(policy,
					applicantInsured);
			//截取推荐人编码作为渠道
			String brNo = LongPolicyAction.subCode(policy.getAgentcode());
			order.setBrNo(brNo);
			// 获取出生年月
			Set<GePolicy> policys = order.getPolicys();
			Iterator<GePolicy> iterator = policys.iterator();
			GePolicy gePolicy = iterator.next();
			Set<GeApplicantInsured> applicantInsureds = gePolicy
					.getApplicantInsureds();
			Iterator<GeApplicantInsured> iterator2 = applicantInsureds
					.iterator();
			GeApplicantInsured applicantInsured = iterator2.next();
			Date birthday = applicantInsured.getBirthday();
			applicantInsured.getIdentifynumber();
//			if(applicantInsured.getAddress()==null){
//				applicantInsured.setAddress("");
//			}
			// 判断身份证类别
			String strIDtype =insureShortPolicyService.convertIdentifytype(applicantInsured);
			// 判断性别
			String strSex = insureShortPolicyService.convertSex(applicantInsured);
			// 将date转化为string
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			strBirthday = sdf.format(birthday);
			session.put("strBirthday", strBirthday);
			session.put("strSex", strSex);
			session.put("strIDtype", strIDtype);
			// 将订单信息放入session中
			session.put("InsurePolicy.Order", order);
			resultBusiness(true);
		} catch (Exception e) {
			logger.info(openId + "：" + e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000", "系统异常");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 加载投保信息确认页
	 * 
	 * @return
	 */
	@Action(value = "insureShortPolicyNotice", results = {
			@Result(name = "success", location = "/WEB-INF/jsp/page/transfer/confirm.jsp"),
			@Result(name = "fail", location = "/WEB-INF/jsp/....jsp") })
	public String insureNotice() {
		String openId = (String) ServletActionContext.getRequest().getSession().getAttribute("openId");
		try {
			logger.info("InsureShortPolicyAction.insureNotice: " + openId);
			// 获取订单信息跳转显示页面
			order = (GeOrder) session.get("InsurePolicy.Order");
			//request.setAttribute("sex1", ("sex"));
			resultBusiness(true);
		} catch (Exception e) {
			logger.info(openId + "：" + e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000", "系统异常");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 提交核保(点击下一步)
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Action(value = "insureShortPolicySubmit", results = {
			@Result(name="success",type="json"),
			@Result(name="fail",type="json")
			})
	public String insureSubmit(){
		HttpSession session1 = ServletActionContext.getRequest().getSession();
		String openId = (String)session1.getAttribute("openId");
		Map<String,String> resultMap = null;
		String orderNo = "";
		try {
			logger.info("InsurePolicyAction.InsureSubmit: "+openId);
			order = (GeOrder)session.get("InsurePolicy.Order");
			order.setUserid(openId);
			String channelCode = PortalProp.getString("shortPolicyChannelId");
			//本地生成orderNo
			orderNo = OrderHelper.getOrderNumber("RT","100");
			String transNo = OrderHelper.getTransNo("A", channelCode);
			order.setOpenid(openId);
			order.setPayway("10");
			Set<GePolicy> policys=order.getPolicys();
			Iterator<GePolicy> it=policys.iterator();
			GePolicy policy=null;
			String deptid = null;
			while(it.hasNext()){
				String brNo = order.getBrNo();
				policy=it.next();
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
				if(brNo==null||brNo.length()==0){
					brNo = "A0000";
				}
				policy.setBrNo(brNo);
				policy.setDeptid(deptid);
			}
			order.setDeptid(deptid);
			//拼接承保需要的实体
			InsurancePolicy  ip = insureShortPolicyService.returnInsurancePolicy(orderNo, order, channelCode, transNo);
			resultMap = insureShortPolicyService.insureSubmit(orderNo, order, channelCode, transNo);
			//核心返回orderNo(同程接口orderNo在核保由核心返回)
			orderNo = resultMap.get("orderNo");
			session.remove("ordercode");
			session.put("ordercode", orderNo);
			session.put("insurePolicy", ip);
			session.remove("InsurePolicy.Order");
			session1.setAttribute("ordercode", orderNo);
			String resultCode = resultMap.get("resultCode");
			if(resultCode.equals("0")){
				resultBusiness(true, "1000");
			}else{
				resultBusiness(false, "2000", "核保失败： "+resultMap.get("resultMsg"));
			}
		}catch (Exception e) {
			logger.info(openId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 提交承保(点击下一步)
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Action(value = "insureShortPolicyPromise", results = {
			@Result(name="success",location="/WEB-INF/jsp/page/transfer/success.jsp"),
			@Result(name="fail",location="/WEB-INF/jsp/xxx.jsp")
			})
	public String insurePromise(){
		Map<String,String> resultMap = null;
			HttpSession session = ServletActionContext.getRequest().getSession();
			String ordercode = (String)session.getAttribute("ordercode");
			String channelCode = PortalProp.getString("shortPolicyChannelId");
			String openId = (String) session.getAttribute("openId");
			//本地生成流水号
			String transNo = OrderHelper.getTransNo("A", channelCode);
		
			InsurancePolicy ip = (InsurancePolicy)session.getAttribute("insurePolicy");
			session.removeAttribute("insurePolicy");
			GeOrder geOrder = orderService.findGeOrderByOrderCode(ordercode);//从数据库中获取订单对象
			ExtraAttrs extraAttrs = new ExtraAttrs();
		    List entryList = new ArrayList();
		    Entry entry = new Entry();
		    entry.setKey("unit");
		    GePolicy policyI = (GePolicy)this.session.get("InsurePolicy.PolicyI");
		    entry.setValue(policyI.getUnitcount());
		    entryList.add(entry);
		    extraAttrs.setEntry(entryList);
		    logger.info("InsurancePolicy:"+ip);
		    ip.setExtraAttrs(extraAttrs);
		    
		    
			String orderamount = String.valueOf(ip.getProduct().getPremium());
			logger.info("短险承保成功，保费："+orderamount+",openId:"+openId);
			request.setAttribute("orderamount", orderamount);
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
			String transDate = sdf2.format(ip.getHeader().getTransDate());
			logger.info("短险承保成功，时间："+transDate+",openId:"+openId);
			request.setAttribute("c", transDate);
			//调用承保接口
			logger.info("支付成功跳转到success页面");
			//resultMap = insureShortPolicyService.insurePromise(geOrder, channelCode, transNo,ip);
//			if(resultMap != null){
//				if("0".equals(resultMap.get("resultCode"))){
//					String policyCode = (String)resultMap.get("policyCode");
//					String orderamount = String.valueOf(ip.getProduct().getPremium());
//					request.setAttribute("orderamount", orderamount);
//					request.setAttribute("policyCode", policyCode);
//					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
//					String transDate = sdf2.format(ip.getHeader().getTransDate());
//					request.setAttribute("c", transDate);
					return SUCCESS;
//				}else{
//					logger.error("承保失败,openId: "+openId);
//					return ERROR;
//				}
//			}else{
//				logger.error("承保异常,openId: "+openId);
//				return ERROR;
//			}
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

	@Override
	protected void processResultBusiness(boolean resultSuccess,
			String resultCode, String resultDescription) {

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setInsureShortPolicyService(
			InsureShortPolicyService insureShortPolicyService) {
		this.insureShortPolicyService = insureShortPolicyService;
	}

	public String getStrBirthday() {
		return strBirthday;
	}

	public void setStrBirthday(String strBirthday) {
		this.strBirthday = strBirthday;
	}

}
