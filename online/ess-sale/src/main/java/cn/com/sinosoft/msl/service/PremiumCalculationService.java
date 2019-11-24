package cn.com.sinosoft.msl.service;

import cn.com.sinosoft.domain.sale.GeApplicantInsured;
import cn.com.sinosoft.domain.sale.GePolicy;

/**
 * 描述：各产品保费试算<br>
 * 作者：CaryXu <br>
 * 修改日期：2015年4月30日 12:39:41 <br>
 * E-mail: Xukaizhen@sinosoft.com.cn <br>
 */
public interface PremiumCalculationService {
	
	/**
	 * 1.根据productCode查询不同产品的保费，productCode有“NBJ”,"CDC","CCC"
	 * 2.网销产品保费试算productCode有“PAC”,"PAT","PAH",
	 *   GePolicy需要传入code,保额,保险期间及保险期间单位(天,年)
	 * 3.将计算的保费结果，存入 GePolicy 对象中。
	 * @param productCode
	 * @param gender
	 * @param payPeriod
	 * @param age
	 * @param amount
	 * @return
	 */
	void calculate(GePolicy gePolicy,GeApplicantInsured applicant);
	
}
