/**
 * File Name:WebflowpageelementServiceImpl.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2014年1月8日上午9:53:37
 */
package cn.com.sinosoft.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeWebflowpageelement;
import cn.com.sinosoft.product.service.WebflowpageelementService;

/**描述：<br>
 * 作者：honghui <br>
 * 修改日期：2014年1月8日上午9:53:37 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
@Component
public class WebflowpageelementServiceImpl extends GenericHibernateDao<GeWebflowpageelement, String> implements WebflowpageelementService {

	/**方法名称：updateWebflowpageelement <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2014年1月8日上午9:53:37 
	 * @see cn.com.sinosoft.product.service.WebflowpageelementService#updateWebflowpageelement(cn.com.sinosoft.domain.product.GeWebflowpageelement) 
	 * @param geWebflowpageelement
	 */
	@ECSOperator(operator="更新web流程页面元素")
	public void updateWebflowpageelement(
			GeWebflowpageelement geWebflowpageelement) {
		super.update(geWebflowpageelement);
	}

	/**方法名称：getGeWebflowpageelement <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2014年1月8日上午9:53:37 
	 * @see cn.com.sinosoft.product.service.WebflowpageelementService#getGeWebflowpageelement(java.lang.String) 
	 * @param pk
	 * @return
	 */
	public GeWebflowpageelement getGeWebflowpageelement(String pk) {
		return super.get(pk);
	}
	
	/**
	 * 方法名称: updateGeWebFlowPageElementStatus<br>
	 * 描述：更新产品页面流程元素处理状态
	 * 作者: yuas
	 * 修改日期：2014年1月10日下午8:26:59
	 * @param status
	 * @param coreproductcode
	 * @param elementCode
	 */
	@ECSOperator(operator="更新web流程页面元素状态")
	public void updateGeWebflowpageelementStatus(String status,String coreproductcode, String elementCode) {
		
		QueryRule query = QueryRule.getInstance();
		query.addEqual("geProductMain.coreproductcode", coreproductcode);
		query.addEqual("webflowpageelementcode", elementCode);
		List<GeWebflowpageelement> webFlowPageElementList = super.find(query);
		for (GeWebflowpageelement webFlowPageElement:webFlowPageElementList){
			webFlowPageElement.setStatus(status);
			super.update(webFlowPageElement);
		}
	}

}
