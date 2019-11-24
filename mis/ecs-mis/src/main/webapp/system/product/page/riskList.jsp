<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx }/system/js/ECSTab.js"></script>
<script type="text/javascript" src="${ctx }/system/product/js/risk.js"></script>
<script type="text/javascript" src="${ctx }/common/js/uuid.js"></script>
<style type="text/css">
.riskItem{
		text-align: center;
		height: 30px;
	}
	
	.tabLeft{
		text-align: right;
		height: 40px;
	}
	
	
</style>
<title>产品列表页面</title>

<script type="text/javascript">
	risk.ctx = '${ctx}';
	$(document).ready(function(){
		risk.createRiskTreeGrid();
		//role.formValidate();
	});
	/**
	 *查询资源
	*/
	function searchRisk(){
		risk.searchData();
	}
</script>
<dict:script typeCode="BUSINESSAREA"></dict:script>
</head>
<body>
	
	<!-- 产品列表（数据）表格 -->
	<table id="riskListDatagrid" width="100%" ></table>
	
	
	
	<!-- 新添加查询工具栏目 -->
	<div id="riskSearchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
	<table>
		<tr>
			<td>险种代码:</td>
			<td valign="middle">
				<input type="text" id="serach_riskcode" name="riskcode" style="width: 100px;">
			</td>
			<td>核心险种代码:</td>
			<td valign="middle">
				<input type="text" id="serach_coreriskcode" name="coreriskcode" style="width: 100px;">
			</td>
			<td>险种名称:</td>
			<td valign="middle">
				<input type="text" id="serach_riskname" name="riskname" style="width: 100px;">
			</td>
			<td>业务领域:</td>
			<td valign="middle">
				<dict:select typeCode="BUSINESSAREA" pleaseChoose="true" name="businessarea" id="serach_businessarea" style="width: 100px;height:22px;"></dict:select>
			</td>
			<td>
				<a id="searchrisk" onclick="searchRisk();" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> 
			</td>
		</tr>
	</table>
	</div>
	
	<!-- 弹出添加操作窗口 --> 
	<div id="risk_operator_window" style="background-color:white ;font-size: 15px;padding: 0px;"> 
	</div>
</body>
</html>