		function queryDetail(userid) {
			$('#permissionData_add_window').show();
			$('#permissionData_add_window').window({
				width : 400,
				height : 440,
				modal : true,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				resizable : false,
				//	onClose:permission.reloadGrid,
				iconCls : 'icon-edit',
				//title : ECSINFO.update,
				href : ctx+"/company/queryDetail?loginInfo.userid=" + userid
			});
			
		}
		var tree = {
			setting : {
				check : {
					enable : true,
					chkStyle : "radio",
					//    						chkboxType: { "Y": "p", "N": "ps" }
					radioType : "all"
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
						name : "comBranchName",
						checked : "isChecked"
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
		function button() {
			$("#showTreeDiv").window({
				width : 300,
				height : 340,
				modal : true,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				resizable : false,
			});
			$.post(ctx+"/company/getAllCompanyTree", null, function(data) {
				$("#showTreeDiv").css("display", "block");
				$.fn.zTree.init($("#tree"), tree.setting, data);

			});
		}
		function sureCompany() {
			var treeObj = $.fn.zTree.getZTreeObj("tree");
			var nodes = treeObj.getCheckedNodes(true);
			$("#_companyBranch").val(nodes[(nodes.length - 1)].comBranchName);
			$("#_companyBranch").prop("disabled",true);
			$("#comBranchId").val(nodes[(nodes.length-1)].comBranchId);
			$("#showTreeDiv").window('close');
		}

		function update(){
			$("#_loginEmail").prop("disabled",true);
			$("#idno").prop("disabled",false);
			$("#td1").hide();
			$("#td2").css("display","block");
			$("#td3").hide();
			
			$("#td4").css("display","block");
			$("#_mobile").prop("disabled",false);
			$("#_loginName").prop("disabled",false);
			$("#b").css("display","block");
//			$("#submit").css("display","block");
//			$("#reset").css("display","block");
//			$("#update").hide();
//			$("#freeze").hide();
			$("#div1").hide();
			$("#div2").show();
			p();
		}
		function back(){
			$("#_loginEmail").prop("disabled",true);
			$("#_password").prop("disabled",true);
			$("#_loginName").prop("disabled",true);
			$("#td1").show();
			$("#td2").css("display","none");
			$("#td3").show();
			
			$("#td4").css("display","none");
			$("#_mobile").prop("disabled",true);
			$("#_companyBranch").prop("disabled",true);
			$("#generatePassword").css("display","none");
			$("#b").css("display","none");
			
			$("#div2").hide();
			$("#div1").show();
		}
		function loginFreeze(userid){
			$.post(ctx+"/company/loginFreeze","loginInfo.userid="+userid,function(data){
				alert("冻结成功");
			});
		}
		function createTable(){
			var loginEmail=$("#loginEmail").val();
			var loginName=$("#loginName").val();
			var comBranchName=$("#comBranchName").val();
			var status=$("#status").val();
			$('#createTable').datagrid({
				toolbar : this.toolbar,
				url : '../company/queryCompanyUser', 
				fit : false,
				pagination:true,
				rownumbers:true,
				pageSize:10,
				pageList:[10,20,30,50],
				singleSelect:true,
				loading:"数据加载中...",
				idField:"userid",
				checkbox:true,
				width : $("#createTable").width(),
				fitColumns:true,
				queryParams:{
					"loginInfo.loginMail":loginEmail,
					"loginInfo.loginName":loginName,
					"companyBranch.comBranchName":comBranchName,
					"loginInfo.status":status
				},
				columns : [ [ {
					field : 'userid',
					title : 'id',
					hidden: true
				}, {
					
					field : 'loginMail',
					title : '用户名/邮箱',
					width : ($("#createTable").width() * 0.2),
					halign: 'center',
					align:'center',
					formatter:function(value,row,index){
						
						return "<a href='#' onclick=queryDetail('"+row.userid+"')>"+value+"</a>";
					}
				}, {
					field : 'loginName',
					title : '用户姓名',
					width : ($("#createTable").width() * 0.15),
					halign: 'center',
					align:'center',
					
				}, {
					field : 'mobile',
					title : '联系电话',
					width : ($("#createTable").width() * 0.15),
					halign: 'center',
					align:'center'
				}, {
					field : 'status',
					title : '用户状态',
					width : ($("#createTable").width() * 0.2),
					halign: 'center',
					align:'center'
				},{
					field : 'comBranchName',
					title : '所属机构',
					
					halign: 'center',
					align:'center'
				},
				] ],
			});
		}
		function submit(){
			$("#name").val($("#_loginName").val());
			$("#_loginEmail").prop("disabled",false);
			$("#form").form('submit',{
				url:ctx+'/company/updateLoginInfo',
				success:function(data){
						$.messager.show({  	
							  title:'My Title',  	
							  msg:'更新企业经办人成功，邮件发送成功',  	
							  timeout:5000,  	
							  showType:'slide'  
						}); 
				$('#permissionData_add_window').window('close');
				}
			});
			$("#_loginEmail").prop("disabled",true);
		}