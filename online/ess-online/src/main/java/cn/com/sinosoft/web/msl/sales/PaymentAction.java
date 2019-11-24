package cn.com.sinosoft.web.msl.sales;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.sinosoft.common.OrderHelper;
import cn.com.sinosoft.common.PaymentConfigProp;
import cn.com.sinosoft.core.exception.BaseException;
import cn.com.sinosoft.core.utils.DateUtils;
import cn.com.sinosoft.domain.payment.GePaymentTypeInfo;
import cn.com.sinosoft.domain.sale.GeApplicantInsured;
import cn.com.sinosoft.domain.sale.GeChildlist;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePayList;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.domain.yinbaotong.BaseInfo;
import cn.com.sinosoft.domain.yinbaotong.LCAppnt;
import cn.com.sinosoft.domain.yinbaotong.LCCont;
import cn.com.sinosoft.domain.yinbaotong.LCInsured;
import cn.com.sinosoft.domain.yinbaotong.Risk;
import cn.com.sinosoft.ess.protal.common.ConfigProp;
import cn.com.sinosoft.ess.protal.common.PortalProp;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.InsurancePolicy;
import cn.com.sinosoft.msl.service.CharityPolicyService;
import cn.com.sinosoft.msl.service.PaymentService;
import cn.com.sinosoft.msl.service.WABpayService;
import cn.com.sinosoft.msl.service.WKBpayService;
import cn.com.sinosoft.msl.service.shortPolicy.InsureShortPolicyService;
import cn.com.sinosoft.sale.service.OrderService;
import cn.com.sinosoft.service.PayService;
import cn.com.sinosoft.util.LongPolicyUtil;
import cn.com.sinosoft.util.WJBLongPolicyUtil;
import cn.com.sinosoft.util.WJXLongPolicyUtil;
import cn.com.sinosoft.web.msl.BaseAction;
import cn.com.sinosoft.web.service.facade.GeGeographicalAreafindService;
import cn.com.sinosoft.web.service.facade.GePayListService;
import cn.com.sinosoft.weixin.util.ClientResponseHandler;
import cn.com.sinosoft.weixin.util.PaymentUtil;

/**
 * 描述：支付方式, 第三方支付平台<br>
 * 作者：CaryXu <br>
 * 修改日期：2015年4月30日 12:39:41 <br>
 * E-mail: Xukaizhen@sinosoft.com.cn <br>
 */
@ParentPackage(value = "ECS-STRUTS")
public class PaymentAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PaymentService paymentServices;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	private  PayService payService;
	
	@Autowired
	private GePayListService payListService;
	
	@Autowired
	private WKBpayService wkbpayService;
	
	@Autowired
	private WABpayService wabpayService;
	
	@Autowired
	GeGeographicalAreafindService GeGeographicalAreafindService;
	
	@Autowired
	private InsureShortPolicyService insureShortPolicyService;
	
	@Autowired
	private CharityPolicyService charityPolicyService;
	
	public static Logger logger = LoggerFactory.getLogger(PaymentAction.class);
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
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
	 * 订单的信息
	 */
	private GeOrder order;
	private String appId;//公众号id
	private String timeStamp;//时间戳
	private String nonceStr;//随机字符串
	private String packageValue;//订单详情扩展字符串
	private String paySign;//签名
    private String succeed;
    private String payType;//支付类型
    private List<GePaymentTypeInfo> paymentTypeInfoList;
    private String[] arrayStr=null; //发起支付所需要的参数
    private String orderCode; //订单号
    private String bankCode;//网银类型
    
    /**
     * 支付方式选择页
     * @return
     */
    @Action(value = "paymentOptions", results = {
			@Result(name="success",location="/WEB-INF/jsp/sales/pay.jsp")})
    public String paymentOptions(){
    	String sessionId=request.getSession().getId();
		try {
			logger.info("PaymentAction.PaymentOptions: "+sessionId);
			order=(GeOrder)session.get("InsurePolicy.Order");
			GeOrder geOrder=paymentServices.unPaidOrder(order);
			if(null == geOrder){
				paymentTypeInfoList=payService.PayWay(order);
				resultBusiness(false, "2022","用户手动刷新支付选择页面，需要弹出支付中状态的浮层");
				return "success";
			}
			paymentTypeInfoList=payService.PayWay(geOrder);
			resultBusiness(true);
		} catch (Exception e) {
			logger.info(sessionId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		return SUCCESS;
    }
    
    /**
	 * 选择支付方式后点击【确认支付】
	 * (env: 0:本机,1:SIT,2:UAT,3:PRD
	 * env=0 不支持5种支付方式
	 * env=1 不支持5种支付方式
	 * env=2 支持5种支付方式, 且金额都为0.01元
	 * env=3 支持5种支付方式, 且金额都为保费实际金额)
	 * 1.根据env为0和1的状态时不调支付接口，直接去承保
	 * 2.session获取订单对象 ，微信公众号支付需获取openId
	 * 3.更新订单信息，保存数据库
	 * 4.发起调用第三方支付请求的接口，获取发起支付的参数
	 * 5.将订单保存到session，将发起支付的数据保存到session
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Action(value = "pay", results = {
			@Result(name="success",location="/WEB-INF/jsp/sales/payInit.jsp"),
			@Result(name="waiting",location="/WEB-INF/jsp/sales/waiting.jsp")})
	public String pay(){
		HttpSession session1 = ServletActionContext.getRequest().getSession();
		String openId = (String) session1.getAttribute("openId");
		//openId = "oehBHuLB2sH9FEMWQ1aPhF4Ft9ek";
		try {
			String env=ConfigProp.getString("env");
			if("0".equals(env) || "1".equals(env)){
				payType="11";
				return "waiting";
			}
			String ordercode = (String) session1.getAttribute("ordercode");
			GeOrder geOrder = orderService.getOrderByOrderCode(ordercode);
			String resultStr = payService.pay(geOrder, openId,request);//预支付
			Set<GePolicy> policys = geOrder.getPolicys();
			String source = "";
			if(policys!=null&&policys.size()>0){
				Iterator<GePolicy> it = policys.iterator();
				GePolicy policy = it.next();
				source = policy.getSource();//获取来源
			}else{
				source = "tuanxian";
			}
		    this.request.setAttribute("source", source);
		    this.session.put("InsurePolicy.Pay", resultStr);
		}catch(BaseException e){
			logger.error(openId+"："+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			logger.error(openId+"："+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	
    
//	/**
//	 *  Session获取发起支付所需的二维码链接
//	 *	URL链接生产二维码图像
//     *  向页面写出二进制流
//	 * @return
//	 */
//	@Action(value = "QRCodeInit")
//    public String QRCodeInit(){
//    	String sessionId=request.getSession().getId();
//		try {
//			logger.info("PaymentAction.QRCodeInit: "+sessionId);
//			GeOrder geOrder=(GeOrder)session.get("InsurePolicy.Order");
//			GeOrder order=paymentServices.updateOrder(geOrder, "11","");
//			String curUrl=payService.pay(order, null,request);
//			response.setContentType("image/jpeg");
//			QRCodeWriter qrCodeWriter = new QRCodeWriter();
//			BitMatrix bitMatrix = qrCodeWriter.encode(curUrl,BarcodeFormat.QR_CODE, 300, 300);
//			String fileFormat = "gif";
//			MatrixToImageWriter.writeToStream(bitMatrix, fileFormat,response.getOutputStream());
//			resultBusiness(true);
//		} catch (Exception e) {
//			logger.info(sessionId+"："+e.getMessage());
//			logger.error(ExceptionUtils.getStackTrace(e));
//			e.printStackTrace();
//			resultBusiness(false, "9000","系统异常");
//			return ERROR;
//		}
//		return SUCCESS;
//    }
//    
//	
//    /**
//     * 跳转到发起支付的页面  除微信扫码
//     * @return
//     */
//	@Action(value = "payInit", results = {
//			@Result(name="success",location="/WEB-INF/jsp/sales/payInit.jsp")})
//    public String payInit(){
//    	String sessionId=request.getSession().getId();
//		try {
//			logger.info("PaymentAction.PayInit: "+sessionId);
//			arrayStr=(String[]) session.get("InsurePolicy.Pay");
//			GeOrder geOrder=(GeOrder)session.get("InsurePolicy.Order");
//			payType=geOrder.getPayway();
//			resultBusiness(true);
//		} catch (Exception e) {
//			logger.info(sessionId+"："+e.getMessage());
//			logger.error(ExceptionUtils.getStackTrace(e));
//			e.printStackTrace();
//			resultBusiness(false, "9000","系统异常");
//			return ERROR;
//		}
//		return SUCCESS;
//    }

	/**
	 * 跳转到页面等待页
	 * @return
	 */
	@Action(value = "waiting", results = {
			@Result(name="success",location="/WEB-INF/jsp/sales/waiting.jsp")})
	public String waiting(){
		String sessionId=request.getSession().getId();
		try {
			logger.info("PaymentAction.Waiting: "+sessionId);
			GeOrder geOrder=(GeOrder)session.get("InsurePolicy.Order");
			payType=geOrder.getPayway();
			resultBusiness(true);
		} catch (Exception e) {
			logger.info("【"+sessionId+"】："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 微信支付后台通知接口(反复收到同样商户订单号的通知)
	 * @return
	 * @throws Exception 
	 */
	@Action(value = "wxpayNotifyUrl")
	public String wxpayNotifyUrl() throws Exception {
		logger.info("开始进入微信支付成功通知接口");
		PrintWriter out= response.getWriter();
		String ordercode = null;
		try {
			String requestXml = IOUtils.toString(request.getInputStream(),request.getCharacterEncoding());
			logger.info("wxpayNotifyUrl异步通知返回参数："+requestXml);
			ClientResponseHandler queryRes = new ClientResponseHandler();
			queryRes.setContent(requestXml);
			SortedMap map=queryRes.getAllParameters();
			if("SUCCESS".equals((String)map.get("return_code"))){
				String key=PaymentConfigProp.getString("weixin_key");//密钥
				String sign=(String)map.get("sign");
				logger.info("微信支付后台通知接口参数："+map.toString());
				if(sign.equals(PaymentUtil.createSign(map,key))){
					//签名成功
					logger.info("#####签名开始");
					payService.updateProposalPaymentAndSaveProposalPaymentLog(map);
					logger.info("#####签名结束");
					//查询该笔订单是否已经支付，如果已经支付则不在修改订单信息
					if("SUCCESS".equals(queryRes.getParameter("return_code")) && "SUCCESS".equals(queryRes.getParameter("result_code"))){				
						String transaction_id = queryRes.getParameter("transaction_id");//取微信支付订单号
						String paytype = queryRes.getParameter("trade_type");
						String total_fee = queryRes.getParameter("total_fee");
						ordercode = queryRes.getParameter("out_trade_no");//取商户订单号
						String openid = queryRes.getParameter("openid");//取得openId
						List<GePayList> temp = payListService.getPayList(transaction_id);
						//如果此微信订单号无所对应记录且交易类型为JSAPI 第一次通知无对应记录 如果是第一次通知
						if(temp.size()<1&&paytype.equals("JSAPI")){
							GePayList gePayList = new GePayList();//支付表对象
							gePayList.setOrderid(ordercode);//存商户订单号
							gePayList.setMicroordercode(transaction_id);//微信订单号
							gePayList.setPaytype(paytype);
							gePayList.setMount(total_fee);
							gePayList.setPaytime(new Date());
							payListService.savePayList(gePayList);//保存支付表
							logger.info("支付表保存成功,订单号:"+ordercode+"  微信订单号:"+transaction_id);
							GeOrder geOrder = orderService.getOrderByOrderCode(ordercode);
							//做承保
							Set<GePolicy> policys = geOrder.getPolicys();
							if(policys!=null&&policys.size()>0&&!ordercode.startsWith("RT003")){//如果有关联的保单则做承保
								Iterator<GePolicy> it = policys.iterator();
								GePolicy policy = it.next();//取出保单
								String source = policy.getSource();//取出来源
								if(source.equals("changxian")){
									//长险承保
									String flag = longAcceptanceBr(ordercode,openid);
									if(flag.equals("1")){//如果承保成功
										out.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[支付成功]]></return_msg></xml>");
										logger.info("微信支付后台通知接口,成长卫士承保成功，订单号："+ordercode);
									}else{
										//承保失败,暂不处理，后补承保
										out.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[temp]]></return_msg></xml>");
										logger.info("微信支付后台通知接口,成长卫士承保失败，订单号："+ordercode);
									}
								}else if(source.equals("tuanxian")){//如果为团险
									if(ordercode.startsWith("RT002")){//如果为赠险成长卫士
										String flag = longAcceptance(ordercode,openid);
										if(flag.equals("1")){//如果承保成功
											updateSumamount(ordercode);//更新被保人保额
											out.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[支付成功]]></return_msg></xml>");
										}else{
											//承保失败,暂不处理，后补承保
											out.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[temp]]></return_msg></xml>");
										}
									}else if(ordercode.startsWith("RT003")){
										//仅更新捐书/款进度
										GeOrder order = orderService.getOrderByOrderCode(ordercode);//从库里取出订单实体
										Double bookmoney = order.getBookmoney();//书款
										Double stipend = order.getStipend();//捐款
										if(bookmoney!=null&&bookmoney>0){
											order.setBookStatus("已提交");//更新捐书进度
										}
										if(stipend!=null&&stipend>0){
											order.setGiftStatus("已提交");//更新捐款进度
										}
										orderService.updateOrder(order);//更新订单状态
										out.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[支付成功]]></return_msg></xml>");
									}
								}else if(source.equals("duanxian")){
									//短险承保待补充
									String flag = shortAcceptance(ordercode, openid);
									if("1".equals(flag)){
										out.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[支付成功]]></return_msg></xml>");
									} else {
										out.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[temp]]></return_msg></xml>");
									}
								}else if(source.equals("WENJIAXING")){
									String flag = longAcceptanceWJX(ordercode,openid);
									if(flag.equals("1")){//如果承保成功
										out.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[支付成功]]></return_msg></xml>");
									}else{
										//承保失败,暂不处理，后补承保
										out.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[temp]]></return_msg></xml>");
									}
								}else if(source.equals("WENJIABAO")){
									String flag = longAcceptanceWJB(ordercode,openid);
									if(flag.equals("1")){//如果承保成功
										out.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[支付成功]]></return_msg></xml>");
										logger.info("微信支付后台通知接口,稳驾保承保成功，订单号："+ordercode);
									}else{
										//承保失败,暂不处理，后补承保
										out.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[temp]]></return_msg></xml>");
										logger.info("微信支付后台通知接口,稳驾保承保失败，订单号："+ordercode);
									}
								}else if(source.equals("TAWENKB-R")){
									String flag = wkbpayService.WKBlongAcceptance(ordercode,openid);
									if(flag.equals("1")){//如果承保成功
										logger.info("稳康宝承保成功，订单号："+ordercode);
										out.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[支付成功]]></return_msg></xml>");
									}else{
										//承保失败,暂不处理，后补承保
										logger.info("稳康宝承保失败，订单号："+ordercode);
										out.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[temp]]></return_msg></xml>");
									}
								}else if(source.equals("WENAIBAO")){
									String flag = wabpayService.WABlongAcceptance(ordercode,openid);
									if(flag.equals("1")){//如果承保成功
										out.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[支付成功]]></return_msg></xml>");
										logger.info("微信支付后台通知接口,稳爱保承保成功，订单号："+ordercode);
									}else{
										//承保失败,暂不处理，后补承保
										out.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[temp]]></return_msg></xml>");
										logger.info("微信支付后台通知接口,稳爱保承保失败，订单号："+ordercode);
									}
								}
							}
							geOrder.setPaystatus("1");//支付成功
							geOrder.setGatewayrno(transaction_id);//微信订单号
							orderService.updateOrder(geOrder);//更新库表
							logger.info("微信支付通知接口更新订单表更新成功，订单号："+ordercode);
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error("微信异步通知异常");
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			return ERROR;
		}finally{
			out.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[支付成功]]></return_msg></xml>");
			out.flush();
			out.close();
			logger.info("微信支付通知接口执行完毕，订单号："+ordercode);
		}
		return null;
	}
	
	/**
	 * 稳驾保承保方法
	 * @param ordercode
	 * @param openId
	 * @return 1承保成功，0承保失败
	 */
	public String longAcceptanceWJB(String ordercode,String openId){
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
			logger.info("稳驾保承保订单状态修改完毕");
		}
		return flag;
	}
	
	
	/**
	 * 长险承保方法(增加合作伙伴代码的长险承保方法)
	 * @param ordercode
	 * @param openId
	 * @return 1承保成功，0承保失败
	 */
	public String longAcceptanceBr(String ordercode,String openId){
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
		String brNo = order.getBrNo();
		if(brNo==null||brNo.length()==0){
			brNo="A0000";
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
				String Code = order.getBankBranchCode();//续保银行
				String bankAccountNumber = policy.getBankAccountNumber();//续保银行账号
				LCCont lCCont = new LCCont();
				if(Code!=null&&bankAccountNumber!=null&&Code.length()>0&&bankAccountNumber.length()>0){//如果存在续保
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
//				lCCont.setAccBankCode("MSG01");//渠道编码
				
				BaseInfo baseInfo = new BaseInfo();
				baseInfo.setZoneNo("MSG01");//渠道编码
				baseInfo.setBrNo(brNo);//推荐码
				baseInfo.setActyNo(ActyNo);//活动码
				Map<String, String> map = LongPolicyUtil.approved(pro.getProperty("yinbaotong"), risk, lCInsured, lcAppnt,lCCont,baseInfo);
				flag = map.get("flag");
				policy.setBrNo(brNo);
				logger.info("保单信息加入合作伙伴代码"+brNo);
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
			logger.info("成长卫士承保订单状态修改完毕");
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
		Double bookmoney = order.getBookmoney();//书款
		Double stipend = order.getStipend();//捐款
		if(bookmoney!=null&&bookmoney>0){
			order.setBookStatus("已提交");//更新捐书进度
		}
		if(stipend!=null&&stipend>0){
			order.setGiftStatus("已提交");//更新捐款进度
		}
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
				logger.info("更新保额：取出被保儿童信息，name:"+geChild.getName()+"初始保额："+geChild.getAmount());
				if(geChild.getAmount()!=null){
					double amt = Double.valueOf(geChild.getAmount());
					logger.info("保单保额："+amt);
					geChild.setAmount(policy.getSumamount()+amt);
				}else{
					geChild.setAmount(policy.getSumamount());
				}
				charityPolicyService.updateAmount(geChild);
				orderService.updateOrder(order);//更新订单状态
				//更新结束	
		}catch (Exception e) {
			logger.error("更新被保人保额异常");
			e.printStackTrace();
		}
	}

	public boolean isActy(){
		//团险优惠时间段
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
	 * tuan承保方法
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
				
				
				
				String bankAccountNumber = policy.getBankAccountNumber();//续保银行账号
				String code=policy.getBankBranchCode();//银行编码
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
	 * 稳驾行承保方法
	 * @param ordercode
	 * @param openId
	 * @return 1承保成功，0承保失败
	 */
	public String longAcceptanceWJX(String ordercode,String openId){
		String ActyNo = "";//取得活动码
		String flag = "0";
		//长险承保
		GeApplicantInsured recognizee = null;
		GeApplicantInsured applicantInsured = null;
		GeOrder order = orderService.getOrderByOrderCode(ordercode);//从库里取出订单实体
		Set<GePolicy> policys = order.getPolicys();
		Iterator<GePolicy> it = policys.iterator();
		GePolicy policy = it.next();
		String brNo = order.getBrNo();
		if(brNo==null||brNo.length()==0){
			brNo="A0000";
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
//				String Code = order.getBankBranchCode();//续保银行
				String bankAccountNumber = policy.getBankAccountNumber();//续保银行账号
				LCCont lCCont = new LCCont();
//				if(Code!=null&&bankAccountNumber!=null&&Code.length()>0&&bankAccountNumber.length()>0){//如果存在续保
					lCCont.setBankAccNo(bankAccountNumber);//续保银行
					lCCont.setRenewalPermit("Y");//自动续保标志
					lCCont.setAccBankCode(order.getBankBranchCode());
					lCCont.setBankProvince(order.getBankProvince());
					lCCont.setBankCity(order.getBankCity());
//				}else{
//					lCCont.setAccBankCode("MSG01");//渠道编码
//				}
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
//				lCCont.setAccBankCode("MSG01");//渠道编码
				BaseInfo baseInfo = new BaseInfo();
				baseInfo.setZoneNo("MSG01");//渠道编码
				baseInfo.setBrNo(brNo);//推荐码
				baseInfo.setActyNo(ActyNo);//活动码
				Map<String, String> map = WJXLongPolicyUtil.approved(pro.getProperty("yinbaotong"), risk, lCInsured, lcAppnt,lCCont,baseInfo);
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
	
	/**
	 * 短险承保
	 * @param ordercode
	 * @param openId
	 * @return
	 */
	public String shortAcceptance(String ordercode,String openId){
		String flag = "1";//默认为成功
		Map<String,String> resultMap = null;
		String channelCode = PortalProp.getString("shortPolicyChannelId");
		//本地生成流水号
		String transNo = OrderHelper.getTransNo("A", channelCode);
		try {
			//组装承保实体
			GeOrder geOrder = orderService.findGeOrderByOrderCode(ordercode);//从数据库中获取订单对象
			InsurancePolicy ip = setShorBean(geOrder);
			//调用承保接口
			logger.info("paymentAction调用insurePromise方法");
			resultMap = insureShortPolicyService.insurePromise(geOrder, channelCode, transNo,ip);
			
			if(resultMap != null){
				if("0".equals(resultMap.get("resultCode"))){
					String orderamount = String.valueOf(ip.getProduct().getPremium());
					request.setAttribute("orderamount", orderamount);
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
					String transDate = sdf2.format(ip.getHeader().getTransDate());
					request.setAttribute("c", transDate);
					return flag;
				}else{
					logger.error("承保失败,openId: "+openId);
					flag = "0";
					return flag;
				}
			}else{
				logger.error("承保异常,openId: "+openId);
				flag = "0";
				return flag;
			}
		} catch (Exception e) {
			flag = "0";
			logger.error("承保或更改状态异常，openId:"+openId+"， 异常信息："+e);
		}
		
		return flag;
	}

	/**
	 * 组装承保所用bean
	 * @return
	 */
	public InsurancePolicy setShorBean(GeOrder geOrder){
		String channelCode = PortalProp.getString("shortPolicyChannelId");
		//本地生成orderNo
		String orderNo = OrderHelper.getOrderNumber("RT","100");
		String transNo = OrderHelper.getTransNo("A", channelCode);
		InsurancePolicy  ip = insureShortPolicyService.returnInsurancePolicy(orderNo, geOrder, channelCode, transNo);
		return ip;
	}
	

	
	/**
	 * 选择其他支付方式
	 * @return
	 */
	@Action(value = "payOthers", results = {
			@Result(name="success",type="json"),
			@Result(name="fail",type="json")})
	public String payOthers(){
		String sessionId=request.getSession().getId();
		try {
			logger.info("PaymentAction.PayOthers:"+sessionId);
			GeOrder order=(GeOrder) session.get("InsurePolicy.Order");
			GeOrder geOrder=paymentServices.updateOrderStatus(order);
			session.put("InsurePolicy.Order", geOrder);
			resultBusiness(true);
		}catch(BaseException e){
			logger.info(sessionId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, e.getExceptionCode(),e.getExceptionDesc());
		}catch (Exception e) {
			logger.info(sessionId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 判断订单是否支付成功
	 * @return
	 */
	@Action(value = "paySuccess", results = {
			@Result(name="success",type="json"),
			@Result(name="interrupt",type="json"),
			@Result(name="fail",type="json")})
	public String paySuccess(){
		String sessionId=request.getSession().getId();
		try {
			logger.info("PaymentAction.paySuccess:"+sessionId);
			GeOrder order=(GeOrder) session.get("InsurePolicy.Order");
			if(order == null){
				succeed="interrupt";
				return "interrupt";
			}
			succeed=paymentServices.paySuccess(order.getOrdercode());
			resultBusiness(true);
		}catch (Exception e) {
			logger.info(sessionId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 承保（先判断是否成功）
	 * @return
	 */
	@Action(value = "insurePolicy", results = {
			@Result(name="success",type="json"),
			@Result(name="fail",type="json")})
	public String insurePolicy(){
		String sessionId=request.getSession().getId();
		try {
			logger.info("PaymentAction.InsurePolicy:"+sessionId);
			GeOrder order=(GeOrder) session.get("InsurePolicy.Order");
			if(order == null){
				succeed="interrupt";
				return "interrupt";
			}
			succeed=paymentServices.insurePolicy(order.getOrdercode());
			resultBusiness(true);
		}catch(BaseException e){
			logger.info("【"+sessionId+"】:"+e.getExceptionDesc());
			e.printStackTrace();
			resultBusiness(false, e.getExceptionCode(), e.getExceptionDesc());
		} catch (Exception e) {
			logger.info(sessionId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 稳康宝继续支付方法
	 * 订单号
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Action(value = "payContinue", results = {
			@Result(name="success",location="/WEB-INF/jsp/sales/payInit.jsp"),
			@Result(name="waiting",location="/WEB-INF/jsp/sales/waiting.jsp")})
	public String payContinue(){
		HttpSession session1 = ServletActionContext.getRequest().getSession();
		String openId = (String) session1.getAttribute("openId");
		//openId = "oehBHuLB2sH9FEMWQ1aPhF4Ft9ek";
		try {
			String env=ConfigProp.getString("env");
			if("0".equals(env) || "1".equals(env)){
				payType="11";
				return "waiting";
			}
//			String ordercode = (String) session1.getAttribute("ordercode");
			String ordercode = request.getParameter("orderCode");
			GeOrder geOrder = orderService.getOrderByOrderCode(ordercode);
			String resultStr = payService.pay(geOrder, openId,request);//预支付
			Set<GePolicy> policys = geOrder.getPolicys();
			String source = "";
			if(policys!=null&&policys.size()>0){
				Iterator<GePolicy> it = policys.iterator();
				GePolicy policy = it.next();
				source = policy.getSource();//获取来源
			}else{
				source = "tuanxian";
			}
		    this.request.setAttribute("source", source);
		    this.session.put("InsurePolicy.Pay", resultStr);
		}catch(BaseException e){
			logger.error(openId+"："+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			logger.error(openId+"："+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	
//	
//	/**
//	 * 支付宝非手机支付同步通知接口
//	 * @return
//	 * @throws UnsupportedEncodingException 
//	 */
//	@Action(value = "zhifubaoReturnUrl", results = {
//			@Result(name="success",location="/WEB-INF/jsp/sales/waiting.jsp"),
//			@Result(name="fail",location="/WEB-INF/jsp/sales/waiting.jsp")})
//	public String zhifubaoReturnUrl(){
//		String sessionId=request.getSession().getId();
//		try {
//			logger.info("PaymentAction.ZhifubaoReturnUrl: "+sessionId);
//			GeOrder geOrder=(GeOrder)session.get("InsurePolicy.Order");
//			Map<String,String> params = payService.zhifubaoPayParam(request);
//			String trade_status = params.get("trade_status");
//			String commonParam=(String)params.get("extra_common_param");
//			String[] arrayStr=commonParam.split(",");
//			payType=arrayStr[0];
//			boolean verify_result = AlipayNotify.verify(params);
//			if(verify_result){//验证成功
//				if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
//					//更新订单状态
//					paymentServices.zhifubaoUpdateOrder(geOrder,params);	
//					payService.updateProposalPaymentAndSaveProposalPaymentLog(params);
//					logger.info("【"+sessionId+"】：支付宝非手机端同步通知签名校验成功，且支付成功");
//					resultBusiness(true);
//					return SUCCESS;
//				}
//				logger.info("【"+sessionId+"】：支付宝非手机端同步通知签名校验成功，支付宝端通知支付未成功");
//				resultBusiness(false, "2019","支付宝非手机端同步通知签名校验成功，支付宝端通知支付未成功");
//				return FAIL;
//			}else{
//				logger.info("【"+sessionId+"】：支付宝非手机端同步通知签名校验失败！");
//				resultBusiness(false, "2020","支付宝非手机端同步通知签名校验失败！");
//				return FAIL;
//			}
//		}catch(BaseException e){
//			logger.info("【"+sessionId+"】："+e.getMessage());
//			e.printStackTrace();
//			resultBusiness(false, e.getExceptionCode(),e.getExceptionDesc());
//			return FAIL;
//		} catch (Exception e) {
//			logger.info("【"+sessionId+"】："+e.getMessage());
//			logger.error(ExceptionUtils.getStackTrace(e));
//			e.printStackTrace();
//			resultBusiness(false, "9000","系统异常");
//			return ERROR;
//		}
//	}
//	
//	
//	/**
//	 * 支付宝非手机支付同步通知接口
//	 * @return
//	 * @throws UnsupportedEncodingException 
//	 */
//	@Action(value = "zhifubaoMobileReturnUrl", results = {
//			@Result(name="success",location="/WEB-INF/jsp/sales/waiting.jsp"),
//			@Result(name="fail",location="/WEB-INF/jsp/sales/waiting.jsp")})
//	public String zhifubaoMobileReturnUrl(){
//		String sessionId=request.getSession().getId();
//		try {
//			logger.info("PaymentAction.ZhifubaoMobileReturnUrl: "+sessionId);
//			Map<String,String> params = payService.zhifubaoPayParam(request);
//			GeOrder geOrder=(GeOrder)session.get("InsurePolicy.Order");
//			//交易状态
//			String result=(String)params.get("result");
//			payType="21";
//			boolean verify_result = AlipayNotify.verifyReturn(params);
//			if(verify_result){//验证成功
//				logger.info("【"+sessionId+"】：支付宝手机端同步通知签名校验成功");
//				if("success".equals(result)){
//					paymentServices.zhifubaoUpdateOrder(geOrder, params);
//					payService.updateProposalPaymentAndSaveProposalPaymentLog(params);
//					logger.info("【"+sessionId+"】：支付宝手机端同步通知签名校验成功，且支付成功");
//					resultBusiness(true);
//					return SUCCESS;
//				}
//				logger.info("【"+sessionId+"】：支付宝手机端同步通知签名校验成功，但是支付未成功");
//				resultBusiness(false, "2019","支付宝同步通知签名校验成功，但是支付未成功");
//				return FAIL;
//			}else{
//				logger.info("【"+sessionId+"】：支付宝手机端同步通知签名校验失败");
//				resultBusiness(false, "2020","支付宝手机端同步通知签名校验失败");
//				return FAIL;
//			}
//		}catch(BaseException e){
//			logger.info("【"+sessionId+"】："+e.getMessage());
//			e.printStackTrace();
//			resultBusiness(false, e.getExceptionCode(),e.getExceptionDesc());
//			return FAIL;
//		} catch (Exception e) {
//			logger.info("【"+sessionId+"】："+e.getMessage());
//			logger.error(ExceptionUtils.getStackTrace(e));
//			e.printStackTrace();
//			resultBusiness(false, "9000","系统异常");
//			return ERROR;
//		}
//	}
//	
//	
//	/**
//	 * 支付宝支付后台通知接口   非手机端
//	 * @param pe
//	 * @return
//	 * @throws IOException
//	 * @throws JDOMException
//	 */
//	@Action(value = "zhifubaoPayNotifyUrl")
//	public String zhifubaoPayNotifyUrl() throws IOException {
//		String sessionId=request.getSession().getId();
//		PrintWriter out= response.getWriter();
//		try {
//			logger.info("PaymentAction.ZhifubaoPayNotifyUrl: "+sessionId);
//			//获取支付宝POST过来反馈信息
//			Map<String,String> params = payService.zhifubaoPayParam(request);
//			logger.info("支付宝异步请求参数"+params.toString());
//			//交易状态
//			String trade_status=(String)params.get("trade_status");
//			//请求信息保存数据库  更新该笔订单的支付记录信息
//			payService.updateProposalPaymentAndSaveProposalPaymentLog(params);
//			//计算得出通知验证结果
//			boolean verify_result=AlipayNotify.verify(params);
//		
//			logger.info("支付宝异步通知结果："+verify_result);
//			if(verify_result){
//				//验证成功
//				if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
//					String returnStr= paymentServices.updateOrderAndInsurePolicy(params);
//					logger.info("【"+sessionId+"】：支付宝同步通知签名校验成功，且支付成功");
//					out.write(returnStr);
//				}
//				logger.info("【"+sessionId+"】：支付宝同步通知签名校验成功，但是支付未成功");
//				out.write("fail");
//			}else{
//				//验证失败
//				logger.info("【"+sessionId+"】：支付宝同步通知签名校验失败");
//				out.write("fail");
//			}
//		}catch(BaseException e){
//			logger.info("【"+sessionId+"】："+e.getMessage());
//			e.printStackTrace();
//			out.write("fail");
//		} catch (Exception e) {
//			logger.info("【"+sessionId+"】："+e.getMessage());
//			logger.error(ExceptionUtils.getStackTrace(e));
//			e.printStackTrace();
//			out.write("fail");
//		}finally{
//			out.flush();
//			out.close();
//		}
//		
//		return null;
//	}
//
//	
//	/**
//	 * 支付宝支付后台通知接口    手机端
//	 * @param pe
//	 * @return
//	 * @throws IOException
//	 * @throws JDOMException
//	 */
//	@Action(value = "zhifubaoMobilePayNotifyUrl")
//	public String zhifubaoMobilePayNotifyUrl() throws IOException{
//		String sessionId=request.getSession().getId();
//		PrintWriter out= response.getWriter();
//		try {
//			logger.info("PaymentAction.ZhifubaoMobilePayNotifyUrl: "+sessionId);
//			Map<String,String> params = payService.zhifubaoPayParam(request);
//			
//			//更新该笔订单的支付记录信息
//			payService.updateProposalPaymentAndSaveProposalPaymentLog(params);
//			
//			//XML解析notify_data数据
//			Document doc_notify_data = DocumentHelper.parseText(params.get("notify_data"));
//			
//			//交易状态
//			String trade_status = doc_notify_data.selectSingleNode( "//notify/trade_status" ).getText();
//			
//			if(AlipayNotify.verifyNotify(params)){
//				//验证成功
//				if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
//					paymentServices.updateOrderAndInsurePolicyMobile(doc_notify_data);
//					logger.info("【"+sessionId+"】：支付宝同步通知签名校验成功，且支付成功");
//					out.write("success");
//				}
//				logger.info("【"+sessionId+"】：支付宝手机端支付异步通知签名校验成功，但是支付失败");
//				out.write("fail");
//			}else{//验证失败
//				logger.info("【"+sessionId+"】：支付宝手机端支付异步通知签名校验失败");
//				out.write("fail");
//			}
//		}catch(BaseException e){
//			logger.info("【"+sessionId+"】："+e.getMessage());
//			e.printStackTrace();
//			out.write("fail");
//		} catch (Exception e) {
//			logger.info("【"+sessionId+"】："+e.getMessage());
//			logger.error(ExceptionUtils.getStackTrace(e));
//			e.printStackTrace();
//			out.write("fail");
//		}finally{
//			out.flush();
//			out.close();
//		}
//		return null;
//	}
	
	/**
	 * 跳转到支付成功页
	 * @return
	 *//*
	@Action(value = "insureSuccess", results = {
			@Result(name="success",location="/WEB-INF/jsp/sales/result.jsp")})
	public String insureSuccess(){
		String sessionId=request.getSession().getId();
		try {
			logger.info("PaymnetAction.InsureSuccess");
			GeOrder geOrder=(GeOrder) session.get("InsurePolicy.Order");
			order=paymentServices.getOrder(geOrder.getOrdercode());
		} catch (Exception e) {
			logger.info("【"+sessionId+"】："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	*//**
	 * 会话超时
	 * @return
	 *//*
	@Action(value = "interrupt", results = {
			@Result(name="success",location="/WEB-INF/jsp/sales/delay.jsp")})
	public String interrupt(){
		String sessionId=request.getSession().getId();
		try {
			logger.info("PaymnetAction.Interrupt");
		} catch (Exception e) {
			logger.info("【"+sessionId+"】："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		return SUCCESS;
	}*/
	
	/*public static void main(String[] args) {
		new WKBPolicyAction().WKBlongAcceptance("RT0051512181952400007883","");
		
		Date now=new Date();
		String appId="wxf7976813f2c4c421";
		String mchId="1237340702";//商户号
		String merchantOrderNo=Util.getMerchantOrderNo(now);
		String key="Cdehpq1234Pqlsdjfol56712werfaerd";//key
		SortedMap<String,Object>  httpReq=new TreeMap<String,Object>();
		httpReq.put("appid", appId);//微信平台appID
		httpReq.put("body", "支付成功");
		httpReq.put("mch_id", mchId);//商户号
		httpReq.put("nonce_str", Util.getRandomStringByLength(32));//随机字符串
		httpReq.put("notify_url", "http://localhost:8080/ess-online/sales/insureConfirm/weixinPayOk.jsp");//通知地址
		httpReq.put("openid", "oeYOqs8OH2CfV3WJHdQvBkYXK-mE");
		httpReq.put("out_trade_no", merchantOrderNo);//微信订单号
		httpReq.put("spbill_create_ip", "192.168.3.47");//终端IP
		httpReq.put("total_fee", "1");//总金额
		httpReq.put("trade_type", "JSAPI");//交易类型
		httpReq.put("sign", "");//签名
		
		String sign = PaymentUtil.createSign(httpReq,key);
		httpReq.put("sign", sign);
		String reqString=XMLUtil.mapToXmlString(httpReq);
		// 初始化http提交
		TenpayHttpClient httpClient = new TenpayHttpClient();
		// 通信对象
		httpClient.setTimeOut(30);
		//请求数据
		httpClient.call("https://api.mch.weixin.qq.com/pay/unifiedorder", reqString);
		System.out.println(httpClient.getResContent());
		SortedMap<String,Object>  httpReq1=new TreeMap<String,Object>();
		httpReq1.put("appid", appId);
		httpReq1.put("mch_id", mchId);
		httpReq1.put("device_info", "");
		httpReq1.put("nonce_str", Util.getRandomStringByLength(32));
		httpReq1.put("sign", sign);
		httpReq1.put("interface_url", "https://api.mch.weixin.qq.com/pay/unifiedorder");
		httpReq1.put("execute_time_", "10000");
		httpReq1.put("return_code", "FAIL");
		httpReq1.put("return_msg", "");
		httpReq1.put("result_code", "FAIL");
		httpReq1.put("err_code", "");
		httpReq1.put("err_code_des", "");
		httpReq1.put("out_trade_no", "");
		httpReq1.put("user_ip", "192.168.3.47");
		httpReq1.put("time", "");
		String httpUrl="https://api.mch.weixin.qq.com/payitil/report";
	}*/
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	public String getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}


	public String getNonceStr() {
		return nonceStr;
	}


	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}


	public String getPackageValue() {
		return packageValue;
	}
	public void setPackageValue(String packageValue) {
		this.packageValue = packageValue;
	}
	
	public String getPaySign() {
		return paySign;
	}

	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}
	
	public String getSucceed() {
		return succeed;
	}
	public void setSucceed(String succeed) {
		this.succeed = succeed;
	}
	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}
	public GeOrder getOrder() {
		return order;
	}

	public void setOrder(GeOrder order) {
		this.order = order;
	}

	public List<GePaymentTypeInfo> getPaymentTypeInfoList() {
		return paymentTypeInfoList;
	}

	public void setPaymentTypeInfoList(List<GePaymentTypeInfo> paymentTypeInfoList) {
		this.paymentTypeInfoList = paymentTypeInfoList;
	}
	public String[] getArrayStr() {
		return arrayStr;
	}
	public void setArrayStr(String[] arrayStr) {
		this.arrayStr = arrayStr;
	}
	
	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
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

	
	@Override
	protected void processResultBusiness(boolean resultSuccess,
			String resultCode, String resultDescription) {
	}

	public void setPaymentServices(PaymentService paymentServices) {
		this.paymentServices = paymentServices;
	}

	public void setPayService(PayService payService) {
		this.payService = payService;
	}
}
