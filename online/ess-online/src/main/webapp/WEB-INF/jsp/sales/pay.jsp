<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>

	<%@ include file="../common/meta.jsp"%>
	
	<%@ include file="../common/rels.jsp"%>
	
	<link href="${ctx}/resources/css/sales/sales.min.css?${random}" rel="stylesheet"/>
	<script src="${ctx}/resources/js/sales/pay.js?${random}"></script>
</head>
<body>
	<s:set var="order" value="#request.order" />
		<s:iterator  var="policys" value="#order.policys">
			<s:set var="policy" value="#policys" />
		</s:iterator>
	<div class="wrap pay">
		<jsp:include page="../common/head.jsp"></jsp:include>
		<div class="head line">
    		<h1 class="head-name">订单支付</h1>
		</div>
		<div class="content">
			<div class="banner hidden-sm">
				<a class="banner-img">
					<img class="hidden-lg" src="${ctx}/resources/image/sales/${policy.prodoctcode}/banner-sm.jpg">
					<img class="hidden-sm" src="${ctx}/resources/image/sales/${policy.prodoctcode}/banner-lg.jpg">
				</a>
				<div class="container banner-container">
					<div class="banner-product">
						<!-- 						产品banner说明文字 -->
						<jsp:include page="/WEB-INF/jsp/sales/element/${policy.prodoctcode}/banner-info.jsp"></jsp:include>
						<div class="banner-product-ac">
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="pay-body">
					<div class="insure-process hidden-sm">
						<img src="${ctx}/resources/image/sales/process-step3.png">
					</div>
					<div class="pay-title">支付方式</div>
					<div class="pay-type">
						<s:iterator var="payment" value="#request.paymentTypeInfoList" status="status">
							<div class="pay-item row">
								<s:if test="#status.first">
									<s:if test="#payment.payTypeCode == 10 || #payment.payTypeCode == 11 ">
										<div class="col-sm-6 col-lg-6 pay-type-icon"><img src="${ctx}/resources/image/common/icon-wechat.png"></div>
											<div class="col-sm-14 col-lg-14">
												<p class="pay-type-name"><s:property value="#payment.payTypeName" /></p>
												<p class="pay-type-instro hidden-lg"><s:property value="#payment.payTypedescription" /></p>
												<p class="pay-type-instro hidden-sm"><s:property value="#payment.payTypedescription" /></p>
											</div>
										<div class="col-sm-4 col-lg-4 pay-type-select"><input type="radio" checked="checked" name="radioPayType"  value='<s:property value="#payment.payTypeCode"/>' onclick="radioChange()"  /></div>
									</s:if><s:elseif test="#payment.payTypeCode == 20  || #payment.payTypeCode == 21 ">
										<div class="col-sm-6 col-lg-6 pay-type-icon"><img src="${ctx}/resources/image/common/icon-alipay.png"></div>
										<div class="col-sm-14 col-lg-14">
												<p class="pay-type-name"><s:property value="#payment.payTypeName" /></p>
												<p class="pay-type-instro hidden-lg"><s:property value="#payment.payTypedescription" /></p>
												<p class="pay-type-instro hidden-sm"><s:property value="#payment.payTypedescription" /></p>
											</div>
										<div class="col-sm-4 col-lg-4 pay-type-select"><input type="radio" checked="checked" name="radioPayType" value='<s:property value="#payment.payTypeCode"/>' onclick="radioChange()" /></div>
									</s:elseif><s:elseif test="#payment.payTypeCode == 22">
										<div class="col-sm-6 col-lg-6 pay-type-icon"><img src="${ctx}/resources/image/common/icon-bank.png"></div>
											<div class="col-sm-14 col-lg-14">
												<p class="pay-type-name"><s:property value="#payment.payTypeName" /></p>
												<p class="pay-type-instro hidden-lg"><s:property value="#payment.payTypedescription" /></p>
												<p class="pay-type-instro hidden-sm"><s:property value="#payment.payTypedescription" /></p>
											</div>
										<div class="col-sm-4 col-lg-4 pay-type-select"><input type="radio" checked="checked" name="radioPayType" value='<s:property value="#payment.payTypeCode"/>' onclick="radioChange()" /></div>
									</s:elseif>
								</s:if><s:else>
									<s:if test="#payment.payTypeCode == 10 || #payment.payTypeCode == 11 ">
										<div class="col-sm-6 col-lg-6 pay-type-icon"><img src="${ctx}/resources/image/common/icon-wechat.png"></div>
											<div class="col-sm-14 col-lg-14">
												<p class="pay-type-name"><s:property value="#payment.payTypeName" /></p>
												<p class="pay-type-instro hidden-lg"><s:property value="#payment.payTypedescription" /></p>
												<p class="pay-type-instro hidden-sm"><s:property value="#payment.payTypedescription" /></p>
											</div>
										<div class="col-sm-4 col-lg-4 pay-type-select"><input type="radio"  name="radioPayType"  value='<s:property value="#payment.payTypeCode"/>' onclick="radioChange()"  /></div>
									</s:if><s:elseif test="#payment.payTypeCode == 20  || #payment.payTypeCode == 21 ">
										<div class="col-sm-6 col-lg-6 pay-type-icon"><img src="${ctx}/resources/image/common/icon-alipay.png"></div>
										<div class="col-sm-14 col-lg-14">
												<p class="pay-type-name"><s:property value="#payment.payTypeName" /></p>
												<p class="pay-type-instro hidden-lg"><s:property value="#payment.payTypedescription" /></p>
												<p class="pay-type-instro hidden-sm"><s:property value="#payment.payTypedescription" /></p>
											</div>
										<div class="col-sm-4 col-lg-4 pay-type-select"><input type="radio" name="radioPayType" value='<s:property value="#payment.payTypeCode"/>' onclick="radioChange()" /></div>
									</s:elseif><s:elseif test="#payment.payTypeCode == 22">
										<div class="col-sm-6 col-lg-6 pay-type-icon"><img src="${ctx}/resources/image/common/icon-bank.png"></div>
											<div class="col-sm-14 col-lg-14">
												<p class="pay-type-name"><s:property value="#payment.payTypeName" /></p>
												<p class="pay-type-instro hidden-lg"><s:property value="#payment.payTypedescription" /></p>
												<p class="pay-type-instro hidden-sm"><s:property value="#payment.payTypedescription" /></p>
											</div>
										<div class="col-sm-4 col-lg-4 pay-type-select"><input type="radio"  name="radioPayType" value='<s:property value="#payment.payTypeCode"/>' onclick="radioChange()" /></div>
									</s:elseif>
								</s:else>
								
							</div>
						</s:iterator>
					</div>
				</div>
			</div>
		</div>
		<div class="pay-action">
			<div class="container">
				<div class="pay-action-inner">
					<div class="pay-info">
					<s:iterator var="payment" value="#request.paymentTypeInfoList" status="status">
						<s:if test="#status.first">
							<s:if test="#payment.payTypeCode == 10 || #payment.payTypeCode == 11 ">
								<img id=payInfoImg src="${ctx}/resources/image/common/icon-wechat.png">
								<span id=payInfoSpan ><s:property value="#payment.payTypeName" /></span>
							</s:if><s:elseif test="#payment.payTypeCode == 20  || #payment.payTypeCode == 21 ">
								<img id=payInfoImg src="${ctx}/resources/image/common/icon-alipay.png">
								<span id=payInfoSpan ><s:property value="#payment.payTypeName" /></span>
							</s:elseif><s:elseif test="#payment.payTypeCode == 22">
								<img id=payInfoImg src="${ctx}/resources/image/common/icon-bank.png">
								<span id=payInfoSpan ><s:property value="#payment.payTypeName" /></span>
							</s:elseif>
					  </s:if>
					</s:iterator>
						<strong><s:property value="#order.orderamount"/>元</strong>
					</div>
					<form action="${ctx}/msl/sales/pay" target="_blank" method="post" id="insureForm">
						<input type="hidden" id="hiddenPayType" name="payType" value="" />
						<input type="hidden" id="hiddenbankCode" name="bankCode" value="" />
						<a class="btn insure" id="insureButton"><span>确认支付</span></a>
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="../common/foot.jsp"></jsp:include>
	</div>
	<jsp:include page="/WEB-INF/jsp/common/common-modal.jsp"></jsp:include>
	<!-- 弹出对话框 -->
	<div class="modal fade" id="payResult">
		<div class="modal-dialog alert">
			<div class="modal-header clearfix">登录平台支付</div>
			<div class="modal-content" data-content="modal">请您在新打开的支付平台页面进行支付。<br/>完成支付后请根据您的情况点击下面的按钮</div>
			<div class="modal-footer">
				<a class="modal-btn btn inline" data-dismiss="modal" data-btn="ok" id="finishPay">已完成付款</a>
				<a class="modal-btn btn cancel inline" data-dismiss="modal" data-btn="cancel" id="changePayType">选择其他支付方式</a>
			</div>
		</div>
	</div>
	
	<!-- 弹出二维码浮层 -->
	<div class="modal fade" id="QRCode">
		<div class="modal-dialog alert">
			<div class="modal-header clearfix">微信扫码支付</div>
			<div class="modal-content" data-content="modal"><img id="qrcodeImg"  style="height:300px;width:300px"  /></div>
			<div class="modal-footer">
				<a class="modal-btn btn inline" data-dismiss="modal" data-btn="ok" id="finishPayQRCode">已完成付款</a>
				<a class="modal-btn btn cancel inline" data-dismiss="modal" data-btn="cancel" id="changePayTypeQRCode">选择其他支付方式</a>
			</div>
		</div>
	</div>
	<!-- 网银支付浮层  -->
<div class="modal fade" id="bankChoose">
		<div class="modal-dialog bank-modal">
			<div class="modal-header clearfix">请选择银行<a type="button" class="close" data-dismiss="modal"></a></div>
			<div class="modal-content">
				<ul class="bank-list row">
					<li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="ICBCB2C" checked id="ICBCB2C_radio"/>
						<label for="ICBCB2C_radio"><i></i><img src="${ctx}/resources/image/bank/payment_icbc.png"/></label>
					</li>
					<li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="CCB" id="CCB_radio"/>
						<label for="CCB_radio"><i></i><img src="${ctx}/resources/image/bank/payment_ccb.png" class="ui-pay-img"/></label>
					</li>
					<li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="ABC" id="ABC_radio"/>
						<label for="ABC_radio"><i></i><img src="${ctx}/resources/image/bank/payment_abc.png" class="ui-pay-img"/></label>
					</li>
					<li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="CMB" id="CMB_radio"/>
						<label for="CMB_radio"><i></i><img src="${ctx}/resources/image/bank/payment_cmb.png" class="ui-pay-img"/></label>
					</li>
					<%-- <li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="CITIC" id="CITIC_radio"/>
						<label for="CITIC_radio"><i></i><img src="${ctx}/resources/image/bank/payment_citic.png" class="ui-pay-img"/></label>
					</li> --%>
					<li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="SPDB" id="SPDB_radio"/>
						<label for="SPDB_radio"><i></i><img src="${ctx}/resources/image/bank/payment_spdb.png" class="ui-pay-img"/></label>
					</li>
					<li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="BJBANK" id="BJBANK_radio"/>
						<label for="BJBANK_radio"><i></i><img src="${ctx}/resources/image/bank/payment_bob.png" class="ui-pay-img"/></label>
					</li>
					<li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="PSBC-DEBIT" id="PSBC_radio"/>
						<label for="PSBC_radio"><i></i><img src="${ctx}/resources/image/bank/payment_postgc.png" class="ui-pay-img"/></label>
					</li>
					<%-- <li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="CEBBANK" id="CEBBANK_radio"/>
						<label for="CEBBANK_radio"><i></i><img src="${ctx}/resources/image/bank/payment_ceb.png" class="ui-pay-img"/></label>
					</li> --%>
					<li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="CMBC" id="CMBC_radio"/>
						<label for="CMBC_radio"><i></i><img src="${ctx}/resources/image/bank/payment_cmbc.png" class="ui-pay-img"/></label>
					</li>
					<li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="SPABANK" id="SPABANK_radio"/>
						<label for="SPABANK_radio"><i></i><img src="${ctx}/resources/image/bank/payment_pab.png" class="ui-pay-img"/></label>
					</li>
					<li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="GDB" id="GDB_radio"/>
						<label for="GDB_radio"><i></i><img src="${ctx}/resources/image/bank/payment_gdb.png" class="ui-pay-img"/></label>
					</li>
					<li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="BOCB2C" id="BOCB2C_radio"/>
						<label for="BOCB2C_radio"><i></i><img src="${ctx}/resources/image/bank/payment_boc.png" class="ui-pay-img"/></label>
					</li>
					<li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="CIB" id="CIB_radio"/>
						<label for="CIB_radio"><i></i><img src="${ctx}/resources/image/bank/payment_cib.png" class="ui-pay-img"/></label>
					</li>
					<%-- <li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="COMM" id="COMM_radio"/>
						<label for="COMM_radio"><i></i><img src="${ctx}/resources/image/bank/payment_comm.png" class="ui-pay-img"/></label>
					</li> --%>
					<li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="FDB" id="FDB_radio"/>
						<label for="FDB_radio"><i></i><img src="${ctx}/resources/image/bank/payment_fdb.png" class="ui-pay-img"/></label>
					</li>
					<li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="SHBANK" id="SHBANK_radio"/>
						<label for="SHBANK_radio"><i></i><img src="${ctx}/resources/image/bank/payment_shbank.png" class="ui-pay-img"/></label>
					</li>
					<li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="NBBANK" id="NBBANK_radio"/>
						<label for="NBBANK_radio"><i></i><img src="${ctx}/resources/image/bank/payment_nbbank.png" class="ui-pay-img"/></label>
					</li>
					<li class="col-lg-8 col-sm-12">
						<input name="paybank" type="radio" value="HZCBB2C" id="HZCBB2C_radio"/>
						<label for="HZCBB2C_radio"><i></i><img src="${ctx}/resources/image/bank/payment_hzcbb2c.png" class="ui-pay-img"/></label>
					</li>
				</ul>
			</div>
			<div class="modal-footer">
				<a class="modal-btn btn inline" data-dismiss="modal" data-btn="ok" id="bankConfirmPay">确认支付</a>
				<a class="modal-btn btn cancel inline" data-dismiss="modal" data-btn="cancel" id="changePayTypeBank">选择其他支付方式</a>
			</div>
		</div>
	</div>	
</body>
</html>