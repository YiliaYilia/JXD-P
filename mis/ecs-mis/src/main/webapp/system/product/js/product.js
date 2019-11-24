var Product = function(){};
Product.prototype.ctx = null;

Product.add = {
	    text: ECSINFO.add,
	    iconCls: 'icon-add',
	    handler:function(){
	    	//弹出添加产品窗口
	    	$('#product_operator_window').window({ 
			    width:450,    
			    height:300,    
			    modal:true,
			    collapsible:false,
			    minimizable:false,
			    maximizable:false,
			    resizable:false,
			    iconCls:'icon-add',
			    title:ECSINFO.add,
			    href:"../../system/product/productAddUpdateOperator?operate=ADD"
			}).show(); 
	    }
};

Product.update={

	    text: ECSINFO.update,
	    iconCls: 'icon-edit',
	    handler:function(){
	    	var rows =$('#productListDatagrid').datagrid('getChecked');
	    	if(rows== null || rows.length != 1){
	    		ECSINFO.alert_update_unique();
	    		return false;
	    	}else{
	    		var row = rows[0];
	    		//弹出修改产品窗口
	        	$('#product_operator_window').window({ 
	    		    width:450,    
	    		    height:300,    
	    		    modal:true,
	    		    collapsible:false,
	    		    minimizable:false,
	    		    maximizable:false,
	    		    resizable:false,
	    		    iconCls:'icon-edit',
	    		    title:ECSINFO.update,
	    		    href:"../../system/product/productAddUpdateOperator?operate=UPDATE"+"&geProductMain.coreproductcode="+row.coreproductcode
	    		}).show(); 
	    	}
	    	
	    }
};


Product.del={

	    text: ECSINFO.del,
	    iconCls: 'icon-remove',
	    handler:function(){
	    	var rows =$('#productListDatagrid').datagrid('getChecked');
	    	
	    	if(rows== null || rows.length ==0){
	    		ECSINFO.alert_delete_requried();
	    		return false;
	    	}else{
	    		ECSINFO.confirm_delete(function(){
	    			var data = "";
	        		for(var i=0;i<rows.length;i++){
	        			data = data+"&productCodes["+ i +"]="+rows[i].coreproductcode;
	        		}
	        		data = data+"&date="+new Date();
	        		$.ajax({
	        			type:"POST",
	        			url:"../../system/product/deleteProduct",
	        			data:data,
	        			success:function(data){
	        				$('#productListDatagrid').datagrid('load'); 
	        				$('#productListDatagrid').datagrid('clearChecked');
	        			},
	        			error:function (XMLHttpRequest, textStatus, errorThrown){
	        				ECSINFO.alert_system_error();
	        			}
	        		});
	        		
	    		});
            	
	    	}
	    }
};


Product.flow={

	    text: "流程定制",
	    iconCls: 'icon-flow-edit',
	    handler:function(){
	    	var rows =$('#productListDatagrid').datagrid('getChecked');
	    	if(rows== null || rows.length != 1){
	    		ECSINFO.alert_update_unique();
	    		return false;
	    	}
	    	else{
	    		var row = rows[0];
	    		if(row.productstatus =='1' || row.productstatus =='2'){
	    			//弹出流程定制窗口
			    	$('#product_operator_window').window({ 
					    width:600,    
					    height:350,    
					    modal:true,
					    collapsible:false,
					    minimizable:false,
					    maximizable:false,
					    resizable:false,
					    iconCls:'icon-flow-edit',
					    title:"流程定制",
					    href:"../../system/product/productFlowConfig?coreproductcode="+row.coreproductcode
					}).show(); 
	    		}
	    		else if(row.productstatus =='3'){
	    			$.messager.alert("提示","对不起!流程已详细定义不能再定制流程");
	    		}
	    		else{
	    			 $.messager.alert("提示","对不起!流程已定制");
	    		}
	    		
	    	}
	    	
	    }
};

Product.info={

	    text: "详情定义",
	    iconCls: 'icon-info-edit',
	    handler:function(){
			var rows =$('#productListDatagrid').datagrid('getChecked');
	    	if(rows== null || rows.length != 1){
	    		ECSINFO.alert_update_unique();
	    		return false;
	    	}
	    	else{
	    		var row = null;
	    		row = rows[0];

		    	
	    		if(row.productstatus =='1'){
	    			$.messager.alert("提示","请先进行流程定制");
	    		}
	    		if(row.productstatus =='2'){
	    			
	    			
			    	var tab = new ECSTab();
	    			tab.target = $('#mainTab', window.parent.document);
	    			window.parent.CreateTab("产品详细定义","productInfoTabId","../system/product/prodouctInfoConfig?coreproductcode="+row.coreproductcode+"&date="+new Date());
	    		}
	    		else{
	    			$.messager.alert("提示","请先进行流程定制");
	    		}
	    		
	    	}
	    }
};


Product.prototype.toolbar =[];



Product.prototype.createProductTreeGrid = function(){
	var that = this;
	that.initToolBar();
	$('#productListDatagrid').datagrid({
		fit:true,
		toolbar : that.toolbar,
		checkOnSelect:true,
		pagination : true,
		rownumbers:true,
		fitColumns:true,
		title:"",
		pageSize:15,
		pageList:[10,15,20],
		idField:"coreproductcode",
		columns : [ [
         {
 			field : 'ck',
 			checkbox:true
 		},
		 {
			field : 'coreproductcode',
			title : '产品代码',
			width : ($("#productListDatagrid").width() * 0.1)
		}, {
			field : 'productname',
			title : '产品名称',
			width : ($("#productListDatagrid").width() * 0.2)
		}, {
			field : 'productstatus',
			title : '产品状态',
			width : ($("#productListDatagrid").width() * 0.1),
			formatter:function(index,row){
				return dictTrans(row.productstatus,'productConfigStatus');
        	}
		}, 
		{
			field : 'businessarea',
			title : '业务领域 ',
			width : ($("#productListDatagrid").width() * 0.15),
			formatter:function(index,row){
				return dictTrans(row.businessarea,'BUSINESSAREA');
        	}
		},
		{
			field : 'createdate',
			title : '创建时间',
			width : ($("#productListDatagrid").width() * 0.15)
		},
		{
			field : 'updatedate',
			title : '更新时间',
			width : ($("#productListDatagrid").width() * 0.15)
		},
		
		{
			field : 'operatorname',
			title : '操作人员',
			width : ($("#productListDatagrid").width() * 0.15)
		} 
		
		] ]
	});
	
	that.initOwnToolBar();
	that.loadData();
	
};

Product.prototype.initToolBar = function(){
	if(auth.access('RULE_PRODUCT_ADD_ADD')){
		this.toolbar.push(Product.add);
		this.toolbar.push("-");
	}
	if(auth.access('RULE_PRODUCT_ADD_UPDATE')){
		this.toolbar.push(Product.update);
		this.toolbar.push("-");
	}
	if(auth.access('RULE_PRODUCT_ADD_DEL')){
		this.toolbar.push(Product.del);
		this.toolbar.push("-");
	}
	if(auth.access('RULE_PRODUCT_ADD_FLOW')){
		this.toolbar.push(Product.flow);
		this.toolbar.push("-");
	}
	if(auth.access('RULE_PRODUCT_ADD_INFO')){
		this.toolbar.push(Product.info);
		this.toolbar.push("-");
	}
}

Product.prototype.initOwnToolBar = function(){
		$('.datagrid-toolbar table tr').append("<td></td>");
		$('#productSearchBar table').appendTo('.datagrid-toolbar table tr td:last');
}

/**
 * 开始加载数据
 */
Product.prototype.loadData = function(){
	var that =this;
	$('#productListDatagrid').datagrid('options').url = that.ctx+"/system/product/getProductListData";
	
}
/**
 * 查询数据
 * @param Productname 按角色名称查询
 */
Product.prototype.searchData = function(){
	var businessarea = $("#serach_businessarea").val();
	var productname = $("#serach_productname").val().replace(/\s+/g,"");
	var coreproductcode = $("#serach_coreproductcode").val().replace(/\s+/g,"");
	var productstatus = $("#serach_productstatus").val().replace(/\s+/g,"");
	$('#productListDatagrid').datagrid('load',{  
	     "geProductMain.businessarea": businessarea,
	     "geProductMain.productname":productname,
	     "geProductMain.coreproductcode":coreproductcode,
	     "geProductMain.productstatus":productstatus
	});  
}

/**
 * 添加元素
 */
Product.prototype.addElement = function(pageNo){
	var elements = $("#"+pageNo+"_page_elementId option:selected");
	//var ownPermissions = $("#ownPermission option");

	for(var i=0;i<elements.length;i++){
		//如果选中的已经存在
		if(typeof($("#"+pageNo+"_page_ownerElementId option[value='"+$(elements[i]).val()+"']").val())!='undefined'){
			 $.messager.alert("提示","对不起!元素已经存在");
			 return false;
		}
		else{
			 var element = $(elements[i]).clone(true);
			 $("#"+pageNo+"_page_ownerElementId").append(element);
		}
		
		
	}
	
	
}
/**
 * 移除元素
 */
Product.prototype.removeElement = function(pageNo){
	var elements = $("#"+pageNo+"_page_ownerElementId option:selected");
	for(var i=0;i<elements.length;i++){
		//如果选中的已经存在
//		if(typeof( $("#"+pageNo+"_page_elementId option[value='"+$(elements[i]).val()+"']").val())!='undefined'){
//			//alert($(permissions[i]).val());
//		}
//		else{
//			 $("#"+pageNo+"_page_ownerElementId").remove($(elements[i]));
//		}
		$(elements[i]).remove();
		
	}
}


/**
 * 添加或者修改产品
 */
Product.prototype.addUpdateProduct = function(){
	var that = this;
	var businessarea = $("#addupdate_businessarea").val();
	var productname = $("#addupdate_productname").val().replace(/\s+/g,"");
	var coreproductcode = $("#addupdate_coreproductcode").val().replace(/\s+/g,"");
	var coreproductsimplename = $("#addupdate_coreproductsimplename").val().replace(/\s+/g,"");
	var productflow = $("#addupdate_productflow").val();
	var operate = $("#operate").val();
	var data = "geProductMain.businessarea="+businessarea
		+"&geProductMain.productname="+productname
		+"&geProductMain.coreproductcode="+coreproductcode
		+"&geProductMain.coreproductsimplename="+coreproductsimplename
		+"&geProductMain.productflow="+productflow
		+"&operate="+operate
		+"&date="+new Date();
	$.ajax({
		type:"POST",
		url:that.ctx+"/system/product/doProductADDUpdate",
		data:data,
		success:function(data){
			$('#product_operator_window').window('close');
			$('#productListDatagrid').datagrid('load'); 
			$('#productListDatagrid').datagrid('clearChecked');
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			ECSINFO.alert_system_error();
		}
	});
	 
}

Product.prototype.formValidate = function(){
	var that = this;
	$('#addUpdateProductForm').validator({
		theme: 'blue',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{ //自定义规则 有两种方式 1、EL表达式 2、自定义方法
			productname: [/^[^<>]+$/, '不能出现<>字符'], //自定义EL表达式
			/**
			 *@param element 当前验证的DOM元素
			 *@param param 规则传递的参数
			 *@param field 当前字段元数据
			*/
			unique:function(element, param, field){ //自定义方法规则
				
				var data = "operate="+$("#operate").val()+"&geProductMain.coreproductcode="+$("#addupdate_coreproductcode").val()+"&date="+new Date();
				return $.ajax({
					type:"POST",
					url:that.ctx+"/system/product/existProduct",
					data:data,
					success:function(data){
						return data;
					},
					error:function (XMLHttpRequest, textStatus, errorThrown){
						ECSINFO.alert_system_error();
						return false;
					}
				});
			}
		},
		fields:{//那些字段要加入到规则中
			"productname":{
				rule:"required;productname;",
				tip: "不能出现<>字符"
			    //ok: "成功后显示"
			    //msg: {required: "全名必填!"}  覆盖默认的提示文字
			},
			"coreproductcode":{
				rule:"required;unique;"
			}
		},
		valid: function(form){ //验证成功
			that.addUpdateProduct();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
		
	});
	
	$('#addProductConfigPageElementForm').validator({
		valid: function(form){ //验证成功
			  var pageAndElement = "";
			  var selectCommon=$('select[id$=_page_ownerElementId]'); //查询
			  for(var i=0;i<selectCommon.length;i++){
				  var selectId = $(selectCommon[i]).attr("id");
				  var elements = $("#"+selectId+" option");
				  pageAndElement = pageAndElement+selectId.replace("_page_ownerElementId","");
				  for(var j=0;j<elements.length;j++){
					  pageAndElement = pageAndElement+"_"+$(elements[j]).val();
				  }
				  if(i != selectCommon.length -1){
					  pageAndElement = pageAndElement+"-";
				  }
			  }
			  var coreproductcode = $("#product_coreproductcode").val();
			  var data = "config="+pageAndElement+"&date="+new Date();
			  data = data+"&coreproductcode="+coreproductcode;
			  $.ajax({
					type:"POST",
					url:that.ctx+"/system/product/doProductFlowConfig",
					data:data,
					success:function(data){
						if(data =='SUCCESS'){
							$('#product_operator_window').window('close');
							that.searchData();
						}
						else{
							ECSINFO.alert_system_error();
						}
					},
					error:function (XMLHttpRequest, textStatus, errorThrown){
						ECSINFO.alert_system_error();
						return false;
					}
			  });
			 
			 
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
	});
	
	
}
