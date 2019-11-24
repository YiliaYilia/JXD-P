<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
		<div class="list">
			<b class="list-up"></b>
			<div class="list-head">
				<s:if test="#request.contactAddress != null">
				<p class="pactive"><s:property value="#request.contactAddress[0].contDesc" /></p>
				<p class="pno"><s:property value="#request.contactAddress[0].contNo" /></p>
				<p class="pname"><s:property value="#request.contactAddress[0].mainRiskName" /></p>
				</s:if>
			</div>
			<div class="list-body">
				<s:iterator id="address" value="#request.contactAddress" status="stat">
				<s:if test="#stat.first">
					<div class="list-item active" id='<s:property value="#address.contNo" />,<s:property value="#address.address" />'>
						<p class="pactive"><s:property value="#address.contDesc" /></p>
						<p class="pno"><s:property value="#address.contNo" /></p>
						<p class="list-info pname"><s:property value="#address.mainRiskName" /></p>
					</div>
				</s:if><s:else>
					<div class="list-item" id='<s:property value="#address.contNo" />,<s:property value="#address.address" />'>
						<p class="pactive"><s:property value="#address.contDesc" /></p>
						<p class="pno"><s:property value="#address.contNo" /></p>
						<p class="list-info pname"><s:property value="#address.mainRiskName" /></p>
					</div>
				</s:else>
				</s:iterator>
			</div>
		</div>