<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>支付成功-瑞泰人寿</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<%@ include file="../../common/meta.jsp"%>
	<%@ include file="../../common/rels.jsp"%>
	<link href="<%=request.getContextPath()%>/global/global/css/common.css?${random}" rel="stylesheet"/>
	<link href="<%=request.getContextPath()%>/global/global/css/sale.css?${random}" rel="stylesheet"/>

  </head>
  
  <body>
    	<p class="paid">您购买的</p>
    	<p class="paid">${productname}</p>
		<p class="premium">保费： ${orderamount}元</p>
		<p  class="success_time">已于${paydate}支付成功</p>

    	<div class="clear"></div>
    	<div class="sure_btn" >确&nbsp;&nbsp;&nbsp;&nbsp;定</div>
    	<div class="clear"></div>
    	<div style="position: fixed;bottom: 30px"><jsp:include page="../../common/footer.jsp"></jsp:include></div>

  </body>
</html>
