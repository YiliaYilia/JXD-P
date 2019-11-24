<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>自助理赔申请</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
 	<meta name="format-detection" content="telephone=no"/>
 	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/compensation/compensation.css" type="text/css"></link>
 	<script src="<%=request.getContextPath()%>/global/lib/jquery/jquery-2.1.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/style-font.css">
  </head>
  <body  class="gray">
  <div class="grace-head"> </div>
  <ul class="grace-top-menu2"> 
    <li class="menu-select"> 1.填写申请 </li>
    <li> 2.上传资料</li>
    <li> 3.完成</li>
  </ul>
  <a class="grace-info-tl"> 核对信息</a>
   	<!--核对投保信息区域-->
   	<div  class="panel-collapse collapse in cardcontent">
             <ul class="grace-form"> 
    <li > <div class="pull-left">保险单号：</div> <div class="pull-right text-right">${geClaimManagement.policyCode}</div></li>
    <li > <div class="pull-left" style="width:50%;">与被保险人关系：</div> <div class="pull-right text-right" style="width:40%;">${geClaimManagement.insrelationApp}</div></li>
    <li > <div class="pull-left" >申请人：</div> <div class="pull-right text-right">${geClaimManagement.name}</div></li>
    
    <li > <div class="pull-left">被保险人<br/>当前职业：</div> <div class="pull-right text-right"> ${geClaimManagement.occupation}</div></li>
   
     <li > <div class="pull-left" >索赔类别：</div> <div class="pull-right text-right" >${geClaimManagement.claimManagementType}</div></li>
    <li > <div class="pull-left">报案人<br/>联系电话：</div> <div class="pull-right text-right">${geClaimManagement.phone}</div></li>
    <li > <div class="pull-left">被保险人<br/>出险原因：</div> <div class="pull-right text-right">${geClaimManagement.startCause}</div></li>
    
    <li > <div class="pull-left">被保险人<br/>出险日期：</div> <div class="pull-right text-right" >${geClaimManagement.startDate}</div></li>
    
	    			<c:if test="${geClaimManagement.isInsure=='Y'}">
	    			<li > <div class="pull-left"  >公司名称： </div> <div class="pull-right text-right">${geClaimManagement.corporationName}</div></li>
	    			</tr>
	    			<li > <div class="pull-left"  >投保日期： </div> <div class="pull-right text-right">${geClaimManagement.insureDate}</div></li>
	    			</tr>
	    			<li > <div class="pull-left"  >购买险种名称及保额： </div> <div class="pull-right text-right">${geClaimManagement.insuranceInfo}</div></li>
	    			</tr>
	    			</c:if>
  </ul>  
            </div>
     <ul class="btn-last"> 
              <li onclick="window.history.back()">修改 </li>
              <li onclick="window.location.href ='${ctx}/msl/sales/infoComfirmClaimAction'">确认 </li>
            </ul>
<div class="footer footer-fixed "> <img src="${ctx}/uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>

  </body>
</html>
