<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
<dict:script typeCode="SEX,USERSTATUS,USERTYPE"></dict:script>
</head>
<body>
<div style="height:270px;"> 
<form name="userManageForm" id="userManageForm">
	<c:if test="${userInfo.userid != null }">
		<input type="hidden" value="${userInfo.userid }" name="geUser.userid" id="userid">
	</c:if>
	<table style="margin-left: 10px;">
		<tr>
			<td class="tabLeft">用户名：</td>
			<td>
				<c:if test="${userInfo.userid != null }">
					${userInfo.username }
					<input type="hidden" value="${userInfo.username }" id="username" name="geUser.username">
					<span style="margin-left:20px;color:red;cursor: pointer;" onclick="canclerepwd();" id="canclerepwd">取消修改密码</span>
				</c:if>
				<c:if test="${userInfo.userid == null }">
					<input type="text" id="username" name="geUser.username">
				</c:if>
			</td>
		</tr>
		<tr id="repwdbtn" style="display: none;">
			<td class="tabLeft">密 码：</td>
			<td><span style="color:red;cursor: pointer;" onclick="repwdclick();" id="repwdbtn">修改密码</span></td>
		</tr>
		<tr id="pwdinput">
			<td class="tabLeft">密 码：</td>
			<td><input type="text" id="password" name="geUser.password"></td>
		</tr>
		<tr id="againpwdinput">
			<td class="tabLeft">确认密码：</td>
			<td><input type="text" id="againpwd" name="againpwd"></td>
		</tr>
		<tr>
			<td class="tabLeft">性别：</td>
			<td>
			<c:if test="${userInfo.sex == null }">
				<dict:radio typeCode="SEX" type="radio" name="geUser.sex" defaultValue="M"></dict:radio>
			</c:if>
			<c:if test="${userInfo.sex != null }">
				<dict:radio typeCode="SEX" type="radio" name="geUser.sex" defaultValue="${userInfo.sex }"></dict:radio>
			</c:if>
			</td>
		</tr>
		<tr>
			<td class="tabLeft">电子邮箱：</td>
			<td><input type="text" value="${userInfo.email }" id="email" name="geUser.email"></td>
		</tr>
		<tr>
			<td class="tabLeft">电话：</td>
			<td><input type="text" value="${userInfo.phone }" id="phone" name="geUser.phone"></td>
		</tr>
	</table>
</form>
</div>
<div style="padding-left: 80px;padding-top: 10px;" class="userDataItem">
    <a class="easyui-linkbutton" style="color: #444" data-options="iconCls:'icon-save'"  onclick="$('#userManageForm').submit();">保存</a>
    <a class="easyui-linkbutton" style="color: #444" data-options="iconCls:'icon-reload'"  onclick="$('#userManageForm').form('reset');">重置</a>
    <a class="easyui-linkbutton" style="color: #444" data-options="iconCls:'icon-cancel'" onclick="$('#alterUserInfo_windows').window('close');">关闭</a>  
</div>
	<script type="text/javascript">
		var userInfo = new UserInfo();
		$(function(){
			userInfo.formValidate();
			userInfo.ctx = '${ctx }';
			userInfo.opPwdInput('hide');
		});
		
		function repwdclick() {
			userInfo.opPwdInput();
		}
		function canclerepwd() {
			userInfo.opPwdInput('hide');
		}
	</script>
</body>
</html>