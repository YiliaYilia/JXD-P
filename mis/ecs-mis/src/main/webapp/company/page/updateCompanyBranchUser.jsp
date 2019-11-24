<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${ctx}/company/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript"
	src="${ctx}/company/js/jquery.ztree.all-3.5.js"></script>
<script type="text/javascript" src="${ctx}/company/js/listCompanyBranchUser.js"></script>
<script type="text/javascript">
	var ctx="${ctx}";
	window.onload=function(){
		createTable();
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="${ctx }/company/queryCompanyUser" method="post">
		登录账户：<input name="loginInfo.loginMail" type="text" valign="middle"
			value="${loginInfo.loginMail}" id="loginEmail"> 用户姓名：<input
			name="loginInfo.loginName" type="text"
			value="${loginInfo.loginName }" id="loginName"></br> 所属机构：<input
			name="companyBranch.comBranchName" type="text"
			value="${companyBranch.comBranchName}" id="comBranchName">
		冻结状态：<select name="loginInfo.status" id="status">
		<option value=""
				${loginInfo.status == '' ? 'selected="selected"' :''}>全部</option>
			<option value="1"
				${loginInfo.status == '1' ? 'selected="selected"' :''}>未冻结</option>
			<option value="0"
				${loginInfo.status == '0' ? 'selected="selected"' :''}>已冻结</option>
			
		</select> <br><input value="查询" type="button" onclick="createTable()"> <input type="reset"
			value="清空">
	</form>
<table id="createTable" width="100%">
</table>
	<div id="permissionData_add_window"
		style="background-color: white; font-size: 15px; padding: 10px;">
	</div>
</body>
</html>
