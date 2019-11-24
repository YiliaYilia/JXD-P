<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>

</head>
<body>
	<script type="text/javascript" src="${ctx }/system/js/resource/resourceTreeConvert.js"></script>
	<form  name="addUpdatePermissionForm" id="addUpdatePermissionForm" autocomplete="off" >
		
		<div style="width:400px; height: 380px;">
			<table border="0" width="100%" >
				<tr>
					<td valign="top">
						<div style="width:400px;">
							<fieldset>
									<legend><strong>权限信息:</strong></legend>
								<div class="permissionItem">
									权限名称:
									<label>${gePermission.permissionname}</label>
								  	<input value="${gePermission.permissionname }"  <c:if test="${gePermission.permissionid != null }"> type="hidden" </c:if> 
								    <c:if test="${gePermission.permissionid == null }"> type="text"</c:if>  id="permissionname" maxlength="100" name="permissionname" >
								</div>
								<div class="permissionItem">
									权限描述:
								  	<input type="text" value="${gePermission.permissiondatadesc }" id="permissiondatadesc" maxlength="100" name="permissiondatadesc" data-rule="filter(<>^%&$*@#!);">
								</div>
							</fieldset>
						</div>
						<div style="width:400px; height:200px;">
							<fieldset>
								<legend><strong>拥有的资源:</strong></legend>
								<div style="width:100%; height:200px; OVERFLOW-Y: auto; OVERFLOW-X:auto;border: 0px solid #ABADB3; text-align: left;">
									
									<ul style="text-align: left;" id="resourceTree"></ul>
									
								</div>
							</fieldset>
						</div>
						<input type="hidden" name="operate" id="operate" value="${opeartype }">
						<c:if test="${gePermission.permissionid != null }">
							<input type="hidden" value="${gePermission.permissionid}" id="permissionid" name="permissionid">
						</c:if>
						<br>
						<div style="padding-top: 20px;text-align: center;" class="permissionItem">
						    <a  class="easyui-linkbutton" data-options="iconCls:'icon-save'"  onclick="$('#addUpdatePermissionForm').submit();">保存</a>
						    <a  class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#permissionData_add_window').window('close');">离开</a>  
						</div>
						
					</td>
				</tr>
			</table>
	 	 </div>  
	</form>
	<!-- 为什么在这写js代码：因为easyui加载的时候如果js放到head上面，easyui是加载不到的，只加载body内容 -->
	<!--<script type="text/javascript">
	 
		$('#addUpdatePermissionForm').on('valid.form', function(){
			permission.addUpdatePermission();
			return false;
		}).on('invalid.form', function(){
			return false;
		}); 
		</script>  -->
		<script type="text/javascript">
		permission.ctx = '${ctx}';
		$("document").ready(function(){
			permission.formValidate();
			var operate = $("#operate").val();
			var permissionid = $("#permissionid").val();
			var data = "operate="+operate+"&permissionid="+permissionid+"&date="+new Date();
			$.ajax({
				type:"POST",
				url:"${ctx}/system/getResourceTree",
				data:data,
				success:function(data){
					$('#resourceTree').tree({    
						data: convert(data),
						animate:true,
						lines:true,
						checkbox:true
						
					});
				},
				error:function (XMLHttpRequest, textStatus, errorThrown){
					$.messager.alert('系统异常','系统异常,请稍后再试');
				}
			});
		});
	

	</script>
</body>
</html>