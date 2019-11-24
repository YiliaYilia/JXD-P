<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/wechat/common/meta.jsp"%>
	
	<%@ include file="/WEB-INF/jsp/wechat/common/rels.jsp"%>
	
	<link href="${ctx}/resources/css/animate/pop-ani.css?${random}" rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript" src="${ctx}/resources/js/identity/bind.js?${random}"></script>
	
</head>
<body>
	<div class="main">
		<div class="pop-container">
			<div class="pop-item pop7" data-index="1">
				<a></a>
			</div>
			<div class="pop-item pop8" data-index="2">
				<a></a>
			</div>
			<div class="pop-item pop9" data-index="3">
				<a></a>
			</div>
			<div class="pop-item pop6" data-index="0">
				<a></a>
			</div>
		</div>
		<div class="bind">
			<p class="welcome"><span>亲,你好</span></p>
			<form class="bind-form">
				<div class="bind-box">
					<input type="text" placeholder="请输入您的姓名" name="customerName" id="customerName" maxLength=40>
				</div>
				<div class="bind-box">
					<input type="text" placeholder="请输入您的证件号" name="idNo" id="idNo" maxLength=20>
				</div>
				<div class="bind-box">
					<input type="text" placeholder="请输入您的手机号码" name="mobile" id="mobile" maxLength=11>
				</div>
				<div class="bind-box">
					<input class="bind-code" type="text" id="validateCode" placeholder="请输入验证码" maxLength=6>
					<a class="bind-send" id="btnSendCode" onclick="sendMessage(this)" >获取验证码</a>
				</div>
				<div class="bind-action">
					<a class="bind-btn disable" id="bindBtn" onclick="insuredBinding(this)">确&nbsp;&nbsp;定</a>
				</div>
			</form>
		</div>
	</div>
	
	<%@ include file="/WEB-INF/jsp/wechat/common/common-modal.jsp"%>
</body>
<script type="text/javascript">
if(!resultSuccess){
	$(document).ready(function(){
		if(resultCode == '2097'){
			modal_notice('您尚未关注中宏保险官方微信，请先完成关注，谢谢！')
		}
		if(resultCode == '2099'){
			modal_alert({content:'您尚未身份绑定，无法体验微服务，请输入您的信息。',btn:'确定'});
		}
		if(resultCode == '2098'){
			modal_alert({content:'微信已经绑定，欢迎您体验<br/>保单微服务。',btn:'确定',callback:function(){
					window.location.href = contentRootPath+"/service";
			}});
		}
		if(resultCode == '2008'){
			modal_alert({content:'长时间未进行操作，请重新进入',btn:'确定'});
		}
	});
}
</script>
</html>