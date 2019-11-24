<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ include file="../../common/taglibs.jsp"%>
<%@ page import="cn.com.sinosoft.web.domain.MakeTicketSignature"%>
<% 
request.setCharacterEncoding("UTF-8");
String url= "https://weixin.oldmutual-guodian.com/onlineApp/msl/sales/WJBHomePage";
if(request.getQueryString()!=null){
	url = url+"?"+request.getQueryString();
}
MakeTicketSignature mts = new MakeTicketSignature();
String brNo = (String)session.getAttribute("brNo")==null?"":(String)session.getAttribute("brNo");
%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>稳驾保</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta name="format-detection" content="telephone=no"/>
    <link href="<%=request.getContextPath() %>/resources/css/common/main.min.css?${random}" rel="stylesheet"/>
    <link href="<%=request.getContextPath() %>/resources/css/animate/loader-ani.css" rel="stylesheet"/>
 	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/wjb/wjb.css " type="text/css"></link>
 	<script src="<%=request.getContextPath() %>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
  	<script src="<%=request.getContextPath() %>/resources/lib/common/main.js?${random}"></script>
  	<script src="<%=request.getContextPath()%>/resources/lib/component/modal.js"></script>
	<!-- Mobiscroll JS and CSS Includes -->
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.core.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.frame.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.scroller.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.util.datetime.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.datetimebase.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.datetime.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.select.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.listbase.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.image.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.treelist.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.frame.android.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.frame.android-holo.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.frame.ios-classic.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.frame.ios.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.frame.jqm.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.frame.sense-ui.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.frame.wp.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.android-holo-light.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.wp-light.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/mobiscroll.mobiscroll-dark.js"></script>

    <script src="<%=request.getContextPath()%>/resources/js/i18n/mobiscroll.i18n.zh.js"></script>

    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.animation.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.icons.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.frame.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.frame.android.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.frame.android-holo.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.frame.ios-classic.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.frame.ios.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.frame.jqm.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.frame.sense-ui.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.frame.wp.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.scroller.css"?${random} rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.scroller.android.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.scroller.android-holo.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.scroller.ios-classic.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.scroller.ios.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.scroller.jqm.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.scroller.sense-ui.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.scroller.wp.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.image.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.android-holo-light.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.wp-light.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/css/mobiscroll.mobiscroll-dark.css" rel="stylesheet" type="text/css" />

  </head>
  <style>
	.loader8{font-size:50px;}
  </style>
  
  <body style="position:relative;">
  	<!-- 正文 -->
  	<section class="product_wrap">
  		<img src="<%=request.getContextPath()%>/${imgUrl}" alt="产品图" class="product_img"/>
  		<div class="clear"></div>
  		<form action="<%=request.getContextPath()%>/msl/sales/wjbFill" method="post" id="baseForm" name="form1">
	  		<table class="info_table">
	  			<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>出生日期：</td>
					<td width=70%>	
						<input onclick="defaultDate();" class="txt14" style="width:60%;height:25px;" type="text" readonly="readonly" id="defaultStart"  placeholder="请选择出生日期"/>
						<input class="txt14" style="width:60%;height:25px;display:none;" type="text" readonly="readonly" id="start" name="start" onChange="changeBirthday();"/>
					</td>
				</tr>
	  			<tr>
	  				<td class="txt14" style="text-indent: 5%"><span class="must">*</span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</td>
	  				<td><select id="applicantInsured.sex" name="applicantInsured.sex" class="txt14" onChange="trial();">
		  					 	<option value="M">男</option>
		  					    <option value="F">女</option>
	  					</select> 	
	  				</td>
	  			</tr>
	  			<tr>
	  				<td class="txt14" style="text-indent: 5%"><span class="must">*</span>投保份数:</td>
	  				<td><select id="count" name="policy.contnumber" class="txt14" onChange="trial();">
		  					 	<option value="1">1份</option>
		  					    <option value="2">2份</option>
	  					</select> 	
	  				</td>
	  			</tr>
	  			<tr>
	  				<td class="txt14">基本保险金额:</td><td class="txt14"><span id="coverage">100000.00</span>元</td>
	  			</tr>
	  			<tr>
	  				<td class="txt14" style="text-indent: 5%"><span class="must">*</span>保险期间:</td>
	  				<td>
	  					<select class="txt14" style="width: 55%;" id="time" onChange="changeTime();">
	  						<option value="30">30年</option>
	  						<option value="75">至75周岁</option>
	  					</select>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td class="txt14" style="text-indent: 5%"><span class="must">*</span>缴费期间:</td>
	  				<td>
	  					<select class="txt14" style="width: 55%;" id="payment_time" name="payment_time" onChange="trial();">
	  						<option value="3">3年</option>
	  						<option value="5">5年</option>
	  						<option value="10">10年</option>
	  						<option value="20">20年</option>
	  					</select>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td class="txt14">首期保险费:</td><td class="txt14"><span id="sumbasepremium">0.00</span>元/年</td>
	  			</tr>
	  		</table>
	  		<input type="hidden" id="applicantInsured.identifynumber" name="applicantInsured.identifynumber" value='${applicantInsured.identifynumber}' />
	  		<input type="hidden" id="applicantInsured.birthday" name="applicantInsured.birthday" value='${applicantInsured.birthday}'>
   			<input type="hidden" id="policy.sumamount" name="policy.sumamount" value='${policy.sumamount}'>
   			<input type="hidden" id="policy.sumbasepremium" name="policy.sumbasepremium" value='${policy.sumbasepremium}'>
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
			<img src="<%=request.getContextPath() %>/resources/image/wjb/pro02.jpg" alt="产品图" class="product_img"/>
			<div class="clear"></div>
		</section>
		<section class="info" >
			<div class="info_left txt18" >2.条款及费率</div>
			<div class="right add">+</div>
			<div class="right minu" style="display: none;font-size: 2.4em;margin-top: -3px; ">-</div>
			<div class="clear"></div>
		</section>  
		<section class="info_hide txt14">
			<a href="<%=request.getContextPath()%>/resources/pdf/wjb/wjb_article.pdf">瑞泰稳驾保两全保险合同条款</a>
			<a href="<%=request.getContextPath()%>/resources/pdf/wjb/wjb_rate_tab.pdf">瑞泰稳驾保两全保险产品费率表</a>
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
	
	//设定默认日期
	function defaultDate(){
		  $("#defaultStart").hide();
		   $("#start").show();
		   $("#start").click();
	}
	$(function () {
            var demo, theme, mode, display, lang;
            demo = 'date';
            theme = 'android',
            mode = 'scroller',
            display = 'modal',
            dateFormat= 'yy年mm月dd日',
//             endYear=new Date().getFullYear(),
            lang = 'zh';
            $('.demo-cont').hide();
            $("#demo_cont_" + demo).show();
            init();
           function init() {
                // Date demo initialization
                $('#start').val("1985年1月1日").mobiscroll().date({
                    theme: theme,     // Specify theme like: theme: 'ios' or omit setting to use default 
                    mode: mode,       // Specify scroller mode like: mode: 'mixed' or omit setting to use default 
                    display: display, // Specify display mode like: display: 'bottom' or omit setting to use default 
                    lang: lang,        // Specify language like: lang: 'pl' or omit setting to use default 
					"height": 90,
               		dateFormat:dateFormat,
               		startYear:1900,
//                		endYear:endYear,
               		maxDate:new Date(new Date().getFullYear(),new Date().getMonth(),new Date().getDate()),
//                		 minDate:new Date(1985,1,1),
                });
               
            }    
            // -------------------------------------------------------------------
            // Demo page code START, you can disregard this in your implementation

            // Demo page code END
            // -------------------------------------------------------------------
            
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
		link="https://weixin.oldmutual-guodian.com/onlineApp/share/share.html?source=WENJIABAO";	//生产
	}else{
		link="https://weixin.oldmutual-guodian.com/onlineApp/share/share.html?source=WENJIABAO&brNO="+brNo;//生产
	}
	wx.showOptionMenu();
	var shareData = {
	        title: '稳驾保两全保险!', // 分享标题
	        desc: "稳驾保两全保险！", // 分享描述
	        link:link,
	        imgUrl: "http://weixin.oldmutual-guodian.com/onlineApp/"+'${imgUrl}' // 分享图标
	    };
	  wx.onMenuShareAppMessage(shareData);//分享给朋友
	  
	  wx.onMenuShareTimeline({//分享至朋友圈
	        title: '稳驾保两全保险!', // 分享标题
	        desc: "稳驾保两全保险！", // 分享描述
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
	
	$(".info").bind("click",function(){
		$(this).find(".add").toggle();
		$(this).find(".minu").toggle();
		$(this).next().toggle();
	});
 	
	//根据出生日期修改参数
	function changeBirthday(){
		$("#sumbasepremium").text('0.00');
		var birthday = $("#start").val().replace("年","-").replace("月","-").replace("日","");//取得生日 
		if(birthday == "" || birthday.length==0) {
			alert("请选择您的出生日期");
	    	return false;
		}else{
			var age = GetAgeByBrithday(birthday);  //年龄
	    	if(age<18||age>60){
		    	alert("本产品投保年龄为18周岁（含）至60周岁（含）");
	        	modal_loading('hide');
	        	return false;
			}else{
	        	//更改保险期间
	        	updateTime(age);
	        	//更改缴费期间
	        	updatePayment_time(age);
			}
	    	trial();
		}
		
	}
	
	
	function trial(){
		$("#coverage").html($("#count").val()*10+"0000.00"); 
		$("#sumbasepremium").text(amntFormat);
		var sex = document.getElementById("applicantInsured.sex").value;//取得性别
		var birthday = $("#start").val().replace("年","-").replace("月","-").replace("日","");//取得生日
		count = Number($("#count").val());//取得份数
		sumpremium = 100000.00*count;
		var age = GetAgeByBrithday(birthday);  //年龄
		var payYear = document.getElementById("payment_time").value; //缴费期间
		var time = $("#time").val();		//保险期间
		if(birthday!=""&&birthday!=null&&count!=null&&count!=""&&age>=18&&age<=60&&payYear!=""&&time!=""){
			$.ajax({
				type:"POST",
				async: false,
				url:"<%=request.getContextPath()%>/msl/sales/WJBPolicyCalculate",
				data:{
			    	"applicantInsured.birthday":birthday,
			    	"applicantInsured.sex":sex,
			  		"policy.sumamount":sumpremium,
			    	"policy.payYear":payYear,
			    	"time":time
				   },
				dataType:"json",
				success:function(data){
					var inputAmnt=Number(data.policy.sumbasepremium).toFixed(2);
					amntFormat=outputmoney(inputAmnt);
					$("#sumbasepremium").text(amntFormat);
					modal_loading('hide');
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
		var age = GetAgeByBrithday(birthday);
		if(birthday==""||birthday.length==0){
			alert("请选择被保险人生日"); 
			modal_loading('hide');
			return false;
		}else if(age<18||age>60){
			alert("本产品投保年龄为18周岁（含）至60周岁（含）");
	    	modal_loading('hide');
	    	return false;
		}else if(amntFormat=='0.00'||amntFormat.length==0){
			alert("保费为空");
			modal_loading('hide');
			return false;
		}else{
			trial();
			document.getElementById("applicantInsured.birthday").value = birthday;
			document.getElementById("policy.sumamount").value = sumpremium;//保额
			document.getElementById("policy.sumbasepremium").value = amntFormat;//保费
			$("#baseForm").submit();
		  }
		 
	  }
	
  	function getSex(value){
		if (parseInt(value.substr(16, 1)) % 2 == 1){
			return "M";
		}else{
			return "F"; 
		} 
	}
  	
  	//更改缴费期间
  	function updatePayment_time(age){
  		//默认显示4个
  		var obj = document.getElementById("payment_time");
  		document.getElementById("payment_time").options.length = 0;  
  		obj.add(new Option("3年",3));
  		obj.add(new Option("5年",5));
  		obj.add(new Option("10年",10));
  		obj.add(new Option("20年",20));
		if(age>45 && age<=55){
			$('#payment_time option[value="20"]').remove();
		}else if(age>55 && age<=60){
			$('#payment_time option[value="10"]').remove();
			$('#payment_time option[value="20"]').remove();
		}
  	}
  	
    //45岁时选择保险期间修改缴费期间
  	function changeTime(){
  		//默认显示4个
  		var obj = document.getElementById("payment_time");
  		document.getElementById("payment_time").options.length = 0;  
  		obj.add(new Option("3年",3));
  		obj.add(new Option("5年",5));
  		obj.add(new Option("10年",10));
  		obj.add(new Option("20年",20));
  		var $time = $("#time").val();
  		if($time==75){
			$('#payment_time option[value="20"]').remove();
		}
  		trial();
  	}
  	
    //根据年龄修改保险期间
	function updateTime(age){
  		//默认显示2个
  		var obj = document.getElementById("time");
  		document.getElementById("time").options.length = 0;  
  		obj.add(new Option("30年",30));
  		obj.add(new Option("至75周岁",75));
		if(age<45 && age>17){
			$('#time option[value="75"]').remove(); 
		}else if(age>45 && age<61){
			$('#time option[value="30"]').remove();
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
				if (todayDay - birthdayDay >= 0) {//alert(thisDay+'-'+brithd+"_ddd");
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
