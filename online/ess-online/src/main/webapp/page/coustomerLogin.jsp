<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="format-detection" content="telephone=no" />
	
	<title>用户登录-瑞泰人寿</title>
	
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
	
	<meta name="description" content="用户登录-瑞泰人寿">
	
	<link href="../global/css/common/main.min.css?${random}" rel="stylesheet"/>
	<link href="../global/css/animate/animate.css" rel="stylesheet"/>
	<link href="../global/css/animate/loader-ani.css" rel="stylesheet"/>
	
	<script src="../global/lib/jquery/jquery-2.1.3.min.js"></script>
	<script src="../global/lib/common/main.js?${random}"></script>
	
	<script src="../global/lib/component/modal.js"></script>
	
	<script src="../global/lib/jquery/jquery.event.move.js"></script>
	<script src="../global/lib/jquery/jquery.mobile.touch.js"></script>
	<script src="../global/lib/jquery/jquery.event.swipe.js"></script>
	
	<script>
		
		sino.namespace('manulife');
	
		var contentRootPath = '..';
		var resultSuccess = '${resultSuccess}' == 'true';
		var resultDescription = '${resultDescription}';
		var resultCode = '${resultCode}';
		
		var headImgPath='${fansInfo.headimgUrl}';
		
	</script>
	
	<link href="../global/css/animate/pop-ani.css?${random}" rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript" src="../global/js/identity/bind.js?${random}"></script>
</head>


<style>
	body,html{height:100%}
.wrap{height:100%;position:relative;overflow:hidden}
.list{height:106px;border-top:6px solid #00693c;bottom:0;left:0;background:#fff;z-index:100;position:absolute;width:100%;-webkit-transition:height .4s ease-out}
.list-mask{position:absolute;top:0;left:0;height:100%;width:100%;display:none;z-index:90}
.list-mask.active{display:block}
.list-up{position:absolute;z-index:10;width:100%;height:100px;background:url(../global/image/page/icon-up.png) center no-repeat;-webkit-animation:arrowUp 1s linear infinite}
.list.open .list-body{display:block}
.list.open .list-head{display:none}
.list.open .list-up{top:-100px;-webkit-animation:arrowDown 1s linear infinite}
.list-body{height:100%;display:none;overflow-y:auto}
.list-head,.list-item{padding:13px 32px 0;height:100px}
.list-head .pname,.list-item .pname{font-size:3rem;color:#000;font-weight:700;line-height:40px}
.list-head .pname.group:after,.list-item .pname.group:after{content:'鍥綋';font-size:2.2rem;display:inline-block;height:1.5em;line-height:1.5em;padding:0 .2em;background:#ffc425;color:#fff;font-weight:400;text-align:center;margin-left:10px}
.list-head .pno,.list-item .pno{font-size:2.4rem;color:000;padding-bottom:6px}
.list-head .pactive,.list-item .pactive{font-size:2.4rem;color:#ffc425;float:right}
.list-item{border-bottom:1px solid #00693c}
.list-item.active{background:#00693c}
.list-item.active .pname,.list-item.active .pno{color:#fff}
.nav{height:100%;width:123px;position:absolute;top:0;right:0;z-index:90;background:#434343;box-shadow:10px 18px 38px #262626 inset;overflow:scroll;padding-top:80px;padding-bottom:106px}
.nav-head{text-align:center;padding:23px 0 10px}
.nav-head img{width:80px;height:80px;border-radius:40px}
.nav-arr{height:90px;display:block;background-repeat:no-repeat;background-position:center;background-image:url(../global/image/page/icon-arr-left.png);-webkit-animation:arrowLeft 1s linear infinite}
.nav-item{height:96px;display:block;border-bottom:1px solid #353535;background-repeat:no-repeat;background-position:center}
.nav-item.basic{background-image:url(../global/image/page/icon-basic.png)}
.nav-item.basic.active{background-color:#719500}
.nav-item.pay{background-image:url(../global/image/page/icon-pay.png)}
.nav-item.pay.active{background-color:#719500}
.nav-item.phone{background-image:url(../global/image/page/icon-phone.png)}
.nav-item.phone.active{background-color:#719500}
.nav-item.money{background-image:url(../global/image/page/icon-money.png)}
.nav-item.money.active{background-color:#719500}
.nav-item.protect{background-image:url(../global/image/page/icon-protect.png)}
.nav-item.protect.active{background-color:#719500}
.nav-item.name{line-height:96px;color:#fff;text-align:center;font-size:2.6rem}
.nav-item.name.active{background-color:#719500}
.nav-item.name0,.nav-item.name1,.nav-item.name2,.nav-item.name3,.nav-item.name4,.nav-item.name5,.nav-item.name6,.nav-item.name7{line-height:96px;color:#fff;text-align:center;font-size:2.6rem}
.head{height:80px;top:0;left:0;background:#00693c;z-index:100;position:absolute;width:100%}
.head-name{font-size:3.6rem;line-height:80px;text-align:center;color:#fff}
.head-icon{position:absolute;left:0;top:0;height:80px;width:80px}
.head-icon.home{background:url(../global/image/page/head-home.png) center no-repeat}
.head-icon.back{background:url(../global/image/page/head-back.png) center no-repeat}
.head-icon.left{left:0}
.head-icon.right{right:0}
.content{height:100%;-webkit-overflow-scrolling:touch;overflow:auto}
.content.policy .page{padding:80px 123px 106px 0;-webkit-animation-fill-mode:both;-webkit-animation-timing-function:ease-out;-webkit-animation-duration:.6s;-webkit-animation-iteration-count:1;overflow-y:scroll;z-index:60;position:absolute;top:0;left:0;height:100%;width:100%;display:none}
.content.policy .page.active{display:block}
.content.policy .page.index{padding-right:0;padding-left:50px}
.content.address .page{padding:80px 0 106px;position:relative}
.content.menu .page{padding:1px 0 106px;position:relative}
.content.phone .page{padding:80px 0 0;position:relative}
.content.loan .page{padding:80px 0 106px;position:relative}
.content.claim .page{padding:80px 0 106px}
.content.claimTip .page{padding:80px 0 0;position:absolute;top:0;left:0;height:100%;width:100%;display:none;-webkit-animation-fill-mode:both;-webkit-animation-timing-function:ease-out;-webkit-animation-duration:.6s;-webkit-animation-iteration-count:1;overflow-y:scroll}
.content.claimTip .page.active{display:block}
.content.conservation .page,.content.office .page{padding:80px 0 0}
.content.conservation .page.index{padding-right:0;padding-left:54px;padding-top:180px;position:absolute;top:0;left:0;height:100%;width:100%}
.index-item{display:block;float:left;background-repeat:no-repeat;background-position:center 60px;border-radius:4px;width:262px;height:244px;padding-top:170px;font-size:2.8rem;text-align:center;color:#fff;margin-bottom:17px;margin-right:17px}
.index-item:active,.index-item:visited{color:#fff}
.index-item.basic{background-image:url(../global/image/page/icon-basic-big.png);background-color:#719500;width:538px;margin-top:25px}
.index-item.pay{background-image:url(../global/image/page/icon-pay-big.png);background-color:#719500}
.index-item.phone{background-image:url(../global/image/page/icon-phone-big.png);background-color:#719500}
.index-item.money{background-image:url(../global/image/page/icon-money-big.png);background-color:#719500}
.index-item.protect{background-image:url(../global/image/page/icon-protect-big.png);background-color:#719500}
.index-item.addressModify{height:274px;width:538px;background-image:url(../global/image/page/icon-address.png);background-color:#719500;padding-top:170px}
.index-item.phoneModify{height:343px;background-image:url(../global/image/page/icon-phone-modify.png);background-color:#719500;background-position:center 80px;padding-top:210px}
.index-item.returnLoan{height:343px;background-image:url(../global/image/page/icon-loan.png);background-color:#719500;background-position:center 80px;padding-top:210px}
.index-item.claimQuery{height:274px;width:538px;background-image:url(../global/image/page/icon-claimQuery.png);background-color:#719500;padding-top:170px}
.index-item.claimTip{height:274px;width:538px;background-image:url(../global/image/page/icon-claimTip.png);background-color:#719500;padding-top:170px}
.main{position:absolute;top:0;left:0;height:100%;width:100%;overflow:scroll}
.welcome{margin-top:5%;text-align:center;font-size:4rem;display:none;-webkit-animation-fill-mode:both;-webkit-animation-timing-function:ease-in-out;-webkit-animation-duration:.5s}
.welcome.show{display:block}
.welcome span{font-size:4.7rem;vertical-align:top}
.foot{position:absolute;width:100%;height:80px;bottom:0;display:none;-webkit-animation-fill-mode:both;-webkit-animation-timing-function:ease-in-out;-webkit-animation-duration:.5s;padding:0 40px}
.foot p{border-top:2px solid #00693c;height:80px}
.foot-phone{height:80px}
.foot-phone img{height:50%;width:auto;margin-top:18px}
.foot-logo{height:80px}
.foot-logo img{height:60%;width:auto;margin-top:14px}
.foot-phone{float:left}
.foot-logo{float:right}
.foot.show{display:block}
.bind{width:100%;position:absolute;margin-top:-160px;top:50%;z-index:20;-webkit-animation-name:fadeInUp;-webkit-animation-fill-mode:both;-webkit-animation-timing-function:ease-in-out;-webkit-animation-duration:.8s;-webkit-animation-iteration-count:1;-webkit-animation-delay:2.2s}
.bind .welcome{display:block;position:static;margin:30px 0}
.bind-box{height:72px;width:70%;margin:10px auto 0;border-bottom:2px solid #9b9a9a;border-radius:5px}
.bind-box input{height:70px;width:100%;font-size:3rem;padding:10px;border:0;background:0 0}
.bind-box select{height:70px;width:100%;font-size:3rem;padding:10px;border:0;background:0 0}
.bind-box input.bind-code{width:46%}
.bind-box input:disabled{color:#545454}
.bind-send{min-width:40%;max-width:50%;padding:0 5px;display:inline-block;height:60px;line-height:60px;text-align:center;background:#00693c;border-radius:5px;font-size:3rem;color:#fff;float:right;margin-top:10px}
.bind-send.disable{background:#c1c2c2}
.bind-action{width:80%;margin:60px auto 0}
.bind-btn{display:block;height:96px;line-height:96px;text-align:center;background:#00693c;border-radius:8px;font-size:3.6rem;color:#fff}
.bind-btn.disable{background:#c1c2c2}
.pop-main{width:100%;height:600px;margin-top:3%;padding-bottom:100px;display:none}
.pop-main.show{display:block}
.pop-container{position:absolute;width:100%;height:100%}
.pop-container.slide{-webkit-animation-name:slidePop;-webkit-animation-fill-mode:both;-webkit-animation-timing-function:ease-in-out;-webkit-animation-duration:1s;-webkit-animation-iteration-count:1}
.pop-item{position:absolute}
.pop-item a{width:100%;height:100%;background-size:100%!important;text-align:center;color:#fff;display:block;border-radius:50%}
.pop-item.pop1{width:266px;height:266px;top:240px;left:180px;font-size:36px}
.pop-item.pop1 a{padding-top:95px;background:url(../global/image/page/pop1.png) center no-repeat}
.pop-item.pop2{width:190px;height:190px;top:135px;left:61px;font-size:32px}
.pop-item.pop2 a{padding-top:61px;background:url(../global/image/page/pop2.png) center no-repeat}
.pop-item.pop3{width:160px;height:160px;top:367px;left:420px;font-size:28px}
.pop-item.pop3 a{padding-top:54px;background:url(../global/image/page/pop3.png) center no-repeat}
.pop-item.pop4{width:200px;height:200px;top:421px;left:54px;font-size:32px}
.pop-item.pop4 a{padding-top:63px;background:url(../global/image/page/pop4.png) center no-repeat}
.pop-item.pop5{width:150px;height:150px;top:500px;left:353px;font-size:30px}
.pop-item.pop5 a{padding-top:37px;background:url(../global/image/page/pop5.png) center no-repeat}
.pop-item.pop6{width:580px;height:580px;top:406px;left:0;font-size:36px}
.pop-item.pop6 a{background:url(../global/image/page/logo_t.png) center no-repeat}
.pop-item.pop7{width:240px;height:240px;top:508px;left:213px;font-size:36px}
.pop-item.pop7 a{background:url(../global/image/page/pop2.png) center no-repeat}
.pop-item.pop8{width:240px;height:240px;top:399px;left:298px;font-size:36px}
.pop-item.pop8 a{background:url(../global/image/page/pop4.png) center no-repeat}
.pop-item.pop9{width:240px;height:240px;top:382px;left:140px;font-size:36px}
.pop-item.pop9 a{background:url(../global/image/page/pop5.png) center no-repeat}
.ani-pop-in{-webkit-animation-fill-mode:both;-webkit-animation-timing-function:ease-in-out;-webkit-animation-duration:1.2s;-webkit-animation-iteration-count:1}
.ani-pop-in-pop1{-webkit-animation-name:in-pop1}
.ani-pop-in-pop2{-webkit-animation-name:in-pop2}
.ani-pop-in-pop3{-webkit-animation-name:in-pop3}
.ani-pop-in-pop4{-webkit-animation-name:in-pop4}
.ani-pop-in-pop5{-webkit-animation-name:in-pop5}
.ani-pop-shake{-webkit-animation-name:popShake;-webkit-animation-timing-function:ease-in-out;-webkit-animation-duration:1.5s;-webkit-animation-iteration-count:infinite}
.ani-pop-shake-pop1{-webkit-animation-delay:.2s}
.ani-pop-shake-pop2{-webkit-animation-delay:.4s}
.ani-pop-shake-pop3{-webkit-animation-delay:.6s}
.ani-pop-shake-pop4{-webkit-animation-delay:.8s}
.ani-pop-shake-pop5{-webkit-animation-delay:1s}
.ani-pop-out{-webkit-animation-fill-mode:both;-webkit-animation-timing-function:linear;-webkit-animation-duration:1s;-webkit-animation-iteration-count:1}
.ani-pop-out-pop1{-webkit-animation-name:out-pop1}
.ani-pop-out-pop2{-webkit-animation-name:out-pop2}
.ani-pop-out-pop3{-webkit-animation-name:out-pop3}
.ani-pop-out-pop4{-webkit-animation-name:out-pop4}
.ani-pop-out-pop5{-webkit-animation-name:out-pop5}
.ani-pop-in2{-webkit-animation-fill-mode:both;-webkit-animation-timing-function:ease-in-out;-webkit-animation-duration:.6s;-webkit-animation-iteration-count:1;-webkit-animation-delay:1s}
.ani-pop-in2-pop6{-webkit-animation-name:in-pop6}
.ani-pop-in2-pop7{-webkit-animation-name:in-pop7}
.ani-pop-in2-pop8{-webkit-animation-name:in-pop8}
.ani-pop-in2-pop9{-webkit-animation-name:in-pop9}
.ani-pop-out2{-webkit-animation-fill-mode:both;-webkit-animation-timing-function:ease-in-out;-webkit-animation-duration:1s;-webkit-animation-iteration-count:1}
.ani-pop-out2-pop6{-webkit-animation-name:out-pop6}
.ani-pop-out2-pop7{-webkit-animation-name:out-pop7}
.ani-pop-out2-pop8{-webkit-animation-name:out-pop8}
.ani-pop-out2-pop9{-webkit-animation-name:out-pop9}
.remind{margin:38px;padding:22px 21px 19px 25px;border:3px dashed #D8D8D8;border-radius:7px;font-size:2.4rem;color:#4C4C4C}

.sel_wrap{width:100%;float:left;border:0px; position:relative;_filter:alpha(opacity=0);background: url(../global/images/icons.png) no-repeat right;}
.sel_wrap label{height:70px;width:100%;font-size:3rem;padding:10px 10px 10px 10px;border:0;background:0 0;}
.select{width:100%;border:none;font-family: 'Microsoft YaHei'; z-index:4;position:absolute;opacity:0;filter:alpha(opacity=0);top:0;left:0;margin:0;padding:0;opacity:0;}
.tit_sb{width:20%}
</style>

<link rel="stylesheet" type="text/css" href="../uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/style-font.css">
<style>
	
	.modal-dialog.alert .modal-header{
	font-size: 2.5em;
	}
	.modal-dialog.alert .modal-content {
    font-size: 1.8em;
}
.modal-dialog.alert .modal-btn{
	font-size: 2.5em;
    background: #E8C26D;
	}
.btn-last {
    width: 100%;
    margin: 5px auto;
    overflow: hidden;
    margin-top: 10px;
    margin-bottom: 90px;
    bottom: 0;
    position: fixed;
    padding: 5px;
}	
	</style>

    <body  class="gray">
  <div class="grace-head"> </div>
  <img src="../uinew/images/login-pic.png" style="margin-top: 55px;">
<h2 style="padding-top:40px; text-align:center; color:#c8a154; font-size:2em; font-weight:bold;">用户登录</h2>
<form class="bind-form" action="<%=path %>/action/getinvestmentAccount" name="reForm" id="reForm" method="post"
	style="font-size: 1.2em;width: 100%;position: absolute;padding-top:20px; ">
				<input type="hidden" id="OpenID" name="OpenID" value="${OpenID}">

<div  class="panel-collapse collapse in cardcontent" style="font-size: 1.4em;padding: 5%;">
             <ul class="grace-form"> 
    <li > <div class="pull-left">客户号: </div> 
    	<div class="pull-right">
    		<input style="width:60%;    font-size: 1em;" type="text"  name="coustomerid" id="coustomerid" maxLength=40 readonly="readonly" 
    		value="${coustomerid}">
    		</div></li>
    		
    		<li > <div class="pull-left">密码: </div> 
    	<div class="pull-right">
    		<input style="width:60%;    font-size: 1em;" type="password" placeholder="请输入您的密码" name="passWord" id="passWord" maxLength=20>
    		</div></li>

  </ul>
  <p style="padding: 24px;font-size: 0.9em;text-align: center;">
  注：请您输入瑞泰人寿官网的客户登陆密码<br >
       	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;如需帮助请致电客服专线4008109339  
     </p>   
            </div>
            <input type="hidden" id="policyNum" name="policyNum" value=${policyNum}>
				<input type="hidden" id="productCode" name="productCode" value=${productCode}>
				<input type="hidden" id="productName" name="productName" value=${productName}>
				<input type="hidden" id="investment" name="investment" value=${investment}>
				
            <ul class="btn-last"> 
              <li style="margin-top: 5px;line-height: 70px;width: 100%;font-size: 1.4em;" href="#" id="bindBtn" onclick="login()">
						登&nbsp;&nbsp;录
              	 </li>
              	</ul>
				
			</form>			
<div class="footer footer-fixed" > <img src="../uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>

	
	<div class="modal fade" data-rule="alert" id="modal_alert">
		<div class="modal-dialog alert">
			<div class="modal-header clearfix"><span data-title="modal">提示信息</span><a type="button" class="close" data-dismiss="modal"></a></div>
			<div class="modal-content" data-content="modal"></div>
			<div class="modal-footer">
				<a class="modal-btn btn" data-dismiss="modal" data-btn="modal">确定</a>
			</div>
		</div>
	</div>
	
<!-- 		对话框 -->
	<div class="modal fade" data-rule="dialog" >
		<div class="modal-dialog alert">
			<div class="modal-header clearfix">提示信息</div>
			<div class="modal-content" data-content="modal"></div>
			<div class="modal-footer">
				<a class="modal-btn btn inline" data-dismiss="modal" data-btn="ok">确定</a>
				<a class="modal-btn btn cancel inline" data-dismiss="modal" data-btn="cancel">取消</a>
			</div>
		</div>
	</div>
	
<!-- 		加载等待框 -->
	<div class="modal fade" data-rule="loading" id="modal_loading">
		<div class="modal-dialog loading">
			<div class="modal-content" data-content="modal">
				<p class="loader8">加载中......</p>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">

	$(document).ready(function(){
		//微信浏览器校验
		/*  var ua = navigator.userAgent.toLowerCase();
		  	if(ua.match(/MicroMessenger/i)!="micromessenger") {
		    	window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx618b6902989a293e&redirect_uri=http://testweixin.oldmutual-guodian.com/online/action/firstLogin?response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
		    }*/
	});	 

 

	 $(".sel_wrap").on("change", function() {
	        var o;
	        var opt = $(".select").find('option');
	        opt.each(function(i) {
	            if (opt[i].selected == true) {
	                o = opt[i].innerHTML;
	            }
	        });
	        $("#idtype").val(o);
    }).trigger('change'); 
    
   /*  function test(){
    	  var o;
	        var opt = $(".select").find('option');
	        opt.each(function(i) {
	            if (opt[i].selected == true) {
	                o = opt[i].innerHTML;
	            }
	        });
	        $("#idtype").val(o);
    }
     */
	function dosubmit(){
		$("#reForm").submit();
	}
     
     function login(){
    	var coustomerid = $("#coustomerid").val();
    	var passWord = $("#passWord").val();
   		$.ajax({
   			type : "post",
   			url :'<%=path %>/action/coustomerLogin',
   			dataType : "json",
   			async : false,
   			data : {
   				"coustomerid" : coustomerid,
   				"passWord" : passWord
   			},
   			success : function(data) {
   				if(data.flag == "0"){
   					dosubmit();
   				}else if(data.flag === "4"){
   					alert(data.content);
   					//modal_alert({content:data.content,btn:'确定'});
					//登录老地址http://staging.oldmutual-guodian.com/newLinkedWeb/passport/signin
   					window.location.assign( "http://staging.oldmutual-guodian.com/passport/signin");
   				}else{
   					modal_alert({content:data.content,btn:'确定'});
   				}
   			}
   		});
 	}

</script>



</html>