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
	$(function () {
		var tag = $('#tag').val();
		if(tag == 'tag'){
			alert("理赔报案已成功，返回自助理赔查询进行修改！");
			window.location.href ="${ctx}/msl/sales/menuClaimAction";
		}
	});
 	function topayway(radom){
 		var claimManagementNo = $('#claimManagementNo').val();
 		if(radom == '0'){
 			var item = $(":radio:checked"); 
 			var len=item.length; 
 			if(len>0){
 				var rad = item.val();
 				//微信提交
 				if(rad == '02'){
 					window.location.href ='${ctx}/msl/sales/paywayClaimAction?commitType='+rad+'&claimManagementNo='+claimManagementNo;
 				} else {
 					$.ajax({
 						type:"POST",
 						url:"${ctx}/msl/sales/paywayClaimAction",
 						data:{
 							"commitType":rad,
 							"claimManagementNo":claimManagementNo
 						},
 						dataType:"json",
 						success:function(data){
 							if(rad == '01'){
 								alert("已选择柜面提交，请前往柜面继续办理！")
 							}else if(rad == '03'){
 								alert("已选择邮箱提交，请将资料发到指定邮箱！")
 							}
 							window.location.href ="${ctx}/msl/sales/menuClaimAction";
 						}
 					});
 				}
 			} else {
 				alert("请选择提交方式");
 			}
 		}else if(radom == '1'){
 			window.location.href ="${ctx}/msl/sales/menuClaimAction";
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
  
 <div class="normal-con"> 
 	
   		<c:if test="${claimManagementType=='1'||claimManagementType=='2'}">
   <div class="check-icon"><img src="${ctx}/uinew/images/yes.png"   width="100%" alt=""/> </div>
   <p> 您已完成信息填写部分<br/>报案已成功</p>
   
	 		<form action="">
		 			<input type="hidden" id="claimManagementNo" value="${claimManagementNo }" />
		 			<input type="hidden" id="tag" value="${tag }" />
		 			
   <ul class="choice"> 
     <li> <div class="radio"><label><input type="radio" name="way" value="02" checked /> 微信提交</label></div></li>
     <li> <div class="radio"><label><input type="radio" name="way" value="01" <c:if test="${commitType == '01' }">checked="checked"</c:if> /> 柜面提交 ： <a href="http://www.oldmutual-guodian.com/public/contact/">查看联系方式</a></label></div></li>
     <li> <div class="radio"><label><input type="radio" name="way" value="03" <c:if test="${commitType == '03' }">checked="checked"</c:if>/> 邮箱提交 ： Claim@oldmutual-guodian.com</label></div></li>

   </ul>
	 		</form>
 </div>
 <div class="next-button " onclick="topayway(0);"><img src="${ctx}/uinew/images/button3.jpg" width="100%"  alt=""/> </div>    
 
 		</c:if>
 		<c:if test="${claimManagementType>'2'&&claimManagementType<'6'}">
 
   <div class="check-icon"><img src="${ctx}/uinew/images/yes.png"   width="100%" alt=""/> </div>
   <p> 报案成功，请提交书面申请至我公司<br />如有疑问，请您拨打我们的客户服务专线400-810-9339。</p>
 <div class="next-button " onclick="topayway(1);"><img src="${ctx}/uinew/images/button4.jpg" width="100%"  alt=""/> </div>  
  
	   	</c:if>
<div class="footer footer-fixed "> <img src="${ctx}/uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>
  </body>
  <script src="<%=request.getContextPath()%>/resources/js/compensation/finish.js"></script>
</html>
