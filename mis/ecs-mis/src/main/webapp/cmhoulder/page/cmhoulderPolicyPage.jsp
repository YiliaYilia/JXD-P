<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/page/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${ctx}/company/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript"
	src="${ctx}/company/js/jquery.ztree.all-3.5.js"></script>
<script type="text/javascript"
	src="${ctx}/cmhoulder/js/boundCmhoulderUserPolicy.js">
	
</script>
<script type="text/javascript">
	var ctx = "${ctx}";
	window.onload=function(){
		createPolicyTable();
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<form method="post" id="form">
	<div id="searchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: block;">
	<table>
		<tr>
		<td>
			保单号：
		</td>
		<td  valign="middle">
			<input name="policy.policyNo" type="text" id="policyNo1">
		</td>
		<td>
			保险公司名称：
		</td>
		<td  valign="middle">
			<input name="policy.insuranceCompanyName" type="text" id="insuranceCompanyName">
		</td>
		<td>
			产品名称:
		</td>
		<td  valign="middle">
			<input type="text" name="policy.productName" id="productName">
		</td>
		<td>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="createPolicyTable()">查询</a><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form').form('clear')">清空</a>
		</td>
		</tr>
		<tr>
			<td valign="middle">
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="selectCmhoulder()">选择海达经办人</a>
			</td>
			<td valign="middle">
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="boundPolicy()">绑定保单</a>
			</td>
			<td>
				<span id="showCmhoulderBranchName"></span>
			</td>
			<td>
				<span id="showManagerLoginName"></span><input type="hidden" id="managerId" name="managerLoginInfo.managerId">
			</td>
		</tr>
	</table>
</div>
</form>
	<table id="createPolicyTable"  width="100%">
	</table>
	<div id="selectCmhoulderUser_add_window"
		style="background-color: white; font-size: 15px; padding: 10px;display:none;">
		
		<div style="display:none;float:left;width:50%" id="showTreeDiv" >
			<div id="tree" class="ztree"></div>
		</div>
	<div style="float:right;width:50%;display:none;" id="managerLoginInfo">
	</div>
	<a onclick="sureSelectManagerLoginInfo()"  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">确定</a>
<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#selectCmhoulderUser_add_window').window('close')">关闭</a>
</div>

	
</body>
</html>