var Order = function(){};
Order.prototype.ctx = null;

/**
 * 查看按钮
 */
Order.view = {
	text : ECSINFO.view,
	iconCls : 'icon-search',
	handler : function() {
		var rows =$('#orderData').datagrid('getChecked');
    	if(rows== null || rows.length != 1){
    		ECSINFO.alert_update_unique();
    		return false;
    	}
    	else{
    		var row = rows[0];
    		var tab = new ECSTab();
			tab.target = $('#mainTab', window.parent.document);
			window.parent.CreateTab("订单详情","orderInfo","../business/orderInfo?orderno="+row.orderno+"&date="+new Date());
    	}
	}
};
Order.exp =  {
		text : '导出',
		iconCls : 'icon-add',
		handler : function() {
			var ordercode = $("#ordercode-search").val().replace(/\s+/g,"");
			var paystatus = $("#paystatus-search").val();
			var accoutnstatus = $("#accoutnstatus-search").val();
			var recipientname = $("#recipientname-search").val().replace(/\s+/g,"");
			var productname = $("#productname-search").val().replace(/\s+/g,"");
			var insuretimebegin = $("#insuretimebegin-search").val();
			var insuretimeend = $("#insuretimeend-search").val();
			var deptid = $("#deptid-search").val();
			var userid = $("#userid-search").val().replace(/\s+/g,"");
			window.location.href='../business/expOrder?ordercode='+ordercode+'&paystatus='+paystatus+'&recipientname='+recipientname+'&productname='
								+productname+'&starttime='+insuretimebegin+'&endtime='+insuretimeend+'&accoutnstatus='+accoutnstatus+'&deptid='+deptid
								+'&userid='+userid;
		}
};
/**
 * 工具栏
 */
Order.prototype.toolbar = [];

/**
 * 初始化工具栏
 */
Order.prototype.initToolBar = function(){
	if(auth.access('RULE_BUSINESSDATA_ORDER')){
		this.toolbar.push(Order.view);
		this.toolbar.push(Order.exp);
		this.toolbar.push("-");
	}
};

/**
 * 自定义工具栏
 */
Order.prototype.initOwnToolBar = function(){
	$('.datagrid-toolbar table tr').append("<td></td>");
	$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
};

/**
 * 创建用户信息数据表格
 */
Order.prototype.createDataGrid = function(){
	this.initToolBar();
	var that = this;
	var userid = $("#userid-search").val().replace(/\s+/g,"");
	$('#orderData').datagrid({
		toolbar : this.toolbar,
		url : that.ctx+'/business/findOrderData?userid='+userid,
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
		}, {
			field : 'productname',
			title : '产品名称', 
			width : $("#orderData").width() * 0.2,
			halign: 'center',
			align:'center'
		}, {
			field : 'applicantname',
			title : '投保人姓名', 
			width : $("#orderData").width() * 0.1,
			halign: 'center',
			align:'center'
		},{
			field : 'recipientname',
			title : '被保人姓名', 
			width : $("#orderData").width() * 0.1,
			halign: 'center',
			align:'center'
		}, {
			field : 'policyno',
			title : '保单号', 
			width : $("#orderData").width() * 0.1,
			halign: 'center',
			align:'center'
		}, {
			field : 'agentCode',
			title : '推荐人编码',
			width : $("#orderData").width() * 0.1,
			halign: 'center',
			align:'center'
		}, {
			field : 'preferentialcode',
			title : '活动码',
			width : $("#orderData").width() * 0.1,
			halign: 'center',
			align:'center'
		}, {
			field : 'deptid',
			title : '组织机构',
			width : $("#orderData").width() * 0.1,
			halign: 'center',
			align:'center'
		}, {
			field : 'policyStatus',
			title : '保单状态', 
			formatter: function(value){
				return dictTrans1(value,'POLICYSTATUS');
			},
			halign: 'center',
			align:'center'
		}, {
			field : 'paystatus',
			title : '支付状态',
			formatter: function(value){
				return dictTrans1(value,'PAYSTATUS');
			},
			halign: 'center',
			align:'center'
		}, {
			field : 'status',
			title : '对账状态',
			formatter: function(value){
				return dictTrans1(value,'STATUS');
			},
			halign: 'center',
			align:'center'
		},{
			field : 'submittime',
			title : '投保时间',
			width : $("#orderData").width() * 0.1,
			halign: 'center',
			align:'center'
		},{
			field : 'gatewayrno',
			title : '微信订单号',
			width : $("#orderData").width() * 0.1,
			halign: 'center',
			align:'center'
		},{
			field : 'orderamount',
			title : '订单金额',
			formatter: function(value){
				return "￥ "+value;
			},
			halign: 'center',
		} ] ]
	});
	this.initOwnToolBar();
};

/**
 * 查询
 */
Order.prototype.searchData = function(){
	var ordercode = $("#ordercode-search").val().replace(/\s+/g,"");
	var paystatus = $("#paystatus-search").val();
	var recipientname = $("#recipientname-search").val().replace(/\s+/g,"");
	var productname = $("#productname-search").val().replace(/\s+/g,"");
	var insuretimebegin = $("#insuretimebegin-search").val();
	var insuretimeend = $("#insuretimeend-search").val();
	var accoutnstatus = $("#accoutnstatus-search").val();
	var deptid = $("#deptid-search").val();
	$('#orderData').datagrid('load',{  
	     "geOrder.ordercode": ordercode,
	     "geOrder.paystatus":paystatus,
	     "geOrder.applicantname":recipientname,
	     "geOrder.productname":productname,
	     "geOrder.starttime": insuretimebegin,
	     "geOrder.endtime": insuretimeend,
	     "geOrder.status": accoutnstatus,
	     "geOrder.deptid":deptid
	});
	$('#orderData').datagrid('clearSelections');
};


var result = '';
function dictTrans1(dictCode,dictType){
	if(result==''){
		result = [{"dictdatacode":"0","dictdataname":"未支付","dicttypecode":"PAYSTATUS"},
		          {"dictdatacode":"1","dictdataname":"支付成功","dicttypecode":"PAYSTATUS"},
		          {"dictdatacode":"2","dictdataname":"未支付的已撤单","dicttypecode":"PAYSTATUS"},
		          {"dictdatacode":"3","dictdataname":"支付中","dicttypecode":"PAYSTATUS"},
		          {"dictdatacode":"4","dictdataname":"交易可疑","dicttypecode":"PAYSTATUS"},
		          {"dictdatacode":"5","dictdataname":"支付失败","dicttypecode":"PAYSTATUS"},
		          {"dictdatacode":"6","dictdataname":"支付成功且退款成功的已撤单","dicttypecode":"PAYSTATUS"},
		          {"dictdatacode":"7","dictdataname":"退款中","dicttypecode":"PAYSTATUS"},
		          {"dictdatacode":"8","dictdataname":"订单完成","dicttypecode":"PAYSTATUS"},
		          {"dictdatacode":"0","dictdataname":"未对账","dicttypecode":"STATUS"},
		          {"dictdatacode":"1","dictdataname":"对账成功","dicttypecode":"STATUS"},
		          {"dictdatacode":"2","dictdataname":"对账失败","dicttypecode":"STATUS"},
		          {"dictdatacode":"1","dictdataname":"核保成功","dicttypecode":"POLICYSTATUS"},
		          {"dictdatacode":"2","dictdataname":"核保失败","dicttypecode":"POLICYSTATUS"},
		          {"dictdatacode":"3","dictdataname":"承保成功","dicttypecode":"POLICYSTATUS"},
		          {"dictdatacode":"4","dictdataname":"承保失败","dicttypecode":"POLICYSTATUS"},
		          ];
	}
	result = eval(result);
	for(var i = 0;i<result.length;i++){
		if(result[i].dicttypecode==dictType&&result[i].dictdatacode==dictCode){
			return result[i].dictdataname;}}return "";
			};
			function dictReload(ctx,dictType){$.ajax({async:false,url:ctx+'/system/dictReload',data:{'dictType':dictType,'temp':new Date().getTime()},success:function(data){data = eval(data);result=data.result;}});} 



var order = new Order();