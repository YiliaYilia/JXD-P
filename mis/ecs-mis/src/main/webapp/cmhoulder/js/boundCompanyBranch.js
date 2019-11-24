function createTable(){
	$("#createCmhoulderBoundCompanyBranchTable").datagrid({
		toolbar : this.toolbar,
		url : '../cmhoulder/queryManagerLoginInfoBound', 
		fit : false,
		pagination:true,
		rownumbers:true,
		pageSize:10,
		pageList:[10,20,30,50],
		singleSelect:true,
		loading:"数据加载中...",
		idField:"userid",
		checkbox:true,
		width : $("#createCmhoulderTable").width(),
		fitColumns:true,
		columns : [ [{
			field : 'managerId',
			title : '海达经办人ID',
			width : ($("#createCmhoulderBoundCompanyBranchTable").width() * 0.2),
			halign: 'center',
			align:'center',
			hidden:true
		},{
			field : 'managerLoginName',
			title : '海达经办人账户',
			width : ($("#createCmhoulderBoundCompanyBranchTable").width() * 0.2),
			halign: 'center',
			align:'center',
		},{
			field : 'operated',
			title : '操作',
			width : ($("#createCmhoulderBoundCompanyBranchTable").width() * 0.2),
			halign: 'center',
			align:'center',
			formatter: function(value,row,index){
				return "<a href='#' style='cursor：pointer;' onclick=boundCompanyBranch('"+row.managerId+"')>绑定企业机构</a>";
			}
		}]]
	});
}

	function boundCompanyBranch(id) {
		$("#managerId").val(id);
		$('#permissionData_add_window').show();
		$('#permissionData_add_window').window({
			width : 670,
			height : 440,
			modal : true,
			collapsible : false,
			minimizable : false,
			maximizable : false,
			resizable : false,
			iconCls : 'icon-edit',
			href : ctx+"/company/selectCompanyBranchTree",
			onLoad : function() {
				root(id);
			}

		});
	}
	var tree = {
		setting : {
			check : {
				enable : true,
				chkStyle : "checkbox",
				chkboxType : {
					"Y" : "ps",
					"N" : "ps"
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
					name : "comBranchName" ,

				},
				simpleData : {
					enable : true,
					idKey : "comBranchId",
					pIdKey : "comParentBranchNo",
					rootPId : 0
				},

			},

		}
	};
	function root(id) {
		$.ajax({
			url : ctx+"/company/getCompanyTreeWithNoBound",
			type : "POST",
			success : function(data) {
				$("#showTreeDiv").css("display", "block");
				var treeObj=$.fn.zTree.init($("#tree"), tree.setting, data);
				$.ajax({
					type:"POST",
					url:ctx+"/cmhoulder/getCompanyBranchByManagerId",
					data:"managerLoginInfo.managerId="+id,
					success:function(data){
						for (var i = 0; i < data.length; i++) {
							
							var nodes = treeObj.getNodesByParam("comBranchNo", data[i].comBranchNo, null);
							treeObj.checkNode(nodes[0], true, true);
							
						}
						
					}
				});
			}
		});
	}
	function boundCompanyBranchs() {
		var comBranchIds = "";
		var treeObj = $.fn.zTree.getZTreeObj("tree");
		var nodes = treeObj.getChangeCheckedNodes();
		for (var i = 0; i < nodes.length; i++) {
			comBranchIds += nodes[i].comBranchId + ",";
		}
		$.ajax({
			type : "POST",
			url : ctx+"/cmhoulder/boundCmhoulderAndComanyBranch",
			data : "companyBranch.comBranchId=" + comBranchIds
					+ "&managerLoginInfo.managerId=" + $("#managerId").val(),
			success : function(data) {
				$('#permissionData_add_window').window("close");
				$.messager.show({  	
					  title:'My Title',  	
					  msg:'绑定企业机构成功',  	
					  timeout:5000,  	
					  showType:'slide'  
				}); 
			}
		});
	}