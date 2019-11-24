var Policy = function(){};
Policy.prototype.ctx = null;

/**
 * 查看按钮
 */
Policy.view = {
	text : ECSINFO.view,
	iconCls : 'icon-search',
	handler : function() {
		var rows =$('#policyData').datagrid('getChecked');
    	if(rows== null || rows.length != 1){
    		ECSINFO.alert_update_unique();
    		return false;
    	}
    	else{
    		var row = rows[0];
    		var tab = new ECSTab();
			tab.target = $('#mainTab', window.parent.document);
			window.parent.CreateTab("保单详情","policyInfo","../business/policyInfo?policyno="+row.policyno+"&date="+new Date());
    	}
	}
};

Policy.exp =  {
		text : '导出',
		iconCls : 'icon-add',
		handler : function() {
		//	window.location.href='../business/expPolicy'
			var policycode = $("#policycode-search").val().replace(/\s+/g,"");
			var productname = $("#productname-search").val().replace(/\s+/g,"");
			var applicantname = $("#applicantname-search").val().replace(/\s+/g,"");
			var status = $("#policystatus-search").val();
			var insuretimebegin = $("#insuretimebegin-search").val();
			var insuretimeend = $("#insuretimeend-search").val();
			window.location.href='../business/expCharityPolicy?policycode='+policycode+'&productname='+productname+'&applicantname='+applicantname+'&status='
									+status+'&starttime='+insuretimebegin+'&endtime='+insuretimeend;                                 
		}
};



/**
 * 工具栏
 */
Policy.prototype.toolbar = [];

/**
 * 初始化工具栏
 */
Policy.prototype.initToolBar = function(){
	if(auth.access('RULE_BUSINESSDATA_POLICY')){
		this.toolbar.push(Policy.view);
		this.toolbar.push(Policy.exp);
		this.toolbar.push("-");
	}
};

/**
 * 自定义工具栏
 */
Policy.prototype.initOwnToolBar = function(){
	$('.datagrid-toolbar table tr').append("<td></td>");
	$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
};

/**
 * 创建用户信息数据表格
 */
Policy.prototype.createDataGrid = function(){
	this.initToolBar();
	$('#policyData').datagrid({
		toolbar : this.toolbar,
		fit : true,
		pagination:true,
		rownumbers:true,
		pageSize:15,
		pageList:[15,20,30,50],
		loading:"数据加载中...",
		idField:"policyno",
		checkbox:true,
		width : $("#policyData").width(),
		fitColumns:true,
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
			width : $("#policyData").width() * 0.15,
			halign: 'center',
			align:'center'
		}, {
			field : 'productname',
			title : '产品名称',
			width : $("#policyData").width() * 0.2,
			halign: 'center',
			align:'center'
		}, {
			field : 'insuretime',
			title : '投保日期',
			width : $("#policyData").width() * 0.1,
			halign: 'center',
			align:'center'
		}, {
			field : 'applicantname',
			title : '投保人',
			width : $("#policyData").width() * 0.1,
			halign: 'center',
			align:'center'
		}, {
			field : 'insuredname',
			title : '被保人',
			width : $("#policyData").width() * 0.1,
			halign: 'center',
			align:'center'
		}, {
			field : 'agentcode',
			title : '推荐人号码',
			width : $("#policyData").width() * 0.1,
			halign: 'center',
			align:'center'
		},  {
			field : 'preferentialcode',
			title : '活动码',
			width : $("#policyData").width() * 0.1,
			halign: 'center',
			align:'center'
		}, {
			field : 'takeeffecttime',
			title : '生效日期',
			width : $("#policyData").width() * 0.1,
			formatter: function(value){
				return formatdata(value);
			},
			halign: 'center',
			align:'center'
		}, {
			field : 'deadlinetime',
			title : '截止日期',
			width : $("#policyData").width() * 0.1,
			formatter: function(value){
				return formatdata(value);
			},
			halign: 'center',
			align:'center'
		}, {
			field : 'sumbasepremium',
			title : '保费',
			width : $("#policyData").width() * 0.1,
			formatter: function(value){
				return "￥"+value;
			},
			halign: 'center',
			align:'center'
		}, {
			field : 'sumamount',
			title : '总保额',
			width : $("#policyData").width() * 0.1,
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
	this.initOwnToolBar();
	this.loadData();
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
 * 开始加载数据
 */
Policy.prototype.loadData = function(){
	$('#policyData').datagrid('options').url = this.ctx+"/business/charityFindPolicyData";
	
}


/**
 * 查询
 */
Policy.prototype.searchData = function(){
	var policycode = $("#policycode-search").val().replace(/\s+/g,"");
	var productname = $("#productname-search").val().replace(/\s+/g,"");
	var applicantname = $("#applicantname-search").val().replace(/\s+/g,"");
	var status = $("#policystatus-search").val();
	var insuretimebegin = $("#insuretimebegin-search").val();
	var insuretimeend = $("#insuretimeend-search").val();
	$('#policyData').datagrid('load',{  
	     "gePolicy.policycode": policycode,
	    "gePolicy.productname": productname,
	     "gePolicy.applicantname": applicantname,
	     "gePolicy.status": status,
	     "gePolicy.starttime": insuretimebegin,
	     "gePolicy.endtime": insuretimeend
	});
	$('#policyData').datagrid('clearSelections');
};

var policy = new Policy();