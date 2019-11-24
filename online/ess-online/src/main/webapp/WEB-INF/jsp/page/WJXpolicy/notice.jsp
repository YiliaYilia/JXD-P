<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ include file="../../common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>稳驾行</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
 	<meta name="format-detection" content="telephone=no"/>
 	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/wjx/wjx.css" type="text/css"></link>
	<!-- 暂时  -->
 	<script src="<%=request.getContextPath() %>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
  </head>
  <body onload="backshow()">
  	<!--标题区域-->
  	<div class="nav txt16">
  		<div class="menu">填写信息</div>
  		<div class="menu" style="color:#fff;">健康告知</div>
  		<div class="menu">确认投保</div>
  		<div class="menu">在线缴费</div>
  		<div class="clear"></div>
  	</div>
   	<section class="notice_wrap">
   		<p class="txt16 margin50">
   			1、被保险人在其他保险公司正在申请和已生效的私家车意外险风险保额累计是否超过人民币50万元？<br/>
			2、被保险人是否曾被保险公司拒保、延期承保、加费或任何形式的修改承保、或解除过保险合同？是否曾经申请过任何形式的保险理赔？ 
   		</p>
	 		<form action="">
	 			<p class="txt16"><input id="yes" type="radio"   value="" name="yes"/><span class="radio_img"></span>是</p>
	 			<p class="txt16"><input type="radio" value=""  id="no" name="yes"/><span class="radio_img"></span>否</p>
	 		</form>
	 	</section>
	  <!-- 按钮区域 -->
   	<section class="btn_wrap">
   		<div class="one_btn txt24" onclick="confirm()">下一步</div>
   	</section>
   	<div class="footer">
		<div class="img_div"><img class="logoimg" src="<%=request.getContextPath() %>/global/global/images/logo.png"></div>
		<div class="addr_div txt10">
			<div class="foot_span">客户服务专线：4008109339</div>
			<div class="foot_span">网址：www.oldmutual-chnenergy.com</div>
		</div>
	<div class="clear"></div>
	</div>
  </body>
  <script>
  	$(".radio_img").click(function(){
		if($(this).prev().prop("checked")==false){
			$(".radio_img").removeClass("current_radio");
			$(this).addClass("current_radio");
			$(this).prev().prop("checked",true);
		}
	});
	function backshow(){
		if($("#no").prop("checked")==true){
		$("#no").next().addClass("current_radio");
		}
	}
	function confirm(){
		if ($(":radio:checked").length == 0)
		{
			alert("请选择是或否");
		}else{
			if($("#yes:checked").length == 1){
				alert("非常抱歉，您填写的投保告知存在异常，请通过其他方式投保，详询客服专线：4008109339，谢谢！ ");
			}else{
				window.location.href="<%=request.getContextPath()%>/msl/sales/WJXInsureConfirm";
			}
		}
	}
  </script>
</html>

