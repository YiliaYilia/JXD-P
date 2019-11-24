<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>

	<%@ include file="../common/meta.jsp"%>
	
	<%@ include file="../common/rels.jsp"%>
	
	<link href="${ctx}/resources/css/sales/sales.min.css?${random}" rel="stylesheet"/>
	
	<script src="${ctx}/resources/js/sales/result.js"></script>
</head>
<body>
	<div class="wrap result">
		<jsp:include page="../common/head.jsp"></jsp:include>
		<div class="head line">
    		<h1 class="head-name">订单提交</h1>
		</div>
		<div class="content">
			<div class="result-head">
				<div class="container">
					<img src="${ctx}/resources/image/common/success.png"/>
					<p>恭喜你！投保成功</p>
					<div class="result-title">保险详情</div>
				</div>
			</div>
			<div class="container">
				<div class="result-body">
					<s:set var="order" value="#request.order" />
					<s:iterator  var="policys" value="#order.policys">
						<s:set var="policy" value="#policys" />
					</s:iterator>
					
					<div class="insure-process hidden-sm">
						<img src="${ctx}/resources/image/sales/process-step4.png">
					</div>
					<p class="result-label">产品信息</p>
					<ul class="list">
						<li><i class="r1"></i><label>计划名称：</label><span><s:property value="#order.productname" /></span></li>
						<li><i class="r2"></i><label>合同生效日：</label><span><s:date name="#policy.takeeffecttime" format="yyyy年MM月dd日" />0时</span></li>
						<li><i class="r3"></i><label>合同终止日：</label><span><s:date name="#policy.deadlinetime" format="yyyy年MM月dd日" />24时</span></li>
						<li><i class="r4"></i><label>保费：</label><span><s:property value="#policy.sumbasepremium" />元</span></li>
					</ul>
					<p class="result-label">支付信息</p>
					<ul class="list">
						<li><i class="r5"></i><label>保单号：</label><span><s:property value="#policy.policycode" /></span></li>
						<li><i class="r6"></i><label>支付方式：</label><span>
						<s:if test="#order.paymentplatform == 1 ">微信</s:if>
						<s:if test="#order.paymentplatform == 2 ">支付宝</s:if>
						</span></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="result-action hidden-sm">
			<div class="container">
				<div class="result-action-inner">
					<a class="btn insure" href="${ctx}/msl/sales/home"><span>返回首页</span></a>
				</div>
				<img class="bottom-tree hidden-sm" src="${ctx}/resources/image/common/tree.png"/>
				<img class="bottom-car hidden-sm" src="${ctx}/resources/image/common/car.png"/>
			</div>
		</div>
		<jsp:include page="../common/foot.jsp"></jsp:include>		
	</div>
</body>
</html>