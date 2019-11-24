<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单管理</title>
<script type="text/javascript" src="${ctx }/business/js/order/order.js"></script>
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
<input type="hidden" id="userid-search" name="userid" value="${user.geUser.userid }"/>
	<table id="orderData" width="100%"></table>
	<div id="searchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
		<table>
			<tr>
				<td>
					订单号&nbsp;&nbsp;&nbsp;&nbsp;：<input type="text" id="ordercode-search" name="ordercode" style="width: 100px;">
				</td>
				<td>
					支付状态&nbsp;&nbsp;&nbsp;&nbsp;：<dict:select typeCode="PAYSTATUS" pleaseChoose="true" name="paystatus" id="paystatus-search" style="width: 100px;height:22px;"></dict:select>
				</td>
				<td>
					对账状态：<dict:select typeCode="ACCOUTNSTATUS" pleaseChoose="true" name="accoutnstatus" id="accoutnstatus-search" style="width: 100px;height:22px;"></dict:select>
				</td>
				<td>
					投保日期：<input readonly="readonly" class="Wdate" type="text" id="insuretimebegin-search" name="insuretimebegin" style="width: 100px;cursor: pointer;" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'insuretimeend-search\')||\'%y-%M-%d\'}'})"> 
				</td>
				<td rowspan="2">
					<a id="search" onclick="searchOder();" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> 
				</td>
			</tr>	
		    <tr>
				<td>
					产品名称：<dict:select typeCode="PRODUCTNAME" pleaseChoose="true" name="productname" id="productname-search" style="width: 100px;height:22px;"></dict:select>
				</td>
				<td>
					投保人姓名：<input type="text" id="recipientname-search" name="recipientname" style="width: 100px;">
				</td>
				<td>
					组织机构：<select  id="deptid-search" name="deptid" style="width: 100px;">
					        <option value="">请选择</option>
					        <c:forEach items="${departmentList }" var="department">
							<option value="${department.deptid }">${department.deptname }</option>
							</c:forEach>
					</select>
				</td>
				<td>
				    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;到 &nbsp;&nbsp;
				    <input readonly="readonly" class="Wdate" type="text" id="insuretimeend-search" name="insuretimeend" style="width: 100px;cursor: pointer;" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'insuretimebegin-search\')}',maxDate:'%y-%M-%d'})">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>