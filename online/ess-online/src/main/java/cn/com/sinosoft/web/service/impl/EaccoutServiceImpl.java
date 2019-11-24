package cn.com.sinosoft.web.service.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.tools.ant.taskdefs.Sleep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.common.PaymentConfigProp;
import cn.com.sinosoft.core.exception.PersistenceException;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.domain.sale.GeApplicantInsured;
import cn.com.sinosoft.domain.sale.GeEaccout;
import cn.com.sinosoft.domain.sale.GeEaccoutStatus;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.domain.yinbaotong.ChkDetail;
import cn.com.sinosoft.domain.yinbaotong.ChkDetails;
import cn.com.sinosoft.sale.service.EastatusService;
import cn.com.sinosoft.sale.service.OrderService;
import cn.com.sinosoft.sale.service.PolicyService;
import cn.com.sinosoft.util.LongPolicyUtil;
import cn.com.sinosoft.web.util.FundUtil;
import cn.com.sinosoft.web.util.FundUtil.Bill;
import cn.com.sinosoft.web.util.MessageUtil;

/**
 * 对账跑批，将存在异常的保单存入对账表中
 * @author lwy
 */

@Component
@Service("eaccoutService")
public class EaccoutServiceImpl extends GenericHibernateDao<GeEaccout, Integer>{
	private static Logger log = LoggerFactory.getLogger(EaccoutServiceImpl.class);
	private static SimpleDateFormat sp = new SimpleDateFormat("yyyyMMdd");
	private static DecimalFormat df = new DecimalFormat("######0.00"); 
	private static SimpleDateFormat dateLine = new SimpleDateFormat("yyyy-MM-dd");
	private static Properties pro = new Properties();
	static{
		try {
			pro.load(new InputStreamReader(LongPolicyUtil.class.getResourceAsStream("/config/SecondPeriod.properties"), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	OrderService orderService;//引入订单service处理类
	
	@Autowired
	EastatusService eaccoutStatus;
	
	@Autowired
	PolicyService policyService;
	/**
	 * 微信对账
	 */
	public void check(GeEaccoutStatus eaStatus){
		log.info("微信对账开始");
		String appId = PaymentConfigProp.getString("weixin_Appid");
		String mch_id = PaymentConfigProp.getString("weixin_Mch_id");//商户号
		String key = PaymentConfigProp.getString("weixin_key");//密钥
		log.info("读取微信配置信息完成");
		Date d = new Date(System.currentTimeMillis()-1000*60*60*24);//昨天日期date型
		String date = sp.format(d);//获取昨天日期
		log.info("昨日日期："+date);
		//获取微信昨天所有交易成功的订单
		List<Bill> bills = FundUtil.analyze(FundUtil.sendXml(appId, date, "SUCCESS", mch_id, key));
		log.info("获取支付成功微信订单"+bills.size()+"张");
		for(Bill bill:bills){
			String orderCode = bill.getMchOrderNo();//订单号
			if(orderCode.startsWith("RT")){
				log.info("获取支付成功订单号： "+orderCode);
				GeOrder order = orderService.getOrderByOrderCode(orderCode);
				GeEaccout eaccout = new GeEaccout();//创建异常保单信息对象
				if(order!=null){//如果订单对象不为空
					try{
						Set<GePolicy> policys = order.getPolicys();
						Iterator<GePolicy> it = policys.iterator();
						while(it.hasNext()){
							GePolicy policy = it.next();
							if(policy!=null&&policy.getStatus().equals("3")){//如果此保单的状态是承保成功
								order.setStatus("1");
								log.info("此订单已成功承保： "+orderCode);
							}else if(policy==null){//如果没有关联上保单
								eaccout.setExceptionCode("1");//设置异常编码为1
								eaccout.setUserid(bill.getUserId());//用户的openId
								eaccout.setCircpaymentno(bill.getWeiXinOrderNo());//微信订单号
								eaccout.setOrdercode(orderCode);//订单号
								eaccout.setAgentcode(eaccout.getAgentcode());//推荐人编码
								eaccout.setPaytime(bill.getDate());//交易时间
								eaccout.setRefundmentflag("");//退款标识，暂无
								eaccout.setPayBank(bill.getBank());//付款银行
								eaccout.setOrderamount(new Double(bill.getAmount().substring(0, bill.getAmount().length()-2)));//钱
								super.save(eaccout);
								order.setStatus("2");//对账失败
								log.info("异常保单插入完成,订单号："+orderCode);
							}else{
								log.info("发现异常订单： "+orderCode);
								Set<GeApplicantInsured> applicantInsureds = policy.getApplicantInsureds();//投保人信息
								Iterator<GeApplicantInsured> iterator = applicantInsureds.iterator();
								GeApplicantInsured applicantInsured = null;
								if(iterator.hasNext()){
									applicantInsured = iterator.next();
								}
								eaccout.setExceptionCode("1");//设置异常编码为1
								eaccout.setFlowno(policy.getFlowno());//保存流水号
								eaccout.setUserid(bill.getUserId());//用户的openId
								eaccout.setProductname(policy.getProductname());//产品名称
								eaccout.setCircpaymentno(bill.getWeiXinOrderNo());//微信订单号
								eaccout.setOrdercode(orderCode);//订单号
								eaccout.setOrderamount(policy.getSumamount());//保额
								eaccout.setPrem(policy.getSumbasepremium());//保费
								eaccout.setApplicantname(policy.getApplicantname());//投保人姓名
								eaccout.setInsuredname(policy.getInsuredname());//被保人姓名
								eaccout.setAgentcode(eaccout.getAgentcode());//推荐人编码
								eaccout.setProdoctcode(policy.getProdoctcode());//产品编码
								eaccout.setPaytime(bill.getDate());//交易时间
								eaccout.setRefundmentflag("");//退款标识，暂无
								eaccout.setPayBank(bill.getBank());//付款银行
								if(applicantInsured!=null){
									eaccout.setApplicantPhone(applicantInsured.getMobile());
								}
								super.save(eaccout);
								order.setStatus("2");//对账失败
								log.info("异常保单插入完成,订单号："+orderCode);
							}
						}
					}catch(Exception e){
						log.info("对账异常,orderCode:"+orderCode);
						order.setStatus("2");//对账失败
					}
					orderService.updateOrder(order);//更新订单状态
					log.info("订单状态更新完成： "+orderCode);
				}else if(!bill.getAmount().equals("0.01")){//如果不为一分
						eaccout.setExceptionCode("1");//设置异常编码为1
						eaccout.setUserid(bill.getUserId());//用户的openId
						eaccout.setCircpaymentno(bill.getWeiXinOrderNo());//微信订单号
						eaccout.setOrdercode(orderCode);//订单号
						eaccout.setAgentcode(eaccout.getAgentcode());//推荐人编码
						eaccout.setPaytime(bill.getDate());//交易时间
						eaccout.setRefundmentflag("");//退款标识，暂无
						eaccout.setPayBank(bill.getBank());//付款银行
						eaccout.setOrderamount(new Double(bill.getAmount().substring(0, bill.getAmount().length()-2)));//钱
						super.save(eaccout);
						log.info("未存此订单号，异常保单插入完成,订单号："+orderCode);
				}
			}
		}
		eaStatus.setWxstatus("success");
		log.info("微信对账结束");
	}
	
	
	
	/**
	 * 银保通对账
	 */
	public void checkByLongPolicy(){
		log.info("银保通对账开始");
		GeEaccoutStatus eaStatus =new GeEaccoutStatus();
		eaStatus.setEadate(dateLine.format(new Date()));
		eaStatus.setYbtstatus("fail");
		eaStatus.setWxstatus("fail");
		try{
			List<String> policycodes = new ArrayList<String>();
			List<GePolicy> policyList = policyService.findGePolicyList();//获取当天生效的保单
			/*List<GeOrder> orders = orderService.findGeOrderList();//查询前一天所有支付成功的订单
			List<GePolicy> policyList = new ArrayList<GePolicy>();//需要对账的保单对象集合
			for(GeOrder order:orders){
				Set<GePolicy> policys = order.getPolicys();
				Iterator<GePolicy> it = policys.iterator();
				while(it.hasNext()){
					GePolicy policy = it.next();
					policyList.add(policy);
				}
			}*/
			ChkDetails chkDetails = new ChkDetails();
			List<ChkDetail> ChkDetail = new ArrayList<ChkDetail>();//银保通对账接口封装对象
			for(GePolicy policy:policyList){
 				if((policy.getSource().equals("WENJIABAO")||policy.getSource().equals("changxian")||policy.getSource().equals("WENJIAXING")||policy.getSource().equals("tuanxian")||policy.getSource().equals("TAWENKB-R")||policy.getSource().equals("WENAIBAO"))&&policy.getStatus().equals("3")){//长险且承保成功的保单
					String policycode = policy.getPolicycode();
					ChkDetail chkDetail = new ChkDetail();
					chkDetail.setBankCode("803");//银行代码
					chkDetail.setTranDate(sp.format(policy.getInsuretime()));//保单日期
					chkDetail.setZoneNo("MSG01");
					String brNo = policy.getBrNo();
					if(brNo==null||brNo.length()==0){
						brNo="A0000";
					}
					chkDetail.setBrNo(brNo);
					chkDetail.setFuncFlag("100");//承保后的单子
					chkDetail.setTransrNo(policy.getFlowno());//承保时的流水号
					chkDetail.setPolNo(policycode);//承保的保单号
					chkDetail.setTranAmnt(df.format(policy.getSumbasepremium()));//保费
					chkDetail.setConfirmFlag("1");//标志
					if(!policycodes.contains(policycode)){
						ChkDetail.add(chkDetail);
					}
					policycodes.add(policycode);
					
				}
			}
			if(ChkDetail.size()>0){
				String chkDetailCount = ChkDetail.size()+"";
				chkDetails.setChkDetailCount(chkDetailCount);
				chkDetails.setChkDetail(ChkDetail);
				String respone = LongPolicyUtil.check(chkDetails, pro.getProperty("yinbaotong"));
				if(respone.equals("1")){
					MessageUtil.sendMessage("15510776709", "银保通对账成功 ");
					logger.info("银保通对账成功");
					eaStatus.setYbtstatus("success");
					logger.info("对账状态修改为success");
				}else{
					MessageUtil.sendMessage("15510776709", "银保通对账失败：  "+respone);
					logger.error("银保通对账失败："+respone);
					
				}
			}
			else{
				log.info("昨日长险没有承保成功的保单");
				eaStatus.setYbtstatus("success");
				logger.info("对账状态修改为success");
			}
			log.info("银保通对账结束");
		}catch(PersistenceException e){//如果数据库异常
			new Sleep().doSleep(100000);//暂停100秒
			//重新执行此方法
			try{
				List<String> policycodes = new ArrayList<String>();
				List<GePolicy> policyList = policyService.findGePolicyList();//获取当天生效的保单
				/*List<GeOrder> orders = orderService.findGeOrderList();//查询前一天所有支付成功的订单
				List<GePolicy> policyList = new ArrayList<GePolicy>();//需要对账的保单对象集合
				for(GeOrder order:orders){
					Set<GePolicy> policys = order.getPolicys();
					Iterator<GePolicy> it = policys.iterator();
					while(it.hasNext()){
						GePolicy policy = it.next();
						policyList.add(policy);
					}
				}*/
				ChkDetails chkDetails = new ChkDetails();
				List<ChkDetail> ChkDetail = new ArrayList<ChkDetail>();//银保通对账接口封装对象
				for(GePolicy policy:policyList){
					if((policy.getSource().equals("WENJIABAO")||policy.getSource().equals("changxian")||policy.getSource().equals("WENJIAXING")||policy.getSource().equals("tuanxian")||policy.getSource().equals("TAWENKB-R")||policy.getSource().equals("WENAIBAO"))&&policy.getStatus().equals("3")){//长险且承保成功的保单
						String policycode = policy.getPolicycode();
						ChkDetail chkDetail = new ChkDetail();
						chkDetail.setBankCode("803");//银行代码
						chkDetail.setTranDate(sp.format(policy.getInsuretime()));//保单日期
						chkDetail.setZoneNo("MSG01");
						String brNo = policy.getBrNo();
						if(brNo==null||brNo.length()==0){
							brNo="A0000";
						}
						chkDetail.setBrNo(brNo);
						chkDetail.setFuncFlag("100");//承保后的单子
						chkDetail.setTransrNo(policy.getFlowno());//承保时的流水号
						chkDetail.setPolNo(policycode);//承保的保单号
						chkDetail.setTranAmnt(df.format(policy.getSumbasepremium()));//保费
						chkDetail.setConfirmFlag("1");//标志
						if(!policycodes.contains(policycode)){
							ChkDetail.add(chkDetail);
						}
						policycodes.add(policycode);
						
					}
				}
				if(ChkDetail.size()>0){
					String chkDetailCount = ChkDetail.size()+"";
					chkDetails.setChkDetailCount(chkDetailCount);
					chkDetails.setChkDetail(ChkDetail);
					String respone = LongPolicyUtil.check(chkDetails, pro.getProperty("yinbaotong"));
					if(respone.equals("1")){
						MessageUtil.sendMessage("15510776709", "银保通二次对账成功 ");
						eaStatus.setYbtstatus("success");
						logger.info("银保通二次对账成功");
					}else{
						MessageUtil.sendMessage("15510776709", "银保通二次对账失败：  "+respone);
						logger.error("银保通二次对账失败："+respone);
						
					}
				}
			}catch(Exception e1){
				logger.info("银保通二次对账异常"+e);
				e.printStackTrace();
				MessageUtil.sendMessage("15510776709", "银保通二次对账异常");
			}
		}catch(Exception e){
			MessageUtil.sendMessage("15510776709", "银保通对账异常");
			log.info("银保通对账异常："+e);
			e.printStackTrace();
		}finally{
			check(eaStatus);
			eaccoutStatus.saveStatus(eaStatus);
//			for(int i=1;i<36;i++){
//				Date d = new Date(System.currentTimeMillis()-1000*60*60*24*i);//昨天日期date型
//				String date = sp.format(d);//获取昨天日期
//				check(date);
//			}
		}
	}
	
	public void checkByLongPolicyAgain(){
		logger.info("第二次对账批处理开始····");
		logger.info("查询第一次对账状态····");
		GeEaccoutStatus eaStatus = eaccoutStatus.findStatus();
		String ybtStatus = eaStatus.getYbtstatus();
		String wxStatus = eaStatus.getWxstatus();
		logger.info("第一次银保通对账状态："+ybtStatus);
		logger.info("第一次微信对账状态："+wxStatus);
		if(!(ybtStatus==null&&wxStatus==null)){
			if(!(ybtStatus.equals("success")&&wxStatus.equals("success"))){
				checkByLongPolicy();
			}else{
				logger.info("第一次对账成功，跳过第二次对账");
			}
		}else{
			logger.info("第一次对账成功，跳过第二次对账");
		}
	}
	
	/**
	 * 微信对账
	 */
	
	public void check(){
		log.info("微信对账开始查询20160409支付成功的保单");
//		GeEaccoutStatus eaStatus =new GeEaccoutStatus();
		String appId = PaymentConfigProp.getString("weixin_Appid");
		String mch_id = PaymentConfigProp.getString("weixin_Mch_id");//商户号
		String key = PaymentConfigProp.getString("weixin_key");//密钥
		log.info("读取微信配置信息完成");
		Date d = new Date();
		Calendar cal= Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DAY_OF_MONTH, -2);
		String date = sp.format(cal.getTime());//指定日期
		log.info("获取指定日期 04月09号的对账单===="+date);
		
		//获取微信昨天所有交易成功的订单
		List<Bill> bills = FundUtil.analyze(FundUtil.sendXml(appId, date, "SUCCESS", mch_id, key));
		log.info("获取支付成功微信订单"+bills.size()+"张");
		for(Bill bill:bills){
			String orderCode = bill.getMchOrderNo();//订单号
			if(orderCode.startsWith("RT")){
				log.info("获取支付成功订单号： "+orderCode);
				GeOrder order = orderService.getOrderByOrderCode(orderCode);
				GeEaccout eaccout = new GeEaccout();//创建异常保单信息对象
				if(order!=null){//如果订单对象不为空
					try{
						Set<GePolicy> policys = order.getPolicys();
						Iterator<GePolicy> it = policys.iterator();
						while(it.hasNext()){
							GePolicy policy = it.next();
							if(policy!=null&&policy.getStatus().equals("3")){//如果此保单的状态是承保成功
								order.setStatus("1");
								log.info("此订单已成功承保： "+orderCode);
							}else if(policy==null){//如果没有关联上保单
								eaccout.setExceptionCode("1");//设置异常编码为1
								eaccout.setUserid(bill.getUserId());//用户的openId
								eaccout.setCircpaymentno(bill.getWeiXinOrderNo());//微信订单号
								eaccout.setOrdercode(orderCode);//订单号
								eaccout.setAgentcode(eaccout.getAgentcode());//推荐人编码
								eaccout.setPaytime(bill.getDate());//交易时间
								eaccout.setRefundmentflag("");//退款标识，暂无
								eaccout.setPayBank(bill.getBank());//付款银行
								eaccout.setOrderamount(new Double(bill.getAmount().substring(0, bill.getAmount().length()-2)));//钱
								super.save(eaccout);
								order.setStatus("2");//对账失败
								log.info("异常保单插入完成,订单号："+orderCode);
							}else{
								log.info("发现异常订单： "+orderCode);
								Set<GeApplicantInsured> applicantInsureds = policy.getApplicantInsureds();//投保人信息
								Iterator<GeApplicantInsured> iterator = applicantInsureds.iterator();
								GeApplicantInsured applicantInsured = null;
								if(iterator.hasNext()){
									applicantInsured = iterator.next();
								}
								eaccout.setExceptionCode("1");//设置异常编码为1
								eaccout.setFlowno(policy.getFlowno());//保存流水号
								eaccout.setUserid(bill.getUserId());//用户的openId
								eaccout.setProductname(policy.getProductname());//产品名称
								eaccout.setCircpaymentno(bill.getWeiXinOrderNo());//微信订单号
								eaccout.setOrdercode(orderCode);//订单号
								eaccout.setOrderamount(policy.getSumamount());//保额
								eaccout.setPrem(policy.getSumbasepremium());//保费
								eaccout.setApplicantname(policy.getApplicantname());//投保人姓名
								eaccout.setInsuredname(policy.getInsuredname());//被保人姓名
								eaccout.setAgentcode(eaccout.getAgentcode());//推荐人编码
								eaccout.setProdoctcode(policy.getProdoctcode());//产品编码
								eaccout.setPaytime(bill.getDate());//交易时间
								eaccout.setRefundmentflag("");//退款标识，暂无
								eaccout.setPayBank(bill.getBank());//付款银行
								if(applicantInsured!=null){
									eaccout.setApplicantPhone(applicantInsured.getMobile());
								}
								super.save(eaccout);
								order.setStatus("2");//对账失败
								log.info("异常保单插入完成,订单号："+orderCode);
							}
						}
					}catch(Exception e){
						log.info("对账异常,orderCode:"+orderCode);
						order.setStatus("2");//对账失败
					}
					orderService.updateOrder(order);//更新订单状态
					log.info("订单状态更新完成： "+orderCode);
				}else if(!bill.getAmount().equals("0.01")){//如果不为一分
						eaccout.setExceptionCode("1");//设置异常编码为1
						eaccout.setUserid(bill.getUserId());//用户的openId
						eaccout.setCircpaymentno(bill.getWeiXinOrderNo());//微信订单号
						eaccout.setOrdercode(orderCode);//订单号
						eaccout.setAgentcode(eaccout.getAgentcode());//推荐人编码
						eaccout.setPaytime(bill.getDate());//交易时间
						eaccout.setRefundmentflag("");//退款标识，暂无
						eaccout.setPayBank(bill.getBank());//付款银行
						eaccout.setOrderamount(new Double(bill.getAmount().substring(0, bill.getAmount().length()-2)));//钱
						super.save(eaccout);
						log.info("未存此订单号，异常保单插入完成,订单号："+orderCode);
				}
			}
		}
		log.info("微信对账结束");
	}
	
}
