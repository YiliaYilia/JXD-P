<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.com.sinosoft.web.domain.MakeTicketSignature"%>
<% 
request.setCharacterEncoding("UTF-8");
// String url = "http://testweixin.oldmutual-guodian.com/online/msl/sales/longPolicyHome";//测试
String url = "https://weixin.oldmutual-guodian.com/onlineApp/msl/sales/longPolicyHome";//生产
if(request.getQueryString()!=null){
	url = url+"?"+request.getQueryString();
}
MakeTicketSignature mts = new MakeTicketSignature();
String brNo = (String)session.getAttribute("brNo")==null?"":(String)session.getAttribute("brNo");
String brNoGYX = (String)request.getParameter("brNo")!=null?request.getParameter("brNo"):"";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>瑞泰人寿—一款给力的少儿重疾险</title>
<%@ include file="../../common/meta.jsp"%>
<%@ include file="../../common/rels.jsp"%>
<%@ include file="/common/page/common.jsp"%>

<link href="<%=request.getContextPath()%>/global/global/css/common.css?${random}" rel="stylesheet" />
<link	href="<%=request.getContextPath()%>/global/global/css/sale.css?${random}"	rel="stylesheet" />

<script	src="<%=request.getContextPath()%>/resources/lib/component/form.js"></script>
<script	src="<%=request.getContextPath()%>/resources/lib/jquery/validate/jquery.validator.js?${random}"></script>
<script	src="<%=request.getContextPath()%>/resources/lib/jquery/validate/local/zh_CN.js?${random}"></script>

<!--
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/global/css/bootstrap.min.css">
-->

<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/global/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/global/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/global/css/safe-new.css">
<style type="text/css">
/* Demo Page styling, you can disregard this in your implementation */
.header {
	padding: .625em;
	background: #5185a8;
}

.header h1 {
	margin: 0;
	padding: 0;
	color: #fff;
	text-align: center;
	font-size: 1.25em;
	font-weight: bold;
	text-shadow: 1px 1px 1px #000;
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
}

.content {
	padding: 1em;
}

.dwwr {
	width: 500px;
}

.dw-i {
	font-size: 1.8em;
}
</style>

<script>
        $(function () {

            // -------------------------------------------------------------------
            // Demo page code START, you can disregard this in your implementation
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
                
               

            // Demo page code END
            // -------------------------------------------------------------------
        });
    </script>
<!-- 	工具类 -->
<script	src="<%=request.getContextPath()%>/resources/lib/utils/dateUtils.js?${random}"	type="text/javascript"></script>
<script	src="<%=request.getContextPath()%>/resources/lib/utils/idCardUtils.js?${random}"	type="text/javascript"></script>
<script	src="<%=request.getContextPath()%>/resources/lib/utils/stringUtils.js?${random}"	type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
  $(".info1").click(function(){
	  $(this).addClass("info-select");
	  $(this).siblings().removeClass("info-select");
	  $(".info1-con").show();
	  $(".info1-con").siblings().hide();
	  
	  })
  $(".info2").click(function(){
	  $(this).addClass("info-select");
	  $(this).siblings().removeClass("info-select");
	  $(".info2-con").show();
	  $(".info2-con").siblings().hide();
	  
	  })
    $(".info3").click(function(){
	  $(this).addClass("info-select");
	  $(this).siblings().removeClass("info-select");
	  $(".info3-con").show();
	  $(".info3-con").siblings().hide();
	  
	  })
});
</script>
<%-- <script src="<%=request.getContextPath()%>/resources/resources/js/sales/fill.js?${random}"></script> --%>
</head>

<body>
	<div class="grace-head">
	</div>
	<div class="grace-banner">
		<img class="img" src="<%=request.getContextPath()%>/${imgUrl}" />
	</div>
	<div class="content">瑞泰成长卫士少儿重大疾病保险</div>
	<div class="center" style="border-top: 0px; margin-top: -30px;">
		<form
			action="<%=request.getContextPath()%>/msl/sales/longPolicyInsure"
			method="post" id="baseForm" name="form1">
			<table class="table" style="font-size: 1.5em;">
				<tr>
					<td colspan="2"
						style="text-align: center; font-size: 1.6em; font-family: '微软雅黑'; color: #666563;">被保险人信息</td>
				</tr>
				<tr>
					<td width=30% style="text-align: center;">出生日期：</td>
					<td width=70%><input class="data_input" type="date" id="start"
						name="start" onchange="trial();" /></td>
				</tr>
				<tr>
					<td style="text-align: center;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
					<td><select
						style="font-size: 1.0em; width: 35%; height: 34px;"
						id="recognizee.sex" name="recognizee.sex" onChange="trial();">
							<option value="M" style="font-size: 1.0em;">男</option>
							<option value="F" style="font-size: 1.0em;">女</option>
					</select></td>
				</tr>
				<tr>
					<td style="text-align: center;">投保份数：</td>
					<td><select id="count" name="policy.contnumber"
						style="font-size: 1.1em; width: 35%; height: 34px;"
						onChange="trial();">
							<option>5</option>
							<option >4</option>
							<option >3</option>
							<option >2</option>
							<option >1</option>
					</select>份</td>
				</tr>
				<tr>
					<td style="text-align: center;">保障期限：</td>
					<td>1年</td>
				</tr>
				<tr>
					<td style="text-align: center;">保&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;额：</td>
					<td><span><span id="coverage"
							style="color: red; font-size: 1.3">500000</span>元</span></td>
				</tr>
				<input type="hidden" id="recognizee.birthday"
					name="recognizee.birthday" value='${recognizee.birthday}'>
				<input type="hidden" id="policy.sumamount" name="policy.sumamount"
					value='${policy.sumamount}'>
				<input type="hidden" id="policy.sumbasepremium"
					name="policy.sumbasepremium" value='${policy.sumbasepremium}'>
			</table>
			<ul class="grace-buttonmoney">
				<li class="pull-left grace-button1">应付保费：
					<span id="sumbasepremium"></span>元
				</li>
				<li class="pull-right grace-button2" onclick="dosubmit();">立即投保</li>
			</ul>
		</form>
	</div>


	<div class="grace-info">
		<div class="info info-select info1">
			产品特色 <span> </span>
		</div>


		<div class="info info2">
			投保须知 <span> </span>
		</div>



		<div class="info info3">
			投保案例 <span> </span>
		</div>
	</div>
	<div>
		<div class="info1-con">
			<img src="<%=request.getContextPath()%>/uinew/images/con1.jpg"
				alt="" />
		</div>
		<div class="info2-con">
			<img src="<%=request.getContextPath()%>/uinew/images/con2.jpg"
				alt="" />
		</div>
		<div class="info3-con">
			<img src="<%=request.getContextPath()%>/uinew/images/con3.jpg"
				alt="" />
		</div>
	</div>


	<!-- 		提示框 -->
	<div class="modal fade" data-rule="alert" id="modal_alert">
		<div class="modal-dialog alert" style="margin-top: 320px;">
			<div class="modal-header clearfix">
				<span data-title="modal">提示信息</span><a type="button" class="close"
					data-dismiss="modal"></a>
			</div>
			<div class="modal-content" data-content="modal"></div>
			<div class="modal-footer">
				<a class="modal-btn btn" data-dismiss="modal" data-btn="modal">确定</a>
			</div>
		</div>
	</div>

	<!-- 		提示框 -->
	<div class="modal fade" data-rule="notice" id="modal_notice">
		<div class="modal-dialog alert" style="margin-top: 320px;">
			<div class="modal-header clearfix">
				<span data-title="modal">提示信息</span>
			</div>
			<div class="modal-content" data-content="modal"></div>
			<div class="modal-footer"></div>
		</div>
	</div>

	<!-- 		对话框 -->
	<div class="modal fade" data-rule="dialog">
		<div class="modal-dialog alert" style="margin-top: 320px;">
			<div class="modal-header clearfix">提示信息</div>
			<div class="modal-content" data-content="modal"></div>
			<div class="modal-footer">
				<a class="modal-btn btn inline" data-dismiss="modal" data-btn="ok">确定</a>
				<a class="modal-btn btn cancel inline" data-dismiss="modal"
					data-btn="cancel">取消</a>
			</div>
		</div>
	</div>

	<div class="modal fade" data-rule="loading" id="modal_loading">
		<div class="modal-dialog loading" style="margin-top: 320px;">
			<div class="modal-content" data-content="modal" style="height: 0;border: 0;">
				<p class="loader8">加载中......</p>
			</div>
		</div>
	</div>
	<div class="footer ">

		<img src="<%=request.getContextPath()%>/uinew/images/bottom-line.jpg"
			alt="" />
	</div>
</body>
<script type="text/javascript">
var brNo ="<%=brNo%>";
var brNoGYX ="<%=brNoGYX%>";
alert("brNo:"+brNo);
alert("brNoGYX:"+brNoGYX);
	
	$(".info").click(function(){
		$(".info_hid").css("display","none");
		$(this).next().css("display","block");  			
 		});
		var count = 1;
		var amntFormat = "";
		var sumpremium = "";
	  //保费试算
	 	if(brNo=="GI300"){
		 sumpremium=500000;
		/*  $("#count option[value='4']").remove();
		 $("#count option[value='3']").remove();
		 $("#count option[value='2']").remove();
		 $("#count option[value='1']").remove(); */
		 $("#count").attr("disabled","disabled");
		 
	 } 
	  
	  function trial(){
		  $("#coverage").html($("#count").val()*10+"0000.00"); 
		  $("#sumbasepremium").text(amntFormat);
		  var sex = $('#recognizee.sex').val();//取得性别
		  sex = document.getElementById("recognizee.sex").value
		  var birthday = $("#start").val().replace("年","-").replace("月","-").replace("日","");
		  //var birthday = $("#year").val()+"-"+$("#mon").val()+"-"+$("#day").val();//取得生日
		  var date = new Date(Date.parse(birthday));
		  var age = (new Date().getTime() - date.getTime())/(24 * 60 * 60 * 1000);
		  count = Number($("#count").val());//取得份数
		  sumpremium = 100000.00*count;
		  var Iage = GetAgeByBrithday(birthday);
		  if(birthday!=""&&birthday!=null&&count!=null&&count!=""&&age>=30&&Iage<18){
			  $.ajax({
				   type:"POST",
				   async: false,
				   url:contentRootPath+"/msl/sales/longPolicyCalculate",
				   data:{
					   "recognizee.birthday":birthday,
					   "recognizee.sex":sex,
					   "policy.sumamount":sumpremium
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
	  
	  //提交表单准备投保
	  function dosubmit(){
		  modal_loading();
		  var birthday = $("#start").val().replace("年","-").replace("月","-").replace("日","");//取得生日
		  var date = new Date(Date.parse(birthday));
		  var age = (new Date().getTime() - date.getTime())/(24 * 60 * 60 * 1000);
		  var Iage = GetAgeByBrithday(birthday);
		  if(birthday==""||birthday.length==0){
			  alert("请选择被保险人生日"); 
			  modal_loading('hide');
			  return false;
		  }else if(age<=30||Iage>18){
			  alert("被保险人的年龄限制为30天~18周岁");
			  modal_loading('hide');
			  return false;
		  }else if(amntFormat=='0.00'||amntFormat.length==0){
			  alert("保费为空");
			  modal_loading('hide');
			  return false;
		  }else{
			  trial();
			  document.getElementById("recognizee.birthday").value = birthday;
			  document.getElementById("policy.sumamount").value = sumpremium;//保额
			  document.getElementById("policy.sumbasepremium").value = amntFormat;//保费
			  $("#baseForm").submit();
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

<script>
function dataSelect()
{
strYYYY = document.form1.YYYY.outerHTML;
strMM = document.form1.MM.outerHTML;
strDD = document.form1.DD.outerHTML;
MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
//先给年下拉框赋内容
var y = new Date().getFullYear();
var str = strYYYY.substring(0, strYYYY.length - 9);
for (var i = (y-99); i < (y+1); i++) //以今年为准，前30年，后30年
{
str += "<option value='" + i + "'> " + i  + "</option>\r\n";
}
document.form1.YYYY.outerHTML = str +"</select>";
//赋月份的下拉框
var str = strMM.substring(0, strMM.length - 9);

for (var i = 1; i < 13; i++)
{
if(i<10){i="0"+i}
str += "<option value='" + i + "'> " + i  + "</option>\r\n";
}
document.form1.MM.outerHTML = str +"</select>";
document.form1.YYYY.value = y;
var MMtep= new Date().getMonth() + 1;
if(MMtep<10){MMtep="0"+MMtep}
document.form1.MM.value =MMtep;
var n = MonHead[new Date().getMonth()];
if (new Date().getMonth() ==1 && IsPinYear(YYYYvalue)) n++;
writeDay(n); //赋日期下拉框
document.form1.DD.value = new Date().getDate();
}
function YYYYMM(str) //年发生变化时日期发生变化(主要是判断闰平年)
{
var MMvalue = document.form1.MM.options[document.form1.MM.selectedIndex].value;
if (MMvalue == ""){DD.outerHTML = strDD; return;}
var n = MonHead[MMvalue - 1];
if (MMvalue ==2 && IsPinYear(str)) n++;
writeDay(n)
}
function MMDD(str) //月发生变化时日期联动
{
var YYYYvalue = document.form1.YYYY.options[document.form1.YYYY.selectedIndex].value;
if (str == ""){DD.outerHTML = strDD; return;}
var n = MonHead[str - 1];
if (str ==2 && IsPinYear(YYYYvalue)) n++;
writeDay(n)
}
function writeDay(n) //据条件写日期的下拉框
{
var s = strDD.substring(0, strDD.length - 9);
for (var i=1; i<(n+1); i++){
if(i<10){i="0"+i}
s += "<option value='" + i + "'> " + i + "</option>\r\n";
}
document.form1.DD.outerHTML = s +"</select>";
}
function IsPinYear(year)//判断是否闰平年
{ return(0 == year%4 && (year0 !=0 || year%400 == 0))}
</script>

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
// 		link="http://testweixin.oldmutual-guodian.com/online/share/share.html?source=longPolicyHome"; //测试
		link="https://weixin.oldmutual-guodian.com/onlineApp/share/share.html?source=longPolicyHome";	//生产
	}else{
// 		link="http://testweixin.oldmutual-guodian.com/online/share/share.html?source=longPolicyHome&brNO="+brNo;//测试
		link="https://weixin.oldmutual-guodian.com/onlineApp/share/share.html?source=longPolicyHome&brNO="+brNo;//生产
	}
	wx.showOptionMenu();
	var shareData = {
	        title: '瑞泰人寿少儿重疾险', // 分享标题
	        desc: "一款给力的少儿重疾险！50万保额！40种疾病！300元起！", // 分享描述
	        link:link,
	        imgUrl: "http://weixin.oldmutual-guodian.com/onlineApp/"+'${imgUrl}' // 分享图标
	    };
	  wx.onMenuShareAppMessage(shareData);//分享给朋友
	  
	  wx.onMenuShareTimeline({//分享至朋友圈
	        title: '瑞泰人寿少儿重疾险', // 分享标题
	        desc: "一款给力的少儿重疾险！50万保额！40种疾病！300元起！", // 分享描述
	        link:link,
	        imgUrl: "http://weixin.oldmutual-guodian.com/onlineApp/"+'${imgUrl}' // 分享图标
		    });
});	
	
wx.error(function (res) {
	//var df = window.location.href;
	//modal_alert({content:res.errMsg,btn:'确定'});
	});
</script>

</html>
