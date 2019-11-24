<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>追加投资查询</title>
<script type="text/javascript" src="${ctx }/business/js/investment/investment.js"></script>
<script type="text/javascript" src="${ctx }/system/js/ECSTab.js"></script>
<dict:script typeCode="PAYSTATUS"></dict:script>
<script type="text/javascript">
investment.ctx = '${ctx}';
$(document).ready(function(){
	investment.createDataGrid();
});
function searchInvestment(){
	investment.searchData();
}
</script>
</head>

<body>
<input type="hidden" id="userid-search" name="userid" value="${user.geUser.userid }"/>
	<table id="investmentData" width="100%"></table>
	<div id="searchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
		<table>
			<tr>
				<td>
					保单号：<input type="text" id="policyNo-search" name="policyNo" style="width: 100px;">
				</td>
				<td>
					投保人：<input type="text"   name="applicantName" id="applicantName-search" style="width: 100px;">
				</td>
				<td>
					追加日期：<input readonly="readonly" class="Wdate" type="text" id="startTime-search" name="startTime" style="width: 100px;cursor: pointer;" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime-search\')||\'%y-%M-%d\'}'})"> 
				</td>
				<td>
				    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;到 &nbsp;&nbsp;
				    <input readonly="readonly" class="Wdate" type="text" id="endTime-search" name="endTime" style="width: 100px;cursor: pointer;" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startTime-search\')}',maxDate:'%y-%M-%d'})">
				</td>
				<td>
					<a id="search" onclick="searchInvestment();" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> 
				</td>
			</tr>
		</table>
	</div>
</body>
</html>