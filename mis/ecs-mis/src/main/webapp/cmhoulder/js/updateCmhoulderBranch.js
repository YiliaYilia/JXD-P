var data=null;
function createTable(){
	var managerLoginName=$("#managerLoginName").val();
	var managerName=$("#managerName").val();
	var status=$("#status").val();
	$('#createCmhoulderTable').datagrid({
		toolbar : this.toolbar,
		url : '../cmhoulder/queryManagerLoginInfo', 
		fit : false,
		pagination:true,
		rownumbers:true,
		pageSize:10,
		pageList:[10,20,30,50],
		singleSelect:true,
		loading:"数据加载中...",
		idField:"managerId",
		checkbox:true,
		width : $("#createCmhoulderTable").width(),
		fitColumns:true,
		queryParams:{
			"managerLoginInfo.managerLoginName":managerLoginName,
			"managerLoginDetail.managerName":managerName,
			"managerLoginInfo.status":status,
		},
		columns : [ [ {
			field : 'managerLoginName',
			title : '用户名/邮箱',
			width : ($("#createCmhoulderTable").width() * 0.2),
			halign: 'center',
			align:'center',
			formatter:function(value,row,index){
				
				return "<a href='#' style='cursor：pointer;'>"+value+"</a>";
			}
		}, {
			
			field : 'managerName',
			title : '姓名',
			width : ($("#createCmhoulderTable").width() * 0.2),
			halign: 'center',
			align:'center',
		}, {
			field : 'moblie',
			title : '手机号码',
			
			halign: 'center',
			align:'center'
		},{
			field : 'cmhdBranchName',
			title : '所属机构',
			width : ($("#createCmhoulderTable").width() * 0.15),
			halign: 'center',
			align:'center'
		}
		] ],
		onClickRow:function(rowIndex, rowData){
			data=rowData;
			updateManagerLoginInfo();
		}
	});
}
function updateManagerLoginInfo(){
	$("#form").form("clear");
	$("#updateLoginInfoAndDetail").show();
	$("#updateLoginInfoAndDetail").window({
		width : 400,
		height : 440,
		modal : true,
		collapsible : false,
		minimizable : false,
		maximizable : false,
		resizable : false,
	});
	$("#detail").show();
	$("#update").hide();
	$("#email").text(data.managerLoginName);
	$("#name").text(data.managerName);
	$("#phone").text(data.moblie);
	$("#idno").text(data.idno);
	$("#sex").val(data.sex);
	$("#branch").text(data.cmhdBranchName);
	$("#managerLoginName1").val(data.managerLoginName);
	$("#managerName1").val(data.managerName);
	$("#moblie").val(data.moblie);
	$("#idno1").val(data.idno);
	$("#managerId").val(data.managerId);
	$("#mdId").val(data.id);
	$("#mcbId").val(data.mcbId);
	$("#cbId").val(data.cmhdBranchId);
	$("#cmhdBranchName").val(data.cmhdBranchName);
}
function sureCmhoulder(){
	var treeObj = $.fn.zTree.getZTreeObj("tree");
	var nodes = treeObj.getCheckedNodes(true);
	if(nodes.length==0){
		alert("请选择机构");
		return;
	}
	$("#cmhdBranchName").val(nodes[0].cmhdBranchName);
	$("#cmhdBranchId").val(nodes[0].cmhdBranchId);
	$("#cmhoulderTree").window('close');
	
}function selectCmhoulderTree() {
	$("#cmhoulderTree").show();
	tree.root();
	$('#cmhoulderTree').window({
		width : 400,
		height : 340,
		modal : true,
		collapsible : false,
		minimizable : false,
		maximizable : false,
		resizable : false,

	});
}
var tree = {
	setting : {
		check: {
			enable: true,
			chkStyle: "radio",
			radioType: "all"
		},
		view : {
			showLine : true,
			dblClickExpand : true,
			showIcon : true,
			fontCss : {
				color : "gray"
			}
		},

		data : {
			key : {
				name : "cmhdBranchName",
				checked : "isChecked"
			},
			simpleData : {
				enable : true,
				idKey : "cmhdBranchId",
				pIdKey : "cmhdParentBranchNo",
				rootPId : 0
			},

		},

	},
	root : function() {
		$.post( ctx+"/cmhoulder/getAllCmhoulderTree", null,
				function(data) {
					$.fn.zTree.init($("#tree"), tree.setting, data);
				});

	}
};
function update(){
	$("#form").form('submit',{
		url:ctx+"/cmhoulder/updateManagerLoginInfo",
		success:function(data){
			$.messager.show({  	
				  title:'My Title',  	
				  msg:'更新成功',  	
				  timeout:5000,  	
				  showType:'slide'  
			}); 
		},
		error:function (XMLHttpRequest, textStatus, errorThrown) {
			$.messager.show({  	
				  title:'消息提示',  	
				  msg:'更新失败.',  	
				  timeout:5000,  	
				  showType:'slide'  
				});
		}
	});
	$("#updateLoginInfoAndDetail").window("close");
	createTable();
}
function update_1(){
	$("#detail").hide();
	$("#update").show();
}
function back(){
	$("#detail").show();
	$("#update").hide();
}
function reset(){
	$("#managerLoginName1").val(data.managerLoginName);
	$("#managerName1").val(data.managerName);
	$("#moblie").val(data.moblie);
	$("#idno1").val(data.idno);
	$("#cmhdBranchName").val(data.cmhdBranchName);
}
function loginFreeze(){
	$.ajax({
		type:"POST",
		url:ctx+"/cmhoulder/loginFreeze",
		data:{
			"managerLoginInfo.managerId":$("#managerId").val()
		},
		success:function(data){
			$.messager.show({  	
				  title:'消息提示',  	
				  msg:'冻结账户成功.',  	
				  timeout:5000,  	
				  showType:'slide'  
				});
		},
		error:function (XMLHttpRequest, textStatus, errorThrown) {
			$.messager.show({  	
				  title:'消息提示',  	
				  msg:'冻结账户失败.',  	
				  timeout:5000,  	
				  showType:'slide'  
				});
		}
	});
}