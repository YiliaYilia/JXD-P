var Risk = function(){};
Risk.prototype.ctx = null;

Risk.add = {
	    text: ECSINFO.add,
	    iconCls: 'icon-add',
	    handler:function(){
	    	//弹出添加产品窗口
	    	$('#risk_operator_window').window({ 
			    width:640,    
			    height:420,
			    modal:true,
			    collapsible:false,
			    minimizable:false,
			    maximizable:false,
			    resizable:false,
			    iconCls:'icon-add',
			    title:ECSINFO.add,
			    href:"../../system/product/jumpAddOrUpdateRiskPage?opeartype=ADD"
			}).show(); 
	    }
};

Risk.update={

	    text: ECSINFO.update,
	    iconCls: 'icon-edit',
	    handler:function(){
	    	var rows =$('#riskListDatagrid').datagrid('getChecked');
	    	if(rows== null || rows.length != 1){
	    		ECSINFO.alert_update_unique();
	    		return false;
	    	}else{
	    		var row = rows[0];
	    		//弹出修改产品窗口
	        	$('#risk_operator_window').window({ 
	        		width:640,    
				    height:420,
	    		    modal:true,
	    		    collapsible:false,
	    		    minimizable:false,
	    		    maximizable:false,
	    		    resizable:false,
	    		    iconCls:'icon-edit',
	    		    title:ECSINFO.update,
	    		    href:"../../system/product/jumpAddOrUpdateRiskPage?opeartype=UPDATE&geRisk.riskcode="+row.riskcode
	    		}).show(); 
	    	}
	    	
	    }
};

Risk.view={

	    text: ECSINFO.view,
	    iconCls: 'icon-search',
	    handler:function(){
			var rows =$('#riskListDatagrid').datagrid('getChecked');
			if(rows== null || rows.length != 1){
	    		ECSINFO.alert_update_unique();
	    		return false;
	    	}else{
	    		var row = rows[0];
	    		//弹出查看险种窗口
	        	$('#risk_operator_window').window({
	        		width:640,    
				    height:420,
	    		    modal:true,
	    		    collapsible:false,
	    		    minimizable:false,
	    		    maximizable:false,
	    		    resizable:false,
	    		    iconCls:'icon-edit',
	    		    title:ECSINFO.view,
	    		    href:"../../system/product/jumpAddOrUpdateRiskPage?opeartype=VIEW&geRisk.riskcode="+row.riskcode
	    		}).show(); 
	    	}
	    }
};


Risk.prototype.toolbar =[];



Risk.prototype.createRiskTreeGrid = function(){
	var that = this;
	that.initToolBar();
	$('#riskListDatagrid').datagrid({
		fit:true,
		toolbar : that.toolbar,
		checkOnSelect:true,
		pagination : true,
		rownumbers:true,
		fitColumns:true,
		title:"",
		pageSize:15,
		pageList:[10,15,20],
		idField:"riskcode",
		columns : [ [
         {
 			field : 'ck',
 			checkbox:true
 		},
		 {
			field : 'riskcode',
			title : '险种代码',
			width : ($("#riskListDatagrid").width() * 0.1)
		}, {
			field : 'riskname',
			title : '险种名称',
			width : ($("#riskListDatagrid").width() * 0.2)
		}, {
			field : 'risksimplename',
			title : '险种简称',
			width : ($("#riskListDatagrid").width() * 0.2)
		}, 
		{
			field : 'coreriskcode',
			title : '核心险种代码',
			width : ($("#riskListDatagrid").width() * 0.15)
		},
		{
			field : 'riskmark',
			title : '主附险标志',
			width : ($("#riskListDatagrid").width() * 0.15),
			formatter:function(index,row){
				var value = "";
				if(row.riskmark == '01'){
					value = "是";
				}else{
					value = "否";
				}
				return value;
        	}
		},
		{
			field : 'businessarea',
			title : '业务领域 ',
			width : ($("#riskListDatagrid").width() * 0.2),
			formatter:function(index,row){
				return dictTrans(row.businessarea,'BUSINESSAREA');
        	}
		}
		
		] ]
	});
	
	that.initOwnToolBar();
	that.loadData();
	
};

Risk.prototype.initToolBar = function(){
	if(auth.access('RULE_PRODUCT_RISKDUTY_ADD')){
		this.toolbar.push(Risk.add);
		this.toolbar.push("-");
	}
	if(auth.access('RULE_PRODUCT_RISKDUTY_UPDATE')){
		this.toolbar.push(Risk.update);
		this.toolbar.push("-");
	}
	
	if(auth.access('RULE_PRODUCT_RISKDUTY_DEL')){
		//this.toolbar.push(Risk.del);
		//this.toolbar.push("-");
	}
	if(auth.access('RULE_PRODUCT_RISKDUTY_VIEW')){
		this.toolbar.push(Risk.view);
		this.toolbar.push("-");
	}
};

Risk.prototype.initOwnToolBar = function(){
		$('.datagrid-toolbar table tr').append("<td></td>");
		$('#riskSearchBar table').appendTo('.datagrid-toolbar table tr td:last');
};

/**
 * 开始加载数据
 */
Risk.prototype.loadData = function(){
	var that =this;
	$('#riskListDatagrid').datagrid('options').url = that.ctx+"/system/product/getRiskListData";
	
};
/**
 * 查询数据
 * @param Riskname 按角色名称查询
 */
Risk.prototype.searchData = function(){
	
	var riskcode = $("#serach_riskcode").val().replace(/\s+/g,"");
	var coreriskcode = $("#serach_coreriskcode").val().replace(/\s+/g,"");
	var riskname = $("#serach_riskname").val().replace(/\s+/g,"");
	var businessarea = $("#serach_businessarea").val();
	$('#riskListDatagrid').datagrid('load',{  
	     "geRisk.riskcode": riskcode,
	     "geRisk.coreriskcode":coreriskcode,
	     "geRisk.riskname":riskname,
	     "geRisk.businessarea":businessarea
	});  
};

/**
 * 添加元素
 */
Risk.prototype.addElement = function(pageNo){
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
	
	
};
/**
 * 移除元素
 */
Risk.prototype.removeElement = function(pageNo){
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
};


/**
 * 添加或者修改产品
 */
Risk.prototype.addUpdateRisk = function(){
	
	var that = this;
	var riskcode = $("#riskcode").val();
	var riskname = $("#riskname").val().replace(/\s+/g,"");
	var risksimplename = $("#risksimplename").val().replace(/\s+/g,"");
	var coreriskcode = $("#coreriskcode").val().replace(/\s+/g,"");
	var riskmark = $("#riskmark").val();
	var businessarea = $("#businessarea").val();
	var opeartype = $("#opeartype").val();
	
	var data = "&geRisk.riskcode="+riskcode
			  +"&geRisk.riskname="+riskname
			  +"&geRisk.risksimplename="+risksimplename
			  +"&geRisk.coreriskcode="+coreriskcode
			  +"&geRisk.riskmark="+riskmark
			  +"&geRisk.businessarea="+businessarea;
	
	var duties = $("#addDutyTable tr");
	for (var i = 0; i < duties.length; i++) {
		var duty = $(duties[i]).find("input");
		if (duty[0].value != "") {
			data += "&geRisk.geDutys[" + (i) + "].dutyno=" + duty[0].value;
		}
		data += "&geRisk.geDutys[" + (i) + "].dutycode=" + duty[1].value;
		data += "&geRisk.geDutys[" + (i) + "].dutyname=" + duty[2].value;
		data += "&geRisk.geDutys[" + (i) + "].dutysimplename=" + duty[3].value;
	}
	data = data +"&opeartype="+opeartype+"&date="+new Date();

	$.ajax({
		type:"POST",
		url:that.ctx+"/system/product/updateGeRisk",
		data:data,
		success:function(data){
			$('#risk_operator_window').window('close');
			$('#riskListDatagrid').datagrid('load'); 
			$('#riskListDatagrid').datagrid('clearChecked');
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			ECSINFO.alert_system_error();
		}
	});
	 
};

Risk.prototype.formValidate = function(){
	var that = this;
	$('#addUpdateRiskForm').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{ //自定义规则 有两种方式 1、EL表达式 2、自定义方法
			riskrule: [/^[^<>]+$/, '不能出现<>字符'] //自定义EL表达式
		},
		fields:{//那些字段要加入到规则中
			"geRisk.riskcode":{
				rule:"required;riskrule;"
			},
			"geRisk.riskname":{
				rule:"required;riskrule;"
			},
			"geRisk.risksimplename":{
				rule:"required;riskrule;"
			},
			"geRisk.coreriskcode":{
				rule:"required;riskrule;"
			},
			"geRisk.riskmark":{
				rule:"required;"
			},
			"geRisk.businessarea":{
				rule:"required;"
			}
		},
		valid: function(form){ //验证成功
			$('#addUpdateDutyForm').submit();
			return false;
		},
		invalid: function(form){//验证失败
			$("#risk_operate").tabs('select',"险种信息");
			return false;
		}
		
	});
	
	$('#addUpdateDutyForm').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{ //自定义规则 有两种方式 1、EL表达式 2、自定义方法
			riskrule: [/^[^<>]+$/, '不能出现<>字符'], //自定义EL表达式
			/**
			 *@param element 当前验证的DOM元素
			 *@param param 规则传递的参数
			 *@param field 当前字段元数据
			*/
			uniqueDutyCode:function(element, param, field){ //自定义方法规则
				
				var duties = $("#addDutyTable tr");
			
				var dutyno = "";
				
				for(var i = 0; i < duties.length; i++){
					var dutyI = $(duties[i]).find("input");
					
					if(element.value == dutyI[1].value){
						dutyno = dutyI[0].value;
					}
					
					for(var j = i+1; j < duties.length; j++){
						var dutyJ = $(duties[j]).find("input");
						if(dutyI[1].value == dutyJ[1].value){
							return '同一险种不可输入相同的责任代码！';
						}
					}
				}
				
				var data = "opeartype="+$("#opeartype").val()+"&dutyCode="+element.value+"&businessArea=&dutyNo="+dutyno+"&businessArea="+$("#businessarea").val()+"&date="+new Date();
				return $.ajax({
					type:"POST",
					url:that.ctx+"/system/product/existDutyCode",
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
		valid: function(form){ //验证成功
			risk.addUpdateRisk();
			return false;
		},
		invalid: function(form){//验证失败
			$("#risk_operate").tabs('select',"责任信息");
			return false;
		}
		
	});
	
};

var risk = new Risk();