<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
			<script type="text/x-jQuery-tmpl" id="basicInfoTpl">
			<div class="page" id="policy-basic">
				<div class="basic-head">
					<div class="basic-title">
						<b>保单号码：</b><span class="titletext">{{policyNo}}</span>
					</div>
					<div class="basic-tab">
						<span>{{policyName}}</span>
					</div>
					<div class="clearfix">
						<div class="basic-sub">
							<label>合同生效日期</label>
							<span>{{cValiDate}}</span>
						</div>
						<div class="basic-sub">
							<label>保单期满日</label>
							<span>{{insuEndDateFormat}}</span>
						</div>
					</div>
				</div>
				<div class="basic-body">
					<div class="basic-item clearfix">	
						<label class="col-10">投保人：</label>
						<span class="col-14">{{appntName}}</span>
					</div>
					<div class="basic-item clearfix">
						<label class="col-10">被保人：</label>
						<span class="col-14">{{insuredName}}</span>
					</div>
					<div class="basic-item clearfix">
						<label class="col-10">受益人：</label>
						<span class="col-24 ben">{{bnfInfo}}</span>
					</div>
				</div>
				<div class="basic-extra">
					<div class="basic-extra-item">
						<label>缴费年限</label>
					</div>
					<div class="basic-extra-item">
						<span>{{payYear}}年</span>
					</div>
				</div>
				<p class="remind">温馨提示：<br/>1.以上数据仅供参考！<br/>2.为保护您的信息安全，我们将您的重要资料做了部分隐藏，若需核查，敬请拨打<a href="tel:4008188888">400-818-8888</a>垂询！</p>
			</div>
        	</script>
