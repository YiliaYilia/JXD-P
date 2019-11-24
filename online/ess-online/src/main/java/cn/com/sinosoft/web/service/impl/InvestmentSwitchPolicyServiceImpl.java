package cn.com.sinosoft.web.service.impl;


import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.com.sinosoft.common.service.axis.AccountVO;
import cn.com.sinosoft.common.service.axis.ClientBindQueryLocator;
import cn.com.sinosoft.common.service.axis.LinkWebLocator;
import cn.com.sinosoft.common.service.axis.LinkWebSoap_PortType;
import cn.com.sinosoft.common.service.axis.ProductInvestmentAccountMsg;
import cn.com.sinosoft.common.service.axis.ReturnMsg;
import cn.com.sinosoft.common.service.axis.SwitchAccountVO;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.domain.sale.GeAccount;
import cn.com.sinosoft.domain.sale.GeAccountSwitch;
import cn.com.sinosoft.domain.user.GE_ACCOUNT_MAP;
import cn.com.sinosoft.web.action.InvestmentSwitchPolicyAction;
import cn.com.sinosoft.web.domain.IIMSSession;
import cn.com.sinosoft.web.domain.SingleCap;
import cn.com.sinosoft.web.service.facade.GE_ACCOUNT_MAPService;
import cn.com.sinosoft.web.service.facade.InvestmentAccountService;
import cn.com.sinosoft.web.service.facade.InvestmentSwitchPolicyService;

@Service
public class InvestmentSwitchPolicyServiceImpl extends GenericHibernateDao<GeAccountSwitch, Integer> implements InvestmentSwitchPolicyService{
	
	@Autowired
	InvestmentAccountService investmentAccountService;
	
	@Autowired
	GE_ACCOUNT_MAPService ge_ACCOUNT_MAPService;
	private static Properties pro = new Properties();
	static{
		try {
			pro.load(new InputStreamReader(InvestmentSwitchPolicyAction.class.getResourceAsStream("/config/AccountTransfer.properties"), "UTF-8"));		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static Log logger = LogFactory.getLog(InvestmentSwitchPolicyServiceImpl.class);
	private int statuscode ;
	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	
	/**
	 * 账户查询
	 */
	public AccountVO[] getProductInvestmentAccount(String productCode,String sessionid) {
		AccountVO[] reAVO = new AccountVO[0];
		try {
			LinkWebLocator hts = new LinkWebLocator();
			LinkWebSoap_PortType detail = null;
			detail = hts.getLinkWebSoap();
			ProductInvestmentAccountMsg result= detail.getProductInvestmentAccount(sessionid, productCode);
			String returnCode = result.getHeader().getReturnCode();
			String returnMsg = result.getHeader().getReturnMsg();
			logger.info("账户查询结果：返回码:"+returnCode+",返回内容："+returnMsg);
			if("0".equals(returnCode)){
				reAVO = result.getBody();
			}
		} catch (Exception e){
			e.printStackTrace();
		} 
		return reAVO;
	}
	
	/**
	 * 提交转移信息
	 */
	public String saveSwitchPolicy(String policyNbr,SwitchAccountVO[] alSwitch,String productName,String sessionid){
		String returnCode = null;
		String returnMsg = null;
		try {
			LinkWebLocator hts = new LinkWebLocator();
			LinkWebSoap_PortType detail = null;
			detail = hts.getLinkWebSoap();
			//查询接口
			ReturnMsg result= detail.saveSwitchPolicy(sessionid, policyNbr, alSwitch);//调用官网接口
			returnCode = result.getHeader().getReturnCode();
			returnMsg = result.getHeader().getReturnMsg();
			//取当前时间
			String makedate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
			
			if("0".equals(returnCode)){
				logger.info("转移申请提交成功，Code:"+returnCode+",Msg:"+returnMsg);
				for(SwitchAccountVO sa:alSwitch){
					//如果成功则将账户变更记录插入到指定表
					String account_id = sa.getIvmtAcctID();
					GE_ACCOUNT_MAP ge_account_map = ge_ACCOUNT_MAPService.getOne("account_code", account_id);//将账户号再换回老接口标准
					String account_code = ge_account_map.getAccount_id();//老接口端口号
					//从原映射表中调取账户名称
					List<GeAccount> geAccounts = investmentAccountService.findAccount(account_code);
					String accountName = "";
					if(geAccounts.size()>0){
						accountName = geAccounts.get(0).getAccountname();
						this.InsertAccount(accountName, makedate, policyNbr, sa.getSwitchRatio(),productName);
					}else{
						logger.info("入资产转移报表异常");
					}
				}
				this.statuscode = 1;
				return "转移申请提交成功";
			}else{
				logger.info("转移申请提交失败,code:"+returnCode+",Msg:"+returnMsg);
				this.statuscode = returnCode!=null?Integer.parseInt(returnCode):0;
				return pro.getProperty(returnCode)!=null?pro.getProperty(returnCode):pro.getProperty("other");
			}
		} catch (Exception e){
			logger.error("转移申请提交异常",e);
			this.statuscode = -1;
			return "转移申请提交异常";
		} 
	}
	
	/**
	 * 插入账户操作报表
	 * @param accountName 账户名称
	 * @param makedate 时间
	 * @param policynum 保单号
	 * @param switchratio 修改比例
	 */

	public void InsertAccount(String accountName,String makedate,String policynum,String switchratio,String productName){
		GeAccountSwitch ga = new GeAccountSwitch();
		ga.setAccountName(accountName);
		ga.setMakedate(makedate);
		ga.setPolicynum(policynum);
		switchratio += "%";
		ga.setSwitchratio(switchratio);
		ga.setProductName(productName);
		this.save(ga);		
	}

}
