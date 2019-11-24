<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>
<script type="text/javascript" src="${ctx }/system/product/js/productAttr/productAttrTreeConvert.js"></script>
<script type="text/javascript" src="${ctx }/system/product/js/productAttr/productAttribute.js"></script>
<style>
	.productAttrItem{
		padding-top: 10px;
	}
	.n-invalid {border: 1px solid red;}
</style>

</head>
<body>
<script type="text/javascript">
var productAttr = new ProductAttr();

$(document).ready(function(){
	productAttr.ctx='${ctx}';
	productAttr.formValidate();
});
		
</script>
<fieldset>
	<legend><strong>产品属性:</strong></legend>
	<form  name="addUpdateProductAttrForm" id="addUpdateProductAttrForm" autocomplete="off" >
   	<table border="0" style="width: 380px;">
   		<tr valign="top">
   			<td  valign="top">
   				<div class="productAttrItem" id="updateOpearHide">
		    		父属性名称:
		    		<input type="hidden" value="" name="productattrparent" id="productattrparent"><!-- 父属性名称  对应text-->
		    		<span id="productattrparentName"></span>
		    	</div>
		    	<div class="productAttrItem" id="updatePid">
			    		属性编号:
			    		<span id="productAttrParentId"></span>
			    	</div>
	   				<div class="productAttrItem" id="updatePid1">
			    		属性编号:
			    		<input type="text" name="productAttrId" id="productAttrId" maxlength="100">
			    		<span id=""></span>
			    	</div>
		    	<div class="productAttrItem">
		    		属性名称:
		    		<input type="text" name="productattrName" id="productattrName"  >
		    	</div>
		    	<div class="productAttrItem">
		    		显示顺序:
		    		<input type="text" name="seqindex" id="seqindex"  >
		    	</div>
		    	<div class="productAttrItem">
		    		属性描述:
		    		<input type="text" name="productattrdesc" id="productattrdesc"   >
		    	</div>
		    	<div class="productAttrItem">
		    		详细信息:
		    		<input type="text" name="productattrinfo" id="productattrinfo"  >
		    	</div>
		    	<br><br>
		    	<div style="text-align: center;">
		    		<a type="submit" class="easyui-linkbutton" data-options="iconCls:'icon-save'"  onclick="$('#addUpdateProductAttrForm').submit();">保存</a>
		    		<a type="submit" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#productAttr_addUpdate_window').window('close');">离开</a>  
		    	</div>
   			</td>
   		</tr>
   	</table>
   				<!-- 操作类型：删除、修改，不能删除该隐藏域 -->
   				<input type="hidden" value="" id="opeartype" name="opeartype">
   	</form>
</fieldset>
</body>
</html>