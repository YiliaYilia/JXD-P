<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	
	<%@ include file="/WEB-INF/jsp/wechat/common/meta.jsp"%>
	
	<%@ include file="/WEB-INF/jsp/wechat/common/rels.jsp"%>
	
	<link href="${ctx}/resources/css/conservation/conservation.min.css?${random}" rel="stylesheet"/>
	
	<script type="text/javascript" src="${ctx}/resources/js/conservation/loan.js?${random}"></script>
</head>
<body>
	<div class="wrap">
		<div class="head">
			<a href="${ctx}/conservations" class="head-icon back right"></a>
    		<h1 class="head-name">归还保单贷款</h1>
		</div>
		<div class="content loan">
			<div class="page">
				<!-- 贷款详细 -->
				<s:if test="#request.inputLoan.contNo != null">
					<s:iterator var="loan" value="#request.loanList" >
						<s:if test="#request.inputLoan.contNo == #loan.contNo">
							<div class="policy">
								<div class="policy-id">
									<span>保单编号</span><br>
									<span id="contNo"><s:property value="#loan.contNo" /></span>
								</div>
								<div class="policy-money">
									<span class="policy-money-je">贷款金额(元)</span><br>
									<span id="loanAmnt"><s:property value="#loan.loanAmntFormat" /></span>元
								</div>
							</div>
							<div class="data">
								<div class="datail">
									<div class="datail-left"><span>缴费银行：</span></div>
									<div class="datail-right"><span id="payBankName"><s:property value="#loan.payBankName" /></span></div>
								</div>
								<div class="datail dat-border">
									<div class="datail-left"><span>缴费账户：</span></div>
									<div class="datail-right"><span id="payAccNo"><s:property value="#loan.payAccNo" /> </span></div>
								</div>
							</div>
						</s:if>
					</s:iterator>
				</s:if><s:else>
					<div class="policy">
						<div class="policy-id">
						<span>保单号码</span><br/>
						<span id="contNo"><s:property value="#request.loanList[0].contNo" /></span></div>
						<div class="policy-money">
							<span class="policy-money-je">贷款金额(元)</span><br>
							<span id="loanAmnt"><s:property value="#request.loanList[0].loanAmntFormat" /></span>元
						</div>
					</div>
					<div class="data">
						<div class="datail">
							<div class="datail-left"><span>缴费银行：</span></div>
							<div class="datail-right"><span id="payBankName"><s:property value="#request.loanList[0].payBankName" /></span></div>
						</div>
						<div class="datail dat-border">
							<div class="datail-left"><span>缴费账户：</span></div>
							<div class="datail-right"><span id="payAccNo"><s:property value="#request.loanList[0].payAccNo" /> </span></div>
						</div>
					</div>
				</s:else>
				
				<form  method="post" action="${ctx}/repayLoan" onsubmit="return vaildForm()" >
					<div class="return">
						<div class="return-title"><span>归还贷款：</span></div>
						<div class="return-radio"><input type="radio" name="all" id="allLoan" checked="checked"><label for="allLoan">归还全部贷款</label></div>
						<div class="return-radio"><input type="radio" name="all" id="partLoan" ><label for="partLoan">归还部分贷款</label></div>
					</div>
					<div class="money return" >
						<div class="return-title"><span>归还金额：</span></div>
							<s:if test="#request.inputLoan.contNo != null ">
								<div class="money-input"><input type="text" id="returnAmnt" name="inputLoan.repaymentAmnt"  value="<s:property value='#request.inputLoan.repaymentAmnt' />"  onkeyup="value=this.value.replace(/[^\d.]/g,'')"/></div>
							</s:if><s:else>
								<div class="money-input"><input type="text" id="returnAmnt" name="inputLoan.repaymentAmnt"  value=""  onkeyup="value=this.value.replace(/[^\d.]/g,'')"/></div>
							</s:else>
					</div>
					<div class="confirm" >
						<input type="hidden" id="contNo" name="inputLoan.contNo" />
						<input type="hidden" id="isOr" name="isOr" />
						<input type="submit" class="confirm-btn ok input" id="confirmButton"  value="确&nbsp;定"  >
					</div>
				</form>
				<p class="remind">温馨提示：<br/>1.以上数据仅供参考！<br/>2.为保护您的信息安全，我们将您的重要资料做了部分隐藏，若需核查，敬请拨打<br/><a href="tel:4008188888">400-818-8888</a>垂询！</p>
			</div>
		</div>
		<jsp:include page="/WEB-INF/jsp/wechat/element/list-loan.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/wechat/common/common-modal.jsp"></jsp:include>
	</div>
</body>
<script type="text/javascript">
	var returnAmnt="<s:property value='#request.inputLoan.repaymentAmnt' />";
</script>
</html>