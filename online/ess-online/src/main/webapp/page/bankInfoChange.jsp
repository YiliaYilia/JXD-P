<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>银行账户变更</title>
	
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/wjx/area.js"></script>
  	<meta name="format-detection" content="telephone=no"/>
<%
 	String policyNum=request.getParameter("policyNum")==null?"":request.getParameter("policyNum");
 	String polName=new String(request.getParameter("polName").getBytes("ISO8859-1"),"UTF-8");
 	String renewalIndicator=request.getParameter("renewalIndicator");
 	String accountBank=request.getParameter("accountBank")==null?"":new String(request.getParameter("accountBank").getBytes("ISO8859-1"),"UTF-8");
 	String bankCardID=request.getParameter("bankCardID").equals("888888")?"":request.getParameter("bankCardID");
 	if(!bankCardID.equals("")&&bankCardID.length()!=0){
 		bankCardID=bankCardID.substring(0,bankCardID.length()-8)+"****"+bankCardID.substring(bankCardID.length()-4,bankCardID.length());
 	}
%> 
<link href="../global/css/common/main.min.css?${random}" rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="../uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/style-font.css">
<style>
	.grace-form .pull-right {
	   text-align: right;
	}
		.grace-form .pull-right input{
	   font-family:"微软雅黑";
	   color: rgb(102, 102, 102);
	   font-size:22.4px;
	}
	select {
		border: none;
		font-size: 22.4px;
		width:20%;
		text-align: right;
	}
	input {
	text-align: right;
}
</style>
</head>
<script type="text/javascript">
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
<body  class="gray" onload="init2();">
	<div class="grace-head"> </div>
	<h2 style="margin-top:60px; text-align:center; color:#c8a154; font-size:2em; font-weight:bold;">银行账户变更</h2>
		<form action="<%=request.getContextPath()%>/action/changeBankNum" method="post" name="creator" id="submit" enctype="multipart/form-data">
			<div  class="panel-collapse collapse in cardcontent" style="    font-size: 1.4em;">
	              <ul class="grace-form"> 
		            <!--  <%if(renewalIndicator.equals("Y")){ %> -->
					    <li> 
					    	<div class="pull-left">保单号码: </div> 
					    	<div class="pull-right"><%=policyNum%></div>
					    	<input type="hidden" name="changepolicy.policyno" value="<%=policyNum%>">
					    </li>
					    		 
					    <li> 
					    	<div class="pull-left">投保人姓名: </div> 
					    	<div class="pull-right"><%=polName%></div>
					    	<input type="hidden" name="changepolicy.applicantname" value="<%=polName%>">
					    </li>
					    <li> 
					    	<div class="pull-left">银行名称: </div> 
					    	<div class="pull-right"><%=accountBank%></div>
					    	<input type="hidden" name="changepolicy.bank" value="<%=accountBank%>">
					    </li>
					     <li> 
					    	<div class="pull-left">银行卡号: </div> 
					    	<div class="pull-right"><%=bankCardID%>	</div>
					    	<input type="hidden" name="changepolicy.bankaccountnumber" value="<%=bankCardID%>">
					    </li>
					    <li> 
					    	<div class="pull-left">新银行名称: </div> 
					    	<div class="pull-right">
						    	<select style="width:40%;text-align:right; " name="changepolicy.bankcode" id="bankC">
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
									<option value="130302">中信银行</option>
									<option value="100403">邮政储蓄银行</option>
									<option value="100301">交通银行</option>
						    	</select>
					    	</div>
					    </li>
					     <li> 
					    	<div class="pull-left">新银行卡号: </div> 
					    	<div class="pull-right"><input type="text" name="changepolicy.bankaccountnumberC" id="bankaccountnumberC" placeholder="请填写投保人银行账号(暂不支持信用卡)" maxlength="20">	</div>
					    </li>
					    <li> 
					    	<div class="pull-left">开户行省: </div>  
					    	<div class="pull-right">
					    		<select style="width:40%;text-align:right; " name="changepolicy.bankProvince" id="payBankProvinceAddress" onchange="BankBranch();" >
						    	</select>
					    	</div>
					    </li>
					    <li> 
					    	<div class="pull-left">开户行市: </div> 
					    	<div class="pull-right">
					    		<select style="width:40%;text-align:right; " name="changepolicy.bankCity" id="paybankCityAddress" onchange="BankBranch();">
						    	</select>
					    	</div>
					    </li>
					     <!-- <%} %> -->
				     </ul> 
				    
						 <%if(renewalIndicator.equals("N")){ %>
					     <ul class="grace-form"> 
					     	    <li> 
					    	<div class="pull-left">保单号码: </div> 
					    	<div class="pull-right"><%=policyNum%></div>
					    	<input type="hidden" name="changepolicy.policyno" value="<%=policyNum%>">
					    </li>
					    		 
					    <li> 
					    	<div class="pull-left">投保人姓名: </div> 
					    	<div class="pull-right"><%=polName%></div>
					    	<input type="hidden" name="changepolicy.applicantname" value="<%=polName%>">
					    </li>
						    <!--<li>
						    	 <div class="pull-left">续保选择:</div>
						    	 <div style="float: right;">
						    	<input type="checkbox" id="renewalflag" style="width: 25px;height: 25px;all" checked="checked" onclick="showorhide();"/>
						    	申请续保至被保险人25岁
						    	</div>
						    </li>-->
						    </ul>
						   <ul class="grace-form" id="showorhide"> 
						    <li> 
						    	<div class="pull-left">银行名称: </div> 
						    	<div class="pull-right">
							    	<select style="width:40%;text-align:right; " name="changepolicy.bankcode" id="bankC">
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
										<option value="130302">中信银行</option>
										<option value="100403">邮政储蓄银行</option>
										<option value="100301">交通银行</option>
							    	</select>
						    	</div>
						    </li>
						     <li> 
						    	<div class="pull-left">银行卡号: </div> 
						    	<div class="pull-right"><input type="text" name="changepolicy.bankaccountnumberC" id="bankaccountnumberC" placeholder="请填写投保人银行账号(暂不支持信用卡)" maxlength="20">	</div>
						    </li>
						    <li> 
						    	<div class="pull-left">开户行省: </div>  
						    	<div class="pull-right">
						    		<select style="width:40%;text-align:right; " name="changepolicy.bankProvince" id="payBankProvinceAddress" onchange="BankBranch();" >
							    	</select>
						    	</div>
						    </li>
						    <li> 
						    	<div class="pull-left">开户行市: </div> 
						    	<div class="pull-right">
						    		<select style="width:40%;text-align:right; " name="changepolicy.bankCity" id="paybankCityAddress" onchange="BankBranch();">
							    	</select>
						    	</div>
						    </li>
						     <li class="grace-tips" style="font-size:1em;"><span style="font-size:1em;">提示 :</span><br/><br/>
					如选择续保，将每年从上述续保缴费账户自动划扣保费。 <br />
					</li>
					    </ul>
					   
				    	<%} %>
				    <ul class="grace-form" id="shengming"> 	
				   
					<li>
							<p style="font-size: 0.8em;margin-bottom:10px;margin-top:0px;text-align:left;line-height:2.0em;">
								投保人声明及授权：我同意授权瑞泰人寿根据保险合同约定的保费金额和交费方式委托银行从上述账户划款。如果我提供的账户是凭印鉴或密码支取，则我将同意并授权委托银行在划转保险费时免于核对该账户中的印鉴或密码。
							</p>
										
					</li>	
				  </ul>  
	        
		      	  <ul class="btn-last" style="margin: 10px auto 150px;"> 
				        <li style="margin-top: 5px;line-height: 70px;font-size: 1.4em;"   onclick="save()">确认</li>
						<li style="margin-top: 5px;line-height: 70px;font-size: 1.4em;" href="#"  onclick="javascript:window.location.href='${ctx}/action/getPolicyBasic?policyNo=<%=policyNum%>'">取消</li>
	              </ul>
            </div>
            
		</form>
	<div class="footer footer-fixed" > <img src="../uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>
<script type="text/javascript">
	
	function save(){
		//var flag=$("#renewalflag").is(':checked');
		var reg = /^[0-9]{8,20}$/;//校验银行卡号为8到20之间的数字
		bankaccountnumberC=$("#bankaccountnumberC").val()==null?"":$("#bankaccountnumberC").val();
		payBankProvinceAddress=$("#payBankProvinceAddress").val()=="省/市"?"":$("#payBankProvinceAddress").val();
		paybankCityAddress=$("#paybankCityAddress").val()=="市/区"?"":$("#paybankCityAddress").val();
		var renewalIndicator="<%=renewalIndicator%>";
	    if(bankaccountnumberC==""||bankaccountnumberC.length==0){
			alert("请填写银行卡号！");
			return;
		}
		else if(!reg.test(bankaccountnumberC.replace(/\s*/g,''))){
			alert("请填写正确的银行卡号！");
			return;
		}
		if(payBankProvinceAddress==""||payBankProvinceAddress.length==0||paybankCityAddress==""||paybankCityAddress.length==0){
			alert("请选择开户行省市！");
			return;
		}
		
		$("#submit").submit();
	}
	function showorhide(){
		var flag=$("#renewalflag").is(':checked');
		if(flag==false){
			$("#showorhide").hide();
			$("#shengming").hide();
		}else{
			$("#showorhide").show();
			$("#shengming").show();
		}
	}
</script>
</body>
<%@ include file="/page/result.jsp"%>
</html>
