var ECSINFO = {};
ECSINFO.add ="新建";
ECSINFO.exp ="导入";
ECSINFO.update="修改";
ECSINFO.del="删除";
ECSINFO.view ="查看";

ECSINFO.alert_system_error = function(){
	$.messager.alert("提示","系统异常，请稍后再试");
};
ECSINFO.alert_update_unique = function(){
	 $.messager.alert("提示","只能选择单条记录");
};
ECSINFO.alert_delete_requried = function(){
	 $.messager.alert("提示","至少选择一条记录");
};
ECSINFO.alert_repeat = function(){
	 $.messager.alert("提示","部分数据已存在，请整理后重新操作");
};
ECSINFO.alert_insert_repeat = function(){
	 $.messager.alert("提示","插入失败，银行编码已存在");
};
ECSINFO.alert_insert_error = function(){
	 $.messager.alert("提示","插入失败");
};
ECSINFO.confirm_delete = function(fun){
	$.messager.confirm("友情提示","是否确定删除？",function(state){
		if(state){
			fun();
		}
	});
};

/**
 * 显示添加成功
 */
ECSINFO.showAddSuccess = function(){
	$.messager.alert("提示","保存成功");
};
/**
 * 显示修改成功
 */
ECSINFO.showUpdateSuccess=function(){
	$.messager.alert("提示","修改成功");
};
/**
 * 显示删除成功
 */
ECSINFO.showDeleteSuccess=function(){
	$.messager.alert("提示","删除成功");
};