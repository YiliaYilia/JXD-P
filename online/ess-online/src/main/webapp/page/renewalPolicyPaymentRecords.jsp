<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>保单交费记录</title>
	
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
<script>
		var subFlag = true;
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
		$(function () {
			var divNum = $(".payment-outer-content").length;
			for(var i = 1;i <= divNum;i++){
				if(i <= 5){
					$(".payment-outer-content").attr("style","display:block");
				}else{
					$(".payment-outer-content").attr("style","display:none");
				}
			}
	 	})
		function divShow(){
			$(".payment-outer-content").attr("style","display:block");

		}
</script>
  	<meta name="format-detection" content="telephone=no"/>
 <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="../global/css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="../global/css/all.css" type="text/css"></link>
    <!-- 引入 -->
	<link href="../global/css/common/main.min.css?${random}" rel="stylesheet"/>
	<link href="../global/css/page/page.min.css?${random}" rel="stylesheet"/>
	<link href="../global/css/animate/animate.css" rel="stylesheet"/>
	<link href="../global/css/animate/loader-ani.css" rel="stylesheet"/>
	
	<script src="../global/lib/jquery/jquery-2.1.3.min.js"></script>
	<script src="../global/lib/common/main.js?${random}"></script>
	
	<script src="../global/lib/component/modal.js"></script>
	
	<script src="../global/lib/jquery/jquery.event.move.js"></script>
	<script src="../global/lib/jquery/jquery.mobile.touch.js"></script>
	<script src="../global/lib/jquery/jquery.event.swipe.js"></script>
	
	<!-- 引入 end-->
    <script type="text/javascript" src="../global/js/jquery/1.9.0/jquery.min.js"></script>
  	<script type="text/javascript" src="../global/js/common.js"></script>

	<style>
	.grace-form .pull-right {
    text-align: right;
	}
		.grace-form .pull-right input{
    font-family:"微软雅黑";
    color: rgb(102, 102, 102);
    font-size:22.4px;
	}
	.payment-outer-content {
    width: 100%;
    border-bottom: 2px solid #c6c6c6;
}

.payment-outer-content-div {
    width: 100%;
    padding-top: 20px;
    background-color: #fff;
}

.payment-outer-content-div-span1 {
    margin: 0 5%;
}

.payment-outer-content-div:last-child {
    padding-bottom: 20px;
}

.payment-outer-content2 {
    width: 100%;
    height: 50px;
    line-height: 50px;
    text-align: center;
    background-color: #fff;
}

.payment-outer-content2-span {
    font-size: 20px;
    color: #333;
}
	
	</style>
</head>
    <div class="clear"></div>
    <body  class="gray">
     <div class="payment-outer">
        <!-- 交费记录 -->
        <c:forEach var="records" items="${recordsList}"  varStatus="this_status">
        <div class="payment-outer-content" style="display: none;">
            <div class="payment-outer-content-div">
                <span class="payment-outer-content-div-span1">应交日期：${records.dueDate}</span>
                <span class="payment-outer-content-div-span2">扣费日期：${records.payDate}</span>
            </div>
            <div class="payment-outer-content-div">
                <span class="payment-outer-content-div-span1">扣费银行：中国建设银行${records.deductBank}</span>
                <span class="payment-outer-content-div-span2" style="color: #FAA63E;">${records.payAmount }</span>
            </div>
        </div>
        </c:forEach>
        
        <!-- 展示更多 -->
        <div class="payment-outer-content2">
            <span class="payment-outer-content2-span" id="recordsLoad" onclick="divShow()">展示更多</span>
        </div>
    </div>
<div class="footer footer-fixed" > <img src="../uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>


</body>
</html>
