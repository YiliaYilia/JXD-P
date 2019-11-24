package cn.com.sinosoft.web.service.facade;

import java.util.List;

import cn.com.sinosoft.common.service.axis.PolicyInformation;
import cn.com.sinosoft.common.service.axis.QueryModel;
import cn.com.sinosoft.domain.user.GePolicyCodeConfig;
import cn.com.sinosoft.domain.user.MobileCustomer;

/**
 * <p>Title: PolicyListQueryService</p>
 * <p>Description:保单列表</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company:sinosoft</p>
 * @author ZhangTiancong
 * @version 1.0
 */
public interface PolicyListQueryService {
	
	/**
	 * 功能：查询保单列表接口
	 * 描述：接口查询用户保单列表
	 * 作者： ZhangTiancong
	 * @param name		姓名
	 * @param cardType	证件类型
	 * @param cardNum	证件号
	 * @return 报文实体
	 */
	PolicyInformation policyListQuery(String name,String cardType,String cardNum);

	/**
	 * 功能：查询保单列表接口
	 * 描述：接口查询用户保单列表
	 * 作者： LiuWenkang
	 * @param partyCode		客户号
	 * @param roleCode		角色 ""时则默认为查询投保人；POLICY-HOL 投保人；LIFE-ASSD 被保人
	 * @return 报文实体
	 */
	PolicyInformation policyListQuery(String partyCode,String roleCode);
	
	/**
	 * 功能：接收保单列表
	 * 描述：处理保单列表接口查询结果
	 * 作者： ZhangTiancong
	 * @param name		姓名
	 * @param cardType	证件类型
	 * @param cardNum	证件号
	 */
	public QueryModel[] depacketizeQuery(QueryModel[] localQM,String name,String cardType,String cardNum);

	/**
	 * 功能：接收保单列表
	 * 描述：处理保单列表接口查询结果
	 * 作者： ZhangTiancong
	 * 作者： LiuWenkang
	 * @param partyCode		客户号
	 * @param roleCode		角色 null时则默认为查询投保人；POLICY-HOL 投保人；LIFE-ASSD 被保人
	 * @return 报文实体
	 */
	public QueryModel[] depacketizeQuery(QueryModel[] localQM,String name,String cardType,String cardNum,String partyCode,String roleCode);


}
