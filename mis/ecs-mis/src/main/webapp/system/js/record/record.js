var Record = function(){};
Record.prototype.ctx = null;



Record.prototype.toolbar =[];



Record.prototype.createRecordTreeGrid = function(){
	var that = this;
	$('#RecordDatagrid').datagrid({
		fit:true,
		toolbar : that.toolbar,
		pagination : true,
		rownumbers:true,
		fitColumns:true,
		title:"",
		pageSize:15,
		pageList:[10,15,20],
		columns : [ [
         
		 {
			field : 'operatorName',
			title : '操作人',
			width : ($("#RecordDatagrid").width() * 0.1)
		}, {
			field : 'expendTime',
			title : '系统消耗时间/ms',
			width : ($("#RecordDatagrid").width() * 0.2)
		}, {
			field : 'createTime',
			title : '日志创建时间',
			width : ($("#RecordDatagrid").width() * 0.25)
		},
		{
			field:'description',
			title : '内容',
			width : ($("#RecordDatagrid").width() * 0.45)
 		}
		
		] ]
	});
	
	that.initOwnToolBar();
	that.loadData();
	
};



Record.prototype.initOwnToolBar = function(){
		$('.datagrid-toolbar table tr').append("<td></td>");
		$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
}

/**
 * 开始加载数据
 */
Record.prototype.loadData = function(){
	var that =this;
	$('#RecordDatagrid').datagrid('options').url = that.ctx+"/system/getDailyRecord";
}
/**
 * 查询数据
 */
Record.prototype.searchData = function(){
	var operatorName = $("#operatorName").val().replace(/\s+/g,"");
	var startTime = $('#startTime').datebox('getValue')+'';
	var endTime = $('#endTime').datebox('getValue')+'';
	$('#RecordDatagrid').datagrid('load',{  
	        "operatorName": operatorName,
	        "startTime":startTime,
	        "endTime":endTime
	 });  
}
