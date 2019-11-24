package cn.com.sinosoft.web.service.impl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cn.com.sinosoft.common.service.axis.*;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.BankAccount;
import cn.com.sinosoft.domain.sale.GeMobileCustomer;
import cn.com.sinosoft.domain.sale.RenewalBankData;
import cn.com.sinosoft.domain.sale.RenewalPayRecords;
import cn.com.sinosoft.web.domain.PolicyCoverInformation;
import cn.com.sinosoft.web.domain.RenewalPolicy;
import cn.com.sinosoft.web.service.facade.ClientBindService;
import cn.com.sinosoft.web.service.facade.RenewalPayRecordsService;
import cn.com.sinosoft.web.util.HttpClientUtils;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.web.domain.RenewalPolicyPaymentRecords;
import cn.com.sinosoft.web.service.facade.RenewalService;
import org.springframework.web.client.RestTemplate;

import javax.xml.rpc.ServiceException;

@Component
@EnableAsync
public class RenewalServiceImpl extends GenericHibernateDao<RenewalBankData, String> implements RenewalService{

	
	private static Log logger = LogFactory.getLog(RenewalServiceImpl.class);

	private static RenewalPremiumServiceLocator premiumservice;
	private  static BankMsgModifyInterfaceLocator msgModify;

	static{
		premiumservice = new RenewalPremiumServiceLocator();
		msgModify = new BankMsgModifyInterfaceLocator();
	}

	private  String url;
	private String third_code;
	private String system_user;
	private  String sysytem_password;

	@Autowired
	RenewalPayRecordsService renewalPayRecordsService;
	@Autowired
	ClientBindService clientBindService;
	/**
	 * 功能：查询续期保单交费记录
	 * 描述：调用核心接口查询续期保单交费列表
	 * 作者： fenghj
	 */
	@Override
	public List<RenewalPolicy> queryRenewalPolicy(String methodName, String systemCode, String premiumMode, String applicantCode) {

		List<RenewalPolicy> renewalPolicieList = new ArrayList<RenewalPolicy>();

		String url = "http://10.46.70.19:8080/peri/services/RenewalPremiumCenter?";
		//将前端参数添加到map集合中
		Map<String, String> parmeters = new HashMap<String, String>();
		parmeters.put("methodName", methodName);
		parmeters.put("systemCode", systemCode);
		parmeters.put("PremiumMode", premiumMode);
		parmeters.put("applicantCode", applicantCode);
		//调用http方法请求核心接口
		Object result = HttpClientUtils.service(url, parmeters);

		if(result != null){

			JSONObject jsonObj = JSONObject.fromObject(result);
			Integer resultCode = jsonObj.getInt("resultCode");

			if(Integer.valueOf(resultCode).equals(0)){

				JSONArray array = jsonObj.getJSONArray("resultJson");
				logger.info(array.toString());

				if(array != null && array.size() > 0){

					for (int i = 0; i < array.size(); i++) {

						JSONObject jsonObject = array.getJSONObject(i);
						logger.info("遍历jsonArray,获取数组中的name属性值："+jsonObject.get("name"));

						if(jsonObject !=null && jsonObject.size()>0){

							RenewalPolicy renewalPolicy = new RenewalPolicy();
							renewalPolicy.setNo(jsonObject.getString("no"));
							renewalPolicy.setMainRiskName(jsonObject.getString("mainRiskName"));
							renewalPolicy.setPolicyCode(jsonObject.getString("policyCode"));
							renewalPolicy.setApplicantName(jsonObject.getString("applicantName"));
							renewalPolicy.setDueDate(jsonObject.getString("dueDate"));
							renewalPolicy.setAvailablePayDay(jsonObject.getString("availablePayDay"));
							renewalPolicy.setDueAmount(jsonObject.getString("dueAmount"));
							renewalPolicy.setBillingStatus(jsonObject.getString("BillingStatus"));
							renewalPolicy.setPayDate(jsonObject.getString("payDate"));
							renewalPolicy.setCycleTermNo(jsonObject.getString("CycleTermNo"));
							renewalPolicy.setPolicyStatus(jsonObject.getString("PolicyStatus"));

							JSONArray arrayPolicyCoverList = jsonObject.getJSONArray("policyCoverInformation");



							if(arrayPolicyCoverList !=null && arrayPolicyCoverList.size()>0){

								List<PolicyCoverInformation> policyCoverInformationList = new ArrayList<PolicyCoverInformation>();

								for (int j = 0; j < arrayPolicyCoverList.size(); j++) {

									JSONObject arrayPolicyCover = arrayPolicyCoverList.getJSONObject(j);
									PolicyCoverInformation policyCoverInformation = (PolicyCoverInformation) JSONObject.toBean(arrayPolicyCover, PolicyCoverInformation.class);
									policyCoverInformationList.add(policyCoverInformation);
								}

								renewalPolicy.setPolicyCoverInformationList(policyCoverInformationList);
							}

							renewalPolicieList.add(renewalPolicy);
						}
					}
				}
			}
		}

		return renewalPolicieList;
	}
	/**
	 * 功能：查询续期保单交费记录
	 * 描述：调用核心接口查询续期保单交费列表
	 * 作者： fenghj
	 */
	@Override
	public List<RenewalPolicyPaymentRecords> queryRenewalPolicyPaymentRecords(String systemCode,String payStatus,String startDate,String endDate,String policyCode) {

		List<RenewalPolicyPaymentRecords> recordsList = new ArrayList<RenewalPolicyPaymentRecords>();
		RenewalPremiumServiceLocator service = new RenewalPremiumServiceLocator();

		try {

			BasicOutputModel result = new BasicOutputModel();
			RenewalPremiumServicePortType portType = service.getRenewalPremiumServiceHttpSoap11Endpoint();
			result =  portType.getRenewalPremiumList("00401666", "APP", "A", "2018-09-01", "2018-11-11", "00401666", "RH00011523", "");
			Integer resultCode = result.getResultCode();
			if(Integer.valueOf(resultCode).equals(0)){

				Object obj = result.getResultJson();
				obj = "[{\"no\":\"1\",\"dueDate\":\"2019-11-01\",\"payDate\":\"2019-11-02\",\"deductBank\":\"工商银行\",\"accountNumber\":\"343434344343\",\"payAmount\":\"23\"},{\"no\":\"1\",\"dueDate\":\"2019-11-01\",\"payDate\":\"2019-11-02\",\"deductBank\":\"工商银行\",\"accountNumber\":\"343434344343\",\"payAmount\":\"23\"},{\"no\":\"1\",\"dueDate\":\"2019-11-01\",\"payDate\":\"2019-11-02\",\"deductBank\":\"工商银行\",\"accountNumber\":\"343434344343\",\"payAmount\":\"23\"},{\"no\":\"1\",\"dueDate\":\"2019-11-01\",\"payDate\":\"2019-11-02\",\"deductBank\":\"工商银行\",\"accountNumber\":\"343434344343\",\"payAmount\":\"23\"},{\"no\":\"1\",\"dueDate\":\"2019-11-01\",\"payDate\":\"2019-11-02\",\"deductBank\":\"工商银行\",\"accountNumber\":\"343434344343\",\"payAmount\":\"23\"},{\"no\":\"1\",\"dueDate\":\"2019-11-01\",\"payDate\":\"2019-11-02\",\"deductBank\":\"工商银行\",\"accountNumber\":\"343434344343\",\"payAmount\":\"23\"},{\"no\":\"1\",\"dueDate\":\"2019-11-01\",\"payDate\":\"2019-11-02\",\"deductBank\":\"工商银行\",\"accountNumber\":\"343434344343\",\"payAmount\":\"23\"},{\"no\":\"1\",\"dueDate\":\"2019-11-01\",\"payDate\":\"2019-11-02\",\"deductBank\":\"工商银行\",\"accountNumber\":\"343434344343\",\"payAmount\":\"23\"}]";
				JSONArray array=JSONArray.fromObject(obj);
				logger.info(array.toString());

				if(array != null && array.size() > 0){
					for (int i = 0; i < array.size(); i++) {

						JSONObject jsonObject = array.getJSONObject(i);
						logger.info("遍历jsonArray,获取数组中的name属性值："+jsonObject.get("name"));
						RenewalPolicyPaymentRecords records = (RenewalPolicyPaymentRecords) JSONObject.toBean(jsonObject,RenewalPolicyPaymentRecords.class);

						String accountNumber = records.getAccountNumber();
						//将银行卡取后四位
						if(accountNumber.length() >=4){
							accountNumber = accountNumber.substring(accountNumber.length()-4, accountNumber.length());
							records.setAccountNumber(accountNumber);
						}

						recordsList.add(records);

					}
				}

			}

		}catch(Exception e){
			logger.error("查询续期保单交费列表异常",e);
		}


		return recordsList;
	}

	/**
	 * 查询可支持银行
	 * @return
	 */
	public List<RenewalBankData> queryBank() {
		QueryRule query = QueryRule.getInstance();
		query.addEqual("status","Y");
		return find(query);
	}

	/**
	 * 查询是否可以支付
	 * @param operator
	 * @param systemCode
	 * @param policyCode
	 * @param paymentReferenceNo
	 * @param dueDate
	 * @return
	 */
	@Override
	public BasicOutputModel doPaymentStatus(String operator, String systemCode, String policyCode, String paymentReferenceNo, String dueDate) {
//		RenewalPremiumServiceLocator service = new RenewalPremiumServiceLocator();
		BasicOutputModel result = new BasicOutputModel();
		try {
			RenewalPremiumServicePortType portType = premiumservice.getRenewalPremiumServiceHttpSoap11Endpoint();
			result = portType.doPremiumPayCheck(operator, systemCode, policyCode, paymentReferenceNo, dueDate);
		} catch (ServiceException e) {
			logger.error("查询支付状态接口异常");
		} catch (RemoteException e) {
			logger.error("查询支付状态异常");
		}
		return result;
	}

	/**
	 * 保单挂起
	 * @param operator
	 * @param systemCode
	 * @param policyCode
	 * @param paymentReferenceNo
	 * @param dueDate
	 * @return
	 */
	@Override
	public BasicOutputModel policyHangUp(String operator, String systemCode, String policyCode, String paymentReferenceNo, String dueDate) {
		BasicOutputModel result = new BasicOutputModel();
		try {
			RenewalPremiumServicePortType portType = premiumservice.getRenewalPremiumServiceHttpSoap11Endpoint();
			result =portType.doPremiumPayInitiate(operator, systemCode, policyCode, paymentReferenceNo, dueDate);
		} catch (ServiceException e) {
			logger.error("保单挂起接口异常");
		} catch (RemoteException e) {
			logger.error("保单挂起异常");
		}
		return result;
	}

	@Override
	@Async
	public Map<String,String> renewalPay(String operator, String systemCode, String policyCode, String paymentReferenceNo, String dueDate, String payDate, String payAmount, String bankBranchCode, String bankAccountNumber, String online_pay_code,String appntname,String bankBranchName,String bankstate) {
		BasicOutputModel hangresult = null;
		BasicOutputModel payresult= null;
		BankMsgModifyModel bankresult= null;
		Map<String,String> statemap =new HashMap<String,String>();
		try {
			RenewalPremiumServicePortType portType = premiumservice.getRenewalPremiumServiceHttpSoap11Endpoint();
			payresult =portType.doPremiumPay(operator, systemCode, policyCode, paymentReferenceNo, dueDate,payDate,payAmount,bankBranchCode,bankAccountNumber,online_pay_code);
			if("0".equals(payresult.getResultCode())){
				statemap.put("paystate","0");
				hangresult = portType.doPremiumPayTerminate(operator, systemCode, policyCode, paymentReferenceNo, dueDate);
				if("0".equals(hangresult.getResultCode())){
					statemap.put("hangstate","0");
					if("Y".equals(bankstate)){
						bankresult = msgModify.getBankMsgModifyInterfaceHttpSoap11Endpoint().modifyBankCardMsg(policyCode, bankAccountNumber, appntname, bankBranchName);
						if("success".equals(bankresult.getState())){
							statemap.put("bankstate","0");
						}else{
							statemap.put("bankstate","1");
						}
					}
				}else{
					statemap.put("hangstate","1");
				}
			}else{
				statemap.put("paystate","1");
			}
		} catch (ServiceException e) {
			logger.error("银行卡变更异常");
		} catch (RemoteException e) {
			logger.error("实付解挂异常");
		}
		return statemap;
	}


	@Override
	public String postForJson(Map<String,Object> jsonString) {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(30000);// 设置超时
		requestFactory.setReadTimeout(30000);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		String result = restTemplate.postForObject(url,jsonString,String.class);
		return result;
	}

	@Override
	public Map<String,Object> getJsonString(String coustomerip,String paytype,String paychannel,String paymode,String paycode,double order_money,String bankaccountname,String accountcode,String bank_code,String bankname,String customerid,String tel,String reckonaccount,String backcode,String policyjson) {
		GeMobileCustomer customer = clientBindService.getOne("coustomerid",customerid);
		Map<String,Object> recordsmap = new HashMap<String, Object>();
		recordsmap.put("body","瑞泰瑞和定期寿险");
		recordsmap.put("third_code",third_code);
		recordsmap.put("system_user",system_user);
		recordsmap.put("system_password",sysytem_password);
		recordsmap.put("pay_type",paytype);
		recordsmap.put("pay_channel",paychannel);
		recordsmap.put("pay_mode",paymode);
		recordsmap.put("pay_code",paycode);
		recordsmap.put("order_money",order_money);
		recordsmap.put("proposal_person",bankaccountname);//付款人
		recordsmap.put("order_currency","156");
		recordsmap.put("account_type","00");
		recordsmap.put("account_no",accountcode);//账号
		recordsmap.put("account_name",bankaccountname);//账户持有人
		recordsmap.put("account_prop","0");//私人
		recordsmap.put("bank_code",bank_code);
		recordsmap.put("bank_name",bankname);
		recordsmap.put("id_num",customer.getIdnumber());
		recordsmap.put("id_type",customer.getIdtype());
		recordsmap.put("cust_userid",customerid);
		if(!"".equals(backcode)&&backcode!=null){
			recordsmap.put("back_code",backcode);
		}else{
			recordsmap.put("back_code",accountcode);
		}
		recordsmap.put("spbill_create_ip",coustomerip);
		recordsmap.put("tel",tel);
		recordsmap.put("reckon_account",reckonaccount);
		recordsmap.put("time_start",new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		recordsmap.put("busin_detail",policyjson);
		return recordsmap;
	}

	public String checkResultPoll(String policycode,String payresult){
		RenewalPayRecords renewalPayRecords =null;
		int flag = 1;
		while(flag<20){
			renewalPayRecords =renewalPayRecordsService.findByPolicyNo(policycode);
			if("1".equals(renewalPayRecords.getResultstate())){
				payresult =renewalPayRecords.getResultstate();
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			flag++;
		}
		return payresult;
		/*Runnable runnable = new Runnable() {

			@Override
			public void run() {

			}
		};
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.schedule(runnable,1,TimeUnit.MINUTES);*/

	}
}
