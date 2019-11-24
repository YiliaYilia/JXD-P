var IdPhoto = function(){};
IdPhoto.prototype.ctx = null;

/**
 * 导出按钮
 */
IdPhoto.exportExcel = {
	text : '导出',
	iconCls : 'icon-add',
	handler : function() {
		var proposalContNo = $("#proposalContNo").val();
		var startTime = $("#insuretimebegin-search").val();
		var endTime = $("#insuretimeend-search").val();
		var IDs = "";
		$('input:checkbox[name="checkbox"]:checked').each(function(i){
			var $id = $(this).parents("tr").find("td").eq(0).text();
			IDs += ($id+",");
		});
		if(IDs.length > 0){
			IDs = IDs.substring(0, IDs.length - 1);
		}
		window.location.href = '../business/exportIdPhoto?IDs='+IDs+'&proposalContNo='+proposalContNo+'&startTime='+startTime+'&endTime='+endTime
	}
};

/**
 * 图片打包下载为zip
 */
IdPhoto.exportIdPhotoToZip = {
	text : '证件照下载',
	iconCls : 'icon-add',
	handler : function() {
		var proposalContNo = $("#proposalContNo").val();
		var startTime = $("#insuretimebegin-search").val();
		var endTime = $("#insuretimeend-search").val();
		var IDs = "";
		var rows = $('input:checkbox[name="checkbox"]:checked').length;
    	if(rows== null || rows != 1){
    		ECSINFO.alert_update_unique();
    		return false;
    	}else{
    		$('input:checkbox[name="checkbox"]:checked').each(function(i){
    			IDs = $(this).parents("tr").find("td").eq(0).text();
    		});
    		window.location.href = '../business/exportIdPhotoToZip?IDs='+IDs
    	}
	}
};

/**
 * 工具栏
 */
IdPhoto.prototype.toolbar = [];

/**
 * 初始化工具栏
 */
IdPhoto.prototype.initToolBar = function() {
	if (auth.access('RULE_BUSINESSDATA_IDPHOTO')) {
		this.toolbar.push(IdPhoto.exportExcel);
		this.toolbar.push(IdPhoto.exportIdPhotoToZip);
		this.toolbar.push("-");
	}

};


/**
 * 创建用户信息数据表格
 */
IdPhoto.prototype.createDataGrid = function() {
	this.initToolBar();
	$('#userData').datagrid(
			{
				toolbar : this.toolbar,
				url : '../business/getIdData',
				fit : true,
				pagination : true,
				rownumbers : true,
				pageSize : 15,
				pageList : [ 15, 20, 30, 50 ],
				loading : "数据加载中...",
				idField : "userid",
				checkbox : true,
				width : $("#userData").width(),
				fitColumns : true,
				columns : [ [
						{
							field : 'id',
							title : 'id',
							hidden : true
						},
						{
							checkbox:true,
							field : 'checkbox',
							title : 'checkbox'
						}, 
						{
							field : 'proposalContNo',
							title : '投保单号',
//							width : $("#userData").width() * 0.01,
							halign : 'center',
							align : 'center'
						},
						{
							field : 'policyCode',
							title : '产品名称',
							halign : 'center',
							align : 'center'
						},
						{
							field : 'applicantInsured_name',
							title : '投保人姓名',
							halign : 'center',
							align : 'center'
						},
						{
							field : 'applicantInsured_idType',
							title : '投保人证件类型',
							formatter: function(value){
								return codeToName(value,'IDTYPE');
							},
							halign : 'center',
							align : 'center'
						},
						{
							field : 'applicantInsured_IdNo',
							title : '投保人证件号码',
							halign : 'center',
							align : 'center'
						},
						{
							field : 'applicantInsured_endTime',
							title : '投保人证件有效期',
							halign : 'center',
							align : 'center'
						},
						{
							field : 'applicantInsured_frontal',
							title : '投保人证件正面',
							formatter : function(value) {
								return "<a href=\"#\"  onclick=\"open2('"
										+ value + "');\">点击显示</a>"
							},
							halign : 'center',
							align : 'center'
						},
						{
							field : 'applicantInsured_reverse',
							title : '投保人证件反面',
							formatter : function(value) {
								return "<a href=\"#\"  onclick=\"open2('"
										+ value + "');\">点击显示</a>"
							},
							halign : 'center',
							align : 'center'
						},
						{
							field : 'recognizee_name',
							title : '被保人姓名',
							halign : 'center',
							align : 'center'
						},
						{
							field : 'recognizee_idType',
							title : '被保人证件类型',
							formatter: function(value){
								return codeToName(value,'IDTYPE');
							},
							halign : 'center',
							align : 'center'
						},
						{
							field : 'recognizee_IdNo',
							title : '被保人证件号码',
							halign : 'center',
							align : 'center'
						},
						{
							field : 'recognizee_endTime',
							title : '被保人证件有效期',
							halign : 'center',
							align : 'center'
						},
						{
							field : 'recognizee_frontal',
							title : '被保人证件正面',
							formatter : function(value) {
								return "<a href=\"#\"  onclick=\"open2('"
										+ value + "');\">点击显示</a>"
							},
							halign : 'center',
							align : 'center'
						},
						{
							field : 'recognizee_reverse',
							title : '被保人证件反面',
							formatter : function(value) {
								return "<a href=\"#\"  onclick=\"open2('"
										+ value + "');\">点击显示</a>"
							},
							halign : 'center',
							align : 'center'
						}, {
							field : 'uploadTime',
							title : '上传时间',
							halign : 'center',
							align : 'center'
						} ] ]
			});
	this.initOwnToolBar();
};

function codeToName(code,type){
	if(type=='IDTYPE'){
		if(code=='O'){
			return '户口薄';
		}else if(code=='I'){
			return '身份证';
		}
	}else{
		return code;
	}
}


/**
 * 重新加载用户数据
 */
IdPhoto.prototype.reloadGrid = function() {
	$("#userData").datagrid('reload', {
		'idPhotoData.proposalContNo' : $("#proposalContNo").val()
	});
};

/**
 * 加载搜索条
 */
IdPhoto.prototype.initOwnToolBar = function() {
	$('.datagrid-toolbar table tr').append("<td></td>");
	$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
};

/**
 * 搜索
 */
IdPhoto.prototype.searchData = function() {
	var proposalContNo = $("#proposalContNo").val();
	var startTime = $("#insuretimebegin-search").val();
	var endTime = $("#insuretimeend-search").val();
	if (typeof (proposalContNo) == 'undefined') {
		proposalContNo = "";
	} else {
		proposalContNo = proposalContNo.replace(/\s+/g, "");
	}
	if (typeof (startTime) == 'undefined') {
		startTime = "";
	} else {
		startTime = startTime.replace(/\s+/g, "");
	}
	if (typeof (endTime) == 'undefined') {
		endTime = "";
	} else {
		endTime = endTime.replace(/\s+/g, "");
	}
	$('#userData').datagrid('load', {
		'idPhotoData.proposalContNo' : proposalContNo,
		'idPhotoData.starttime' : startTime,
		'idPhotoData.endtime' : endTime
	});
};

var idPhoto = new IdPhoto();