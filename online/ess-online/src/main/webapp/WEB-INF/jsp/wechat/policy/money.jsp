<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
		<script type="text/x-jQuery-tmpl" id="moneyInfoTpl">
			<div class="page" id="policy-money">
				<div class="money-title">
					<img src="${ctx}/resources/image/policy/golds.png">
					<label>{{cashValueType}}</label>
					<span><b>{{cashValueFormat}}</b>元</span>
				</div>
				<div class="clearfix">
					<div class="money-info col-12">
						<label>累计红利</label>
						<span><b>{{bonusValueFormat}}</b>元</span>
					</div>
					<div class="money-info col-12">
						<label>现金利益</label>
						<span><b>{{getCashValueFormat}}</b>元</span>
					</div>
				</div>
				<div class="money-extra">
					<div class="basic-extra-item">
						<label>期满利益</label>
						<span>{{earnedPremFormat}}元</span>
					</div>
					<div class="basic-extra-item">
						<label>保单贷款</label>
						<span>{{loanAmntFormat}}元</span>
					</div>
				</div>
   				<p class="remind">温馨提示：<br/>1.以上数据仅供参考！<br/>2.为保护您的信息安全，我们将您的重要资料做了部分隐藏，若需核查，敬请拨打<a href="tel:4008188888">400-818-8888</a>垂询！<br/>3.各项保单价值由产品的特性及保单的利益保障、生效年限等因素确定！</p>
			</div>
		</script>	
		
		<script type="text/x-jQuery-tmpl" id="moneyInfoAllTpl">
			<div class="page" id="policy-money">
				<div class="money-panel row">
					<div class="money-item col-12">
						<img src="${ctx}/resources/image/policy/golds.png">
						<label>保证现金价值</label>
						<span><b>{{cashValueFormat}}</b>元</span>
					</div>
					<div class="money-item col-12">
						<label>账户价值</label>
						<span><b>{{accountValueFormat}}</b>元</span>
					</div>
				</div>
				<div class="clearfix">
					<div class="money-info col-12">
						<label>累计红利</label>
						<span><b>{{bonusValueFormat}}</b>元</span>
					</div>
					<div class="money-info col-12">
						<label>现金利益</label>
						<span><b>{{getCashValueFormat}}</b>元</span>
					</div>
				</div>
				<div class="money-extra">
					<div class="basic-extra-item">
						<label>期满利益</label>
						<span>{{earnedPremFormat}}元</span>
					</div>
					<div class="basic-extra-item">
						<label>保单贷款</label>
						<span>{{loanAmntFormat}}元</span>
					</div>
				</div>
   				<p class="remind">温馨提示：<br/>1.以上数据仅供参考！<br/>2.为保护您的信息安全，我们将您的重要资料做了部分隐藏，若需核查，敬请拨打<a href="tel:4008188888">400-818-8888</a>垂询！<br/>3.各项保单价值由产品的特性及保单的利益保障、生效年限等因素确定！</p>
			</div>
		</script>