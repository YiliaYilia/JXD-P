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
</head>
<script type="text/javascript" src="${ctx}/cmhoulder/js/boundCompanyBranch.js"></script>
<script type="text/javascript">
	var ctx="${ctx}";
	window.onload=function(){
		createTable();
	}
</script>
<body>
<table id="createCmhoulderBoundCompanyBranchTable" width="100%"></table>
	<table>
		<input type="hidden" id="managerId">
	</table>
	<div id="permissionData_add_window"
		style="background-color: white; font-size: 15px; padding: 10px;">
	</div>
</body>

</html>