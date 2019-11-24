<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.com.sinosoft.domain.user.DateChangeData"%>
<% 
request.setCharacterEncoding("UTF-8");
String url = "http://localhost:8080/onlineTest/page/certificate.jsp?" + request.getQueryString();
//String url = "https://testweixin.oldmutual-guodian.com/online/page/certificate.jsp?" + request.getQueryString();//测试
//String url = "http://weixin.oldmutual-guodian.com/online/page/certificate.jsp?" + request.getQueryString(); //生产
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String conservationFlag = request.getParameter("conservationFlag")==null?"":request.getParameter("conservationFlag");
if(conservationFlag == null || "".equals(conservationFlag)){
	conservationFlag = request.getAttribute("conservationFlag")==null?"":request.getAttribute("conservationFlag").toString();
}
String partyType = request.getAttribute("partyType")==null?"":request.getAttribute("partyType").toString();
String partyCode = request.getAttribute("partyCode")==null?"":request.getAttribute("partyCode").toString();
String CardNo = request.getAttribute("cardNo")==null?"":request.getAttribute("cardNo").toString();
String CardType = request.getAttribute("cardType")==null?"":request.getAttribute("cardType").toString();
String ExpiredDate = request.getAttribute("expiredDate")==null?"":request.getAttribute("expiredDate").toString().replace("/", "-");
%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>证件有效期变更</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="../global/css/common/main.min.css?${random}"
	rel="stylesheet" />
<link rel="stylesheet" href="../global/css/common.css" type="text/css"></link>
<link rel="stylesheet" href="../global/css/all.css" type="text/css"></link>
<link rel="stylesheet" href="../global/css/fillInfo.css" type="text/css"></link>
<link rel="stylesheet" href="../global/css/font-size-screen.css" />
<link rel="stylesheet" href="../global/css/date.css" type="text/css"></link>
<link href="../global/css/animate/loader-ani.css" rel="stylesheet"/>
<script type="text/javascript"
	src="../global/lib/jquery/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="../resources/lib/jquery/jquery.js"></script>
<script type="text/javascript" src="../resources/lib/jquery/ajaxfileupload.js"></script>
<script type="text/javascript" src="../global/js/date.js"></script>
<script type="text/javascript" src="../global/js/iscroll.js"></script>
<script type="text/javascript" src="../global/js/common.js"></script>
<script src="../global/lib/common/main.js?${random}"></script>
<script src="../global/lib/component/modal.js"></script>
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
<meta name="format-detection" content="telephone=no" />
</head>

<style type="text/css">
#dateshadow {
	width: 102%;
	height: 2500px;
	min-width: 555px;
}

#datePage {
	position: fixed;
}

.file {
	position: relative;
	display: inline-block; -
	-background: #D0EEFF; -
	-border: 1px solid #99D3F5; -
	-border-radius: 4px;
	padding: 4px 12px;
	overflow: hidden; -
	-color: #1E88C7;
	text-decoration: none;
	text-indent: 0;
	line-height: 20px;
	float: left;
	margin-left: 10px;
	color: #c8a154;
	font-weight: bold;
}

.file1 {
	position: relative;
	display: inline-block;
	background: #D0EEFF;
	border: 1px solid #99D3F5;
	border-radius: 4px;
	padding: 10px 20px;
	overflow: hidden;
	color: #1E88C7;
	text-decoration: none;
	text-indent: 0;
	line-height: 20px;
	float: left;
	margin: 20px 20px;
}

.file input {
	position: absolute;
	font-size: 100px;
	right: 0;
	top: 0;
	opacity: 0;
}

.file:hover {
	background: #AADFFD;
	border-color: #78C3F3;
	color: #004974;
	text-decoration: none;
}

.file1:hover {
	background: #AADFFD;
	border-color: #78C3F3;
	color: #004974;
	text-decoration: none;
}

.date_select {
	float: left;
	margin-top: 5px;
}

.view_border {
	/*border:1px solid #808080;*/
	height: 220px;
	width: 95%;
	float: left;
	margin: 10px;
}

.txt1 {
	font-size: 1.2em;
	color: black;
	font-family: "微软雅黑";
}
.viewModal{
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	z-index: 501;
	max-height: 100%;
	overflow-y: auto;
	height: 200px; 
	border-radius:5px;
	color:#fff;
	font-size: 30px;
}
.viewModal label{
	background-color: #1aad19;
	width: 100%;
	position: relative;
	display: block;
	text-align: center;
	overflow: hidden;
	line-height: 90px;
}
.viewModal button{
	background-color: #1aad19;
	width: 100%;
	position: relative;
	display: block;
	text-align: center;
	overflow: hidden;
	line-height: 90px;
	color:#fff;
	font-size: 30px;
}
</style>
<script type="text/javascript">
 		$(function(){
 			$('#ExpiredDate').date();
 		})
 	</script>
<style>
.grace-head {
	width: 100%;
	height: 50px;
	background: url(../uinew/images/header.jpg) center center;
	background-size: cover;
	position: fixed;
	top: 0px;
	z-index: 999;
}

.footer {
	width: 100%;
	bottom: 0;
	position: relative;
	margin-top: 50px;
}

.next-button {
	width: 96%;
	margin: 0 auto;
}

.crsInfo .modal-dialog {
	width: 90%;
	background: #fff
}

.crsInfo .modal-dialog .modal-header {
	height: 80px;
	line-height: 80px;
	font-size: 3rem;
	padding-left: 20px
}

.crsInfo .modal-dialog .modal-content {
	padding: 40px 40px 50px;
	color: #757575;
	font-size: 2.8rem;
	word-break: break-all
}

.crsInfo .modal-dialog .modal-footer {
	padding-bottom: 20px;
	text-align: center;
}

.crsInfo .modal-dialog .modal-btn {
	height: 70px;
	line-height: 70px;
	background: #E8C26D;
	font-size: 2.8rem;
	color: #fff;
	margin: 0 40px;
	width: 50%;
	border-radius: 5px
}

.crsinfo_modal_alert .modal-dialog {
	width: 90%;
	background: #fff
}

.crsinfo_modal_alert .modal-dialog .modal-header {
	height: 80px;
	line-height: 80px;
	font-size: 3rem;
	padding-left: 20px
}

.crsinfo_modal_alert .modal-dialog .modal-content {
	padding: 40px 40px 50px;
	color: #757575;
	font-size: 2.8rem;
	word-break: break-all
}

.crsinfo_modal_alert .modal-dialog .modal-footer {
	padding-bottom: 20px;
	text-align: center;
}

.crsinfo_modal_alert .modal-dialog .modal-btn,.btn-default {
	height: 70px;
	line-height: 70px;
	font-size: 2.8rem;
	margin: 0 35px;
	width: 32%;
	border-radius: 5px
}

.crsinfo_modal_alert .modal-dialog .modal-btn {
	color: #fff;
	background: #E8C26D;
}

</style>
<body>
	<div class="grace-head"></div>
	<h2
		style="margin-top:70px; text-align:center; color:#c8a154; font-size:2em; font-weight:bold;">证件有效期变更</h2>
	<div class="clear"></div>
	<div class="container">
		<section class="fillInfoWrap">
			<div class="fillDiv">
				<form action="<%=path %>/action/PartyChange" name="reForm"
					id="reForm" method="post">
					<table class="fillTable" style="margin-left:3%">
						<tbody>

							<tr>
								<td class="txt1" colspan="2">变更主体： <select class="txt2"
									id="partyType" name="partyType" disabled="disabled"
									style="width:30%;font-size: 1.0em;">
										<option value="pol">投保人</option>
										<option value="lifeAssd">被保险人</option>
										<option value="benfic">身故受益人</option>
								</select>
								</td>
							</tr>
							<tr>
								<td class="txt1" colspan="2"><span style="float:left">证件有效期截止日：</span>

									<select id="year" class="date_select"
									style="width:20%;-webkit-appearance: menulist;font-size: 1.0em;">
										<%for(int y=2015;y<2050;y++){ %>
										<option value="<%=y%>"><%=y%></option>
										<%} %>
								</select> <span style="float:left">年</span> <select id="month"
									class="date_select"
									style="width:13%;-webkit-appearance: menulist;font-size: 1.0em;">
										<%for(int m=1;m<13;m++){ %>
										<option value="<%=m%>"><%=m%></option>
										<%} %>
								</select> <span style="float:left">月</span> <select id="day"
									class="date_select"
									style="width:13%;-webkit-appearance: menulist;font-size: 1.0em;">
										<%for(int d=1;d<32;d++){ %>
										<option value="<%=d%>"><%=d%></option>
										<%} %>
								</select> <span style="float:left">日</span></td>
							</tr>
							<tr>
								<td colspan="2" class="txt1" style="border-bottom:none;">上传证件照(身份证请上传正面及反面)</td>
							</tr>
							<tr>
								<td colspan="2" style="border-bottom:none;"><a class="file"
									id="chooseFront">上传正面</a></td>
							</tr>
							<tr>
								<td colspan="2" style="border-bottom:none;" class="view_border">
									<img id="viewFrout" onclick="showModal('viewFrout')" src="../uinew/images/add.png"
									style="width:100%;height:100%;float:left">
								</td>
							</tr>
							<tr>
								<td colspan="2" style="border-bottom:none;"><a class="file"
									id="chooseContrary">上传反面</a></td>
							</tr>
							<tr>
								<td colspan="2" style="border-bottom:none;" class="view_border">
									<img id="viewContrary" onclick="showModal('viewContrary')" src="../uinew/images/add.png"
									style="width:100%;height:100%;float:left">
								</td>
							</tr>
							<input type="hidden" id="partyCode" name="partyCode"
								value="<%=partyCode %>">
							<input type="hidden" id="CardNo" name="CardNo"
								value="<%=CardNo %>">
							<input type="hidden" id="CardType" name="CardType"
								value="<%=CardType %>">
							<tr>
								<td class="alignRight" colspan="2" style="border-bottom:none;">
									<div class="next-button " onclick="dosubmit();">
										<img src="../uinew/images/button2.jpg" width="100%"
											alt="" style="width: 100%;height: auto;">
									</div>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<!-- crs录入 -->
			<div class="modal fade crsInfo" id="crsInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-content" data-content="modal">
							<h4>依据国家税务总局、财政部等共同发布的《非居民金融账户涉税信息尽职调查管理办法》（2017年第14号）的要求，需要您配合填写并签署相应的税收居民身份声明文件。</h4><br/>
							<span>税收居民身份</span>
							<select id="taxType" class="taxType" style="width:50%;font-size: 0.8em;" onChange="trial();">
								<option value="">--请选择--</option>
								<option value="1">仅为中国大陆税收居民</option>
								<option value="2">仅为非居民</option>
								<option value="3">既是中国大陆税收居民又是其他税收管辖区居民</option>
							</select>
						</div>
						<div class="modal-footer">
							<button type="button" class="modal-btn btn" onclick="crsInfoSubmit();">提交</button>
						</div>
					</div>
				</div>
			</div>
			<!-- crs确认提交框 -->
			<div class="modal fade crsInfoSubmit" id="crsInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-content" data-content="modal">
							<h4>依据国家税务总局、财政部等共同发布的《非居民金融账户涉税信息尽职调查管理办法》（2017年第14号）的要求，需要您配合填写并签署相应的税收居民身份声明文件。</h4><br/>
							<span>税收居民身份</span>
							<select id="taxType" class="taxType" style="width:50%;font-size: 0.8em;" onChange="trial();">
								<option value="">--请选择--</option>
								<option value="1">仅为中国大陆税收居民</option>
								<option value="2">仅为非居民</option>
								<option value="3">既是中国大陆税收居民又是其他税收管辖区居民</option>
							</select>
						</div>
						<div class="modal-footer">
							<button type="button" class="modal-btn btn" onclick="crsInfoSubmit();">提交</button>
						</div>
					</div>
				</div>
			</div>
			<input type="hidden" id="taxDeclaraID" value="" />
			<input type="hidden" id="mediaPathFront" value="" />
			<input type="hidden" id="mediaPathContrary" value="" />
			<input type="hidden" value="N" id="successChooseFront"> <input
				type="hidden" value="N" id="successChooseContrary">
			<div id="viewFroutModal" hidden="hidden" class="viewModal">
            	<div style="padding:20px 15px;">
            		<label>选择图片
                		<input id="viewFroutFile" hidden="hidden" type="file" name="viewFroutFile" accept="image/*" onchange="imageChange('viewFrout')"/>
            		</label>
            		<button class="btnbtn" onclick="hiddenModal('viewFrout')">取消</button>
        		</div>
    		</div>
    		<div id="viewContraryModal" hidden="hidden" class="viewModal">
            	<div style="padding:20px 15px;">
            		<label>选择图片
                		<input id="viewContraryFile" hidden="hidden" type="file" name="viewContraryFile" accept="image/*" onchange="imageChange('viewContrary')"/>
            		</label>
            		<button class="btnbtn" onclick="hiddenModal('viewContrary')">取消</button>
        		</div>
    		</div>
    		<div>
    			<form action="<%=request.getContextPath()%>/page/bankInfoChange.jsp" method="post" id="changebank">
					<input type="hidden" name="policyNum" value="${policyNum}" />
					<input type="hidden" name="polName" value="${polName}" />
					<input type="hidden" name="accountBank" value="${accountBank}" />
					<input type="hidden" name="bankCardID" value="${bankCardID}" />
					<input type="hidden" name="renewalIndicator" value="${renewalIndicator}" />
				</form>
				<form action="" method="post" id="dovalue">
					<input type="hidden" id="investment" name="investment">
					<input type="hidden" id="policyNum" name="policyNum" value="${policyNum}">
					<input type="hidden" id="productCode" name="productCode" value="${productCode}">
					<input type="hidden" id="productName" name="productName" value="${productName}">
					<input type="hidden" id="coustomerid" name="coustomerid" value="${coustomerid}">
					<!-- 追加投资所用信息 -->
					<input type="hidden" id="applicantName" name="applicantName" value="${polName}">
					<input type="hidden" id="accountBank" name="accountBank" value="${accountBank}">
					<input type="hidden" id="bankCardId" name="bankCardId" value="${bankCardID}">
				</form>
    		</div>
			<div class="clear"></div>
		</section>
	</div>
	<div class="clear"></div>
	<div id="datePlugin"></div>
	<div class="footer ">
		<img src="../uinew/images/bottom-line.jpg" alt="" width="100%">
	</div>
	<style>
.modal-dialog.alert .modal-btn {
	background: #E8C26D;
}
</style>
	<!--弹出框 -->
	<div class="modal fade" data-rule="alert" id="modal_alert">
		<div class="modal-dialog alert">
			<div class="modal-header clearfix">
				<span data-title="modal">提示信息</span><a type="button" class="close"
					data-dismiss="modal"></a>
			</div>
			<div class="modal-content" data-content="modal"></div>
			<div class="modal-footer">
				<a class="modal-btn btn" data-dismiss="modal" data-btn="modal">确定</a>
			</div>
		</div>
	</div>
	<!--crsinfo弹出框 -->
	<div class="modal fade crsinfo_modal_alert" id="crsinfo_modal_alert" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-content" data-content="modal" id="crsinfo_content"></div>
						<div class="modal-footer">
							<button type="button" class="modal-btn btn" onclick="crsInfoSubmitForce();">确认</button>
							<button type="button" class="btn-default btn" data-dismiss="modal">取消</button>
						</div>
					</div>
				</div>
			</div>
	<!--加载等待框 -->
	<div class="modal fade" data-rule="loading" id="modal_loading">
		<div class="modal-dialog loading">
			<div class="modal-content" data-content="modal">
				<p class="loader8">加载中......</p>
			</div>
		</div>
	</div>
	<input type="hidden" id="appid" name="appid" />
  	<input type="hidden" id="urlPrefix" name="urlPrefix" />
</body>
<script type="text/javascript">
	var investment =
		<c:forEach var="investment" items="${policyBasic.investments}">
			"investmentName=${investment.investmentName}&"+
			"price=${investment.price}&"+
			"priceDate=${investment.priceDate}&"+
			"units=${investment.units},"+
		</c:forEach>"";
    $(document).ready(function(){
    	var hostname = location.hostname;
        if(hostname.startsWith('testweixin')){
    		$("#appid").attr("value", "wx618b6902989a293e");
        	$("#urlPrefix").attr("value", "http://testweixin.oldmutual-guodian.com/online/");
    	}else if(hostname.startsWith('weixin')){
    		$("#appid").attr("value", "wx5be4b58fee2539db");
    		$("#urlPrefix").attr("value", "http://weixin.oldmutual-guodian.com/online/");
    	}
    	var all_options = document.getElementById("partyType").options;
    	var partyType = "<%=partyType %>";
    	for (i=0; i<all_options.length; i++){
    		if (all_options[i].value == partyType){   
    			$("#partyType").attr("value", partyType);
    		}
    	}
    	$("#investment").attr("value",investment);
    });	
	
	function showModal(viewName){
		//$('#crsInfo').modal('show');
        document.getElementById(viewName+"Modal").removeAttribute("hidden");
    };
    function hiddenModal(viewName) {
        document.getElementById(viewName+"Modal").setAttribute("hidden","hidden");
    };
    
    function imageChange(viewName) {
        var file = document.getElementById(viewName+"File").files[0];
        var URL = window.URL || window.webkitURL;
        var imgURL = URL.createObjectURL(file);
        //alert(imgURL);
        document.getElementById(viewName+"Modal").setAttribute("hidden","hidden");
        var partyCode = $("#partyCode").val();
        var type;
        if(viewName=="viewFrout"){
        	type = "front";
        }else{
        	type = "contrary";
        }
        var cardNo = $("#CardNo").val();
        var partyType = $("#partyType").val();
        //去旷世验证
        modal_loading();
        $.ajaxFileUpload({
            url : '<%=path %>/action/identityOCR',
            secureuri : false,
            fileElementId : viewName + "File",
            dataType : 'json',
            data : {
            	"partyCode" : partyCode,
  				"type" : type,
  				"cardNo" : cardNo,
  				"partyType" : partyType
            },
            success : function(data,status){
            	modal_loading('hide');
            	if(data.flag == "0"){
            		document.getElementById(viewName).setAttribute("src",imgURL);
            		if(viewName=="viewFrout"){
            			document.getElementById("successChooseFront").value = "Y";
						$("#mediaPathFront").attr("value", data.mediaPathFront);
                    }else{
                    	document.getElementById("successChooseContrary").value = "Y";
						$("#mediaPathContrary").attr("value", data.mediaPathContrary);
                    	$("#year").val(data.year);
                    	$("#month").val(data.month);
                    	$("#day").val(data.day);
                    }
            	}else{
					modal_alert({content:data.message,btn:'确定'});
            		//document.getElementById(viewName).setAttribute("src","");
            	}
            },
            error : function(data,status,e){
            	modal_loading('hide');
            	modal_alert({content:'上传出错，请重新拍照或选择其他照片',btn:'确定'});
            	//document.getElementById(viewName).setAttribute("src","");
            }
        });
    };
	
	function crsInfoSubmit(){
		//crs校验
		var partyCode = $("#partyCode").val();
    	var taxType = $("#taxType").val();
    	if(taxType==""){
    		alert("请选择您的税收居民身份");
    		return false;
    	}
		$('#crsInfo').modal('hide');
        $.ajax({
    		url :'<%=path %>/action/dealPartyTaxType',
    		dataType : "json",
    		type : "POST",
    		async : false,
    		data : {
    			"partyCode" : partyCode,
    			"callBy":"WECHAT",
    			"taxType":taxType,
    			"operate" : "check"
    		},
    		success : function(data) {
    			if(data.code == "0"){
    				$("#taxDeclaraID").attr("value", data.taxDeclaraID);
    				//变更证件有效期
    				dosubmit();
    			}else if(data.code == "1133"){
					$('#crsinfo_content').html(data.contenct);
					$('#crsinfo_modal_alert').modal('show');
    			}else{
    				modal_alert({content:data.contenct,btn:'确定'});
    				$(".btn").click(function (){
    					window.location.href='<%=request.getContextPath()%>/page/policyService.jsp';
    				});
    			}
    		}
    	});
	}
	
	function crsInfoSubmitForce(){
		//crs校验
		var partyCode = $("#partyCode").val();
    	var taxType = $("#taxType").val();
        $.ajax({
    		url :'<%=path %>/action/dealPartyTaxType',
    		dataType : "json",
    		type : "POST",
    		async : false,
    		data : {
    			"partyCode" : partyCode,
    			"callBy":"WECHAT",
    			"taxType":taxType,
    			"operate" : "save"
    		},
    		success : function(data) {
    			if(data.code == "0"){
    				$("#taxDeclaraID").attr("value", data.taxDeclaraID);
    				//变更证件有效期
    				dosubmit();
    			}else{
    				modal_alert({content:data.contenct,btn:'确定'});
    				$(".btn").click(function (){
    					window.location.href='<%=request.getContextPath()%>/page/policyService.jsp';
    				});
    			}
    		}
    	});
	}
	
	
  	function dosubmit(){
  		var partyType = $("#partyType").val();
  		var ExpiredDate = $("#year").val()+"-"+$("#month").val()+"-"+$("#day").val();
  		var partyCode = $("#partyCode").val();
  		var CardNo = $("#CardNo").val();
  		var CardType = $("#CardType").val();
		var successChooseFront = $("#successChooseFront").val();
  		var successChooseContrary = $("#successChooseContrary").val();
		var taxDeclaraID = $("#taxDeclaraID").val();
		var mediaPathFront = $("#mediaPathFront").val();
		var mediaPathContrary = $("#mediaPathContrary").val();
  		if(successChooseFront != "Y"){
  			modal_alert({content:'请上传证件照正面',btn:'确定'});
  			return;
  		}
  		if(successChooseContrary != "Y"){
  			modal_alert({content:'请上传证件照反面',btn:'确定'});
  			return;
  		}
  		$.ajax({
  			type : "post",
  			url :'<%=path %>/action/PartyChange',
			timeout : 0, //超时时间设置，单位毫秒
  			dataType : "json",
  			async : true,
  			data : {
  				"partyType" : partyType,
  				"partyCode" : partyCode,
  				"ExpiredDate" : ExpiredDate,
  				"CardNo" : CardNo,
  				"CardType" : CardType,
  				"taxDeclaraID" : taxDeclaraID,
				"mediaPathFront" : mediaPathFront,
  				"mediaPathContrary" : mediaPathContrary
  			},
  			success : function(data) {
				if(data.code == "0"){
					modal_alert({content:data.contenct,btn:'确定'}); 
  					$(".btn").click(function (){
  						var conservationFlag = "<%=conservationFlag %>";
  				  		if(conservationFlag != null && conservationFlag=="bankAccountChange"){//银行账号变更
  				  			$("#changebank").submit();
  				  		}else if(conservationFlag != null && conservationFlag=="accountAssetTransfer"){//资产转移
  				  			$("#dovalue").attr("action","<%=request.getContextPath()%>/action/toCoustomerLoginPage");
	    					$("#dovalue").submit();
  				  		}else if(conservationFlag != null && conservationFlag=="crsInfoChange"){//crs变更
		    				window.location.href ='https://open.weixin.qq.com/connect/oauth2/authorize?appid=' + $('#appid').val()
		    						+ '&redirect_uri=' + $('#urlPrefix').val()
		    						+ 'action/crsInfoChange&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect';
  				  		}else if(conservationFlag != null && conservationFlag=="myInfo"){//个人地址变更
		  					window.location.href ='https://open.weixin.qq.com/connect/oauth2/authorize?appid=' + $('#appid').val()
		  							+ '&redirect_uri=' + $('#urlPrefix').val()
		  							+ 'action/myInfo&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect';
  				  		}else{
  				  			window.location.href='<%=request.getContextPath()%>/page/policyService.jsp';
  				  		}
					});
  				}else if(data.code == "1121" || data.code == "1123"){
					$('#taxType').val('');
					$('#crsInfo').modal('show');
  				}else{
					modal_alert({content:data.contenct,btn:'确定'}); 
				}
  			},
			error : function(XMLHttpRequest, textStatus, errorThrown){
				alert(errorThrown);
			}
  		});
		modal_loading();
	}
  	
  	
  	
	function downloadMedia(media_id,type){
  		var CardNo = $("#CardNo").val();
  		var partyCode = $("#partyCode").val();
  		$.ajax({
  			type : "post",
  			url :'<%=path %>/action/downloadMedia',
  			dataType : "json",
  			async : false,
  			data : {
  				"partyCode" : partyCode,
  				"type" : type,
  				"CardNo" : CardNo,
  				"media_id" : media_id
  			},
  			success : function(data) {
  			}
  		});
	}
	function trial(){
		window.scrollTo(0, document.body.scrollTop + 1);
		document.body.scrollTop >= 1 && window.scrollTo(0, document.body.scrollTop - 1);
	}
</script>
</html>
