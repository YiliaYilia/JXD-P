<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>

	<%@ include file="../common/meta.jsp"%>
	
	<%@ include file="../common/rels.jsp"%>
	
	<script src="${ctx}/resources/js/reservation/index.js"></script>
</head>
<body>
	<div class="wrap home quote">
		<jsp:include page="../common/head.jsp"></jsp:include>
		<div class="head">
    		<h1 class="head-name">热销线下爆款</h1>
		</div>
		<div class="content">
			<div class="banner">
				<a class="banner-img" href="#">
					<img class="hidden-lg" src="${ctx}/resources/image/sales/banner-sales-m.jpg">
					<img class="hidden-sm" src="${ctx}/resources/image/sales/banner-sales-lg.jpg">
				</a>
				<div class="container"></div>
			</div>
			<div class="container">
				<div class="pt-list row">
					<div class="pt-item col-sm-24 col-lg-8">
						<img src="${ctx}/resources/image/reservation/rs-pt1.png">
						<div class="pt-detail">
							<div class="pt-name">中宏长保福星重大<br>疾病保险</div>
							<p>为您的孩子撑起爱的保护伞！</p>
						</div>
						<div class="pt-btn">
							<form action="${ctx}/reservation/product" id="formCCC" method="post" >
							   <a id="codeCCC" href="javascript:;" class="btn quote"><span>保费试算</span><b></b></a>
						       <input type ="hidden" name="policy.prodoctcode" value="CCC"  />
						    </form>
						 </div>
					</div>
					<div class="pt-item col-sm-24 col-lg-8">
						<img src="${ctx}/resources/image/reservation/rs-pt2.png">
						<div class="pt-detail">
							<div class="pt-name">中宏长保安康重大<br>疾病保险</div>
							<p>给您稳稳的幸福！</p>
						</div>
						<div class="pt-btn">
						   <form action="${ctx}/reservation/product" id="formCDC" method="post" >
							 <a id="codeCDC" href="javascript:;" class="btn quote"><span>保费试算</span><b></b></a>
						      <input type ="hidden" name="policy.prodoctcode" value="CDC"  />
						   </form>
						</div>
					</div>
					<div class="pt-item col-sm-24 col-lg-8">
						<img src="${ctx}/resources/image/reservation/rs-pt3.png">
						<div class="pt-detail">
							<div class="pt-name doubt">中宏陪伴成长少儿<br>理财计划</div>
							<p>给您的孩子准备一辈子的压岁钱！</p>
						</div>
						<div class="pt-btn">
						  <form action="${ctx}/reservation/product" id="formNBJ" method="post" >
							<a id="codeNBJ" href="javascript:;" class="btn quote"><span>保费试算</span><b></b></a>
						    <input type ="hidden" name="policy.prodoctcode" value="NBJ"  />
						  </form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../common/foot.jsp"></jsp:include>
	</div>
</body>
</html>