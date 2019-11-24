package cn.com.sinosoft.web.system.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.product.service.ProductAttributeService;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.product.GeProductAttribute;
import cn.com.sinosoft.domain.system.GeArea;
import cn.com.sinosoft.dto.product.ProductAttrTree;

public class productAttributeAction extends Struts2Action{
	
	private String prentId;
	private GeProductAttribute geProductAttr;
	@Autowired
	private ProductAttributeService productAttrService;
	
	
	public String getPrentId() {
		return prentId;
	}

	public void setPrentId(String prentId) {
		this.prentId = prentId;
	}

	public GeProductAttribute getGeProductAttr() {
		return geProductAttr;
	}

	public void setGeProductAttr(GeProductAttribute geProductAttr) {
		this.geProductAttr = geProductAttr;
	}

	/**
	 * 方法名称: jumpToProductAttributePage<br>
	 * 描述：跳转到产品属性页面
	 * 作者: liaojiping
	 * 修改日期：2013-12-31下午06:09:02
	 * @return
	 */
//	@Action(value = "productAttr")
//	public String jumpToProductAttributePage() {
//		return "../page/product/productAttribute";
//	}
	
	@Action(value="productAttr")
	public String jumpToProductAttributePage(){
		List<GeProductAttribute> productAttrs = productAttrService.getGeProductAttributeAll();
		List<ProductAttrTree> productAttrTrees = new ArrayList<ProductAttrTree>();
		for(GeProductAttribute productAttr:productAttrs){
			ProductAttrTree tree = new ProductAttrTree();
			tree.setId(productAttr.getAttrid());
			tree.setParentId(productAttr.getAttrparent());
			tree.setText(productAttr.getAttrname());
		    tree.setAttrdesc(productAttr.getAttrdescription());
		    tree.setAttrnoteinfo(productAttr.getAttrnoteinfo());
		    long seq = Long.parseLong(productAttr.getSeqindex().toString());
			tree.setSeqindex(seq);
		 //   tree.setSeqindex(productAttr.getSeqindex());
		    tree.setAttrparent(productAttr.getAttrparent());
		    tree.setProductattrname(productAttr.getAttrname());
		    tree.setProductattrid(productAttr.getAttrid());
			BeanUtils.copyProperties(productAttr, tree);
			productAttrTrees.add(tree);
		}
		getHttpServletRequest().setAttribute("productAttrTree", JSONArray.fromObject(productAttrTrees).toString());	
		return  "../product/page/productAttribute";
	}
	
	/**
	 * 方法名称: jumpAddORUpdateProductAttrPage<br>
	 * 描述：跳转到添加修改产品属性页面
	 * 作者: liaojiping
	 * 修改日期：2014-1-8上午11:00:41
	 * @return
	 */
	@Action(value="jumpAddORUpdateProductAttrPage")
	public String jumpAddORUpdateProductAttrPage(){
		
	//	getHttpServletRequest().setAttribute("resourceIcons", resourceIconService.geResourcesIconsAll());
		return "../product/page/productattr-operate";
	}
	
	/**
	 * 方法名称: existProductAttr<br>
	 * 描述：查看是否存在产品属性
	 * 作者: liaojiping
	 * 修改日期：2014-1-8上午11:01:31
	 */
	@Action(value="existProductAttr")
	public void existProductAttr(){
		Map<String, String> result = new HashMap<String, String>();
		if("ADD".equals(getHttpServletRequest().getParameter("opeartype"))){
			String productAttrId = getHttpServletRequest().getParameter("productAttrId");
			boolean boo = productAttrService.existGeProductAttr(productAttrId);
			if(boo || "1".equals(productAttrId)){ //存在  "1"为所有跟区域的父id
				result.put("error", "此编号已存在");
			}
			else{//不存在
				result.put("ok", "");
			}
		}
		else{
			System.out.println("====update begin======");
			result.put("ok", "");
		}
		renderText(JSONObject.fromObject(result).toString());
	}
	
	/**
	 * 方法名称: addUpdateProductAttr<br>
	 * 描述：添加或更新产品属性
	 * 作者: user
	 * 修改日期：2014-1-3下午12:23:54
	 */
	@Action(value="addUpdateProductAttr")
	public void addUpdateProductAttr(){
			if("ADD".equals(getHttpServletRequest().getParameter("opeartype"))){
				geProductAttr.setAttrid(geProductAttr.getAttrid());
				geProductAttr.setAttrname(geProductAttr.getAttrname());
				geProductAttr.setAttrdescription(geProductAttr.getAttrdescription());
				geProductAttr.setAttrnoteinfo(geProductAttr.getAttrnoteinfo());
				long seq = Long.parseLong(geProductAttr.getSeqindex().toString());
				geProductAttr.setSeqindex(seq);
				geProductAttr.setAttrparent(geProductAttr.getAttrparent());
				productAttrService.addGeProductAttr(geProductAttr);
				renderText("ADD_SUCCESS"); 
				System.out.println("======addUpdateProductAttr  end=======");
			}else if("UPDATE".equals(getHttpServletRequest().getParameter("opeartype"))){
				System.out.println("======addUpdateProductAttr begin=======");
				geProductAttr.setAttrid(geProductAttr.getAttrid());
				geProductAttr.setAttrname(geProductAttr.getAttrname());
				geProductAttr.setAttrdescription(geProductAttr.getAttrdescription());
				geProductAttr.setAttrnoteinfo(geProductAttr.getAttrnoteinfo());
				long seq = Long.parseLong(geProductAttr.getSeqindex().toString());
				geProductAttr.setSeqindex(seq);
				geProductAttr.setAttrparent(getHttpServletRequest().getParameter("prentId"));
				System.out.println("========endendend==========="+geProductAttr.getAttrparent());
				productAttrService.updateGeProductAttr(geProductAttr);
				renderText("UPDATE_SUCCESS"); 
		}
	}	
	
	/**
	 * 方法名称: existChildren<br>
	 * 描述：查看是否存在子节点
	 * 作者: liaojiping
	 * 修改日期：2014-1-3下午05:22:03
	 * @return
	 */
	@Action(value="existChildren")
	public String existChildren(){
		String id = geProductAttr.getAttrid();
		//String id =  geProductAttr.getAttrparent();
		List<GeProductAttribute> childs = productAttrService.getGeProductAttrChild(id);
		if(childs.size()>0&&childs!=null){
			System.out.println("----------------childs-----------"+childs.get(0).getAttrname());
			renderText("EXIST"); 
		}
		return null;
	}
	
	/**
	 * 方法名称: deleteArea<br>
	 * 描述：删除产品属性
	 * 作者: liaojiping
	 * 修改日期：2014-1-8上午11:02:10
	 */
	@Action(value="deleteProductAttr")
	public void deleteProductAttr(){
		productAttrService.deleteGeProductAttr(geProductAttr.getAttrid());
		renderText("DEL_SUCCESS"); 
	}
	
}
