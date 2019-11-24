<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
}

.STYLE3 {
	color: #528311;
	font-size: 12px;
}

.STYLE4 {
	color: #42870a;
	font-size: 12px;
}
-->

</style>

<script type="text/javascript">
$(document).ready(function(){ 
    $("body").keydown(function(e){ 
        var curKey = e.which; 
        if(curKey == 13){ 
        	document.loginForm.submit();
            return false; 
        } 
    }); 
}); 

</script>



</head>

<body>
<c:if test="${param.error=='timeout' }" >
	<script type="text/javascript">
		window.top.location.href="${ctx}/system/page/login.jsp";//获取顶级窗口
	</script>
</c:if>
<form action="${ctx}/ECSUserLogin" name="loginForm">
<table width="100%" height="100%" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<td bgcolor="#e5f6cf">&nbsp;</td>
	</tr>
	<tr>
		<td height="608" background="${ctx}/system/images/login_03.gif">
		<table width="862" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="266" background="${ctx}/system/images/login_04.gif">&nbsp;</td>
			</tr>
			<tr>
				<td height="95">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="424" height="95"
							style="background-image: url('${ctx}/system/images/login_06.gif');">&nbsp;</td>
						<td width="183"
							style="background-image: url('${ctx}/system/images/login_07.gif'); background-repeat: no-repeat;">

						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="21%" height="30">
								<div align="center"><span class="STYLE3">用户</span></div>
								</td>
								<td width="79%" height="30"><input type="text"
									name="username"
									style="height: 25px; width: 130px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;line-height: 25px"></td>
							</tr>
							<tr>
								<td height="30">
								<div align="center"><span class="STYLE3">密码</span></div>
								</td>
								<td height="30"><input type="password" name="password"
									style="height: 25px; width: 130px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;line-height: 25px"></td>
							</tr>
							<tr>
								<td height="30">&nbsp;</td>
								<td height="30"><img src="${ctx}/system/images/dl.gif" width="81"
									height="22" border="0" usemap="#Map"></td>
							</tr>
						</table>

						</td>
						<td width="255" background="${ctx}/system/images/login_08.gif">&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td height="247" valign="top" background="${ctx}/system/images/login_09.gif">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="22%" height="30">&nbsp;</td>
						<td width="56%" align="center">
						<c:if test="${param.error=='yes' }" >
							<span style="margin-left: 170px;font-size: 12px;color: red;">*用户名或密码错误,请重新输入</span>
						</c:if>
						</td>
						<td width="22%">&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td height="30">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="44%" height="20">&nbsp;</td>
								<td width="56%" class="STYLE4">中科软ECS后台管理平台 版本 V5.0</td>
							</tr>
						</table>
						</td>
						<td>&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td bgcolor="#a2d962">&nbsp;</td>
	</tr>
</table>
</form>
<map name="Map">
	<area shape="rect" coords="3,3,36,19" onclick="document.loginForm.submit();">
	<area shape="rect" coords="40,3,78,18"
		onclick="document.loginForm.reset();">
</map>
</body>
</html>