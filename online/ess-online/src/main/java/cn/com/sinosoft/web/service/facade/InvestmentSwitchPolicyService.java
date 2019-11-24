package cn.com.sinosoft.web.service.facade;

import cn.com.sinosoft.common.service.axis.AccountVO;
import cn.com.sinosoft.common.service.axis.SwitchAccountVO;

public interface InvestmentSwitchPolicyService {

	AccountVO[] getProductInvestmentAccount(String productCode,String sessionid);
	
	String saveSwitchPolicy(String policyNbr,SwitchAccountVO[] alSwitch,String productName,String sessionid);
	
	int getStatuscode();
}
