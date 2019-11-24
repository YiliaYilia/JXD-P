var UserManage = function(){};
UserManage.prototype.ctx = null;

/**
 * 添加按钮
 */
UserManage.add =  {
		text : ECSINFO.add,
		iconCls : 'icon-add',
		handler : function() {
			$('#operate_window').window({
				width : 460,
				height : 420,
				modal : true,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				resizable : false,
				iconCls : 'icon-add',
				title : ECSINFO.add,
				href:"../system/userOperate?operate=add"
			}).show();
		}
};

/**
 * 更新按钮
 */
UserManage.update = {
		text : ECSINFO.update,
		iconCls : 'icon-edit',
		handler : function() {
			var selections = $("#userData").datagrid('getSelections');
			if(selections.length != 1){
				ECSINFO.alert_update_unique();
			} else {
				var row = selections[0];
				$('#operate_window').window({
					width : 460,
					height : 420,
					modal : true,
					collapsible : false,
					minimizable : false,
					maximizable : false,
					resizable : false,
					iconCls : 'icon-edit',
					title : ECSINFO.update,
					href:"../system/userOperate?operate=update&geUser.userid=" + row.userid+"&date="+new Date()
				}).show();
			}
		}
};

/**
 * 删除按钮
 */
UserManage.del = {
		text : ECSINFO.del,
		iconCls : 'icon-remove',
		handler : function() {
			var selections = $("#userData").datagrid('getSelections');
			if(selections.length > 0){
				var deleteName = "";
				var deleteId = "";
				$(selections).each(function(index,selection){
					selection = eval(selection);
					deleteName += selection.username+", ";
					deleteId += selection.userid+",";
				});
				deleteName = deleteName.substring(0,deleteName.length-2);
				deleteIds = deleteId.substring(0,deleteId.length-1);
				
				ECSINFO.confirm_delete(function(){    
					$.ajax({
						url:"../system/deleteUserData",
						data:{"deleteIds":deleteIds},
						success:function(){
							userManage.reloadGrid();
							$('#userData').datagrid('clearSelections');  
						}
					});
				});
			}else{
				ECSINFO.alert_delete_requried();
			}
		}
};

/**
 * 查看按钮
 */
UserManage.view = {
		text : ECSINFO.view,
		iconCls : 'icon-search',
		handler : function() {
			var selections = $("#userData").datagrid('getSelections');
			if(selections.length != 1){
				ECSINFO.alert_update_unique();
			} else {
				var row = selections[0];
				$('#operate_window').window({
					width : 420,
					height : 400,
					modal : true,
					collapsible : false,
					minimizable : false,
					maximizable : false,
					resizable : false,
					iconCls : 'icon-edit',
					title : ECSINFO.view,
					href:"../system/userOperate?operate=see&geUser.userid=" + row.userid
				}).show();
			}
		}
};

/**
 * 工具栏
 */
 UserManage.prototype.toolbar = [];
 
 /**
  * 初始化工具栏
  */
 UserManage.prototype.initToolBar = function(){
		if(auth.access('RES_AUTH_USER_ADD')){
			this.toolbar.push(UserManage.add);
			this.toolbar.push("-");
		}if(auth.access('RES_AUTH_USER_UPDATE')){
			this.toolbar.push(UserManage.update);
			this.toolbar.push("-");
		}if(auth.access('RES_AUTH_USER_DEL')){
			this.toolbar.push(UserManage.del);
			this.toolbar.push("-");
		}if(auth.access('RES_AUTH_USER_VIEW')){
			this.toolbar.push(UserManage.view);
			this.toolbar.push("-");
		}

};

/**
 * 创建用户信息数据表格
 */
UserManage.prototype.createDataGrid = function(){
	this.initToolBar();
	$('#userData').datagrid({
		toolbar : this.toolbar,
		url : '../system/findUserData', 
		fit : true,
		pagination:true,
		rownumbers:true,
		pageSize:15,
		pageList:[15,20,30,50],
		loading:"数据加载中...",
		idField:"userid",
		checkbox:true,
		width : $("#userData").width(),
		fitColumns:true,
		columns : [ [ {
			field : 'userid',
			title : 'id',
			hidden: true
		}, {
			checkbox:true,
			field : 'checkbox',
			title : 'checkbox'
		}, {
			field : 'username',
			title : '姓名',
			width : ($("#userData").width() * 0.15),
			halign: 'center',
			align:'center'
		}, {
			field : 'usertype',
			title : '用户类型',
			width : ($("#userData").width() * 0.15),
			formatter: function(value){
				return dictTrans(value,'USERTYPE');
			},
			halign: 'center',
			align:'center'
		}, {
			field : 'email',
			title : '邮箱',
			width : ($("#userData").width() * 0.2),
			halign: 'center',
			align:'center'
		},{
			field : 'sex',
			title : '性别',
			formatter: function(value){
				return dictTrans(value,'SEX');
			},
			halign: 'center',
			align:'center'
		},{
			field : 'phone',
			title : '电话',
			width : ($("#userData").width() * 0.2),
			halign: 'center'
		},{
			field : 'state',
			title : '状态',
			formatter: function(value){
				return dictTrans(value,'USERSTATUS');
			},
			halign: 'center',
			align:'center'
		},{
			field : 'operatorname',
			title : '添加/修改人员',
			width : ($("#userData").width() * 0.2),
			halign: 'center',
			align:'center'
		} ] ]
	});
	this.initOwnToolBar();
};

/**
 * 搜索
 * @param username
 */
UserManage.prototype.searchData = function(username){
	if(typeof(username)=='undefined'){
		username="";
	}
	else{
		username=username.replace(/\s+/g,"");
	}
	$('#userData').datagrid('clearSelections');  
	$('#userData').datagrid('load',{
		'geUser.username':username
	});  
};

/**
 * 重新加载用户数据
 */
UserManage.prototype.reloadGrid = function(){
	$("#userData").datagrid('reload',{
		'geUser.username':$("#username-search").val()
	});
};

/**
 * 加载搜索条
 */
UserManage.prototype.initOwnToolBar = function(){
	$('.datagrid-toolbar table tr').append("<td></td>");
	$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
};

/**
 * 添加角色
 */
UserManage.prototype.addRole = function(){
	var roles = $("#allRoles option:selected");
	for ( var int = 0; int < roles.length; int++) {
		if(!typeof($("#owerRoles option[value='"+$(roles[int]).val()+"']").val())!='undefined'){
			$("#owerRoles").append($(roles[int]));
		}
	}
};

/**
 * 移除角色
 */
UserManage.prototype.removeRole = function(){
	var roles = $("#owerRoles option:selected");
	for ( var int = 0; int < roles.length; int++) {
		if(!typeof($("#allRoles option[value='"+$(roles[int]).val()+"']").val())!='undefined'){
			$("#allRoles").append($(roles[int]));
		}
	}
};

/**
 * 添加用户组
 */
UserManage.prototype.addGroup = function(){
	var roles = $("#allUsergroup option:selected");
	for ( var int = 0; int < roles.length; int++) {
		if(!typeof($("#owerUsergroups option[value='"+$(roles[int]).val()+"']").val())!='undefined'){
			$("#owerUsergroups").append($(roles[int]));
		}
	}
};

/**
 * 移除用户组
 */
UserManage.prototype.removeGroup = function(){
	var roles = $("#owerUsergroups option:selected");
	for ( var int = 0; int < roles.length; int++) {
		if(!typeof($("#allUsergroups option[value='"+$(roles[int]).val()+"']").val())!='undefined'){
			$("#allUsergroup").append($(roles[int]));
		}
	}
};

/**
 * 添加或修改用户
 */
UserManage.prototype.addUpdateUser = function(){
	var operate = $("#operate").val();
	var username = $("#username").val();
	var password = $("#password").val();
	var usertype = $("#usertype").val();
	var email = $("#email").val();
	var sex = $("input[name='geUser.sex']:checked").val();
	var phone = $("#phone").val();
	var state = $("input[name='geUser.state']:checked").val();
	var operatorname = $("#operatorname").val();
	var geUsergroups = $("#owerUsergroups option");
	var geRoles = $("#owerRoles option");
	var geDepartments = $("#organ").tree('getCheckedExt');
	
	var data = "operate="+operate+
			   "&geUser.username="+username+
			   "&geUser.usertype="+usertype+
			   "&geUser.email="+email+
			   "&geUser.sex="+sex+
			   "&geUser.phone="+phone+
			   "&geUser.state="+state+
			   "&geUser.operatorname="+operatorname;
	if($("#pwdinput:hidden").html() == undefined){
		data = data + "&geUser.password="+password;
	} else if(operate=='add'){
		data = data + "&geUser.password="+password;
	}
	if(operate=='update'){
		data = data + "&geUser.userid="+$("#userid").val();
	}
	for ( var int = 0; int < geUsergroups.length; int++) {
		data = data + "&geUsergroups["+int+"].usergroupid="+$(geUsergroups[int]).val();
	}
	for ( var int = 0; int < geRoles.length; int++) {
		data = data + "&geRoles["+int+"].roleid="+$(geRoles[int]).val();
	}
	if($('#isOpenDep').val() != "0"){
		for ( var int = 0; int < geDepartments.length; int++) {
			data = data + "&geDepartments["+int+"].deptid="+geDepartments[int].id;
		}
		data = data + "&isOpenDep=open";
	}else{
		data = data + "&isOpenDep=no";
	}
	dictReload(this.ctx,"SEX,USERSTATUS,USERTYPE");
	$.ajax({
		type:"POST",
		url:this.ctx+"/system/addOrUpdateUser",
		data:data,
		success:function(data){
			$('#operate_window').window('close');
			$('#userData').datagrid('reload'); 
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
};

/**
 * 隐藏或显示密码输入框
 */
UserManage.prototype.opPwdInput = function(operate){
	if(operate == 'hide'){
		$('#pwdinput').hide();
		$('#password').attr("name","");
		$('#againpwd').attr("name","");
		$('#againpwdinput').hide();
		$('#canclerepwd').hide();
		$('#repwdbtn').show();
	} else {
		$('#pwdinput').show();
		$('#password').attr("name","geUser.password");
		$('#againpwd').attr("name","againpwd");
		$('#againpwdinput').show();
		$('#canclerepwd').show();
		$('#repwdbtn').hide();
	}
};

/**
 * 用户操作页面表单验证
 */
UserManage.prototype.formValidate = function(){
	$('#userManageForm').validator({
		theme: 'yellow_right',
		timely:1,
		rules:{
			username : [/^[^<>]+$/, '不能包含<>字符'],
			againpwd : function(element, param, field) {
				if(element.value != $("#password").val()){
					return '两次输入的密码不一致';
				} else {
					return true;
				}
			},
			phone: function(element, param, field) {
				if(/^1[3458]\d{9}$/.test(element.value)){
					return true;
				} else if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(element.value)){
					return true;
				} else {
					return '不是有效的电话号码';
				}
		    }
		},
		fields:{
			"geUser.username":{
				rule:"required;length[2~15];username;remote[../system/existUserName, operate];",
				tip: "不能包含<>字符"
				//ok:""
			},
			"geUser.password":{
				rule:"required;password;",
				tip:"由6到16位字母或数字组成"
				//ok:""
			},
			"againpwd":{
				rule:"required;againpwd;",
				tip:"请再次确认密码"
				//ok:""
			},
			"geUser.email":{
				rule:"email;",
				tip:"电子邮箱"
			},
			"geUser.phone":{
				rule:"phone;",
				tip:"手机或固定电话（区号-电话号）"
			}
		},
		valid: function(form){ //验证成功
			userManage.addUpdateUser();
			return false;
		},
		invalid: function(form){//验证失败
			$('#user_operate').tabs('select',0);
			return false;
		}
	});
};

var userManage = new UserManage();