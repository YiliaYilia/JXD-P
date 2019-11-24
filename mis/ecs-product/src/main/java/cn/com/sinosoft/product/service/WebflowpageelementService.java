/**
 * File Name:WebflowpageelementService.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2014年1月8日上午9:47:28
 */
package cn.com.sinosoft.product.service;

import cn.com.sinosoft.domain.product.GeWebflowpageelement;

/**描述：产品流程拥有的节点业务处理<br>
 * 作者：honghui <br>
 * 修改日期：2014年1月8日上午9:47:28 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public interface WebflowpageelementService {
	
	/**
	 * 方法名称: updateWebflowpageelement<br>
	 * 描述：更新元素
	 * 作者: honghui
	 * 修改日期：2014年1月8日上午9:52:44
	 * @param geWebflowpageelement
	 */
	public void updateWebflowpageelement(GeWebflowpageelement geWebflowpageelement);
	/**
	 * 方法名称: getGeWebflowpageelement<br>
	 * 描述：获取元素
	 * 作者: honghui
	 * 修改日期：2014年1月8日上午9:52:54
	 * @param pk
	 * @return
	 */
	public GeWebflowpageelement getGeWebflowpageelement(String pk);
	
	/**
	 * 方法名称: updateGeWebFlowPageElementStatus<br>
	 * 描述：更新产品页面流程元素处理状态
	 * 作者: yuas
	 * 修改日期：2014年1月10日下午8:26:59
	 * @param status
	 * @param coreproductcode
	 * @param elementCode
	 */
	public void updateGeWebflowpageelementStatus(String status,String coreproductcode, String elementCode);
	

}
