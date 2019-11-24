<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>

	<%@ include file="../common/meta.jsp"%>
	
	<%@ include file="../common/rels.jsp"%>
	
	<link href="${ctx}/resources/css/sales/sales.min.css?${random}1" rel="stylesheet"/>
</head>
<body>
	<div class="wrap delay">
		<jsp:include page="../common/head.jsp"></jsp:include>
		<div class="head line">
    		<h1 class="head-name">订单支付</h1>
		</div>
		<div class="content">
			<div class="delay-head">
				<div class="container">
					<img class="hidden-lg" src="${ctx}/resources/image/common/delay-head.jpg">
					<img class="hidden-sm" src="${ctx}/resources/image/common/delay-head-lg.png">
				</div>
			</div>
			<div class="container">
				<p class="delay-txt">请关注中宏保险微信绑定身份后<br>或登录中宏保险官网网上自助服务</p>
				<p class="delay-query">查询您的保单信息</p>
			</div>
		</div>
		<div class="delay-action hidden-sm">
			<div class="container">
				<div class="delay-action-inner">
					<a class="btn insure" href="test?relativelyPattern=/sales/pay.jsp"><span>返回首页</span></a>
				</div>
				<img class="bottom-tree hidden-sm" src="${ctx}/resources/image/common/tree.png"/>
				<img class="bottom-car hidden-sm" src="${ctx}/resources/image/common/car.png"/>
			</div>
		</div>
		<jsp:include page="../common/foot.jsp"></jsp:include>
	</div>
</body>
</html>