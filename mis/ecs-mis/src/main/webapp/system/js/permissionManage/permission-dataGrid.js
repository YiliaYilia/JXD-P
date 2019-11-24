var PermissionManage = function(){};
PermissionManage.prototype.formatItem = function(row){
	var s = '<span style="font-weight:bold">' + row.text + '</span><br/>'
	+ '<span style="color:#888">' + row.desc + '</span>';
return s;
};

PermissionManage.add = {
		text : ECSINFO.add,
		iconCls : 'icon-add',
		handler : function() {
			$("#permissionId").attr("disabled",true);
			$("#permissionName").attr("disabled",true);
			$("#permissionDataDesc").attr("disabled",true);
			$("#permissionName").val("");
			$("#permissionDataDesc").val("");
			$("#permissionId").val("");
			$('#operateType').val("ADD");
			$('#permissionData_add_window').show();
			$('#permissionData_add_window').window({
				width:470,    
			    height:440,    
			    modal:true,
			    collapsible:false,
			    minimizable:false,
			    maximizable:false,
			    resizable:false,
				iconCls : 'icon-add',
				title : ECSINFO.add,
				href:"../system/permissionOperate?operate=ADD"
			});
		}
	};


PermissionManage.update={
		text : ECSINFO.update,
		iconCls : 'icon-edit',
		handler : function() {
			
			var selections = $("#permissionData").datagrid('getSelections');
			if(selections.length == 1){
				var row = selections[0];
				$('#operateType').val("UPDATE");
				$('#permissionData_add_window').show();
				$('#permissionData_add_window').window({
					width:470,    
					height:440,
				    modal:true,
				    collapsible:false,
				    minimizable:false,
				    maximizable:false,
				    resizable:false,
				//	onClose:permission.reloadGrid,
					iconCls : 'icon-edit',
					title : ECSINFO.update,
					href:"../system/permissionOperate?operate=UPDATE&gePermission.permissionid="+row.permissionid
				});
			}else{
				ECSINFO.alert_update_unique();
			}
		}
	};


PermissionManage.del = {
		text : ECSINFO.del,
		iconCls : 'icon-remove',
		handler : function() {
			var selections = $("#permissionData").datagrid('getSelections');
			if(selections.length>=1){
			var deleteId = "";
			$(selections).each(function(index,selection){
				selection = eval(selection);
				deleteId += selection.permissionid+",";
			});
			deleteIds = deleteId.substring(0,deleteId.length-1);    
				ECSINFO.confirm_delete(function(){
					$.ajax({
						url:"../system/deletePermissionDatas",
						data:{"deleteIds":deleteIds},
						success:function(){
							permission.reloadGrid();
						//	$('#permissionData').datagrid('clearChecked');
						}
					});	    	
				});
			}else{
				ECSINFO.alert_delete_requried();
			}
		}
	};



/**
 * 初始化自定义工具栏（搜索框）
 */
PermissionManage.prototype.initOwnToolBar = function(){
	$('.datagrid-toolbar table tr').append("<td></td>");
	$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
} ;

/**
 * 添加或修改权限
 */

PermissionManage.prototype.addUpdatePermission = function(){
		
	var that = this;
	var permissionName = $("#permissionname").val();
	var permissionDataDesc = $("#permissiondatadesc").val();
	var resources = $("#resourceTree").tree('getCheckedExt');	
	var operate = $("#operate").val();
	var data = "gePermission.permissionname="+permissionName+"&gePermission.permissiondatadesc="+permissionDataDesc+"&operate="+operate;
	if(operate=='UPDATE'){
		data = data+"&gePermission.permissionid="+$("#permissionid").val();
	}
	for(var i=0;i<resources.length;i++){
		data = data+"&geResources["+i+"].resourcesid="+resources[i].id;
	}
	data= data+"&date="+new Date();
	$.ajax({
	
		type:"POST",
		url:"../system/addOrUpdatePermission",
		data:data,
		success:function(data){
			$('#permissionData_add_window').window('close');
			$('#permissionData').datagrid('load'); 
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
}
/**
 * 保存权限
 */
PermissionManage.prototype.savePermissionData = function(){
	var permissionName = $("#permissionName").val();
	var permissionDataDesc = $("#permissionDataDesc").val();
    var permissionId =$("#permissionId").val() ;
    var permissionCreateTime = Date();
	$.ajax({
		url:"../system/savePermissionData",
		dataType:"json",
		data:{"permissionId":permissionId,"permissionName":permissionName,"permissionDataDesc":permissionDataDesc,"permissionCreateTime":permissionCreateTime},
		success:function(data){
			data = eval(data);
			if(data.success){
				$.messager.alert("成功",data.value);
			}else{
				$.messager.alert("错误","系统错误");
			}
		}
	});
};


/**
 * 创建表格
 */
PermissionManage.prototype.createPermissionGrid = function(){
	permission.initToolBar();
	$('#permissionData').datagrid({
		url : '../system/searchPermissionData',
		pageSize:20,
		pageList:[15,20,25,30],
		toolbar : permission.toolbar,
		pagination : true,
		fit:true,
		fitColumns:true,
		rownumbers:true,
		checkbox:true,
		loading:"数据加载中...",
	//	idField:"permissionid",
		width:$("#permissionData").width(),
		columns : [ [ {
			field : 'permissionid',
			title : 'ID',
			hidden:true
		}, {
			checkbox:true
		},{
			field : 'permissionname',
			title : '权限名称',
			width : ($("#permissionData").width() * 0.16)
		}, {
			field : 'permissiondatadesc',
			title : '权限描述',
			width : ($("#permissionData").width() * 0.16)
		}, {
			field : 'createtimeformat',
			title : '创建时间',
			width : ($("#permissionData").width() * 0.16)
		} , {
			field : 'operatorname',
			title : '添加/修改人员',
			width : ($("#permissionData").width() * 0.16)
		} ] ]
	});
	permission.initOwnToolBar();
};

/**
 * 初始化基本工具栏
 */
PermissionManage.prototype.initToolBar = function(){
	if(auth.access('RES_AUTH_PERMISSION_ADD')){
		this.toolbar.push(PermissionManage.add);
		this.toolbar.push("-");
	}if(auth.access('RES_AUTH_PERMISSION_UPDATE')){
		this.toolbar.push(PermissionManage.update);
		this.toolbar.push("-");
	}if(auth.access('RES_AUTH_PERMISSION_DEL')){
		this.toolbar.push(PermissionManage.del);
		this.toolbar.push("-");
	}

} ;

/**
 * 刷新表格
 */
PermissionManage.prototype.reloadGrid=function(){
	$("#permissionData").datagrid('reload',{
		permissionname:$("#permissionname-search").val()
	});
};



/**
 * 关闭窗口
 */
PermissionManage.prototype.close = function(){
	permission.reloadGrid();
	$('#permissionData_add_window').window('close');
//	$('#permissionData').datagrid('clearChecked');
};

/**
 * 搜索权限
 */
PermissionManage.prototype.searchPermissionData = function(){
	var permissionname = $("#permissionnameSearch").val();
	$("#permissionData").datagrid('load',{'permissionnameSearch':permissionname});
};

/**
 * 工具栏
 */
PermissionManage.prototype.toolbar = [];
/**
 * 权限名称验证
 */
PermissionManage.prototype.formValidate = function(){
	var that = this;
	$('#addUpdatePermissionForm').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{ //自定义规则 有两种方式 1、EL表达式 2、自定义方法
			permissionname: [/^[^<>]+$/, '不能出现<>字符'], //自定义EL表达式
			/**
			 *@param element 当前验证的DOM元素
			 *@param param 规则传递的参数
			 *@param field 当前字段元数据
			*/
			unique:function(element, param, field){ //自定义方法规则
				
				var data = "operate="+$("#operate").val()+"&permissionname="+$("#permissionname").val()+"&date="+new Date();
				return $.ajax({
					type:"POST",
					url:"../system/existPermission",
					data:data,
					success:function(data){
						return data;
					},
					error:function (XMLHttpRequest, textStatus, errorThrown){
						$.messager.alert('系统异常','验证请等待');
						return false;
					}
				});
			}
		},
		fields:{//那些字段要加入到规则中
			"permissionname":{
				rule:"required;permissionname;unique",
				tip: "不能出现<>字符"
				
			    //ok: "成功后显示"
			    //msg: {required: "全名必填!"}  覆盖默认的提示文字
			}
		},
		valid: function(form){ //验证成功
			permission.addUpdatePermission();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
	});
}

var permission = new PermissionManage();
