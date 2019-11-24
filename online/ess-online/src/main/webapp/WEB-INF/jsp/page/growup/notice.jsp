<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML>
<html>
<head>
<title>健康告知-瑞泰人寿</title>
<%@ include file="../../common/meta.jsp"%>
<%@ include file="../../common/rels.jsp"%>
<link
	href="<%=request.getContextPath()%>/global/global/css/common.css?${random}"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/global/global/css/sale.css?${random}"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/uinew/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/uinew/css/style-font.css">

</head>
<style>
.cbox {
	display: block;
	width: 25px;
	height: 25px;
	border: 1px solid #000;
	background: #fff;
	text-align: center;
	float: left;
}

.cbox.checked {
	background: #fff;
}

.cbox.checked:after {
	content: "√"
}
.health-info-con {
    font-size: 1.6em;
}
.grace-applicant-info{
	border: none; 
	background: transparent;    
	font-size: 1.6em;
}
			
</style>

<body>
	<div class="grace-head"></div>
	<ul class="grace-top-menu">
		<li>填写信息</li>
		<li class="menu-select">健康告知</li>
		<li>确认投保</li>
		<li>在线缴费</li>

	</ul>

	<div class="health-info-con">
		<span>填写信息健康告知确认投保在线缴费</span>
		<p>1.被保险人是否曾经或正患有以下疾病：恶性肿瘤、心脏病、重症肌无力、多发性硬化、呼吸衰竭、肝功能衰竭、肾功能衰竭、血液病、精神疾病、癫痫、、器官移植术后、残疾、视力障碍（近视800度以上）、心肌炎、智力障碍、、肠梗阻、糖尿病、类风湿性关节病？</p>
		<p>2.过去两年内被保险人是否出现过晕厥、胸闷、呕血、咳血、便血、血尿、尿蛋白、肿块、关节红肿或酸痛、体重下降超过5公斤、淋巴结肿大或皮肤溃烂等？</p>
		<p>3.过去两年内，超声波、CT、活体组织检查?是否曾经接受外科手术、住院治疗？</p>
		<p>4.被保险人是否曾被保险公司拒保、延期承保、加费或任何形式的修改承保、或解除过保险合同？是否曾经申请过人身保险或重大疾病保险理赔？</p>
		<p>5.被保险人（其他保险公司）累计正在申请和已生效的累计重大疾病风险保额是否超过人民币20万元？</p>
		<p>6.（2周岁及以下被保险人适用）被保险人是否出生体重<
			2.5kg，是否早产、过期产、难产？是否有产伤、窒息、抢救史或被置于保温箱？是否有畸形、发育迟缓、惊厥、抽搐或脑瘫等？</p>
	</div>
	
	<div class="choose-con">
		<ul class="grace-applicant-info">
			<li><input type="radio" name="Select_Flag" value="Y"  style="width: 25px;height: 25px;"
				onclick="clickRadio(this)" /> 是</li>
			<li><input type="radio" name="Select_Flag" value="N"  style="width: 25px;height: 25px;"
				onclick="clickRadio(this)" /> 否</li>
		</ul>
		<form
			action="<%=request.getContextPath()%>/msl/sales/longPolicyInsureConfirm"
			method="post" id="noticeForm">
			<input type="hidden" id="HealthFlag" name="HealthFlag"
				value='${HealthFlag}'>
		</form>
	</div>

	<div class="next-button" style="margin-bottom: 90px;padding-bottom: 90px;">
		<img src="<%=request.getContextPath()%>/uinew/images/nextbutton.jpg"
			width="100%" alt="" onclick="dosubmit()" />
	</div>
		<div class="footer footer-fixed">
		<img src="<%=request.getContextPath()%>/uinew/images/bottom-line.jpg"
			alt="" />
	</div>
</body>
<script type="text/javascript">
	function clickRadio(radio) {
		if (radio.value === "Y") {
			document.getElementById("HealthFlag").value = "Y";
		} else {
			document.getElementById("HealthFlag").value = "N";
		}
	}

	

	function dosubmit() {
		if (document.getElementById("HealthFlag").value != "N") {
			alert("您填写的健康告知存在异常，请通过其他方式投保，详询客服专线：4008109339，谢谢！");
		} else {
			document.getElementById("noticeForm").submit();
		}

	}
</script>
</html>
