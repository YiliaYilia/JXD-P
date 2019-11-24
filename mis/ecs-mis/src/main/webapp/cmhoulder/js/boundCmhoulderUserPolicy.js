
function selectCmhoulder() {
	$('#selectCmhoulderUser_add_window').show();
	$('#selectCmhoulderUser_add_window').window({
		width : 700,
		height : 440,
		modal : true,
		collapsible : false,
		minimizable : false,
		maximizable : false,
		resizable : false,
		iconCls : 'icon-add',
		title:'添加'

	});
	tree.root();
	
}
var tree = {
	setting : {
		callback : {
			onClick : function(event, treeId, treeNode) {
				$("#showCmhoulderBranchName").text(treeNode.cmhdBranchName);
				$
						.ajax({
							url : ctx + "/cmhoulder/queryCmhoulderLoginInfo",
							data : "cmhoulderBranch.cmhdBranchId="
									+ treeNode.cmhdBranchId,
							type : "POST",
							success : function(data) {
								$("#managerLoginInfo").show();
								$("#managerLoginInfo").datagrid({
									pageSize : 10,
									pageList : [ 10, 20, 25, 30 ],
									fit : false,
									fitColumns : false,
									rownumbers : true,
									checkbox : true,
									singleSelect:true,
									data:data,
									loading : "数据加载中...",
									idField : "managerId",
									pagination : true,
									width : ($("#createPolicyTable").width()*0.29),
									columns : [ [ {
										checkbox:true,
										field : 'managerId',
									},{
										field : 'managerLoginName',
										title : '海达经办人账户',
										width : ($("#createPolicyTable").width() * 0.28),
										halign: 'center',
										align:'center'
									}]]
								});
							}
						});
			}
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
		$.post(ctx + "/cmhoulder/getAllCmhoulderTree", null, function(data) {
			$("#showTreeDiv").css("display", "block");
			$.fn.zTree.init($("#tree"), tree.setting, data);

		});

	}
};
function sureSelectManagerLoginInfo() {
	$("#managerLoginInfo").hide();
	$('#selectCmhoulderUser_add_window').window('close');
	var sureData=$("#managerLoginInfo").datagrid('getChecked');
	$("#managerId").val(sureData[0].managerId);
	$("#showManagerLoginName").text(
			sureData[0].managerLoginName);
	

}
function createPolicyTable() {
	var policyNo=$("#policyNo1").val();
	var insuranceCompanyName=$("#insuranceCompanyName").val();
	var productName=$("#productName").val();
	$("#createPolicyTable").datagrid(
			{
				url : '../cmhoulder/queryPolicy',
				pageSize : 10,
				pageList : [ 10, 20, 25, 30 ],
				fit : false,
				fitColumns : false,
				rownumbers : true,
				checkbox : true,
				loading : "数据加载中...",
				idField : "policyNo",
				pagination : true,
				width : $("#createPolicyTable").width(),
				queryParams:{
					"policy.policyNo":policyNo,
					"policy.insuranceCompanyName":insuranceCompanyName,
					"policy,productName":productName
				},
				columns : [ [ {
					field : 'checkbox',
					checkbox : true,
					title:'全选'
				}, {

					field : 'policyNo',
					title : '保单号',
					width : ($("#createPolicyTable").width() * 0.16)
				}, {
					field : 'insuranceCompanyName',
					title : '保险公司名称',
					width : ($("#createPolicyTable").width() * 0.16)
				}, {
					field : 'productName',
					title : '产品名称',
					width : ($("#createPolicyTable").width() * 0.16)
				}, {
					field : 'policyStatus',
					title : '状态',
					width : ($("#createPolicyTable").width() * 0.16)
				}, {
					field : 'period',
					title : '保障期限',
					width : ($("#createPolicyTable").width() * 0.16)
				}, {
					field : 'premium',
					title : '保费',
					width : ($("#createPolicyTable").width() * 0.16)
				} ,{
					field:"operate",
					title:"操作",
					width:($("#createPolicyTable").width() * 0.16),
					formatter: function(value,row,index){
				         if (row.user){
				             return row.user.name;
				          } else {
				             return value;
				          }  			
				      }  		
				   
				}] ]
				
			});
	toolBar();
}
function boundPolicy(){
	var showCmhoulderBranchName=$("#showCmhoulderBranchName").text();
	var showManagerLoginName=$("#showManagerLoginName").text();
	var selectPolicy=$("#createPolicyTable").datagrid('getChecked');
	var policyNo="";
	for(var i=0;i<selectPolicy.length;i++){
		policyNo+=selectPolicy[i].policyNo+",";
	}
	if(showCmhoulderBranchName==""&& showManagerLoginName==""){
		$.messager.alert('Warning','请选择海达经办人'); 


	}else if(policyNo!=""){
		$.ajax({
			type:"POST",
			url:ctx+"/cmhoulder/boundPolicy",
			data:{
				"policy.policyNo":policyNo,
				"managerLoginInfo.managerId":$("#managerId").val(),
			},
			success:function(data){
				$.messager.show({  	
					  title:'消息提示',  	
					  msg:'绑定保单成功',  	
					  timeout:5000,  	
					  showType:'slide'  
					});
			},
			error:function (XMLHttpRequest, textStatus, errorThrown) {
				$.messager.show({  	
					  title:'消息提示',  	
					  msg:'绑定保单失败.',  	
					  timeout:5000,  	
					  showType:'slide'  
					});
			}
		});
	}else{
		$.messager.alert('Warning','请勾选保单'); 
	}
}
function toolBar(){
	$('.datagrid-toolbar table tr').append("<td></td>");
	$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
}