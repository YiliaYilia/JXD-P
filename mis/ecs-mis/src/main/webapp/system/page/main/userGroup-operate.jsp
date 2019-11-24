<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户组管理</title>
</head>
<body>
	
	<form  name="addUserGroupForm" id="addUserGroupForm" autocomplete="off" data-validator-option="{theme: 'yellow_right',timely:1}">
		<div class="roleItem">
			用户组名称:
			<label>${group.usergroupname }</label>
		  	<input value="${group.usergroupname }"  <c:if test="${group.usergroupid != null }">type="hidden"</c:if> 
		  		<c:if test="${group.usergroupid == null }">type="text"</c:if> name="geGroup.usergroupname" id="usergroupname" maxlength="100">
		</div>																																		                        
		<div class="roleItem">
			用户组描述:
		  	<input type="text" value="${group.usergroupdesc }" name="geGroup.usergroupdesc" id="usergroupdesc" maxlength="100" data-rule="filter(<>^%&$*@#!);">
		</div>
		<input type="hidden" name="operate" id="operate" value="${opeartype }">
		<c:if test="${group.usergroupid != null }">
			<input type="hidden" value="${group.usergroupid }" name="geGroup.usergroupid" id="usergroupid">
		</c:if>
		<div class="roleItem">
			<table border="0">
				<tr>
					<td>未关联的角色</td>
					<td></td>
					<td>已关联的角色</td>
				</tr>
				<tr>
					<td width="180,50,160">
						<select multiple="multiple" style="width: 180px; height: 150px;" id="allRole">
							<c:forEach items="${roles }" var="role">
								<option value="${role.roleid }">${role.rolename }</option>
							</c:forEach>
						</select>
					</td>
					<td align="center">
						<div><img alt="添加" onclick="ugp.addRole();" src="${ctx }/system/images/arrow_right.png" style="cursor: pointer;width: 20px;"></div>
						<div><img alt="移除" onclick="ugp.removeRole();" src="${ctx }/system/images/arrow_left.png" style="cursor: pointer;width: 20px;"></div>
					</td>
					<td>
						<select multiple="multiple" name="role.roleid"  style="width: 180px; height: 150px;" id="ownRole">
						
							<c:forEach items="${owerRoles }" var="owerRole">
								<option value="${owerRole.roleid }">${owerRole.rolename }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
			</table>
		</div>
		<div style="text-align: center;" class="roleItem">
		    <a  class="easyui-linkbutton" data-options="iconCls:'icon-save'"  onclick="$('#addUserGroupForm').submit();">保存</a>
		    <a  class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="ugp.closeNoReload();">离开</a>  
		</div>
	</form>
	<!-- 为什么在这写js代码：因为easyui加载的时候如果js放到head上面，easyui是加载不到的，只加载body内容 -->
	<script type="text/javascript">
		$(document).ready(function(){
			ugp.formValidate();
		});
		
		$('#addUserGroupForm').on('valid.form', function(){
			ugp.addUpdateUserGroup();
			return false;
		}).on('invalid.form', function(){
			return false;
		}); 
	</script>
</body>
</html>