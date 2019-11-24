var Organ = function(){};
Organ.checkRow = null; //鼠标选择表格那一项
Organ.prototype.ctx = null;

Organ.prototype.toolbar=[
    {
        text: '提示：<font color="red">请使用鼠标右键进行操作</font>',
         iconCls: 'icon-tip'
          }
       ];
/**
 * 创建组织机构表格树
 * @param jsonData json类型数据
 */
Organ.prototype.createOrganTreeGrid = function(jsonData){
	var that = this;
	$('#organList').treegrid({  
	    data: convert(data),
	    idField:'id',    
	    treeField:'text', 
	    title:"",
	    toolbar:that.toolbar,
	    fit:true,
	    fitColumns:true,
	    onContextMenu:function(event,row){ //弹出菜单按钮
	    	Organ.checkRow = row;
	    	event.preventDefault();
	    	$('#organMune').menu('show',{
	    		left: event.pageX,
	    		top: event.pageY
	    	});
	    },
	    columns:[[    
	        {field:'text',title:'机构名称',width:($('#organList').width()*0.2),align:'left'},    
	        {field:'organType',title:'类型',width:($('#organList').width()*0.1),align:'left',
	        	formatter:function(index,row){
	        		return dictTrans(row.organType,"DEPARTMENTTYPE");
	        	}
	        },    
	        {field:'deptCode',title:'机构编码',width:($('#organList').width()*0.1),align:'left'},
	        {field:'contactAddress',title:'地址',width:($('#organList').width()*0.2),align:'left'},
	        {field:'officePhone',title:'办公电话',width:($('#organList').width()*0.2),align:'left'},
	        {field:'zipCode',title:'邮政编号',width:($('#organList').width()*0.2),align:'left'}
	    ]]    
	}); 
};
/**
 * 弹出菜单选项
 * @param item
 */
Organ.prototype.selectMenu = function(item){
	if(item.name=='addOrganMenu'){
		$('#organ_add_window').show();
		//打开窗口
		$('#organ_add_window').window({    
		    width:450,    
		    height:400,  
		    modal:true,
		    collapsible:false,
		    minimizable:false,
		    maximizable:false,
		    resizable:false,
		    iconCls:'icon-add',
		    title:'添加机构',
		    href:'../system/jumpaDDoRUpdateOrganPage',
		    onLoad:function(){
		    	$("#updateOpearHide").show();
		    	$("#deptCode").show();
		    	$("#deptCodeName").hide();
				$("#deptCode").removeAttr("readonly");
				$("#opeartype").val("ADD");//操作类型为添加
				$("#organparentName").html(Organ.checkRow.deptname); //父资源名称
				$("#deptid").val(Organ.checkRow.deptid);//父资源ID
				$("#parentId").val(Organ.checkRow.parentId);
				$("#root").val(Organ.checkRow.root);
				$("#deptCode").val(Organ.checkRow.deptCode+"_"); //机构编码 
		    }
		}); 
	}
	else if(item.name=='updateOrganMenu'){
		$('#organ_add_window').show();
		//打开窗口
		$('#organ_add_window').window({    
		    width:450,    
		    height:400,    
		    modal:true,
		    collapsible:false,
		    minimizable:false,
		    maximizable:false,
		    iconCls:'icon-edit',
		    title:'修改机构',
		    href:'../system/jumpaDDoRUpdateOrganPage',
		    onLoad:function(){
		    	$("#deptCode").attr("readonly","readonly");
		    	$("#deptCode").hide();
				$("#deptid").val(Organ.checkRow.deptid);//机构或部门ID
				$("#opeartype").val("UPDATE");//操作类型为修改
				$("#updateOpearHide").hide();//修改的时候隐藏父资源名称
				$("#deptCode").val(Organ.checkRow.deptCode); //机构编码 
				$("#deptCodeName").html(Organ.checkRow.deptCode); //机构编码 
				$("#deptname").val(Organ.checkRow.deptname); //机构名称 
				$("#contactAddress").val(Organ.checkRow.contactAddress);//地址
				$("#officePhone").val(Organ.checkRow.officePhone);//办公电话
				$("#zipCode").val(Organ.checkRow.zipCode);//邮政编号
				$("#parentId").val(Organ.checkRow.parentId);
				$("#root").val(Organ.checkRow.root);
				$("#organType").val(Organ.checkRow.organType);//组织机构类型
		    }
		}); 
	}
	//删除资源
	else if(item.name=='delOrganMenu'){
		var nodes = $('#organList').treegrid('getChildren',Organ.checkRow.deptid);//展开父节点
		var root=Organ.checkRow.root;
		if(!root){
		if(nodes == 0){ 
			 $.messager.confirm('提示', '您确定要删除该节点?', function(boo){  
	                if (boo){  
	                	organ.deleteOrgan(Organ.checkRow.id);
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
Organ.prototype.deleteOrgan= function(id){
	var that = this;
	var data = "deptid="+id+"&date="+new Date();
	$.ajax({
		type:"POST",
		url:that.ctx+"/system/delOrgan",
		data:data,
		success:function(data){
			if(data =='DEL_SUCCESS'){
				 $('#organList').treegrid('remove',Organ.checkRow.id);
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
Organ.prototype.addOrgan =  function(){
	var that = this;
	var deptid= $("#deptid").val();
	var deptname = $("#deptname").val();
	var parentId= $("#parentId").val();	
	var root=$("#root").val();	
	var organType =  $("#organType").val();
	var deptCode =  $("#deptCode").val();
	var contactAddress =$("#contactAddress").val();
	var officePhone =$("#officePhone").val();
	var zipCode =$("#zipCode").val();
	var opeartype = $("#opeartype").val();//操作类型：删除 、更新
	var data = "deptid="+deptid
	           +"&parentId="+parentId
	           +"&deptCode="+deptCode
	           +"&deptname="+deptname
		       +"&organType="+organType
		       +"&contactAddress="+contactAddress
			   +"&officePhone="+officePhone
			   +"&zipCode="+zipCode
			   +"&root="+root;
	data = data+"&opeartype="+opeartype+"&date="+new Date();
	dictReload(this.ctx,"DEPARTMENTTYPE");
	$.ajax({
		type:"POST",
		url:that.ctx+"/system/addUpdateOrgan",
		data:data,
		success:function(data){
			if(data == 'ADD_SUCCESS'){
				//添加
				$('#organList').treegrid('append',{
					parent: Organ.checkRow.id,  
					data: [{
						id:deptCode,
						deptid:deptCode,
						parentId:deptid,
						deptCode:deptCode,
						text:deptname,
						deptname:deptname,
						organType:organType,
						contactAddress:contactAddress,
						officePhone:officePhone,
						zipCode:zipCode
					}]
				});
				$('#organList').treegrid('expand',Organ.checkRow.deptid);//展开父节点
				$('#organ_add_window').window('close');
			}
			if(data == 'UPDATE_SUCCESS'){
				//更新
				$('#organList').treegrid('update',{
					id: deptid,
					row: {
						id:deptCode,
						text:deptname,
						deptname:deptname,
						deptid:deptCode,
						parentId:parentId,
						organType:organType,
						deptCode:deptCode,
						contactAddress: contactAddress,
						officePhone:officePhone,
						zipCode:zipCode
					}
				});
				$('#organ_add_window').window('close');
			}
			if(data=='ISEXIST'){
				$.messager.alert('提示','机构代码重复，请核实后填写');
			}
				
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
};
//验证表单
Organ.prototype.formValidate = function(){
	var that = this;
	$('#addUpdateOrganForm').validator({
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
			organdeptCodePrefix:function(element, param, field){
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
					// if(regex.test(deptCode)){
					//		return {"ok": ""};
					//	}
					//   else{
					//		return {"error": "必须以"+deptid+"_开头,结尾必须有字符"};
					//	}
			    return {"ok": ""};
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
				rule:"required",
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
			organ.addOrgan();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
	});
};

