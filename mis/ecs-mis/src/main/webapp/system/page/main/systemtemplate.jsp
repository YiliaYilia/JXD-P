<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>
<script type="text/javascript" src="${ctx }/system/js/template/template.js"></script>
</head>

<body>
	<table id="templatedata" width="100%"></table>
<dict:script typeCode="TEMPLATEFUNCTION,TEMPLATETYPE"></dict:script>
<!-- 修改短信模板    开始 -->
<div id="template_update" style="display:none;">
<fieldset>
	<legend><strong>模板信息:</strong></legend>
<form action="templateUpdateForm" id="templateUpdateForm">
<table width="400">
	    <tr>
	      <td width="80">模板名称：</td>
	      <td><input type="text" class="tempname" name="tempname" /></td>
        </tr>
	    <tr>
	      <td>模板类型：</td>
	      <td><dict:select typeCode="TEMPLATETYPE" id="type" style="width: 153px;" ></dict:select></td>
        </tr>
	    <tr>
	      <td>所属功能：</td>
	      <td><dict:select typeCode="TEMPLATEFUNCTION" id="function" style="width: 153px;"></dict:select></td>
        </tr>
	    <tr>
	      <td>模板内容：</td>
	      <td><textarea cols="42" rows="7" class="tempcontent" name="tempcontent" style="resize:none"></textarea></td>
        </tr>
	    <tr>
	      <td colspan="2"><div align="center">
	      	<input type="text" value="" id="tempid" style="display: none;" />
	      	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#templateUpdateForm').submit()">保存</a> 
	       	  <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"	onclick='temp.closewindowdiv("template_update")'>离开</a>
	      </div></td>
        </tr>
</table>
</form>
</fieldset>
</div>
<!-- 修改短信模板    结束 -->
<!-- 新增短信模板    开始 -->
<div id="template_add" style="display:none;">
<fieldset>
	<legend><strong>模板信息:</strong></legend>
<form action="templateAddForm" id="templateAddForm">
 <table width="400" >
	    <tr>
	      <td width="80">模板名称：</td>
	      <td align="left">
	      	<input type="text" class="tempname" name="tempname" />
	      </td>
        </tr>
	    <tr>
	      <td>模板类型：</td>
	      <td><dict:select typeCode="TEMPLATETYPE" id="type" style="width: 153px;" ></dict:select></td>
        </tr>
	    <tr>
	      <td>所属功能：</td>
	      <td><dict:select typeCode="TEMPLATEFUNCTION" id="function" style="width: 153px;"></dict:select></td>
        </tr>
	    <tr>
	      <td>模板内容：</td>
	      <td><textarea cols="20" rows="7" class="tempcontent" name="tempcontent" style="resize:none"></textarea></td>
        </tr>
	    <tr>
	      <td colspan="2"><div align="center">
	      <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#templateAddForm').submit()">保存</a> 
	       	  <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"	onclick='temp.closewindowdiv("template_add")'>离开</a>
	      </div></td>
        </tr>
</table>
</form>
</fieldset>
</div>
<!-- 新增短信模板    结束 -->
<!-- 搜索 结束 -->
<div id="template_search" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
	<table>
		<tr>
			<td>模板名称:</td>
			<td valign="middle">
				<input type="text" id="rolename-search" name="dicttypeid" >
			</td>
			<td>
				<a id="search" onclick="temp.searchTemplate();" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> 
			</td>
		</tr>
	</table>
</div>
<!-- 搜索  结束  -->
<script type="text/javascript">
		temp.initToolbar();
		$('#templatedata').datagrid({
			url: "${ctx}/system/searchTmplate",
			pageSize:20,
			pagination : true,
			rownumbers:true,
			fit:true,
			toolbar:temp.toolbar,
			fitColumns:true,
			checkbox:true,
		    columns:[[
				{field : 'tempid',title : 'ID',hidden:true},
				{checkbox:true},
		    	{field:'tempname',title:'模板名称',width:($("#templatedata").width() * 0.2),align:'left'},
		    	{field:'typecode',title:'模板类型',width:($("#templatedata").width() * 0.2),align:'left',
		    		formatter:function(index,row){
		        		return dictTrans(row.typecode,"TEMPLATETYPE");
		        	}
		    	},
		    	{field:'functioncode',title:'所属功能',width:($("#templatedata").width() * 0.2),align:'left',
		    		formatter:function(index,row){
		        		return dictTrans(row.functioncode,"TEMPLATEFUNCTION");
		        	}
		    	},
		    	{field:'createTime',title:'创建时间',width:($("#templatedata").width() * 0.2),align:'left'},
		    	{field:'operatopname',title:'添加/修改（人员）',width:($("#templatedata").width() * 0.2),align:'left'}
		    ]]
		});
		temp.createToolbar();
		
</script>
</body>
</html>