package cn.com.sinosoft.msl.service.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.core.exception.BaseException;
import cn.com.sinosoft.core.exception.enumerate.ExceptionGrade;
import cn.com.sinosoft.core.utils.DateUtil;
import cn.com.sinosoft.core.utils.IdcardUtils;
//import cn.com.sinosoft.domain.msl.remote.MslRegion;
import cn.com.sinosoft.domain.sale.GeApplicantInsured;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;
//import cn.com.sinosoft.domain.system.CustomerBindingIdentity;
//import cn.com.sinosoft.msl.model.insurancePolicy.request.Body;
import cn.com.sinosoft.msl.model.underWriting.request.Applicant;
import cn.com.sinosoft.msl.model.underWriting.request.Insured;
import cn.com.sinosoft.msl.model.underWriting.request.Risk;
import cn.com.sinosoft.msl.service.InsurePolicyService;
//import cn.com.sinosoft.msl.service.PremiumCalculationService;
import cn.com.sinosoft.msl.service.SalesPolicyService;
import cn.com.sinosoft.sale.service.OrderService;
//import cn.com.sinosoft.sale.service.PolicyService;

 

 
@Component
@Service("insurePolicyService")
 
 
public class InsurePolicyServiceImpl  implements InsurePolicyService{
	public static Logger logger = LoggerFactory.getLogger(InsurePolicyServiceImpl.class);
	
	@Autowired
	private OrderService olderService;
//	@Autowired
//	private PremiumCalculationService premiumCalculationService;
	@Autowired
	private OrderService orderService;
//	@Autowired
//	private PolicyService policeservice;
	@Override
	public boolean validateProductCode(String productCode) {
		//产品中有任意一个符合要求的返回true
		if("PAH".equals(productCode)||"PAT".equals(productCode)||"PAC".equals(productCode)){
			return true;
		}
		return false;
	}
	@Override 
	public List<GeOrder> dealCount(String productCode) {
		List<GeOrder> olders=olderService.findGeOrderByProductcode(productCode);
		return olders;
	}
// 
//	@Override
//	public boolean echoCustomer(CustomerBindingIdentity cusotemer,
//			GeApplicantInsured applicantInsured)throws BaseException {
//		if(cusotemer==null){
//			return false;
//		}else{
//			
//				cn.com.sinosoft.msl.model.customerInfo.response.Body body=
//				SalesPolicyService.queryCustomerInfo(cusotemer.getCustomerNo(), applicantInsured.getName(),applicantInsured.getIdentifynumber());
//				applicantInsured.setMobile(body.getMobile());
//				applicantInsured.setEmail(body.getEmail());
//				return true;
//		}
//	}
//	/**
//	 * 回显录入信息选中的投保地区 1.获取投被保人的投保地区Code 
//	 * 2.设置MslRegion对象的投保地区Code 
//	 * 3.返回这个MslRegion对象
//	 */
//	@Override
//	public MslRegion echoRegion(GeOrder order) {
//		Set<GePolicy> policys= order.getPolicys();
//		Iterator it=policys.iterator();
//		GePolicy policy=null;
//		while(it.hasNext()){
//			policy=(GePolicy)it.next();
//		}
//		MslRegion mslRegion=new MslRegion();
//		if(policy.getAreacodepro()==null){
//			mslRegion.setProvinceCode(0);
//		}else{
//			Integer code=Integer.valueOf(policy.getAreacodepro());
//			mslRegion.setProvinceCode(code);
//		}
//		return mslRegion;
//	}
//	@Override
//	public boolean insurePolicy(String orderCode) {
//		GeOrder order=(GeOrder) orderService.getOrderByOrderCode(orderCode);
//		GePolicy policy=null;
//		Set<GePolicy> policySet=order.getPolicys();
//		Iterator<GePolicy> it=policySet.iterator();
//		while(it.hasNext()){
//			policy=it.next();
//		}
//		Body body=new Body();
//		body.setTranSchnl("0");
//		body.setZoneNo(policy.getAreacodepro());
//		body.setOldTranNo(policy.getOldlpolicyno());
//		body.setProposalPrtNo(order.getOrdercode());
//		body.setContNo(policy.getPolicycode());
//		body.setSysRefNumber(order.getCircpaymentno());
//		body.setChannelCd(order.getChannelCode());
//		body.setPayType(order.getPaymentplatform());
//		body.setPayDate(DateUtil.DateToString(order.getPaytime(), "yyyyMMdd"));
//		body.setPayTime(DateUtil.DateToString(order.getPaytime(), "HHmmss"));
//		body.setSubPrem(order.getOrderamount()+"");
//		SalesPolicyService.insurancePolicy(body);
//		
//		Iterator<GePolicy> its=policySet.iterator();
//		while(its.hasNext()){
//			policy=its.next();
//			policy.setStatus("1");
//		}
//		order.setPolicys(policySet);
////		order.setFlowno(flowNo);
//		orderService.updateOrder(order);
//		GeOrder geOrder=(GeOrder) orderService.getOrderByOrderCode(orderCode);
//		GePolicy gePolicy=null;
//		Set<GePolicy> gePolicySet=geOrder.getPolicys();
//		Iterator<GePolicy> geIt=gePolicySet.iterator();
//		while(geIt.hasNext()){
//			gePolicy=geIt.next();
//		}
//		
//		if("1".equals(gePolicy.getStatus())){
//			return true;
//		}
//		return false;
//	}
	@Override
	public List<String> showPolicyAmount(String productcode,
			List<String> policyAmountList) {
		if("PAH".equals(productcode)||"PAT".equals(productcode)||"PAC".equals(productcode)){
			for(Integer i = 1;i<=10;i++){
				policyAmountList.add((i*10000)+".0");
			}
		}
		return policyAmountList;
	}
	@Override
	public boolean showPolicyPeriod(String productcode,
			List<String> periodTypeList, List<String> periodNumberList) {
		if("PAH".equals(productcode)){
			periodNumberList.add("1");
			periodTypeList.add("Y");
			return true;
		}
		if("PAT".equals(productcode)){
			periodNumberList.add("3");
			periodNumberList.add("7");
			periodNumberList.add("14");
			periodNumberList.add("30");
			periodNumberList.add("1");
			periodTypeList.add("D");
			periodTypeList.add("D");
			periodTypeList.add("D");
			periodTypeList.add("D");
			periodTypeList.add("Y");
			return true;
		}
		if("PAC".equals(productcode)){
			periodNumberList.add("1");
			periodTypeList.add("Y");
			return true;
		}
		return false;
	}
//	
//	/**
//	ResultCode: 2011	姓名字数校验：姓名小于2个字符，提示错误“姓名有误，请核实”；
//	 * ResultCode: 2012	被保人年龄过小校验：被保人年龄小于18周岁时，提示错误“被保人年龄小于18周岁”；
//	 * ResultCode: 2013	被保人年龄过大校验：被保人年龄大于70周岁时，提示错误“被保人年龄大于70周岁”；
//	 * ResultCode: 2014	手机号码位数校验：手机号码应为11位，且必须为13、14、15、17、18开头的数字，若不是，提示错误“请输入正确的手机号码”；
//	 * ResultCode: 2015	电子邮件格式校验：电子邮件中应包含＂＠＂字符，否则提示错误“请输入正确的电子邮件地址”；
//	 * ResultCode: 2016	身份证件位数校验：身份证不为18位，提示错误“请输入正确的身份证号”；
//	 * ResultCode: 2017	保障起始日校验：应大于等于投保日+1，小于等于投保日+180，否则系统提示错误“请输入正确的保障起始日”
//
//	 */
	@Override
	public int insureSubmit(String orderNo, GeOrder order, String channelCode,
			String loginWay) {
		order.setLoginWay(loginWay);
		order.setChannelCode(channelCode);
		order.setOrdercode(orderNo);
		List<Object> objects=this.getGepolcyGeApplicant(order);
		GePolicy policy=(GePolicy)objects.get(0);
		GeApplicantInsured applicantInsured=(GeApplicantInsured)objects.get(1);
		Integer size=applicantInsured.getName().getBytes().length;
		Integer age=IdcardUtils.getAgeByIdCard(applicantInsured.getIdentifynumber());
		String mobile=applicantInsured.getMobile();
		String mobile_2=mobile.substring(0, 2);
		String email=applicantInsured.getEmail();
		Integer index=email.indexOf("@");
		logger.debug("长度:"+size.toString());
		logger.debug("年龄:"+age.toString());
		logger.debug("手机:"+mobile);
		logger.debug("手机号前两位:"+mobile_2);
		logger.debug("邮箱有@:"+index.toString());
		logger.debug("身份证号码:"+applicantInsured.getIdentifynumber());
		if(size<2||size>40){
			return 2011;
		}
		if(age<18){
			return 2012;
		}
		if(age>70){
			return 2013;
		}
		if(mobile.length()!=11){
			return 2014;
		}
		if(index<=0){
			return 2015;
		}
		if(applicantInsured.getIdentifynumber().length()!=18){
			return 2016;
		}
//		if(policy.getDeadlinetime().getTime()-policy.getTakeeffecttime().getTime()>=3600*24&&policy.getDeadlinetime().getTime()-policy.getTakeeffecttime().getTime()<=3600*24*180){
//			return 2017;
//		}
		if(mobile_2.equals("13")||mobile_2.equals("14")||mobile_2.equals("15")||mobile_2.equals("17")||mobile_2.equals("18")){
			this.encapsulationOfMessage(orderNo, order, channelCode, loginWay);
			orderService.saveOrder(order);
			return 0;
		}else{
			return 2014;
		}
	}
	@Override
	public boolean birthdayAndGender(GeOrder order) {
		Set <GePolicy> policys= order.getPolicys();
		Iterator<GePolicy> it= policys.iterator();
		GePolicy policy=null;
		while(it.hasNext()){
			policy=it.next();
		}
		Set<GeApplicantInsured> applicantInsureds= policy.getApplicantInsureds();
		Iterator<GeApplicantInsured> its= applicantInsureds.iterator();
		GeApplicantInsured geApplicantInsured=null;
		while(its.hasNext()){
			geApplicantInsured=its.next();
		}
		String birthday = IdcardUtils.getBirthByIdCard(geApplicantInsured.getIdentifynumber());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		String gender=IdcardUtils.getGenderByIdCard(geApplicantInsured.getIdentifynumber());
		try {
			geApplicantInsured.setBirthday(sdf.parse(birthday));
			geApplicantInsured.setSex(gender);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public GeOrder insureInput(GePolicy policy,
			Set<GeApplicantInsured> applicantInsureds) {
		Set<GePolicy> policys=new HashSet<GePolicy>();
		policys.add(policy);
		Iterator<GeApplicantInsured> it = applicantInsureds.iterator();
		while (it.hasNext()) {
			GeApplicantInsured applicantInsured = (GeApplicantInsured)it.next();
			applicantInsured.setPolicy(policys);
		}
		policy.setApplicantInsureds(applicantInsureds);
		GeOrder order=new GeOrder();
		policy.setOrder(order);
		order.setPolicys(policys);
		return order;
	}

	private  GeOrder encapsulationOfMessage(String orderNo, GeOrder order, String channelCode,
			String loginWay){
		cn.com.sinosoft.msl.model.underWriting.request.Body body=new cn.com.sinosoft.msl.model.underWriting.request.Body();
		Set<GePolicy> policys=order.getPolicys();
		Iterator<GePolicy> it=policys.iterator();
		GePolicy policy=null;
		while(it.hasNext()){
			policy=it.next();
		}
		policy.setApplicantcode(orderNo);
		Set<GeApplicantInsured> applicantinsureds=policy.getApplicantInsureds();
		Iterator<GeApplicantInsured> iter=applicantinsureds.iterator();
		GeApplicantInsured geApplicantInsured=null;
		while(iter.hasNext()){
			geApplicantInsured=iter.next();
		}
		geApplicantInsured.setIdentifytype("0");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		Date d=new Date();
		String birthday="";
		try {
//			boolean flag=false;
//		flag=IdcardUtils.validateCard(geApplicantInsured.getIdentifynumber());
//		if(flag==false){
//			logger.info("insureInput失败，失败原因【身份证不合法】");
//			throw new BaseException(ExceptionGrade.GENERAL, new Throwable(), "2013", "身份证不合法");
//		}
		birthday = IdcardUtils.getBirthByIdCard(geApplicantInsured.getIdentifynumber());
			d = sdf.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		GeApplicantInsured geApplicantInsured_holder=new GeApplicantInsured(); 
		geApplicantInsured_holder.setName(geApplicantInsured.getName());
		geApplicantInsured_holder.setEmail(geApplicantInsured.getEmail());
		geApplicantInsured_holder.setMobile(geApplicantInsured.getMobile());
		geApplicantInsured_holder.setIdentifynumber(geApplicantInsured.getIdentifynumber());
		String gender  = IdcardUtils.getGenderByIdCard(geApplicantInsured.getIdentifynumber());
		geApplicantInsured_holder.setSex(gender);
		geApplicantInsured_holder.setSex(gender);
		geApplicantInsured_holder.setBirthday(d);
		geApplicantInsured_holder.setProvince(geApplicantInsured.getProvince());
		geApplicantInsured_holder.setIdentifytype("0");
		try {
			geApplicantInsured_holder.setBirthday(sdf.parse(birthday));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		GeApplicantInsured geApplicantInsured_insured=new GeApplicantInsured(); 
		geApplicantInsured_insured.setName(geApplicantInsured.getName());
		geApplicantInsured_insured.setEmail(geApplicantInsured.getEmail());
		geApplicantInsured_insured.setMobile(geApplicantInsured.getMobile());
		geApplicantInsured_insured.setIdentifynumber(geApplicantInsured.getIdentifynumber());
		String gender_insured = IdcardUtils.getGenderByIdCard(geApplicantInsured.getIdentifynumber());
		geApplicantInsured_insured.setSex(gender_insured);
		geApplicantInsured_insured.setSex(gender);
		geApplicantInsured_insured.setBirthday(d);
		geApplicantInsured_insured.setProvince(geApplicantInsured.getProvince());
		geApplicantInsured_insured.setIdentifytype("0");
		try {
			geApplicantInsured_insured.setBirthday(sdf.parse(birthday));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Set<GeApplicantInsured> applicantInsureds = new HashSet<GeApplicantInsured>();
		applicantInsureds.add(geApplicantInsured_holder);
		applicantInsureds.add(geApplicantInsured_insured);
		policy.setApplicantInsureds(applicantInsureds);
		policy.setApplicantname(geApplicantInsured.getName());
		Date now=new Date();
		policy.setInsuretime(now);
		policy.setAreacode(policy.getAreacodepro());
		policy.setInsuredname(policy.getApplicantname());
		policy.setInputdate(now);
		policy.setSumamount(10.00);
		policys.add(policy);
		order.setPolicys(policys);
		order.setAgentidentitycode(geApplicantInsured.getIdentifynumber());//设置证件号
		//order.setChannelName("公司官网渠道");
		order.setOrderamount(policy.getSumbasepremium());
		order.setCoreproductcode(policy.getProdoctcode());
		
		
		

		body.setTranSchnl("0");//设置普通网销
		if("01".equals(order.getLoginWay())){
			body.setaPPChannel("Mini Site");//设置微信移动端
		}else{
			body.setaPPChannel("Web Site");//设置微信移动端
		}
		body.setZoneNo(policy.getAreacodepro());//设置地区编号
		body.setProposalPrtNo(order.getOrdercode());//设置订单号
		body.setPolApplyDate(sdf.format(now).toString());//设置投保日期
		body.setContractEffDate(sdf.format(policy.getTakeeffecttime()).toString());
		body.setDisCount("100");//无折扣送100
		body.setBeneficType("Y");//设置合法
		
		Applicant applicant=new Applicant();
		applicant.setName(geApplicantInsured.getName());//设置姓名
		applicant.setSex(geApplicantInsured.getSex());//设置性别
		applicant.setBirthday(sdf.format(geApplicantInsured.getBirthday()));//设置生日
		applicant.setiDType("1");//设置证件类型,1为身份证
		applicant.setGovtTermDate("");//设置证件有效期
		applicant.setiDNo(geApplicantInsured.getIdentifynumber());//设置身份证号码
		applicant.setAddress("");//设置地址
		applicant.setZipCode("");
		//applicant.setZipCode(policy.getAreacodepro());//设置邮编
		applicant.setAreaCode("");//设置固话区号
		applicant.setPhone("");//设置固话号码
		applicant.setExtNumber("");//设置固化分机号
		applicant.setMobile(geApplicantInsured.getMobile());//设置移动电话
		applicant.setEmail(geApplicantInsured.getEmail());//设置邮箱
		applicant.setRelaToInsured("01");//设置与被保人关系01为本人
		applicant.setAppntZoneNo(policy.getAreacodepro());
		body.setApplicant(applicant);
		
		List<Insured> insureds=new ArrayList<Insured>();
		Insured insured=new Insured();
		insured.setName(geApplicantInsured.getName());//设置姓名
		insured.setSex(geApplicantInsured.getSex());//设置性别
		insured.setBirthday(sdf.format(geApplicantInsured.getBirthday()).toString());//设置生日
		insured.setiDType("1");//设置证件类型,1为身份证
		insured.setGovtTermDate("");//设置证件有效期
		insured.setiDNo(geApplicantInsured.getIdentifynumber());//设置身份证号码
		insured.setAddress("");//设置地址
		insured.setZipCode("");//设置邮编
		insured.setAreaCode("");//设置固话区号
		insured.setPhone("");//设置固话号码
		insured.setExtNumber("");//设置固化分机号
		insured.setMobile(geApplicantInsured.getMobile());//设置移动电话
		insured.setEmail(geApplicantInsured.getEmail());//设置邮箱policy.getAreacodepro()
		insured.setInsuredZoneNo(policy.getAreacodepro());
		insured.setRelaToInsured("01");//设置与被保人关系01为本人
		insureds.add(insured);
		
		body.setInsured(insureds);
		
		List<Risk> risks=new ArrayList<Risk>();
		Risk risk=new Risk();
		risk.setRiskCode(policy.getProdoctcode());
		risk.setMainRiskCode(policy.getProdoctcode());
		int prem= (int)(order.getOrderamount()*100);
			risk.setPrem(String.valueOf(prem));
			risk.setMult("1");
			String sumpremium=policy.getSumamount().toString();
			int num=sumpremium.indexOf(".");
			risk.setAmnt(sumpremium.substring(0, num)+"0000");
			risk.setPayIntv("12");
			risk.setInsuYearFlag(policy.getPolicytermtype());//D
			risk.setInsuYear(policy.getPolicyterm());//3
			risk.setPayEndYearFlag("Y");
			risk.setPayEndYear("0");
			risks.add(risk);
		insured.setRisk(risks);
		
		cn.com.sinosoft.msl.model.underWriting.response.Body body_response=SalesPolicyService.underWriting(body);
		policy.setPolicycode(body_response.getContNo());//保单号 
		policy.setOldlpolicyno(body_response.getTransNo());//交易流水号
		policy.setUnitcount("1");
		policy.setCreateTime(now);
		policy.setUpdatetime(now);
		policy.setIslegalflag("1");//设置法收益人为本人
		policy.setStatus("0");//设置状态0为核保成功
		policy.setOrder(order);
		policy.setApplicantInsureds(applicantinsureds);
			//调用核保接口成功保存数据库
		order.setPolicys(policys);
		order.setPaystatus("0");//未支付为0
		order.setStatus("0");//设置未对账
		order.setSubmittime(now);//设置提交时间
		order.setCreatedate(now);
		order.setBusinessType("3");
		order.setCoreproductcode(policy.getProdoctcode());
		order.setRecipientname(policy.getApplicantname());
		order.setRecipientmobile(geApplicantInsured.getMobile());
//		order.setPaymentplatform("2");
		geApplicantInsured.setIdentifytype("0");
		return order;
	}

	private List<Object> getGepolcyGeApplicant(GeOrder order){
		Set<GePolicy> policys=order.getPolicys();
		Iterator<GePolicy> it= policys.iterator();
		GePolicy policy=null;
		if(it.hasNext()){
			policy=it.next();
		}
		Set<GeApplicantInsured> applicantinsureds= policy.getApplicantInsureds();
		Iterator<GeApplicantInsured> its= applicantinsureds.iterator();
		GeApplicantInsured applicantInsured=null;
		if(its.hasNext()){
			applicantInsured=its.next();
		}
		List<Object> objects=new ArrayList<Object>();
		objects.add(policy);
		objects.add(applicantInsured);
		return objects;
	}
	@Override
	public boolean takeEffectTimeInit(GePolicy policy) {
		try {
			policy.setTakeeffecttime(new Date());
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}
