<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品添加或者更新页面</title>
</head>
<body>
<fieldset>
	<legend><strong>产品信息:</strong></legend>
	<form  name="addUpdateProductForm" id="addUpdateProductForm" autocomplete="off">
		<input type="hidden" value="${operate }" name="operate" id="operate">
	<div class="productItem">
			<c:if test="${geProduct != null }">
				产品代码:
				<input type="text" value="${geProduct.coreproductcode }" name="coreproductcode" id="addupdate_coreproductcode" maxlength="100" style="border: 0px;" readonly="readonly">
			</c:if>
			<c:if test="${geProduct == null }">
				产品代码:
		  		<input type="text" value="${geProduct.coreproductcode }" name="coreproductcode" id="addupdate_coreproductcode" maxlength="100">
			</c:if>
			
		</div>
		<div class="productItem">
			产品名称:
		  	<input type="text" value="${geProduct.productname }" name="productname" id="addupdate_productname" maxlength="100" data-rule="filter(<>^%&$*@#!);">
		</div>
		<div class="productItem">
			产品简称:
			<input type="text" value="${geProduct.coreproductsimplename }" name=coreproductsimplename id="addupdate_coreproductsimplename" maxlength="100" data-rule="filter(<>^%&$*@#!);">
		</div>
		<div class="productItem">
			业务领域:
			<c:if test="${geProduct != null }">
				<dict:span dictCode="${geProduct.businessarea }" type="span" typeCode="BUSINESSAREA" ></dict:span>
			</c:if>
			
			<c:if test="${geProduct == null }">
				<dict:select defaultValue="${geProduct.businessarea }" typeCode="BUSINESSAREA" name="businessarea" id="addupdate_businessarea" style="width: 100px;height:22px;"></dict:select>
			</c:if>
		</div>
		<div class="productItem">
			产品流程:
			<c:if test="${geProduct != null }">
				${geProduct.geWebflow.flowname }
			</c:if>
			<c:if test="${geProduct == null }">
			<select name="productflow" id="addupdate_productflow">
			<c:forEach items="${productflowdefines }" var="fine">
<%-- 				<c:if test="${geProduct.productflow ==  fine }"> --%>
					<option value="${fine.productflowdefineno }">${fine.productflowname }</option>
<%-- 				</c:if> --%>
			</c:forEach>
			</select>
			</c:if>
		</div>
		<div style="text-align: center;" class="roleItem">
		    <a  class="easyui-linkbutton" data-options="iconCls:'icon-save'"  onclick="$('#addUpdateProductForm').submit();">保存</a>
		    <a  class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#role_addUpdate_window').window('close');">离开</a>  
		</div>
		</form>
		</fieldset>
		<script type="text/javascript">
		var product = new Product();
		product.ctx = '${ctx}';
		$(document).ready(function(){
			product.formValidate();
		});
	</script>
</body>
</html>