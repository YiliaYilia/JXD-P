<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="format-detection" content="telephone=no" />
	
	<title>用户绑定-瑞泰人寿</title>
	
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
	
	<meta name="description" content="用户绑定-瑞泰人寿">
	
	<link href="<%=path %>/global/css/common/main.min.css?${random}" rel="stylesheet"/>
	<link href="<%=path %>/global/css/animate/animate.css" rel="stylesheet"/>
	<link href="<%=path %>/global/css/animate/loader-ani.css" rel="stylesheet"/>
	
	<script src="<%=path %>/global/lib/jquery/jquery-2.1.3.min.js"></script>
	<script src="<%=path %>/global/lib/common/main.js?${random}"></script>
	
	<script src="<%=path %>/global/lib/component/modal.js"></script>
	
	<script src="<%=path %>/global/lib/jquery/jquery.event.move.js"></script>
	<script src="<%=path %>/global/lib/jquery/jquery.mobile.touch.js"></script>
	<script src="<%=path %>/global/lib/jquery/jquery.event.swipe.js"></script>
	
	<script>
		
		sino.namespace('manulife');
	
		var contentRootPath = '..';
		var resultSuccess = '${resultSuccess}' == 'true';
		var resultDescription = '${resultDescription}';
		var resultCode = '${resultCode}';
		
		var headImgPath='${fansInfo.headimgUrl}';
		
	</script>
	
	<link href="<%=path %>/global/css/animate/pop-ani.css?${random}" rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript" src="<%=path %>/global/js/identity/bind.js?${random}"></script>
</head>


<style type="text/css">
body {
	background-color: #FFFBF7;
}

.head {
	width: 100%;
	height: 92px;
	text-align: center;
	border-bottom: 3px solid #E2E2E2;
	background-color: #fff;
}	

.head img {
	padding-top: 20px;
	padding-bottom: 20px;
}

.bottom {
	width: 100%;
	height: 80px;
	background-color: #F3F3F3;
    z-index: 999;
    position: fixed;
    bottom: 0;
    left: 0;
    _position: absolute;
    overflow: visible;
}

.ulClass {
	width: 100%;
	margin-top: 60px;
	font-size: 18px;
	font-family: "Microsoft YaHei";
	padding:0 30px;
}

.ulClass li {
	height: 80px;
	border: 1px solid #b9bec4;
	line-height:80px;
	width:100%;
	border-radius:3px;
	margin:30px 0;
	background:#f8f8f8;
	text-align: left;
	/* padding: 5px 0; */
}

.ulClass li label{
	display:inline-block;
	width: 140px;
	text-align: left;
	font-size: 1.5em;
	color: #333;
	background:#fff;
	height: 75px;
	border-right:1px solid #b9bec4;
	vertical-align: top;
}

.ulClass li input{
	border:none;
	background:#f8f8f8;
	height:40px;
	line-height:20px;
	padding:0 5px;
	vertical-align: middle;
	font-size: 1.5em;
}
</style>


<body>
	<div class="head">
		<img src="<%=path %>/global/images/logo_t.png" />
	</div>
	<div style="width: 100%;text-align: center;">
		<form class="bind-form" action="<%=path %>/action/getPolicyList" name="reForm" id="reForm" method="post">
			<input type="hidden" id="claimTag" value="${claimTag}">
			<input type="hidden" id="OpenID" name="OpenID" value="${OpenID}">
			<input type="hidden" id="path" name="path" value="<%=path %>">
			
			<ul class="ulClass">
				<li>
					<label>投保人姓名</label>
					<input type="text" name="clientName" id="clientName" maxLength=40>
				</li>
				<li>
					<label>证件号</label>
					<input type="text" name="idNo" id="idNo" maxLength=20>
				</li>
				<li>
					<label>证件类型</label>
					<select onchange="test()" class="select" name="idType" id="idType" style="width: 70%;height: 50px;font-size: 1.3em;font-family: 微软雅黑;">
						<option value="ID_CARD">身份证</option>
						<option value="MOC">军官证</option>
						<option value="SOLDIERS">士兵证</option>
						<option value="PASSPORT">护照</option>
						<option value="DRIVING_LICENSE">驾照</option>
						<option value="CTC">台胞证</option>
						<option value="HKMTP">港澳通行证</option>
						<option value="MID">返乡证</option>						
						<option value="HHR">户口本</option>
						<option value="BC">出生证</option>						
						<option value="BIRTHCERT">出生日期</option>
						<option value="OTHERS">其他</option>
	    			</select>
				</li>
				<li>
					<style>
.bind-send{
	    min-width: 20%;
    max-width: 50%;
    display: inline-block;
    height: 60px;
    line-height: 50px;
    text-align: center;
    background: rgb(232,194,109);
    border-radius: 5px;
    font-size: 18px;
    float: right;
    margin-top: 10px;
    margin-right: 20px;
    
	}
.bind-send.disable{background:#c1c2c2}
						</style>
					<label>验证码</label>
					<input class="bind-code" type="text" id="validateCode" maxLength=6 style="width: 40%;">
					<input type="hidden" id="hiddenvaldate" value=""/>
					<a class="bind-send" id="btnSendCode" onclick="sendMessage(this)" style="width: 20%;height: 50px;">获取验证码</a>
				</li>	
				
				<li>
					<img src="<%=path %>/global/images/qrxx_03.jpg" onclick="login()"/>
				</li>
			</ul>
		</form>
	</div>
	<div class="bottom">
		<img src="<%=path %>/uinew/images/bottom-line.jpg" />		
	</div>
	
	<div class="modal fade" data-rule="alert" id="modal_alert">
		<div class="modal-dialog alert">
			<div class="modal-header clearfix"><span data-title="modal">提示信息</span><a type="button" class="close" data-dismiss="modal"></a></div>
			<div class="modal-content" data-content="modal"></div>
			<div class="modal-footer">
				<a class="modal-btn btn" data-dismiss="modal" data-btn="modal" style="background-color: #E8C26D;">确定</a>
			</div>
		</div>
	</div>
	
	<div class="modal fade" data-rule="dialog" >
		<div class="modal-dialog alert">
			<div class="modal-header clearfix">提示信息</div>
			<div class="modal-content" data-content="modal"></div>
			<div class="modal-footer">
				<a class="modal-btn btn inline" data-dismiss="modal" data-btn="ok" style="background-color: #E8C26D;">确定</a>
				<a class="modal-btn btn cancel inline" data-dismiss="modal" data-btn="cancel" style="background-color: #E8C26D;">取消</a>
			</div>
		</div>
	</div>
	
	<div class="modal fade" data-rule="loading" id="modal_loading">
		<div class="modal-dialog loading">
			<div class="modal-content" data-content="modal">
				<p class="loader8">加载中......</p>
			</div>
		</div>
	</div>

</body>

<script type="text/javascript">

	$(document).ready(function(){
				
		/*  var ua = navigator.userAgent.toLowerCase();
		  	if(ua.match(/MicroMessenger/i)!="micromessenger") {
		    	window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx618b6902989a293e&redirect_uri=http://testweixin.oldmutual-guodian.com/online/action/firstLogin?response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
		    }
		  	*/
		   /*  <c:if test="${Contenct!=null}">
		    modal_alert({content:'${Contenct}',btn:'确定'});
			</c:if>  */
			
	});	 

 

	 $(".sel_wrap").on("change", function() {
	        var o;
	        var opt = $(".select").find('option');
	        opt.each(function(i) {
	            if (opt[i].selected == true) {
	                o = opt[i].innerHTML;
	            }
	        });
	        $("#idtype").val(o);
    }).trigger('change'); 
    
   /*  function test(){
    	  var o;
	        var opt = $(".select").find('option');
	        opt.each(function(i) {
	            if (opt[i].selected == true) {
	                o = opt[i].innerHTML;
	            }
	        });
	        $("#idtype").val(o);
    }
     */
	function dosubmit(){
    	var claimTag = $("#claimTag").val();
		if(claimTag == 'claimTag'){
			//转入理赔流程
			window.location.href = '<%=path %>/msl/sales/isMobileCustomerAction';
		} else {
			$("#reForm").submit();
		}
	}
	
     
     function checkNameAndNO(){
    	var clientName = $("#clientName").val();
 		var idNo = $("#idNo").val();
 		if(clientName==""||clientName.length==0||clientName=="请输入投保人姓名"){
 			alert("请输入您的姓名");
 			return false;
 		}else if(idNo==""||idNo.length==0||idNo=="请输入您的证件号"){
 			alert("请输入您的证件号");
 			return false;
 		}else{
 			return true;
 		}
 	}
    
     
    function login(){
    	/* var code = $('#validateCode').val();
    	var hidcode = $('#hiddenvaldate').val();
    	if("" != code){
    		if(code != hidcode){
    			modal_alert({content:'请输入正确验证码！',btn:'确定'});
    			return false;
    		}
    	} else {
    		modal_alert({content:'请输入正确验证码！',btn:'确定'});
    		return false;
    	} */
    	if(!checkNameAndNO()){
			return false;
		}else{
			$("#bindBtn").attr("onclick","");
		  	var clientName = $("#clientName").val();
		  	var idNo = $("#idNo").val();
		  	var OpenID = $("#OpenID").val();
		  	var idType = $("#idType").val();
			$.ajax({
				type : "post",
				url :'<%=path %>/action/clientBind',
				dataType : "json",
				async : false,
				data : {
					"clientName" : clientName,
					"idNo" : idNo,
					"OpenID" : OpenID,
					"idType" : idType
				},
				success : function(data) {
					if(data.flag == "0"){
						alert("绑定成功");
						dosubmit();
					}else{
						modal_alert({content:data.content,btn:'确定'});
						$("#bindBtn").attr("onclick","login()");
					}
				}
			});
		}
  	}
    
    
    
</script>



</html>