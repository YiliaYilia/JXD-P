/**
 * File Name:ProductServiceImpl.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2014年1月2日下午1:46:20
 */
package cn.com.sinosoft.product.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.core.springsecurity.SpringSecurityUtil;
import cn.com.sinosoft.core.utils.StringUtils;
import cn.com.sinosoft.domain.product.GeInsurancePlan;
import cn.com.sinosoft.domain.product.GeInsurancePlanAccount;
import cn.com.sinosoft.domain.product.GeInsurancePlanAccountScore;
import cn.com.sinosoft.domain.product.GeProductExtend;
import cn.com.sinosoft.domain.product.GeProductExtendPeriod;
import cn.com.sinosoft.domain.product.GeProductInformbook;
import cn.com.sinosoft.domain.product.GeProductMain;
import cn.com.sinosoft.domain.product.GeProductOtherconfig;
import cn.com.sinosoft.domain.product.GeProductflowpageelementdefine;
import cn.com.sinosoft.domain.product.GeRiskSurvey;
import cn.com.sinosoft.domain.product.GeRiskSurveySubject;
import cn.com.sinosoft.domain.product.GeRiskSurveySubjectOption;
import cn.com.sinosoft.domain.product.GeSaleArea;
import cn.com.sinosoft.domain.product.GeWebflowpage;
import cn.com.sinosoft.domain.product.GeWebflowpageelement;
import cn.com.sinosoft.product.service.ProductExtendPeriodService;
import cn.com.sinosoft.product.service.ProductExtendService;
import cn.com.sinosoft.product.service.ProductFlowPageElementDefineService;
import cn.com.sinosoft.product.service.ProductService;
import cn.com.sinosoft.product.service.SaleAreaService;

/**描述：产品业务操作类<br>
 * 作者：honghui <br>
 * 修改日期：2014年1月2日下午1:46:20 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
@Component
public class ProductServiceImpl extends GenericHibernateDao<GeProductMain, String> implements ProductService {
	@Autowired
	private ProductFlowPageElementDefineService productFlowPageElementDefineService;
	
	@Autowired
	private ProductFlowPageElementDefineService pageElementDefineService;
	
	@Autowired
	private ProductExtendService productExtendService;
	
	@Autowired
	private ProductExtendPeriodService productExtendPeriodService;
	
	@Autowired
	private SaleAreaService saleAreaService;
	/**方法名称：addProductMain <br>
	 * 描述：添加产品 <br>
	 * 作者：honghui <br>
	 * 修改日期：2014年1月2日下午1:47:07 
	 * @see cn.com.sinosoft.product.service.ProductService#addProductMain(cn.com.sinosoft.domain.product.GeProductMain) 
	 * @param geProductMain
	 */
	@ECSOperator(operator="添加产品")
	public void addProductMain(GeProductMain geProductMain) {
		this.save(geProductMain);
	}
	/**
	 * 方法名称：updateProductMain <br>
	 * 描述： 修改产品<br>
	 * 作者：honghui <br>
	 * 修改日期：2014年1月15日下午12:18:43 
	 * @see cn.com.sinosoft.product.service.ProductService#updateProductMain(cn.com.sinosoft.domain.product.GeProductMain) 
	 * @param geProductMain
	 */
	@ECSOperator(operator="修改产品")
	public void updateProductMain(GeProductMain geProductMain){
		super.update(geProductMain);
	}

	
	/**方法名称：updateProductMainFlowElement <br>
	 * 描述：更新产品流程配置 <br>
	 * 作者：honghui <br>
	 * 修改日期：2014年1月5日下午6:36:40 
	 * @see cn.com.sinosoft.product.service.ProductService#updateProductMainFlowElement(cn.com.sinosoft.domain.product.GeProductMain) 
	 * @param geProductMain
	 */
	@ECSOperator(operator="更新产品流程配置")
	public void updateProductMainFlowElement(GeProductMain geProductMain,String config) {
		Map<String, List<String>> pageMap = new HashMap<String, List<String>>();
		
		String[] pageAndElement = config.split("-");  //多个页面用“-”隔开
		for(int i=0;i<pageAndElement.length;i++){
			String page = pageAndElement[i];
			String[] elements = page.split("_");//页面与元素用“—”隔开
			List<String> elementCodes = new ArrayList<String>();
			
			for(int j=1;j<elements.length;j++){
				String elementId = elements[j];
				elementCodes.add(elementId);
				pageMap.put(elements[0], elementCodes); //elements[0] 表示页面 elementCodes表示该页面元素
			}
		}
		
		List<GeWebflowpage> webflowpages = geProductMain.getGeWebflow().getGeWebflowpages();
		for(int i=0;i<webflowpages.size();i++){
			GeWebflowpage page = webflowpages.get(i);
			
			List<GeWebflowpageelement> oldGeWebflowpageelements =page.getGeWebflowpageelements();
			List<GeWebflowpageelement> tempGeWebflowpageelements = new ArrayList<GeWebflowpageelement>();
			tempGeWebflowpageelements.addAll(oldGeWebflowpageelements);
			for(GeWebflowpageelement ele : tempGeWebflowpageelements){
				page.getGeWebflowpageelements().remove(ele);
				this.delete(ele);
			}
			
			page.getGeWebflowpageelements().clear();
			if(pageMap.containsKey(page.getWebflowpagecode())){
				List<String> elementCodes = pageMap.get(page.getWebflowpagecode());
				for(int j=0;j<elementCodes.size();j++){
					String elementId = elementCodes.get(j);
					GeProductflowpageelementdefine elementFine = 
							pageElementDefineService.getGeProductflowpageelementdefine(elementId);
					GeWebflowpageelement webflowpageelement = new GeWebflowpageelement();
					webflowpageelement.setCreatetime(new Date());
					webflowpageelement.setUpdatetime(new Date());
					webflowpageelement.setHandleurl(elementFine.getHandleurl());
					webflowpageelement.setWebflowpageelementname(elementFine.getElementname());
					webflowpageelement.setSeqindex((long)j);
					webflowpageelement.setGeWebflowpage(page);
					webflowpageelement.setGeProductMain(geProductMain);
					webflowpageelement.setWebflowpageelementcode(elementFine.getProductflowpageelementdefineno());
					page.getGeWebflowpageelements().add(webflowpageelement);
				}
				
			}
		}
		this.update(geProductMain);
	}


	/**方法名称：getProductMainByPage <br>
	 * 描述： 分页查询产品<br>
	 * 作者：honghui <br>
	 * 修改日期：2014年1月2日下午1:49:10 
	 * @see cn.com.sinosoft.product.service.ProductService#getProductMainByPage(cn.com.sinosoft.domain.product.GeProductMain, int, int) 
	 * @param geProductMain
	 * @param page
	 * @param rows
	 * @return
	 */
	public Page<GeProductMain> getProductMainByPage(
			GeProductMain geProductMain, int page, int rows) {
		QueryRule queryRule = QueryRule.getInstance();
		if(geProductMain != null){
			if(!StringUtils.isEmpty(geProductMain.getCoreproductcode())){
				queryRule.addLike("coreproductcode", "%"+geProductMain.getCoreproductcode()+"%");
			}
			if(!StringUtils.isEmpty(geProductMain.getProductname())){
				queryRule.addLike("productname", "%"+geProductMain.getProductname()+"%");
			}
			if(!StringUtils.isEmpty(geProductMain.getBusinessarea())){
				queryRule.addEqual("businessarea", geProductMain.getBusinessarea());
			}
			if(!StringUtils.isEmpty(geProductMain.getProductstatus())){
				queryRule.addEqual("productstatus", geProductMain.getProductstatus());
			}
		}
		queryRule.addDescOrder("createdate");
		return this.find(queryRule, page, rows);
	}

	/**方法名称：geProductMain <br>
	 * 描述：通过主键获取产品实体 <br>
	 * 作者：honghui <br>
	 * 修改日期：2014年1月3日下午2:30:54 
	 * @see cn.com.sinosoft.product.service.ProductService#geProductMain(java.lang.String) 
	 * @param pk
	 * @return
	 */
	public GeProductMain geProductMain(String pk) {
		return this.get(pk);
	}

	/**
	 * 方法名称: deleteProduct<br>
	 * 描述：删除产品
	 * 作者: yuas
	 * 修改日期：2014年1月8日下午1:36:20
	 * @param coreProductCode
	 * @throws Exception
	 */
	@ECSOperator(operator="删除产品")
	public void deleteProduct(String coreProductCode) {
		GeProductMain geProductMain = this.geProductMain(coreProductCode);
		String productStatus = geProductMain.getProductstatus();
		super.delete(geProductMain);
	}
	
	/**
	 * 方法名称: findAllProduct<br>
	 * 描述：查询所有产品
	 * 作者: yuas
	 * 修改日期：2014年1月8日下午1:40:17
	 * @return
	 */
	public List<GeProductMain> findAllProduct(){
		QueryRule queryRule = QueryRule.getInstance();
		return this.find(GeProductMain.class, queryRule);
	}
	
	/**
	 * 方法名称：findProductByName<br>
	 * 描述：根据产品名称获得产品（模糊查询）<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月22日下午6:48:41<br>
	 * @param productname
	 * @return
	 */
	public List<GeProductMain> findProductByName(String productname) {
		QueryRule queryRule = QueryRule.getInstance();
		if(!StringUtils.isEmpty(productname)){
			queryRule.addLike("productname", "%"+productname+"%");
		}
		return this.find(GeProductMain.class, queryRule);
	}
	
	/**方法名称：updateProductMainForBXJH <br>
	 * 描述：添加或者更新产品保险计划 <br>
	 * 作者：honghui <br>
	 * 修改日期：2014年1月7日下午7:09:03 
	 * @see cn.com.sinosoft.product.service.ProductService#updateProductMain(cn.com.sinosoft.domain.product.GeProductMain) 
	 * @param geProductMain
	 */
	@ECSOperator(operator="添加或者更新产品保险计划 ")
	public void updateProductMainForBXJH(GeProductMain geProductMain ,List<GeInsurancePlan> geInsurancePlans,
			List<GeInsurancePlanAccount> geInsurancePlanAccounts,List<GeInsurancePlanAccountScore> geInsurancePlanAccountScores) {
		List<GeInsurancePlan> insurancePlans = geProductMain.getGeInsurancePlans();
		for(GeInsurancePlan plan:insurancePlans){
			this.delete(plan);
		}
		
		for(GeInsurancePlanAccountScore score:geInsurancePlanAccountScores){
			score.setGeInsurancePlan(geInsurancePlans.get(0));
		}
		
		for(GeInsurancePlanAccount account:geInsurancePlanAccounts){
			account.setGeInsurancePlan(geInsurancePlans.get(0));
			account.setCreatetime(new Date());
			account.setOperator(SpringSecurityUtil.getCurrentUserName());
		}
		geInsurancePlans.get(0).setGeInsurancePlanAccounts(geInsurancePlanAccounts);
		geInsurancePlans.get(0).setGeInsurancePlanAccountScores(geInsurancePlanAccountScores);
		geInsurancePlans.get(0).setGeProductMain(geProductMain);
		geProductMain.setGeInsurancePlans(geInsurancePlans);
		//geProductMain.setProductstatus("3"); //3、表示已经详细定义
		
		this.update(geProductMain);
	}

	/**
	 * 方法名称：updateProductMainForOtherConfig<br>
	 * 描述：添加或者更新产品其他属性配置<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月8日下午1:21:29<br>
	 * @see cn.com.sinosoft.product.service.ProductService#updateProductMainForOtherConfig(cn.com.sinosoft.domain.product.GeProductMain, java.util.List, java.lang.String)
	 * @param geProductMain
	 * @param geProductOtherconfigs
	 * @param otherConfigCode
	 */
	@ECSOperator(operator="添加或者更新产品其他属性配置")
	public void updateProductMainForOtherConfig(GeProductMain geProductMain,
			List<GeProductOtherconfig> geProductOtherconfigs,String otherConfigCode) {
		List<GeProductOtherconfig> otherconfigs = geProductMain.getGeProductOtherconfigs();
		for (GeProductOtherconfig otherconfig : otherconfigs) {
			if(otherConfigCode.equals(otherconfig.getOtherconfigcode())){
				this.delete(otherconfig);
			}
		}
		geProductMain.setGeProductOtherconfigs(geProductOtherconfigs);
		List<GeWebflowpage> geWebflowpages = geProductMain.getGeWebflow().getGeWebflowpages();
		List<GeWebflowpageelement> geWebflowpageelements;
		for (GeWebflowpage geWebflowpage : geWebflowpages) {
			geWebflowpageelements = geWebflowpage.getGeWebflowpageelements();
			for (GeWebflowpageelement geWebflowpageelement : geWebflowpageelements) {
				if(otherConfigCode.equals(geWebflowpageelement.getWebflowpageelementcode())){
					geWebflowpageelement.setStatus("1");
				}
			}
		}
		this.update(geProductMain);
	}
	
	/**
	 * 方法名称：updateProductMainForInformbooks<br>
	 * 描述：添加或者更新投保告知<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月10日下午5:11:11<br>
	 * @see cn.com.sinosoft.product.service.ProductService#updateProductMainForInformbooks(cn.com.sinosoft.domain.product.GeProductMain, java.util.List)
	 * @param geProductMain
	 * @param geProductInformbooks
	 */
	@ECSOperator(operator="添加或者更新投保告知")
	public void updateProductMainForInformbooks(GeProductMain geProductMain,
			List<GeProductInformbook> geProductInformbooks) {
		List<GeProductInformbook> informbooks = geProductMain.getGeProductInformbooks();
		for (GeProductInformbook geProductInformbook : informbooks) {
			this.delete(geProductInformbook);
		}
		geProductMain.setGeProductInformbooks(geProductInformbooks);
		List<GeWebflowpage> geWebflowpages = geProductMain.getGeWebflow().getGeWebflowpages();
		List<GeWebflowpageelement> geWebflowpageelements;
		for (GeWebflowpage geWebflowpage : geWebflowpages) {
			geWebflowpageelements = geWebflowpage.getGeWebflowpageelements();
			for (GeWebflowpageelement geWebflowpageelement : geWebflowpageelements) {
				if("TBGZ".equals(geWebflowpageelement.getWebflowpageelementcode())){
					geWebflowpageelement.setStatus("1");
				}
			}
		}
		this.update(geProductMain);
	}
	

	/**
	 * 方法名称: valProductStatus<br>
	 * 描述： (详细定义)编辑每个标签页时校验产品状态，如果是刚发布的，产品状态改为已定制流程
	 * 作者: yuas
	 * 修改日期：2014年1月10日下午7:11:43
	 * @param geProductMain
	 * @return
	 */
	public boolean valProductStatus(GeProductMain geProductMain){
		boolean suc = true;
		try {
			geProductMain = this.geProductMain(geProductMain.getCoreproductcode());
			if(geProductMain.getProductstatus().equals("05")){
				geProductMain.setProductstatus("02");
				geProductMain.setUpdatedate(new Date());
				this.update(geProductMain);
			}
		} catch (Exception e) {
			suc = false;
			e.printStackTrace();
		}
		return suc;
	}

    /**
     * 方法名称：updateProductMainForFxpgwj <br>
     * 描述：更新产品的风险评估问卷信息 <br>
     * 作者：liaojiping <br>
     * 修改日期：2014-1-9下午05:54:41 
     * @see cn.com.sinosoft.product.service.ProductService#updateProductMainForFxpgwj(cn.com.sinosoft.domain.product.GeProductMain, java.util.List, java.util.List, java.util.List) 
     * @param geProductMain
     * @param geRiskSurveys
     * @param geRiskSurveySubject
     * @param geRiskSurveySubjectOption
     */
	public void updateProductMainForFxpgwj(GeProductMain geProductMain,List<GeRiskSurvey> geRiskSurveys,String datas){
		List<GeRiskSurvey> surveys = geProductMain.getGeRiskSurveys();
		List<GeRiskSurvey> oldSurveys = new ArrayList<GeRiskSurvey>(surveys);
		for(GeRiskSurvey survey:oldSurveys){
			surveys.remove(survey);
			this.delete(survey);
		}
		geProductMain.getGeRiskSurveys().clear();
		List<GeRiskSurveySubject> geRiskSurveySubjects = geRiskSurveys.get(0).getGeRiskSurveySubjects();
		for(int i=0;i<geRiskSurveySubjects.size();i++ ){
			GeRiskSurveySubject subject = geRiskSurveySubjects.get(i);
			subject.setGeRiskSurvey(geRiskSurveys.get(0));
			List<GeRiskSurveySubjectOption> options =subject.getGeRiskSurveySubjectOptions();
			for(int j=0;j<options.size();j++){
				options.get(j).setGeRiskSurveySubject(subject);
			}
		}
		
		/*String[] alls = datas.split("@"); //得到所有的题目和选项内容
		List<GeRiskSurveySubject> geRiskSurveySubjects = new ArrayList<GeRiskSurveySubject>();
		for(int i=0;i<alls.length;i++){
			GeRiskSurveySubject geRiskSurveySubject = new GeRiskSurveySubject();
			String[] topics = alls[i].split("[$]");//一个完整的问题和选项
			String[] question = topics[0].split("_");//1  问题名【答否】
			String[] answers =  topics[1].split(",");//A-答案-分值 , B-答案-分值
			List<String[]> answerList = new ArrayList<String[]>();//{[A,答案，分值][B,答案，分值]}
			for(int z=0;z<answers.length;z++){
				String[] answer = answers[z].split("-");//[A,答案，分值]
				answerList.add(answer);
			}
			geRiskSurveySubject.setTopicno(i+1+"");
			geRiskSurveySubject.setTopic(question[1]);
			geRiskSurveySubject.setIsanswer(question[2]);
			List<GeRiskSurveySubjectOption> geRiskSurveySubjectOptions = new ArrayList<GeRiskSurveySubjectOption>();
			for(int j=0;j<answerList.size();j++){
				GeRiskSurveySubjectOption geRiskSurveySubjectOption = new GeRiskSurveySubjectOption();
				geRiskSurveySubjectOption.setSerialo(answerList.get(j)[0]);
				geRiskSurveySubjectOption.setOptioncontent(answerList.get(j)[1]);
				geRiskSurveySubjectOption.setOptionscore(answerList.get(j)[2]);
				geRiskSurveySubjectOption.setGeRiskSurveySubject(geRiskSurveySubject);
				geRiskSurveySubjectOptions.add(geRiskSurveySubjectOption);
			}
			geRiskSurveySubject.setGeRiskSurveySubjectOptions(geRiskSurveySubjectOptions);
			geRiskSurveySubject.setGeRiskSurvey(geRiskSurveys.get(0));
			geRiskSurveySubjects.add(geRiskSurveySubject);
		}*/
		Date date = new Date();
		geRiskSurveys.get(0).setCreatetime(date);
		geRiskSurveys.get(0).setOperator(SpringSecurityUtil.getCurrentUserName());
		geRiskSurveys.get(0).setGeRiskSurveySubjects(geRiskSurveySubjects);
		geRiskSurveys.get(0).setGeProductMain(geProductMain);
		geProductMain.setGeRiskSurveys(geRiskSurveys);
		this.update(geProductMain);
	}
	/**
	 * 方法名称: saveOrUpdatePolicyConfig<br>
	 * 描述：更新保单配置内容
	 * 作者: lihengjun
	 * 修改日期：2014年1月15日下午1:36:54
	 * @param geProductMain
	 * @return
	 */
	@ECSOperator(operator="更新保单配置内容")
	public Map<String, Object> saveOrUpdatePolicyConfig(GeProductMain geProductMain){
		
		
		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("resultCode", "success");	
		try {	
//			this.valProductStatus(geProductMain);
//			String coreproductcode = geProductMain.getCoreproductcode();
//			GeProductMain geProductMainDB =  this.geProductMain(coreproductcode);
//			GeProductApplicantconfig geProductApplicantconfigDB = geProductMainDB.getGeProductApplicantconfig();
//			if(geProductApplicantconfigDB!=null){//判断是已经存在投保人配置
//				BeanUtils.copyProperties(geProductApplicantconfig,geProductApplicantconfigDB, new String[]{"applicantconfigno"});
//			}else{
//				geProductApplicantconfigDB=geProductApplicantconfig;
//			}
//			geProductMainDB.setGeProductApplicantconfig(geProductApplicantconfigDB);
//			geProductApplicantconfigDB.setGeProductMain(geProductMainDB);
//	
//			productService.addProductMain(geProductMainDB);
//			webflowpageelementService.updateGeWebflowpageelementStatus("1",geProductMain.getCoreproductcode(),"bdpz");
		} catch (Exception e) {
			logger.error("保存异常", e);
			result.put("resultCode", "error");
			result.put("resultInfo", "保存异常,请重试");
		}
		
		
		
		return result;
	}
	/**
	 * 方法名称: updateProductInfoConfig<br>
	 * 描述：更新产品信息
	 * 作者: lihengjun
	 * 修改日期：2014年1月14日下午7:30:40
	 * @param geProductMain
	 * @param map
	 * @return
	 */
	@ECSOperator(operator="更新产品基本信息")
	public Map<String, Object> updateProductInfoConfig(GeProductMain geProductMainPage,Map<String, Object> map){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("resultCode", "success");
		try {
			String coreproductcode = geProductMainPage.getCoreproductcode();
			GeProductMain geProductMain = this.geProductMain(coreproductcode);
			//删除缴费年限后保存
			productExtendService.deleteByCoreProduct(coreproductcode);
			List<GeProductExtend> geProductExtends = geProductMainPage.getGeProductExtends();
			for (int i = 0; geProductExtends!=null&&i < geProductExtends.size(); i++) {
				GeProductExtend g = geProductExtends.get(i);
				g.setGeProductMain(geProductMain);
				productExtendService.add(g);
			}
			//删除保险期间后保存
			productExtendPeriodService.deleteByCoreProduct(coreproductcode);
			List<GeProductExtendPeriod> geProductExtendPeriods = geProductMainPage.getGeProductExtendsPeriods();
			for (int i = 0; geProductExtendPeriods!=null&&i < geProductExtendPeriods.size(); i++) {
				GeProductExtendPeriod g = geProductExtendPeriods.get(i);
				if(g!=null){
					g.setGeProductMain(geProductMain);
					productExtendPeriodService.add(g);
				}
			}
			//删除服务区域后保存
			saleAreaService.deleteByCoreProduct(coreproductcode);
			List<GeSaleArea> geSaleAreas = geProductMainPage.getGeSaleAreas();
			for (int i = 0; geSaleAreas!=null&&i < geSaleAreas.size(); i++) {
				GeSaleArea g = geSaleAreas.get(i);
				g.setGeProductMain(geProductMain);
				saleAreaService.add(g);
			}
			
			
			List<String> ignoreProList = this.getIgnoreProperties(map);
			String[] ignoreProperties = new String[ignoreProList.size()];
			//不需要从页面获取的属性值
			ignoreProperties = ignoreProList.toArray(ignoreProperties);
			//从页面中取值复制,忽略一些属性值
			BeanUtils.copyProperties(geProductMainPage, geProductMain, ignoreProperties);
			
			
			
			geProductMain.setUpdatedate(new Date());;
			this.update(geProductMain);
		
		} catch (Exception e) {
			logger.error("保存异常", e);
			result.put("resultCode", "error");
			result.put("resultInfo", "保存异常,请重试");
		}
		return result;
	}
	/**
	 * 方法名称: getIgnoreProperties<br>
	 * 描述：获取 不需要复制的属性名称List
	 * 作者: lihengjun
	 * 修改日期：2014年1月15日上午10:35:41
	 * @param parameterMap
	 * @return
	 */
	private List<String> getIgnoreProperties(Map<String, Object> parameterMap){
		List<String> list = this.getObjectFieldNameList(GeProductMain.class);
		Iterator it = parameterMap.keySet().iterator();
		while(it.hasNext()){
			String key = (String) it.next();
			if(key.startsWith("geProductMain.")){
				String keyField = key.replaceAll("geProductMain.", "");
				for (String fieldName : list) {
					if(keyField.startsWith(fieldName)){//剔除页面请求中的属性名称
						list.remove(fieldName);
						break;
					}
				}
			}
		}
		return list;
	}
	/**
	 * 方法名称: getObjectFieldNameList<br>
	 * 描述：获取类中的 所有属性名称
	 * 作者: lihengjun
	 * 修改日期：2014年1月15日上午10:18:19
	 * @param clazz
	 * @return
	 */
	private List<String> getObjectFieldNameList(Class clazz){
		List<String> list = new ArrayList<String>();
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			list.add(field.getName());
		}
		
		return list;
	}
	
//	QueryRule queryRule = QueryRule.getInstance();
//	queryRule.addEqual("geProductMain.coreProductCode", geProductMain.getCoreProductCode());
//	queryRule.addEqual("attributeKind", "period");
//	List<GeProductAttrAllowValues>  productAttrAllowValueList = geProductAttrAllowValuesService.findPAAValuesList(queryRule);
//	geProductAttrAllowValuesService.deletePAAValuesList(productAttrAllowValueList);
//	geProductAttrAllowValuesService.savePAAValuesList(geProductMain.getGeProductAttrAllowValueses());
//	productManageService.saveDept(geProductMain.getCoreProductCode(),deptidSave);
//	productManageService.configProductDetail(geProductMain);
//	geWebFlowPageElementService.updateGeWebFlowPageElementStatus(geProductMain.getCoreProductCode(),"productInfo");
	

}
