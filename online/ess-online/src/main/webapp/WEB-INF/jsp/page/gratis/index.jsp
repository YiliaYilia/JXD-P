<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../common/taglibs.jsp"%>
<%@ page import="cn.com.sinosoft.web.domain.MakeTicketSignature"%>
<% 
request.setCharacterEncoding("UTF-8");
String url = "http://weixin.oldmutual-guodian.com/onlineApp/msl/sales/gratisProduct?"+request.getQueryString();
MakeTicketSignature mts = new MakeTicketSignature();
%>
<!DOCTYPE HTML>
<html>
<head>
<title>瑞泰人寿公共交通意外险</title>
<%@ include file="../../common/meta.jsp"%>
<%@ include file="../../common/rels.jsp"%>
<link
	href="<%=request.getContextPath()%>/global/global/css/common.css?${random}"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/global/global/css/sale.css?${random}"
	rel="stylesheet" />

<script
	src="<%=request.getContextPath()%>/resources/lib/component/form.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/lib/jquery/validate/jquery.validator.js?${random}"></script>
<script
	src="<%=request.getContextPath()%>/resources/lib/jquery/validate/local/zh_CN.js?${random}"></script>
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
        body { padding: 0; margin: 0; font-size: 16px; font-family: arial, verdana, sans-serif; }
        input, select { width: 100%; padding:0.25em; margin: 0 0 .625em 0; border: 1px solid #aaa; box-sizing: border-box; -moz-box-sizing: border-box; -webkit-box-sizing: border-box; }
        .header { padding: .625em; background: #5185a8;}
        .header h1 { margin: 0; padding: 0; color: #fff; text-align: center; font-size: 1.25em; font-weight: bold; text-shadow: 1px 1px 1px #000; text-overflow: ellipsis; overflow: hidden; white-space: nowrap; }
        .content { padding: 1em; }
		 .dwwr{width:500px;}
        .dw-i{font-size: 1.8em;}
    </style>
	<script>
        $(function () {
           var isExistId = document.getElementById("isExistId").value;
           if(isExistId == 'true'){
        	   alert("您已经领取过此保险，无法重复领取！");
           }
           
           var subscribe = document.getElementById("subscribe").value;
           if(subscribe == '0'){
        	  viewReason();
           }
        });
        
        $(function () {
            var demo, theme, mode, display, lang;
            demo = 'date';
            theme = 'android',
            mode = 'scroller',
            display = 'modal',
            dateFormat= 'yy年mm月dd日',
            endYear=new Date().getFullYear()+50,
            lang = 'zh';
            $('.demo-cont').hide();
            $("#demo_cont_" + demo).show();
            init();
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
               		 minDate:new Date(new Date().getFullYear(),new Date().getMonth(),new Date().getDate()+1),
                });
              
            }    

            // -------------------------------------------------------------------
            // Demo page code START, you can disregard this in your implementation

            // Demo page code END
            // -------------------------------------------------------------------
        });
        
        
    </script>
<script
	src="<%=request.getContextPath()%>/resources/lib/utils/dateUtils.js?${random}"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/lib/utils/idCardUtils.js?${random}"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/lib/utils/stringUtils.js?${random}"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/page/index.js?${random}"></script>
</head>
<body>
	<img class="img" src="<%=request.getContextPath()%>/global/page/images/gratis.jpg" />
	<div class="content">公共交通工具意外险</div>
	<form action="${ctx}/msl/sales/insureGratisPolicyInput" method="post" name="form" id="form">
		<div class="center">
			<table class="table">
			<tr>
   				<td width=30% style="margin-left: 15%;">开始日期：</td>
   				<td width=70% ><input class="data_input" type=text  id="start" name="start" readonly="readonly" onchange="computeEnd();"/></td>
   				
   			</tr>
   			<tr>
   				<td width=30% style="margin-left: 15%">截止日期：</td>
   				<td width=70% ><input  class="data_input" type=text  id="end" name="end" readonly="readonly" value=""/></td>
   			</tr>
				<tr>
					<td style="margin-left: 15%">保险天数：</td>
					<td style=""><input id="inputPeriodTerm"
						name="policy.policyterm" type="text" value="7" class="amount_text" disabled="disabled"/>天</td>
				</tr>
				<tr>
					<td style="margin-left: 15%"">投保份数：</td>
					<td>
					<input id="inputPeriodNum"
						name="policy.unitcount" type="text" value="2" class="amount_text" disabled="disabled"/>份
					</td>
				</tr>
				<tr>
					<td style="margin-left: 15%">应付金额：</td>
					<td><span id="sumbasepremium">0.0元</span></td>
				</tr>
				
				<tr>
					<td colspan="2" style="margin-left: 15%">
					保险责任：<br/>
					航空意外身故及伤残     40万元<br/>
					轨道交通意外身故及伤残  20万元<br/>
					轮船、营运汽车意外身故及伤残  10万元<br/>
					<font color="grey">
					意外伤残保险金=伤残等级对应的给付比例*保险合同约定的保险金额</font>
					</td>
				</tr>
				<input type="hidden" id="isExistId" value="${isExist }"></input>
				<input type="hidden" id="subscribe" value="${subscribe }"></input>
			</table>
			
			<div id="toInsure" class="btn">领&nbsp;取&nbsp;赠&nbsp;险</div>
		</div>
	</form>
	
	<jsp:include page="../../common/common-modal.jsp"></jsp:include>
	<jsp:include page="../../common/footer.jsp"></jsp:include>
	<div id="popDiv" class="mydiv" style="display:none;width:100%;float:right;position: absolute;">
   		<img style="width:100%"class="img" src="<%=request.getContextPath()%>/global/page/images/qrcode.jpg" />
   		长按二维码关注微信号领取赠险
   	</div>
</body>
<script type="text/javascript">

function viewReason(){
	    var str = "";
		var msgw,msgh,bordercolor; 
		//	msgw=591;//提示窗口的宽度 
		//	msgh=418;//提示窗口的高度 
			//titleheight=25//提示窗口标题高度 
			bordercolor="#ffffff";//提示窗口的边框颜色 
			//titlecolor="#99CCFF";//提示窗口的标题颜色 
		var sWidth,sHeight; 
			sWidth=2000;//浏览器工作区域内页面宽度 或使用 screen.width//屏幕的宽度 
			sHeight=2300;//屏幕高度（垂直分辨率） 
			//背景层（大小与窗口有效区域相同，即当弹出对话框时，背景显示为放射状透明灰色） 
		var bgObj=document.createElement("div");//创建一个div对象（背景层） //动态创建元素，这里创建的是 div 
			//定义div属性，即相当于(相当于，但确不是，必须对对象属性进行定义 
			bgObj.setAttribute('id','bgDiv'); 
			bgObj.style.position="fixed"; 
			bgObj.style.top="0"; 
			bgObj.style.background="#777"; 
			bgObj.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75"; 
			bgObj.style.opacity="0.6"; 
			bgObj.style.left="0"; 
			bgObj.style.width=100 + "%"; 
			bgObj.style.height=100 + "%"; 
			bgObj.style.zIndex = "10000"; 
			document.body.appendChild(bgObj);//在body内添加该div对象 
			//创建一个div对象（提示框层） 
		var msgObj=document.createElement("div") ;
		//定义div属性，即相当于 
		//<div id="msgDiv" align="center" style="background-color:white; border:1px solid #336699; position:absolute; left:50%; top:50%; font:12px/1.6em Verdana,Geneva,Arial,Helvetica,sans-serif; margin-left:-225px; margin-top:npx; width:400px; height:100px; text-align:center; line-height:25px; z-index:100001;"></div> 
			msgObj.setAttribute("id","msgDiv"); 
			msgObj.setAttribute("align","center"); 
		//	msgObj.style.background="white"; 
//			msgObj.style.border="1px solid " + bordercolor; 
			msgObj.style.position = "fixed"; 
			msgObj.style.left = "25%"; 
			msgObj.style.top = "25%"; 
			msgObj.style.backgroundColor="#fff";
		//	msgObj.style.font="15px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif"; 
			//msgObj.style.marginLeft = "-120px" ; 
			//msgObj.style.marginTop = "-200px"; 
			msgObj.style.width = 50 + "%"; 
			//msgObj.style.height = msgh + "px"; 
			//msgObj.style.textAlign = "left"; 
			//msgObj.style.lineHeight ="25px"; 
			msgObj.style.zIndex = "10001"; 
			msgObj.innerHTML=document.getElementById("popDiv").innerHTML;
			document.body.appendChild(msgObj);//在body内添加提示框div对象msgObj		
	}

	$(".info").click(function(){
		$(".info_hid").css("display","none");
		$(this).next().css("display","block");	
		
	});

	//计算结束日期
	function computeEnd(){
		var start = $("#start").val().replace("年","-").replace("月","-").replace("日","");
		var inputPeriodTerm =  $("#inputPeriodTerm").val();
		if(start!=""&&inputPeriodTerm!=""){
			var date1 = new Date(Date.parse(start));
			if(Date.parse(date1)<Date.parse('2016-04-06')){
				var curDate = new Date();
				var date2 = new Date(date1.getTime()+(inputPeriodTerm-1)*(24 * 60 * 60 * 1000));
				var month = (date2.getMonth()+1);
				var day = date2.getDate();
				month =(month<10 ? "0"+month:month);
				day =(day<10 ? "0"+day:day);
				var endDate = date2.getFullYear()+'年'+month+'月'+day+'日';
				document.getElementById("end").value = endDate;
				calculatePremGratis(true);
			} else {
				alert("请输入有效的起始日期，不得大于2016-04-05");
				document.getElementById("end").value = '';
				document.getElementById("start").value = '';
				return false;
			}
		}else{
			return false;
		}
	}
	
	//计算间隔日期
	function compute(){
		//var start = $("#year").val()+"-"+$("#mon").val()+"-"+$("#day").val();//取得开始日期
		var start = $("#start").val().replace("年","-").replace("月","-").replace("日","");
		//var end = $("#year1").val()+"-"+$("#mon1").val()+"-"+$("#day1").val();//取得结束日期
		var end = $("#end").val().replace("年","-").replace("月","-").replace("日","");
		if(start!=""&&end!=""){
			var date1 = new Date(Date.parse(start));
			var date2 = new Date(Date.parse(end));  
			var curDate = new Date();
			if(Date.parse(date1)>Date.parse(curDate)){
				var interval = (date2.getTime() - date1.getTime())/(24 * 60 * 60 * 1000);//计算投保天数
				interval = interval+1;
				if(start==end){
					interval = 1;
				}
				if(interval == "NaN"){
					document.getElementById("inputPeriodTerm").value = "0";
				}else if(interval>30||interval<1){
					alert("保险期间不得少于1天不得多于30天");
					return false;
				}else{
					document.getElementById("inputPeriodTerm").value = interval;
					calculatePremGratis(true);
					return true;
				}
			}else{
				alert("请输入有效的起始日期，不得小于明天");
				return false;
			}
		}else{
			return false;
		}
	}

	//试算保费
	function calculatePremGratis(isHide){
		var policyTerm = $("#inputPeriodTerm").val();
		var policyNum = $("#inputPeriodNum").val();
		var takeeffecttime = $("#start").val().replace("年","-").replace("月","-").replace("日","");//取得开始日期
		var deadlinetime = $("#end").val().replace("年","-").replace("月","-").replace("日","");//取得结束日期
		policyTerm = parseInt(policyTerm);
		policyNum = parseInt(policyNum);
		var policytermType = "D";
			if(isHide){
				modal_loading();
			}
		$.ajax({
		   type:"POST",
		   url:contentRootPath+"/msl/sales/gratisCalculate",
		   data:{
			   "policy.prodoctcode":"TATIANB02",
			   "policy.policyterm":policyTerm,
			   "policy.takeeffecttime":takeeffecttime,
			   "policy.deadlinetime":deadlinetime,
			   "policy.policytermtype":policytermType,
			   "policy.unitcount":policyNum,
			   "policy.sumamount":350000*policyNum
		   },
		   dataType:"json",
		   success:function(data){
				//var inputAmnt=Number(data.policy.sumbasepremium).toFixed(2);
			    //var amntFormat=outputmoney(inputAmnt);
			    //$("#sumbasepremium").text(amntFormat);
			    calculateFlag = true;
			    modal_loading('hide');
			}
		});
	}
</script>

<script>
function dataSelect()
{
strYYYY = document.form.YYYY.outerHTML;
strMM = document.form.MM.outerHTML;
strDD = document.form.DD.outerHTML;
MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
//先给年下拉框赋内容
var y = new Date().getFullYear();
var str = strYYYY.substring(0, strYYYY.length - 9);
for (var i = y; i < (y+21); i++) //以今年为准，前30年，后30年
{
str += "<option value='" + i + "'> " + i  + "</option>\r\n";
}
document.form.YYYY.outerHTML = str +"</select>";
//赋月份的下拉框
var str = strMM.substring(0, strMM.length - 9);

for (var i = 1; i < 13; i++)
{
if(i<10){i="0"+i}
str += "<option value='" + i + "'> " + i  + "</option>\r\n";
}
document.form.MM.outerHTML = str +"</select>";
document.form.YYYY.value = y;
var MMtep= new Date().getMonth() + 1;
if(MMtep<10){MMtep="0"+MMtep}
document.form.MM.value =MMtep;
var n = MonHead[new Date().getMonth()];
if (new Date().getMonth() ==1 && IsPinYear(YYYYvalue)) n++;
writeDay(n); //赋日期下拉框
document.form.DD.value = new Date().getDate()+1;
}
function YYYYMM(str) //年发生变化时日期发生变化(主要是判断闰平年)
{
var MMvalue = document.form.MM.options[document.form.MM.selectedIndex].value;
if (MMvalue == ""){DD.outerHTML = strDD; return;}
var n = MonHead[MMvalue - 1];
if (MMvalue ==2 && IsPinYear(str)) n++;
writeDay(n)
}
function MMDD(str) //月发生变化时日期联动
{
var YYYYvalue = document.form.YYYY.options[document.form.YYYY.selectedIndex].value;
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
document.form.DD.outerHTML = s +"</select>";
document.form.DD.value = "01";
}
function IsPinYear(year)//判断是否闰平年
{ return(0 == year%4 && (year0 !=0 || year%400 == 0))}
</script>

<script>
function dataSelect1()
{
strYYYY = document.form.YYYY1.outerHTML;
strMM = document.form.MM1.outerHTML;
strDD = document.form.DD1.outerHTML;
MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
//先给年下拉框赋内容
var y = new Date().getFullYear();
var mh= new Date().getMonth() + 1;
var dh= new Date().getDate();
var str = strYYYY.substring(0, strYYYY.length - 9);
if(mh==1||mh==3||mh==5||mh==7||mh==8||mh==10||mh==12){
if((dh+7)>31&&(mh+1)>12){
for (var i = (y+1); i < (y+52); i++) //以今年为准，前30年，后30年
{
str += "<option value='" + i + "'> " + i  + "</option>\r\n";
}
}
else{
for (var i =y; i < (y+51); i++) //以今年为准，前30年，后30年
{
str += "<option value='" + i + "'> " + i  + "</option>\r\n";
}
}
}else{
if((dh+7)>30&&(mh+1)>12){
for (var i = (y+1); i < (y+52); i++) //以今年为准，前30年，后30年
{
str += "<option value='" + i + "'> " + i  + "</option>\r\n";
}
}
else{
for (var i =y; i < (y+51); i++) //以今年为准，前30年，后30年
{
str += "<option value='" + i + "'> " + i  + "</option>\r\n";
}
}
}

document.form.YYYY1.outerHTML = str +"</select>";
//赋月份的下拉框
var str = strMM.substring(0, strMM.length - 9);

if(mh==1||mh==3||mh==5||mh==7||mh==8||mh==10||mh==12){
	if((dh+7)>31){
		for (var i = (mh+1); i < 13; i++)
		{
		if(i<10){
			i="0"+i
			}
		str += "<option value='" + i + "'> " + i  + "</option>\r\n";
		}
	}else{
		for (var i = mh; i < 13; i++)
		{
		if(i<10){
			i="0"+i
			}
		str += "<option value='" + i + "'> " + i  + "</option>\r\n";
		}
	}

}else{
	if((dh+7)>30){
		for (var i = (mh+1); i < 13; i++)
		{
		if(i<10){i="0"+i}
		str += "<option value='" + i + "'> " + i  + "</option>\r\n";
		}
	}else{
		for (var i = mh; i < 13; i++)
		{
		if(i<10){i="0"+i}
		str += "<option value='" + i + "'> " + i  + "</option>\r\n";
		}
	}
}

document.form.MM1.outerHTML = str +"</select>";
document.form.YYYY1.value = y;
var MMtep= new Date().getMonth() + 1;
if(MMtep<10){MMtep="0"+MMtep}
document.form.MM1.value =MMtep;
var n = MonHead[new Date().getMonth()];
if (new Date().getMonth() ==1 && IsPinYear(YYYYvalue)) n++;
writeDay1(n); //赋日期下拉框

if(mh==1||mh==3||mh==5||mh==7||mh==8||mh==10||mh==12){
	if((dh+7)>31){
		document.form.DD1.value = (dh+7)-31;
	}else{
		document.form.DD1.value = dh+7;
	}
}else{
	if((dh+7)>30){
		document.form.DD1.value = (dh+7)-30;
	}else{
		document.form.DD1.value = dh+7;
	}
}
}
function YYYYMM1(str) //年发生变化时日期发生变化(主要是判断闰平年)
{
var MMvalue = document.form.MM1.options[document.form.MM1.selectedIndex].value;
if (MMvalue == ""){DD1.outerHTML = strDD; return;}
var n = MonHead[MMvalue - 1];
if (MMvalue ==2 && IsPinYear(str)) n++;
writeDay1(n)
}
function MMDD(str) //月发生变化时日期联动
{
var YYYYvalue = document.form.YYYY1.options[document.form.YYYY1.selectedIndex].value;
if (str == ""){DD1.outerHTML = strDD; return;}
var n = MonHead[str - 1];
if (str ==2 && IsPinYear(YYYYvalue)) n++;
writeDay1(n)
}
function writeDay1(n) //据条件写日期的下拉框
{
var s = strDD.substring(0, strDD.length - 9);
for (var i=1; i<(n+1); i++){
if(i<10){i="0"+i}
s += "<option value='" + i + "'> " + i + "</option>\r\n";
}
document.form.DD1.outerHTML = s +"</select>";
}
function IsPinYear(year)//判断是否闰平年
{ return(0 == year%4 && (year0 !=0 || year%400 == 0))}
</script>

<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="http://res.wx.qq.com/js/wechat/jweixinInit.js"></script>
<script>
wx.config({
	//开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
    debug: false,
  	//必填，公众号的唯一标识
    appId: '<%=mts.getAppid()%>', 
 	//必填，生成签名的时间戳
    timestamp: '<%=mts.getTimestamp()%>',
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
	        title: '瑞泰人寿公共交通意外险赠险', // 分享标题
	        desc: "真送！免费！不忽悠！七天公共交通意外险！", // 分享描述
	        link:"http://weixin.oldmutual-guodian.com/onlineApp/html/transfer.jsp",
	        imgUrl: "http://weixin.oldmutual-guodian.com/onlineApp/global/page/images/gratis.jpg" // 分享图标
	    };
	  wx.onMenuShareAppMessage(shareData);
	  wx.onMenuShareTimeline(
		  {
	        title: '瑞泰人寿公共交通意外险赠险', // 分享标题
	        desc: "真送！免费！不忽悠！七天公共交通意外险！", // 分享描述
	        link:"http://weixin.oldmutual-guodian.com/onlineApp/html/transfer.jsp",
	        imgUrl: "http://weixin.oldmutual-guodian.com/onlineApp/global/page/images/gratis.jpg" // 分享图标
		  }
		);//分享至朋友圈
});


	
wx.error(function (res) {
	//var df = window.location.href;
	//alert('<%=url%>');
	//modal_alert({content:res.errMsg,btn:'确定'});;
});
</script>
</html>
