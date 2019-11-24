<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx }/system/product/js/flow/flowDefine.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#flow_operate').tabs('disableTab', 1);
});
</script>
<title>流程配置</title>
</head>
<body>
	<form name="flowDefineForm" id="flowDefineForm">
		<input type="hidden" name="operate" id="operate" value="${operate }">
		<input type="hidden" name="geProductflowdefine.operator" id="operator" value="${user.geUser.username }">
		<c:if test="${geProductflowdefine.productflowdefineno != null }">
			<input type="hidden" value="${geProductflowdefine.productflowdefineno }" name="geProductflowdefine.productflowdefineno" id="productflowdefineno">
		</c:if>
		<div id="flow_operate" class="easyui-tabs" data-options="border:false,plain:true" style="width:465px;height:385px;">
			<div title="流程定义" style="overflow:hidden; padding-left: 15px;" data-options="singleSelect:true">
				<table style="margin-top: 10px;">
					<tr>
						<td class="tabLeft">流程名称：</td>
						<td>
							<input type="text" value="${geProductflowdefine.productflowname }" id="productflowname" name="geProductflowdefine.productflowname">
						</td>
					</tr>
				</table>
				<table border="0" style="margin-top: 10px;">
					<tr>
						<td>所有的流程页面</td>
						<td></td>
						<td>已拥有的流程页面</td>
					</tr>
					<tr>
						<td width="160,50,160,50">
							<select multiple="multiple" style="width: 185px; height: 200px;" id="pagedefines">
								<c:forEach items="${pagedefines }" var="pagedefine">
									<option value="${pagedefine.productflowpagedefineno }">${pagedefine.pagename }</option>
								</c:forEach>
							</select>
						</td>
						<td align="center">
							<div><img alt="添加" onclick="flowDefine.addOption('pagedefines','owerpagedefines');" src="${ctx }/system/images/arrow_right.png" style="cursor: pointer;width: 20px;"></div>
							<div style="height: 30px;"></div>
							<div><img alt="移除" onclick="flowDefine.removeOption('owerpagedefines');" src="${ctx }/system/images/arrow_left.png" style="cursor: pointer;width: 20px;"></div>
						</td>
						<td>
							<select multiple="multiple" name="owerpagedefine.productflowpagedefineno"  style="width: 180px; height: 200px;" id="owerpagedefines">
								<c:forEach items="${owerpagedefines }" var="owerpagedefine">
									<option value="${owerpagedefine.productflowpagedefineno }">${owerpagedefine.pagename }</option>
								</c:forEach>
							</select>
						</td>
						<td align="center">
							<div><img alt="上移" onclick="flowDefine.moveOption('owerpagedefines',-1);" src="${ctx }/system/images/arrow_up.png" style="cursor: pointer;width: 20px;"></div>
							<div style="height: 30px;"></div>
							<div><img alt="下移" onclick="flowDefine.moveOption('owerpagedefines',1);" src="${ctx }/system/images/arrow_down.png" style="cursor: pointer;width: 20px;"></div>
						</td>
					</tr>
				</table>
				<div style="padding-left: 90px;padding-top: 15px;">
				    <a class="easyui-linkbutton" data-options="iconCls:'icon-save'"  onclick="flowDefine.next();">下一步</a>
				    <a class="easyui-linkbutton" style="margin-left: 30px;" data-options="iconCls:'icon-cancel'" onclick="$('#operate_window').window('close');">关闭</a>  
				</div>
			</div>
			<div title="页面元素" style="overflow:hidden;" data-options="singleSelect:false">
				<div id="pageEles" class="easyui-tabs" data-options="border:false,tabPosition:'left',headerWidth:100" style="width:465px;height:285px;">
				</div>
				<div style="padding-left: 105px;padding-top: 5px;">
				    <a class="easyui-linkbutton" data-options="iconCls:'icon-save'"  onclick="flowDefine.addUpdateFlow();">保存</a>
				    <a class="easyui-linkbutton" style="margin-left: 30px;" data-options="iconCls:'icon-cancel'" onclick="$('#operate_window').window('close');">关闭</a>  
				</div>
			</div>
		</div>
	</form>
</body>
</html>