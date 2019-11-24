/**
 * File Name:ProductService.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2014年1月2日下午1:45:57
 */
package cn.com.sinosoft.product.service;

import java.util.List;
import java.util.Map;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.product.GeInsurancePlan;
import cn.com.sinosoft.domain.product.GeInsurancePlanAccount;
import cn.com.sinosoft.domain.product.GeInsurancePlanAccountScore;
import cn.com.sinosoft.domain.product.GeProductInformbook;
import cn.com.sinosoft.domain.product.GeProductMain;
import cn.com.sinosoft.domain.product.GeProductOtherconfig;
import cn.com.sinosoft.domain.product.GeRiskSurvey;
import cn.com.sinosoft.domain.product.GeRiskSurveySubject;
import cn.com.sinosoft.domain.product.GeRiskSurveySubjectOption;

/**描述：产品业务操作类<br>
 * 作者：honghui <br>
 * 修改日期：2014年1月2日下午1:45:57 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public interface ProductService {
	
	/**
	 * 方法名称: addProductMain<br>
	 * 描述：添加产品
	 * 作者: honghui
	 * 修改日期：2014年1月2日下午1:46:59
	 * @param geProductMain
	 */
	public void addProductMain(GeProductMain geProductMain);
	
	/**
	 * 方法名称: updateProductMain<br>
	 * 描述：更新产品
	 * 作者: honghui
	 * 修改日期：2014年1月15日下午12:12:06
	 * @param geProductMain
	 */
	public void updateProductMain(GeProductMain geProductMain);
	
	/**
	 * 方法名称: updateProductMainFlowElement<br>
	 * 描述：更新产品流程配置
	 * 作者: honghui
	 * 修改日期：2014年1月5日下午6:36:16
	 * @param geProductMain
	 */
	public void updateProductMainFlowElement(GeProductMain geProductMain,String config);
	
	/**
	 * 方法名称: getProductMainByPage<br>
	 * 描述：分页查询产品
	 * 作者: honghui
	 * 修改日期：2014年1月2日下午1:48:38
	 * @param geProductMain
	 * @return
	 */
	public Page<GeProductMain> getProductMainByPage(GeProductMain geProductMain,int page,int rows);

	/**
	 * 方法名称: geProductMain<br>
	 * 描述：通过主键获取产品实体
	 * 作者: honghui
	 * 修改日期：2014年1月3日下午2:30:31
	 * @param pk
	 * @return
	 */
	public GeProductMain geProductMain(String pk);
	
	/**
	 * 方法名称: deleteProduct<br>
	 * 描述：删除产品状态不为04-已审核，05-已发布的产品
	 * 作者: yuas
	 * 修改日期：2014年1月8日下午1:36:20
	 * @param coreProductCode
	 * @throws Exception
	 */
	public void deleteProduct(String coreProductCode);
	
	/**
	 * 方法名称: findAllProduct<br>
	 * 描述：查询所有产品
	 * 作者: yuas
	 * 修改日期：2014年1月8日下午1:40:17
	 * @return
	 */
	public List<GeProductMain> findAllProduct();
	
	/**
	 * 方法名称：findProductByName<br>
	 * 描述：根据产品名称获得产品（模糊查询）<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月22日下午6:47:29<br>
	 * @return
	 */
	public List<GeProductMain> findProductByName(String productname);
	
	/**
	 * 方法名称: updateProductMainForBXJH<br>
	 * 描述：更新产品表
	 * 作者: honghui
	 * 修改日期：2014年1月7日下午7:08:35
	 * @param geProductMain
	 */
	public void updateProductMainForBXJH(GeProductMain geProductMain,List<GeInsurancePlan> geInsurancePlans,List<GeInsurancePlanAccount> geInsurancePlanAccounts ,List<GeInsurancePlanAccountScore> geInsurancePlanAccountScores);
	
	/**
	 * 方法名称：updateProductMainForOtherConfig<br>
	 * 描述：更新产品的其他配置<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月8日下午1:18:03<br>
	 * @param geProductMain
	 * @param geProductOtherconfigs
	 * @param otherConfigCode
	 */
	public void updateProductMainForOtherConfig(GeProductMain geProductMain,List<GeProductOtherconfig> geProductOtherconfigs,String otherConfigCode);

	/**
	 * 方法名称：updateProductMainForInformbooks<br>
	 * 描述：更新产品的投保告知项<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月9日下午6:13:02<br>
	 * @param geProductMain
	 * @param geProductInformbooks
	 */
	public void updateProductMainForInformbooks(GeProductMain geProductMain,List<GeProductInformbook> geProductInformbooks);
	
	/**
	 * 方法名称: valProductStatus<br>
	 * 描述： (详细定义)编辑每个标签页时校验产品状态，如果是刚发布的，产品状态改为已定制流程
	 * 作者: yuas
	 * 修改日期：2014年1月10日下午7:11:43
	 * @param geProductMain
	 * @return
	 */
	public boolean valProductStatus(GeProductMain geProductMain);

	
	/**
	 * 方法名称: updateProductMainForFxpgwj<br>
	 * 描述：更新产品的风险评估问卷信息
	 * 作者: liaojiping
	 * 修改日期：2014-1-9下午05:52:56
	 * @param geProductMain
	 * @param geRiskSurvey
	 * @param geRiskSurveySubject
	 * @param geRiskSurveySubjectOption
	 */
	public void updateProductMainForFxpgwj(GeProductMain geProductMain,List<GeRiskSurvey> geRiskSurveys,String datas);
	//public void updateProductMainForFxpgwj(GeProductMain geProductMain,List<GeRiskSurvey> geRiskSurvey,List<GeRiskSurveySubject> geRiskSurveySubject,List<GeRiskSurveySubjectOption> geRiskSurveySubjectOption);

	
	/**
	 * 方法名称: updateProductInfoConfig<br>
	 * 描述：更新产品信息
	 * 作者: partrick
	 * 修改日期：2014年1月14日下午7:30:40
	 * @param geProductMain
	 * @param map
	 * @return
	 */
	public Map<String, Object> updateProductInfoConfig(GeProductMain geProductMain,Map<String, Object> map);

}
