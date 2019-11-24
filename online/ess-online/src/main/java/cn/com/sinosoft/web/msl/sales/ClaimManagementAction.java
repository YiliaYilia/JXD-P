package cn.com.sinosoft.web.msl.sales;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.common.service.axis.BasicQuery;
import cn.com.sinosoft.common.service.axis.CardInformation;
import cn.com.sinosoft.common.service.axis.PartyInformation;
import cn.com.sinosoft.common.service.axis.QueryModel;
import cn.com.sinosoft.common.service.axis.RoleQueryModel;
import cn.com.sinosoft.core.mail.MailUtil;
import cn.com.sinosoft.core.utils.ClaimUtils;
import cn.com.sinosoft.domain.sale.GeClaimManagement;
import cn.com.sinosoft.domain.sale.GeClaimRider;
import cn.com.sinosoft.domain.sale.GeMobileCustomer;
import cn.com.sinosoft.domain.system.GeDepartment;
import cn.com.sinosoft.domain.user.GePermission;
import cn.com.sinosoft.domain.user.GeResources;
import cn.com.sinosoft.domain.user.GeRole;
import cn.com.sinosoft.domain.user.GeUser;
import cn.com.sinosoft.domain.user.GeUsergroup;
import cn.com.sinosoft.sale.service.ClaimManagementService;
import cn.com.sinosoft.sale.service.PolicyMobileService;
import cn.com.sinosoft.web.domain.ClaimManagementEntity;
import cn.com.sinosoft.web.entity.IDTypeEntity;
import cn.com.sinosoft.web.msl.BaseAction;
import cn.com.sinosoft.web.service.facade.ClientBindService;
import cn.com.sinosoft.web.service.facade.PartyChangeService;
import cn.com.sinosoft.web.service.facade.PolicyBasicQueryService;
import cn.com.sinosoft.web.service.facade.PolicyListQueryService;
import cn.com.sinosoft.web.service.facade.ResourceService;
import cn.com.sinosoft.web.service.facade.SinoImageService;
import cn.com.sinosoft.web.service.impl.WeiXinServiceImpl;

/**
 * 快速理赔
 * @author liangkesai
 * @date 2018年6月25日 下午5:14:07
 */
@ParentPackage(value = "ECS-STRUTS")
public class ClaimManagementAction extends BaseAction {
	
	private static final long serialVersionUID = 776181521071868159L;

	public static Logger logger = LoggerFactory.getLogger(ClaimManagementAction.class);

	private GeClaimManagement geClaimManagement;
	
	private static Properties pro = new Properties();

	@Autowired
	private ClaimManagementService claimManagementService;
	
	@Autowired
	private ClientBindService clientBindService;
	
	@Autowired
	private PolicyMobileService policyMobileService;
	
	@Autowired
	private PolicyListQueryService policyListQueryService;
	
	@Autowired
	private PartyChangeService partyChangeService;
	
	@Autowired
	private PolicyBasicQueryService policyBasicQueryService; 
	
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private SinoImageService sinoImageService;
	private ExecutorService sinoImagePool = Executors.newFixedThreadPool(2);
	
	
	static{
		try {
			pro.load(new InputStreamReader(ClaimManagementAction.class.getResourceAsStream("/config/mailSenderInfo.properties"), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 首页
	 * @return
	 */
	@Action(value = "menuClaimAction", results = {
			@Result(name = "success", location = "/WEB-INF/jsp/page/compensation/menu.jsp"),
			@Result(name = "error", location = "/WEB-INF/jsp/page/compensation/claimError.jsp")})
	public String menuClaimAction() {
			HttpSession session  = ServletActionContext.getRequest().getSession();
			String openId = WeiXinServiceImpl.getOpenId(request);
			//String openId = "oipGbs6aOJCQcO0jGszXYVdAmp_I";//测试
			if(openId!=null && openId.length()>0){
				session.setAttribute("openId", openId);
			}
		try {
			resultBusiness(true);
		} catch (Exception e) {
			logger.error("###menuClaimAction###"+e);
			resultBusiness(false, "9000", "系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 需知页面 
	 * @return
	 */
	@Action(value = "noticeClaimAction", results = {
			@Result(name = "success", location = "/WEB-INF/jsp/page/compensation/notice.jsp"),
			@Result(name = "error", location = "/WEB-INF/jsp/page/compensation/notice.jsp")})
	public String noticeClaimAction() {
		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			String openId = (String) session.getAttribute("openId");
			logger.info("###理赔需知获取 openId###: "+openId);
			if(openId==null || openId.length()==0){
				return ERROR;
			}
			resultBusiness(true);
		} catch (Exception e) {
			logger.error("###noticeClaimAction### 异常信息："+e);
			resultBusiness(false, "9000", "系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 判断客户是否绑定
	 * @return
	 */
	@Action(value = "isMobileCustomerAction", results = {
			@Result(name = "isCustomer", location = "/WEB-INF/jsp/page/compensation/fill_stepone.jsp"),
			@Result(name="noCustomer", location="/page/index.jsp"),
			@Result(name = "error", location = "/WEB-INF/jsp/page/compensation/claimError.jsp")})
	public String isMobileCustomerAction() {
		String tag = "isCustomer";
		QueryModel[] policyList = null;
		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			String openId = (String) session.getAttribute("openId");
			logger.info("###判断客户是否绑定获取 openId###: "+openId);
			if(openId==null || openId.length()==0){
				return ERROR;
			}
			//查询微信是否绑定
			List<GeMobileCustomer> isCustomer = clientBindService.checkOpenID(openId);
			if(null != isCustomer && isCustomer.size()>0){
				//绑定 继续理赔流程
				tag = "isCustomer";
				List<GeMobileCustomer> mcList = policyMobileService.getOrderByNo(openId);
				GeMobileCustomer geMobileCustomer = null;
				for(GeMobileCustomer temp:mcList){
					String coustomerid = temp.getCoustomerid();
					if(coustomerid.startsWith("C") && coustomerid.length() == 12){//如果客户号符合短险标志
						geMobileCustomer = temp;
					}else{//如果客户为短险
						geMobileCustomer = temp;
						break;
					}
				}
				//查询保单列表 
				policyList = policyListQueryService.depacketizeQuery(policyList,geMobileCustomer.getName(), geMobileCustomer.getIdtype(), geMobileCustomer.getIdnumber());
				if(policyList.length<1){
					this.request.setAttribute("Contenct", "保单查询失败");
				}else{
					this.request.setAttribute("policyList", policyList);
				}
				policyList = null;
			} else {
				//未绑定 跳转绑定流程
				this.request.setAttribute("claimTag", "claimTag");//绑定之后跳转至理赔流程
				this.request.setAttribute("OpenID", openId);
				tag = "noCustomer";
			}
		} catch (Exception e) {
			policyList = new QueryModel[0];
			this.request.setAttribute("Contenct", "保单查询异常");
			logger.error("###isMobileCustomerAction### 异常信息："+e);
			resultBusiness(false, "9000", "系统异常");
			return ERROR;
		}
		return tag;
	}
	
	/**
	 * 通过保单号以及索赔类型判断是否有未结案的理赔
	 * @return
	 */
	@Action(value = "isPolicyCodeAction")
	public void isOrderCodeAction() {
		String resultsjon ="";
		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			String openId = (String) session.getAttribute("openId");
			logger.info("###判断是否有未结案的理赔获取 openId###: "+openId);
			String policyCode = this.request.getParameter("policyCode");
			String claimManagementType = this.request.getParameter("claimManagementType");
			GeClaimManagement claimManagement = new GeClaimManagement();
			claimManagement.setPolicyCode(policyCode);
			claimManagement.setClaimManagementType(claimManagementType);
			claimManagement.setOpenId(openId);
			//判断是否存在未处理完成的理赔
			boolean b = claimManagementService.isPolicyCode(claimManagement);
			resultsjon = "{\"flag\":\""+b+"\"}";	
			resultBusiness(true);
		} catch (Exception e) {
			logger.error("###isPolicyCodeAction###  异常信息："+e);
			resultBusiness(false, "9000", "系统异常");
		} finally {
			renderJson(resultsjon);
		}
	}
	
	/**
	 * 处理第一屏理赔申请信息
	 * @return
	 */
	@Action(value = "fillSteponeClaimAction", results = {
			@Result(name = "success", location = "/WEB-INF/jsp/page/compensation/fill_steptwo.jsp"),
			@Result(name = "error", location = "/WEB-INF/jsp/page/compensation/fill_steptwo.jsp")})
	public String fillSteponeClaimAction() {
		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			String openId = (String) session.getAttribute("openId");
			logger.info("###处理第一屏理赔申请信息获取 openId###: "+openId);
			if(openId==null || openId.length()==0){
				return ERROR;
			}
			//理赔单查询转过来的请求
			String claimManagementNo = request.getParameter("claimManagementNo");
			session.removeAttribute("updateContent");
			if(null != claimManagementNo && !"".equals(claimManagementNo)){
				GeClaimManagement ge = new GeClaimManagement();
				ge.setClaimManagementNo(claimManagementNo);
				List<GeClaimManagement> list =  claimManagementService.findClaimList(ge);
				geClaimManagement = list.get(0);
				
				String updateContent = request.getParameter("updateContent");
				session.setAttribute("updateContent", updateContent);
			}
			
			ClaimManagementEntity claim = new ClaimManagementEntity();
			BeanUtils.copyProperties(claim, geClaimManagement);
			//用于日期回显正确格式
			String startDate = ClaimUtils.getStrDate(geClaimManagement.getStartDate());
			String insureDate = ClaimUtils.getStrDate(geClaimManagement.getInsureDate());
			claim.setStartDate(startDate);
			claim.setInsureDate(insureDate);
			request.setAttribute("geClaimManagement", claim);//资料录入第二屏所用
			session.setAttribute("geClaimManagement", geClaimManagement);//入库所用
			resultBusiness(true);
		} catch (Exception e) {
			logger.error("###fillSteptwoClaimAction### 异常信息："+e);
			resultBusiness(false, "9000", "系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 处理第二屏理赔申请信息
	 * @return
	 */
	@Action(value = "fillSteptwoClaimAction", results = {
			@Result(name = "COMFIRM", location = "/WEB-INF/jsp/page/compensation/info_comfirm.jsp"),
			@Result(name = "error", location = "/WEB-INF/jsp/page/compensation/claimError.jsp")})
	public String fillSteptwoClaimAction() {
		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			String openId = (String) session.getAttribute("openId");
			logger.info("###处理第二屏理赔申请信息获取 openId###: "+openId);
			if(openId==null || openId.length()==0){
				return ERROR;
			}
			//从信息确认页面返回 如果是空则返回
			GeClaimManagement claimManagement = (GeClaimManagement)session.getAttribute("geClaimManagement");
			if(null != claimManagement){
				//用于日期回显正确格式
				ClaimManagementEntity claim = new ClaimManagementEntity();
				BeanUtils.copyProperties(claim, geClaimManagement);
				String claimManagementType = ClaimUtils.getClaimManagementType(geClaimManagement.getClaimManagementType());
				String insrelationApp = ClaimUtils.getInsrelationApp(geClaimManagement.getInsrelationApp());
				String startDate = ClaimUtils.getStrDate(geClaimManagement.getStartDate());
				String insureDate = ClaimUtils.getStrDate(geClaimManagement.getInsureDate());
				claim.setStartDate(startDate);
				claim.setInsureDate(insureDate);
				claim.setClaimManagementType(claimManagementType);
				claim.setInsrelationApp(insrelationApp);
				request.setAttribute("geClaimManagement", claim);//确认页面展示
				session.setAttribute("geClaimManagement", geClaimManagement);//入库所用
			} else {
				logger.info("###已经保存数据无法进行返回修改资料，重定向到报案完成页面！### ");
				response.sendRedirect(request.getContextPath()+"/msl/sales/infoComfirmClaimAction?tag=tag");
			}
			resultBusiness(true);
		} catch (Exception e) {
			logger.error("###fillSteptwoClaimAction### 异常信息："+e);
			resultBusiness(false, "9000", "系统异常");
			return ERROR;
		}
		return "COMFIRM";
	}
	
	/**
	 * 入库
	 * @return
	 */
	@Action(value = "infoComfirmClaimAction", results = {
			@Result(name = "success", location = "/WEB-INF/jsp/page/compensation/finish.jsp"),
			@Result(name = "error", location = "/WEB-INF/jsp/page/compensation/claimError.jsp")})
	public String infoComfirmClaimAction() {
		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			String openId = (String) session.getAttribute("openId");
			logger.info("###理赔信息确认获取 openId###: "+openId);
			if(openId==null || openId.length()==0){
				return ERROR;
			}
			geClaimManagement = (GeClaimManagement)session.getAttribute("geClaimManagement");
			if(null == geClaimManagement){
				logger.info("####进入点击返回按钮####");
				//session被清空
				String claimManagementNo = (String) session.getAttribute("claimManagementNo");
				if(null != claimManagementNo && !"".equals(claimManagementNo)){
					GeClaimManagement ge = new GeClaimManagement();
					ge.setClaimManagementNo(claimManagementNo);
					List<GeClaimManagement> list =  claimManagementService.findClaimList(ge);
					geClaimManagement = list.get(0);
					String tag = request.getParameter("tag");
					request.setAttribute("tag", tag);//标识是否为返回页面
				}
			} else {
				String claimManagementNo = geClaimManagement.getClaimManagementNo();
				if(null == claimManagementNo ||"".equals(claimManagementNo)){
					logger.info("####理赔新单入库####");
					//如果id为空 为新加理赔单
					String flowNo = ClaimUtils.createFlowNo(geClaimManagement.getClaimManagementType());//生成流水号
					geClaimManagement.setFlowNo(flowNo);
					geClaimManagement.setCreateDate(new Date());
					geClaimManagement.setOpenId(openId);
					//向核心查询保单信息
					//查询证件号和姓名
					RoleQueryModel roleQueryModel = partyChangeService.RoleQuery(geClaimManagement.getPolicyCode());
					List<Map<String, String>> polParty = formatPartyInformation(roleQueryModel.getTPolPartyInformation());
					logger.info("投保人姓名："+polParty.get(0).get("name"));
					geClaimManagement.setPolName(polParty.get(0).get("name"));	//投保人姓名
					List<Map<String, String>> lifeAssdParty = formatPartyInformation(roleQueryModel.getTLifeAssdPartyInformation());
					geClaimManagement.setInsuredIdNo(lifeAssdParty.get(0).get("CardNo")); //被保人证件号
					geClaimManagement.setInsuredName(lifeAssdParty.get(0).get("name"));	//被保人姓名
					//查询该保单所属市场
					BasicQuery policyBasic = policyBasicQueryService.policyBasicQuery(geClaimManagement.getPolicyCode());
					geClaimManagement.setDeptid(policyBasic.getBranchcode());
					session.setAttribute("deptid", policyBasic.getBranchcode());
					sendMail(geClaimManagement.getPolicyCode(),policyBasic.getBranchcode());
				}
				geClaimManagement.setState("01");//已提交无附件状态   已报案
				claimManagementService.saveClaimManagement(geClaimManagement);
				session.setAttribute("claimManagementNo", geClaimManagement.getClaimManagementNo());
			}
			request.setAttribute("claimManagementType", geClaimManagement.getClaimManagementType());
			request.setAttribute("commitType", geClaimManagement.getCommitType());
			request.setAttribute("claimManagementNo", geClaimManagement.getClaimManagementNo());
			//保持成功清空session
			session.removeAttribute("geClaimManagement");
			resultBusiness(true);
		} catch (Exception e) {
			logger.error("###infoComfirmClaimAction 异常信息："+e);
			resultBusiness(false, "9000", "系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**	
	 * 选择提交方式
	 * @return
	 */
	@Action(value = "paywayClaimAction", results = {
			@Result(name = "success", location = "/WEB-INF/jsp/page/compensation/payway.jsp"),
			@Result(name="other",type="json")})
	public String paywayClaimAction() {
		String tag =SUCCESS;
		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			String openId = (String) session.getAttribute("openId");
			logger.info("###理赔提交方式获取 openId###: "+openId);
			if(openId==null || openId.length()==0){
				return ERROR;
			}
			GeClaimManagement geClaim = new GeClaimManagement();
			String claimManagementNo = request.getParameter("claimManagementNo");
			if(null != claimManagementNo && !"".equals(claimManagementNo)){
				GeClaimManagement ge = new GeClaimManagement();
				ge.setClaimManagementNo(claimManagementNo);
				List<GeClaimManagement> list =  claimManagementService.findClaimList(ge);
				geClaim = list.get(0);
			}
			String commitType = request.getParameter("commitType");
			geClaim.setCommitType(commitType);//设置提交方式
			if("02".equals(commitType)){
				//微信提交
				session.setAttribute("geClaimManagement", geClaim);
				request.setAttribute("payType", geClaim.getPayType());
			} else {
				tag = "other";
				//柜台、邮箱提交 直接结束
				geClaim.setPayType("");//设置支付方式
			}
			claimManagementService.saveClaimManagement(geClaim);
			resultBusiness(true);
		} catch (Exception e) {
			logger.error("###infoComfirmClaimAction 异常信息："+e);
			resultBusiness(false, "9000", "系统异常");
			return ERROR;
		}
		return tag;
	}
	
	
	/**	
	 * 选择支付方式并且对提交方式和支付方式进行入库
	 * 成功之后跳入上传资料页面
	 * @return
	 */
	@Action(value = "finishClaimAction")
	public void uploadClaimAction() {
		String claimManagementNo = "";
		String updateContent = "";
		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			String openId = (String) session.getAttribute("openId");
			logger.info("###理赔支付方式 获取 openId###: "+openId);
			String payType = this.request.getParameter("payType");
			GeClaimManagement geClaim = (GeClaimManagement)session.getAttribute("geClaimManagement");
			claimManagementNo = geClaim.getClaimManagementNo();
			geClaim.setPayType(payType);//设置支付方式
			claimManagementService.saveClaimManagement(geClaim);
			//session.removeAttribute("geClaimManagement");
			updateContent = (String) session.getAttribute("updateContent");
			//session.removeAttribute("updateContent");
			resultBusiness(true);
		} catch (Exception e) {
			logger.error("###infoComfirmClaimAction  异常信息："+e);
			resultBusiness(false, "9000", "系统异常");
		} finally {
			logger.info("claimManagementNo:"+claimManagementNo+",updateContent:"+updateContent);
			renderJson("{\"flag\":\"true\",\"claimManagementNo\":\""+claimManagementNo+"\",\"updateContent\":\""+updateContent+"\"}");
		}
	}
	
	/**
	 * 根据meadia_id下载图片
	 * @return
	 */
	@Action(value = "downloadMedia")
	public void downloadMedia() {
		try {
			String claimManagementNo = request.getParameter("claimManagementNo");
			logger.info("###理赔图片下载claimManagementNo###: "+claimManagementNo);
			//查询对应理赔单
			GeClaimManagement claim = new GeClaimManagement();
			claim.setClaimManagementNo(claimManagementNo);
			List<GeClaimManagement> list =  claimManagementService.findClaimList(claim);
			geClaimManagement  = list.get(0);
			String filePath = ServletActionContext.getServletContext().getRealPath("/");
			String mediaPath = null;
			String meadia_id [] = request.getParameterValues("media_id");
			Set<GeClaimRider> claimRiders = new HashSet<GeClaimRider>();
			for (int i = 0; i < meadia_id.length; i++) {
				GeClaimRider claimRider = new GeClaimRider();
				mediaPath = WeiXinServiceImpl.downloadMedia(meadia_id[i],filePath+"IdentityImage/",ClaimUtils.createFlowNo("4")+"_rider");
				claimRider.setRiderPath(mediaPath);
				claimRider.setClaimManagement(geClaimManagement);
				claimRiders.add(claimRider);
			}
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("claimRiders", claimRiders);
			session.setAttribute("geClaimManagement", geClaimManagement);
			resultBusiness(true);
		}catch (Exception e) {
			logger.error("###downloadMedia###: 异常信息："+e);
			resultBusiness(false, "9000", "系统异常");
		} finally {
			renderJson("{\"flag\":\"true\"}");
		}
	}
	
	/**
	 * 理赔申报成功
	 * @return
	 */
	@Action(value = "successClaimAction", results = {
			@Result(name = "success", location = "/WEB-INF/jsp/page/compensation/success.jsp"),
			@Result(name = "error", location = "/WEB-INF/jsp/page/compensation/claimError.jsp")})
	public String successClaimAction() {
		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			String updateImages = request.getParameter("updateImages");
			if(null != updateImages && !"".equals(updateImages)){
				request.setAttribute("updateImages", updateImages);
			}
			GeClaimManagement claimManagement = (GeClaimManagement)session.getAttribute("geClaimManagement");
			String openId = (String) session.getAttribute("openId");
			logger.info("###理赔申报成功,openId: "+openId+",claimManagementNo:"+claimManagement.getClaimManagementNo());
			if(openId==null || openId.length()==0){
				return ERROR;
			}
			@SuppressWarnings("unchecked")
			Set<GeClaimRider> claimRiders = (Set<GeClaimRider>)session.getAttribute("claimRiders");
			claimManagement.setGeClaimRider(claimRiders);
			claimManagement.setState("02");  //修改状态为已经提交
			claimManagement.setUpdateDate(new Date()); //修改更新时间
			claimManagementService.saveClaimManagement(claimManagement);
			//提交附件资料后给理赔专员发送通知邮件
			String deptid = (String) session.getAttribute("deptid");
			logger.info("policyCode"+claimManagement.getPolicyCode()+",deptid:"+deptid);
			if(deptid == null || "".equals(deptid)){//若session失效，则重新获取该保单所属市场
				//查询该保单所属市场
				BasicQuery policyBasic = policyBasicQueryService.policyBasicQuery(claimManagement.getPolicyCode());
				deptid = policyBasic.getBranchcode();
			}
			sendMail(claimManagement.getPolicyCode(),deptid);
			//MailUtil.sendSimpleMail(pro.getProperty("toAddress"), pro.getProperty("subject"),"您好!\n    保单号为："+claimManagement.getPolicyCode()+"的理赔申请已提交成功，请及时处理!");
			resultBusiness(true);
			session.removeAttribute("claimRiders");
			session.removeAttribute("geClaimManagement");
			session.removeAttribute("deptid");
			//单起线程提交资料到影像系统
			if(claimRiders != null && claimRiders.size() > 0){//存在影像资料
				logger.info("*******异步影像上传开始******");
				final String filePath = ServletActionContext.getServletContext().getRealPath("/") + "/IdentityImage/";
				final GeClaimManagement claimManagement1 = claimManagement;
				sinoImagePool.execute(new Thread(new Runnable() {
					@Override
					public void run() {
						logger.info("ClaimManagementNo:"+claimManagement1.getClaimManagementNo());
						sinoImageService.sinoImageClaim(claimManagement1,filePath);
					}
				}));
			}
		} catch (Exception e) {
			logger.error("###infoComfirmClaimAction 异常信息：",e);
			resultBusiness(false, "9000", "系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 查看理赔单子
	 * @return
	 */
	@Action(value = "findClaimListAction", results = {
			@Result(name = "success", location = "/WEB-INF/jsp/page/compensation/list.jsp"),
			@Result(name = "error", location = "/WEB-INF/jsp/page/compensation/claimError.jsp")})
	public String findClaimListAction() {
		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			String openId = (String) session.getAttribute("openId");
			logger.info("###查看理赔单 获取 openId###: "+openId);
			if(openId==null || openId.length()==0){
				return ERROR;
			}
			GeClaimManagement claimManagement = new GeClaimManagement();
			claimManagement.setOpenId(openId);
			List<GeClaimManagement> list =  claimManagementService.findClaimList(claimManagement);
			List<ClaimManagementEntity> claimList = new ArrayList<ClaimManagementEntity>();
			for (Iterator<GeClaimManagement> iterator = list.iterator(); iterator.hasNext();) {
				GeClaimManagement geClaimManagement = (GeClaimManagement) iterator.next();
				ClaimManagementEntity claim = new ClaimManagementEntity();
				//复制对象
				BeanUtils.copyProperties(claim, geClaimManagement);
				//标识中文转换
				String createDate = ClaimUtils.getStrDate(geClaimManagement.getCreateDate());
				String languageState = ClaimUtils.getState(geClaimManagement.getState());
				claim.setLanguageState(languageState);
				claim.setCreateDate(createDate);
				claimList.add(claim);
			}
			session.setAttribute("openId", openId);
			request.setAttribute("claimList", claimList);
			resultBusiness(true);
		} catch (Exception e) {
			logger.error("###findClaimListAction 异常信息："+e);
			resultBusiness(false, "9000", "系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 查看理赔详情
	 * @return
	 */
	@Action(value = "findClaimAction", results = {
			@Result(name = "success", location = "/WEB-INF/jsp/page/compensation/detail.jsp"),
			@Result(name = "error", location = "/WEB-INF/jsp/page/compensation/claimError.jsp")})
	public String findClaimAction() {
		try {
			String claimManagementNo = request.getParameter("claimManagementNo");
			GeClaimManagement claimManagement = new GeClaimManagement();
			claimManagement.setClaimManagementNo(claimManagementNo);
			List<GeClaimManagement> list =  claimManagementService.findClaimList(claimManagement);
			ClaimManagementEntity claim = new ClaimManagementEntity();
			for (Iterator<GeClaimManagement> iterator = list.iterator(); iterator.hasNext();) {
				GeClaimManagement geClaimManagement = (GeClaimManagement) iterator.next();
				//复制对象
				BeanUtils.copyProperties(claim, geClaimManagement);
				//标识中文转换
				String languageClaimManagementType = ClaimUtils.getClaimManagementType(geClaimManagement.getClaimManagementType());
				String insrelationApp = ClaimUtils.getInsrelationApp(geClaimManagement.getInsrelationApp());
				String startDate = ClaimUtils.getStrDate(geClaimManagement.getStartDate());
				String insureDate = ClaimUtils.getStrDate(geClaimManagement.getInsureDate());
				String createDate = ClaimUtils.getStrDate(geClaimManagement.getCreateDate());
				String languageState = ClaimUtils.getState(geClaimManagement.getState());
				String payType = ClaimUtils.getPayType(geClaimManagement.getPayType());
				claim.setInsrelationApp(insrelationApp);
				claim.setStartDate(startDate);
				claim.setInsureDate(insureDate);
				claim.setLanguageState(languageState);
				claim.setPayType(payType);
				claim.setCreateDate(createDate);
				claim.setLanguageClaimManagementType(languageClaimManagementType);
			}
			//测试地址
			String rider = ClaimUtils.RIDER+request.getContextPath()+"/";
			Set<GeClaimRider> claimSet = claim.getGeClaimRider();
			for (Iterator<GeClaimRider> iterator = claimSet.iterator(); iterator.hasNext();) {
				GeClaimRider geClaimRider = (GeClaimRider) iterator.next();
				String path = geClaimRider.getRiderPath();
				path = rider + path.substring(path.indexOf("IdentityImage"), path.length());
				geClaimRider.setRiderPath(path);
			}
			request.setAttribute("claimRiderSet", claim.getGeClaimRider());
			request.setAttribute("claim", claim);
			resultBusiness(true);
		} catch (Exception e) {
			logger.error("###findClaimAction 异常信息："+e);
			resultBusiness(false, "9000", "系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 保单人员查询结果集格式化
	 * @param partyInfos
	 * @return
	 */
	public List<Map<String,String>> formatPartyInformation(PartyInformation[] partyInfos){
		List<Map<String,String>> list = new  ArrayList<Map<String,String>>();
		HashMap<String,String> hm = null;
		String CardNo = "";
		String CardType = "";
		String ExpiredDate = "";
		for(PartyInformation partyInfo:partyInfos){
			if(partyInfo.getTCardInformation().length>0){
				//暂时单人无视多证件的情况
				CardInformation cardInfo = partyInfo.getTCardInformation(0);
				CardNo = cardInfo.getCardNo();
				CardType = IDTypeEntity.formatIDType("longType", "chineseType", cardInfo.getCardType());
				ExpiredDate = cardInfo.getExpiredDate();
			}
			hm = new HashMap<String, String>();
			hm.put("name", partyInfo.getName());
			hm.put("partyCode", partyInfo.getPartyCode());
			hm.put("CardNo",CardNo);
			hm.put("CardType",CardType);
			hm.put("ExpiredDate", ExpiredDate);
			list.add(hm);
		}
		return list;
	}
	
	private void sendMail(String policyCode, String deptId){
		logger.info("policyCode:"+policyCode+",deptId:"+deptId);
		if(deptId != null){
			StringBuffer to = new StringBuffer();
			GeResources resources = resourceService.get("RULE_BUSINESSDATA_CLAIM");
			Set<GePermission> permissions = resources.getGePermissions();
			for(GePermission permission: permissions){
				Set<GeRole> roles = permission.getGeRoles();
				for(GeRole role: roles){
					Set<GeUser> users = new HashSet<GeUser>(0);
					Set<GeUsergroup> usergroups = role.getGeUsergroups();
					for(GeUsergroup usergroup: usergroups){
						users = usergroup.getGeUsers();
					}
					users.addAll(role.getGeUsers());
					for(GeUser user: users){
						Set<GeDepartment> departments = user.getGeDepartments();
						for(GeDepartment department: departments){
							if(department.getDeptid() != null && department.getDeptid().equals(deptId) && user.getEmail() != null && !"".equals(user.getEmail())){
								to.append(user.getEmail()+",");
								break;
							}
						}
					}
				}
			}
			if(to.length()>0){
				MailUtil.sendSimpleMail(to.substring(0, to.length()-1).split(","),pro.getProperty("subject"),"您好!\n    保单号为：" + policyCode + "的理赔申请已提交成功，请及时处理!",pro.getProperty("toAddress").split(","));
				logger.info("收件人："+to.substring(0, to.length()-1).toString()+",抄送人："+pro.getProperty("toAddress"));
				return ;
			}
		}
		MailUtil.sendSimpleMail(pro.getProperty("toAddress").split(","),pro.getProperty("subject"),"您好!\n    保单号为：" + policyCode + "的理赔申请已提交成功，请及时处理!",null);
		logger.info("收件人："+pro.getProperty("toAddress"));
	}
	
	
	public GeClaimManagement getGeClaimManagement() {
		return geClaimManagement;
	} 

	public void setGeClaimManagement(GeClaimManagement geClaimManagement) {
		this.geClaimManagement = geClaimManagement;
	}

	@Override
	protected void processResultBusiness(boolean resultSuccess, String resultCode, String resultDescription) {}
	
}
