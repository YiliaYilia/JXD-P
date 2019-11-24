<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${ctx}/company/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript"
	src="${ctx}/company/js/jquery.ztree.all-3.5.js"></script>
<script type="text/javascript" src="${ctx}/company/js/addCompanyBranch.js"></script>
<script type="text/javascript">
	var data=eval('(' + '${companyBranchs}' + ')');
	var ctx="${ctx}";
</script>

<style type="text/css">
div#rMenu {
	position: absolute;
	visibility: hidden;
	top: 0;
	background-color: #FAFAFA;
	text-align: left;
	padding: 2px;
}

div#rMenu li {
	margin: 0px 0;
	padding: 0 0px;
	cursor: pointer;
	list-style: none outside none;
	background-color: #ABABAB;
}
</style>
</head>
<body>
	<div id="tree" class="ztree"></div>
	<div id="rMenu">
		<li id="addSameLevelMenu" onclick="addSameLevelMenu();">添加同级菜单</li>
		<li id="addLowerLevelMenu" onclick="addLowerLevelMenu();">添加下级菜单</li>
	</div>

<div id="addCompanyBranchData_add_window"
		style="background-color: white; font-size: 15px; padding: 10px; display: none;">
<form id="form" method="post" autocomplete="off"
data-validator-option="{theme:'yellow_right_effect',stopOnError:true}">
		<table style="margin-top: 10px;">
			<tr>
				<td>机构编号</td>
				<td id="comBranchId"></td>
			</tr>
			<tr>
				<td>机构名称</td>
				<td><input type="text" id="comBranchName" data-rule="机构名称:required;comBranchName"></td>
			</tr>
			<tr>
				<td>企业机构代码</td>
				<td><input type="text" id="comBranchNo" data-rule="企业机构代码:required;comBranchNo"></td>
			</tr>
			<tr>
				<td>机构等级</td>
				<td id="level"></td>
			</tr>
			<tr>
				<td>机构描述</td>
				<td><input type="text" id="comBranchDesc" data-rule="机构描述:required;comBranchDesc"></td>
			</tr>
			<tr>
				<td>所属区域</td>
				<td>
				<select id='province'>
				<option>请选择省</option>
				</select>
				<select id='city'>
				<option>请选择市</option>
				</select>
				<select id='area'>
				<option>请选择县/镇</option>
				</select></td>
			</tr>
			
			<tr>
				<td colspan="2">
			<div style="text-align: center;" class="roleItem">
		    <a  class="easyui-linkbutton" data-options="iconCls:'icon-save'"  onclick="addCompanyBranch()">创建</a>
		    <a  class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#addCompanyBranchData_add_window').window('close')">离开</a>  
		</div></td>
			</tr>
		</table>
</form>
	</div>

</body>
</html>