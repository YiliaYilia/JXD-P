<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>

<style>
	.organItem{
		padding-top: 10px;
	}
	.n-invalid {border: 1px solid red;}
</style>

</head>
<body>
<script type="text/javascript">
		
</script>
	
	<form  name="" id="updateAreaForm" autocomplete="off">
	
 	<div title="险种责任配置" style="background-color: #FFFFFF;height:85%;padding-left: 30px;padding-top: 10px;">
		<ul id="riskButyConfigTree" class="easyui-tree"></ul>
	</div>
	<div style="padding-top: 20px;text-align: center;" class="RiskItem">
	    <a  class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="updateRiskButyConfig();">保存</a>  
	    <a  class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#riskButy_add_window').window('close');">离开</a>  
	</div>
	</form>
<script type="text/javascript">
$(function(){
	var coreproductcode = $("#coreproductcode").val();
	var businessarea = $("#businessarea").val();
	var data = eval('('+'${productRiskDutyTrees}'+')');
	$('#riskButyConfigTree').tree({
		data: convert(data),
		animate:true,
		lines:true,
		checkbox:true,
		formatter:function(node){
			return node.text;
		}
		
	});
	
	$('#riskButyConfigTree').tree('expandAll');
	
});

function updateRiskButyConfig(){
	var coreproductcode = $("#coreproductcode").val();
	var businessarea = $("#businessarea").val();
	var geRiskButys = $("#riskButyConfigTree").tree('getCheckedExt');
	var data = "";
	for ( var i = 0; i < geRiskButys.length; i++) {
		data = data + "&geRiskButys["+i+"]="+geRiskButys[i].id;
	}
	data = data + "&coreproductcode=" + coreproductcode;
	data = data + "&businessarea=" + businessarea;
	data = data + "&allSelectRisk=" + "${allSelectRisk}";
	data = data + "&allSelectDuty=" + "${allSelectDuty}";
	$.ajax({
		type:"POST",
		url:riskDuty.ctx+"/system/product/updateRiskButyConfig",
		data:data,
		success:function(data){
			$('#riskButy_add_window').window('close');
			
			initializeRiskDuty();
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
}

</script>
</body>
</html>