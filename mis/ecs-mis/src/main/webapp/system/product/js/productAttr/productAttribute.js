var ProductAttr = function(){};
ProductAttr.checkRow = null; //鼠标选择表格那一项
ProductAttr.prototype.ctx = null;
/**
 * 在工具栏显示提示
 */
ProductAttr.prototype.toolbar =[
	 {
        text: '提示：<font color="red">请使用鼠标右键进行操作</font>',
        iconCls: 'icon-tip'
    }
];
/**
 * 创建产品属性表格树
 * @param jsonData json类型数据
 */
ProductAttr.prototype.createProductAttrTreeGrid = function(jsonData){
	//alert(convert(jsonData));
	var that = this;
	$('#productAttrList').treegrid({  
	    data: convert(jsonData),
	    idField:'id',    
	    treeField:'text',
	    title:"",
	    toolbar:that.toolbar,
	    fit:true,
	    fitColumns:true,

	    onContextMenu:function(event,row){ //弹出菜单按钮
	    	ProductAttr.checkRow = row;
	    	event.preventDefault();
	    	$('#productAttr_menu').menu('show',{
	    		left: event.pageX,
	    		top: event.pageY
	    	});
	    },
	    columns:[[    
	        {field : 'id',title : 'ID',hidden:true},
	        {field:'text',title:'产品属性名称',width:($('#productAttrList').width()*0.2),align:'left'},    
	//        {field:'productattrname',title:'属性名称',width:($('#productAttrList').width()*0.2),align:'center'},
	        {field:'productattrid',title:'属性编号',width:($('#productAttrList').width()*0.2),align:'center'},
	        {field:'productseqindex',title:'显示顺序',width:($('#productAttrList').width()*0.2),align:'center'},
	        {field:'productattrdesc',title:'属性描述',width:($('#productAttrList').width()*0.2),align:'center'},
	        {field:'productattrnoteinfo',title:'属性详细信息',width:($('#productAttrList').width()*0.2),align:'center'},
	  //      {field:'parentId',title:'父属性编号',width:($('#productAttrList').width()*0.2),align:'center'}
	    ]]    
	}); 
}
/**
 * 弹出菜单选项
 * @param item
 */
ProductAttr.prototype.selectMenu=function(item){
	if(item.name=='addProductAttrMenu'){
		
		//打开窗口
		$('#productAttr_addUpdate_window').window({    
		    width:450,    
		    height:400,    
		    modal:true,
		    collapsible:false,
		    minimizable:false,
		    maximizable:false,
		    resizable:false,
		    iconCls:'icon-add',
		    title:ECSINFO.add,
		    href:'../product/jumpAddORUpdateProductAttrPage',
		    onLoad:function(){  
		    	$("#productAttrId").removeAttr("readonly");
		    	$("#opeartype").val("ADD");//操作类型为添加
		    	$("#productattrparentName").html(ProductAttr.checkRow.text);//父属性
		  //  	$("#productattrparent").val(ProductAttr.checkRow.parentId); //父区域编号
		    	$("#updateOpearHide").show();
		    	$("#updatePid").hide();
				$("#updatePid1").show();
		    }
		}); 
	}
	else if(item.name=='updateProductAttrMenu'){
		//打开窗口
		$('#productAttr_addUpdate_window').window({    
		    width:450,    
		    height:400,    
		    modal:true,
		    collapsible:false,
		    minimizable:false,
		    maximizable:false,
		    iconCls:'icon-edit',
		    title: ECSINFO.update,
		    href:'../product/jumpAddORUpdateProductAttrPage',
		    onLoad:function(){    
		    	$("#productAttrId").attr("readonly","readonly");
		    	$("#opeartype").val("UPDATE");//操作类型为修改
		    	$("#updateOpearHide").hide();
		    	$("#productattrparent").val(ProductAttr.checkRow.parentId); 
		    	$("#productAttrId").val(ProductAttr.checkRow.id);
		    	$("#productattrName").val(ProductAttr.checkRow.text);
		    	$("#seqindex").val(ProductAttr.checkRow.productseqindex);
		    	$("#productattrdesc").val(ProductAttr.checkRow.productattrdesc);
		    	$("#productattrinfo").val(ProductAttr.checkRow.productattrnoteinfo);
				$("#updatePid1").hide();
				$("#updatePid").show();
				$("#productAttrParentId").html(ProductAttr.checkRow.id);
		    }    
		}); 
	}
	else if(item.name='delProductAttrMenu'){
		//获取子节点  getChildren
		var attrid = ProductAttr.checkRow.id;
		var data = "&geProductAttr.attrid="+attrid+"&date"+new Date();
		//alert(data);
		$.ajax({
			type:"POST",
			url:"../product/existChildren",
			data:data,
			success:function(data){
				if(data == 'EXIST'){
					$.messager.alert('提示','该产品属性存在子属性，请先删除子属性');
				}else{
					$.messager.confirm('友情提示', '您确定要删除该节点?', function(boo){   
		                if (boo){  
		                	productAttr.deleteProductAttr(ProductAttr.checkRow.id);
		                }  
		            });  
				}
			},
			error:function (XMLHttpRequest, textStatus, errorThrown){
				$.messager.alert('系统异常','系统异常,请稍后再试');
			}
		});
	}
	
}

ProductAttr.prototype.deleteProductAttr = function(id){
	var that = this;
	var data = "&geProductAttr.attrid="+id+"&date="+new Date();
	
	$.ajax({
		type:"POST",
		url:"../product/deleteProductAttr",
		data:data,
		
		success:function(data){
			if(data =='DEL_SUCCESS'){
				 $('#productAttrList').treegrid('remove',ProductAttr.checkRow.id);
			}
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
}
ProductAttr.prototype.addUpdateProductAttr = function(){
	
	//var dateUtil = new DateUtil();
	var that = this;
	var attrid = $("#productAttrId").val();//产品属性编号
	var attrname =  $("#productattrName").val();//产品属性名称
	var seq =  $("#seqindex").val();//产品属性信息
	var attrdesc = $("#productattrdesc").val();
	var attrinfo = $("#productattrinfo").val();  
	var parentId = ProductAttr.checkRow.id; //添加父产品属性编号
	var prentId = ProductAttr.checkRow.parentId;//添加父产品属性编号--修改时用
	var opeartype = $("#opeartype").val();//操作类型：删除 、更新
	var data = "&geProductAttr.attrid="+attrid+"&geProductAttr.attrname="+attrname
		+"&geProductAttr.seqindex="+seq+"&geProductAttr.attrparent="+parentId+"&prentId="+prentId
		+"&geProductAttr.attrdescription="+attrdesc+"&geProductAttr.attrnoteinfo="+attrinfo +"&date="+new Date();
	
	data = data+"&opeartype="+opeartype;
	//alert(data);
	$.ajax({
		type:"POST",
		url:"../product/addUpdateProductAttr",
		data:data,
		success:function(data){
			if(data == 'ADD_SUCCESS'){
				//添加
				$('#productAttrList').treegrid('append',{
					parent: ProductAttr.checkRow.id,  
					data: [{
						id:attrid,
						text: attrname,
						productattrname:attrname,
						productseqindex:seq,
						productattrdesc:attrdesc,
						productattrnoteinfo:attrinfo,
						productattrid:attrid,
						parentId:parentId
					}]
				});
				$('#productAttrList').treegrid('expand',ProductAttr.checkRow.id);//展开父节点
				$('#productAttr_addUpdate_window').window('close');
			}
			if(data == 'UPDATE_SUCCESS'){
				//更新
				$('#productAttrList').treegrid('update',{
					id: attrid,
					row: {
						id: attrid,
						text: attrname,
						productattrname:attrname,
						productseqindex:seq,
						productattrdesc:attrdesc,
						productattrnoteinfo:attrinfo,
					//	productattrparent:parentId,
						productattrparent:prentId,
						productattrid:attrid
					}
				});
				$('#productAttrList').treegrid('expand',ProductAttr.checkRow.id);//展开父节点
				$('#productAttr_addUpdate_window').window('close');
			}
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
}
ProductAttr.prototype.formValidate = function(){
	var that = this;
	$('#addUpdateProductAttrForm').validator({
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
				var data = "opeartype="+$("#opeartype").val()+"&productAttrId="+$("#productAttrId").val()+"&date="+new Date();
				return $.ajax({
					type:"POST",
					url:"../product/existProductAttr",
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
			
			"productAttrId":{
				rule:"required;resourcescode;unique",
				tip: "支持字母与数字下划线"
				
			    //ok: "成功后显示"
			    //msg: {required: "全名必填!"}  覆盖默认的提示文字
			},
			"productattrName":{
				rule:"required"
			//	tip: "仅支持字母与数字下划线反斜杠"
			},
			"seqindex":{
				rule:"required;digits;range[~10000000000000000000]",
				tip:"只能输入数字"
			}
			
		},
		valid: function(form){ //验证成功
			productAttr.addUpdateProductAttr();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
		
	});
}


