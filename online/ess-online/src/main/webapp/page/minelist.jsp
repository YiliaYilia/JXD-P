<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>保单人员列表</title>
	
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="../global/css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="../global/css/all.css" type="text/css"></link>
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
  	<meta name="viewport" content="width=device-width, target-densitydpi=240,initial-scale=0.667, minimum-scale=0.667, maximum-scale=0.667, user-scalable=0" id="viewport">
  	<meta name="format-detection" content="telephone=no"/>
  </head>
  <body>
   	<!--受益人信息 -->
	<div class="header">
    	<div>
	    	<div class="headertitle">受益人列表</div>
	    	<div class="clear"></div>
    	</div>
    </div>
    <div class="clear"></div>
    <div class="container">
   		<div class="content">
   		<c:forEach var="benfic" items="${benficParty}"  varStatus="this_status">
   			<div class="signdiv">
    			<div class="signimg" onclick="javascript:window.location.href='<%=path %>/page/certificate.jsp?partyType=benfic&partyCode=${benfic.partyCode}&CardNo=${benfic.CardNo}&CardType=${benfic.CardType}&ExpiredDate=${benfic.ExpiredDate}'">
    				<img src="../global/images/redbook.png"/>
    			</div>
    		</div>
    		<div class="signdiv1">
    		<div class="signarrow"></div>
    		</div>
   			<div class="hidetable">
   				<div class="width80p firstdiv">
   					<div class="black">姓名:${benfic.name}</div>
   					<div>证件号：[${benfic.CardType}]${benfic.CardNo}</div>
   					<div>证件有效期：${benfic.ExpiredDate}</div>
   				</div>
   				<div class="width20p seconddivshow cursor">
   					<div class="showbtn"></div>
   				</div>
   				<div class="width20p seconddivhide cursor" onclick="javascript:window.location.href='<%=path %>/page/certificate.jsp?partyType=benfic&partyCode=${benfic.partyCode }&CardNo=${benfic.CardNo}&CardType=${benfic.CardType}&ExpiredDate=${benfic.ExpiredDate}'">
   					<div class="hidebtn">
   						<span class="hidespan1"></span>
   						<span class="hidespan2"></span>
   					</div>
   				</div>
   				<div class="width20p forthdiv cursor">
   					<img src="../global/images/detailinfo.png" class="width36"/>
   					<div>详细信息</div>
   				</div>
   			</div>
   			<c:if test="${this_status.last==false}">
    			<div class="hidelinkline"></div> 
    			</c:if>
   			</c:forEach>
   			<div class="lastlinkline"></div>
    		 <div class="clear"></div>
    	</div>
    </div>
    <div class="clear"></div>
	  	<!--被保人信息 -->
	<div class="header">
    	<div>
	    	<div class="headertitle">被保人列表</div>
	    	<div class="clear"></div>
    	</div>
    </div>
    <div class="clear"></div>
    <div class="container">
   		<div class="content">
   		<c:forEach var="lifeAssd" items="${lifeAssdParty}"  varStatus="this_status">
   			<div class="signdiv">
    			<div class="signimg" onclick="javascript:window.location.href='<%=path %>/page/certificate.jsp?partyType=lifeAssd&partyCode=${lifeAssd.partyCode }&CardNo=${lifeAssd.CardNo}&CardType=${lifeAssd.CardType}&ExpiredDate=${lifeAssd.ExpiredDate}'">
    				<img src="../global/images/redbook.png"/>
    			</div>
    		</div>
    		<div class="signdiv1">
    		<div class="signarrow"></div>
    		</div>
   			<div class="hidetable">
   				<div class="width80p firstdiv">
   					<div class="black">姓名:${lifeAssd.name}</div>
   					<div>证件号：${lifeAssd.CardType}:${lifeAssd.CardNo}</div>
   					<div>证件有效期：${lifeAssd.ExpiredDate}</div>
   				</div>
   				<div class="width20p seconddivshow cursor">
   					<div class="showbtn"></div>
   				</div>
   				<div class="width20p seconddivhide cursor" onclick="javascript:window.location.href='<%=path %>/page/certificate.jsp?partyType=lifeAssd&partyCode=${lifeAssd.partyCode }&CardNo=${lifeAssd.CardNo}&CardType=${lifeAssd.CardType}&ExpiredDate=${lifeAssd.ExpiredDate}'">
   					<div class="hidebtn">
   						<span class="hidespan1"></span>
   						<span class="hidespan2"></span>
   					</div>
   				</div>
   				<div class="width20p forthdiv cursor">
   					<img src="../global/images/detailinfo.png" class="width36"/>
   					<div>详细信息</div>
   				</div>
   			</div>
   			<c:if test="${this_status.last==false}">
    			<div class="hidelinkline"></div> 
    			</c:if>
   			</c:forEach>
   			<div class="lastlinkline"></div>
    		 <div class="clear"></div>
    	</div>
    </div>
    <div class="clear"></div>
      	<!--投保人信息 -->
	<div class="header">
    	<div>
	    	<div class="headertitle">投保人列表</div>
	    	<div class="clear"></div>
    	</div>
    </div>
    <div class="clear"></div>
    <div class="container">
   		<div class="content">
   		<c:forEach var="pol" items="${polParty}"  varStatus="this_status">
   			<div class="signdiv">
    			<div class="signimg" onclick="javascript:window.location.href='<%=path %>/page/certificate.jsp?partyType=pol&partyCode=${pol.partyCode }&CardNo=${pol.CardNo}&CardType=${pol.CardType}&ExpiredDate=${pol.ExpiredDate}'">
    				<img src="../global/images/redbook.png"/>
    			</div>
    		</div>
    		<div class="signdiv1">
    		<div class="signarrow"></div>
    		</div>
   			<div class="hidetable">
   				<div class="width80p firstdiv">
   					<div class="black">姓名:${pol.name}</div>
   					<div>证件号：${pol.CardType}:${pol.CardNo}</div>
   					<div>证件有效期：${pol.ExpiredDate}</div>
   				</div>
   				<div class="width20p seconddivshow cursor">
   					<div class="showbtn"></div>
   				</div>
   				<div class="width20p seconddivhide cursor" onclick="javascript:window.location.href='<%=path %>/page/certificate.jsp?partyType=pol&partyCode=${pol.partyCode }&CardNo=${pol.CardNo}&CardType=${pol.CardType}&ExpiredDate=${pol.ExpiredDate}'">
   					<div class="hidebtn">
   						<span class="hidespan1"></span>
   						<span class="hidespan2"></span>
   					</div>
   				</div>
   				<div class="width20p forthdiv cursor">
   					<img src="../global/images/detailinfo.png" class="width36"/>
   					<div>详细信息</div>
   				</div>
   			</div>
   			<c:if test="${this_status.last==false}">
    			<div class="hidelinkline"></div> 
    			</c:if>
   			</c:forEach>
   			<div class="lastlinkline"></div>
    		 <div class="clear"></div>
    	</div>
    </div>
    <div class="clear"></div>
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
 
  <script type="text/javascript">
  <c:if test="${Contenct!=null}">
	$(document).ready(function(){
			modal_alert({content:'${Contenct}',btn:'确定'});
	});	 
</c:if>
</script>
 
    <%--  <%@ include file="/page/result.jsp"%>  --%>
</html>
