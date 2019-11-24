<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>
<script type="text/javascript" src="${ctx }/system/js/resource/resourceTreeConvert.js"></script>
<script type="text/javascript" src="${ctx }/system/js/resource/resource.js"></script>
<style>
	.resourceItem{
		padding-top: 10px;
	}
	.n-invalid {border: 1px solid red;}
</style>
<script type="text/javascript">
var data = eval('('+'${resourceTree}'+')');
var resource = new Resource();

$(document).ready(function(){
	resource.createResourceTreeGrid(data);
	resource.ctx='${ctx}';
	
	resource.formValidate();
/* 	$('#addUpdateResouceForm').on('valid.form', function(){
		resource.addUpdateResource();
		return false;
	}).on('invalid.form', function(){
		return false;
	}); */ 

});

		
</script>
</head>

<dict:script typeCode="MENUTYPE"></dict:script>

<table id="resourceList"   width="100%"></table>  

<auth:showView permission="RES_AUTH_RESOURCE_ADD,RES_AUTH_RESOURCE_UPDATE,RES_AUTH_RESOURCE_DEL" desc="如果有其中一项，就显示">
<!-- 弹出操作菜单项 -->
<div id="resource_menu" class="easyui-menu" style="width:110px;display: none" data-options="onClick:resource.selectMenu">   
   	<auth:showView permission="RES_AUTH_RESOURCE_ADD" desc="控制新增资源权限"> 
    	<div data-options="iconCls:'icon-add',name:'addResourceMenu'" >添加资源</div>
    </auth:showView>
    <auth:showView permission="RES_AUTH_RESOURCE_UPDATE" desc="控制修改资源权限">    
    	<div data-options="iconCls:'icon-edit',name:'updateResourceMenu'">修改资源</div>
    </auth:showView>
    <auth:showView permission="RES_AUTH_RESOURCE_DEL" desc="控制删除资源权限"> 
    	<div data-options="iconCls:'icon-remove',name:'delResourceMenu'">删除资源</div>  
    </auth:showView>
</div>
</auth:showView>

<!-- 弹出添加操作窗口 --> 
<div id="resource_addUpdate_window" style="font-size: 15px;padding: 10px;">   
   	
</div>
	