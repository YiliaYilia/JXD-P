var BankchangeList = function(){};
BankchangeList.prototype.ctx = null;
/**
 * 查看按钮
 */
//BankchangeList.view = {
//	text : ECSINFO.view,
//	iconCls : 'icon-search',
//	handler : function() {
//		var rows =$('#orderData').datagrid('getChecked');
//    	if(rows== null || rows.length != 1){
//    		ECSINFO.alert_update_unique();
//    		return false;
//    	}
//    	else{
//    		var row = rows[0];
//    		var tab = new ECSTab();
//			tab.target = $('#mainTab', window.parent.document);
//			window.parent.CreateTab("订单详情","orderInfo","../business/orderInfo?orderno="+row.orderno+"&date="+new Date());
//    	}
//	}
//};
/**
 * 导出按钮
 */
BankchangeList.exp={
		text : '导出',
		iconCls : 'icon-add',
		handler : function() {
			var policyno = $("#policyno-search").val().replace(/\s+/g,"");
			var applicantname = $("#applicantname-search").val().replace(/\s+/g,"");
			var srartTime = $("#insuretimebegin-search").val();
			var endTime = $("#insuretimeend-search").val();
			window.location.href='../business/expBankchangeList?policyno='+policyno+'&applicantname='+applicantname+'&srarttime='+srartTime+'&endtime='
								+endTime;
		}
};
/**
 * 工具栏
 */
BankchangeList.prototype.toolbar = [];

/**
 * 初始化工具栏
 */
BankchangeList.prototype.initToolBar = function(){
	if(auth.access('RULE_BUSINESSDATA_ORDER')){
		this.toolbar.push(BankchangeList.exp);
		this.toolbar.push("-");
	}
};

/**
 * 自定义工具栏
 */
BankchangeList.prototype.initOwnToolBar = function(){
	$('.datagrid-toolbar table tr').append("<td></td>");
	$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
};

/**
 * 创建用户信息数据表格
 */
BankchangeList.prototype.createDataGrid = function(){
	this.initToolBar();
	var that = this;
	$('#orderData').datagrid({
		toolbar : this.toolbar,
		url : that.ctx+'/business/findbankAll',
		fit : true,
		pagination:true,
		rownumbers:true,
		pageSize:15,
		pageList:[15,20,30,50],
		loading:"数据加载中...",
		idField:"orderno",
		checkbox:true,
		width : $("#orderData").width(),
		fitColumns:true,
		columns : [ [ {
			field : 'orderno',
			title : 'orderno',
			hidden: true
		}, {
			checkbox:true,
			field : 'checkbox',
			title : 'checkbox'
		},{
			field : 'policyno',
			title : '保单号', 
			width : $("#orderData").width() * 0.1,
			halign: 'center',
			align:'center'
		}, {
			field : 'applicantname',
			title : '投保人姓名', 
			width : $("#orderData").width() * 0.1,
			halign: 'center',
			align:'center'
		}, {
			field : 'bank',
			title : '原银行名称', 
			halign: 'center',
			align:'center'
		}, {
			field : 'bankaccountnumber',
			title : '原银行卡号',
			halign: 'center',
			align:'center'
		}, {
			field : 'bankC',
			title : '新银行名称',
			halign: 'center',
			align:'center'
		},{
			field : 'bankaccountnumberC',
			title : '新银行卡号',
			width : $("#orderData").width() * 0.1,
			halign: 'center',
			align:'center'
		},{
			field : 'updateTime',
			title : '修改时间',
			width : $("#orderData").width() * 0.1,
			halign: 'center',
			align:'center'
		}] ]
	});
	this.initOwnToolBar();
};

/**
 * 查询
 */
BankchangeList.prototype.searchData = function(){
	var policyno = $("#policyno-search").val().replace(/\s+/g,"");
	var applicantname = $("#applicantname-search").val().replace(/\s+/g,"");
	var srartTime = $("#insuretimebegin-search").val();
	var endTime = $("#insuretimeend-search").val();
	$('#orderData').datagrid('load',{  
	     "changepolicy.policyno": policyno,
	     "changepolicy.applicantname":applicantname,
	     "starttime":srartTime,
	     "endtime":endTime,
	});
	$('#orderData').datagrid('clearSelections');
};


	function dictReload(ctx,dictType){$.ajax({async:false,url:ctx+'/system/dictReload',data:{'dictType':dictType,'temp':new Date().getTime()},success:function(data){data = eval(data);result=data.result;}});} 



var bankchange = new BankchangeList();