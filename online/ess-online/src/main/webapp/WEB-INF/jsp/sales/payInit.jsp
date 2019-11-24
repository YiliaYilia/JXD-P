<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/rels.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付页面</title>
<script type="text/javascript">
function onBridgeReady(){
	var str='<s:property value="#session['InsurePolicy.Pay']"/>';
	var arrayStr=str.split(',');
	var appId=arrayStr[0];
	var noncestr=arrayStr[1];
	var packageValue=arrayStr[2];
	var paySign=arrayStr[3];
	var signType=arrayStr[4]
	var timeStamp=arrayStr[5];
	//alert("appId:"+appId+",nonceStr:"+noncestr+",package:"+packageValue+",paySign:"+paySign+",timeStamp:"+timeStamp);
	   WeixinJSBridge.invoke(
			   'getBrandWCPayRequest',{
			   "appId" : appId,     //公众号名称，由商户传入     
	           "nonceStr" : noncestr, //随机串     
	           "package" : packageValue,     
	           "paySign" : paySign, //微信签名 
	           "signType" : signType,         //微信签名方式:     
	           "timeStamp":timeStamp        //时间戳，自1970年以来的秒数     
	       },
	       function(res){
	           if(res.err_msg == "get_brand_wcpay_request:ok" ) {
	        	   var source = '${source}';
	        	   if(source=='changxian'){
	        		   window.location.href =contentRootPath+'/msl/sales/toSuccess?source=${source}';  
	        	   }else if(source=='tuanxian'){
	        		   window.location.href =contentRootPath+'/msl/sales/toCharitySuccess?source=tuanxian';
	        	   }else if(source=='WENJIAXING'){
	        		   window.location.href =contentRootPath+'/msl/sales/WJXtoSuccess?source=WENJIAXING';
	        	   }else if(source=='TAWENKB-R'){
	        		   window.location.href =contentRootPath+'/msl/sales/WKBtoSuccess?source=TAWENKB-R';
	        	   }else if(source=='WENAIBAO'){
	        		   window.location.href =contentRootPath+'/msl/sales/WABtoSuccess?source=WENAIBAO';
	        	   }else if(source=='WENJIABAO'){
	        		   window.location.href =contentRootPath+'/msl/sales/WJBtoSuccess?source=WENJIABAO';
	        	   }else{
	        		   window.location.href =contentRootPath+'/msl/sales/insureShortPolicyPromise';
	        	   }
	           }
	           if(res.err_msg == "get_brand_wcpay_request:cancel" ){
	        	   alert("支付过程用户取消");
	           }
	           if(res.err_msg == "get_brand_wcpay_request:fail"){
	        	   alert("支付失败");
	           }
	       }
	   ); 
}
if (typeof WeixinJSBridge == "undefined"){
	   if( document.addEventListener ){
	       document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
	   }else if (document.attachEvent){
	       document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
	       document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
	   }
	}else{
	   onBridgeReady();
	}
</script>
</head>
<body>
	<%-- <%
	  String url=(String)session.getAttribute("InsurePolicy.Pay");
	  out.println(url);
	%> --%>

</body>
</html>