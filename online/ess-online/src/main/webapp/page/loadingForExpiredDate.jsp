<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.com.sinosoft.web.service.impl.WeiXinServiceImpl"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	WeiXinServiceImpl weixin = new WeiXinServiceImpl();
	String openId = weixin.getOpenId(request);
	String operationName = request.getParameter("operationName")==null?"":request.getParameter("operationName").toString();
%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>读取中...</title>

<meta http-equiv="content-type" content="text/html; charset=utf-8">

<link href="../global/css/common/main.min.css?${random}" rel="stylesheet" />
<link href="../global/css/animate/animate.css" rel="stylesheet" />
<link href="../global/css/animate/loader-ani.css" rel="stylesheet" />
<script src="../global/lib/jquery/jquery-2.1.3.min.js"></script>
<script src="../global/lib/common/main.js?${random}"></script>
<script src="../global/lib/component/modal.js"></script>
<script src="../global/lib/jquery/jquery.event.move.js"></script>
<script src="../global/lib/jquery/jquery.mobile.touch.js"></script>
<script src="../global/lib/jquery/jquery.event.swipe.js"></script>

<!-- 引入 end-->
<script type="text/javascript" src="../global/js/common.js"></script>
<!-- init page scale-->
<meta name="viewport"
	content="width=device-width, target-densitydpi=240,initial-scale=0.667, minimum-scale=0.667, maximum-scale=0.667, user-scalable=0"
	id="viewport">
<meta name="format-detection" content="telephone=no" />
<style type="text/css">
.modal-dialog.alert .modal-btn {
    background: #E8C26D;
}
</style>
</head>
<body>
	<!--加载等待框 -->
	<div class="modal fade" data-rule="loading" id="modal_loading">
		<div class="modal-dialog loading">
			<div class="modal-content" data-content="modal">
				<p class="loader8">加载中......</p>
			</div>
		</div>
	</div>
	<!--弹出框 -->
	<div class="modal fade" data-rule="alert" id="modal_alert">
		<div class="modal-dialog alert">
			<div class="modal-header clearfix">
				<span data-title="modal">提示信息</span><a type="button" class="close"
					data-dismiss="modal"></a>
			</div>
			<div class="modal-content" data-content="modal"></div>
			<div class="modal-footer">
				<a class="modal-btn btn" data-dismiss="modal" data-btn="modal">确定</a>
			</div>
		</div>
	</div>
	<input type="hidden" id="appid" name="appid" />
  	<input type="hidden" id="urlPrefix" name="urlPrefix" />
</body>

<script type="text/javascript">
	$(document).ready(function(){
		var hostname = location.hostname;
	    if(hostname.startsWith('testweixin')){
			$("#appid").attr("value", "wx618b6902989a293e");
	    	$("#urlPrefix").attr("value", "http://testweixin.oldmutual-guodian.com/online/");
		}else if(hostname.startsWith('weixin')){
			$("#appid").attr("value", "wx5be4b58fee2539db");
			$("#urlPrefix").attr("value", "http://weixin.oldmutual-guodian.com/online/");
		}
		var openId = "<%=openId%>";
		if(openId != null && openId != ""){
			modal_loading();
			var operationName = "<%=operationName%>";
			$.ajax({
	    		url :'<%=path %>/action/expiredDateCheckByOpenId',
	    		dataType : "json",
	    		type : "POST",
	    		async : true,
	    		data : {
	    			openId:openId
	    		},
	    		success : function(data) {
	    			if(data.code == "0"){//变更
	    				window.location.href = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=' + $('#appid').val()
	    						+ '&redirect_uri=' + $('#urlPrefix').val() + 'action/' + operationName
	    						+'&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect';
	    			}else if(data.code == "1"){
	    				//变更证件有效期后再进行变更
	    				modal_alert({content:data.message,btn:'确定'});
	    				$(".btn").click(function (){
	    					onclickToCertificate(operationName,data.partyCode,'pol',data.partyCode,data.cardNo,data.cardType,data.expiredDate);
	    				});
	    			}else if(data.code == "2"){
	    				//跳转到绑定页面
	    				window.location.href = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=' + $('#appid').val()
	    						+ '&redirect_uri=' + $('#urlPrefix').val() 
	    						+ 'action/firstLogin&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect';
	    			}else{
	    				modal_alert({content:data.contenct,btn:'确定'});
	    				$(".btn").click(function (){
	    					window.location.href = '<%=path %>/page/policyService.jsp';
	    				});
	    			}
	    		}
	    	});
		}else{
			modal_alert({content:'获取参数失败，请取消关注后再次关注。',btn:'确定'});
			$(".btn").click(function (){
				window.location.href = '<%=path %>/page/policyService.jsp';
			});
		}
	});
	
	function onclickToCertificate(conservationFlag,polPartyCode,partyType,partyCode,cardNo,cardType,expiredDate){
		//window.location.href = '<%=path %>/action/certificate?polPartyCode='+polPartyCode +'&partyType='+partyType+'&partyCode='+partyCode
		//	+'&cardNo='+cardNo+'&cardType='+cardType+'&expiredDate='+expiredDate + url;
		var url = $('#urlPrefix').val() + 'action/certificate?polPartyCode='+polPartyCode +'&partyType='+partyType+'&partyCode='+partyCode 
				+'&cardNo='+cardNo+'&cardType='+cardType+'&expiredDate='+expiredDate+'&conservationFlag='+conservationFlag;
		window.location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid='+ $('#appid').val() 
				+'&redirect_uri='+encodeURIComponent(url)
				+'&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect';
	}
</script>
</html>
