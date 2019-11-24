<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.com.sinosoft.web.domain.MakeTicketSignature"%>
<% 
request.setCharacterEncoding("UTF-8");
String url = "http://weixin.oldmutual-guodian.com/onlineApp/msl/sales/PreferentialIntroduce";
if(request.getQueryString()!=null){
	url = url+"?"+request.getQueryString();
}
MakeTicketSignature mts = new MakeTicketSignature();
%>

<!DOCTYPE HTML>
<html>
  <head>
  <title>瑞泰人寿—史上最给力的少儿重疾险！内部团购，空前折扣，限时限量优惠！</title>
	<style>
		.page{width:100%;position:relative;z-index:-1;}
		.btn{width:50%;height:60px;position:absolute;z-index:1;background-color:#ff4a01;border-radius:5px;
			text-align:center;top:76%;left:25%;
			color: #fff;line-height:3.0em;font-size: 1.8em}
	</style>
	<%@ include file="../../common/meta.jsp"%>
	<%@ include file="../../common/rels.jsp"%>
	<script src="<%=request.getContextPath()%>/resources/lib/component/form.js"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/validate/jquery.validator.js?${random}"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/validate/local/zh_CN.js?${random}"></script>
  </head>

  <body >
 	 <div style="position:relative;">
   		<img class="page"  src="<%=request.getContextPath()%>/global/images/propagate.jpg"/>
    	<div class="btn" onclick="dosubmit();"> 立&nbsp;&nbsp;&nbsp;即&nbsp;&nbsp;&nbsp;投&nbsp;&nbsp;&nbsp;保</div>
     </div>
     
  </body>
<script type="text/javascript">
	  //提交表单准备投保
	  function dosubmit(){
		 // window.location.href ="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx5be4b58fee2539db&redirect_uri=http://weixin.oldmutual-guodian.com/onlineApp/msl/sales/longPreferentialHome?brNo=A0000&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";//生产
		    window.location.href ="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx618b6902989a293e&redirect_uri=http://testweixin.oldmutual-guodian.com/online/msl/sales/longPreferentialHome?brNo=A0000&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";//测试
	  }
</script>

<script>
	var phoneWidth =  parseInt(window.screen.width);
	var phoneScale = phoneWidth/640;
	var ua = navigator.userAgent;
	if (/Android (\d+\.\d+)/.test(ua)){
		var version = parseFloat(RegExp.$1);
		if(version>2.3){
			document.write('<meta name="viewport" content="width=640, minimum-scale = '+phoneScale+', maximum-scale = '+phoneScale+', target-densitydpi=device-dpi">');
		}else{
			document.write('<meta name="viewport" content="width=640, target-densitydpi=device-dpi">');
		}
	} else {
		document.write('<meta name="viewport" content="width=640, user-scalable=no, target-densitydpi=device-dpi">');
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
	//alert(df);
	//alert('<%=url%>');
	//alert(res.errMsg);
	});
</script>

</html>
