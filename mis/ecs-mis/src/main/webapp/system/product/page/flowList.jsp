<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售流程</title>
<script type="text/javascript" src="${ctx }/system/product/js/flow/flowDefine.js"></script>
<script type="text/javascript">
	flowDefine.ctx = '${ctx}';
	$(document).ready(function(){
		flowDefine.createDataGrid();
	});
	/**
	 *查询资源
	*/
	function searchFlow(){
		flowDefine.searchData($("#flowname-search").val());
	}
</script>
</head>
<body>
	<table id="flowData" width="100%"></table>
	<div id="searchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
		<table>
			<tr>
				<td>
					&nbsp;&nbsp;流程名称：<input type="text" id="flowname-search" name="flowname" >
				</td>
				<td>
					<a id="search" onclick="searchFlow();" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> 
				</td>
			</tr>
		</table>
	</div>
	<div id="operate_window" style="display: none;background-color:white ; font-size: 15px; padding: 10px;overflow:hidden;">
	</div>
</body>
</html>