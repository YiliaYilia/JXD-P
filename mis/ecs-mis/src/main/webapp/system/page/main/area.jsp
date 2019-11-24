<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx }/system/js/area/areaTreeConvert.js"></script>
<script type="text/javascript" src="${ctx }/system/js/area/area.js"></script>
<script type="text/javascript" src="${ctx }/common/js/dateUtil.js"></script>
<style>
	.resourceItem{
		padding-top: 10px;
	}
	.n-invalid {border: 1px solid red;}
</style>
<script type="text/javascript">
//	var data = eval('('+'${areaTrees}'+')');
	var area = new Area();
	$(document).ready(function(){
//			area.createAreaTreeGrid(data);
			area.createAreaTreeGrid();
			area.ctx='${ctx}';
	});


</script>

</head>

<body>

<table id="areaData" width="100%"></table>
<auth:showView permission="RES_ORG_MANAGER_AREA_ADD,RES_ORG_MANAGER_AREA_UPDATE,RES_ORG_MANAGER_AREA_DEL" desc="如果有其中一项，就显示">
<!-- 弹出操作菜单项 -->
	<div id="areaMenu" class="easyui-menu" style="width:110px;display: none" data-options="onClick:area.selectMenu">   
   	<auth:showView permission="RES_ORG_MANAGER_AREA_ADD" desc="控制新增区域"> 
    	<div data-options="iconCls:'icon-add',name:'addAreaMenu'" >添加区域</div>
    </auth:showView>
    <auth:showView permission="RES_ORG_MANAGER_AREA_UPDATE" desc="控制修改区域">    
    	<div data-options="iconCls:'icon-edit',name:'updateAreaMenu'">修改区域</div>
    </auth:showView>
    <auth:showView permission="RES_ORG_MANAGER_AREA_DEL" desc="控制删除区域"> 
    	<div data-options="iconCls:'icon-remove',name:'delAreaMenu'">删除区域</div>  
    </auth:showView>
</div>

</auth:showView>	

<!-- 弹出添加操作窗口 --> 
<div id="area_add_window" style="width: 320px;height: 40px;display: none;font-size: 15px;padding: 10px;">   

</div>  

		
	    	