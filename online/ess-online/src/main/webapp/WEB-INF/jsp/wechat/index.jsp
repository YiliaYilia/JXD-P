<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>

	<%@ include file="/WEB-INF/jsp/wechat/common/meta.jsp"%>
	
	<%@ include file="/WEB-INF/jsp/wechat/common/rels.jsp"%>
	
	<link href="${ctx}/resources/css/animate/pop-ani.css" rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript" src="${ctx}/resources/js/index/menu.js"></script>
	
</head>
<body>
	<div class="wrap bg">
		<div class="content menu">
			<div class="page">
				<p class="welcome"><s:property value="#request.nickName"/>，您好</p>
				<div class="pop-main">
					<div class="pop-item pop2" data-index="1">
						<a href="${ctx}/policyList?type=pay">缴费信息<br>查询</a>
					</div>
					<div class="pop-item pop4" data-index="3">
						<a href="${ctx}/claims">理赔<br>服务</a>
					</div>
					<div class="pop-item pop5" data-index="4">
						<a href="${ctx}/conservations">业务<br>办理</a>
					</div>
					<div class="pop-item pop3" data-index="2">
						<a href="${ctx}/regionInit">服务网点<br>查询</a>
					</div>
					<div class="pop-item pop1" data-index="0">
						<a href="${ctx}/policyList">保单信息<br>查询</a>
					</div>
				</div>
			</div>
		</div>
		<div class="foot">
			<p>
				<a class="foot-phone" href="tel:4008188888"><img src="${ctx}/resources/image/page/400818888.png"></a>
				<a class="foot-logo"><img src="${ctx}/resources/image/page/logo.png"></a>
			</p>
		</div>
	</div>
</body>
</html>