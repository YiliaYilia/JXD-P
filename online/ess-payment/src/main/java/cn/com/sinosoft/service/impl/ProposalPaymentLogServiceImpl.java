package cn.com.sinosoft.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.payment.ProposalPaymentLog;
import cn.com.sinosoft.service.ProposalPaymentLogService;

@Component
public class ProposalPaymentLogServiceImpl extends GenericHibernateDao<ProposalPaymentLog, String> implements ProposalPaymentLogService{

	
	@Override
	public void saveProposalPaymentLog(ProposalPaymentLog proposalPaymentLog) {
		super.save(proposalPaymentLog);
		
	}

	@Override
	public ProposalPaymentLog getProposalPaymentLogByFlowNo(String flowNo) {
		if(null==flowNo){
			return null;
		}
		QueryRule queryRule=QueryRule.getInstance();
		queryRule.addEqual("flowNo", flowNo);
		List<ProposalPaymentLog> list=super.find(queryRule);
		return list.get(0);
	}
//
//	@Override
//	public void updateProposalPaymentLog(ProposalPaymentLog proposalPaymentLog) {
//		super.update(proposalPaymentLog);
//		
//	}

}
