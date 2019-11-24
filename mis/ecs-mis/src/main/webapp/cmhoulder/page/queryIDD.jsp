<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="${ctx }/cmhoulder/js/inquirySheetDuty.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	window.onload=function(){
		createIddDataGrid();
	}
</script>
</head>
<body>
<!-- 	查询添加栏 -->
	<div class="datagrid-toolbar">
		<table>
			<tr>
				<td>
	    		<a class="l-btn l-btn-plain" href="javascript:addIdd()">
				<span class="l-btn-left">
				<span class="l-btn-text icon-add l-btn-icon-left">添加</span>
				</span>
				</a>
				</td>
				<td>
					<div class="datagrid-btn-separator"></div>
				</td>
				<td>
					<form id="resetIddQuery">
					<table>
						<tr>
							<td>条款名称:</td>
							<td><input type="text" name="dutyName" id="dutyName"/></td>
							<td>条款编号</td>
							<td><input type="text" name="dutyCode" id="dutyCode"/></td>
							<td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="createIddDataGrid()">查询</a></td>
							<td><a href="#"  class="easyui-linkbutton" onclick="$('#resetIddQuery').form('clear');">重置</a></td>
						</tr>
					</table>
					<form>
				</td>
			</tr>
		</table>
	</div>
<!-- 	列表信息     -->
	<table id="iddList" width="100%"></table>
	
<!-- 	详情页面 -->
	<div id="dutyDetails" Style="display:none">
	<form id=""  enctype="multipart/form-data">
	<table align="center">
		<tr>
			<td align="right">条款编码:</td>
			<td id="iddDutyId">
				${IDD.dutyCode}
			</td>
		</tr>
		<tr>
			<td align="right">条款名称:</td>
			<td id="iddDutyName">
				${IDD.dutyName}
			</td>
		</tr>
		<tr>
			<td align="right">条款内容:</td>
			<td id="iddDutyInfo">
				${IDD.dutyInfo}
			</td>
		</tr>
		<tr>
			<td><a href="#"  class="easyui-linkbutton" id="compileOperate"">编辑</a></td>
			<td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" id="deleteOperate">删除</a></td>
		</tr>
	</table>
	</form>
	</div>
<!-- 	修改页面 -->
	<div id="updateDuty" Style="display:none">
		<form id="updateIddForm" action="${ctx}/cmhoulder/updateIDD" method="POST"  enctype="multipart/form-data">
			<table align="center">
				<tr>
					<td align="right">条款编码:</td>
					<input type="hidden" id="iddDutyCode" name="inquiryDutyDictionary.dutyCode"/>
					<input type="hidden" id="iddDutyId2" name="inquiryDutyDictionary.dutyId"/>
					<input type="hidden" id="iddCreateTime" name="inquiryDutyDictionary.createTime"/>
					<input type="hidden" id="iddDutyInfoPath" name="inquiryDutyDictionary.dutyInfoPath"/>
					<input type="hidden" id="iddDutyName3"/>
					<td id="iddDutyCode2"></td>
				</tr>
				<tr>
					<td align="right">条款名称:</td>
					<td>
						<input type="text" id="iddDutyName2" data-rule="required;tkmc"  name="inquiryDutyDictionary.dutyName"/>&nbsp&nbsp
					</td>
				</tr>
				<tr>
					<td align="right">条款内容:</td>
					<td>
						<textarea id="iddDutyInfo2" data-rule="required;tkmc" name="inquiryDutyDictionary.dutyInfo">${IDD.dutyInfo}</textarea>
					</td>
				</tr>
				<tr>
					<td>条款路径：</td>
					<td>
					<input type="file" name="myfile"/>
					</td>
				</tr>
			</table>
		</form>	
		<div align="center" style="width: 500">
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="updateIddForm()">修改</a>
			<a href="#"  class="easyui-linkbutton" onclick="resetUpdateIddForm()">重置</a>
		</div>
	</div>
<!-- 添加条款  -->
	<div id="addIdd" style="display:none">
		<form id="addIddForm" action="${ctx}/cmhoulder/saveFile" method="POST"  enctype="multipart/form-data" >
			<table align="center">
				<tr>
					<td align="right">条款编码:</td>
					<td><input type="text" id="tkbm" name="inquiryDutyDictionary.dutyCode" data-rule="required;tkmc"></td>
				</tr>
				<tr>
					<td align="right">条款名称:</td>
					<td>
					<input type="text"  id="tkmc" name="inquiryDutyDictionary.dutyName" data-rule="required;tkmc"/>&nbsp&nbsp
					</td>
				</tr>
				<tr>
					<td align="right">条款内容:</td>
					<td>
					<textarea  id="tknr" name="inquiryDutyDictionary.dutyInfo" data-rule="required;tknr"></textarea>
					</td>
				</tr>
				<tr>
					<td>条款路径：</td>
					<td>
					<input type="file" id="tklj" name="myfile" data-rule="required;tknr"/>
					</td>
				</tr>
			</table>
	   </form>
	   <div align="center" style="width: 500">
	   		<a id="" class="easyui-linkbutton" id="addsubmit" onclick="addIddForm()" data-options="iconCls:'icon-save'" href="#">
				保存
			</a>
			<a id="" class="easyui-linkbutton l-btn" onclick="$('#addIdd').window('close');" data-options="iconCls:'icon-cancel'" href="#">
				离开
			</a>
	   </div>
	</div>
</body>
</html>

