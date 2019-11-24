package cn.com.sinosoft.web.action;

import java.util.*;

import javax.persistence.Query;
import javax.script.ScriptException;

import cn.com.sinosoft.common.service.axis.BasicOutputModel;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.BankAccount;
import cn.com.sinosoft.domain.sale.GeMobileCustomer;
import cn.com.sinosoft.domain.sale.RenewalBankData;
import cn.com.sinosoft.domain.sale.RenewalPayRecords;
import cn.com.sinosoft.sale.service.PolicyMobileService;
import cn.com.sinosoft.web.service.facade.BankAccountService;
import cn.com.sinosoft.web.service.facade.RenewalPayRecordsLogsService;
import cn.com.sinosoft.web.service.facade.RenewalPayRecordsService;
import cn.com.sinosoft.web.util.CommonUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.common.service.axis.QueryModel;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.web.domain.RenewalPolicyPaymentRecords;
import cn.com.sinosoft.web.service.facade.RenewalService;

public class RenewalAction extends Struts2Action{

	private static final long serialVersionUID = 1L;
	
	private static Log logger = LogFactory.getLog(RenewalAction.class);
	
	@Autowired
	private RenewalService renewalService;
	@Autowired
	PolicyMobileService policyMobileService;
	@Autowired
	BankAccountService bankAccountService;

	@Autowired
	RenewalPayRecordsService renewalPayRecordsService;
	@Autowired
	RenewalPayRecordsLogsService renewalPayRecordsLogsService;
	private QueryModel[] policyList;
	
	@Action(value="queryRenewalPolicy")
	public String queryRenewalPolicy() throws ScriptException{
		
		policyList = new QueryModel [8];
		this.setRequestAttribute("policyList", policyList);
		return "../page/renewalPolicyList";
	}
	
	/**
	 * 功能：查询续期保单交费记录
	 * 描述：调用核心接口查询
	 * 作者： fenghj
	 */
	@Action(value="queryRenewalPolicyPaymentRecords")
	public String queryRenewalPolicyPaymentRecords() throws ScriptException{
		
		logger.info("start RenewalPolicyPaymentRecords");
		String systemCode = "WECHAT";
		String payStatus = "A";
		String startDate = "2019-01-01";
		String endDate = "2019-11-12";
		String policyCode = "11111111";

		List<RenewalPolicyPaymentRecords> recordsList = new ArrayList<RenewalPolicyPaymentRecords>();
		recordsList = renewalService.queryRenewalPolicyPaymentRecords(systemCode, payStatus, startDate, endDate, policyCode);
		this.setRequestAttribute("recordsList", recordsList);
		
		logger.info("end RenewalPolicyPaymentRecords");
		
		return "../page/renewalPolicyPaymentRecords";
	}

	/**
	 * 查询银行配置信息
	 * @return
	 */
	@Action(value = "queryBank")
	public List<RenewalBankData> queryBank(){
		List<RenewalBankData> listbank = renewalService.queryBank();
		return listbank;
	}

	/**
	 * 客户添加银行卡信息
	 * @return
	 */
	@Action(value = "saveBankAccount")
	public String saveBankAccount(){
		/*String appntname = getHttpServletRequest().getParameter("");
		String bankcode = getHttpServletRequest().getParameter("");
		String bankaddress = getHttpServletRequest().getParameter("");*/
		String customerid = "";
		String appntname = "";
		String bankcode = "";
		String bankaddress = "";
		GeMobileCustomer gc =policyMobileService.getByCustomerid(customerid);
		Map<String,String> map = new HashMap<String, String>();
		if(gc!=null){
			if(!appntname.equals(gc.getName())){
				map.put("state","02");
				map.put("message","姓名有误");
				return JSON.toJSONString(map);
			}
			BankAccount bc = bankAccountService.findBankAccountByCustomeridAndBankCode(customerid,bankcode);
			if(bc!=null){
				map.put("state","02");
				map.put("message","卡号已存在");
				return JSON.toJSONString(map);
			}
			BankAccount bankaccount = new BankAccount();
			bankaccount.setAppntname(appntname);
			bankaccount.setCustomerno(customerid);
			bankaccount.setPaybankcode(bankcode);
			bankaccount.setPaybankname(bankaddress);
			bankaccount.setCreatetime(new Date());
			boolean flag = bankAccountService.saveBankAccount(bankaccount);
			if(flag){
				map.put("state","01");
				map.put("message", JSONObject.toJSONString(bankaccount));
				return JSON.toJSONString(map);
			}else{
				map.put("state","02");
				map.put("message","添加失败");
				return JSON.toJSONString(map);
			}
		}else{
			map.put("state","02");
			map.put("message","查询无此客户");
			return JSON.toJSONString(map);
		}
	}

	/**
	 * 客户银行选择
	 */
	//@Action(value = "sendRandomVcode")发送验证码
	@Action(value = "queryBankAccount")
	public void queryALLBankAccount(){
		String customerid = "";
		List<BankAccount> list = bankAccountService.findAllBankAccount(customerid);
	}

	/**
	 * 支付
	 * @return
	 *
	 */
	@Action(value = "renewalPay")
    public String renewalPayResult(){
	    String Vcode = "";//结果返回的验证码
	    String testcode = "";//页面获取的验证码
        String operator = "";//业务员工号
        String systemCode = "APP";//系统标识
        String policyCode = "";//保单号
        String paymentReferenceNo = "";//交易号
        String dueDate = "";//应交日
		double premium = 0.0;//交易金额，实付金额
        String appntname = "";//持卡人
        String paybank = "";//支付银行
        String paybankcode = "";//支付银行账号
        String duenum = "";//期数
        String mobile = "";//手机号
        String bankstate = "";//是否需要银行卡变更
        String payDate = "";//实付日
        String bankBranchCode = "";//银行编码
        String online_pay_code = "";//资金平台流水号
		String paytype = "";//支付类型01-PC，02-WAP，03-APP
		String paychannel = "";//微信01	通联02	银联03
		String paymode = "";//10银联代收，11银联代付
		String customerno = "";//客户号
		String reckonaccount = "";//清算账号
		String backcode = "";//退款账户，空值则赋值支付账号
		String policyjson = "";//保单信息json格式
		//确定参数
		String clientIP = getHttpServletRequest().getServerName();
		Map<String,String> statemap = new HashMap<String, String>();
        if(Vcode.equals(testcode)){
        	logger.info("开始查询是否可以支付-----");
            BasicOutputModel PaymentStatus = renewalService.doPaymentStatus(operator, systemCode, policyCode, paymentReferenceNo, dueDate);
            //0为可以支付，1为不可支付
            if("0".equals(PaymentStatus.getResultCode())){
            	//保单状态 -1为挂起异常，0为挂起，1为实付，2为实付异常，3为解挂，4为解挂异常，5为银行卡变更，6为银行卡变更异常
            	String resultstate = "0";
            	//支付状态 0未支付 1支付成功 2支付失败 3 支付中
				String paystate = "0";
				String serialno = "";
				logger.info("保单挂起开始-----");
                BasicOutputModel hangUpResult = renewalService.policyHangUp(operator, systemCode, policyCode, paymentReferenceNo, dueDate);
				//生成支付记录信息
                renewalPayRecordsService.saveRecords(policyCode,appntname,duenum,dueDate,paystate,paybank,paybankcode,bankstate,mobile,premium,"","");
				if("0".equals(hangUpResult.getResultCode())){
					serialno = CommonUtil.getSerialNo();

					renewalPayRecordsLogsService.saveRecords(policyCode,appntname,duenum,dueDate,false,paystate,paybank,paybankcode,bankstate,mobile,premium,serialno,resultstate);
                    //生成交易号,更新保单状态
					renewalPayRecordsService.updateRecords(policyCode,serialno,false,paystate,resultstate);
					//组合实付接口的参数map
					Map<String,Object> map = renewalService.getJsonString(clientIP,paytype,paychannel,paymode,serialno,premium,appntname,paybankcode,bankBranchCode,paybank,customerno,mobile,reckonaccount,backcode,policyjson);
					//支付平台发送数据
					String result = renewalService.postForJson(map);
					String code  =JSON.parseObject(result).getString("code");
					if("SUCCESS".equals(code)){
						paystate = "3";
						renewalPayRecordsService.updateRecords(policyCode,serialno,false,paystate,resultstate);
						String returnStateResult = renewalService.checkResultPoll(policyCode,paystate);
						if("1".equals(returnStateResult)){
							paystate = "1";
							//renewalPayRecordsService.updateRecords(policyCode,serialno,true,paystate,resultstate);
							//renewalPayRecordsLogsService.saveRecords(policyCode,appntname,duenum,dueDate,true,paystate,paybank,paybankcode,bankstate,mobile,premium,serialno,resultstate);
							Map<String,String> payresults = renewalService.renewalPay(operator, systemCode, policyCode, paymentReferenceNo, dueDate,payDate,String.valueOf(premium),bankBranchCode,paybankcode,online_pay_code,appntname,paybank,bankstate);
							if("0".equals(payresults.get("paystata"))){
								resultstate="1";
								renewalPayRecordsService.updateRecords(policyCode,serialno,false,paystate,resultstate);
								renewalPayRecordsLogsService.saveRecords(policyCode,appntname,duenum,dueDate,false,paystate,paybank,paybankcode,bankstate,mobile,premium,serialno,resultstate);
								if("0".equals(payresults.get("hangstate"))){
									resultstate="3";
									renewalPayRecordsService.updateRecords(policyCode,serialno,false,paystate,resultstate);
									renewalPayRecordsLogsService.saveRecords(policyCode,appntname,duenum,dueDate,false,paystate,paybank,paybankcode,bankstate,mobile,premium,serialno,resultstate);
									if(payresults.get("bankstate")!=null){
										if("1".equals(payresults.get("bankstate"))){
											resultstate="5";
											renewalPayRecordsService.updateRecords(policyCode,serialno,false,paystate,resultstate);
											renewalPayRecordsLogsService.saveRecords(policyCode,appntname,duenum,dueDate,false,paystate,paybank,paybankcode,bankstate,mobile,premium,serialno,resultstate);
										}else{
											resultstate="6";
											renewalPayRecordsService.updateRecords(policyCode,serialno,false,paystate,resultstate);
											renewalPayRecordsLogsService.saveRecords(policyCode,appntname,duenum,dueDate,false,paystate,paybank,paybankcode,bankstate,mobile,premium,serialno,resultstate);
										}
									}
								}else{
									resultstate="4";
									renewalPayRecordsLogsService.saveRecords(policyCode,appntname,duenum,dueDate,false,paystate,paybank,paybankcode,bankstate,mobile,premium,serialno,resultstate);
									renewalPayRecordsService.updateRecords(policyCode,serialno,false,"resultstate","4");
								}
							}else{
								resultstate="2";
								renewalPayRecordsService.updateRecords(policyCode,serialno,false,paystate,resultstate);
								renewalPayRecordsLogsService.saveRecords(policyCode,appntname,duenum,dueDate,false,paystate,paybank,paybankcode,bankstate,mobile,premium,serialno,resultstate);

							}
							statemap.put("returncode","1");
							statemap.put("returnmsg","支付成功");
						}else{
							paystate = "2";
							renewalPayRecordsService.updateRecords(policyCode,serialno,false,paystate,resultstate);
							renewalPayRecordsLogsService.saveRecords(policyCode,appntname,duenum,dueDate,false,paystate,paybank,paybankcode,bankstate,mobile,premium,serialno,resultstate);
							statemap.put("returncode","0");
							statemap.put("returnmsg","支付失败");
						}

					}else{
						paystate="2";
						renewalPayRecordsService.updateRecords(policyCode,serialno,false,paystate,resultstate);
						renewalPayRecordsLogsService.saveRecords(policyCode,appntname,duenum,dueDate,false,paystate,paybank,paybankcode,bankstate,mobile,premium,serialno,resultstate);
						statemap.put("returncode","0");
						statemap.put("returnmsg","支付失败，请稍后重试");
					}
                }else{
                	//挂起异常
					resultstate = "-1";
					renewalPayRecordsService.updateRecords(policyCode,serialno,false,paystate,resultstate);
					renewalPayRecordsLogsService.saveRecords(policyCode,appntname,duenum,dueDate,false,paystate,paybank,paybankcode,bankstate,mobile,premium,serialno,resultstate);
					statemap.put("returncode","0");
					statemap.put("returnmsg","支付失败，请稍后重试");
				}
            }else{
            	//不可支付
				statemap.put("returncode","0");
				statemap.put("returnmsg",PaymentStatus.getResultMessage());
			}
        }else{
        	//验证码错误
			statemap.put("returncode","0");
			statemap.put("returnmsg","验证码错误，请重新输入");
		}
        return JSON.toJSONString(statemap);
    }
}
