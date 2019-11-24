<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML>
<html>
  <head>
  <title>确认捐赠-国电资本控股</title>
	<%@ include file="../../common/meta.jsp"%>
	<%@ include file="../../common/rels.jsp"%>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/charity/actlists.css">
	<link href="<%=request.getContextPath()%>/global/global/css/common.css?${random}" rel="stylesheet"/>
	<link href="<%=request.getContextPath()%>/resources/css/charity/sale.css?${random}" rel="stylesheet"/> 
  </head>
  </head>
  
  <body onload="show();">
  	<div id="head">信息确认</div>
  	
  	<div class="policy_holder" style="margin-top:20px;">捐&nbsp;赠&nbsp;人&nbsp;信&nbsp;息</div>
  	<div class="center_fill">
  	<table class="msg">
  		<tr>
  			<td  style="text-align:center;width:40%">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
  			<td  style="float:left;width:100%">&nbsp;${name1}</td>
  		</tr>
  		<tr>
  			<td  style="text-align:center;">证件类型：</td>
  			<td  style="float:left;width:100%">&nbsp;${identifytype1}</td>
  		</tr>
  		<tr>
  			<td  style="text-align:center;">证件号码：</td>
  			<td  style="float:left;width:100%">&nbsp;${applicantInsured.identifynumber}</td>
  		</tr>
  		
  		<tr>
  			<td  style="text-align:center;">出生日期：</td>
  			<td  style="float:left;width:100%">&nbsp;${birthday1}</td>
  		</tr><tr>
  			<td  style="text-align:center;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
  			<td  style="float:left;width:100%">
				&nbsp;${sex1}
			</td>
  		</tr>
  		<tr>
  			<td  style="text-align:center;">手机号码：</td>
  			<td  style="float:left;width:100%">&nbsp;${applicantInsured.mobile}</td>
  		</tr>
  		<tr>
  			<td  style="text-align:center;">电子邮箱：</td>
  			<td  style="float:left;width:100%">&nbsp;${applicantInsured.email}</td>
  		</tr>

  		<tr>
  			<td  style="text-align:center;">通讯地址：</td>
  			<td  style="float:left;width:100%">
	  		&nbsp;${applicantInsured.address}
  			</td>
  		</tr>
  	</table>
  	</div>
  	<div id="childFlag">
  	<div class="policy_holder">被&nbsp;捐&nbsp;赠&nbsp;人&nbsp;信&nbsp;息</div>
  	<div class="center_fill">
  	<table class="msg">
  		<tr>
  			<td   style="text-align:center;width:40%">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
  			<td   style="float:left;width:100%">&nbsp;${name2}</td>
  		</tr>
  		<tr>
  			<td   style="text-align:center;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
  			<td   style="float:left;width:100%">&nbsp;${sex2}</td>
  		</tr>
  		<tr>
  			<td   style="text-align:center;">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
  			<td   style="float:left;width:100%">&nbsp;${age2}岁</td>
  		</tr>
  	</table>
  	</div>
  	</div>
  	
  	<input type="hidden" id="donationFlag" name="donationFlag" value="${donationFlag}" /> 
  	<div class="policy_holder" id="medicalFlag">医&nbsp;疗&nbsp;救&nbsp;助&nbsp;捐&nbsp;赠&nbsp;信&nbsp;息</div>
  	<div id="isCharity" style="display: none"> 
  	<div class="center_fill">
  	<table class="msg">
  		<tr>
  			<td   style="text-align:left;width:40%">少儿重疾保障</td>
  			<td   style="float:left;width:100%">&nbsp;</td>
  		</tr>
  		<tr>
  			<td   style="text-align:center;width:40%">保障项目：</td>
  			<td   style="float:left;width:100%">&nbsp;40种重大疾病</td>
  		</tr>
  		<tr>
  			<td   style="text-align:center;width:40%">保障额度：</td>
  			<td   style="float:left;width:100%">&nbsp;${sumamounts}元</td>
  		</tr>
  		<tr>
  			<td   style="text-align:center;">应付金额：</td>
  			<td   style="float:left;width:100%">&nbsp;${sumbasepremium}元</td>
  		</tr>
  		</table>
  		</div>
  		</div>
  		<div id="giveFlag">
  		<div class="center_fill">
  		<table class="msg">
  		<tr>
  			<td   style="text-align:left;width:40%">意外伤害保障</td>
  			<td   style="float:left;width:100%">&nbsp;</td>
  		</tr>
  		<tr>
  			<td   style="text-align:center;width:40%">保障额度：</td>
  			<td   style="float:left;width:100%">&nbsp;10000.00元</td>
  		</tr>
  		<tr>
  			<td   style="text-align:left;width:40%">意外伤害医疗保障</td>
  			<td   style="float:left;width:100%">&nbsp;</td>
  		</tr>
  		<tr>
  			<td   style="text-align:center;width:40%">保障额度：</td>
  			<td   style="float:left;width:100%">&nbsp;600.00元</td>
  		</tr>
  	</table>
  	</div>
  	<div><p style="color:#DF262B;text-align:center;width:80%%;margin:20px auto;font-size:0.8em;line-height:1.6em;">注：此次捐赠项目中的医疗救助保障有效期均为一年。</p></div>
  	</div>
  	

  	<div id="isHelp" style="display: none">
  	<input type="hidden" id="helpStudyFlag" name="helpStudyFlag" value="${helpStudyFlag}" />  
  	<div class="policy_holder"> 助&nbsp;学&nbsp;捐&nbsp;赠&nbsp;信&nbsp;息</div>
  	<div class="center_fill">
  	<table class="msg">
  		<tr>
  			<td   style="text-align:left;width:50%;margin-left:30%;">1.捐赠助学金：</td>
  			<td   style="float:left;width:100%">&nbsp;${stipend}元</td>
  		</tr>
  		<tr>
  			<td   style="text-align:left;margin-left:30%;">2.捐赠爱心书库：</td>
  			<td   style="float:left;width:100%">&nbsp;${bookmoney}元</td>
  		</tr>
  	</table>
  	</div>
  	</div>
  	</div>
  	<div><p style="color:#DF262B;width:80%;margin:20px auto;text-align:center;font-size:1.2em;line-height:2.4em;">应付总金额：￥${sumMoney}元</p></div>
	<div class="bottom">
		<div class="left_bottom">
			<div class="left_btn" onclick="cancel();">取消</div>
		</div>
		<div class="right_bottom">
			<div class="left_btn" onclick="underwriting();">确认支付</div>
		</div>
	</div>
  	<jsp:include page="../../common/charityfoot.jsp"></jsp:include>
  </body>
	<script type="text/javascript">
	
	//取消
	function cancel(){
		 window.location.href =contentRootPath+'/msl/sales/charityPolicyHome';
	}
	
	  //核保
	  function underwriting(){
			  $.ajax({
				   type:"POST",
				   url:contentRootPath+"/msl/sales/charityPolicyInsureSubmit",
				   data:{
				   },
				   dataType:"json",
				   success:function(data){
					   if(data.flag=="0"){
						   alert("订单保存成功，测试环境跳过支付");
						   //window.location.href =contentRootPath+'/msl/sales/pay';
						   window.location.href =contentRootPath+'/msl/sales/toTestCharitySuccess?source=tuanxian';
					   }else if(data.flag=="1"){
						   alert(data.content);
					   }
					}
				});  
	  }
		function show(){
			var  donationFlag = $("#donationFlag").val();
			var  helpStudyFlag = $("#helpStudyFlag").val();
			if(donationFlag=='1'){
				$('#isCharity').show();
			}
			if(helpStudyFlag=='1'){
				$('#isHelp').show();
			}
			if(donationFlag=='0' && '${stipend}'=='0.00'){
				 document.getElementById("giveFlag").style.display="none";
				 document.getElementById("medicalFlag").style.display="none";
			}
		}
		
	</script>
</html>
