package cn.com.sinosoft.ess.config.service;

import cn.com.sinosoft.domain.msl.MslInsuranceRate;


public interface MslInsuranceRateService {
//	/**
//	 * 根据产品代码和缴费期限，查出基数保费
//	 * @param prodoctCode
//	 * @param PayPeriodNumber
//	 * @return
//	 */
//	double getBasePremium(String prodoctCode,int PayPeriodNumber);
	/**
	 * 根据产品代码和保险期间数值和保险期间单位查出基数保费
	 * @param prodoctCode
	 * @param PayPeriodNumber
	 * @param sumamount
	 * @return
	 */
	MslInsuranceRate getSumInsured(String prodoctCode,String number,String type);
}
