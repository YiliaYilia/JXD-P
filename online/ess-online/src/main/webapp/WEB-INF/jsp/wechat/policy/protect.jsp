<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
		<script type="text/x-jQuery-tmpl" id="protectInfoTpl">
			
			<div class="page" id="policy-protect">
				<div class="protect-list">
				{{#insured}}
				<div class="protect-item">
					<div class="protect-name">
						<img src="${ctx}/resources/image/policy/label.png">
						<span>{{name}}</span>
					</div>
					{{#risk}}
					<div class="protect-detail">
						<div class="protect-title">{{riskName}}</div>
						<div class="protect-info">
							<label>保险金额/计划</label>
							<span>{{amntFormat}}</span>
						</div>
					</div>
					{{/risk}}
				</div>
				{{/insured}}
				</div>
				<p class="remind">温馨提示：<br/>1.以上数据仅供参考！<br/>2.为保护您的信息安全，我们将您的重要资料做了部分隐藏，若需核查，敬请拨打<a href="tel:4008188888">400-818-8888</a>垂询！</p>
			</div>
			
		</script>
		
		<script type="text/x-jQuery-tmpl" id="protectInfoGroupTpl">
			{{#groupPolicy}}
			<div class="page" id="policy-name{{index}}">
				<div class="protect-list">
					<div class="protect-item">
						<div class="protect-name">
							<img src="${ctx}/resources/image/policy/label.png">
							<span>{{name}}</span>
						</div>
						{{#riskList}}
							<div class="protect-detail">
								<div class="protect-title">{{riskName}}</div>
								<div class="protect-info">
									<label>保险金额/计划</label>
									<span>{{amntFormat}}</span>
								</div>
							</div>
						{{/riskList}}
					</div>
				</div>
				<p class="remind">温馨提示：<br/>1.以上数据仅供参考！<br/>2.为保护您的信息安全，我们将您的重要资料做了部分隐藏，若需核查，敬请拨打<a href="tel:4008188888">400-818-8888</a>垂询！</p>
			</div>
			{{/groupPolicy}}
		</script>