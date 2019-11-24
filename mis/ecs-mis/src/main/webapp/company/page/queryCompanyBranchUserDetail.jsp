<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="../../common/page/common.jsp"%>
	<%@ taglib prefix="c" uri="core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Insert title here</title>
</head>
<body>

<form method="post" id="form" autocomplete="off"
data-validator-option="{theme:'yellow_right_effect',stopOnError:true}">
<table>
	<input name="loginInfo.userid" value=${loginInfo.userid } type="hidden">
	<input name="companyBranch.comBranchId" value="${loginInfo.companyBranchUser[0].companyBranch.comBranchId }" type="hidden" id="comBranchId">
	<input name="customerLoginDetail.id" value="${loginInfo.customerLoginDetail.id }" type="hidden" >
	<input name="customerLoginDetail.loginName" value="${loginInfo.customerLoginDetail.loginName }" type="hidden" id="name">
	<input name="companyBranchUser.id" value="${loginInfo.companyBranchUser[0].id }" type="hidden">
	<input name="loginInfo.password" value="${loginInfo.password }"type="hidden">
	<tr>
	<td>用户名/邮箱</td>
	<td><input type="text" name="loginInfo.loginMail" id="_loginEmail" value="${loginInfo.loginMail }" disabled="disabled" ></td>
	</tr>
	<tr>
	<td>身份证号码</td>
	<td><input type="text" id="idno" name="customerLoginDetail.idno" data-rule="身份证号码:required;managerLoginDetail.idno;ID_card" value="${loginInfo.customerLoginDetail.idno }" disabled="disabled"></td>
	</tr>
	<tr>
	<tr>
	<td>用户姓名</td>
	<td><input type="text" name="loginInfo.loginName" id="_loginName" value="${loginInfo.loginName }" data-rule="姓名:required;loginInfo.loginName" disabled="disabled"></td>
	</tr>
	<tr>
	<td>性别</td>
	<td id="td1">
	<c:if test="${loginInfo.customerLoginDetail.sex == 1 }">
		<span id="men">男</span>
	</c:if>
	<c:if test="${loginInfo.customerLoginDetail.sex == 0}">
		<span id="women">女</span>
	</c:if>
	</td>
	<td id="td2" style="display:none">
	<input type="radio"   id="mens" name="customerLoginDetail.sex" value="1"  ${loginInfo.customerLoginDetail.sex == '1' ? "checked='checked'" : '' }>男<input type="radio" id= "womens" name="customerLoginDetail.sex" value="0"  ${customerLoginDetail.sex == '0' ? "checked='checked'" : ''}>女</td>
	</tr>
	<tr>
	<tr>
	<td>联系电话</td>
	<td><input type="text" name="customerLoginDetail.mobile" id="_mobile" value="${loginInfo.customerLoginDetail.mobile }"  disabled="disabled" data-rule="手机号码:required;customerLoginDetail.mobile;mobile"></td>
	</tr>
	<tr>
	<tr>
	<td>所属机构</td>
	<td><input type="text" id="_companyBranch" name="companyBranch.comBranchName" value="${loginInfo.companyBranchUser[0].companyBranch.comBranchName}" disabled="disabled" id="comBranchName"></td><td><a href="#" class="easyui-linkbutton" id="b" onclick="button()" style="display:none" data-options="plain:true">选择</a></td>
	</tr>
</table>
</form>
<div style="display:none;" id="showTreeDiv">
<div id="tree" class="ztree"></div>
<a class="easyui-linkbutton" id="sureCompany" onclick="sureCompany()">确定</a>
</div>
<br>
<div id="div1">
<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="update()" id="update">编辑</a>
<a href="javascript:loginFreeze('${loginInfo.userid}')" class="easyui-linkbutton" id="freeze">冻结账号</a>
<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#permissionData_add_window').window('close');">关闭</a>
</div>
<div id="div2" style="display:none">
<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-back'" onclick="back()"  id="back">返回</a>
<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submit()"  id="submit">修改</a>
<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-back'" onclick="$('form').form('reset')"  id="reset">重置</a>
<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#permissionData_add_window').window('close');">关闭</a>
</div>

</body>

</html>