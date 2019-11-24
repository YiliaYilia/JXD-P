<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<%@ include file="/WEB-INF/jsp/wechat/common/meta.jsp"%>
	<%@ include file="/WEB-INF/jsp/wechat/common/rels.jsp"%>
	
</head>
<body>
	<div class="wrap">
		<div class="head">
			<a href="${ctx}/service" class="head-icon home right"></a>
    		<h1 class="head-name">理赔服务</h1>
		</div>
		<div class="content conservation">
			<div class="page active index">
				<a class="index-item claimQuery" href="${ctx}/claimList">理赔查询</a>
				<a class="index-item claimTip" href="${ctx}/claim/claimTip.jsp">理赔贴士</a>
			</div>
		</div>
	</div>
</body>
</html>