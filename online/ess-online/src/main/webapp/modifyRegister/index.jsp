<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>注册</title>
</head>
<body>
<form action="modifyRegister.do" id="frm" name="frm" method="post">
	用户名：<input type="text" id="userName" name="userName" onblur="checkUserName()"/><br/>
	密码：<input type="text" id="password" name="password"/><br/>
	电子邮箱：<input type="text" id="email" name="email"/><br/>
	手机号码：<input type="text" id="mobile" name="mobile"/><br/>
	真实姓名：<input type="text" id="realName" name="realName"/><br/>
	证件类型：<select id="certType" name="certType">
		  	<option value="1">身份证</option>
		  </select><br/>
	证件号码：<input type="text" id="certId" name="certId"/><br/>
	性别：<select id="gender" name="gender">
		  	<option value="1">男</option>
		  	<option value="2">女</option>
		  </select><br/>
	生日：<input type="text" id="birth" name="birth"/><br/>
	固定电话：<input type="text" id="telephone" name="telephone"/><br/>
	职业：<input type="text" id="job" name="job"/><br/>
	收入状况：<input type="text" id="income" name="income"/><br/>
	所在城市：<input type="text" id="city" name="city"/><br/>
	<input type="hidden" id="userType" name="userType" value="个人"/>
	<input type="hidden" id="channel" name="channel" value="电商平台登陆渠道"/>
	<input type="button" id="btn" name="btn" value="登录" onclick="doSubmit();"/>
</form>
</body>
<script type="text/javascript">
function checkUserName(){
	var userName = document.getElementById("userName").value;
	var userType = document.getElementById("userType").value;
	var channel = document.getElementById("channel").value;
	$.ajax({
		type: "POST",
		dataType:"text",
		url: "checkUserName.do",
		data: "userName="+userName+"&"+"userType="+userType+"&"+"channel="+channel,
		success: function(data){
			var data = Number(data);
			if(data=="success"){
				return true;
			}
			if(data=="failed"){
				alert("该用户名不可使用");
				return false;
			}
		}
	});
}
function checkAll(){
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	var email = document.getElementById("email").value;
	var certId = document.getElementById("certId").value;
	var birth = document.getElementById("birth").value;
	if(userName==""||userName.length==0){
		alert("用户名不能为空！");
		return false;
	}
	if(password==""||password.length==0){
		alert("密码不能为空！");
		return false;
	}
	if(email==""||email.length==0){
		alert("电子邮箱不能为空！");
		return false;
	}
	if(certId==""||certId.length==0){
		alert("证件号码不能为空！");
		return false;
	}
	if(birth==""||birth.length==0){
		alert("生日不能为空！");
		return false;
	}
	return true;
}
function doSubmit(){
	if(!checkAll()){
		return false;
	}
	if(!checkUserName()){
		return false;
	}
	document.getElementById("frm").submit();
}

</script>
</html>