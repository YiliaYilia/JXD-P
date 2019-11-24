/**
 * File Name:ProductAction.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author Leeyao
 * @version:v1.0
 * Createdate:2014年1月2日上午9:59:11
 */
package cn.com.sinosoft.web.system.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.utils.JsonDateValueProcessor;
import cn.com.sinosoft.core.utils.JsonUtils;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.product.GeProductflowPage;
import cn.com.sinosoft.domain.product.GeProductflowdefine;
import cn.com.sinosoft.domain.product.GeProductflowpageElement;
import cn.com.sinosoft.domain.product.GeProductflowpagedefine;
import cn.com.sinosoft.domain.product.GeProductflowpageelementdefine;
import cn.com.sinosoft.dto.product.FlowData;
import cn.com.sinosoft.dto.product.FlowData.FlowDataRow;
import cn.com.sinosoft.product.service.ProductFlowDefineService;
import cn.com.sinosoft.product.service.ProductFlowPageDefineService;
import cn.com.sinosoft.product.service.ProductFlowPageElementDefineService;

/**
 * 描述：销售流程配置action<br>
 * 作者：Leeyao<br>
 * 修改日期：2014年1月2日上午10:44:26<br>
 * E-mail: liysz0441@sinosoft.com.cn<br>
 */
public class FlowDefineAction extends Struts2Action{

	private static final long serialVersionUID = 1L;
	@Autowired
	private ProductFlowDefineService flowDefineService; 
	@Autowired
	private ProductFlowPageDefineService pageDefineService;
	@Autowired
	private ProductFlowPageElementDefineService flowPageElementDefineService;

	private GeProductflowdefine geProductflowdefine;
	private List<GeProductflowpagedefine> ownPages;
	/**
	 * 方法名称：jumpFlowDefineListPage<br>
	 * 描述：跳转到流程列表页面<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月2日上午10:50:31<br>
	 * @return
	 */
	@Action(value="flowList")
	public String jumpFlowListPage(){
		return "/page/flowList";
	}
	
	/**
	 * 方法名称：jumpFlowOperatePage<br>
	 * 描述：跳转至流程操作页面<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月2日下午5:03:43<br>
	 * @return
	 */
	@Action(value="flowOperate")
	public String jumpFlowOperatePage(){
		String operate = this.getHttpServletRequest().getParameter("operate");
		this.getHttpServletRequest().setAttribute("operate", operate);
		List<GeProductflowpagedefine> pagedefines = pageDefineService.getGeProductflowpagedefines();
		if("add".equals(operate)){
			this.getHttpServletRequest().setAttribute("pagedefines", pagedefines);
		} else if("view".equals(operate)){
			geProductflowdefine = flowDefineService.getGeProductflowdefine(geProductflowdefine.getProductflowdefineno());
			this.getHttpServletRequest().setAttribute("geProductflowdefine", geProductflowdefine);
			return "/page/flowView";
		}
		return "/page/flowOperate";
	}
	
	/**
	 * 方法名称：jumpElementPage<br>
	 * 描述：生成元素页面<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月6日下午7:08:22<br>
	 * @return
	 */
	@Action(value="elementPage")
	public String jumpElementPage(){
		String pageno = this.getHttpServletRequest().getParameter("pageno");
		List<GeProductflowpageelementdefine> elements = flowPageElementDefineService.getAllProductflowpageelementdefines();
		this.getHttpServletRequest().setAttribute("elements", elements);
		this.getHttpServletRequest().setAttribute("ownelements", elements);
		this.getHttpServletRequest().setAttribute("pageno", pageno);
		return "/page/pageElement";
	}
	
	/**
	 * 方法名称：findFlowData<br>
	 * 描述：查询销售流程数据<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月2日下午1:30:35<br>
	 */
	@Action(value = "findFlowData")
	public void findFlowData() {
		String productflowname = "";
		if(geProductflowdefine != null){
			productflowname = geProductflowdefine.getProductflowname();
		}
		Page<GeProductflowdefine> pageObj = flowDefineService.getGeProductflowdefineByName(productflowname, page, rows);
		FlowData flowData = new FlowData();
		List<GeProductflowdefine> productflowdefines = (List<GeProductflowdefine>)pageObj.getData();
		flowData.setTotal(pageObj.getTotal() + "");
		List<FlowDataRow> rows = new ArrayList<FlowData.FlowDataRow>();
		for (GeProductflowdefine geProductflowdefine : productflowdefines) {
			FlowDataRow row = new FlowDataRow();
			BeanUtils.copyProperties(geProductflowdefine,row);
			row.setFlowname(geProductflowdefine.getProductflowname());
			row.setFlowno(geProductflowdefine.getProductflowdefineno());
			rows.add(row);
		}
		flowData.setRows(rows);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss"));
		renderJson(JsonUtils.convertObject(flowData,jsonConfig));
	}
	
	/**
	 * 方法名称：addOrUpdateFlow<br>
	 * 描述：添加或修改流程<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2014年1月6日下午4:27:57<br>
	 */
	@Action(value = "addOrUpdateFlow")
	public void addOrUpdateFlow(){
		String operate = getHttpServletRequest().getParameter("operate");
		String config = getHttpServletRequest().getParameter("config");
		if("add".equals(operate)){
			String[] pageAndElement = config.split("-");
			geProductflowdefine.setCreatetime(new Date());
			geProductflowdefine.setUpdatetime(new Date());
			List<GeProductflowPage> flowPages = new ArrayList<GeProductflowPage>();
			for(int i=0;i<pageAndElement.length;i++){
				GeProductflowPage flowPage = new GeProductflowPage();
				flowPage.setDefaultseqindex((long)i+1);
				flowPage.setCreatetime(new Date());
				flowPage.setUpdatetime(new Date());
				flowPage.setOperator(geProductflowdefine.getOperator());
				flowPage.setRequired("");
				flowPage.setGeProductflowdefine(geProductflowdefine);
				
				String page = pageAndElement[i];
				String[] elements = page.split("_");
				//elements第一个是页面id 后面所有为元素id
				
				//页面
				GeProductflowpagedefine pagedefine = pageDefineService.getGeProductflowpagedefineByPK(elements[0]);
				flowPage.setGeProductflowpagedefine(pagedefine);
				flowPages.add(flowPage);
				
				//元素的集合
				List<GeProductflowpageElement> pageElements = new ArrayList<GeProductflowpageElement>();
				for (int j = 1; j < elements.length; j++) {
					GeProductflowpageElement element = new GeProductflowpageElement();
					GeProductflowpageelementdefine pageelement = flowPageElementDefineService.getGeProductflowpageelementdefine(elements[j]);
					element.setDefaultseqindex((long)j);
					element.setCreatetime(new Date());
					element.setUpdatetime(new Date());
					element.setOperator(geProductflowdefine.getOperator());
					element.setRequired("");
					element.setGeProductflowPage(flowPage);
					element.setGeProductflowpageelementdefine(pageelement);
					pageElements.add(element);
				}
				//元素的集合结束
				flowPage.setGeProductflowpageElements(pageElements);
			}
			geProductflowdefine.setGeProductflowPages(flowPages);
			flowDefineService.addGeProductflowdefine(geProductflowdefine);
		} else if("update".equals(operate)){
			
		}
	}
	
	public GeProductflowdefine getGeProductflowdefine() {
		return geProductflowdefine;
	}
	public void setGeProductflowdefine(GeProductflowdefine geProductflowdefine) {
		this.geProductflowdefine = geProductflowdefine;
	}

	public List<GeProductflowpagedefine> getOwnPages() {
		return ownPages;
	}

	public void setOwnPages(List<GeProductflowpagedefine> ownPages) {
		this.ownPages = ownPages;
	}
}
