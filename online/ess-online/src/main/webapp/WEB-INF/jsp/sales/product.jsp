<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>

	<%@ include file="../common/meta.jsp"%>
	
	<%@ include file="../common/rels.jsp"%>
	
	<link href="${ctx}/resources/css/sales/sales.min.css?${random}" rel="stylesheet"/>
	
	<script src="${ctx}/resources/js/sales/product.js?${random}"></script>
</head>
<body>
	<div class="wrap product">
		<jsp:include page="../common/head.jsp"></jsp:include>
		<div class="head">
			<a href="${ctx}/msl/sales/home" class="head-icon back left"></a>
    		<h1 class="head-name red">中宏私家车意外伤害保险</h1>
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
							<form action="${ctx}/msl/sales/insure" method="post" id="buyNow">
								<input type="hidden" id="productCode" name="policy.prodoctcode" value="${policy.prodoctcode}">
								<input type="hidden" id="isBack" name="isBack" value="${request.isBack}">
								<a class="btn b-insure" id="buyNow-top"><b></b><span>立即投保</span></a>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="product-basic row">
					<div class="product-info price col-sm-12 col-lg-12">金额：<strong>￥<b>18.75</b></strong><span>起</span></div>
					<div class="product-info count col-sm-12 col-lg-12">已售：<strong><b id="count"></b></strong><span>份</span></div>
				</div>
				<jsp:include page="/WEB-INF/jsp/sales/element/${policy.prodoctcode}/productDetail.jsp"></jsp:include>		
			</div>
		</div>
		<div class="product-action <s:if test='#request.policy.prodoctcode == "PAT"'>beach</s:if>">
			<div class="container">
				<form action="${ctx}/msl/sales/insure" method="post" id="buyNow-2">
					<input type="hidden" id="productCode" name="policy.prodoctcode" value="${policy.prodoctcode}">
					<input type="hidden" id="isBack" name="isBack" value="${request.isBack}">
				<a class="btn insure"id="buyNow-bottom"><b></b><span>立即投保</span></a>
				</form>
				<jsp:include page="/WEB-INF/jsp/sales/element/${policy.prodoctcode}/productBottom.jsp"></jsp:include>		
<%-- 				<img class="bottom-tree hidden-sm" src="${ctx}/resources/image/common/tree.png"/> --%>
			</div>
		</div>
		<jsp:include page="../common/foot.jsp"></jsp:include>		
	</div>
</body>
</html>