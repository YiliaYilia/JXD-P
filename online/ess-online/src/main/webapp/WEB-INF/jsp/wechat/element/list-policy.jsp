<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
		<div class="list">
			<b class="list-up"></b>
			<s:iterator id="list" value="#request.policyList" status="stat">
				<s:if test="#stat.first">
					<div class="list-head">
						<p class="pactive"><s:property value="#list.contStatus"/></p>
						<p class="pno"><s:property value="#list.contNo"/></p>
						<s:if test="#list.gaoFlag == 'GLH'">
							<p class="pname group"><s:property value="#list.mainRiskName"/></p>
						</s:if>
						<s:else>
							<p class="pname"><s:property value="#list.mainRiskName"/></p>			
						</s:else>
						<p class="pcValiDate" style="display:none;"><s:property value="#list.cValiDate"/></p>
						<p class="gaoFlag" style="display:none;"><s:property value="#list.gaoFlag"/></p>
					</div>
				</s:if>
			</s:iterator>
			<div class="list-body">
				<s:iterator id="list" value="#request.policyList" status="stat">
					<s:if test="#stat.first">
						<div class="list-item active">
							<p class="pactive"><s:property value="#list.contStatus"/></p>
							<p class="pno"><s:property value="#list.contNo"/></p>
							<s:if test="#list.gaoFlag == 'GLH'">
								<p class="pname group"><s:property value="#list.mainRiskName"/></p>
							</s:if>
							<s:else>
								<p class="pname"><s:property value="#list.mainRiskName"/></p>
							</s:else>	
							<p class="pcValiDate" style="display:none;"><s:property value="#list.cValiDate"/></p>
							<p class="gaoFlag" style="display:none;"><s:property value="#list.gaoFlag"/></p>
							<p class="startDate" style="display:none;"><s:property value="#request.startDate"/></p>
							<p class="endDate" style="display:none;"><s:property value="#request.endDate"/></p>						
						</div>
					</s:if>
					<s:else>
						<div class="list-item">
							<p class="pactive"><s:property value="#list.contStatus"/></p>
							<p class="pno"><s:property value="#list.contNo"/></p>
							<s:if test="#list.gaoFlag == 'GLH'">
								<p class="pname group"><s:property value="#list.mainRiskName"/></p>
							</s:if>
							<s:else>
								<p class="pname"><s:property value="#list.mainRiskName"/></p>
							</s:else>
							<p class="pcValiDate" style="display:none;"><s:property value="#list.cValiDate"/></p>
							<p class="gaoFlag" style="display:none;"><s:property value="#list.gaoFlag"/></p>
							<p class="startDate" style="display:none;"><s:property value="#request.startDate"/></p>
							<p class="endDate" style="display:none;"><s:property value="#request.endDate"/></p>	
						</div>
					</s:else>
				</s:iterator>
			</div>
		
<!-- 			<div class="list-body"> -->
<!-- 				<div class="list-item active"> -->
<!-- 					<p class="pactive">有效</p> -->
<!-- 					<p class="pno">1111111</p> -->
<!-- 					<p class="list-info pname">保险名称1</p> -->
<!-- 				</div> -->
<!-- 				<div class="list-item"> -->
<!-- 					<p class="pactive">有效</p> -->
<!-- 					<p class="pno">1111112</p> -->
<!-- 					<p class="pname group">保险名称2</p> -->
<!-- 				</div> -->
<!-- 				<div class="list-item"> -->
<!-- 					<p class="pactive">有效</p> -->
<!-- 					<p class="pno">1111113</p> -->
<!-- 					<p class="pname">保险名称3</p> -->
<!-- 				</div> -->
<!-- 				<div class="list-item"> -->
<!-- 					<p class="pactive">有效</p> -->
<!-- 					<p class="pno">1111114</p> -->
<!-- 					<p class="pname group">保险名称4</p> -->
<!-- 				</div> -->
<!-- 				<div class="list-item"> -->
<!-- 					<p class="pactive">有效</p> -->
<!-- 					<p class="pno">1111115</p> -->
<!-- 					<p class="pname">保险名称5</p> -->
<!-- 				</div> -->
<!-- 				<div class="list-item"> -->
<!-- 					<p class="pactive">有效</p> -->
<!-- 					<p class="pno">1111116</p> -->
<!-- 					<p class="pname group">保险名称6</p> -->
<!-- 				</div> -->
<!-- 				<div class="list-item"> -->
<!-- 					<p class="pactive">有效</p> -->
<!-- 					<p class="pno">1111117</p> -->
<!-- 					<p class="pname">保险名称7</p> -->
<!-- 				</div> -->
<!-- 			</div> -->
		</div>