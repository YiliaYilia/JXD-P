<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
</head>
<body>
	
	<form  name="addUpdateRoleForm" id="addUpdateRoleForm" autocomplete="off">
		<div>
			<fieldset>
				<legend><strong>角色信息:</strong></legend>
				<c:if test="${role.roleid != null }">
					<input type="hidden" value="${role.roleid }" name="geRole.roleid" id="roleid">
				</c:if>
				<div class="roleItem">
					角色名称:
					<c:if test="${role.roleid != null }">
					<span>${role.rolename }</span>
				  	</c:if>
				  	<c:if test="${role.roleid == null }">
				  	<input type="text" value="${role.rolename }" name="geRole.rolename" id="rolename" maxlength="100">
				  	</c:if>
				</div>
				<div class="roleItem">
					角色描述:
				  	<input type="text" value="${role.roledesc }" name="geRole.roledesc" id="roledesc" maxlength="100" data-rule="filter(<>^%&$*@#!);">
			</div>
		</fieldset>
		</div>
		<div class="roleItem">
			<fieldset>
				<legend><strong>权限信息:</strong></legend>
			<table border="0">
				<tr>
					<td>未拥有的权限</td>
					<td></td>
					<td>拥有的权限</td>
				</tr>
				<tr>
					<td width="160,50,160">
						<select multiple="multiple" style="width: 160px; height: 150px;" id="allPermission">
							<c:forEach items="${permissions }" var="permission">
								<option value="${permission.permissionid }">${permission.permissionname }</option>
							</c:forEach>
						</select>
					</td>
					<td align="center">
						<div><img alt="添加" onclick="role.addPermission();" src="${ctx }/system/images/arrow_right.png" style="cursor: pointer;width: 20px;"></div>
						<div><img alt="移除" onclick="role.removePermission();" src="${ctx }/system/images/arrow_left.png" style="cursor: pointer;width: 20px;"></div>
					</td>
					<td>
						<select multiple="multiple" name="gePermission.permissionid"  style="width: 160px; height: 150px;" id="ownPermission">
						
							<c:forEach items="${owerPermissions }" var="owerpermission">
								<option value="${owerpermission.permissionid }">${owerpermission.permissionname }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
			</table>
			</fieldset>
		</div>
		<div style="text-align: center;" class="roleItem">
		    <a  class="easyui-linkbutton" data-options="iconCls:'icon-save'"  onclick="$('#addUpdateRoleForm').submit();">保存</a>
		    <a  class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#role_addUpdate_window').window('close');">离开</a>  
		</div>
		<input type="hidden" name="operate" id="operate" value="${opeartype }">
	</form>
	<!-- 为什么在这写js代码：因为easyui加载的时候如果js放到head上面，easyui是加载不到的，只加载body内容 
	<script type="text/javascript">
		$('#addUpdateRoleForm').on('valid.form', function(){
			role.addUpdateRole();
			return false;
		}).on('invalid.form', function(){
			return false;
		}); 
	</script>-->
	<script type="text/javascript">
		var role = new Role();
		role.ctx = '${ctx}';
		$(document).ready(function(){
			role.formValidate();
		});
	</script>
</body>
</html>