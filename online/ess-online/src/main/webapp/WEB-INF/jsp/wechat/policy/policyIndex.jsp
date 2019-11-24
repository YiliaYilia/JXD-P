<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
			<script type="text/x-jQuery-tmpl" id="policyIndexTpl">
			<div class="page index" id="policy-index">
				<a class="index-item basic" data-target="#policy-basic">保单信息</a>
				<a class="index-item pay" data-target="#policy-pay">缴费信息</a>
				<a class="index-item phone" data-target="#policy-phone">服务营销员信息</a>
				<a class="index-item money" data-target="#policy-money">保单价值累计</a>
				<a class="index-item protect" data-target="#policy-protect">保障信息</a>
			</div>
        	</script>
        	<script type="text/x-jQuery-tmpl" id="policyGroupIndexTpl">
				<div class="page index" id="policy-index">
					{{#navList}}
						<a class="index-item {{clazz}}" data-target="#policy-{{name}}">{{display}}</a>
					{{/navList}}
				</div>
        	</script>
