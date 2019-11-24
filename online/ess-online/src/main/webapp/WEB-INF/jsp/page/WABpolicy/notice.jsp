<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ include file="../../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
<meta name="format-detection" content="telephone=no"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/wjx/wjx.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/wkb/wkb.css" type="text/css"></link>
<script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
<title>稳爱保</title>
</head>
<body onload="backshow()">
<div class="wkb">
	<!--标题区域-->
  	<div class="wkbnav txt16">
  		<div class="menu">填写信息</div>
  		<div class="menu" style="color:#fff;">如实告知</div>
  		<div class="menu">确认投保</div>
  		<div class="menu">在线缴费</div>
  		<div class="clear"></div>
  	</div>
   	<section class="notice_wrap">
   		<div class="txt16 margin50">
   			<p style="font-weight:bold;">被保险人生活习惯告知：</p>
			<p class="two_lev">
			1、被保险人目前是否吸烟？<br/>
			2、目前是否饮酒？<br/>
			3、是否使用成瘾药物如镇静安眠药、迷幻药，吸食或注射毒品？<br/>
			4、是否有危险嗜好或从事危险活动，如赛车、赛马、滑雪、攀岩、蹦极、潜水、跳水、拳击、武术、摔跤、探险或特技活动及其他高风险活动？<br/><br/>
			</p>
			
			<p style="font-weight:bold;">财务及保险经历告知：</p>
			<p class="two_lev">
			1、投保人是否在银行有贷款或向其他人有借贷？<br/>
			2、被保险人在其他保险公司正在申请和已生效的人寿保险保额累计是否超过人民币100万元？<br/>
			3、被保险人是否曾被保险公司拒保、延期承保、加费或任何形式的修改承保、或解除过保险合同？是否曾经申请过人身保险或重大疾病保险理赔？<br/><br/>
 			</p>
 			
 			<p style="font-weight:bold;">被保险人健康告知：</p>
 			<p class="two_lev">
 			1、被保险人是否患有或曾经患有或已经被告知有下列疾病：恶性肿瘤、脑血管疾病、心功能不全Ⅱ级（含）以上、高血压Ⅱ级（含）以上、糖尿病、冠心病、心肌梗塞、呼吸衰竭、肺心病、肝硬化、慢性肾脏疾病、肾功能不全、再生障碍性贫血、癫痫、系统性红斑狼疮、性传播疾病、白血病、慢性酒精中毒、精神疾病、智力障碍、阿尔兹海默氏病（老年痴呆或早老年痴呆症）、帕金森氏病、重症肌无力、多发性硬化症、失明、瘫痪、先天性疾病、遗传性疾病；身体畸形或残疾；艾滋病患者或艾滋病毒携带者，曾经或正在吸毒？<br/>
			2、（妇女适用）现在是否怀孕？<br/><br/>
			</p>
			<p style="font-weight:bold;">被保险人职业类型告知：</p>
			<p class="two_lev">
			您的职业属于以下职业类型吗？<br/>
			<a href="../../resources/pdf/wab/wabNoJob.xlsx">职业类型</a><br/><br/>
 			</p>
 			<p style="color:black;">您是否存在以上情况的一种或多种？</p>
   		</div>
 		<form action="" class="radio_div">
 			<p class="txt16"><input id="yes" type="radio" value="" name="1"/><span class="radio_img"></span>是</p>
 			<p class="txt16"><input type="radio" value="" id="no" name="1"/><span class="radio_img"></span>否</p>
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
				window.location.href="<%=request.getContextPath()%>/msl/sales/WABInsureConfirm";
			}
		}
	}
  </script>
</html>