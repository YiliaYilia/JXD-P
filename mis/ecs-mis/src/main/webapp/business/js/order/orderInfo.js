var OrderInfo = function() {};
OrderInfo.prototype.ctx = null;
OrderInfo.prototype.orderno = null;

/**
 * 创建数据表格
 */
OrderInfo.prototype.createDataGrid = function(){
	var that = this;
	$('#orderPolicyData').datagrid({
		url : that.ctx+'/business/getPolicyDataForOrder?orderno='+that.orderno,
		fit : true,
		rownumbers:true,
		loading:"数据加载中...",
		idField:"policyno",
		width : $("#orderPolicyData").width(),
		fitColumns:true,
		singleSelect:true,
		columns : [ [ {
			field : 'policyno',
			title : 'policyno',
			hidden: true
		}, {
			checkbox:true,
			field : 'checkbox',
			title : 'checkbox'
		}, {
			field : 'policycode',
			title : '保单号',
			width : $("#policyData").width() * 0.3,
			halign: 'center',
			align:'center'
		}, {
			field : 'productname',
			title : '产品名称',
			width : $("#policyData").width() * 0.3,
			halign: 'center',
			align:'center'
		}, {
			field : 'insuretime',
			title : '投保日期',
			width : $("#policyData").width() * 0.2,
			halign: 'center',
			align:'center'
		}, {
			field : 'applicantname',
			title : '投保人',
			width : $("#policyData").width() * 0.15,
			halign: 'center',
			align:'center'
		}, {
			field : 'insuredname',
			title : '被保人',
			width : $("#policyData").width() * 0.15,
			halign: 'center',
			align:'center'
		}, {
			field : 'takeeffecttime',
			title : '生效日期',
			width : $("#policyData").width() * 0.15,
			formatter: function(value){
				return formatdata(value);
			},
			halign: 'center',
			align:'center'
		}, {
			field : 'deadlinetime',
			title : '截止日期',
			width : $("#policyData").width() * 0.15,
			formatter: function(value){
				return formatdata(value);
			},
			halign: 'center',
			align:'center'
		}, {
			field : 'sumbasepremium',
			title : '保费',
			width : $("#policyData").width() * 0.15,
			formatter: function(value){
				return "￥"+value;
			},
			halign: 'center',
			align:'center'
		}, {
			field : 'sumamount',
			title : '总保额',
			width : $("#policyData").width() * 0.15,
			formatter: function(value){
				return "￥"+value;
			},
			halign: 'center',
			align:'center'
		}, {
			field : 'status',
			title : '状态',
			formatter: function(value){
				return dictTrans1(value,'STATUS');
			},
			halign: 'center'
		} ] ]
	});
};
function formatdata(value){
	return value.substring(0,10);
}


var result = '';
function dictTrans1(dictCode,dictType){
	if(result==''){
		result = [
		          {"dictdatacode":"1","dictdataname":"核保成功","dicttypecode":"STATUS"},
		          {"dictdatacode":"2","dictdataname":"核保失败","dicttypecode":"STATUS"},
		          {"dictdatacode":"3","dictdataname":"承保成功","dicttypecode":"STATUS"},
		          {"dictdatacode":"4","dictdataname":"承保失败","dicttypecode":"STATUS"},
		          ];
	}
	result = eval(result);
	for(var i = 0;i<result.length;i++){
		if(result[i].dicttypecode==dictType&&result[i].dictdatacode==dictCode){
			return result[i].dictdataname;}}return "";
			};
			function dictReload(ctx,dictType){$.ajax({async:false,url:ctx+'/system/dictReload',data:{'dictType':dictType,'temp':new Date().getTime()},success:function(data){data = eval(data);result=data.result;}});} 

/**
 * 查看保单信息
 */
OrderInfo.prototype.viewPolicy = function(rowIndex){
	$('#orderPolicyData').datagrid('selectRow',rowIndex);
	var row =$('#orderPolicyData').datagrid('getSelected');
	if(row != null){
		var tab = new ECSTab();
		tab.target = $('#mainTab', window.parent.document);
		window.parent.CreateTab("保单详情","policyInfo","../business/policyInfo?policyno="+row.policyno+"&date="+new Date());
	}
};

var orderInfo = new OrderInfo();