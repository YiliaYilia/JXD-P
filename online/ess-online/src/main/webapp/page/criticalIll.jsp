<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>重疾绿通服务</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="../global/lib/jquery/jquery-2.1.3.min.js"></script>
  	<script type="text/javascript" src="../global/js/common.js"></script>
  	<script src="../global/lib/common/main.js?${random}"></script>	
	<script src="../global/lib/component/modal.js"></script>
	<link rel="stylesheet" type="text/css" href="../uinew/css/safe-new.css">
	<link rel="stylesheet" type="text/css" href="../uinew/css/style-font.css">
	<meta name="viewport" content="width=device-width, target-densitydpi=240,initial-scale=0.667, minimum-scale=0.667, maximum-scale=0.667, user-scalable=0" id="viewport">
	<meta name="format-detection" content="telephone=no"/>
	<style>
		a {
			text-decoration:none;
			color:#c69e47;
		}
	</style>
</head>
<body class="gray">
	<div class="grace-head"> </div>
	<h2 style="margin-top:60px; text-align:center; color:#c8a154; font-size:2em; font-weight:bold;">就医绿通服务</h2>
	<div  class="panel-collapse collapse in cardcontent" style="font-size: 1.4em;">
		<ul class="grace-form"> 
			<c:if test="${criticalIllFlag eq null || criticalIllFlag eq ''}">
				<li>您在我司投保的重疾险累计保额未达到标准，暂不能申请重疾绿通服务，欢迎继续投保我司其他重疾险产品。详情请咨询客服专线400-810-9339。</li>
			</c:if>
			<c:if test="${criticalIllFlag eq '01' || criticalIllFlag eq '03' || criticalIllFlag eq '02'}">
				<li>您的重疾险保额已达到我司重疾绿通服务的申请条件，详情请点击重疾绿通服务介绍或拨打客服专线400-810-9339。</li>
				<li class="grace-tips" style="font-size:1em;">
					<a href="http://testweixin.oldmutual-guodian.com/online/html/va-services/ServicesDetail.html#healthService">重疾绿通服务介绍</a>
				</li>
			</c:if>
		</ul>
	</div>
	<div class="footer" style="position:fixed;bottom: 0"> <img src="../uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>
</body>
</html>