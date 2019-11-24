<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>系统信息</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
 	<meta name="format-detection" content="telephone=no"/>
 	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/compensation/compensation.css" type="text/css"></link>
  </head>
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/style-font.css">
<body  class="gray">
  <div class="grace-head"> </div>
<h2 style="margin-top:60px; text-align:center; color:#c8a154; font-size:2em; font-weight:bold;">系统提示</h2>

   		<p class="deal_success txt18">
   			OH NO！出错了，返回理赔首页！
   		</p>
            <div class="next-button" onclick="javascript:window.location.href ='${ctx}/msl/sales/menuClaimAction'">
            	<img src="${ctx}/uinew/images/button3.jpg" width="100%"  alt=""/> </div>  
<div class="footer footer-fixed "> <img src="${ctx}/uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>
  </body>
</html>
