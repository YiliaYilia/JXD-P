<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银行账号修改查询</title>
<script type="text/javascript" src="${ctx}/business/js/bankchange/bankchangeList.js"></script>
<script type="text/javascript" src="${ctx}/system/js/ECSTab.js"></script>
<dict:script typeCode="PAYSTATUS"></dict:script>
<script type="text/javascript">
bankchange.ctx = '${ctx}';
$(document).ready(function(){
	bankchange.createDataGrid();
});
function searchOder(){
	bankchange.searchData();
}
</script>
</head>

<body>
	<table id="orderData" width="100%"></table>
	<div id="searchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
		<table>
			<tr>
				<td>
					保单号&nbsp;&nbsp;&nbsp;&nbsp;：<input type="text" id="policyno-search" name="ordercode" style="width: 100px;">
				</td>
				<td>
					投保人姓名：<input type="text" id="applicantname-search" name="recipientname" style="width: 100px;">
				</td>
				<td>
					修改日期：<input readonly="readonly" class="Wdate" type="text" id="insuretimebegin-search" name="insuretimebegin" style="width: 100px;cursor: pointer;" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'insuretimeend-search\')||\'%y-%M-%d\'}'})"> 
				</td>
				<td>
				    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;到 &nbsp;&nbsp;
				    <input readonly="readonly" class="Wdate" type="text" id="insuretimeend-search" name="insuretimeend" style="width: 100px;cursor: pointer;" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'insuretimebegin-search\')}',maxDate:'%y-%M-%d'})">
				</td>
				<td rowspan="2">
					<a id="search" onclick="searchOder();" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> 
				</td>
			</tr>	
		    
		</table>
	</div>
</body>
</html>