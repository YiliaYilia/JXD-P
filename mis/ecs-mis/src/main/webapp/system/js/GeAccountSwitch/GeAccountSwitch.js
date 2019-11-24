var UserManage = function(){};
UserManage.prototype.ctx = null;

/**
 * 添加按钮
 */
UserManage.add =  {
		text : '导出',
		iconCls : 'icon-add',
		handler : function() {
			var policynum = $("#policynum").val();
//			var productName = $("#productName-search").val().replace(/\s+/g,"");
			var accountName =$("#accountName-search").val().replace(/\s+/g,"");
			var makedateBegin = $("#makedateBegin-search").val();
			var makedateEnd = $("#makedateEnd-search").val();
				window.location.href='../system/exportGeAccountSwitch?policynum='
					+policynum
//					+'&productName='+encodeURI(encodeURI(productName))
				+'&accountName='+encodeURI(encodeURI(accountName))
				+'&makedateBegin='+makedateBegin+'&makedateEnd='+makedateEnd;
				
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
		}

};

/**
 * 创建用户信息数据表格
 */
UserManage.prototype.createDataGrid = function(){
	this.initToolBar();
	$('#userData').datagrid({
		toolbar : this.toolbar,
		url : '../system/GeAccountSwitchSearch', 
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
			field : 'id',
			title : 'id',
			hidden: true
		}, {
			checkbox:true,
			field : 'checkbox',
			title : 'checkbox'
		},  {
			field : 'policynum',
			title : '保单号',
			width : ($("#userData").width() * 0.1),
			halign: 'center',
			align:'center'
		},
//		{
//			field : 'productName',
//			title : '险种名称',
//			width : ($("#userData").width() * 0.15),
//			halign: 'center',
//			align:'center'
//		},
		{
			field : 'accountName',
			title : '账户名称',
			width : ($("#userData").width() * 0.15),
			halign: 'center',
			align:'center'
		}, {
			field : 'switchratio',
			title : '修改比例',
			width : ($("#userData").width() * 0.1),
			halign: 'center',
			align:'center'
		},{
			field : 'makedate',
			title : '操作时间',
			halign: 'center',
			align:'center'
		} ] ]
	});
	this.initOwnToolBar();

};



/**
 * 搜索
 */
UserManage.prototype.searchData = function(){
	var policynum = $("#policynum").val();
//	var productName = $("#productName-search").val().replace(/\s+/g,"");
	var accountName =$("#accountName-search").val().replace(/\s+/g,"");
	var makedateBegin = $("#makedateBegin-search").val();
	var makedateEnd = $("#makedateEnd-search").val();
	if(typeof(policynum)=='undefined'){
		policynum="";
	}
	else{
		upolicynum = policynum.replace(/\s+/g,"");
	}
	$('#userData').datagrid('clearSelections');  
	$('#userData').datagrid('load',{
		'geAccountSwitch.policynum':policynum,
//		'geAccountSwitch.productName':productName,
		'geAccountSwitch.accountName':accountName,
		'geAccountSwitch.starttime':makedateBegin,
		'geAccountSwitch.endtime':makedateEnd
	});  
	
};

/**
 * 重新加载用户数据
 */
UserManage.prototype.reloadGrid = function(){
	$("#userData").datagrid('reload',{
		'geAccountSwitch.policynum':$("#policynum").val()
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










var userManage = new UserManage();