function clear(){
	$("#form").form('clear');
}
	function submit(){
		$("#form").form('submit',{
			url:ctx+"/cmhoulder/addCmhoulder",
			success:function(data){
				$.messager.show({  	
					  title:'My Title',  	
					  msg:'创建成功',  	
					  timeout:5000,  	
					  showType:'slide'  
				}); 
			}
		});
		
		$("#form").form('clear');
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
	}
	function p() {
		var num = "";
		for (var i = 0; i < 6; i++) {
			num += Math.floor(Math.random() * 10);
		}
		$("#password").val(num);
	}
	function selectCmhoulderTree() {
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