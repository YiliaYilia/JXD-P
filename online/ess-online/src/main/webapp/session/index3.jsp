<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="cn.com.sinosoft.ess.protal.payment.CryptoUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String channel = "1";
String retURL="http://84.238.160.246:8080/online/session/domo.jsp";
String signature = channel+retURL+"70D1E461A79DEF2F08C77EED95AFC5C6";
signature=CryptoUtil.MD5(signature);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

<a href="http://84.238.160.46:8080/icbc/esrv/eservice/RegServlet?channel=1&retURL=<%=retURL %>&signature=<%=signature %>">註冊</a>

</body>
</html>