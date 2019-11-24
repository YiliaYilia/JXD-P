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
<script type="text/javascript" src="${ctx}/company/js/listCompanyBranch.js"></script>
<script type="text/javascript">
var data = eval('('+'${companyBranchs}'+')');
var ctx="${ctx}";
</script>
<style type="text/css">
div#rMenu {position:absolute; visibility:hidden; top:0; background-color: #555;text-align: left;padding: 2px;}
div#rMenu li{
	margin: 1px 0;
	padding: 0 5px;
	cursor: pointer;
	list-style: none outside none;
	background-color: #DFDFDF;
}
	</style>
</head>
<body>
<div id="tree" class="ztree" style="float:left;width:40%;"></div>
<div id="companyBranchDetail" style="float:right;width:50%;display:none;line-height: -30px">
	<table border="1" >
		<tr>
				<td>机构编号</td>
				<td id="comBranchId1"></td>
			</tr>
			<tr>
				<td>机构名称</td>
				<td id="comBranchName1"></td>
			</tr>
			<tr>
				<td>企业机构代码</td>
				<td id="comBranchNo1"></td>
			</tr>

			<tr>
				<td>机构等级</td>
				<td id="level1"></td>
			</tr>
			<tr>
				<td>机构描述</td>
				<td id="comBranchDesc1"></td>
			</tr>
			<tr>
				<td>所属区域</td>
				<td id="area"></td>
			</tr>
	</table>
</div>
<div id="rMenu">
		<li id="updateCompanyBranch" onclick="updateCompanyBranch();">修改</li>
		<li id="deleteCompanyBranch" onclick="deleteCompanyBranch();">删除</li>
</div>
<div id="addCompanyBranchData_add_window"
		style="background-color: white; font-size: 15px; padding: 10px;display:none;">
	<table style="margin-top: 10px;">
			<tr>
				<td>机构编号</td>
				<td id="comBranchId"></td>
			</tr>
			<tr>
				<td>机构名称</td>
				<td><input type="text" id="comBranchName"></td>
			</tr>
			<tr>
				<td>企业机构代码</td>
				<td><input type="text" id="comBranchNo"></td>
			</tr>

			<tr>
				<td>机构等级</td>
				<td id="level"></td>
			</tr>
			<tr>
				<td>机构描述</td>
				<td><input type="text" id="comBranchDesc"></td>
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
		<td colspan="2"><div style="text-align: center;" class="roleItem">
		    <a  class="easyui-linkbutton" data-options="iconCls:'icon-save'"  onclick="updateCompanyBranch_1()">修改</a>
		    <a  class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="resert()">重置</a></td>
	</tr>
	</table>
</div>
</body>
</html>