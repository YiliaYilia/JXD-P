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
    
    <title>用户绑定</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="global/css/mobile.css">
	<script type="text/javascript" src="global/js/jquery/1.9.0/jquery.min.js"></script>
	 <meta name="viewport" content="width=device-width, initial-scale=0.667, minimum-scale=0.667, maximum-scale=0.667, user-scalable=0" id="viewport">
  	 <meta name="format-detection" content="telephone=no"/>
  </head>
  <body>
    	<div class="content">
    	<form action="<%=path %>/action/clientBind" name="reForm" id="reForm" method="post">
    		<input type="hidden" id="OpenID" name="OpenID" value="${OpenID}">
    		<img class="logo_t" src="global/images/logo_t.png" />
    		<div class="input">
    			<div class="w_type">证件类型</div>
    			<div class="sel_wrap">
    				<label>身份证</label>
	    			<select class="select"name="idType" id="idType">
						<option value="ID_CARD">身份证</option>
						<option value="MOC">军官证</option>
						<option value="SOLDIERS">士兵证</option>
						<option value="PASSPORT">护照</option>
						<option value="DRIVING_LICENSE">驾照</option>
						<option value="CTC">台胞证</option>
						<option value="HKMTP">港澳通行证</option>
						<option value="MID">返乡证</option>						
						<option value="HHR">户口本</option>
						<option value="BC">出生证</option>						
						<option value="BIRTHCERT">出生日期</option>
						<option value="OTHERS">其他</option>
						
	    			</select>
    			</div>
    			<div class="clear"></div>
   			</div>
   			<div class="input">
		    			<div class="w_type">证件号码</div>
		    			<input class="input_text" type="text" maxlength="18" name="idNo" id="idNo" value="请输入您的证件号码" onfocus="if(this.value=='请输入您的证件号码'){this.value=''}"
	    				onblur="if(this.value=='请输入您的证件号码'||this.value==''){this.value='请输入您的证件号码'}"/>	
		    			<div class="clear"></div>
	    			</div>
    		<div class="input">
    			<div class="w_type">您的姓名</div>
    			<input class="input_text" type="text" name="clientName" id="clientName" maxlength="10" value="请输入您的真实姓名" onfocus="if(this.value=='请输入您的真实姓名'){this.value=''}"
   				onblur="if(this.value=='请输入您的真实姓名'||this.value==''){this.value='请输入您的真实姓名'}"/>	
    			<div class="clear"></div>
   			</div>
   			<div class="input_btn">
   				<div class="bingding_btn" onclick="dosubmit()">提交绑定</div>
   			</div>
   			</form>
    	</div>
  </body>
  <%@ include file="/page/result.jsp"%>
  <script type="text/javascript">
	$(".sel_wrap").on("change", function() {
        var o;
        var opt = $(this).find('option');
        opt.each(function(i) {
            if (opt[i].selected == true) {
                o = opt[i].innerHTML;
            }
        });
        $(this).find('label').html(o);
    }).trigger('change');
	
	
	function dosubmit(){
		$("#reForm").submit();
	}
</script>
</html>
