var Order = function(){};
Order.prototype.ctx = null;

/**
 * 查看按钮
 */

Order.exp =  {
		text : '导出',
		iconCls : 'icon-add',
		handler : function() {
			var orderid = $("#ordercode-search").val().replace(/\s+/g,"");
			var isback = $("#isback-search").val();
			var applicantname = $("#applicantname-search").val();
			var policyno = $("#policyno-search").val();
			var insuretimebegin = $("#insuretimebegin-search").val();
			var insuretimeend = $("#insuretimeend-search").val();
			window.location.href='../business/expPayList?orderid='+orderid+'&isback='+isback+'&applicantname='+applicantname+'&policyno='
								+policyno+'&starttime='+insuretimebegin+'&endtime='+insuretimeend;
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
	$('#orderData').datagrid({
		toolbar : this.toolbar,
		url : that.ctx+'/business/findPayListData',
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
			field : 'orderid',
			title : '订单号',
			width : $("#orderData").width() * 0.15,
			halign: 'center',
			align:'center'
		}, {
			field : 'policyno',
			title : '保单号', 
			width : $("#orderData").width() * 0.2,
			halign: 'center',
			align:'center'
		},{
			field : 'applicantname',
			title : '投保人姓名', 
			width : $("#orderData").width() * 0.2,
			halign: 'center',
			align:'center'
		},{
			field : 'productname',
			title : '产品名称', 
			width : $("#orderData").width() * 0.2,
			halign: 'center',
			align:'center'
		},
		/*{
			field : 'activecode',
			title : '活动码', 
			width : $("#orderData").width() * 0.2,
			halign: 'center',
			align:'center'
		},  {
			field : 'channelcode',
			title : '渠道编码', 
			width : $("#orderData").width() * 0.2,
			halign: 'center',
			align:'center'
		},*/
		{
			field : 'mount',
			title : '金额', 
			formatter: function(value){
				return amTrans(value);
			},
			halign: 'center',
			align:'center'
		}, {
			field : 'paytime',
			title : '支付时间', 
			width : $("#orderData").width() * 0.2,
			halign: 'center',
			align:'center'
		}
		/*,{
			field : 'isback',
			title : '是否退款',
			formatter: function(value){
				return dictTrans1(value,'BACK');
			},
			halign: 'center',
			align:'center'
		},
		{
			field : 'remark',
			title : '备注',
			width : $("#orderData").width() * 0.1,
			halign: 'center',
		} */
		] ]
	});
	this.initOwnToolBar();
};


var result = '';
function dictTrans1(dictCode,dictType){
	if(result==''){
		result = [{"dictdatacode":"0","dictdataname":"未退款","dicttypecode":"BACK"},
		          {"dictdatacode":"1","dictdataname":"已退款","dicttypecode":"BACK"},
		          ];
	}
	result = eval(result);
	for(var i = 0;i<result.length;i++){
		if(result[i].dicttypecode==dictType&&result[i].dictdatacode==dictCode){
			return result[i].dictdataname;}}return "";
			};
			function dictReload(ctx,dictType){$.ajax({async:false,url:ctx+'/system/dictReload',data:{'dictType':dictType,'temp':new Date().getTime()},success:function(data){data = eval(data);result=data.result;}});} 


			
			
			
			
			function amTrans(value){
				var res = parseFloat(value);
				return res/100;
			}
/**
 * 查询
 */
Order.prototype.searchData = function(){
	var orderid = $("#ordercode-search").val().replace(/\s+/g,"");
	var isback = $("#isback-search").val();
	var applicantname = $("#applicantname-search").val();
	var policyno = $("#policyno-search").val();
	var insuretimebegin = $("#insuretimebegin-search").val();
	var insuretimeend = $("#insuretimeend-search").val();
	$('#orderData').datagrid('load',{  
	     "gePayList.orderid": orderid,
	     "gePayList.isback":isback,
	     "gePayList.applicantname":applicantname,
	     "gePayList.policyno":policyno,
	     "gePayList.starttime": insuretimebegin,
	     "gePayList.endtime": insuretimeend
	});
	$('#orderData').datagrid('clearSelections');
};





var order = new Order();