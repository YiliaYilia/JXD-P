<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${ctx }/system/js/userGroup/userGroup-dataGrid.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>
<style type="text/css">
	.roleItem{
		padding-top: 10px;
	}
	.n-invalid {border: 1px solid red;}
</style>
</head>
<body>
<table id="UserGroupDate" width="100%">

</table>

<div id="searchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
	<table>
		<tr>
			<td>用户组名称：</td>
			<td><input type="text" id="usergroupnameSearch" onkeydown='if(event.keyCode==13) ugp.searchUserGroupData()'></td>
			<td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="ugp.searchUserGroupData()">查询</a></td>
		</tr>
	</table>
</div>


<!-- 弹出添加操作窗口 --> 
<div id="userGroup_add_window" style="background-color:white ;font-size: 15px;padding: 10px;"> 
</div>

<script type="text/javascript">
	//创建表格
	ugp.createDataGrid();
</script>

</body>
</html>