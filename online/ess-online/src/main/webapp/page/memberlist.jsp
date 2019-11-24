<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
      <title>保单成员列表</title>
    <meta http-equiv="content-type" content="text/html" charset="utf-8">
    <!-- 引入 -->
	<link href="../global/css/common/main.min.css?${random}" rel="stylesheet"/>
	<link href="../global/css/page/page.min.css?${random}" rel="stylesheet"/>
	<link href="../global/css/animate/animate.css" rel="stylesheet"/>
	<link href="../global/css/animate/loader-ani.css" rel="stylesheet"/>
	
	<script src="../global/lib/jquery/jquery-2.1.3.min.js"></script>
	<script src="../global/lib/common/main.js?${random}"></script>
	
	<script src="../global/lib/component/modal.js"></script>
	
	<script src="../global/lib/jquery/jquery.event.move.js"></script>
	<script src="../global/lib/jquery/jquery.mobile.touch.js"></script>
	<script src="../global/lib/jquery/jquery.event.swipe.js"></script>
	
	<!-- 引入 end-->
    <script type="text/javascript" src="../global/js/jquery/1.9.0/jquery.min.js"></script>
  	<script type="text/javascript" src="../global/js/common.js"></script>
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
	
  </head>
  
<link rel="stylesheet" type="text/css" href="../uinew/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/style-font.css">

<style>
	.insurance-text ul li.add-bg {
    width: 20%;
    background: url(../uinew/images/bg.jpg) repeat-y right 0;
    min-height: 155px;
    float: right;
    border-top-right-radius: 6px;
    border-bottom-right-radius: 6px;
    text-align: center;
    line-height: 105px;
    font-size: 80px;
    color: #fff;
}
.insurance-list {
    font-size: 20px;
		margin-top: 30px;
}
	</style>
	
    <body  class="gray">
  <div class="grace-head"> </div>
<h2 style="margin-top:70px; text-align:center; color:#c8a154; font-size:2em; font-weight:bold;">请选择您要变更的保单成员</h2>


  <div class="insurance-list"> 
    <div class="insurance-tl"> 投保人列表</div>
    <ul class="insurance-content"> 
    	
   		<c:forEach var="pol" items="${polParty}"  varStatus="this_status">
      <li> 
        <div class="insurance-icon"></div>
        <div class="insurance-text"> 
          <ul> 
             <li class="wenzi"> 
               <h2> 姓名:${pol.name}</h2>
               <p> 证件号: [${pol.CardType}]${pol.CardNo}</p>
               <p>证件有效期：${pol.ExpiredDate}</p>
             </li>
             <li class="add-bg" onclick="onclickToCertificate('${pol.partyCode}','pol','${pol.partyCode}','${pol.CardNo}','${pol.CardType}','${pol.ExpiredDate}');">+</li>
          </ul>
        </div>
      </li>
      </c:forEach>
    </ul>
    <div class="insurance-tl">被保人列表</div>
    <ul class="insurance-content"> 
    	
   		<c:forEach var="lifeAssd" items="${lifeAssdParty}"  varStatus="this_status">
      <li> 
        <div class="insurance-icon"></div>
        <div class="insurance-text"> 
          <ul> 
             <li class="wenzi"> 
               <h2> 姓名:${lifeAssd.name}</h2>
               <p> 证件号: [${lifeAssd.CardType}]${lifeAssd.CardNo}</p>
               <p>证件有效期：${lifeAssd.ExpiredDate}</p>
             </li>
             <li class="add-bg" onclick="onclickToCertificate('${polParty[0].partyCode}','lifeAssd','${lifeAssd.partyCode}','${lifeAssd.CardNo}','${lifeAssd.CardType}','${lifeAssd.ExpiredDate}');">+</li>
          </ul>
        </div>
      </li>
      
   			</c:forEach>
    </ul>
    
    <c:if test="${flag == 0}">
    <div class="insurance-tl">受益人列表</div>
    <ul class="insurance-content"> 
   		<c:forEach var="benfic" items="${benficParty}"  varStatus="this_status">
      <li> 
        <div class="insurance-icon"></div>
        <div class="insurance-text"> 
          <ul> 
             <li class="wenzi"> 
               <h2> 姓名:${benfic.name}</h2>
               <p> 证件号: [${benfic.CardType}]${benfic.CardNo}</p>
               <p>证件有效期：${benfic.ExpiredDate}</p>
             </li>
             <li class="add-bg" onclick="onclickToCertificate('${polParty[0].partyCode}','benfic','${benfic.partyCode}','${benfic.CardNo}','${benfic.CardType}','${benfic.ExpiredDate}');">+</li>
          </ul>
        </div>
      </li>
      
   			</c:forEach>
    </ul>
    </c:if>

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
	<div class="footer "> <img src="../uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>

	
<!-- 		加载等待框 -->
	<div class="modal fade" data-rule="loading" id="modal_loading">
		<div class="modal-dialog loading">
			<div class="modal-content" data-content="modal">
				<p class="loader8">加载中......</p>
			</div>
		</div>
	</div>
  </body>
 
  <script type="text/javascript">
//  var conwidth =  parseInt($(".container").width());
  //	$(".header").width(conwidth);
	//alert($(".container").width());alert($(".header").width());
	
	<c:if test="${Contenct!=null}">
		$(document).ready(function(){
				modal_alert({content:'${Contenct}',btn:'确定'});
		});	 
	</c:if>
	
	function onclickToCertificate(polPartyCode,partyType,partyCode,cardNo,cardType,expiredDate){
		window.location.href = '<%=path %>/action/certificate?polPartyCode='+polPartyCode +'&partyType='+partyType+'&partyCode='+partyCode
			+'&cardNo='+cardNo+'&cardType='+cardType+'&expiredDate='+expiredDate;
		//var url = 'http://testweixin.oldmutual-guodian.com/online/action/certificate?polPartyCode='+polPartyCode +'&partyType='+partyType+'&partyCode='+partyCode
		//	+'&cardNo='+cardNo+'&cardType='+cardType+'&expiredDate='+expiredDate;
		//window.location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx618b6902989a293e&redirect_uri='+encodeURIComponent(url)
		//    +'&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect'; //测试
		// window.location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx5be4b58fee2539db&redirect_uri='+encodeURIComponent(url)
		// +'&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect'; //生产
	}
</script>
 
    <%--  <%@ include file="/page/result.jsp"%>  --%>
</html>
