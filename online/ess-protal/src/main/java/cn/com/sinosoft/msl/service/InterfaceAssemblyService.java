package cn.com.sinosoft.msl.service;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.core.exception.BaseException;
import cn.com.sinosoft.core.utils.PropertityUtil;
import cn.com.sinosoft.ess.protal.common.ConfigProp;
import cn.com.sinosoft.ess.protal.common.JaxbMapper;
import cn.com.sinosoft.ess.protal.common.PortalProp;
import cn.com.sinosoft.ess.protal.webservice.Axis2ClientUtils2;


public class InterfaceAssemblyService {
	private static final Logger logger = LoggerFactory.getLogger("rootLogger");

//	private static String PortalProp.get;/* #银保通会员中心地址 */

//	private static String isDebug; /*是否调用本地报文*/
//	
//	private static String env; /*是否调用平台短信*/
	
//	static {
//		// 读取文件初始化WebService参数
//		PropertityUtil.init("config/portal.properties");
//		PortalProp.get = PropertityUtil.get("ybtCusCenterWebServiceURL");
//		
//	}
	/**
	 * 保单核保
	 * @param tranData
	 * @return
	 * @throws BaseException
	 */
	public static cn.com.sinosoft.msl.model.underWriting.response.TranDataRes underWriting(cn.com.sinosoft.msl.model.underWriting.request.TranDataReq tranData) throws BaseException {
		String reqxml = JaxbMapper.toXml(tranData, "GBK");
		logger.debug("请求："+reqxml);
		String resultXML = "";
		if("1".equals(ConfigProp.getString("isDebug"))){
			resultXML = InterfaceAssemblyService.underWritingResultX();
		}else{
			resultXML = Axis2ClientUtils2.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
		}
		logger.debug(resultXML);
		cn.com.sinosoft.msl.model.underWriting.response.TranDataRes dataRes = JaxbMapper.fromXml(resultXML,cn.com.sinosoft.msl.model.underWriting.response.TranDataRes.class);
		return dataRes;
	}
	/**
	 * 保单承保
	 * @param tranData
	 * @return
	 * @throws BaseException
	 */
	public static cn.com.sinosoft.msl.model.insurancePolicy.response.TranDataRes insurancePolicy(cn.com.sinosoft.msl.model.insurancePolicy.request.TranDataReq tranData) throws BaseException {
		String reqxml = JaxbMapper.toXml(tranData, "GBK");
		logger.debug("请求："+reqxml);
		String resultXML = "";
		if("1".equals(ConfigProp.getString("isDebug"))){
			resultXML = InterfaceAssemblyService.insurancePolicyResultX();
		}else{
			resultXML = Axis2ClientUtils2.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
		}
		logger.debug(resultXML);
		cn.com.sinosoft.msl.model.insurancePolicy.response.TranDataRes dataRes = JaxbMapper.fromXml(resultXML,cn.com.sinosoft.msl.model.insurancePolicy.response.TranDataRes.class);
		return dataRes;
	}
//	/**
//	 * 查询客户信息
//	 * @param tranData
//	 * @return
//	 * @throws BaseException   
//	 */
//	public static cn.com.sinosoft.msl.model.customerInfo.response.TranDataRes queryCustomerInfo(cn.com.sinosoft.msl.model.customerInfo.request.TranDataReq tranData) throws BaseException {
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		if("1".equals(ConfigProp.getString("isDebug"))){
//			resultXML = InterfaceAssemblyService.customerInfo();
//		}else{
//			resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
//		}
//		logger.debug(resultXML);
//		cn.com.sinosoft.msl.model.customerInfo.response.TranDataRes dataRes = JaxbMapper.fromXml(resultXML,cn.com.sinosoft.msl.model.customerInfo.response.TranDataRes.class);
//		return dataRes;
//	}
//	
//	/**
//	 * 查询营销员
//	 * @param tranData
//	 * @return
//	 * @throws BaseException
//	 */
//	public static cn.com.sinosoft.msl.model.salesMan.response.TranDataRes querySalesMan(cn.com.sinosoft.msl.model.salesMan.request.TranDataReq tranData) throws BaseException {
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		if("1".equals(ConfigProp.getString("isDebug"))){
//			resultXML = InterfaceAssemblyService.querySalesManResultX();
//		}else{
//			resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
//		}
//		logger.debug(resultXML);
//		cn.com.sinosoft.msl.model.salesMan.response.TranDataRes dataRes = JaxbMapper.fromXml(resultXML,cn.com.sinosoft.msl.model.salesMan.response.TranDataRes.class);
//		return dataRes;
//	}	
//	/**
//	 * 保单查询（个险）
//	 * @param tranData
//	 * @return
//	 * @throws BaseException
//	 */
//	public static cn.com.sinosoft.msl.model.personal.policy.response.TranData policyQuery(cn.com.sinosoft.msl.model.personal.policy.request.TranData tranData) throws BaseException {
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		if("1".equals(ConfigProp.getString("isDebug"))){
//			resultXML = InterfaceAssemblyService.resultX();
//		}else{
////			resultXML = InterfaceAssemblyService.resultX();
//			resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
//		}
//		logger.debug(resultXML);
//		cn.com.sinosoft.msl.model.personal.policy.response.TranData reponseTranData = JaxbMapper.fromXml(resultXML, cn.com.sinosoft.msl.model.personal.policy.response.TranData.class);
//		return reponseTranData;
//	}
//	/**
//	 * 保单详细信息查询 （个险）
//	 * @param tranData
//	 * @return
//	 * @throws BaseException
//	 */
//	
//	public static cn.com.sinosoft.msl.model.personal.policyBasic.response.TranDataRes policyDetailQuery(cn.com.sinosoft.msl.model.personal.policyBasic.request.TranData tranData)throws BaseException{
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		if("1".equals(ConfigProp.getString("isDebug"))){
//			resultXML = InterfaceAssemblyService.resultXml();
//		}else{
////			resultXML = InterfaceAssemblyService.resultXml();
//			resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
//		}
//		logger.debug(resultXML);
//		cn.com.sinosoft.msl.model.personal.policyBasic.response.TranDataRes reponseTranData = JaxbMapper.fromXml(resultXML, cn.com.sinosoft.msl.model.personal.policyBasic.response.TranDataRes.class);
//		return reponseTranData;
//	}
//	/**
//	 * 服务营销员信息查询 (个险)
//	 * @param tranData
//	 * @return
//	 * @throws BaseException
//	 */
//	public static cn.com.sinosoft.msl.model.personal.service.response.TranData serviceSaleInfoQuery(cn.com.sinosoft.msl.model.personal.service.request.TranData tranData)throws BaseException{
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		if("1".equals(ConfigProp.getString("isDebug"))){	
//		}else
//		resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
//		logger.debug(resultXML);
//		cn.com.sinosoft.msl.model.personal.service.response.TranData reponseTranData = JaxbMapper.fromXml(resultXML, cn.com.sinosoft.msl.model.personal.service.response.TranData.class);
//		return reponseTranData;
//	}
//	/**
//	 * 理赔进展查询(个团险)
//	 * @param  理赔进展查询-个团单请求报文
//	 * @return 理赔进展查询-个团单应答报文
//	 * @throws BaseException
//	 */
//	public static cn.com.sinosoft.msl.model.claims.response.TranDataRes claimInfoQuery(cn.com.sinosoft.msl.model.claims.request.TranDataReq tranData)throws BaseException{
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		if("1".equals(ConfigProp.getString("isDebug"))){
//			resultXML=InterfaceAssemblyService.getRequestXml("理赔进展查询");
//		}else{
//			resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
////			resultXML=InterfaceAssemblyService.getRequestXml("理赔进展查询");
//		}
//		logger.debug(resultXML);
//		cn.com.sinosoft.msl.model.claims.response.TranDataRes reponseTranData = JaxbMapper.fromXml(resultXML, cn.com.sinosoft.msl.model.claims.response.TranDataRes.class);
//		return reponseTranData;
//	}
//	/**
//	 * 缴费信息查询(个险)
//	 * @param tranData
//	 * @return
//	 * @throws BaseException
//	 */
//	public static cn.com.sinosoft.msl.model.personal.payment.response.TranData paymentInfoQuery(cn.com.sinosoft.msl.model.personal.payment.request.TranData tranData)throws BaseException{
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		if("1".equals(ConfigProp.getString("isDebug"))){
//			if(tranData.getPaymentInfo().getStartDate().equals("2014-11-15")){
//				resultXML = InterfaceAssemblyService.payInfoResult();
//			}if(tranData.getPaymentInfo().getStartDate().substring(0, 4).equals("2013")&&tranData.getPaymentInfo().getEndDate().substring(0, 4).equals("2013")){
//				resultXML = InterfaceAssemblyService.payEmpyInfo();
//			}else{
//				resultXML = InterfaceAssemblyService.paymentResult();
//			}
//		}else{
//			resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
//		}
//		logger.debug(resultXML);
//		cn.com.sinosoft.msl.model.personal.payment.response.TranData reponseTranData = JaxbMapper.fromXml(resultXML,cn.com.sinosoft.msl.model.personal.payment.response.TranData.class);
//		return reponseTranData;
//	}
//	/**
//	 * 服务网点信息查询（个险）
//	 * @param tranData
//	 * @return
//	 * @throws BaseException
//	 */
//	public static cn.com.sinosoft.msl.model.personal.network.response.TranData serviceNetWorkQuery(cn.com.sinosoft.msl.model.personal.network.request.TranData tranData)throws BaseException{
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
//		logger.debug(resultXML);
//		cn.com.sinosoft.msl.model.personal.network.response.TranData reponseTranData =  JaxbMapper.fromXml(resultXML,cn.com.sinosoft.msl.model.personal.network.response.TranData.class);
//		return reponseTranData;
//	}
////	/**
////	 * 员工-理赔信息查询(团险)
////	 * @param 员工-理赔信息查询请求报文(团险)
////	 * @return 员工-理赔信息查询应答报文(团险)
////	 * @throws BaseException
////	 */
////	public static cn.com.sinosoft.msl.model.group.employeeClaims.response.TranDataRes  employeeClaimsQuery(cn.com.sinosoft.msl.model.group.employeeClaims.request.TranDataReq tranData)throws BaseException{
////		String reqxml = JaxbMapper.toXml(tranData, "GBK");
////		String resultXML = "";
////		resultXML = Axis2ClientUtils.callBancassuranceRemoteService(BASE_ADDRESS + "/WebServiceForWeChat?wsdl", BASE_ADDRESS + "/WebServiceForWeChat", "service", reqxml);
////		logger.info(resultXML);
////		cn.com.sinosoft.msl.model.group.employeeClaims.response.TranDataRes reponseTranData = JaxbMapper.fromXml(resultXML, cn.com.sinosoft.msl.model.group.employeeClaims.response.TranDataRes.class);
////		return reponseTranData;
////	}
//	
//	/**
//	 * 员工-保障利益查询(团险)
//	 * @param 员工-保障利益查询请求报文(团险)
//	 * @return 员工-保障利益查询应答报文（团险）
//	 * @throws BaseException
//	 */
//	public static cn.com.sinosoft.msl.model.group.employeeProtection.response.TranDataRes  employeeProtectionQuery(cn.com.sinosoft.msl.model.group.employeeProtection.request.TranDataReq tranData)throws BaseException{
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		if("1".equals(ConfigProp.getString("isDebug"))){
//			resultXML = InterfaceAssemblyService.empResult();
//		}else{
//			resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
//		}
//		logger.debug(resultXML);
//		cn.com.sinosoft.msl.model.group.employeeProtection.response.TranDataRes reponseTranData = JaxbMapper.fromXml(resultXML, cn.com.sinosoft.msl.model.group.employeeProtection.response.TranDataRes.class);
//		return reponseTranData;
//	}
//	
//	
//	/**
//	 * 联系地址变更请求(保全业务)
//	 * @param 联系地址变更请求报文(保全业务)
//	 * @return 联系地址变更应答报文(保全业务)
//	 * @throws BaseException
//	 */
//	public static  cn.com.sinosoft.msl.model.preserve.address.update.response.TranDataRes  addressUpdate(cn.com.sinosoft.msl.model.preserve.address.update.request.TranDataReq tranData)throws BaseException{
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		if("1".equals(ConfigProp.getString("isDebug"))){
//			resultXML=InterfaceAssemblyService.getRequestXml("联系地址变更");
//		}else{
//			resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
////		resultXML=InterfaceAssemblyService.getRequestXml("联系地址变更");
//		}
//		logger.debug(resultXML);
//		 cn.com.sinosoft.msl.model.preserve.address.update.response.TranDataRes reponseTranData = JaxbMapper.fromXml(resultXML,  cn.com.sinosoft.msl.model.preserve.address.update.response.TranDataRes.class);
//		return reponseTranData;
//	}
//	
//	/**
//	 * 联系地址查询请求(保全业务)
//	 * @param 联系地址查询请求报文(保全业务)
//	 * @return 联系地址查询应答报文(保全业务)
//	 * @throws BaseException
//	 */
//	public static  cn.com.sinosoft.msl.model.preserve.address.query.response.TranDataRes  addressQuery(cn.com.sinosoft.msl.model.preserve.address.query.request.TranDataReq tranData)throws BaseException{
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		if("1".equals(ConfigProp.getString("isDebug"))){
//			resultXML=InterfaceAssemblyService.getRequestXml("联系地址查询");
//		}else{
//			resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
////		resultXML=InterfaceAssemblyService.getRequestXml("联系地址查询");
//		}
//		logger.debug(resultXML);
//		cn.com.sinosoft.msl.model.preserve.address.query.response.TranDataRes reponseTranData = JaxbMapper.fromXml(resultXML,  cn.com.sinosoft.msl.model.preserve.address.query.response.TranDataRes.class);
//		return reponseTranData;
//	}
//	
//	
//	/**
//	 * 贷款保单列表查询(保全业务)
//	 * @param 贷款保单列表查询请求报文(保全业务)
//	 * @return 贷款保单列表查询应答报文(保全业务)
//	 * @throws BaseException
//	 */
//	public static  cn.com.sinosoft.msl.model.preserve.credit.response.TranDataRes creditPolicyListQuery(cn.com.sinosoft.msl.model.preserve.credit.request.TranDataReq tranData)throws BaseException{
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		if("1".equals(ConfigProp.getString("isDebug"))){
//			resultXML=InterfaceAssemblyService.getRequestXml("贷款保单");
//		}else{
//			resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
////		resultXML=InterfaceAssemblyService.getRequestXml("贷款保单");
//		}
//		logger.debug(resultXML);
//		cn.com.sinosoft.msl.model.preserve.credit.response.TranDataRes reponseTranData = JaxbMapper.fromXml(resultXML,cn.com.sinosoft.msl.model.preserve.credit.response.TranDataRes.class);
//		return reponseTranData;
//	}
//	
//	/**
//	 * 联系电话变更(保全业务)
//	 * @param 联系电话变更请求报文(保全业务)
//	 * @return 联系电话变更应答报文(保全业务)
//	 * @throws BaseException
//	 */
//	public static  cn.com.sinosoft.msl.model.preserve.phone.update.response.TranDataRes  phoneUpdate(cn.com.sinosoft.msl.model.preserve.phone.update.request.TranDataReq tranData)throws BaseException{
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		if("1".equals(ConfigProp.getString("isDebug"))){
//			resultXML=InterfaceAssemblyService.getRequestXml("联系电话变更");
//		}else{
//			resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
////		resultXML=InterfaceAssemblyService.getRequestXml("联系电话变更");
//		}
//		logger.debug(resultXML);
//		cn.com.sinosoft.msl.model.preserve.phone.update.response.TranDataRes reponseTranData = JaxbMapper.fromXml(resultXML,cn.com.sinosoft.msl.model.preserve.phone.update.response.TranDataRes.class);
//		return reponseTranData;
//	}
//	
//	/**
//	 * 联系电话查询(保全业务)
//	 * @param 联系电话查询请求报文(保全业务)
//	 * @return 联系电话查询应答报文(保全业务)
//	 * @throws BaseException
//	 */
//	public static  cn.com.sinosoft.msl.model.preserve.phone.query.response.TranDataRes  phoneQuery(cn.com.sinosoft.msl.model.preserve.phone.query.request.TranDataReq tranData)throws BaseException{
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		if("1".equals(ConfigProp.getString("isDebug"))){
//			resultXML=InterfaceAssemblyService.getRequestXml("联系电话查询");
//		}else{
//			resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
////		resultXML=InterfaceAssemblyService.getRequestXml("联系电话查询");
//		}
//		logger.debug(resultXML);
//		cn.com.sinosoft.msl.model.preserve.phone.query.response.TranDataRes reponseTranData = JaxbMapper.fromXml(resultXML,cn.com.sinosoft.msl.model.preserve.phone.query.response.TranDataRes.class);
//		return reponseTranData;
//	}
//	
//	
//	/**
//	 *  归还保单贷款(保全业务)
//	 * @param  归还保单贷款请求报文(保全业务)
//	 * @return  归还保单贷款应答报文(保全业务)
//	 * @throws BaseException
//	 */
//	public static  cn.com.sinosoft.msl.model.preserve.remand.response.TranDataRes  returnPolicyLoan(cn.com.sinosoft.msl.model.preserve.remand.request.TranDataReq tranData)throws BaseException{
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		if("1".equals(ConfigProp.getString("isDebug"))){
//			resultXML=InterfaceAssemblyService.getRequestXml("归还保单贷款");
//		}else{
//			resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
////		resultXML=InterfaceAssemblyService.getRequestXml("归还保单贷款");
//		}
//		logger.debug(resultXML);
//		cn.com.sinosoft.msl.model.preserve.remand.response.TranDataRes reponseTranData = JaxbMapper.fromXml(resultXML,cn.com.sinosoft.msl.model.preserve.remand.response.TranDataRes.class);
//		return reponseTranData;
//	}
//	/**
//	 * 账号绑定（客户管理）
//	 * @param tranData
//	 * @return
//	 * @throws BaseException
//	 */
//	public static cn.com.sinosoft.msl.model.customerMange.binding.response.TranData accountBinding(cn.com.sinosoft.msl.model.customerMange.binding.request.TranData tranData) throws BaseException{
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		if("1".equals(ConfigProp.getString("isDebug"))){
//			resultXML=InterfaceAssemblyService.getRequestXml("归还保单贷款");
//		}else{
//			resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
////		resultXML =InterfaceAssemblyService.bindResult();
//		}
//		logger.debug(resultXML);
//		cn.com.sinosoft.msl.model.customerMange.binding.response.TranData reponseTranData = JaxbMapper.fromXml(resultXML,cn.com.sinosoft.msl.model.customerMange.binding.response.TranData.class);
//		return reponseTranData;
//	}
//	/**
//	 * 身份认证 （客户管理）
//	 * @param tranData
//	 * @return
//	 * @throws BaseException
//	 */
//	public static cn.com.sinosoft.msl.model.customerMange.identity.response.TranData identityInfoQuery(cn.com.sinosoft.msl.model.customerMange.identity.request.TranData tranData)throws BaseException{
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		if("1".equals(ConfigProp.getString("isDebug"))){
//			resultXML = InterfaceAssemblyService.identityResult();
//		}else{
////		if(tranData.getCustomerIdentityInfo().getCustomerName().equals("覃龙")){
////			resultXML = InterfaceAssemblyService.oneResult();
////		}else{
////			resultXML = InterfaceAssemblyService.identityResult();
////		}
//			resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
//		}
//		logger.debug(resultXML);
//		cn.com.sinosoft.msl.model.customerMange.identity.response.TranData reponseTranData = JaxbMapper.fromXml(resultXML,cn.com.sinosoft.msl.model.customerMange.identity.response.TranData.class);
//		return reponseTranData;
//	}
//	/**
//	 * 发送短信（客户管理）
//	 * @param tranData
//	 * @return
//	 * @throws BaseException
//	 */
//	public static cn.com.sinosoft.msl.model.customerMange.sendMessage.response.TranData sendMessage(cn.com.sinosoft.msl.model.customerMange.sendMessage.request.TranData tranData)throws BaseException{
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		if("3".equals(ConfigProp.getString("env"))){
//			resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
//		}else{
//			resultXML = InterfaceAssemblyService.messageResult();
//		}
//		logger.debug(resultXML);
//		cn.com.sinosoft.msl.model.customerMange.sendMessage.response.TranData reponseTranData = JaxbMapper.fromXml(resultXML,cn.com.sinosoft.msl.model.customerMange.sendMessage.response.TranData.class);
//		return reponseTranData;
//	}
//	/**
//	 * 账号解绑（客户管理）
//	 * @param tranData
//	 * @return
//	 * @throws BaseException
//	 */
//	public static cn.com.sinosoft.msl.model.customerMange.unbunding.response.TranData accountUnbunding(cn.com.sinosoft.msl.model.customerMange.unbunding.request.TranData tranData)throws BaseException{
//		String reqxml = JaxbMapper.toXml(tranData, "GBK");
//		String resultXML = "";
//		if("1".equals(ConfigProp.getString("isDebug"))){
//			resultXML =InterfaceAssemblyService.bindResult();
//		}else{
//			resultXML = Axis2ClientUtils.callBancassuranceRemoteService(PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat?wsdl", PortalProp.getString("ybtCusCenterWebServiceURL") + "/WebServiceForWeChat", "service", reqxml);
////		resultXML =InterfaceAssemblyService.bindResult();
//		}
//		logger.debug(resultXML);
//		cn.com.sinosoft.msl.model.customerMange.unbunding.response.TranData reponseTranData = JaxbMapper.fromXml(resultXML,cn.com.sinosoft.msl.model.customerMange.unbunding.response.TranData.class);
//		return reponseTranData;
//	}
	public static String bindResult(){
		String result = "";
		result = "<?xml version='1.0' encoding=	'GBK'?>" + 
				"<TranData>"+
				"<Head>"+
					"<Flag>0</Flag>"+
					"<Desc>交易成功！</Desc>"+
				"</Head>"+
				"</TranData>";
		return result;
	}
	public static String messageResult(){
		String result = "";
		result = "<?xml version='1.0' encoding=	'GBK'?>" + 
				"<TranData>"+
				"<Head>"+
					"<Flag>0</Flag>"+
					"<Desc>交易成功！</Desc>"+
				"</Head>"+
				"</TranData>";
		return result;
	}
	public static String identityResult(){
		String result = "";
		result = "<?xml version='1.0' encoding=	'GBK'?>" + 
				"<TranData>"+
				"<Head>"+
					"<Flag>0</Flag>"+
					"<Desc>success</Desc>"+
				"</Head>"+
				"<Body>"+
					"<CustomerNo>8888888888</CustomerNo>"+
				"</Body>"+
				"</TranData>";			
		return result;
	}
	public static String resultXml(){
		String result = "";
		result = "<?xml version='1.0' encoding=	'GBK'?>" + 
					"<TranData>"+
						"<Head>"+
							"<Flag>0</Flag>"+
							"<Desc>交易成功！</Desc>"+
							"</Head>"+
						"<Body>"+
							"<AppntName>张三</AppntName>"+
							"<InsuredCode>0001</InsuredCode>"+
							" <InsuredName>李四</InsuredName>"+
							"<BonusValue>1,000.00</BonusValue>"+
							"<CashValueType>03</CashValueType>"+
							"<CashValue>213</CashValue>"+
							"<LoanAmnt>130000.00</LoanAmnt>"+
							"<EarnedPrem>1000.00</EarnedPrem>"+
							"<GetCashValue>4000.00</GetCashValue>"+
							"<PayYear>4</PayYear>"+
							"<InsuEndDate>9999-12-31</InsuEndDate>"+
							"<AgentCode>001</AgentCode>"+
							"<AgentName>蔡明</AgentName>"+
							"<AgentPhone>13147865120</AgentPhone>"+
							"<OrganName>上海</OrganName>"+
							"<OrganAddr>上海虹口</OrganAddr>"+
							"<OrganZipCode>13400</OrganZipCode>"+
							"<OrganTele>95383</OrganTele>"+
							"<BnfInfo>范冰冰/李连杰/</BnfInfo>"+	
							"<AccountValue>29120.11</AccountValue>"+	
							"<Insured> "+
								"<Code>0001</Code>"+
								"<Name>王五</Name>"+
								"<Risk>"+
									"<RiskName>金彩人生</RiskName>"+
									"<RiskCode>213123</RiskCode>"+
									"<Amnt></Amnt>"+
								"</Risk>"+
							"</Insured>"+
							"<Insured> "+
								"<Code>0001</Code>"+
								"<Name>张三</Name>"+
								"<Risk>"+
									"<RiskName>金彩人生</RiskName>"+
									"<RiskCode>213123</RiskCode>"+
									"<Amnt>7000.00元</Amnt>"+
								"</Risk>"+
							"</Insured>"+
						"</Body>"+
					"</TranData>";							
		return result;
	}
	public static String customerInfo(){
		String result = "";
		result = "<?xml version='1.0' encoding=	'GBK'?>" + 
				"<TranData>"+
					"<Head>"+
						"<Flag>0</Flag>"+
						"<Desc>success</Desc>"+
					"</Head>"+
					"<Body>"+
						"<CustomerName>李四</CustomerName>"+
						"<IDNo>310113199201013413</IDNo>"+
						"<Mobile>13856450998</Mobile>"+
						"<Email>123@123.com</Email>"+
					"</Body>"+
				"</TranData>";
		return result;
	}
	public static String resultX(){
		String result = "";
		result = "<?xml version='1.0' encoding=	'GBK'?>" + 
				 "<TranData>"+
				 	"<Head>"+
				 		"<Flag>0</Flag>"+
				 		"<Desc>success</Desc>"+
				 	"</Head>"+
				 	"<Body>"+
				 		"<Policy>"+
				 			"<ContNo>4380000025</ContNo>"+
				 			"<MainRiskName>聪明宝宝</MainRiskName>"+
				 			"<MainRiskCode>ABC</MainRiskCode>"+
				 			"<CValiDate>2014-01-01</CValiDate>"+
				 			"<GBOFlag>CAS</GBOFlag>"+
				 			"<ContStatus>P</ContStatus>"+
				 			"<ContDesc></ContDesc>"+
				 		"</Policy>"+
				 		"<Policy>"+
				 			" <ContNo>9500128377</ContNo>"+
				 			"<MainRiskName>金彩人生</MainRiskName>"+
				 			"<MainRiskCode>ABC</MainRiskCode>"+
				 			"<CValiDate>2013-03-05</CValiDate>"+
				 			"<GBOFlag>CAS</GBOFlag>"+
				 			"<ContStatus>P</ContStatus>"+
				 			"<ContDesc></ContDesc>"+
				 		"</Policy>"+
				 		"<Policy>"+
				 			"<ContNo>67T0000183</ContNo>"+
				 			"<MainRiskName>安心无忧</MainRiskName>"+
				 			"<MainRiskCode>ABC</MainRiskCode>"+
				 			"<CValiDate>2011-02-03</CValiDate>"+
				 			"<GBOFlag>GLH</GBOFlag>"+
				 			"<ContStatus>P</ContStatus>"+
				 			"<ContDesc></ContDesc>"+
			 			"</Policy>"+
				 	"</Body>"+
				 "</TranData>";
		return result ;
	}
	public static String underWritingResultX(){
		String result = "";
		result = "<?xml version='1.0' encoding=	'GBK'?>" + 
				 "<TranData>"+
				 	"<Head>"+
				 		"<Flag>0</Flag>"+
				 		"<Desc>交易成功：集成测试</Desc>"+
				 	"</Head>"+
				 	"<Body>"+
				 			"<TransChnl>01</TransChnl>"+
				 			"<ContNo>91A0000017</ContNo>"+
				 			"<TransNo>20150520042904578735</TransNo>"+
				 			"<ProposalPrtNo>2014021250461195</ProposalPrtNo>"+
				 			"<Prem>2100</Prem>"+
				 			"<Amnt>50000000</Amnt>"+
				 			"<ComCode/>"+
				 			"<ComLocation/>"+
				 			"<ComName/>"+
				 			"<ComZipCode/>"+
				 			"<ComPhone/>"+	
				 			"<ContractEffDate>20150420</ContractEffDate>"+
				 			"<ContractEndDate/>"+
				 	"</Body>"+
				 "</TranData>";
		return result ;
	}	
	public static String insurancePolicyResultX(){
		String result = "";
		result = "<?xml version='1.0' encoding=	'GBK'?>" + 
				 "<TranData>"+
				 	"<Head>"+
				 		"<Flag>0</Flag>"+
				 		"<Desc>承保成功！</Desc>"+
				 	"</Head>"+
				 "</TranData>";
		return result ;
	}
	public static String querySalesManResultX(){
		String result = "";
		result = "<?xml version='1.0' encoding=	'GBK'?>" + 
				 "<TranData>"+
				 	"<Head>"+
				 		"<Flag>0</Flag>"+
				 		"<Desc>交易成功！</Desc>"+
				 		"</Head>"+
				 		"<Body>"+
					 	"<AgentCode>123123123</AgentCode>"+
					 	"<AgentName>Lee</AgentName>"+
					 	"<LocName>231321231</LocName>"+
				 	"</Body>"+
				 "</TranData>";
		return result ;
	}	
	
	public static String paymentResult(){
		String result = "";
		result = "<?xml version='1.0' encoding=	'GBK'?>" + 
				"<TranData>"+
				" <Head>"+
				"<Flag>0</Flag>"+
				"<Desc>交易成功！</Desc>"+
				"</Head>"+
				"<Body>"+
				"<PayIntv>5</PayIntv>"+
				"<Prem>75724.00</Prem>"+
				"<NextPayDate>2014-02-11</NextPayDate>"+
				"<PayMode>银行转账</PayMode>"+
				"<PayBankCode>01</PayBankCode>"+
				"<PayBankName>工商银行</PayBankName>"+
				"<PayAccNo>6222021001101679220</PayAccNo>"+
				"<Payment>"+
				"	<PayDate>2014-11-15</PayDate>"+
				"	<PayMode>银行转账</PayMode>"+
				"	<PayAmnt>1000.00</PayAmnt>"+
				"</Payment>"+
				"<Payment>"+
				"	<PayDate>2014-11-29</PayDate>"+
				" 	<PayMode>银行转账</PayMode>"+
				" 	<PayAmnt>2000.00</PayAmnt>"+
				"</Payment>"+
				"<Payment>"+
				"	<PayDate>2014-12-01</PayDate>"+
				" 	<PayMode>银行转账</PayMode>"+
				"	<PayAmnt>3000.00</PayAmnt>"+
				"</Payment>"+
				"<Payment>"+
				"<PayDate>2015-02-01</PayDate>"+
				" <PayMode>银行转账</PayMode>"+
				" <PayAmnt>1000.00</PayAmnt>"+
				"</Payment>"+
				"</Body>"+
				"</TranData>";
		return result;
	}
	public static String payInfoResult(){
		String result = "";
		result = "<?xml version='1.0' encoding=	'GBK'?>" + 
				"<TranData>"+
				" <Head>"+
				"<Flag>0</Flag>"+
				"<Desc>交易成功！</Desc>"+
				"</Head>"+
				"<Body>"+
				"<PayIntv>5</PayIntv>"+
				"<Prem>75724.00</Prem>"+
				"<NextPayDate>2014-02-11</NextPayDate>"+
				"<PayMode>银行转账</PayMode>"+
				"<PayBankCode>01</PayBankCode>"+
				"<PayBankName>招行银行</PayBankName>"+
				"<PayAccNo>01234567890124</PayAccNo>"+
				"<Payment>"+
				"	<PayDate>2014-11-15</PayDate>"+
				"	<PayMode>银行转账</PayMode>"+
				"	<PayAmnt>1000.00</PayAmnt>"+
				"</Payment>"+
				"<Payment>"+
				"	<PayDate>2014-11-29</PayDate>"+
				" 	<PayMode>银行转账</PayMode>"+
				" 	<PayAmnt>2000.00</PayAmnt>"+
				"</Payment>"+
				"</Body>"+
				"</TranData>";
		return result;
	}
	public static String empResult(){
		String result = "";
		result = "<?xml version='1.0' encoding=	'GBK'?>" + 
				 "<TranData>"+
				 	"<Head>"+
				 		"<Flag>0</Flag>"+
				 		" <Desc>交易成功！</Desc>"+
				 		"</Head>"+
				 	"<Body> "+
				 		"<Insured> "+
				 		"<Code>0001</Code>"+
				 		"<Name>李辉</Name>"+
				 		"<RelaToMainInsu>8</RelaToMainInsu>"+
				 		" <Risk>  "+
				 			"<RiskName>安心无忧</RiskName>"+
				 			"<RiskCode>ABC</RiskCode>"+
				 			"<Amnt>5724.00元</Amnt>"+
				 		" </Risk> "+
				 		"</Insured>"+
				 		"<Insured> "+
				 		"<Code>0001</Code>"+
				 		"<Name>张丽</Name>"+
				 		"<RelaToMainInsu>8</RelaToMainInsu>"+
				 		" <Risk>  "+
				 			" <RiskName>安心无忧</RiskName>"+
				 			"<RiskCode>ABC</RiskCode>"+
				 			" <Amnt>5724.00元</Amnt>"+
				 		" </Risk> "+
				 		"</Insured>"+
				 		"<Insured> "+
				 		"<Code>0001</Code>"+
				 		"<Name>王五</Name>"+
				 		"<RelaToMainInsu>8</RelaToMainInsu>"+
				 		" <Risk>  "+
				 			"<RiskName>安心无忧</RiskName>"+
				 			"<RiskCode>ABC</RiskCode>"+
				 			"<Amnt>5724.00元</Amnt>"+
				 		" </Risk> "+
				 		"</Insured>"+
				 		"<Insured> "+
				 		"<Code>0001</Code>"+
				 		"<Name>张三</Name>"+
				 		"<RelaToMainInsu>8</RelaToMainInsu>"+
				 		" <Risk>  "+
				 			" <RiskName>安心无忧</RiskName>"+
				 			"<RiskCode>ABC</RiskCode>"+
				 			" <Amnt>5724.00元</Amnt>"+
				 		" </Risk> "+
				 		"</Insured>"+
				 	"</Body>"+
				 "</TranData>";
		return result ;
	}
	public static String getRequestXml(String type){
		String returnStr="";
		if("理赔进展查询".equals(type)){
			returnStr="<?xml version='1.0' encoding='GBK'?>"+
			"<TranData>"+
			   "<Head>"+
			      "<Flag>0</Flag>"+
			      "<Desc>交易成功！</Desc>"+
			   "</Head>"+
			   "<Body> "+         
			      "<Claim>  "+     
			         "<ContNo>67T0000183</ContNo>"+
			         "<ClaimDate>2015-02-22</ClaimDate>"+
			         "<ClaimStatus>正在处理</ClaimStatus>"+
			         "<Claimer>张三</Claimer>"+
			         "<CloseDate>2015-03-26</CloseDate>"+
			         "<GBOFlag>1</GBOFlag>"+
			         "<ClaimAmnt>2000.00</ClaimAmnt>"+
			         "<MainRiskCode>10011</MainRiskCode>"+
			         "<MainRiskName>安心无忧</MainRiskName>"+
			         "<ContStatus>0</ContStatus>"+
			         "<ContDesc>生效</ContDesc>"+
			         "<PolicyDate>20140101</PolicyDate>"+
			      "</Claim>"+
				  "<Claim>"+
			         "<ContNo>4380000025</ContNo>"+
			         "<ClaimDate>2015-02-22</ClaimDate>"+
			         "<ClaimStatus>已处理</ClaimStatus>"+
			         "<Claimer>张三</Claimer>"+
			         "<CloseDate>2015-02-24</CloseDate>"+
			         "<GBOFlag>1</GBOFlag>"+
			         "<ClaimAmnt>5000.00</ClaimAmnt>"+
			         "<MainRiskCode>10022</MainRiskCode>"+
			         "<MainRiskName>聪明宝宝</MainRiskName>"+
			         "<ContStatus>0</ContStatus>"+
			         "<ContDesc>生效</ContDesc>"+
			         "<PolicyDate>20140101</PolicyDate>"+
			      "</Claim> 	"+
				  "<Claim>"+       
			        " <ContNo>9500128377</ContNo>"+
			         "<ClaimDate>2015-01-11</ClaimDate>"+
			         "<ClaimStatus>正在处理</ClaimStatus>"+
			         "<Claimer>张三</Claimer>"+
			         "<CloseDate>2015-03-13</CloseDate>"+
			         "<GBOFlag>1</GBOFlag>"+
			         "<ClaimAmnt>6000.00</ClaimAmnt>"+
			         "<MainRiskCode>10033</MainRiskCode>"+
			         "<MainRiskName>金彩人生</MainRiskName>"+
			         "<ContStatus>0</ContStatus>"+
			         "<ContDesc>生效</ContDesc>"+
			         "<PolicyDate>20140101</PolicyDate>"+
			      "</Claim>  "+ 
			   "</Body>"+
			"</TranData>";
		}else if("贷款保单".equals(type)){
			returnStr="<?xml version='1.0' encoding='GBK' standalone='yes'?>\n"+
			"<TranData>\n"+
			    "<Head>\n"+
			        "<Flag>0</Flag>\n"+
			        "<Desc>交易成功</Desc>\n"+
			    "</Head>\n"+
			    "<Body>\n"+
			        "<Loan>\n"+
			            "<ContNo>67T0000183</ContNo>\n"+
			            "<MainRiskName>安心无忧</MainRiskName>\n"+
			            "<MainRiskCode>ABC1</MainRiskCode>\n"+
			            "<ContStatus>0</ContStatus>\n"+
			            "<ContDesc>有效</ContDesc>\n"+
			            "<PolicyDate>20140111</PolicyDate>\n"+
			            "<LoanAmnt>10000.00</LoanAmnt>\n"+
			            "<PayBankName>招商银行</PayBankName>\n"+
			            "<PayAccNo>111112212121</PayAccNo>\n"+
			        "</Loan>\n"+
			        "<Loan>\n"+
			            "<ContNo>4380000025</ContNo>\n"+
			            "<MainRiskName>聪明宝宝</MainRiskName>\n"+
			            "<MainRiskCode>ABC2</MainRiskCode>\n"+
			            "<ContStatus>0</ContStatus>\n"+
			            "<ContDesc>有效</ContDesc>\n"+
			            "<PolicyDate>20140111</PolicyDate>\n"+
			            "<LoanAmnt>7000.00</LoanAmnt>\n"+
			            "<PayBankName>招商银行</PayBankName>\n"+
			            "<PayAccNo>1111333333222222</PayAccNo>\n"+
			        "</Loan>\n"+
			    "</Body>\n"+
			"</TranData>";
		}else if("联系地址变更".equals(type)){
			returnStr="<?xml version='1.0' encoding='GBK' standalone='yes'?>"+
			"<TranData>"+
			    "<Head>"+
			        "<Flag>0</Flag>"+
			        "<Desc>交易成功！</Desc>"+
			    "</Head>"+
			"</TranData>";
		}else if("联系地址查询".equals(type)){
			returnStr="<?xml version='1.0' encoding='GBK' standalone='yes'?>"+
			"<TranData>"+
			    "<Head>"+
			        "<Flag>0</Flag>"+
			        "<Desc>交易成功！</Desc>"+
			    "</Head>"+
			    "<Body>"+
			        "<Loan>"+
			            "<ContNo>4380000025</ContNo>"+
			            "<MainRiskName>聪明宝宝</MainRiskName>"+
			            "<MainRiskCode>ABC1</MainRiskCode>"+
			            "<Address>西江湾路388号</Address>"+
			            "<ContStatus>1</ContStatus>"+
			            "<ContDesc>有效</ContDesc>"+
			            "<PolicyDate>20140111</PolicyDate>"+
			        "</Loan>"+
			        "<Loan>"+
			            "<ContNo>67T0000183</ContNo>"+
			            "<MainRiskName>安心无忧</MainRiskName>"+
			            "<MainRiskCode>ABC2</MainRiskCode>"+
			            "<Address>花园路111号</Address>"+
			            "<ContStatus>1</ContStatus>"+
			            "<ContDesc>有效</ContDesc>"+
			            "<PolicyDate>20140111</PolicyDate>"+
			        "</Loan>"+
			    "</Body>"+
			"</TranData>";
		}else if("联系电话变更".equals(type)){
			returnStr="<?xml version='1.0' encoding='GBK' standalone='yes'?>"+
			"<TranData>"+
			   "<Head>"+
			        "<Flag>0</Flag>"+
			        "<Desc>交易成功！</Desc>"+
			    "</Head>"+
			"</TranData>";
		}else if("联系电话查询".equals(type)){
			returnStr="<?xml version='1.0' encoding='GBK' standalone='yes'?>"+
			"<TranData>"+
			    "<Head>"+
			        "<Flag>0</Flag>"+
			        "<Desc>交易成功！</Desc>"+
			    "</Head>"+
			    "<Body>"+
			        "<AreaCode>021</AreaCode>"+
			        "<Phone>84343467</Phone>"+
			        "<ExtNumber>2248</ExtNumber>"+
			        "<Mobile>13645342798</Mobile>"+
			    "</Body>"+
			"</TranData>";
		}else if("归还保单贷款".equals(type)){
			returnStr="<?xml version='1.0' encoding='GBK' standalone='yes'?>"+
			"<TranData>"+
			    "<Head>"+
			        "<Flag>0</Flag>"+
			       " <Desc>交易成功！</Desc>"+
			   " </Head>"+
			"</TranData>";
		}
		return returnStr;
	}
	public static String oneResult(){
		String result = "";
		result = "<?xml version='1.0' encoding=	'GBK'?>" + 
				"<TranData>"+
				"<Head>"+
					"<Flag>0</Flag>"+
					"<Desc>交易成功！</Desc>"+
				"</Head>"+
				"<Body>"+
					"<CustomerNo>8888888888</CustomerNo>"+
				"</Body>"+
				"</TranData>";			
		return result;
	}
	public static String payEmpyInfo(){
		String result = "";
		result = "<?xml version='1.0' encoding=	'GBK'?>" + 
				"<TranData>"+
				"<Head>"+
					"<Flag>0</Flag>"+
					"<Desc>交易成功！</Desc>"+
				"</Head>"+
				"<Body>"+
				"</Body>"+
				"</TranData>";		
		return result;
	}
}




