<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/common/page/common.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>荣誉证书：尊敬的慈主，您的爱心伞让孩子们生活如此美丽缤纷！</title>
   	<%@ include file="../../common/meta.jsp"%>
   	<%@ include file="../../common/rels.jsp"%>
   	    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/charity/honor.css">
  </head>
  	<style> 
  	
  	</style>
  <body>
   	<div class="page" id="page" style="position: relative;">
   		<div class="head_box">
   			尊敬的${geOrder.applicantname}慈主，<br/>
   			您的“爱心伞”将让孩子们生活如此美丽缤纷：
   		</div>
   		<div class="clear"></div>
   		<div class="center_box">
   			
   			<table class="table">
   				<tr>
   					<td style="width:40;font-weight:bold;text-align:left; ">爱心“重疾伞”：</td>
   					<td style="text-align:right;">重大疾病保障金额：
	   				 <c:set var="sumamount" value="${gePolicy.sumamount}"/> 
	   					<span style="color:red;">${sumamount}</span>元
   					<%-- 	<c:choose>
			 	 			<c:when test="${(not empty  "${sumbasepremium}"}">
			 	 				<span style="color:red;">${sumamounts}</span>元
			 	 			</c:when>
			 	 			<c:otherwise>
			 	 				<span style="color:red;">0.00</span>&nbsp;元
			 	 			</c:otherwise>
						</c:choose> --%>
   					</td>
   				</tr>
   			<tr>
   					<td style="width:40;font-weight:bold;text-align:left; ">爱心“意外伞”：</td>
   					<td style="text-align:right;">意外伤害保障金：
   					<%-- 	<c:set var="sumbasepremium" value="${geOrder.orderamount}"/>
   						<c:choose>
		 	 			<c:when test="${(not empty sumbasepremium &&sumbasepremium!='0.00' ) ||(not empty stipend && stipend!='0.00')}">
		 	 				<span style="color:red;">10000.00</span>&nbsp;元
		 	 			</c:when>
		 	 			<c:otherwise>
		 	 			<span style="color:red;">0.00</span>&nbsp;元
		 	 			</c:otherwise>
						</c:choose> --%>
   						<c:if test="${not empty sumbasepremium||not empty stipend}"><span style="color:red;">10000.00</span></c:if>元
   					<%-- 	<c:if test="${empty sumbasepremium&&empty stipend}"><span style="color:red;"> 0.0</span></c:if>元  --%>
   					</td>
   					
   					
   				</tr>
   				<tr>
   					<td style="width:40;font-weight:bold ;text-align:left;">&nbsp;</td>
   					<td style="text-align:right;">意外伤害医疗保障金：
   						<%-- <c:set var="sumbasepremium" value="${geOrder.orderamount}"/>
   						<c:choose>
		 	 				<c:when test="${(not empty sumbasepremium  &&sumbasepremium!='0.00' ) ||(not empty stipend && stipend!='0.00')}">
		 	 					<span style="color:red;">600.00</span>&nbsp;元
		 	 				</c:when>
		 	 				<c:otherwise>
		 	 					<span style="color:red;">0.00</span>&nbsp;元
		 	 				</c:otherwise>
						</c:choose> --%>
   						<c:if test="${not empty sumbasepremium||not empty stipend}"><span style="color:red;">&nbsp;600.00</span></c:if>元
   						<%-- <c:if test="${empty sumbasepremium&&empty stipend}"><span style="color:red;"> </span></c:if>元 --%>
   					</td>
   					
   				</tr>
   				<tr>
   					<td style="width:40;font-weight:bold ;text-align:left;">爱心“助学伞”：</td>
   					<c:set var="stipend" value="${geOrder.stipend}"/>
				  	 
   					<td style="text-align:right;">捐赠金额：
   						<%-- <c:choose>
		 	 				<c:when test="${not empty stipend}">
		 	 					<span style="color:red;">${stipend}</span>&nbsp;元
		 	 				</c:when>
		 	 				<c:otherwise>
		 	 					<span style="color:red;">0.00</span>&nbsp;元
		 	 				</c:otherwise>
						</c:choose> --%>
   					<span style="color:red;">${stipend}</span>元</td> 
   					
   				</tr>
   				<tr>
   					<td style="width:40;font-weight:bold;text-align:left; ">爱心“书库伞”：</td>
   						<c:set var="bookmoney" value="${geOrder.bookmoney}"/>
				  	 <td style="text-align:right;">捐赠金额：
				  	 	<span style="color:red;">&nbsp;${bookmoney}</span>元
				  	 	<%-- <c:choose>
		 	 				<c:when test="${not empty  bookmoney}">
		 	 					<span style="color:red;">${bookmoney}</span>&nbsp;元
		 	 				</c:when>
		 	 				<c:otherwise>
		 	 					<span style="color:red;">0.00</span>&nbsp;元
		 	 				</c:otherwise>
						</c:choose> --%>
				  	 </td>
				  	 	
   					
   				</tr>
   				<tr>
   					<%-- <c:set var="sumMoney" value="${geOrder.sumMoney}"/> --%>
   					<td colspan="2" style="font-weight: bold;text-align:center;">善款总计：<span style="color:red;">${num}</span>元</td>
   				</tr>
   			</table>
   		
   		</div>
   		<%-- <div class="left_box">
   			<c:set var="sumbasepremium" value="${geOrder.orderamount}"/>
		  	 	<c:if test="${not empty sumbasepremium}">
		  	 		保费：${geOrder.orderamount}元</br> 
		  	 	</c:if>
		  	 	<c:set var="stipend" value="${geOrder.stipend}"/>
		  	 	<c:if test="${not empty stipend}">
		  	 		助学金：${stipend}元 </br>
		  	 	</c:if>
		  	 	<c:set var="bookmoney" value="${geOrder.bookmoney}"/>
		  	 	<c:if test="${not empty bookmoney}">
		  	 		爱心书库：${bookmoney}元 </br>
		  	 	</c:if>
    	总金额：${num}元 </br>
    	订单号：${geOrder.ordercode}</br>
   		</div> --%>
   		<!-- <div class="bottom_box">
   			让贫困地区的孩子们无忧无虑的生活和学习原来如此简单，把它分享出去，邀请您的同事一起行动起来吧！
   		</div> -->
   	</div>
   	
  </body>
<script type="text/javascript">
	 var pageHeight =  document.documentElement.clientHeight;
	document.getElementById("page").style.height=pageHeight+'px';
</script>

</html>
