<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../common/taglibs.jsp"%>
<%@ page import="cn.com.sinosoft.web.domain.MakeTicketSignature"%>
<% 
request.setCharacterEncoding("UTF-8");
String url = "http://weixin.oldmutual-guodian.com/onlineApp/msl/sales/shortProduct?"+request.getQueryString();
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
 
 
 
 function test(){
     $(function () {
     	var dateStart=$("#start").val();
     	if(dateStart!='undefined'&&dateStart.length>0){
     		  var yTemp=dateStart.substring(0,4);
     		  var mTemp=dateStart.substring(5,7);
     		  var dTemp=dateStart.substring(8,10);
     		  var dTemp1=dTemp*1+29;
     	}
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
           
             $('#end').mobiscroll().date({
                 theme: theme,     // Specify theme like: theme: 'ios' or omit setting to use default 
                 mode: mode,       // Specify scroller mode like: mode: 'mixed' or omit setting to use default 
                 display: display, // Specify display mode like: display: 'bottom' or omit setting to use default 
                 lang: lang,        // Specify language like: lang: 'pl' or omit setting to use default 
					"height": 90,
            		 dateFormat:dateFormat,
            		 endYear:endYear,
            		 minDate:new Date(yTemp,mTemp-1,dTemp),
            		 maxDate:new Date(yTemp,mTemp*1-1,dTemp1),
             });
         }    

     });
}
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
	<img class="img" src="<%=request.getContextPath()%>/global/page/images/transfer.jpg" />
	<div class="content">公共交通工具意外险</div>
	<form action="${ctx}/msl/sales/insureShortPolicyInput" method="post" name="form" id="form">
		<div class="center">
			<table class="table">
				<tr>
   				<td width=30% style="text-align:center;">开始日期：</td>
   				<td width=70% ><input onchange="test()" class="data_input" type=text  id="start" name="start" readonly="readonly" onchange="compute();"/></td>
   			</tr>
   			<tr>
   				<td width=30% style="text-align:center;">截止日期：</td>
   				<td width=70% ><input  class="data_input" type=text  id="end" name="end" readonly="readonly" onchange="compute();"/></td>
   			</tr>
				<tr>
					<td style="text-align: center;">保险天数：</td>
					<td style=""><input id="inputPeriodTerm"
						name="policy.policyterm" type="text" value="" class="amount_text" disabled="disabled"/>天</td>
				</tr>
				<tr>
					<td style="text-align: center;">投保份数：</td>
					<td>
					<select style="font-size:1.0em;width:35%;padding:0.25em" id="inputPeriodNum" name="policy.unitcount">
   						<option value="10">10</option>
   						<option value="9">9</option>
   						<option value="8">8</option>
   						<option value="7">7</option>
   						<option value="6">6</option>
   						<option value="5">5</option>
   						<option value="4">4</option>
   						<option value="3">3</option>
   						<option value="2">2</option>
   						<option value="1">1</option>
   					</select>份
					</td>
				</tr>
				<tr>
					<td style="text-align: center;">应付金额：</td>
					<td><span id="sumbasepremium"></span>&nbsp;元</span></td>
				</tr>
			</table>
			<div id="toInsure" class="btn">立&nbsp;即&nbsp;投&nbsp;保</div>
		</div>
	</form>
	<div class="info" style="margin-top: 30px;">
		<div class="left">1.产品特色</div>
		<div class="right">+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div class="clear"></div>
	</div>
	<div class="info_hid"  style="display: none;">
		<img src="<%=request.getContextPath()%>/global/page/images/transfer_item.png"/>
	</div>
	<div class="info">
		<div class="left">2.投保须知</div>
		<div class="right">+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div class="clear"></div>
	</div>
	<div class="info_hid" style="display: none;">
		<img src="<%=request.getContextPath()%>/global/page/images/transfer_notice.png"/>
	</div>
	<div class="info">
		<div class="left">3.投保案例</div>
		<div class="right">+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div class="clear"></div>
	</div>
	<div class="info_hid" style="display: none;">
		<img src="<%=request.getContextPath()%>/global/page/images/transfer_case.png"/>
	</div>
	<jsp:include page="../../common/common-modal.jsp"></jsp:include>
	<jsp:include page="../../common/footer.jsp"></jsp:include>

</body>
<script type="text/javascript">

	$(".info").click(function(){
		$(".info_hid").css("display","none");
		$(this).next().css("display","block");	
		
	});
	
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
					calculatePrem(true);
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
	        title: '瑞泰人寿公共交通意外险', // 分享标题
	        desc: "1天1元钱！高额保障，超低保费，公共交通工具全覆盖！", // 分享描述
	        link:"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx5be4b58fee2539db&redirect_uri=http://weixin.oldmutual-guodian.com/onlineApp/msl/sales/shortProduct&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect",
	        imgUrl: "http://weixin.oldmutual-guodian.com/onlineApp/global/page/images/transfer-suo.jpg" // 分享图标
	    };
	  wx.onMenuShareAppMessage(shareData);
	  wx.onMenuShareTimeline(
		  {
	        title: '瑞泰人寿—公共交通意外险，1天1元钱！高额保障，超低保费，公共交通工具全覆盖！', // 分享标题
	        desc: "1天1元钱！高额保障，超低保费，公共交通工具全覆盖！", // 分享描述
	        link:"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx5be4b58fee2539db&redirect_uri=http://weixin.oldmutual-guodian.com/onlineApp/msl/sales/shortProduct&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect",
	        imgUrl: "http://weixin.oldmutual-guodian.com/onlineApp/global/page/images/transfer-suo.jpg" // 分享图标
		  }
		);//分享至朋友圈
});


	
wx.error(function (res) {
	//var df = window.location.href;
	//modal_alert({content:res.errMsg,btn:'确定'});
	});
</script>
</html>
