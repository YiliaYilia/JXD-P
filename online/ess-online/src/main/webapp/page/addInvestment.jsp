<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>万能险追加投资</title>
	
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
<script>
		var subFlag = true;
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
		
		
		function check(amount){
			var policyCode = $("#policyCode").val();//保险单号
			var reCode = /^[0-9]*[1-9][0-9]*$/;		//正整数
			
			if(amount != ''){
				if (reCode.test(amount)){
					if(amount<1000){
						alert("追加投资金额不得少于1000元");
						return false;
					}
				} else {
					alert("追加投资金额必须是整数！");
					return false;
				}
			} else {
				alert("请输入追加金额！");
				return false;
			}
			return true;
		}
		
		function save(){
			var policyNo = $('#policyNo').val();
			var amount = $("#amount").val();		//金额
			var bankCardID = $("#bankCardID").val();
			var applicantName = $("#applicantName").val();
			var accountBank = $("#AccountBank").val();
 			if(!check(amount)){
				return;
			}
 			else if(subFlag ==false){
 				alert("正在处理，请勿重复提交");
 				return;
 			}else{
				$.ajax({
					type:"POST",
					url:"${ctx}/action/isExistByPolicyNo",
					data:{
						"policyNo":policyNo,
						"amount":amount,
						"bankCardID":bankCardID,
						"geInvestment.policyNo":policyNo,
						"geInvestment.applicantName":applicantName,
						"geInvestment.accountBank":accountBank,
						"geInvestment.bankCardId":bankCardID,
						"geInvestment.amount":amount,
						
						
					},
					async: false,
					dataType:"json",
					success:function(data){
						 //当天已追加
						 if(data.flag == 'true'){
							 alert(data.contenct);
						 } else {
							 if(data.code == '0'){
								  alert(data.contenct);
								 window.location.href="${ctx}/page/policyService.jsp";
							 } else{
								 alert(data.contenct);
							 }
						 }
					}
				});
 			}
		}
		
</script>
  	<meta name="format-detection" content="telephone=no"/>


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
	</style>
</head>

    <body  class="gray">
  <div class="grace-head"> </div>
<h2 style="margin-top:60px; text-align:center; color:#c8a154; font-size:2em; font-weight:bold;">追加投资</h2>
<form action="${ctx}/action/saveInvestment" method="post" name="investmentForm" id="investmentForm" enctype="multipart/form-data">
			<div  class="panel-collapse collapse in cardcontent" style="    font-size: 1.4em;">
             <ul class="grace-form"> 
    <li > <div class="pull-left">保单号码: </div> 
    	<div class="pull-right">
    		${policyNo}
							<input type=hidden id="policyNo" name="geInvestment.policyNo" value="${policyNo}"/>
    		</div></li>
    		 
    <li > <div class="pull-left">投保人姓名: </div> 
    	<div class="pull-right">
							${applicantName}
							<input type=hidden id="applicantName" name="geInvestment.applicantName" value="${applicantName}"/>
    		</div></li>
    <li > <div class="pull-left">银行名称: </div> 
    	<div class="pull-right">
							${accountBank}
							<input type=hidden id="AccountBank" name="geInvestment.accountBank" value="${accountBank}"/>
    		</div></li>
    <li > <div class="pull-left">银行卡号: </div> 
    	<div class="pull-right">
							${showBankCardId}
							<input type=hidden id="bankCardID" name="geInvestment.bankCardId" value="${bankCardId}"/>
    		</div></li>
    <li > <div class="pull-left">追加金额: </div> 
    	<div class="pull-right">
    		<input type=text id="amount" maxlength="8" style="font-size:1.0em;width:44%;height:34px;" placeholder="请输入追加金额" name="geInvestment.amount" />&nbsp;元

    		</div></li>
		<li>
			<p style="font-size: 0.8em;margin-bottom:10px;margin-top:0px;text-align:left;line-height:2.0em;">
								<img src="<%=request.getContextPath()%>/resources/image/wjx/star.png"/>
								投保人声明及授权：我同意授权瑞泰人寿根据保险合同约定的保费金额和交费方式委托银行从上述账户划款。如果我提供的账户是凭印鉴或密码支取，则我将同意并授权委托银行在划转保险费时免于核对该账户中的印鉴或密码。
							</p>
							<p style="color: red;font-size: 0.8em;margin-bottom:0px;text-align:left;">提示：</p>
							<p style="color: red;font-size: 0.8em;margin-bottom:10px;margin-top:0px;text-align:left;line-height:2.0em;">●您在每个工作日13:30之前成功提出的追加保险费申请，我们将在当日处理；超过13:30后成功提出的申请将在下一个工作日处理。</p>
							<p style="color: red;font-size: 0.8em;margin-bottom:10px;margin-top:0px;text-align:left;line-height:2.0em;">●为了确保您的权益，我们收到您提交的追加保险费申请后，可能将会有客服人员进行电话回访，请您注意接听。</p>
						
			</li>	
  </ul>  
        
        <ul class="btn-last" style="margin: 10px auto 150px;"> 
              <li style="margin-top: 5px;line-height: 70px;font-size: 1.4em;" href="#"  onclick="save()">
						确认
						</li>
						<li style="margin-top: 5px;line-height: 70px;font-size: 1.4em;" href="#"  onclick="javascript:window.location.href='${ctx}/action/getPolicyBasic?policyNo=${policyNo }'">
						取消
						</li>
              	</ul>
              	
            </div>

			</form>
<div class="footer footer-fixed" > <img src="../uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>


</body>
<%@ include file="/page/result.jsp"%>
</html>
