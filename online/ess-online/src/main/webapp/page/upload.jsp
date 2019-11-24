<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.com.sinosoft.web.domain.MakeTicketSignature"%>
<% 
request.setCharacterEncoding("UTF-8");
String url = "https://weixin.oldmutual-guodian.com/onlineApp/page/upload.jsp?"+request.getQueryString();  //生产
// String url = "http://testweixin.oldmutual-guodian.com/online/page/upload.jsp?"+request.getQueryString(); //测试
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
MakeTicketSignature mts = new MakeTicketSignature();
String claimManagementNo = request.getParameter("claimManagementNo");
%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>自助理赔申请</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
 	<meta name="format-detection" content="telephone=no"/>
 	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/compensation/compensation.css" type="text/css"></link>
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
 	<script src="https://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script>
	
	var medieArray = new Array();//存放图片路径	
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
 	      'checkJsApi',
 	      'chooseImage',
 	      'previewImage',
 	      'uploadImage',
 	      'downloadImage',
 	      'closeWindow'
 	    ]
 	});
 	function downloadMedia(){
 		$.ajax({
 			type : "post",
 			url :'<%=path %>/msl/sales/downloadMedia',
 			dataType : "json",
 			async : false,
 			traditional:true,
 			data : {
 				"media_id" : medieArray,
 				"claimManagementNo": '<%=claimManagementNo %>'
 			},
 			success : function(data) {
 				if("updateImages" == '<%=request.getParameter("updateImages") %>'){
 					window.location.href ='<%=path %>/msl/sales/successClaimAction?updateImages=updateImages';
 				}else{
 					window.location.href ='<%=path %>/msl/sales/successClaimAction';
 				}
 				medieArray = [];
 			}
 		});
 	};
 	wx.ready(function () {
 		  var scrArray = new Array();//存放图片路径
 		  // 5 图片接口
 		  // 5.1 拍照、本地选图
 		  var photoSrc = null;
 		  var localIds = [];
 		  var _html="";
 		  document.querySelector('#addPhoto').onclick = function () {
 		    wx.chooseImage({
 		      success: function (res) {
 		       localIds = localIds.concat(res.localIds);
 	    	   for(var i in res.localIds){
 	    	       	photoSrc=res.localIds[i];
 	    	       	_html=_html+'<img class="up_img" src="'+photoSrc+'"/>';
 	    	        scrArray[i] = photoSrc;
 	    	    }
	 	    	$(".up_div").removeAttr("style");
	 	    	$("#upimg_div").append(_html);
	 	    	_html="";//清空
	 	    	$('.up_img').click(function(){
	 	    		var aa=[];
	 	 	        var src=[];
	 	 	        aa=$('.up_img');
	 	 	        for (i=0;i<aa.length;i++){
	 	 	            src[i]=aa[i].src;    //把所有的src存到数组里
	 	 	        }
	 	 	        var index = $('.up_img').index(this);
	 	 			wx.previewImage({
	 	 		 	    current: src[index], // 当前显示图片的http链接
	 	 		 	    urls: src // 需要预览的图片http链接列表
	 	 		 	});
	 	 	 	 });
 		      }
 		    });
 	     };
 		 
 	  		//点击确认按钮后直接上传图片
 		 var submitPhone = document.querySelector('#submitPhone').onclick = function () {
 	  		if(scrArray.length > 0){
  				var localId = localIds.pop();
			  	wx.uploadImage({
					localId: localId,
					success: function (res) {
					   	var media_id = res.serverId;
					   	medieArray[localIds.length] = media_id;
					   	if(localIds.length > 0){
					   		setTimeout(function(){ submitPhone();},100);
					    } else {
					    	downloadMedia();	
					    }
					}
				});
 	  		} else {
 	  			alert("请上传理赔所需资料。");
 	  		}
 	    	
 	 	};
 	});	
 		
 	 wx.error(function (res) {
 		alert(res.errMsg);
 	});  
 	 
</script>
<link rel="stylesheet" type="text/css" href="../uinew/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/style-font.css">
  </head>
  <body  class="gray">
  <div class="grace-head"> </div>
  	<!--标题区域-->
    <h2 style="margin-top:60px; text-align:center; color:#c8a154; font-size:1.5em; font-weight:bold;">授权声明及上传</h2>

   	<!--报案成功提示区域-->
   	<section class="container">
		<section class="upload_wrap txt16">
			<p class="txt22 title" style="    margin: 0;">资料上传</p>
			<section class="upimg_wrap">
				<div id="upimg_div">
				</div>
				<div class="up_div txt38" id="addPhoto" style="margin-left:108px;">
					+
				</div>
				<p class="blue_font txt14">注：请点击加号上传资料。</p>
			</section>
			<div class="clear"></div>
			<p class="txt22 title"  style="    margin: 0;">申请人授权及声明</p>
			<p>1、本人上述所填内容均为真实可信，如有虚假，愿承担法律责任。</p>
			<p>2、本人已阅读并知晓《反保险欺诈提示》。</p>
			<p>3、本人授权任何医生、医院、保险公司或任何组织，以及凡熟悉被保险人身体健康情况之人士向瑞泰人寿保险有限公司提供相关健康情况、既往病史、诊疗情况、病历、意外细节、相关笔录报告或其他相关资料，本人愿承担由此产生的一切法律责任。</p>
			<p>4、因本人过错导致银行转账不成功、未及时或未全额收取理赔款项的，由本人承担一切责任。</p>
		</section>
    	<!-- 按钮区域 -->
    	
            <ul class="btn-last"> 
              <li onclick="javascript:window.location.href ='<%=path %>/msl/sales/menuClaimAction'">取消 </li>
              <li class="right_btn txt22" id="submitPhone">确认提交 </li>
            </ul>
<div class="footer footer-fixed "> <img src="../uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>

   	</section>
  </body>
</html>
