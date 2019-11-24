<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
		<div class="list">
			<b class="list-up"></b>
			<div class="list-head">
				<s:if test="#request.claimList != null">
				<p class="pactive"><s:property value="#request.claimList[0].claimStatus" /></p>
				<p class="pname">理赔受理日期</p>
				<p class="pno"><s:property value="#request.claimList[0].claimDate" /></p>
				</s:if>
			</div>
			<div class="list-body">
			<s:iterator var="claim" value="#request.claimList" status="stat">
				<s:if test="#stat.first">
					<div class="list-item active" data-claimDate='<s:property value="#claim.claimDate"/>'>
						<p class="pactive"><s:property value="#claim.claimStatus"/></p>
						<p class="list-info pname">理赔受理日期</p>
						<p class="pno"><s:property value="#claim.claimDate"/></p>
					</div>
				</s:if>
				<s:else>
					<div class="list-item" data-claimDate='<s:property value="#claim.claimDate"/>'>
						<p class="pactive"><s:property value="#claim.claimStatus"/></p>
						<p class="list-info pname">理赔受理日期</p>
						<p class="pno"><s:property value="#claim.claimDate"/></p>
					</div>
				</s:else>
			</s:iterator>	
			</div>
		</div>	