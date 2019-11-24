<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>自助理赔查询</title>
	
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    
	<script src="<%=request.getContextPath()%>/global/lib/jquery/jquery-2.1.3.min.js"></script>
	<script src="<%=request.getContextPath()%>/global/lib/common/main.js?${random}"></script>
	
	<script src="<%=request.getContextPath()%>/global/lib/component/modal.js"></script>
	
	<script src="<%=request.getContextPath()%>/global/lib/jquery/jquery.event.move.js"></script>
	<script src="<%=request.getContextPath()%>/global/lib/jquery/jquery.mobile.touch.js"></script>
	<script src="<%=request.getContextPath()%>/global/lib/jquery/jquery.event.swipe.js"></script>
	
	<!-- 引入 end-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/global/js/jquery/1.9.0/jquery.min.js"></script>
  	<script type="text/javascript" src="<%=request.getContextPath()%>/global/js/common.js"></script>
  	<!-- init page scale-->
  	<script>
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
  	<meta name="format-detection" content="telephone=no"/>
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/style-font.css">
<style>
	.insurance-text ul li.add-bg {
    width: 20%;
    background: url(${ctx}/uinew/images/bg.jpg) repeat-y right 0;
    min-height: 120px;
    float: right;
    border-top-right-radius: 6px;
    border-bottom-right-radius: 6px;
    text-align: center;
    line-height: 70px;
    font-size: 80px;
    color: #fff;
}
	</style>

  </head>
  <body  class="gray">
  <div class="grace-head"> </div>

  <div class="insurance-list" style="font-size: 20px;"> 
    <div class="insurance-tl"> 自助理赔列表</div>
    <ul class="insurance-content"> 
    	
   		<c:forEach var="claim" items="${claimList}"  varStatus="this_status">
   			
       <li> 
        <div class="insurance-icon"></div>
        <div class="insurance-text"> 
          <ul> 
             <li class="wenzi"> 
               <h2> ${claim.name }&nbsp;&nbsp;&nbsp;&nbsp;${claim.languageState } </h2>
               <p> 保险单号：${claim.policyCode }</p>
               <p class="shengxiao"> <span class="icon-time"></span>${claim.createDate }申请</p>
                
             </li>
             <li class="add-bg" onclick="javascript:window.location.href='<%=path %>/msl/sales/findClaimAction?claimManagementNo=${claim.claimManagementNo }'">+</li>
          </ul>
        </div>
      </li>
      
   			</c:forEach>
    </ul>
  </div>
  
<div class="footer footer-fixed "> <img src="${ctx}/uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>

<!-- 框体 -->
	<div class="modal fade" data-rule="alert" id="modal_alert">
		<div class="modal-dialog alert">
			<div class="modal-header clearfix"><span data-title="modal">提示信息</span><a type="button" class="close" data-dismiss="modal"></a></div>
			<div class="modal-content" data-content="modal"></div>
			<div class="modal-footer">
				<a class="modal-btn btn" data-dismiss="modal" data-btn="modal">确定</a>
			</div>
		</div>
	</div>
<!-- 		加载等待框 -->
	<div class="modal fade" data-rule="loading" id="modal_loading">
		<div class="modal-dialog loading">
			<div class="modal-content" data-content="modal">
				<p class="loader8">加载中......</p>
			</div>
		</div>
	</div>
  </body>
</html>
