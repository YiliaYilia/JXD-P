<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.com.sinosoft.web.domain.MakeTicketSignature"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String url = "http://testweixin.oldmutual-guodian.com/online/action/RXresult";
if(request.getQueryString()!=null){
	url = url+"?"+request.getQueryString();
}
MakeTicketSignature mts = new MakeTicketSignature();
String insuredage = request.getParameter("insuredage");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0" name="viewport" />
		<meta name="format-detection" content="telephone=no" />
		<title>瑞享金生终身寿险</title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/calculator/result.css" />
		<script src="<%=request.getContextPath() %>/resources/js/jquery-1.11.1.min.js"></script>
		<script>
			$(function(){
				/*var w = document.documentElement.clientWidth;
				if(980 < w){
					w = 980;
				}
				var height = w*1.775;
				$(".content").height(height);
				$(window).resize(function(){
					var w = document.documentElement.clientWidth;
					if(980 < w){
						w = 980;
					}
					var height = w*1.775;
					$(".content").height(height);
				})*/
			})
			function share(){
				$(".layer").show();
				$(".layer_img").show();
				$(".layer_font").show();
			}
		</script>
	</head>
	<body>
		<div class="main_wrap">
			<img src="<%=request.getContextPath() %>/resources/image/calculator/rxjs.jpg" class="big_img"/>
			<span class="title">瑞享金生终身寿险保险计划</span>
			<div class="content" style="margin-top:-1em;">
				<p class="con_title">投保信息&nbsp;&nbsp;<span class="imp_c">
				<%=session.getAttribute("xingming")%>
				<%=session.getAttribute("sex").equals("M")?"先生":"女士"%>
				</span></p>
				<table class="basic_info">
					<tr>
						<td>
							 投保人年龄<br/><span class="imp_c"><%=session.getAttribute("insuredage")%>岁</span>
						</td>
						<td>
							 保险期间<br/><span class="imp_c">终身</span>
						</td>
					</tr>
					<tr>
						<td>
							保险金额<br/><span class="imp_c"><%=session.getAttribute("coverage")%></span>万
						</td>
						<td>
							交费期间<br/><span class="imp_c"><%=session.getAttribute("period").equals("1")?"趸交":session.getAttribute("period")+"年"%></span>
						</td>
					</tr>
				</table>
			</div>
			<div class="content">
				<p class="con_title">保费信息</p>
				<table class="basic_info">
					<tr>
						<td>
							 首年保费<br/><span class="imp_c"><%=session.getAttribute("startPremium")%></span>万
						</td>
						<td>
							年交保费<br/><span class="imp_c"><%=session.getAttribute("startPremium")%></span>万
						</td>
					</tr>
					<tr>
						<td>
							合计保费<br /><span class="imp_c"><%=session.getAttribute("premium")%></span>万
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
				</table>
			</div>
			<div class="content">
				<p class="con_title">现金价值<span style="font-size:0.875rem;">（现金价值是年度末数值）</span></p>
				<table class="basic_info">
					<tr>
						<td>
							60岁
						</td>
						<td>
							<span class="imp_c" id="value60"><%=session.getAttribute("value60")%></span>万
						</td>
					</tr>
<!-- 					<tr> -->
<!-- 						<td> -->
<!-- 							年龄 -->
<!-- 						</td> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="valueage" id="valueage" onchange="trial();"/> -->
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td> -->
<!-- 							现金价值 -->
<!-- 						</td> -->
<!-- 						<td> -->
<!-- 							<span class="imp_c" id="value"></span>万 -->
<!-- 						</td> -->
<!-- 					</tr> -->
					<tr>
						<td colspan="2">
							<a onclick="window.location.href='<%=request.getContextPath()%>/action/RXxj';">
								<p class="detail">瑞享金生终身寿险现金价值表详情</p>
							</a>
						</td>
					</tr>
					<tr>
						<td colspan="2" style="font-size:0.875rem;">
							现金价值贷款比例高达<span class="imp_c">80%</span>，确保资金灵活性
						</td>
					</tr>	
				</table>
			</div>
			<div class="content">
				<p class="con_title">保险责任</p>
				<h5>身故保险金</h5>
				<p class="con_con">
					&#10148 180日内因病：给付保险费的120%，保险合同终止。<br/>
					&#10148 意外伤害或180日后身故：<br/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;未满18周岁，给付保险费的120%，保险合同终止<br/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年满18周岁，给付<span style="color:blue;"><%=session.getAttribute("coverage")%>万</span>，保险合同终止
				</p>
				<h5>全残保险金</h5>
				<p class="con_con">
					&#10148 180日内因病：给付保险费的120%，保险合同终止。<br/>
					&#10148 意外伤害或180日后全残：<br/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;未满18周岁，给付保险费的120%，保险合同终止<br/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年满18周岁，给付<span style="color:blue;"><%=session.getAttribute("coverage")%>万</span>，保险合同终止
				</p>
				<p style="font-size:60%;">
					保险责任、责任免除及犹豫期等内容详见瑞泰瑞享金生终身寿险合同条款<br/>
					未成年人身故保险金的给付按照国务院保险监督管理机构规定的限额执行
				</p>
				
			</div>
			<div class="content">
				<p class="con_title">责任免除</p>
				<p class="con_con">
					因下列情形之一导致被保险人身故或全残，我们不承担给付保险金责任<br />
					1、	投保人对被保险的故意杀害、故意伤害<br />
					2、	被保险人故意犯罪或抗拒依法采取的刑事强制措施<br />
					3、	被保险人自本合同生效之日起2年内自杀。<br />
				</p>
			</div>
			<div class="content" onclick="window.location.href='<%=request.getContextPath()%>/resources/pdf/calculator/rx.pdf';">
				<p class="con_title imp_c" style="font-weight:normal;font-size:100%;color:blue;">条款详情</p>
				<span style="float: right;margin-right:10px;color: #b5b3b3;line-height: 2em;margin-top: -2em;"></span>
			</div>
			<p class="con_con" style="color: #fff;">
				温馨提示:上述关于本产品的演示及说明，仅供保险从业人员学习、交流、演示数据仅供参考，请以实际条款为准。
			</p>
			<div class="content" style="margin-bottom: 20px; height:2rem;">
				<p class="con_title imp_c" style="font-weight:normal;font-size:100%;color:blue;" onclick="window.location.href='http://i.eqxiu.com/s/g1388IMh?eqrcode=1&from=groupmessage&isappinstalled=0';">关于瑞泰人寿</p>
			</div>
			<div class="content" style="margin-bottom: 20px; height:2rem;">
				<p class="con_title imp_c" style="font-weight:normal;font-size:100%;" onclick="share()">分享到朋友圈</p>
			</div>
		</div>
		<div class="layer"></div>
		<img src="<%=request.getContextPath() %>/resources/image/charity/point.png" class="layer_img"/>
		<div class="layer_font">点击此处分享到朋友圈&nbsp;&nbsp;</div>
	</body>
</html>
<script>
//页面回显
/* function backshow(){
	var valueage = document.getElementById("valueage").value;//现金价值年龄
	$("#valueage").val(valueage);
	if(valueage != "" && valueage.length>0){
		trial();
	}
} */
	
//保费试算
function trial(){
	var insuredage = <%=insuredage%>; 
	var valueage = document.getElementById("valueage").value;  //现金价值年龄
	if(valueage > 106 || isNaN(valueage)){
		document.getElementById("valueage").value="";
		alert("现金价值年龄输入必须在1-106岁之间");
		return false;
	}else if(valueage <= insuredage){
		document.getElementById("valueage").value="";
		alert("现金价值年龄必须大于投保年龄!");
		return false;
	}else if(valueage !="" && valueage!=null){
		$.ajax({
		   type:"POST",
		   async: false,
		   url:"<%=request.getContextPath()%>/action/RXtrial",
		   data:{
			   "valueage":valueage
		   },
		   dataType:"json",
		   success:function(data){
			   var d = eval("("+data.result+")");
			   $("#value").html(d.value);
			},
			error:function(){
				alert("系统异常!");
			}
		}); 
  }else{
	 alert("请填写现金价值年龄!");
  }
}
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
	//分享给朋友
	wx.onMenuShareAppMessage({
		title: "瑞享金生终身寿险!", // 分享标题
	    desc: "瑞享金生终身寿险!", // 分享描述
// 	    link:"http://testweixin.oldmutual-guodian.com/online/action/RXCalculator", //分享链接
	    imgUrl:"" // 分享图标
	});
	
	//分享至朋友圈 
	wx.onMenuShareTimeline({
	    title: "瑞享金生终身寿险！", // 分享标题
		desc: "瑞享金生终身寿险！", // 分享描述
// 	    link:"http://testweixin.oldmutual-guodian.com/online/action/RXCalculator", //分享链接
	    imgUrl:"" // 分享图标
	});
});	
	
wx.error(function (res) {
	//var df = window.location.href;
	//modal_alert({content:res.errMsg,btn:'确定'});
	});
</script>