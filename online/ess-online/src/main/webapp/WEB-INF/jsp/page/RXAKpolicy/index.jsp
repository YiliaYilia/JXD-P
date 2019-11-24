<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ include file="../../common/taglibs.jsp"%>
<%@ page import="cn.com.sinosoft.web.domain.MakeTicketSignature"%>
<% 
request.setCharacterEncoding("UTF-8");
String url= "https://weixin.oldmutual-guodian.com/onlineApp/msl/sales/RXAKHomePage";
if(request.getQueryString()!=null){
	url = url+"?"+request.getQueryString();
}
MakeTicketSignature mts = new MakeTicketSignature();
String brNo = (String)session.getAttribute("brNo")==null?"":(String)session.getAttribute("brNo");
%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>瑞享安康</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta name="format-detection" content="telephone=no"/>
    <link href="<%=request.getContextPath() %>/resources/css/common/main.min.css?v=1.00" rel="stylesheet"/>
    <link href="<%=request.getContextPath() %>/resources/css/animate/loader-ani.css" rel="stylesheet"/>
 	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/wjb/wjb.css " type="text/css"></link>
 	<script src="<%=request.getContextPath() %>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
  	<script src="<%=request.getContextPath() %>/resources/lib/common/main.js?v=1.00"></script>
  	<script src="<%=request.getContextPath()%>/resources/lib/component/modal.js"></script>
	<jsp:include page="../../common/Mobiscroll.jsp"></jsp:include>
  </head>
  <style>
	.loader8{font-size:50px;}
  </style>
  <body style="position:relative;" onload="backshow();">
  	<!-- 正文 -->
  	<section class="product_wrap">
  		<img src="<%=request.getContextPath()%>/${imgUrl}" alt="产品图" class="product_img"/>
  		<div class="clear"></div>
  		<form action="<%=request.getContextPath()%>/msl/sales/rxakFill" method="post" id="baseForm" name="form1">
	  		<table class="info_table">
	  			<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>出生日期：</td>
					<td width=70%>	
						<input onclick="defaultDate();" class="txt14" style="width:60%;height:25px;" type="text" readonly="readonly" id="defaultStart"  placeholder="被保险人出生日期"/>
						<input class="txt14" style="width:60%;height:25px;display:none;" type="text" readonly="readonly" id="start" name="start" onchange="changeBirthday();"/>
					</td>
				</tr>
	  			<tr>
	  				<td class="txt14" style="text-indent: 5%"><span class="must">*</span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
	  				<td><select id="recognizee.sex" name="recognizee.sex" class="txt14" onchange="trial();">
		  					 	<option value="M">男</option>
		  					    <option value="F">女</option>
	  					</select> 	
	  				</td>
	  			</tr>
	  			<tr>
	  				<td class="txt14" style="text-indent: 5%"><span class="must">*</span>保险金额：</td>
	  				<td class="txt14"><input id="coverage" name="coverage" type="text" style="width:35%;height:25px;" onchange="trial();" placeholder="10~41.6"/>万元</td>
	  			</tr>
	  			<tr>
	  				<td class="txt14" style="text-indent:5%;color:red;"><span class="must"></span>温馨提示：</td>
	  				<td class="txt14" style="color:red;">保险金额10万起售，且须为1000元整倍数</td>
	  			</tr>
	  			<tr>
	  				<td class="txt14" style="text-indent: 5%"><span class="must">*</span>缴费期间：</td>
	  				<td>
	  					<select class="txt14" style="width: 55%;" id="PayEndYear" name="PayEndYear" onchange="trial();">
	  						<option value="0">趸交</option>
	  						<option value="3">3年</option>
	  						<option value="5">5年</option>
	  						<option value="10">10年</option>
	  						<option value="20">20年</option>
	  					</select>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td class="txt14" >保险期间：</td><td class="txt14"><span>保终身</span></td>
	  			</tr>
	  			<tr>
	  				<td class="txt14">首期保险费：</td><td class="txt14"><span id="sumbasepremium">0.00</span>元/年</td>
	  			</tr>
	  		</table>
	  		<input type="hidden" id="recognizee.birthday" name="recognizee.birthday" value='${recognizee.birthday}'>
   			<input type="hidden" id="policy.sumamount" name="policy.sumamount" value='${policy.sumamount}'>
   			<input type="hidden" id="policy.sumbasepremium" name="policy.sumbasepremium" value='${policy.sumbasepremium}'>
   			<input type="hidden" id="policy.payYear" name="policy.payYear" value='${policy.payYear}'>
  		</form>
		  <!-- 按钮区域 -->
	   	<section class="btn_wrap">
	   		<div class="min_btn txt16" onclick="dosubmit();">立即投保</div>
	   	</section>
		<section class="info" >
			<div class="info_left txt18">1.产品特色</div>
			<div class="right add">+</div>
			<div class="right minu" style="display: none;font-size: 2.4em;margin-top: -3px;">-</div>
			<div class="clear"></div>
		</section>  
		<section class="info_hide">
			<img src="<%=request.getContextPath() %>/resources/image/rxak/pro02.jpg" alt="产品图" class="product_img"/>
			<div class="clear"></div>
		</section>
		<section class="info" >
			<div class="info_left txt18" >2.条款及费率</div>
			<div class="right add">+</div>
			<div class="right minu" style="display: none;font-size: 2.4em;margin-top: -3px; ">-</div>
			<div class="clear"></div>
		</section>  
		<section class="info_hide txt14">
			<a href="<%=request.getContextPath()%>/resources/pdf/rxak/rxak_article.pdf">瑞泰瑞享安康重大疾病保险合同条款</a>
			<a href="<%=request.getContextPath()%>/resources/pdf/rxak/rxak_rate_tab.pdf">瑞泰瑞享安康重大疾病保险产品费率表</a>
		</section>
  	</section>
  	<div class="footer">
		<div class="img_div"><img class="logoimg" src="<%=request.getContextPath()%>/global/global/images/logo.png"></div>
		<div class="addr_div txt12">
			<div class="foot_span">客户服务专线：4008109339</div>
			<div class="foot_span">网址：www.oldmutual-chnenergy.com</div>
		</div>
	<div class="clear"></div>
	</div>
<script type="text/javascript">
	//mobiscroll初始化
	$(function () {
		var demo, theme, mode, display, lang;
		demo = 'date';
    	theme = 'wp',
   		mode = 'scroller',
		display = 'modal',
		dateFormat= 'yy年mm月dd日',
		lang = 'zh';
		$('.demo-cont').hide();
		$("#demo_cont_" + demo).show();
		init();
		function init() {
        	$('#start').val("1985年1月1日").mobiscroll().date({
            	theme: theme,     
                mode: mode,       
                display: display, 
                lang: lang,     
				"height": 90,
           		dateFormat:dateFormat,
           		startYear:1900,
   				maxDate:new Date(new Date().getFullYear(),new Date().getMonth(),new Date().getDate()),
			});
		}    
	});
</script>
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
		link="https://weixin.oldmutual-guodian.com/onlineApp/share/share.html?source=RUIXANKANG";	//生产
	}else{
		link="https://weixin.oldmutual-guodian.com/onlineApp/share/share.html?source=RUIXANKANG&brNO="+brNo;//生产
	}
	wx.showOptionMenu();
	var shareData = {
	        title: '瑞享安康重大疾病保险!', // 分享标题
	        desc: "瑞享安康重大疾病保险！", // 分享描述
	        link:link,
	        imgUrl: "http://weixin.oldmutual-guodian.com/onlineApp/"+'${imgUrl}' // 分享图标
	    };
	  wx.onMenuShareAppMessage(shareData);//分享给朋友
	  
	  wx.onMenuShareTimeline({//分享至朋友圈
	        title: '瑞享安康重大疾病保险!', // 分享标题
	        desc: "瑞享安康重大疾病保险！", // 分享描述
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
	var amntFormat = "";
	var sumpremium = "";
	
	$(".info").bind("click",function(){
		$(this).find(".add").toggle();
		$(this).find(".minu").toggle();
		$(this).next().toggle();
	});
	
	function backshow(){
		var birthday = sessionStorage.getItem("birthday"); 
		var sex = sessionStorage.getItem("sex"); 
		var sumpremium = sessionStorage.getItem("sumpremium")/10000; 
		var payYear = sessionStorage.getItem("payYear");
		if(birthday != null ){
			document.getElementById("defaultStart").value = birthday;
			document.getElementById("start").value = birthday;
		}
		if(sex != null){
			document.getElementById("recognizee.sex").value = sex;
		}
		if(sumpremium != null && sumpremium != 0){
			document.getElementById("coverage").value = sumpremium;
		}
		if(payYear != null){
			document.getElementById("PayEndYear").value = payYear;
		}
		if(birthday != null && sex != null && sumpremium != null && payYear != null){
			trial();
		}
	}
	
	//设定默认日期
	function defaultDate(){
		  $("#defaultStart").hide();
		   $("#start").show();
		   $("#start").click();
	}
	
	function trial(){
		if(!check()){
			return;
		}
		$("#sumbasepremium").text(amntFormat);
		var sex = document.getElementById("recognizee.sex").value;//取得性别
		var birthday = $("#start").val().replace("年","-").replace("月","-").replace("日","");//取得生日
		coverage = Number($("#coverage").val());//取得保额
		sumpremium = 10000.00*coverage;	//总保额万元转元
		var age = GetAgeByBrithday(birthday);  //年龄
		var payYear = document.getElementById("PayEndYear").value; //缴费期间
		var date = new Date(Date.parse(birthday));
		var day = (new Date().getTime() - date.getTime())/(24 * 60 * 60 * 1000); //出生天数
		if(birthday!=""&&birthday!=null&&day>30&&age<=60){
			$.ajax({
				type:"POST",
				async: false,
				url:"<%=request.getContextPath()%>/msl/sales/RXAKPolicyCalculate",
				data:{
			    	"recognizee.birthday":birthday,
			    	"recognizee.sex":sex,
			  		"policy.sumamount":sumpremium,
			    	"policy.payYear":payYear,
			    	"age":age
				   },
				dataType:"json",
				success:function(data){
					if(data.policy.sumbasepremium == "0.001"){
						alert("因该单保费达到人民银行关于客户身份识别的标准，请线下投保");
						$("#sumbasepremium").text('0.00');
					}else if(data.policy.sumbasepremium == "0.002"){
						alert("您所投保的基本保险金额以超限，需提供近期体检报告");
						$("#sumbasepremium").text('0.00');
					}else{
						var inputAmnt=Number(data.policy.sumbasepremium).toFixed(2);
						amntFormat=outputmoney(inputAmnt);
						$("#sumbasepremium").text(amntFormat);
						modal_loading('hide');
					}
				}
			}); 
		}else{
			$("#sumbasepremium").text('0.00');
		}
	}
	
	//立即投保按钮
	function dosubmit(){
		modal_loading();
		var birthday = $("#start").val().replace("年","-").replace("月","-").replace("日","");//取得生日
		if(!check()){
			modal_loading('hide');
			return;
		}
		if(amntFormat=='0.00'||amntFormat.length==0){
			alert("保费为空");
			modal_loading('hide');
			return false;
		}else{
			var payYear = document.getElementById("PayEndYear").value; //缴费期间
			var sex = document.getElementById("recognizee.sex").value;//取得性别
			document.getElementById("recognizee.birthday").value = birthday;
			document.getElementById("policy.sumamount").value = sumpremium;//保额
			document.getElementById("policy.sumbasepremium").value = amntFormat;//保费
			document.getElementById("policy.payYear").value = payYear;
			
			sessionStorage.setItem("birthday", birthday); 
			sessionStorage.setItem("sex", sex); 
			sessionStorage.setItem("sumpremium", sumpremium); 
			sessionStorage.setItem("payYear", payYear); 
			
			$("#baseForm").submit();
		  }
	}
	
	//根据出生日期修改参数,并计算保费
	function changeBirthday(){
		$("#sumbasepremium").text('0.00');
		var birthday = $("#start").val().replace("年","-").replace("月","-").replace("日","");//取得生日 
		if(birthday == "" || birthday.length==0) {
			alert("请选择您的出生日期");
	    	return false;
		}else{
			var date = new Date(Date.parse(birthday));
			var day = (new Date().getTime() - date.getTime())/(24 * 60 * 60 * 1000); //出生天数
			var age = GetAgeByBrithday(birthday);  //年龄
	    	if(day<=30||age>=60){
		    	alert("本产品投保年龄为出生满30天，且小于60周岁");
	        	return false;
			}else{
// 	        	更改缴费期间
	        	updatePayment_time(age);
	        	trial();
			}
		}
	}
	
	function check(){
		//出生日期
		var birthday = $("#start").val().replace("年","-").replace("月","-").replace("日","");//取得生日 
		var date = new Date(Date.parse(birthday));
		var day = (new Date().getTime() - date.getTime())/(24 * 60 * 60 * 1000); //出生天数
		var age = GetAgeByBrithday(birthday);  //年龄
		if(birthday == "" || birthday.length==0) {
			alert("请选择您的出生日期");
	    	return false;
		}
		if(day<=30||age>=60){
			alert("本产品投保年龄为出生满30天，且小于60周岁");
	    	return false;
		}
		//保额
		coverage = Number($("#coverage").val());//取得保额
		sumpremium = 10000.00*coverage;	//总保额万元转元
		if(coverage =="0" || coverage == null){
// 			alert("请填写保额");
			return false;
		}
		if(coverage=="NaN" || sumpremium%1000!=0){
			alert("请填写正确的保额");
			return false;
		}
		if(coverage<10 || coverage>41.6){
			alert("基本保险金额最低10万元，最高41.6万元，且须为1000元的整数倍");
			return false;
		}
		
		if(birthday!=""&&birthday!=null&&coverage!=""&&coverage!=null){
			return true;
		}
	}
  	
  	//更改缴费期间
  	function updatePayment_time(age){
  		//默认显示5个
  		var obj = document.getElementById("PayEndYear");
  		document.getElementById("PayEndYear").options.length = 0;  
  		obj.add(new Option("趸交",0));
  		obj.add(new Option("3年",3));
  		obj.add(new Option("5年",5));
  		obj.add(new Option("10年",10));
  		obj.add(new Option("20年",20));
		if(age>45){
			$('#PayEndYear option[value="20"]').remove();
		} 
		if(age>55){
			$('#PayEndYear option[value="10"]').remove();
		}
		if(age>60){
			$('#PayEndYear option[value="5"]').remove();
		}
		if(age>65){
			$('#PayEndYear option[value="3"]').remove();
		}
  	}
  	
  	function getSex(value){
		if (parseInt(value.substr(16, 1)) % 2 == 1){
			return "M";
		}else{
			return "F"; 
		} 
	}
  	
  	function IdentityCodeValid(code,type){var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};var tip="";var pass=true;if(!code||!/(^\d{15}$)|(^\d{17}(\d|X)$)/.test(code)){if(type){tip="投保人身份证号格式错误"}else{tip="被保险人身份证号格式错误"}pass=false}if(!city[code.substr(0,2)]){if(type){tip="投保人身份证地址编码错误"}else{tip="被保人身份证地址编码错误"}pass=false}else{if(code.length==18){code=code.split('');var factor=[7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2];var parity=[1,0,'X',9,8,7,6,5,4,3,2];var sum=0;var ai=0;var wi=0;for(var i=0;i<17;i++){ai=code[i];wi=factor[i];sum+=ai*wi}var last=parity[sum%11];if(parity[sum%11]!=code[17]){if(type){tip="投保人身份证校验位错误"}else{tip="被保人身份证校验位错误"}pass=false}}}if(!pass)alert(tip);return pass}
  	
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
		if (todayYear - birthdayYear < 0) {
			alert("出生日期选择错误!");
		} else {
			if (todayMonth * 1 - birthdayMonth * 1 < 0) {
				age = (todayYear * 1 - birthdayYear * 1) - 1;
			}
			else if(todayMonth * 1 - birthdayMonth * 1 < 1){
				if (todayDay - birthdayDay >= 0) {
					age = (todayYear * 1 - birthdayYear * 1);
				} else {
					age = (todayYear * 1 - birthdayYear * 1) - 1;
				}
			}
			else {
				age = (todayYear * 1 - birthdayYear * 1)
			}
		}
		return age * 1;
	}
</script>
</html>