<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx }/system/js/record/record.js"></script>
<title>角色管理</title>
<script type="text/javascript">
	var record = new Record();
	record.ctx = '${ctx}';
	$(document).ready(function(){
		record.createRecordTreeGrid();
	
	});
	/**
	 *查询日志
	*/
	function searchRecords(){
		record.searchData();
	}
</script>
<style type="text/css">
	.roleItem{
		padding-top: 10px;
	}
	.n-invalid {border: 1px solid red;}
</style>
</head>
<body>



	<!-- 操作日志（数据）表格 -->
	<table id="RecordDatagrid" width="100%" ></table>
	
	
	
	<!-- 新添加查询工具栏目 -->
	<div id="searchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
	<table>
		<tr>
			<td>
				创建日期：
			</td>
			<td>
				<input id="startTime" data-options="editable:false" type="text" class="easyui-datebox" readonly="readonly"></input>  
			</td>
			<td>
				至<input id="endTime" data-options="editable:false" type="text" class="easyui-datebox"  readonly="readonly"></input>  
			</td>
			<td>操作人:</td>
			<td valign="middle">
				<input type="text" id="operatorName" >
			</td>
			<td>
				<a id="search" onclick="searchRecords();" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> 
			</td>
		</tr>
	</table>
	</div>
	
</body>
</html>