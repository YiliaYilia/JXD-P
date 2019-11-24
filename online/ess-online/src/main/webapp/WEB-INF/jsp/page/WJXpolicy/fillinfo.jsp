<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ include file="../../common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<title>稳驾行</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
	<meta name="format-detection" content="telephone=no"/>
	<link href="<%=request.getContextPath() %>/resources/css/common/main.min.css?${random}" rel="stylesheet"/>
	<link href="<%=request.getContextPath() %>/resources/css/animate/loader-ani.css" rel="stylesheet"/>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/wjx/wjx.css" type="text/css"></link>
</head>
<body onload="init();">
<div class="wjx">
	<!--标题区域
  	<header class="txt24">填写信息</header>-->
  	<div class="nav txt16">
  		<div class="menu" style="color:#fff;">填写信息</div>
  		<div class="menu">健康告知</div>
  		<div class="menu">确认投保</div>
  		<div class="menu">在线缴费</div>
  		<div class="clear"></div>
  	</div>
  	<!-- 正文区域 -->
  	<form action="<%=request.getContextPath()%>/msl/sales/WJXInsureInput" method="post" id="creator" name="creator">
  	<section class="fillinfo_wrap">
  		<div class="title" style="margin: 15px auto 20px auto;">投保人信息</div>
  		<c:if test="${!empty comAppList}">
	  		<table class="common_info txt14">
	  			<tr>
	  				<td colspan="5">
	 					<span>常用投保人</span>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td width="20%" align="left">
						<div class="checkbox_div txt14" style="margin: 0;">
				 			 <input class="comChoose" type="checkbox" id ="comChoose" name=""/><div class="checkbox checkboxCom"><span class="checked_img"></span></div> 
				 		 	 <input class="comName" type="hidden" name="comName" value="${comAppList.name}" >
					 		<%--  <input class="comIdno" type="hidden" name="comIdno" value="${comAppList.idno}" >
					 		 <input class="comSex" type="hidden" name="comSex" value="${comAppList.sex}" >
					 		 <input class="comBirthday" type="hidden" name="comBirthday" value="${comBirthday}" > --%>
					 		 <input class="comMobile" type="hidden" name="comMobile" value="${comAppList.mobile}" >
					 		 <input class="comEmail" type="hidden" name="comEmail" value="${comAppList.email}" >
				 		</div>
				 		<span>${comAppList.name}</span>
					</td>
	  			</tr>
	  		</table>
  		</c:if>
  		<table>
  			<tr>
  				<td width="35%" class="left" style="text-indent: 5%;"><span class="must">*</span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
  				<td width="65%"><input id="applicantInsured.name"  name="applicantInsured.name" type="text" value="${applicantInsured.name}"/></td>
  			</tr>
  			<tr>
				<td class="left">身份证号：</td>
				<td>
				<input type="hidden" id="applicantInsured.identifytype" name="applicantInsured.identifytype" value="I"/>
				<input type="text" id="applicantInsured.identifynumber" name="applicantInsured.identifynumber" readonly="readonly" value="${idno}" style="background: #e2e2e2"/>
				</td>
  			</tr>
  			<tr>
  				<td class="left">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
  				<td>
  					<%-- <select id="applicantInsured.sex" name="applicantInsured.sex"  value="${sex}">
  						<option value="M">男</option>
						<option value="F">女</option>
  					</select> --%>
  					<input type="text" id="applicantInsured.sex" name="applicantInsured.sex" readonly="readonly" value="${sex}" style="background: #e2e2e2"/>
  				</td>
  			</tr>
  			<tr>
  				<td class="left">出生日期：</td>
  				<td>
  					<input type="text" id="applicantInsured.birthday" class="birthdayDate" name="applicantInsured.birthday" value="${birthday}" readonly="readonly" style="background: #e2e2e2"/>
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
		  					<span>省</span>
	  					</div>
	  					<div class="select_div">
	  						<select name="city" id="city" onchange = "select();"></select>
  							<span>市</span>
  						</div>
  						<div class="input_div">
	  						<input id="conty" type="text" />
	  						<span>区/县</span>
  						</div>
  						<div class="input_div">
  							<input id="street" type="text"/>
  							<span>镇/街道</span>
  						</div>
  					</div>
  					<div class="addr_div">
  						<div class="input_div" style="width: 100%;">
	  						<input id="area" style="width: 75%" type="text"/>
	  						<span>村/社区</span>
  						</div>
  					</div>
  					<div class="addr_div"><input id="detail_addr" type="text" width="100%" style="margin:5px auto"/></div>
  					<input type="hidden" id="applicantInsured.address" name="applicantInsured.address" value="${applicantInsured.address}" />
  				</td>
  			</tr>
  		</table>
  		<div class="checkbox_div makeComApp">
 			 <input type="checkbox" id ="commonApplicant.flag" name="commonApplicant.flag"/><div class="checkbox"><span class="checked_img"></span></div> 
 		</div>
 		<span class="makeComApp">作为常用投保人</span>
  	
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
  	
  		<div class="title">续期缴费信息</div>
 		<table class="txt16">
 			<tr>
 				<td class="noberder" style="text-indent: 5%;"><span class="must">*</span>缴费银行：</td>
 				<td class="noberder">
 					<select id="policy.bank"
							name="policy.bankBranchCode" style="width: 95%;">
								<c:if test="${brNo=='TM001'}">
								<option value="090004">中信银行信用卡</option>
								<option value="100302">中信银行储蓄卡</option>
							</c:if>
								<option value="100102">工商银行</option>
								<option value="100103">农业银行</option>
								<option value="100104">中国银行</option>
								<option value="100105">建设银行</option>
								<option value="100308">招商银行</option>
								<option value="100305">民生银行</option>
								<option value="100307">深发/平安银行</option>
								<option value="100310">浦发银行</option>
								<option value="100309">兴业银行</option>
								<option value="100303">光大银行</option>
								<option value="100304">华夏银行</option>
								<option value="100306">广发银行</option>
							<c:if test="${brNo!='TM001'}">
								<option value="100302">中信银行</option>
							</c:if>
								<option value="100403">邮政储蓄银行</option>
						</select>
 				</td>
 			</tr>
 			<tr>		
					<td class="noberder" width="35%" >开户行所在地：</td>
					<td>
							<select style="width: 30%;" name="bankProvinceAddress"
								id="bankProvinceAddress" onchange="select();"></select> <span>省&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<select style="width: 40%;" name="bankCityAddress"
								id="bankCityAddress" onchange="select();"></select> <span>市</span>
								<input type="hidden" id="policy.bankProvince"
								name="policy.bankProvince" value="${policy.bankProvince}" /> <input
								type="hidden" id="policy.bankCity" name="policy.bankCity"
								value="${policy.bankCity}" />
					</td>
				</tr>
 			
 			<tr>
 				<td class="noberder" width="35%" style="text-indent: 5%;"><span class="must">*</span>银行账号：</td>
 				<td class="noberder" width="65%"><input type="text" placeholder="填写投保人的银行账号" style="width: 95%;font-size: 0.875em;" id="policy.bankAccountNumber" name="policy.bankAccountNumber" value="${policy.bankAccountNumber}"/></td>
 			</tr>
 		</table>

  		<div class="pay_info">	
  			<div class="state_div txt14">
	  			<p>
	  			<img src="../../resources/image/wjx/star.png"/>
	  			投保人声明及授权：我同意授权瑞泰人寿根据保险合同约定的保费金额和交费方式委托银行从上述账户划款。如果我提供的账户是凭印鉴或密码支取，则我将同意并授权委托银行在划转保险费时免于核对该账户中的印鉴或密码。
	  			</p>
  			</div>
  		</div>
  		<div class="title">推荐人信息</div>
  		<div class="pay_info" style="margin: 0 5% 35px 5%;">
  			<div class="info_dtl txt16 recommend">
	  			<span style="width: 40%;">推荐人编码：</span>
	  			<input type="text" style="width: 25%;"id="policy.agentcode" name="policy.agentcode" value="${policy.agentcode}"/>
	  			<input type="hidden" id="policy.deptid" name="policy.deptid" value="${policy.deptid}">
	  			<c:if test="${isAgentCode=='0'}"><span style="padding-left: 0px;width: 30%;">（选填）</span></c:if>
  			</div>
  		</div>
  	</section>
  	</form>
  	 <!-- 按钮区域 -->
  	 <section class="btn_wrap">
   		<div class="one_btn txt22" onclick="save()" style="float: left;">下一步</div>
   		<div class="clear"></div>
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
	<script src="<%=request.getContextPath() %>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/wjx/area.js?${random}"></script>
  	<script src="<%=request.getContextPath() %>/resources/lib/common/main.js?${random}"></script>
  	<script src="<%=request.getContextPath() %>/resources/lib/component/modal.js"></script>
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
	
	
	$(".checkboxCom").click(function(){
		if($(this).prev().prop("checked")){
		var name = $(this).parent("div").find(".comName").val();
		var mobile = $(this).parent("div").find(".comMobile").val();
		var email = $(this).parent("div").find(".comEmail").val();
		document.getElementById("applicantInsured.name").value=name;
		document.getElementById("applicantInsured.mobile").value=mobile;
		document.getElementById("applicantInsured.email").value=email;
		}
		$(".makeComApp").toggle();
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
		var province = document.getElementById("province").value=="省/市"?"":document.getElementById("province").value;//投保人地址
		var city = document.getElementById("city").value=="市/区"?"":document.getElementById("city").value;//投保人地址
		var conty = document.getElementById("conty").value==null?"":document.getElementById("conty").value;//投保人地址
		var street = document.getElementById("street").value==null?"":document.getElementById("street").value;//投保人地址
		var area = document.getElementById("area").value==null?"":document.getElementById("area").value;//投保人地址
		var detail_addr = document.getElementById("detail_addr").value==null?"":document.getElementById("detail_addr").value;//投保人地址
		var addressTemp = province+city+conty+street+area+detail_addr;//投保人地址
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
				alert("投保人身份证号与生日不相符");
				return false;
			}else if(getSex(applicantInsuredidentifynumber)!=recognizeeSex){
				alert("投保人身份证号与性别不相符");
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
		/* var re3 = /^([\u4e00-\u9fa5]|[a-zA-Z0-9])+$/; */
		if(address==""||address.length==0){
			alert("请输入地址");
			return false;
		}else if(address.length<8||address.length>30){
			alert("请输入有效的地址");
			return false;
		}else if(province=="" || city=="" || conty=="" || street=="" || area=="" || detail_addr==""){
			alert("请输入有效的地址");
			return false;
		}/* else if(!re3.test(address)){
			alert("请输入有效的地址");
			return false;
		} */
		//校验银行
		var bank = document.getElementById("policy.bank").value;
			if (bankProvince==""||bankProvince.length==0&&bankCity==""||bankCity.length==0) {
			alert("请填写开户行所在地！");
			return false;
			}
		if(isAgentCode=="1"){
			if(agentCode==null||agentCode.length==0){
				alert("请输入推荐人编码");
				return false;
			}
		}
		//推荐人编码校验,推荐人编码为选填，填写了则判断brno是否为专属连接，不为专属链接推荐人编码为5到15位，为专属链接15位以下
		if(isAgentCode==1||agentCode!=""&&agentCode.length>0){
			if(brNo1=='A0000'||brNo1==null||brNo1.length==0){
				if(agentCode!=""||agentCode.length!=0){
					if(!reg.test(agentCode)){
						alert("推荐人编码为5~15位的字母和数字，请重新输入！");
						return false;
					}
					else if(agentCode.length>15||agentCode.length<5){
						alert("推荐人编码为5~15位的字母和数字，请重新输入！");
						return false;
					}else 
					
					{return true;}
				}
				return true; 
			}else{
				if(!reg.test(agentCode)){
					alert("推荐人编码为15位以内的字母和数字，请重新输入！");
					return false;
				}
				else if(agentCode.length>15){
					alert("推荐人编码为15位以内的字母和数字，请重新输入！");
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
	
	
	//保存投被保人信息并将页面跳转至健康告知
		function save(){
			var agentCode = getObj("policy.agentcode");
			//校验
			if(!check()){
				return;
			}  
			var bankProvince = document.getElementById("bankProvinceAddress").value=="省/市"?"":document.getElementById("bankProvinceAddress").value;//开户行地址
			var bankCity = document.getElementById("bankCityAddress").value=="市/区"?"":document.getElementById("bankCityAddress").value;//开户行地址
			var province = document.getElementById("province").value=="省/市"?"":document.getElementById("province").value;//投保人地址
			var city = document.getElementById("city").value=="市/区"?"":document.getElementById("city").value;//投保人地址
			var conty = document.getElementById("conty").value==null?"":document.getElementById("conty").value;//投保人地址
			var street = document.getElementById("street").value==null?"":document.getElementById("street").value;//投保人地址
			var area = document.getElementById("area").value==null?"":document.getElementById("area").value;//投保人地址
			var detail_addr = document.getElementById("detail_addr").value==null?"":document.getElementById("detail_addr").value;//投保人地址
			var addressTemp = province+city+conty+street+area+detail_addr;//投保人地址
			var regExp = /<\/?[^>]+>/gi; 
			var address =  addressTemp.replace(regExp,""); 
			//校验地址
			if(address==""||address.length==0){
				alert("请输入地址");
				return;
			}else if(address.length<8||address.length>30){
				alert("请输入有效的地址");
				return;
			} 
			//校验银行
			var bank = document.getElementById("policy.bank").value;
					 if (bankProvince==""||bankProvince.length==0&&bankCity==""||bankCity.length==0) {
					alert("请填写开户行所在地！");
					return;
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
			document.getElementById("policy.bankProvince").value=bankProvince;
			document.getElementById("policy.bankCity").value=bankCity;
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
		
</script>


</html>