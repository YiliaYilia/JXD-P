<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>保单详情</title>
	
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../../global/css/common.css" type="text/css"></link>
<link rel="stylesheet" href="../../global/css/all.css" type="text/css"></link>
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
		.file {
		    position: relative;
		    display: inline-block;
		    background: #D0EEFF;
		    border: 1px solid #99D3F5;
		    border-radius: 4px;
		    padding: 8px 12px;
		    overflow: hidden;
		    color: #1E88C7;
		    text-decoration: none;
		    text-indent: 0;
		    line-height: 20px;
		    float:left;
		    margin:20px 20px ;
		}
	.file:hover {
		    background: #AADFFD;
		    border-color: #78C3F3;
		    color: #004974;
		    text-decoration: none;
		}
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
			<div class="headertitle">保单详情</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="clear"></div>
	<div class="container">
		<div class="content">
			<div class="tablehead">
				<div class="borderleft"></div>
				<div class="borderright">
					<div>
						<div class="titleimgdiv"></div>
						<span class="titlecontent black">保单详细信息</span>
					</div>
				</div>
			</div>
			<div class="clear"></div>
			<div class="tablestyle">
				<table class="table txt1">
					<tr>
						<td class="firstcolumn" style="width:40%">保单号码</td>
						<td class="secondcolumn">${gePolicy.policycode}</td>
					</tr>
					<tr>
						<td class="firstcolumn">险种名称</td>
						<td class="secondcolumn">${gePolicy.productname}</td>
					</tr>
					<tr>
						<td class="firstcolumn">保单生效日期</td>
						<td class="secondcolumn">${gePolicy.takeeffecttime}</td>
					</tr>

					<tr>
						<td class="firstcolumn">投保人姓名</td>
						<td class="secondcolumn">${gePolicy.applicantname}</td>
					</tr>

					<tr>
						<td class="firstcolumn">被保险人姓名</td>
						<td class="secondcolumn">${gePolicy.insuredname}</td>
					</tr>
					<tr>
						<td class="firstcolumn">保费</td>
						<td class="secondcolumn">${gePolicy.sumbasepremium}</td>
					</tr>
					<tr>
						<td class="firstcolumn">保额</td>
						<td class="secondcolumn">${gePolicy.sumamount}</td>
					</tr>
					
				</table>
			</div>
			<div style="height: 50px;"></div>
		</div>
	</div>
	<div class="clear"></div>
</body>
</html>
