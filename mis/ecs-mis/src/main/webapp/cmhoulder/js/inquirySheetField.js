//$("#addIfd").validator({
//	theme:'yellow_right_effect',
//			rules: {
//				"#inquiryFieldName": function(element){
//			  		if(testInquiryFieldName()){
//			  			return true;
//			  		}else{
//			  			return "对不起，你输入的字段名称已经存在，请重新输入";
//			  		}
//			  	},
//			},
//			fields: {
//				 '#inquiryFieldName': 'required; inquiryFieldName;',
//				 '#inquiryFieldDisplayType':'required;inquiryFieldDisplayType'
//			}
//		}).on("click", "#addIfdbutton", function(){
//			$('#addIfd').trigger("submit");
//		});
//
//function testInquiryFieldName(){
//	var flag = false;
//	var name = $("input[name='inquiryFieldName']").val();
//	$.ajax({
//		type:"POST",
//		url:"${ctx}/cmhoulder/saveIFD",
//		data:"inquiryFieldDictionary.inquiryFieldName="+name,
//		success:function(data){
//			if("OK"==data){
//				flag = true;
//			}else if("NO"==data){
//				flag = false;
//			}
//		}
//	});
//	return flag;
//}

//列表信息显示
createIfdDataGrid = function(jsonData) {
	var inquiryFieldName = $("#IFDName").val();
	$('#ifdList')
			.datagrid(
					{
						url : "../cmhoulder/loadIFDdetail",
						pageSize : 20,
						resultType : "json",
						pagination : true,
						rownumbers : true,
						fit : false,
						fitColumns : true,
						queryParams : {
							'inquiryFieldDictionary.inquiryFieldName' : inquiryFieldName
						},
						columns : [ [
								{
									field : 'inquiryFieldDictId',
									title : '字段编码',
									width : ($('#ifdList').width() * 0.2),
									align : 'left'
								},
								{
									field : 'inquiryFieldName',
									title : '字段名称',
									width : ($('#ifdList').width() * 0.1),
									align : 'left',
									formatter : function(value, row) {
										return "<a  href='#' onclick=ifdDetails('"
												+ row.inquiryFieldDictId
												+ "')>" + value + "</a>";
									}
								}, {
									field : 'inquiryFieldDisplayType',
									title : '字段值显示形式',
									width : ($('#ifdList').width() * 0.1),
									align : 'left',
									formatter : function(value, row, index) {
										if (value == "1") {
											return row = "文本框";
										}
										if (value == "2") {
											return row = "文本编辑框";
										}
										if (value == "3") {
											return row = "Word编辑控件";
										}
									}
								}

						] ]
					});
};

// 弹出详情页面层
var ifdDetails = function(id) {
	$.ajax({
		type : "POST",
		url : "../cmhoulder/jumpIFDDetails",
		data : {
			'inquiryFieldDictionary.inquiryFieldDictId' : id
		},
		success : function(data) {
			$("#ifdId").text(data.inquiryFieldDictId);
			$("#ifdName").text(data.inquiryFieldName);
			if (data.inquiryFieldDisplayType == "1") {
				$("#ifdType").text('文本框');
			}
			if (data.inquiryFieldDisplayType == "2") {
				$("#ifdType").text('文本编辑框');
			}
			if (data.inquiryFieldDisplayType == "3") {
				$("#ifdType").text('Word编辑控件');
			}
			$("#compileOperate").attr("onclick",
					"updateIfd('" + data.inquiryFieldDictId + "')");
			$("#deleteOperate").attr("onclick",
					"deleteIfd('" + data.inquiryFieldDictId + "')");
		},
	});

	$("#ifdDetails").show();
	$('#ifdDetails').window({
		width : 400,
		height : 150,
		modal : true,
		collapsible : false,
		minimizable : false,
		maximizable : false,
		resizable : false,
		title : '详情页面'
	});
};

// 删除询价单字段信息
var deleteIfd = function(id) {
	if (confirm("真的要删除该条信息吗？")) {
		$.ajax({
			type : "POST",
			url : "../cmhoulder/deleteIFDById",
			data : {
				'inquiryFieldDictionary.inquiryFieldDictId' : id
			},
			success : function(data) {
				if ("OK" == data) {
					alert("删除成功");
				} else if ("NO" == data) {
					alert("删除失败，服务器繁忙");
				}
				$("#ifdDetails").window("close");
				createIfdDataGrid();
			}
		});
	} else {
	}
}

// 跳转到修改页面
var updateIfd = function(id) {
	$.ajax({
		type : "POST",
		url : "../cmhoulder/jumpIFDUpdatePage",
		data : {
			'inquiryFieldDictionary.inquiryFieldDictId' : id
		},
		success : function(data) {
			$("#updateId").text(data.inquiryFieldDictId);
			$("#updateIfdId").attr("value", data.inquiryFieldDictId);
			$("#updateIfdName").attr("value", data.inquiryFieldName);
			$("#updateIfdName1").attr("value", data.inquiryFieldName);
			$("#" + data.inquiryFieldDisplayType).attr("selected", true);
		},
	});
	$("#ifdDetails").window("close");
	$("#updatePage").show();
	$('#updatePage').window({
		width : 450,
		height : 200,
		modal : true,
		collapsible : false,
		minimizable : false,
		maximizable : false,
		resizable : false,
		iconCls : 'icon-edit',
		title : ECSINFO.update
	});
}

// 弹出添加页面
var addIFD = function() {
	$("#addPage").form("clear");
	$("#inquiryFieldName").val("");
	$("#inquiryFieldDisplayType").val("0");
	$("#addPage").show();
	$('#addPage').window({
		width : 450,
		height : 200,
		modal : true,
		collapsible : false,
		minimizable : false,
		maximizable : false,
		resizable : false,
		iconCls : 'icon-add',
		title : ECSINFO.add
	});
}

//ajax添加询价单字段
function saveIFD(){
	var name = $("input[name='inquiryFieldName']").val();
	var displayType = $("select[name='inquiryFieldDisplayType']").val();
	if(name.toString().trim()!="" && displayType!="0"){
	$.ajax({
		type:"POST",
		url:"../cmhoulder/saveIFD",
		data:"inquiryFieldDictionary.inquiryFieldName="+name+"&inquiryFieldDictionary.inquiryFieldDisplayType="+displayType,
		success:function(data){
			if("OK"==data){
				alert("添加成功");
				$("#addPage").window("close");
				createIfdDataGrid();
			}else if("NO"==data){
				alert("您输入的字段名称已经存在，请重新输入");
			}else if("error"==data){
				alert("服务器异常未添加成功");
			}
		}
	});
	}else{
		alert('有选项为填写');
	}
}

//修改字段
function updateIfdForm(){
	var name = $("#updateIfdName").val();
	var name1 = $("#updateIfdName1").val();
	if(name1 != name){
		$.ajax({
			type:"POST",
			url:"../cmhoulder/findIFDByInquiryName",
			data:"inquiryFieldDictionary.inquiryFieldName="+name,
			success:function(data){
				if("OK"==data){
					$("#updateIfdForm").submit();
					$("#updatePage").window("close");
					createIfdDataGrid();
				}else if("NO"==data){
					alert("您输入的字段名称已经存在，请重新输入");
				}
			}
		});
	}else{
		$("#updateIfdForm").submit();
	}
}

//重置修改页面
function resetUpdateIfdForm(){
	$("#updateIfdForm").form('reset');
}
