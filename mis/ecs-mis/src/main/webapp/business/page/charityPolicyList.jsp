<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保单管理</title>
<script type="text/javascript" src="${ctx }/business/js/charityPolicy/policy.js"></script>
<script type="text/javascript" src="${ctx }/system/js/ECSTab.js"></script>
<script type="text/javascript">
var policy = new Policy();
policy.ctx = '${ctx}';
$(document).ready(function(){
	policy.createDataGrid();
});

function searchPolicy(){
	policy.searchData();
}
</script>
</head>

<body>
	<table id="policyData" width="100%"></table>
	<div id="searchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
		<table>
			<tr>
				<td>
					保单号：<input type="text" id="policycode-search" name="policycode" style="width: 120px;" >
				</td>
				<!-- <td>
					产品名称：<select  id="productname-search" name="productname" style="width: 100px;">
							<option value="">请选择</option>
							<option value="瑞泰成长卫士少儿重大疾病保险">瑞泰成长卫士少儿重大疾病保险</option>
							<option value="瑞泰瑞驰交通工具意外伤害保险">瑞泰瑞驰交通工具意外伤害保险</option>
					</select>
				</td> -->
				<td>
					产品名称：<dict:select typeCode="PRODUCTNAME" pleaseChoose="true" name="productname" id="productname-search" style="width: 200px;height:22px;"></dict:select>
				</td>
				<td>
					保单状态：<dict:select typeCode="POLICYSTATUS" pleaseChoose="true" name="paystatus" id="policystatus-search" style="width: 100px;height:22px;"></dict:select>
				</td>
				<td>
					投保人：<input type="text" id="applicantname-search" name="applicantname" style="width: 70px;" >
				</td>
				<td>
					投保日期：<input readonly="readonly" class="Wdate" type="text" id="insuretimebegin-search" name="insuretimebegin" style="width: 100px;cursor: pointer;" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'insuretimeend-search\')||\'%y-%M-%d\'}'})"> 到 
					<input readonly="readonly" class="Wdate" type="text" id="insuretimeend-search" name="insuretimeend" style="width: 100px;cursor: pointer;" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'insuretimebegin-search\')}',maxDate:'%y-%M-%d'})">
				</td>
				<td>&nbsp;&nbsp;</td>
				<td>
					<a id="search" onclick="searchPolicy();" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> 
				</td>
			</tr>
		</table>
	</div>
</body>
</html>