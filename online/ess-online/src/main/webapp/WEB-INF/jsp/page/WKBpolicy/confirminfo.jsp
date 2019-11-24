<%@ include file="../../common/taglibs.jsp"%>
﻿﻿﻿﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<!DOCTYPE html>
<html>
<head>
<title>稳康宝</title>
<%@ include file="../../common/rels.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
<meta name="format-detection" content="telephone=no"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/wjx/wjx.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/wkb/wkb.css" type="text/css"></link>
<script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
</head>
<style>
.loader8{font-size:50px;}
@media (max-width: 370px) {
	.fillinfo_wrap{font-size:0.8em;}
}
</style>
<body onload="backshow()">
<div class="wkb">
	<!--标题区域-->
  	<div class="wkbnav txt16">
  		<div class="menu">填写信息</div>
  		<div class="menu">健康告知</div>
  		<div class="menu" style="color:#fff;">确认投保</div>
  		<div class="menu">在线缴费</div>
  		<div class="clear"></div>
  	</div>
  	<!-- 正文区域 -->
  	<section class="fillinfo_wrap fillinfo_top">
  		<div class="wkb_title" style="margin: 15px auto 20px auto;">投保人信息</div>
  		<table>
  			<tr>
  				<td width="35%" class="left">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
  				<td width="65%">${applicantInsured.name}</td>
  			</tr>
  			<tr>
  				<td class="left">身份证号：</td>
  				<td>${applicantInsured.identifynumber}</td>
  			</tr>
  			<tr>
  				<td class="left">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
  				<td>${sex1}</td>
  			</tr>
  			<tr>
  				<td class="left">出生日期：</td>
  				<td>${birthday1}</td>
  			</tr>
  			<tr>
  				<td class="left">手机号码：</td>
  				<td>${applicantInsured.mobile}</td>
  			</tr>
  			<tr>
  				<td class="left">电子邮箱：</td>
  				<td>${applicantInsured.email}</td>
  			</tr>
  			<tr>
  				<td class="noberder left">通讯地址：</td>
  				<td class="noberder">${applicantInsured.address}</td>
  			</tr>
  		</table>
  		
  		<!-- <div class="checkbox_div txt14">
 			<input type="checkbox"/><div class="checkbox"><span class="checked_img"></span></div>
 			<span>作为常用投保人</span>
  		</div> -->
  	<div class="wkb_title">被保险人信息</div>
  	<table>
  		<tr>
  			<td class="noberder left" width="35%">被保险人：</td>
  			<td width="65%" class="noberder">被保险人与投保人为同一人</td>
  		</tr>
  	</table>
  	<div class="wkb_title">受益人信息</div>
  	<table>
  		<tr>
  			<td class="noberder" width="35%"><span style="display: block;margin-left: 17%;float: left;">身故保险金<br/>受益人：</span></td>
  			<td class="noberder" width="65%">法定</td>
  		</tr>
  	</table>
  	
  	<div class="wkb_title">投保信息</div>
  		<div class="pay_info">
  			<div class="info_dtl txt16">
  				<span>保险期间：</span>
  				<c:if test="${policyI.unitcount=='1'}">
  					<input class="noberder" type="text" value="30年" readonly="readonly"/>
  				</c:if>
  				<c:if test="${policyI.unitcount=='2'}">
  				<input class="noberder" type="text" value="至80周岁" readonly="readonly"/>
  				</c:if>
  			</div>
  			<div class="info_dtl txt16">
  				<span>基本保险金额：</span>
  				<input class="noberder" type="text" value="${policyI.sumamount}元" readonly="readonly"/>
  			</div>
  			<div class="info_dtl txt16">
  				<span>交费期限：</span>
  				<input class="noberder" type="text" value="10年" readonly="readonly"/>
  			</div>
  			<div class="info_dtl txt16">
  				<span>首期保险费：</span>
  				<input class="noberder" type="text" value="${policyI.sumbasepremium}元 " readonly="readonly"/>
  			</div>
  		</div>
  		
  		
  		
  		<div class="wkb_title">缴费信息</div>
			<c:if test="${policy.billingType eq 'N'}">
				<table >
					<tr>
						<td class="left" width="35%">支付方式：</td>	
						<td width="65%">微信支付</td>
					</tr>
				</table>
			</c:if>
		 	<c:if test="${policy.billingType eq 'Y'}">
				<table >
					 <tr>
						<td class="left" width="35%">支付方式：</td>	
						<td width="65%">银行代扣</td>
					</tr>
					 <tr>
						<td class="left">缴费银行：</td>
						<td>
							<c:if test="${policy.bankBranchCode eq '100102'}">工商银行</c:if>
							<c:if test="${policy.bankBranchCode eq '100103'}">农业银行</c:if>
							<c:if test="${policy.bankBranchCode eq '100104'}">中国银行</c:if>
							<c:if test="${policy.bankBranchCode eq '100105'}">建设银行</c:if>
							<c:if test="${policy.bankBranchCode eq '100302'}">中信银行</c:if>
							<c:if test="${policy.bankBranchCode eq '100303'}">光大银行</c:if>
							<c:if test="${policy.bankBranchCode eq '100304'}">华夏银行</c:if>
							<c:if test="${policy.bankBranchCode eq '100305'}">民生银行</c:if>
							<c:if test="${policy.bankBranchCode eq '100307'}">深发/平安银行</c:if>
							<c:if test="${policy.bankBranchCode eq '100308'}">招商银行</c:if>
							<c:if test="${policy.bankBranchCode eq '100309'}">兴业银行</c:if>
							<c:if test="${policy.bankBranchCode eq '100310'}">浦发银行</c:if>
							<c:if test="${policy.bankBranchCode eq '100306'}">广发银行</c:if>
							<c:if test="${policy.bankBranchCode eq '090004'}">中信银行信用卡</c:if>
							<c:if test="${policy.bankBranchCode eq '100403'}">邮政储蓄银行</c:if>
						</td>
					</tr>
					<tr>
						 <td class="left" style="width:40%">开户行所在地：</td>
						 <td>${policy.bankProvince}省${policy.bankCity}市</td>
					</tr>
					<tr>
						 <td class="left" >银行账号：</td>
						 <td>${policy.bankAccountNumber} </td>
					</tr>  
					<tr><td colspan="2" class="left"><img src="<%=request.getContextPath()%>/resources/image/wjx/star.png"/>
					投保人声明及授权：我同意授权瑞泰人寿根据保险合同约定的保费金额和交费方式委托银行从上述账户划款。如果我提供的账户是凭印鉴或密码支取，则我将同意并授权委托银行在划转保险费时免于核对该账户中的印鉴或密码。</td></tr>
				</table>
			</c:if> 
		<div class="wkb_title">续期缴费信息</div>
					<table >
						 <tr>
							<td class="left" style="width:40%">缴费银行：</td>
							<td>
								<c:if test="${policy.bankBranchCode eq '100102'}">工商银行</c:if>
								<c:if test="${policy.bankBranchCode eq '100103'}">农业银行</c:if>
								<c:if test="${policy.bankBranchCode eq '100104'}">中国银行</c:if>
								<c:if test="${policy.bankBranchCode eq '100105'}">建设银行</c:if>
								<c:if test="${policy.bankBranchCode eq '100302'}">中信银行</c:if>
								<c:if test="${policy.bankBranchCode eq '100303'}">光大银行</c:if>
								<c:if test="${policy.bankBranchCode eq '100304'}">华夏银行</c:if>
								<c:if test="${policy.bankBranchCode eq '100305'}">民生银行</c:if>
								<c:if test="${policy.bankBranchCode eq '100307'}">深发/平安银行</c:if>
								<c:if test="${policy.bankBranchCode eq '100308'}">招商银行</c:if>
								<c:if test="${policy.bankBranchCode eq '100309'}">兴业银行</c:if>
								<c:if test="${policy.bankBranchCode eq '100310'}">浦发银行</c:if>
								<c:if test="${policy.bankBranchCode eq '100306'}">广发银行</c:if>
								<c:if test="${policy.bankBranchCode eq '090004'}">中信银行信用卡</c:if>
								<c:if test="${policy.bankBranchCode eq '100403'}">邮政储蓄银行</c:if>
							</td>
						</tr>
						<tr>
						<td class="left" >开户行所在地：</td>
							 <td >${policy.bankProvince}省${policy.bankCity}市</td>
						</tr>
						<tr>
							 <td class="left" >银行账号：</td>
							 <td>${policy.bankAccountNumber}</td>
						</tr>  
						<tr><td colspan="2" class="left"><img src="<%=request.getContextPath()%>/resources/image/wjx/star.png"/>
						投保人声明及授权：我同意授权瑞泰人寿根据保险合同约定的保费金额和交费方式委托银行从上述账户划款。如果我提供的账户是凭印鉴或密码支取，则我将同意并授权委托银行在划转保险费时免于核对该账户中的印鉴或密码。</td></tr>
					</table>
  		
  		<div class="wkb_title">推荐人信息</div>	
  		<div class="pay_info">
  			<div class="info_dtl txt16 recommend">
	  			<span>推荐人编码：</span>
	  			<input class="noberder" type="text" style="width: 40%;" value="${policy.agentcode}" readonly="readonly"/>
  			</div>
  		</div>
  		
  		<div class="checkbox_div txt16">
	 		<table>
		  		<tr>
		  			<td width="10%" class="noberder"><input type="checkbox" id="checkboxsure"/><div class="checkbox" ><span class="checked_img"></span></div></td>
		 			<td class="noberder">	
		 			<span>
	 					我已阅读<a href="../../resources/pdf/wkb/wkb_notice.pdf">《人身保险投保提示、人身保险产品风险提示书、瑞泰附加稳康宝癌症疾病保险产品特别提示、投保须知、自动转账授权声明及客户声明》</a>、<a href="../../resources/pdf/wkb/wkb_article.pdf">《瑞泰稳康宝两全保险条款、瑞泰附加稳康宝癌症病症保险条款》</a>，理解并同意其全部内容。 
	 				</span>
	 				</td>
	 			</tr>
	 		</table>
  		</div>
  	</section>
  	
  	 <!-- 按钮区域 -->
   	<section class="btn_wrap">
   	<c:choose>
		<c:when test="${policy.billingType=='Y'}">
			<div class="one_btn txt22" onclick="underwriting()">确认投保</div>
		</c:when> 
		<c:otherwise>
			<div class="one_btn txt22" onclick="underwriting()">在线支付</div>
		</c:otherwise> 
	</c:choose>
   	</section>
    <div class="footer">
		<div class="img_div"><img class="logoimg" src="<%=request.getContextPath() %>/global/global/images/logo.png"></div>
		<div class="addr_div txt10">
			<div class="foot_span">客户服务专线：4008109339</div>
			<div class="foot_span">网址：www.oldmutual-chnenergy.com</div>
		</div>
	<div class="clear"></div>
	</div> 
</div>
<jsp:include page="../../common/common-modal.jsp"></jsp:include>
</body>
<script>
	$(".checkbox").click(function(){
		if($(this).prev().prop("checked")==false){
			$(this).find(".checked_img").show();
			$(this).prev().prop("checked",true);
		}else{
			$(this).find(".checked_img").hide();
			$(this).prev().prop("checked",false);
		}
	});
	
	
	

	  //核保
	  function underwriting(){
	  		 modal_loading();
		  var flag = document.getElementById("checkboxsure").checked;
		  
		  if(!flag){
			  alert("请您阅读《人身保险投保提示、瑞泰附加稳康宝癌症疾病保险产品、人身保险产品风险提示书、投保须知、客户声明及自动转账授权声明》、《瑞泰稳康宝两全保险条款、瑞泰附加稳康宝癌症病症保险条款》。");
			  modal_loading('hide');
			  return;
		  }else{
		  	modal_loading();
			  $.ajax({
				   type:"POST",
				   url:"<%=request.getContextPath()%>/msl/sales/WKBinsureSubmit",
				   data:{
				   },
				   dataType:"json",
				   success:function(data){
					   if(data.flag=="0"){
						   alert("核保成功，测试环境跳过支付");
						   document.getElementById("checkboxsure").checked=false;
						   <%-- window.location.href ='<%=request.getContextPath()%>/msl/sales/pay'; --%>
						   window.location.href ='<%=request.getContextPath()%>/msl/sales/WKBtoTestSuccess?source=TAWENKB-R';
					   }else if(data.flag=="1"){
					   		modal_loading('hide');
						    alert(data.content);
					   }else if(data.flag=="2"){
						 window.location.href ='<%=request.getContextPath()%>/msl/sales/WKBtoBankSuccess';
					   }
					}
				});   
		  }
	  }
	
	  function backshow(){
		var checked = $("#checkboxsure").prop("checked");
		if(checked){
			$("#checkboxsure").next().find(".checked_img").show();
		}
	  }
</script>
</html>