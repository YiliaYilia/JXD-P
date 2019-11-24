<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" src="${ctx }/system/js/dictManage/dict-type-dataGrid.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>
<body>

<table id="dicttype" width="100%">
	
</table>

<div id="searchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
	<table>
		<tr>
			<td>类型名称：</td>
			<td><input type="text" id="dictTypeName-search"></td>
			<td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick=dicttype.searchDictTypeData()>搜索</a></td>
		</tr>
	</table>
</div>


<div id="dictTypeData_add_window"
	style="display: none; font-size: 15px; padding: 10px;">
	<form  name="addUpdateDictTypeForm" id="addUpdateDictTypeForm">
	<fieldset>
				<legend><strong>字典类型信息:</strong></legend>
	<table border="0">
		<tr valign="top">
			<td><span>类型代码：</span></td>
			<td><input type="text" id="dictTypeCode" name="dictTypeCodeAuth"></td>
			</tr>
		<tr>
			<td><span>类型名称：</span></td>
			<td><input type="text" id="dictTypeName" name="dictTypeNameAuth"></td>
		</tr>
	</table>
	<input type="hidden" id="dictTypeID" value="">
	<input type="hidden" id="oldCode" name="oldCode" value="">
	<input type="hidden" id="operateType" name="operateType" value="">
	<div align="center" style="width: 500"><a href="#"
		class="easyui-linkbutton" data-options="iconCls:'icon-save'"
		onclick="$('#addUpdateDictTypeForm').submit()">保存</a> <a href="#" class="easyui-linkbutton"
		data-options="iconCls:'icon-cancel'"
		onclick="$('#dictTypeData_add_window').window('close');")>离开</a></div>
	</fieldset>
	</form>
</div>
<script type="text/javascript">
	//创建表格
	dicttype.createDataGrid();
</script>
</body>
</html>