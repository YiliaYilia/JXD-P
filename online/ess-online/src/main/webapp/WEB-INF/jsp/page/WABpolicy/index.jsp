<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ include file="../../common/taglibs.jsp"%>
<%@ page import="cn.com.sinosoft.web.domain.MakeTicketSignature"%>
<% 
request.setCharacterEncoding("UTF-8");
String url = "https://weixin.oldmutual-guodian.com/onlineApp/msl/sales/WABHomePage";
if(request.getQueryString()!=null){
	url = url+"?"+request.getQueryString();
}
MakeTicketSignature mts = new MakeTicketSignature();
String brNo = (String)session.getAttribute("brNo")==null?"":(String)session.getAttribute("brNo");
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>稳爱保</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta name="format-detection" content="telephone=no"/>
    <link href="<%=request.getContextPath() %>/resources/css/common/main.min.css?${random}" rel="stylesheet"/>
    <link href="<%=request.getContextPath() %>/resources/css/animate/loader-ani.css" rel="stylesheet"/>
 	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/wjx/wjx.css" type="text/css"></link>
 	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/wkb/wkb.css" type="text/css"></link>
 	<script src="<%=request.getContextPath()%>/resources/js/wab/wabJobCode.js?v=2"></script>
 	<script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
  </head>
  <style>
	.loader8{font-size:50px;}
  </style>
<body onload="backshow();_init_job();">
  <div class="wkb">
  	<!-- 正文 -->
  	<section class="product_wrap">
  		<img src="<%=request.getContextPath()%>/${imgUrl}" alt="产品图" class="product_img"/>
  		<div class="clear"></div>
  		<form action="<%=request.getContextPath()%>/msl/sales/wabFill" method="post" id="baseForm" name="form1">
  		<table class="info_table">
  			<tr>
  				<td class="txt14" style="text-indent: 5%;width:33%;"><span class="must">*</span>身份证号码:</td>
  				<td colspan="2"><input id="identifynumber" name="identifynumber" type="text" class="txt14" value='' onChange="changeIdNo();"/></td>
  			</tr>
  			
  			<tr>
  				<td class="txt14" style="text-indent: 5%"><span class="must">*</span>投保份数:</td>
  				<td colspan="2">
  					<select id="count" class="txt14" style="width: 55%;" onchange="trial();">
		  				<option value="5">5份</option>
		  				<option value="6">6份</option>
		  				<option value="7">7份</option>
		  				<option value="8">8份</option>
		  				<option value="9">9份</option>
		  				<option value="10">10份</option>
  					</select>
  				</td>
  			</tr>
  			<tr>
  				<td class="txt14"  style="text-indent: 2.3%;width:33%;">基本保险金额:</td><td class="txt14"><span id="coverage">500000.00</span>元</td>
  			</tr>
  			<tr>
  				<td class="txt14" style="text-indent: 5%"><span class="must">*</span>保障期限:</td>
  				<td colspan="2">
  					<select class="txt14" style="width: 55%;" id="time" onchange="changePT();trial();">
  						<option value="60">至60周岁</option>
  						<option value="65">至65周岁</option>
  						<option value="70">至70周岁</option>
  						<option value="75">至75周岁</option>
  						<option value="80">至80周岁</option>
  						<option value="100">至100周岁</option>
  					</select>
  				</td>
  			</tr>
  			<tr>
  				<td class="txt14" style="text-indent: 5%"><span class="must">*</span>缴费期限:</td>
  				<td colspan="2">
  					<select class="txt14" style="width: 55%;" id="payment_time" onchange="trial();">
  						<option value="10">10年</option>
  						<option value="20">20年</option>
  					</select>
	  			</td>
  			</tr>
  			<tr>
	  			<td class="txt14" style="text-indent: 5%;width:33%;"><span class="must">*</span>职&emsp;&emsp;业:</td>
  						<td width="30%" onchange="trial();">
		  					<select name="industry" id="industry" style="width:100%;"  ></select>
	  					</td>
	  					<td onchange="trial();">
	  						<select name="job" id="job" style="width:85%;"></select>
  						</td>
  					</div>
	  		</tr>
  			<tr>
  				<td class="txt14" style="text-indent: 2.3%;width:33%;">首期保险费:</td><td class="txt14"><span id="sumbasepremium">0.00</span>元/年</td>
  			</tr>
  		</table>
  			<input type="hidden" id="applicantInsured.identifynumber" name="applicantInsured.identifynumber" value='${applicantInsured.identifynumber}' />
	  		<input type="hidden" id="applicantInsured.birthday" name="applicantInsured.birthday" value='${applicantInsured.birthday}'>
	  		<input type="hidden" id="applicantInsured.sex" name="applicantInsured.sex" value='${applicantInsured.sex}'>
   			<input type="hidden" id="policy.sumamount" name="policy.sumamount" value='${policy.sumamount}'>
   			<input type="hidden" id="policy.sumbasepremium" name="policy.sumbasepremium" value='${policy.sumbasepremium}'>
   			<input type="hidden" id="policy.policyterm" name="policy.policyterm" value='${policy.policyterm}'>
   			<input type="hidden" id="policy.jobCode" name="policy.jobCode" value='${policy.jobCode}'>
   			<input type="hidden" id="policy.payYear" name="policy.payYear" value='${policy.payYear}'>
		 </form>
		  <!-- 按钮区域 -->
	   	<section class="btn_wrap">
	   		<div class="min_btn txt16" onclick="dosubmit();" style="background: #5b8de1;">立即投保</div>
	   	</section>
			<section class="wkb_info">
				<div class="info_left txt18">1.产品特色</div>
				<div class="right add">+</div>
				<div class="right minu" style="display: none;font-size: 2.4em;margin-top: -3px;">-</div>
				<div class="clear"></div>
			</section>  
			<section class="info_hide">
				<img src="<%=request.getContextPath()%>/resources/image/wab/pro02.jpg" alt="产品图" class="product_img"/>
				<div class="clear"></div>
			</section>
			<section class="wkb_info">
				<div class="info_left txt18">2.投保须知</div>
				<div class="right add">+</div>
				<div class="right minu" style="display: none;font-size: 2.4em;margin-top: -3px;">-</div>
				<div class="clear"></div>
			</section>  
			<section class="info_hide">
				<img src="<%=request.getContextPath()%>/resources/image/wab/pro03.jpg" alt="产品图" class="product_img"/>
				<div class="clear"></div>
			</section>
			<section class="wkb_info">
				<div class="info_left txt18">3.条款及费率</div>
				<div class="right add">+</div>
				<div class="right minu" style="display: none;font-size: 2.4em;margin-top: -3px;">-</div>
				<div class="clear"></div>
			</section>  
			<section class="info_hide txt14">
				<a href="<%=request.getContextPath()%>/resources/pdf/wab/wabht.pdf">瑞泰稳爱保定期寿险合同条款</a>
				<a href="<%=request.getContextPath()%>/resources/pdf/wab/wabfl.pdf">瑞泰稳爱保定期寿险产品费率表</a>
			</section>
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
<script src="https://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script>
wx.config({
	//开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
    debug: false,
  	//必填，公众号的唯一标识
    appId: '<%=mts.getAppid()%>', 
 	//必填，生成签名的时间戳
    timestamp: <%=mts.getTimestamp()%>,
 	//必填，生成签名的随机串
    nonceStr: '<%=mts.getNoncestr()%>',
 	//必填，签名，由jsapi_ticket获取
    signature: '<%=mts.getSignature(url)%>',
 	//必填，需要使用的JS接口列表，所有JS接口列表见附录2
    jsApiList: [
		'onMenuShareTimeline', 
		'onMenuShareAppMessage'
    ]
});



wx.ready(function () {
	var brNo = "<%=brNo%>";
	var link="";
	if(brNo==null||brNo=="A0000"||brNo.length==0){
		link="https://weixin.oldmutual-guodian.com/onlineApp/share/share.html?source=WENAIBAO";	//生产
	}else{
		link="https://weixin.oldmutual-guodian.com/onlineApp/share/share.html?source=WENAIBAO&brNO="+brNo;//生产
	}
	wx.showOptionMenu();
	var shareData = {
	        title: '稳爱保定期寿险!', // 分享标题
	        desc: "稳爱保定期寿险！", // 分享描述
	        link:link,
	        imgUrl: "http://weixin.oldmutual-guodian.com/onlineApp/"+'${imgUrl}' // 分享图标
	    };
	  wx.onMenuShareAppMessage(shareData);//分享给朋友
	  
	  wx.onMenuShareTimeline({//分享至朋友圈
	        title: '稳爱保定期寿险!', // 分享标题
	        desc: "稳爱保定期寿险！", // 分享描述
	        link:link,
	        imgUrl: "http://weixin.oldmutual-guodian.com/onlineApp/"+'${imgUrl}' // 分享图标
		    });
});	
	
wx.error(function (res) {
	//var df = window.location.href;
	//modal_alert({content:res.errMsg,btn:'确定'});
	});
</script>
<script>
	var count = 1;
	var amntFormat = "";
	var sumpremium = "";
	
  	$(".wkb_info").bind("click",function(){
		$(this).find(".add").toggle();
		$(this).find(".minu").toggle();
		$(this).next().toggle();
	});
	
  	//立即投保按钮
  	function dosubmit(){
  		var idno = document.getElementById("identifynumber").value.toUpperCase();
  		var sumbasepremium1 = $("#sumbasepremium").html();
  		
  		var industry = $("#industry").val();	//行业
  		var job = $("#job").val();	//职业
  		if(industry=="行业分类"||job=="职业类型"){
  			alert("请选择您的职业");
  			return false;
  		}else if(amntFormat=='0.00'||amntFormat.length==0||sumbasepremium1=='0.00'){
  			alert("保费为空");
			return false;
		}else{
		  	trial();
			document.getElementById("policy.sumamount").value = sumpremium;//保额
			document.getElementById("policy.sumbasepremium").value = amntFormat;//保费
			document.getElementById("applicantInsured.identifynumber").value = idno;//证件号
			document.getElementById("policy.policyterm").value =document.getElementById("time").value;//保障期间
			document.getElementById("policy.payYear").value =document.getElementById("payment_time").value;//缴费期限
			$("#baseForm").submit();
		}
  	}
  	
  	//保费试算
  	function trial(){
		document.getElementById("policy.sumbasepremium").value=null;
  		$("#coverage").html($("#count").val()*10+"0000.00");
  		var sex = document.getElementById("applicantInsured.sex").value;
  		var birthday = document.getElementById("applicantInsured.birthday").value;
  		var idno = document.getElementById("identifynumber").value.toUpperCase();
  		count = Number($("#count").val());//取得份数
  		sumpremium = 100000.00*count;
  		var time = document.getElementById("time").value;	//保障期限
  		var $payment_time = $("#payment_time").val();	//缴费期限
  		var industry = $("#industry").val();	//行业
  		var job = $("#job").val();	//职业
  		if(industry=="行业分类"||job=="职业类型"){
  			alert("请选择您的职业");
  			return false;
  		}
  		if(birthday!=""&&birthday!=null&&count!=null&&IdentityCodeValid(idno,true)){
  			var age =  GetAgeByBrithday(birthday);
	  		if(age>55||age<18){
	  			alert("投保人年龄必须在18至55岁之间");
	  			return false;
			}else{
	  			$.ajax({
					type:"POST",
					async: false,
					url:"<%=request.getContextPath()%>/msl/sales/WABPolicyCalculate",
					data:{
						"applicantInsured.birthday":birthday,
						"applicantInsured.sex":sex,
						"policy.sumamount":sumpremium,
						"policy.policyterm":time,
						"industry":industry,
						"job":job,
						"policy.payYear":$payment_time,
						"applicantInsured.identifynumber":idno
					},
					dataType:"json",
					success:function(data){
						if(data.policy.sumbasepremium == "0.001"){
							alert("因该单保费达到人民银行关于客户身份识别的标准，请线下投保");
							$("#sumbasepremium").text('0.00');
						}else{
							var inputAmnt=Number(data.policy.sumbasepremium).toFixed(2);
							amntFormat=outputmoney(inputAmnt);
							$("#sumbasepremium").text(amntFormat);
							var jobCode = data.policy.jobCode;
							document.getElementById("policy.jobCode").value=jobCode;
						}
					},
					error:function(){
						alert("系统繁忙");
					}
				});  
			}
		}else{
			  $("#sumbasepremium").text('0.00');
		}
  	}
	//页面回显
	function backshow(){
		_init_job();
		var bd = document.getElementById("identifynumber").value.toUpperCase();//身份证号
// 		var count = document.getElementById("count").value;//份数
// 		var time = document.getElementById("time").value;
// 		var payment_time = document.getElementById("payment_time").value;
// 		$("#count").val(count);
// 		$("#identifynumber").val(bd);
// 		$("#time").val(time);
// 		$("#payment_time").val(payment_time);
		if(bd != "" && bd.length != 0){
			changeIdNo();
// 			trial();
		}
	}
  	 
	//校验
	function changeIdNo(){
		$("#sumbasepremium").text('0.00');
  		//身份证验证
  		document.getElementById("policy.sumbasepremium").value=null;
		var value = document.getElementById("identifynumber").value.toUpperCase();
	  		
		var year = "1900";
	    var month = "1";
	    var day = "1";
	  	if(value==null||value.length==0){
	  		alert("请输入身份证号码！");
			return false;
	  	}else if(value.length !=15 && value.length !=18  ){
			alert("请输入正确的身份证号码！"); 
			return false;
		}else if(IdentityCodeValid(value,true)==false){
			return false;
		}
		if(value.length == 15){
        	year = "19" + value.substr(6, 2);
            month = value.substr(8, 2);
            day = value.substr(10, 2);
	    }else if(value.length == 18) {
	        year = value.substr(6, 4);
	        month = value.substr(10, 2);
	        day = value.substr(12, 2);
	    }else{
	        return;
	    }
	    newDate = new Date(year, month - 1, day);
	    if(newDate.toString() == "NaN") {
	    	return;
		}else{
	    	var sex = getSex(value);
	    	var birthday = year+"-"+month+"-"+day;
	        document.getElementById("applicantInsured.sex").value = sex;
	        document.getElementById("applicantInsured.birthday").value = year+"-"+month+"-"+day;
	        var age =  GetAgeByBrithday(birthday);
	        if(age<18||age>55){
	        	alert("投保人年龄必须在18至55岁之间");
	        	return false;
	        }else{
	        	// 更改份数
	        	changeCount(age);
	        	//更改缴费期间
	        	changePayment_time(age);
	        	//修改保障期间
	        	changeTime(age);
	        	var industry = $("#industry").val();	//行业
	      		var job = $("#job").val();	//职业
	      		if(industry=="行业分类"||job=="职业类型"){
	      			return false;
	      		}
	        	trial();
	        }
	    }
	}
	//修改保障期间
	function changeTime(age){
		//默认显示6个
  		var obj = document.getElementById("time");
  		document.getElementById("time").options.length = 0;  
  		obj.add(new Option("至60周岁",60));
  		obj.add(new Option("至65周岁",65));
  		obj.add(new Option("至70周岁",70));
  		obj.add(new Option("至75周岁",75));
  		obj.add(new Option("至80周岁",80));
  		obj.add(new Option("至100周岁",100));
  		if(age>50){
  			$('#time option[value="60"]').remove(); 
  		}
	}
	
	function changePT(){
		var birthday = document.getElementById("applicantInsured.birthday").value;
		var age =  GetAgeByBrithday(birthday);
		var time = $("#time").val();
		
		var obj = document.getElementById("payment_time");
  		document.getElementById("payment_time").options.length = 0;  
		if(time=="60"){
	  		obj.add(new Option("10年",10));
		}else if(age>45 && age<=55){
			obj.add(new Option("10年",10));
		}else{
			obj.add(new Option("10年",10));
	  		obj.add(new Option("20年",20));
		}
	}
	
	//缴费期间修改
	function changePayment_time(age){
		//默认显示2个
  		var obj = document.getElementById("payment_time");
  		document.getElementById("payment_time").options.length = 0;  
  		obj.add(new Option("10年",10));
  		obj.add(new Option("20年",20));
  		
  		var time = $("#time").val();
  		
		if(age>45 && age<=55){
			$('#payment_time option[value="20"]').remove(); 
		}
		if(time=="60"){
			$('#payment_time option[value="20"]').remove(); 
		}
		
	}
	
	//份数更改
  	function changeCount(age){
  		//默认显示6个
  		var obj = document.getElementById("count");
  		document.getElementById("count").options.length = 0;  
  		for(var i=5;i<=10;i++){ obj.add(new Option(i+"份",i)); }
		if(age>=46 && age <= 55){
			$('#count option[value="6"]').remove(); 
			$('#count option[value="7"]').remove();
			$('#count option[value="8"]').remove(); 
			$('#count option[value="9"]').remove();
			$('#count option[value="10"]').remove();
		}
	}
	
	//计算年龄
	function GetAgeByBrithday(birthday) {
		var age = 0;
		var today = new Date();
		var todayYear = today.getFullYear();
		var todayMonth = today.getMonth() + 1;
		var todayDay = today.getDate();
		var birthday1 = birthday.split("-");
		birthdayYear = parseInt(birthday1[0]);
		birthdayMonth = parseInt(birthday1[1]);
		birthdayDay = parseInt(birthday1[2]);
		if(todayYear - birthdayYear < 0){
			alert("出生日期选择错误!");
		}else{
			if(todayMonth * 1 - birthdayMonth * 1 < 0){
				age = (todayYear * 1 - birthdayYear * 1) - 1;
			}else if(todayMonth * 1 - birthdayMonth * 1 < 1){
				if(todayDay - birthdayDay >= 0) {//alert(thisDay+'-'+brithd+"_ddd");
					age = (todayYear * 1 - birthdayYear * 1);
				}else{
					age = (todayYear * 1 - birthdayYear * 1) - 1;
				}
			}else{
				age = (todayYear * 1 - birthdayYear * 1);
			}
		}
		return age * 1;
	}
	
	//性别获取
	function getSex(value){
		if (parseInt(value.substr(16, 1)) % 2 == 1){
			return "M";
		}else{
			return "F"; 
		} 
	}
	
	function IdentityCodeValid(code,type){var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};var tip="";var pass=true;if(!code||!/(^\d{15}$)|(^\d{17}(\d|X)$)/.test(code)){if(type){tip="投保人身份证号码格式错误"}else{tip="被保险人身份证号码格式错误"}pass=false}if(!city[code.substr(0,2)]){if(type){tip="投保人身份证地址编码错误"}else{tip="被保人身份证地址编码错误"}pass=false}else{if(code.length==18){code=code.split('');var factor=[7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2];var parity=[1,0,'X',9,8,7,6,5,4,3,2];var sum=0;var ai=0;var wi=0;for(var i=0;i<17;i++){ai=code[i];wi=factor[i];sum+=ai*wi}var last=parity[sum%11];if(parity[sum%11]!=code[17]){if(type){tip="投保人身份证校验位错误"}else{tip="被保人身份证校验位错误"}pass=false}}}if(!pass)alert(tip);return pass}

	function outputmoney(number) {
  		number = number.replace(/\,/g, "");
  		if(isNaN(number) || number == ""){
  			return "";
  		}
  		number = Math.round(number * 100) / 100;
  	    if (number < 0){
  	    	return '-' + outputdollars(Math.floor(Math.abs(number) - 0) + '') + outputcents(Math.abs(number) - 0);
  	    }
  	    else{
  	    	return outputdollars(Math.floor(number - 0) + '') + outputcents(number - 0);
  	    }
  	}

  	//格式化金额
  	function outputdollars(number) {
  	    if (number.length <= 3){
  	    	return (number == '' ? '0' : number);
  	    }else {
  	        var mod = number.length % 3;
  	        var output = (mod == 0 ? '' : (number.substring(0, mod)));
  	        for (var i = 0; i < Math.floor(number.length / 3); i++) {
  	            if ((mod == 0) && (i == 0)){
  	            	output += number.substring(mod + 3 * i, mod + 3 * i + 3);
  	            }
  	            else{
  	            	output += ',' + number.substring(mod + 3 * i, mod + 3 * i + 3);
  	            }
  	        }
  	        return (output);
  	    }
  	}

  	function outputcents(amount) {
  	    amount = Math.round(((amount) - Math.floor(amount)) * 100);
  	    return (amount < 10 ? '.0' + amount : '.' + amount);
  	}
	</script>
</html>
