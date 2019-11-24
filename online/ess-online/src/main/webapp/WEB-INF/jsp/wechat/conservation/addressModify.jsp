<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	
	<%@ include file="/WEB-INF/jsp/wechat/common/meta.jsp"%>
	
	<%@ include file="/WEB-INF/jsp/wechat/common/rels.jsp"%>
	
	<link href="${ctx}/resources/css/conservation/conservation.min.css?${random}" rel="stylesheet"/>
	<script type="text/javascript" src="${ctx}/resources/js/conservation/address.js?${random}"></script>
</head>
<body>
	<div class="wrap">
		<div class="head">
			<a href="${ctx}/conservations" class="head-icon back right"></a>
    		<h1 class="head-name">联系地址变更</h1>
		</div>
		<div class="content address">
			<div class="page">
				<!-- 当前地址 -->
				<div class="out">
					<div class="out-inn">
						<div class="out-inn-left"><img src="${ctx}/resources/image/conservation/color-1.png"><span>保单号码</span></div>
						<div class="out-inn-right"><span id="contNo"><s:property value="#request.contactAddress[0].contNo"/></span></div>
					</div>
					<div class="out-inn">
						<div class="out-inn-left"><img src="${ctx}/resources/image/conservation/color-1.png"><span>固定电话</span></div>
						<div class="out-inn-right"><span>
						<s:if test="#request.contactPhone.areaCode != '' ">
							<s:property value="#request.contactPhone.areaCode"/>
						</s:if>
						<s:if test="#request.contactPhone.phone != '' ">
							-<s:property value="#request.contactPhone.phone"/>
						</s:if>
						<s:if test="#request.contactPhone.extNumber != '' ">
							-<s:property value="#request.contactPhone.extNumber"/>
						</s:if>
						</span></div>
					</div>
					<div class="out-inn">
						<div class="out-inn-left"><img src="${ctx}/resources/image/conservation/color-1.png"><span>手机号码</span></div>
						<div class="out-inn-right"><span><s:property value="#request.contactPhone.mobile"/></span></div>
					</div>
					<div class="out-inn">
						<div class="out-inn-left"><img src="${ctx}/resources/image/conservation/color-1.png"><span>当前通讯地址</span></div>
						<div class="out-inn-right long"><span id="spanAddress"><s:property value="#request.contactAddress[0].address"/></span></div>
					</div>
				</div>
				<!-- 变更地址 -->
				<form id="addressModifyForm" method="post" >
				<div class="newadd">
					<div class="newadd-title"><span>新的联系地址</span></div>
					<div class="newadd-info">
						<div class="city">
							<div class="city-title"><span>所在地区：</span></div>
							<div class="city-info">
								<div class="city-info-content">
									<span>省</span>
									<select name="inputRegion.province"  id ="province">
										<option value="">请选择</option>
										<s:iterator var="province"  value="#request.provinceList">
											<option value='<s:property value="#province.provinceCode"/>'><s:property value="#province.provinceName"/> </option>
										</s:iterator>
									</select>
								</div>
								<div class="city-info-content">
									<span>市</span>
									<select name="inputRegion.city"  id="city">
										<option value="">请选择</option>
										<s:iterator var="city"  value="#request.cityList">
											<option value='<s:property value="#city.cityCode"/>'><s:property value="#city.cityName"/> </option>
										</s:iterator>
									</select>
								</div>
								<div class="city-info-content">
									<span>区</span>
									<select name="inputRegion.district" class="dropDownMenu" id="district">
											<option value="">请选择</option>
										<s:iterator var="district"  value="#request.districtList">
											<option value='<s:property value="#district.countyCode"/>'><s:property value="#district.countyName"/> </option>
										</s:iterator>
									</select>
								</div>
							</div>
						</div>
						<div class="city">
							<div class="city-title"><span>通讯地址：</span></div>
							<div class="city-info city-info-height"><input class="city-none-bott" type="text" name="inputAddress.address" id = "address" value=""></div>
							
						</div>
						<div class="city">
							<div class="city-title"><span>邮政编码</span></div>
							<div class="city-info city-info-height"><input class="city-none-bott" type="text" maxlength="6" name="inputAddress.zipCode" id="zipCode" value="" onkeyup="value=this.value.replace(/\D+/g,'')"></div>
						</div>
					</div>
				</div>
				<div class="address-all">
					<input type="hidden" id="policyList" name="policyList" value='<s:property value="#request.contactAddress[0].contNo"/>'>
					<input type="checkbox" id="modifyAll">
					<label for="modifyAll">变更全部保单</label>
				</div>
				<div class="address-agree">
					<input type="checkbox" id="agreeNotice" checked="checked">
					<label for="agreeNotice">本人已认真核对上述变更申请，并已仔细阅读和同意<a id="agreeDetail">变更声明</a></label>
				</div>
				<div class="okUpdate confirm">
					<span class="confirm-btn ok inline"  id="modifyButton">确&nbsp;认</span>
					<span class="confirm-btn cancel inline" id="cleanButton" >清&nbsp;空</span>
				</div>
				</form>
				<p class="remind">温馨提示：<br/>1.以上数据仅供参考！<br/>2.为保护您的信息安全，我们将您的重要资料做了部分隐藏，若需核查，敬请拨打<br/><a href="tel:400-818-8888">400-818-8888</a>垂询！</p>
			</div>
		</div>
		<jsp:include page="/WEB-INF/jsp/wechat/element/list-address.jsp"></jsp:include>
	</div>
	<jsp:include page="/WEB-INF/jsp/wechat/common/common-modal.jsp"></jsp:include>

	<div class="modal fade" id="agreeModal" data-rule="modal">
		<div class="modal-dialog address">
			<div class="modal-content" data-content="modal">
				<p>本人要求贵公司按本申请书所述，变更上述保险合同的保单联系地址，同时承认以下各点：</p>
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
<script>
 var allContNo = new Array();
 <s:iterator id="address" value="#request.contactAddress" status="status">
 	allContNo[<s:property value='#status.index'/>]='<s:property value="#address.contNo"/>'; 
 </s:iterator>
</script>
</html>