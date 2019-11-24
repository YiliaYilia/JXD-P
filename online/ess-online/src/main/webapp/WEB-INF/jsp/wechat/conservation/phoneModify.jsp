<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	
	<%@ include file="/WEB-INF/jsp/wechat/common/meta.jsp"%>
	
	<%@ include file="/WEB-INF/jsp/wechat/common/rels.jsp"%>
	
	<link href="${ctx}/resources/css/conservation/conservation.min.css?${random}" rel="stylesheet"/>
	<script type="text/javascript" src="${ctx}/resources/js/conservation/phone.js?${random}"></script>
</head>
<body>

	<div class="wrap">
		<div class="head">
			<a href="${ctx}/conservations" class="head-icon back right"></a>
    		<h1 class="head-name">联系电话变更</h1>
		</div>
		<div class="content phone">
			<div class="page">
				<!-- 更改联系电话 -->
				<div class="ph phout">
					<div class="ph-title ph-titleout">
						<span>当前联系电话</span>
					</div>
					<div class="ph-inn">
						<div class="ph-inn-left"><span>固定电话：</span></div>
						<div class="ph-inn-right">
							<span><s:if test="#request.contactPhone.areaCode != '' "><s:property value="#request.contactPhone.areaCode"/></s:if></span>
							<span><s:if test="#request.contactPhone.phone != '' ">-<s:property value="#request.contactPhone.phone"/></s:if></span>
							<span><s:if test="#request.contactPhone.extNumber != '' ">-<s:property value="#request.contactPhone.extNumber"/></s:if></span>
						</div>
					</div>
					<div class="ph-inn">
						<div class="ph-inn-left"><span>手机号码：</span></div>
						<div class="ph-inn-right"><span><s:property value="#request.contactPhone.mobile"/></span></div>
					</div>
				</div>
				<form id="phoneModifyForm"   method="post">
				<div class="ph phnew">
					<div class="ph-title ph-titlenew">
						<div class="ph-title-size"><span>新的联系电话</span></div>
<%-- 						<div class="ph-title-up"><img src="${ctx}/resources/image/conservation//pencil.png"><span>修改</span></div> --%>
					</div>
					<div class="phup">
						<div class="phup-title">
							<input type="checkbox" id="phoneModify">
							<label for="phoneModify">固定电话：</label>
						</div>
						<div class="phup-input readonly" id="phoneInput">
							<input readonly="readonly" type="text" class="code" id="areaCode" name="inputPhone.areaCode" maxlength="4" placeholder="区号" onkeyup="value=this.value.replace(/\D+/g,'')" value='<s:property value="#request.contactPhone.areaCode" />'>
							<input readonly="readonly" type="text" class="phone" id="phone" name="inputPhone.phone"  maxlength="8" placeholder="电话号" onkeyup="value=this.value.replace(/\D+/g,'')" value='<s:property value="#request.contactPhone.phone"/>'>
							<input readonly="readonly" type="text" class="code" id="extNumber" name="inputPhone.extNumber"   maxlength="20"  placeholder="分机" onkeyup="value=this.value.replace(/\D+/g,'')" value='<s:property value="#request.contactPhone.extNumber" />'>
						</div>
					</div>
					<div class="phup">
						<div class="phup-title">
							<input type="checkbox" id="mobileModify">
							<label for="mobileModify">手机号码：</label>
						</div>
						<div class="phup-input readonly" id="mobileInput">
							<input readonly="readonly" type="text" id="mobile" name="inputPhone.mobile" onkeyup="this.value=this.value.replace(/\D+/g,'')" maxlength="11" value='<s:property value="#request.contactPhone.mobile" />' >
						</div>
					</div>
					<p class="ph-notice">提示：请勾选您需要变更的电话。</p>
				</div>
				</form>
				<div class="address-agree">
					<input type="checkbox" id="agreeNotice" checked="checked">
					<label for="agreeNotice">本人已认真核对上述变更申请，并已仔细阅读和同意<a id="agreeDetail">变更声明</a></label>
				</div>
				<div class="okUpdate confirm" id="modifyButton">
					<span class="confirm-btn ok" >确&nbsp;认&nbsp;修&nbsp;改</span>
				</div>	
				<p class="remind">温馨提示：<br/>1.以上数据仅供参考！<br/>2.为保护您的信息安全，我们将您的重要资料做了部分隐藏，若需核查，敬请拨打<br/><a href="tel:4008188888">400-818-8888</a>垂询！</p>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/jsp/wechat/common/common-modal.jsp"></jsp:include>
	
	<div class="modal fade" id="agreeModal" data-rule="modal">
		<div class="modal-dialog address">
			<div class="modal-content" data-content="modal">
				<p>本人要求贵公司按本申请书所述，变更联系电话，同时承认以下各点：</p>
				<p>1.	本人已认真核对上述变更申请书并如实答复，确认所有答复均为真实和正确的，同时本人明白上述答复的真实性是保险合同成立的重要依据；</p>
				<p>2.	本申请书及相关文件将附于保险合同内，成为保险合同的构成部分；</p>
				<p>3.	本人同时授权：本人在保单中的资料（包括今后所作的任何修订或补充），可供贵公司（包括其关联公司和附属公司）及其因业务必要而委托的服务供应商，用以提供客户服务及推荐相关产品与服务。</p>
			</div>
			<div class="modal-footer">
				<a class="modal-btn btn" data-dismiss="modal" data-btn="modal" id="readConfirm">已阅读</a>
			</div>
		</div>
	</div>
</body>
</html>