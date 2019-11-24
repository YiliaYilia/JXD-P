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
<title>稳康宝</title>
</head>
<body onload="backshow()">
<div class="wkb">
	<!--标题区域-->
  	<div class="wkbnav txt16">
  		<div class="menu">填写信息</div>
  		<div class="menu" style="color:#fff;">健康告知</div>
  		<div class="menu">确认投保</div>
  		<div class="menu">在线缴费</div>
  		<div class="clear"></div>
  	</div>
   	<section class="notice_wrap">
   		<div class="txt16 margin50">
   			<p>被保险人生活习惯告知：</p>
			<p class="two_lev">
				1、被保险人目前是否吸烟？<br/>
				2、目前是否饮酒？<br/>
				3、是否使用成瘾药物如镇静安眠药、迷幻药，吸食或注射毒品？<br/><br/>
			</p>
			
			<p>财务及保险经历告知：</p>
			<p class="two_lev">
			1、投保人是否在银行有贷款或向其他人有借贷？<br/>
			2、被保险人在其他保险公司正在申请和已生效的重大疾病保险保额累计是否超过人民币50万元？<br/>
			3、被保险人是否曾被保险公司拒保、延期承保、加费或任何形式的修改承保、或解除过保险合同？是否曾经申请过人身保险或重大疾病保险理赔？<br/><br/>
 			</p>
 			
 			<p>被保险人健康告知：</p>
 			<p class="two_lev">
 			1、近期诊治：在过去六个月内是否做过诊断性检查如X光、超声波、CT、活体检查、验血、验尿、宫颈涂片、乳腺检查、乳腺X光检查以及是否接受过医生的诊察、治疗、用药、手术？<br/>
			2、是否曾患有或正在患有或被告知患有下列症状、疾病或因此而接受治疗？<br/>
				A. 反复头晕、反复头痛、晕厥、胸闷、心慌、气急、不能平卧、口唇发紫、淤血、鼻出血、反复牙龈出血、呕血、咳血、浮肿、腹痛、便血、血尿、尿蛋白、肿块、
				黄疸、声嘶、关节红肿或酸痛；或曾在过去六个月内持续一周以上出现下列症状：体重下降、食欲不振、盗汗、腹泻、淋巴结肿大或皮肤溃烂；<br/>
				B. 继发性高血压、风湿性心脏病、冠心病、心肌梗塞、肺心病、脑血管病、中风；<br/>
				C.呼吸衰竭、瘫痪；<br/>
				D. 消化性溃疡或出血、食道静脉曲张、脾大、肠梗阻、肝炎、肝炎病毒携带、肝硬化、胆石症、胰腺炎或其他消化系统疾病；<br/>
				E.肾衰竭、肾盂积水等疾病；<br/>
				F. 癌症、白血病、肿瘤、肿物、囊肿、息肉等；<br/>
				G.再生障碍性贫血、白血病、血友病<br/>
				H.糖尿病、甲状旁腺疾病或其他内分泌系统或代谢性疾病；<br/>
				I. 精神分裂症、抑郁症；<br/>
				J.骨骼、关节疾病或结缔组织疾病；<br/>
				K. 眼、耳、鼻、咽、喉或口腔疾病；<br/>
				L.您及您的配偶是否曾接受艾滋病毒（HIV）的检验（如有请提供检查结果）；<br/>
			3、有无智能障碍？<br/>
			4、您的亲属是否曾患有恶性肿瘤？<br/><br/>
			</p>
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
				window.location.href="<%=request.getContextPath()%>/msl/sales/WKBInsureConfirm";
			}
		}
	}
  </script>
</html>