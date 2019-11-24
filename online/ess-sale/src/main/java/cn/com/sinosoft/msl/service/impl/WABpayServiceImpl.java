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
import cn.com.sinosoft.domain.yinbaotongWAB.BaseInfo;
import cn.com.sinosoft.domain.yinbaotongWAB.LCAppnt;
import cn.com.sinosoft.domain.yinbaotongWAB.LCBnf;
import cn.com.sinosoft.domain.yinbaotongWAB.LCBnfs;
import cn.com.sinosoft.domain.yinbaotongWAB.LCCont;
import cn.com.sinosoft.domain.yinbaotongWAB.LCInsured;
import cn.com.sinosoft.domain.yinbaotongWAB.Risk;
import cn.com.sinosoft.msl.service.WABpayService;
import cn.com.sinosoft.sale.service.OrderService;
import cn.com.sinosoft.util.WABLongPolicyUtil;

@Component
@Service("WABpayService")
public class WABpayServiceImpl implements WABpayService {
	
	@Autowired
	OrderService orderService;
	
	public static Logger logger = LoggerFactory.getLogger(WABpayServiceImpl.class);
	private static Properties pro = new Properties();
	static{
		try {
			pro.load(new InputStreamReader(WABLongPolicyUtil.class.getResourceAsStream("/config/SecondPeriod.properties"), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static DecimalFormat df = new DecimalFormat("######0.00"); 
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	@Override
	public String WABlongAcceptance(String ordercode,String openId){
		String ActyNo = "";//取得活动码
		String flag = "0";
		//稳爱保长险承保
		GeApplicantInsured recognizee = null;
		GeApplicantInsured applicantInsured = null;
		GeOrder order = orderService.getOrderByOrderCode(ordercode);//从库里取出订单实体
		Set<GePolicy> policys = order.getPolicys();
		Iterator<GePolicy> it = policys.iterator();
		GePolicy policy = it.next();
		String payEndYear = policy.getPayYear();   //缴费期限  10  20
		String jobCode = policy.getJobCode();	//职业编码
		String InsuYear = policy.getPolicyterm();//保障期限	至70/75/80/100岁
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
				//承保数据填充
				LCCont lCCont = new LCCont();
				lCCont.setBankAccNo(bankAccountNumber);
				lCCont.setRenewalPermit("Y");
				//银行代扣部分
				lCCont.setBankProvince(order.getBankProvince());
				lCCont.setBankCity(order.getBankCity());
				lCCont.setAccBankCode(order.getBankBranchCode());//银行编码
				lCCont.setAccName(applicantInsured.getName());
//				lCCont.setSpecContent(policy.getJobFlag());    //职业标识
				Risk risk = new Risk();//被保险人险种信息
				risk.setCValiDate("");//生效日期
				risk.setAmnt(df.format(policy.getSumamount()));//保额
				risk.setPrem(df.format(policy.getSumbasepremium()));//保费
				risk.setBeneficiaryIndicator("2".equals(policy.getIslegalflag())?"Y":"N");   //受益人2法定Y  3指定N
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
				//受益人
				LCBnfs lcbnfs = new LCBnfs();
				List<LCBnf> lCBnf = new ArrayList<LCBnf>();
				if("2".equals(policy.getIslegalflag())){//法定受益人
					lcbnfs.setLCBnfCount("0");
				}else if("3".equals(policy.getIslegalflag())){//指定受益人
					LCBnf lbf1 = new LCBnf();
					lcbnfs.setLCBnfCount(policy.getlCBnfCount());
					//受益人信息
					lbf1.setName(policy.getBnfName1()); //受益人姓名
					lbf1.setSex(policy.getBnfSex1());  	//受益人性别
					lbf1.setBirthday(policy.getBnfBirthday1().replace("-", "")); //受益人出生日期
//					lbf1.setIDType("I");		//受益人证件类型
					lbf1.setIDNo(policy.getBnfIDNo1());			//受益人证件号码
					lbf1.setBnfLot(policy.getBnfLot1());     //受益人受益比例
					lbf1.setRelationToInsured(policy.getRelationToInsured1());
					lCBnf.add(lbf1);
					if("2".equals(policy.getlCBnfCount())){
						LCBnf lbf2 = new LCBnf();
						lcbnfs.setLCBnfCount(policy.getlCBnfCount());
						lbf2.setName(policy.getBnfName2()); //受益人姓名
						lbf2.setSex(policy.getBnfSex2());  	//受益人性别
						lbf2.setBirthday(policy.getBnfBirthday2().replace("-", "")); //受益人出生日期
//						lbf2.setIDType("I");		//受益人证件类型
						lbf2.setIDNo(policy.getBnfIDNo2());			//受益人证件号码
						lbf2.setBnfLot(policy.getBnfLot2());     //受益人受益比例
						lbf2.setRelationToInsured(policy.getRelationToInsured2());
						lCBnf.add(lbf2);
					}else if("3".equals(policy.getlCBnfCount())){
						lcbnfs.setLCBnfCount(policy.getlCBnfCount());
						LCBnf lbf2 = new LCBnf();
						lbf2.setName(policy.getBnfName2()); //受益人姓名
						lbf2.setSex(policy.getBnfSex2());  	//受益人性别
						lbf2.setBirthday(policy.getBnfBirthday2().replace("-", "")); //受益人出生日期
//						lbf2.setIDType("I");		//受益人证件类型
						lbf2.setIDNo(policy.getBnfIDNo2());			//受益人证件号码
						lbf2.setBnfLot(policy.getBnfLot2());     //受益人受益比例
						lbf2.setRelationToInsured(policy.getRelationToInsured2());
						lCBnf.add(lbf2);
						LCBnf lbf3 = new LCBnf();
						lbf3.setName(policy.getBnfName3()); //受益人姓名
						lbf3.setSex(policy.getBnfSex3());  	//受益人性别
						lbf3.setBirthday(policy.getBnfBirthday3().replace("-", "")); //受益人出生日期
//						lbf3.setIDType("I");		//受益人证件类型
						lbf3.setIDNo(policy.getBnfIDNo3());			//受益人证件号码
						lbf3.setBnfLot(policy.getBnfLot3());     //受益人受益比例
						lbf3.setRelationToInsured(policy.getRelationToInsured3());
						lCBnf.add(lbf3);
					}
					//循环添加受益人默认值
					for(LCBnf lc : lCBnf){
						lc.setIDType("I");
						lc.setBnfType("");
						lc.setBnfNo("");
						lc.setBnfGrade("1");
						lc.setBnfPartyKey("");
						lc.setIDExpDate("");
						lc.setIDEffDate("");
						lc.setJobCode("");
						lc.setBnfHomePhone("");
						lc.setBnfCompanyPhone("");
						lc.setBnfMobile("");
						lc.setBnfAppSame("N"); //受益人与被保人是否是同一人
						lc.setBnfInsuredSame("N");//受益人与投保人是否是同一人
						lc.setRelaToAppnt("");
						lc.setHomeAddress("");
						lc.setHomeZipCode("");
						lc.setMailAddress("");
						lc.setMailZipCode("");
						lc.setEmail("");
						lc.setAddressStateTC("CHN");
						lc.setAddressState("");
						lc.setCity("");
						lc.setMsgCode("");
						lc.setBelongToInsured("");
						lc.setAddress("");
					}
				}
				lcbnfs.setLCBnf(lCBnf);
				Map<String, String> map = WABLongPolicyUtil.approved(pro.getProperty("yinbaotong"), risk, lCInsured, lcAppnt,lCCont,baseInfo,lcbnfs, payEndYear,InsuYear);
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
		}
		return flag;
	}
}
