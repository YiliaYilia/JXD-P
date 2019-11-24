<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/meta.jsp"%>
<%@ include file="../common/rels.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	if("2020" == resultCode){
		modal_alert('签名校验失败',function(){
 				
			});
		return;
	}else if("2019" == resultCode){
		modal_alert('签名校验成功，支付宝端返回支付失败',function(){
			$.ajax({
				   type:"POST",
				   url:contentRootPath+"/msl/sales/payOthers",
				   dataType:"json",
				   success:function(data){
					   modal_loading('hide');
						   window.location.href =contentRootPath+'/msl/sales/paymentOptions';
					}
				});
		});
		return;
	}else if("2021" == resultCode){
		modal_alert('将支付宝返回参数转换格式时报错',function(){
			
		});
		return;
	}
	var payType='<s:property value="#request.payType"/>';
	
	var wait;
	if("11" == payType){
		//微信扫码支付
		insurePolicy();
		
	}else if("10"==payType){
		//JSAPI支付
		wait=setInterval(function() { 
			checkSuccess();
		}, 1000); 
	}else{
		 insurePolicy();
	}
	
	//判断是否支付成功,如果成功则承保
	function  checkSuccess(){
		$.ajax({
			type : "POST",
			url : contentRootPath + "/msl/sales/paySuccess",
			data : {},
			dataType : "json",
			success : function(data) {
				if("success" == data.succeed){
					 clearTimeout(wait);
					 insurePolicy();
				}
			}
		});
	}
	
	//承保
	function insurePolicy(){
		$.ajax({
			type : "POST",
			url : contentRootPath + "/msl/sales/insurePolicy",
			data : {},
			dataType : "json",
			success : function(data) {
				if("2019" == data.resultCode){
					modal_alert('您未支付成功，请选择其他方式进行支付',function(){
						$.ajax({
							   type:"POST",
							   url:contentRootPath+"/msl/sales/payOthers",
							   dataType:"json",
							   success:function(data){
								   modal_loading('hide');
									   window.location.href =contentRootPath+'/msl/sales/paymentOptions';
								}
							});
		 			});
					return false;
				}
				if(data.succeed){
					modal_loading('hide');
					window.location.href =contentRootPath+"/msl/sales/insureSuccess";
				}
				
			}
		});
	}
}); 
</script>
<body>
<jsp:include page="/WEB-INF/jsp/common/common-modal.jsp"></jsp:include>
</body>
</html>