package cn.com.sinosoft.web.system.product;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.config.service.DictTypeService;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.core.springsecurity.SpringSecurityUtil;
import cn.com.sinosoft.core.utils.JsonDateValueProcessor;
import cn.com.sinosoft.core.utils.JsonUtils;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.product.GeDuty;
import cn.com.sinosoft.domain.product.GeProductMain;
import cn.com.sinosoft.domain.product.GeProductduty;
import cn.com.sinosoft.domain.product.GeProductrisk;
import cn.com.sinosoft.domain.product.GeProdutyExtend;
import cn.com.sinosoft.domain.product.GeRisk;
import cn.com.sinosoft.domain.system.GeDictType;
import cn.com.sinosoft.dto.product.ProductRiskDutyTree;
import cn.com.sinosoft.dto.product.RiskData;
import cn.com.sinosoft.dto.product.RiskData.RiskDataRow;
import cn.com.sinosoft.product.service.DutyService;
import cn.com.sinosoft.product.service.ProductService;
import cn.com.sinosoft.product.service.ProductdutyService;
import cn.com.sinosoft.product.service.ProductriskService;
import cn.com.sinosoft.product.service.ProdutyExtendService;
import cn.com.sinosoft.product.service.RiskService;
import cn.com.sinosoft.product.service.WebflowpageelementService;

/**
 * 描述：产品险种责任相关配置<br>
 * 作者：yuas <br>
 * 修改日期：2014年1月14日上午9:16:09 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 */
public class RiskDutyAction  extends Struts2Action{
	private static final Logger logger = Logger.getLogger(RiskDutyAction.class);
	@Autowired
	private DictTypeService dictTypeService;
	@Autowired
	private RiskService riskService;
	
	@Autowired
	private DutyService dutyService;
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ProdutyExtendService produtyExtendService;
	@Autowired
	private ProductriskService productriskService;
	
	@Autowired
	private ProductdutyService productdutyService;
	
	@Autowired
	private WebflowpageelementService webflowpageelementService;
	
	private GeRisk geRisk;
	private GeProductduty geProductduty;
	private GeProductrisk geProductrisk;
	private List<String> geRiskButys;
	
	private String allSelectRisk;
	
	private String allSelectDuty;
	
	/**
	 * 方法名称: jumpRiskListPage<br>
	 * 描述：跳转到产品险种责任配置页面
	 * 作者: yuas
	 * 修改日期：2014年1月7日下午2:27:09
	 * @return
	 */
	@Action(value="riskList")
	public String jumpRiskListPage(){
		return "/page/riskList";
	}
	
	/**
	 * 方法名称: getRiskListData<br>
	 * 描述：获取险种列表数据
	 * 作者: yuas
	 * 修改日期：2014年1月7日下午3:09:25
	 */
	@Action(value="getRiskListData")
	public void getRiskListData(){
		Page<GeRisk> riskPage = riskService.getRiskByPage(geRisk, page, rows);
		
		List<RiskDataRow>  listRows = new ArrayList<RiskDataRow>();
		RiskData riskData = new RiskData(); 
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(GeRisk data: (List<GeRisk>)riskPage.getData()){
			RiskDataRow row = new RiskDataRow();
			BeanUtils.copyProperties(data, row);
			listRows.add(row);
		}
		riskData.setTotal(riskPage.getTotal() + "");
		riskData.setRows(listRows);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss")); 
		renderJson(JsonUtils.convertObject(riskData,jsonConfig));
	}
	
	/**
	 * 方法名称: jumpAddOrUpdateRiskPage<br>
	 * 描述：跳转到险种责任添加，修改页面
	 * 作者: yuas
	 * 修改日期：2014年1月7日下午5:38:21
	 * @return
	 */
	@Action(value="jumpAddOrUpdateRiskPage")
	public String jumpAddOrUpdateRiskPage(){
		String opeartype = this.getParameter("opeartype");
		
		if("UPDATE".equals(opeartype) || "VIEW".equals(opeartype)){
			GeRisk risk = riskService.findGeRiskByRiskCode(geRisk.getRiskcode());
			this.setRequestAttribute("geRisk", risk);
		}
		
		this.setRequestAttribute("opeartype", opeartype);
		return "/page/risk-operate";
	}
	
	/**
	 * 方法名称: existRiskCode<br>
	 * 描述：判断险种代码是否已经存在
	 * 作者: yuas
	 * 修改日期：2014年1月14日上午9:17:24
	 * @throws Exception
	 */
	@Action("existRiskCode")
	public void existRiskCode() throws Exception{
		
//		List<GeDirectory> list2 =	productManageService.findEntitys(GeDirectory.class, QueryRule.getInstance());
//		for (GeDirectory geDirectory : list2) {
//			this.geDirectoryService.deleteGeDirectory(geDirectory.getEid());
//		}
		
		List<GeProductMain> list = productService.findAllProduct();
		for (GeProductMain geProductMain : list) {
			productService.deleteProduct(geProductMain.getCoreproductcode());
		}
		
//		Map<String, String> resultMap = new HashMap<String, String>();
//		try {
//			String riskCode = super.getRequest().getParameter("riskCode");
//			GeRisk geRisk = geRiskService.findGeRiskByRiskCode(riskCode);
//			if (geRisk == null) {
//				resultMap.put("resultFlag", "error");
//			} else {
//				resultMap.put("resultFlag", "success");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			resultMap.put("resultFlag", "error");
//		} finally {
//			JSONObject jsonObject = JSONObject.fromObject(resultMap);
//			renderText(jsonObject.toString());
//		}
	}
	
	/**
	 * 方法名称: existDutyCode<br>
	 * 描述：判断同一业务领域相同责任代码是否已经存在
	 * 作者: yuas
	 * 修改日期：2014年1月14日上午9:17:39
	 */
	@Action("existDutyCode")
	public void existDutyCode(){
		Map<String, String> resultMap = new HashMap<String, String>();
		String dutyNo =  this.getParameter("dutyNo");
		String dutyCode =  this.getParameter("dutyCode");
		String businessArea = this.getParameter("businessArea");
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("businessarea", businessArea);
		queryRule.addEqual("dutycode", dutyCode);
		if(StringUtils.isNotBlank(dutyNo)){
			queryRule.addNotEqual("dutyno", dutyNo);
		}
		
		if(dutyService.findDuty(queryRule).size() != 0){
			resultMap.put("error", "同一业务领域责任代码重复，请修改业务领域或责任代码！");
		}else{
			resultMap.put("ok", "");
		}
		
		renderJson(JsonUtils.convertObject(resultMap));
	}
	
	/**
	 * 方法名称: updateGeRisk<br>
	 * 描述：修改险种信息
	 * 作者: yuas
	 * 修改日期：2014年1月14日上午9:17:52
	 */
	@Action("updateGeRisk")
	public void updateGeRisk() {
		//Map<String, String> resultMap = new HashMap<String, String>();
		//try {
			String opeartype = this.getParameter("opeartype");
			
			geRisk.setCreatetime(new Date());
			geRisk.setOperator(SpringSecurityUtil.getCurrentUserName());
			
			if("ADD".equals(opeartype)){
				List<GeDuty> geDutyList = geRisk.getGeDutys();
				for (GeDuty geDuty:geDutyList) {
					geDuty.setCreatetime(new Date());
					geDuty.setGeRisk(geRisk);
					geDuty.setOperator(SpringSecurityUtil.getCurrentUserName());
					geDuty.setBusinessarea(geRisk.getBusinessarea());
				}
				riskService.addGeRisk(geRisk);
			}else{
				riskService.updateGeRisk(geRisk);
			}
	}
	
	/**
	 * 方法名称: queryRiskDutyTree<br>
	 * 描述：查询产品关联的险种和责任
	 * 作者: yuas
	 * 修改日期：2014年1月10日上午10:17:56
	 */
	@Action(value = "queryRiskDutyTree")
	public void queryRiskDutyTree() {
		
		String coreproductcode = getHttpServletRequest().getParameter("coreproductcode");
		String operate = getHttpServletRequest().getParameter("operate");
		
		List<ProductRiskDutyTree> productRiskDutyTrees = new ArrayList<ProductRiskDutyTree>();
		
		GeProductMain geProductMain = productService.geProductMain(coreproductcode);
		
		ProductRiskDutyTree productTree = new ProductRiskDutyTree();
		productTree.setId("product#" + geProductMain.getCoreproductcode());
		productTree.setParentId("");
		productTree.setText(geProductMain.getProductname());
		productTree.setCode(geProductMain.getCoreproductcode());
		productTree.setType("product");
		productRiskDutyTrees.add(productTree);
		
		List<GeProductrisk> productriskList = geProductMain.getGeProductRisks();
		
		if(productriskList != null && productriskList.size() > 0){
			for (GeProductrisk geProductrisk : productriskList) {
				
				
				List<GeProductduty> productdutyList = geProductrisk.getGeProductdutys();
				if(productdutyList != null && productdutyList.size() > 0){
					for (GeProductduty geProductduty : productdutyList) {
						ProductRiskDutyTree dutyTree = new ProductRiskDutyTree();
						dutyTree.setId("duty#" + geProductduty.getProductdutyno());
						dutyTree.setParentId("risk#" + geProductrisk.getProductriskno());
						dutyTree.setText(geProductduty.getProductdutyname()+"(" + geProductduty.getProductdutycode() + ")");
						dutyTree.setCode(geProductduty.getProductdutycode());
						dutyTree.setType("duty");
						productRiskDutyTrees.add(dutyTree);
					}
				}
				
				ProductRiskDutyTree riskTree = new ProductRiskDutyTree();
				riskTree.setId("risk#" + geProductrisk.getProductriskno());
				riskTree.setParentId("product#" + geProductMain.getCoreproductcode());
				riskTree.setText(geProductrisk.getProductriskname());
				riskTree.setCode(geProductrisk.getProductriskcode());
				riskTree.setType("risk");
				
				productRiskDutyTrees.add(riskTree);
				
			}
		}
		
		
		renderJson(JSONArray.fromObject(productRiskDutyTrees).toString());
	}
	
	/**
	 * 方法名称: jumpEditRiskDuty<br>
	 * 描述：跳转到产品险种责任配置页面
	 * 作者: yuas
	 * 修改日期：2014年1月14日上午9:18:42
	 * @return
	 */
	@Action(value = "jumpEditRiskDuty")
	public String jumpEditRiskDuty(){
		
		String coreproductcode = getHttpServletRequest().getParameter("coreproductcode");
		String opeartype = getHttpServletRequest().getParameter("opeartype");
		
		List<ProductRiskDutyTree> productRiskDutyTrees = new ArrayList<ProductRiskDutyTree>();
		
		GeProductMain geProductMain = productService.geProductMain(coreproductcode);
		StringBuffer allRisk = new StringBuffer();
		StringBuffer allDuty = new StringBuffer();
		productRiskDutyTrees = findAllRiskDutyTree(geProductMain, allRisk, allDuty);
		
		getHttpServletRequest().setAttribute("productRiskDutyTrees", JSONArray.fromObject(productRiskDutyTrees).toString());
		getHttpServletRequest().setAttribute("opeartype", opeartype);
		allSelectRisk = allRisk.toString();
		allSelectDuty = allDuty.toString();
		
		return  "/page/elements/riskduty-config";
	}
	
	/**
	 * 方法名称: queryAllRiskDutyTree<br>
	 * 描述：查询所有险种，责任
	 * 作者: yuas
	 * 修改日期：2014年1月14日上午9:19:30
	 */
	@Action(value = "queryAllRiskDutyTree")
	public void queryAllRiskDutyTree() {
		
		String coreproductcode = getHttpServletRequest().getParameter("coreproductcode");
		List<ProductRiskDutyTree> productRiskDutyTrees = new ArrayList<ProductRiskDutyTree>();
		
		GeProductMain geProductMain = productService.geProductMain(coreproductcode);
		StringBuffer allRisk = new StringBuffer();
		StringBuffer allDuty = new StringBuffer();
		productRiskDutyTrees = findAllRiskDutyTree(geProductMain, allRisk, allDuty);
		
		renderJson(JSONArray.fromObject(productRiskDutyTrees).toString());
	}
	
	/**
	 * 方法名称: findAllRiskDutyTree<br>
	 * 描述：查询所有险种，责任
	 * 作者: yuas
	 * 修改日期：2014年1月14日上午9:19:50
	 * @param geProductMain
	 * @param allRisk
	 * @param allDuty
	 * @return
	 */
	private List<ProductRiskDutyTree> findAllRiskDutyTree(GeProductMain geProductMain, StringBuffer allRisk, StringBuffer allDuty){
		List<ProductRiskDutyTree> productRiskDutyTrees = new ArrayList<ProductRiskDutyTree>();
		
		ProductRiskDutyTree productTree = new ProductRiskDutyTree();
		productTree.setId("product#" + geProductMain.getCoreproductcode());
		productTree.setParentId("");
		productTree.setText(geProductMain.getProductname());
		productTree.setCode(geProductMain.getCoreproductcode());
		productTree.setType("product");
		productTree.setChecked(true);
		productRiskDutyTrees.add(productTree);
		 
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("businessarea", geProductMain.getBusinessarea());
		List<GeRisk> geRiskList = riskService.findGeRiskByQueryRule(queryRule);
		
		List<GeProductrisk> productRiskList = geProductMain.getGeProductRisks();
		boolean riskCheck = false; 
		boolean dutyCheck = false;
		if(geRiskList != null && geRiskList.size() > 0){
			for (GeRisk geRisk : geRiskList) {
				
				List<GeProductduty> productdutyList = null;
				if(productRiskList != null && productRiskList.size() > 0){
					for (GeProductrisk geProductrisk : productRiskList) {
						if(geRisk.getRiskcode().equals(geProductrisk.getProductriskcode())){
							riskCheck = true;
							productdutyList = geProductrisk.getGeProductdutys();
							allRisk.append(geProductrisk.getProductriskcode()).append(",");
							break;
						}
					}
				}
				
				QueryRule dutyQueryRule = QueryRule.getInstance();
				dutyQueryRule.addEqual("geRisk.riskcode", geRisk.getRiskcode());;
				List<GeDuty> dutyList = dutyService.findDuty(queryRule);
				if(dutyList != null && dutyList.size() > 0){
					for (GeDuty geDuty : dutyList) {
						
						if(productdutyList != null && productdutyList.size() > 0){
							for (GeProductduty geProductduty : productdutyList) {
								if(geDuty.getDutyno().equals(geProductduty.getDutyserialno())){
									dutyCheck = true;
									allDuty.append(geProductduty.getGeProductrisk().getRiskcode()+"@-"+ geProductduty.getDutyserialno()).append(",");//存的是配置表的id
									break;
								}
							}
						}
						
						ProductRiskDutyTree dutyTree = new ProductRiskDutyTree();
						dutyTree.setId("duty#" + geRisk.getRiskcode() +"@-" + geDuty.getDutyno());
						dutyTree.setParentId("risk#" + geRisk.getRiskcode());
						dutyTree.setText(geDuty.getDutyname()+"(" + geDuty.getDutycode() + ")");
						dutyTree.setCode(geDuty.getDutycode());
						dutyTree.setType("duty");
						dutyTree.setChecked(dutyCheck);
						productRiskDutyTrees.add(dutyTree);
						dutyCheck = false;
					}
				}
				
				ProductRiskDutyTree riskTree = new ProductRiskDutyTree();
				riskTree.setId("risk#" + geRisk.getRiskcode());
				riskTree.setParentId("product#" + geProductMain.getCoreproductcode());
				riskTree.setText(geRisk.getRiskname());
				riskTree.setCode(geRisk.getRiskcode());
				riskTree.setType("risk");
				riskTree.setChecked(riskCheck);
				
				productRiskDutyTrees.add(riskTree);
				riskCheck = false;
				
			}
		}
		return productRiskDutyTrees;
	}
	
	/**
	 * 方法名称: updateRiskButyConfig<br>
	 * 描述：修改产品关联的产品，责任
	 * 作者: yuas
	 * 修改日期：2014年1月14日上午9:20:03
	 */
	@Action(value = "updateRiskButyConfig")
	public void updateRiskButyConfig(){
		
		String coreproductcode = getHttpServletRequest().getParameter("coreproductcode");
		String businessarea = getHttpServletRequest().getParameter("businessarea");
		GeProductMain geProductMain = productService.geProductMain(coreproductcode);
		// (详细定义)编辑每个标签页时校验产品状态，如果是刚发布的，产品状态改为已定制流程
		productService.valProductStatus(geProductMain);
		
		List<String> riskNowList = new ArrayList<String>();
		List<String> dutyNowList = new ArrayList<String>();
		
		if(geRiskButys != null && geRiskButys.size() > 0){
			for (String id : geRiskButys) {
				 if(id.indexOf("risk#") > -1){
					id  = id.replaceAll("risk#", "");
					riskNowList.add(id);
				}else if(id.indexOf("duty#") > -1){
					id  = id.replaceAll("duty#", "");
					dutyNowList.add(id);
				}
			}
			
			String[] allRisk_old = allSelectRisk.split(",");  // 已选的险种代码
			String[] allDuty_old = allSelectDuty.split(",");  // 已选的责任(配置表里的id)
			
			// 旧
			List<String> allRisk_list = Arrays.asList(allRisk_old);
			List<String> allDuty_list = Arrays.asList(allDuty_old);
			allRisk_list = new ArrayList(allRisk_list);
			allDuty_list = new ArrayList(allDuty_list);
			
			// 添加险种
			for (String code : riskNowList) {
				if(!allRisk_list.contains(code)){
					
					QueryRule queryRule = QueryRule.getInstance();
					queryRule.addEqual("riskcode", code);
					queryRule.addEqual("businessarea", businessarea);
					List<GeRisk> list = riskService.findGeRiskByQueryRule(queryRule);
					
					if(list!=null && list.size()>0){
						GeRisk risk = list.get(0);
						GeProductrisk geProductRisk = new GeProductrisk();
						
						geProductRisk.setCreatetime(new Date());
						geProductRisk.setGeProductMain(geProductMain);
						geProductRisk.setRiskcode(code);
						geProductRisk.setProductriskcode(code);
						geProductRisk.setProductriskname(risk.getRiskname());
							
						productriskService.addGeProductrisk(geProductRisk);
					}
				}
			}
			// 添加责任(每个新的在旧的里没有)
			for (String id : dutyNowList) {
				int index = id.indexOf("@-");
				String riskID = id.substring(0, index);
				String serialNo = id.substring(index+2,id.length());
				
				if(!allDuty_list.contains(id)){
					QueryRule q = QueryRule.getInstance();
					q.addEqual("dutyno", serialNo);
					List<GeDuty> list = dutyService.findDuty(q);
					if(list!=null && list.size()>0){
						GeDuty duty = list.get(0);
						GeProductduty geProductDuty = new GeProductduty();
						geProductDuty.setCreatetime(new Date());
						geProductDuty.setGeProductMain(geProductMain);
						geProductDuty.setProductdutycode(duty.getDutycode());
						geProductDuty.setProductdutyname(duty.getDutyname());
						geProductDuty.setDutyserialno(duty.getDutyno());
						
						q = QueryRule.getInstance();
						q.addEqual("productriskcode", riskID);
						q.addEqual("geProductMain.coreproductcode", coreproductcode);
						GeProductrisk geRisk = productriskService.findByQueryRule(q).get(0);
						geProductDuty.setGeProductrisk(geRisk);
						
						productdutyService.addGeProductduty(geProductDuty);
					}
				}
			}
			
			// 每个旧的在新的里没有做删除操作
			for (String id : allDuty_list) {
				if(!"".equals(id)){
					if( ! dutyNowList.contains(id)){
						String dutyId = id.substring(id.indexOf("@-")+2, id.length());
						
						// 删除责任
						QueryRule q = QueryRule.getInstance();
						q.addEqual("dutyserialno", dutyId);
						q.addEqual("geProductMain.coreproductcode", coreproductcode);
						GeProductduty dutyDel = productdutyService.findGeProductdutyByQueryRule(q).get(0);
						if(dutyDel != null){
							productdutyService.deleteGeProductduty(dutyDel);
						}
					}
				}
			}
			
			for (String code : allRisk_list) {
				if(!"".equals(code)){
					if( ! riskNowList.contains(code)){
						// 删除险种
						QueryRule q = QueryRule.getInstance();
						q = QueryRule.getInstance();
						q.addEqual("productriskcode", code);
						q.addEqual("geProductMain.coreproductcode", coreproductcode);
						GeProductrisk geRisk = this.productriskService.findByQueryRule(q).get(0);
						productriskService.deleteGeProductrisk(geRisk);
					}
				}
			}
		}else{
			// 根据产品id全部删除
			productdutyService.deleteByProductId(coreproductcode);
			productriskService.deleteByProductId(coreproductcode);
		}
		
		// 置标签页状态(没有责任时，状态需要置回)
//		if(dutyNowList.size()>0){
//			webflowpageelementService.updateGeWebflowpageelementStatus("1", geProductMain.getCoreproductcode(), "dutyKindConfig");
//		}else{
//			webflowpageelementService.updateGeWebflowpageelementStatus("0", geProductMain.getCoreproductcode(), "dutyKindConfig");
//		}
		
		//return "";
	}
	/**
	 * 方法名称: checkOrEditRiskDuty<br>
	 * 描述：查看或者编辑 险种责任
	 * 作者: partrick
	 * 修改日期：2014年1月13日下午5:42:10
	 * @return
	 */
	@Action(value = "checkOrEditRiskDuty")
	public String checkOrEditRiskDuty(){
		String returnUrl = "";
		String type = this.getHttpServletRequest().getParameter("type");
		String dutyNo = this.getHttpServletRequest().getParameter("dutyNo");
		String riskNo = this.getHttpServletRequest().getParameter("riskNo");
		String operation = this.getHttpServletRequest().getParameter("operation");
		
		if("check".equals(operation)){
		}else if("edit".equals(operation)){
		}
				
		if("risk".equals(type)){
			geProductrisk = productriskService.get(riskNo);
			returnUrl = "/page/elements/checkOrEditRisk";
		}else if("duty".equals(type)){
			geProductduty = productdutyService.findBySerialNo(dutyNo);
			returnUrl = "/page/elements/checkOrEditDuty";
			
			//责任金额单位
			GeDictType geDictType = dictTypeService.findDictTypeByCode("DUTY_INSURED_UNIT_TYPE");
			this.getHttpServletRequest().setAttribute("duty_insured_unit_typeList", geDictType.getGeDictDatas());
		}
		
		this.getHttpServletRequest().setAttribute("operation", operation);
		this.getHttpServletRequest().setAttribute("type", type);
		
		return returnUrl;
	}
	/**
	 * 方法名称: updateRiskInfo<br>
	 * 描述：更新险种信息
	 * 作者: partrick
	 * 修改日期：2014年1月13日下午5:42:28
	 * @return
	 */
	@Action(value = "updateRiskInfo")
	public String updateRiskInfo(){
		Map<String, String> result = new HashMap<String, String>();
		result.put("resultCode", "success");
		String returnUrl = null;
		String dutyNo = this.getHttpServletRequest().getParameter("dutyNo");
		String riskNo = this.getHttpServletRequest().getParameter("riskNo");
			
		try {
			GeProductrisk geProductriskDB = productriskService.get(riskNo);
			
			geProductriskDB.setProductriskname(geProductrisk.getProductriskname());
			geProductriskDB.setSeqindex(geProductrisk.getSeqindex());
			geProductriskDB.setSaleflag(geProductrisk.getSaleflag());
			geProductriskDB.setIsshowproductduty(geProductrisk.getIsshowproductduty());
			
			productriskService.updateGeProductrisk(geProductriskDB);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("保存异常", e);
			this.printParameterMap();
			result.put("resultCode", "error");
			result.put("resultInfo", "保存异常,请重试");
		}
		renderJson(JsonUtils.convertObject(result));
		return null;
	}
	/**
	 * 方法名称: updateDutyInfo<br>
	 * 描述：更新责任信息
	 * 作者: partrick
	 * 修改日期：2014年1月13日下午5:42:39
	 * @return
	 */
	@Action(value = "updateDutyInfo")
	public String updateDutyInfo(){
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("resultCode", "success");
		String returnUrl = null;
		String dutyNo = this.getHttpServletRequest().getParameter("dutyNo");
		String riskNo = this.getHttpServletRequest().getParameter("riskNo");
		try {	
			
			GeProductduty geProductdutyDB = productdutyService.findBySerialNo(dutyNo);
			
			geProductdutyDB.setProductdutyname(geProductduty.getProductdutyname());
			geProductdutyDB.setSeqindex(geProductduty.getSeqindex());
			geProductdutyDB.setSaleflag(geProductduty.getSaleflag());
			
			geProductdutyDB.setUpdatetime(new Date());
			
			
			produtyExtendService.deleteByDutyId(dutyNo);
			List<GeProdutyExtend> geProdutyExtends = geProductduty.getGeProdutyExtends();
			for (int i = 0; i < geProdutyExtends.size(); i++) {
				GeProdutyExtend ex = geProdutyExtends.get(i);
				if(ex!=null
						&& ex.getAttributetype()!=null 
						&& ex.getAttributevalue()!=null
						&& !"".equals(ex.getAttributetypevalue()) 
						&& !"".equals(ex.getAttributevalue())){
					ex.setAttributeno(null);
					ex.setGeProductduty(geProductdutyDB);
					produtyExtendService.add(ex);
				}
			}
			productdutyService.updateGeProductduty(geProductdutyDB);
		
		} catch (Exception e) {
			logger.error("保存异常", e);
			this.printParameterMap();
			result.put("resultCode", "error");
			result.put("resultInfo", "保存异常,请重试");
		}
	
		renderJson(JsonUtils.convertObject(result));
	
		return returnUrl;
	}
	/**
	 * 方法名称: deleteRiskOrDuty<br>
	 * 描述：
	 * 作者: partrick
	 * 修改日期：2014年1月13日下午5:10:46
	 * @return
	 */
	@Action("deleteRiskOrDuty")
	public String deleteRiskOrDuty(){
		Map<String, String> result = new HashMap<String, String>();
		result.put("resultCode", "success");
		String type = this.getHttpServletRequest().getParameter("type");
		String dutyNo = this.getHttpServletRequest().getParameter("dutyNo");
		String riskNo = this.getHttpServletRequest().getParameter("riskNo");
		String operation = this.getHttpServletRequest().getParameter("operation");
		
		try {	
			if("delete".equals(operation)){
				if("risk".equals(type)){
					productriskService.deleteByPK(riskNo);
				}else if("duty".equals(type)){
					productdutyService.deleteGeProductduty(dutyNo);
				}
			}
		} catch (Exception e) {
			logger.error("删除异常", e);
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
	 * 作者: partrick
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
	public GeRisk getGeRisk() {
		return geRisk;
	}

	public void setGeRisk(GeRisk geRisk) {
		this.geRisk = geRisk;
	}

	public List<String> getGeRiskButys() {
		return geRiskButys;
	}

	public void setGeRiskButys(List<String> geRiskButys) {
		this.geRiskButys = geRiskButys;
	}

	public GeProductduty getGeProductduty() {
		return geProductduty;
	}

	public void setGeProductduty(GeProductduty geProductduty) {
		this.geProductduty = geProductduty;
	}

	public GeProductrisk getGeProductrisk() {
		return geProductrisk;
	}

	public void setGeProductrisk(GeProductrisk geProductrisk) {
		this.geProductrisk = geProductrisk;
	}

	public String getAllSelectRisk() {
		return allSelectRisk;
	}

	public void setAllSelectRisk(String allSelectRisk) {
		this.allSelectRisk = allSelectRisk;
	}

	public String getAllSelectDuty() {
		return allSelectDuty;
	}

	public void setAllSelectDuty(String allSelectDuty) {
		this.allSelectDuty = allSelectDuty;
	}
	
}
