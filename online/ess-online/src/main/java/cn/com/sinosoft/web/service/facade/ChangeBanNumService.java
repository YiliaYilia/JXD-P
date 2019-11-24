package cn.com.sinosoft.web.service.facade;

import cn.com.sinosoft.common.service.axis.BankMsgModifyModel;
import cn.com.sinosoft.domain.sale.GeChangepolicy;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;

public interface ChangeBanNumService {
	BankMsgModifyModel getbankMsgModifyModel(String policyno,String bankaccountnumber,String bankFullName,String bankcode,String bankprovince,String bankBranchName,String bankcity);
	
	void saveGechangepolicy(GePolicy policy);
	
	GePolicy getPolicybypolicyno(String policyno);
	
	
	

}
