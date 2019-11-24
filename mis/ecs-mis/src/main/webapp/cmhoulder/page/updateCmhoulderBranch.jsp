<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${ctx}/company/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript"
	src="${ctx}/company/js/jquery.ztree.all-3.5.js"></script>
	<script type="text/javascript"
	src="${ctx}/cmhoulder/js/updateCmhoulderBranch.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	var ctx="${ctx}";
$().ready(function(){
		createTable();
	});
</script>
</head>
<body>
	<form action="${ctx }/cmhoulder/query" method="post">
	海达经办人账号：<input name="managerLoginInfo.managerLoginName" type="text" id="managerLoginName">
	海达经办人姓名：<input name="managerLoginInfo.managerName" type="text"  id="managerName">
	冻结状态：<select name="managerLoginInfo.status" id="status">
		<option value=""}>全部</option>
		<option value="1" }>未冻结</option>
		<option value="0" }>已冻结</option>
		
	</select> 
	<a href="javascript:createTable()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >查询</a>
	</form>
	<table id="createCmhoulderTable" width="100%"></table>
	<div id="updateLoginInfoAndDetail" style="display:none;">
	<div style="display:none;" id="detail">
	<table>
		<tr>
			<td class="tabLeft">用户名/邮箱</td>
			<td id="email"></td>	
		</tr>
		<tr>
			<td class="tabLeft">姓名</td>
			<td id="name"></td>	
		</tr>
		<tr>
			<td class="tabLeft">手机号码</td>
			<td id="phone"></td>	
		</tr>
		<tr>
			<td class="tabLeft">身份证号码</td>
			<td id="idno"></td>	
		</tr>
		<tr>
			<td class="tabLeft">所属机构</td>
			<td id="branch"></td>	
		</tr>
	</table>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="update_1()">编辑</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="loginFreeze()">冻结账户</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#updateLoginInfoAndDetail').window('close')">关闭</a>
	
	</div>
	<div id="update" style="display:none;">
	<form method="post" id="form">
	<input type="hidden" name="managerLoginInfo.managerId" id="managerId">
	<input type="hidden" name="managerLoginDetail.id" id="mdId">
	<input type="hidden" name="managerCmhoulderBranch.id" id="mcbId">
	<input type="hidden" name="cmhoulderBranch.cmhdBranchId" id="cbId">
	<input type="hidden" name="managerLoginDetail.sex" id="sex"> 
	<table>
		<tr>
			<td class="tabLeft">用户名/邮箱</td>
			<td><input name="managerLoginInfo.managerLoginName" id="managerLoginName1" type="text" disabled="disabled"></td>
		</tr>
		<tr>
			<td class="tabLeft">姓名</td>
			<td><input name="managerLoginDetail.managerName" id="managerName1" type="text" data-rule="姓名:required;managerLoginDetail.managerName"></td>
		</tr>
		<tr>          
			<td class="tabLeft">手机号码</td>
			<td><input name="managerLoginDetail.moblie" id="moblie" type="text" data-rule="手机号码:required;managerLoginDetail.moblie;mobile"></td>
		</tr>
		<tr>
			<td class="tabLeft">身份证号码</td>
			<td><input name="managerLoginDetail.idno" type="text" id="idno1" data-rule="身份证号码:required;managerLoginDetail.idno;ID_card"></td>
		</tr>
		<tr>
			<td class="tabLeft">所属机构</td>
			<td><input type="text" name="cmhoulderBranch.cmhdBranchName"
					id="cmhdBranchName" disabled="disabled"></td>
				<td><a href="#" class="easyui-linkbutton"
					data-options="plain:true" onclick="selectCmhoulderTree()">选择</a></td>
		</tr>
		</table>
		</form>
		<div id="cmhoulderTree" style="display:none">
			<div id="tree" class="ztree"></div>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="sureCmhoulder()">确定</a><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#cmhoulderTree').window('close')">关闭</a>
		</div>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="back()">返回</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="update()">修改</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-undo'" onclick="reset()">重置</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#updateLoginInfoAndDetail').window('close')">关闭</a>
	</div>
	</div>
</body>
</html>
