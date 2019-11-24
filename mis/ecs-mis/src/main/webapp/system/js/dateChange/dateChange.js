var UserManage = function() {
};
UserManage.prototype.ctx = null;

/**
 * 导出按钮
 */
UserManage.add = {
	text : '导出',
	iconCls : 'icon-add',
	handler : function() {
		var cardNo = $("#cardNo").val();
		var startTime = $("#insuretimebegin-search").val();
		var endTime = $("#insuretimeend-search").val();
		window.location.href = '../system/exportDateChange?cardNo=' + cardNo
				+ '&insuretimebegin=' + startTime + '&insuretimeend=' + endTime
	}
};

/**
 * 工具栏
 */
UserManage.prototype.toolbar = [];

/**
 * 初始化工具栏
 */
UserManage.prototype.initToolBar = function() {
	if (auth.access('RES_AUTH_USER_ADD')) {
		this.toolbar.push(UserManage.add);
		this.toolbar.push("-");
	}

};

/**
 * 创建用户信息数据表格
 */
UserManage.prototype.createDataGrid = function() {
	this.initToolBar();
	$('#userData').datagrid(
			{
				toolbar : this.toolbar,
				url : '../system/DateChangeDataSearch',
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
							checkbox : true,
							field : 'checkbox',
							title : 'checkbox'
						},
						{
							field : 'coustomerid',
							title : '客户号',
							width : ($("#userData").width() * 0.15),
							halign : 'center',
							align : 'center'
						},
						{
							field : 'changeType',
							title : '变更主体',
							width : ($("#userData").width() * 0.15),
							halign : 'center',
							align : 'center'
						},
						{
							field : 'cardType',
							title : '证件类型',
							width : ($("#userData").width() * 0.15),
							halign : 'center',
							align : 'center'
						},
						{
							field : 'cardNo',
							title : '证件号码',
							width : ($("#userData").width() * 0.15),
							halign : 'center',
							align : 'center'
						},
						{
							field : 'expiredDate',
							title : '证件有效期',
							halign : 'center',
							align : 'center'
						},
						{
							field : 'front',
							title : '证件正面',
							width : ($("#userData").width() * 0.09),
							formatter : function(value) {
								return "<a href=\"#\"  onclick=\"open2('"
										+ value + "');\">点击显示</a>"
							},
							halign : 'center',
							align : 'center'
						},
						{
							field : 'contrary',
							title : '证件反面',
							width : ($("#userData").width() * 0.09),
							formatter : function(value) {
								return "<a href=\"#\"  onclick=\"open2('"
										+ value + "');\">点击显示</a>"
							},
							halign : 'center',
							align : 'center'
						}, {
							field : 'updatetime',
							title : '变更时间',
							halign : 'center',
							align : 'center'
						} ] ]
			});
	this.initOwnToolBar();
};

var result = '';
function typeTransfer(dictCode, dictType) {
	if (result == '') {
		result = [ {
			"dictdatacode" : "F",
			"dictdataname" : "女",
			"dicttypecode" : "SEX"
		}, {
			"dictdatacode" : "M",
			"dictdataname" : "男",
			"dicttypecode" : "SEX"
		}, {
			"dictdatacode" : "0",
			"dictdataname" : "无效",
			"dicttypecode" : "STATE"
		}, {
			"dictdatacode" : "1",
			"dictdataname" : "有效",
			"dicttypecode" : "STATE"
		}, {
			"dictdatacode" : "ID_CARD",
			"dictdataname" : "身份证",
			"dicttypecode" : "IDTYPE"
		}, {
			"dictdatacode" : "PASSPORT",
			"dictdataname" : "护照",
			"dicttypecode" : "IDTYPE"
		}, {
			"dictdatacode" : "MOC",
			"dictdataname" : "军官证",
			"dicttypecode" : "IDTYPE"
		}, {
			"dictdatacode" : "DRIVING_LICENSE",
			"dictdataname" : "驾照",
			"dicttypecode" : "IDTYPE"
		}, {
			"dictdatacode" : "BC",
			"dictdataname" : "出生证明",
			"dicttypecode" : "IDTYPE"
		}, {
			"dictdatacode" : "CTC",
			"dictdataname" : "台胞证",
			"dicttypecode" : "IDTYPE"
		}, {
			"dictdatacode" : "SOLDIERS",
			"dictdataname" : "士兵证",
			"dicttypecode" : "IDTYPE"
		}, {
			"dictdatacode" : "HKMTP",
			"dictdataname" : "港澳通行证",
			"dicttypecode" : "IDTYPE"
		}, {
			"dictdatacode" : "MID",
			"dictdataname" : "港澳台回乡证",
			"dicttypecode" : "IDTYPE"
		}, {
			"dictdatacode" : "HHR",
			"dictdataname" : "户口本",
			"dicttypecode" : "IDTYPE"
		}, {
			"dictdatacode" : "OTHERS",
			"dictdataname" : "其他",
			"dicttypecode" : "IDTYPE"
		}, {
			"dictdatacode" : "BIRTHCERT",
			"dictdataname" : "出生日期",
			"dicttypecode" : "IDTYPE"
		} ];
	}
	result = eval(result);
	for (var i = 0; i < result.length; i++) {
		if (result[i].dicttypecode == dictType
				&& result[i].dictdatacode == dictCode) {
			return result[i].dictdataname;
		}
	}
	return "";
};
function dictReload(ctx, dictType) {
	$.ajax({
		async : false,
		url : ctx + '/system/dictReload',
		data : {
			'dictType' : dictType,
			'temp' : new Date().getTime()
		},
		success : function(data) {
			data = eval(data);
			result = data.result;
		}
	});
}

/**
 * 搜索
 * 
 * @param username
 */
UserManage.prototype.searchData = function() {
	var cardNo = $("#cardNo").val();
	var startTime = $("#insuretimebegin-search").val();
	var endTime = $("#insuretimeend-search").val();
	if (typeof (cardNo) == 'undefined') {
		cardNo = "";
	} else {
		cardNo = cardNo.replace(/\s+/g, "");
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
		'dateChangeData.cardNo' : cardNo,
		'dateChangeData.starttime' : startTime,
		'dateChangeData.endtime' : endTime
	});
};

/**
 * 重新加载用户数据
 */
UserManage.prototype.reloadGrid = function() {
	$("#userData").datagrid('reload', {
		'dateChangeData.cardNo' : $("#cardNo").val()
	});
};

/**
 * 加载搜索条
 */
UserManage.prototype.initOwnToolBar = function() {
	$('.datagrid-toolbar table tr').append("<td></td>");
	$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
};

var userManage = new UserManage();