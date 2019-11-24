package cn.com.sinosoft.web.service.impl;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.common.service.axis.BankMsgModifyInterfaceLocator;
import cn.com.sinosoft.common.service.axis.BankMsgModifyInterfacePortType;
import cn.com.sinosoft.common.service.axis.BankMsgModifyModel;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.web.service.facade.ChangeBanNumService;
@Component
public class ChangeBanNumServiceImpl extends GenericHibernateDao<GePolicy,Integer> implements ChangeBanNumService {
	private static final Logger log=LoggerFactory.getLogger(ChangeBanNumServiceImpl.class);
	@Override
	public void saveGechangepolicy(GePolicy policy){
		super.update(policy);
	}
	 
	@Override
	public GePolicy getPolicybypolicyno(String policyno) {
		QueryRule query=QueryRule.getInstance();
		query.addEqual("policycode",policyno);
		GePolicy findUnique = super.findUnique(query);
		return findUnique;
	}

	@Override
	public BankMsgModifyModel getbankMsgModifyModel(String policyno, String bankaccountnumber, String bankFullName,
			String bankcode, String bankprovince, String bankBranchName, String bankcity) {
		BankMsgModifyInterfaceLocator bankMsg = new BankMsgModifyInterfaceLocator();
		BankMsgModifyModel modifyBankMsg = null;
		try {
			BankMsgModifyInterfacePortType Soap11Endpoint = bankMsg.getBankMsgModifyInterfaceHttpSoap11Endpoint();
			try {
				modifyBankMsg = Soap11Endpoint.modifyBankMsg(policyno, bankaccountnumber, bankcode, bankBranchName, bankprovince, bankcity, bankFullName);
			} catch (RemoteException e) {
				log.error("调用修改银行账号接口异常");
				e.printStackTrace();
			}
		} catch (ServiceException e) {
			log.error("调用修改银行账号接口异常");
			e.printStackTrace();
		}
		return modifyBankMsg;
	}

	
}
