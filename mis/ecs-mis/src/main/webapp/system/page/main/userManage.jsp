<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>
<script type="text/javascript" src="${ctx }/system/js/userManage/userGrid.js"></script>
<script type="text/javascript" src="${ctx }/system/js/organ/organTreeConvert.js"></script>
<dict:script typeCode="SEX,USERSTATUS,USERTYPE"></dict:script>
<script type="text/javascript">
	userManage.ctx = '${ctx}';
	$(document).ready(function(){
		userManage.createDataGrid();
	});
	/**
	 *查询资源
	*/
	function searchUser(){
		userManage.searchData($("#username-search").val());
	}
</script>
<style type="text/css">
	.tabLeft{
		text-align: right;
		height: 30px;
	}
	.button{
		width: 100%;
		padding-top: 18px;
		clear: both;
	}
</style>
<body>
	<table id="userData" width="100%"></table>
	<div id="searchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
		<table>
			<tr>
				<td>
					&nbsp;&nbsp;用户姓名：<input type="text" id="username-search" name="username" >
				</td>
				<td>
					<a id="search" onclick="searchUser();" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> 
				</td>
			</tr>
		</table>
	</div>
	<div id="operate_window" style="display: none;background-color:white ; font-size: 15px; padding: 10px;overflow:hidden;">
	</div>
</body>
</html>