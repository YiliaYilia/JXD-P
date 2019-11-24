<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>
<script type="text/javascript" src="${ctx }/system/product/js/productAttr/productAttribute.js"></script>
<script type="text/javascript" src="${ctx }/system/product/js/productAttr/productAttrTreeConvert.js"></script>

<style>
	.productAttrItem{
		padding-top: 10px;
	}
	.n-invalid {border: 1px solid red;}
</style>
<script type="text/javascript">
    var data = eval('('+'${productAttrTree}'+')');
    var productAttr = new ProductAttr();
    $(document).ready(function(){
    	productAttr.createProductAttrTreeGrid(data);
    	productAttr.ctx='${ctx}';
    });
</script>	
</head>

<dict:script typeCode="MENUTYPE"></dict:script>
<table id="productAttrList" width="100%"></table>
<auth:showView permission="RULE_PRODUCT_ATTR_ADD,RULE_PRODUCT_ATTR_UPDATE,RULE_PRODUCT_ATTR_DEL" desc="如果有其中一项，就显示">
<!-- 弹出操作菜单项 -->
<div id="productAttr_menu" class="easyui-menu" style="width:110px;display: none" data-options="onClick:productAttr.selectMenu">   
   	<auth:showView permission="RULE_PRODUCT_ATTR_ADD" desc="控制新增产品属性权限"> 
    	<div data-options="iconCls:'icon-add',name:'addProductAttrMenu'" >添加产品属性</div>
    </auth:showView>
    <auth:showView permission="RULE_PRODUCT_ATTR_UPDATE" desc="控制修改产品属性权限">    
    	<div data-options="iconCls:'icon-edit',name:'updateProductAttrMenu'">修改产品属性</div>
    </auth:showView>
    <auth:showView permission="RULE_PRODUCT_ATTR_DEL" desc="控制删除产品属性权限"> 
    	<div data-options="iconCls:'icon-remove',name:'delProductAttrMenu'">删除产品属性</div>  
    </auth:showView>
</div>
</auth:showView>
<!-- 弹出添加操作窗口 --> 
<div id="productAttr_addUpdate_window" style="font-size: 15px;padding: 10px;">   
   	
</div>

	