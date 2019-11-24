<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx }/business/js/charityOrder/orderInfo.js"></script>
<script type="text/javascript" src="${ctx }/system/js/ECSTab.js"></script>
<title>订单详情</title>
<script type="text/javascript">
	orderInfo.ctx = '${ctx}';
	orderInfo.orderno = '${order.orderno}';
	$(document).ready(function(){
		var isfirst = 0;
		$('#orderInfo').tabs({
			onSelect: function(title,index){
				if(index == 1 && isfirst == 0){
					orderInfo.createDataGrid();
					isfirst = 1;
				}
			}
		});
		$('#basic').propertygrid({
			fit:true,
			fitColumns:true,
			showGroup:true,
			columns: [[
			            { title: "订单信息", field: "name",width:15 },
			            { title: "", field: "value",width:80 }
			        ]]
		});
	});
</script>
</head>
<body>
	<div id="orderInfo" class="easyui-tabs" data-options="tabPosition:'top',fit:true,plain:true,border:false" >
		<div title="基本信息" data-options="fit:true">
			<table class="easyui-propertygrid" id="basic">
				<tr>
					<td></td>
					<td>订单号</td>
					<td>${order.ordercode }</td>
				</tr>
				<tr>
					<td></td>
					<td>订单总额</td>
					<td>${order.orderamount }</td>
				</tr>
				<tr>
					<td></td>
					<td>支付时间</td>
					<td>${order.paytime }</td>
				</tr>
				<tr>
					<td></td>
					<td>支付状态</td>
					<td id="paystatus"></td>
				</tr>
				<tr>
					<td></td>
					<td>提交时间</td>
					<td>${order.submittime }</td>
				</tr>
				<tr>
					<td></td>
					<td>对账状态</td>
					<td id="status"></td>
				</tr>
			</table>
		</div>
		<div title="保单信息" data-options="fit:true">
			<table id="orderPolicyData" width="100%"></table>
		</div>
	</div>
</body>
<script>
	var paystatus = ${order.paystatus}; 
	var status = ${order.status}; 
	if(paystatus==0){
		$('#paystatus').html('未支付');
	}
	if(paystatus==1){
		$('#paystatus').html('支付成功');
	}
	if(paystatus==2){
		$('#paystatus').html('未支付的已撤单');
	}
	if(paystatus==3){
		$('#paystatus').html('支付中');
	}
	if(paystatus==4){
		$('#paystatus').html('交易可疑');
	}
	if(paystatus==5){
		$('#paystatus').html('支付失败');
	}
	if(paystatus==6){
		$('#paystatus').html('支付成功且退款成功的已撤单');
	}
	if(paystatus==7){
		$('#paystatus').html('退款中');
	}
	if(paystatus==8){
		$('#paystatus').html('订单完成');
	}
	if(status==0){
		$('#status').html('未对账');
	}
	if(status==1){
		$('#status').html('对账成功');
	}
	if(status==2){
		$('#status').html('对账失败');
	}
	if(status==3){
		$('#status').html('本地成功，支付接口失败');
	}
</script>

</html>