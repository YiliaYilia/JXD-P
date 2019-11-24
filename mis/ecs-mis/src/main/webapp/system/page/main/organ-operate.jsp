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
var organ = new Organ();
$(document).ready(function(){
	organ.ctx='${ctx}';
	organ.formValidate();
});
		
</script>
<fieldset>
	<legend><strong>机构信息:</strong></legend>
<form  name="addUpdateOrganForm" id="addUpdateOrganForm" autocomplete="off">
   	<table border="0" style="width: 390px;">
   		<tr valign="top">
   			<td valign="top">
   				<!-- 操作类型：删除、修改，不能删除该隐藏域 -->
   				<input type="hidden" value="" id="opeartype" name="opeartype">
		    	<div class="organItem" id="updateOpearHide">
		    		父资源名称:
   				    <input type="hidden" value="" name="deptid" id="deptid">
   				    <input type="hidden" value="" name="parentId" id="parentId">
   				    <input type="hidden" value="" name="root" id="root">
		    		<span id="organparentName"></span>
		    	</div> 
		    	<div class="organItem">
		    		机构编码:
		    		<input type="text" name="deptCode" id="deptCode" maxlength="100" data-rule="机构编码:required" data-tip="提示：不能为空" >
		    	    <span id="deptCodeName"></span>
		    	</div>
		    	<div class="organItem">
		    		机构名称:
		    		<input type="text" name="deptname" id="deptname" maxlength="100" data-rule="名称:required" data-tip="提示：可支持中文" >
		    	</div>
		    	<div class="organItem">
		    	所属类型:
			    <dict:select typeCode="DEPARTMENTTYPE" name="organType" id="organType" style="width: 155px;"></dict:select>
		    	 </div>
		    	<div class="organItem">
		    		机构地址:
		    		<input type="text" name="contactAddress" id="contactAddress" maxlength="100" data-rule="地址:required" data-tip="提示：可支持中文" >
		    	</div>
		    	<div class="organItem">
		    		办公电话:
		    		<input type="text" name="officePhone" id="officePhone" maxlength="100">
		    	</div>
		    	<div class="organItem">
		    		邮政编号:
		    		<input type="text" name="zipCode" id="zipCode" maxlength="30">
		    	</div>
		    	<div style="text-align: center;">
		    		<a type="submit" class="easyui-linkbutton" data-options="iconCls:'icon-save'"  onclick="$('#addUpdateOrganForm').submit();">保存</a>
		    		<a type="submit" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#organ_add_window').window('close');">离开</a>  
		    	</div>
   			</td>   			
   		</tr>
   	</table>
   	</form>
</fieldset>
</body>
</html>