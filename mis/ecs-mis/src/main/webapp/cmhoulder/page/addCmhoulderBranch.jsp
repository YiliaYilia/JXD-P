<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${ctx}/company/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript"
	src="${ctx}/company/js/jquery.ztree.all-3.5.js"></script>
<script type="text/javascript" src="${ctx}/cmhoulder/js/addCmhoulderBranch.js"></script>
<script type="text/javascript">
	var ctx="${ctx}";
</script>
</head>
<body>
	<form action="${ctx }/cmhoulder/addCmhoulder" method="post" id="form" autocomplete="off"
data-validator-option="{theme:'yellow_right_effect',stopOnError:true}">
	<input type="hidden" name="cmhoulderBranch.cmhdBranchId" id="cmhdBranchId">
		<table>
			<tr>
				<td>用户名/邮箱</td>
				<td><input type="text" name="managerLoginInfo.managerLoginName" data-rule="用户名/邮箱:required;managerLoginInfo.managerLoginName;email"></td>
			</tr>
			<tr>
				<td>身份证号码</td>
				<td><input type="text" name="managerLoginDetail.idno" data-rule="身份证号码:required;managerLoginDetail.idno;ID_card"></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="managerLoginDetail.managerName" data-rule="姓名:required;managerLoginDetail.managerName"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="radio" name="managerLoginDetail.sex" value="1" checked='true'>男<input type="radio" name="managerLoginDetail.sex" value="0">女</td>
			</tr>
			<tr>
				<td>手机号码</td>
				<td><input type="text" name="managerLoginDetail.moblie" data-rule="手机号码:required;managerLoginDetail.moblie;mobile"></td>
			</tr>

			<tr>
				<td>所属机构</td>
				<td><input type="text" name="cmhoulderBranch.cmhdBranchName"
					id="cmhdBranchName" disabled="disabled"></td>
				<td><a href="#" class="easyui-linkbutton"
					data-options="plain:true" onclick="selectCmhoulderTree()">选择</a></td>
			</tr>
			<tr>
				<td colspan="2"><a href="javascript:submit()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">创建</a><a href="javascript:clear()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">重置</a></td>
			</tr>
		</table>
		
		<div id="cmhoulderTree" style="display:none">
			<div id="tree" class="ztree"></div>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="sureCmhoulder()">确定</a><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#cmhoulderTree').window('close')">关闭</a>
		</div>
	</form>
</body>
</html>