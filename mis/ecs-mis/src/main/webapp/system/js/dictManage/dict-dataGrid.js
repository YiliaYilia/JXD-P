var DictManage = function(){};
DictManage.prototype.formatItem = function(row){
	var s = '<span>' + row.desc + '</span>';
return s;
};

DictManage.prototype.refreshSearchCbx = function(){
	$('#dicttypeid-search').combobox('reload','../system/findAllDictType?temp='+new Date().getTime());
};

DictManage.add = {
		text : ECSINFO.add,
		iconCls : 'icon-add',
		handler : function() {
			dict.formValidate();
			$("#oldCode").val("");
			$("#dictDataID").val("");
			$("#dictDataName").attr("disabled",true);
			$("#dictDataCode").attr("disabled",true);
			$("#dictDataDesc").attr("disabled",true);
			$("#dictDataCode").val("");
			$("#dictDataDesc").val("");
			$("#dictDataName").val("");
			$('#operateType').val("ADD");
			$('#dicttypeid-cbx').combobox({
					onSelect:function(record){
						$("#dictDataName").attr("disabled",false);
						$("#dictDataCode").attr("disabled",false);
						$("#dictDataDesc").attr("disabled",false);
					}
			});
			$('#dicttypeid-cbx').combobox('reload','../system/findAllDictType?temp='+new Date().getTime());
			$("#dicttypeid-cbx").combobox("select","");
			$('#dictData_add_window').show();
			$('#dictData_add_window').window({
				width : 450,
				height : 250,
				modal : true,
			    resizable:false,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				iconCls : 'icon-add',
				onClose:dict.close,
				title : ECSINFO.add
			});
		}
	};

DictManage.update={
		text : ECSINFO.update,
		iconCls : 'icon-edit',
		handler : function() {
			dict.formValidate();
			var selections = $("#dictData").datagrid('getSelections');
			if(selections.length == 1){
				$('#operateType').val("UPDATE");
				$('#dicttypeid-cbx').combobox({
					onSelect:function(record){
						$("#dictDataName").attr("disabled",false);
						$("#dictDataCode").attr("disabled",false);
						$("#dictDataDesc").attr("disabled",false);
					}
				});
				$('#dicttypeid-cbx').combobox('reload','../system/findAllDictType?temp='+new Date().getTime());
				$('#dictData_add_window').show();
				$('#dictData_add_window').window({
					width : 450,
					height : 250,
					modal : true,
				    resizable:false,
					collapsible : false,
					minimizable : false,
					maximizable : false,
					onClose:dict.close,
					iconCls : 'icon-edit',
					title : ECSINFO.update
				});
				
				$(selections).each(function(index,selection){
					selection = eval(selection);
					var editId = selection.dictdataid;
					$.ajax({
						url:"../system/editDictData?temp="+new Date().getTime(),
						data:{"editId":editId},
						success:function(result){
							result = eval(result);
							if(result.success){
								$("#dictDataID").val(result.dictdataid);
								$("#dictDataCode").val(result.dictdatacode);
								$("#dictDataDesc").val(result.dictdatadesc);
								$("#dictDataName").val(result.dictdataname);
								$("#oldCode").val(result.dictdatacode);
								$("#oldID").val(result.dicttypeid);
								$("#dicttypeid-cbx").combobox("select",result.dicttypeid);
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

DictManage.del = {
		text : ECSINFO.del,
		iconCls : 'icon-remove',
		handler : function() {
			var selections = $("#dictData").datagrid('getSelections');
			if(selections.length >= 1){
				var deleteName = "";
				var deleteId = "";
				$(selections).each(function(index,selection){
					selection = eval(selection);
					deleteId += selection.dictdataid+",";
				});
				var deleteIds = deleteId.substring(0,deleteId.length-1);
				ECSINFO.confirm_delete(function(){
					$.ajax({
						url:"../system/deleteDictDatas?temp="+new Date().getTime(),
						data:{"deleteIds":deleteIds},
						success:function(){
							dict.reloadGrid();
						}
					});	    	
				});
			}else{
				ECSINFO.alert_delete_requried();
			}
			
		
		}
	};


/**
 * 验证规则
 */
DictManage.prototype.formValidate = function(){
	var that = this;
	$('#addUpdateDictDataForm').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{
			/**
			 *@param element 当前验证的DOM元素
			 *@param param 规则传递的参数
			 *@param field 当前字段元数据
			*/
			unique:function(element, param, field){
				var codeAuth = $("#dictDataCode").val();
				var v = $('#addUpdateDictDataForm').validator().data('validator');
				if(""!=codeAuth){
					return $.ajax({
						url:"../system/existDictData?temp="+new Date().getTime(),
						async:false,
						data:{
							"oldCode":$('#oldCode').val(),
							"oldID":$('#oldID').val(),
							"operateType":$('#operateType').val(),
							"dicttypeid":$("#dicttypeid-cbx").combobox('getValue'),
							"dictDataCodeAuth":codeAuth
						},
						success:function(result){
							return result;
						}
					});
				}
			}
		},
		fields:{//那些字段要加入到规则中
			"dictDataCodeAuth":{
				rule:"required;unique",
				tip: "建议填写英文或缩写"
			    //ok: "成功后显示"
			    //msg: {required: "全名必填!"}  覆盖默认的提示文字
			},
			"dictDataNameAuth":{
				rule:"required",
				tip: "该代码的中文内容"
			}
		},
		valid: function(form){ //验证成功
			dict.saveDictData();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
	});
};

/**
 * 初始化基本工具栏
 */
DictManage.prototype.initToolBar = function(){
	if(auth.access('RES_DIC_MANAGER_DIC_ADD')){
		this.toolbar.push(DictManage.add);
		this.toolbar.push("-");
	}if(auth.access('RES_DIC_MANAGER_DIC_UPDATE')){
		this.toolbar.push(DictManage.update);
		this.toolbar.push("-");
	}if(auth.access('RES_DIC_MANAGER_DIC_DEL')){
		this.toolbar.push(DictManage.del);
		this.toolbar.push("-");
	}

} ;

/**
 * 初始化自定义工具栏（搜索框）
 */
DictManage.prototype.initOwnToolBar = function(){
	$('.datagrid-toolbar table tr').append("<td></td>");
	$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
} ;

/**
 * 保存数据字典
 */
DictManage.prototype.saveDictData = function(){
	var dictTypeId = $("#dicttypeid-cbx").combobox('getValue');
	var dictDataCode = $("#dictDataCode").val();
	var dictDataDesc = $("#dictDataDesc").val();
	var dictDataName = $("#dictDataName").val();
	var dictDataID = $("#dictDataID").val();
	$.ajax({
		url:"../system/saveDictData?temp="+new Date().getTime(),
		dataType:"json",
		data:{"dictTypeID":dictTypeId,"dictDataCode":dictDataCode,"dictDataDesc":dictDataDesc,"dictDataName":dictDataName,"dictDataID":dictDataID},
		success:function(data){
			dict.close1();
			data = eval(data);
			if(data.success){
				dict.reloadGrid();
				$("#oldCode").val(data.oldCode);
			}else{
				ECSINFO.alert_system_error();
			}
		}
	});
};


/**
 * 创建表格
 */
DictManage.prototype.createDataGrid = function(){
	dict.initToolBar();
	$('#dictData').datagrid({
		url : '../system/searchDictData?temp='+new Date().getTime(),
		onLoadSuccess:dict.refreshSearchCbx,
		pageSize:20,
		pageList:[15,20,25,30],
		toolbar : dict.toolbar,
		pagination : true,
		fit:true,
		fitColumns:true,
		rownumbers:true,
		checkbox:true,
		width:$("#dictData").width(),
		columns : [ [ {
			field : 'dictdataid',
			title : 'ID',
			hidden:true
		}, 
		{
			checkbox:true
		},{
			field : 'dicttypecode',
			title : '所属类型 ',
			width : ($("#dictData").width() * 0.16)
		}, {
			field : 'dicttypename',
			title : '所属类型 ',
			width : ($("#dictData").width() * 0.16)
		}, {
			field : 'dictdatacode',
			title : '代码',
			width : ($("#dictData").width() * 0.16)
		}, {
			field : 'dictdataname',
			title : '内容',
			width : ($("#dictData").width() * 0.16)
		} , {
			field : 'dictdatadesc',
			title : '描述',
			width : ($("#dictData").width() * 0.16)
		}, {
			field : 'createtimestr',
			title : '创建时间',
			width : ($("#dictData").width() * 0.18)
		} , {
			field : 'operatorname',
			title : '创建人',
			width : ($("#dictData").width() * 0.16)
		} ] ]
	});

	dict.initOwnToolBar();
};

/**
 * 刷新表格
 */
DictManage.prototype.reloadGrid=function(){
	$("#dictData").datagrid('reload',{
		dictTypeID:$("#dicttypeid-search").combobox('getValue'),
		temp:new Date().getTime()
	});
};

/**
 * 工具栏
 */
DictManage.prototype.toolbar = [];

/**
 * 关闭窗口
 */
DictManage.prototype.close = function(){
	$('#addUpdateDictDataForm').validator('hideMsg', '#dictDataCode');
	$('#addUpdateDictDataForm').validator('hideMsg', '#dictDataName');
	$('#addUpdateDictDataForm').validator('destroy');
};

/**
 * 关闭窗口1
 */
DictManage.prototype.close1 = function(){
	$('#dictData_add_window').window('close');
};

/**
 * 搜索数据字典
 */
DictManage.prototype.searchDictData = function(){
	var dictTypeID = $("#dicttypeid-search").combobox('getValue');
	$("#dictData").datagrid('load',{'dictTypeID':dictTypeID});
};


var dict = new DictManage();



















