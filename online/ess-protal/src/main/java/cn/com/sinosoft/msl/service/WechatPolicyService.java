package cn.com.sinosoft.msl.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.core.exception.BaseException;
import cn.com.sinosoft.core.exception.enumerate.ExceptionGrade;
//import cn.com.sinosoft.msl.model.claims.request.ClaimsQueryReq;
//import cn.com.sinosoft.msl.model.claims.response.Claim;
import cn.com.sinosoft.msl.model.common.request.Head;
//import cn.com.sinosoft.msl.model.customerMange.binding.request.BindingBody;
//import cn.com.sinosoft.msl.model.customerMange.identity.request.CustomerIdentityInfo;
//import cn.com.sinosoft.msl.model.customerMange.sendMessage.request.SendMessageInfo;
//import cn.com.sinosoft.msl.model.group.employeeProtection.request.EmployeeProtectionQueryReq;
//import cn.com.sinosoft.msl.model.group.employeeProtection.response.Insured;
//import cn.com.sinosoft.msl.model.personal.network.response.Body;
//import cn.com.sinosoft.msl.model.personal.payment.request.PaymentInfo;
//import cn.com.sinosoft.msl.model.personal.policy.request.PolicyQuery;
//import cn.com.sinosoft.msl.model.personal.policy.response.Policy;
//import cn.com.sinosoft.msl.model.personal.policyBasic.request.PolicyDetail;
//import cn.com.sinosoft.msl.model.preserve.address.query.request.AddressQueryReq;
//import cn.com.sinosoft.msl.model.preserve.address.query.response.Loan;
//import cn.com.sinosoft.msl.model.preserve.address.update.request.AddressUpdateReq;
//import cn.com.sinosoft.msl.model.preserve.address.update.request.Cont;
//import cn.com.sinosoft.msl.model.preserve.credit.request.CreditPolicyListQueryReq;
//import cn.com.sinosoft.msl.model.preserve.phone.query.request.PhoneQueryReq;
//import cn.com.sinosoft.msl.model.preserve.phone.query.response.PhoneQueryRes;
//import cn.com.sinosoft.msl.model.preserve.phone.update.request.PhoneUpdateReq;
//import cn.com.sinosoft.msl.model.preserve.remand.request.ReturnPolicyLoanReq;




public class WechatPolicyService {
	private static final Logger logger = LoggerFactory.getLogger(WechatPolicyService.class);
	
	private static final SimpleDateFormat formatDate=new SimpleDateFormat("yyyyMMdd");
	private static final SimpleDateFormat formatTime=new SimpleDateFormat("hhmmss");
	private static final DecimalFormat decimalFormat = new DecimalFormat("000");
	private static final SimpleDateFormat format=new SimpleDateFormat("yyyyMMddhhmmssSSS");
	
	private static final Random random = new Random();

//	
//	/**
//	 * 账户绑定（客户管理）
//	 * @param customerNo
//	 * @return
//	 */
//	public static boolean bindingAccount(String customerNo,String weChatId ){
//		cn.com.sinosoft.msl.model.customerMange.binding.request.TranData tranData = new cn.com.sinosoft.msl.model.customerMange.binding.request.TranData();
//		Head bindingHead = WechatPolicyService.getHead();
//		bindingHead.setFuncFlag("WC003");
//		tranData.setHead(bindingHead);
//		BindingBody binding = new BindingBody();
//		binding.setCustomerNo(customerNo);
//		binding.setWeChatId(weChatId);
//		tranData.setBindingBody(binding);
//		cn.com.sinosoft.msl.model.customerMange.binding.response.TranData head = InterfaceAssemblyService.accountBinding(tranData);
//		if ("0".equals(head.getHead().getFlag())){
//			logger.info("客户号【"+customerNo+"】调用账户绑定接口成功");
//			return true;
//		}else{
//			logger.info("客户号【"+customerNo+"】调用账户绑定接口失败，失败原因【"+head.getHead().getDesc()+"】");
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", head.getHead().getDesc());
//		}
//			
//	}
//	/**
//	 * 身份认证（客户管理）
//	 * @param customerIdentityInfo
//	 * @return
//	 */
//	public static PolicyQuery cardIdentify(CustomerIdentityInfo customerIdentityInfo){
//		cn.com.sinosoft.msl.model.customerMange.identity.request.TranData tranData = new cn.com.sinosoft.msl.model.customerMange.identity.request.TranData();
//		Head cardIdentifyHead = WechatPolicyService.getHead();
//		cardIdentifyHead.setFuncFlag("WC001");
//		tranData.setHead(cardIdentifyHead);
//		CustomerIdentityInfo customerIdentify = new CustomerIdentityInfo();
//		customerIdentify.setCustomerName(customerIdentityInfo.getCustomerName());
//		customerIdentify.setIDNo(customerIdentityInfo.getIDNo());
//		customerIdentify.setMobile4Right(customerIdentityInfo.getMobile4Right());
////		customerIdentify.setWechatID(customerIdentityInfo.getWechatID());
//		tranData.setCustomerIdentityInfo(customerIdentify);
//		cn.com.sinosoft.msl.model.customerMange.identity.response.TranData policyQuery = InterfaceAssemblyService.identityInfoQuery(tranData);
//		if("0".equals(policyQuery.getHead().getFlag())){
//			logger.info("客户号【"+policyQuery.getPolicyQuery()+"】调用身份认证接口成功");
//			return policyQuery.getPolicyQuery();
//		}else{
//			logger.info("客户号【"+policyQuery.getPolicyQuery()+"】调用身份认证接口失败，失败原因【"+policyQuery.getHead().getDesc()+"】");
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", policyQuery.getHead().getDesc());
//		}
//	}
//	/**
//	 * 发送短信（客户管理）
//	 * @param customerNo
//	 * @param smsMsg
//	 * @return
//	 */
//	public static boolean sendMessage(String customerNo,String smsMsg){
//		cn.com.sinosoft.msl.model.customerMange.sendMessage.request.TranData tranData = new cn.com.sinosoft.msl.model.customerMange.sendMessage.request.TranData();
//		Head sendMessageHead = WechatPolicyService.getHead();
//		sendMessageHead.setFuncFlag("WC002");
//		tranData.setHead(sendMessageHead);
//		SendMessageInfo sendmsg = new SendMessageInfo();
//		sendmsg.setCustomerNo(customerNo);
//		sendmsg.setSmsMsg(smsMsg);
//		tranData.setSendMessage(sendmsg);
//		cn.com.sinosoft.msl.model.customerMange.sendMessage.response.TranData head = InterfaceAssemblyService.sendMessage(tranData);
//		if ("0".equals(head.getHead().getFlag())){
//			logger.info("调用发送短信接口成功");
//			return true;
//		}else{
//			logger.info("调用发送短信接口失败，失败原因【"+head.getHead().getDesc()+"】");
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", head.getHead().getDesc());		
//		}
//	}
//	/**
//	 * 账户解绑（客户管理）
//	 * @param customerNo
//	 * @return
//	 */
//	public static boolean unBunding(String customerNo,String weChatId){
//		cn.com.sinosoft.msl.model.customerMange.unbunding.request.TranData tranData = new cn.com.sinosoft.msl.model.customerMange.unbunding.request.TranData();
//		Head sendMessageHead = WechatPolicyService.getHead();
//		sendMessageHead.setFuncFlag("WC004");
//		tranData.setHead(sendMessageHead);
//		BindingBody binding = new BindingBody();
//		binding.setCustomerNo(customerNo);
//		binding.setWeChatId(weChatId);
//		tranData.setBindingBody(binding);
//		cn.com.sinosoft.msl.model.customerMange.unbunding.response.TranData head = InterfaceAssemblyService.accountUnbunding(tranData);
//		if ("0".equals(head.getHead().getFlag())){
//			logger.info("客户号【"+customerNo+"】调用账户解绑接口成功");
//			return true;
//		}else{
//			logger.info("客户号【"+customerNo+"】调用账户解绑接口失败，失败原因【"+head.getHead().getDesc()+"】");
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", head.getHead().getDesc());
//		}
//	}
//	/**
//	 * 服务网点信息查询（个险）
//	 * @param zoneNo
//	 * @return
//	 */
//	public static Body findNetWork(String zoneNo)throws BaseException{
//		cn.com.sinosoft.msl.model.personal.network.request.TranData tranData = new cn.com.sinosoft.msl.model.personal.network.request.TranData();
//		cn.com.sinosoft.msl.model.personal.network.request.Body body = new cn.com.sinosoft.msl.model.personal.network.request.Body();
//		body.setZoneNo(zoneNo);
//		Head findNetWorkHead = WechatPolicyService.getHead();
//		findNetWorkHead.setFuncFlag("WC009");
//		tranData.setHead(findNetWorkHead);
//		tranData.setBody(body);
//		cn.com.sinosoft.msl.model.personal.network.response.TranData netWorkBody = InterfaceAssemblyService.serviceNetWorkQuery(tranData);
//		if ("0".equals(netWorkBody.getHead().getFlag())){
//			return netWorkBody.getBody();
//		}else{
//			
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", netWorkBody.getHead().getDesc());
//		}
//	}
//	/**
//	 * 缴费信息查询(个险)
//	 * @param contNo
//	 * @param startDate
//	 * @param endDate
//	 * @return
//	 */
//	public static cn.com.sinosoft.msl.model.personal.payment.response.Body paymentInfoQy(String contNo,String startDate,String endDate){
//		cn.com.sinosoft.msl.model.personal.payment.request.TranData tranData = new cn.com.sinosoft.msl.model.personal.payment.request.TranData();
//		PaymentInfo paymentInfo = new PaymentInfo();
//		paymentInfo.setContNo(contNo);
//		paymentInfo.setEndDate(endDate);
//		paymentInfo.setStartDate(startDate);
//		Head paymentInfoQyHead = WechatPolicyService.getHead();
//		paymentInfoQyHead.setFuncFlag("WC008");
//		tranData.setHead(paymentInfoQyHead);
//		tranData.setPaymentInfo(paymentInfo);
//		cn.com.sinosoft.msl.model.personal.payment.response.TranData tranDataRes = InterfaceAssemblyService.paymentInfoQuery(tranData);
//		if ("0".equals(tranDataRes.getHead().getFlag())){
//			logger.info("保单号【"+contNo+"】调用缴费信息查询接口成功");
//			return tranDataRes.getBody();
//		}else{
//			logger.info("客户号【"+contNo+"】调用缴费信息查询接口失败，失败原因【"+tranDataRes.getHead().getDesc()+"】");
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", tranDataRes.getHead().getDesc());
//		}
//	}
//	/**
//	 * 保单列表查询（个险）
//	 * @param customerNo
//	 * @return
//	 */
//	public static List<Policy> policyQuery(String customerNo){
//		cn.com.sinosoft.msl.model.personal.policy.request.TranData tranData = new cn.com.sinosoft.msl.model.personal.policy.request.TranData();
//		PolicyQuery policyQuery = new PolicyQuery();
//		policyQuery.setCustomerNo(customerNo);
//		Head policyQueryHead = WechatPolicyService.getHead();
//		policyQueryHead.setFuncFlag("WC005");
//		tranData.setHead(policyQueryHead);
//		tranData.setPolicyQuery(policyQuery);
//		cn.com.sinosoft.msl.model.personal.policy.response.TranData policy = InterfaceAssemblyService.policyQuery(tranData);
//		if ("0".equals(policy.getHead().getFlag())){
//			logger.info("客户号【"+customerNo+"】调用保单列表查询接口成功");
//			return policy.getBody().getPolicy();	
//		}else{
//			logger.info("客户号【"+customerNo+"】调用保单列表查询接口失败，失败原因【"+policy.getHead().getDesc()+"】");
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", policy.getHead().getDesc());
//		}
//	}
//	/**
//	 * 保单基本信息查询（个险）
//	 * @param customerNo
//	 * @param contNo
//	 * @return
//	 */
//	public static cn.com.sinosoft.msl.model.personal.policyBasic.response.Body policyDetailQuery(String customerNo,String contNo){
//		cn.com.sinosoft.msl.model.personal.policyBasic.request.TranData tranData = new cn.com.sinosoft.msl.model.personal.policyBasic.request.TranData();
//		PolicyDetail policyDetail = new PolicyDetail();
//		policyDetail.setContNo(contNo);
//		policyDetail.setCustomerNo(customerNo);
//		Head policyDetailQueryHead = WechatPolicyService.getHead();
//		policyDetailQueryHead.setFuncFlag("WC006");
//		tranData.setHead(policyDetailQueryHead);
//		tranData.setPolicyDetail(policyDetail);
//		cn.com.sinosoft.msl.model.personal.policyBasic.response.TranDataRes policyBasicInfo = InterfaceAssemblyService.policyDetailQuery(tranData);
//		if ("0".equals(policyBasicInfo.getHead().getFlag())){
//			logger.info("客户号【"+customerNo+"】调用保单基本信息查询接口成功");
//			return policyBasicInfo.getBody();
//		}else{
//			logger.info("客户号【"+customerNo+"】调用保单基本信息查询接口失败，失败原因【"+policyBasicInfo.getHead().getDesc()+"】");
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", policyBasicInfo.getHead().getDesc());
//		}
//	}
//	/**
//	 * 服务营销员信息查询（个险）
//	 * @param customerNo
//	 * @param contNo
//	 * @return
//	 */
////	public static List<SalesmanInfo> serviceInfoQuery(String customerNo,String contNo ){
////		cn.com.sinosoft.msl.model.personal.service.request.TranData tranData = new cn.com.sinosoft.msl.model.personal.service.request.TranData();
////		PolicyDetail policyDetail = new PolicyDetail();
////		policyDetail.setContNo(contNo);
////		policyDetail.setCustomerNo(customerNo);
////		Head serviceInfoQueryHead = WechatPolicyService.getHead();
////		serviceInfoQueryHead.setFuncFlag("WC010");
////		tranData.setHead(serviceInfoQueryHead);
////		tranData.setPolicyDetail(policyDetail);
////		cn.com.sinosoft.msl.model.personal.service.response.TranData salesmanInfo = InterfaceAssemblyService.serviceSaleInfoQuery(tranData);
////		if ("0".equals(salesmanInfo.getHead().getFlag())){
////			return salesmanInfo.getBody().getSalesmanInfo();
////		}else{
////			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "1", salesmanInfo.getHead().getDesc());
////		}
////	}
//	
//	/**
//	 * 理赔进展查询(个团险)
//	 * @param  customerNo 客户号
//	 * @return 理赔进展信息
//	 */
//	public static List<Claim>  claimsInfoQuery(String customerNo)throws BaseException{
//		cn.com.sinosoft.msl.model.claims.request.TranDataReq req=new cn.com.sinosoft.msl.model.claims.request.TranDataReq();
//		Head head=WechatPolicyService.getHead();
//		head.setFuncFlag("WC017");
//		req.setHead(head);
//		ClaimsQueryReq body=new ClaimsQueryReq();
//		body.setCustomerNo(customerNo);
//		req.setClaimsQueryReq(body);
//		cn.com.sinosoft.msl.model.claims.response.TranDataRes res=InterfaceAssemblyService.claimInfoQuery(req);
//		if("0".equals(res.getHead().getFlag())){
//			logger.info("客户号【"+customerNo+"】调用理赔进展查询接口成功");
//			if(null == res.getClaimsQueryRes().getClaimList()){
//				return null;
//			}
//			return res.getClaimsQueryRes().getClaimList();
//		}else{
//			logger.info("客户号【"+customerNo+"】调用理赔进展查询接口失败，失败原因【"+res.getHead().getDesc()+"】");
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", res.getHead().getDesc());
//		}
//	}
//	
//	
//	
//	/**
//	 * 员工-保障利益查询(团险)
//	 * @param  customerNo 客户号
//	 * @param  contNo 保单号
//	 * @return 员工-保障利益信息
//	 */
//	public static List<Insured>  employeeProtectionQuery(String customerNo,String contNo)throws BaseException{
//		cn.com.sinosoft.msl.model.group.employeeProtection.request.TranDataReq req=new cn.com.sinosoft.msl.model.group.employeeProtection.request.TranDataReq();
//		Head head=WechatPolicyService.getHead();
//		head.setFuncFlag("WC007");
//		req.setHead(head);
//		EmployeeProtectionQueryReq body=new EmployeeProtectionQueryReq();
//		body.setCustomerNo(customerNo);
//		body.setContNo(contNo);
//		req.setEmployeeProtectionQueryReq(body);
//		cn.com.sinosoft.msl.model.group.employeeProtection.response.TranDataRes res=InterfaceAssemblyService.employeeProtectionQuery(req);
//		if("0".equals(res.getHead().getFlag())){
//			return res.getEmployeeProtectionQueryRes().getInsuredList();
//		}else{
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", res.getHead().getDesc());
//		}
//	}
//	
//	
//	/**
//	 * 联系地址变更请求(保全业务)
//	 * @param contNo  客户号
//	 * @param contNo  保单号
//	 * @param province 省，编码
//	 * @param city 城市，编码
//	 * @param district 县，编码
//	 * @param address 地址
//	 * @param zipCode 邮编
//	 * @return true：修改成功，抛异常：失败
//	 */
//	public static boolean addressUpdate(String customerNo,String[] contNo,String province,String city,String district,String address,String zipCode)throws BaseException{
//		cn.com.sinosoft.msl.model.preserve.address.update.request.TranDataReq req=new cn.com.sinosoft.msl.model.preserve.address.update.request.TranDataReq();
//		Head head=WechatPolicyService.getHead();
//		head.setFuncFlag("WC012");
//		req.setHead(head);
//		AddressUpdateReq body=new AddressUpdateReq();
//		body.setCustomerNo(customerNo);
//		Cont cont=new Cont();
//		cont.setContNo(contNo);
//		body.setCont(cont);
//		body.setProvince(province);
//		body.setCity(city);
//		body.setDistrict(district);
//		body.setAddress(address);
//		body.setZipCode(zipCode);
//		req.setAddressUpdateReq(body);
//		cn.com.sinosoft.msl.model.preserve.address.update.response.TranDataRes res=InterfaceAssemblyService.addressUpdate(req);
//		if("0".equals(res.getHead().getFlag())){
//			logger.info("客户号【"+customerNo+"】调用联系地址变更接口成功");
//			return true;
//		}else{
//			logger.info("客户号【"+customerNo+"】调用联系地址变更接口失败，失败原因【"+res.getHead().getDesc()+"】");
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", res.getHead().getDesc());
//		}
//	}
//	
//	/**
//	 * 联系地址查询请求(保全业务)
//	 * @param customerNo 客户号
//	 * @return 客户联系地址信息
//	 */
//	public static List<Loan> addressQuery(String customerNo)throws BaseException{
//		cn.com.sinosoft.msl.model.preserve.address.query.request.TranDataReq req = new cn.com.sinosoft.msl.model.preserve.address.query.request.TranDataReq();
//		Head head=WechatPolicyService.getHead();
//		head.setFuncFlag("WC011");
//		req.setHead(head);
//		AddressQueryReq body = new AddressQueryReq();
//		body.setCustomerNo(customerNo);
//		req.setAddressQueryReq(body);
//		cn.com.sinosoft.msl.model.preserve.address.query.response.TranDataRes res=InterfaceAssemblyService.addressQuery(req);
//		if("0".equals(res.getHead().getFlag())){
//			logger.info("客户号【"+customerNo+"】调用联系地址查询接口成功");
//			if(null == res.getAddressQueryRes()){
//				return null;
//			}
//			return res.getAddressQueryRes().getLoanList();
//		}else{
//			logger.info("客户号【"+customerNo+"】调用联系地址查询接口失败，失败原因【"+res.getHead().getDesc()+"】");
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", res.getHead().getDesc());
//		}
//	}
//
//	
//	/**
//	 * 贷款保单列表查询(保全业务)
//	 * @param 客户号
//	 * @return 贷款保单列表信息
//	 */
//	public static List<cn.com.sinosoft.msl.model.preserve.credit.response.Loan>  creditPolicyListQuery(String customerNo)throws BaseException{
//		cn.com.sinosoft.msl.model.preserve.credit.request.TranDataReq tranData=new cn.com.sinosoft.msl.model.preserve.credit.request.TranDataReq();
//		Head head=WechatPolicyService.getHead();
//		head.setFuncFlag("WC015");
//		tranData.setHead(head);
//		CreditPolicyListQueryReq body=new CreditPolicyListQueryReq();
//		body.setCustomerNo(customerNo);
//		tranData.setCreditPolicyListQuery(body);
//		cn.com.sinosoft.msl.model.preserve.credit.response.TranDataRes  res=InterfaceAssemblyService.creditPolicyListQuery(tranData);
//		if ("0".equals(res.getHead().getFlag())) {
//			logger.info("客户号【"+customerNo+"】调用贷款保单列表查询接口成功");
//			if(null == res.getCreditPolicyListQueryRes()){
//				return null;
//			}
//			return res.getCreditPolicyListQueryRes().getLoanList();
//		}else{
//			logger.info("客户号【"+customerNo+"】调用贷款保单列表查询接口失败，失败原因【"+res.getHead().getDesc()+"】");
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", res.getHead().getDesc());
//		}
//		
//	}
//
// 
//	/**
//	 * 联系电话变更(保全业务)
//	 * @param customerNo 客户号
//	 * @param areaCode 固话区号
//	 * @param phone 固话号码
//	 * @param mobile 手机号码
//	 * @return true：修改成功，抛异常：失败
//	 */
//	public static boolean phoneUpdate(String customerNo,String areaCode,String phone,String extNumber,String mobile)throws BaseException{
//		cn.com.sinosoft.msl.model.preserve.phone.update.request.TranDataReq req=new cn.com.sinosoft.msl.model.preserve.phone.update.request.TranDataReq();
//		Head head=WechatPolicyService.getHead();
//		head.setFuncFlag("WC014");
//		req.setHead(head);
//		PhoneUpdateReq body=new PhoneUpdateReq();
//		body.setCustomerNo(customerNo);
//		body.setAreaCode(areaCode);
//		body.setExtNumber(extNumber);
//		body.setPhone(phone);
//		body.setMobile(mobile);
//		req.setPhoneUpdateReq(body);
//		cn.com.sinosoft.msl.model.preserve.phone.update.response.TranDataRes res=InterfaceAssemblyService.phoneUpdate(req);
//		if("0".equals(res.getHead().getFlag())){
//			logger.info("客户号【"+customerNo+"】调用联系电话变更接口成功");
//			return true;
//		}else{
//			logger.info("客户号【"+customerNo+"】调用联系电话变更接口失败，失败原因【"+res.getHead().getDesc()+"】");
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", res.getHead().getDesc());
//		}
//	}
//	
//	/**
//	 * 联系电话查询(保全业务)
//	 * @param customerNo  客户号
//	 * @return 联系电话信息
//	 */
//	public static  PhoneQueryRes phoneQuery(String customerNo)throws BaseException{
//		cn.com.sinosoft.msl.model.preserve.phone.query.request.TranDataReq req = new cn.com.sinosoft.msl.model.preserve.phone.query.request.TranDataReq();
//		Head head=WechatPolicyService.getHead();
//		head.setFuncFlag("WC013");
//		req.setHead(head);
//		PhoneQueryReq body=new PhoneQueryReq();
//		body.setCustomerNo(customerNo);
//		req.setPhoneQueryReq(body);
//		cn.com.sinosoft.msl.model.preserve.phone.query.response.TranDataRes res=InterfaceAssemblyService.phoneQuery(req);
//		if("0".equals(res.getHead().getFlag())){
//			logger.info("客户号【"+customerNo+"】调用联系电话查询接口成功");
//			return res.getPhoneQueryRes();
//		}else{
//			logger.info("客户号【"+customerNo+"】调用联系电话查询接口失败，失败原因【"+res.getHead().getDesc()+"】");
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", res.getHead().getDesc());
//		}
//	}
//	
//	/**
//	 * 归还保单贷款(保全业务)
//	 * @param contNo 保单号
//	 * @param repaymentAmnt  还款金额
//	 * @return
//	 */
//	public static boolean returnPolicyLoan(String customerNo,String contNo,String repaymentAmnt)throws BaseException{
//		cn.com.sinosoft.msl.model.preserve.remand.request.TranDataReq req = new cn.com.sinosoft.msl.model.preserve.remand.request.TranDataReq();
//		Head head=WechatPolicyService.getHead();
//		head.setFuncFlag("WC016");
//		req.setHead(head);
//		ReturnPolicyLoanReq body = new ReturnPolicyLoanReq();
//		body.setCustomerNo(customerNo);
//		body.setContNo(contNo);
//		body.setRepaymentAmnt(repaymentAmnt);
//		req.setReturnPolicyLoanRes(body);
//		cn.com.sinosoft.msl.model.preserve.remand.response.TranDataRes  res=InterfaceAssemblyService.returnPolicyLoan(req);
//		if("0".equals(res.getHead().getFlag())){
//			logger.info("客户号【"+customerNo+"】调用归还保单贷款还款接口成功");
//			return true;
//		}else{
//			logger.info("客户号【"+customerNo+"】调用归还保单贷款还款接口失败，失败原因【"+res.getHead().getDesc()+"】");
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2101", res.getHead().getDesc());
//		}
//		
//	}
//	
	
	
	
	//公共Head部分
	public static Head getHead(){
		Head head=new Head();
		Date now=new Date();
		head.setTranDate(formatDate.format(now));//交易日期[yyyyMMdd]
		head.setTranTime(formatTime.format(now));//交易时间[hhmmss]
		head.setTransrNo(format.format(now)+decimalFormat.format(random.nextInt(1000)));//交易流水号
		head.setSysCode("MSL");//前端系统代码,系统缩写 
		return head;
	}
	

	public static void main(String[] args) {
		//员工-保障利益查询(团险)
//		List<Insured> list=  employeeProtectionQuery("10982950","1011257266");
		
		//联系地址查询请求(保全业务)？
		//List<Loan> listLoan= addressQuery("4300003720");
		//联系地址变更请求(保全业务)
		//String[] contNo={"4300038042"};
		//boolean flag=addressUpdate("4300003720", contNo, "110000", "110100", "110101", "斯蒂芬斯蒂芬", "100000");
//		//贷款保单列表查询(保全业务)
		//List<cn.com.sinosoft.msl.model.preserve.credit.response.Loan> listLoan1= creditPolicyListQuery("4300003720");

//		//联系电话查询(保全业务)
		 //PhoneQueryRes phone= phoneQuery("4300025629");
		 
		//联系电话变更(保全业务)
		//boolean flag1=phoneUpdate("4300025629","0543","1000000","20","138XXXXXXXX");
//		 //归还保单贷款(保全业务)
		//boolean flag2= returnPolicyLoan("4300003720","4300038042","2835");
		
		//理赔
//		List<Claim> list=claimsInfoQuery("4300024974");
		/*for (int i = 0; i < listLoan.size(); i++) {
			System.out.println(listLoan.get(i));
		}*/
	}

}

