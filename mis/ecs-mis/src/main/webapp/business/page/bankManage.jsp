<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript"	src="${ctx }/business/js/bankmanage/bankmanage.js"></script>
<script type="text/javascript" src="${ctx }/system/js/ECSTab.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>
<script type="text/javascript">
bankManage.ctx = '${ctx}';
$(document).ready(function(){
	bankManage.createDataGrid();
});
function searchbankdata(){
	bankManage.searchbankdata();
}
function clearsearch(){
    $("#searchBankCode").val("");
    $("#searchBankName").val("");
}
</script>
<body>

<table id="bankData" width="100%"></table>

<div id="searchBar"
	style="margin: 0px; padding: 5px; padding-right: 10px; width: 100%; display: none;">
<table>
	<tr>
		<td>银行编码：</td>
		<td><input type="text"	id="searchBankCode" name="bankcodeid"></td>
		<td>付方银行：</td>
        <td><input type="text"	id="searchBankName" name="banknameid"></td>
		<td><a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'" onclick=searchbankdata()>搜索</a></td>
        <td><input type = "button" value = "清空" onclick=clearsearch()></td>
	</tr>
</table></div>

<div id="bankData_add_window"
	style="display:none; font-size: 15px; padding: 10px;">
	<fieldset>
	<legend><strong>银行信息:</strong></legend>
<form name="addUpdateBankDataForm" id="addUpdateBankDataForm"">

	<table border="0">
		<tr valign="top">
			<td><span>银行编码：</span></td>
			<td><input type="text" id="addbankcode"	name="bankcode"></td>
		</tr>
		<tr>
			<td><span>银行名称：</span></td>
			<td><input type="text" id="addbankname" name="bankname"></td>
		</tr>
		<tr>
			<td><span>支付渠道：</span></td>
			<td><input type="text" id="addpaychannel" name="paychannel"></td>
		</tr>
		<tr>
			<td><span>单笔限额：</span></td>
			<td><input type="text" id="addsinglelmt" name="singlelmt"></td>
		</tr>
        <tr>
			<td><span>单日限额：</span></td>
			<td><input type="text" id="adddaylmt" name="daylmt"></td>
		</tr>
		<tr>
            <td><span>可用状态：</span></td>
            <td><select id="addstatus" name="status">
                    <option value = "Y" selected="selected">Y</option>
                    <option value = "N">N</option>
                </select>
            </td>
        </tr>
	</table>
    <input type="hidden" id="operateType" name="operateType" value="">
    <input type="hidden" id="bankID" name="bankID" value="">
</form>
<div align="center" style="width: 500"><a href="#"
	class="easyui-linkbutton" data-options="iconCls:'icon-save'"
	onclick="$('#addUpdateBankDataForm').submit()">保存</a>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
	onclick="$('#bankData_add_window').window('close');">离开</a></div>
</div>
</fieldset>



<div id="upload_window" style="display:none; font-size: 15px; padding: 10px;">
	<fieldset>
	<legend><strong>上传文件:</strong></legend>
    <form name="uploadForm" id="uploadForm" enctype="multipart/form-data">
        <input type="file"	id = "file" name="file">
     </form>
     <span class="tip" style = "color:#ff9955">提示：仅支持Excel格式，最大支持50M</span>
    <div align="center" style="width: 500">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'"
        onclick="$('#uploadForm').submit()">确认</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
        onclick="$('#upload_window').window('close');">取消</a>
     </div>
</div>
</fieldset>

<bankManage:script typeCode="TEMPLATETYPE"></bankManage:script>

</body>
</html>