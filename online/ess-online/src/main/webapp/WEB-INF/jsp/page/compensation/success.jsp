<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>自助理赔申请</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
 	<meta name="format-detection" content="telephone=no"/>
 	
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/style-font.css">
  </head>
  <body  class="gray">
  <div class="grace-head"> </div>
  
  	<!--阶段标识区域-->
  <ul class="grace-top-menu2"> 
    <li> 1.填写申请 </li>
    <li > 2.上传资料</li>
    <li class="menu-select"> 3.完成</li>
  </ul>
  
 <div class="normal-con"> 
   <div class="check-icon"><img src="${ctx}/uinew/images/yes.png"   width="100%" alt=""/> </div>
  <div  class="panel-collapse collapse in cardcontent info-con">
  		<!--报案成功提示区域-->
             <div class="text-con"> 
  	<c:if test="${updateImages=='updateImages'}">
  		资料补传成功
  	</c:if>
  	<c:if test="${updateImages== null}">
             您的理赔申请已受理。赔付金额<=3000元的案件，我们将在收到您齐全的索赔资料后3小时内结案（如遇节假日顺延），并在一个工作日内结案支付，具体到账日期请以银行实际操作为准，请您耐心等待！
  	</c:if>
  	         </div>
            </div>
            </div>
           <div class="next-button " onclick="javascript:window.location.href ='${ctx}/msl/sales/menuClaimAction'"><img src="${ctx}/uinew/images/button4.jpg" width="100%"  alt=""/> </div> 
<div class="footer footer-fixed "> <img src="${ctx}/uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>

  </body>
</html>
