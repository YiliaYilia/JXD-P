/**
 * File Name:ProductAction.java
 * @Description: 
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月31日下午4:59:11
 */
package cn.com.sinosoft.web.system.product;

import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.config.service.AreaService;
import cn.com.sinosoft.config.service.DictDataService;
import cn.com.sinosoft.config.service.DictTypeService;
import cn.com.sinosoft.config.service.GeDepartmentService;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.springsecurity.SpringSecurityUtil;
import cn.com.sinosoft.core.utils.JsonDateValueProcessor;
import cn.com.sinosoft.core.utils.JsonUtils;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.product.GeAddresseeConfig;
import cn.com.sinosoft.domain.product.GeInsurancePlan;
import cn.com.sinosoft.domain.product.GeInsurancePlanAccount;
import cn.com.sinosoft.domain.product.GeInsurancePlanAccountScore;
import cn.com.sinosoft.domain.product.GeProductApplicantconfig;
import cn.com.sinosoft.domain.product.GeProductBeneficiaryconfig;
import cn.com.sinosoft.domain.product.GeProductEmergencyConfig;
import cn.com.sinosoft.domain.product.GeProductInformbook;
import cn.com.sinosoft.domain.product.GeProductInsuredconfig;
import cn.com.sinosoft.domain.product.GeProductMain;
import cn.com.sinosoft.domain.product.GeProductOtherconfig;
import cn.com.sinosoft.domain.product.GeProductflowPage;
import cn.com.sinosoft.domain.product.GeProductflowdefine;
import cn.com.sinosoft.domain.product.GeSaleArea;
import cn.com.sinosoft.domain.product.GeRiskSurvey;
import cn.com.sinosoft.domain.product.GeRiskSurveySubject;
import cn.com.sinosoft.domain.product.GeRiskSurveySubjectOption;
import cn.com.sinosoft.domain.product.GeWebflow;
import cn.com.sinosoft.domain.product.GeWebflowpage;
import cn.com.sinosoft.domain.product.GeWebflowpageelement;
import cn.com.sinosoft.domain.system.GeArea;
import cn.com.sinosoft.domain.system.GeDepartment;
import cn.com.sinosoft.domain.system.GeDictData;
import cn.com.sinosoft.domain.system.GeDictType;
import cn.com.sinosoft.dto.product.InforBooks;
import cn.com.sinosoft.dto.product.InforBooks.InforBook;
import cn.com.sinosoft.dto.product.OccupationTree;
import cn.com.sinosoft.dto.product.ProductMainDto;
import cn.com.sinosoft.dto.system.AreaTree;
import cn.com.sinosoft.dto.system.OrganTree;
import cn.com.sinosoft.product.service.OccupationService;
import cn.com.sinosoft.product.service.ProInsuredOccupationService;
import cn.com.sinosoft.product.service.ProductFlowDefineService;
import cn.com.sinosoft.product.service.ProductFlowPageElementDefineService;
import cn.com.sinosoft.product.service.ProductService;
import cn.com.sinosoft.product.service.WebflowpageelementService;

/**描述：<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月31日下午4:59:11 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class ProductAction extends Struts2Action{
	private static final Logger logger = Logger.getLogger(ProductAction.class);
	@Autowired
	private ProductFlowDefineService flowDefineService;
	@Autowired
	private ProductService productService;
	@Autowired
	private DictDataService dictDataService;
	@Autowired
	private ProductFlowPageElementDefineService pageElementDefineService;
	@Autowired
	private WebflowpageelementService webflowpageelementService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private OccupationService occupationService;
	@Autowired
	private ProInsuredOccupationService proInsuredOccupationService;
	@Autowired
	private GeDepartmentService geDepartmentService;
	
	private List<GeInsurancePlan> geInsurancePlans;
	private List<GeInsurancePlanAccount> geInsurancePlanAccounts;
	private List<GeInsurancePlanAccountScore> geInsurancePlanAccountScores;
	
	//投保告知
	private List<GeProductInformbook> geProductInformbooks;
	
	private GeProductMain geProductMain;
	private GeProductOtherconfig geProductOtherconfig;
	private GeProductInformbook geProductInformbook;
	//投保人配置信息表
	private GeProductApplicantconfig geProductApplicantconfig;
	@Autowired
	private DictTypeService dictTypeService;
	//被保人配置信息表
	private GeProductInsuredconfig geProductInsuredconfig;
	//受益人配置信息表
	private GeProductBeneficiaryconfig geProductBeneficiaryconfig;
	//紧急联系人配置信息表
	private GeProductEmergencyConfig geProductEmergencyConfig;
	//收件人（包含地址信息）配置信息表
	private GeAddresseeConfig geAddresseeConfig;
	//机构信息
	private List<GeDepartment> geDepartments;
	/**
	 * 服务地区
	 */
	private List<GeSaleArea> geSaleAreas;
	//产品编码List
	private List<String> productCodes;
	
	

	private List<GeRiskSurvey> geRiskSurveys;
	private List<GeRiskSurveySubject> geRiskSurveySubject;
	private List<GeRiskSurveySubjectOption> geRiskSurveySubjectOption;
	/**
	 * 方法名称: jumpProductListPage<br>
	 * 描述：跳转到产品列表页面
	 * 作者: honghui
	 * 修改日期：2013年12月31日下午5:01:28
	 */
	@Action(value="productList")
	public String jumpProductListPage(){
		return "/page/productList";
	}
	
	/**
	 * 方法名称: getProductListData<br>
	 * 描述：获取茶品列表数据
	 * 作者: honghui
	 * 修改日期：2014年1月2日下午1:55:22
	 */
	@Action(value="getProductListData")
	public void getProductListData(){
		Page<GeProductMain> productPage = productService.getProductMainByPage(geProductMain, page, rows);
		Map<String, Object> map = new HashMap<String, Object>();
		List<GeProductMain> geProductMains = productPage.getData();
		List<ProductMainDto> productMainDtos = new ArrayList<ProductMainDto>(); 
		for(GeProductMain productMain:geProductMains){
			ProductMainDto productMainDto = new ProductMainDto();
			BeanUtils.copyProperties(productMain, productMainDto);
			productMainDtos.add(productMainDto);
		}
		map.put("total", productPage.getTotal());
		map.put("rows", productMainDtos);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss")); 
		renderJson(JsonUtils.convertObject(map,jsonConfig));
	}
	
	/**
	 * 方法名称: deleteProduct<br>
	 * 描述：删除产品信息，相关配置信息
	 * 作者: yuas
	 * 修改日期：2014年1月15日下午5:08:00
	 */
	@Action(value="deleteProduct")
	public void deleteProduct(){
		if(productCodes != null && productCodes.size() > 0){
			for(String productcode : productCodes){
				productService.deleteProduct(productcode);
			}
		}
	}

	/**
	 * 方法名称: jumpProductADDUpdatePage<br>
	 * 描述：跳转到产品添加或者修改操作页面
	 * 作者: honghui
	 * 修改日期：2014年1月2日下午12:20:51
	 * @return
	 */
	@Action(value="productAddUpdateOperator")
	public String jumpProductADDUpdatePage(){
		List<GeProductflowdefine> productflowdefines = flowDefineService.getGeProductflowdefines();
		if("ADD".equalsIgnoreCase(this.getParameter("operate"))){
			
		}
		else{
			GeProductMain product = productService.geProductMain(geProductMain.getCoreproductcode());
			this.setRequestAttribute("geProduct", product);
		}
		
		this.setRequestAttribute("productflowdefines", productflowdefines);
		this.setRequestAttribute("operate", this.getParameter("operate"));
		return "/page/productAddUpdate";
	}
	@Action(value="existProduct")
	public void existProduct(){
		GeProductMain product = productService.geProductMain(geProductMain.getCoreproductcode());
		Map<String, String> result = new HashMap<String, String>();
		if("ADD".equals(getHttpServletRequest().getParameter("operate"))){
			 
			if(product != null){ //存在
				result.put("error", "编号已经存在");
			}
			else{//不存在
				result.put("ok", "");
			}
		}
		else{
			result.put("ok", "");
		}
		
		renderText(JSONObject.fromObject(result).toString());
	}
	/**
	 * 方法名称: doProductADDUpdate<br>
	 * 描述：处理添加或者修改产品
	 * 作者: honghui
	 * 修改日期：2014年1月2日下午1:42:05
	 */
	@Action(value="doProductADDUpdate")
	public void doProductADDUpdate(){
		String operateType = this.getParameter("operate");
		if("ADD".equalsIgnoreCase(operateType)){ //添加操作
			geProductMain.setCreatedate(new Date());
			geProductMain.setUpdatedate(new Date());
			geProductMain.setOperatorname(SpringSecurityUtil.getCurrentUserName());
			geProductMain.setProductstatus("1"); //1、表示已创建 可以查看数据字典
			
			GeProductflowdefine geProductflowdefine = flowDefineService.getGeProductflowdefine(geProductMain.getProductflow());
			List<GeProductflowPage> geProductflowPages = geProductflowdefine.getGeProductflowPages(); //获取该流程有哪些页面
			
			GeWebflow geWebflow = new GeWebflow();
			geWebflow.setUpdatetime(new Date());
			geWebflow.setCreatetime(new Date());
			geWebflow.setFlowname(geProductflowdefine.getProductflowname());
			geWebflow.setWebflowcode(geProductflowdefine.getProductflowdefineno());
			for(GeProductflowPage page:geProductflowPages){
				GeWebflowpage geWebflowpage = new GeWebflowpage();
				geWebflowpage.setCreatetime(new Date());
				geWebflowpage.setSeqindex(page.getDefaultseqindex());
				geWebflowpage.setUpdatetime(new Date());
				geWebflowpage.setWebflowpagecode(page.getGeProductflowpagedefine().getProductflowpagedefineno());
				geWebflowpage.setPagename(page.getGeProductflowpagedefine().getPagename());
				geWebflowpage.setGeWebflow(geWebflow);
				geWebflow.getGeWebflowpages().add(geWebflowpage);
			}
			
			geWebflow.setGeProductMain(geProductMain);
			geProductMain.setGeWebflow(geWebflow);
			productService.addProductMain(geProductMain);
		}
		else{//修改操作
			GeProductMain product = productService.geProductMain(geProductMain.getCoreproductcode());
			product.setProductname(geProductMain.getProductname());
			product.setCoreproductsimplename(geProductMain.getCoreproductsimplename());
			productService.updateProductMain(product);
		}
		renderText("SUCCESS");
	}

	/**
	 * 方法名称: jumpProductFlowConfig<br>
	 * 描述：跳转到产品流程定制页面
	 * 作者: honghui
	 * 修改日期：2014年1月2日下午4:55:47
	 * @return
	 */
	@Action(value="productFlowConfig")
	public String jumpProductFlowConfig(){
		String coreproductcode = this.getParameter("coreproductcode");
		GeProductMain geProductMain =  productService.geProductMain(coreproductcode);
		GeProductflowdefine geProductflowdefine = flowDefineService.getGeProductflowdefine(geProductMain.getProductflow());
		this.setRequestAttribute("geProductflowdefine", geProductflowdefine);
		this.setRequestAttribute("coreproductcode", coreproductcode);
		this.setRequestAttribute("geProductMain", geProductMain);
		return "/page/productFlowConfig";
	}
	
	/**
	 * 方法名称: doProductFlowConfig<br>
	 * 描述：处理产品配置流程
	 * 作者: honghui
	 * 修改日期：2014年1月5日下午3:01:37
	 */
	@Action(value="doProductFlowConfig")
	public void doProductFlowConfig(){
		String config = this.getParameter("config");
		String coreproductcode = this.getParameter("coreproductcode");
		GeProductMain geProductMain =  productService.geProductMain(coreproductcode);
		geProductMain.setProductstatus("2"); //2、表示已定制 可以查看数据字典
		productService.updateProductMainFlowElement(geProductMain,config);
		renderText("SUCCESS");
	}
	
	/**
	 * 方法名称: jumpProdouctInfoConfig<br>
	 * 描述：跳转到产品详情配置页面
	 * 作者: honghui
	 * 修改日期：2014年1月5日下午8:42:52
	 * @return
	 */
	@Action(value="prodouctInfoConfig")
	public String jumpProdouctInfoConfig(){
		String coreproductcode = this.getParameter("coreproductcode");
		GeProductMain geProductMain =  productService.geProductMain(coreproductcode);
		List<GeWebflowpage> geWebflowpages = geProductMain.getGeWebflow().getGeWebflowpages();
		Map<String, GeWebflowpageelement> map = new HashMap<String, GeWebflowpageelement>();
		for(GeWebflowpage geWebflowpage:geWebflowpages){
			List<GeWebflowpageelement> geWebflowpageelements = geWebflowpage.getGeWebflowpageelements();
			for(GeWebflowpageelement element:geWebflowpageelements){
				if(!map.containsKey(element.getWebflowpageelementcode())){
					map.put(element.getWebflowpageelementcode(), element);
				}
			}
		}
		this.setRequestAttribute("elements", map.values());
		this.setRequestAttribute("geProductMain", geProductMain);
		return "/page/elements";
	}
	
	
	public void convertTree(GeArea geArea,AreaTree areaTree){
		List<GeArea> childs = geArea.getChilds();
		if(childs.size()>0){
			for(GeArea area:childs){
				AreaTree tree = new AreaTree();
				tree.setId(area.getGid());//主Id
				tree.setParentId(area.getParentArea().getGid());//从Id
				tree.setText(area.getGname());
				tree.setCheckbox(true);
				String gid = area.getGid();
				if(area.getChilds().size()>0){
					tree.setState("closed"); 
				}else{
					tree.setState("open");
				}
				
				BeanUtils.copyProperties(area, tree,new String[]{"pgid","parentArea","childs"});
				tree.setParentId(area.getParentArea().getGid());
				tree.setPgid(area.getParentArea().getGid());
				areaTree.getChildren().add(tree);
				convertTree(area,tree);
			}
		
		}
	}
	/**
	 * 方法名称: jumpProductBaseInfo<br>
	 * 描述：跳转到产品详细配置
	 * 作者: honghui
	 * 修改日期：2014年1月6日上午10:14:37
	 * @return
	 */
	@Action(value="productBaseInfo")
	public String jumpProductBaseInfo(){
		String coreproductcode = this.getParameter("coreproductcode");
		GeProductMain geProductMain =  productService.geProductMain(coreproductcode);
		this.setRequestAttribute("geProductMain", geProductMain);
		this.setRequestAttribute("peroidList", geProductMain.getGeProductExtends());
		this.setRequestAttribute("peroidList2", geProductMain.getGeProductExtendsPeriods());
		
		return "/page/elements/productBaseInfo";
	}
	/**
	 * 方法名称: getSaleAreaTree<br>
	 * 描述：根据产品代码加载服务地区树
	 * 作者: lihengjun
	 * 修改日期：2014年1月15日下午3:28:12
	 * @return
	 */
	@Action("getSaleAreaTree")
	public String getSaleAreaTree(){
		
		geProductMain =  productService.geProductMain(geProductMain.getCoreproductcode());
		List<GeSaleArea> geSaleAreas = geProductMain.getGeSaleAreas();
		
		List<GeDepartment> geDepartments = geDepartmentService.fingByOrganType("sarea"); //机构类型：服务区域
		
		List<OrganTree> organTrees = new ArrayList<OrganTree>();
		for (GeDepartment geDepartment : geDepartments) {
			OrganTree tree = new OrganTree();
			if(geSaleAreas != null && geSaleAreas.size() > 0){
				for(GeSaleArea geSaleArea : geSaleAreas){
					if(geSaleArea.getGid().equals(geDepartment.getDeptid())){
						tree.setChecked(true);
						geSaleAreas.remove(geSaleArea);
						break;
					}
				}
			}
			tree.setId(geDepartment.getDeptid());
			tree.setDeptCode(geDepartment.getDeptCode());
			tree.setParentId(geDepartment.getParentid());
			tree.setText(geDepartment.getDeptname());
			tree.setDeptid(geDepartment.getDeptid());
			tree.setDeptname(geDepartment.getDeptname());
			tree.setOrganType(geDepartment.getOrganType());
			tree.setContactAddress(geDepartment.getContactAddress());
			tree.setOfficePhone(geDepartment.getOfficePhone());
			tree.setZipCode(geDepartment.getZipCode());
			tree.setRoot(geDepartment.getRoot());
			OrganTree.Attribute attr = new OrganTree.Attribute();
			attr.setGid(geDepartment.getDeptid());
			attr.setGname(geDepartment.getDeptname());
			attr.setPgid(geDepartment.getParentid());
			attr.setNote("");
			
			tree.setAttributes(attr);
			organTrees.add(tree);
		}
		renderJson(JSONArray.fromObject(organTrees).toString());	
		return null;
	}
	/**
	 * 方法名称: jumpBfss<br>
	 * 描述：保费试算
	 * 作者: honghui
	 * 修改日期：2014年1月6日上午10:15:28
	 * @return
	 */
	@Action(value="bfss")
	public String jumpBfss(){
		String coreproductcode = this.getParameter("coreproductcode");
		String elementcode = this.getParameter("elementcode");
		GeProductMain geProductMain =  productService.geProductMain(coreproductcode);
		List<GeProductOtherconfig> otherconfigs = geProductMain.getGeProductOtherconfigs();
		for (GeProductOtherconfig otherconfig : otherconfigs) {
			if(elementcode.equals(otherconfig.getOtherconfigcode())){
				geProductOtherconfig = otherconfig;
			}
		}
		this.setRequestAttribute("geProductMain", geProductMain);
		this.setRequestAttribute("geProductOtherconfig", geProductOtherconfig);
		return "/page/elements/bfss";
	}
	
	/**
	 * 方法名称: jumpFxpgwj<br>
	 * 描述：跳转到风险评估问卷
	 * 作者: honghui
	 * 修改日期：2014年1月6日上午10:16:13
	 * @return
	 */
	@Action(value="fxpgwj")
	public String jumpFxpgwj(){
		String coreproductcode = this.getParameter("coreproductcode");
		GeProductMain geProductMain =  productService.geProductMain(coreproductcode);
		this.setRequestAttribute("geProductMain", geProductMain);
		return "/page/elements/fxpgwj";
	}
	
	/**
	 * 方法名称: doFxpgwj<br>
	 * 描述：保存风险评估问卷信息
	 * 作者: liaojiping
	 * 修改日期：2014-1-9下午05:47:48
	 */
	@Action(value="doFxpgwj")
	public void doFxpgwj(){
		String coreproductcode = this.getParameter("coreproductcode");
		GeProductMain geProductMain =  productService.geProductMain(coreproductcode);
		HttpServletRequest request = ServletActionContext.getRequest();
		String datas=request.getParameter("data");
		productService.updateProductMainForFxpgwj(geProductMain,geRiskSurveys,datas);
	//	productService.updateProductMainForFxpgwj(geProductMain, geRiskSurvey, geRiskSurveySubject, geRiskSurveySubjectOption);
		renderText("SUCCESS");
	}
	/**
	 * 方法名称: jumpBxjh<br>
	 * 描述：跳转到保险计划
	 * 作者: honghui
	 * 修改日期：2014年1月6日上午10:16:46
	 * @return
	 */
	@Action(value="bxjh")
	public String jumpBxjh(){
		String coreproductcode = this.getParameter("coreproductcode");
		GeProductMain geProductMain =  productService.geProductMain(coreproductcode);
		this.setRequestAttribute("geProductMain", geProductMain);
		return "/page/elements/bxjh";
	}
	
	@Action(value="doBxjh")
	public void doBxjh(){
		String coreproductcode = this.getParameter("coreproductcode");
		GeProductMain geProductMain =  productService.geProductMain(coreproductcode);
		productService.updateProductMainForBXJH(geProductMain,geInsurancePlans,geInsurancePlanAccounts,geInsurancePlanAccountScores );
		renderText("SUCCESS");
	}
	
	/**
	 * 方法名称: jumpBdpz<br>
	 * 描述：跳转到保单配置
	 * 作者: honghui
	 * 修改日期：2014年1月6日上午10:17:23
	 * @return
	 */
	@Action(value="bdpz")
	public String jumpBdpz(){
		String coreproductcode = this.getParameter("coreproductcode");
		GeProductMain geProductMain =  productService.geProductMain(coreproductcode);
		//投保人,被保人,受益人 配置项
		GeProductApplicantconfig geProductApplicantconfig = geProductMain.getGeProductApplicantconfig();
		GeProductInsuredconfig geProductInsuredconfig = geProductMain.getGeProductInsuredconfig();
		GeProductBeneficiaryconfig geProductBeneficiaryconfig = geProductMain.getGeProductBeneficiaryconfig();
		//投保人,被保人,受益人 配置项的map
		Map<String, Object>  geProductApplicantconfigMap = new HashMap<String, Object>();
		Map<String, Object>  geProductInsuredconfigMap = new HashMap<String, Object>();
		Map<String, Object>  geProductBeneficiaryconfigMap = new HashMap<String, Object>();
		//获取保单配置 基本配置
		List<GeDictData> policyApplicantConfigBaseInfoList = this.getPolicyConfigBaseInfoList("ApplicantconfigInfoTYPE");
		List<GeDictData> policyInsuredConfigBaseInfoList = this.getPolicyConfigBaseInfoList("InsuredconfigInfoTYPE");
		List<GeDictData> policyBeneficiaryConfigBaseInfoList = this.getPolicyConfigBaseInfoList("BeneficiaryconfigInfoTYPE");
		
		try {
			if(geProductApplicantconfig!=null){
				geProductApplicantconfigMap = PropertyUtils.describe(geProductApplicantconfig);
			}
			if(geProductInsuredconfig!=null){
				geProductInsuredconfigMap = PropertyUtils.describe(geProductInsuredconfig);
			}
			if(geProductBeneficiaryconfig!=null){
				geProductBeneficiaryconfigMap = PropertyUtils.describe(geProductBeneficiaryconfig);
			}
			System.err.println("geProductBeneficiaryconfigMap=\n"+geProductBeneficiaryconfigMap);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
		
		GeAddresseeConfig geAddresseeConfig = geProductMain.getGeAddresseeConfig();
		GeProductEmergencyConfig geProductEmergencyConfig = geProductMain.getGeProductEmergencyConfig();
		this.setRequestAttribute("geProductMain", geProductMain);
		this.setRequestAttribute("geProductApplicantconfig", geProductApplicantconfig);
		this.setRequestAttribute("geProductInsuredconfig", geProductInsuredconfig);
		this.setRequestAttribute("geProductBeneficiaryconfig", geProductBeneficiaryconfig);
		this.setRequestAttribute("policyApplicantConfigBaseInfoList", policyApplicantConfigBaseInfoList);
		this.setRequestAttribute("policyInsuredConfigBaseInfoList", policyInsuredConfigBaseInfoList);
		this.setRequestAttribute("policyBeneficiaryConfigBaseInfoList", policyBeneficiaryConfigBaseInfoList);
		this.setRequestAttribute("geProductBeneficiaryconfigMap", geProductBeneficiaryconfigMap);
		this.setRequestAttribute("geProductInsuredconfigMap", geProductInsuredconfigMap);
		this.setRequestAttribute("geProductApplicantconfigMap", geProductApplicantconfigMap);
		
		this.setRequestAttribute("geAddresseeConfigDB", geAddresseeConfig);
		this.setRequestAttribute("geProductEmergencyConfigDB", geProductEmergencyConfig);
		
		return "/page/elements/bdpz";
	}
	/**
	 * 方法名称: saveApplicantConfig<br>
	 * 描述：保存投保人配置信息
	 * 作者: ljd
	 * 修改日期：2014年1月8日下午1:31:08
	 * @return
	 */
	@Action(value="saveOrUpdateApplicantConfig")
	public void saveOrUpdateApplicantConfig(){
		Map<String, String> result = new HashMap<String, String>();
		result.put("resultCode", "success");	
		try {	
			productService.valProductStatus(geProductMain);
			String coreproductcode = this.getParameter("coreproductcode");
			GeProductMain geProductMainDB =  productService.geProductMain(coreproductcode);
			GeProductApplicantconfig geProductApplicantconfigDB = geProductMainDB.getGeProductApplicantconfig();
			if(geProductApplicantconfigDB!=null){//判断是已经存在投保人配置
				BeanUtils.copyProperties(geProductApplicantconfig,geProductApplicantconfigDB, new String[]{"applicantconfigno"});
			}else{
				geProductApplicantconfigDB=geProductApplicantconfig;
			}
			geProductMainDB.setGeProductApplicantconfig(geProductApplicantconfigDB);
			geProductApplicantconfigDB.setGeProductMain(geProductMainDB);
	
			productService.addProductMain(geProductMainDB);
			webflowpageelementService.updateGeWebflowpageelementStatus("1",geProductMain.getCoreproductcode(),"bdpz");
		} catch (Exception e) {
			logger.error("保存异常", e);
			result.put("resultCode", "error");
			result.put("resultInfo", "保存异常,请重试");
		}
		renderJson(JsonUtils.convertObject(result));
		
	}	
	
	
	/**
	 * 方法名称: saveInsuredConfig<br>
	 * 描述：保存被保人配置信息
	 * 作者: ljd
	 * 修改日期：2014年1月8日下午3:01:28
	 */
	@Action(value="saveOrUpdateInsuredConfig")
	public void saveOrUpdateInsuredConfig(){
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("resultCode", "success");	
		String coreproductcode = this.getParameter("coreproductcode");
		try {	
			productService.valProductStatus(geProductMain);
			
			GeProductMain geProductMainDB =  productService.geProductMain(coreproductcode);
			GeProductInsuredconfig geProductInsuredconfigDB = geProductMainDB.getGeProductInsuredconfig();
			//先删除原有职业,再保存新的职业信息
			proInsuredOccupationService.addAfterDelete(geProductInsuredconfigDB, geProductInsuredconfig);
			
			if(geProductInsuredconfigDB!=null){//判断是已经存在被保人配置
				BeanUtils.copyProperties(geProductInsuredconfig,geProductInsuredconfigDB, new String[]{"insuredconfigno"});
			}else{
				geProductInsuredconfigDB=geProductInsuredconfig;
			}
			geProductMainDB.setGeProductInsuredconfig(geProductInsuredconfigDB);
			geProductInsuredconfigDB.setGeProductMain(geProductMainDB);
			productService.addProductMain(geProductMainDB);
			webflowpageelementService.updateGeWebflowpageelementStatus("1",geProductMain.getCoreproductcode(),"bdpz");
		} catch (Exception e) {
			logger.error("保存异常", e);
			result.put("resultCode", "error");
			result.put("resultInfo", "保存异常,请重试");
		}
		renderJson(JsonUtils.convertObject(result));		
		
	}	
	
	
	
	/**
	 * 方法名称: saveEmergencyConfig<br>
	 * 描述：保存紧急联系人配置信息
	 * 作者: ljd
	 * 修改日期：2014年1月8日下午3:02:22
	 */
	@Action(value="saveOrUpdateEmergencyConfig")
	public void saveOrUpdateEmergencyConfig(){
		Map<String, String> result = new HashMap<String, String>();
		result.put("resultCode", "success");	
		try {	
			productService.valProductStatus(geProductMain);
			String coreproductcode = this.getParameter("coreproductcode");
			GeProductMain geProductMainDB =  productService.geProductMain(coreproductcode);
			GeProductEmergencyConfig geProductEmergencyConfigDB = geProductMainDB.getGeProductEmergencyConfig();
			if(geProductEmergencyConfigDB!=null){//判断是已经存在紧急联系人配置
				BeanUtils.copyProperties(geProductEmergencyConfig,geProductEmergencyConfigDB , new String[]{"emergencyconfigno","geProductMain"});
			}else{
				geProductEmergencyConfigDB=geProductEmergencyConfig;
			}
			geProductMainDB.setGeProductEmergencyConfig(geProductEmergencyConfigDB);
			geProductEmergencyConfigDB.setGeProductMain(geProductMainDB);
			productService.addProductMain(geProductMainDB);
			webflowpageelementService.updateGeWebflowpageelementStatus("1",geProductMain.getCoreproductcode(),"bdpz");
		} catch (Exception e) {
			logger.error("保存异常", e);
			result.put("resultCode", "error");
			result.put("resultInfo", "保存异常,请重试");
		}
		renderJson(JsonUtils.convertObject(result));		
		
	}	
	
	
	/**
	 * 方法名称: saveAddresseeConfig<br>
	 * 描述：保存收件人配置信息
	 * 作者: ljd
	 * 修改日期：2014年1月8日下午3:02:47
	 */
	@Action(value="saveOrUpdateAddresseeConfig")
	public void saveOrUpdateAddresseeConfig(){
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("resultCode", "success");	
		try {	
			productService.valProductStatus(geProductMain);
			String coreproductcode = this.getParameter("coreproductcode");
			GeProductMain geProductMainDB =  productService.geProductMain(coreproductcode);
			GeAddresseeConfig geAddresseeConfigDB = geProductMainDB.getGeAddresseeConfig();
			if(geAddresseeConfigDB!=null){//判断是已经存在收件人配置
				BeanUtils.copyProperties(geAddresseeConfig,geAddresseeConfigDB, new String[]{"addresseeconfigno","geProductMain"});
			}else{
				geAddresseeConfigDB=geAddresseeConfig;
			}
			geProductMainDB.setGeAddresseeConfig(geAddresseeConfigDB);
			geAddresseeConfigDB.setGeProductMain(geProductMainDB);
			productService.addProductMain(geProductMainDB);
			webflowpageelementService.updateGeWebflowpageelementStatus("1",geProductMain.getCoreproductcode(),"bdpz");
		} catch (Exception e) {
			logger.error("保存异常", e);
			result.put("resultCode", "error");
			result.put("resultInfo", "保存异常,请重试");
		}
		renderJson(JsonUtils.convertObject(result));		
		
	}
	
	/**
	 * 方法名称: jumpFlsm<br>
	 * 描述：跳转到法律声明
	 * 作者: honghui
	 * 修改日期：2014年1月6日上午10:17:59
	 * @return
	 */
	@Action(value="flsm")
	public String jumpFlsm(){
		String coreproductcode = this.getParameter("coreproductcode");
		String elementcode = this.getParameter("elementcode");
		GeProductMain geProductMain =  productService.geProductMain(coreproductcode);
		List<GeProductOtherconfig> otherconfigs = geProductMain.getGeProductOtherconfigs();
		for (GeProductOtherconfig otherconfig : otherconfigs) {
			if(elementcode.equals(otherconfig.getOtherconfigcode())){
				geProductOtherconfig = otherconfig;
			}
		}
		this.setRequestAttribute("geProductMain", geProductMain);
		this.setRequestAttribute("geProductOtherconfig", geProductOtherconfig);
		return "/page/elements/flsm";
	}
	
	/**
	 * 方法名称：saveOtherConfig<br>
	 * 描述：保存产品其他配置（法律声明，投保声明）<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月8日下午4:01:13<br>
	 */
	@Action(value="saveOtherConfig")
	public void saveOtherConfig(){
		try {
			PrintWriter writer = this.getHttpServletResponse().getWriter();
			try {
				String coreproductcode = this.getParameter("coreproductcode");
				GeProductMain geProductMain =  productService.geProductMain(coreproductcode);
				geProductOtherconfig.setGeProductMain(geProductMain);
				List<GeProductOtherconfig> geProductOtherconfigs = new ArrayList<GeProductOtherconfig>();
				geProductOtherconfigs.add(geProductOtherconfig);
				productService.updateProductMainForOtherConfig(geProductMain, geProductOtherconfigs, geProductOtherconfig.getOtherconfigcode());
				writer.print("<script type='text/javascript' type='language'>window.parent.message(true);</script>");
			} catch (Exception e) {
				logger.error(e);
				writer.print("<script type='text/javascript' type='language'>window.parent.message(false);</script>");
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	/**
	 * 方法名称: jumpTbgz<br>
	 * 描述：跳转到投保告知
	 * 作者: honghui
	 * 修改日期：2014年1月6日上午10:18:33
	 * @return
	 */
	@Action(value="tbgz")
	public String jumpTbgz(){
		String coreproductcode = this.getParameter("coreproductcode");
		this.setRequestAttribute("coreproductcode", coreproductcode);
		return "/page/elements/tbgz";
	}
	
	/**
	 * 方法名称：getTbgz<br>
	 * 描述：获得投保告知项<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月9日下午4:59:38<br>
	 */
	@Action(value="getTbgz")
	public void getTbgz(){
		String coreproductcode = this.getParameter("coreproductcode");
		GeProductMain geProductMain =  productService.geProductMain(coreproductcode);
		List<GeProductInformbook> geProductInformbooks = geProductMain.getGeProductInformbooks();
		//按照显示顺序排序
		Collections.sort(geProductInformbooks, new Comparator<GeProductInformbook>() {
			public int compare(GeProductInformbook o1, GeProductInformbook o2) {
				return o1.getInformorder().compareTo(o2.getInformorder());
			}
        });
		
		InforBooks inforBooks = new InforBooks();
		inforBooks.setTotal(geProductInformbooks.size()+"");
		List<InforBook> books = new ArrayList<InforBooks.InforBook>();
		for (GeProductInformbook geProductInformbook : geProductInformbooks) {
			InforBook inforBook = new InforBook();
			BeanUtils.copyProperties(geProductInformbook, inforBook);
			books.add(inforBook);
		}
		inforBooks.setRows(books);
		String result = JSONObject.fromObject(inforBooks).toString();
		super.render(result, "text/json;charset=UTF-8");
	}
	
	/**
	 * 方法名称：jumpTbgzEdit<br>
	 * 描述：跳转到投保告知项编辑页<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月10日下午3:28:32<br>
	 * @return
	 */
	@Action(value="tbgzEdit")
	public String jumpTbgzEdit(){
		String count = this.getParameter("count");
		String operate = this.getParameter("operate");
		if(geProductInformbook == null){
			geProductInformbook = new GeProductInformbook();
			geProductInformbook.setInformcontent("");
			geProductInformbook.setInformoption("N");
			geProductInformbook.setInformorder(count);
		}
		this.setRequestAttribute("geProductInformbook", geProductInformbook);
		this.setRequestAttribute("count", count);
		this.setRequestAttribute("operate", operate);
		return "/page/elements/tbgzEdit";
	}
	
	/**
	 * 方法名称：saveTbgz<br>
	 * 描述：保存投保告知项<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月9日下午6:17:43<br>
	 */
	@Action(value="saveTbgz")
	public void saveTbgz(){
		String coreproductcode = this.getParameter("coreproductcode");
		GeProductMain geProductMain =  productService.geProductMain(coreproductcode);
		if(geProductInformbooks == null){
			geProductInformbooks = new ArrayList<GeProductInformbook>();
		}
		for (GeProductInformbook informbook : geProductInformbooks) {
			informbook.setGeProductMain(geProductMain);
		}
		productService.updateProductMainForInformbooks(geProductMain, geProductInformbooks);
		renderText("SUCCESS");
	}
	
	/**
	 * 方法名称: jumpTbsm<br>
	 * 描述：跳转到投保声明
	 * 作者: honghui
	 * 修改日期：2014年1月6日上午10:19:01
	 * @return
	 */
	@Action(value="tbsm")
	public String jumpTbsm(){
		String coreproductcode = this.getParameter("coreproductcode");
		String elementcode = this.getParameter("elementcode");
		GeProductMain geProductMain =  productService.geProductMain(coreproductcode);
		List<GeProductOtherconfig> otherconfigs = geProductMain.getGeProductOtherconfigs();
		for (GeProductOtherconfig otherconfig : otherconfigs) {
			if(elementcode.equals(otherconfig.getOtherconfigcode())){
				geProductOtherconfig = otherconfig;
			}
		}
		this.setRequestAttribute("geProductMain", geProductMain);
		this.setRequestAttribute("geProductOtherconfig", geProductOtherconfig);
		return "/page/elements/tbsm";
	}
	
	/**
	 * 方法名称: jumpZl<br>
	 * 描述：跳转到总览
	 * 作者: honghui
	 * 修改日期：2014年1月6日上午10:19:38
	 * @return
	 */
	@Action(value="zl")
	public String jumpZl(){
		String coreproductcode = this.getParameter("coreproductcode");
		GeProductMain geProductMain =  productService.geProductMain(coreproductcode);
		this.setRequestAttribute("geProductMain", geProductMain);
		return "/page/elements/zl";
	}
	
	
	/**
	 * 方法名称: saveOrUpdateBeneficiaryConfig<br>
	 * 描述：新增或者
	 * 作者: lihengjun
	 * 修改日期：2014年1月8日下午4:22:31
	 * @return
	 */
	@Action("saveOrUpdateBeneficiaryConfig")
	public String saveOrUpdateBeneficiaryConfig(){
		Map<String, String> result = new HashMap<String, String>();
		result.put("resultCode", "success");
		try {
			productService.valProductStatus(geProductMain);
			String coreproductcode = this.getParameter("coreproductcode");
			GeProductMain geProductMainDB =  productService.geProductMain(coreproductcode);
			GeProductBeneficiaryconfig geProductBeneficiaryconfigDB = geProductMainDB.getGeProductBeneficiaryconfig();
			if(geProductBeneficiaryconfigDB!=null){//判断是已经存在被保人配置
				BeanUtils.copyProperties(geProductBeneficiaryconfig,geProductBeneficiaryconfigDB, new String[]{"beneficiaryconfigno","geProductMain"});
			}else{
				geProductBeneficiaryconfigDB = geProductBeneficiaryconfig;
			}
			geProductMainDB.setGeProductBeneficiaryconfig(geProductBeneficiaryconfigDB);;
			geProductBeneficiaryconfigDB.setGeProductMain(geProductMainDB);
			
			productService.addProductMain(geProductMainDB);
			webflowpageelementService.updateGeWebflowpageelementStatus("1",geProductMain.getCoreproductcode(),"bdpz");
		} catch (Exception e) {
			logger.error("保存异常", e);
			result.put("resultCode", "error");
			result.put("resultInfo", "保存异常,请重试");
		}
		
		renderJson(JsonUtils.convertObject(result));		
		return null;
	}
	
	/**
	 * 方法名称: getPolicyConfigBaseInfoList<br>
	 * 描述：获取数据字典中 保单配置基本信息
	 * 作者: lihengjun
	 * 修改日期：2014年1月8日下午2:24:51
	 * @return
	 */
	private List<GeDictData> getPolicyConfigBaseInfoList(String typeCode){
		

		GeDictType dictType = dictTypeService.findDictTypeByCode("POLICYCONFIGPERSONBASEINFOTYPE");
		Set<GeDictData> policyConfigBaseInfoSet = dictType.getGeDictDatas();///
		List<GeDictData> policyConfigBaseInfoList = new ArrayList<GeDictData>(policyConfigBaseInfoSet);
		
		GeDictType dictType2 = null;
		if(typeCode!=null){
			dictType2 = dictTypeService.findDictTypeByCode(typeCode);
		}
		
		if(dictType2!=null){
			Set<GeDictData> policyConfigBaseInfoSet2 = dictType2.getGeDictDatas();
			if(policyConfigBaseInfoSet2!=null&&!policyConfigBaseInfoSet2.isEmpty()){
				policyConfigBaseInfoList.addAll(policyConfigBaseInfoSet2);
			}
		}
		
		Collections.sort(policyConfigBaseInfoList, new Comparator<GeDictData>(){
			public int compare(GeDictData o1, GeDictData o2) {
 				return o1.getDictdatadesc().compareTo(o2.getDictdatadesc());
			}});;
			
		return policyConfigBaseInfoList;
	}
	/**
	 * 获取 职业树
	 * 方法名称: getOccupationTree<br>
	 * 描述：
	 * 作者: lihengjun
	 * 修改日期：2014年1月13日上午10:06:35
	 * @return
	 */
	@Action("getOccupationTree")
	public String getOccupationTree(){
		String insuredconfigno = this.getHttpServletRequest().getParameter("insuredconfigno");
		List<OccupationTree> occupationTrees = occupationService.findOccupationTree(insuredconfigno);
		renderJson(JSONArray.fromObject(occupationTrees).toString());

		return null;
	}
	
	/**
	 * 方法名称: saveOrUpdateProductInfo<br>
	 * 描述：保存更新产品配置信息
	 * 作者: lihengjun
	 * 修改日期：2014年1月14日下午5:42:07
	 * @return
	 */
	@Action("saveOrUpdateProductInfoConfig")
	public String saveOrUpdateProductInfoConfig(){
		this.printParameterMap();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("resultCode", "success");
		
		try {
			geProductMain.getGeProductExtends();
			geProductMain.setGeSaleAreas(geSaleAreas);
			result = productService.updateProductInfoConfig(geProductMain, this.getHttpServletRequest().getParameterMap());
			
		} catch (Exception e) {
			logger.error("保存异常", e);
			this.printParameterMap();
			result.put("resultCode", "error");
			result.put("resultInfo", "保存异常,请重试");
		}
		
		renderJson(JsonUtils.convertObject(result));	
		
		return null;
	}
	/**
	 * 方法名称: printParameterMap<br>
	 * 描述：打印request 中参数值,出错时使用
	 * 作者: lihengjun
	 * 修改日期：2014年1月13日下午5:38:44
	 */
	public void printParameterMap(){
		Map map = this.getHttpServletRequest().getParameterMap();
		Iterator it = map.keySet().iterator();
		StringBuffer paramValueStr = new StringBuffer("\n请求中参数值如下:\n");
		while(it.hasNext()){
			String key = (String) it.next();
			Object value = map.get(key);
			if(value instanceof String){
				paramValueStr.append(key+"="+String.valueOf(value)+"\n");
			}else if(value instanceof String[]){
				String[] arr = (String[])value;
				paramValueStr.append(key+"="+Arrays.toString(arr)+"\n");
			}
			
		}
		logger.info(paramValueStr.toString());
	}
	public GeProductMain getGeProductMain() {
		return geProductMain;
	}

	public void setGeProductMain(GeProductMain geProductMain) {
		this.geProductMain = geProductMain;
	}

	public List<GeInsurancePlan> getGeInsurancePlans() {
		return geInsurancePlans;
	}

	public void setGeInsurancePlans(List<GeInsurancePlan> geInsurancePlans) {
		this.geInsurancePlans = geInsurancePlans;
	}

	public List<GeInsurancePlanAccount> getGeInsurancePlanAccounts() {
		return geInsurancePlanAccounts;
	}

	public void setGeInsurancePlanAccounts(
			List<GeInsurancePlanAccount> geInsurancePlanAccounts) {
		this.geInsurancePlanAccounts = geInsurancePlanAccounts;
	}

	public GeProductOtherconfig getGeProductOtherconfig() {
		return geProductOtherconfig;
	}

	public void setGeProductOtherconfig(GeProductOtherconfig geProductOtherconfig) {
		this.geProductOtherconfig = geProductOtherconfig;
	}
	

	public GeProductApplicantconfig getGeProductApplicantconfig() {
		return geProductApplicantconfig;
	}

	public void setGeProductApplicantconfig(
			GeProductApplicantconfig geProductApplicantconfig) {
		this.geProductApplicantconfig = geProductApplicantconfig;
	}

	public List<GeProductInformbook> getGeProductInformbooks() {
		return geProductInformbooks;
	}

	public void setGeProductInformbooks(
			List<GeProductInformbook> geProductInformbooks) {
		this.geProductInformbooks = geProductInformbooks;
	}

	public GeProductInformbook getGeProductInformbook() {
		return geProductInformbook;
	}

	public void setGeProductInformbook(GeProductInformbook geProductInformbook) {
		this.geProductInformbook = geProductInformbook;
	}
	public GeProductInsuredconfig getGeProductInsuredconfig() {
		return geProductInsuredconfig;
	}

	public void setGeProductInsuredconfig(
			GeProductInsuredconfig geProductInsuredconfig) {
		this.geProductInsuredconfig = geProductInsuredconfig;
	}

	public GeProductBeneficiaryconfig getGeProductBeneficiaryconfig() {
		return geProductBeneficiaryconfig;
	}

	public void setGeProductBeneficiaryconfig(
			GeProductBeneficiaryconfig geProductBeneficiaryconfig) {
		this.geProductBeneficiaryconfig = geProductBeneficiaryconfig;
	}

	public GeProductEmergencyConfig getGeProductEmergencyConfig() {
		return geProductEmergencyConfig;
	}

	public void setGeProductEmergencyConfig(
			GeProductEmergencyConfig geProductEmergencyConfig) {
		this.geProductEmergencyConfig = geProductEmergencyConfig;
	}

	public GeAddresseeConfig getGeAddresseeConfig() {
		return geAddresseeConfig;
	}

	public void setGeAddresseeConfig(GeAddresseeConfig geAddresseeConfig) {
		this.geAddresseeConfig = geAddresseeConfig;
	}



	public List<GeInsurancePlanAccountScore> getGeInsurancePlanAccountScores() {
		return geInsurancePlanAccountScores;
	}

	public void setGeInsurancePlanAccountScores(
			List<GeInsurancePlanAccountScore> geInsurancePlanAccountScores) {
		this.geInsurancePlanAccountScores = geInsurancePlanAccountScores;
	}
	
	public List<GeDepartment> getGeDepartments() {
		return geDepartments;
	}

	public void setGeDepartments(List<GeDepartment> geDepartments) {
		this.geDepartments = geDepartments;
	}

	public List<GeSaleArea> getGeSaleAreas() {
		return geSaleAreas;
	}

	public void setGeSaleAreas(List<GeSaleArea> geSaleAreas) {
		this.geSaleAreas = geSaleAreas;
	}
	
	public List<String> getProductCodes() {
		return productCodes;
	}

	public void setProductCodes(List<String> productCodes) {
		this.productCodes = productCodes;
	}

	public List<GeRiskSurvey> getGeRiskSurveys() {
		return geRiskSurveys;
	}

	public void setGeRiskSurveys(List<GeRiskSurvey> geRiskSurveys) {
		this.geRiskSurveys = geRiskSurveys;
	}

	public List<GeRiskSurveySubject> getGeRiskSurveySubject() {
		return geRiskSurveySubject;
	}

	public void setGeRiskSurveySubject(List<GeRiskSurveySubject> geRiskSurveySubject) {
		this.geRiskSurveySubject = geRiskSurveySubject;
	}

	public List<GeRiskSurveySubjectOption> getGeRiskSurveySubjectOption() {
		return geRiskSurveySubjectOption;
	}

	public void setGeRiskSurveySubjectOption(
			List<GeRiskSurveySubjectOption> geRiskSurveySubjectOption) {
		this.geRiskSurveySubjectOption = geRiskSurveySubjectOption;
	}
	
	
}
