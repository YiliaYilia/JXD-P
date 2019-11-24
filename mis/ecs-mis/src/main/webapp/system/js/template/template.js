var Template = function(){};
Template.prototype.formatItem = function(row){
	var s = '<span>' + row.desc + '</span>';
return s;
};




/**
 * 工具栏
 */
Template.prototype.toolbar = [];

/**
 * 重新加载表格数据
 */
Template.prototype.reloadData=function(){
	$('#templatedata').datagrid('reload');
};
/**
 * 添加工具栏
 */
Template.add = {
		text:ECSINFO.add,
		iconCls: 'icon-add',
		handler: function(){
			temp.cleanvalue();
			temp.cleanTips("template_add");
			temp.validateTemplate();
			$("#template_add").show();
			$('#template_add').window({
				modal : true,
				resizable:false,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				width:450,
				iconCls : 'icon-add',
				title : ECSINFO.add,
				onBeforeClose:function(){
					temp.cleanTips("template_add");
				}
			});
		}
};

/**
 * 修改工具栏
 */
Template.update = {
		text:ECSINFO.update,
		iconCls: 'icon-edit',
		handler: function(){
			temp.validateTemplate();
			temp.cleanTips("template_update");
			var selections = $("#templatedata").datagrid('getSelections');
			if(selections.length == 1){
				$("#template_update").show();
				$("#template_update").find('.tempname').val(selections[0].tempname);
				$("#template_update").find('#type').val(selections[0].typecode);
				$("#template_update").find('#function').val(selections[0].functioncode);
				$("#template_update").find('#tempid').val(selections[0].tempid);
				$("#template_update").find('.tempcontent').val(selections[0].tempcontent);
				$('#template_update').window({
					modal : true,
					resizable:false,
					collapsible : false,
					minimizable : false,
					maximizable : false,
					width:450,
					iconCls : 'icon-edit',
					title : ECSINFO.update,
					onBeforeClose:function(){
						temp.cleanTips("template_update");
					}
				});
			} else {
				ECSINFO.alert_update_unique();
			}
		}
};

/**
 * 删除工具栏
 */
Template.del = {
		text:ECSINFO.del,
		iconCls: 'icon-remove',
		handler: function(){
			var selections = $("#templatedata").datagrid('getSelections');
			templateList = [];
			if(selections.length > 0){
				var ids = "";
				$(selections).each(function(index,selection){
					ids = ids + selection.tempid + ",";
				});
				ECSINFO.confirm_delete(function(){
					if(temp.todeleteTemplate(ids)){
						temp.reloadData();
					}
				});
				
			} else {
				ECSINFO.alert_delete_requried();
			}
			
		}
};


/**
 * 初始化工具栏
 */
Template.prototype.initToolbar=function(){
	if(auth.access('RES_TEMP_TEMPLATE_ADD')){
		this.toolbar.push(Template.add);
		this.toolbar.push("-");
	}if(auth.access('RES_TEMP_TEMPLATE_UPDATE')){
		this.toolbar.push(Template.update);
		this.toolbar.push("-");
	}if(auth.access('RES_TEMP_TEMPLATE_DEL')){
		this.toolbar.push(Template.del);
		this.toolbar.push("-");
	}
};

/**
 * 修改短信模版（调用action）
 */
Template.prototype.updateTemplate=function() {
	var tempname = $("#template_update").find('.tempname').val();
	var typecode = $("#template_update").find('#type').find("option:selected").val();
	var funcode = $("#template_update").find('#function').find("option:selected").val();
	var tempcontent = $("#template_update").find('.tempcontent').val();
	var tempid = $("#template_update").find('#tempid').val();
	$.ajax({
		url : "../system/updateTemplate",
		dataType : "text",
		type: "post",
		async : false,
		data : {
			"tempid" : tempid,
			"tempname" : tempname,
			"typecode" : typecode,
			"funcode" : funcode,
			"tempcontent" : tempcontent,
			"date":new Date().getTime()
		},
		success : function(result) {
			temp.closewindowdiv("template_update");
			if (result == "success") {
				temp.reloadData();
			} else {
				ECSINFO.alert_system_error();
			}
		}
	});
};

/**
 * 删除短信模版（调用action）
 */
Template.prototype.todeleteTemplate=function(getmpids) {
	var isRight = false;
	$
			.ajax({
				url : "../system/deleteTemplate",
				dataType : "text",
				async : false,
				data : {
					"getmpids" : getmpids,
					"date":new Date()
				},
				success : function(data) {
					if (data == "success") {
						isRight = true;
					} else {
						ECSINFO.alert_system_error();
					}
				}
			});
	return isRight;
};

/**
 * 添加短信模板
 */
Template.prototype.addTemplate=function() {
	
		var tempname = $("#template_add").find('.tempname').val();
		var typecode = $("#template_add").find('#type').find("option:selected").val();
		var funcode = $("#template_add").find('#function').find("option:selected").val();
		var tempcontent = $("#template_add").find('.tempcontent').val();
		
		$.ajax({
			url : "../system/addTemplate",
			dataType : "text",
			type: "post",
			async : false,
			data : {
				"tempname" : tempname,
				"typecode" : typecode,
				"funcode" : funcode,
				"tempcontent" : tempcontent,
				"date":new Date().getTime()
			},
			success : function(result) {
				temp.closewindowdiv("template_add");
				if (result == "success") {
					temp.reloadData();
				} else {
					ECSINFO.alert_system_error();
				}
			}
		});
	
};

/**
 * 验证说填写内容
 * @param divid
 * @returns {Boolean}
 */
Template.prototype.validateTemplate=function(){
	$('#templateUpdateForm').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{
			unique:function(element, param, field){
				var tempid = $("#template_update").find('#tempid').val();
				var typecode = $("#template_update").find('#type').find("option:selected").val();
				var funcode = $("#template_update").find('#function').find("option:selected").val();
				var tempname = element.value;
				if("" != tempid){
					return $.ajax({
						url:"../system/exitsTmplate",
						async:false,
						data:{
							"tempid":tempid,
							"tempname":tempname,
							"typecode":typecode,
							"funcode":funcode,
							"funtype":"UPDATE",
							"date":new Date().getTime()
						},
						success:function(result){
							return result;
						}
					});
				}
			}
		},
		fields:{//那些字段要加入到规则中
			"tempname":{
				rule:"模板名称:required;unique"
			},
			"tempcontent":{
				rule:"模板内容:required"
			}
		},
		valid: function(form){ //验证成功
			temp.updateTemplate();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
	});
	$('#templateAddForm').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{
			unique:function(element, param, field){
				var tempname = element.value;
				var typecode = $("#template_add").find('#type').find("option:selected").val();
				var funcode = $("#template_add").find('#function').find("option:selected").val();
				if("" != tempname){
					return $.ajax({
						url:"../system/exitsTmplate",
						async:false,
						data:{
							"typecode":typecode,
							"funcode":funcode,
							"tempname":tempname,
							"funtype":"ADD",
							"date":new Date().getTime()
						},
						success:function(result){
							return result;
						}
					});
				}
			}
		},
		fields:{//那些字段要加入到规则中
			"tempname":{
				rule:"模板名称:required;unique"
			},
			"tempcontent":{
				rule:"模板内容:required"
			}
		},
		valid: function(form){ //验证成功
			temp.addTemplate();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
	});
};

/**
 * 关闭显示窗口
 */
Template.prototype.closewindowdiv=function(divid) {
	temp.cleanTips(divid);
	$('#' + divid).validator('destroy');
	$("#" + divid).window('close');
};

/**
 * 清楚消息提示
 * @param divid
 */
Template.prototype.cleanTips=function(divid){
	$('#' + divid).validator('hideMsg', '.tempcontent');
	$('#' + divid).validator('hideMsg', '.tempname');
};

/**
 * 清除所填写的内容
 */
Template.prototype.cleanvalue=function(){
	$("#template_add").find('.tempname').val("");
	$("#template_add").find('.tempcontent').val("");
};

/**
 * 搜索短息模板
 */
Template.prototype.searchTemplate=function(){
	var tempname = $("#rolename-search").val();
	$('#templatedata').datagrid('load',{"tempname" : tempname});
};

/**
 * 创建toolbar
 */
Template.prototype.createToolbar=function(){
	$('.datagrid-toolbar table tr').append("<td></td>");
	$('#template_search table').appendTo('.datagrid-toolbar table tr td:last');
};


var temp = new Template();