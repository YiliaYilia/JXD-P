<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.permissionItem{
	padding-top: 10px;
}
.n-invalid {border: 1px solid red;}
</style>
<head>
<script type="text/javascript" src="${ctx }/system/js/permissionManage/permission-dataGrid.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ESC后台管理</title>
</head>
<body>
<table id="permissionData"  width="100%">
	
</table>


<div id="searchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
	<table>
		<tr>
		<td>
			权限名称：
		</td>
		<td  valign="middle">
			<input type="text" id="permissionnameSearch"  onkeydown='if(event.keyCode==13) permission.searchPermissionData()'/>
		</td>
		<td>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick=permission.searchPermissionData()>查询</a>
		</td>
		</tr>
	</table>
</div>

<div id="permissionData_add_window" style="background-color:white ;font-size: 15px;padding: 10px;"> 
</div>

<script type="text/javascript">
//创建表格
permission.createPermissionGrid();
</script>
</body>
</html>