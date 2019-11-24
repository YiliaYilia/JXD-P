<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	
	<%@ include file="/WEB-INF/jsp/wechat/common/meta.jsp"%>
	
	<%@ include file="/WEB-INF/jsp/wechat/common/rels.jsp"%>
	
	<link href="${ctx}/resources/css/office/office.min.css?${random}" rel="stylesheet"/>
	
	<script src="${ctx}/resources/js/office/office.js?${random}"></script>
</head>
<body>
	<div class="wrap">
		<div class="head">
			<a href="${ctx}/service" class="head-icon home right"></a>
    		<h1 class="head-name">服务网点查询</h1>
		</div>
		<div class="content office">
			<div class="page">
				<div class="office-head"></div>
				<div class="office-fm">
					<p class="office-fm-title">所在城市</p>
					<div class="office-fm-body">
						<div class="office-fm-row">
							<label>省</label>
							<select  name="inputRegion.province"  class="province"   id="dropDownMenu">
								<s:if test="#request.inputRegion.provinceCode == -1">
									<option value="" selected="selected">请选择</option>
								</s:if>
								<s:iterator var="province" value="#request.provinceList">
									<s:if test="#request.inputRegion.provinceCode == #province.provinceCode">
										<option value='<s:property value="#province.provinceCode" />' selected="selected"><s:property value="#province.provinceName" /></option>
									</s:if><s:else>
										<option value='<s:property value="#province.provinceCode" />'><s:property value="#province.provinceName" /></option>
									</s:else>
								</s:iterator>
							</select>
						</div>
						<div class="office-fm-row">
							<label>市</label>
							<select id="city" >
								
							</select>
						</div>
					</div>
					<div class="office-fm-action" >
						<a class="btn office-fm-btn" id="queryButton">查&nbsp;询</a>
					</div>
				</div>
				<div class="office-list">
				
				</div>
			</div>
		</div>
	</div>
	<!-- 模版页面 -->
	<jsp:include page="/WEB-INF/jsp/wechat/office/basic.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/jsp/wechat/common/common-modal.jsp"></jsp:include>
	<script type="text/javascript">
		var regionProvinceCode='<s:property value="#request.inputRegion.provinceCode" />';
		var regionCityCode='<s:property value="#request.inputRegion.cityCode" />';
	</script>
</body>
</html>