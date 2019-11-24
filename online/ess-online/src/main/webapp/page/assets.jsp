<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String keylist = "";

/**
HashMap<String,String>[] investments = new HashMap[1];
investments[0] = new HashMap();
investments[0].put("rate","100");
investments[0].put("value","123123.00");
investments[0].put("investmentName","成长型投资账户");

**/
HashMap<String,String>[] investments = (HashMap[])request.getAttribute("investments");
for(HashMap<String,String> investment:investments){
	if(investment.get("rate") != "" && investment.get("rate") != null && investment.get("rate").endsWith("%")){
		String[] temp = investment.get("rate").split("[.]");
		investment.put("rate", temp[0]+"%");
	}
}

%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>投资账户资产转移</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link href="../global/css/common/main.min.css?${random}" rel="stylesheet"/>	
    <link rel="stylesheet" href="../global/css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="../global/css/all.css" type="text/css"></link>
    <link rel="stylesheet" href="../global/css/fillInfo.css" type="text/css"></link>
    <link rel="stylesheet" href="../global/css/font-size-screen.css" />
    <script type="text/javascript" src="../global/lib/jquery/jquery-2.1.3.min.js"></script>
  	<script type="text/javascript" src="../global/js/common.js"></script>
  	<script src="../global/lib/common/main.js?${random}"></script>	
	<script src="../global/lib/component/modal.js"></script>
  	<!-- init page scale-->
  	<meta name="viewport" content="width=device-width, target-densitydpi=240,initial-scale=0.667, minimum-scale=0.667, maximum-scale=0.667, user-scalable=0" id="viewport">
  	<meta name="format-detection" content="telephone=no"/>
<style>
	.txt0{font-size: 1.5em;}
	.txt1{font-size: 1.3em;}
	.txt2{font-size: 1.0em;}
	.txt3{font-size: 0.9em;}
	.txt4{font-size: 0.8em;}
	.txt5{font-size: 0.7em;}
	

	@media only screen and (max-width: 960px) {
		.txt0{font-size: 1.4em;}
		.txt1{font-size: 1.2em;}
		.txt2{font-size: 0.9em;}
		.txt3{font-size: 0.7em;}
		.txt4{font-size: 0.7em;}
		.txt5{font-size: 0.6em;}
	}

	@media only screen and (max-width: 640px) {
		.txt0{font-size: 1.2em;}
		.txt1{font-size:1.0em;}
		.txt2{font-size: 0.8em;}
		.txt3{font-size: 0.6em;}
		.txt4{font-size: 0.6em;}
		.txt5{font-size: 0.5em;}
	}

	@media only screen and (max-width: 480px) {
		.txt0{font-size: 1.2em;}
		.title1{font-size: 1.0em;}
		.txt2{font-size: 0.7em;}
		.txt3{font-size: 0.5em;}
		.txt4{font-size: 0.5em;}
		.txt5{font-size: 0.4em;}
	}
	.fillTable tbody tr td{line-height: 70px;}

</style>

<link rel="stylesheet" type="text/css" href="../uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="../uinew/css/style-font.css">

  </head>

<style>
	
.insurance-tl {
    font-size: 0.9em;
}
.insurance-content li {
    background: none;
		padding-top: 0;
}
.insurance-text ul li.wenzi {
    width: 100%;
    padding-left: 0;
}
.grace-form {
    border-left: 0;
    border-right: 0;
    font-size:0.85em;
}
.insurance-text {
    width: 90%;
}
.grace-form .pull-left {
    width: 28%;
}
.grace-form .pull-right {
    width: 72%;
}
.insurance-text ul {
    padding-top: 10px;
}
.insurance-icon {
    margin-top: 24px;
}
.insurance-list {
    margin-top: 30px;
    margin-bottom: 30px;
}

	</style>
<body class="gray" style="font-size:18px;">
  <div class="grace-head"> </div>
           <h2 style="margin-top:60px; text-align:center; color:#c8a154; font-size:2em; font-weight:bold;">投资账户资产转移 </h2>
  	
  	<div class="panel-collapse collapse in cardcontent " style="font-size: 1.5em;">
  		
  		<div class="insurance-list"> 
    <div class="insurance-tl">投资比例</div>
    <ul class="insurance-content"> 
			    		<% for(HashMap hashmap:investments){
		    				if("0.00".equals(hashmap.get("value"))){
		    					continue;
		    				}else{
		    			%>
      <li> 
        <div class="insurance-icon"></div>
        <div class="insurance-text"> 
          <ul> 
             <li class="wenzi"> 
             <ul class="grace-form"> 
              <li > <div class="pull-left">账户名称 </div> <div class="pull-right text-right"><%=hashmap.get("investmentName") %></div></li>
              <li > <div class="pull-left">账户价值 </div> <div class="pull-right text-right"><%=hashmap.get("value") %></div></li>
             	<li > <div class="pull-left">分配比例 </div> <div class="pull-right text-right"><%=hashmap.get("rate") %></div></li>
             
            </ul>  
             </li>
          </ul>
        </div>
      </li>
		    			<% }}%>
    </ul>
  </div>
  
    <div class="insurance-tl">投资账户</div>
    <ul class="insurance-content"> 
    	
    	
	    <c:forEach var="accountVO" items="${accountVOs}"  varStatus="this_status">			
	    <li> 
        <div class="insurance-icon"></div>
        <div class="insurance-text"> 
          <ul> 
             <li class="wenzi"> 
             <ul class="grace-form"> 
              <li > <div class="pull-left" style="width:50%">${accountVO.ivmtAcctName} </div> 
              	<div class="pull-right text-right"  style="width:50%">
              		<input style="width:85%;text-align:center;font-size: 0.9em;" placeholder="请输入分配比例" class="txt0" type="text" id="${accountVO.ivmtAcctCode}" name="${accountVO.ivmtAcctCode}" value=""/>%
	    				
              		</div></li>
             </ul>  
             </li>
          </ul>
        </div>
      </li>
      <c:set var="tempStr" value="${accountVO.ivmtAcctCode}"/>
	    <%keylist = keylist +pageContext.getAttribute("tempStr")+"&";%>
			</c:forEach>
      
    </ul>
  </div>
  <br >
  <div class="tipDiv" style="width:100%;  padding-left: 5%;border-bottom:0;height:auto">
	    		<div class="txt1" style="width:15%;float:left;font-size:1.2em">注：</div>
	    		<div  class="txt1"  style="width:85%;float:left;height:auto	">					
						<li style="list-style: inherit;">请输入各账户的分配比例，各账户比例之和应为100%</li>
						<li style="list-style: inherit;">根据人民银行反洗钱相关规定，如您的保单保费≥20万元，且投保人、被保险人及受益人未在我司留存身份证件有效期，请您先在微信“证件有效期变更”中补齐相关信息后再提交投资账户资产转移申请，如需帮助请致电客服专线：4008109339，谢谢！</li>
				</div>
				<div class="clear"></div>
	    	</div>
				
  
            <ul class="btn-last" style="width:100%;padding: 5px;"> 
            <li  style="width: 100%;padding: 10px;font-size: 1.5em;" id="submitBtn" 
            	onclick="dosubmit()">
						提交
						</li>
            </ul> 
            
            </div>
<style>
	
	.modal-dialog.alert .modal-header{
	font-size: 2em;
	}
	.modal-dialog.alert .modal-content {
    font-size: 1.3em;
}
.modal-dialog.alert .modal-btn{
	font-size: 2em;
    background: #E8C26D;
	}
	
	</style>            
    
        <!--弹出框 -->
    <div class="modal fade" data-rule="alert" id="modal_alert">
		<div class="modal-dialog alert">
			<div class="modal-header clearfix"><span data-title="modal">提示信息</span><a type="button" class="close" data-dismiss="modal"></a></div>
			<div class="modal-content" data-content="modal"></div>
			<div class="modal-footer">
				<a class="modal-btn btn" data-dismiss="modal" data-btn="modal">确定</a>
			</div>
		</div>
	</div>
	
  </body>
  <script type="text/javascript">
  $(document).ready(function(){
	    <c:if test="${Contenct!=null}">
	    modal_alert({content:'${Contenct}',btn:'确定'});
		</c:if>
	});	 
  
	function dosubmit(){
		var sum = 0;
		<c:forEach var="accountVO" items="${accountVOs}"  varStatus="this_status">
		var temp = $("#${accountVO.ivmtAcctCode}").val() != ''?parseInt($("#${accountVO.ivmtAcctCode}").val()):0;
		sum += temp;
		var a${accountVO.ivmtAcctCode} = $("#${accountVO.ivmtAcctCode}").val();
		</c:forEach>
		if(sum!=100){
			modal_alert("请输入各账户的分配比例，各账户比例之和应为100%");
			return;
		} 
  		$.ajax({
  			url :'<%=path %>/action/changeinvestmentAccount',
  			dataType : "json",
  			async : false,
  			data : {
  				<c:forEach var="accountVO" items="${accountVOs}"  varStatus="this_status">
  				"${accountVO.ivmtAcctCode}" : a${accountVO.ivmtAcctCode},
  				</c:forEach>
  				"productName":"${productName}",
  				"policyNum" : "${policyNum}",
  				"productCode" : "${productCode}",
  				"keylist" : "<%=keylist%>",
  				"sessionId" : "${sessionId}"
  			},
  			success : function(data) {
				modal_alert({content:data.Contenct,btn:'确定'}); 
  			}
  		});
	}
	

  </script>
</html>
