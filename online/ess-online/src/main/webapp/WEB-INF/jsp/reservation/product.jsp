<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>

	<%@ include file="../common/meta.jsp"%>
	
	<%@ include file="../common/rels.jsp"%>
	
	<link href="${ctx}/resources/css/reservation/reserv.min.css?${random}" rel="stylesheet"/>
	
	<script src="${ctx}/resources/js/reservation/product.js"></script>
	
</head>
<body>
	<div class="wrap product">
		<jsp:include page="../common/head.jsp"></jsp:include>
		<div class="head">
			<a href="${ctx}/reservation/home" class="head-icon back left"></a>
    		<jsp:include page="/WEB-INF/jsp/reservation/element/${policy.prodoctcode}/product-name.jsp"></jsp:include>
		</div>
		<div class="content">
			<div class="banner">
				<a class="banner-img">
					<img class="hidden-lg" src="${ctx}/resources/image/reservation/${policy.prodoctcode}/banner-sm.jpg">
					<img class="hidden-sm" src="${ctx}/resources/image/reservation/${policy.prodoctcode}/banner-lg.jpg">
				</a>
				<div class="container banner-container">
					<div class="banner-reserv">
					
<!-- 						产品banner说明文字 -->
						<jsp:include page="/WEB-INF/jsp/reservation/element/${policy.prodoctcode}/banner-info.jsp"></jsp:include>
						<div class="banner-product-ac">
							<form action="${ctx}/reservation/reserve" id="formReserve1" method="post" >
							   <a id="sumAmount1" class="btn b-quote" href="javascript:;"><b></b><span>立即试算</span></a>
						       <input  type ="hidden" name="policy.prodoctcode" value="${policy.prodoctcode}" />
						    </form>
						</div>
					</div>
				</div>
			</div>
<!-- 			产品详情图片 -->
			<div class="product-talk">
				<div class="container">
					<img class="hidden-lg" src="${ctx}/resources/image/reservation/${policy.prodoctcode}/pt-talk-sm.jpg">
					<img class="hidden-sm" src="${ctx}/resources/image/reservation/${policy.prodoctcode}/pt-talk-lg.jpg">
				</div>
			</div>
			<div class="container">
				<div class="product-example">
					<img class="hidden-lg" src="${ctx}/resources/image/reservation/${policy.prodoctcode}/pt-example-sm.jpg">
					<img class="hidden-sm" src="${ctx}/resources/image/reservation/${policy.prodoctcode}/pt-example-lg.jpg">
				</div>
				<div class="product-notice">
					<img class="hidden-lg" src="${ctx}/resources/image/reservation/${policy.prodoctcode}/pt-notice-sm.jpg">
					<img class="hidden-sm" src="${ctx}/resources/image/reservation/${policy.prodoctcode}/pt-notice-lg.jpg">
				</div>
			</div>
		</div>
		<div class="quote-action">
			<div class="container">
				<form action="${ctx}/reservation/reserve" id="formReserve2" method="post" >
				  <a id="sumAmount2" class="btn insure qt" href="javascript:;"><b></b><span>立即试算</span></a>
			      <input  type ="hidden" name="policy.prodoctcode" value="${policy.prodoctcode}" />
			    </form>
			</div>
			<img class="bottom-tree hidden-sm" src="${ctx}/resources/image/common/tree.png"/>
		</div>
		<jsp:include page="../common/foot.jsp"></jsp:include>
	</div>
</body>
</html>