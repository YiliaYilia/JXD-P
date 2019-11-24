package cn.com.sinosoft.web.action;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jcraft.jsch.Session;
import com.sun.tools.ws.processor.model.Request;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.slf4j.Logger;

import cn.com.sinosoft.common.service.axis.BankMsgModifyModel;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.sale.GeChangepolicy;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.web.service.facade.ChangeBanNumService;
import cn.com.sinosoft.web.service.facade.ChangeBanNumUpdateOrderService;
import cn.com.sinosoft.web.service.facade.ChangeBanSavebankchangepolicyrService;
public class BanknumberChangeAction extends Struts2Action{
	private static final Long serialVersionUID=1L;
	
	private static final Logger log=LoggerFactory.getLogger(BanknumberChangeAction.class);
	
	private GeChangepolicy changepolicy=new GeChangepolicy();
	
	@Autowired
	private ChangeBanNumService BanNumService;
	
	@Autowired
	private ChangeBanNumUpdateOrderService BanNumUpdateOrderService;
	@Autowired
	private ChangeBanSavebankchangepolicyrService cs;
	
	@Action(value="changeBankNum")
	public String changeBankNum(){
		changepolicy.setUpdateTime(new Date());//修改时间
		String bank = changepolicy.getBankcode();//银行编码
		if(bank!=null&&bank.length()>0){
			if (bank.equals("090004")) {
		        bank = "中信银行信用卡";
		    }else if(bank.equals("070309")){
				bank="兴业银行";
			}else{
				Integer bankInt = Integer.valueOf(bank);
				switch (bankInt) {
				case 130102:bank="工商银行";break; 
				case 100103:bank="农业银行";break; 
				case 130104:bank="中国银行";break; 
				case 130105:bank="建设银行";break; 
				case 130308:bank="招商银行";break;  
				case 100307:bank="平安银行";break;
				case 100310:bank="浦发银行";break;   
				case 100303:bank="光大银行";break;                                                                          
				case 100306:bank="广发银行";break;  
				case 130302:bank="中信银行";break;  
				case 100403:bank="邮政储蓄银行";break;
				case 100301:bank="交通银行";break; 
				}
			}
		}
		changepolicy.setBankC(bank);
		//调接口
		BankMsgModifyModel bankMsg = BanNumService.getbankMsgModifyModel(changepolicy.getPolicyno(), changepolicy.getBankaccountnumberC(),"",changepolicy.getApplicantname(), changepolicy.getBankProvince(),changepolicy.getBankC(),changepolicy.getBankCity());
		log.info("bank:"+bank);
		log.info("polno:"+changepolicy.getPolicyno()+"bankAccountNumber:"+changepolicy.getBankaccountnumberC()+"accountHolderName："+""+"bankBranchName:"+changepolicy.getApplicantname()+"bankAccountProvince:"+changepolicy.getBankProvince()+"bankAccountCity:"+changepolicy.getBankC()+"bankFullName:"+changepolicy.getBankCity());
		log.info("bankMsg:"+bankMsg);
		if(bankMsg!=null){
			String polno = bankMsg.getPolno();//保单号
			String state = bankMsg.getState();//修改状态
			String msg = bankMsg.getMsg();//提示信息
			getHttpServletRequest().setAttribute("msg",msg);
			if(state.equals("S")){
				if(changepolicy!=null){
					cs.savechangepolicy(changepolicy);
					log.info("修改信息存入Gechangepolicy");
				}
//			修改policy表银行信息
				log.info("保单号："+polno);
				log.info(msg);
				String policyno = changepolicy.getPolicyno();//获取保单号
//		 		GePolicy policy = BanNumService.getPolicybypolicyno("TN00003958");
		 		GePolicy policy = BanNumService.getPolicybypolicyno(policyno);
		 		if(policy!=null){
					policy.setBank(changepolicy.getBankC());//银行名称
					policy.setBankBranchCode(changepolicy.getBankcode());//银行编码
					policy.setBankAccountNumber(changepolicy.getBankaccountnumberC());
					policy.setBankProvince(changepolicy.getBankProvince());
					policy.setBankCity(changepolicy.getBankCity());
					BanNumService.saveGechangepolicy(policy);//修改信息存库
					log.info("policy更新银行修改信息");
		 		}
//	 		修改order表银行信息
//				GeOrder order = BanNumUpdateOrderService.getOrderbypolicyno("TN00003831");
				GeOrder order = BanNumUpdateOrderService.getOrderbypolicyno(policyno);
				if(order!=null){ 
					order.setBankBranchName(changepolicy.getBankC());//银行名称
					order.setBankBranchCode(changepolicy.getBankcode());//银行编码
					order.setBankProvince(changepolicy.getBankProvince());
					order.setBankCity(changepolicy.getBankCity());
					BanNumUpdateOrderService.updateOrder(order);
					log.info("order更新银行修改信息");
				}
				
			} else{
				log.info("错误："+msg);
			}
		}
		return "../page/policyService";
}

	public GeChangepolicy getChangepolicy() {
		return changepolicy;
	}

	public void setChangepolicy(GeChangepolicy changepolicy) {
		this.changepolicy = changepolicy;
	}

	
}
