<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>国电资本控股</title>
    <%@ include file="../../common/meta.jsp"%>
	<%@ include file="../../common/rels.jsp"%> 
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/charity/wechat.css">	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
  		<h1>慈善捐助查询</h1>
  		<a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx618b6902989a293e&redirect_uri=http://testweixin.oldmutual-guodian.com/online/msl/sales/findCharityPolicy&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect">
  		<!-- <a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx5be4b58fee2539db&redirect_uri=http://weixin.oldmutual-guodian.com/onlineTaste/msl/sales/findCharityPolicy&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect"> -->
    		<div class="btn">
   			保单查询
   			</div>
   		</a>
   		<a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx618b6902989a293e&redirect_uri=http://testweixin.oldmutual-guodian.com/online/msl/sales/findHonor&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect">
   		<!-- <a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx5be4b58fee2539db&redirect_uri=http://weixin.oldmutual-guodian.com/onlineTaste/msl/sales/findHonor&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect"> -->
   		<div class="btn" style="margin-top:80px;">
   			 荣誉证书查询
   		</div>
   		</a>
   		<div class="btn" >
   			助学金捐赠进度
   		</div>
   		
   		<div class="info_hid" style="display: none;">
   			您捐助的助学金进度是：${sgiftStatus}。
   		</div>
   		<div class="clear"></div>
   		<div class="btn" style="margin-top:80px;">
   				爱心书库捐赠进度
   		</div>
   		<div class="info_hid" style="display: none;">
   			您捐助的助学金进度是：${sgiftStatus}。
   		</div>
   		<div class="clear"></div>
  </body>
  	<script>
  		$(".btn").click(function(){
		$(".info_hid").css("display","none");
		$(this).next().css("display","block");  			
 		});
  </script>
</html>
