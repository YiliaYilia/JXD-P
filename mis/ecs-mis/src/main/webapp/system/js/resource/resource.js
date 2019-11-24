var Resource = function(){};
Resource.checkRow = null; //鼠标选择表格那一项
Resource.prototype.ctx = null;
/**
 * 在工具栏显示提示
 */
Resource.prototype.toolbar =[
	 {
        text: '提示：<font color="red">请使用鼠标右键进行操作</font>',
        iconCls: 'icon-tip'
    }
];

/**
 * 创建资源表格树
 * @param jsonData json类型数据
 */
Resource.prototype.createResourceTreeGrid = function(jsonData){
	var that = this;
	$('#resourceList').treegrid({    
	    data: convert(data),
	    idField:'id',    
	    treeField:'text',
	    title:"",
	    toolbar:that.toolbar,
	    fit:true,
	    fitColumns:true,
	    onContextMenu:function(event,row){ //弹出菜单按钮
	    	Resource.checkRow = row;
	    	event.preventDefault();
	    	$('#resource_menu').menu('show',{
	    		left: event.pageX,
	    		top: event.pageY
	    	});
	    	
	    },
	    columns:[[    
	        {field:'text',title:'资源名称',width:($('#resourceList').width()*0.2),align:'left'},    
	        {field:'resourcesiconpath',title:'图标',width:($('#resourceList').width()*0.1),align:'center',
	        	formatter:function(index,row){
	        		if(row.resourcesiconpath!=''){
	        			return "<img src='"+row.resourcesiconpath+"' width='20',height='20'>";
	        		}
	        		
	        	}
	        },    
	        {field:'resourcestype',title:'资源类型',width:($('#resourceList').width()*0.1),align:'center',
	        	formatter:function(index,row){
					return dictTrans(row.resourcestype,'MENUTYPE');
	        	}
	        },    
	        {field:'resourcescode',title:'资源编码',width:($('#resourceList').width()*0.2),align:'left'},
	        {field:'resourcescontent',title:'资源内容',width:($('#resourceList').width()*0.2),align:'left'} ,
	        {field:'resourcesdesc',title:'资源描述',width:($('#resourceList').width()*0.2),align:'left'}
	    ]]    
	}); 
}




/**
 * 弹出菜单选项
 * @param item
 */
Resource.prototype.selectMenu = function(item){
	if(item.name=='addResourceMenu'){
		
		//打开窗口
		$('#resource_addUpdate_window').window({    
		    width:600,    
		    height:400,    
		    modal:true,
		    collapsible:false,
		    minimizable:false,
		    maximizable:false,
		    resizable:false,
		    iconCls:'icon-add',
		    title:'添加资源',
		    href:'../system/jumpaDDoRUpdateResourcePage',
		    onLoad:function(){   
		    	$("#resourcescode").removeAttr("readonly");
				$("#resourcescodeSpan").hide();
				$("#resourcescode").show();
				$("#opeartype").val("ADD");//操作类型为添加
				$("#resourcesparentName").html(Resource.checkRow.text); //父资源名称
				$("#resourcesparent").val(Resource.checkRow.resourcescode);//父资源编码
				$("#resourcescode").val(Resource.checkRow.resourcescode+"_");
		    }
		}); 
		
		
	}
	else if(item.name=='updateResourceMenu'){
		
		//打开窗口
		$('#resource_addUpdate_window').window({    
		    width:600,    
		    height:400,    
		    modal:true,
		    collapsible:false,
		    minimizable:false,
		    maximizable:false,
		    iconCls:'icon-edit',
		    title:'修改资源',
		    href:'../system/jumpaDDoRUpdateResourcePage',
		    onLoad:function(){    
				$("#resourcescode").attr("readonly","readonly");
				$("#resourcescode").hide();
				$("#resourcescodeSpan").show();
				$("#resourcescodeSpan").text(Resource.checkRow.resourcescode);
				$("#opeartype").val("UPDATE");//操作类型为修改
				$("#updateOpearHide").hide();//修改的时候隐藏父资源名称
				$("#resourcesparent").val(Resource.checkRow.resourcesparent);//父资源编号
				$("#resourcesid").val(Resource.checkRow.resourcesid);//资源编号
				$("#resourcescode").val(Resource.checkRow.resourcescode);//资源编码
				$("#resourcesname").val(Resource.checkRow.resourcesname);//资源名称
				$("#resourcestype").val(Resource.checkRow.resourcestype);//资源类型
				$("#resourcescontent").val(Resource.checkRow.resourcescontent)//资源内容;
				$("#resourcesdesc").val(Resource.checkRow.resourcesdesc)//资源描述;
				$("#resourcesicon").html('<img src="'+Resource.checkRow.resourcesiconpath+'"  width="22" height="22" >');
				$("#resourcesiconid").val(Resource.checkRow.resourcesiconid);
		    }    

		}); 
		
	}
	//删除资源
	else if(item.name=='delResourceMenu'){
		//获取子节点  getChildren
		var nodes = $('#resourceList').treegrid('getChildren',Resource.checkRow.resourcescode);//展开父节点
		if(nodes == 0){ //没有子节点就允许删除
			 $.messager.confirm('友情提示', '您确定要删除该节点?', function(boo){  
	                if (boo){  
	                	resource.deleteResource(Resource.checkRow.resourcescode);
	                }  
	            });  
		
		}
		else{
			$.messager.alert('提示','该节点存在子节点，请先删除子节点');
		}
	}
	
}



/**
 * 按资源编号删除资源
 * @param id 资源编号
 */
Resource.prototype.deleteResource = function(id){
	var that = this;
	var data = "geResources.resourcesid="+id+"&date="+new Date();
	
	$.ajax({
		type:"POST",
		url:that.ctx+"/system/deleteResource",
		data:data,
		success:function(data){
			if(data =='DEL_SUCCESS'){
				 $('#resourceList').treegrid('remove',Resource.checkRow.resourcescode);
			}
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
}




/**
 * 添加或者修改资源
 */
Resource.prototype.addUpdateResource =  function(){
	
	
	
	var that = this;
	var resourcesname = $("#resourcesname").val();
	var resourcestype =  $("#resourcestype").val();
	var resourcesparent =  $("#resourcesparent").val();
	var resourcescontent =  $("#resourcescontent").val();
	var resourcesdesc =  $("#resourcesdesc").val();
	var resourcescode =  $("#resourcescode").val();
	var resourcesiconid =  $("#resourcesiconid").val();
	var opeartype = $("#opeartype").val();//操作类型：删除 、更新
	var data = "geResources.resourcesname="+resourcesname+"&geResources.resourcestype="+resourcestype
		+"&geResources.resourcesparent="+resourcesparent+"&geResources.resourcescontent="+resourcescontent
		+"&geResources.resourcesdesc="+resourcesdesc+"&geResources.resourcescode="+resourcescode
		+"&date="+new Date();
	if(resourcesiconid !=''){
		data = data+"&geResourcesIcon.resourcesiconid="+resourcesiconid;
	}
	var icon = $('#ICON'+resourcesiconid).attr("src");
	if(typeof(icon)=='undefined'){
		icon ="";
	}
	data = data+"&opeartype="+opeartype;
	dictReload(this.ctx,"MENUTYPE");
	$.ajax({
		type:"POST",
		url:that.ctx+"/system/addUpdateResource",
		data:data,
		success:function(data){
			if(data == 'ADD_SUCCESS'){
				//添加
				$('#resourceList').treegrid('append',{
					parent: Resource.checkRow.resourcescode,  
					data: [{
						
						id:resourcescode,
						text: resourcesname,
						resourcesname:resourcesname,
						resourcesiconpath: icon,
						resourcesparent:resourcesparent,
						resourcestype:resourcestype,
						resourcescode:resourcescode,
						resourcescontent:resourcescontent,
						resourcesdesc:resourcesdesc,
						resourcesiconid:resourcesiconid
						
					}]
				});
				$('#resourceList').treegrid('expand',Resource.checkRow.resourcescode);//展开父节点
				$('#resource_addUpdate_window').window('close');
			}
			if(data == 'UPDATE_SUCCESS'){
				
				//更新
				$('#resourceList').treegrid('update',{
					id: resourcescode,
					row: {
						id:resourcescode,
						text: resourcesname,
						resourcesname:resourcesname,
						resourcesiconpath: icon,
						resourcestype:resourcestype,
						resourcescode:resourcescode,
						resourcescontent:resourcescontent,
						resourcesdesc:resourcesdesc,
						resourcesiconid:resourcesiconid
					}
				});
				$('#resource_addUpdate_window').window('close');
			}
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
	
}



/**
 * 选择资源图标
 * @param e 当前节点
 * @param id 图标编号
 */
Resource.prototype.selectResourceIcon = function selectResourceIcon(e,id){
	$(".resourceIconItem").css("border","1px solid #96CB55");
	$(e).css("border","1px solid red");
	$("#resourcesiconid").val(id);
	$("#resourcesicon").html($(e).html());
}


Resource.prototype.formValidate = function(){
	var that = this;
	$('#addUpdateResouceForm').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{ //自定义规则 有两种方式 1、EL表达式 2、自定义方法
			resourcescode: [/^[a-zA-Z0-9_]+$/, '仅支持字母与数字下划线'], //自定义EL表达式
			resourcescodePrefix:function(element, param, field){
				var resourcesparent =  $("#resourcesparent").val();
				var resourcescode = $("#resourcescode").val();
				var opeartype = $("#opeartype").val();//操作类型：删除 、更新
				var regex="";
				if(opeartype=="UPDATE"){
					regex = new RegExp("^"+resourcesparent);
				}
				else{
					regex = new RegExp("^"+resourcesparent+"_[A-Za-z0-9_]+$");
				}
					if(regex.test(resourcescode)){
						return {"ok": ""};
					}
					else{
						return {"error": "必须以"+resourcesparent+"_开头,结尾必须有字符"};
					}
			},
			resourcescontent:[/^[a-zA-Z0-9_\/]+$/, '仅支持字母与数字下划线反斜杠'],
			/**
			 *@param element 当前验证的DOM元素
			 *@param param 规则传递的参数
			 *@param field 当前字段元数据
			*/
			unique:function(element, param, field){ //自定义方法规则
				var data = "opeartype="+$("#opeartype").val()+"&geResources.resourcescode="+$("#resourcescode").val()+"&date="+new Date();
				return $.ajax({
					type:"POST",
					url:that.ctx+"/system/existResource",
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
			"geResources.resourcescode":{
				rule:"required;resourcescodePrefix;resourcescode;unique",
				tip: "支持字母与数字下划线"
				
			    //ok: "成功后显示"
			    //msg: {required: "全名必填!"}  覆盖默认的提示文字
			},
			"resourcescontent":{
				rule:"required;resourcescontent",
				tip: "仅支持字母与数字下划线反斜杠"
				
			},
			"resourcestype":{
				rule:"required"
			},
			"resourcesname":{
				rule:"required"
			}
		},
		valid: function(form){ //验证成功
			resource.addUpdateResource();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
		
	});
}
