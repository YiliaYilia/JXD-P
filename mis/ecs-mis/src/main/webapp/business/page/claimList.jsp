<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>理赔管理</title>
<script type="text/javascript" src="${ctx }/business/js/claim/claim.js"></script>
<script type="text/javascript" src="${ctx }/system/js/ECSTab.js"></script>
<script type="text/javascript">
var claim = new Claim();
claim.ctx = '${ctx}';
$(document).ready(function(){
	claim.createDataGrid();
});
function searchOder(){
	claim.searchData();
}
</script>
</head>

<body>
	<input type="hidden" id="userid-search" name="userid" value="${user.geUser.userid }"/>
	<table id="claimData" width="100%"></table>
	<div id="searchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
		<table>
			<tr>
				<td>
					保险单号：<input type="text" id="policyCode-search" name="policyCode" >
				</td>
				<td>
					申请人：<input type="text" id="name-search" name="name" >
				</td>
				<td>
					申请时间：<input readonly="readonly" class="Wdate" type="text" id="createDateBegin-search" name="createDateBegin" style="width: 100px;cursor: pointer;" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'createDateEnd-search\')||\'%y-%M-%d\'}'})"> 到 
					<input readonly="readonly" class="Wdate" type="text" id="createDateEnd-search" name="createDateEnd" style="width: 100px;cursor: pointer;" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'createDateBegin-search\')}',maxDate:'%y-%M-%d'})">
				</td>
				<td>
					状态：<dict:select typeCode="STATE" pleaseChoose="true" name="state" id="state-search" style="width: 100px;height:22px;"></dict:select>
				</td>
				<td>&nbsp;&nbsp;</td>
				<td>
					<a id="search" onclick="searchOder();" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> 
				</td>
			</tr>
		</table>
	</div>
</body>
</html>