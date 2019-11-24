<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>个人税收居民身份声明</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link href="../global/css/common/main.min.css?${random}" rel="stylesheet"/>	
    <link rel="stylesheet" href="../global/css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="../global/css/all.css" type="text/css"></link>
    <link rel="stylesheet" href="../global/css/fillInfo.css" type="text/css"></link>
    <link rel="stylesheet" href="../global/css/font-size-screen.css" />
	<link href="../global/css/animate/loader-ani.css" rel="stylesheet"/>
    <script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
  	<script type="text/javascript" src="../global/js/common.js"></script>
  	<script src="../global/lib/common/main.js?${random}"></script>	
	<script src="../global/lib/component/modal.js"></script>	
	<script src="<%=request.getContextPath()%>/resources/js/page/area1.js?${random}"></script>
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
.txt0{font-size: 1.5em;}
	.txt1{font-size: 1.3em;}
	.txt2{font-size: 1.0em;}
	.txt3{font-size: 0.9em;}
	.txt4{font-size: 0.8em;}
	.txt5{font-size: 0.7em;}
	

	@media only screen and (max-width: 960px) {
		.txt0{font-size: 1.4em;}
		.txt1{font-size: 1.2em;}
		.txt2{font-size: 0.9em;}
		.txt3{font-size: 0.7em;}
		.txt4{font-size: 0.7em;}
		.txt5{font-size: 0.6em;}
	}

	@media only screen and (max-width: 640px) {
		.txt0{font-size: 1.2em;}
		.txt1{font-size:1.1em;}
		.txt2{font-size: 0.8em;}
		.txt3{font-size: 0.6em;}
		.txt4{font-size: 0.6em;}
		.txt5{font-size: 0.5em;}
	}

	@media only screen and (max-width: 480px) {
		.txt0{font-size: 1.2em;}
		.title1{font-size: 1.0em;}
		.txt2{font-size: 0.7em;}
		.txt3{font-size: 0.5em;}
		.txt4{font-size: 0.5em;}
		.txt5{font-size: 0.4em;}
	}
	.fillTable tbody tr td{line-height: 70px;}
	
  </style>
  
  


<link rel="stylesheet" type="text/css" href="../uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/style-font.css">

<style>
	
.pull-left{
    font-size: 26px  !important;
}
.pull-right select{font-size:80%;}

.crsinfo_modal_alert .modal-dialog {
	width: 90%;
	background: #fff
}

.crsinfo_modal_alert .modal-dialog .modal-header {
	height: 80px;
	line-height: 80px;
	font-size: 3rem;
	padding-left: 20px
}

.crsinfo_modal_alert .modal-dialog .modal-content {
	padding: 40px 40px 50px;
	color: #757575;
	font-size: 2.8rem;
	word-break: break-all
}

.crsinfo_modal_alert .modal-dialog .modal-footer {
	padding-bottom: 20px;
	text-align: center;
}

.crsinfo_modal_alert .modal-dialog .modal-btn,.btn-default {
	height: 70px;
	line-height: 70px;
	font-size: 2.8rem;
	margin: 0 35px;
	width: 32%;
	border-radius: 5px
}

.crsinfo_modal_alert .modal-dialog .modal-btn {
	color: #fff;
	background: #E8C26D;
}
	</style>
    <body class="gray">
 <div class="grace-head" > </div>
<h2 style="margin-top:60px; text-align:center; color:#c8a154; font-size:2em; font-weight:bold;padding-bottom: 50px;padding-top: 30px;">个人税收居民身份声明</h2>

<form class="bind-form" action="<%=path %>/action/changeMine" name="reForm" id="reForm" method="post">
	   	
<div  class="panel-collapse collapse in cardcontent" style="font-size: 1.4em;">
	<ul class="grace-form"> 
    	<li > <div class="pull-left" style="width:35%;">税收居民身份</div> 
    	<div class="pull-right" style="width:65%;">
    		<select id="taxType" class="taxType" style="width:90%;">
						<option value="">--请选择--</option>
						<option value="1">仅为中国大陆税收居民</option>
						<option value="2">仅为非居民</option>
						<option value="3">既是中国大陆税收居民又是其他税收管辖区居民</option>
					</select>
	    						</div></li>
  </ul>  
        
</div>
   		<input type="hidden" id="partyCode" value="${myinfo.coustomerid}">
		<input type="hidden" id="taxDeclaraID" value="" />
   	</form>
            <div class="next-button" onclick="dosubmit()" style="margin-top: 50px;"><img src="../uinew/images/submit-button.jpg" width="100%"  alt=""/> </div>    

<div class="footer footer-fixed" > <img src="../uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>

<style>
	
	.modal-dialog.alert .modal-header{
	font-size: 2.5em;
	}
	.modal-dialog.alert .modal-content {
    font-size: 1.8em;
}
.modal-dialog.alert .modal-btn{
	font-size: 2.5em;
    background: #E8C26D;
	}
	
	</style>
 
    <!--弹出框 -->
    <div class="modal fade" data-rule="alert" id="modal_alert">
		<div class="modal-dialog alert">
			<div class="modal-header clearfix"><span data-title="modal">提示信息</span>
				<a type="button" class="close" data-dismiss="modal"></a></div>
			<div class="modal-content" data-content="modal"></div>
			<div class="modal-footer">
				<a class="modal-btn btn" data-dismiss="modal" data-btn="modal">确定</a>
			</div>
		</div>
	</div>
	<!--crsinfo弹出框 -->
	<div class="modal fade crsinfo_modal_alert" id="crsinfo_modal_alert" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-content" data-content="modal" id="crsinfo_content" style="font-size: 0.6em;"></div>
				<div class="modal-footer">
					<button type="button" class="modal-btn btn" onclick="submitForce();">确认</button>
					<button type="button" class="btn-default btn" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	<!--加载等待框 -->
	<div class="modal fade" data-rule="loading" id="modal_loading">
		<div class="modal-dialog loading">
			<div class="modal-content" data-content="modal">
				<p class="loader8">提交中......</p>
			</div>
		</div>
	</div>
  </body>
  <script type="text/javascript">
	
	function submitForce(){
		var partyCode = $("#partyCode").val();
    	var taxType = $("#taxType").val();
        $.ajax({
    		url :'<%=path %>/action/dealPartyTaxType',
    		dataType : "json",
    		type : "POST",
    		async : false,
    		data : {
    			"partyCode" : partyCode,
    			"callBy":"WECHAT",
    			"taxType":taxType,
    			"operate" : "save"
    		},
    		success : function(data) {
    			if(data.code == "0"){
    				modal_alert({content:data.contenct,btn:'确定'}); 
					$(".btn").click(function (){
						window.location.href='<%=request.getContextPath()%>/page/policyService.jsp';
					});
    			}else{
    				modal_alert({content:data.contenct,btn:'确定'});
    				$(".btn").click(function (){
    					window.location.href='<%=request.getContextPath()%>/page/policyService.jsp';
    				});
    			}
    		}
    	});
	}
	
	
	function dosubmit(){
    	var taxType = $("#taxType").val();
    	if(taxType==""){
    		alert("请选择您的税收居民身份");
    		return false;
    	}
        $.ajax({
    		url :'<%=path %>/action/dealPartyTaxType',
			timeout : 0, //超时时间设置，单位毫秒
    		dataType : "json",
    		type : "POST",
    		async : true,
    		data : {
    			"partyCode" : "${myinfo.coustomerid}",
    			"callBy":"WECHAT",
    			"taxType":taxType,
    			"operate" : "check"
    		},
    		success : function(data) {
    			if(data.code == "0"){
    				modal_alert({content:data.contenct,btn:'确定'}); 
					$(".btn").click(function (){
						window.location.href='<%=request.getContextPath()%>/page/policyService.jsp';
					});
    			}else if(data.code == "1133"){
    				$('#crsinfo_content').html(data.contenct);
					$('#crsinfo_modal_alert').modal('show');
    			}else{
					modal_alert({content:data.contenct,btn:'确定'});
    				$(".btn").click(function (){
    					window.location.href='<%=request.getContextPath()%>/page/policyService.jsp';
    				});
				}
    		},
			error : function(XMLHttpRequest, textStatus, errorThrown){
				alert(errorThrown);
			}
    	});
		modal_loading();
	}
  </script>
</html>
