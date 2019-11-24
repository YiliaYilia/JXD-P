package cn.com.sinosoft.service;

import java.util.List;

import cn.com.sinosoft.domain.payment.GePaymentTypeInfo;

public interface PaymentTypeInfoService {
	/**
	 * 根据登录方式查询支付方式
	 * @param loginWay
	 * @return
	 */
	public List<GePaymentTypeInfo> findByLoginWayCode(String loginWay);
}
