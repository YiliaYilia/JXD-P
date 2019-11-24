<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ include file="../../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>瑞享安康</title>
<%@ include file="../../common/rels.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
<meta name="format-detection" content="telephone=no"/>
<link href="<%=request.getContextPath() %>/resources/css/common/main.min.css?${random}" rel="stylesheet"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/wjx/wjx.css" type="text/css"></link>
<script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
</head>
<style>
.loader8{font-size:50px;}
</style>
<body onload="backshow()">
<div class="wjx">
	<!--标题区域-->
  	<div class="nav txt16">
  		<div class="menu">填写信息</div>
  		<div class="menu" style="color:#fff;">确认信息</div>
  		<div class="menu">如实告知</div>
  		<div class="menu">在线缴费</div>
  		<div class="clear"></div>
  	</div>
  	<!-- 正文区域 -->
  	<section class="fillinfo_wrap">
  		<div class="title" style="margin: 15px auto 20px auto;">投保人信息</div>
  		<table>
  			<tr>
  				<td width="35%" class="left">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
  				<td width="65%">${applicantInsured.name}</td>
  			</tr>
  			<tr>
  				<td class="left">证件类型：</td>
  				<td>${applicantInsured.identifytype =="I"?"身份证":"户口簿"}</td>
  			</tr>
  			<tr>
  				<td class="left">证件号码：</td>
  				<td>${applicantInsured.identifynumber}</td>
  			</tr>
  			<tr>
  				<td class="left">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
  				<td>${applicantInsured.sex =="M"?"男":"女"}</td>
  			</tr>
  			<tr>
  				<td class="left">出生日期：</td>
  				<td id="applicantInsuredBirthday"></td>
  			</tr>
  			<tr>
  				<td class="left">证件有效期：</td>
  				<td>${idPhotoData.applicantInsured_endTime}</td>
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
		
		<div class="title">被保险人信息</div>
		<table>
			<c:if test="${age >= 18}">
			<tr>
  				<td class="noberder left" width="35%">被保险人：</td>
  				<td width="65%" class="noberder">被保险人与投保人为同一人</td>
  			</tr>
  			</c:if>
  			<c:if test="${age < 18}">
  			<tr>
  				<td width="35%" class="left">与投保人关系：</td>
  				<td width="65%">父母</td>
  			</tr>
  			<tr>
  				<td width="35%" class="left">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
  				<td width="65%">${recognizee.name}</td>
  			</tr>
  			<tr>
  				<td class="left">证件类型：</td>
  				<td>${recognizee.identifytype =="I"?"身份证":"户口簿"}</td>
  			</tr>
  			<tr>
  				<td class="left">证件号码：</td>
  				<td>${recognizee.identifynumber}</td>
  			</tr>
  			<tr>
  				<td class="left">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
  				<td>${sex}</td>
  			</tr>
  			<tr>
  				<td class="left">出生日期：</td>
  				<td>${birthday}</td>
  			</tr>
  			<tr>
  				<td class="left">证件有效期：</td>
  				<td>${idPhotoData.recognizee_endTime}</td>
  			</tr>
  			<tr>
  				<td class="left">手机号码：</td>
  				<td>${recognizee.mobile}</td>
  			</tr>
  			<tr>
  				<td class="left">电子邮箱：</td>
  				<td>${recognizee.email}</td>
  			</tr>
  			<tr>
  				<td class="noberder left">通讯地址：</td>
  				<td class="noberder">${recognizee.address}</td>
  			</tr>	
  			</c:if>
		</table>
		<div class="title">受益人信息</div>
  		<table>
  			<c:if test="${policy.islegalflag=='2'}">
  			<tr>
  				<td width="35%" class="noberder"><span style="display: block;margin-left: 17%;float: left;">身故保险金<br/>受益人：</span></td>
  				<td width="65%" class="noberder ">法定</td>
  			</tr>
  			</c:if>
  			<c:if test="${policy.islegalflag=='3'}">
  			<tr>
  				<td width="35%"><span style="display: block;margin-left: 17%;float: left;">身故保险金<br/>受益人：</span></td>
  				<td>指定</td>
  			</tr>
  				<c:if test="${not empty policy.bnfName1}">
  				<tr>
  					<td class="left">受益人一姓名：</td>
  					<td>${policy.bnfName1}</td>
  				</tr>	
  				<tr>
  					<td class="left">证件类型：</td>
  					<td>${lcbnf.IDType =="I"?"身份证":"户口簿"}</td>
  				</tr>
  				<tr>
  					<td class="left">证件有效期：</td>
  					<td>${lcbnf.IDExpDate}</td>
  				</tr>
  				<tr>
  					<td class="left">证件号码：</td>
  					<td>${policy.bnfIDNo1}</td>
  				</tr>
  				<tr>
  					<td class="left">性&emsp;&emsp;别：</td>
  					<td>${policy.bnfSex1  =="M"?"男":"女"}</td>
  				</tr>
  				<tr>
  					<td class="left">出生日期：</td>
  					<td>${policy.bnfBirthday1}</td>
  				</tr>
  				<tr>
  					<td class="left">与被保人关系：</td>
  					<td>${policy.relationToInsured1 =="PA"?"父母":policy.relationToInsured1=="SP"?"配偶":"子女"}</td>
  				</tr>
  				<tr>
  					<td class="left">受益顺序：</td>
  					<td>第一顺序受益人</td>
  				</tr>
  				<tr>
  					<td class="left">受益比例：</td>
  					<td>${policy.bnfLot1}%</td>
  				</tr>
  				</c:if>
  				<c:if test="${not empty policy.bnfName2}">
				<tr>
					<td class="left">受益人二姓名：</td>
					<td>${policy.bnfName2}</td>
				</tr>	
				<tr>
					<td class="left">证件类型：</td>
					<td>${lcbnf2.IDType =="I"?"身份证":"户口簿"}</td>
				</tr>
				<tr>
					<td class="left">证件有效期：</td>
					<td>${lcbnf2.IDExpDate}</td>
				</tr>
				<tr>
					<td class="left">证件号码：</td>
					<td>${policy.bnfIDNo2}</td>
				</tr>
				<tr>
					<td class="left">性&emsp;&emsp;别：</td>
					<td>${policy.bnfSex2  =="M"?"男":"女"}</td>
				</tr>
				<tr>
					<td class="left">出生日期：</td>
					<td>${policy.bnfBirthday2}</td>
				</tr>
				<tr>
					<td class="left">与被保人关系：</td>
					<td>${policy.relationToInsured2 =="PA"?"父母":policy.relationToInsured2=="SP"?"配偶":"子女"}</td>
				</tr>
				<tr>
					<td class="left">受益顺序：</td>
					<td>第一顺序受益人</td>
				</tr>
				<tr>
					<td class="left">受益比例：</td>
					<td>${policy.bnfLot2}%</td>
				</tr>
			</c:if>
			<c:if test="${not empty policy.bnfName3}">
				<tr>
					<td class="left">受益人三姓名：</td>
					<td>${policy.bnfName3}</td>
				</tr>	
				<tr>
					<td class="left">证件类型：</td>
					<td>${lcbnf3.IDType =="I"?"身份证":"户口簿"}</td>
				</tr>
				<tr>
					<td class="left">证件有效期：</td>
					<td>${lcbnf3.IDExpDate}</td>
				</tr>
				<tr>
					<td class="left">证件号码：</td>
					<td>${policy.bnfIDNo3}</td>
				</tr>
				<tr>
					<td class="left">性&emsp;&emsp;别：</td>
					<td>${policy.bnfSex3  =="M"?"男":"女"}</td>
				</tr>
				<tr>
					<td class="left">出生日期：</td>
					<td>${policy.bnfBirthday3}</td>
				</tr>
				<tr>
					<td class="left">与被保人关系：</td>
					<td>${policy.relationToInsured3 =="PA"?"父母":policy.relationToInsured3=="SP"?"配偶":"子女"}</td>
				</tr>
				<tr>
					<td class="left">受益顺序：</td>
					<td>第一顺序受益人</td>
				</tr>
				<tr>
					<td class="left">受益比例：</td>
					<td>${policy.bnfLot3}%</td>
				</tr>
			</c:if>
  			</c:if>
  		</table>
  		<div class="title">投保信息</div>
  		<div class="pay_info">
  			<div class="info_dtl txt16">
  				<span>保险期间：</span>
  				<input class="noberder" type="text" value='保终身' readonly="readonly"/>
  			</div>
  			<div class="info_dtl txt16">
  				<span style="width: 48%;">基本保险金额：</span>
  				<input style="width: 50%;" class="noberder" type="text" value="${index_policy.sumamount}0元" readonly="readonly"/>
  			</div>
  			<div class="info_dtl txt16">
  				<span>缴费期限：</span>
  				<input class="noberder" type="text" id="payYear" readonly="readonly"/>
  			</div>
  			<div class="info_dtl txt16">
  				<span>首期保险费：</span>
  				<input class="noberder" type="text" value="${index_policy.sumbasepremium}0元 " readonly="readonly"/>
  			</div>
  			<div class="clear"></div>
  		</div>
  		
  		<div class="title">缴费信息</div>
				<table >
					 <tr>
						<td class="left noberder" width="35%">支付方式：</td>	
						<td class="noberder"  width="65%">银行代扣</td>
					</tr>
				</table>
  		<div class="title">推荐人信息</div>
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
	 				我已阅读
	 				<a href="<%=request.getContextPath()%>/resources/pdf/rxak/rxak_notice.pdf">《人身保险投保提示、人身保险产品风险提示书、投保须知、自动转账授权声明及客户声明》</a>、 
	 				<a href="<%=request.getContextPath()%>/resources/pdf/rxak/rxak_article.pdf"">《瑞泰瑞享安康重大疾病保险合同条款》</a>，理解并同意其全部内容。 
	 			</span>
	 		</td>
	 		</tr>
	 		</table>
  		</div>
  		
  	</section>
  	
  	 <!-- 按钮区域 -->
   	<section class="btn_wrap">
   		<div class="one_btn txt22" onclick="toNotice();">下一步</div>
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
	<script src="<%=request.getContextPath() %>/resources/lib/common/main.js?${random}"></script>
 	<script src="<%=request.getContextPath() %>/resources/lib/component/modal.js"></script>
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
	
	$(function(){
		$("#applicantInsuredBirthday").html(GMTToStr('${applicantInsured.birthday}'));
		$("#payYear").val(changepayYear('${index_policy.payYear}')); 
 	})
	
	//下一步前往告知页面
	function toNotice(){
		modal_loading();
		var flag = document.getElementById("checkboxsure").checked;
		if(!flag){
			modal_loading('hide');
			alert("请您阅读《人身保险投保提示、人身保险产品风险提示书、投保须知、客户声明及自动转账授权声明》、《瑞泰瑞享安康重大疾病保险合同条款》。");
			return;
		}else{
		  	modal_loading();
			document.getElementById("checkboxsure").checked=false;
			window.location.href ='<%=request.getContextPath()%>/msl/sales/RXAKtoNotice';
		}
	  }
	  
	function changepayYear(payYear){
		if(payYear == "0"){
			return "趸交";
		}else{
			return payYear+"年";	
		}
	}
	
	function backshow(){
		var checked = $("#checkboxsure").prop("checked");
		if(checked){
			$("#checkboxsure").next().find(".checked_img").show();
		}
	}
	
	function GMTToStr(time){
		var date = new Date(time)
		var Str=date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
    	return Str;
	}
</script>
</html>