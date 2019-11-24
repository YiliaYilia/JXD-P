<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>瑞泰人寿</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/sales/propagate.css">
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
   <%
		String flag = request.getParameter("flag")==null?"":request.getParameter("flag");
	%>
  </head>
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
  <body style="position:relative;">
    	<img class="page" src="../global/images/transfer_propagate.jpg" />
    	<div class="transfer_btn">
    	<%if(flag.equals("1")){ %>
    	<a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx5be4b58fee2539db&redirect_uri=http://weixin.oldmutual-guodian.com/onlineApp/msl/sales/gratisProduct?flag=1&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect"><div class="left_btn">限时抢赠险</div></a>
    	<%}else{ %>
    	<a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx5be4b58fee2539db&redirect_uri=http://weixin.oldmutual-guodian.com/onlineApp/msl/sales/gratisProduct&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect"><div class="left_btn">限时抢赠险</div></a>
    	<%} %>
    	<a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx5be4b58fee2539db&redirect_uri=http://weixin.oldmutual-guodian.com/onlineApp/msl/sales/shortProduct&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect"><div  class="right_btn">赠险不够请点我</div></a>
    	</div>
  </body>
</html>