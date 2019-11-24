<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
  <head>
  <title>投保信息-瑞泰人寿</title>
 	<!-- <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport"> -->
	 <%@ include file="../../common/meta.jsp"%> 
	<%@ include file="../../common/rels.jsp"%>
	<%@ include file="/common/page/common.jsp"%>
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
	<script src="<%=request.getContextPath()%>/resources/js/page/area.js?${random}"></script>
  </head>
  <style>
  			 .checkbox_div{width: 90%;margin: 5px auto;margin-left: 40px;}
		 .checkbox_div input[type='checkbox']{display:none;}
		 .checkbox_div .checkbox{width: 20px;height: 20px;border: 1px solid #535353;float: left;margin: 2px 5px auto auto;}
		 .checkbox_div .checked_img{border: #535353 solid;border-width:2px 2px 0 0;width: 12px;height: 7px;position:absolute;
		 transform:rotate(135deg);-webkit-transform:rotate(135deg);-ms-transform:rotate(135deg);display: inline-block;margin: 2px auto auto 2.5px;display:none;}
 	</style>
  <body onload="init1();hint();">
  	<div class="nav">
  		<div class="menu" style="color:#fff;">填写信息</div>
  		<div class="menu">健康告知</div>
  		<div class="menu">确认投保</div>
  		<div class="menu">在线缴费</div>
  	</div>
  	<form action="<%=request.getContextPath()%>/msl/sales/longPolicyInsureInput" method="post" id="creator" name="creator" enctype="multipart/form-data">
  	<div class="policy_holder">投&nbsp;保&nbsp;人&nbsp;信&nbsp;息</div>
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
				<select id="applicantInsured.identifytype" name="applicantInsured.identifytype" >
						<option value="I">身份证</option>
						<option value="P">护照</option>
						<option value="S">军官证/士兵证</option>
						<option value="O">户口本</option>
						<option value="H">港澳居民来往内地通行证/回乡证</option>
						<option value="T">台湾居民来往大陆通行证/台胞证</option>
				</select>
			<%-- <input type=text name="applicantInsured.identifytype" value="${applicantInsured.identifytype}"/> --%>
			</td>
  		</tr>
  		<tr>
  			<td  style="color:red; float:right;">*</td>
  			<td  style="text-align:center;">证件号码：</td>
  			<td  style="float:left;width:100%"><input type=text id="applicantInsured.identifynumber" name="applicantInsured.identifynumber" onchange="changeBirth();"/></td>
  		</tr>
  		
  		
  		<tr>
  			<td  style="color:red; float:right;">*</td>
  			<td  style="text-align:center;">出生日期：</td>
 			<td >
	 			<input  class="data_input" style="text-align: left;" type=text  id="start" name="start" readonly="readonly" />
 			</td>
 			<input type="hidden" id="applicantInsured.birthday" name="applicantInsured.birthday" value="${applicantInsured.birthday}" />
  		</tr>
  		<tr>
  			<td  style="color:red; float:right;">*</td>
  			<td  style="text-align:center;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
  			<td >
				<select style="font-size:1.0em;width:35%;height:34px;" id="applicantInsured.sex" name="applicantInsured.sex">
					<option value="M">男</option>
					<option value="F">女</option>
				</select>
   			</td>
  		</tr>
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
  			<td  style="float:left;width:100%">
	  			<select style="width:35%;" name="province" id="province" onchange ="select1();"></select>
	  			<select style="width:55%;  margin-left:5%" name="city" id="city" onchange = "select1();" ></select>
  			</td>
  		</tr>
  		<tr>
  			<!-- <td  style="color:red; float:right;">&nbsp;</td>
  			<td  colspan=2 width=100%><input type="text" id="address" ></td> -->
			<input type="hidden" id="applicantInsured.address" name="applicantInsured.address" value="${applicantInsured.address}" />  		
  		</tr>
  	</table>
  	</div>
  	
  	<div class="policy_holder">被&nbsp;保&nbsp;人&nbsp;信&nbsp;息</div>
  	<div class="center_fill">
  	<table class="msg">
  		<tr>
  			<td colspan="2" style="text-align:center;">与投保人关系：</td>
  			<td  style="float:left; align:center;width:50%">
				<select style="width:100%" id="recognizee.insrelationapp" name="recognizee.insrelationapp">
					<option value="CH">子女</option>
<!-- 				<option value="PA">父母</option>
					<option value="EM">雇佣</option>
					<option value="SF">本人</option>
					<option value="ES">法定</option>
					<option value="GF">（外）祖父母</option> -->
				</select>
			</td>
  		</tr>
  		<tr>
  			<td style="color:red; float:right;">*</td>
  			<td style="text-align:center;width:40%">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
  			<td style="float:left;width:100%"><input type=text id="recognizee.name" name="recognizee.name" value="${recognizee.name}"/></td>
  		</tr>
  		<tr>
  			<td style="color:red; float:right;">*</td>
  			<td style="text-align:center;">证件类型：</td>
  			<td  style="float:left;width:100%">
				<select id="recognizee.identifytype" name="recognizee.identifytype" onchange="hint();">
						<option value="O">户口本</option>
						<option value="I">身份证</option>
						<option value="P">护照</option>
						<option value="S">军官证/士兵证</option>
						<option value="H">港澳居民来往内地通行证/回乡证</option>
						<option value="T">台湾居民来往大陆通行证/台胞证</option>
				</select>
			</td>
  		</tr>
  		<tr>
  			<td style="color:red; float:right;">*</td>
  			<td style="text-align:center;">证件号码：</td>
  			<td style="float:left;width:100%"><input type=text id="recognizee.identifynumber" name="recognizee.identifynumber" value="${recognizee.identifynumber}" /></td>
  		</tr>
  		<!-- <p style="color: red;font-size: 0.9em;text-align:left;line-height:2.0em;">如选择户口本，请输入被保险人出生日期</p> -->
  		<tr>
  			<td style="color:red; float:right;">&nbsp;</td>
  			<td style="text-align:center;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
  			<td style="float:left;width:100%">&nbsp;${sex}</td>
  		</tr>
  		<tr>
  			<td style="color:red; float:right;">&nbsp;</td>
  			<td style="text-align:center;">出生日期：</td>
  			<td style="float:left;width:100%">&nbsp;${birthday}</td>
  		</tr>
  	</table>
  	</div>
  	<div class="policy_holder">受益人信息</div>
  	<div class="center_fill">
  	<div class="choose">
  		<table  class="msg">
  		<tr>
  			<td style="color:red; float:right;">&nbsp;</td>
  			<td style="text-align:center;">受益人</td>
  			<td style="float:left;width:100%">被保险人本人</td>
  		</tr>
  	</table>
  	</div>
  	</div>
  	<div class="policy_holder">续保选择</div>
  	<div class="center_fill">
  	<div class="choose">
  		<table  class="msg">
  		
  		<tr>
  			<td style="text-align:center;">
  			<input style="width: 25px;height: 25px;" type="checkbox"  id="renewalflag" /> 
  			
  			<input type="hidden" id="policy.renewalflag" name="policy.renewalflag">
  			<div class="checkbox" >
  			<span class="checked_img">
  			</span></div>
  			</td>
  			<td style="text-align:left;">申请续保至被保险人25岁</td>
  		</tr>
  		<tr>
  			<td   style="text-align:left;width:40%">续保缴费银行</td>
  			<td  style="float:left;width:100%">
				<!-- <select id="policy.bank" name="policy.bank">
						<option value="工商银行">工商银行</option>
						<option value="建设银行">建设银行</option>
						<option value="招商银行">招商银行</option>
						<option value="邮政储蓄银行">邮政储蓄银行</option>
						<option value="广发银行">广发银行</option>
						<option value="光大银行">光大银行</option>
				</select> -->
				<select id="policy.bank"
							name="policy.bankBranchCode">
							 <c:if test="${brNo=='TM001'}">
								<option value="090004">中信银行信用卡</option>
								<option value="130302">中信银行储蓄卡</option>
							</c:if> 
								<option value="130102">工商银行</option>
								<option value="100103">农业银行</option>
								<option value="130104">中国银行</option>
								<option value="130105">建设银行</option>
								<option value="130308">招商银行</option>
								<!--<option value="100305">民生银行</option>-->
								<option value="100307">平安银行</option>
								<option value="100310">浦发银行</option>
								<!--<option value="100309">兴业银行</option>-->
								<option value="100303">光大银行</option>
								<!--<option value="100304">华夏银行</option>-->
								<option value="100306">广发银行</option>
							<c:if test="${brNo!='TM001'}">
								<option value="130302">中信银行</option>
							</c:if>
								<option value="100403">邮政储蓄银行</option>
								<option value="100301">交通银行</option>
						</select>
			</td>
  			<%-- <td   style="float:left;width:100%"><input type=text id="policy.bank" name="policy.bank" value="${policy.bank}"/></td> --%>
  		</tr>
  		<tr>
	  		<td>开户行所在地：</td>
	  		 <td>
	  			<select style="width:35%;" name="bankProvinceAddress" id="bankProvinceAddress" onchange ="select1();"></select>
	  			<select style="width:55%;  margin-left:5%" name="bankCityAddress" id="bankCityAddress" onchange = "select1();" ></select>
	  			<input type="hidden" id="policy.bankProvince" name="policy.bankProvince" value="${policy.bankProvince}" />
				<input type="hidden" id="policy.bankCity" name="policy.bankCity" value="${policy.bankCity}" />
	  		</td>
	  		
  		</tr>
  		<tr>
  			<td   style="text-align:left;">续保缴费账号</td>
  			<td   style="float:left;width:100%"><input type=text id="policy.bankAccountNumber" name="policy.bankAccountNumber" value="${policy.bankAccountNumber}"/></td>
  		</tr>
  	</table>
  	<p style="color: red;font-size: 0.9em;margin-bottom:10px;text-align:left;">提示：</p>
  	<p style="color: red;font-size: 0.9em;text-align:left;line-height:2.0em;">●每年缴纳续期保费时，将根据被保险人年龄持续享受所对应的保费优惠</p>
  	<p style="color: red;font-size: 0.9em;margin-bottom:10px;text-align:left;line-height:2.0em;">●如选择续保，将每年从上述续保缴费账户自动划扣保费。 如不选择续保，保单将在1年后自动终止。</p>
  	<p style="color: red;font-size: 0.9em;text-align:left;line-height:2.0em;">●请填写投保人本人活期储蓄卡/折，不能使用信用卡</p>
  	</div>
  	</div>
  	<div class="notice_btn" onclick="save()">下一步：健康告知</div>
  	</form>
  	<jsp:include page="../../common/footer.jsp"></jsp:include>
  </body> 
 <script type="text/javascript">
 $(".checkbox").click(function(){
		if($(this).prev().prop("checked")==false){
			$(this).find(".checked_img").show();
			$(this).prev().prop("checked",true);
		}else{
			$(this).find(".checked_img").hide();
			$(this).prev().prop("checked",false);
		}
	});	
	//校验
	function check(){
		var applicantInsuredname = getObj("applicantInsured.name");//投保人姓名
		var applicantInsuredidentifytype = getObj('applicantInsured.identifytype');//投保人证件类型
		var applicantInsuredidentifynumber = getObj("applicantInsured.identifynumber");//投保人证件号
		var province = document.getElementById("province").value=="省/市"?"":document.getElementById("province").value;//投保人地址
		var city = document.getElementById("city").value=="市/区"?"":document.getElementById("city").value;//投保人地址
		/* var adressText = document.getElementById("address").value==null?"":document.getElementById("address").value;//投保人地址 */
		var bankProvince = document.getElementById("bankProvinceAddress").value=="省/市"?"":document.getElementById("bankProvinceAddress").value;//开户行地址
		var bankCity = document.getElementById("bankCityAddress").value=="市/区"?"":document.getElementById("bankCityAddress").value;//开户行地址
		var adressTemp = province+city;//投保人地址
		var regExp = /<\/?[^>]+>/gi; 
		var adress =  adressTemp.replace(regExp,""); 
		var recognizeeidentifynumber = getObj("recognizee.identifynumber");//被保人证件号
		var recognizeeSex = null
		if('${sex}' == '男'){
			recognizeeSex = 'M';
		}else{
			recognizeeSex = 'F';
		}
		if(applicantInsuredname==""||applicantInsuredname.length==0){
			alert("请输入投保人姓名");
			return false;
		}else if(!/^[a-zA-Z ]{3,20}$/.test(applicantInsuredname)&&!/^[\u4e00-\u9fa5]{2,10}$/.test(applicantInsuredname)){
			alert("请输入正确的投保人姓名");
			return false;
		}
		if(applicantInsuredidentifytype == 'I'){
			var age = parseInt(new Date().getFullYear()) - parseInt(applicantInsuredidentifynumber.substring(6,10));//投保人年龄
			if(!IdentityCodeValid(applicantInsuredidentifynumber,true)){
				return false;
			}
			var start = getBirth(applicantInsuredidentifynumber);
			var br =  $("#start").val().replace("年","-").replace("月","-").replace("日","");//取得生日
			if(start!=br){
				alert("投保人身份证号与生日不相符");
				return false;
			}else if(getSex(applicantInsuredidentifynumber)!=getObj("applicantInsured.sex")){
				alert("投保人身份证号与性别不相符");
				return false;
			}else if(age<18){
				alert("投保人需大于18周岁");
				return false;
			}
		}else{
			if(applicantInsuredidentifynumber==""||applicantInsuredidentifynumber.length==0){
				alert("请输入投保人证件号");
				return false;
			}else if(!check1(applicantInsuredidentifytype,applicantInsuredidentifynumber)){
				return false;
			}
		}
		//校验手机
		var phone = getObj("applicantInsured.mobile");
		var re1 = /^0?1[3|7|5|8][0-9]\d{8}$/;
	  	if(!re1.test(phone)){
	  		alert("请输入正确的手机号码");
			return false;
	 	}
		
	  	//校验投保人年龄
	  	var birthday = $("#year").val();
		var age =  parseInt(new Date().getFullYear()) - parseInt(birthday);
		if(age<18){
			alert("投保人年龄须在18以上");
			return false;
		}
	  	
	  	//校验邮箱
	  	var email=getObj("applicantInsured.email");
		var re2 =/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if(email.length==0||email==""){
			alert("请输入您的电子邮箱");
			return false;
		}else if(!re2.test(email)){
			alert("电子邮箱有误,请核对后输入");
			return false;
		}
		
		var re3 = /^([\u4e00-\u9fa5]|[a-zA-Z0-9])+$/;
		if(adress==""||adress.length==0){
			alert("请输入地址");
			return false;
		}/* else if(adress.length<8||adress.length>30){
			alert("请输入有效的地址");
			return false;
		} */else if(!re3.test(adress)){
			alert("请输入有效的地址！");
			return false;
		}else if(province==""||city==""||province.length==0||city.length==0){
			alert("请输入有效的地址");
			return;
		}
		
		//校验被保人姓名
		if(getObj("recognizee.name")==""||getObj("recognizee.name").length==0){
			alert("请输入被保人姓名");
			return false;
		}else if(!/^[a-zA-Z ]{3,20}$/.test(getObj("recognizee.name"))&&!/^[\u4e00-\u9fa5]{2,10}$/.test(getObj("recognizee.name"))){
			alert("请输入正确的被保人姓名");
			return false;
		}else if(getObj("recognizee.name")==applicantInsuredname){
			alert("投被保人姓名不能一致");
			return false;
		}
		
		//校验续保标识
		var flag = document.getElementById("renewalflag").checked;//续保标志
		var bankAccountNumber = getObj("policy.bankAccountNumber");
		var bankName = getObj("policy.bank");
		var reg = /^[0-9]{8,20}$/;//校验银行卡号为8到20之间的数字
		if(flag){
			if (bankProvince==""||bankProvince.length==0&&bankCity==""||bankCity.length==0) {
				alert("如您选择续保，请填写开户行所在地！");
				return false;
				}
			if(bankName.lengh==0||bankName==""||bankAccountNumber.lengh==0||bankAccountNumber==""){
				alert("如果您选择续保，请填写续保银行及账号");
				return false;
			}else if(!reg.test(bankAccountNumber)) {
				alert("您输入的银行账号有误，请重新输入！");
				return false;
			}
	
			var arr=new Array();//校验银行卡号不能全部相同
			var fg;
			for(var i=0;i<bankAccountNumber.length;i++){
				arr[i]=bankAccountNumber.substring(i,i+1);
				if(arr[0]!=arr[i]){
					fg=true;
				}
			}
			if(fg!=true){
				  alert("您输入的银行账号有误，请重新输入！");
			        return;
			}
		}else{
			if(bankName.length>0&&bankAccountNumber.length>0){
				alert("请您先选择续保，再填写续保银行及账号");
				return false;
			}
		}
		
		
		
		
		if(getObj("recognizee.identifytype") == 'I'){
			
			if(!IdentityCodeValid(recognizeeidentifynumber)){
				return false;
			}
			
			var start = getBirth(recognizeeidentifynumber,false);
			var br =  '${birthday}';
			var birthday = br.replace('年','-').replace('月','-').replace('日','');
			if(start!=birthday){
				alert("被保人身份证号与生日不相符");
				return false;
			}else if(getSex(recognizeeidentifynumber)!=recognizeeSex){
				alert("被保人身份证号与性别不相符");
				return false;
			}
		}else{
			if(recognizeeidentifynumber.length==""||recognizeeidentifynumber.length==0){
				alert("请输入被保人证件号");
				return false;
			}else if(!check1(getObj("recognizee.identifytype"),recognizeeidentifynumber)){
				return false;
			}
		}
		return true;
	} 
  	
	

	//type = true 投保人 flase 被保人
	function IdentityCodeValid(code,type) {
		            var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
		            var tip = "";
		            var pass= true;
		          if(!code || !/(^\d{15}$)|(^\d{17}(\d|X)$)/.test(code)){
					  if(type){
						  tip = "投保人身份证号格式错误";  
					  }else{
						  tip = "被保险人身份证号格式错误";
					  }
		               pass = false;
		                
		            }
		           if(!city[code.substr(0,2)]){
						if(type){
							tip = "投保人身份证地址编码错误";
						}else{
							tip = "被保人身份证地址编码错误";
						}
		                
		                pass = false;
		            }
		            else{
		                //18位身份证需要验证最后一位校验位
		                if(code.length == 18){
		                    code = code.split('');
		                    //∑(ai×Wi)(mod 11)
		                    //加权因子
		                    var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
		                    //校验位
		                    var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
		                    var sum = 0;
		                    var ai = 0;
		                    var wi = 0;
		                    for (var i = 0; i < 17; i++)
		                    {
		                        ai = code[i];
		                        wi = factor[i];
		                        sum += ai * wi;
		                    }
		                    var last = parity[sum % 11];
		                    if(parity[sum % 11] != code[17]){
							if(type){
								tip = "投保人身份证校验位错误";
							}else{
								tip = "被保人身份证校验位错误";
							}
		                        pass =false;
		                    }
		                }
		            }
		            if(!pass) alert(tip);
		            return pass;
			}
  
 		//保存投被保人信息并将页面跳转至健康告知
 		function save(){
 			//校验
 			if(!check()){
 				return;
 			}
 			var flag = document.getElementById("renewalflag").checked;//续保标志
 			if(flag){
 				document.getElementById("policy.renewalflag").value = "1";
 			}else{
 				document.getElementById("policy.renewalflag").value = "2";
 			}
 			var province = document.getElementById("province").value=="省/市"?"":document.getElementById("province").value;//投保人地址
 			var city = document.getElementById("city").value=="市/区"?"":document.getElementById("city").value;//投保人地址
 			/* var adressText = document.getElementById("address").value==null?"":document.getElementById("address").value;//投保人地址 */
 			var adressTemp = province+city;//投保人地址
 			var bankProvince = document.getElementById("bankProvinceAddress").value=="省/市"?"":document.getElementById("bankProvinceAddress").value;//开户行地址
 			var bankCity = document.getElementById("bankCityAddress").value=="市/区"?"":document.getElementById("bankCityAddress").value;//开户行地址
 			var regExp = /<\/?[^>]+>/gi; 
 			var address =  adressTemp.replace(regExp,"");
 			var br = $("#start").val().replace("年","-").replace("月","-").replace("日","");//取得生日
 			document.getElementById("policy.bankProvince").value=bankProvince;
			document.getElementById("policy.bankCity").value=bankCity;
 			document.getElementById("applicantInsured.address").value = address;
 			document.getElementById("applicantInsured.birthday").value = br;
 			$("#creator").submit();
 		}
 		
 		//身份证算生日
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
 			var value = getObj("applicantInsured.identifynumber");
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
            	document.getElementById("start").value = year+"年"+month+"月"+day+"日";
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
 				if(length <10||length >18){
 					alert('军官证或士兵证号码应在10到18个字符之间');
 					return false;
 				}
 			}
 			return true;
 		}
 		
 	//被保人证件号回显生日
	function hint(){
		var type = getObj("recognizee.identifytype");
		if(type=='O'){
			var brTemp = '${birthday}';
			brTemp = brTemp.replace("年","").replace("月","").replace("日","");
			document.getElementById("recognizee.identifynumber").value = brTemp;
		}else{
			document.getElementById("recognizee.identifynumber").value = "";
		}
	}


	/* function yuedu(){
			 if(document.getElementById("renewalflag").checked==true){
				document.getElementById("check").className='cbox checked';
			 }
		} */

</script>
</html>
