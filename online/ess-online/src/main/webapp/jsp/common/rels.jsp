<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp"%>

<link href="${ctx}/resources/css/common/main.min.css?${random}" rel="stylesheet"/>
<link href="${ctx}/resources/css/animate/animate.css" rel="stylesheet"/>
<link href="${ctx}/resources/css/animate/loader-ani.css" rel="stylesheet"/>

<!-- 可以通过标签控制加载的jq版本，演示版本可以不控制，实际上线版本需要控制 -->
<script src="${ctx}/resources/lib/jquery/jquery-1.10.2.min.js"></script>
<script src="${ctx}/resources/lib/jquery/jquery.event.move.js"></script>
<script src="${ctx}/resources/lib/common/main.js?${random}"></script>
<script src="${ctx}/resources/lib/jquery/mustache.js"></script>

<script src="${ctx}/resources/lib/component/modal.js"></script>
<script src="${ctx}/resources/lib/component/tab.js"></script>
<script src="${ctx}/resources/lib/component/keyboard.js"></script>
<script src="${ctx}/resources/lib/component/checkbox.js"></script>
<script src="${ctx}/resources/lib/component/range.js"></script>

<script src="${ctx}/resources/lib/jquery/jquery.event.move.js"></script>
<script src="${ctx}/resources/lib/jquery/jquery.mobile.touch.js"></script>
<script src="${ctx}/resources/lib/jquery/jquery.event.swipe.js"></script>

<script>
	
	sino.namespace('manulife');

	var contentRootPath = '${ctx}';
	var resultSuccess = '${resultSuccess}' == 'true';
	var resultDescription = '${resultDescription}';
	var resultCode = '${resultCode}';

	var useragent = {
		platform : '${useragent.platform}',
		browser : '${useragent.browser}',
		isMobile : '${useragent.isMobile}' == 'true',
		isWechat : '${useragent.isWechat}' == 'true'
	};
</script>
