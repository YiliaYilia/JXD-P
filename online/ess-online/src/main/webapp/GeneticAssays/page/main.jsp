<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="format-detection" content="telephone=no" />

<title>肺癌易感基因免费检测邀请函</title>
<link rel="stylesheet"
	href="../GeneticAssays/resources/css/main.min.css" />
<link rel="stylesheet" href="../GeneticAssays/resources/css/product.css" />

<script type="text/javascript"
	src="../GeneticAssays/resources/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript"
	src="../GeneticAssays/resources/js/jquery.touchSwipe.min.js"></script>
<script type="text/javascript"
	src="../GeneticAssays/resources/js/display.js"></script>
</head>
<body>
	<div class="page_wrap" id="page-wrap">
		<div class="page page1 active">
			<img src="../GeneticAssays/resources/images/describe.png"
				class="page1_describe" /> <img
				src="../GeneticAssays/resources/images/big_circle.png"
				class="page1_bg" />
			<p class="single" style="bottom: 54%;">你爱吸烟吗？</p>
			<p class="double"
				style="bottom: 48%; color: #a1cbff; z-index: 103; font-size: 1.6em;">你关注健康吗？</p>
			<p class="single" style="bottom: 42%;">你是二手烟继承者吗？</p>
			<p class="double"
				style="bottom: 37%; color: #0cd6cb; font-size: 1.1em; text-indent: 2%; z-index: 103;">你生活的城市PM2.5浓度标高吗？</p>
			<p class="single" style="bottom: 31%; color: #a1cbff; z-index: 103;">你是易感人群吗？</p>
			<p class="double" style="bottom: 25%;">你有遗传家族史吗？</p>
			<img src="../GeneticAssays/resources/images/star_max.png"
				class="page1_flash" /> <img
				src="../GeneticAssays/resources/images/star.png" class="page1_star" />
			<img src="../GeneticAssays/resources/images/arrow.png" class="arrow" />
		</div>
		<div class="page page2">
			<img src="../GeneticAssays/resources/images/circle1.png"
				class="page2_circle" style="width: 36%; top: 32.6%; left: 6.125%;" />
			<img src="../GeneticAssays/resources/images/circle2.png"
				class="page2_circle" style="width: 52.5%; top: 12%;; left: 52%;" />
			<img src="../GeneticAssays/resources/images/circle3.png"
				class="page2_circle" style="width: 49.8%; top: 54%; left: 38%;" />
			<img src="../GeneticAssays/resources/images/line.png"
				class="page2_line" style="width: 18.6%; top: 35.7%; left: 40%;" />
			<div class="btn" onclick="join()">我要参与！</div>
		</div>
		<div class="page page3">
			<img src="../GeneticAssays/resources/images/describe1.png"
				class="page3_describe" />
			<div class="input_div"
				style="background: url(../GeneticAssays/resources/images/name.png) no-repeat; background-size: 100% 100%;">
				<input type="text" name="name" id="name" />
			</div>
			<div class="input_div"
				style="background: url(../GeneticAssays/resources/images/address.png) no-repeat; top: 52%; background-size: 100% 100%;">
				<input type="text" name="address" id="address" />
			</div>
			<div class="input_div"
				style="background: url(../GeneticAssays/resources/images/telephone.png) no-repeat; top: 62%; background-size: 100% 100%;">
				<input type="text" name="phone" id="phone" maxlength="11"/>
			</div>
			<div class="btn"  onclick="save()">我要提交！</div>
		</div>
	</div>
	<div class="code_cover"></div>
	<div class="code_div">
		<p>提交成功！</p>
		<img src="../GeneticAssays/resources/images/erweima.jpg" />
		<p style="font-size: 0.6em; color: #00ffea;">长按二维码关注瑞泰人寿<br/>检测完成后获取电子报告</p>
	</div>
</body>
<script type="text/javascript">
function save(){
	if(check()){
		var name=document.getElementById("name").value;
		var address=document.getElementById("address").value;
		var phone=document.getElementById("phone").value;
		$.ajax({
			   type:"POST",
			   url:"<%=request.getContextPath()%>/action/getGeneticAssays",
				data : {
					"name" : name,
					"address" : address,
					"phone" : phone
				},
				async : false,
				dataType : "json",
				success : function(data) {
					if(data.flag=="1"){
						show_code();
					}else if(data.flag=="2"){
						alert("提交失败，您已经提交过该申请");
					}else if(data.flag=="3"){
						alert("提交失败，请重新提交");
					}else{
						alert("系统异常，请重新提交");
					}
				}
			});
		}
	}
</script>
</html>