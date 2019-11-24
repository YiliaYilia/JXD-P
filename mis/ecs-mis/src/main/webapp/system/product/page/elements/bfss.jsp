<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fck" uri="FCKeditor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保费试算</title>


</head>
<body>
	<form action="saveOtherConfig" method="post" target="framebfss" id="bfss">
		<input type="hidden" id="bfss_coreProductCode" name="coreproductcode" value="${geProductMain.coreproductcode }">
		<input type="hidden" id="bfss_configname" name="geProductOtherconfig.otherconfigname" value="保费试算">
		<input type="hidden" id="bfss_configcode" name="geProductOtherconfig.otherconfigcode" value="BFSS">
		<input type="hidden" id="bfss_configtype" name="geProductOtherconfig.otherconfigtype" value="HTML">
		<fck:editor instanceName="bfss" basePath="/common/js/fckeditor" inputName="" toolbarSet="" value="${geProductOtherconfig.otherconfigcontent }" height="400"></fck:editor>
		<input type="hidden" id="bfss_configcontent" name="geProductOtherconfig.otherconfigcontent">
		<div align="center"><a class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="elementsUtil.saveOtherConfig('bfss');">保存</a></div>
	</form>	
	<iframe name="framebfss" style="display: none;"></iframe>		
</body>
</html>