package cn.com.sinosoft.service;

import cn.com.sinosoft.domain.payment.ProposalPayment;

public interface ProposalPaymentService {
	
	/**
	 * 保存订单支付信记录信息
	 * @param proposalPayment
	 */
	public void saveProposalPayment(ProposalPayment proposalPayment);
	/**
	 * 根据订单号查询订单支付信记录信息
	 * @param orderNo
	 * @return
	 */
	public ProposalPayment getProposalPaymentByOrderCode(String orderCode); 
	
	/**
	 * 根据交易流水号查询订单支付信记录信息
	 * @param orderNo
	 * @return
	 */
	public ProposalPayment getProposalPaymentByFlowNo(String flowNo); 
	
	/**
	 * 更新订单支付信记录信息
	 * @param proposalPayment
	 */
	public void updateProposalPayment(ProposalPayment  proposalPayment);
}