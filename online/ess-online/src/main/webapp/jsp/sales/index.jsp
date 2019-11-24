<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>

	<%@ include file="../common/meta.jsp"%>
	
	<%@ include file="../common/rels.jsp"%>
	<script src="${ctx}/resources/js/sales/index.js?${random}"></script>
</head>
<body>
	<div class="wrap home">
		<jsp:include page="../common/head.jsp"></jsp:include>
		<div class="head">
    		<h1 class="head-name">网销专属产品</h1>
		</div>
		<div class="content">
			<div class="banner">
				<a class="banner-img" href="#">
					<img class="hidden-lg" src="${ctx}/resources/image/sales/banner-sales-m.jpg">
					<img class="hidden-sm" src="${ctx}/resources/image/sales/banner-sales-lg.jpg">
				</a>
				<div class="container"></div>
			</div>
			<div class="pt-title hidden-sm">
				<div class="container">网销专属产品</div>
			</div>
			<div class="container">
				<div class="pt-list row">
				<form action="${ctx}/msl/sales/product" method="post" id="from">
					<div class="pt-item col-sm-24 col-lg-8">
						<img src="${ctx}/resources/image/sales/pt1.png">
						<div class="pt-detail">
							<div class="pt-name">中宏私家车<br class="hidden-sm">意外伤害险</div>
							<p>1天5分钱，保障10万元！<b></b></p>
						</div>
						<div class="pt-btn">
							<a class="btn buy" id="buyPAC"><span>立即购买</span><b></b></a>
						</div>
					</div>
					<div class="pt-item col-sm-24 col-lg-8">
						<img src="${ctx}/resources/image/sales/pt2.png">
						<div class="pt-detail">
							<div class="pt-name">中宏旅游<br class="hidden-sm">意外伤害险</div>
							<p>1天5分钱，保障10万元！</p>
						</div>
						<div class="pt-btn">
							<a class="btn buy" id="buyPAT"><span>立即购买</span><b></b></a>
						</div>
					</div>
					<div class="pt-item col-sm-24 col-lg-8">
						<img src="${ctx}/resources/image/sales/pt3.png">
						<div class="pt-detail">
							<div class="pt-name doubt">中宏法定节假日<br>意外伤害险</div>
							<p>假期安心畅游必备之选！</p>
						</div>
						<div class="pt-btn">
							<a class="btn buy" id="buyPAH"><span>立即购买</span><b></b></a>
						</div>
					</div>
					<input type="hidden" name="policy.prodoctcode" id="productcode">
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="../common/foot.jsp"></jsp:include>
	</div>
</body>
</html>