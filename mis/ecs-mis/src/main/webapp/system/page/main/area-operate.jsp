<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>
<script type="text/javascript" src="${ctx }/system/js/organ/organTreeConvert.js"></script>
<script type="text/javascript" src="${ctx }/system/js/organ/organ.js"></script>
<style>
	.organItem{
		padding-top: 10px;
	}
	.n-invalid {border: 1px solid red;}
</style>

</head>
<body>
<script type="text/javascript">
		var area = new Area();
		$(document).ready(function(){
			area.ctx='${ctx}';
			area.formValidate();
		});
</script>
	<fieldset>
	<legend><strong>区域信息:</strong></legend>
	<form  name=addUpdateAreaForm id="addUpdateAreaForm" autocomplete="off">
   		<table border="0" style="width: 300px;height: 20px;">
	   		<tr valign="top">
	   			<td width="400" valign="top">
	   				<!-- 操作类型：删除、修改，不能删除该隐藏域 -->
	   				<input type="hidden" value="" id="opeartype" name="opeartype">
	   				<div class="resourceItem" id="updateOpearHide">
			    		父区域名称:
			    		<input type="hidden" value="" name="areaPrent" id="areaPrent"><!--父区域编号 --> 
			    		<span id="areaParentName"></span>
			    	</div>
			    	<div class="resourceItem" id="updatePgid">
			    		区域编号:
			    		<span id="areaParentId"></span>
			    	</div>
	   				<div class="resourceItem" id="updatePgid1">
			    		区域编号:
			    		<input type="text" name="geArea.gid" id="areaGid" maxlength="100">
			    		<span id=""></span>
			    	</div>
	   				<div class="resourceItem">
			    		区域名称:
			    		<input type="text" name="gname" id="areaGname" maxlength="100">
			    	</div>
			    	<div class="resourceItem">
			    		备注信息:
			    		<input type="text" name="areaNote" id="areaNote" maxlength="100" >
			    	</div>
			    	<div style="text-align: center;">
			    		<a type="submit" class="easyui-linkbutton" data-options="iconCls:'icon-save'"  onclick="$('#addUpdateAreaForm').submit();">保存</a>
			    		<a type="submit" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#area_add_window').window('close');">离开</a>  
			    	</div>
	   			</td>
	   		</tr>
   		</table>
   	</form>
   	</fieldset>
</body>
</html>