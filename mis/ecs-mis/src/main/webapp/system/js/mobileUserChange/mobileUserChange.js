var UserManage = function(){};
UserManage.prototype.ctx = null;

/**
 * 导出按钮
 */
UserManage.add =  {
		text : '导出',
		iconCls : 'icon-add',
		handler : function() {
			window.location.href='../system/exportMobileUserChange'
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
		url : '../system/mobileCustomerChangeSearch', 
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
		},{
			field : 'idnumber',
			title : '证件号码',
			width : ($("#userData").width() * 0.15),
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
			field : 'mobile',
			title : '手机',
			width : ($("#userData").width() * 0.2),
			halign: 'center'
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
	var updatetimeBegin = $("#updatetimeBegin-search").val();
	var updatetimeEnd = $("#updatetimeEnd-search").val();
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
		'geMobileCustomerChange.name':username,
		'geMobileCustomerChange.idnumber':idnumber,
		'geMobileCustomerChange.starttime':updatetimeBegin,
		'geMobileCustomerChange.endtime':updatetimeEnd
	});  
};

/**
 * 重新加载用户数据
 */
UserManage.prototype.reloadGrid = function(){
	$("#userData").datagrid('reload',{
		'geMobileCustomerChange.coustomerid':$("#coustomerid").val()
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