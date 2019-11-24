<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fck" uri="FCKeditor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>法律声明</title>
</head>
<body>
	<form action="saveOtherConfig" method="post" target="frameflsm" id="flsm">
		<input type="hidden" id="flsm_coreProductCode" name="coreproductcode" value="${geProductMain.coreproductcode }">
		<input type="hidden" id="flsm_configname" name="geProductOtherconfig.otherconfigname" value="法律声明">
		<input type="hidden" id="flsm_configcode" name="geProductOtherconfig.otherconfigcode" value="FLSM">
		<input type="hidden" id="flsm_configtype" name="geProductOtherconfig.otherconfigtype" value="HTML">
		<fck:editor instanceName="flsm" basePath="/common/js/fckeditor" inputName="" toolbarSet="" value="${geProductOtherconfig.otherconfigcontent }" height="400"></fck:editor>
		<input type="hidden" id="flsm_configcontent" name="geProductOtherconfig.otherconfigcontent">
		<div align="center"><a class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="elementsUtil.saveOtherConfig('flsm');">保存</a></div>
	</form>	
	<iframe name="frameflsm" style="display: none;"></iframe>
</body>
</html>