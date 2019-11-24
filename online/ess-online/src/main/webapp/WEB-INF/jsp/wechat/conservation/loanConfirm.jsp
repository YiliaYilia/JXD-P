<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	
	<%@ include file="/WEB-INF/jsp/wechat/common/meta.jsp"%>
	
	<%@ include file="/WEB-INF/jsp/wechat/common/rels.jsp"%>
	
	<link href="${ctx}/resources/css/conservation/conservation.min.css?${random}" rel="stylesheet"/>
	
	<script type="text/javascript" src="${ctx}/resources/js/conservation/loanConfirm.js?${random}"></script>
	
</head>
<body>
	<div class="wrap">
		<div class="head">
			<a id="submitReturnForm" class="head-icon back right"></a>
			<form id="returnForm" action="${ctx}/loanList" method="post">
				<input type="hidden" name="inputLoan.contNo" value="<s:property value='#request.inputLoan.contNo' />">
				<input type="hidden" name="inputLoan.repaymentAmnt" value="<s:property value='#request.inputLoan.repaymentAmnt' />">
			</form>
			
    		<h1 class="head-name">归还保单贷款确认</h1>
		</div>
		<div class="content loan">
			<div class="page">
				<!-- 贷款详细 -->
				<s:iterator var="loan" value="#session['ConservationService.LoanList']">
				<s:if test="#loan.contNo == #request.inputLoan.contNo">
				<s:set var="newLoan" value="#loan"></s:set>
				<div class="policy">
					<div class="policy-id">
						<span>保单号码</span><br>
						<span id="confirmContNo"><s:property value="#loan.contNo" /></span>
					</div>
					<div class="policy-money">
						<span class="policy-money-je">归还贷款金额</span><br>
						<span id="confirmLoanAmnt"><s:property value="#request.inputLoan.repaymentAmntFormat" /></span>元
					</div>
				</div>
				<div class="data">
				<div class="datail">
						<div class="datail-left">缴费方式：</div>
						<div class="datail-right">银行转账</div>
					</div>
					<div class="datail">
						<div class="datail-left">缴费银行：</div>
						<div class="datail-right"><s:property value="#loan.payBankName" /></div>
					</div>
					<div class="datail dat-border">
						<div class="datail-left">缴费账户：</div>
						<div class="datail-right" id="payAccNo"><s:property value="#loan.payAccNo" /></div>
					</div>
				</div>
				</s:if>
				</s:iterator>
				<div class="confirm conf-top" id="submitButton">
			        <input type="hidden" id="isOr" name="isOr" value="<s:property value='#request.isOr' />" />
					<span class="confirm-btn ok" >确定</span>
				</div>
				
				<div class="remind">
					<div class="remind-sp">
						<span>友情提示：</span>
					</div>
					<div class="remind-sp">
						<span>1、本公司将在您递交本申请之日起的三个工作日内至您的缴费账户进行一次转账扣款，扣款金额等于您本次申请归还的贷款金额。</span>
					</div>
					<div class="remind-sp">
						<span>2、扣款成功后，本公司将按您本次申请递交日期归还贷款。</span>
					</div>
					<div class="remind-sp">
						<span>3、若因缴费账户余额不足等原因导致扣款失败，本次申请即终止。您若需归还贷款，请重新递交申请，归还贷款金额以届时的保单累计贷款金额为准。</span>
					</div>
					<div class="remind-bott">
						<span>温馨提示：<br/>1.以上数据仅供参考！<br/>2.为保护您的信息安全，我们将您的重要资料做了部分隐藏，若需核查，敬请拨打<br/><a href="tel:4008188888">400-818-8888</a>垂询！</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/jsp/wechat/common/common-modal.jsp"></jsp:include>
</body>
</html>