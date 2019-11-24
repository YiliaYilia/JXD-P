<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
	<title>自助理赔详情</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<!-- init page scale-->
	<script>
		var phoneWidth =  parseInt(window.screen.width);
		var phoneScale = phoneWidth/640;
		var ua = navigator.userAgent;
		if (/Android (\d+\.\d+)/.test(ua)){
			var version = parseFloat(RegExp.$1);
			if(version>2.3){
				document.write('<meta name="viewport" content="width=640, minimum-scale = '+phoneScale+', maximum-scale = '+phoneScale+', target-densitydpi=device-dpi">');
			}else{
				document.write('<meta name="viewport" content="width=640, target-densitydpi=device-dpi">');
			}
		} else {
			document.write('<meta name="viewport" content="width=640, user-scalable=no, target-densitydpi=device-dpi">');
		}
	</script>
	<meta name="format-detection" content="telephone=no"/>
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
	<style>
		.txt1{font-size: 1.3em;}
		.btn{width:50%;margin:20px auto;height: 2em;line-height: 2em;background: #027e64;color:#fff;border-radius:5px;text-align: center;}
		.content .tablehead .borderright .titlecontent{margin: 30px 20px;}
		.content .table{width: 100%;line-height: 3em;}
		.secondcolumn img{width:60px;height:60px;margin-right:5%;}
		.imgList{width:60px;height:60px;margin-right:5%;}
		#imgbox-overlay {position: fixed;top: 0;	left: 0;width: 100%;height: 100%;background: #000;z-index: 80;opacity:0.5;display:none;}
		#imgbox-wrap {position: absolute;top: 0;left: 0;z-index: 90;width: 100%;height: 100%;display:none;}
		#imgbox-wrap img{display:block;margin:auto;width:100%;}
		@media only screen and (max-width: 960px) {
			.txt1{font-size: 1.2em;}
		}
		@media only screen and (max-width: 640px) {
			.txt1{font-size:1.1em;}
		}
	</style>
	<script type="text/javascript">
		$(function () {
	 		$(".imgList").click(function(){
	 			window.scrollTo(0,0);
	 			$("#imgbox-overlay").show();
	 			$("#imgbox-wrap").show();
	 			$(".img-overlay").prop("src",$(this).attr("src"));
	 		})
	 		$(".img-overlay").click(function(){
	 			$("#imgbox-overlay").hide();
	 			$("#imgbox-wrap").hide();
	 		})
		})
	</script>
	<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/jquery.bxslider.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/safe-new.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/style-font.css">
</head>
<body class="gray">
	<div class="grace-head"></div>
	<h2 style="margin-top:60px; text-align:center; color:#c8a154; font-size:2.5em; font-weight:bold;">自助理赔详情</h2>
<style>
	.grace-form .pull-left {
    	width: 30%;
    	text-align: left;
	}
	.grace-form .pull-right {
    	width: 70%;
	}
</style>
	<div class="panel-collapse collapse in cardcontent " style="font-size: 1.5em;">
		<ul class="grace-form"> 
		    <li><div class="pull-left">保险单号：</div> <div class="pull-right text-right">${claim.policyCode}</div></li>
		    <li><div class="pull-left">申请人：</div> <div class="pull-right text-right">${claim.name}</div></li>
		    <li><div class="pull-left">申请日期：</div> <div class="pull-right text-right">${claim.createDate}</div></li>
		    <li><div class="pull-left">与被保险人关系：</div> <div class="pull-right text-right">${claim.insrelationApp}</div></li>
		    <li><div class="pull-left">索赔类别：</div> <div class="pull-right text-right">${claim.languageClaimManagementType}</div></li>
		    <li><div class="pull-left" style="width:35%">被保险人<br>出险日期：</div> <div class="pull-right text-right" style="width:65%;">${claim.startDate}</div></li>
		    <li><div class="pull-left">被保险人<br>出险原因：</div> <div class="pull-right text-right">${claim.startCause}</div></li>
		    <li><div class="pull-left">被保险人<br>当前职业：</div> <div class="pull-right text-right">${claim.occupation}</div></li>
		    <li><div class="pull-left">报案人<br>联系电话：</div> <div class="pull-right text-right">${claim.phone}</div></li>
		    
		    <!-- 在其他保险公司有人身保险显示 -->
			<c:if test="${claim.isInsure=='Y'}">
				<li><div class="pull-left">公司名称：</div> <div class="pull-right text-right">${claim.corporationName}</div></li>
				<li><div class="pull-left">投保日期：</div> <div class="pull-right text-right">${claim.insureDate}</div></li>
				<li><div class="pull-left">购买险种名称及保额：</div> <div class="pull-right text-right">${claim.insuranceInfo}</div></li>
			</c:if>
			<!-- 结束 -->
						
			<li><div class="pull-left">状态：</div> <div class="pull-right text-right">${claim.languageState}</div></li>
			<!-- 理赔额状态为已完成状态时显示 -->
			<c:if test="${claim.state == '05'}">
				<li><div class="pull-left">理赔额：</div> <div class="pull-right text-right">${claim.amount}</div></li>
			</c:if>
			<!-- 结束 -->
						
	        <li><div class="pull-left">备注：</div> <div class="pull-right text-right">${claim.remark}</div></li>
			<li> 
				<div class="pull-left">理赔资料：</div> 
				<div class="pull-right text-right">
					<c:forEach var="rider" items="${claimRiderSet}"  varStatus="this_status">
	   					<img src="${rider.riderPath}" class="imgList" />
	   				</c:forEach>
	            </div>
	        </li>
		</ul>  
		<ul class="link-btn"> 
			<c:if test="${claim.state == '03'}">		
				<li onclick="window.location.href ='${ctx}/msl/sales/fillSteponeClaimAction?claimManagementNo=${claim.claimManagementNo }&updateContent=updateContent';"> <a href="#" > 修改资料</a></li>
			</c:if>
			<c:if test="${claim.state == '01' || claim.state == '03'}">
				<c:if test="${claim.claimManagementType == '1' || claim.claimManagementType == '2'}">
					<c:if test="${claim.commitType == '02'}">
		     			<li onclick="window.location.href ='${ctx}/page/upload.jsp?claimManagementNo=${claim.claimManagementNo }&updateImages=updateImages';"> 
		     				<a href="#" >资料补传</a>
		     			</li>
					</c:if>
				</c:if>
			</c:if>
			<li onclick="window.location.href ='${ctx}/msl/sales/findClaimListAction'"><a href="#">返&nbsp;&nbsp;回</a></li>
	  	</ul>
	</div>
	<div id="imgbox-overlay"></div>
	<div id="imgbox-wrap"><img class="img-overlay"/></div>
	<div class="footer footer-fixed "><img src="${ctx}/uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>
</body>
</html>