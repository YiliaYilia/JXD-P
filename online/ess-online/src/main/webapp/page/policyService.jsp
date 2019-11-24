<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.com.sinosoft.web.service.impl.WeiXinServiceImpl" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
WeiXinServiceImpl weixin = new WeiXinServiceImpl();
String openId = weixin.getOpenId(request);
%>
<html>
<head>
<title>保单服务</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"
	name="viewport" />
<meta name="format-detection" content="telephone=no" />
<link href="../global/css/common/main.min.css?${random}" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="../uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/style-font.css">
<link href="../global/css/animate/loader-ani.css" rel="stylesheet" />
<script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
<style type="text/css">
.link-btn {
	height: 200px;
	background: #f0f0f0;
	padding: 15px 0px;
}

.link-btn li {
	width: 70%;
	margin: 0 auto;
	text-align: center;
	line-height: 30px;
	border-radius: 4px;
	border: 1px solid #dec36d;
	margin-bottom: 10px;
	background: #fff;
	color: #666;
}

.link-btn li a {
	color: #666;
}
</style>
</head>
<body class="gray">
	<div class="grace-head"></div>
	<div class="banner">
		<img src="../uinew/images/insurance-pic2.jpg" width="100%" alt="" />
	</div>
	<ul class="link-btn" style="margin-bottom: 100px">
		<li><a href="#" onclick="getPolicyList()"> 保单查询</a></li>
		<li><a href="#" onclick="getOrderList()">订单查询 </a></li>
		<li><a href="#" onclick="expiredDate('myInfo')">变更个人联系方式 </a></li>
		<li><a href="#" onclick="expiredDate('crsInfoChange')">个人税收居民身份声明</a></li>
		<li><a href="#" id="contractReview">网销保单在线回访</a></li>
		<li><a href="#" onclick="clientUnbind()">微信解绑</a></li>
	</ul>
	<input type="hidden" id="appid" name="appid" />
	<input type="hidden" id="urlPrefix" name="urlPrefix" />
	<div class="footer" style="position: fixed;">
		<img src="../uinew/images/bottom-line.jpg" alt="" width="100%" />
	</div>
</body>
<script type="text/javascript">
	$(document).ready(
			function() {
				var hostname = location.hostname;
				if (hostname.startsWith('testweixin')) {
					$("#contractReview").attr("href","https://staging.oldmutual-guodian.com/common/onlineService/contractReview/");
					$("#appid").attr("value", "wx618b6902989a293e");
					$("#urlPrefix").attr("value","http://testweixin.oldmutual-guodian.com/online/");
				} else if (hostname.startsWith('weixin')) {
					$("#contractReview").attr("href","https://www.oldmutual-guodian.com/common/onlineService/contractReview/");
					$("#appid").attr("value", "wx5be4b58fee2539db");
					$("#urlPrefix").attr("value","http://weixin.oldmutual-guodian.com/online/");
				}
			});
	function getPolicyList() {
		window.location.href = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid='
				+ $('#appid').val()
				+ '&redirect_uri='
				+ $('#urlPrefix').val()
				+ 'page/loading.jsp&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect';
	}

	function getOrderList() {
		window.location.href = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid='
				+ $('#appid').val()
				+ '&redirect_uri='
				+ $('#urlPrefix').val()
				+ 'action/todayOrderList&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect';
	}

	function expiredDate(operationName) {
		var url = $('#urlPrefix').val()
				+ 'page/loadingForExpiredDate.jsp?operationName='
				+ operationName;
		window.location.href = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid='
				+ $('#appid').val()
				+ '&redirect_uri='
				+ encodeURIComponent(url)
				+ '&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect';
	}
	
	function clientUnbind() {
		var flag = confirm("您是否确认解绑此微信号的保单查询服务功能。");
		if (flag) {
			$.ajax({
	    		url :'<%=path %>/action/clientUnbind',
	    		dataType : "json",
	    		type : "POST",
	    		async : false,
	    		data : {
	    			"openId" : '<%=openId%>',
	    		},
	    		success : function(data) {
	    			alert(data.content);
	    		}
	    	});
		}
	}
</script>
</html>

