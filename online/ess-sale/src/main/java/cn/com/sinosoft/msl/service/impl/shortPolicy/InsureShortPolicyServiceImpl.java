package cn.com.sinosoft.msl.service.impl.shortPolicy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.omgd.ec.ws.AppResponse;
import com.omgd.ec.ws.DoAppResponse;

import cn.com.sinosoft.core.exception.BaseException;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.dictonary.GeDictonary;
import cn.com.sinosoft.domain.sale.GeApplicantInsured;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.domain.sale.GeRiskduty;
import cn.com.sinosoft.ess.config.service.GeDepartmentService;
import cn.com.sinosoft.ess.protal.common.PortalProp;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.Agreement;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.Entry;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.ExtraAttrs;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.Header;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.InsuraPerson;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.InsurancePolicy;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.Policy;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.Product;
import cn.com.sinosoft.msl.service.shortPolicy.InsureShortPolicyService;
import cn.com.sinosoft.msl.service.shortPolicy.SalesPolicyService;
import cn.com.sinosoft.sale.service.OrderService;

@Component
@Service("insureShortPolicyService")
public class InsureShortPolicyServiceImpl extends GenericHibernateDao<GeDictonary, String>  implements InsureShortPolicyService{
	
	private static String INSURESUBMIT = null;
	private static String INSUREPROMISE = null;
	
	static{
		
		INSURESUBMIT = "核保";
		INSUREPROMISE = "承保";
	
	}
	
	public static Logger logger = LoggerFactory.getLogger(InsureShortPolicyServiceImpl.class);
	
	@Autowired
	private OrderService olderService;
	
	@Autowired
	private GeDepartmentService depser;
	
	@Override
		public GeOrder insureInput(GePolicy policy,
		        GeApplicantInsured applicantInsured) {
				// 投被保人信息
				Set<GeApplicantInsured> applicantInsureds = new HashSet<GeApplicantInsured>();
			    // 格式化日期
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date birthday = null;
			try {
				birthday = sdf.parse(sdf.format(applicantInsured.getBirthday()));
				applicantInsured.setBirthday(birthday);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 内勤人员
			applicantInsured.setOccupationcode("A1001_1");
			applicantInsureds.add(applicantInsured);
			// 保单信息
			Set<GePolicy> policys = new HashSet<GePolicy>();
			policys.add(policy);
			// 将投被保人信息存入保单对象属性中
			policy.setApplicantInsureds(applicantInsureds);
			applicantInsured.setPolicy(policys);
			// 订单信息
			GeOrder order = new GeOrder();
			// 将保单信息存入订单信息中
			order.setPolicys(policys);
			return order;
		}
	/**
	 * 拼装接口请求字段
	 */
	@Override
	public InsurancePolicy returnInsurancePolicy(String orderNo, GeOrder order, String channelCode, String transNo){
		//赋值投被保人实体保单订单
		Set<GePolicy> policys=order.getPolicys();
		Iterator<GePolicy> it=policys.iterator();
		GePolicy policy=null;
		while(it.hasNext()){
			policy=it.next();
		}
		
		GeApplicantInsured geApplicantInsured_holder=new GeApplicantInsured();
		Set<GeApplicantInsured> applicantinsureds=policy.getApplicantInsureds();
		Iterator<GeApplicantInsured> iter=applicantinsureds.iterator();
		GeApplicantInsured geApplicantInsured=null;
		while(iter.hasNext()){
			geApplicantInsured=iter.next();
		}
		geApplicantInsured_holder.setName(geApplicantInsured.getName());
		geApplicantInsured_holder.setEmail(geApplicantInsured.getEmail());
		geApplicantInsured_holder.setMobile(geApplicantInsured.getMobile());
		geApplicantInsured_holder.setIdentifynumber(geApplicantInsured.getIdentifynumber());
		geApplicantInsured_holder.setIdentifytype(geApplicantInsured.getIdentifytype());
		geApplicantInsured_holder.setSex(geApplicantInsured.getSex());
		geApplicantInsured_holder.setBirthday(geApplicantInsured.getBirthday());
//		geApplicantInsured_holder.setProvince(geApplicantInsured.getProvince());
		geApplicantInsured_holder.setInsrelationapp("1");
		geApplicantInsured_holder.setFlag("holder");
		
		GeApplicantInsured geApplicantInsured_insured=new GeApplicantInsured(); 
		geApplicantInsured_insured.setName(geApplicantInsured.getName());
		geApplicantInsured_insured.setEmail(geApplicantInsured.getEmail());
		geApplicantInsured_insured.setMobile(geApplicantInsured.getMobile());
		geApplicantInsured_insured.setIdentifynumber(geApplicantInsured.getIdentifynumber());
		geApplicantInsured_insured.setIdentifytype(geApplicantInsured.getIdentifytype());
		geApplicantInsured_insured.setSex(geApplicantInsured.getSex());
		geApplicantInsured_insured.setBirthday(geApplicantInsured.getBirthday());
//		geApplicantInsured_insured.setProvince(geApplicantInsured.getProvince());
		geApplicantInsured_insured.setInsrelationapp("2");
		geApplicantInsured_insured.setFlag("insured");
		
		Set<GeApplicantInsured> applicantInsureds = new HashSet<GeApplicantInsured>();
		applicantInsureds.add(geApplicantInsured_holder);
		applicantInsureds.add(geApplicantInsured_insured);
		policy.setApplicantInsureds(applicantInsureds);
		policy.setApplicantname(geApplicantInsured.getName());
		Date now = new Date();
		// 设置投保日期
		policy.setInsuretime(now);
		policy.setApplicantname(geApplicantInsured.getName());
//		policy.setApplicantaddress(geApplicantInsured.getAddress()==null?"":geApplicantInsured.getAddress());
		policy.setInsuredname(geApplicantInsured.getName());
		policy.setProdoctcode("TATIANB02");
		// 设置被保人姓名
		policy.setInsuredname(geApplicantInsured.getName());
		// 设置签单时间
		policy.setInputdate(now);
		// 设置长短险
		policy.setSource("duanxian");
		// 设置渠道0：官网直销
		policy.setOriginate("0");

		policys.add(policy);
		order.setPolicys(policys);
		order.setAgentidentitycode(geApplicantInsured.getIdentifynumber());//设置证件号
		order.setOrderamount(policy.getSumpremium());
		order.setCoreproductcode(policy.getProdoctcode());
		//赋值险种责任实体
		List<GeRiskduty> risks=new ArrayList<GeRiskduty>();
		GeRiskduty risk = new GeRiskduty();
		risk.setRiskcode("BPA-PT");//主险代码
		
		risk.setCvaliDate(policy.getTakeeffecttime());
		risk.setMult(policy.getUnitcount());
		risk.setRiskName("民航班机意外身故与残疾");
		risks.add(risk);
		Set<GeRiskduty> geRiskduty = new HashSet<GeRiskduty>(risks);
		policy.setRiskDuties(geRiskduty);
		
		//拼装接口信息实体
		InsurancePolicy insurancePolicy = new InsurancePolicy();
		Agreement agreement = new Agreement(true,false,true);
		Header header = new Header(channelCode,now,transNo);
		
		Map<String,String> map1 = new HashMap<String,String>();
		map1.put("unit", policy.getUnitcount());//投保份数
		InsuraPerson holder = new InsuraPerson(geApplicantInsured_holder.getBirthday(), geApplicantInsured_holder.getSex(),
				geApplicantInsured_holder.getIdentifynumber(), geApplicantInsured_holder.getIdentifytype(),
				geApplicantInsured_holder.getMobile(),  geApplicantInsured_holder.getName(),
//				PortalProp.getString("occupationCode"), geApplicantInsured_holder.getProvince(),
				PortalProp.getString("occupationCode"), "110100",//通信地址写死测试
				PortalProp.getString("workType"), "0");
		holder.setEmail(geApplicantInsured_holder.getEmail());
		ExtraAttrs extraAttrs = new ExtraAttrs();
		List<Entry> entryList = new ArrayList<Entry>();
		Entry entry = new Entry();
		entry.setKey("unit");
		entry.setValue(policy.getUnitcount());
		entryList.add(entry);
		extraAttrs.setEntry(entryList);
		
		List<Policy> policyList = new ArrayList<Policy>();
		GeRiskduty riskDemo =  risks.get(0);
		Policy policyDemo = new Policy(riskDemo.getRiskcode(),policy.getTakeeffecttime(),map1,policy.getPolicyterm(),
				policy.getPolicytermtype(),"0","0",policy.getSumpremium(),policy.getSumamount());
		policyList.add(policyDemo);
		//如有需要，在此转换生效日期的格式
		Product product = new Product("",String.valueOf(policy.getSumbasepremium()),policy.getProdoctcode(),policy.getTakeeffecttime(),1,policyList,policy.getPolicytermtype(),"0",policy.getSumpremium(),policy.getSumamount());
		product.setName("瑞泰天天保公共交通工具意外伤害保险");
		order.setProductname("瑞泰天天保公共交通工具意外伤害保险");
		product.setPeriod(Integer.parseInt(policy.getPolicyterm()));
		product.setPremTerm("0");
		insurancePolicy.setHeader(header);
		insurancePolicy.setAgreement(agreement);
		insurancePolicy.setHolder(holder);
		insurancePolicy.setProduct(product);
		insurancePolicy.setExtraAttrs(extraAttrs);
		return insurancePolicy;
	} 
	
	
	/**
	 * 核保、承保封装报文发送信息，调用核保承保接口
	 * @param insureFlag    核保,承保标识
	 * @param orderNo
	 * @param order
	 * @param channelCode
	 * @param transNo
	 * @return
	 * @throws JAXBException
	 * @throws ParseException 
	 * @throws BaseException 
	 */
	private Map<String,String> encapsulationOfMessage(String orderNo, GeOrder order, String channelCode, String transNo) throws JAXBException, BaseException, ParseException{
		
		Map<String,String> resultMap = new HashMap<String,String>();
		Date now = new Date();
		String infoLog = INSURESUBMIT;
		Set<GePolicy> policys=order.getPolicys();
		Iterator<GePolicy> it=policys.iterator();
		GePolicy policy=null;
		while(it.hasNext()){
			policy=it.next();
		}
		
		GeApplicantInsured geApplicantInsured_holder=new GeApplicantInsured();
		Set<GeApplicantInsured> applicantinsureds=policy.getApplicantInsureds();
		Iterator<GeApplicantInsured> iter=applicantinsureds.iterator();
		GeApplicantInsured geApplicantInsured=null;
		while(iter.hasNext()){
			geApplicantInsured=iter.next();
		}
		geApplicantInsured_holder.setName(geApplicantInsured.getName());
		geApplicantInsured_holder.setEmail(geApplicantInsured.getEmail());
		geApplicantInsured_holder.setMobile(geApplicantInsured.getMobile());
		geApplicantInsured_holder.setIdentifynumber(geApplicantInsured.getIdentifynumber());
		geApplicantInsured_holder.setIdentifytype(geApplicantInsured.getIdentifytype());
		geApplicantInsured_holder.setSex(geApplicantInsured.getSex());
		geApplicantInsured_holder.setBirthday(geApplicantInsured.getBirthday());
//		geApplicantInsured_holder.setProvince(geApplicantInsured.getProvince());
//		geApplicantInsured_holder.setAddress(policy.getApplicantaddress());
		geApplicantInsured_holder.setInsrelationapp("1");
		geApplicantInsured_holder.setFlag("holder");
		
		GeApplicantInsured geApplicantInsured_insured=new GeApplicantInsured(); 
		geApplicantInsured_insured.setName(geApplicantInsured.getName());
		geApplicantInsured_insured.setEmail(geApplicantInsured.getEmail());
		geApplicantInsured_insured.setMobile(geApplicantInsured.getMobile());
		geApplicantInsured_insured.setIdentifynumber(geApplicantInsured.getIdentifynumber());
		geApplicantInsured_insured.setIdentifytype(geApplicantInsured.getIdentifytype());
		geApplicantInsured_insured.setSex(geApplicantInsured.getSex());
		geApplicantInsured_insured.setBirthday(geApplicantInsured.getBirthday());
//		geApplicantInsured_insured.setAddress(policy.getApplicantaddress());
//		geApplicantInsured_insured.setProvince(geApplicantInsured.getProvince());
		geApplicantInsured_insured.setInsrelationapp("2");
		geApplicantInsured_insured.setFlag("insured");
		
		Set<GeApplicantInsured> applicantInsureds = new HashSet<GeApplicantInsured>();
		applicantInsureds.add(geApplicantInsured_holder);
		applicantInsureds.add(geApplicantInsured_insured);
		
		policy.setApplicantname(geApplicantInsured.getName());
		// 设置投保日期
		policy.setInsuretime(now);
		policy.setApplicantname(geApplicantInsured.getName());
//		policy.setApplicantaddress(geApplicantInsured.getAddress()==null?"":geApplicantInsured.getAddress());
		policy.setInsuredname(geApplicantInsured.getName());
		policy.setProdoctcode("TATIANB02");
		// 设置签单时间
		policy.setInputdate(now);
		// 设置被保人姓名
		policy.setInsuredname(geApplicantInsured.getName());
		// 设置长短险
		policy.setSource("duanxian");
		// 设置渠道0：官网直销
		policy.setOriginate("0");

		List<GeRiskduty> risks=new ArrayList<GeRiskduty>();
		GeRiskduty risk = new GeRiskduty();
		risk.setRiskcode("BPA-PT");//主险代码
		//前台计算得到加1天
		risk.setCvaliDate(policy.getTakeeffecttime());
		risk.setMult(policy.getUnitcount());
		risk.setRiskName("民航班机意外身故与残疾");
		risks.add(risk);
		Set<GeRiskduty> geRiskduty = new HashSet<GeRiskduty>(risks);
		policy.setRiskDuties(geRiskduty);
		InsurancePolicy insurancePolicy = new InsurancePolicy();
		//
		Agreement agreement = new Agreement(true,false,true);
		Header header = new Header(channelCode,now,transNo);
		
		Map<String,String> map1 = new HashMap<String,String>();
		map1.put("unit", policy.getUnitcount());//投保份数
		InsuraPerson holder = new InsuraPerson(geApplicantInsured_holder.getBirthday(), geApplicantInsured_holder.getSex(),
				geApplicantInsured_holder.getIdentifynumber(), geApplicantInsured_holder.getIdentifytype(),
				geApplicantInsured_holder.getMobile(),  geApplicantInsured_holder.getName(),
//				PortalProp.getString("occupationCode"), geApplicantInsured_holder.getProvince(),
			PortalProp.getString("occupationCode"), "110100",
				PortalProp.getString("workType"), "0");
		holder.setEmail(geApplicantInsured_holder.getEmail());
		ExtraAttrs extraAttrs = new ExtraAttrs();
		List<Entry> entryList = new ArrayList<Entry>();
		Entry entry = new Entry();
		entry.setKey("unit");
		entry.setValue(policy.getUnitcount());
		entryList.add(entry);
		extraAttrs.setEntry(entryList);
		List<Policy> policyList = new ArrayList<Policy>();
		GeRiskduty riskDemo =  risks.get(0);
		Policy policyDemo = new Policy(riskDemo.getRiskcode(),policy.getTakeeffecttime(),map1,policy.getPolicyterm(),
				policy.getPolicytermtype(),"0","0",policy.getSumpremium(),policy.getSumamount());
		policyList.add(policyDemo);
		Product product = new Product("",String.valueOf(policy.getSumbasepremium()),policy.getProdoctcode(),policy.getTakeeffecttime(),1,policyList,policy.getPolicytermtype(),"0",policy.getSumpremium(),policy.getSumamount());
		product.setName("瑞泰天天保公共交通工具意外伤害保险");
		product.setPeriod(Integer.parseInt(policy.getPolicyterm()));
		order.setProductname("瑞泰天天保公共交通工具意外伤害保险");
		product.setPremTerm("0");
		insurancePolicy.setHeader(header);
		insurancePolicy.setAgreement(agreement);
		insurancePolicy.setHolder(holder);
		insurancePolicy.setProduct(product);
		insurancePolicy.setExtraAttrs(extraAttrs);
		
		//调用核保接口
//		DoAppResponse appResp = null;
//		//核保测试用Map
//		AppResponse response = null;
//		String returnCode = "";
//			appResp = SalesPolicyService.underWriting(insurancePolicy);//调核保接口
//			if(appResp != null){
//				response = appResp.getResponse();
//				if(response != null){
//					returnCode = appResp.getResponse().getReturnCode();
//					if ("0".equals(returnCode)){
//						policy.setUpdatetime(now);
//						policy.setIslegalflag("1");//设置法收益人为本人
//						policy.setStatus("1");//设置状态1为核保成功
//						policy.setPaymentstatus("0");
//						order.setPaystatus("0");//未支付为0,支付成功为1,支付失败为5
//						order.setStatus("0");//设置未对账0,对账成功1,对账失败2,本地成功支付接口失败3
//						order.setSubmittime(now);//设置提交时间
//						order.setCreatedate(now);
//						order.setBusinessType("3");
//						order.setLoginWay("03");
//						order.setCoreproductcode(policy.getProdoctcode());
//						order.setRecipientname(policy.getApplicantname());
//						order.setRecipientmobile(geApplicantInsured.getMobile());
//						policy.setOrder(order);
//						policy.setApplicantInsureds(applicantinsureds);
//							//调用核保接口成功保存数据库
//						order.setPolicys(policys);
//						resultMap.put("orderNo", orderNo);
//						resultMap.put("resultCode", "0");
//					}
//				}else{
//					logger.info("调用"+infoLog+"接口失败，失败原因【"+"接口未返回信息"+"】");
//					resultMap.put("resultCode", "1");
//					resultMap.put("resultMsg", "系统异常");
//				}
//			}else{
//				logger.info("调用"+infoLog+"接口失败，失败原因【"+"接口未返回信息"+"】");
//				resultMap.put("resultCode", "1");
//				resultMap.put("resultMsg", "系统异常");
//			}
		
		//修改，暂不做核保
		policy.setUpdatetime(now);
		policy.setIslegalflag("2");//设置收益人为法定
		policy.setStatus("1");//设置状态1为核保成功
		policy.setPaymentstatus("0");
		String deptidHade = policy.getDeptid();
		String deptid=null ;
		if(deptidHade!=null&&deptidHade.length()>0){
			deptid = depser.findDepart(deptidHade).getDeptid();
		}else{
			deptid =depser.findRootDepart().getDeptid();
		}
		policy.setDeptid(deptid);
		order.setPaystatus("0");//未支付为0,支付成功为1,支付失败为5
		order.setStatus("0");//设置未对账0,对账成功1,对账失败2,本地成功支付接口失败3
		order.setSubmittime(now);//设置提交时间
		order.setCreatedate(now);
		order.setBusinessType("3");
		order.setLoginWay("03");
		order.setCoreproductcode(policy.getProdoctcode());
		order.setApplicantname(policy.getApplicantname());	//设置投保人姓名
		order.setRecipientname(policy.getApplicantname());
		order.setRecipientmobile(geApplicantInsured.getMobile());
		order.setDeptid(deptid); //加入机构代码
		
		policys.add(policy);
		policy.setApplicantInsureds(applicantInsureds);
		geApplicantInsured_holder.setPolicy(policys);
		geApplicantInsured_insured.setPolicy(policys);
		policy.setOrder(order);
		order.setPolicys(policys);
		order.setAgentidentitycode(geApplicantInsured.getIdentifynumber());//设置证件号
		order.setOrderamount(policy.getSumpremium());
		order.setCoreproductcode(policy.getProdoctcode());
		//policy.setOrder(order);
		//policy.setApplicantInsureds(applicantinsureds);
			//调用核保接口成功保存数据库
		order.setPolicys(policys);
		resultMap.put("orderNo", orderNo);
		resultMap.put("resultCode", "0");

		return resultMap;
	}
	
	
	//承保
	private Map<String,String> encapsulationOfMessage2(GeOrder order, String channelCode, String transNo,InsurancePolicy ip) throws JAXBException, BaseException, ParseException{
		String infoLog = INSUREPROMISE;
		logger.info("调用天天保承保方法");
		Map<String,String> resultMap = new HashMap<String,String>();
		DoAppResponse appResp = null;
		AppResponse response = null;
		String returnCode = "";
		Set<GePolicy> policys=order.getPolicys();
		Iterator<GePolicy> it=policys.iterator();
		GePolicy policy=null;
		while(it.hasNext()){
			policy=it.next();
		}
			appResp = SalesPolicyService.blewWriting(ip);
			if(appResp != null){
				response = appResp.getResponse();
				if(response != null){
					returnCode = appResp.getResponse().getReturnCode();
					if ("0".equals(returnCode)){
						order.setPaymentplatform("1");//支付平台 1为微信
						order.setPayway("10");//支付方式为微信10公众账号
						order.setPaystatus("1");
						order.setStatus("0");//设置未对账
						order.setFlowno(response.getHeader().getTransNo());
						policy.setStatus("3");
						policy.setPolicycode(appResp.getResponse().getContract().getContNo());
						order.setBankorderno(appResp.getResponse().getContract().getOrderNo());
						//order.setOrdercode(appResp.getResponse().getContract().getOrderNo());
						order.setPolicys(policys);
						order.setFlag("3");
						resultMap.put("resultCode", "0");
						resultMap.put("policyCode", appResp.getResponse().getContract().getContNo());
						logger.info("保单号：" + appResp.getResponse().getContract().getContNo());
					}else{
						policy.setStatus("4");
						order.setPolicys(policys);
						order.setFlag("4");
						logger.info("调用"+infoLog+"接口失败，失败原因【"+response.getReturnMsg()==null?"":response.getReturnMsg()+"】");
						resultMap.put("resultCode", "1");
						resultMap.put("resultMsg", response.getReturnMsg()==null?"":response.getReturnMsg());
					}
				}else{
					policy.setStatus("4");
					order.setFlag("4");
					order.setPolicys(policys);
					logger.info("调用"+infoLog+"接口失败，失败原因【"+"接口未返回信息"+"】");
					resultMap.put("resultCode", "1");
					resultMap.put("resultMsg", "系统异常");
				}
			}else{
				policy.setStatus("4");
				order.setFlag("4");
				order.setPolicys(policys);
				logger.info("调用"+infoLog+"接口失败，失败原因【"+"接口未返回信息"+"】");
				resultMap.put("resultCode", "1");
				resultMap.put("resultMsg", "系统异常");
			}
		
		
		return resultMap;
	}
		/**
		 * 确认核保
		 * 1.校验规则, 如下:
		 * 2.设置订单号
		 * 3.设置渠道(登录途径)名称, 渠道编号
		 * 4.调用核保接口
		 * 5.若核保成功, 那么保存投被保人数据
		 * 6.若核保成功, 那么保存保单数据
		 * 7.若核保成功, 那么保存订单数据
		 * 8.返回核保的错误提示信息, 这里底层会向上级抛出BaseException, ResultCode: 2101.
		 * @param orderNo 
		 * @param order
		 * @param channelCode
		 * @param transNo
		 */
		@Override
		public Map<String,String> insureSubmit(String orderNo, GeOrder order, String channelCode, String transNo) {
			Map<String,String> resultMap = null;
			String resultCode = "";
			order.setChannelCode(channelCode);
			order.setOrdercode(orderNo);
			order.setPaystatus("0");
			try {
					try {
						resultMap = this.encapsulationOfMessage(orderNo, order, channelCode, transNo);
					} catch (BaseException e) {
						e.printStackTrace();
					} catch (ParseException e) {
						e.printStackTrace();
					}
				 
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resultCode = resultMap.get("resultCode");
			if(resultCode != null && "0".equals(resultCode)){
				olderService.saveOrder(order);
			}
			return resultMap;
		}
	
		/**
		 * 承保
		 * 1.校验规则, 如下:
		 * 2.设置订单号
		 * 3.设置渠道(登录途径)名称, 渠道编号
		 * 4.调用核保接口
		 * 5.若核保成功, 那么保存投被保人数据
		 * 6.若核保成功, 那么保存保单数据
		 * 7.若核保成功, 那么保存订单数据
		 * 8.返回核保的错误提示信息, 这里底层会向上级抛出BaseException, ResultCode: 2101.
		 * @param orderNo 
		 * @param channelCode
		 * @param transNo
		 */
		@Override
		public Map<String,String> insurePromise(GeOrder order, String channelCode, String transNo,InsurancePolicy ip) {
			Map<String,String> resultMap = null;
			String resultCode = "";
			//GeOrder order = olderService.findGeOrderByOrderCode(orderNo);
			try {
				try {
					logger.info("调用encapsulationOfMessage2方法");
					resultMap = this.encapsulationOfMessage2(order, channelCode, transNo,ip);
				} catch (BaseException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} catch (JAXBException e) {
				e.printStackTrace();
			}
			resultCode = resultMap.get("resultCode");
			if(resultCode != null){
				order.setPolicyno((String)resultMap.get("policyCode"));
				olderService.saveOrder(order);
			}
			return resultMap;
		}
		
		/**
		 * 判断性别
		 * 
		 * @param applicantInsured
		 */
	
		@Override
		public String convertSex(GeApplicantInsured applicantInsured) {
			if (applicantInsured.getSex().equals("M")) {
				return "男";
			}
			if (applicantInsured.getSex().equals("F")) {
				return "女";
			}
			return "保密";
	
		}
	
		/**
		 * 判断证件类型
		 * 
		 * @param applicantInsured
		 */
	
		@Override
		public String convertIdentifytype(GeApplicantInsured applicantInsured) {
			if (applicantInsured.getIdentifytype().equals("A")) {
				return "身份证";
			}
			if (applicantInsured.getIdentifytype().equals("B")) {
				return "护照";
			}
			if (applicantInsured.getIdentifytype().equals("C")) {
				return "军官证";
			}
			if (applicantInsured.getIdentifytype().equals("H")) {
				return "出生证明";
			}
			if (applicantInsured.getIdentifytype().equals("L")) {
				return "士兵证";
			}
			if (applicantInsured.getIdentifytype().equals("N")) {
				return "港澳通行证";
			}
			if (applicantInsured.getIdentifytype().equals("Q")) {
				return "港澳台回乡证";
			}
			if (applicantInsured.getIdentifytype().equals("D")) {
				return "驾照";
			}
			if (applicantInsured.getIdentifytype().equals("K")) {
				return "台胞证";
			}
			else  {
				return "其他";
			}
		}
		
		@Override
		public boolean getCommonHolderList(String name, String mobile) {
			// TODO Auto-generated method stub
			return false;
		}
	
		@Override
		public String initAddressInfo(String codeType, String seniorCode) {
			QueryRule queryRule =QueryRule.getInstance();
//			if(codeType.equals("province")){
//				queryRule.addEqual("type", codeType);
//			}
//			if(codeType.equals("city")){
//				queryRule.addEqual("type", codeType);
//				queryRule.addEqual("fkey", seniorCode);
//			}
			List<GeDictonary> zoneInfoList = super.find(queryRule);
			StringBuffer temp = new StringBuffer();
			temp.append("<option value=''>");
			temp.append("请选择");
			Iterator<GeDictonary> it = zoneInfoList.iterator();
			while(it.hasNext()){
				temp.append("<option value='"+it.next().getKey()+"'>"+it.next().getValue()+"</option>");
			}
			temp.append("</option>");
			return temp.toString();
		}
	
		@Override
		public boolean savePolicyInfo(GePolicy policy) {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
