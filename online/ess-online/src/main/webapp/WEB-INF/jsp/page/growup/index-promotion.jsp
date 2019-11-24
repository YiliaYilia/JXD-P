<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.com.sinosoft.web.domain.MakeTicketSignature"%>
<% 
request.setCharacterEncoding("UTF-8");
String url = "http://weixin.oldmutual-guodian.com/onlineApp/msl/sales/PreferentialIntroduce?"+request.getQueryString();
MakeTicketSignature mts = new MakeTicketSignature();
%>
<!DOCTYPE HTML>
<html>
  <head>
  <title>瑞泰人寿少儿重疾险</title>
	<%@ include file="../../common/meta.jsp"%>
	<%@ include file="../../common/rels.jsp"%>
	<link href="<%=request.getContextPath()%>/global/global/css/common.css?${random}" rel="stylesheet"/>
	<link href="<%=request.getContextPath()%>/global/global/css/sale.css?${random}" rel="stylesheet"/>
	
	<script src="<%=request.getContextPath() %>/resources/lib/component/form.js"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/validate/jquery.validator.js?${random}"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/validate/local/zh_CN.js?${random}"></script>
<!-- 	日期控件 -->
  <meta charset="utf-8">

    <!-- jQuery Include -->
    <script src="js/jquery-1.11.1.min.js"></script>

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
     
    <style type="text/css">
        /* Demo Page styling, you can disregard this in your implementation */
        .header { padding: .625em; background: #5185a8;}
        .header h1 { margin: 0; padding: 0; color: #fff; text-align: center; font-size: 1.25em; font-weight: bold; text-shadow: 1px 1px 1px #000; text-overflow: ellipsis; overflow: hidden; white-space: nowrap; }
        .content { padding: 1em; }
      
		 .dwwr{width:500px;}
        .dw-i{font-size: 1.8em;}
    </style>

     <script>
        $(function () {

           function init() {
                
                // Date demo initialization
                $('#start').mobiscroll().date({
                    theme: theme,     // Specify theme like: theme: 'ios' or omit setting to use default 
                    mode: mode,       // Specify scroller mode like: mode: 'mixed' or omit setting to use default 
                    display: display, // Specify display mode like: display: 'bottom' or omit setting to use default 
                    lang: lang,        // Specify language like: lang: 'pl' or omit setting to use default 
					"height": 90,
               		dateFormat:dateFormat,
               		endYear:endYear,
               		
                });
                
            }    

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
                
                init();

            // Demo page code END
            // -------------------------------------------------------------------
        });
    </script>

<!-- 	工具类 -->
	<script src="<%=request.getContextPath()%>/resources/lib/utils/dateUtils.js?${random}" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/utils/idCardUtils.js?${random}" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/utils/stringUtils.js?${random}" type="text/javascript"></script>
	
	<%-- <script src="<%=request.getContextPath()%>/resources/resources/js/sales/fill.js?${random}"></script> --%>
  </head>

  <body>
   		<img class="img" src="<%=request.getContextPath()%>/global/global/images/home_1z.jpg"/>
   		<div class="content">瑞泰成长卫士少儿重大疾病保险</div>
   		
   		<div class="center">
   		<form action="<%=request.getContextPath()%>/msl/sales/insurePromotion" method="post" id="baseForm" name="form1">
   		<table class="table">
   		<td colspan="2" style="text-align:center;" >请填写被保险人信息</td></tr> 
   				<tr>
   				<td width=30% style="text-align:center;">出生日期：</td>
   				<td width=70% ><input  class="data_input" type=text  id="start" name="start" readonly="readonly" onchange="trial();"/></td>
   			</tr>
   			<tr>
   				<td style="text-align: center;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
   				<td >
   					<select style="font-size:1.0em;width:30%;height:34px;" id="recognizee.sex" name="recognizee.sex" onChange="trial();">
   						<option value="M">男</option>
   						<option value="F">女</option>
   					</select>
   				</td>
   			</tr>
   			<tr>
   				<td  style="text-align: center;">投保份数：</td>
   				<td  ><select id="count" style="font-size:1.0em;width:30%;height:34px;" onChange="trial();">
   						<option>3</option>
   						<option>2</option>
   						<option>1</option>
   					</select>份</td>
   			</tr>
   			<tr>
   				<td style="text-align: center;">保障期限：</td>
   				<td >1年</td>
   			</tr>
   			<tr>
   				<td style="text-align: center;">保&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;额：</td>
   				<td ><span id="coverage" style="color: red;">100000.00</span>元</td>
   			</tr>
   			
   			<td width=30% style="text-align:center;">优&nbsp;&nbsp;惠&nbsp;&nbsp;码：</td>
   				<td width=70% ><input style="height:35px;font-size:1.2em;width:30%;" type="text" name="policy.preferentialcode" id="policy.preferentialcode" onChange="trial();" /></td>
   			<tr>
   				<td style="text-align: center;">原&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价：</td>
   				<td><span><s><span id="original" style="color:red;font-size: 1.3"></span></s>元</span></td>
   			</tr>
   			
   			 <tr>
   				<td style="text-align: center;">优&nbsp;&nbsp;惠&nbsp;&nbsp;价：</td>
   				<td><span><span id="sumbasepremium" style="color:red;font-size: 1.3"></span>元</span></td>
   			</tr>
   			<input type="hidden" id="recognizee.birthday" name="recognizee.birthday" value='${recognizee.birthday}'>
   			<input type="hidden" id="policy.sumamount" name="policy.sumamount" value='${policy.sumamount}'>
   			<input type="hidden" id="policy.sumbasepremium" name="policy.sumbasepremium" value='${policy.sumbasepremium}'>
   			<!-- 活动码 -->
   			<input type="hidden" name="ActyNo" value='discont1'>
   		</table>
   		</form>
		  <div class="btn" onclick="dosubmit();">立&nbsp;即&nbsp;投&nbsp;保</div>
   		</div>
   		<div class="info"style="margin-top:30px;">
   			<div class="left">1.产品特色</div> 
   			<div class="right">+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div> 
   			<div class="clear"></div>
   		</div>
		<div class="info_hid" style="display: none;">
   			<img/ src="<%=request.getContextPath()%>/global/global/images/growup_item1.jpg">
   			<img/ src="<%=request.getContextPath()%>/global/global/images/growup_plan.png">
   		</div>
		
		
   		<div class="info">
   			<div class="left">2.投保须知 </div> 
   			<div class="right">+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div> 
   			<div class="clear"></div>
   		</div>
		<div class="info_hid" style="display: none;">
   			<img/ src="<%=request.getContextPath()%>/global/global/images/growup_content1.jpg">
   		</div>
		
   		<jsp:include page="../../common/common-modal.jsp"></jsp:include>
   		<jsp:include page="../../common/footer.jsp"></jsp:include>
   		
  </body>
<script type="text/javascript">
	$(".info").click(function(){
		$(".info_hid").css("display","none");
		$(this).next().css("display","block");  			
 		});
		var count = 1;
		var amntFormat = "";
		var sumpremium = "";
	  //保费试算
	  function trial(){
		  $("#coverage").html($("#count").val()*10+"0000.00");
		  $("#sumbasepremium").text(amntFormat);
		  var preCode =  document.getElementById("policy.preferentialcode").value;
		  var sex = $('#recognizee.sex').val();//取得性别
		  sex = document.getElementById("recognizee.sex").value
		  var birthday = $("#start").val().replace("年","-").replace("月","-").replace("日","");//取得生日
		  var Iage = GetAgeByBrithday(birthday);
		  var date = new Date(Date.parse(birthday));
		  var age = (new Date().getTime() - date.getTime())/(24 * 60 * 60 * 1000);
		  count = Number($("#count").val());//取得份数
		  sumpremium = 100000.00*count
		  if(birthday!=""&&birthday!=null&&count!=null&&count!=""&&sex!=""&&sex!=null&&age>=30&&Iage<18){
			  $.ajax({
				   type:"POST",
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
						$("#original").text(amntFormat);
						if(preCode!=null&&preCode!=""&&preCode.length>0){
						    amntFormat = changeAmount(amntFormat);
						    $("#sumbasepremium").text(amntFormat+'.00');
						}else{
							$("#sumbasepremium").text(amntFormat);
						}
					    modal_loading('hide');
					}
				}); 
		  }else{
			  $("#sumbasepremium").text('0.00');
			  $("#original").text('0.00');
		  }
	  }
	  //计算优惠后的保费      
	  function changeAmount(value){
		  var birthday = $("#start").val().replace("年","-").replace("月","-").replace("日","");
		  var age = GetAgeByBrithday(birthday);
		  if(age<=2){
			  value= value*1-15*count;
		  }else if(age<=17){
			  value= value*1-10*count;
		  }
		  return value;
	  }
	  
	  //防延迟在投保之前的第二次试算
	  function trial1(){
		  $("#coverage").html($("#count").val()*10+"0000.00");
		  $("#sumbasepremium").text(amntFormat);
		  var preCode =  document.getElementById("policy.preferentialcode").value;
		  var sex = $('#recognizee.sex').val();//取得性别
		  sex = document.getElementById("recognizee.sex").value
		  var birthday = $("#start").val().replace("年","-").replace("月","-").replace("日","");//取得生日
		  var Iage = GetAgeByBrithday(birthday);
		  var date = new Date(Date.parse(birthday));
		  var age = (new Date().getTime() - date.getTime())/(24 * 60 * 60 * 1000);
		  count = Number($("#count").val());//取得份数
		  sumpremium = 100000.00*count
		  if(birthday!=""&&birthday!=null&&count!=null&&count!=""&&age>=30&&Iage<18){
			  $.ajax({
				   type:"POST",
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
						$("#original").text(amntFormat);
						if(preCode!=null&&preCode!=""&&preCode.length>0){
						    amntFormat = changeAmount(amntFormat);
						    $("#sumbasepremium").text(amntFormat+".00");
							document.getElementById("recognizee.birthday").value = birthday;
							document.getElementById("policy.sumamount").value = sumpremium;//保额
							document.getElementById("policy.sumbasepremium").value = amntFormat;//保费
							$("#baseForm").submit();
						}else{
							$("#sumbasepremium").text(amntFormat);
							alert("输入优惠码 享受团购价");
							return;
						}
					    modal_loading('hide');
					}
				}); 
		  }else{
			  alert("被保人相关数据异常");
			  $("#sumbasepremium").text('0.00');
			  $("#original").text('0.00');
			  return;
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
	  
	  //提交表单准备投保
	  function dosubmit(){
		  var preCode =  document.getElementById("policy.preferentialcode").value;
		  var birthday = $("#start").val().replace("年","-").replace("月","-").replace("日","");//取得生日
		  var date = new Date(Date.parse(birthday));
		  var age = (new Date().getTime() - date.getTime())/(24 * 60 * 60 * 1000);
		  var Iage = GetAgeByBrithday(birthday);
		  if(birthday==""||birthday.length==0){
			  alert("请选择被保险人生日"); 
			  return false;
		  }else if(age<=30||Iage>=18){
			  alert("被保险人的年龄限制为30天~18周岁");
			  return false;
		  }else if(amntFormat=='0.00'){
			  alert("保费为空");
			  return false;
		  }else if(preCode==null||preCode==""||preCode.length==0){
			  alert("输入优惠码 享受团购价");
			  return false;
		  }else{
			  trial1();
		  }
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

<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
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
	wx.showOptionMenu();
	var shareData = {
	        title: '瑞泰人寿少儿重疾险', // 分享标题
	        desc: "史上最给力的少儿重疾险！内部团购，空前折扣，限时限量优惠！", // 分享描述
	        link:"http://weixin.oldmutual-guodian.com/onlineApp/msl/sales/PreferentialIntroduce",
	        imgUrl: "http://weixin.oldmutual-guodian.com/onlineApp/global/page/images/growup_suo.jpg" // 分享图标
	    };
	  wx.onMenuShareAppMessage(shareData);//分享给朋友
	  
	  wx.onMenuShareTimeline({//分享至朋友圈
	        title: '瑞泰人寿—史上最给力的少儿重疾险！内部团购，空前折扣，限时限量优惠！', // 分享标题
	        desc: "瑞泰人寿—史上最给力的少儿重疾险！内部团购，空前折扣，限时限量优惠！", // 分享描述
	        link:"http://weixin.oldmutual-guodian.com/onlineApp/msl/sales/PreferentialIntroduce",
	        imgUrl: "http://weixin.oldmutual-guodian.com/onlineApp/global/page/images/growup_suo.jpg" // 分享图标
		    });
});	
	
wx.error(function (res) {
	//var df = window.location.href;
	//modal_alert({content:res.errMsg,btn:'确定'});
	});
</script>

</html>
