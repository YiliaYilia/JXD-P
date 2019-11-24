<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="cn.com.sinosoft.core.utils.PropertityUtil"%>
<%@ page import="cn.com.sinosoft.ess.protal.payment.CryptoUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String userId = (String)request.getSession().getAttribute("userId");
if(userId==null||"".equals(userId)){
	userId="";
}else{
	userId = CryptoUtil.TripleDesEncode(userId);
}
String channeldes = CryptoUtil.TripleDesEncode("1");
PropertityUtil.init("config/pwd.properties");
String refreshSessionUrl = PropertityUtil.get("refreshSessionUrl");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<iframe id="frmsession_include" name="frmsession_include" src="" style="display:none;" marginwidth="0" marginheight="0" frameborder="0" scrolling="no" width="0" height="0">						
</iframe>
<form id="frmsession_include_form" action="<%=refreshSessionUrl%>" name="frmsession_include_form" method="post" target="frmsession_include" style="display:none;">
	<input type="hidden" id="userId" name="userId" value="<%=userId%>"/>
	<input type="hidden" id="channel" name="channel" value="<%=channeldes%>"/>
</form>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/icbc/investmentlinked/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#frmsession_include_form").submit();
});
</script>
</html>