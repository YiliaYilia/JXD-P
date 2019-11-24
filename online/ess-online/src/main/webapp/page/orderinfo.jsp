<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>订单详情</title>
	
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../uinew/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/style-font.css">
<!-- init page scale-->
<script>
		var phoneWidth =  parseInt(window.screen.width);
		var phoneScale = phoneWidth/640;
		var ua = navigator.userAgent;
		if (/Android (\d+\.\d+)/.test(ua)){
			var version = parseFloat(RegExp.$1);
			if(version>2.3){
				document.write('<meta name="viewport" content="width=640, minimum-scale = '+phoneScale+', maximum-scale = '+phoneScale+', target-densitydpi=device-dpi">');
			}else{
				document.write('<meta name="viewport" content="width=640, target-densitydpi=device-dpi">');
			}
		} else {
			document.write('<meta name="viewport" content="width=640, user-scalable=no, target-densitydpi=device-dpi">');
		}
	</script>
  	<meta name="format-detection" content="telephone=no"/>

<style>
.grace-form .pull-left {
    width: 31%;
    text-align: left;
}
.grace-form .text-right {
    width: 69%;
}
	</style>
</head>
<body class="gray" style="font-size:18px;">
  <div class="grace-head"> </div>
           <h2 style="margin-top:60px; text-align:center; color:#c8a154; font-size:2em; font-weight:bold;">订单详情 </h2>
            <div class="panel-collapse collapse in cardcontent " style="font-size: 1.4em;">
             <ul class="grace-form" > 
              <li > <div class="pull-left">投保单号 : </div> <div class="pull-right text-right">${tOrder.flowno}</div></li>
              <li > <div class="pull-left">产品名称: </div> <div class="pull-right text-right">${tOrder.productname}</div></li>
              <li > <div class="pull-left">订单金额: </div> <div class="pull-right text-right">${tOrder.orderamount}</div></li>
              <c:forEach var="extraProduct"
						items="${policyBasic.extraProductName}" begin="1">
						<li > <div class="pull-left"></div> <div class="pull-right text-right">${extraProduct}</div></li>
					</c:forEach>
					
              <li > <div class="pull-left">投保人: </div> <div class="pull-right text-right">${tOrder.applicantname}</div></li>
              <li > <div class="pull-left">被保人: </div> <div class="pull-right text-right">${tOrder.applicantname}</div></li>
              <li > <div class="pull-left">投保时间: </div> <div class="pull-right text-right">${submittime}</div></li>
              
              
              <li > <div class="pull-left" style="width:35%">支付状态: </div> <div class="pull-right text-right" style="width:65%;"> <c:if
									test="${tOrder.paystatus=='0'}">未支付</c:if> <c:if
									test="${tOrder.paystatus=='1'}">支付成功</c:if> <c:if
									test="${tOrder.paystatus=='10'}">银行处理中</c:if> <c:if
									test="${tOrder.paystatus=='5'}">支付失败</c:if></div></li>
              <li > <div class="pull-left">订单状态: </div> <div class="pull-right text-right"><c:if
									test="${tOrder.orderstatus=='1'||tOrder.orderstatus=='5'}">核保中</c:if> 
									<c:if test="${tOrder.orderstatus=='2'}">缴费中</c:if> 
									<c:if test="${order.orderstatus=='6'}">核保成功，可继续支付</c:if> 
									<c:if test="${tOrder.orderstatus=='3'}">已承保</c:if> 
									<c:if test="${tOrder.orderstatus=='4'}">投保失败</c:if></div></li>
              <li > <div class="pull-left">缴费方式: </div> <div class="pull-right text-right"><c:if test="${tOrder.billingType eq 'Y'}">银行代扣</c:if>
							<c:if test="${tOrder.billingType eq 'N'}">微信支付</c:if></div></li>
               
						
					
            </ul>  
            
             <ul class="btn-last" style="margin-bottom: 100px">
              <c:if test="${tOrder.paystatus eq '0'&&tOrder.billingType eq 'N'}">
              <li  style="margin-top: 5px;float:right;" id="coustomerLoginId" onclick="payContinue();">
						继续支付
						</li> 
			 </c:if>			
			</ul>

            </div>
           
            
<div class="footer " style="    position: fixed;"> <img src="../uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>
</body>
<%@ include file="/page/result.jsp"%>
<script type="text/javascript">
function payContinue(){
		//window.location.href ='<%=request.getContextPath()%>/msl/sales/payContinue&orderCode=${tOrder.ordercode}';
	 	window.location.href ='<%=request.getContextPath()%>/msl/sales/WKBtoTestSuccessContinue?source=TAWENKB-R&orderCode=${tOrder.ordercode}';
}
</script>
</html>
