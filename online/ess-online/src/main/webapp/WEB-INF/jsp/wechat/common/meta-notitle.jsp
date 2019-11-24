<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="format-detection" content="telephone=no" />

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
	
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
		// 屏幕右上方选项菜单
		WeixinJSBridge.call('hideOptionMenu');
		// 屏幕下方工具条
		WeixinJSBridge.call('hideToolbar');
	}, false);
	
	var _hmt = _hmt || []; 
	(function() { 
	var hm = document.createElement("script"); 
	hm.src = "//hm.baidu.com/hm.js?dc930de726cf0d8959f1366eeee55bc2"; 
	var s = document.getElementsByTagName("script")[0]; 
	s.parentNode.insertBefore(hm, s); 
	})(); 

	//本地开发,请注释后勿提交svn,或模拟UserAgent追加micromessenger.
	var useragent = navigator.userAgent.toLowerCase();
	if(!/micromessenger/.test(useragent)){
		window.location.href= '${ctxBase}/wechat/error/client.jsp';
	}
</script>

<meta name="description" content="中宏保险">

