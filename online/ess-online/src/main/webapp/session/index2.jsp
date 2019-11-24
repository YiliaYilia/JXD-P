<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="cn.com.sinosoft.ess.protal.payment.CryptoUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String userId = (String)request.getSession().getAttribute("userId");
userId="24109";
String userName="";
String userType="1";
String channel = "1";
String signature = userId+userName+userType+channel+"70D1E461A79DEF2F08C77EED95AFC5C6";
signature=CryptoUtil.MD5(signature);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title></title>
</head>
<body>

<form action="http://84.238.29.87:8080/icbc/esrv/eservice/ViewPersonalInfoServlet"  id="frm" name="frm" method="post">
	<input type="hidden" id="userId" name="userId" value="<%=userId %>"/>
	<input type="hidden" id="userName" name="userName" value=""/>
	<input type="hidden" id="userType" name="userType" value="1"/>
	<input type="hidden" id="channel" name="channel" value="1"/>
	
	<input type="hidden" id="signature" name="signature" value="<%=signature %>"/>
</form>

</body>
<script type="text/javascript">
function doSubmit(){
	document.getElementById("frm").submit();
}
doSubmit();
</script>
</html>