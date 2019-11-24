<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
 <head>
  <title>国电资本控股</title>
	<%@ include file="../../common/meta.jsp"%>
	<%@ include file="../../common/rels.jsp"%>
	<link href="<%=request.getContextPath()%>/resources/css/charity/common.css?${random}" rel="stylesheet"/>
	<link href="<%=request.getContextPath()%>/resources/css/charity/sale.css?${random}" rel="stylesheet"/> 
	<%-- <link href="<%=request.getContextPath()%>/global/css/group.css?${random}" rel="stylesheet"/> --%>
	 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/charity/insurant.css">
	
	<script src="<%=request.getContextPath() %>/resources/lib/component/form.js"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/validate/jquery.validator.js?${random}"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/validate/local/zh_CN.js?${random}"></script>
<!-- 	工具类 -->
<meta charset="utf-8">

    <!-- jQuery Include -->
	
    <!-- Mobiscroll JS and CSS Includes -->
    
    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.core.js"></script>
    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.frame.js"></script>
    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.scroller.js"></script>

    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.util.datetime.js"></script>
    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.datetimebase.js"></script>
    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.datetime.js"></script>
    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.select.js"></script>
    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.listbase.js"></script>
    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.image.js"></script>
    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.treelist.js"></script>

    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.frame.android.js"></script>
    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.frame.android-holo.js"></script>
    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.frame.ios-classic.js"></script>
    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.frame.ios.js"></script>
    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.frame.jqm.js"></script>
    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.frame.sense-ui.js"></script>
    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.frame.wp.js"></script>

    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.android-holo-light.js"></script>
    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.wp-light.js"></script>
    <script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.mobiscroll-dark.js"></script>

    <script src="<%=request.getContextPath()%>/resources/date/js/i18n/mobiscroll.i18n.zh.js"></script>

    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.animation.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.icons.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.frame.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.frame.android.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.frame.android-holo.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.frame.ios-classic.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.frame.ios.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.frame.jqm.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.frame.sense-ui.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.frame.wp.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.scroller.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.scroller.android.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.scroller.android-holo.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.scroller.ios-classic.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.scroller.ios.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.scroller.jqm.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.scroller.sense-ui.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.scroller.wp.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.image.css" rel="stylesheet" type="text/css" />

    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.android-holo-light.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.wp-light.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.mobiscroll-dark.css" rel="stylesheet" type="text/css" />
    
    <style type="text/css">
        .header { padding: .625em; background: #5185a8;}
        .header h1 { margin: 0; padding: 0; color: #fff; text-align: center; font-size: 1.25em; font-weight: bold; text-shadow: 1px 1px 1px #000; text-overflow: ellipsis; overflow: hidden; white-space: nowrap; }
        .content { padding: 1em; }
        .dwwr{width:500px;}
        .dw-i{font-size: 1.8em;}
    </style>

     <script>
       $(function () {
			var addre = document.getElementById("address_hidden").value;
       		if(addre != ''){
       			document.getElementById("applicantInsured.address").value=addre;
       		}
            function init() {
                
                $('#birthday').mobiscroll().date({
                    theme: theme,     
                    mode: mode,      
                    display: display, 
                    lang: lang,   
                    "height": 90,
               		dateFormat:dateFormat,
               		
                });
                
                
            }    

            var demo, theme, mode, display, lang,dateFormat,endtime;
            
                demo = 'date';
                theme = 'android',
                mode = 'scroller',
                display = 'modal',
                dateFormat= 'yy年mm月dd日',
                
                lang = 'zh';

                $('.demo-cont').hide();
                $("#demo_cont_" + demo).show();
                
                init();
        });
    </script>

	<script src="<%=request.getContextPath()%>/resources/lib/utils/dateUtils.js?${random}" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/utils/idCardUtils.js?${random}" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/utils/stringUtils.js?${random}" type="text/javascript"></script>
	
	<%--  <script src="<%=request.getContextPath()%>/resources/js/page/charityfill.js?${random}"></script>  --%>
  </head>
  		<style>
  		.cbox{display:block;width:30px;height:30px;border:1px solid #000;background:#fff;text-align:center;float:left;}
  		.cbox.checked{background:#fff;}
 		.cbox.checked:after{content:"√"}
 	</style>
  <body onload="show();yuedu();">
 	<div id="head">填写捐赠信息</div>
  <form action="<%=request.getContextPath()%>/msl/sales/charityPolicyInsure" method="post" id="creator" name="creator" enctype="multipart/form-data">
 	<input type="hidden" id="donationFlag" name="donationFlag" value="${donationFlag}" />  		
  	<input type="hidden" id="helpStudyFlag" name="helpStudyFlag" value="${helpStudyFlag}" />  		
  	<input type="hidden" id="sumpremium" name="sumpremium" value="${sumpremium}" />  
  	<input type="hidden" id="policy.sumamount" name="policy.sumamount"  /> 		
  	<input type="hidden" id="policy.sumbasepremium" name="policy.sumbasepremium"  /> 
 	 <div class="center">
 	  <div id="isTrial" style="display: none" >
	 	 <table class="table" style="font-size:1.2em;">
	 	 	<tr>
	 	 		<td colspan="2" style="text-align:center;">瑞泰成长卫士少儿重大疾病保险</td>
	 	 	</tr>
	 	 	<tr>
				<td style="text-align: center; width:40%">投保份数：</td>
				<td style=" width:50%" >
					<div id="min" class="plus" style="text-align:center;float:left;font-size:1.0em">-&nbsp;&nbsp;</div>
					<input type="text" id="count" value="3" disabled style="font-size:1.0em;width:20%;height:38px;text-align:center;float:left;">
					<div id="plus" class="plus" style="font-size:1.0em">&nbsp;&nbsp;+</div>
				</td>
			</tr>
			<tr>
				<td style="text-align: center;width:40%">应付金额：</td>
				<td style=" width:50%;" >
					<input type="text" id="sumbasepremium" value="" disabled style="font-size:1.1em;width:45%;height:38px;float:left;text-align:center;border:none;">
				</td>
			</tr>
			<tr>
				<td style="text-align: center;width:40%">保&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;额：</td>
				<td style=" width:50%" >
					<input type="text" id="coverage"  value="300000.00"  disabled style="font-size:1.1em;width:45%;height:38px;float:left;text-align:center;border:none;">
				</td>
			</tr>
	 	 </table>
	 </div>
	<div class="policy_holder">捐&nbsp;赠&nbsp;人&nbsp;信&nbsp;息</div>
  	<div class="center_fill">
  	<table class="msg">
  		<tr>
  			<td  style="color:red; float:right;">*</td>
  			<td  style="text-align:center;width:40%">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
  			<td  style="float:left;width:100%"><input type=text id="applicantInsured.name" name="applicantInsured.name" value="${applicantInsured.name}"/></td>
  		</tr>
  		<tr>
  			<td  style="color:red; float:right;">*</td>
  			<td  style="text-align:center;">证件类型：</td>
  			<td  style="float:left;width:100%">
					<select id="applicantInsured.identifytype" name="applicantInsured.identifytype" onchange="choose()">
						<option value="I">身份证</option>
						<option value="P">护照</option>
						<option value="S">军官证、士兵证</option>
						<option value="M">回乡证</option>
						<option value="O">临时身份证、户口本</option>
						<option value="H">港澳通行证</option>
						<option value="T">台胞证</option>
					</select>
			</td>
  		</tr>
  		
  		<tr>
  			<td  style="color:red; float:right;">*</td>
  			<td  style="text-align:center;">证件号码：</td>
  			<td  style="float:left;width:100%"><input type=text id="applicantInsured.identifynumber" name="applicantInsured.identifynumber" onchange="changeBirth();"/></td>
  		</tr>
  		<tbody id="message" style="display:none;">
  		<tr>
  				<td  style="color:red; float:right;">*</td>
   				<td style="text-align:center;">出生日期：</td>
   				<td  style="float:left;width:100%"><input type=text id="birthday" name="birthday"/></td>
   				<input type="hidden" id="applicantInsured.birthday" name="applicantInsured.birthday" value="${applicantInsured.birthday}"/>
   				
   			</tr>
  		<tr>
  			<td  style="color:red; float:right;">*</td>
   			<td style="text-align: center;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
   			<td >
   				<select style="font-size:1.0em;width:35%;height:34px;" id="applicantInsured.sex" name="applicantInsured.sex">
   					<option value="M">男</option>
   					<option value="F">女</option>
   				</select>
   				</td>
   			</tr>
   			</tbody>
  		<tr>
  			<td  style="color:red; float:right;">*</td>
  			<td  style="text-align:center;">手机号码：</td>
  			<td  style="float:left;width:100%"><input type=text id="applicantInsured.mobile" name="applicantInsured.mobile" value="${applicantInsured.mobile}"/></td>
  		</tr>
  		<tr>
  			<td  style="color:red; float:right;">*</td>
  			<td  style="text-align:center;">电子邮箱：</td>
  			<td  style="float:left;width:100%"><input type=text id="applicantInsured.email" name="applicantInsured.email" value="${applicantInsured.email}"/></td>
  		</tr>
  		<tr>
  			<td  style="color:red; float:right;">*</td>
  			<td  style="text-align:center;">通讯地址：</td>
			<td  style="float:left;width:100%"><input type=text   id="applicantInsured.address" name="applicantInsured.address" value="北京西城区西直门外大街金贸中心D座5层" />
			<input type="hidden" id="address_hidden" value="${applicantInsured.address}">

  			</td>  	
  		</tr>
  		</table>
	 </div>	
	 <div id="isCharity" style="display: none"> 
	 <div class="continue" style="width:100%;background-color:#eee890;font-size:1.3em;color:#529cbd;margin:20px auto;float:left;padding:10px 0;">
	 <div style="width:70%;float:left;text-align:center;"><span style="margin-left:40%;">续&nbsp;捐&nbsp;选&nbsp;择</span></div>
	 <div  style="width:30%;float:left;text-align:right;">+&nbsp;&nbsp;&nbsp;&nbsp;</div>
	 </div>
	 <div class="clear"></div>
	 <!-- <div class="policy_holder" onclick="hiding">续&nbsp;捐&nbsp;选&nbsp;择</div> -->
  	 <div class="center_fill" id="ischarity" style="display:none;">
  		<table class="msg" >
  			<tr>
  			<td style="text-align:center;width:30%;">
  			<input style="width:1px;height:1px;opacity:0;" type="checkbox" id="renewalflag"/>
  			<div class="cbox" id="check" onclick="this.className=/checked/ig.test(this.className)?this.className.replace('checked',''):(this.className+' checked')">
  			</div></td>
  			<input type="hidden" id="policy.renewalflag" name="policy.renewalflag">  

  			<td style="float:left;width:100%">我要续捐</td>
  		</tr>
  		<tr>
  			<td colspan="2" style="font-size:0.8em;color:red;line-height:2.0em;">注：疾病保障有效期为一年，如您选择续捐，将在保单到期一月前通过微信向您推送续捐信息。</td>
  		</tr>
  		</table>
  	</div>
  	</div>
  	<div id="isHelp" style="display: none">
  	 <div class="policy_holder">助&nbsp;学&nbsp;项&nbsp;目&nbsp;信&nbsp;息</div>
  		<div class="center_fill">
  			<table class="msg">
  			<tr>
  				<td style="text-align:center;width:25%;">
  					<input id="stipend" style="width:1px;height:1px;opacity:0;" type="checkbox" name="stipend"/>
  					<div class="cbox" id="check1" onclick="this.className=/checked/ig.test(this.className)?this.className.replace('checked',''):(this.className+' checked')">
  					</div>
  				</td>
  				<td  style="float:left;line-height:30px;width:100%;">捐赠助学金</td>
  			</tr>
  			<div>
  			<tbody id="help_text" style="display:none">
  			<tr >
  				 <td style="margin-top:-20px;" colspan="2">
  				 <input type="text" class="stipend" id="policy.stipend" name="policy.stipend" maxlength="12" value="" style="font-size:1.0em;width:40%;height:34px;float:left;text-align: center;">元</td>
  			</tr>
  		<tr   >
  			<td colspan="2" style="font-size:0.8em;color:red;line-height:2.0em;margin:20px auto;">注：您选择的被捐赠儿童为${grade}，其一学期学杂费约为${tuition}元，供您参考。</td>
  		</tr>
  		</tbody>
  		<tr>
  			<td style="text-align:center;width:25%">
  			<input id="bookmoney" style="width:1px;height:1px;opacity:0;" type="checkbox" name="bookmoney"/>
  			<div class="cbox" id="check2" onclick="this.className=/checked/ig.test(this.className)?this.className.replace('checked',''):(this.className+' checked')">
  			</div>
  			</td>
  			<td  style="float:left;line-height:30px;width:100%;">捐赠爱心书库</td>
  		</tr>
  		<tbody id="book_text" style="display:none">
  		 <tr >
  			<td style="margin-top:-20px;" colspan="2"><input type="text" value="" class="bookmoney" id="policy.bookmoney" name="policy.bookmoney" maxlength="12" style="font-size:1.0em;width:40%;height:34px;float:left;text-align: center;">元（爱心书库已累计${sumBookMoney}元）</td>
  		</tr>
  		<tr   >
  			<td colspan="2" style="font-size:0.8em;color:red;line-height:2.0em;margin:20px auto;">注：爱心书库捐款每累计3万元，将以贵单位名义向贫困儿童捐赠价值10万元的书籍。您的名字也将出现在捐赠名单中。</td>
  		</tr>
  		</tbody>
  		<tr>
  			<td style="text-align:center;width:25%;">
  			<input style="display:none;" type="radio" name="isAuthorization" id="isAuthorization"/><div class="radio_img"></div>
  			
  			</td>
  			<td  style="float:left;font-size:1.0em;line-height:30px;width:100%">您已授权我司代为捐赠助学金或爱心书库金</td>
  		</tr>
  		</table>
  	</div>
  	</div>
	 </div>
	</form>
	<div class="bottom_btn" style="font-size:2.0em;line-height: 60px;" onclick="save();">确&nbsp;&nbsp;认</div>
	<div class="clear"></div>
	<jsp:include page="../../common/common-modal.jsp"></jsp:include>
	<jsp:include page="../../common/charityfoot.jsp"></jsp:include>
  </body>
  <script type="text/javascript">
  	$(".radio_img").click(function(){
  		if($("#isAuthorization").prop("checked")){
  			$("#isAuthorization").prop("checked",false);
		    $(this).css("background-position-y","-29px");
	     }else{
	    	 $("#isAuthorization").prop("checked",true);
		     $(this).css("background-position-y","0");
	     }
	});
  </script>
  <script>
  
  	function account(){
       var a=document.getElementById("count").value;
       var b=100000
       document.getElementById("coverage").value=Number(a*b).toFixed(2);
 	} 
  	function choose(){
  		var card=document.getElementById("applicantInsured.identifytype").value;
  		if(card=="I"){
  			document.getElementById("message").style.display="none";
  		}else
  		{
  			document.getElementById("message").style.display="";
  		}
  	}
  $("#check").click(function(){
		if(document.getElementById("renewalflag").checked==true){
			 document.getElementById("renewalflag").checked=false;
		}else{
			 document.getElementById("renewalflag").checked=true;	
		}
	}); 
	$(".continue").click(function(){
		if(document.getElementById("ischarity").style.display==""){
			document.getElementById("ischarity").style.display="none";
		}
		else
		 {
		document.getElementById("ischarity").style.display="";
		}
	})
  </script>
  <script>
  $("#check1").click(function(){
		if(document.getElementById("stipend").checked==true){
			 document.getElementById("stipend").checked=false;
			 $("#help_text").css("display","none");
			 $("#help_text").attr("value","");
			  document.getElementById("policy.stipend").value=""; 
		}else{
			 document.getElementById("stipend").checked=true;
			 $("#help_text").css("display","");
			
		}
	});
	
  $("#check2").click(function(){
		if(document.getElementById("bookmoney").checked==true){
			 document.getElementById("bookmoney").checked=false;
			 $("#book_text").css("display","none");
			 $("#book_text").attr("value",""); 
			 document.getElementById("policy.bookmoney").value=""; 
			
		}else{
			 document.getElementById("bookmoney").checked=true;
			 $("#book_text").css("display","");	
			
			 
		}
	});
  </script>
  <script type="text/javascript">
  	$("#plus").click(function(){
  		 if($("#count").val()*1<3){
  			$("#count").val($("#count").val()*1+1);
  			account();
  			trial();
  		}
  	});
  	$("#min").click(function(){
  		if($("#count").val()*1>1){
  			$("#count").val($("#count").val()*1-1);
  			account();
  			trial();
  		}
  	});
  
  	$(".stipend").click(function(){
 		var stipendFlag = document.getElementById("stipend").checked;//捐赠助学金标志
		if(!stipendFlag){
			 alert("请先勾选捐赠助学金");
			 return false;
		}
	}); 
 	
 	$(".bookmoney").click(function(){
		var bookmoneyFlag = document.getElementById("bookmoney").checked;//捐赠爱心书库标志
		if(!bookmoneyFlag){
			 alert("请先勾捐赠爱心书库");
			 return false;
		}
	}); 
  	
  	function save(){
  			modal_loading();
			//校验
			if(!check()){
				modal_loading('hide');
				return;
			}
			
			var flag = document.getElementById("renewalflag").checked;//续保标志
			if(flag){
				document.getElementById("policy.renewalflag").value = "1";
			}else{
				document.getElementById("policy.renewalflag").value = "2";
			}
			var stipendFlag = document.getElementById("stipend").checked;//捐赠助学金标志
			var bookmoneyFlag = document.getElementById("bookmoney").checked;//捐赠爱心书库标志
			var isAuthorizationFlag = document.getElementById("isAuthorization").checked;//授权标志
			var stipend = document.getElementById("policy.stipend").value;//捐赠助学金
			var bookmoney = document.getElementById("policy.bookmoney").value;//捐赠爱心书库
			var   su   =   /^[0-9]*[1-9][0-9]*$/;
			var  helpStudyFlag = $("#helpStudyFlag").val();
			if(bookmoneyFlag){
				if(bookmoney==""||bookmoney.length==0){
	 				alert("请填写捐赠爱心书库金额");
	 				return false;
	 			}
			}
			if(bookmoney.length>0 && !bookmoneyFlag){
				alert("请勾选捐赠爱心书库");
				return false;
			}
			if(bookmoney.length>0 && !su.test(bookmoney) ){
				alert("只能输入整数");
				return false;
			}
			if(stipendFlag){
				if(stipend==""||stipend.length==0){
	 				alert("请填写捐赠助学金金额");
	 				modal_loading('hide');
	 				return false;
	 			}
			}
			if(stipend.length>0 && !stipendFlag){
				alert("请勾选捐赠助学金");
				modal_loading('hide');
				return false;
			}
			if(stipend.length>0 && !su.test(stipend) ){
				alert("只能输入整数");
				modal_loading('hide');
				return false;
			}
			if(stipendFlag || bookmoneyFlag){
				if(!isAuthorizationFlag){
					alert("请勾选您已授权我司代为捐赠助学金或爱心书库金");
					modal_loading('hide');
					return false;	
					
				}
			}
			if(helpStudyFlag=='1'){
				if(!stipendFlag && !bookmoneyFlag){
						alert("助学金或爱心书库金至少选择一份捐赠");
						modal_loading('hide');
						return false;	
				}
			}
			trial1();
		
		}
  	 function trial1(){
		  count = Number($("#count").val());//取得份数
		  sumpremium = 100000.00*count;
		  if(count>=1&&count<=3){
			  $.ajax({
				   type:"POST",
				   url:contentRootPath+"/msl/sales/charityPolicyCalculate",
				   data:{
					   "policy.sumamount":sumpremium
				   },
				   dataType:"json",
				   success:function(data){
						var inputAmnt=Number(data.sumbasepremium).toFixed(2);
					    amntFormat=outputmoney(inputAmnt);
					    $("#sumbasepremium").val(amntFormat);
						document.getElementById("policy.sumamount").value = sumpremium;//保额	
						var birthday =  $("#birthday").val().replace("年","-").replace("月","-").replace("日","");
						document.getElementById("applicantInsured.birthday").value = birthday;
						$("#creator").submit();
					}
				}); 
		  }else{
			  count = Number($("#count").val());//取得份数
				sumpremium = 100000.00*count;
				document.getElementById("policy.sumamount").value = sumpremium;//保额
				var  sumpre = $("#sumbasepremium").val();
				var inputAmnt=Number(sumpre).toFixed(2);
				amntFormat=outputmoney(inputAmnt);
				//document.getElementById("policy.sumbasepremium").value = amntFormat;//保费
				var birthday =  $("#birthday").val().replace("年","-").replace("月","-").replace("日","");
				document.getElementById("applicantInsured.birthday").value = birthday;
				$("#creator").submit();
		  }
	  }	
  	
	function getBirth(value) {
        var year = "1900";
        var month = "1";
        var day = "1";
        if (value.length == 15) {
            year = "19" + value.substr(6, 2);
            month = value.substr(8, 2);
            day = value.substr(10, 2);
        } else if (value.length == 18) {
            year = value.substr(6, 4);
            month = value.substr(10, 2);
            day = value.substr(12, 2);
        } else {
            return "";
        }
        newDate = new Date(year, month - 1, day);
        if (newDate.toString() == "NaN") {
            return "";
        }
        else {
            var start =  year + "-" + month + "-" + day;
            return start;
        }
    }
		
		
		function changeBirth(){
			var value = document.getElementById("applicantInsured.identifynumber").value;
			  var year = "1900";
	            var month = "1";
	            var day = "1";
	            if (value.length == 15) {
	                year = "19" + value.substr(6, 2);
	                month = value.substr(8, 2);
	                day = value.substr(10, 2);
	            } else if (value.length == 18) {
	                year = value.substr(6, 4);
	                month = value.substr(10, 2);
	                day = value.substr(12, 2);
	            } else {
	                return;
	            }
	            newDate = new Date(year, month - 1, day);
	            if (newDate.toString() == "NaN") {
	                return;
	            }
	            else {
	            	var sex = getSex(value);
	            	document.getElementById("applicantInsured.sex").value = sex;
	            	document.getElementById("birthday").value = year+"年"+month+"月"+day+"日";
	            }
		}
	
		
		function getSex(value){
			if (parseInt(value.substr(16, 1)) % 2 == 1) {
				return "M";
		} else {
			return "F"; 
		} 
		}
		//取页面上的值
		function getObj(id){
			return document.getElementById(id).value;
		}
		//校验其它证件
		function check1(value,type){
			var result="";
			var length=value.length;
			if(type=="P"){
				if(length <3){
					alert('护照号码不得小于3个字符');
					return false;
				}
			}
			if(type=="M"){
				if(length <8){
					alert('港澳回乡证号码不得小于8个字符');
					return false;
				}
			}
			if(type=="T"){
				if(length <8){
					alert('台胞证号码不得小于8个字符');
					return false;
				}
			}
			if(type=="O"){
				if(length <3){
					alert('户口本号码不得小于3个字符');
					return false;
				}
			}
			if(type=="S"){
				if(length <10){
					alert('军官证或士兵证号码应在10到18个字符之间');
					return false;
				}
				if(length >18){
					alert('军官证或士兵证号码应在10到18个字符之间');
					return false;
				}
			}
			return true;
		}
		
		
		//校验
		function check(){
			var applicantInsuredname = document.getElementById("applicantInsured.name").value;//投保人姓名
			var applicantInsuredidentifytype = document.getElementById("applicantInsured.identifytype").value;//投保人证件类型
			var applicantInsuredidentifynumber =document.getElementById("applicantInsured.identifynumber").value;//投保人证件号
			var adress = document.getElementById("applicantInsured.address").value;
			var re =  /^[A-Z u4E00-u9FA5]+$/;//校验姓名的正则
			var ree = /^\d{15}(\d{2}(x|X|\d))?$/;//校验身份证号的正则
			var age = parseInt(new Date().getFullYear()) - parseInt(applicantInsuredidentifynumber.substring(6,10));//投保人年龄
			if(applicantInsuredname==""||applicantInsuredname.length==0){
				alert("请输入投保人姓名");
				return false;
			}
		 	var yw = /^[a-zA-Z ]{3,8}$/;
			var zw = /^[\u4e00-\u9fa5]{2,4}$/;
			if(yw.test(applicantInsuredname)|| zw.test(applicantInsuredname)){
			}else{
				alert("您输入的投保人姓名格式不正确！");
				return false;
			}
			if(applicantInsuredidentifytype == 'I'){
				if(applicantInsuredidentifynumber.length!=15&&applicantInsuredidentifynumber.length!=18){
					alert("您输入的证件号码有误");
	 				return false;
				}else if(!ree.test(applicantInsuredidentifynumber)){
					alert("您输入的证件号码有误");
	 				return false;
				}
				var start = getBirth(applicantInsuredidentifynumber);
				var br =  $("#birthday").val().replace("年","-").replace("月","-").replace("日","");//取得生日
				if(start!=br){
					alert("您输入的证件号码有误");
	 				return false;
				}else if(getSex(applicantInsuredidentifynumber)!=document.getElementById("applicantInsured.sex").value){
					alert("您输入的证件号码有误");
	 				return false;
				}else if(age<18){
					alert("投保人需大于18周岁");
	 				return false;
				}
			}else{
				if(applicantInsuredidentifynumber==""||applicantInsuredidentifynumber.length==0){
					alert("请输入投保人证件号");
	 				return false;
				}else if(!check1(applicantInsuredidentifynumber,applicantInsuredidentifytype)){
	 				return false;
				}
			}
			//校验手机
			var phone = document.getElementById("applicantInsured.mobile").value;
			var re1 = /^0?1[3|7|5|8][0-9]\d{8}$/;
		  	if(!re1.test(phone)){
		  		alert("请输入正确的手机号码");
			return false;
		 	}
			
		  	//校验投保人生日
		  	/* var birthday = $("#birthday").val().replace("年","-").replace("月","-").replace("日","");//取得生日
		  	var date = new Date(Date.parse(birthday));
		  	var age = (new Date().getTime() - date.getTime())/(24 * 60 * 60 * 1000); */
		 	
		  	var birthday = $("#year").val();
			var age =  parseInt(new Date().getFullYear()) - parseInt(birthday);
			if(age<18){
				alert("投保人年龄须在18以上");
				return false;
			}
			
			//校验邮箱
 		  	var email=document.getElementById("applicantInsured.email").value;
 			var re2 =/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
 			if(email.length==0||email==""){
 				alert("请输入您的电子邮箱");
 				return false;
 			}else if(!re2.test(email)){
 				alert("电子邮箱有误,请核对后输入");
 				return false;
 			}
			//校验投保人地址
			if(adress==""||adress.length==0){
				alert("请输入地址");
 			return false;
			}else if(adress.length<8){
				alert("请输入有效的地址");
				return false;
			}
			
			return true;
		}
		 //保费试算
		  function trial(){
			  count = Number($("#count").val());//取得份数
			  sumpremium = 100000.00*count;
			  if(count!=null&&count!=""){
				  $.ajax({
					   type:"POST",
					   url:contentRootPath+"/msl/sales/charityPolicyCalculate",
					   data:{
						   "policy.sumamount":sumpremium
					   },
					   dataType:"json",
					   success:function(data){
							var inputAmnt=Number(data.sumbasepremium).toFixed(2);
						    amntFormat=outputmoney(inputAmnt);
						    $("#sumbasepremium").val(amntFormat);
						    document.getElementById("policy.sumbasepremium").value = amntFormat;//保费
						    modal_loading('hide');
						  
							var birthday2 =  data.prodoctcode;
							if(birthday2!=null&&birthday2.length>0){
								document.getElementById("applicantInsured.birthday").value=birthday2;
								document.getElementById("birthday").value=birthday2;
							} 
							//回显份数
					  		var unicount =  data.unitcount
					   		if(unicount != '' &&  unicount != null){
					   			$("#count").val(data.unitcount);
					   			trial();
					   		}
						}
					}); 
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
		function show(){
			
			var  donationFlag = $("#donationFlag").val();
			var  helpStudyFlag = $("#helpStudyFlag").val();
			var  sumpremium = $("#sumpremium").val();
			var inputAmnt=Number(sumpremium).toFixed(2);
		    amntFormat=outputmoney(inputAmnt);
			if(donationFlag=='1'){
				$('#isCharity').show();
				$('#isTrial').show();
				$('#count').val('3');
				trial();
			} else if(donationFlag=="0"){
				document.getElementById("policy.sumbasepremium").value =0;//保费
			}
			
			if(helpStudyFlag=='1'){
				$('#isHelp').show();
			}
		}
		function yuedu(){
		 if(document.getElementById("renewalflag").checked==true){
				document.getElementById("check").className='cbox checked';
				$("#ischarity").css("display","");
			 }
			 if(document.getElementById("stipend").checked==true){
				document.getElementById("check1").className='cbox checked';
				$("#help_text").css("display","");
			 }
			 if(document.getElementById("bookmoney").checked==true){
				document.getElementById("check2").className='cbox checked';
				 $("#book_text").css("display","");	
				 
			 }
			 if(document.getElementById("isAuthorization").checked==true){
				 $(".radio_img").css("background-position-y","0");
				 $("this").prop("checked",true);
			 }
			 choose();
			 var new_br=document.getElementById("applicantInsured.birthday").value;
 			 if(new_br!=null&&new_br.length>0){
 				document.getElementById("birthday").value=new_br;
 				var d=new Date(new_br);
 				var y=d.getFullYear();
 				var m=d.getMonth()+1;
 				var day=d.getDate();
 				var d1=y+"年"+m+"月"+day+"日";
 				document.getElementById("birthday").value=d1;
			}

		}
		
					  		
  </script>
 
</html>
