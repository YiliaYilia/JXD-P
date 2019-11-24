package cn.com.sinosoft.service;

import cn.com.sinosoft.domain.payment.ProposalPaymentLog;

public interface ProposalPaymentLogService {
	/**
	 * 保存订单支付时请求和返回结果日志־
	 * @param proposalPaymentLog
	 */
	public void saveProposalPaymentLog(ProposalPaymentLog proposalPaymentLog);
	
	/**
	 * 根据订单号查询订单请求和结果信息
	 * @param orderNo
	 * @return
	 */
	public ProposalPaymentLog getProposalPaymentLogByFlowNo(String flowNo);
//	
//	/**
//	 * 修改请求数据或返回数据
//	 * @param proposalPaymentLog
//	 */
//	public void updateProposalPaymentLog(ProposalPaymentLog proposalPaymentLog);
	
	
}
