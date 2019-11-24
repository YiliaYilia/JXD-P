<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fck" uri="FCKeditor" %>
<%@ taglib prefix="c" uri="core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投保告知编辑页</title>
</head>
<body>
	<input type="hidden" id="operate" value="${operate }">
	<fck:editor instanceName="tbgz" basePath="/common/js/fckeditor" inputName="" toolbarSet="" value="${geProductInformbook.informcontent }" height="340px;"></fck:editor>
	<div style="float: left;padding: 10px 0 0 10px;">
		指定值: 
		<select id="desValue">
			<option value="Y" <c:if test="${geProductInformbook.informoption == 'Y' }">selected="selected"</c:if>>是</option>
			<option value="N"<c:if test="${geProductInformbook.informoption == 'N' }">selected="selected"</c:if>>否</option>
		</select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		显示顺序: 
		<select id="showorder">
			<c:forEach var="index" begin="0" end="${count-1 }" step="1">
				<option value="${index }" <c:if test="${geProductInformbook.informorder == (index+1) }">selected="selected"</c:if>>${index+1 }</option>
			</c:forEach>
		</select>
	</div>
	<div style="float: right;padding: 10px 20px 0 0;"><a class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="tbgz.addOrUpdate($('#operate').val())">保存</a></div>
</body>
</html>