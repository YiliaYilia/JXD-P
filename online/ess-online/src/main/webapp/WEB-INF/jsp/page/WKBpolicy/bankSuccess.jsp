<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../common/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    
    
    <title>提交成功-瑞泰人寿</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
	<%@ include file="../../common/meta.jsp"%>
	<%@ include file="../../common/rels.jsp"%>
	
	 <link href="<%=request.getContextPath()%>/global/global/css/common.css?${random}" rel="stylesheet"/>
	<%--<link href="<%=request.getContextPath()%>/global/global/css/sale.css?${random}" rel="stylesheet"/> --%>
	<style type="text/css">
	.paidfist{width:100%; text-align:center; font-size:1.3em;margin:0 auto;margin-top:50px;}
	.paid{width:100%; text-align:center; font-size:1.3em;margin:0 auto;margin-top:30px;}
	.premium{width:100%;text-align:center;font-size:1.3em;margin:0 auto;margin-top:30px;}
	.success_timefist{width:100%;text-align:center;font-size:1.3em;margin:0 auto;margin-top:5px;}
	.success_time{width:100%;text-align:center;font-size:1.3em;margin:0 auto;margin-top:30px;}
	.chaxun{width:95%;text-align:center;font-size:1.0em;margin:0 auto;margin-top:30px;color: red;}
	.sign{color:red;}
	.footer{width:90%;margin:20px auto;height:50px}
	.footer .img_div{float:left;width:25%;margin: 5px auto;}
	.footer .img_div .logoimg {width: 100%;}
	.footer .addr_div{float:right;width:70%;margin-left:5%}
	.footer .addr_div .foot_span{color:#808080;float:left;width:100%}
	.grace-head {
    width: 100%;
    height: 50px;
    background: url(../../uinew/images/header.jpg) center center;
    background-size: cover;
    top: 0px;
    z-index: 999;
}
	</style>
  </head>
  
  <body>
	  <div class="grace-head"></div>
		
    	<p class="paidfist">您购买的</p>
    	<p class="paid">${productname}</p>
		<p class="premium">保费： ${orderamount}元</p>
		<p  class="success_time">已于${paydate}提交成功</p>
		<c:choose>
			<c:when test="${subscribe=='1'}">
				<div>
					<p  class="success_timefist" style="margin-top: 60px;">点击<a href="<%=request.getContextPath() %>/action/todayOrderList" style="font-size: 1.35em;border-bottom:1px solid black;color:red;">订单查询</a>立即查看投保状态</p>
					<p  class="success_time" style="width:90%;">您也可以通过微信“客户服务”-“保单</p>
					<p  class="success_time" style="width:90%;">&nbsp;&nbsp;服务”-“订单查询”实时查询投保状态。</p>
				</div>
			</c:when>
			<c:otherwise>
				<div>
				<img src="<%=request.getContextPath() %>/global/global/images/erweima.jpg" style="margin:0 auto" />
					<p  class="chaxun" style="margin-top:10px;">扫描二维码关注瑞泰人寿</p>
					<p  class="success_time" style="width:90%;margin-top:20px">点击微信“客户服务”-“保单服务”</p>
					<p  class="success_time" style="width:90%;">-“订单查询”实时查询投保状态。</p>
				</div>
			</c:otherwise>
		</c:choose>
    	<div class="clear"></div>
		<div style="position: fixed;bottom:10px;" >
		<div class="footer">
		<div class="img_div"><img class="logoimg" src="<%=request.getContextPath()%>/global/global/images/logo.png"></div>
		<div class="addr_div txt10">
			<div class="foot_span">客户服务专线：4008109339</div>
			<div class="foot_span">网址：www.oldmutual-chnenergy.com</div>
		</div>
		<div class="clear"></div>
		</div>
		</div>
  </body>
</html>
