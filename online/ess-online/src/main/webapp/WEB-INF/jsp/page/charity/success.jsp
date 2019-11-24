<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>支付成功-国电资本控股</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<%@ include file="../../common/meta.jsp"%>
	<%@ include file="../../common/rels.jsp"%>
	<link href="<%=request.getContextPath()%>/global/global/css/common.css?${random}" rel="stylesheet"/>
	<link href="<%=request.getContextPath()%>/global/global/css/sale.css?${random}" rel="stylesheet"/>

  </head>
  
  <body onload="show();">
  
  	<div id="isCharity" style="display: none">
  	<input type="hidden" id="donationFlag" name="donationFlag" value="${donationFlag}" /> 
    	<p class="paid">您捐赠的</p>
    	<p class="paid">${productname}</p>
		<p class="premium">保费： ${orderamount}元</p>
		
	</div>
	<div id="isHelp" style="display: none">
  	<input type="hidden" id="helpStudyFlag" name="helpStudyFlag" value="${helpStudyFlag}" />
  		<p class="paid" id="help_head" style="display:"";">爱心伞慈善捐赠</p>
  	 	<c:set var="stipend" value="${stipend}"/>
  	 	<c:if test="${not empty stipend}">
  	 		<p class="paid">您捐赠的助学金：${stipend}元</p>
  	 	</c:if>
  	 	<c:set var="bookmoney" value="${bookmoney}"/>
  	 	<c:if test="${not empty bookmoney}">
  	 		<p class="paid">您捐赠的爱心书库：${bookmoney}元</p>
  	 	</c:if>
  	</div> 
  		<p class="paid">总金额：￥${sumMoney}元</p>
		<p  class="success_time">已于${paydate}支付成功</p>
    	<div class="clear"></div>
    	<div class="sure_btn" onclick="dosubmit();" >确&nbsp;&nbsp;&nbsp;&nbsp;定</div>
    	<div class="clear"></div>
    	<div style="position:relative; bottom: 30px"><jsp:include page="../../common/charityfoot.jsp"></jsp:include></div>
<form action="<%=request.getContextPath()%>/msl/sales/honorCertificate" method="post" id="baseForm" name="form1"></form>
  </body>
  <script type="text/javascript">
  	 
	  function dosubmit(){
			  $("#baseForm").submit();
	  }
	  function show(){
			var  donationFlag = $("#donationFlag").val();
			var  helpStudyFlag = $("#helpStudyFlag").val();
			if(donationFlag=='1'){
				$('#isCharity').show();
				$('#help_head').dispaly="none";
				
			}
			if(helpStudyFlag=='1'){
				$('#isHelp').show();
			}
		}
</script>
</html>
