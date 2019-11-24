var Investment = function(){};
Investment.prototype.ctx = null;

Investment.exp =  {
		text : '导出',
		iconCls : 'icon-add',
		handler : function() {
			var policyNo = $("#policyNo-search").val().replace(/\s+/g,"");
			var applicantName = $("#applicantName-search").val().replace(/\s+/g,"");
			var startTime = $("#startTime-search").val();
			var endTime = $("#endTime-search").val();
			window.location.href='../business/expInvestment?policyNo='+policyNo+'&applicantName='+encodeURI(encodeURI(applicantName))+'&startTime='+startTime+'&endTime='
								+endTime;
		}
};
/**
 * 工具栏
 */
Investment.prototype.toolbar = [];

/**
 * 初始化工具栏
 * 导出按钮
 */
Investment.prototype.initToolBar = function(){
	if(auth.access('RULE_BUSINESSDATA_ORDER')){
		this.toolbar.push(Investment.exp);
		this.toolbar.push("-");
	}
};

/**
 * 自定义工具栏
 */
Investment.prototype.initOwnToolBar = function(){
	$('.datagrid-toolbar table tr').append("<td></td>");
	$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
};

/**
 * 创建用户信息数据表格
 */
Investment.prototype.createDataGrid = function(){
	this.initToolBar();
	var that = this;
	var userid = $("#userid-search").val().replace(/\s+/g,"");
	$('#investmentData').datagrid({
		toolbar : this.toolbar,
		url : that.ctx+'/business/findInvestmentData',
		fit : true,
		pagination:true,
		rownumbers:true,
		pageSize:15,
		pageList:[15,20,30,50],
		loading:"数据加载中...",
		idField:"investmentno",
		checkbox:true,
		width : $("#investmentData").width(),
		fitColumns:true,
		columns : [ [ {
			field : 'investmentno',
			title : 'investmentno',
			hidden: true
		}, {
			checkbox:true,
			field : 'checkbox',
			title : 'checkbox'
		}, {
			field : 'policyNo',
			title : '保单号',
			width : $("#investmentData").width() * 0.15,
			halign: 'center',
			align:'center'
		}, {
			field : 'applicantName',
			title : '投保人', 
			width : $("#investmentData").width() * 0.2,
			halign: 'center',
			align:'center'
		}, {
			field : 'accountBank',
			title : '开户行', 
			width : $("#investmentData").width() * 0.1,
			halign: 'center',
			align:'center'
		}, {
			field : 'bankCardId',
			title : '银行卡号',
			width : $("#investmentData").width() * 0.1,
			halign: 'center',
			align:'center'
		}, {
			field : 'amount',
			title : '追加金额',
			width : $("#investmentData").width() * 0.1,
			halign: 'center',
			align:'center'
		}, {
			field : 'createTime',
			title : '追加日期',
			width : $("#investmentData").width() * 0.1,
			halign: 'center',
			align:'center'
		}] ]
	});
	this.initOwnToolBar();
};

/**
 * 查询
 */
Investment.prototype.searchData = function(){
	var policyNo = $("#policyNo-search").val().replace(/\s+/g,"");
	var applicantName = $("#applicantName-search").val().replace(/\s+/g,"");
	var startTime = $("#startTime-search").val();
	var endTime = $("#endTime-search").val();
	$('#investmentData').datagrid('load',{  
	     "geInvestment.policyNo": policyNo,
	     "geInvestment.applicantName":applicantName,
	     "startTime":startTime,
	     "endTime":endTime
	});
	$('#investmentData').datagrid('clearSelections');
};


var result = '';

var investment = new Investment();