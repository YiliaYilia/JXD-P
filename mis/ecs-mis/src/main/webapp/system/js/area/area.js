
var Area = function(){};
Area.checkRow = null; //鼠标选择表格那一项
Area.prototype.ctx = null;
Area.prototype.toolbar =[
                        	 {
                                text: '提示：<font color="red">请使用鼠标右键进行操作</font>',
                                iconCls: 'icon-tip'
                            }
                        ];

/**
 * 创建区域表格树
 * @param jsonData json类型数据
 */
Area.prototype.createAreaTreeGrid = function(jsonData){
	var that = this;
	$('#areaData').treegrid({
//	    data: convert(data),
		url : '../system/getGeAreaRoot',
	    idField:'id',    
	    treeField:'text',  
	    toolbar:that.toolbar,
	    fit:true,
	    fitColumns:true,
	    sortName:'createTime',
	    sortOrder:'desc',
	  
	    onContextMenu:function(event,row){ //弹出菜单按钮
	    	
	    	Area.checkRow = row;
	    	event.preventDefault();
	    	$('#areaMenu').menu('show',{
	    		left: event.pageX,
	    		top: event.pageY
	    	});
	    },
	    onBeforeExpand:function(row){
	    	var url = '../system/getGeAreaChild?prentId='+row.id;
	    	 $("#areaData").treegrid("options").url = url;  
	        return true;      
	    },
	    columns:[[    
	       {field : 'text',title : '区域名称',width : ($("#areaData").width() * 0.25),align:'left'},
	       {field : 'id',title : '区域编号',width : ($("#areaData").width() * 0.25),align:'center'},
	       {field : 'note',title : '备注信息',width : ($("#areaData").width() * 0.25),align:'center'},
	       {field : 'createTime',title : '创建时间',width : ($("#areaData").width() * 0.25),align:'center'}
	       ]]    
	}); 
}


/**
 * 弹出菜单选项
 * @param item
 */
Area.prototype.selectMenu = function(item){
	if(item.name=='addAreaMenu'){
		//重复打开，清空内容
		$('#area_add_window').show();
		//打开窗口
		$('#area_add_window').window({    
		    width:450,    
		    height:290,    
		    modal:true,
		    collapsible:false,
		    minimizable:false,
		    maximizable:false,
		    resizable : false,
		    iconCls:'icon-add',
		    title : ECSINFO.add,
		    href:'../system/jumpAddOrUpdateAreaPage',
		    onLoad:function(){   
				$("#areaGid").removeAttr("readonly");
				$("#opeartype").val("ADD");//操作类型为添加
				$("#areaParentName").html(Area.checkRow.text); //父区域名称
				$("#areaPrent").val(Area.checkRow.gid); //父区域编号
				$("#updateOpearHide").show();//显示父区域名称
				$("#updatePgid").hide();
				$("#updatePgid1").show();
		    	}
			}); 
	}
	else if(item.name=='updateAreaMenu'){
		//重复打开，清空内容
		$('#area_add_window').show();
		//打开窗口
		$('#area_add_window').window({    
		    width:400,    
		    height:260,    
		    modal:true,
		    collapsible:false,
		    minimizable:false,
		    maximizable:false,
		    resizable : false,
		    iconCls:'icon-edit',
		    title : ECSINFO.update,
		    href:'../system/jumpAddOrUpdateAreaPage',
		    onLoad:function(){   
				$("#areaGid").attr("readonly","readonly");
				$("#opeartype").val("UPDATE");//操作类型为修改
				$("#updateOpearHide").hide();//修改的时候隐藏父区域名称
				$("#areaPrent").val(Area.checkRow.pgid); //父区域编号
				$("#areaGid").val(Area.checkRow.id);//区域编码
				$("#areaGname").val(Area.checkRow.text);//区域名称
				$("#areaNote").val(Area.checkRow.note);//备注信息;
				$("#updatePgid1").hide();
				$("#updatePgid").show();
				$("#areaParentId").html(Area.checkRow.id);
		    	}
			});
	}
	//删除资源
	else if(item.name=='delAreaMenu'){
		//获取子节点  getChildren
//		var nodes = $('#areaData').treegrid('getChildren',Area.checkRow.id);//展开父节点
		var gid = Area.checkRow.id;
		var data = "geArea.gid="+gid+"&date"+new Date();
		$.ajax({
			type:"POST",
			url:"../system/existChildren",
			data:data,
			success:function(data){
				if(data == 'EXIST'){
					$.messager.alert('提示','该区域存在子区域，请先删除子区域');
				}else{
					$.messager.confirm('友情提示', '您确定要删除该节点?', function(boo){   
		                if (boo){  
		                	area.deleteArea(Area.checkRow.id);
		                }  
		            });  
				}
			},
			error:function (XMLHttpRequest, textStatus, errorThrown){
				$.messager.alert('系统异常','系统异常,请稍后再试');
			}
		});
//		if(nodes == 0){ //没有子节点就允许删除
//			 $.messager.confirm('友情提示', '您确定要删除该节点?', function(boo){   
//	                if (boo){  
//	                	area.deleteArea(Area.checkRow.id);
//	                }  
//	            });  
//		
//		}
//		else{
//			$.messager.alert('提示','该区域存在子区域，请先删除子区域');
//		}
	}
}

/**
 * 按区域编号删除区域
 * @param id 区域编号
 */
Area.prototype.deleteArea = function(id){
	var that = this;
	var data = "geArea.gid="+id+"&date="+new Date();
	
	$.ajax({
		type:"POST",
		url:that.ctx+"/system/deleteArea",
		data:data,
		
		success:function(data){
			if(data =='DEL_SUCCESS'){
				 $('#areaData').treegrid('remove',Area.checkRow.id);
			}
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
}

/**
 * 添加或者修改区域
 */

Area.prototype.addUpdateArea =  function(){
	var dateUtil = new DateUtil();
	var that = this;
	var gid = $("#areaGid").val();//区域编号
	var gname =  $("#areaGname").val();//区域名称
	var note =  $("#areaNote").val();//区域信息
	var pgid = Area.checkRow.id; //添加父区域编号
	var prentId = Area.checkRow.pgid;//添加父区域编号
	var opeartype = $("#opeartype").val();//操作类型：删除 、更新
	var createTime = Area.checkRow.createTime;
	var data = "geArea.gid="+gid+"&geArea.gname="+gname
		+"&geArea.note="+note+"&geArea.pgid="+pgid+"&prentId="+prentId
		+"&date="+new Date()+"&createTime="+dateUtil.format(null,'yyyy-MM-dd HH:mm:ss');
	
	data = data+"&opeartype="+opeartype;
	$.ajax({
		type:"POST",
		url:that.ctx+"/system/addUpdateArea",
		data:data,
		success:function(data){
			if(data == 'ADD_SUCCESS'){
				//添加
				$('#areaData').treegrid('append',{
					parent: Area.checkRow.id,  
					data: [{
						id:gid,
						text: gname,
						note:note,
						pgid:pgid,//父区域编号
						createTime:dateUtil.format(null,'yyyy-MM-dd HH:mm:ss')
					}]
				});
				$('#areaData').treegrid("reload",Area.checkRow.id);
				$('#areaData').treegrid('expand',Area.checkRow.id);//展开父节点
				$('#area_add_window').window('close');
			}
			if(data == 'UPDATE_SUCCESS'){
				//更新
				$('#areaData').treegrid('update',{
					id: gid,
					row: {
						id:gid,
						text: gname,
						note: note,
						gid:prentId,//父区域编号
						createTime:dateUtil.format(null, 'yyyy-MM-dd HH:mm:ss')
					}
				});
				$('#areaData').treegrid("reload",Area.checkRow.gid);
				$('#areaData').treegrid('expand',Area.checkRow.gid);//展开父节点
				$('#area_add_window').window('close');
			}
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
}

Area.prototype.formValidate = function(){
	var that = this;
	$('#addUpdateAreaForm').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{ //自定义规则 有两种方式 1、EL表达式 2、自定义方法
			resourcescode: [/^[a-zA-Z0-9_]+$/, '仅支持字母与数字下划线'], //自定义EL表达式
			resourcescontent:[/^[a-zA-Z0-9_\/]+$/, '仅支持字母与数字下划线反斜杠'],
			/**
			 *@param element 当前验证的DOM元素
			 *@param param 规则传递的参数
			 *@param field 当前字段元数据
			*/
			unique:function(element, param, field){ //自定义方法规则
				var data = "opeartype="+$("#opeartype").val()+"&geArea.gid="+$("#areaGid").val()+"&date="+new Date();
				return $.ajax({
					type:"POST",
					url:that.ctx+"/system/existArea",
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
			"geArea.gid":{
				rule:"required;digits;unique;range[~10000000000000000000]",
				tip:"纯数字编号"
			},
			"gname":{
				rule:"required",
				tip:"支持中文"
			}
		},
		valid: function(form){ //验证成功
			area.addUpdateArea();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
		
	});
}