<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
</head>
<body>
	<%
	String userId = request.getParameter("userId");
	String userName = request.getParameter("userName");
	String signature = request.getParameter("signature");
	
	response.sendRedirect(request.getContextPath()+"/icbc/investmentlinked/sessionSynchronizedBack?userId="+userId+"&userName="+userName+"&signature="+signature); 
	%>
</body>
</html>