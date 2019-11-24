<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>

<link href="${ctx}/resources/css/common/main.min.css?${random}" rel="stylesheet"/>
<link href="${ctx}/resources/css/page/page.min.css?${random}" rel="stylesheet"/>
<link href="${ctx}/resources/css/animate/animate.css" rel="stylesheet"/>
<link href="${ctx}/resources/css/animate/loader-ani.css" rel="stylesheet"/>

<script src="${ctx}/resources/lib/jquery/jquery-2.1.3.min.js"></script>
<script src="${ctx}/resources/lib/common/main.js?${random}"></script>
<script src="${ctx}/resources/lib/jquery/mustache.js"></script>

<script src="${ctx}/resources/lib/component/modal.js"></script>

<script src="${ctx}/resources/lib/jquery/jquery.event.move.js"></script>
<script src="${ctx}/resources/lib/jquery/jquery.mobile.touch.js"></script>
<script src="${ctx}/resources/lib/jquery/jquery.event.swipe.js"></script>
<%-- <script src="${ctx}/resources/lib/jquery/jquery.event.tap.js"></script> --%>
<%-- <script src="${ctx}/resources/lib/jquery/jquery.transit.min.js"></script> --%>

<script src="${ctx}/resources/lib/component/list.js?${random}"></script>
<script src="${ctx}/resources/lib/component/nav.js"></script>
<script src="${ctx}/resources/lib/component/index.js"></script>

<script>
	
	sino.namespace('manulife');

	var contentRootPath = '${ctx}';
	var resultSuccess = '${resultSuccess}' == 'true';
	var resultDescription = '${resultDescription}';
	var resultCode = '${resultCode}';
	
	var headImgPath='${fansInfo.headimgUrl}';
	
</script>
