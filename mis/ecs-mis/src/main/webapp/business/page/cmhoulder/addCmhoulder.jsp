<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${ctx }/business/addCmhoulder">
<table>
	<tr>
		<td>姓名</td>
		<td><input type="text" name="managerLoginInfo.managerName"></td>
	</tr>
	<tr>
		<td>邮箱(用户名)</td>
		<td><input type="text" name="managerLoginInfo.managerLoginName"></td>
	</tr>
	<tr>
		<td>密码</td>
		<td><input type="text" name="managerLoginInfo.password"><input type="button" value="生成密码"></td>
	</tr>
	<tr>
		<td>手机号码</td>
		<td><input type="text" name="managerLoginDetail.moblie"></td>
	</tr>
	<tr>
		<td>部门</td>
		<td></td>
	</tr>
	<tr>
		<td>所属机构</td>
		<td>
		<select>
			<c:forEach items="${cmhoulderBranch }" var="cmhoulder">
				<option name="cmhoulderBranch.cmhdBranchName" value="${cmhoulder.cmhdBranchName }">${cmhoulder.cmhdBranchName }</option>
			</c:forEach>
		</select>
			
		</td>
	</tr>
	<tr>
		<td>负责企业机构</td>
		<td>
		<select>
			<c:forEach items="${companyBranch }" var="company">
				<option name="companyBranch.comBranchName" value="${company.comBranchName }">${company.comBranchName}</option></br>
			</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="创建"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="reset" value="重置"></td>
		<td></td>
	</tr>
</table>
</form>
</body>
</html>