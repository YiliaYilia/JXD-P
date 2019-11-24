<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="${ctx }/cmhoulder/js/inquirySheetField.js"></script>
<script type="text/javascript">
	window.onload=function(){
		createIfdDataGrid();
	}
</script>
<script type="text/javascript">

</script>
</head>
<body>
<!-- 	查询添加栏 -->
	<div class="datagrid-toolbar">
	    <table>
	    	<tr>
	    		<td>
	    		<a class="l-btn l-btn-plain" href="javascript:addIFD()">
				<span class="l-btn-left">
				<span class="l-btn-text icon-add l-btn-icon-left">添加</span>
				</span>
				</a>
				</td>
				<td>
				<div class="datagrid-btn-separator"></div>
				</td>
				<td>
					<form id="resetIfdQuery">
					<table>
						<tbody>
							<tr>
								<td>字段名称:：</td>
							<td>
								<input id="IFDName" type="text">
							</td>
							<td>
								<a id="" class="easyui-linkbutton l-btn" onclick="createIfdDataGrid()" data-options="iconCls:'icon-search'" href="#">查询</a>
							</td>
								<td><a href="#"  class="easyui-linkbutton" onclick="$('#resetIfdQuery').form('clear');">重置</a></td>
							</tr>
						</tbody>
					</table>
					</form>
				</td>
	    	</tr>
	    </table>
	</div>
<!-- 	列表信息的显示       -->
		<table id="ifdList" width="100%"></table>
<!-- 	弹出详情的页面     -->
	<div id="ifdDetails" style="display:none;">
		<table id="ifdDetailsView" align="center">
			<tr>
				<td align="right">字段编码：</td>
				<td id="ifdId"></td>
			</tr>
			<tr>
				<td align="right">字段名称：</td>
				<td id="ifdName"></td>
			</tr>
			<tr>
				<td align="right">字段显示形式：</td>
				<td id="ifdType"></td>
			</tr>
			<tr>
				<td><a href="#" id="compileOperate" class="easyui-linkbutton">编辑</a></td>
				<td><a href="#" id="deleteOperate" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a></td>
			</tr>	
		</table>
	</div>
	
<!-- 	弹出修改的页面   -->
	<div id="updatePage" style="display:none;">
	<form action="${ctx}/cmhoulder/updateIFD" method="POST" id="updateIfdForm">
		<table align="center">
			<tr>
				<td align="right">字段编码：</td>
				<td id="updateId"></td>
				<input type="hidden" id="updateIfdId" name="inquiryFieldDictionary.inquiryFieldDictId">
				<input type="hidden" id="updateIfdName1">
			</tr>
			<tr>
				<td align="right">字段名称：</td>
				<td><input type="text" id="updateIfdName" onblur="testInquiryName()" data-rule="required;inquiryName" name="inquiryFieldDictionary.inquiryFieldName"></td>
			</tr>
			<tr>
				<td align="right">字段显示形式：</td>
				<td >
					<select id="updateIfdType" data-rule="required;inquiryFieldDisplayType" name="inquiryFieldDictionary.inquiryFieldDisplayType">
						<option value="1" id="1">文本框</option>
						<option value="2" id="2">文本编辑框</option>
						<option value="3" id="3">Word编辑控件</option>
					</select>
				</td>
			</tr>
		</table>
	</form>
		<div align="center" style="width: 500">
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="updateIfdForm()">修改</a>
			<a href="#"  class="easyui-linkbutton" onclick="resetUpdateIfdForm()">重置</a>
		</div>
	</div>
<!-- 	添加信息 -->
<div id="addPage" style="display:none;">
	<form id="addIfd">
	<table align="center">
		<tr>
			<td align="right">字段编码:</td>
			<td>系统自动生成唯一标识</td>
		</tr>
		<tr>
			<td align="right">字段名称:</td>
			<td><input type="text" id="inquiryFieldName" data-rule="required;inquiryFieldName;"  data-tip="请输入字段名称" name="inquiryFieldName"/>&nbsp&nbsp
		</tr>
		<tr>
			<td align="right">字段值显示形式:</td>
			<td>
			<select name="inquiryFieldDisplayType" id="inquiryFieldDisplayType" data-tip="请做选择" data-inputstatus="error" aria-invalid="true" class="n-invalid" data-rule="required;inquiryFieldDisplayType;" style="width:154px;">
				<option value="0">———请选择————</option>
				<option value="1">———文本框————</option>
				<option value="2">——文本编辑框——</option>
				<option value="3">——Word编辑控件——</option>		
			</select>&nbsp&nbsp
			</td>
		</tr>
	</table>
	</form>
		<div align="center" style="width: 500">
	   		<a id="addIfdbutton" class="easyui-linkbutton" onclick="saveIFD()" data-options="iconCls:'icon-save'" href="#">
				保存
			</a>
			<a id="" class="easyui-linkbutton l-btn" onclick="$('#addPage').window('close');" data-options="iconCls:'icon-cancel'" href="#">
				离开
			</a>
		</div>
</div>
</body>
</html>
