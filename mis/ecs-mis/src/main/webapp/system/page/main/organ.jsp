<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${ctx }/system/js/organ/organTreeConvert.js"></script>
<script type="text/javascript" src="${ctx }/system/js/organ/organ.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
		var data = eval('('+'${organTrees}'+')');
		var organ = new Organ();
		$(document).ready(function(){
			organ.createOrganTreeGrid(data);
			organ.ctx='${ctx}';
			organ.formValidate();
		});
</script>
<style>
	.organItem{
		padding-top: 10px;
	}
	.n-invalid {border: 1px solid red;}
</style>
</head>
<dict:script typeCode="DEPARTMENTTYPE"></dict:script>
<body>
<table id="organList" width="100%"></table>  

<auth:showView permission="RES_ORG_MANAGER_ORG_ADD,RES_ORG_MANAGER_ORG_DEL,RES_ORG_MANAGER_ORG_UPDATE,RES_ORG_MANAGER_ORG_VIEW" desc="如果有其中一项，就显示">
<!-- 弹出操作菜单项 -->
<div id="organMune" class="easyui-menu" style="width:110px;display: none" data-options="onClick:organ.selectMenu">   
   	<auth:showView permission="RES_ORG_MANAGER_ORG_ADD" desc="添加"> 
    	<div data-options="iconCls:'icon-add',name:'addOrganMenu'" >添加</div>
    </auth:showView>
    <auth:showView permission="RES_ORG_MANAGER_ORG_UPDATE" desc="修改">    
    	<div data-options="iconCls:'icon-edit',name:'updateOrganMenu'">修改</div>
    </auth:showView>
    <auth:showView permission="RES_ORG_MANAGER_ORG_DEL" desc="删除"> 
    	<div data-options="iconCls:'icon-remove',name:'delOrganMenu'">删除</div>  
    </auth:showView>
</div>
</auth:showView>

<!-- 弹出添加操作窗口 --> 
<div id="organ_add_window" style="font-size: 15px;padding: 10px;">   
   
</div>
	    	