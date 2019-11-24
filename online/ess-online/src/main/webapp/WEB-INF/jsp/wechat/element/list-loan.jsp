<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
		<div class="list">
			<b class="list-up"></b>
			
			<s:if test="#request.inputLoan.contNo != null">
				<s:iterator var="loan" value="#request.loanList"  >
					<s:if test="#request.inputLoan.contNo == #loan.contNo">
					<div class="list-head" id='<s:property  value="#loan.contNo"/>;<s:property  value="#loan.loanAmntFormat"/>;<s:property  value="#loan.payBankName"/>;<s:property  value="#loan.payAccNo"/>'>
						<p class="pactive"><s:property  value="#loan.contDesc"/></p>
						<p class="pno"><s:property  value="#loan.contNo"/></p>
						<p class="pname"><s:property  value="#loan.mainRiskName"/></p>
					</div>
					</s:if>
				</s:iterator>
			</s:if><s:else>
				<s:if test="#request.loanList != null ">
				<div class="list-head" id='<s:property  value="#request.loanList[0].contNo"/>;<s:property  value="#request.loanList[0].loanAmntFormat"/>;<s:property  value="#request.loanList[0].payBankName"/>;<s:property  value="#request.loanList[0].payAccNo"/>'>
				<p class="pactive"><s:property  value="#request.loanList[0].contDesc"/></p>
				<p class="pno"><s:property  value="#request.loanList[0].contNo"/></p>
				<p class="pname"><s:property  value="#request.loanList[0].mainRiskName"/></p>
				</div>
				</s:if>
			</s:else>
				
				
				
			
			<div class="list-body">
			<s:iterator var="loan" value="#request.loanList"  status="stat">
			<s:if test="#stat.first">
				<div class="list-item active" id='<s:property  value="#loan.contNo"/>;<s:property  value="#loan.loanAmntFormat"/>;<s:property  value="#loan.payBankName"/>;<s:property  value="#loan.payAccNo"/>'>
					<p class="pactive"><s:property  value="#loan.contDesc"/></p>
					<p class="pno"><s:property  value="#loan.contNo"/></p>
					<p class="list-info pname"><s:property  value="#loan.mainRiskName"/></p>
				</div>
			</s:if><s:else>
				<div class="list-item" id='<s:property  value="#loan.contNo"/>;<s:property  value="#loan.loanAmntFormat"/>;<s:property  value="#loan.payBankName"/>;<s:property  value="#loan.payAccNo"/>'>
					<p class="pactive"><s:property  value="#loan.contDesc"/></p>
					<p class="pno"><s:property  value="#loan.contNo"/></p>
					<p class="list-info pname"><s:property  value="#loan.mainRiskName"/></p>
				</div>
			</s:else>
				
				</s:iterator>
				
			</div>
		</div>