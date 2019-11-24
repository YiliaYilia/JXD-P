<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../common/taglibs.jsp"%>
<%@ include file="../../common/rels.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>自助理赔申请</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta name="format-detection" content="telephone=no"/>
 	<script src="<%=request.getContextPath()%>/resources/js/compensation/steptwo.js"></script>
 	  <!-- date -->
	<script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.core.js"></script>
	<script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.frame.js"></script>
	<script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.scroller.js"></script>
	<script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.util.datetime.js"></script>
	<script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.datetimebase.js"></script>
	<script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.datetime.js"></script>
	<script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.frame.android.js"></script>
	<script src="<%=request.getContextPath()%>/resources/date/js/mobiscroll.frame.android-holo.js"></script>
	<script src="<%=request.getContextPath()%>/resources/date/js/i18n/mobiscroll.i18n.zh.js"></script>
	<link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.frame.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.frame.android.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.frame.android-holo.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.scroller.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.scroller.android.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/resources/date/css/mobiscroll.scroller.android-holo.css" rel="stylesheet" type="text/css" />
 	
 	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/compensation/compensation.css?${random}" type="text/css"></link>
 	<script type="text/javascript">
 		function fillSteptwo(){
 			//modal_loading();
 			if(!check()){
				//modal_loading('hide');
				return;
			}
 			
 			$("#creator").submit();
 		}
 	</script>
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/style-font.css">
<style type="text/css">
.next-button {
    margin-bottom: 0px;
	padding-bottom:50px;
}
</style>
</head>
<body  class="gray" onload="backshow()">
	<div class="grace-head"></div>
  	<!--阶段标识区域-->
	<ul class="grace-top-menu2"> 
		<li class="menu-select"> 1.填写申请 </li>
		<li> 2.上传资料</li>
		<li> 3.完成</li>
  	</ul>
   	<!--填写投保信息区域-->
	<form action="<%=request.getContextPath()%>/msl/sales/fillSteptwoClaimAction" method="post" id="creator" name="creator" enctype="multipart/form-data">
		<input id="policyCode" name="geClaimManagement.policyCode" type="hidden" value="${geClaimManagement.policyCode }" />
  		<input id="name" name="geClaimManagement.name" type="hidden" value="${geClaimManagement.name }"/>
  		<input id="insrelationApp" name="geClaimManagement.insrelationApp" type="hidden"  value="${geClaimManagement.insrelationApp }"/>
		<input id="claimManagementType" name="geClaimManagement.claimManagementType" type="hidden"  value="${geClaimManagement.claimManagementType }"/>
		<c:if test="${geClaimManagement.claimManagementNo != null && geClaimManagement.claimManagementNo != ''}">
			<input id="claimManagementNo" name="geClaimManagement.claimManagementNo" type="hidden"  value="${geClaimManagement.claimManagementNo}"/>
		</c:if>
		<input id="openId" name="geClaimManagement.openId" type="hidden"  value="${geClaimManagement.openId }"/>
		<input id="state" name="geClaimManagement.state" type="hidden"  value="${geClaimManagement.state }"/>
		<input id="amount" name="geClaimManagement.amount" type="hidden"  value="${geClaimManagement.amount }"/>
		<input id="commitType" name="geClaimManagement.commitType" type="hidden"  value="${geClaimManagement.commitType }"/>
		<input id="payType" name="geClaimManagement.payType" type="hidden"  value="${geClaimManagement.payType }"/>
		<input id="flowNo" name="geClaimManagement.flowNo" type="hidden"  value="${geClaimManagement.flowNo }"/>
		<input id="remark" name="geClaimManagement.remark" type="hidden"  value="${geClaimManagement.remark }"/>
		<input id="createDate" name="geClaimManagement.createDate" type="hidden"  value="${geClaimManagement.createDate }"/>
   		
   		<div  class="panel-collapse collapse in cardcontent">
        	<ul class="grace-form"> 
    		<li>
    			<div class="pull-left">被保险人<br/>出险日期：</div>
    			<div class="pull-right"> 
    				<input id="geClaimManagement.startDate" name="geClaimManagement.startDate" type="hidden" value="${geClaimManagement.startDate}" />
    				<input type="date" id="startDate" value="${geClaimManagement.startDate}" style="height:22px; line-height:22px;"/>
    			</div>
    		</li>
    		<li>
    			<div class="pull-left">被保险人<br/>出险原因：</div> 
    			<div class="pull-right"> 
    				<input class="txt14"  id="startCause" name="geClaimManagement.startCause" type="text" value="${geClaimManagement.startCause }"/>
    			</div>
    		</li>
    <li > <div class="pull-left" >报案人<br/>联系电话：</div> <div class="pull-right"><input class="txt14"  id="phone" name="geClaimManagement.phone" type="text" value="${geClaimManagement.phone }" maxlength="11"/></div></li>
    
    <li > <div class="pull-left">被保险人<br/>当前职业：</div> <div class="pull-right"> 
    <input class="txt14"  id="occupation" name="geClaimManagement.occupation" type="text" value="${geClaimManagement.occupation }"/>
    </div></li>
   
     <li > <div class="pull-left" style="width:65%">被保险人是否在其他公司有人身保险：</div> <div class="pull-right" style="width:30%;"> 
     
							<select class="form-control" id="isInsure" name="geClaimManagement.isInsure" onchange="choose()">
								<option value="">请选择</option>
								<option <c:if test="${geClaimManagement.isInsure == 'Y' }">selected="selected"</c:if> value="Y">是</option>
								<option <c:if test="${geClaimManagement.isInsure == 'N' }">selected="selected"</c:if> value="N">否</option>
							</select></div></li>
    <li class="isInsureOrNo"> <div class="pull-left">公司名称：</div> <div class="pull-right"> <input class="txt14"  id="corporationName" name="geClaimManagement.corporationName" type="text" value="${geClaimManagement.corporationName }"/></div></li>
    <li  class="isInsureOrNo"> <div class="pull-left">投保日期：</div> <div class="pull-right"> 
    	
    	<input class="txt14"  id="geClaimManagement.insureDate" name="geClaimManagement.insureDate" type="hidden" value="${geClaimManagement.insureDate}"/>
			<input type="date" id="insureDate" value="${geClaimManagement.insureDate}" style="height:22px; line-height:22px;"/></div></li>
    
    <li  class="isInsureOrNo"> <div class="pull-left"  style="width:50%">购买险种名称及保额：</div> <div class="pull-right" style="width:45%;"> <input class="txt14"  id="insuranceInfo" name="geClaimManagement.insuranceInfo" type="text" value="${geClaimManagement.insuranceInfo }"/>
    </div></li>
    
  			</ul>  
		</div>
	    	</form>
    	<!-- 按钮区域 -->
	   	<div class="next-button " onclick="fillSteptwo()"><img src="${ctx}/uinew/images/button2.jpg" width="100%"  alt=""/> </div>
   	
   	<div class="footer footer-fixed "> <img src="${ctx}/uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>

   	<jsp:include page="../../common/common-modal.jsp"></jsp:include>
  </body>
</html>
