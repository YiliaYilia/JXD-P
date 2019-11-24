<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>

	<%@ include file="../common/meta.jsp"%>
	
	<%@ include file="../common/rels.jsp"%>
	 
	<link href="${ctx}/resources/css/reservation/reserv.min.css?${random}" rel="stylesheet"/>
	
	<script src="${ctx}/resources/lib/component/form.js"></script>
		
	<!-- 	校验框架 -->
	<script src="${ctx}/resources/lib/jquery/validate/jquery.validator.js?${random}"></script>
	<script src="${ctx}/resources/lib/jquery/validate/local/zh_CN.js?${random}"></script>
	
	<script src="${ctx}/resources/js/reservation/quote.js"></script>
</head>
<body>
	<div class="wrap quote">
		<jsp:include page="../common/head.jsp"></jsp:include>
		<div class="head">
			   <form action="${ctx}/reservation/product" id="formProduct" method="post" >	
				 <a id ="backProduct" href="javascript:;" class="head-icon back left"></a>
	    	     <input type="hidden" id ="prodoctcode" name="policy.prodoctcode" value="${policy.prodoctcode}"  />
	    	   </form>
    		<h1 class="head-name">保费试算</h1>
		</div>
		<div class="content">
			<div class="banner">
				<a class="banner-img">
					<img class="hidden-lg" src="${ctx}/resources/image/reservation/${policy.prodoctcode}/banner-sm.jpg">
					<img class="hidden-sm" src="${ctx}/resources/image/reservation/${policy.prodoctcode}/banner-lg.jpg">
				</a>
				<div class="container banner-container">
					<div class="banner-reserv qt">
					<!-- 						产品banner说明文字 -->
						<jsp:include page="/WEB-INF/jsp/reservation/element/${policy.prodoctcode}/banner-info.jsp"></jsp:include>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="quote-head">请填写如下信息，<br class="hidden-lg">我们将为您进行保费试算和产品利益演示。</div>
				<div class="quote-fill">
					<form id="fillForm">
						<ul class="list form qt">
							<li class="row">
								<label class="form-label col-sm-11 col-lg-11 i1"><i></i><span>被保人姓名</span></label>
								<div class="form-control col-sm-13 col-lg-13">
									<input  id ="name"  class="form-input" type="text" value="" autocomplete="off">
								</div>
							</li>
							<li class="row">
								<label class="form-label col-sm-11 col-lg-11 i9"><i></i><span>被保人年龄</span></label>
								<div class="form-control col-sm-13 col-lg-13">
									<select class="form-select" id="age" >
											<s:iterator var="age" value="#request.ageList"  >		
												<option value='<s:property value="#age"/>'><s:if test="#age==0">7天</s:if><s:else ><s:property value="#age"/>岁</s:else> </option>								
											</s:iterator>
									</select>
								</div>
							</li>
							<li class="row">
								<label class="form-label col-sm-24 col-lg-24 quote-gender-lb"><span>请选择被保人性别</span></label>
								<div class="form-control col-sm-24 col-lg-24 row quote-gender">
									<input type="hidden" id="gender" value="M">
									<div class="col-sm-12 col-lg-5 quote-gender-it male active" value="M">
										<b></b>
										<p>男</p>
									</div>
									<div class="col-sm-12 col-lg-6 quote-gender-it female" value="F">
										<b></b>
										<p>女</p>
									</div>
								</div>
							</li>
							<li class="row">
								<label class="form-label col-sm-11 col-lg-11 i3"><i></i><span>您的手机号码</span></label>
								<div class="form-control col-sm-13 col-lg-13">
									<input id="phone" class="form-input" type="text" value="" autocomplete="off">
								</div>
							</li>
							<li class="row">
								<label class="form-label col-sm-24 col-lg-12 i4"><i></i><span>被保人常住地</span></label>
								<div class="col-sm-24 col-lg-6 quote-address">
									<label class="form-label col-sm-11 hidden-lg"><i></i><span>省/直辖市</span></label>
									<div class="form-control col-sm-13 col-lg-24">
										<select class="form-select" name="inputRegion.province"  id="dropDownMenu">
											<option value="" selected="selected">请选择</option>		
											<s:iterator var="province" value="#request.provinceList">		
												<option value='<s:property value="#province.provinceCode" />'><s:property value="#province.provinceName" /></option>								
											</s:iterator>
										</select>
									</div>
								</div>
								<div class="col-sm-24 col-lg-6 quote-address">
									<label class="form-label col-sm-11 hidden-lg"><i></i><span>市</span></label>
									<div class="form-control col-sm-13 col-lg-24">
										<select class="form-select" id="city">
											 <option value="" selected="selected">请选择</option>	 
											<!-- <option>上海市</option> -->
										</select>
									</div>
								</div>
							</li>
							<li class="row">
								<label class="form-label col-sm-11 col-lg-11 i7"><i></i><span>保险金额</span></label>
								<div class="form-control col-sm-24 col-lg-24 quote-range">
									<select class="form-select hidden" id="money" >
									  <s:if test='#request.policy.prodoctcode=="NBJ"' >
										<s:iterator var="amount" value="#request.policyAmountList" status="st" >		
											 <s:if test="#st.index==0||#st.index==1||#st.index==2">
												 <option value='<s:property value="#amount"/>'>
												 	<s:property value="%{numberFormat(#amount/1000)}" />千
												 </option>
											 </s:if>
											 <s:else>
												 <option value='<s:property value="#amount"/>'>
												 	<s:property value="%{numberFormat(#amount/10000)}" />万
												 </option>
											 </s:else>											 								
										</s:iterator>
									  </s:if>
									  <s:else>
										<s:iterator var="amount" value="#request.policyAmountList"  >		
											 <option value='<s:property value="#amount"/>'>
											 	<s:property value="%{numberFormat(#amount/10000)}" />万
											 </option>								
										</s:iterator>
									  </s:else>										
									</select>
								</div>
							</li>
							<li class="row">
								<label class="form-label col-sm-11 col-lg-11 i10"><i></i><span>缴费期限</span></label>
								<div class="form-control col-sm-24 col-lg-24 quote-range">
									<select class="form-select hidden" id="payDate" >
									</select>
								</div>
							</li>
						</ul>
					</form>
				</div>
			</div>
		</div>
		<div class="quote-action">
			<div class="container">
				<a class="btn insure qt" id="reservateInput" ><b></b><span>立即试算</span></a>
			</div>
			<img class="bottom-tree hidden-sm" src="${ctx}/resources/image/common/tree.png"/>
		</div>
		<jsp:include page="../common/foot.jsp"></jsp:include>
		<jsp:include page="../common/common-modal.jsp"></jsp:include>		
	</div>
</body>
</html>