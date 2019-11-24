<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<script type="text/javascript" src="${ctx }/system/js/organ/organTreeConvert.js"></script>
<script type="text/javascript" src="${ctx }/system/js/userManage/userGrid.js"></script>
<dict:script typeCode="SEX,USERSTATUS,USERTYPE"></dict:script>
</head>
<body>
	<form name="userManageForm" id="userManageForm" autocomplete="off" data-validator-option="{theme: 'blue',timely:1}">
		<input type="hidden" name="operate" id="operate" value="${opeartype }">
		<input type="hidden" name="geUser.operatorname" id="operatorname" value="${user.geUser.username }">
		<c:if test="${userData.userid != null }">
			<input type="hidden" value="${userData.userid }" name="geUser.userid" id="userid">
		</c:if>
		<div id="user_operate" class="easyui-tabs" data-options="border:false,plain:true" style="width:420px;height:320px;"> 
			<div title="基本信息" style="overflow:hidden;" data-options="singleSelect:true"> 
			<table style="margin-top: 10px;">
				<tr>
					<td class="tabLeft">用户名：</td>
					<td>
						<c:if test="${userData.userid != null }">
							${userData.username }
							<input type="hidden" value="${userData.username }" id="username" name="geUser.username">
							<span style="margin-left:20px;color:red;cursor: pointer;" onclick="canclerepwd();" id="canclerepwd">取消修改密码</span>
						</c:if>
						<c:if test="${userData.userid == null }">
							<input type="text" id="username" name="geUser.username">
						</c:if>
					</td>
				</tr>
				<tr id="repwdbtn" style="display: none;">
					<td class="tabLeft">密 码：</td>
					<td><span style="color:red;cursor: pointer;" onclick="repwdclick();" id="repwdbtn">修改密码</span></td>
				</tr>
				<tr id="pwdinput">
					<td class="tabLeft">密 码：</td>
					<td><input type="text" id="password" name="geUser.password"></td>
				</tr>
				<tr id="againpwdinput">
					<td class="tabLeft">确认密码：</td>
					<td><input type="text" id="againpwd" name="againpwd"></td>
				</tr>
				<tr>
					<td class="tabLeft">性别：</td>
					<td>
					<c:if test="${userData.sex == null }">
						<dict:radio typeCode="SEX" type="radio" name="geUser.sex" defaultValue="M"></dict:radio>
					</c:if>
					<c:if test="${userData.sex != null }">
						<dict:radio typeCode="SEX" type="radio" name="geUser.sex" defaultValue="${userData.sex }"></dict:radio>
					</c:if>
					</td>
				</tr>
				<tr>
					<td class="tabLeft">电子邮箱：</td>
					<td><input type="text" value="${userData.email }" id="email" name="geUser.email"></td>
				</tr>
				<tr>
					<td class="tabLeft">电话：</td>
					<td><input type="text" value="${userData.phone }" id="phone" name="geUser.phone"></td>
				</tr>
				<tr>
					<td class="tabLeft">用户状态：</td>
					<td>
						<c:if test="${userData.state == null }">
							<dict:radio typeCode="USERSTATUS" type="radio" name="geUser.state" defaultValue="1"></dict:radio>
						</c:if>
						<c:if test="${userData.state != null }">
							<dict:radio typeCode="USERSTATUS" type="radio" name="geUser.state" defaultValue="${userData.state }"></dict:radio>
						</c:if>
					</td>
				</tr>
				<tr>
					<td class="tabLeft">用户类型：</td>
					<td>
						<c:if test="${userData.usertype == null }">
							<dict:select typeCode="USERTYPE" style="width: 155px;" defaultValue="user" name="geUser.usertype" id="usertype"></dict:select>
						</c:if>
						<c:if test="${userData.usertype != null }">
							<dict:select typeCode="USERTYPE" style="width: 155px;" defaultValue="${userData.usertype }" name="geUser.usertype" id="usertype"></dict:select>
						</c:if>
					</td>
				</tr>
			</table>
			</div>
			<div title="关联角色" style="">
				<table border="0">
					<tr>
						<td>未分配的角色</td>
						<td></td>
						<td>已拥有角色</td>
					</tr>
					<tr>
						<td width="160,50,160">
							<select multiple="multiple" style="width: 195px; height: 265px;" id="allRoles">
								<c:forEach items="${roles }" var="role">
									<option value="${role.roleid }">${role.rolename }</option>
								</c:forEach>
							</select>
						</td>
						<td align="center">
							<div><img alt="添加" onclick="userManage.addRole();" src="${ctx }/system/images/arrow_right.png" style="cursor: pointer;width: 20px;"></div>
							<div><img alt="移除" onclick="userManage.removeRole();" src="${ctx }/system/images/arrow_left.png" style="cursor: pointer;width: 20px;"></div>
						</td>
						<td>
							<select multiple="multiple" name="geUsergroup.usergroupid"  style="width: 190px; height: 265px;" id="owerRoles">
								<c:forEach items="${owerRoles }" var="owerRole">
									<option value="${owerRole.roleid }">${owerRole.rolename }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
				</table>
			</div>
			<div title="关联用户组" style="">
				<table border="0">
					<tr>
						<td>未分配的用户组</td>
						<td></td>
						<td>所属用户组</td>
					</tr>
					<tr>
						<td width="160,50,160">
							<select multiple="multiple" style="width: 195px; height: 265px;" id="allUsergroup">
								<c:forEach items="${usergroups }" var="usergroup">
									<option value="${usergroup.usergroupid }">${usergroup.usergroupname }</option>
								</c:forEach>
							</select>
						</td>
						<td align="center">
							<div><img alt="添加" onclick="userManage.addGroup();" src="${ctx }/system/images/arrow_right.png" style="cursor: pointer;width: 20px;"></div>
							<div><img alt="移除" onclick="userManage.removeGroup();" src="${ctx }/system/images/arrow_left.png" style="cursor: pointer;width: 20px;"></div>
						</td>
						<td>
							<select multiple="multiple" name="geUsergroup.usergroupid"  style="width: 190px; height: 265px;" id="owerUsergroups">
								<c:forEach items="${owerUsergroups }" var="owerUsergroup">
									<option value="${owerUsergroup.usergroupid }">${owerUsergroup.usergroupname }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
				</table>
			</div>
			<div title="所属机构" style="background-color:white" data-options="href:'../system/page/main/user-organ.jsp'">
				<input type="hidden" id="isOpenDep" value="0" >
			</div>
		</div>
		<div style="padding-left: 80px;padding-top: 10px;" class="userDataItem">
			<c:if test="${opeartype != 'VIEW'}">
				 <a class="easyui-linkbutton" data-options="iconCls:'icon-save'"  onclick="$('#userManageForm').submit();">保存</a>
		         <a class="easyui-linkbutton" data-options="iconCls:'icon-reload'"  onclick="$('#userManageForm').form('reset');">重置</a>
			</c:if>
		   
		    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#operate_window').window('close');">关闭</a>  
		</div>
	</form>
	<script type="text/javascript">
		$(function(){
			userManage.formValidate();
			if($('#operate').val() == 'update'){
				userManage.opPwdInput('hide');
			}
		});
		
		function repwdclick() {
			userManage.opPwdInput();
		}
		function canclerepwd() {
			userManage.opPwdInput('hide');
		}
	</script>
</body>
</html>