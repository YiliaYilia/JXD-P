<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
String articleUrl = "https://testweixin.oldmutual-guodian.com/online"; //测试条款url
// String articleUrl = "https://weixin.oldmutual-guodian.com/onlineApp"; //生产条款url
%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>保单详情</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<!-- <link rel="stylesheet" type="text/css" href="../uinew/css/bootstrap.min.css"> -->
<link rel="stylesheet" type="text/css" href="../uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/style-font.css">
<link href="../global/css/animate/loader-ani.css" rel="stylesheet"/>
<link rel="stylesheet" href="../global/css/common.css" type="text/css"></link>
<link href="../global/css/common/main.min.css?${random}" rel="stylesheet" />
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
	}else{
		document.write('<meta name="viewport" content="width=640, user-scalable=no, target-densitydpi=device-dpi">');
	}
</script>
<meta name="format-detection" content="telephone=no"/>
<style>
.grace-form .pull-left {
	width: 31%;
    text-align: left;
}
.grace-form .text-right {
    width: 69%;
}
.layer{
	width:100%;background: #000000;opacity:0.6;color:#ffffff;position:fixed;z-index:1000;top:0;left:0;font-size:1.25rem;line-height:16rem;text-align:center;display:none;}
.modal-dialog.alert .modal-btn {
	background: #E8C26D;
}
</style>
</head>
<script type="text/javascript">
	var msg="${msg}";
	if(msg!=""){
		alert(msg);
	}
</script>
<body class="gray" style="font-size:18px;">
	<div class="grace-head"></div>
	<h2 style="margin-top:60px; text-align:center; color:#c8a154; font-size:2em; font-weight:bold;">保单详情 </h2>
	<div class="panel-collapse collapse in cardcontent " style="font-size: 1.4em;margin-bottom: 90px;">
		<ul class="grace-form"> 
			<li><div class="pull-left">保险单号 : </div><div class="pull-right text-right">${policyBasic.policyNum}</div></li>
	    	<li><div class="pull-left">险种名称: </div><div class="pull-right text-right">${policyBasic.productName}</div></li>
			<li><div class="pull-left">附加险 : </div><div class="pull-right text-right">${policyBasic.extraProductName[0]}</div></li>
			<c:forEach var="extraProduct" items="${policyBasic.extraProductName}" begin="1">
				<li><div class="pull-left"></div><div class="pull-right text-right">${extraProduct}</div></li>
			</c:forEach>
			<c:if test="${policyBasic.policystatus ne '03'}">
				<li><div class="pull-left">保单生效日期: </div><div class="pull-right text-right">${policyBasic.inceptionDate}</div></li>
			</c:if>
			<c:if test="${policyBasic.policystatus eq '03'}">
				<li><div class="pull-left">保单生效日期: </div><div class="pull-right text-right"></div></li>
			</c:if>
			<li><div class="pull-left">保险期限: </div><div class="pull-right text-right">${policyBasic.term}年</div></li>
			<li><div class="pull-left">保险金额: </div><div class="pull-right text-right">${policyBasic.assured}</div></li>
			<c:if test="${policyBasic.insuranceType eq 'TRADLIFE'}">
				<li><div class="pull-left">缴费银行账户: </div><div class="pull-right text-right">${policyBasic.bankCardID}</div></li>
				<li><div class="pull-left">银行名称: </div><div class="pull-right text-right">${policyBasic.accountBank}</div></li>
			</c:if>
			<c:if test="${policyBasic.payTermYears!='1'&&policyBasic.payTermYears!='0'&&policyBasic.payTermYears!=''}">
				<li><div class="pull-left">缴费期间: </div> 
					<c:choose>
						<c:when test="${policyBasic.payTermYears=='99'||policyBasic.payTermYears=='100'}">
							<div class="pull-right text-right">终身</div>
						</c:when> 
						<c:otherwise>
							<div class="pull-right text-right">${policyBasic.payTermYears}年</div>
						</c:otherwise> 
					</c:choose>
				</li>
			</c:if>
	        <li><div class="pull-left" style="width:35%">投保人姓名: </div><div class="pull-right text-right" style="width:65%;">${policyBasic.polName}</div></li>
	        <li><div class="pull-left">被保险人姓名: </div><div class="pull-right text-right">${policyBasic.assuredName}</div></li>
	        <li><div class="pull-left">营销机构: </div><div class="pull-right text-right">${policyBasic.distributor}</div></li>
	        <li><div class="pull-left">理财顾问: </div><div class="pull-right text-right">${policyBasic.FA}</div></li>
			<c:if test="${policyBasic.insuranceType=='ULINDLIFE'}">
	        	<li name="value" id="value"><div class="pull-left"><a>投资账户总价值: </a></div>
	        	<div class="pull-right text-right"><a>${policyBasic.totalValue}</a></div></li>
			</c:if>
			<c:if test="${policyBasic.insuranceType=='LIFE'}">
				<li name="value" id="value"><div class="pull-left"><a>投资账户总价值: </a></div>
				<div class="pull-right text-right"><a>${policyBasic.totalValue}</a></div></li>
			</c:if>
		</ul>  
        <ul class="btn-last"> 
			<c:if test="${policyBasic.insuranceType=='ULINDLIFE'}">
        		<li style="margin-top: 5px;" href="#" id="coustomerLoginId">投资账户资产转移</li>
			</c:if>
			<c:if test="${!coustomerid.startsWith('C') || coustomerid.length() != 12}">
            	<li style="margin-top: 5px;" onclick="window.location.href='${ctx}/action/getMemberList?policyNo=${policyBasic.policyNum}'">证件有效期变更</li>
			</c:if>
		
			<c:if test="${policyBasic.productCode=='UVRUILI-1' || policyBasic.productCode=='UVRUILI-2' || policyBasic.productCode=='UVRUILI-N'}">
            	<li style="margin-top: 5px;" id="investmentButton">追加投资</li>
			</c:if> 
		
            <li style="margin-top: 5px;" id="coustomerLoginId" onclick="window.location.href='${ctx}/action/getPayDetail?policyNo=${policyBasic.policyNum}'">交易明细</li> 	


<%--			
				<c:if test="${policyBasic.policystatus eq '05' && channel eq 'wechat'|| policyBasic.policystatus eq '15' && channel eq 'wechat'||policyBasic.policystatus eq '19' && channel eq 'wechat' ||policyBasic.policystatus eq '21'&& channel eq 'wechat'||policyBasic.policystatus eq '03' && channel eq 'wechat'}"> 
--%>
			<c:if test="${policyBasic.term > 1}">
				<c:if test="${policyBasic.policystatus eq '05' || policyBasic.policystatus eq '19'||policyBasic.policystatus eq '15'}">
					<li style="margin-top: 5px;"  id="banksubmit">银行账户变更</li>
				</c:if>
			</c:if>
			<c:if test="${policyBasic.term == 1}">
				<c:if test="${policyBasic.policystatus eq '05'}">
					<li style="margin-top: 5px;"  id="banksubmit">银行账户变更</li>
				</c:if>
			</c:if>
			<c:if test="${validate eq 'Y' &&policytime eq 'N'||validate eq 'N'}"> 
				<c:forEach items="${pdfname}" var="pdfname">
					<li id="dzbd" style="margin-top: 5px;" onclick="window.location.href='${ctx}/action/downloadPolicy?pdf=${pdfname.pdfname}&policyNum=${policyBasic.policyNum}&product=${policyBasic.productCode}&policytime=${policytime}&filepath=${filepath}&name=${policyBasic.productName}'">
						${pdfname.pdfnamec}
					</li>
				</c:forEach>
			</c:if>
			<c:if test="${validate eq 'Y' &&policytime eq 'Y'}">
				<li id="dzbd" style="margin-top: 5px;" onclick="window.location.href='${ctx}/action/downloadPolicy?pdf=after20160804policy&policyNum=${policyBasic.policyNum}&product=${policyBasic.productCode}&policytime=${policytime}&filepath=${filepath}&name=${policyBasic.productName}'">
					瑞泰人寿电子保单
				</li>
			</c:if>		   
<%-- 		<c:if test="${policyBasic.productName == null && policyBasic.productName.length()==0}">
      	    	<li style="margin-top: 5px;"  id="xbsubmit">续保</li> 
			</c:if>
<!-- 	</ul>
		<ul class="btn-last"> 
-->
<%-- 		<c:if test="${validate eq 'Y' &&policytime eq 'N'||validate eq 'N'}"> 
				<c:forEach items="${pdfname}" var="pdfname">
					<li style="margin-top: 5px;"  onclick="window.location.href='${ctx}/action/downloadPolicy?pdf=${pdfname.pdfname}&policyNum=${policyBasic.policyNum}&product=${policyBasic.productCode}&policytime=${policytime}&filepath=${filepath}&name=${policyBasic.productName}'">
						${pdfname.pdfnamec}
					 </li>
				</c:forEach>
			</c:if>
			<c:if test="${validate eq 'Y' &&policytime eq 'Y'}">
				<li style="margin-top: 5px;"  onclick="window.location.href='${ctx}/action/downloadPolicy?pdf=after20160804policy&policyNum=${policyBasic.policyNum}&product=${policyBasic.productCode}&policytime=${policytime}&filepath=${filepath}&name=${policyBasic.productName}'">
					瑞泰人寿电子保单
				</li>
			</c:if>  
--%>
<%-- 		<c:if test="${policyBasic.productCode eq 'UVRUILI-1' ||policyBasic.productCode eq 'UVRUILI-N'|| policyBasic.productCode eq 'UVRUILI-2' || policyBasic.productCode eq 'UVZHISNG-2'}">
				<li style="margin-top: 5px;"  onclick="window.location.href='${ctx}/action/downloadPolicy?pdf=Ksecret&policyNum=${policyBasic.policyNum}'">
					客户密函
				</li>
			</c:if> 
--%>
			<c:if test="${policyBasic.productCode eq 'WENAIBAO'}"> 
				<li id="tiaokuan" style="margin-top: 5px;" onclick="window.location.href='<%=articleUrl%>/resources/pdf/wab/wabht.pdf'" >
					主险条款
				</li>
			</c:if> 
			<c:if test="${policyBasic.productCode eq 'WENJIABAO'}"> 
				<li id="tiaokuan" style="margin-top: 5px;" onclick="window.location.href='<%=articleUrl%>/resources/pdf/wjb/wjb_article.pdf'" >
					主险条款
				</li>
			</c:if> 
			<c:if test="${policyBasic.productCode eq 'RUIXANKANG'}"> 
				<li id="tiaokuan" style="margin-top: 5px;" onclick="window.location.href='<%=articleUrl%>/resources/pdf/rxak/rxak_article.pdf'" >
					主险条款
				</li>
			</c:if>
			<c:if test="${policyBasic.productCode eq 'WENJIAXING'}"> 
				<li id="tiaokuan" style="margin-top: 5px;" onclick="window.location.href='<%=request.getContextPath()%>/resources/pdf/tiaokuan/wjx_article.pdf'" >
					主险条款
				</li>
			</c:if> 
			<c:if test="${policyBasic.productCode eq 'UVRUILI-1'}"> 
				<li id="tiaokuan" style="margin-top: 5px;" onclick="window.location.href='<%=request.getContextPath()%>/resources/pdf/tiaokuan/rlyh_article.pdf'" >
					主险条款
				</li>
			</c:if> 
			<c:if test="${policyBasic.productCode eq 'UVRUILI-N'}"> 
				<li id="tiaokuan" style="margin-top: 5px;" onclick="window.location.href='<%=request.getContextPath()%>/resources/pdf/tiaokuan/rlyh_article.pdf'" >
					主险条款
				</li>
			</c:if> 
			<c:if test="${policyBasic.productCode eq 'UVRUILI-2'}"> 
				<li id="tiaokuan" style="margin-top: 5px;" onclick="window.location.href='<%=request.getContextPath()%>/resources/pdf/tiaokuan/wjx_article.pdf'" >
					主险条款
				</li>
			</c:if> 
			<c:if test="${policyBasic.productCode eq 'UVZHISHENG'}"> 
				<li id="tiaokuan" style="margin-top: 5px;" onclick="window.location.href='<%=request.getContextPath()%>/resources/pdf/tiaokuan/zsrsZS_article.pdf'" >
					主险条款
				</li>
			</c:if> 
			<c:if test="${policyBasic.productCode eq 'TAWENKB-R'}"> 
				<li id="tiaokuan" style="margin-top: 5px;" onclick="window.location.href='<%=request.getContextPath()%>/resources/pdf/tiaokuan/wkb_article.pdf'" >
					主险条款
				</li>
			</c:if> 
			<c:if test="${policyBasic.productCode eq 'HEALTHGD'}"> 
				<li id="tiaokuan" style="margin-top: 5px;" onclick="window.location.href='<%=request.getContextPath()%>/resources/pdf/tiaokuan/long_article.pdf'" >
					主险条款
				</li>
			</c:if> 
			<c:if test="${policyBasic.productCode eq 'UVZHISNG-2'}"> 
				<li id="tiaokuan" style="margin-top: 5px;" onclick="window.location.href='<%=request.getContextPath()%>/resources/pdf/tiaokuan/zsrsLQ_article.pdf'" >
					主险条款
				</li>
			</c:if> 
			<c:if test="${policyBasic.productCode eq 'JINGZHIRS'}"> 
				<li id="tiaokuan" style="margin-top: 5px;" onclick="window.location.href='<%=request.getContextPath()%>/resources/pdf/tiaokuan/jzrs_article.pdf'" >
					主险条款
				</li>
			</c:if> 
			<c:if test="${policyBasic.productCode eq 'SLELI-D'}"> 
				<li id="tiaokuan" style="margin-top: 5px;" onclick="window.location.href='<%=request.getContextPath()%>/resources/pdf/tiaokuan/jyzxD_article.pdf'" >
					主险条款
				</li>
			</c:if> 
			<c:if test="${policyBasic.productCode eq 'JINGYINGRS'}"> 
				<li id="tiaokuan" style="margin-top: 5px;" onclick="window.location.href='<%=request.getContextPath()%>/resources/pdf/tiaokuan/jyrs_article.pdf'" >
					主险条款
				</li>
			</c:if> 
			<c:if test="${policyBasic.productCode eq 'LXANKANG'}"> 
				<li id="tiaokuan" style="margin-top: 5px;" onclick="window.location.href='<%=request.getContextPath()%>/resources/pdf/tiaokuan/LXANKANG_article.pdf'" >
					主险条款
				</li>
			</c:if>
        </ul> 
<%-- 	<p style="text-align: center;color: red;font-size: 1rem;">温馨提示：由于电子保单文件较大，打开速度稍慢，请您耐心等候！</p> --%>
        <input type="hidden" id="partyCode" name="partyCode" value="${policyBasic.partyCode}">
	</div>
		<form action="" method="post" id="dovalue" name="dovalue">
			<input type="hidden" id="investment" name="investment">
			<input type="hidden" id="policyNum" name="policyNum" value="${policyBasic.policyNum}">
			<input type="hidden" id="productCode" name="productCode" value="${policyBasic.productCode}">
			<input type="hidden" id="productName" name=productName value="${policyBasic.productName}">
			<input type="hidden" id="coustomerid" name="coustomerid" value="${coustomerid}">
			<!-- 追加投资所用信息 -->
			<input type="hidden" id="applicantName" name="applicantName" value="${policyBasic.polName}">
			<input type="hidden" id="accountBank" name="accountBank" value="${policyBasic.accountBank}">
			<input type="hidden" id="bankCardId" name="bankCardId" value="${policyBasic.bankCardID}">
		</form>
		<form action="<%=request.getContextPath()%>/page/bankInfoChange.jsp" method="post" id="changebank">
			<input type="hidden" id="policyNum" name="policyNum" value="${policyBasic.policyNum}" />
			<input type="hidden" name="polName" value="${policyBasic.polName}" />
			<input type="hidden" name="accountBank" value="${policyBasic.accountBank}" />
			<input type="hidden" name="bankCardID" value="${policyBasic.bankCardID}" />
			<input type="hidden" name="renewalIndicator" value="${policyBasic.renewalIndicator}" />
		</form>
	<div class="layer">温馨提示：由于电子保单文件较大，打开速度稍慢，请您耐心等候！</div>
	<div class="footer" style="position: fixed;"><img src="../uinew/images/bottom-line.jpg" alt="" width="100%"/></div>
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
<%@ include file="/page/result.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
	var hostname = location.hostname;
    if(hostname.startsWith('testweixin')){
		$("#appid").attr("value", "wx618b6902989a293e");
    	$("#urlPrefix").attr("value", "http://testweixin.oldmutual-guodian.com/online/");
	}else if(hostname.startsWith('weixin')){
		$("#appid").attr("value", "wx5be4b58fee2539db");
		$("#urlPrefix").attr("value", "http://weixin.oldmutual-guodian.com/online/");
	}
});
	function hide(){
		$(".layer").hide();
	}
	$(function(){
		var height=$(window).height();
		$(".layer").height(height);
	});
	$("#dzbd").click(function(){
		$(".layer").show();
		setTimeout("hide()",5000 )
	});
  	<c:choose>
		<c:when test="${policyBasic.insuranceType=='LIFE'}">
			$("#value").click(function(){
				window.location.href="${ctx}/action/getUniversal?rate=${policyBasic.rate}&month=${policyBasic.month}&totalValue=${policyBasic.totalValue}"});
		</c:when>
		<c:when test="${policyBasic.insuranceType=='ULINDLIFE'}">
			var investment =
				<c:forEach var="investment" items="${policyBasic.investments}">
					"investmentName=${investment.investmentName}&"+
					"price=${investment.price}&"+
					"priceDate=${investment.priceDate}&"+
					"units=${investment.units},"+
				</c:forEach>"";
			$(document).ready(function(){
				$("#investment").attr("value",investment);
			});
			$("#value").click(function(){
				$("#dovalue").attr("action","${ctx}/action/getInvestment");
				$("#dovalue").submit();
			});
			$("#coustomerLoginId").click(function(){
				var partyCode = $('#partyCode').val();
				$.ajax({
		    		url :'<%=path %>/action/expiredDateCheckByPartyCode',
		    		dataType : "json",
		    		type : "POST",
		    		async : true,
		    		data : {
		    			"partyCode" : partyCode
		    		},
		    		success : function(data) {
		    			if(data.code == "0"){
		    				//资产账户转移
		    				$("#dovalue").attr("action","${ctx}/action/toCoustomerLoginPage");
		    				$("#dovalue").submit();
		    			}else if(data.code == "1"){
		    				//变更证件有效期后再进行资产账户转移
		    				modal_alert({content:data.message,btn:'确定'});
		    				$(".btn").click(function (){
		    					onclickToCertificate('accountAssetTransfer',data.partyCode,'pol',data.partyCode,data.cardNo,data.cardType,data.expiredDate);
		    				});
		    			}else{
		    				modal_alert({content:data.contenct,btn:'确定'});
		    			}
		    		}
		    	});
				modal_loading();
			});
		</c:when>
	</c:choose>
		$("#banksubmit").click(function(){
			var partyCode = $('#partyCode').val();
			$.ajax({
	    		url :'<%=path %>/action/expiredDateCheckByPartyCode',
	    		dataType : "json",
	    		type : "POST",
	    		async : true,
	    		data : {
	    			"partyCode" : partyCode
	    		},
	    		success : function(data) {
	    			if(data.code == "0"){
	    				//变更银行账号
	    				$("#changebank").submit();
	    			}else if(data.code == "1"){
	    				//变更证件有效期后再进行银行账号变更
	    				modal_alert({content:data.message,btn:'确定'});
	    				$(".btn").click(function (){
	    					onclickToCertificate('bankAccountChange',data.partyCode,'pol',data.partyCode,data.cardNo,data.cardType,data.expiredDate);
	    				});
	    			}else{
	    				modal_alert({content:data.contenct,btn:'确定'});
	    			}
	    		}
	    	});
			modal_loading();
		})
		/* $("#xbsubmit").click(function(){
			$("#changebank").submit();
		}) */
		$("#investmentButton").click(function(){
			$("#dovalue").attr("action","${ctx}/action/addInvestment");
			$("#dovalue").submit();
		});
		function onclickToCertificate(conservationFlag,polPartyCode,partyType,partyCode,cardNo,cardType,expiredDate){
			var information;
			if(conservationFlag=='bankAccountChange'){//银行账号变更
				information = $('#changebank input');
			}else if(conservationFlag=='accountAssetTransfer'){//账户资产转移
				information = $('#dovalue input');
			}
			var url = $('#urlPrefix').val() + 'action/certificate?polPartyCode='+polPartyCode +'&partyType='+partyType+'&partyCode='+partyCode
					+'&cardNo='+cardNo+'&cardType='+cardType+'&expiredDate='+expiredDate+'&conservationFlag='+conservationFlag;
			for(var i = 0; i<information.length; i++){
				url = url + '&' + information[i].name + '=' + information[i].value;
			}
			//window.location.href = '<%=path %>/action/certificate?polPartyCode='+polPartyCode +'&partyType='+partyType+'&partyCode='+partyCode
			//	+'&cardNo='+cardNo+'&cardType='+cardType+'&expiredDate='+expiredDate + url;
			window.location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid='+ $('#appid').val()
					+ '&redirect_uri='+encodeURIComponent(url)
					+'&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect';
		}
	</script>
</html>