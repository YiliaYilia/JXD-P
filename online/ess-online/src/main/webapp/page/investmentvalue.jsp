<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
HashMap<String,String>[] investments = (HashMap[])request.getAttribute("investments");
for(HashMap<String,String> investment:investments){
	if(investment.get("rate") != "" && investment.get("rate") != null && investment.get("rate").endsWith("%")){
		String[] temp = investment.get("rate").split("[.]");
		investment.put("rate", temp[0]+"%");
	}
}
%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>保单详情</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
  	<!-- init page scale-->
	<meta name="viewport" content="width=device-width, target-densitydpi=240,initial-scale=0.667, minimum-scale=0.667, maximum-scale=0.667, user-scalable=0" id="viewport">
	<meta name="format-detection" content="telephone=no"/>
<link rel="stylesheet" type="text/css" href="../uinew/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/style-font.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/default.css">
<link href="../uinew/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />	

  </head>
   <style>
	
* {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

html {
	-ms-touch-action: none;
}

body,ul,li {
	padding: 0;
	margin: 0;
	border: 0;
}


#header {
	position: absolute;
	z-index: 2;
	top: 0;
	left: 0;
	width: 100%;
	height: 45px;
	line-height: 45px;
	background: #CD235C;
	padding: 0;
	color: #eee;
	font-size: 20px;
	text-align: center;
	font-weight: bold;
}

#footer {
	position: absolute;
	z-index: 2;
	bottom: 0;
	left: 0;
	width: 100%;
	height: 48px;
	background: #444;
	padding: 0;
	border-top: 1px solid #444;
}

#wrapper {
	
	position: absolute;
	z-index: 1;
	top: 95px;
	bottom: 48px;
	left: 0;
	width: 100%;
	background: #ccc;
	overflow: hidden;
}

#scroller {
	position: absolute;
	z-index: 1;
	-webkit-tap-highlight-color: rgba(0,0,0,0);
	width: 800px;
	height: auto;
	background-color: #a00;
	-webkit-transform: translateZ(0);
	-moz-transform: translateZ(0);
	-ms-transform: translateZ(0);
	-o-transform: translateZ(0);
	transform: translateZ(0);
	-webkit-touch-callout: none;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	-webkit-text-size-adjust: none;
	-moz-text-size-adjust: none;
	-ms-text-size-adjust: none;
	-o-text-size-adjust: none;
	text-size-adjust: none;
}

#scroller ul {
	list-style: none;
	padding: 0;
	margin: 0;
	width: 100%;
	height: 100%;
	text-align: center;
}

#scroller li {
	display: block;
	float: left;
	width: 120px;
	height: 100%;
	border-right: 1px solid #dfdfdf;
	background-color: #fafafa;
	font-size: 14px;
}


  </style>
  
<body  class="gray" onload="loaded()">
  <div class="grace-head"> </div>
  <div class="insurance-title">保单投资信息</div>
  <div id="wrapper">
	<div id="scroller">
		 <table width="100%" border="0" cellspacing="0" cellpadding="0" style="width:800px; background:#fff;" class="insurance-table">
  <tr class="insurance-table-line">
    <td style="20%">投资账户名称</td>
    <td style="20%">实际投资分配比例</td>
    <td style="20%">投资单位数量</td>
    <td style="20%">卖出价</td>
    <td style="20%">投资单位价格日期</td>
    <td style="10%">投资账户价格</td>
  </tr>
    <% for(HashMap hashmap:investments){
    				if("0.00".equals(hashmap.get("units"))){
    					continue;
    				}else{
    			%>
  <tr>
    <td style="20%"><%=hashmap.get("investmentName") %></td>
    <td style="20%"><%=hashmap.get("rate") %></td>
    <td style="20%"><%=hashmap.get("units") %></td>
    <td style="20%"><%=hashmap.get("price") %></td>
    <td style="20%"><%=hashmap.get("priceDate") %></td>
    <td style="10%"><%=hashmap.get("value") %></td>
  </tr>
    			<% }}%>
</table>

	</div>
</div>
<div class="footer footer-fixed "> <img src="../uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>

  </body>
</html>
<script src="../uinew/js/jquery.js"></script>
<script src="../uinew/js/fileinput.js" type="text/javascript"></script>
<script src="../uinew/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../uinew/js/iscroll.js"></script>

<script type="text/javascript">
var myScroll;
function loaded () {
	myScroll = new IScroll('#wrapper', { scrollX: true, scrollY: false, mouseWheel: true });
}
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
</script>