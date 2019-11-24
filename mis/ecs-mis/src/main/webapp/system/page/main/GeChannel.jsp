<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${ctx }/system/js/GeChannel/GeChannel.js"></script>
<script type="text/javascript" src="${ctx }/system/js/ECSTab.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>

</head>
<body>
    <table id="channelData" width="100%"></table>
    <div id="searchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
		<table>
			<tr>
				<td>
					合作伙伴代码：<input type="text" id="channelCode-search" name="channelCode" >
				</td>
				<td>
					合作伙伴名称：<input type="text" id="channelName-search" name="channelName" >
				</td>
				<td>
					组织机构：<select  id="deptCode-search" name="deptCode" style="width: 100px;">
					        <option value="">请选择</option>
					        <c:forEach items="${departmentList }" var="department">
							<option value="${department.deptCode }">${department.deptname }</option>
							</c:forEach>
					</select>
				</td>
				<td>
					<a id="search" onclick="geChannel.searchData()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> 
				</td>
			</tr>
		</table>
	</div>
<script type="text/javascript">
	//创建表格
	geChannel.createDataGrid();
</script>
</body>
</html>