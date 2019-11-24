<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>

	<%@ include file="../common/meta.jsp"%>
	
	<%@ include file="../common/rels.jsp"%>
	
	<link href="${ctx}/resources/css/sales/sales.min.css?${random}" rel="stylesheet"/>
	
	<script src="${ctx}/resources/js/sales/confirm.js?${random}"></script>
</head> 
<body>
	<div class="wrap confirm">
		<jsp:include page="../common/head.jsp"></jsp:include>
		<div class="head line">
    		<h1 class="head-name">投保单确认</h1>
		</div>
		<div class="content">
			<div class="container">
				<div class="insure-body">
					<div class="insure-process hidden-sm">
						<img src="${ctx}/resources/image/sales/process-step2.png">
					</div>
					<div class="confirm-panel">
						<h4 class="confirm-head">保单确认</h4>
						<ul class="confirm-list">
							<li><i class="c1"></i><label>计划名称：</label><span>${order.productname }</span></li>
							<li class="duty">
								<i class="c2"></i><label>责任简介：</label>
								<div class="duty-detail row">
									<div class="row">
										<div class="col-sm-12 col-lg-6">身故保险金</div>
										<s:iterator value="#request.order.policys" var="policy">
											<s:iterator value="#policy.applicantInsureds" var="applicant">
											</s:iterator>
										</s:iterator>
										<div class="col-sm-12 col-lg-6 duty-value"><s:property value="%{numberFormat(#policy.sumamount/10000)}"/>万</div>
										<div class="col-sm-12 col-lg-6">残疾保险金</div>
										<div class="col-sm-12 col-lg-6 duty-value">最高<s:property value="%{numberFormat(#policy.sumamount/10000)}"/>万</div>
									</div>
								</div>
							</li>
						<li><i class="c3"></i><label>姓名：</label><span>${applicant.name }</span></li>
						<li><i class="c4"></i><label>身份证号：</label><span>${applicant.identifynumber}</span></li>
						<li><i class="c5"></i><label>性别：</label><span><s:if test="#applicant.sex=='M'.toString()">男</s:if><s:else>女</s:else></span></li>
						<li><i class="c6"></i><label>出生日期：</label><span><s:date name="#applicant.birthday" format="yyyy年M月d日" /></span></li>
						<li><i class="c7"></i><label>合同生效日：</label><span><s:date name="#policy.takeeffecttime" format="yyyy年M月d日" />0时</span></li>
						<li><i class="c8"></i><label>合同终止日：</label><span><s:date name="#policy.deadlinetime" format="yyyy年M月d日" />24时</span></li>
						<li><i class="c9"></i><label>应付保费：</label><span>${policy.sumbasepremium}元</span></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="insure-action">
			<div class="container">
				<div class="insure-action-inner">
					<a class="btn insure" id="insureSubmit"><span>下一步</span></a>
					<form action="${ctx}/msl/sales/insure" method="post" id="back-from">
					<input type="hidden" name="isBack" value="1">
					<input type="hidden" name="policy.prodoctcode" value="${policy.prodoctcode}">
						<a class="btn back" id="back"><span>返回</span></a>
					</form>
				</div>
				<img class="bottom-tree hidden-sm" src="${ctx}/resources/image/common/tree.png"/>
				<img class="bottom-car hidden-sm" src="${ctx}/resources/image/common/car.png"/>
			</div>
		</div>
		<jsp:include page="../common/foot.jsp"></jsp:include>
		<jsp:include page="../common/common-modal.jsp"></jsp:include>	
	</div>
</body>
</html>