<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>登录</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/icbc/investmentlinked/login" id="frm" name="frm" method="post">
	用户名：<input type="text" id="userName" name="userName"/><br/>
	密码：<input type="text" id="password" name="password"/><br/>
	<input type="hidden" id="userType" name="userType" value="个人"/>
	<input type="hidden" id="channel" name="channel" value="电商平台登陆渠道"/>
	<input type="button" id="btn" name="btn" value="登录" onclick="doSubmit();"/>
</form>
</body>
<script type="text/javascript">
function checkAll(){
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	if(userName==""||userName.length==0){
		alert("用户名不能为空！");
		return false;
	}
	if(password==""||password.length==0){
		alert("密码不能为空！");
		return false;
	}
	return true;
}
function doSubmit(){
	if(!checkAll()){
		return false;
	}
	document.getElementById("frm").submit();
}

</script>
</html>