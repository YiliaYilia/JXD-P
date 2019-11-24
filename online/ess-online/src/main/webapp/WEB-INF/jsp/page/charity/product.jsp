<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>瑞泰人寿</title>
    <%@ include file="../../common/meta.jsp"%>
	<%@ include file="../../common/rels.jsp"%>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/charity/insurant.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style>
		.detail_bg{width:100%;position:relative;z-index:-1;}
		.detail_btn{width:60%;height:60px;position:absolute;z-index:1;background-color:#ff4a01;border-radius:5px;text-align:center;bottom:1%;left:20%;text-align:center;
			color: #fff;line-height:2.5em;font-size: 1.5em;}
	</style>
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
  <body>
    	<div style="pisition:relative;">
    		<img class="product"  src="<%=request.getContextPath()%>/resources/image/charity/donation_bg.jpg"/>
    		<div class="product_btn" onclick="goback();">返&nbsp;&nbsp;&nbsp;&nbsp;回
    		</div>
    	</div>
    	<%-- <jsp:include page="../../common/footer.jsp"></jsp:include> --%>
  </body>
    <script>
	  function goback(){
		  history.go(-1);
	  }
  </script>
</html>
