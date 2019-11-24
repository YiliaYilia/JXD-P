var DictTypeManage = function(){};
DictTypeManage.prototype.formatItem = function(row){
	var s = '<span style="font-weight:bold">' + row.text + '</span><br/>'
	+ '<span style="color:#888">' + row.desc + '</span>';
return s;
};

/**
 * 验证规则
 */
DictTypeManage.prototype.formValidate = function(){
	var that = this;
	$('#addUpdateDictTypeForm').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{
			/**
			 *@param element 当前验证的DOM元素
			 *@param param 规则传递的参数
			 *@param field 当前字段元数据
			*/
		},
		fields:{//那些字段要加入到规则中
			"dictTypeCodeAuth":{
				rule:"required;filter(<>^%&$*@#!);remote[../system/existDictType, oldCode, operateType]",
				tip: "建议填写英文大写"
			},
			"dictTypeNameAuth":{
				rule:"required",
				tip: "类型的中文名称"
			}
		},
		valid: function(form){ //验证成功
			dicttype.saveDictTypeData();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
		
	});
};

/**
 * 初始化基础工具栏
 */
DictTypeManage.prototype.initToolBar = function(){
	if(auth.access('RES_DIC_MANAGER_DICTYPE_ADD')){
		this.toolbar.push(DictTypeManage.add);
		this.toolbar.push("-");
	}if(auth.access('RES_DIC_MANAGER_DICTYPE_UPDATE')){
		this.toolbar.push(DictTypeManage.update);
		this.toolbar.push("-");
	}if(auth.access('RES_DIC_MANAGER_DICTYPE_DEL')){
		this.toolbar.push(DictTypeManage.del);
		this.toolbar.push("-");
	}

} ;
/**
 * 初始化自定义工具栏
 */
DictTypeManage.prototype.initOwnToolBar = function(){
	$('.datagrid-toolbar table tr').append("<td></td>");
	$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
} ;

/**
 * 保存数据字典
 */
DictTypeManage.prototype.saveDictTypeData = function(){
	var dictTypeCode = $("#dictTypeCode").val();
	var dictTypeName = $("#dictTypeName").val();
	var dictTypeID = $("#dictTypeID").val();

	$.ajax({
		url:"../system/saveDictTypeData?temp="+new Date().getTime(),
		dataType:"json",
		data:{"dictTypeID":dictTypeID,"dictTypeCode":dictTypeCode,"dictTypeName":dictTypeName},
		success:function(data){
			data = eval(data);
			if(data.success){
				dicttype.close1();
				dicttype.reloadGrid();
			}else{
				ECSINFO.alert_system_error();
			}
		}
	});
};

/**
 * 创建表格
 */
DictTypeManage.prototype.createDataGrid = function(){
	
	dicttype.initToolBar();
	
	$('#dicttype').datagrid({
		url : '../system/searchDictTypeData?temp='+new Date().getTime(),
		pageSize:20,
		toolbar : dicttype.toolbar,
		pagination : true,
		fit:true,
		fitColumns:true,
		rownumbers:true,
		checkbox:true,
		width:$("#dictData").width(),
		columns : [ [ {
			field : 'dicttypeid',
			title : 'ID',
			hidden:true
		},{
			checkbox:true
		},{
			field : 'dicttypecode',
			title : '类型代码',
			width : ($("#dicttype").width() * 0.25)
		}, {
			field : 'dicttypename',
			title : '类型名称',
			width : ($("#dicttype").width() * 0.25)
		}, {
			field : 'createtimestr',
			title : '创建时间',
			width : ($("#dicttype").width() * 0.25)
		} , {
			field : 'operatorname',
			title : '创建人',
			width : ($("#dicttype").width() * 0.22)
		} ] ]
	});
	dicttype.initOwnToolBar();
};

/**
 * 刷新表格
 */
DictTypeManage.prototype.reloadGrid=function(){
	$("#dicttype").datagrid('reload',{
		"dictTypeName":$("#dictTypeName-search").val(),
		temp:new Date().getTime()
	});
};

DictTypeManage.add = {
		text : ECSINFO.add,
		iconCls : 'icon-add',
		handler : function() {
			dicttype.formValidate();
			$("#oldCode").val("");
			$("#dictTypeID").val("");
			$("#operateType").val("ADD");
			$("#dictTypeCode").val("");
			$("#dictTypeName").val("");
			$("#dictTypeID").val("");
			$('#dictTypeData_add_window').show();
			$('#dictTypeData_add_window').window({
				width : 450,
				height : 200,
				onClose:dicttype.close,
				modal : true,
			    resizable:false,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				iconCls : 'icon-add',
				title : ECSINFO.add
			});
		}
	};
DictTypeManage.update = {
		text : ECSINFO.update,
		iconCls : 'icon-edit',
		handler : function() {
			dicttype.formValidate();
			var selections = $("#dicttype").datagrid('getSelections');
			$("#operateType").val("UPDATE");
			if(selections.length == 1){
				$('#dictTypeData_add_window').show();
				$('#dictTypeData_add_window').window({
					width : 450,
					height : 200,
					modal : true,
				    resizable:false,
					onClose:dicttype.close,
					collapsible : false,
					minimizable : false,
					maximizable : false,
					iconCls : 'icon-edit',
					title : ECSINFO.update
				});
				
				$(selections).each(function(index,selection){
					selection = eval(selection);
					var editId = selection.dicttypeid;
					$.ajax({
						url:"../system/editDictTypeData?temp="+new Date().getTime(),
						data:{"editId":editId},
						success:function(result){
							result = eval(result);
							if(result.success){
								$("#dictTypeID").val(result.dictTypeID);
								$("#dictTypeCode").val(result.dictTypeCode);
								$("#dictTypeName").val(result.dictTypeName);
								$("#oldCode").val(result.dictTypeCode);
							}else{
								ECSINFO.alert_system_error();
							}
						}
					});
					
				});
			}else{
				ECSINFO.alert_update_unique();
			}
		}
	};
DictTypeManage.del = {
		text : ECSINFO.del,
		iconCls : 'icon-remove',
		handler : function() {
			var selections = $("#dicttype").datagrid('getSelections');
			if(selections.length >= 1){
				var deleteID = "";
				$(selections).each(function(index,selection){
					selection = eval(selection);
					deleteID += selection.dicttypeid+",";
				});
				var deleteIDs = deleteID.substring(0,deleteID.length-1);
				
				ECSINFO.confirm_delete(function(){
					$.ajax({
						url:"../system/deleteDictTypeDatas?temp="+new Date().getTime(),
						data:{"deleteIDs":deleteIDs},
						success:function(){
							dicttype.reloadGrid();
						}
					});	    	
				});
			}else{
				ECSINFO.alert_delete_requried();
			}
			
		
		}
	};

/**
 * 工具栏
 */
DictTypeManage.prototype.toolbar = [];

/**
 * 关闭窗口
 */
DictTypeManage.prototype.close = function(){
	$('addUpdateDictTypeForm').validator('hideMsg', '#dictTypeCode');
	$('addUpdateDictTypeForm').validator('hideMsg', '#dictTypeName');
	$('#addUpdateDictTypeForm').validator('destroy');
};
/**
 * 关闭窗口
 */
DictTypeManage.prototype.close1 = function(){
	$('#dictTypeData_add_window').window('close');
};

/**
 * 搜索数据字典
 */
DictTypeManage.prototype.searchDictTypeData = function(){
	var dictTypeName = $("#dictTypeName-search").val();
	$("#dicttype").datagrid('load',{'dictTypeName':dictTypeName});
};


var dicttype = new DictTypeManage();



















