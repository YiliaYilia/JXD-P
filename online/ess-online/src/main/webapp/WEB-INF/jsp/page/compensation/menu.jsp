<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../common/taglibs.jsp"%>
<html>
  <head>
    <title>自助理赔</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
 	<meta name="format-detection" content="telephone=no"/>
 	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/compensation/compensation.css" type="text/css"></link>
	<script type="text/javascript">
		function applyClaim(){
			window.location.href ='${ctx}/msl/sales/noticeClaimAction';
		}
		
		
		function queryClaim(){
			window.location.href ='${ctx}/msl/sales/findClaimListAction';
		}
	</script>
	
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/style-font.css">
  </head>
  <body  class="gray">
  <div class="grace-head"> </div>
  <div class="banner"> 
  <img src="${ctx}/uinew/images/insurance-pic2.jpg"  width="100%"  alt=""/> </div>
  
  <ul class="link-btn"> 
     <li onclick="applyClaim()"> <a href="#" style="font-size: 1em;"> 自助理赔申请</a></li>
     <li onclick="queryClaim()"> <a href="#" style="font-size: 1em;">自助理赔查询 </a></li>
  </ul>
<div class="footer footer-fixed "> <img src="${ctx}/uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>
</body>

</html>
