<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>交易明细</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="../global/lib/jquery/jquery-2.1.3.min.js"></script>
  	<script type="text/javascript" src="../global/js/common.js"></script>
  	<script src="../global/lib/common/main.js?${random}"></script>	
	<script src="../global/lib/component/modal.js"></script>
	
	
<link rel="stylesheet" type="text/css" href="../uinew/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/style-font.css">
  	<!-- init page scale-->
  	<meta name="viewport" content="width=device-width, target-densitydpi=240,initial-scale=0.667, minimum-scale=0.667, maximum-scale=0.667, user-scalable=0" id="viewport">
  	<meta name="format-detection" content="telephone=no"/>
  </head>
  <style>
  	
.money-list li {
    height: 80px;
    background: #fff;
    border-bottom: 1px solid #dfdfdf;
    font-size: 1.4em;
}
.pay-text span {
    font-size: 0.8em;
    color: #666;
}

  	</style>
  <body class="gray">
  <div class="grace-head"> </div>
  <h2 style="margin-top:60px; text-align:center; color:#c8a154; font-size:2em; font-weight:bold;">交易明细</h2> 
<ul class="money-list" style="margin-top:50px;margin-bottom: 80px;">
	
			    		<c:forEach var="payDetail" items="${payDetailList}"  varStatus="this_status">
   <li> 
     <div class="pull-left">
       <div class="pay-icon"> 
         <img src="../uinew/images/pay.png" width="100%"  alt=""/>
       </div>
       <div  class="pull-left pay-text">${payDetail.transactionType}<br/>
       <span>${payDetail.transactionDate}</span></div>
     
     </div>
     <div class="pull-right">${payDetail.amount}（元）</div>
   </li>
		    			</c:forEach>
</ul>

<div class="footer" style="position:fixed;bottom: 0"> <img src="../uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>

  </body>
</html>
