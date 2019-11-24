package cn.com.sinosoft.web.service.facade;

import cn.com.sinosoft.common.service.axis.LifeADTPModel;

/**
 * 追加投资接口
 * @author GHY
 *
 */
public interface LifeADTPService {
	
	/**
	 * 追加投资接口
	 * @param policyNo
	 * @param amount
	 * @return
	 */
	LifeADTPModel getLifeADTP(String policyNo, String amount) throws Exception;
	
}
