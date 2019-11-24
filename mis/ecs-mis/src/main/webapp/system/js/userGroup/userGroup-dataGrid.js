var UserGroup = function(){};
UserGroup.prototype.formatItem = function(row){
	var s = '<span style="font-weight:bold">' + row.text + '</span><br/>'
	+ '<span style="color:#888">' + row.desc + '</span>';
return s;
};

/**
 * 添加用户组
 */
UserGroup.add = {
	text: ECSINFO.add,
    iconCls: 'icon-add',
    handler:function(){
    	//弹出添加角色窗口
    	$('#userGroup_add_window').window({ 
		    width:450,    
		    height:380,    
		    modal:true,
		    collapsible:false,
		    minimizable:false,
		    maximizable:false,
		    resizable:false,
		    iconCls:'icon-add',
		    title: ECSINFO.add,
		    href:"../system/userGroupRole?operate=ADD"
		}).show(); 
    }
};
/**
 * 更新用户组
 */
UserGroup.update = {
	text: ECSINFO.update,
    iconCls: 'icon-edit',
    handler:function(){
    	var rows =$('#UserGroupDate').datagrid('getSelections');
    	if(rows.length != 1){
    		$.messager.alert('提示','修改只能选择单条记录');
    		return false;
    	}else{
    		var row = rows[0];
    		//弹出添加角色窗口
        	$('#userGroup_add_window').window({ 
    		    width:450,    
    		    height:380,    
    		    modal:true,
    		    collapsible:false,
    		    minimizable:false,
    		    maximizable:false,
    		    resizable:false,
    		    iconCls:'icon-edit',
    		    title:ECSINFO.update,
    		    href:"../system/userGroupRole?operate=UPDATE&geGroup.usergroupid="+row.usergroupid
    		}).show(); 
    	}
    	
    }
};
/**
 * 删除用户组
 */
UserGroup.del = {
	text : ECSINFO.del,
	iconCls : 'icon-remove',
	handler : function() {
		var selections = $("#UserGroupDate").datagrid('getSelections');
		if(selections.length >= 1){
			ECSINFO.confirm_delete(function(){
				var deleteName = "";
				var deleteId = "";
				$(selections).each(function(index,selection){
					selection = eval(selection);
					deleteName += selection.usergroupname+",";
					deleteId += selection.usergroupid+",";
				});
				deleteName = deleteName.substring(0,deleteName.length-1);
				deleteIds = deleteId.substring(0,deleteId.length-1);
				$.ajax({
					url:"../system/deleteUserGroups",
					data:{"deleteIds":deleteIds},
					success:function(){
						ugp.reloadGrid();
				//		$('#UserGroupDate').datagrid('clearChecked');
					},
					error:function (XMLHttpRequest, textStatus, errorThrown){
        				ECSINFO.alert_system_error();
        			}
				});	  
			});
		}else{
			ECSINFO.alert_delete_requried();
		}
	}
};

UserGroup.prototype.toolbar =[];

UserGroup.prototype.initToolBar = function(){
	if(auth.access('RES_AUTH_USERGROUP_ADD')){
		this.toolbar.push(UserGroup.add);
		this.toolbar.push("-");
	}
	if(auth.access('RES_AUTH_USERGROUP_UPDATE')){
		this.toolbar.push(UserGroup.update);
		this.toolbar.push("-");
	}
	if(auth.access('RES_AUTH_USERGROUP_DEL')){
		this.toolbar.push(UserGroup.del);
		this.toolbar.push("-");
	}
};

UserGroup.prototype.initOwnToolBar = function(){
		$('.datagrid-toolbar table tr').append("<td></td>");
		$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
};

/**
 * 验证规则
 */
UserGroup.prototype.formValidate = function(){
	$('#addUserGroupForm').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{
			usergroupname: [/^[^<>]+$/, '不能出现<>字符'], //自定义EL表达式
			/**
			 *@param element 当前验证的DOM元素
			 *@param param 规则传递的参数
			 *@param field 当前字段元数据
			*/
			unique:function(element, param, field){
				
				var data = "operate="+$("#operate").val()+"&geGroup.usergroupname="+$("#usergroupname").val()+"&date="+new Date();
				return $.ajax({
					type:"POST",
					url:"../system/existUserGroup",
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
			"geGroup.usergroupname":{
				rule:"required;usergroupname;unique",
				tip: "不能出现<>字符"
			    //ok: "成功后显示"
			    //msg: {required: "全名必填!"}  覆盖默认的提示文字
			}
		},
		valid: function(form){ //验证成功
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
	});
};

/**
 * 创建表格
 */
UserGroup.prototype.createDataGrid = function(){
	ugp.initToolBar();
	$('#UserGroupDate').datagrid({
		url : '../system/searchUserGroupData',
		pageSize:20,
		toolbar : ugp.toolbar,
		checkOnSelect:true,
		pagination : true,
		fit:true,
		fitColumns:true,
		rownumbers:true,
		checkbox:true,
		title:"",
		pageSize:15,
		pageList:[10,15,20],
		loading:"数据加载中...",
	//	idField:"usergroupid",
		width:$("#UserGroupDate").width(),
		columns : [ [ {
			checkbox:true,
			field : 'checkbox'
		},{
			field : 'usergroupname',
			title : '用户组名称',
			width : ($("#UserGroupDate").width()*0.3)
		},{
			field : 'usergroupdesc',
			title : '用户组描述',
			width : ($("#UserGroupDate").width()*0.3)
		},{
			field : 'timeString',
			title : '创建时间',
			width : ($("#UserGroupDate").width()*0.2)
		},{
			field : 'operatorname',
			title : '添加/修改人员',
			width : ($("#UserGroupDate").width()*0.19)
		} ] ]
	});
	ugp.initOwnToolBar();
};


UserGroup.prototype.reloadGrid=function(){
	$("#UserGroupDate").datagrid('reload',{
		usergroupname:$("#usergroupnameSearch").val()
	});
};

/**
 * 关闭窗口
 */
UserGroup.prototype.close = function(){
	ugp.reloadGrid();
	$('#userGroup_add_window').window('close');
//	$('#UserGroupDate').datagrid('clearChecked');
};
/**
 * 关闭窗口不重载
 */
UserGroup.prototype.closeNoReload = function(){
	$('#userGroup_add_window').window('close');
};

/**
 * 搜索用户组
 */
UserGroup.prototype.searchUserGroupData = function(){
	var usergroupname = $("#usergroupnameSearch").val();
	if(typeof(usergroupname)=='undefined'){
		usergroupname="";
	}
	else{
		usergroupname=usergroupname.replace(/\s+/g,"");
	}
	$("#UserGroupDate").datagrid('load',{'usergroupnameSearch':usergroupname});
};

/**
 * 添加权限
 */
UserGroup.prototype.addRole = function(){
	var roles = $("#allRole option:selected");
	
	for(var i=0;i<roles.length;i++){
		//如果选中的已经存在
		if(typeof($("#ownRole option[value='"+$(roles[i]).val()+"']").val())!='undefined'){
			//alert($(roles[i]).val());
		}
		else{
			$("#ownRole").append($(roles[i]));
		}
		
	}
	
	
};
/**
 * 移除权限
 */
UserGroup.prototype.removeRole = function(){
	var roles = $("#ownRole option:selected");
	for(var i=0;i<roles.length;i++){
		//如果选中的已经存在
		if(typeof($("#allRole option[value='"+$(roles[i]).val()+"']").val())!='undefined'){
			//alert($(roles[i]).val());
		}
		else{
			$("#allRole").append($(roles[i]));
		}
		
		
	}
};

/**
 * 添加或者修改用户组
 */
UserGroup.prototype.addUpdateUserGroup = function(){
	var usergroupname = $("#usergroupname").val();
	var usergroupdesc = $("#usergroupdesc").val();
	var roles = $("#ownRole option");
	var operate = $("#operate").val();
	
	var data = "geGroup.usergroupname="+usergroupname+"&geGroup.usergroupdesc="+usergroupdesc+"&operate="+operate;
	if(operate=='UPDATE'){
		data = data+"&geGroup.usergroupid="+$("#usergroupid").val();
	}
	for(var i=0;i<roles.length;i++){
		data = data+"&geRoles["+i+"].roleid="+$(roles[i]).val();
	}
	
	$.ajax({
		type:"POST",
		url:"../system/addUserGroupRole",
		data:data,
		success:function(data){
			ugp.close(); 
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			ECSINFO.alert_system_error();
		}
	});
};

var ugp = new UserGroup();