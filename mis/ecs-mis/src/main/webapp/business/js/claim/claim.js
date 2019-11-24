var Claim = function(){};
Claim.prototype.ctx = null;


/**
 * 查看按钮
 */
Claim.view = {
		text : ECSINFO.view,
		iconCls : 'icon-search',
		handler : function() {
			var rows =$('#claimData').datagrid('getChecked');
	    	if(rows== null || rows.length != 1){
	    		ECSINFO.alert_update_unique();
	    		return false;
	    	}
	    	else{
	    		var row = rows[0];
	    		var tab = new ECSTab();
				tab.target = $('#mainTab', window.parent.document);
				window.parent.CreateTab("理赔详情","claimInfo","../business/claimInfo?claimManagementNo="+row.claimManagementNo+"&date="+new Date());
	    	}
		}
	};
/**
 * 导出按钮
 */
Claim.exp={
		text : '导出',
		iconCls : 'icon-add',
		handler : function() {
			var policyno = $("#policyCode-search").val().replace(/\s+/g,"");
			var applicantname = $("#name-search").val().replace(/\s+/g,"");
			var srartTime = $("#createDateBegin-search").val();
			var endTime = $("#createDateEnd-search").val();
			var statesearch = $("#state-search").val();
			var userid = $("#userid-search").val().replace(/\s+/g,"");
			window.location.href='../business/expClaim?policyno='+policyno+'&applicantname='+applicantname+'&srarttime='+srartTime+'&endtime='
								+endTime+'&statesearch='+statesearch+'&userid='+userid;
		}
};
/**
 * 工具栏
 */
Claim.prototype.toolbar = [];

/**
 * 初始化工具栏
 */
Claim.prototype.initToolBar = function(){
	if(auth.access('RULE_BUSINESSDATA_CLAIM')){
		this.toolbar.push(Claim.view);
		this.toolbar.push(Claim.exp);
		this.toolbar.push("-");
	}
};

/**
 * 自定义工具栏
 */
Claim.prototype.initOwnToolBar = function(){
	$('.datagrid-toolbar table tr').append("<td></td>");
	$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
};

/**
 * 创建用户信息数据表格
 */
Claim.prototype.createDataGrid = function(){
	this.initToolBar();
	$('#claimData').datagrid({
		toolbar : this.toolbar,
		fit : true,
		pagination:true,
		rownumbers:true,
		pageSize:15,
		pageList:[15,20,30,50],
		loading:"数据加载中...",
		idField:"claimManagementNo",
		checkbox:true,
		width : $("#claimData").width(),
		fitColumns:true,
		columns : [ [ {
			field : 'claimManagementNo',
			title : 'claimManagementNo',
			hidden: true
		}, {
			checkbox:true,
			field : 'checkbox',
			title : 'checkbox'
		}, {
			field : 'policyCode',
			title : '保险单号',
			width : $("#claimData").width() * 0.25,
			halign: 'center',
			align:'center'
		},  {
			field : 'createDate',
			title : '申请时间',
			width : $("#claimData").width() * 0.25,
			formatter: function(value){
				return formatdata(value);
			},
			halign: 'center',
			align:'center'
		},  {
			field : 'name',
			title : '申请人',
			width : $("#claimData").width() * 0.25,
			halign: 'center',
			align:'center'
		},  {
			field : 'updateDate',
			title : '更新时间',
			width : $("#claimData").width() * 0.25,
			formatter: function(value){
				return formatdata(value);
			},
			halign: 'center',
			align:'center'
		}, {
			field : 'state',
			title : '状态',
			formatter: function(value){
				return dictTrans1(value,'STATUS');
			},
			halign: 'center'
		}, {
			field : 'deptid',
			title : '组织机构',
			width : $("#claimData").width() * 0.1,
			halign: 'center',
			align:'center'
		}] ]
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
		          {"dictdatacode":"01","dictdataname":"已报案","dicttypecode":"STATUS"},
		          {"dictdatacode":"02","dictdataname":"已提交","dicttypecode":"STATUS"},
		          {"dictdatacode":"03","dictdataname":"已退回","dicttypecode":"STATUS"},
		          {"dictdatacode":"04","dictdataname":"审核中","dicttypecode":"STATUS"},
		          {"dictdatacode":"05","dictdataname":"已完成","dicttypecode":"STATUS"},
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
Claim.prototype.loadData = function(){
	var userid = $("#userid-search").val().replace(/\s+/g,"");
	$('#claimData').datagrid('options').url = this.ctx+"/business/findClaimData?userid="+userid;
	
};

/**
 * 查询
 */
Claim.prototype.searchData = function(){
	var policycode = $("#policyCode-search").val().replace(/\s+/g,"");
	var name = $("#name-search").val().replace(/\s+/g,"");
	var createDateBegin = $("#createDateBegin-search").val();
	var createDateEnd = $("#createDateEnd-search").val();
	var state = $("#state-search").val();
	$('#claimData').datagrid('load',{  
	     "geClaimManagement.policyCode": policycode,
	    "geClaimManagement.name": name,
	     "geClaimManagement.starttime": createDateBegin,
	     "geClaimManagement.endtime": createDateEnd,
	     "geClaimManagement.state": state
	});
	$('#claimData').datagrid('clearSelections');
};

var claim = new Claim();