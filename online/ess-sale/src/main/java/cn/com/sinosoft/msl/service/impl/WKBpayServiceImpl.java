package cn.com.sinosoft.msl.service.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.domain.sale.GeApplicantInsured;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.domain.yinbaotongWKB.BaseInfo;
import cn.com.sinosoft.domain.yinbaotongWKB.LCAppnt;
import cn.com.sinosoft.domain.yinbaotongWKB.LCCont;
import cn.com.sinosoft.domain.yinbaotongWKB.LCInsured;
import cn.com.sinosoft.domain.yinbaotongWKB.Risk;
import cn.com.sinosoft.msl.service.WKBpayService;
import cn.com.sinosoft.sale.service.OrderService;
import cn.com.sinosoft.util.WKBLongPolicyUtil;

@Component
@Service("WKBpayService")
public class WKBpayServiceImpl implements WKBpayService {
	
	@Autowired
	OrderService orderService;
	
	public static Logger logger = LoggerFactory.getLogger(WKBpayServiceImpl.class);
	private static Properties pro = new Properties();
	static{
		try {
			pro.load(new InputStreamReader(WKBLongPolicyUtil.class.getResourceAsStream("/config/SecondPeriod.properties"), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static DecimalFormat df = new DecimalFormat("######0.00"); 
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	public String WKBlongAcceptance(String ordercode,String openId){
		String ActyNo = "";//取得活动码
		String flag = "0";
		//承保
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
				String bank = policy.getBank();//续保银行
				String bankAccountNumber = policy.getBankAccountNumber();//续保银行账号
				LCCont lCCont = new LCCont();
				if(bank!=null&&bankAccountNumber!=null&&bank.length()>0&&bankAccountNumber.length()>0){//如果存在续保
					lCCont.setBankAccNo(bankAccountNumber);//续保银行
					lCCont.setRenewalPermit("Y");//自动续保标志
				}
				String unitcount = policy.getUnitcount();
				String insuYearFlag =null;
				String insuYear = null;
				if(unitcount.equals("1")){
					 insuYearFlag = "4";
					 insuYear = "30";
				}else if(unitcount.equals("2")){
					insuYearFlag = "2";
					 insuYear = "80";
				}
				List<Risk> risk = new ArrayList<Risk>();
				Risk risk1 = new Risk();//被保险人险种信息(主险)
				Risk risk2 = new Risk();//被保险人险种信息(附加险)
				risk1.setCValiDate("");//生效日期
				risk1.setAmnt(df.format(policy.getSumamount()));//保额
				risk1.setPrem(df.format(policy.getMainpolicypre()));//保费
				risk1.setRiskCode("TAWENKB-R");
				risk1.setMainRiskCode("TAWENKB-R");
				risk1.setInsuYearFlag(insuYearFlag);//保障期间标志
				risk1.setInsuYear(insuYear);//保障期间
				risk2.setCValiDate("");//生效日期
				risk2.setAmnt(df.format(policy.getSumamount()));//保额
				risk2.setPrem(df.format(policy.getAdditionalpolicypre()));//保费
				risk2.setRiskCode("WKBAR");
				risk2.setMainRiskCode("TAWENKB-R");
				risk2.setInsuYearFlag(insuYearFlag);//保障期间标志
				risk2.setInsuYear(insuYear);//保障期间
				risk.add(risk1);
				risk.add(risk2);
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
				if(order.getBillingType().equals("Y")){
					lCCont.setAccBankCode(policy.getBankBranchCode());//银行编码
				}else{
					lCCont.setAccBankCode("MSG01");//渠道编码
				}
				//银行代扣部分
				lCCont.setBillingType(order.getBillingType());//是否银行代扣
				lCCont.setBankProvince(order.getBankProvince());//开户行省
				lCCont.setBankCity(order.getBankCity());//开户市
				lCCont.setAccName(applicantInsured.getName());//银行账户姓名
				
				BaseInfo baseInfo = new BaseInfo();
				baseInfo.setZoneNo("MSG01");//渠道编码
				baseInfo.setBrNo(brNo);//推荐码
				baseInfo.setActyNo(ActyNo);//活动码
				Map<String, String> map = WKBLongPolicyUtil.approved(pro.getProperty("yinbaotong"), risk, lCInsured, lcAppnt,lCCont,baseInfo);
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
	
}
