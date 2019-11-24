var RiskDuty = function(){};
RiskDuty.checkNode = null; //鼠标选择表格那一项
RiskDuty.prototype.ctx = null;

RiskDuty.prototype.toolbar=[
    {
        text: '提示：<font color="red">请使用鼠标右键进行操作</font>',
         iconCls: 'icon-tip'
          }
       ];

/**
 * 初始化时选中 险种或者责任的操作
 */
RiskDuty.prototype.initCheckRiskDuty = function(){
	var thisObj = this;
	$('#riskButyTree').tree({
		onSelect:function(node){
			var id = node.id;
			var idArr = id.split("#");
			var type = idArr[0];
			id = idArr[1];
			var param = "?type="+type+"&riskNo="+id+"&dutyNo="+id+"&operation=check";
			
			if(type=="risk"||type=="duty"){
				$("#riskDutyInfo").attr("src",thisObj.ctx+"/system/product/checkOrEditRiskDuty"+param);
			}
		}
	});
};
/**
 * 删除 险种或者责任
 * @param type 类型 险种还是责任
 * @param node 选中节点
 */
RiskDuty.prototype.delRiskOrDuty = function(node){
	var thisObj = this;
	var id = node.id;
	var idArr = id.split("#");
	var type = idArr[0];
	id = idArr[1];
	
	 $.messager.confirm('提示', '您确定要删除该节点?', function(boo){  
         if (boo){  
        	var params = "type="+type+"&riskNo="+id+"&dutyNo="+id+"&operation=delete";
			$.ajax({
				type:"POST",
				url:thisObj.ctx+"/system/product/deleteRiskOrDuty",
				data:params,
				success:function(data){
					if(data.resultCode==="success"){
						initializeRiskDuty();//刷新树
						$("#riskDutyInfo").attr("src","");
					}else{
						$.messager.alert('系统异常',data.resultInfo);
					} 
				},
				error:function (XMLHttpRequest, textStatus, errorThrown){
					$.messager.alert('系统异常','系统异常,请稍后再试');
				}
			});
         }  
     }); 
	
	
	
	
};
/**
 * 弹出菜单选项
 * @param item
 */
RiskDuty.prototype.selectMenu = function(item){
	var coreproductcode = $("#coreproductcode").val();
	var businessarea = $("#businessarea").val();
	loadRightClicked(item);
	if(item.name=='editRiskDutyMenu'){
		//弹出窗口
    	$('#riskButy_add_window').window({ 
		    width:300,    
		    height:400,    
		    modal:true,
		    collapsible:false,
		    minimizable:false,
		    maximizable:false,
		    resizable:false,
		    iconCls:'icon-add',
		    title:ECSINFO.add,
		    title:'险种责任配置',
		    href:"../../system/product/jumpEditRiskDuty?coreproductcode="+ coreproductcode + "&businessarea=" + businessarea +"&opeartype=ADD&date="+new Date()
		}).show(); 
	}
	else if(item.name=='updateRiskDutyMenu'){
		$('#riskButy_add_window').show();
		//打开窗口
		$('#riskButy_add_window').window({    
		    width:600,    
		    height:400,    
		    modal:true,
		    collapsible:false,
		    minimizable:false,
		    maximizable:false,
		    iconCls:'icon-edit',
		    title:'修改机构',
		    href:'../system/jumpaDDoRUpdateRiskDutyPage',
		    onLoad:function(){
		    	$("#deptCode").attr("readonly","readonly");
		    	$("#deptCode").hide();
				$("#deptid").val(RiskDuty.checkNode.deptid);//机构或部门ID
				$("#opeartype").val("UPDATE");//操作类型为修改
				$("#updateOpearHide").hide();//修改的时候隐藏父资源名称
				$("#deptCode").val(RiskDuty.checkNode.deptCode); //机构编码 
				$("#deptCodeName").html(RiskDuty.checkNode.deptCode); //机构编码 
				$("#deptname").val(RiskDuty.checkNode.deptname); //机构名称 
				$("#contactAddress").val(RiskDuty.checkNode.contactAddress);//地址
				$("#officePhone").val(RiskDuty.checkNode.officePhone);//办公电话
				$("#zipCode").val(RiskDuty.checkNode.zipCode);//邮政编号
				$("#parentId").val(RiskDuty.checkNode.parentId);
				$("#root").val(RiskDuty.checkNode.root);
				$("#RiskDutyType").val(RiskDuty.checkNode.RiskDutyType);//组织机构类型
		    }
		}); 
	}
	//删除资源
	else if(item.name=='delRiskDutyMenu'){
		var nodes = $('#RiskDutyList').treegrid('getChildren',RiskDuty.checkNode.deptid);//展开父节点
		var root=RiskDuty.checkNode.root;
		if(!root){
		if(nodes == 0){ 
			 $.messager.confirm('提示', '您确定要删除该节点?', function(boo){  
	                if (boo){  
	                	RiskDuty.deleteRiskDuty(RiskDuty.checkNode.id);
	                }  
	            });  
		    }
		else{
			    $.messager.alert('提示','该节点存在子节点,请先删除子节点!');
			}
		}else{
			$.messager.alert('提示','该节点为根节点,不能删除!');
		}
	}
};
/**
 * 按组织机构ID删除
 * @param 
 */
RiskDuty.prototype.deleteRiskDuty= function(id){
	var that = this;
	var data = "deptid="+id+"&date="+new Date();
	$.ajax({
		type:"POST",
		url:that.ctx+"/system/delRiskDuty",
		data:data,
		success:function(data){
			if(data =='DEL_SUCCESS'){
				 $('#RiskDutyList').treegrid('remove',RiskDuty.checkNode.id);
			}
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
};

/**
 * 添加或者修改组织机构
 */
RiskDuty.prototype.addRiskDuty =  function(){
	var that = this;
	var deptid= $("#deptid").val();
	var deptname = $("#deptname").val();
	var parentId= $("#parentId").val();	
	var root=$("#root").val();	
	var RiskDutyType =  $("#RiskDutyType").val();
	var deptCode =  $("#deptCode").val();
	var contactAddress =$("#contactAddress").val();
	var officePhone =$("#officePhone").val();
	var zipCode =$("#zipCode").val();
	var opeartype = $("#opeartype").val();//操作类型：删除 、更新
	var data = "deptid="+deptid
	           +"&parentId="+parentId
	           +"&deptCode="+deptCode
	           +"&deptname="+deptname
		       +"&RiskDutyType="+RiskDutyType
		       +"&contactAddress="+contactAddress
			   +"&officePhone="+officePhone
			   +"&zipCode="+zipCode
			   +"&root="+root;
	data = data+"&opeartype="+opeartype+"&date="+new Date();
	dictReload(this.ctx,"DEPARTMENTTYPE");
	$.ajax({
		type:"POST",
		url:that.ctx+"/system/addUpdateRiskDuty",
		data:data,
		success:function(data){
			if(data == 'ADD_SUCCESS'){
				//添加
				$('#RiskDutyList').treegrid('append',{
					parent: RiskDuty.checkNode.id,  
					data: [{
						id:deptCode,
						deptid:deptCode,
						parentId:deptid,
						deptCode:deptCode,
						text:deptname,
						deptname:deptname,
						RiskDutyType:RiskDutyType,
						contactAddress:contactAddress,
						officePhone:officePhone,
						zipCode:zipCode
					}]
				});
				$('#RiskDutyList').treegrid('expand',RiskDuty.checkNode.deptid);//展开父节点
				$('#riskButy_add_window').window('close');
			}
			if(data == 'UPDATE_SUCCESS'){
				//更新
				$('#RiskDutyList').treegrid('update',{
					id: deptid,
					row: {
						id:deptCode,
						text:deptname,
						deptname:deptname,
						deptid:deptCode,
						parentId:parentId,
						RiskDutyType:RiskDutyType,
						deptCode:deptCode,
						contactAddress: contactAddress,
						officePhone:officePhone,
						zipCode:zipCode
					}
				});
				$('#riskButy_add_window').window('close');
			}
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
};
//验证表单
RiskDuty.prototype.formValidate = function(){
	var that = this;
	$('#addUpdateRiskDutyForm').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{ //自定义规则 有两种方式 1、EL表达式 2、自定义方法
			deptCode: [/^[a-zA-Z0-9_]+$/, '仅支持字母与数字下划线'], 
			deptname:[ /^.*$/,'可支持中文'],
			officePhone: function(element, param, field) {
				if(element.value){
				if(/^1[3458]\d{9}$/.test(element.value)){
					return true;
				} else if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(element.value)){
					return true;
				} else {
					return '不是有效的电话号码';
				}
			}else{
				return true;
			}
		    },
		    zipCode: function(element, param, field) {
		    	if(element.value){
		    		if(/^[1-9][0-9]{5}$/.test(element.value)){
						return true;
					} else {
						return '不是有效的邮政编号';
					}
		    	}else{
		    		return true;
		    	}
		    },
			contactAddress:[ /^.*$/,'可支持中文'],
			RiskDutydeptCodePrefix:function(element, param, field){
				var deptid=$("#deptid").val();
				var deptCode=$("#deptCode").val();
				var opertype=$("#opeartype").val();//操作类型：删除 、更新
				var regex="";
			    if(opertype=="UPDATE"){
			    	regex= new RegExp("^"+deptCode);
			    }
			    else{
					regex = new RegExp("^"+deptid+"_[A-Za-z0-9_]+$");
				}
					    if(regex.test(deptCode)){
							return {"ok": ""};
						}
					    else{
							return {"error": "必须以"+deptid+"_开头,结尾必须有字符"};
						}
			},
			/**
			 *@param element 当前验证的DOM元素
			 *@param param 规则传递的参数
			 *@param field 当前字段元数据
			*/
			unique:function(element, param, field){ //自定义方法规则
				var data = "opeartype="+$("#opeartype").val()+"&deptCode="+$("#deptCode").val()+"&date="+new Date();
				return $.ajax({
					type:"POST",
					url:that.ctx+"/system/existDepartment",
					data:data,
					success:function(data){
						return data;
					},
					error:function (XMLHttpRequest, textStatus, errorThrown){
						$.messager.alert('系统异常','验证请等待');
						return false;
					}
				});
			}
		},
		fields:{//那些字段要加入到规则中
			"deptCode":{
				rule:"required;组织机构编码:RiskDutydeptCodePrefix;deptCode;unique",
				tip: "支持字母与数字下划线"
			},
			"deptname":{
				rule:"required;deptname",
				tip: "可支持中文"
			},
			"contactAddress":{
				rule:"required;contactAddress",
				tip: "可支持中文"
			},
			"officePhone":{
				rule:"电话号码:officePhone;",
				tip:"手机或固定电话（区号-电话号）"
			},
			"zipCode":{
				rule:"邮政编号:zipCode;",
				tip:"邮政编号"
			}
		},
		valid: function(form){ //验证成功
			RiskDuty.addRiskDuty();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
	});
};

