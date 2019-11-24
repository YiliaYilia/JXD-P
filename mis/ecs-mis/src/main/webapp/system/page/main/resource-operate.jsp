<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>
<script type="text/javascript" src="${ctx }/system/js/resource/resourceTreeConvert.js"></script>
<script type="text/javascript" src="${ctx }/system/js/resource/resource.js"></script>
<style>
	.resourceItem{
		padding-top: 10px;
	}
	.n-invalid {border: 1px solid red;}
</style>

</head>
<body>
<script type="text/javascript">
var resource = new Resource();

$(document).ready(function(){
	resource.ctx='${ctx}';
	resource.formValidate();
});
		
</script>

	<form  name="addUpdateResouceForm" id="addUpdateResouceForm" autocomplete="off" >
   	<table border="0" style="width: 540px;height: 340px;">
   		<tr valign="top">
   			<td width="400" valign="top">
   				<div class="resourceItem" id="updateOpearHide">
		    		父资源名称:
		    		<input type="hidden" value="" name="resourcesparent" id="resourcesparent">
		    		<span id="resourcesparentName"></span>
		    	</div>
		    	<div class="resourceItem">
		    		资源编码:
		    		<input type="text" name="geResources.resourcescode" id="resourcescode" maxlength="100" >
		    		<span id="resourcescodeSpan"></span>
		    	</div>
		    	<div class="resourceItem">
		    		资源名称:
		    		<input type="text" name="resourcesname" id="resourcesname" maxlength="100"  >
		    	</div>
		    	<div class="resourceItem" >
		    		资源类型:
		    		<!-- <select name="resourcestype" id="resourcestype">
		    			<option value="M">菜单资源</option>
		    			<option value="F">功能资源</option>
		    		</select> -->
		    		<dict:select typeCode="MENUTYPE" name="resourcestype" id="resourcestype"></dict:select>
		    	</div>
		    	<div class="resourceItem">
		    		资源内容:
		    		<input type="text" name="resourcescontent" id="resourcescontent" maxlength="100" >
		    	</div>
		    	<div class="resourceItem">
		    		资源详情:
		    		<input type="text" name="resourcesdesc" id="resourcesdesc" maxlength="30">
		    	</div>
		    	<div class="resourceItem">
		    		资源图标
		    		<img alt="图标" src="${ctx }/system/images/635.png" width="22" height="22">:
		    		<input type="hidden" name="resourcesiconid" id="resourcesiconid">
		    		<span id="resourcesicon"></span>
		    	</div>
		    	<br><br>
		    	<div style="text-align: center;">
		    		<a type="submit" class="easyui-linkbutton" data-options="iconCls:'icon-save'"  onclick="$('#addUpdateResouceForm').submit();">保存</a>
		    		<a type="submit" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#resource_addUpdate_window').window('close');">离开</a>  
		    	</div>
		    	
   			</td>
   			
   			<td valign="top">
   				<div>请选择资源图标</div>
   				<div style="width: 120px;height:300px; OVERFLOW-Y: auto; OVERFLOW-X:hidden;">
   					<c:forEach items="${resourceIcons }" var="resourceIcon">
   						<div class="resourceIconItem" style="float: left;margin: 2px ;border: 1px solid #96CB55;cursor: pointer;" onclick="resource.selectResourceIcon(this,'${resourceIcon.resourcesiconid}')">
   							<img src="${ctx }${resourceIcon.resourcesiconpath}"  width="22" height="22" id="ICON${resourceIcon.resourcesiconid}">
   						</div>
   					</c:forEach>
   					
   				</div>
   			</td>
   		</tr>
   	</table>
   				<!-- 操作类型：删除、修改，不能删除该隐藏域 -->
   				<input type="hidden" value="" id="opeartype" name="opeartype">
   	</form>
</body>
</html>