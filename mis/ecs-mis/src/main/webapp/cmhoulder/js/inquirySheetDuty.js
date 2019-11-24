//$("#addIddForm").validator({
//		rules: {
//		  	
//		},
//		fields: {
//			'#tkmc':"required;"
//		}
//}).on("click", "#addsubmit", function(){
//			$('#addIddForm').trigger("submit");
//});

//条款列表信息显示
function createIddDataGrid(jsonData) {
	var dutyName = $("#dutyName").val();
	var dutyCode = $("#dutyCode").val();
	$('#iddList').datagrid(
			{
				url : "../cmhoulder/jumpIDDQueryPage",
				pageSize : 20,
				resultType : "json",
				pagination : true,
				rownumbers : true,
				fit : false,
				fitColumns : true,
				queryParams : {
					'inquiryDutyDictionary.dutyName' : dutyName,
					'inquiryDutyDictionary.dutyCode' : dutyCode
				},
				columns : [ [
						{
							field : 'dutyCode',
							title : '条款编号',
							width : ($('#iddList').width() * 0.2),
							align : 'left'
						},
						{
							field : 'dutyName',
							title : '条款名称',
							width : ($('#iddList').width() * 0.1),
							align : 'left',
							formatter : function(value, row) {
								return "<a  href='#' onclick=iddDetails('"
										+ row.dutyId + "')>" + value + "</a>";
							}
						},
						{
							field : 'operate',
							title : '操作',
							width : ($('#iddList').width() * 0.1),
							align : 'left',
							formatter : function(value, row) {
								return "<a  href='#' onclick=iddDetails('"
										+ row.dutyId + "')>查看详情</a>";
							}
						} ] ]
			});
};

// 详情页面
function iddDetails(id) {
	$.ajax({
		type : "POST",
		url : "../cmhoulder/jumpIDDDetails",
		data : {
			'inquiryDutyDictionary.dutyId' : id
		},
		success : function(data) {
			$("#iddDutyId").text(data.dutyId);
			$("#iddDutyName").text(data.dutyName);
			$("#iddDutyInfo").text(data.dutyInfo);
			$("#compileOperate").attr("onclick",
					"updateIdd('" + data.dutyId + "')");
			$("#deleteOperate").attr(
					"onclick",
					"deleteIdd('" + data.dutyId + "','" + data.dutyInfoPath
							+ "')");
		}
	});

	$("#dutyDetails").show();
	$('#dutyDetails').window({
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

// 修改条款
function updateIdd(id) {
	$
			.ajax({
				type : "POST",
				url : "../cmhoulder/jumpIDDDetails",
				data : {
					'inquiryDutyDictionary.dutyId' : id,
				},
				success : function(data) {
					$("#iddDutyCode2").text(data.dutyCode);
					$("#iddDutyId2").attr("value", data.dutyId);
					$("#iddDutyCode").attr("value", data.dutyCode);
					$("#iddCreateTime").attr("value", data.createTime);
					$("#iddDutyInfoPath").attr("value", data.dutyInfoPath);
					$("#iddDutyName3").attr("value", data.dutyName);
					$("#iddDutyName2").attr("value", data.dutyName);
					$("#iddDutyInfo2").attr("value", data.dutyInfo).text(
							data.dutyInfo);
				},
			});
	$("#dutyDetails").window("close");
	$("#updateDuty").show();
	$('#updateDuty').window({
		width : 400,
		height : 300,
		modal : true,
		collapsible : false,
		minimizable : false,
		maximizable : false,
		resizable : false,
		iconCls : 'icon-edit',
		title : ECSINFO.update
	});
}

// 删除条款
function deleteIdd(id, dutyPath) {
	if (confirm("真的要删除该条信息吗？")) {
		$.ajax({
			type : "POST",
			url : "../cmhoulder/deleteIDD",
			data : {
				'inquiryDutyDictionary.dutyId' : id,
				'inquiryDutyDictionary.dutyInfoPath' : dutyPath
			},
			success : function(data) {
				if ("OK" == data) {
					alert("删除成功");
				} else if ("NO" == data) {
					alert("删除失败，服务器繁忙");
				}
				$("#dutyDetails").window("close");
				createIddDataGrid();
			}
		});

	} else {
	}
}

// 添加条款页面
function addIdd() {
	$("#tkbm").val("");
	$("#tkmc").val("");
	$("#tknr").val("");
	$("#tklj").val("");
	$("#addIdd").show();
	$('#addIdd').window({
		width : 500,
		height : 300,
		modal : true,
		collapsible : false,
		minimizable : false,
		maximizable : false,
		resizable : false,
		iconCls : 'icon-add',
		title : ECSINFO.add
	});
}

//添加条款
function addIddForm(){
	var name = $("#tkmc").val();
	var displayType = $("#tknr").val();
	var info = $("#tklj").val();
	var code = $("#tkbm").val();
	if(name.toString().trim()!=""&&displayType.toString().trim()!=""&&info!=""&&code.toString().trim()!=""){
		$.ajax({
			type:"POST",
			url:"../cmhoulder/findIDDByDutyName",
			data:{
				'inquiryDutyDictionary.dutyName':name,
			},
			success:function(data){
				if("OK"==data){
					alert("添加成功");
					$("#addIddForm").submit();
					$("#addIdd").window("close");
					createIddDataGrid();
				}else if("NO"==data){
					alert("您输入的条款名称在系统中已经存在，请重新输入");
				}
			}
		});
	}
}
//修改条款
function updateIddForm(){
	var name = $("#iddDutyName2").val();
	var name1 = $("#iddDutyName3").val();
	if(name1 != name){
		$.ajax({
			type:"POST",
			url:"../cmhoulder/findIDDByDutyName",
			data:{
				'inquiryDutyDictionary.dutyName':name,
			},
			success:function(data){
				if("OK"==data){
					$('#updateIddForm').submit();
					$("#updateDuty").window("close");
					createIddDataGrid();
				}else if("NO"==data){
					alert("您输入的条款名称在系统中已经存在，请重新输入");
				}
				
			}
		});
	}else{
		$('#updateIddForm').submit();
	}
}

//修改页面重置信息
function resetUpdateIddForm(){
	$('#updateIddForm').form('reset');
}