<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>

	<%@ include file="../common/meta.jsp"%>
	
	<%@ include file="../common/rels.jsp"%>
	
	<link href="${ctx}/resources/css/reservation/reserv.min.css?${random}" rel="stylesheet"/>
	<script src="${ctx}/resources/js/reservation/result.js"></script>
</head>
<body>
	<div class="wrap result">
		<s:set value="#request.reservation" var="re"></s:set> 
		<s:iterator var="policy" value="#re.policys">
		</s:iterator>
		<jsp:include page="../common/head.jsp"></jsp:include>
		<div class="head line">
    		<h1 class="head-name">保费试算结果</h1>
		</div>
		<div class="content">
			<div class="banner hidden-sm">
				<a class="banner-img">
					<img class="hidden-lg" src="${ctx}/resources/image/reservation/${policy.prodoctcode}/banner-sm.jpg">
					<img class="hidden-sm" src="${ctx}/resources/image/reservation/${policy.prodoctcode}/banner-lg.jpg">
				</a>
				<div class="container banner-container">
					<div class="banner-reserv qt">
					<!-- 						产品banner说明文字 -->
						<jsp:include page="/WEB-INF/jsp/reservation/element/${policy.prodoctcode}/banner-info.jsp"></jsp:include>
					</div>
				</div>
			</div>
			<div class="result-basic">
				<div class="container">
					<div class="row result-basic-bd">
						<div class="col-sm-24 col-lg-12 result-name">
							<p>以下是您试算出的保费结果</p>
							<h3>${reservation.productname}</h3>  
						</div>
						<div class="col-sm-24 col-lg-12 result-amount">
							<p>首期保费试算结果：<b>
							<span>
					           <s:property value='%{numberFormat(#policy.sumbasepremium,"#0.00")}'/>
							</span>元</b></p> 
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="result-body">
					<s:if test='#policy.prodoctcode=="CDC"||#policy.prodoctcode=="CCC"'>
						<div class="result-img">
							<div class="result-bar">
								<img class="hidden-lg" src="${ctx}/resources/image/reservation/${policy.prodoctcode}/reserv-result-sm.jpg">
								<img class="hidden-sm" src="${ctx}/resources/image/reservation/${policy.prodoctcode}/reserv-result-lg.jpg">
							</div>
							<div class="result-list row">
						 		<s:iterator var="ratio" value="#request.policyBenefit" status="st" >
									<s:if test="#st.index==0"><label class="col-lg-6 col-sm-24 ratio0" id="ratio0Money">￥<s:property value='%{numberFormat(#policy.sumamount*#ratio,"#,##0")}'/></label></s:if>
									<s:if test="#st.index==1"><label class="col-lg-5 col-sm-24 ratio1" id="ratio1Money">￥<s:property value='%{numberFormat(#policy.sumamount*#ratio,"#,##0")}'/></label></s:if>
									<s:if test="#st.index==2"><label class="col-lg-7 col-sm-24 ratio2" id="ratio2Money">￥<s:property value='%{numberFormat(#policy.sumamount*#ratio,"#,##0")}'/></label></s:if>
									<s:if test="#st.index==3"><label class="col-lg-5 col-sm-24 ratio3" id="ratio3Money">￥<s:property value='%{numberFormat(#policy.sumamount*#ratio,"#,##0")}'/></label></s:if>
							 	</s:iterator>
							</div>
						</div>
					</s:if>
					<s:if test='#policy.prodoctcode=="NBJ"'>
						<div class="result-table">
							<table>
								<tr>
									<th colspan="4">万能账户价值</th>
								</tr>
								<tr class="tbg1">
									<td class="tlb">年龄</td>
									<td class="tt">高</td>
									<td class="tt">中</td>
									<td class="tt">低</td>
								</tr>
					  			<s:iterator var="ratio" value="#request.policyBenefit" status="st" >
									<s:if test="#st.index==0">
										<tr class="tbg">
											<td class="tlb">30周岁</td>
											<td>￥<s:property value='%{numberFormat(#policy.sumamount/1000*#ratio,"#,##0")}'/></td>              
									</s:if>
									<s:if test="#st.index==1||#st.index==2">			
										<td>￥<s:property value='%{numberFormat(#policy.sumamount/1000*#ratio,"#,##0")}'/></td>
									</s:if>
									<s:if test="#st.index==3">			
										</tr>
										<tr class="tbg1">
											<td class="tlb">60周岁</td>
											<td>￥<s:property value='%{numberFormat(#policy.sumamount/1000*#ratio,"#,##0")}'/></td>   
									</s:if>
									<s:if test="#st.index==4||#st.index==5">			
										<td>￥<s:property value='%{numberFormat(#policy.sumamount/1000*#ratio,"#,##0")}'/></td>   
									</s:if>
									<s:if test="#st.index==6">			
										</tr>
										<tr class="tbg">
											<td class="tlb">80周岁</td>
											<td>￥<s:property value='%{numberFormat(#policy.sumamount/1000*#ratio,"#,##0")}'/></td>   
									</s:if>
									<s:if test="#st.index==7||#st.index==8">			
											<td>￥<s:property value='%{numberFormat(#policy.sumamount/1000*#ratio,"#,##0")}'/></td>   
									</s:if>
									<s:if test="#st.index==9">			
										</tr>
										<tr class="tbg1">
											<td class="tlb">100周岁</td>
											<td>￥<s:property value='%{numberFormat(#policy.sumamount/1000*#ratio,"#,##0")}'/></td>  
										</s:if>
									<s:if test="#st.index==10||#st.index==11">			
										<td>￥<s:property value='%{numberFormat(#policy.sumamount/1000*#ratio,"#,##0")}'/></td>   
									</s:if>
								</s:iterator>	
								</tr>
							</table>
							<p>您还可根据个人情况，自由灵活地进行万能账户资金的支取以满足人生不同阶段资金需求，如求学、结婚、创业、置业以及退休养老等的。</p>
							<p>以上为本产利益的概要描述，更多内容请查看“产品说明书”或以保险合同条款为准。</p>
						</div>
					</s:if>
					<div class="result-head">如您已有相识的中宏保险营销员，请勾选并输入营销员编号，以便为您提供更多服务。</div>
					<div class="result-fill">
						<ul class="list form qt">
							<li class="row">
								<div class="form-checkbox col-sm-2 result-man-ck col-lg-2 text-center">
									<input type="checkbox" id="saleMan">
									<label for="saleMan"><i></i></label>
								</div>
								<label class="form-label col-sm-11 col-lg-11"><span>营销员编号</span></label>
								<div class="form-control col-sm-11 col-lg-11">
									<input class="form-input" type="text" id="code" autocomplete="off">
								</div>
							</li>
						</ul>
						<ul class="list form qt" id="saleManInfo">
							<li class="row">
								<div class="col-sm-2 col-lg-2"></div>
								<label class="form-label col-sm-11 col-lg-11"><span>营销员姓名</span></label>
								<div class="form-control col-sm-11 col-lg-11">
									<input class="form-input" type="text" id="name" readonly/>
								</div>
							</li>
							<li class="row">
								<div class="col-sm-2 col-lg-2"></div>
								<label class="form-label col-sm-11 col-lg-11"><span>营销服务部</span></label>
								<div class="form-control col-sm-11 col-lg-11">
									<input class="form-input" type="text" id="address" readonly/>
								</div>
							</li>
						</ul>
						<ul class="list form qt">
							<li class="row">
								<div class="form-checkbox col-sm-24 result-agree">
									<input type="checkbox" id="agree"  >
									<label for="agree"><i></i>我了解本保费试算功能使用的部分计算参数（如职业、健康情况等）为默认值，其计算所得的首期保费仅供参考，并不等同于本人实际投保时的应付保费金额。该保险产品的保险责任及责任免除等详细内容以保险合同约定为准。我愿意接受中宏保险及其授权的合作方向本人提供相关客户服务和推荐产品。</label>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="quote-action">
			<div class="container">
				 <form action="${ctx}/reservation/reservateSubmit" id="formChoose" method="post" >
				   <a class="btn insure qt" href="javascript:;" id="choose"><span>确认并返回</span></a>
			       <input type="hidden" id ="inputcode" name="salesMan.code" value="" />
			     </form>
			</div>
			<img class="bottom-tree hidden-sm" src="${ctx}/resources/image/common/tree.png"/>
		</div>
		<jsp:include page="../common/foot.jsp"></jsp:include>
		<jsp:include page="../common/common-modal.jsp"></jsp:include>
	</div>
</body>

</html>