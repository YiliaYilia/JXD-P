<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx }/system/product/js/flow/flowDefine.js"></script>
<title>流程查看</title>
</head>
<body>
<table>
	<tr>
		<td class="tabLeft">流程名称：</td>
		<td>
			${geProductflowdefine.productflowname}
		</td>
	</tr>
</table>
<ul class="easyui-tree" data-options="lines:true" style="margin-top: 10px;">
	<li>
		<span>页面及元素</span>
		<c:forEach items="${geProductflowdefine.geProductflowPages}" var="pages">
			<ul>
				<li>
					<span>${pages.geProductflowpagedefine.pagename }</span>
					<ul>
						<c:forEach items="${pages.geProductflowpageElements }" var="eles">
							<li>
		     					${eles.geProductflowpageelementdefine.elementname }
		     				</li>
		     			</c:forEach>
					</ul>
				</li>
			</ul>
		</c:forEach>
	</li>
</ul>
</body>
</html>