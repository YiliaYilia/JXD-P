<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript"
	src="${ctx }/system/js/dictManage/dict-dataGrid.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>
<body>

<table id="dictData" width="100%">

</table>

<div id="searchBar"
	style="margin: 0px; padding: 5px; padding-right: 10px; width: 100%; display: none;">
<table>
	<tr>
		<td>所属类型：</td>
		<td>
		<div id="searchComboBox"><input class="easyui-combobox"
			id="dicttypeid-search" name="dicttypeid"
			data-options="
		                method: 'get',
		                valueField: 'id',
		                textField: 'text',
		                formatter: dict.formatItem
		            "></div>
		</td>
		<td><a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'" onclick=dict.searchDictData()>搜索</a></td>
	</tr>
</table>
</div>

<div id="dictData_add_window"
	style="display: none; font-size: 15px; padding: 10px;">
	<fieldset>
	<legend><strong>字典信息:</strong></legend>
<form name="addUpdateDictDataForm" id="addUpdateDictDataForm"">

	<table border="0">
		<tr valign="top">
			<td><span>所属类型：</span></td>
			<td><input class="easyui-combobox" id="dicttypeid-cbx"
				name="dicttypeid"
				data-options="
		                method: 'get',
		                valueField: 'id',
		                textField: 'text',
			            editable:false,
		                formatter: dict.formatItem
		            "></td>
		</tr>
		<tr>
			<td><span>代码：</span></td>
			<td><input type="text" id="dictDataCode" name="dictDataCodeAuth"></td>
		</tr>
		<tr>
			<td><span>内容：</span></td>
			<td><input type="text" id="dictDataName" name="dictDataNameAuth"></td>
		</tr>
		<tr>
			<td><span>描述：</span></td>
			<td><input type="text" id="dictDataDesc" name="dictDataDescAuth"></td>
		</tr>
	
	</table>
	<input type="hidden" id="oldCode" name="oldCode" value=""> <input
		type="hidden" id="oldID" name="oldID" value=""> <input
		type="hidden" id="dictDataID" value=""> <input type="hidden"
		id="operateType" name="operateType" value="">

</form>
<div align="center" style="width: 500"><a href="#"
	class="easyui-linkbutton" data-options="iconCls:'icon-save'"
	onclick="$('#addUpdateDictDataForm').submit()">保存</a> 
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
	onclick="$('#dictData_add_window').window('close');">离开</a></div>
</div>
</fieldset>
<dict:script typeCode="TEMPLATETYPE"></dict:script>
<script type="text/javascript">
	//创建表格
	dict.createDataGrid();
</script>
</body>
</html>