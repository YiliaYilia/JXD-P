<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<%@ include file="/WEB-INF/jsp/wechat/common/meta.jsp"%>
	<%@ include file="/WEB-INF/jsp/wechat/common/rels.jsp"%>
	
	<link href="${ctx}/resources/css/claim/claim.min.css?${random}" rel="stylesheet"/>
	
	<script src="${ctx}/resources/js/claim/claim.js?${random}"></script>
</head>
<body>
	<div class="wrap">
		<div class="head">
			<a href="javascript:history.go(-1);" class="head-icon back right"></a>
    		<h1 class="head-name">理赔进展查询</h1>
		</div>
		<div class="content claim" id="claim">
			<div class="page">
				<%-- <div class="claim-head">
					<div class="claim-head-icon">
						<s:if test="#request.fansInfo.headimgUrl != '' ">
							<img src="<s:property value='#request.fansInfo.headimgUrl' />">
						</s:if><s:else>
							<img src="${ctx}/resources/image/conservation/headImg.png">
						</s:else>
					</div> 
	<!-- 				<p class="claim-head-name" id="claim-name"></p> -->
				</div>--%>
				<div class="claim-list" id="claim-list">
				</div>
				<p class="claim-remind">温馨提示：<br/>1.以上数据仅供参考！<br/>2.为保护您的信息安全，我们将您的重要资料做了部分隐藏，若需核查，敬请拨打<br/><a href="tel:4008188888">400-818-8888</a>垂询！</p>
			</div>
		</div>

		<jsp:include page="/WEB-INF/jsp/wechat/element/list-claim.jsp"></jsp:include>
	</div>
	<!-- 模版页面 -->
	<jsp:include page="/WEB-INF/jsp/wechat/claim/basic.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/jsp/wechat/common/common-modal.jsp"></jsp:include>
</body>
</html>