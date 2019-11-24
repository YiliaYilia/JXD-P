var UserManage = function(){};
var row;
UserManage.prototype.ctx = null;

/**
 * 解绑
 */
UserManage.view = {
	text : '解绑',
	iconCls : 'icon-remove',
	handler : function() {
		var users = $('#userData').datagrid('getSelections');
		if(users.length == 1){
			var r = users[0];
			var name = r.name;
			$.messager.confirm('提示框', '确定要解除'+ name +'的绑定信息?',function(s){
				if(s){
					var microid = r.microid;
					$.ajax({
						type:'post',
						url:'../system/releaseCustomer', 
						dataType:'json',
						data : {
							"name" : name,
							"microid" : microid
						},
						async:false,
						success:function(data){
						   if(data == true){
							   UserManage.prototype.searchData();
							   $('#userData').datagrid('clearSelections');
						   } else {
							   $.messager.alert('温馨提示','用户解绑失败，请联系管理员!','warning');
						   }
						}
					});
				}
			});
		} else {
			$.messager.alert('提示','只能选择单条记录进行解绑');
		}
	}
};
/**
 *  绑定按钮
 */
UserManage.bind = {
    text : '绑定',
    iconCls : 'icon-add',
    handler : function() {
        $('#dlg').dialog('open').dialog('setTitle','New User');
        $('#fm').form('clear');
    }
}

function saveUser(){
    $('#fm').form('submit',{
        url: '../system/binding',
        onSubmit: function(){
            return $(this).form('validate');
        },
        success: function(data){
        	console.log('绑定结果：'+data);
        	if(data === 'true'){
                $.messager.alert('提示','绑定成功');
                $('#dlg').dialog('close');
                $('#dg').datagrid('reload');
                UserManage.prototype.searchData();
                $('#userData').datagrid('clearSelections');
			}else {
                $.messager.alert('错误','用户信息有误，绑定失败');
			}
        }
    });
}

/**
 * 导出按钮
 */
UserManage.add =  {
		text : '导出',
		iconCls : 'icon-add',
		handler : function() {
			window.location.href='../system/exportMobileUser';
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
			this.toolbar.push(UserManage.view);
            this.toolbar.push(UserManage.bind);
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
		url : '../system/mobileCustomerSearch', 
		fit : true,   
		pagination:true,
		rownumbers:true,
		pageSize:15,
		pageList:[15,20,30,50],
		loading:"数据加载中...",
		//idField:"userid",
		checkbox:true,
		width : $("#userData").width(),
		onClickRow: function(rowIndex, rowData){
		    row = $('#userData').datagrid('getSelected');
		},
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
			field : 'coustomerid',
			title : '客户号',
			width : ($("#userData").width() * 0.15),
			halign: 'center',
			align:'center'
		},{
			field : 'name',
			title : '姓名',
			width : ($("#userData").width() * 0.15),
			halign: 'center',
			align:'center'
		}, {
			field : 'idtype',
			title : '证件类型',
			width : ($("#userData").width() * 0.15),
			formatter: function(value){
				return typeTransfer(value,'IDTYPE');
			},
			halign: 'center',
			align:'center'
		}, {
			field : 'idnumber',
			title : '证件号码',
			width : ($("#userData").width() * 0.15),
			halign: 'center',
			align:'center'
		},{
			field : 'sex',
			title : '性别',
			formatter: function(value){
				return typeTransfer(value,'SEX');
			},
			halign: 'center',
			align:'center'
		},{
			field : 'birthday',
			title : '生日',
			width : ($("#userData").width() * 0.2),
			halign: 'center',
			align:'center'
		},{
			field : 'email',
			title : '邮箱',
			width : ($("#userData").width() * 0.2),
			halign: 'center',
			align:'center'
		},
		{
			field : 'address',
			title : '地址',
			width : ($("#userData").width() * 0.2),
			halign: 'center',
			align:'center'
		},{
			field : 'postcode',
			title : '邮编',
			width : ($("#userData").width() * 0.2),
			halign: 'center',
			align:'center'
		},{
			field : 'telphone',
			title : '电话',
			width : ($("#userData").width() * 0.2),
			halign: 'center'
		},
		{
			field : 'creattime',
			title : '绑定时间',
			width : ($("#userData").width() * 0.2),
			halign: 'center',
			align:'center'
		},
		{
			field : 'updatetime',
			title : '修改时间',
			width : ($("#userData").width() * 0.2),
			halign: 'center',
			align:'center'
		}] ]
	});
	this.initOwnToolBar();
};

//function bown(row){
//	var users = $('#userData').datagrid('getSelections');
//	if(users.length == 1){
//		var name = row.name;
//		$.messager.confirm('提示框', '确定要解除'+ name +'的绑定信息?',function(r){
//			if(r){
//				var microid = row.microid;
//				$.ajax({
//					type:'post',
//					url:'../system/releaseCustomer', 
//					dataType:'json',
//					data : {
//						"name" : name,
//						"microid" : microid
//					},
//					async:false,
//					success:function(data){
//					   if(data == true){
//						   UserManage.prototype.searchData();
//						   $('#userData').datagrid('clearSelections')
//					   } else {
//						   $.messager.alert('温馨提示','用户解绑失败，请联系管理员!','warning');
//					   }
//					}
//				});
//			}
//		});
//	} else {
//		$.messager.alert('提示','只能选择单条记录进行解绑');
//	}
//}

var result = '';
function typeTransfer(dictCode,dictType){
	if(result==''){
		result = [{"dictdatacode":"F","dictdataname":"女","dicttypecode":"SEX"},
		          {"dictdatacode":"M","dictdataname":"男","dicttypecode":"SEX"},
		          {"dictdatacode":"0","dictdataname":"无效","dicttypecode":"STATE"},
		          {"dictdatacode":"1","dictdataname":"有效","dicttypecode":"STATE"},
		          {"dictdatacode":"ID_CARD","dictdataname":"身份证","dicttypecode":"IDTYPE"},
		          {"dictdatacode":"PASSPORT","dictdataname":"护照","dicttypecode":"IDTYPE"},
		          {"dictdatacode":"MOC","dictdataname":"军官证","dicttypecode":"IDTYPE"},
		          {"dictdatacode":"DRIVING_LICENSE","dictdataname":"驾照","dicttypecode":"IDTYPE"},
		          {"dictdatacode":"BC","dictdataname":"出生证明","dicttypecode":"IDTYPE"},
		          {"dictdatacode":"CTC","dictdataname":"台胞证","dicttypecode":"IDTYPE"},
		          {"dictdatacode":"SOLDIERS","dictdataname":"士兵证","dicttypecode":"IDTYPE"},
		          {"dictdatacode":"HKMTP","dictdataname":"港澳通行证","dicttypecode":"IDTYPE"},
		          {"dictdatacode":"MID","dictdataname":"港澳台回乡证","dicttypecode":"IDTYPE"},
		          {"dictdatacode":"HHR","dictdataname":"户口本","dicttypecode":"IDTYPE"},
		          {"dictdatacode":"OTHERS","dictdataname":"其他","dicttypecode":"IDTYPE"},
		          {"dictdatacode":"BIRTHCERT","dictdataname":"出生日期","dicttypecode":"IDTYPE"}
		          ];
		}
		result = eval(result);
		for(var i = 0;i<result.length;i++){
			if(result[i].dicttypecode==dictType&&result[i].dictdatacode==dictCode){
				return result[i].dictdataname;}}return "";
			};function dictReload(ctx,dictType){$.ajax({async:false,url:ctx+'/system/dictReload',data:{'dictType':dictType,'temp':new Date().getTime()},success:function(data){data = eval(data);result=data.result;}});} 



/**
 * 搜索
 * @param username
 */
UserManage.prototype.searchData = function(){
	var username = $("#username").val();
	var idnumber = $("#idnumber").val();
	var creattimeBegin = $("#creattimeBegin-search").val();
	var creattimeEnd = $("#creattimeEnd-search").val();
	if(typeof(username)=='undefined'){
		username="";
	}else{
		username=username.replace(/\s+/g,"");
	}
	if(typeof(idnumber)=='undefined'){
		idnumber="";
	}else{
		idnumber=idnumber.replace(/\s+/g,"");
	}
	$('#userData').datagrid('load',{
		'mobileCustomer.name':username,
		'mobileCustomer.idnumber':idnumber,
		'mobileCustomer.starttime':creattimeBegin,
		'mobileCustomer.endtime':creattimeEnd
	});  
};

/**
 * 重新加载用户数据
 */
UserManage.prototype.reloadGrid = function(){
	$("#userData").datagrid('reload',{
		'mobileCustomer.coustomerid':$("#coustomerid").val()
	});
};



/**
 * 加载搜索条
 */
UserManage.prototype.initOwnToolBar = function(){
	$('.datagrid-toolbar table tr').append("<td></td>");
	$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
};



var userManage = new UserManage();