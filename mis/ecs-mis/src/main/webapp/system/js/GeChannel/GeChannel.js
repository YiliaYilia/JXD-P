var GeChannel = function(){};
GeChannel.prototype.ctx = null;

/**
 * 查看按钮
 */
GeChannel.view = {
		text : ECSINFO.view,
		iconCls : 'icon-search',
		handler : function() {
			var rows =$('#channelData').datagrid('getChecked');
	    	if(rows== null || rows.length != 1){
	    		ECSINFO.alert_update_unique();
	    		return false;
	    	}else{
	    		var row = rows[0];
	    		//window.location.href='../system/findGeChannelData?id='+row.id+"&date="+new Date();
	    		var tab = new ECSTab();
				tab.target = $('#mainTab', window.parent.document);
				window.parent.CreateTab("渠道详情","GeChannelInfo","../system/findGeChannelData?id="+row.id+"&date="+new Date());
		}
		}
	};


/**
 * 增加按钮
 */
GeChannel.add =  {
		text : ECSINFO.add,
		iconCls : 'icon-add',
		handler : function() {
				//window.location.href='../system/GeChannelForm?logo=1';
	    		var tab = new ECSTab();
				tab.target = $('#mainTab', window.parent.document);
				window.parent.CreateTab("增加渠道信息","GeChannelInfo","../system/GeChannelForm?logo=1");
		}
};

/**
 * 修改按钮
 */
GeChannel.edit =  {
		text : ECSINFO.update,
		iconCls : 'icon-edit',
		handler : function() {
			var rows =$('#channelData').datagrid('getChecked');
	    	if(rows== null || rows.length != 1){
	    		ECSINFO.alert_update_unique();
	    		return false;
	    	}else{
	    		var row = rows[0];
	    		//window.location.href='../system/findGeChannelData?logo=2&id='+row.id+"&date="+new Date();
	    		var tab = new ECSTab();
				tab.target = $('#mainTab', window.parent.document);
				window.parent.CreateTab("修改渠道信息","GeChannelInfo","../system/findGeChannelData?logo=2&id="+row.id+"&date="+new Date());
	    	}
		}
};

/**
 * 删除按钮
 */
GeChannel.del =  {
		text : ECSINFO.del,
		iconCls : 'icon-remove',
		handler : function() {
			var selections = $("#channelData").datagrid('getSelections');
			if(selections.length > 0){
				ECSINFO.confirm_delete(function(){
					var deleteId = "";
					$(selections).each(function(index,selection){
						selection = eval(selection);
						deleteId += selection.id+",";
					});
					var deleteIds = deleteId.substring(0,deleteId.length-1);
					window.location.href='../system/deleteGeChannelData?deleteIds='+deleteIds+"&date="+new Date();
				});
			}else{
				ECSINFO.alert_delete_requried();
			}
		}
	
			
};

/**
 * 工具栏
 */
GeChannel.prototype.toolbar = [];
 

/**
 * 初始化工具栏
 */
GeChannel.prototype.initToolBar = function(){
		if(auth.access('RES_AUTH_USER_ADD')){
			this.toolbar.push(GeChannel.view);
			this.toolbar.push(GeChannel.add);
			this.toolbar.push(GeChannel.edit);
			this.toolbar.push(GeChannel.del);
			this.toolbar.push("-");
		}
};

/**
 * 自定义工具栏
 */
GeChannel.prototype.initOwnToolBar = function(){
	$('.datagrid-toolbar table tr').append("<td></td>");
	$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
};

/**
 * 创建用户信息数据表格
 */
GeChannel.prototype.createDataGrid = function(){
	this.initToolBar();
	$('#channelData').datagrid({
		toolbar : this.toolbar,
		url : '../system/GeChannelSearch', 
		fit : true,   
		pagination:true,
		rownumbers:true,
		pageSize:15,
		pageList:[15,20,30,50],
		loading:"数据加载中...",
		idField:"id",
		checkbox:true,
		width : $("#channelData").width(),
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
			field : 'channelCode',
			title : '合作伙伴代码',
			width : ($("#channelData").width() * 0.1),
			halign: 'center',
			align:'center'
		},{
			field : 'imgUrl',
			title : '首页图片路径',
			width : ($("#channelData").width() * 0.15),
			halign: 'center',
			align:'center'
		},{
			field : 'channelName',
			title : '合作伙伴名称',
			width : ($("#channelData").width() * 0.15),
			halign: 'center',
			align:'center'
		},{
			field : 'showPolicyName',
			title : '产品名称',
			width : ($("#channelData").width() * 0.15),
			halign: 'center',
			align:'center'
		},{
			field : 'showDeptCode',
			title : '机构名称',
			width : ($("#channelData").width() * 0.15),
			halign: 'center',
			align:'center'
		},{
			field : 'policyUrl',
			title : '产品链接',
			width : ($("#channelData").width() * 0.15),
			halign: 'center',
			align:'center'
		},{
			field : 'policyMatrix',
			title : '产品二维码路径',
			width : ($("#channelData").width() * 0.15),
			halign: 'center',
			align:'center'
		},{
			field : 'isAgentcode',
			title : '推荐人是否必填',
			width : ($("#channelData").width() * 0.15),
			formatter: function(value){
				return showAgentcode(value);
			},
			halign: 'center',
			align:'center'
		}] ]
	});
	this.initOwnToolBar();
};

function showAgentcode(value){
	if('1' == value){
		return "必填";
	} else if('0' == value){
		return "可选";
	}
};

/**
 * 搜索
 */
GeChannel.prototype.searchData = function(){
	var channelCode = $("#channelCode-search").val().replace(/\s+/g,"");
	var channelName = $("#channelName-search").val().replace(/\s+/g,"");
	var deptCode = $("#deptCode-search").val().replace(/\s+/g,"");
	$('#channelData').datagrid('clearSelections');  
	$('#channelData').datagrid('load',{
		'geChannel.channelCode':channelCode,
		'geChannel.channelName':channelName,
		'geChannel.deptCode':deptCode
	});  
	
};

var geChannel = new GeChannel();