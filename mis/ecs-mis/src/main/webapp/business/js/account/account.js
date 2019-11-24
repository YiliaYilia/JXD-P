var Account = function(){};
Account.prototype.ctx = null;

/**
 * 导出按钮
 * 
 */

Account.exp =  {
		text : '导出',
		iconCls : 'icon-add',
		handler : function() {
			var ordercode = $("#ordercode-search").val().replace(/\s+/g,"");
			var productname = $("#productname-search").val().replace(/\s+/g,"");
			var applicantname = $("#recipientname-search").val().replace(/\s+/g,"");
			var insuretimebegin = $("#insuretimebegin-search").val();
			var insuretimeend = $("#insuretimeend-search").val();
			window.location.href='../business/expAccount?ordercode='+ordercode+'&productname='+productname+'&applicantname='+applicantname+'&starttime='+insuretimebegin+'&endtime='+insuretimeend;
		}
};

/**
 * 工具栏
 */
Account.prototype.toolbar = [];

/**
 * 初始化工具栏
 */
Account.prototype.initToolBar = function(){
	if(auth.access('RULE_BUSINESSDATA_ORDER')){
		this.toolbar.push(Account.exp);
		this.toolbar.push("-");
	}
};

/**
 * 自定义工具栏
 */
Account.prototype.initOwnToolBar = function(){
	$('.datagrid-toolbar table tr').append("<td></td>");
	$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
};

/**
 * 创建用户信息数据表格
 */
Account.prototype.createDataGrid = function(){
	this.initToolBar();
	var that = this;
	$('#orderData').datagrid({
		toolbar : this.toolbar,
		url : that.ctx+'/business/findAccountData',
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
		}, {
			field : 'ordercode',
			title : '订单号',
			width : $("#orderData").width() * 0.15,
			halign: 'center',
			align:'center'
		},  {
			field : 'circpaymentno',
			title : '微信订单号', 
			width : $("#orderData").width() * 0.2,
			halign: 'center',
			align:'center'
		},{
			field : 'productname',
			title : '产品名称', 
			width : $("#orderData").width() * 0.2,
			halign: 'center',
			align:'center'
		}, {
			field : 'orderamount',
			title : '保额',
			width : $("#orderData").width() * 0.1,
			halign: 'center',
			align:'center'
		},{
			field : 'prem',
			title : '保费',
			width : $("#orderData").width() * 0.1,
			halign: 'center',
			align:'center'
		},{
			field : 'applicantname',
			title : '投保人',
			width : $("#orderData").width() * 0.1,
			halign: 'center',
			align:'center'
		},{
			field : 'applicantPhone',
			title : '投保人手机',
			width : $("#orderData").width() * 0.1,
			halign: 'center',
			align:'center'
		},{
			field : 'insuredname',
			title : '被保人姓名',
			width : $("#orderData").width() * 0.1,
			halign: 'center',
			align:'center'
		},{
			field : 'prodoctcode',
			title : '产品编号',
			width : $("#orderData").width() * 0.1,
			halign: 'center',
			align:'center'
		},{
			field : 'paytime',
			title : '交易时间',
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
Account.prototype.searchData = function(){
	var ordercode = $("#ordercode-search").val().replace(/\s+/g,"");
	var productname = $("#productname-search").val().replace(/\s+/g,"");
	var applicantname = $("#recipientname-search").val().replace(/\s+/g,"");
	var insuretimebegin = $("#insuretimebegin-search").val();
	var insuretimeend = $("#insuretimeend-search").val();
	$('#orderData').datagrid('load',{  
	     "geAccount.ordercode": ordercode,
	     "geAccount.productname":productname,
	     "geAccount.applicantname":applicantname,
	     "geAccount.starttime": insuretimebegin,
	     "geAccount.endtime": insuretimeend
	});
	$('#orderData').datagrid('clearSelections');
};




var account = new Account();