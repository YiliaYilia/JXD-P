<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>

	<%@ include file="/WEB-INF/jsp/wechat/common/meta.jsp"%>
	
	<%@ include file="/WEB-INF/jsp/wechat/common/rels.jsp"%>
	
	<link href="${ctx}/resources/css/policy/policy.min.css?${random}" rel="stylesheet"/>
	
	<script type="text/javascript">
		var infoType = '${param.type}';
	</script>
	
	<link href="${ctx}/resources/lib/jquery/mobiscroll/css/mobiscroll.core-2.0.3.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/resources/lib/jquery/mobiscroll/css/mobiscroll.android-2.0.css" rel="stylesheet" type="text/css" />
		
	<script src="${ctx}/resources/lib/jquery/mobiscroll/mobiscroll.core-2.0.3.js" type="text/javascript"></script>
	<script src="${ctx}/resources/lib/jquery/mobiscroll/mobiscroll.android-2.0.js" type="text/javascript"></script>
		
	<script src="${ctx}/resources/lib/jquery/mobiscroll/mobiscroll.select-2.0.2.js" type="text/javascript"></script>
	<script src="${ctx}/resources/lib/jquery/mobiscroll/mobiscroll.datetime-2.0.3.js" type="text/javascript"></script>
	
	<script src="${ctx}/resources/lib/utils/stringUtils.js"></script>
	<script src="${ctx}/resources/lib/utils/dateUtils.js"></script>
	
	<script src="${ctx}/resources/js/policy/policy.js?${random}"></script>
</head>
<body>
	<div class="wrap">
		<div class="head">
			<a href="${ctx}/service" class="head-icon home right"></a>
    		<h1 class="head-name" id="policy-title">保单信息查询</h1>
		</div>
		<div class="content policy" id="policy"></div>
		<jsp:include page="/WEB-INF/jsp/wechat/element/nav.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/wechat/element/list-policy.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/wechat/common/common-modal.jsp"></jsp:include>
	</div>
	
<!-- 	以下是页面模版 -->
	<jsp:include page="/WEB-INF/jsp/wechat/policy/policyIndex.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/jsp/wechat/policy/basic.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/jsp/wechat/policy/pay.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/jsp/wechat/policy/phone.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/jsp/wechat/policy/money.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/jsp/wechat/policy/protect.jsp"></jsp:include>
	
	<%@ include file="/WEB-INF/jsp/wechat/common/common-modal.jsp"%>
</body>
</html>