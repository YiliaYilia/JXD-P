<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>系统信息</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
<meta name="format-detection" content="telephone=no"/>
<title>系统消息</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/wjx/wjx.css" type="text/css"></link>
<style type="text/css">
	.container{width:96%;color:#666;margin:auto 2%;}
	.deal_success{margin:30px 5% 30px;width:90%;color:#000;}
</style>
</head>
<body>
	<!--标题区域-->
  	<header class="txt24">系统异常</header>
   	<section class="container">
   		<p class="deal_success txt18">
   			OH NO！出错了，返回稳驾保首页！
   		</p>
    	<!-- 按钮区域 -->
	   	<section class="btn_wrap">
	   		<div class="one_btn txt22" onclick="javascript:window.location.href ='${ctx}/msl/sales/WJBHomePage'">确&nbsp;&nbsp;定</div>
	   	</section>
   	</section>
</body>
</html>