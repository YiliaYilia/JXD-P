<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色信息</title>
</head>
<body>
<script type="text/javascript">
$('#pg').propertygrid({
	columns: [[
	            { title: "用户信息", field: "name",width:30 },
	            { title: "", field: "value",width:80 }
	        ]],
    scrollbarSize: 0
});  
</script>
	<div id="tt" class="easyui-tabs" data-options="border:false,plain:true" style="width:378px;height:320px;">   
	    <div title="基本信息" style="" data-options="singleSelect:true"> 
			<input type="hidden" value="${userData.userid }" name="geUser.userid" id="userid">
			<table class="easyui-propertygrid" style="width:376px;height: 280px;" id="pg">
				<thead>   
			        <tr>   
			            <th data-options="field:'name',width:100">name</th>   
			            <th data-options="field:'value',width:100">名称</th>
		        	</tr>   
	    		</thead>
	    		<tbody>
				<tr>
					<td></td>
					<td>用户名</td>
					<td>${userData.username }</td>
				</tr>
				<tr>
					<td></td>
					<td>性别</td>
					<td><dict:span dictCode="${userData.sex }" typeCode="SEX" type="span"></dict:span></td>
				</tr>
				<tr>
					<td></td>
					<td>电子邮箱</td>
					<td>${userData.email }</td>
				</tr>
				<tr>
					<td></td>
					<td>电话</td>
					<td>${userData.phone }</td>
				</tr>
				<tr>
					<td></td>
					<td>用户状态</td>
					<td><dict:span dictCode="${userData.state }" typeCode="USERSTATUS" type="span"></dict:span></td>
				</tr>
				</tr>
				<tr>
					<td></td>
					<td>用户类型</td>
					<td><dict:span dictCode="${userData.usertype }" typeCode="USERTYPE" type="span"></dict:span></td>
				</tr>
				<tr>
					<td></td>
					<td>修改时间</td>
					<td>${userData.createtime }</td>
				</tr>
				</tbody>
			</table>
	    </div>   
	    <div title="关联用户组" style="">
			<table class="easyui-datagrid" style="width:376px;height: 280px;"   
		        data-options="fitColumns:true,singleSelect:true">   
			    <thead>   
			        <tr>   
			            <th data-options="field:'usergroupname',width:100">用户组</th>   
			            <th data-options="field:'usergroupdesc',width:100">描述</th>
			        </tr>   
			    </thead>  
			    <tbody>
					<c:if test="${empty owerUsergroups }">
				    	<tr>
				    		<td>未分配用户组</td>
				    		<td></td>
				    	</tr>
			    	</c:if>
					<c:forEach items="${owerUsergroups }" var="group">
				    	<tr>
				    		<td>${group.usergroupname }</td>
				    		<td>${group.usergroupdesc }</td>
				    	</tr>
					</c:forEach>
			    </tbody> 
			</table> 
	    </div>   
	    <div title="关联角色" style="">
			<table class="easyui-datagrid" style="width:376px;height: 280px;"   
		        data-options="fitColumns:true,singleSelect:true">   
			    <thead>   
			        <tr>   
			            <th data-options="field:'rolename',width:100">角色</th>   
			            <th data-options="field:'roledesc',width:100">描述</th>
			        </tr>   
			    </thead>  
			    <tbody>
					<c:if test="${empty owerRoles }">
				    	<tr>
				    		<td>未分配角色</td>
				    		<td></td>
				    	</tr>
			    	</c:if>
					<c:forEach items="${owerRoles }" var="role">
				    	<tr>
				    		<td>${role.rolename }</td>
				    		<td>${role.roledesc }</td>
				    	</tr>
					</c:forEach>
			    </tbody> 
			</table>   
	    </div>   
	    <div title="所属机构" style="background-color:white" data-options="href:'../system/page/main/user-organ.jsp'"></div>
	</div>
	<div style="padding-left: 200px;" class="userDataItem">
	    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#operate_window').window('close');">关闭</a>  
	</div>
</body>
</html>