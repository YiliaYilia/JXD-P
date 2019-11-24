<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
<script type="text/x-jQuery-tmpl" id="claimBasicInfoTpl">
		
					{{#currentClaimList}}
					<div class="claim-item">
						<div class="claim-basic row">
							<div class="claim-info col-16">
								<p class="claim-no">{{contNo}}</p>
								<p class="claim-name">{{mainRiskName}}</p>
							</div>
							<div class="claim-status col-6">{{claimStatus}}</div>
							<div class="claim-folder col-2"><b></b></div>
						</div>
						<div class="claim-detail">
							<p class="claim-detail-item">
								<label>索赔人：</label>
								<span>{{claimer}}</span>
							</p>
							<p class="claim-detail-item">
								<label>赔付金额：</label>
								<span>{{claimAmntFormat}}元</span>
							</p>
							<p class="claim-detail-item">
								<label>理赔受理日：</label>
								<span>{{claimDate}}</span>
							</p>
							<p class="claim-detail-item">
								<label>结案日期：</label>
								<span>{{closeDate}}</span>
							</p>
						</div>
					</div>
					{{/currentClaimList}}
</script>
