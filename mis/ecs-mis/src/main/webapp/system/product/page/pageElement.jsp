<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx }/system/product/js/flow/flowDefine.js"></script>
<title>页面元素配置</title>
</head>
<body>
	<table border="0" style="margin-top: 10px;">
		<tr>
			<td>所有的页面元素</td>
			<td></td>
			<td>已拥有的页面元素</td>
		</tr>
		<tr>
			<td width="160,50,160,50">
				<select multiple="multiple" style="width: 150px; height: 250px;" id="ele${pageno }">
					<c:forEach items="${elements }" var="element">
						<option value="${element.productflowpageelementdefineno }">${element.elementname }</option>
					</c:forEach>
				</select>
			</td>
			<td align="center">
				<div><img alt="添加" onclick="flowDefine.addOption('ele${pageno }','ownele${pageno }');" src="${ctx }/system/images/arrow_right.png" style="cursor: pointer;width: 20px;"></div>
				<div style="height: 30px;"></div>
				<div><img alt="移除" onclick="flowDefine.removeOption('ownele${pageno }');" src="${ctx }/system/images/arrow_left.png" style="cursor: pointer;width: 20px;"></div>
			</td>
			<td>
				<select multiple="multiple" name="owerpagedefine.productflowpagedefineno"  style="width: 150px; height: 250px;" id="ownele${pageno }">
					<c:forEach items="${ownelements }" var="ownelement">
						<option value="${ownelement.productflowpageelementdefineno }">${ownelement.elementname }</option>
					</c:forEach>
				</select>
			</td>
			<td align="center">
				<div><img alt="上移" onclick="flowDefine.moveOption('ownele${pageno }',-1);" src="${ctx }/system/images/arrow_up.png" style="cursor: pointer;width: 20px;"></div>
				<div style="height: 30px;"></div>
				<div><img alt="下移" onclick="flowDefine.moveOption('ownele${pageno }',1);" src="${ctx }/system/images/arrow_down.png" style="cursor: pointer;width: 20px;"></div>
			</td>
		</tr>
	</table>
</body>
</html>