<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>国电资本控股</title>
    <%@ include file="../../common/meta.jsp"%>
	<%@ include file="../../common/rels.jsp"%>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/charity/insurant.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

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
    	<div style="position:relative;">
    		<img class="page" src="<%=request.getContextPath()%>/resources/image/charity/page_bg.jpg"/>
    		<div class="right_btn" onclick="dosubmit();"><img  src="<%=request.getContextPath()%>/resources/image/charity/btn_img.png"/></div>
    		<div class="page_btn" onclick="doDetails();">捐&nbsp;&nbsp;赠&nbsp;&nbsp;详&nbsp;&nbsp;情</div>
    		<form action="<%=request.getContextPath()%>/msl/sales/matchRecognizee" method="post" id="baseForm" name="form1"></form>
    		<div onclick="dosubmit();"><img class="page_foot"  src="<%=request.getContextPath()%>/resources/image/charity/donate.png"/></div>
    	</div>
    	<%-- <jsp:include page="../../common/footer.jsp"></jsp:include> --%>
  </body>
  <script type="text/javascript">
	  function dosubmit(){
			  $("#baseForm").submit();
	  }
	  function doDetails(){
		  window.location.href =contentRootPath+'/msl/sales/charityPolicyDetails';
	  }
</script>
</html>
