<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx }/system/product/js/product.js"></script>
<style type="text/css">
.productItem{
	padding-top: 10px;
}
</style>
<title>产品流程定制</title>


</head>
<body>
<script type="text/javascript">
	var product = new Product();
	product.ctx = '${ctx}';
	$(document).ready(function(){
		product.formValidate();
	});

</script>
	<form id="addProductConfigPageElementForm" >
	<input type="hidden" name="coreproductcode" id="product_coreproductcode" value="${coreproductcode }">
	<div id="tt" class="easyui-tabs" style="width:586px;height:250px;">
    
    <c:forEach items="${geProductflowdefine.geProductflowPages}" var="pages">
				
		<div title="${pages.geProductflowpagedefine.pagename }" style="padding-top:20px;">  
			<table width="100%" >
				<tr>
					<td align="center">
						<div style="margin-left: -70px;">
							<strong>全部配置项</strong>
						</div>
					</td>
					<td>
					 &nbsp;
					</td>
					<td align="left">
						<strong>已选择配置项</strong>
					</td>
				</tr>
				<tr>
					<td align="right">
						<select  multiple="multiple"  style="width: 200px; height: 160px;" id="${pages.geProductflowpagedefine.productflowpagedefineno}_page_elementId">
						 	<c:forEach items="${pages.geProductflowpageElements }" var="eles">
		           				<option value="${eles.geProductflowpageelementdefine.productflowpageelementdefineno }">
		           					${eles.geProductflowpageelementdefine.elementname }
		           				</option>
		           			</c:forEach>
						</select>
					</td>
					<td align="center">
							<div><img alt="添加" onclick="product.addElement(${pages.geProductflowpagedefine.productflowpagedefineno});" src="${ctx }/system/images/arrow_right.png" style="cursor: pointer;width: 20px;"></div>
							<div><img alt="移除" onclick="product.removeElement(${pages.geProductflowpagedefine.productflowpagedefineno})" src="${ctx }/system/images/arrow_left.png" style="cursor: pointer;width: 20px;"></div>
					</td>
					<td align="left">
						<select  multiple="multiple"  style="width: 200px; height: 160px;"  id="${pages.geProductflowpagedefine.productflowpagedefineno}_page_ownerElementId">
							<c:forEach items="${geProductMain.geWebflow.geWebflowpages }" var="productPages">
								<c:if test="${pages.geProductflowpagedefine.productflowpagedefineno == productPages.webflowpagecode }">
									<c:forEach items="${productPages.geWebflowpageelements}" var="productElement">
										<option value="${productElement.webflowpageelementcode }">
		           						${productElement.webflowpageelementname }
		           						</option>
									</c:forEach>
								</c:if>
							</c:forEach>
							
						</select>
					</td>
				</tr>
			</table> 
					
	    </div>
	 
    </c:forEach>
</div> 
<div style="text-align: center;" class="roleItem">
		    <a  class="easyui-linkbutton" data-options="iconCls:'icon-save'"  onclick="$('#addProductConfigPageElementForm').submit();">保存</a>
		    <a  class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#product_operator_window').window('close');">离开</a>  
		</div>
</form>
</body>

</html>