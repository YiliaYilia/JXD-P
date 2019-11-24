<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>   
   <title>支付成功-瑞泰人寿</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<%@ include file="../../common/meta.jsp"%>
	<%@ include file="../../common/rels.jsp"%>
	 <link href="<%=request.getContextPath()%>/global/global/css/common.css?${random}" rel="stylesheet"/>
	<%--<link href="<%=request.getContextPath()%>/global/global/css/sale.css?${random}" rel="stylesheet"/> --%>
	<style type="text/css">
	.paid{width:100%; text-align:center; font-size:1.3em;margin:0 auto;padding-top:10%;}
	.premium{width:100%;text-align:center;font-size:1.3em;margin:0 auto;padding-top:10%;}
	.success_time{width:100%;text-align:center;font-size:1.3em;margin:0 auto;padding-top:10%;}
	.footer{width:90%;margin:20px auto;height:50px}
	.footer .img_div{float:left;width:25%;margin: 5px auto;}
	.footer .img_div .logoimg {width: 100%;}
	.footer .addr_div{float:right;width:70%;margin-left:5%}
	.footer .addr_div .foot_span{color:#808080;float:left;width:100%}
	</style>
  </head>
  
  <body>
    	<p class="paid">您购买的</p>
    	<p class="paid">${productname}</p>
    	<%-- <p class="paid">保单号：${policyCode}</p> --%>
		<p class="premium">保费： ${orderamount}元</p>
		<p  class="success_time">已于${paydate}支付成功</p>
    	<div class="clear"></div>
    	
		<div style="position: fixed;bottom: 30px;" >
		<div class="footer">
		<div class="img_div"><img class="logoimg" src="<%=request.getContextPath() %>/global/global/images/logo.png"></div>
		<div class="addr_div txt10">
			<div class="foot_span">客户服务专线：4008109339</div>
			<div class="foot_span">网址：www.oldmutual-chnenergy.com</div>
		</div>
		<div class="clear"></div>
		</div>
		</div>
  </body>
</html>
