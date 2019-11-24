<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${ctx}/company/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${ctx}/company/js/jquery.ztree.all-3.5.js"></script>

<script type="text/javascript" src="${ctx}/company/js/addLoginInfo.js"></script>
<script type="text/javascript">
	var ctx="${ctx}";
	window.onload=function(){
		tree.root();
		$("#form").form('clear');
		formValidate();
	}
</script>
<title>Insert title here</title>
</head>
<body>
<div id="">
<form method="post" id="form" autocomplete="off"
data-validator-option="{theme:'yellow_right_effect',stopOnError:true}">
<input type="hidden" name="companyBranch.comBranchId" id="comBranchId_1">
<input type="hidden" name="customerLoginDetail.loginName" id="detailLoginName">
<table style="margin-top: 10px;">
	<tr>
	<td class="tabLeft">用户名/邮箱</td>
	<td><input type="text" name="loginInfo.loginMail" id="loginMail" data-rule="用户名/邮箱:required;loginInfo.loginMail;email"></td>
	</tr>
	<tr>
	<td class="tabLeft">身份证号码</td>
	<td><input type="text" name="customerLoginDetail.idno" id="idno" data-rule="身份证号码:required;managerLoginDetail.idno;ID_card"></td>
	</tr>
	<tr>
	<tr>
	<td class="tabLeft">用户姓名</td>
	<td><input type="text" name="loginInfo.loginName" id="infoLoginName" data-rule="姓名:required;loginInfo.loginName"></td>
	</tr>
	<tr>
	<td class="tabLeft">性别</td>
	<td><input type="radio" name="customerLoginDetail.sex" value="1" checked='true'>男<input type="radio" name="customerLoginDetail.sex" value="0">女</td>
	</tr>
	<tr>
	<tr>
	<td class="tabLeft">联系电话</td>
	<td><input type="text" name="customerLoginDetail.mobile" id="mobile" data-rule="手机号码:required;customerLoginDetail.mobile;mobile"></td>
	</tr>
	<tr>
	<td class="tabLeft">所属机构</td>
	<td><input type="text" id="companyBranch" name="companyBranch.conBranchName" disabled="disabled"></td><td><a href="#" class="easyui-linkbutton" data-options="plain:true" id="button">选择</a></td>
	
	</tr>
	<tr>
	<td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submit()">创建</a><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#form').form('clear')">重置</a></td>
	</tr>
</table>
<div style="display:none;" id="showTreeDiv">
<div id="tree" class="ztree"></div>
<a onclick="p()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" id="sureCompany">确定</a>
</div>
</form>
</div>
</body>
</html>