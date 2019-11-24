<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
  <head>
  <title>投保信息-瑞泰人寿</title>
 
	<%@ include file="../../common/meta.jsp"%>
	<%@ include file="../../common/rels.jsp"%>
	<%@ include file="/common/page/common.jsp"%>
	<link href="<%=request.getContextPath()%>/global/global/css/common.css?${random}" rel="stylesheet"/>
	<link href="<%=request.getContextPath()%>/global/global/css/sale.css?${random}" rel="stylesheet"/>
	
	<script src="<%=request.getContextPath() %>/resources/lib/component/form.js"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/validate/jquery.validator.js?${random}"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/validate/local/zh_CN.js?${random}"></script>
   
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/uinew/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/uinew/css/jquery.bxslider.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/uinew/css/safe-new.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/uinew/css/style-font.css">


		<script>
        $(function () {
           function init() {
                var demo, theme, mode, display, lang;
            
                demo = 'date';
                theme = 'android',
                mode = 'scroller',
                display = 'modal',
                dateFormat= 'yy年mm月dd日',
                endYear=new Date().getFullYear(),
                lang = 'zh';
                $('.demo-cont').hide();
                $("#demo_cont_" + demo).show(); 
            }    

            // Demo page code END
            // -------------------------------------------------------------------
        });
    </script>
<!-- 	工具类 -->
	<script src="<%=request.getContextPath()%>/resources/lib/utils/dateUtils.js?${random}" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/utils/idCardUtils.js?${random}" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/utils/stringUtils.js?${random}" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/js/page/area.js?${random}"></script>
	<script src="<%=request.getContextPath()%>/uinew/js/jquery.js?${random}"></script>
	<script src="<%=request.getContextPath()%>/uinew/js/bootstrap.min.js?${random}"></script>
</head>

<style>
	
	.grace-form {
    font-size: 1.7em;
}

.grace-form .pull-left {
    width: 30%;
    text-align: left;
}

.grace-form .pull-right {
    width: 70%;
    text-align: left;
}
.data_input {
    font-size: 1em;
}

/*checked*/
		 .checkbox_div{width: 90%;margin: 5px auto;margin-left: 40px;}
		 .checkbox_div input[type='checkbox']{display:none;}
		 .checkbox_div .checkbox{width: 20px;height: 20px;border: 1px solid #535353;float: left;margin: 2px 5px auto auto;}
		 .checkbox_div .checked_img{border: #535353 solid;border-width:2px 2px 0 0;width: 12px;height: 7px;position:absolute;
		 transform:rotate(135deg);-webkit-transform:rotate(135deg);-ms-transform:rotate(135deg);display: inline-block;margin: 2px auto auto 2.5px;display:none;}
		 
		 .radio_div{width: 90%;margin: 15px 5%;line-height: 20px;}
		 .radio_div input[type='radio']{display:none;}
		 .radio_div .radio{width:20px;height:20px;border-radius:7px;float:left;margin:8px 5px 0;border:1px solid #656565;}
		 .radio_div .checked_img{background: #656565;}
		 .blue_f{color: #16c2e8;}
		 
		 
	</style>

<body onload="init1();" class="gray">
	<div class="grace-head"></div>
	<ul class="grace-top-menu">
		<li class="menu-select">填写信息</li>
		<li>健康告知</li>
		<li>确认投保</li>
		<li>在线缴费</li>
	</ul>
	<form
		action="<%=request.getContextPath()%>/msl/sales/longPolicyInsureInput"
		method="post" id="creator" name="creator"
		enctype="multipart/form-data">
		<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
			class="grace-info-tl"> 投保人信息 <span
			class="icon-expand_less pull-right"></span>
		</a>
	   
		<div id="collapseOne" class="panel-collapse collapse in cardcontent">
		
  	 	<c:if test="${!empty comAppList}"> 
		<ul class="grace-form">
	  		<li>
	 			<span>&nbsp;&nbsp;常用投保人</span>
			</li>
	  		<c:forEach var="comAppList" items="${comAppList}"> 
	  		<li>
	  	 	 <div class="radio_div txt14" style="margin:0;padding-left:10px;">
	 			 <input class="comChoose" type="radio" id ="comChoose" name="comChoose" />
	 			 <div class="radio checkboxCom"></div> 
	 		 	 <input class="comName" type="hidden" name="comName" value="${comAppList.name}" >
	 		 	 <input class="comIdtype" type="hidden" name="comIdtype" value="${comAppList.idtype}">
		 		 <input class="comIdno" type="hidden" name="comIdno" value="${comAppList.idno}" >
		 		 <input class="comSex" type="hidden" name="comSex" value="${comAppList.sex}" >
		 		 <input class="comBirthday" type="hidden" name="comBirthday" value="${comAppList.birthday}" > 
		 		 <input class="comMobile" type="hidden" name="comMobile" value="${comAppList.mobile}" >
		 		 <input class="comEmail" type="hidden" name="comEmail" value="${comAppList.email}" >
	 		</div>
	 		<span>&nbsp;&nbsp;${comAppList.name}</span>
			</li>
	 		</c:forEach>
	   </ul>
	   </c:if>
			<ul class="grace-form">
				<li>
					<div class="pull-left">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名
						:</div>
					<div class="pull-right">
						<input type=text id="applicantInsured.name"
							name="applicantInsured.name" value="${applicantInsured.name}" />
					</div>
				</li>
				<li>
					<div class="pull-left">证件类型 :</div>
					<div class="pull-right">
						<select id="applicantInsured.identifytype"
							name="applicantInsured.identifytype" style="width: 98%;">
							<option value="I">身份证</option>
							<option value="P">护照</option>
							<option value="S">军官证/士兵证</option>
							<option value="O">户口本</option>
							<option value="H">港澳居民来往内地通行证/回乡证</option>
							<option value="T">台湾居民来往大陆通行证/台胞证</option>
						</select>
					</div>
				</li>
				<li>
					<div class="pull-left">证件号码 :</div>
					<div class="pull-right">
						<input type=text id="applicantInsured.identifynumber"
							name="applicantInsured.identifynumber" onchange="changeBirth();" />
					</div>
				</li>
				<li>
					<div class="pull-left">出生日期 :</div>
					<div class="pull-right">
						<input class="data_input" style="text-align: left;" type="date"
							id="start" name="start" />
						<input type="hidden" id="applicantInsured.birthday" name="applicantInsured.birthday" value="${applicantInsured.birthday}" />
					</div>
				</li>
				<li>
					<div class="pull-left">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别
						:</div>
					<div class="pull-right">
						<select style="font-size: 1.0em; width: 35%;"
							id="applicantInsured.sex" name="applicantInsured.sex">
							<option value="M">男</option>
							<option value="F">女</option>
						</select>
					</div>
				</li>
				<li>
					<div class="pull-left">手机号码 :</div>
					<div class="pull-right">
						<input type=text id="applicantInsured.mobile"
							name="applicantInsured.mobile" value="${applicantInsured.mobile}" />
					</div>
				</li>
				<li>
					<div class="pull-left">电子邮箱 :</div>
					<div class="pull-right">
						<input type=text id="applicantInsured.email"
							name="applicantInsured.email" value="${applicantInsured.email}" />
					</div>
				</li>
				<li>
					<div class="pull-left">通讯地址 :</div>
					<div class="pull-right">
						<select style="width: 35%;" name="province" id="province"
							onchange="select1();"></select> <select
							style="width: 55%; margin-left: 5%" name="city" id="city"
							onchange="select1();"></select>
					</div>
				</li>
		 		<li>
					<div class="pull-left"></div>
					<div class="pull-right">
	  						<input id="conty" name="conty" type="text" style="width:65%"/>
	  						<span>区/县</span>
  					</div>
  				</li>
		 		<li>	
  					<div class="pull-left"></div>
					<div class="pull-right">
						<input type="text" id="address" name="address" placeholder="请填写详细地址"> 
						<input type="hidden"
							id="applicantInsured.address" name="applicantInsured.address"
							value="${applicantInsured.address}" />
					</div>
				</li> 
				<li>
					<div class="pull-left">
					<div class="checkbox_div txt14" id="commonApp">
	 			 		<input type="checkbox" id ="commonApplicant.flag" name="commonApplicant.flag" /><div class="checkbox" ><span class="checked_img"></span></div> 
	  				</div>
					</div>
					<div class="pull-right">
						<span class="makeComApp" >作为常用投保人</span>
					</div>
				</li>
			</ul>

		</div>

		<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"
			class="grace-info-tl"> 被保人信息 <span
			class="icon-expand_less pull-right"></span>
		</a>
		<div id="collapseTwo" class="panel-collapse collapse in cardcontent">
			<ul class="grace-form">
				<li>
					<div class="pull-left">与投保人关系 :</div>
					<div class="pull-right">
						<select id="recognizee.insrelationapp" style="width: 35%;"
							name="recognizee.insrelationapp">
							<option value="CH">子女</option>
						</select>
					</div>
				</li>
				<li>
					<div class="pull-left">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名
						:</div>
					<div class="pull-right">
						<input type=text id="recognizee.name" name="recognizee.name"
							value="${recognizee.name}" />
					</div>
				</li>
				<li>
					<div class="pull-left">证件类型 :</div>
					<div class="pull-right">
						<select id="recognizee.identifytype"
							name="recognizee.identifytype"  style="width: 98%;">
							<option value="I">身份证</option>
							<option value="P">护照</option>
							<option value="S">军官证/士兵证</option>
							<option value="O">户口本</option>
							<option value="H">港澳居民来往内地通行证/回乡证</option>
							<option value="T">台湾居民来往大陆通行证/台胞证</option>
						</select>
					</div>
				</li>
				<li>
					<div class="pull-left">证件号码 :</div>
					<div class="pull-right">
						<input type=text id="recognizee.identifynumber"
							name="recognizee.identifynumber"
							value="${recognizee.identifynumber}" />
					</div>
				</li>
				<li>
					<div class="pull-left">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别
						:</div>
					<div class="pull-right">&nbsp;${sex}</div>
				</li>
				<li>
					<div class="pull-left">出生日期 :</div>
					<div class="pull-right">&nbsp;${birthday}</div>
				</li>
			</ul>
		</div>

		<a data-toggle="collapse" data-parent="#accordion"
			href="#collapsethree" class="grace-info-tl"> 受益人信息 <span
			class="icon-expand_less pull-right"></span>
		</a>
		<div id="collapsethree" class="panel-collapse collapse in cardcontent">
			<ul class="grace-applicant-info">
				<li>受益人:</li>
				<li>被保险人本人</li>
			</ul>
		</div>
		
		<a data-toggle="collapse" data-parent="#accordion"
			href="#collapsefour" class="grace-info-tl"> 续保选择 <span
			class="icon-expand_less pull-right"></span>
		</a>
		<div id="collapsefour" class="panel-collapse collapse in cardcontent">
			<ul class="grace-form">
				
				<li>
				<input type="hidden" id="policy.renewalflag" name="policy.renewalflag"> 
				<input type="checkbox" id="renewalflag" style="width: 25px;height: 25px;"/>
					申请续保至被保险人25岁 </li>
					
				<li>
					<div class="pull-left" style="width: 33%;">续保缴费银行 :</div>
					<div class="pull-right" style="width: 67%;">
						<select id="policy.bank"
							name="policy.bankBranchCode">
							<c:if test="${brNo=='TM001'}">
								<option value="090004">中信银行信用卡</option>
<!-- 								<option value="100302">中信银行储蓄卡</option> -->
							</c:if>
								<option value="130102">工商银行</option>
								<option value="100103">农业银行</option>
 								<option value="130104">中国银行</option>
 								<option value="130105">建设银行</option>
								<option value="130308">招商银行</option>
<!-- 								<option value="100305">民生银行</option> -->
								<option value="100307">平安银行</option>
								<option value="100310">浦发银行</option>
								<!--<option value="100309">兴业银行</option>-->
								<option value="100303">光大银行</option>
								<!--<option value="100304">华夏银行</option>-->
								<option value="100306">广发银行</option>
							<c:if test="${brNo!='TM001'}">
<!-- 								<option value="100302">中信银行</option> -->
							</c:if>
								<option value="100403">邮政储蓄银行</option>
								<option value="100301">交通银行</option>
						</select>
					</div>
				</li>
				<li>
					<div class="pull-left" style="width: 33%;">开户行所在地：</div>
					<div class="pull-right" style="width: 67%;">
						<select
							style="width: 35%;" name="bankProvinceAddress"
							id="bankProvinceAddress" onchange="select1();"></select> 
							<select
							style="width: 55%; margin-left: 5%" name="bankCityAddress"
							id="bankCityAddress" onchange="select1();"></select>
							<input type="hidden" id="policy.bankProvince" name="policy.bankProvince" value="${policy.bankProvince}" />
							<input type="hidden" id="policy.bankCity" name="policy.bankCity" value="${policy.bankCity}" />
					</div>
				</li>
				<li>
					<div class="pull-left" style="width: 33%;">续保缴费账号 :</div>
					<div class="pull-right" style="width: 67%;">
						<input type=text id="policy.bankAccountNumber"
							name="policy.bankAccountNumber"
							value="${policy.bankAccountNumber}" />
					</div>
				</li>
				<li class="grace-tips" style="font-size:1em;"><span style="font-size:1em;">提示 </span><br /> <br />
					(1)如选择续保，将每年从上述续保缴费账户自动划扣保费。如不选择续保，保单将在1年后自动终止。 <br />
					(2)续保缴费暂不支持信用卡。
				</li>
			</ul>
		</div>
		
  		<input type="hidden" value="" id="flag"/>
		<a data-toggle="collapse" data-parent="#accordion"
			href="#collapsefive" class="grace-info-tl"> 推荐人信息 <span
			class="icon-expand_less pull-right"></span>
		</a>
		<div id="collapsefive" class="panel-collapse collapse in cardcontent">
			<ul class="grace-form">
				<li>
					<div class="pull-left" >推荐人编码 :</div>
					<div class="pull-right" >
						<input type=text id="policy.agentcode" name="policy.agentcode" value="${policy.agentcode}" />
					</div>
				</li>
			</ul>
		</div>
		
  		<input type="hidden" id="policy.deptid" name="policy.deptid" value="${policy.deptid}">
		<div class="next-button" style="margin-bottom: 90px;padding-bottom: 90px;">
			<img src="<%=request.getContextPath()%>/uinew/images/nextbutton.jpg"
				width="100%" alt="" onclick="save()" />
		</div>

	</form>
	<div class="footer footer-fixed">

		<img src="<%=request.getContextPath()%>/uinew/images/bottom-line.jpg"
			alt="" />
	</div>
	<%-- 	<jsp:include page="../../common/footer.jsp"></jsp:include> --%>
</body> 
  <script type="text/javascript">
 	/* var brNo1="TM001";  //测试专属连接用   */
 	  var brNo1="${brNo}"; 
  	var flag1=document.getElementById('flag').value;
  	if(brNo1=='TM001'){
  		if(flag1==0||flag1.length==0){
  		document.getElementById('renewalflag').checked=true;
  		document.getElementById('check').classname='cbox checked';
  		}
  		}
  	if(flag1){
  		document.getElementById("renewalflag").checked=false;
  		document.getElementById('check').classname='cbox';
  	} 
	$("#check").click(function(){
		if(document.getElementById("renewalflag").checked==true){
			 document.getElementById("renewalflag").checked=false;
		}else{
			 document.getElementById("renewalflag").checked=true;	
		} 
  	});

	$(".checkbox").click(function(){
		if($(this).prev().prop("checked")==false){
			$(this).find(".checked_img").show();
			$(this).prev().prop("checked",true);
		}else{
			$(this).find(".checked_img").hide();
			$(this).prev().prop("checked",false);
		}
	});  
	 $(".radio").click(function(){
		if($(this).prev().prop("checked")==false){
			$(".radio").removeClass("checked_img"); 
			 $(this).addClass("checked_img"); 
			$(this).prev().prop("checked",true);
		}else{
			$(this).removeClass("checked_img");
			$(this).prev().prop("checked",false);
		}
			
	});  
	
	 $(".checkboxCom").click(function(){
			if($(this).prev().prop("checked")){
			var name = $(this).parent("div").find(".comName").val();
			var mobile = $(this).parent("div").find(".comMobile").val();
			var email = $(this).parent("div").find(".comEmail").val();
			var idno = $(this).parent("div").find(".comIdno").val();
			var sex =  $(this).parent("div").find(".comSex").val();
			var birthday = $(this).parent("div").find(".comBirthday").val();
			var idtype = $(this).parent("div").find(".comIdtype").val();
			var date = new Date(birthday.split(" ")[0]);
			if(sex=="男"){
				sex="M";
			}
			else if(sex=="女"){
				sex="F";
			}
			birthday=date.Format("yyyy-MM-dd"); 
			document.getElementById("applicantInsured.name").value=name;
			document.getElementById("applicantInsured.mobile").value=mobile;
			document.getElementById("applicantInsured.email").value=email;
			document.getElementById("applicantInsured.identifynumber").value=idno;
			document.getElementById("applicantInsured.sex").value=sex;
			document.getElementById("applicantInsured.identifytype").value=idtype;
			document.getElementById("start").value= birthday;
			}else{
				document.getElementById("applicantInsured.name").value="";
				document.getElementById("applicantInsured.mobile").value="";
				document.getElementById("applicantInsured.email").value="";
				document.getElementById("applicantInsured.identifynumber").value="";
				document.getElementById("start").value= "";
			}
		});
  </script>	
  <script type="text/javascript">
	//校验
	function check(){
		var realBrNo = "${brNo}";
		var regcode =  /^[a-zA-Z0-9]+$/;
		var agentCode = getObj("policy.agentcode");
		var isAgentCode ="${isAgentCode}";
		var applicantInsuredname = getObj("applicantInsured.name");//投保人姓名
		var applicantInsuredidentifytype = getObj('applicantInsured.identifytype');//投保人证件类型
		var applicantInsuredidentifynumber = getObj("applicantInsured.identifynumber");//投保人证件号
		var start= getObj("start");
		var bankProvince = document.getElementById("bankProvinceAddress").value=="省/市"?"":document.getElementById("bankProvinceAddress").value;//开户行地址
		var bankCity = document.getElementById("bankCityAddress").value=="市/区"?"":document.getElementById("bankCityAddress").value;//开户行地址
		var province = document.getElementById("province").value=="省/市"?"":document.getElementById("province").value;//投保人地址
		var city = document.getElementById("city").value=="市/区"?"":document.getElementById("city").value;//投保人地址
		var conty = document.getElementById("conty").value==null?"":document.getElementById("conty").value;//投保人地址 区/县
 		var adressText = document.getElementById("address").value==null?"":document.getElementById("address").value; //投保人地址
		var adressTemp = province+city+conty+"区/县"+adressText;//投保人地址
// 		alert(adressTemp);
		var regExp = /<\/?[^>]+>/gi; 
		var adress =  adressTemp.replace(regExp,""); 
		var recognizeeidentifynumber = getObj("recognizee.identifynumber");//被保人证件号
		var recognizeeSex = null
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
		
		if(isAgentCode=="1"){
			if(agentCode==null||agentCode.length==0){
				alert("请填写推荐人编码，如没有推荐人，请输入“0000”。");
				return false;
			}
		}
		 
		if(applicantInsuredidentifytype == 'I'){
			var age = parseInt(new Date().getFullYear()) - parseInt(applicantInsuredidentifynumber.substring(6,10));//投保人年龄
			if(!IdentityCodeValid(applicantInsuredidentifynumber,true)){
				return false;
			}
			var start = getBirth(applicantInsuredidentifynumber);
			var br =  $("#start").val().replace("年","-").replace("月","-").replace("日","");//取得生日
			if(start!=br){
				alert("投保人身份证号与生日不相符");
				return false;
			}else if(getSex(applicantInsuredidentifynumber)!=getObj("applicantInsured.sex")){
				alert("投保人身份证号与性别不相符");
				return false;
			}else if(age<18){
				alert("投保人需大于18周岁");
				return false;
			}
		}else{
			if(applicantInsuredidentifynumber==""||applicantInsuredidentifynumber.length==0){
				alert("请输入投保人证件号");
				return false;
			}else if(!check1(applicantInsuredidentifynumber,getObj("applicantInsured.identifytype"))){
				return false;
			}else if(start==""||start.length==0){
				alert("请输入出生日期！");
				return false;
			}
		}
		//校验投保人年龄
	  	var birthday = $("#start").val();
		var age =  parseInt(new Date().getFullYear()) - parseInt(birthday);
		if(age<18){
			alert("投保人年龄须在18以上");
			return false;
		} 
		//校验手机
		var phone = getObj("applicantInsured.mobile");
		var re1 = /^0?1[3|7|5|8][0-9]\d{8}$/;
		if(phone==""||phone.length==0){
			alert("请输入手机号！");
			return false;
		}else if(!re1.test(phone)){
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
		if(adress==""||adress.length==0){
			alert("请输入地址");
			return false;
		}else if(conty.length==""||conty.length==0){
			alert("请输入区/县信息");
			return false;
		}else if(adressText.length<6||adress.length>40){
			alert("请输入有效的地址");
			return false;
		}else if(!re3.test(adressText)){
			alert("请输入有效的地址！");
			return false;
		}else if(province==""||city==""||province.length==0||city.length==0){
			alert("请输入有效的地址");
			return;
		}else if(!/^[\u4e00-\u9fa5]{1,10}$/.test(conty)){
			alert("请输入有效的区/县地址");
			return false;
		}
		
		
		//校验银行
		var bank = document.getElementById("policy.bank").value;
		
		//校验被保人姓名
		if(getObj("recognizee.name")==""||getObj("recognizee.name").length==0){
			alert("请输入被保人姓名");
			return false;
		}else if(!/^[a-zA-Z ]{3,20}$/.test(getObj("recognizee.name"))&&!/^[\u4e00-\u9fa5]{2,10}$/.test(getObj("recognizee.name"))){
			alert("请输入正确的被保人姓名");
			return false;
		}else if(getObj("recognizee.name")==applicantInsuredname){
			alert("投被保人姓名不能一致");
			return false;
		}
		
		//校验续保标识
		var flag = document.getElementById("renewalflag").checked;//续保标志
		var reg = /^[0-9]{8,20}$/;//校验银行卡号为8到20之间的数字
		var bankAccountNumber = getObj("policy.bankAccountNumber");
		var bankName = getObj("policy.bank");
		
			if(flag){
				if (bankProvince==""||bankProvince.length==0&&bankCity==""||bankCity.length==0) {
					alert("如您选择续保，请填写开户行所在地！");
					return false;
					}
				if(bankName.length==0||bankName==""||bankAccountNumber.length==0||bankAccountNumber==""){
					alert("如果您选择续保，请填写续保银行及账号");
					return false;
				}else if(!reg.test(bankAccountNumber)) {
					alert("您输入的银行账号有误，请重新输入！");
					return false;
				}
		
			var arr=new Array();//校验银行卡号不能全部相同
			var fg;
			for(var i=0;i<bankAccountNumber.length;i++){
				arr[i]=bankAccountNumber.substring(i,i+1);
				if(arr[0]!=arr[i]){
					fg=true;
				}
			}
			if(fg!=true){
				  alert("您输入的银行账号有误，请重新输入！");
			        return;
			}
			
		}else{
			//if(bankName.length>0||bankAccountNumber.length>0){
			if(bankName.length>0&&bankAccountNumber.length>0){
				alert("请您先选择续保，再填写续保银行及账号");
				return false;
			}
		}
		
		
		
		
		if(getObj("recognizee.identifytype") == 'I'){
			
			if(!IdentityCodeValid(recognizeeidentifynumber,false)){
				return false;
			}
			
			var start = getBirth(recognizeeidentifynumber);
			var br =  '${birthday}';
			var birthday = br.replace('年','-').replace('月','-').replace('日','');
			if(start!=birthday){
				alert("被保人身份证号与生日不相符");
				return false;
			}else if(getSex(recognizeeidentifynumber)!=recognizeeSex){
				alert("被保人身份证号与性别不相符");
				return false;
			}
		}else{
			
			if(recognizeeidentifynumber.length==""||recognizeeidentifynumber.length==0){
				alert("请输入被保人证件号");
				return false;
			}else if(!check1(recognizeeidentifynumber,getObj("recognizee.identifytype"))){
				return false;
			}
		}
	//推荐人编码校验,推荐人编码为选填，填写了则判断brno是否为专属连接，不为专属链接推荐人编码为5到15位，为专属链接15位
	if(isAgentCode==1||agentCode!=""&&agentCode.length>0){
		if(brNo1=='A0000'||brNo1==null||brNo1.length==0){
			if(agentCode!=""||agentCode.length!=0){
				if(agentCode = "0000"){//如没有推荐人，请输入“0000”。
					return true;
				}else if(!regcode.test(agentCode)){
					alert("推荐人编码为5~15位的字母和数字，请重新输入！");
					return false;
				}else if(agentCode.length>15||agentCode.length<5){
					alert("推荐人编码为5~15位的字母和数字，请重新输入！");
					return false;
				}else{
					return true;
				}
			}
			return true; 
		}else{
			if(!regcode.test(agentCode)){
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
  	
	//type = true 投保人 flase 被保人
	function IdentityCodeValid(code,type) {
		            var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
		            var tip = "";
		            var pass= true;
		          if(!code || !/(^\d{15}$)|(^\d{17}(\d|X)$)/.test(code)){
					  if(type){
						  tip = "投保人身份证号格式错误";  
					  }else{
						  tip = "被保险人身份证号格式错误";
					  }
		               pass = false;
		                
		            }
		           if(!city[code.substr(0,2)]){
						if(type){
							tip = "投保人身份证地址编码错误";
						}else{
							tip = "被保人身份证地址编码错误";
						}
		                
		                pass = false;
		            }
		            else{
		                //18位身份证需要验证最后一位校验位
		                if(code.length == 18){
		                    code = code.split('');
		                    //∑(ai×Wi)(mod 11)
		                    //加权因子
		                    var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
		                    //校验位
		                    var parity=[1,0,'X',9,8,7,6,5,4,3,2];
		                    var sum = 0;
		                    var ai = 0;
		                    var wi = 0;
		                    for (var i = 0; i < 17; i++)
		                    {
		                        ai = code[i];
		                        wi = factor[i];
		                        sum += ai * wi;
		                    }
		                    var last = parity[sum % 11];
		                    if(parity[sum % 11] != code[17]){
							if(type){
								tip = "投保人身份证校验位错误";
							}else{
								tip = "被保人身份证校验位错误";
							}
		                        pass =false;
		                    }
		                }
		            }
		            if(!pass) alert(tip);
		            return pass;
			}
  
 		//保存投被保人信息并将页面跳转至健康告知
 		function save(){
 			//校验
 			var agentCode = getObj("policy.agentcode");
 			if(!check()){
 				return ;
 			}
 			var flag = document.getElementById("renewalflag").checked;//续保标志
 			if(flag){
 				document.getElementById("policy.renewalflag").value = "1";
 			}else{
 				document.getElementById("policy.renewalflag").value = "2";
 			}
 			var bankProvince = document.getElementById("bankProvinceAddress").value=="省/市"?"":document.getElementById("bankProvinceAddress").value;//开户行地址
 			var bankCity = document.getElementById("bankCityAddress").value=="市/区"?"":document.getElementById("bankCityAddress").value;//开户行地址
 			var province = document.getElementById("province").value=="省/市"?"":document.getElementById("province").value;//投保人地址
 			var city = document.getElementById("city").value=="市/区"?"":document.getElementById("city").value;//投保人地址
 			var conty = document.getElementById("conty").value==null?"":document.getElementById("conty").value;//投保人地址 区/县
 			var adressText = document.getElementById("address").value==null?"":document.getElementById("address").value; //投保人地址
 			var adressTemp = province+city+conty+"区/县"+adressText;//投保人地址
 			var regExp = /<\/?[^>]+>/gi; 
 			var address =  adressTemp.replace(regExp,"");
 			var br = $("#start").val().replace("年","-").replace("月","-").replace("日","");//取得生日
 			document.getElementById("policy.bankProvince").value=bankProvince;
			document.getElementById("policy.bankCity").value=bankCity;
 			document.getElementById("applicantInsured.address").value = address; 
 			document.getElementById("applicantInsured.birthday").value = br;
 			if(brNo1=='A0000'||brNo1==null||brNo1.length==0){
	 			if(agentCode!=null&&agentCode.length>0&&agentCode!="0000"){
	 				 var flag=false;
	 				 $.ajax({
	 					   type:"POST",
	 					   url:contentRootPath+"/msl/sales/existDepart",
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
 		
 		//身份证算生日
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
 		
 		
 		function changeBirth(){
 			var value = getObj("applicantInsured.identifynumber");
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
                return;
            }
            newDate = new Date(year, month - 1, day);
            if (newDate.toString() == "NaN") {
                return;
            }
            else {
            	var sex = getSex(value);
            	document.getElementById("applicantInsured.sex").value = sex;
            	//document.getElementById("start").value = year+"年"+month+"月"+day+"日";
            	document.getElementById("start").value = year+"-"+month+"-"+day+"";
            }
 		}
		
 		
 		function getSex(value){
 			if (parseInt(value.substr(16, 1)) % 2 == 1) {
 				return "M";
			} else {
				return "F"; 
			} 
 		}
 		
 		//取页面上的值
 		function getObj(id){
 			return document.getElementById(id).value;
 		}
	  	
 		//校验其它证件
 		function check1(value,type){
 			var result="";
 			var length=value.length;
 			if(type=="P"){
 				if(length <3){
 					alert('护照号码不得小于3个字符');
 					return false;
 				}
 			}
 			if(type=="M"){
 				if(length <8){
 					alert('港澳回乡证号码不得小于8个字符');
 					return false;
 				}
 			}
 			if(type=="T"){
 				if(length <8){
 					alert('台胞证号码不得小于8个字符');
 					return false;
 				}
 			}
 			if(type=="O"){
 				if(length <3){
 					alert('户口本号码不得小于3个字符');
 					return false;
 				}
 			}
 			if(type=="S"){
 				if(length <10||length >18){
 					alert('军官证或士兵证号码应在10到18个字符之间');
 					return false;
 				}
 			}
 			return true;
 		}
 		
 	//被保人证件号回显生日
	function hint(){
		var type = getObj("recognizee.identifytype");
		if(type=='O'){
			var brTemp = '${birthday}';
			brTemp = brTemp.replace("年","").replace("月","").replace("日","");
			document.getElementById("recognizee.identifynumber").value = brTemp;
		}else{
			document.getElementById("recognizee.identifynumber").value = "";
		}
	}
	/* function yuedu(){
		
		 if(document.getElementById("renewalflag").checked==true){
			document.getElementById("check").className='cbox checked';
		 }else{
		 	document.getElementById("check").className='cbox';
		 }
	} */

</script>
</html>
