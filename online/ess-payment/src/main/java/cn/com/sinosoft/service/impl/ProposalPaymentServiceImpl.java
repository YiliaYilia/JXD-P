package cn.com.sinosoft.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.payment.ProposalPayment;
import cn.com.sinosoft.service.ProposalPaymentService;

@Component
public class ProposalPaymentServiceImpl extends GenericHibernateDao<ProposalPayment, String> implements ProposalPaymentService{

	@Override
	public void saveProposalPayment(ProposalPayment proposalPayment) {
		super.save(proposalPayment);
		
	}

	@Override
	public ProposalPayment getProposalPaymentByOrderCode(String orderCode) {
		if(null == orderCode){
			return null;
		}
		QueryRule queryRule=QueryRule.getInstance();
		queryRule.addEqual("orderNo", orderCode);
		List<ProposalPayment>   list=super.find(queryRule);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
		
	}
	
	@Override
	public ProposalPayment getProposalPaymentByFlowNo(String flowNo) {
		if(null == flowNo){
			return null;
		}
		QueryRule queryRule=QueryRule.getInstance();
		queryRule.addEqual("flowno", flowNo);
		List<ProposalPayment>   list=super.find(queryRule);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void updateProposalPayment(ProposalPayment proposalPayment) {
		super.update(proposalPayment);
		
	}

	

}
