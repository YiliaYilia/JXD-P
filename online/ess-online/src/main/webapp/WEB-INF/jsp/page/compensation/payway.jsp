<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
	<head>
	    <title>自助理赔申请</title>
	    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
	 	<meta name="format-detection" content="telephone=no"/>
	 	<!-- 暂时  -->
	 	<script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
	 	<script type="text/javascript">
			function toupload(){
				var item = $(":radio:checked"); 
				var len=item.length; 
				if(len>0){
					var rad = item.val();
					$.ajax({
						type:"POST",
						url:"${ctx}/msl/sales/finishClaimAction",
						data:{
							"payType":rad
						},
						dataType:"json",
						success:function(data){
							var ct = data.updateContent;
							if("updateContent" == ct){
								window.location.href ='${ctx}/msl/sales/menuClaimAction';
							}else{
								window.location.href ='${ctx}/page/upload.jsp?claimManagementNo='+data.claimManagementNo;
							}
						}
					});
				} else {
					alert("请选择提支付方式");
				}
			}
	 	</script>
		<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/jquery.bxslider.css">
		<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/safe-new.css">
		<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/style-font.css">
	</head>
	<body  class="gray" onload="backshow()">
  		<div class="grace-head"> </div>
  		<!--阶段标识区域-->
  		<ul class="grace-top-menu2"> 
    		<li class="menu-select"> 1.填写申请 </li>
    		<li> 2.上传资料</li>
    		<li> 3.完成</li>
  		</ul>
   		<!--报案成功提示区域-->
   		<!-- 索赔类别选择住院津贴或医疗保险的客户 -->
  		<div  class="panel-collapse collapse in cardcontent info-con">
  			<div class="text-con">
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您已完成信息填写部分，还需要将申请资料拍照传给我们，请根据您的索赔类别提供以下资料的照片：<br/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;投保人及被保险人身份证件正反面、被保险人活期储蓄卡/折、医疗费用专用收据、住院病历及出院小结、医疗费用明细清单、意外事故证明（如因意外引起；需由居住地居委会、工作单位、交管部门或公安机关出具）、活期储蓄银行卡/折、申请医疗报销的，如已在其它机构报销部分费用，还需提供分割单。<br/><br/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;申请医疗报销的客户，请您及时将医疗费用专用收据原件及分割单原件（如已在其它机构报销部分费用）递交给我公司，以便我们能尽快将理赔款支付给您。<br/><br/>
				理赔金支付方式：
            </div>
            <ul class="choice" > 
            	<li><div class="radio"><label><input type="radio" name="payType" value="01" checked="checked"/> 银行转账，请提供被保险人的活期储蓄卡/折的照片，不能使用信用卡。</label></div></li>
         	</ul>
		</div>
		<div class="next-button " onclick="toupload()"><img src="${ctx}/uinew/images/button3.jpg" width="100%"  alt=""/></div> 
		<div class=" footer footer-fixed "> <img src="${ctx}/uinew/images/bottom-line.jpg" alt="" width="100%"/></div>
	</body>
	<script src="<%=request.getContextPath()%>/resources/js/compensation/payway.js"></script>
</html>