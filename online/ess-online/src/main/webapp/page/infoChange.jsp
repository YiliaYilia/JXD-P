<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>个人信息变更</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link href="../global/css/common/main.min.css?${random}" rel="stylesheet"/>	
    <link rel="stylesheet" href="../global/css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="../global/css/all.css" type="text/css"></link>
    <link rel="stylesheet" href="../global/css/fillInfo.css" type="text/css"></link>
    <link rel="stylesheet" href="../global/css/font-size-screen.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/lib/jquery/jquery-ui/css/jquery-ui.css" />
    <script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-ui/jquery-ui.js"></script>
  	<script type="text/javascript" src="../global/js/common.js"></script>
  	<script src="../global/lib/common/main.js?${random}"></script>	
	<script src="../global/lib/component/modal.js"></script>	
	<script src="<%=request.getContextPath()%>/resources/js/page/area1.js?${random}"></script>
  	<!-- init page scale-->
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
	<meta name="format-detection" content="telephone=no"/>
  </head>
   <style>
.txt0{font-size: 1.5em;}
	.txt1{font-size: 1.3em;}
	.txt2{font-size: 1.0em;}
	.txt3{font-size: 0.9em;}
	.txt4{font-size: 0.8em;}
	.txt5{font-size: 0.7em;}
	

	@media only screen and (max-width: 960px) {
		.txt0{font-size: 1.4em;}
		.txt1{font-size: 1.2em;}
		.txt2{font-size: 0.9em;}
		.txt3{font-size: 0.7em;}
		.txt4{font-size: 0.7em;}
		.txt5{font-size: 0.6em;}
	}

	@media only screen and (max-width: 640px) {
		.txt0{font-size: 1.2em;}
		.txt1{font-size:1.1em;}
		.txt2{font-size: 0.8em;}
		.txt3{font-size: 0.6em;}
		.txt4{font-size: 0.6em;}
		.txt5{font-size: 0.5em;}
	}

	@media only screen and (max-width: 480px) {
		.txt0{font-size: 1.2em;}
		.title1{font-size: 1.0em;}
		.txt2{font-size: 0.7em;}
		.txt3{font-size: 0.5em;}
		.txt4{font-size: 0.5em;}
		.txt5{font-size: 0.4em;}
	}
	.fillTable tbody tr td{line-height: 70px;}
	
  </style>
  
  


<link rel="stylesheet" type="text/css" href="../uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/style-font.css">

<style>
	.grace-form .pull-right input{
    font-family:"微软雅黑";
    color: rgb(102, 102, 102);
		    font-size: 26px;
	}
	
	.pull-left{
           font-size: 26px  !important;
		}
		.pull-right select{font-size:80%;}
	</style>
    <body class="gray">
 <div class="grace-head" > </div>
<h2 style="margin-top:60px; text-align:center; color:#c8a154; font-size:2em; font-weight:bold;padding-bottom: 50px;padding-top: 30px;">个人信息变更</h2>

<form class="bind-form" action="<%=path %>/action/changeMine" name="reForm" id="reForm" method="post">
	   	
<div  class="panel-collapse collapse in cardcontent" style="font-size: 1.4em;">
	<ul class="grace-form"> 
    	<li > 
   			<div class="pull-left" style="font-size: 26px;">地址: </div> 
    		<div class="pull-right">
				<select style="width: 35%;"  id="s_province" name="s_province" ></select> 
  				<select style="width: 55%; margin-left: 5%"  id="s_city" name="s_city"></select> 
			</div>
		</li>
		<li>
			<div class="pull-left"></div>
			<div class="pull-right">
	  			<input name="county" id="county" type="text" style="width:65%" value='<%=request.getAttribute("county")%>'/><span>区/县</span>
  			</div>
		</li>
		<li>
			<div class="pull-right">
	     		<%-- <input class="txt0" id="contactAddress" type="text" value="${myinfo.address}" /> --%>
	  				<input type="text" id="contactAddress"  value='<%=request.getAttribute("address1")%>' placeholder="请输入详细地址"/>
    		</div>
    		</li>
    		
    		<li > <div class="pull-left" style="font-size: 26px;">邮编: </div> 
    	<div class="pull-right">
    		<input class="txt0" id="postalcode" type="text" value="${myinfo.postcode}" onfocus="if(this.value=='请输入您的邮政编码'){this.value=''}"
	    				onblur="if(this.value=='请输入您的邮政编码'||this.value==''){this.value='请输入您的邮政编码'}"/>
    		</div></li>
       
    		
    		<li > <div class="pull-left" style="font-size: 26px;">手机: </div> 
    	<div class="pull-right">
    		<input class="txt0" id="contactNo" type="text" value="${myinfo.telphone}" onfocus="if(this.value=='请输入您的手机号码'){this.value=''}"
	    				onblur="if(this.value=='请输入您的手机号码'||this.value==''){this.value='请输入您的手机号码'}"/>
	    			</div></li>
    		<li > <div class="pull-left" style="font-size: 26px;">邮箱: </div> 
    	<div class="pull-right">
    		<input class="txt0" id="email" type="text" value="${myinfo.email}" onfocus="if(this.value=='请输入您的电子邮箱'){this.value=''}"
	    				onblur="if(this.value=='请输入您的电子邮箱'||this.value==''){this.value='请输入您的电子邮箱'}"/>
	    						</div></li>
  </ul>  
        
</div>
   		<input type="hidden" id="partyCode" value="${myinfo.coustomerid}">
   		<input type="hidden" id="name" value="${myinfo.name}">
   		<input type="hidden" id="microid" value="${myinfo.microid}">
   		<input type="hidden" id="idnumber" value="${myinfo.idnumber}">
   		<input type="hidden" id="idtype" value="${myinfo.idtype}">
   		<input type="hidden" id="flag" value="1"/>
   		<input type="hidden" id="taxDeclaraID" value="" />
   	</form>
            <div class="next-button" onclick="dosubmit()" style="margin-top: 50px;"><img src="../uinew/images/submit-button.jpg" width="100%"  alt=""/> </div>    

<div class="footer footer-fixed" > <img src="../uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>
<!-- crs录入 -->
<div id="crsInfo">
	<h4>依据国家税务总局、财政部等共同发布的《非居民金融账户涉税信息尽职调查管理办法》（2017年第14号）的要求，需要您配合填写并签署相应的税收居民身份声明文件。</h4><br/><br>
	<span style="width:45%;">税收居民身份：</span>
		<select id="taxType" class="taxType" style="width: 55%;">
		  	<option value="">--请选择--</option>
			<option value="1">仅为中国大陆税收居民</option>
		  	<option value="2">仅为非居民</option>
		  	<option value="3">既是中国大陆税收居民又是其他税收管辖区居民</option>
  		</select>
</div>

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
	
	</style>
 
    <!--弹出框 -->
    <div class="modal fade" data-rule="alert" id="modal_alert">
		<div class="modal-dialog alert">
			<div class="modal-header clearfix"><span data-title="modal">提示信息</span>
				<a type="button" class="close" data-dismiss="modal"></a></div>
			<div class="modal-content" data-content="modal"></div>
			<div class="modal-footer">
				<a class="modal-btn btn" data-dismiss="modal" data-btn="modal">确定</a>
			</div>
		</div>
	</div>
  </body>
  <script type="text/javascript">
  $("#crsInfo").dialog({
  autoOpen : false,   // 是否自动弹出窗口
  modal : true,    // 设置为模态对话框
  width : 410,   //弹出框宽度
  height : 340,   //弹出框高度
  position : "center",  //窗口显示的位置
  buttons:{
  '确定':function(){
	  //crs校验
	  var taxTpye = $("#taxType").val();
	  if(taxTpye==""){
		  alert("请选择您的税收居民身份");
		  return false;
	  }
		$.ajax({
			url :'<%=path %>/action/dealPartyTaxType',
			dataType : "json",
			type : "POST",
			async : false,
			data : {
				"partyCode" : "${myinfo.coustomerid}",
				"callBy":"WECHAT",
				"taxTpye":taxTpye,
				"operate" : "check"
			},
			success : function(data) {
				if(data.code == "0"){
					$("#taxDeclaraID").attr("value", data.taxDeclaraID);
					//请求保存个人信息
					dosubmit();
				}else{
					modal_alert({content:data.contenct,btn:'确定'});
					$(".btn").click(function (){
						window.location.href='<%=request.getContextPath()%>/page/policyService.jsp';
					});
				}
			}
		});
  },
  '取消':function(){
  $(this).dialog("close");
  }
  }
  });

	$(document).ready(function(){
	    var ua = navigator.userAgent.toLowerCase();
		/* if(ua.match(/MicroMessenger/i)!="micromessenger") {
	    	window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx618b6902989a293e&redirect_uri=http://testweixin.oldmutual-guodian.com/online/action/firstLogin?response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
	    } */
	    <c:if test="${Contenct!=null}">
	    modal_alert({content:'${Contenct}',btn:'确定'});
		</c:if>
		
		_init_area();
		var stateName = '<%=request.getAttribute("stateName")%>';
		if(stateName!= null && stateName!="" && stateName != 'null'){
			document.getElementById("s_province").value = stateName;
			var s_province=document.getElementById("s_province"); 
			var index=s_province.selectedIndex-1; //序号，取当前选中选项的序号 
			var str="0_"+index.toString();
			var s_city=document.getElementById("s_city"); 
			if(dsy.Exists(str)){
	       	    ar = dsy.Items[str];
	       		for(i=0;i<ar.length;i++){
					s_city.options.add(new Option(ar[i],ar[i])); 
	     	    }
     	    }
     	   	var cityName = '<%=request.getAttribute("cityName")%>';
			if(cityName!=null && cityName!="" & cityName!='null'){
				document.getElementById("s_city").value = cityName; 
			}
		}
	});	 
	
	
	//校验邮箱
	function checkEmail(){
		var email=document.getElementById("email").value;
		var l=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if(l.test(email)){
			return true;
		}else if(email==""||email.length==0||email=="请输入您的电子邮箱"){
			email = "";
			return true;
		}else{
			alert("电子邮箱格式有误，请重输");
			return false;
		}
	}
	
	//验证手机
	function checkMobile(){
		var phone = document.getElementById("contactNo").value;
		 var l = /^1\d{10}$/; 
		//var l = /^(13[0-9]|14(0-9)|15(0|1|2|3|5|6|7|8|9)|17[0-9])|18[0-9])\d{8}$/;
		if(l.test(phone)){
			return true;
		}else if(phone==""||phone.length==0||phone=="请输入您的手机号码"){
			alert("请输入您的手机号码");
			return false;
		}else{
			alert("手机号码格式有误，请重输");
			return false;
		}
	}
	
	
	//邮政编码的验证（开头可以为0，共6位）
	function checkPostal(){
		var phone=document.getElementById("postalcode").value;
		var l = /^[0-9]{6}$/;
		if(l.test(phone)){
			return true;
		}else if(phone==""||phone.length==0||phone=="请输入您的邮政编码"){
			alert("请输入您的邮政编码");
			return false;
		}else{
			alert("邮政编码格式有误，请重输");
			return false;
		}
	}
	
	
	function dosubmit(){
		var s_province = document.getElementById("s_province").value;  //省
		var s_city = document.getElementById("s_city").value;			//市
		var county = document.getElementById("county").value;	//区/县
		var contactAddress = document.getElementById("contactAddress").value;	//详细地址
		var reg = /[\u4e00-\u9fa5]|[a-zA-Z]/;
		if(s_province == "省/市" || s_city == "市/区"){
			alert("请选择您的地址");
			return false;
		}
		else if(county== null || county == ""){
			alert("请输入您的区/县地址");
			return false;
		}
		else if(contactAddress== null || contactAddress == ""){
			alert("请输入您的详细地址");
			return false;
		}
		var contactAddress1 = county+"区/县"+contactAddress;
		if(!reg.test(contactAddress1)){
			alert("请输入有效地址");
			return false;
		}
		else if(contactAddress.length > 30){
			alert("地址信息最多输入30个字符");
			return false;
		}
		else if(contactAddress.length < 6){
			alert("地址信息最少输入6个字符");
			return false;
		}
		else if(!checkPostal()){
			return false;
		}
		else if(!checkMobile()){
			return false;
		}
		else if(!checkEmail()){
			return false;
		}
		else{
		var contactAddress = $("#contactAddress").val();
		var contactNo = $("#contactNo").val();
		var postalcode = $("#postalcode").val();
		var email = $("#email").val();
		var name = $("#name").val();
		var microid = $("#microid").val();
		var idtype = $("#idtype").val();
		var idnumber = $("#idnumber").val();
		var taxDeclaraID = $("#taxDeclaraID").val();
  		$.ajax({
  			url :'<%=path %>/action/changeMine',
  			dataType : "json",
  			type : "POST",
  			async : false,
  			data : {
  				"partyCode" : "${myinfo.coustomerid}",
  				"state":s_province,
  				"city":s_city,
  				"contactAddress" : contactAddress1,
  				"contactNo" : contactNo,
  				"postalcode" : postalcode,
  				"name" : name,
  				"microid" : microid,
  				"idtype" : idtype,
  				"idnumber" : idnumber,
  				"email" : email,
  				"taxDeclaraID" : taxDeclaraID
  			},
  			success : function(data) {
  			    modal_alert({content:data.contenct,btn:'确定'}); 
  				if(data.code == "0"){
  					$(".btn").click(function (){
  					  window.location.href='<%=request.getContextPath()%>/page/policyService.jsp';
					});
  				}else if(data.code == "1121" || data.code == "1123"){
  					$("#crsInfo").dialog("open");
  				}
  			}
  		});
		} 
	 }
  </script>
</html>
