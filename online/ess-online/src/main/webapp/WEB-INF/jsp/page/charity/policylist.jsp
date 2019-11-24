<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>保单列表</title>
	
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="../../global/css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="../../global/css/all.css" type="text/css"></link>
    <!-- 引入 -->
	<link href="../../global/css/common/main.min.css?${random}" rel="stylesheet"/>
	<link href="../../global/css/page/page.min.css?${random}" rel="stylesheet"/>
	<link href="../../global/css/animate/animate.css" rel="stylesheet"/>
	<link href="../../global/css/animate/loader-ani.css" rel="stylesheet"/>
	
	<script src="../../global/lib/jquery/jquery-2.1.3.min.js"></script>
	<script src="../../global/lib/common/main.js?${random}"></script>
	
	<script src="../../global/lib/component/modal.js"></script>
	
	<script src="../../global/lib/jquery/jquery.event.move.js"></script>
	<script src="../../global/lib/jquery/jquery.mobile.touch.js"></script>
	<script src="../../global/lib/jquery/jquery.event.swipe.js"></script>
	
	<!-- 引入 end-->
    <script type="text/javascript" src="../../global/js/jquery/1.9.0/jquery.min.js"></script>
  	<script type="text/javascript" src="../../global/js/common.js"></script>
  	<!-- init page scale-->
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
  	<meta name="format-detection" content="telephone=no"/>
  </head>
  <style>
		.txt1{font-size: 1.3em;}
	.txt2{font-size: 1.0em;}
	.txt3{font-size: 0.9em;}
	.txt4{font-size: 0.8em;}
	.txt5{font-size: 0.7em;}
		@media only screen and (max-width: 960px) {
		.txt1{font-size: 1.2em;}
		.txt2{font-size: 0.9em;}
		.txt3{font-size: 0.7em;}
		.txt4{font-size: 0.7em;}
		.txt5{font-size: 0.6em;}
	}

	@media only screen and (max-width: 640px) {
		.txt1{font-size:1.1em;}
		.txt2{font-size: 0.8em;}
		.txt3{font-size: 0.6em;}
		.txt4{font-size: 0.6em;}
		.txt5{font-size: 0.5em;}
	}

	@media only screen and (max-width: 480px) {
		.title1{font-size: 1.0em;}
		.txt2{font-size: 0.7em;}
		.txt3{font-size: 0.5em;}
		.txt4{font-size: 0.5em;}
		.txt5{font-size: 0.4em;}
	}
  </style>
  <body>
  	<div class="header">
    	<div>
	    	<div class="headertitle">保单列表</div>
	    	<div class="clear"></div>
    	</div>
    </div>
    <div class="clear"></div>
    <div class="container">
   		<div class="content" id="personpolicylist">
   		<c:forEach var="policy" items="${policyList}"  varStatus="this_status">
   			<div class="signdiv">
    			<div class="signimg" onclick="javascript:window.location.href='<%=path %>/msl/sales/findCharityInfo?policycode=${policy.policycode }'">
    				<img src="../../global/images/redbook.png"/>
    			</div>
    		</div>
    		<div class="signdiv1">
    		<div class="signarrow"></div>
    		</div>
   			<div class="hidetable">
   				<div class="width80p firstdiv">
   					<div class="black">${policy.productname }</div>
   					<div>保单号：${policy.policycode }</div>
   					<div>生效日期：${policy.takeeffecttime }</div>
   				</div>
   				<div class="width20p seconddivshow cursor">
   					<div class="showbtn"></div>
   				</div>
   				<div class="width20p seconddivhide cursor" onclick="javascript:window.location.href='<%=path %>/msl/sales/findCharityInfo?policycode=${policy.policycode }'">	
   					<div class="hidebtn">
   						<span class="hidespan1"></span>
   						<span class="hidespan2"></span>
   					</div>
   				</div>
   				<div class="width20p forthdiv cursor">
   					<img src="../../global/images/detailinfo.png" class="width36"/>
   					<div>详细信息</div>
   				</div>
   			</div>
   			 <c:if test="${this_status.last==false}">
    			<div class="hidelinkline"></div> 
    		</c:if> 
   			</c:forEach>
   			<div class="lastlinkline"></div>
    		 <div class="clear"></div>
    	</div>
    	
    </div>
    <div class="clear"></div>
<!-- 框体 -->
	<div class="modal fade" data-rule="alert" id="modal_alert">
		<div class="modal-dialog alert">
			<div class="modal-header clearfix"><span data-title="modal">提示信息</span><a type="button" class="close" data-dismiss="modal"></a></div>
			<div class="modal-content" data-content="modal"></div>
			<div class="modal-footer">
				<a class="modal-btn btn" data-dismiss="modal" data-btn="modal">确定</a>
			</div>
		</div>
	</div>
	
	
<!-- 		加载等待框 -->
	<div class="modal fade" data-rule="loading" id="modal_loading">
		<div class="modal-dialog loading">
			<div class="modal-content" data-content="modal">
				<p class="loader8">加载中......</p>
			</div>
		</div>
	</div>
  </body>
 
  <script type="text/javascript">
  var conwidth =  parseInt($(".container").width());
  //	$(".header").width(conwidth);
	//alert($(".container").width());alert($(".header").width());
	
/*   <c:if test="${Contenct!=null}">
	$(document).ready(function(){
			modal_alert({content:'${Contenct}',btn:'确定'});
	});	
</c:if> */
</script>
 
    <%--  <%@ include file="/page/result.jsp"%>  --%>
</html>
