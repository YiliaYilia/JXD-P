package cn.com.sinosoft.web.service.facade;

import cn.com.sinosoft.common.service.axis.BasicQuery;

/**
 * <p>Title: PolicyBasicQueryService</p>
 * <p>Description:保单基本信息</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company:sinosoft</p>
 * @author ztc
 * @version 1.0
 */
public interface PolicyBasicQueryService {
	/**
	 * 查询保单基本信息(长险)
	 * @param policyNo 保单号
	 * @return 接口返回消息
	 */
	BasicQuery policyBasicQuery(String policyNo);
	
	/**
	 * 查询保单基本信息(短险)
	 * @param policyNo 保单号
	 * @return 接口返回消息
	 */
	BasicQuery ShortPolicyBasic(String policyNo);
}
