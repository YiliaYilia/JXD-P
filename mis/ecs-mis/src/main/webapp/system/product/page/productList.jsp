<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx }/system/js/ECSTab.js"></script>
<script type="text/javascript" src="${ctx }/system/product/js/product.js"></script>
<style type="text/css">
.productItem{
	padding-top: 10px;
}
</style>
<title>产品列表页面</title>

<script type="text/javascript">
	var product = new Product();
	product.ctx = '${ctx}';
	$(document).ready(function(){
		product.createProductTreeGrid();
		//role.formValidate();
	});
	/**
	 *查询资源
	*/
	function searchProduct(){
		product.searchData();
	}
</script>
<dict:script typeCode="BUSINESSAREA,productConfigStatus"></dict:script>
</head>
<body>
	
	<!-- 产品列表（数据）表格 -->
	<table id="productListDatagrid" width="100%" ></table>
	
	
	
	<!-- 新添加查询工具栏目 -->
	<div id="productSearchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
	<table>
		<tr>
			<td>产品代码:</td>
			<td valign="middle">
				<input type="text" id="serach_coreproductcode" name="coreproductcode" style="width: 100px;">
			</td>
			<td>产品名称:</td>
			<td valign="middle">
				<input type="text" id="serach_productname" name="productname" style="width: 100px;">
			</td>
			<!--  
			<td>业务领域:</td>
			<td valign="middle">
				<dict:select typeCode="BUSINESSAREA" pleaseChoose="true" name="businessarea" id="serach_businessarea" style="width: 100px;height:22px;"></dict:select>
			</td>-->
			<td>产品状态:</td>
			<td valign="middle">
				<dict:select typeCode="productConfigStatus" pleaseChoose="true" name="productstatus" id="serach_productstatus" style="width: 100px;height:22px;"></dict:select>
			</td>
			<td>
				<a id="searchProduct" onclick="searchProduct();" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> 
			</td>
		</tr>
	</table>
	</div>
	
	<!-- 弹出添加操作窗口 --> 
	<div id="product_operator_window" style="background-color:white ;font-size: 15px;padding: 0px;"> 
	</div>
</body>
</html>