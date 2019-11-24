<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${ctx }/system/js/dateChange/dateChange.js"></script>
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
<table id="userData" width="100%">

</table>

<div id="searchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
	<table>
		<tr>
			<td>证件号：</td>
			<td><input type="text" id="cardNo" onkeydown='if(event.keyCode==13) userManage.searchData()'></td>
			<td>
					变更日期：<input readonly="readonly" class="Wdate" type="text" id="insuretimebegin-search" name="insuretimebegin" style="width: 100px;cursor: pointer;" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'insuretimeend-search\')||\'%y-%M-%d\'}'})"> 到 
					<input readonly="readonly" class="Wdate" type="text" id="insuretimeend-search" name="insuretimeend" style="width: 100px;cursor: pointer;" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'insuretimebegin-search\')}',maxDate:'%y-%M-%d'})">
				</td>
			<td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="userManage.searchData()">查询</a></td>
			
		</tr>
		
	</table>
</div>


<script type="text/javascript">
	//创建表格
	userManage.createDataGrid();
</script>

</body>
</html>