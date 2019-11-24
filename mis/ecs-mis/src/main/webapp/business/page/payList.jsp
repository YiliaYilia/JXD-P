<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>对账管理</title>
<script type="text/javascript" src="${ctx }/business/js/paylist/paylist.js"></script>
<script type="text/javascript" src="${ctx }/system/js/ECSTab.js"></script>
<dict:script typeCode="PAYSTATUS"></dict:script>
<script type="text/javascript">
order.ctx = '${ctx}';
$(document).ready(function(){
	order.createDataGrid();
});
function searchOder(){
	order.searchData();
}
</script>
</head>

<body>
	<table id="orderData" width="100%"></table>
	<div id="searchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
		<table>
			<tr>
				<td>
					订单号：<input type="text" id="ordercode-search" name="ordercode" >
				</td>
				<td>
					投保人姓名：<input type="text" id="applicantname-search" name="applicantname-search" >
				</td>
				<td>
					保单号：<input type="text" id="policyno-search" name="policyno-search" >
				</td>
				<!-- <td>
					是否退款：<select typeCode="PAYSTATUS" pleaseChoose="true" name="isback" id="isback-search" style="width: 100px;height:22px;">
						<option value="">请选择</option>
							<option value="0">未退款</option>
							<option value="1">已退款</option>
					</select>
				</td> -->
				<td>
					是否退款：<dict:select typeCode="ISBACK" pleaseChoose="true" name="isback" id="isback-search" style="width: 100px;height:22px;"></dict:select>
				</td>
				<td>
					交易日期：<input readonly="readonly" class="Wdate" type="text" id="insuretimebegin-search" name="insuretimebegin" style="width: 100px;cursor: pointer;" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'insuretimeend-search\')||\'%y-%M-%d\'}'})"> 到 
					<input readonly="readonly" class="Wdate" type="text" id="insuretimeend-search" name="insuretimeend" style="width: 100px;cursor: pointer;" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'insuretimebegin-search\')}',maxDate:'%y-%M-%d'})">
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