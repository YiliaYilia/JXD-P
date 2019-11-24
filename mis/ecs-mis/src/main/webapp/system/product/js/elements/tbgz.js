var Tbgz = function(){};
Tbgz.prototype.coreproductcode = null;

/**
 * 添加按钮
 */
Tbgz.add =  {
		text : ECSINFO.add,
		iconCls : 'icon-add',
		handler : function() {
			var count = $("#tbgzOptions").datagrid('getRows').length;
			$('#tbgz_operate_window').window({
				width : 600,
				height : 420,
				modal : true,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				resizable : false,
				iconCls : 'icon-add',
				title : ECSINFO.add,
				href:"../../system/product/tbgzEdit?operate=add&count="+(count+1)
			}).show();
		}
};

/**
 * 更新按钮
 */
Tbgz.update = {
		text : ECSINFO.update,
		iconCls : 'icon-edit',
		handler : function() {
			var rows =$('#tbgzOptions').datagrid('getChecked');
			if(rows.length != 1){
				ECSINFO.alert_update_unique();
			} else {
				var row = rows[0];
				tbgz.operate = 'update';
				var count = $("#tbgzOptions").datagrid('getRows').length;
				var index = $('#tbgzOptions').datagrid('getRowIndex',row);
				var data = "count="+count;
				data = data + "&geProductInformbook.informcontent="+encodeURIComponent(row['informcontent']);
				data = data + "&geProductInformbook.informoption="+encodeURIComponent(row['informoption']);
				data = data + "&geProductInformbook.informorder="+(index+1);
				$("#showorder").val(index);
				$("#desValue").val(row['informoption']);
				$('#tbgz_operate_window').window({
					width : 600,
					height : 420,
					modal : true,
					collapsible : false,
					minimizable : false,
					maximizable : false,
					resizable : false,
					iconCls : 'icon-edit',
					title : ECSINFO.update,
					href:"../../system/product/tbgzEdit?operate=update&"+data
				}).show();
			}
		}
};

/**
 * 删除按钮
 */
Tbgz.del = {
		text : ECSINFO.del,
		iconCls : 'icon-remove',
		handler : function() {
			var rows =$('#tbgzOptions').datagrid('getChecked');
			var count = rows.length;
	    	if(rows== null || rows.length ==0){
	    		ECSINFO.alert_delete_requried();
	    		return false;
	    	}else{
	    		ECSINFO.confirm_delete(function(){
	    			for ( var int = 0; int < count; int++) {
	    				var index = $('#tbgzOptions').datagrid('getRowIndex',rows[int]);
		    			$('#tbgzOptions').datagrid('deleteRow',index);
					}
	    			$('#tbgzOptions').datagrid('clearChecked');
	    		});
	    	}
		}
};

/**
 * 保存按钮
 */
Tbgz.save = {
		text : '保存',
		iconCls : 'icon-save',
		handler : function() {
			var changes = $('#tbgzOptions').datagrid('getChanges');
			if(changes== null || changes.length ==0){
				$.messager.alert("提示","未更改任何项，无需保存。");
			}else{
				tbgz.saveTbgzOption();
			}
		}
};

/**
 * 工具栏
 */
Tbgz.prototype.toolbar = [];

/**
 * 初始化工具栏
 */
Tbgz.prototype.initToolBar = function(){
	this.toolbar = [];
	this.toolbar.push(Tbgz.add);
	this.toolbar.push("-");
	this.toolbar.push(Tbgz.update);
	this.toolbar.push("-");
	this.toolbar.push(Tbgz.del);
	this.toolbar.push("-");
	this.toolbar.push(Tbgz.save);
};

/**
 * 初始化投保告知项
 */
Tbgz.prototype.createDataGrid = function(){
	this.initToolBar();
	var that = this;
	$('#tbgzOptions').datagrid({
		toolbar : this.toolbar,
		fit : true,
		fitColumns:true,
		rownumbers:true,
		width : $("#tbgzOptions").width(),
		checkbox:true,
		url: "../../system/product/getTbgz?coreproductcode="+that.coreproductcode,
		columns : [ [ {
			checkbox:true,
			field : 'checkbox',
			title : 'checkbox'
		}, {
			field : 'informcontent',
			title : '投保告知项',
			width : ($("#tbgzOptions").width() * 0.85),
			halign: 'center'
		}, {
			field : 'informoption',
			title : '指定值',
			formatter: function(value){
				return value == 'Y' ? '是' : '否';
			},
			halign: 'center',
			align:'center'
		} ] ]
	});
};

/**
 * 新增选项
 */
Tbgz.prototype.newTbgzOption = function(){
	var tbgzOption = FCKeditorAPI.GetInstance("tbgz").GetData();
	var desValue = $("#desValue").val();
	var showorder = $("#showorder").val();
	$('#tbgzOptions').datagrid('insertRow',{
		index: showorder-0,
		row: {
			informcontent: tbgzOption,
			informoption: desValue
		}
	});
	$('#tbgz_operate_window').window('close');
};

/**
 * 更新选项
 */
Tbgz.prototype.updateTbgzOption = function(){
	var tbgzOption = FCKeditorAPI.GetInstance("tbgz").GetData();
	var desValue = $("#desValue").val();
	var showorder = $("#showorder").val();
	var rows =$('#tbgzOptions').datagrid('getChecked');
	var i = $('#tbgzOptions').datagrid('getRowIndex',rows[0]);
	$('#tbgzOptions').datagrid('deleteRow',i);
	$('#tbgzOptions').datagrid('insertRow',{
		index: showorder-0,
		row: {
			informcontent: tbgzOption,
			informoption: desValue
		}
	});
	$('#tbgzOptions').datagrid('clearChecked');
	$('#tbgzOptions').datagrid('selectRow',showorder);
	$('#tbgz_operate_window').window('close');
};

/**
 * 判断是修改还是添加
 */
Tbgz.prototype.addOrUpdate = function(operate){
	if(operate == 'add'){
		this.newTbgzOption();
		return;
	}
	if(operate == 'update'){
		this.updateTbgzOption();
		return;
	}
};

/**
 * 保存投保告知项
 */
Tbgz.prototype.saveTbgzOption = function(){
	var rows = $('#tbgzOptions').datagrid('getRows');
	if(rows== null || rows.length ==0){
		$.messager.alert("提示","无配置任何项，不能保存。");
		return;
	}
	var data = "coreproductcode="+this.coreproductcode;
	for ( var i = 0; i < rows.length; i++) {
		var informcontent = rows[i]['informcontent'];
		var informoption = rows[i]['informoption'];
		var informorder = i+1;
		data = data + "&geProductInformbooks["+i+"].informcontent=" + encodeURIComponent(informcontent);
		data = data + "&geProductInformbooks["+i+"].informoption=" + encodeURIComponent(informoption);
		data = data + "&geProductInformbooks["+i+"].informorder=" + informorder;
	}
	data = data + "&date="+new Date();
	$.ajax({
		type:"POST",
		url:"../product/saveTbgz",
		data:data,
		success:function(data){
			ECSINFO.showAddSuccess();
			$('#tbgzOptions').datagrid('load'); 
			$('#tbgzOptions').datagrid('clearChecked');
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			ECSINFO.alert_system_error();
		}
	});
};

var tbgz = new Tbgz();