<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>保单详情</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
  	<!-- init page scale-->
	<meta name="viewport" content="width=device-width, target-densitydpi=240,initial-scale=0.667, minimum-scale=0.667, maximum-scale=0.667, user-scalable=0" id="viewport">
	<meta name="format-detection" content="telephone=no"/>
	
<link rel="stylesheet" type="text/css" href="../uinew/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/style-font.css">
<style>
	.grace-form li {
    font-size: 1.4em;
}
.grace-form .pull-left {
    width: 31%;
    text-align: left;
}
.grace-form .pull-right {
    width: 60%;
    text-align: right;
}
	</style>
  </head>
  <body  class="gray">
  <div class="grace-head"> </div>
<h2 style="margin-top:60px; text-align:center; color:#c8a154; font-size:2em; font-weight:bold;">保单投资信息</h2>


            <div class="panel-collapse collapse in cardcontent " >
             <ul class="grace-form"> 
              <li > <div class="pull-left">年化结算利率: </div> 
              	<div class="pull-right ">${rate}%</div></li>
              <li > <div class="pull-left">月份: </div> 
              	<div class="pull-right ">${month}月</div></li>
              <li > <div class="pull-left">投资账户总价值: </div> 
              	<div class="pull-right ">${totalValue}</div></li>
            </ul>  
            </div>
<div class="footer footer-fixed "> <img src="../uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>

  </body>
</html>
