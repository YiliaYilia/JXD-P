<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="cn.com.sinosoft.web.domain.MakeTicketSignature"%>
<% 
request.setCharacterEncoding("UTF-8");
String url = "http://weixin.oldmutual-guodian.com/onlineCharity/msl/sales/honorCertificate";
if(request.getQueryString()!=null){
	url = url+"?"+request.getQueryString();
	
}
System.out.println("==============="+url+"===============");
MakeTicketSignature mts = new MakeTicketSignature();
%>
<%@ include file="/common/page/common.jsp"%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>荣誉证书：尊敬的慈主，您的爱心伞让孩子们生活如此美丽缤纷！</title>
   	<%@ include file="../../common/meta.jsp"%>
   	<%@ include file="../../common/rels.jsp"%>
   	    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/charity/honor.css">
  </head>
  	<style> 
  	
  	</style>
  <body>
   	<div class="page" id="page" style="position: relative;">
   		<div class="head_box">
   			<p style="margin-left:3%">尊敬的${name}慈主，<p>
   			<p style="margin-left:3%">您的“爱心伞”将让孩子们生活如此美丽缤纷：</p>
   		</div>
   		<div class="clear"></div>
   		<div class="center_box">
   			<table class="table">
   				<tr>
   					<td style="width:40;font-weight:bold;text-align:left; ">爱心“重疾伞”：</td>
   					<td style="text-align:right;">重大疾病保障金额：<span style="color:red;">${sumamounts}</span>元</td>
   				</tr>
   				<tr>
   					<td style="width:40;font-weight:bold;text-align:left; ">爱心“意外伞”：</td>
   					<td style="text-align:right;">意外伤害保障金：<span style="color:red;">10000.00</span>元</td>
   				</tr>
   				<tr>
   					<td style="width:40;font-weight:bold ;text-align:left;">&nbsp;</td>
   					<td style="text-align:right;">意外伤害医疗保障金：<span style="color:red;">&nbsp;600.00</span>元</td>
   				</tr>
   				<tr>
   					<td style="width:40;font-weight:bold ;text-align:left;">爱心“助学伞”：</td>
   					<td style="text-align:right;">捐赠金额：<span style="color:red;">${stipend}</span>元</td>
   				</tr>
   				<tr>
   					<td style="width:40;font-weight:bold;text-align:left; ">爱心“书库伞”：</td>
   					<td style="text-align:right;">捐赠金额：<span style="color:red;">&nbsp;${bookmoney}</span>元</td>
   				</tr>
   				<tr>
   					<td colspan="2" style="font-weight: bold;text-align:center;">善款总计：<span style="color:red;">${sumMoney}</span>元</td>
   				</tr>
   			</table>
   		
   		</div>
   		<%-- <div class="left_box">
   			<c:set var="sumbasepremium" value="${sumbasepremium}"/>
  	 	<c:if test="${not empty sumbasepremium}">
  	 		保费：${sumbasepremium}元</br> 
  	 	</c:if>
  	 	<c:set var="sumamount" value="${sumamount}"/>
  	 	<c:if test="${not empty sumamount}">
  	 		保额：${sumamount}元 </br>
  	 	</c:if>
  	 	<c:set var="stipend" value="${stipend}"/>
  	 	<c:if test="${not empty stipend}">
  	 		助学金：${stipend}元 </br>
  	 	</c:if>
  	 	<c:set var="bookmoney" value="${bookmoney}"/>
  	 	<c:if test="${not empty bookmoney}">
  	 		爱心书库：${bookmoney}元 </br>
  	 	</c:if>
    	总金额：${sumMoney}元 </br>
    	订单号：${ordercode}</br>
   		</div> --%>
   		
   		<div  class="share">
   			<img  onclick="viewReason()" style="width:100%" src="<%=request.getContextPath()%>/resources/image/charity/share.png">
   		</div>
   	</div>
   		<div id="popDiv" class="mydiv" style="display:none;width:100%;float:right">
   		<div><img style="float:right" src="<%=request.getContextPath()%>/resources/image/charity/point.png"></div>
   		<div style="margin-top:30%;font-size:2.0em;font-family: Microsoft YaHei;color:#fff;">请点击此处分享给朋友&nbsp;&nbsp;</div>
	</div> 
  </body>
<script type="text/javascript">
	 var pageHeight =  document.documentElement.clientHeight;
	document.getElementById("page").style.height=pageHeight+'px';
</script>
<script src="<%=request.getContextPath() %>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
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
	        title: '荣誉证书', // 分享标题
	        desc: "尊敬的慈主，您的爱心伞让孩子们生活如此美丽缤纷！", // 分享描述
	        link:"http://weixin.oldmutual-guodian.com/onlineCharity/msl/sales/honorCertificate?name="+'${name}'+"&sumbasepremium="+'${sumbasepremium}'+"&sumamount="+'${sumamount}'+"&stipend="+'${stipend}'+"&bookmoney="+'${bookmoney}'+"&sumMoney="+'${sumMoney}'+"&ordercode="+'${ordercode}',
	        imgUrl: "http://weixin.oldmutual-guodian.com/onlineCharity/resources/image/charity/backImg.jpg" // 分享图标
	    };
	  wx.onMenuShareAppMessage(shareData);//分享给朋友
	  
	  wx.onMenuShareTimeline({//分享至朋友圈
	        title: '荣誉证书:尊敬的慈主您的爱心伞让孩子们生活如此美丽缤纷！', // 分享标题
	        desc: "尊敬的慈主，您的爱心伞让孩子们生活如此美丽缤纷！", // 分享描述
	        link:"http://weixin.oldmutual-guodian.com/onlineCharity/msl/sales/honorCertificate?name="+'${name}'+"&sumbasepremium="+'${sumbasepremium}'+"&sumamount="+'${sumamount}'+"&stipend="+'${stipend}'+"&bookmoney="+'${bookmoney}'+"&sumMoney="+'${sumMoney}'+"&ordercode="+'${ordercode}',
	        imgUrl: "http://weixin.oldmutual-guodian.com/onlineCharity/resources/image/charity/backImg.jpg" // 分享图标
		    });
});	
	
<%-- wx.error(function (res) {
	var df = window.location.href;
	alert(df);
	alert('<%=url%>');
	alert(res.errMsg);
	}); --%>
	
	
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
 			bgObj.style.width=sWidth + "px"; 
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
// 			msgObj.style.border="1px solid " + bordercolor; 
 			msgObj.style.position = "fixed"; 
 			msgObj.style.right = "0"; 
 			msgObj.style.top = "0"; 
 		//	msgObj.style.font="15px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif"; 
 			//msgObj.style.marginLeft = "-120px" ; 
 			//msgObj.style.marginTop = "-200px"; 
 			//msgObj.style.width = msgw + "px"; 
 			//msgObj.style.height = msgh + "px"; 
 			//msgObj.style.textAlign = "left"; 
 			//msgObj.style.lineHeight ="25px"; 
 			msgObj.style.zIndex = "10001"; 
 			msgObj.innerHTML=document.getElementById("popDiv").innerHTML;
 			document.body.appendChild(msgObj);//在body内添加提示框div对象msgObj		
 	}
</script>
</html>
