<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
			<script type="text/x-jQuery-tmpl" id="payInfoTpl">
			<div class="page" id="policy-pay">
				<div class="pay-form">
					<label>缴费日期始：</label>
					<input class="pay-form-date" id="startDate" type="text" value="{{startDate}}">
					<label>缴费日期止：</label>
					<input class="pay-form-date" id="endDate" type="text" value="{{endDate}}">
					<div class="pay-form-btn" onclick="payInfo();">查询</div>
					<p class="pay-info-note">提示：您可查询2年内的缴费信息。</p>
				</div>
				<div class="pay-info">
					<div class="pay-info-title">
						<img src="${ctx}/resources/image/policy/yellowpoint.png">
						<h4>缴费信息</h4>
						<p>下期应缴费日：<span>{{nextPayDate}}</span></p>
					</div>
					<div class="clearfix">
						<div class="pay-info-item col-8">
							<label>每期保费</label>
							<span>{{premFormat}}元</span>
						</div>
						<div class="pay-info-item col-8">
							<label>缴费周期</label>
							<span>{{payIntv}}</span>
						</div>
						<div class="pay-info-item col-8">
							<label>缴费方式</label>
							<span>{{payMode}}</span>
						</div>
					</div>
					<div class="pay-info-extra">
						<p>
							<label>缴费账户</label>
							<span>{{payBankName}}</span>
						</p>
						<p>
							<label>缴费帐号</label>
							<span>{{payAccNo}}</span>
						</p>
					</div>
				</div>
				<div class="pay-title">
					<img src="${ctx}/resources/image/policy/greenpoint.png">
					<span>缴费信息</span>
				</div>
				<div class="pay-list">
					{{#paymentInsuranceInfo}}
					<div class="pay-item">
						<div class="pay-item-date col-10">
							<label>{{payMode}}</label>
							<span>{{payDate}}</span>
						</div>
						<div class="pay-item-money col-14">
							<b><span>{{payAmntFormat}}</span>元</b>
						</div>
					</div>
					{{/paymentInsuranceInfo}}
				</div>
				<p class="remind">温馨提示：<br/>1.以上数据仅供参考！<br/>2.为保护您的信息安全，我们将您的重要资料做了部分隐藏，若需核查，敬请拨打<a href="tel:4008188888">400-818-8888</a>垂询！</p>
			</div>
			</script>
			<script type="text/x-jQuery-tmpl" id="payInfoTplNew">
				{{#paymentInsuranceInfo}}
					<div class="pay-item">
						<div class="pay-item-date col-12">
							<label>{{payMode}}</label>
							<span>{{payDate}}</span>
						</div>
						<div class="pay-item-money col-12">
							<b><span>{{payAmntFormat}}</span>元</b>
						</div>
					</div>
				{{/paymentInsuranceInfo}}
			</script>
