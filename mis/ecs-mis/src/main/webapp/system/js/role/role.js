var Role = function(){};
Role.prototype.ctx = null;

Role.add = {
	    text: ECSINFO.add,
	    iconCls: 'icon-add',
	    handler:function(){
	    	//弹出添加角色窗口
	    	$('#role_addUpdate_window').window({ 
			    width:450,    
			    height:430,    
			    modal:true,
			    collapsible:false,
			    minimizable:false,
			    maximizable:false,
			    resizable:false,
			    iconCls:'icon-add',
			    title:ECSINFO.add,
			    href:"../system/roleOperate?operate=ADD"
			}).show(); 
	    }
};

Role.update={

	    text: ECSINFO.update,
	    iconCls: 'icon-edit',
	    handler:function(){
	    	var rows =$('#roleDatagrid').datagrid('getChecked');
	    	if(rows== null || rows.length != 1){
	    		ECSINFO.alert_update_unique();
	    		return false;
	    	}else{
	    		var row = rows[0];
	    		//弹出添加角色窗口
	        	$('#role_addUpdate_window').window({ 
	    		    width:450,    
	    		    height:430,    
	    		    modal:true,
	    		    collapsible:false,
	    		    minimizable:false,
	    		    maximizable:false,
	    		    resizable:false,
	    		    iconCls:'icon-edit',
	    		    title:ECSINFO.update,
	    		    href:"../system/roleOperate?operate=UPDATE&geRole.roleid="+row.roleid
	    		}).show(); 
	    	}
	    	
	    }
};


Role.del={

	    text: ECSINFO.del,
	    iconCls: 'icon-remove',
	    handler:function(){
	    	var rows =$('#roleDatagrid').datagrid('getChecked');
	    	
	    	if(rows== null || rows.length ==0){
	    		ECSINFO.alert_delete_requried();
	    		return false;
	    	}else{
	    		ECSINFO.confirm_delete(function(){
	    			var data = "";
	        		for(var i=0;i<rows.length;i++){
	        			data = data+"&roleids="+rows[i].roleid;
	        		}
	        		data = data+"&date="+new Date();
	        		$.ajax({
	        			type:"POST",
	        			url:"../system/deleteRole",
	        			data:data,
	        			success:function(data){
	        				$('#roleDatagrid').datagrid('load'); 
	        				$('#roleDatagrid').datagrid('clearChecked');
	        			},
	        			error:function (XMLHttpRequest, textStatus, errorThrown){
	        				ECSINFO.alert_system_error();
	        			}
	        		});
	        		
	    		});
            	
	    	}
	    }
};




Role.prototype.toolbar =[];



Role.prototype.createRoleTreeGrid = function(){
	var that = this;
	that.initToolBar();
	$('#roleDatagrid').datagrid({
		fit:true,
		toolbar : that.toolbar,
		checkOnSelect:true,
		pagination : true,
		rownumbers:true,
		fitColumns:true,
		title:"",
		pageSize:15,
		pageList:[10,15,20],
		idField:"roleid",
		columns : [ [
         {
 			field : 'ck',
 			checkbox:true
 		},
		 {
			field : 'rolename',
			title : '角色名称',
			width : ($("#roleDatagrid").width() * 0.25)
		}, {
			field : 'roledesc',
			title : '角色描述',
			width : ($("#roleDatagrid").width() * 0.25)
		}, {
			field : 'createtime',
			title : '创建时间',
			width : ($("#roleDatagrid").width() * 0.25)
		}, {
			field : 'operatorname',
			title : '添加/修改人员',
			width : ($("#roleDatagrid").width() * 0.25)
		} ] ]
	});
	
	that.initOwnToolBar();
	that.loadData();
	
};

Role.prototype.initToolBar = function(){
	if(auth.access('RES_AUTH_ROLE_ADD')){
		this.toolbar.push(Role.add);
		this.toolbar.push("-");
	}
	if(auth.access('RES_AUTH_ROLE_UPDATE')){
		this.toolbar.push(Role.update);
		this.toolbar.push("-");
	}
	if(auth.access('RES_AUTH_ROLE_DEL')){
		this.toolbar.push(Role.del);
		this.toolbar.push("-");
	}
}

Role.prototype.initOwnToolBar = function(){
		$('.datagrid-toolbar table tr').append("<td></td>");
		$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
}

/**
 * 开始加载数据
 */
Role.prototype.loadData = function(){
	var that =this;
	$('#roleDatagrid').datagrid('options').url = that.ctx+"/system/getRoles";
	var pagination = $('#roleDatagrid').datagrid("getPager");
	if(pagination){
		$(pagination).pagination({
			
		});
	}
}
/**
 * 查询数据
 * @param rolename 按角色名称查询
 */
Role.prototype.searchData = function(rolename){
	if(typeof(rolename)=='undefined'){
		rolename="";
	}
	else{
		rolename=rolename.replace(/\s+/g,"");
	}
	 $('#roleDatagrid').datagrid('load',{  
	        "geRole.rolename": rolename
	 });  
}

/**
 * 添加权限
 */
Role.prototype.addPermission = function(){
	var permissions = $("#allPermission option:selected");
	
	//var ownPermissions = $("#ownPermission option");

	for(var i=0;i<permissions.length;i++){
		//如果选中的已经存在
		if(typeof($("#ownPermission option[value='"+$(permissions[i]).val()+"']").val())!='undefined'){
			//alert($(permissions[i]).val());
		}
		else{
			$("#ownPermission").append($(permissions[i]));
		}
		
		
	}
	
	
}
/**
 * 移除权限
 */
Role.prototype.removePermission = function(){
	var permissions = $("#ownPermission option:selected");
	for(var i=0;i<permissions.length;i++){
		//如果选中的已经存在
		if(typeof($("#allPermission option[value='"+$(permissions[i]).val()+"']").val())!='undefined'){
			//alert($(permissions[i]).val());
		}
		else{
			$("#allPermission").append($(permissions[i]));
		}
		
		
	}
}


/**
 * 添加或者修改角色
 */
Role.prototype.addUpdateRole = function(){
	var that = this;
	var rolename = $("#rolename").val();
	var roledesc = $("#roledesc").val();
	var permissions = $("#ownPermission option");
	var operate = $("#operate").val();
	
	var data = "geRole.rolename="+rolename+"&geRole.roledesc="+roledesc+"&operate="+operate;
	if(operate=='UPDATE'){
		data = data+"&geRole.roleid="+$("#roleid").val();
	}
	for(var i=0;i<permissions.length;i++){
		data = data+"&gePermissions["+i+"].permissionid="+$(permissions[i]).val();
	}
	data= data+"&date="+new Date();
	
	$.ajax({
		type:"POST",
		url:that.ctx+"/system/addOrUpdateRole",
		data:data,
		success:function(data){
			$('#role_addUpdate_window').window('close');
			$('#roleDatagrid').datagrid('load'); 
			$('#roleDatagrid').datagrid('clearChecked');
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			ECSINFO.alert_system_error();
		}
	});
	 
}

Role.prototype.formValidate = function(){
	var that = this;
	$('#addUpdateRoleForm').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{ //自定义规则 有两种方式 1、EL表达式 2、自定义方法
			rolename: [/^[^<>]+$/, '不能出现<>字符'], //自定义EL表达式
			/**
			 *@param element 当前验证的DOM元素
			 *@param param 规则传递的参数
			 *@param field 当前字段元数据
			*/
			unique:function(element, param, field){ //自定义方法规则
				
				var data = "operate="+$("#operate").val()+"&geRole.rolename="+$("#rolename").val()+"&date="+new Date();
				return $.ajax({
					type:"POST",
					url:that.ctx+"/system/existRole",
					data:data,
					success:function(data){
						return data;
					},
					error:function (XMLHttpRequest, textStatus, errorThrown){
						ECSINFO.alert_system_error();
						return false;
					}
				});
			}
		},
		fields:{//那些字段要加入到规则中
			"geRole.rolename":{
				rule:"required;rolename;unique",
				tip: "不能出现<>字符"
			    //ok: "成功后显示"
			    //msg: {required: "全名必填!"}  覆盖默认的提示文字
			}
		},
		valid: function(form){ //验证成功
			role.addUpdateRole();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
		
	});
}
