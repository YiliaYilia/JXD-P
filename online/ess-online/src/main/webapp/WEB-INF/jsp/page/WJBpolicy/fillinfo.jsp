﻿﻿﻿﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ include file="../../common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
<meta name="format-detection" content="telephone=no"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/wjb/wjb.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/wkb/wkb.css" type="text/css"></link>
<script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/wjb/wjbJobCode.js?v=2"></script>
<script src="<%=request.getContextPath()%>/resources/js/wjb/wjbArea.js?v=1"></script>
<title>稳驾保</title>
</head>
 
<body onload="init();init2();_init_job();">
<div class="wjb">
<!--标题区域-->
  	<div class="nav txt16">
  		<div class="menu" style="color:#fff;">填写信息</div>
  		<div class="menu">健康告知</div>
  		<div class="menu">确认投保</div>
  		<div class="menu">在线缴费</div>
  		<div class="clear"></div>
  	</div>
  	<!-- 正文区域 -->
  	<form action="<%=request.getContextPath()%>/msl/sales/WJBInsureInput" method="post" id="creator" name="creator">
  	<section class="fillinfo_wrap fillinfo_top">
  	<div class="title">理财顾问信息</div>
  		<table class="txt16" >
			<tr>
  				<td width="35%" class="noberder" style="text-indent: 5%;" >
  				<c:if test="${isAgentCode=='1'}"><span class="must">*</span></c:if>
  				理财顾问编码：</td>
  				<td width="65%" class="noberder">
  					<input type="text" style="width: 65%;font-size:1.2em;" id="policy.agentcode" name="policy.agentcode" value="${policy.agentcode}" onblur="onchangeArea();"/>
  					<input type="hidden" id="policy.deptid" name="policy.deptid" value="${policy.deptid}"/>
					<c:if test="${isAgentCode=='0'}"><span style="padding-left: 0px;width: 30%;">（选填）</span></c:if>
  				</td>
  			</tr>
		</table>
  	<div class="title" style="margin: 15px auto 20px auto;">投保人信息</div>
  	<c:if test="${!empty comAppList}">
	  		<table class="common_info txt14">
	  			<tr>
	  				<td colspan="5">
	 					<span>常用投保人</span>
	  				</td>
	  			</tr>
	  			<c:forEach var="comAppList" items="${comAppList}"> 
	  			<tr>
	  				<td width="20%" align="left">
						<div class="checkbox_div txt14" style="margin: 0;">
				 			 <input class="comChoose" type="checkbox" id ="comChoose" name=""/><div class="checkbox checkboxCom"><span class="checked_img"></span></div> 
				 		 	 <input class="comName" type="hidden" name="comName" value="${comAppList.name}" >
					 		 <input class="comIdno" type="hidden" name="comIdno" value="${comAppList.idno}" >
					 		 <%--  <input class="comSex" type="hidden" name="comSex" value="${comAppList.sex}" >
					 		 <input class="comBirthday" type="hidden" name="comBirthday" value="${comBirthday}" > --%>
					 		 <input class="comMobile" type="hidden" name="comMobile" value="${comAppList.mobile}" >
					 		 <input class="comEmail" type="hidden" name="comEmail" value="${comAppList.email}" >
				 		</div>
				 		<span>${comAppList.name}</span>
					</td>
	  			</tr>
	  			</c:forEach>
	  		</table>
  		</c:if>
  		<table>
  			<tr>
  				<td width="35%" class="left" style="text-indent: 5%;"><span class="must">*</span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
  				<td width="65%"><input id="applicantInsured.name" name="applicantInsured.name" type="text" value="${applicantInsured.name}"/></td>
  			</tr>
  			<tr>
	  			<td class="txt14" style="text-indent: 5%"><span class="must">*</span>职&emsp;&emsp;业：</td>
  				<td>
  					<div class="addr_div">
  						<div class="select_div">
  							<select id="industry" name="industry" class="txt14"></select> 
  						</div>
  						<div class="select_div">
  							<select id="job" name="job" class="txt14"></select> 	
  						</div>	
  					</div>
  					<p style="color: red; font-size:0.8em;word-break:break-all;">注：离退休人员、家庭主妇、待业人员：本险种与稳驾行的累计保额上限10万。</p>
  				</td>
	  		</tr>
	  		<c:if test="${sex=='女'}">
	  		<tr>
	  			<td class="txt14" style="text-indent: 5%"><span class="must">*</span>孕&emsp;&emsp;妇：</td>
  				<td>
  					<select id="yfCode" name="yfCode" class="txt14">
	  					 	<option value="">请选择是否</option>
	  					 	<option value="Y">是</option>
	  					 	<option value="N">否</option>
  					</select> 	
  					<p style="color: red; font-size:0.8em;word-break:break-all;">注：孕妇本险种与稳驾行的累计保额上限10万。</p>
  				</td>
	  		</tr>
	  		</c:if>
  			<tr>
  				<td width="35%" class="left" style="text-indent: 5%;"><span class="must">*</span>身份证号码：</td>
  				<td>
  					<input type="hidden" id="applicantInsured.identifytype" name="applicantInsured.identifytype" value="I"/>
  					<input type="text" id="applicantInsured.identifynumber" name="applicantInsured.identifynumber"  value="${idno}"/>
  				</td>
  			</tr>
  			<tr>
  				<td class="left">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
  				<td>
  					<input type="text" id="applicantInsured.sex" name="applicantInsured.sex" readonly="readonly" value="${sex}" style="background: #E9E9E9"/>
  				</td>
  			</tr>
  			
  			<tr>
  				<td class="left">出生日期：</td>
  				<td>
  					<input type="text" id="applicantInsured.birthday" class="birthdayDate" name="applicantInsured.birthday" value="${birthday}" readonly="readonly" style="background: #E9E9E9"/>
  					<!-- <input type="text" class="birthdayDate date_query_input"/>  -->
  				</td>
  			</tr>
  			<tr>
  				<td class="left" style="text-indent: 5%;"><span class="must">*</span>手机号码：</td>
  				<td><input type="text" id="applicantInsured.mobile" name="applicantInsured.mobile" value="${applicantInsured.mobile}"/></td>
  			</tr>
  			<tr>
  				<td class="left" style="text-indent: 5%;"><span class="must">*</span>电子邮箱：</td>
  				<td><input type="text" id="applicantInsured.email" name="applicantInsured.email" value="${applicantInsured.email}"/></td>
  			</tr>
  			<tr>
  				<td class="noberder left" style="text-indent: 5%;"><span class="must">*</span>通讯地址：</td>
  				<td class="noberder">
  					<div class="addr_div">
  						<div class="select_div">
		  					<select name="province" id="province" onchange ="select();"></select>
	  					</div>
	  					<div class="select_div">
	  						<select name="city" id="city" onchange = "select();"></select>
  						</div>
  					</div>
  					<div class="input_div">
	  						<input id="conty" name="conty" type="text" style="width:65%"/>
	  						<span>区/县</span>
  					</div>
  					<div class="addr_div"><input id="detail_addr" name="detail_addr" type="text" style="margin:5px auto" placeholder="请填写详细地址"/></div>
  					<input type="hidden" id="applicantInsured.address" name="applicantInsured.address" value="${applicantInsured.address}" />
  				</td>
  			</tr>
  		</table>
  		
  		<div class="checkbox_div txt14" id="commonApp">
 			 <input type="checkbox" id ="commonApplicant.flag" name="commonApplicant.flag"/><div class="checkbox"><span class="checked_img"></span></div> 
  		</div>
  		<span class="makeComApp">作为常用投保人</span>
  		<div class="clear"></div>
  	
  	<div class="title">被保险人信息</div>
	<table>
		<tr>
			<td class="noberder left" width="35%">被保险人：</td>
			<td width="65%" class="noberder">被保险人与投保人为同一人</td>
		</tr>
	</table>
	<div class="title">受益人信息</div>
	<table>
		<tr>
			<td class="noberder" width="35%"><span style="display: block;float: left;margin-left: 17%;">身故保险金<br/>受益人：</span></td>
			<td class="noberder" width="65%">法定</td>
		</tr>
	</table>
  	
  
  	<div class="title">缴费信息</div>
	<div class="radio_div" id="bankcheck">
	    <table  class="txt16">
		 	<tr>
				<c:if test="${policy1.sumbasepremium<=3000}">
					<td width="5%"><span class="must">*</span></td>
					<td width="2%">
						<input type="radio"  name="policy.BillingType"    class="BillingType" value="N" ></input><span class="checked_img"  id="BillingTypewechat"></span>
					</td>
					<td width="40%">
						<span>微信支付</span>	
					</td>
				</c:if>
				<td width="2%">	
					<input type="radio" name="policy.BillingType"  class="BillingType" value="Y"/><span class="checked_img" id="BillingTypebank" ></span>
				</td>
				<td><span>银行代扣</span></td>
			</tr>	
		</table>
	 </div>
	<div style="display:none;" id="divID">
		<table class="txt16"  >
			<tr>
				<td class="noberder" style="text-indent: 5%;"><span class="must">*</span>缴费银行：</td>
				<td class="noberder">
					<select id="BankBranchName"  onchange="BankBranchRl();" style="width: 95%;">
						<option value="130102">工商银行</option>
						<option value="100103">农业银行</option>
 						<option value="130104">中国银行</option>
 						<option value="130105">建设银行</option>
						<option value="130308">招商银行</option>
<!-- 					<option value="100305">民生银行</option> -->
						<option value="100307">平安银行</option>
						<option value="100310">浦发银行</option>
						<!--<option value="100309">兴业银行</option>-->
						<option value="100303">光大银行</option>
						<!--<option value="100304">华夏银行</option>-->
						<option value="100306">广发银行</option>
<!-- 					<option value="100302">中信银行</option> -->
						<!-- <option value="090004">中信银行信用卡</option>  -->
						<option value="100403">邮政储蓄银行</option>
						<option value="100301">交通银行</option>
					</select>
					<input type="hidden" id="bankBranchNamevalue" name="policy.BankBranchCode"/>
				 </td>
			</tr>
			<tr>
				 <td  class="noberder" style="text-indent: 5%;" ><span class="must">*</span>开户行所<br/>&nbsp;&nbsp;&nbsp;&nbsp;在&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地：</td>
				 <td>
					<select style="width: 30%;" name="policy.BankProvince"id="payBankProvinceAddress" onchange="BankBranch();BankBranchRl();"></select>
					<span>省</span>
					<select style="width: 40%;" name="policy.BankCity" id="paybankCityAddress" onchange="BankBranch();BankBranchRl();"></select>
					<span>市</span>
					</td>
			</tr>
			<tr>
				 <td class="noberder" width="35%" style="text-indent: 5%;height: 40px;"><span class="must">*</span>银行账号：</td>
				 <td class="noberder" width="65%" style="height: 40px;">
					<input type="text" placeholder="填写投保人的银行账号" style="width: 95%;font-size: 0.875em;" id="AccountNumber" onchange="BankBranchRl();"/>
					<input type="hidden"  name="policy.bankAccountNumber" id="AccountNumbervalue" value="${policy.bankAccountNumber}"/>
				 </td>
			</tr> 
		</table>
			<div class="pay_info">	
			    <div class="state_div txt14">
						<p>
						<img src="<%=request.getContextPath()%>/resources/image/wjx/star.png"/>
						投保人声明及授权：我同意授权瑞泰人寿根据保险合同约定的保费金额和交费方式委托银行从上述账户划款。如果我提供的账户是凭印鉴或密码支取，则我将同意并授权委托银行在划转保险费时免于核对该账户中的印鉴或密码。
						</p>
				</div>
			</div>
	 </div>	
	
  	
	<div class="title" id="XQpayment">续期缴费信息</div>
	<table class="txt16" id="XQTab">
		<tr class="renew">
			<td class="noberder" style="text-indent: 5%;"><span class="must">*</span>缴费银行：</td>
			<td class="noberder">
				<input type="hidden"  name="policy.bank" id="bankvalue" value="${policy.bank}"/>
				<select id="policy.bank" 
							 style="width: 95%;" class="bank">
								<option value="130102">工商银行</option>
									<option value="100103">农业银行</option>
 									<option value="130104">中国银行</option>
 									<option value="130105">建设银行</option>
									<option value="130308">招商银行</option>
<!-- 									<option value="100305">民生银行</option> -->
									<option value="100307">平安银行</option>
									<option value="100310">浦发银行</option>
									<!--<option value="100309">兴业银行</option>-->
									<option value="100303">光大银行</option>
									<!--<option value="100304">华夏银行</option>-->
									<option value="100306">广发银行</option>
<!-- 									<option value="100302">中信银行</option> -->
									<!-- <option value="090004">中信银行信用卡</option>  -->
									<option value="100403">邮政储蓄银行</option>
									<option value="100301">交通银行</option>
				</select>
			</td>
		</tr>
		<tr class="payment">
			<td class="noberder" style="text-indent: 5%;"><span class="must">*</span>缴费银行：</td>
				<td class="noberder"><input class="renewalbank" id="renewalbank" /></td>
		</tr>
		<tr class="renew">
					 <td  class="noberder" style="text-indent: 5%;" ><span class="must">*</span>开户行所<br/>&nbsp;&nbsp;&nbsp;&nbsp;在&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地：</td>
						<td><select style="width: 35%;" name="bankProvinceAddress"
							id="bankProvinceAddress" onchange="select();" ></select> <span>省</span>
							<select style="width: 40%;" name="bankCityAddress"
							id="bankCityAddress" onchange="select();"></select> <span>市</span>
							<input type="hidden" id="policy.bankProvince"
							name="policy.bankProvince" value="${policy.bankProvince}" /> <input
							type="hidden" id="policy.bankCity" name="policy.bankCity"
							value="${policy.bankCity}" /></td>
		</tr>
		<tr class="payment">
			<td class="noberder" id="bankAddress" width="35%" >开户行所在地：</td>
			<td>
				<input type="text" id="renewalbankProvince" class="bankProvince" style="width:35%;text-align:center;"/><span>省</span>
				<input type="text" id="renewalbankCity" class="bankCity" style="width: 45%;text-align: center;"/><span>市</span>
			</td>
		</tr>
		<tr class="paymentno">
			<td class="noberder" width="35%" style="text-indent: 5%;height: 40px;"><span class="must">*</span>银行账号：</td>
			<td class="noberder" width="65%" style="height: 40px;">
				<input type="text" placeholder="填写投保人的银行账号" style="width: 95%;font-size: 0.875em;" class="bankAccountNumber"  id="policy.bankAccountNumber"  value="${policy.bankAccountNumber}"/>
			</td>
		</tr>
	</table>
	<div class="pay_info" id="XQStatement">	
 		<div class="state_div txt14">
  			<p>
  			<img src="<%=request.getContextPath()%>/resources/image/wjx/star.png"/>
  			投保人声明及授权：我同意授权瑞泰人寿根据保险合同约定的保费金额和交费方式委托银行从上述账户划款。如果我提供的账户是凭印鉴或密码支取，则我将同意并授权委托银行在划转保险费时免于核对该账户中的印鉴或密码。
  			</p>
 		</div>
 	</div>
 	<div class="title">声明信息</div>
 		</section>
  </form>	
  
  
  <div class="info_table txt14">
 		<table>
  		<tr>
	 		<td  colspan="2" style="text-indent:0;">	
				本人声明：
			</td>
		</tr>
		<tr>
			<td class="noberder"><input type="checkbox" id="checkboxsure" />
	  			<div class="checkbox_a" ><span class="checked_img"></span></div></td>
			<td>本人仅为中国大陆税收居民<br/></td>
		</tr>
		<tr>
			<td  colspan="2" style="text-indent:0;">温馨提示：<br/></td>
		</tr>
		<tr id="reminderAB">
			<td  colspan="2" style="text-indent:0;">1、中国税收居民是指在中国境内有住所，或者无住所而在境内居住满一年的个人，不含港澳台地区，因此我司又称中国大陆税收居民……<a onclick="showAll();" style="color:blue;">&nbsp;&nbsp;显示更多</a></td>
		</tr>
		<tr id="remindertotalOne" style="display:none;">
			<td  colspan="2" style="text-indent:0;">1、中国税收居民是指在中国境内有住所，或者无住所而在境内居住满一年的个人，不含港澳台地区，因此我司又称中国大陆税收居民。在中国境内有住所是指因户籍、家庭、经济利益关系而在中国境内习惯性居住。在境内居住满一年，是指在一个纳税年度中在中国境内居住365日。临时离境的，不扣减日数。临时离境，是指在一个纳税年度中一次不超过30日或者多次累计不超过90日的离境。</td>
		</tr>
		<tr id="remindertotalTwo" style="display:none;">
			<td  colspan="2" style="text-indent:0;">2、非居民是指中国大陆税收居民以外的个人、企业和其他组织、但不包括政府机构、国际组织、中央银行、金融机构或者在证券市场上市交易的公司及其关联机构。前述证券市场是指被所在地政府认可和监管的证券市场。其他辖区税收居民个人有关判定依据及纳税人识别号相关信息请参见国家税务总局网站（www.chinatax.gov.cn）。</td>
		</tr>
		</table>
		
	</div>
  
  	 <!-- 按钮区域 -->
   	<section class="btn_wrap">
   		<div class="one_btn txt22" onclick="save();">下一步</div>
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
	$(".checkbox_a").click(function(){
		if($(this).prev().prop("checked")==false){
			$(this).find(".checked_img").show();
			$(this).prev().prop("checked",true);
		}else{
			$(this).find(".checked_img").hide();
			$(this).prev().prop("checked",false);
		}
	});
</script>
<script type="text/javascript">
brNo1="${brNo}";
 function getObj(id){
	return document.getElementById(id).value;
}

	//校验
function check(){
		var isAgentCode ="${isAgentCode}";
		var agentCode = getObj("policy.agentcode");
		var reg =  /^[a-zA-Z0-9]+$/;
		var applicantInsuredname = getObj("applicantInsured.name");//投保人姓名
		var applicantInsuredidentifynumber = getObj("applicantInsured.identifynumber");//投保人证件号
		var bankProvince = document.getElementById("bankProvinceAddress").value=="省/市"?"":document.getElementById("bankProvinceAddress").value;//开户行地址
		var bankCity = document.getElementById("bankCityAddress").value=="市/区"?"":document.getElementById("bankCityAddress").value;//开户行地址
		var payBankProvince = document.getElementById("payBankProvinceAddress").value=="省/市"?"":document.getElementById("payBankProvinceAddress").value;//开户行地址
		var paybankCity = document.getElementById("paybankCityAddress").value=="市/区"?"":document.getElementById("paybankCityAddress").value;//开户行地址
		var province = document.getElementById("province").value=="省/市"?"":document.getElementById("province").value;//投保人地址
		var city = document.getElementById("city").value=="市/区"?"":document.getElementById("city").value;//投保人地址
		var conty = document.getElementById("conty").value==null?"":document.getElementById("conty").value;//投保人地址 区/县
		var detail_addr = document.getElementById("detail_addr").value==null?"":document.getElementById("detail_addr").value;//投保人地址
		var addressTemp = province+city+conty+"区/县"+detail_addr;//投保人地址
		var industry = $("#industry").val();	//行业
	    var job = $("#job").val();	//职业
		var regExp = /<\/?[^>]+>/gi; 
		var address =  addressTemp.replace(regExp,""); 
		var recognizeeSex = null;
		
		if('${sex}' == '男'){
			recognizeeSex = 'M';
		}else{
			recognizeeSex = 'F';
		}
		if(applicantInsuredname==""||applicantInsuredname.length==0){
			alert("请输入投保人姓名");
			return false;
		}else if(!/^[a-zA-Z ]{3,20}$/.test(applicantInsuredname)&&!/^[\u4e00-\u9fa5]{2,10}$/.test(applicantInsuredname)){
			alert("请输入正确的投保人姓名");
			return false;
		}
		//职业验证
   		if(industry=="行业分类"||job=="职业类型"){
   			alert("请选择您的职业类型");
   			return false;
   		}
		//孕妇校验
		var yfCode = $("#yfCode").val();
		if(recognizeeSex=="F"&&yfCode==""){
			alert("请选择您是否为孕妇");
			return false;
		}
		//保额超限校验
		var sumamount = '${policy1.sumamount}';
		if(yfCode=="Y" && sumamount=="200000.0"){
			alert("孕妇、离退休人员、家庭主妇、待业人员：本险种与稳驾行的累计保额上限10万。");
			return false;
		}
		if(job=="待业人员" || job=="家庭主妇" || job=="退休人员"){
			if(sumamount=="200000.0"){
				alert("孕妇、离退休人员、家庭主妇、待业人员：本险种与稳驾行的累计保额上限10万。");
				return false;
			}
		}
		
		if(applicantInsuredidentifynumber==""||applicantInsuredidentifynumber.length==0){
			alert("请输入投保人证件号");
			return false;
		}else{
			if(!IdentityCodeValid(applicantInsuredidentifynumber,false)){
				return false;
			}
			var start = getBirth(applicantInsuredidentifynumber);
			var br =  getObj("applicantInsured.birthday");//取得生日
			if(start!=br){
				alert("投保人身份证号码与生日不相符");
				return false;
			}else if(getSex(applicantInsuredidentifynumber)!=recognizeeSex){
				alert("投保人身份证号码与性别不相符");
				return false;
			}
		}
		//校验手机
		var phone = getObj("applicantInsured.mobile");
		var re1 = /^0?1[3|7|5|8][0-9]\d{8}$/;
	  	if(!re1.test(phone)){
	  		alert("请输入正确的手机号码");
			return false;
	 	}
		
	  	
	  	//校验邮箱
	  	var email=getObj("applicantInsured.email");
		var re2 =/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if(email.length==0||email==""){
			alert("请输入您的电子邮箱");
			return false;
		}else if(!re2.test(email)){
			alert("电子邮箱有误,请核对后输入");
			return false;
		}
		
		//校验地址
		var re3 = /[\u4e00-\u9fa5]|[a-zA-Z]/; 
		if(address==""||address.length==0){
			alert("请输入地址");
			return false;
		}else if(conty.length==""||conty.length==0){
			alert("请输入区/县信息");
			return false;
		}else if(detail_addr.length<6||address.length>40){
			alert("请输入有效的地址");
			return false;
		}else if(province=="" || city=="" || detail_addr==""){
			alert("请输入有效的地址");
			return false;
		}else if(!re3.test(detail_addr)){
			alert("请输入有效的地址");
			return false;
		}else if(!/^[\u4e00-\u9fa5]{1,10}$/.test(conty)){
			alert("请输入有效的区/县地址");
			return false;
		}
		 
		
		if(isAgentCode=="1"){
			if(agentCode==null||agentCode.length==0){
				alert("请输入理财顾问编码");
				return false;
			}
		}
		
		//推荐人编码校验,推荐人编码为选填，填写了则判断brno是否为专属连接，不为专属链接推荐人编码为5到15位，为专属链接15位以下
		if(isAgentCode==1||agentCode!=""&&agentCode.length>0){
			if(brNo1=='A0000'||brNo1==null||brNo1.length==0){
				if(agentCode!=""||agentCode.length!=0){
					if(!reg.test(agentCode)){
						alert("理财顾问编码为5~15位的字母和数字，请重新输入！");
						return false;
					}
					else if(agentCode.length>15||agentCode.length<5){
						alert("理财顾问编码为5~15位的字母和数字，请重新输入！");
						return false;
					}else 
					
					{return true;}
				}
				return true; 
			}else{
				if(!reg.test(agentCode)){
					alert("理财顾问编码为15位以内的字母和数字，请重新输入！");
					return false;
				}
				else if(agentCode.length>15){
					alert("理财顾问编码为15位以内的字母和数字，请重新输入！");
					return false;
				}else 
				{return true;}
			} 
		}else{
			return true;
		}
		}
	
	
	function IdentityCodeValid(code,type){var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};var tip="";var pass=true;if(!code||!/(^\d{15}$)|(^\d{17}(\d|X)$)/.test(code)){if(type){tip="投保人身份证号格式错误"}else{tip="被保险人身份证号格式错误"}pass=false}if(!city[code.substr(0,2)]){if(type){tip="投保人身份证地址编码错误"}else{tip="被保人身份证地址编码错误"}pass=false}else{if(code.length==18){code=code.split('');var factor=[7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2];var parity=[1,0,'X',9,8,7,6,5,4,3,2];var sum=0;var ai=0;var wi=0;for(var i=0;i<17;i++){ai=code[i];wi=factor[i];sum+=ai*wi}var last=parity[sum%11];if(parity[sum%11]!=code[17]){if(type){tip="投保人身份证校验位错误"}else{tip="被保人身份证校验位错误"}pass=false}}}if(!pass)alert(tip);return pass}
	function getSex(value){
		if (parseInt(value.substr(16, 1)) % 2 == 1) {
			return "M";
		} else {
			return "F"; 
		} 
	}
	function getBirth(value) {
	    var year = "1900";
	    var month = "1";
	    var day = "1";
	    if (value.length == 15) {
	        year = "19" + value.substr(6, 2);
	        month = value.substr(8, 2);
	        day = value.substr(10, 2);
	    } else if (value.length == 18) {
	        year = value.substr(6, 4);
	        month = value.substr(10, 2);
	        day = value.substr(12, 2);
	    } else {
	        return "";
	    }
	    newDate = new Date(year, month - 1, day);
	    if (newDate.toString() == "NaN") {
	        return "";
	    }
	    else {
	        var start =  year + "-" + month + "-" + day;
	        return start;
	    } 
	}
	
		var BillingType ="";//支付方式
	//保存投被保人信息并将页面跳转至健康告知
		function save(){
			var agentCode = getObj("policy.agentcode");
			//校验
			if(!check()){
				return;
			}  
			//移除disabled属性
			$("#province").removeAttr("disabled");
			$("#city").removeAttr("disabled");
			
			var industry = $("#industry").val();	//行业
	 		var job = $("#job").val();	//职业
			var bankProvince = document.getElementById("bankProvinceAddress").value=="省/市"?"":document.getElementById("bankProvinceAddress").value;//续费开户行地址省
			var bankCity = document.getElementById("bankCityAddress").value=="市/区"?"":document.getElementById("bankCityAddress").value;//续费开户行地址市
			var bank=document.getElementById("policy.bank").value;//续费银行
			var	bankAccountNumber=document.getElementById("policy.bankAccountNumber").value==null?"":document.getElementById("policy.bankAccountNumber").value;//续费银行卡号
			var payBankProvinceAddress =document.getElementById("payBankProvinceAddress").value=="省/市"?"":document.getElementById("payBankProvinceAddress").value;//开户地址省
			var paybankCityAddress =document.getElementById("paybankCityAddress").value=="市/区"?"":document.getElementById("paybankCityAddress").value;//开户地址市
			var BankBranchName=document.getElementById("BankBranchName").value;//缴费银行
			var AccountNumber = document.getElementById("AccountNumber").value==null?"":document.getElementById("AccountNumber").value;//银行卡号
			var renewalbankProvince=document.getElementById("renewalbankProvince").value;
			var renewalbankCity=document.getElementById("renewalbankCity").value;
			var province = document.getElementById("province").value=="省/市"?"":document.getElementById("province").value;//投保人地址
			var city = document.getElementById("city").value=="市/区"?"":document.getElementById("city").value;//投保人地址
			var conty = document.getElementById("conty").value==null?"":document.getElementById("conty").value;//投保人地址 区/县
			var detail_addr = document.getElementById("detail_addr").value==null?"":document.getElementById("detail_addr").value;//投保人地址
			var addressTemp = province+city+conty+"区/县"+detail_addr;//投保人地址
			var regExp = /<\/?[^>]+>/gi; 
			var address =  addressTemp.replace(regExp,""); 
			//校验地址
			if(address==""||address.length==0){
				alert("请输入地址");
				return;
			}else if(detail_addr.length<6||address.length>40){
				alert("请输入有效的地址");
				return;
			} 
			
			if(BillingType==""){
				alert("请选择支付方式");
				return;
			}  
			else if(BillingType=="Y"){	//为银行代扣时 录入信息校验 ，地址信息赋值
				document.getElementById("policy.bankProvince").value=payBankProvinceAddress;
				document.getElementById("policy.bankCity").value=paybankCityAddress;
				document.getElementById("bankvalue").value=document.getElementById("renewalbank").value;
				document.getElementById("bankBranchNamevalue").value=BankBranchName;
					 if (payBankProvinceAddress==""||payBankProvinceAddress.length==0&&paybankCityAddress==""||paybankCityAddress.length==0) {
					alert("请填写开户行所在地！");
					return;
				}
	    	}
		 	else  if(BillingType=="N"){//为微信支付时银行校验地址赋值，续费银行传值
					 if (bankProvince==""||bankProvince.length==0&&bankCity==""||bankCity.length==0) {
					alert("请填写开户行所在地！");
					return;
					 }
			  	document.getElementById("bankvalue").value=bank;
			 	document.getElementById("AccountNumbervalue").value=bankAccountNumber;
		   		document.getElementById("policy.bankProvince").value=bankProvince;
				document.getElementById("policy.bankCity").value=bankCity;
				document.getElementById("bankBranchNamevalue").value=bank;
		   }
			
			var reg = /^[0-9]{8,20}$/;//校验银行卡号为8到20之间的数字
			var obj = document.getElementById("policy.bankAccountNumber");
			var bankno = document.getElementById("policy.bankAccountNumber").value==null?"":document.getElementById("policy.bankAccountNumber").value;//银行卡号
			if(bankno.length=="" || bankno.lenght==0){
				alert("请填写银行卡号！");
				return;
			}else if(!reg.test(obj.value)){  
		        alert("您输入的银行账号有误，请重新输入！");
		        return;
		    }
			var arr=new Array();//校验银行卡号不能全部相同
			var fg;
			for(var i=0;i<bankno.length;i++){
				arr[i]=bankno.substring(i,i+1);
				if(arr[0]!=arr[i]){
					fg=true;
				}
			}
			if(fg!=true){
				  alert("您输入的银行账号有误，请重新输入！");
			        return;
			}
		  	var flag = document.getElementById("checkboxsure").checked; 
			if(!flag){
		 	  alert("请您阅读本人须知。");
			  return false;
  			}
		  	
			var br = $(".birthdayDate").val();//取得生日
			document.getElementById("applicantInsured.address").value = address;
			document.getElementById("applicantInsured.birthday").value = br; 
		
			if(brNo1=='A0000'||brNo1==null||brNo1.length==0){
				if(agentCode!=null&&agentCode.length>0){
					 var flag=false;
					 $.ajax({
						   type:"POST",
						   url:"<%=request.getContextPath() %>/msl/sales/existDepart",
						   data:"agentCode="+agentCode,
						   dataType:"json",
						   success:function(data){
							   if(data.flag=="0"){
								   document.getElementById("policy.deptid").value=data.content;
								   $("#creator").submit();
							   }else if(data.flag=="1")
							   		 alert(data.content);
							}
						});   
						if(!flag){
							return false;
						}
					 }else{
						$("#creator").submit();
					 }
			}else{
				$("#creator").submit();
			}
		}
		
		$(".checkboxCom").click(function(){
		if($(this).prev().prop("checked")){
		var name = $(this).parent("div").find(".comName").val();
	 	var idno = $(this).parent("div").find(".comIdno").val();
	/*	var sex = $(this).parent("div").find(".comSex").val();
		var birthday = $(this).parent("div").find(".comBirthday").val(); */
		var mobile = $(this).parent("div").find(".comMobile").val();
		var email = $(this).parent("div").find(".comEmail").val();
		document.getElementById("applicantInsured.name").value=name;
		document.getElementById("applicantInsured.mobile").value=mobile;
		document.getElementById("applicantInsured.email").value=email;
		document.getElementById("applicantInsured.identifynumber").value=idno;
		}else{
				document.getElementById("applicantInsured.name").value="";
				document.getElementById("applicantInsured.mobile").value="";
				document.getElementById("applicantInsured.email").value="";
				document.getElementById("applicantInsured.identifynumber").value="";
		}
		$("#commonApp").toggle();
		$(".makeComApp").toggle();
	});
		
		
		
		//支付方式按钮样式
		$(".checked_img").click(function(){
			if($(this).prev().prop("checked")==false){
			   $(".checked_img").removeClass("current_radio");  
		       $(this).addClass("current_radio"); 
		   	   $(this).prev().prop("checked",true);
		   		BillingType=$(this).prev().val();
			}
			if($(this).prev().prop("checked")==true){
			   $(".checked_img").removeClass("current_radio");  
		       $(this).addClass("current_radio"); 
		   		BillingType=$(this).prev().val();
			}
		});
		//支付方式
		
		$(".checked_img").click(function(){
	 		/* var BillingType = $('input[name="policy.BillingType"]:checked').val(); */
			if(BillingType=="N"){
				document.getElementById("divID").style.display="none"; 
				document.getElementById("XQpayment").style.display="";
				document.getElementById("XQTab").style.display="";
				document.getElementById("XQStatement").style.display="";
				$(".bankAccountNumber").removeAttr("readonly");
				$(".renew").show();
				$(".payment").hide();
				/* $(".bankAccountNumber").attr("readonly","readonly"); */
			 	$(".bankAccountNumber").css("background","none");
			}
			if(BillingType=="Y"){
				document.getElementById("XQpayment").style.display="none";
				document.getElementById("XQTab").style.display="none";
				document.getElementById("XQStatement").style.display="none";
				document.getElementById("divID").style.display="block";
				$(".renew").hide();
				$(".payment").show();
			 	$(".renewalbank").attr("readonly","readonly");
			 	$(".bankAccountNumber").attr("readonly","readonly");
			 	$(".bankProvince").attr("readonly","readonly");
			 	$(".bankCity").attr("readonly","readonly");
			 	$(".payment input").css("background-color"," #e9e9e9");
			 	$(".paymentno input").css("background-color"," #e9e9e9");
			 	$(".payment input").css("color"," #555");
			 	$(".paymentno input").css("color"," #555");
			 	BankBranchRl();
			}
		});
		 	//续费银行赋值
		function BankBranchRl(){
			var BankBranchName=document.getElementById("BankBranchName").value;
			var AccountNumber=document.getElementById("AccountNumber").value;
			var paybankCityAddress=document.getElementById("paybankCityAddress").value;
			var payBankProvinceAddress=document.getElementById("payBankProvinceAddress").value;
			document.getElementById("policy.bankAccountNumber").value=AccountNumber;
			document.getElementById("AccountNumbervalue").value=AccountNumber;
			document.getElementById("renewalbankCity").value=paybankCityAddress;
			document.getElementById("renewalbankProvince").value=payBankProvinceAddress;
			document.getElementById("bankvalue").value=BankBranchName;
			switch(BankBranchName){
				case "130105":
			document.getElementById("renewalbank").value="建设银行";
					break;
				case "130308":
			document.getElementById("renewalbank").value="招商银行";
					break;
				case "090004":
			document.getElementById("renewalbank").value="中信银行信用卡";
					break;
				case "130102":
			document.getElementById("renewalbank").value="工商银行";
					break;
				case "100306":
			document.getElementById("renewalbank").value="广发银行";
					break;
				case "100103":
			document.getElementById("renewalbank").value="农业银行";
					break;
				case "130104":
			document.getElementById("renewalbank").value="中国银行";
					break;
				case "130302":
			document.getElementById("renewalbank").value="中信银行";
					break;
				case "100303":
			document.getElementById("renewalbank").value="光大银行";
					break;
			/*	case "100304":
			document.getElementById("renewalbank").value="华夏银行";
					break;
				case "100305":
			document.getElementById("renewalbank").value="民生银行";
					break;*/
				case "100307":
			document.getElementById("renewalbank").value="平安银行";
					break;
			/*	case "100309":
			document.getElementById("renewalbank").value="兴业银行";
					break;*/
				case "100310":
			document.getElementById("renewalbank").value="浦发银行";
					break;
				case "100403":
			document.getElementById("renewalbank").value="邮政储蓄银行";
					break;
				case "100301":
			document.getElementById("renewalbank").value="交通银行";
				    break;
			}
	}
	 	
	//根据推荐人编码修改地址信息
	function onchangeArea(){
		var agentCode = getObj("policy.agentcode");
		if(agentCode!=null&&agentCode.length>0){
			$.ajax({
				type:"POST",
				url:"<%=request.getContextPath()%>/msl/sales/wjbDepartToArea",
				data:"agentCode="+agentCode,
				dataType:"json",
				success:function(data){
					//移除disabled属性
					$("#province").removeAttr("disabled");
					$("#city").removeAttr("disabled");
					//移除市里的数据
					var obj = document.getElementById("city");
  					document.getElementById("city").options.length = 0;  
					
					if(data.flag=="0"){//锁定省市
						var stateName = data.stateName;
						var cityName = data.cityName;
						if(stateName!= null && stateName!="" && stateName != 'null'){
							document.getElementById("province").value = stateName;
							$("#province").attr("disabled","disabled");	//锁定省
							//获得所有的市
							for (i = 0; i < where1.length; i++) {
								if (where1[i].loca == stateName) {
									loca3 = (where1[i].locacity).split("|");
									for (j = 0; j < loca3.length; j++) {
										city.options.add(new Option(loca3[j],loca3[j])); 
									}
								break;
								}
							}
							//锁定市
				     	    if(cityName!=null && cityName!="" & cityName!='null'){
								document.getElementById("city").value = cityName; 
								$("#city").attr("disabled","disabled");
							}
						}
					}else if(data.flag=="1"){//锁定省
						var stateName = data.stateName;
						if(stateName!= null && stateName!="" && stateName != 'null'){
							document.getElementById("province").value = stateName;
							$("#province").attr("disabled","disabled");
							//获得所有的市
							for (i = 0; i < where1.length; i++) {
								if (where1[i].loca == stateName) {
									loca3 = (where1[i].locacity).split("|");
									for (j = 0; j < loca3.length; j++) {
										city.options.add(new Option(loca3[j],loca3[j])); 
									}
								break;
								}
							}
						}
					}else if(data.flag=="2"){
						alert(data.content);	
					}
				}
			});   
		}
	}
	
	function showAll(){
		$("#reminderAB").hide();
		$("#remindertotalOne").show();
		$("#remindertotalTwo").show();
	}		
</script>
</html>