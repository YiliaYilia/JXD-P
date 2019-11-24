<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	
	<%@ include file="/WEB-INF/jsp/wechat/common/meta.jsp"%>
	
	<%@ include file="/WEB-INF/jsp/wechat/common/rels.jsp"%>
	
	<link href="${ctx}/resources/css/conservation/conservation.min.css?${random}" rel="stylesheet"/>
</head>
<body>
	<div class="wrap">
		<div class="head">
			<a href="${ctx}/service" class="head-icon home right"></a>
    		<h1 class="head-name">业务办理</h1>
		</div>
		<div class="content conservation">
			<div class="page active index">
				<a class="index-item addressModify" href="${ctx}/address">联系地址<br>变更</a>
				<a class="index-item phoneModify" href="${ctx}/phone">联系电话<br>变更</a>
				<a class="index-item returnLoan" href="${ctx}/loanList">归还保单<br>贷款</a>
			</div>
		</div>
	</div>
</body>
</html>