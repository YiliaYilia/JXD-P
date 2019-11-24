<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
		<div class="nav">
		</div>
		<script type="text/x-jQuery-tmpl" id="navTpl">
			<div class="nav-head">
				<img src="{{headimgUrl}}">
			</div>
			{{#navList}}
				<a class="nav-item {{clazz}}" data-target="#policy-{{name}}">{{display}}</a>
			{{/navList}}
			<a class="nav-arr" data-target="#policy-index"></a>
		</script>