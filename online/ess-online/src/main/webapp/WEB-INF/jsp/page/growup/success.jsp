<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>支付成功-瑞泰人寿</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<%@ include file="../../common/meta.jsp"%>
<%@ include file="../../common/rels.jsp"%>
<link
	href="<%=request.getContextPath()%>/global/global/css/common.css?${random}"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/global/global/css/sale.css?${random}"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/uinew/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/uinew/css/style-font.css">

<style>
	.result {
    font-size: 1.5em;
}
	</style>
</head>

<body>
	<div class="grace-head"></div>
	<ul class="grace-top-menu">
		<li>填写信息</li>
		<li>健康告知</li>
		<li>确认投保</li>
		<li class="menu-select">在线缴费</li>

	</ul>
	<div class="result">

		<div class="yes-success">
			<img src="<%=request.getContextPath()%>/uinew/images/yes.png" width="100%" alt="" />
		</div>
		您购买的${productname}<br /> 保费：<span>${orderamount}元</span><br />
		已于${paydate}支付成功
	</div>
	<div class="footer footer-fixed">
		<img src="<%=request.getContextPath()%>/uinew/images/bottom-line.jpg"
			alt="" />
	</div>

</body>
</html>
