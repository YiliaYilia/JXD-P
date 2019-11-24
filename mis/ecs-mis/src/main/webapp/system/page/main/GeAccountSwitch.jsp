<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${ctx }/system/js/GeAccountSwitch/GeAccountSwitch.js"></script>
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


<table id="userData" width="100%"></table>

<div id="searchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
	<table>
		<tr>
			<td>保单号：<input type="text" id="policynum" onkeydown='if(event.keyCode==13) userManage.searchData()'></td>
			<!-- <td>险种名称：<input type="text" id="productName-search" name="productName" ></td> -->
			<td>账户名称：<input type="text" id="accountName-search" name="accountName" ></td>
			<td> 操作时间：<input readonly="readonly" class="Wdate" type="text" id="makedateBegin-search" name="makedateBegin" style="width: 100px;cursor: pointer;" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'makedateEnd-search\')||\'%y-%M-%d\'}'})"> 到 
			    <input readonly="readonly" class="Wdate" type="text" id="makedateEnd-search" name="makedateEnd" style="width: 100px;cursor: pointer;" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'makedateBegin-search\')}',maxDate:'%y-%M-%d'})"></td>
			<td>&nbsp;&nbsp;</td>    
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