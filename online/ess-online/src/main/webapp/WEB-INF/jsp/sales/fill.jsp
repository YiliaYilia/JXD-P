<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>

	<%@ include file="../common/meta.jsp"%>
	
	<%@ include file="../common/rels.jsp"%>
	
	<link href="${ctx}/resources/css/sales/sales.min.css?${random}" rel="stylesheet"/>
	
	<script src="${ctx}/resources/lib/component/form.js"></script>
	
<!-- 	校验框架 -->
	<script src="${ctx}/resources/lib/jquery/validate/jquery.validator.js?${random}"></script>
	<script src="${ctx}/resources/lib/jquery/validate/local/zh_CN.js?${random}"></script>
<!-- 	日期控件 -->
	<link href="${ctx}/resources/lib/jquery/mobiscroll/css/mobiscroll.core-2.0.3.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/resources/lib/jquery/mobiscroll/css/mobiscroll.android-2.0.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/resources/lib/jquery/mobiscroll/mobiscroll.core-2.0.3.js" type="text/javascript"></script>
	<script src="${ctx}/resources/lib/jquery/mobiscroll/mobiscroll.android-2.0.js" type="text/javascript"></script>
	<script src="${ctx}/resources/lib/jquery/mobiscroll/mobiscroll.select-2.0.2.js" type="text/javascript"></script>
	<script src="${ctx}/resources/lib/jquery/mobiscroll/mobiscroll.datetime-2.0.3.js" type="text/javascript"></script>
	
<!-- 	工具类 -->
	<script src="${ctx}/resources/lib/utils/dateUtils.js?${random}" type="text/javascript"></script>
	<script src="${ctx}/resources/lib/utils/idCardUtils.js?${random}" type="text/javascript"></script>
	<script src="${ctx}/resources/lib/utils/stringUtils.js?${random}" type="text/javascript"></script>
	
	<script src="${ctx}/resources/js/sales/fill.js?${random}"></script>
</head>
<body>
	<div class="wrap insure">
		<jsp:include page="../common/head.jsp"></jsp:include> 
		<div class="head">
			<form action="${ctx}/msl/sales/product" method="post" id="topproduct-from">
			<input type="hidden" id="productCode" name="policy.prodoctcode" value="${policy.prodoctcode}">
			<input type="hidden" name="isBack" value="1">
			<a id="topback" class="head-icon back left"></a>
    		</form>
    		<h1 class="head-name">投保信息</h1>
		</div>
		<div class="content">
			<div class="banner">
				<a class="banner-img">
					<img class="hidden-lg" src="${ctx}/resources/image/sales/${policy.prodoctcode}/banner-sm.jpg">
					<img class="hidden-sm" src="${ctx}/resources/image/sales/${policy.prodoctcode}/banner-lg.jpg">
				</a>
				<div class="container banner-container">
					<div class="banner-product">
						<!-- 						产品banner说明文字 -->
						<jsp:include page="/WEB-INF/jsp/sales/element/${policy.prodoctcode}/banner-info.jsp"></jsp:include>
						<div class="banner-product-ac">
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="insure-body">
					<div class="insure-process hidden-sm">
						<img src="${ctx}/resources/image/sales/process-step1.png">
					</div>
					<div class="insure-head">请填写如下信息，<br class="hidden-lg">我们将为您立即投保</div>
					<div class="insure-fill">
						<form id="fillForm">
							<input type="hidden" id="productCode" name="productCode" value="${policy.prodoctcode}">
							<div class="panel">
								<div class="panel-head">投保人信息</div>
								<div class="panel-body">
									<ul class="list form sale">
											<s:iterator value="#request.order.policys" var="policy">
												<s:iterator value="#policy.applicantInsureds" var="applicant">
												</s:iterator>
											</s:iterator>
										<li class="row">
											<label class="form-label col-sm-11 col-lg-9 i1"><i></i><span>投保人姓名</span></label>
											<div class="form-control col-sm-13 col-lg-14">
												<input class="form-input" type="text" value="${applicant.name }" id="name" name="name">
											</div>
										</li>
										<li class="row">
											<label class="form-label col-sm-11 col-lg-9 i2"><i></i><span>身份证号码</span></label>
											<div class="form-control col-sm-13 col-lg-14">
												<input class="form-input" type="text" value="${applicant.identifynumber}" id="indentifynumber" name="indentifynumber">
											</div>
										</li>
										<li class="row">
											<label class="form-label col-sm-11 col-lg-9 i3"><i></i><span>手机号码</span></label>
											<div class="form-control col-sm-13 col-lg-14">
												<input class="form-input" type="text" value="${applicant.mobile}" id="mobile" name="mobile">
											</div>
										</li>
										<li class="row">
											<label class="form-label col-sm-11 col-lg-9 i4"><i></i><span>电子邮箱</span></label>
											<div class="form-control col-sm-13 col-lg-14">
												<input class="form-input" type="text" value="${applicant.email}" id="email" name="email">
											</div>
										</li>
									</ul>
								</div>
							</div>
							<div class="panel">
								<div class="panel-head">被保人信息</div>
								<div class="panel-body">
									<ul class="list form sale">
										<li class="row">
											<label class="form-label col-sm-11 col-lg-9 i5"><i></i><span>被保险人</span></label>
											<div class="form-control col-sm-13 col-lg-14">
												<label class="form-info">本人</label>
											</div>
										</li>
										<li class="row">
											<label class="form-label col-sm-11 col-lg-9 i11"><i></i><span>被保险人常住地</span></label>
											<div class="form-control col-sm-13 col-lg-14">
												<select class="form-select" id="areacodepro" name="areacodepro">
													<s:if test="#request.isBack==0">
														<option selected="selected" value="${inputRegion.provinceCode}">${inputRegion.provinceName}</option>
														<s:iterator value="#request.provinceList" var="province">
															<option value="${province.provinceCode}">${province.provinceName}</option>
														</s:iterator>
													</s:if>
													
													<s:if test="#request.isBack==1">
														<s:if test="#request.inputRegion.provinceCode==#policy.areacodepro||#policy==null">
															<option value="${inputRegion.provinceCode}">${inputRegion.provinceName}</option>
															<s:iterator value="#request.provinceList" var="province">
															<option value="${province.provinceCode}">${province.provinceName}</option>
															</s:iterator>
														</s:if>
														<s:else>
															<s:iterator value="#request.provinceList" var="province">
															<s:if test="#province.provinceCode==#policy.areacodepro">
																<option selected="selected" value="${province.provinceCode}">${province.provinceName}</option>
															</s:if>
															<s:else>
																<option value="${province.provinceCode}">${province.provinceName}</option>
															</s:else>
															</s:iterator>
														</s:else>
													</s:if>
												</select>
											</div>
										</li>
									</ul>
								</div>
							</div>
							<div class="panel">
								<div class="panel-head">受益人信息</div>
								<div class="panel-body">
									<ul class="list form sale">
										<li class="row">
											<label class="form-label col-sm-11 col-lg-9 i6"><i></i><span>身故受益人</span></label>
											<div class="form-control col-sm-13 col-lg-14">
												<label class="form-info">法定继承人</label>
											</div>
										</li>
									</ul>
								</div>
							</div>
							<div class="panel">
								<div class="panel-head">保单信息</div>
								<div class="panel-body">
									<ul class="list form sale">
										<li class="row">
											<label class="form-label col-sm-11 col-lg-9 i7"><i></i><span>保险金额</span></label>
											<div class="form-control col-sm-13 col-lg-14">
													<select class="form-select" id="sumpremium" name="sumpremium">
														<s:iterator value="#request.policyAmountList" var="amount">
															<s:if test="#amount==#policy.sumamount">
																<option selected="selected" value="<s:property value='#policy.sumamount'/>"><s:property value="%{numberFormat(#policy.sumamount/10000)}"/>万</option>
															</s:if>
															<s:else>
																<option value="<s:property value='amount'/>"><s:property value="%{numberFormat(#amount/10000)}"/>万</option>
															</s:else>
														</s:iterator>
													</select>
											</div>
										</li>
										<li class="row">
											<label class="form-label col-sm-11 col-lg-9 i8"><i></i><span>合同生效日</span></label>
											<div class="form-control col-sm-13 col-lg-14">
												<input class="form-input date" type="text" id="start" name="start" readonly="readonly" value="<s:date name="#policy.takeeffecttime" format="yyyy年MM月dd日" />">
												<div class="form-addon">0时</div>
											</div>
										</li>
										<li class="row">
											<label class="form-label col-sm-11 col-lg-9 i9"><i></i><span>保险期间</span></label>
											<div class="form-control col-sm-13 col-lg-14">
												<select class="form-select" id="inputPeriodNum" name="inputPeriodNum">
													<s:iterator value="#request.periodNumberList" var="numberList" status="i">
														<s:if test="#policy.policyterm==#numberList">
															<option value="<s:property value="#numberList"/>_<s:property value="#request.periodTypeList[#i.index]"/>" selected="selected"><s:property value="numberList"/><s:if test='#request.periodTypeList[#i.index]=="D"'>天</s:if><s:else>年</s:else></option>
														</s:if>
														<s:else>
															<option value="<s:property value="#numberList"/>_<s:property value="#request.periodTypeList[#i.index]"/>"><s:property value="numberList"/><s:if test='#request.periodTypeList[#i.index]=="D"'>天</s:if><s:else>年</s:else></option>
														</s:else>
													</s:iterator>
												</select>
											</div>
										</li>
										<li class="row">
											<label class="form-label col-sm-11 col-lg-9 i10"><i></i><span>合同终止日</span></label>
											<div class="form-control col-sm-13 col-lg-14">
												<label class="form-info" id="endtime"><s:date name="#policy.deadlinetime" format="yyyy年MM月dd日" /></label>
												<div class="form-addon">24时</div>
											</div>
										</li>
									</ul>
								</div>
							</div>
							<div class="panel amount">
								<div class="panel-body">
									<ul class="list">
										<li class="row insure-pay">
											<label class="col-sm-11 col-lg-11">保费</label>
											<span class="col-sm-13 col-lg-13"><span id="sumbasepremium"></span>元</span>
										</li>
										<li class="row insure-agree">
											<div class="form-checkbox col-sm-24 col-lg-24">
												<input type="checkbox" id="agree">
												<label for="agree"><i></i>我已认真阅读<a href="#">投保须知</a> <a href="#">保险条款</a>，并在确认已充分理解保险责任、合同解除、责任免除以及比例给付等免除或减轻贵公司责任的条款</label>
											</div>
										</li>
									</ul>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="insure-action">
			<div class="container">
				<div class="insure-action-inner">
					<a class="btn insure" id="toConfirm"><span>下一步</span></a>
					<form action="${ctx}/msl/sales/product" method="post" id="product-from">
					<input type="hidden" id="productCode" name="policy.prodoctcode" value="${policy.prodoctcode}">
					<input type="hidden" name="isBack" value="1">
					<a class="btn back" id="back"><span>返回</span></a>
					</form>
				</div>
				<img class="bottom-tree hidden-sm" src="${ctx}/resources/image/common/tree.png"/>
				<img class="bottom-car hidden-sm" src="${ctx}/resources/image/common/car.png"/>
			</div>
		</div>
		<input type="hidden" id="systemTime" value="<s:date name="#request.policy.takeeffecttime" format="yyyy-MM-dd" />">
		<input type="hidden" id="start1" value="<s:date name="#policy.takeeffecttime" format="yyyy-MM-dd" />">
		<input type="hidden" id="isBack" value="<s:property value="#request.isBack"/>">
		<jsp:include page="../common/foot.jsp"></jsp:include>		
		<jsp:include page="../common/common-modal.jsp"></jsp:include>		
	</div>
</body>
</html>