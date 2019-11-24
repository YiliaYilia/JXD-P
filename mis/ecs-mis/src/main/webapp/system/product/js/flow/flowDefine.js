var FlowDefine = function(){};
FlowDefine.prototype.ctx = null;

/**
 * 添加按钮
 */
FlowDefine.add =  {
		text : ECSINFO.add,
		iconCls : 'icon-add',
		handler : function() {
			$('#operate_window').window({
				width : 500,
				height : 420,
				modal : true,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				resizable : false,
				iconCls : 'icon-add',
				title : ECSINFO.add,
				href:"../product/flowOperate?operate=add"
			}).show();
		}
};

/**
 * 查看按钮
 */
FlowDefine.view = {
		text : ECSINFO.view,
		iconCls : 'icon-search',
		handler : function() {
			var selections = $("#flowData").datagrid('getSelections');
			if(selections.length != 1){
				ECSINFO.alert_update_unique();
			} else {
				var row = selections[0];
				$('#operate_window').window({
					width : 350,
					height : 420,
					modal : true,
					collapsible : false,
					minimizable : false,
					maximizable : false,
					resizable : false,
					iconCls : 'icon-search',
					title : ECSINFO.view,
					href:"../product/flowOperate?operate=view&geProductflowdefine.productflowdefineno="+row.flowno
				}).show();
			}
		}
};

/**
 * 工具栏
 */
FlowDefine.prototype.toolbar = [];

/**
 * 初始化工具栏
 */
FlowDefine.prototype.initToolBar = function(){
		if(auth.access('RULE_PRODUCT_FLOW_ADD')){
			this.toolbar.push(FlowDefine.add);
			this.toolbar.push("-");
		}if(auth.access('RULE_PRODUCT_FLOW_VIEW')){
			this.toolbar.push(FlowDefine.view);
			this.toolbar.push("-");
		}
};

/**
 * 创建流程信息数据表格
 */
FlowDefine.prototype.createDataGrid = function(){
	this.initToolBar();
	$('#flowData').datagrid({
		toolbar : this.toolbar,
		url : '../product/findFlowData', 
		fit : true,
		pagination:true,
		rownumbers:true,
		pageSize:15,
		pageList:[15,20,30,50],
		loading:"数据加载中...",
		idField:"userid",
		checkbox:true,
		width : $("#flowData").width(),
		fitColumns:true,
		columns : [ [ {
			field : 'flowno',
			title : 'id',
			hidden: true
		}, {
			checkbox:true,
			field : 'checkbox',
			title : 'checkbox'
		}, {
			field : 'flowname',
			title : '流程名称',
			width : ($("#flowData").width() * 0.3),
			halign: 'center',
			align:'center'
		}, {
			field : 'createtime',
			title : '创建时间',
			width : ($("#flowData").width() * 0.25),
			halign: 'center',
			align:'center'
		}, {
			field : 'updatetime',
			title : '修改时间',
			width : ($("#flowData").width() * 0.25),
			halign: 'center',
			align:'center'
		}, {
			field : 'operator',
			title : '操作人员',
			width : ($("#flowData").width() * 0.2),
			halign: 'center',
			align:'center'
		} ] ]
	});
	this.initOwnToolBar();
};

/**
 * 加载搜索条
 */
FlowDefine.prototype.initOwnToolBar = function(){
	$('.datagrid-toolbar table tr').append("<td></td>");
	$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
};

/**
 * 根据名称搜索
 * @param productflowname
 */
FlowDefine.prototype.searchData = function(productflowname){
	if(typeof(productflowname)=='undefined'){
		productflowname="";
	}
	else{
		productflowname=productflowname.replace(/\s+/g,"");
	}
	$('#flowData').datagrid('clearSelections');  
	$('#flowData').datagrid('load',{
		'geProductflowdefine.productflowname':productflowname
	});  
};

/**
 * 将id1中选中的选项添加至id2中
 * @param id1 第一个列表框的id
 * @param id2 第二个列表框的id
 */
FlowDefine.prototype.addOption = function(id1,id2){
	var options = $("#"+id1+" option:selected");
	var ownoptions = $("#"+id2+" option");
	for ( var int = 0; int < options.length; int++) {
		var value = $(options[int]).val();
		var isAdd = true;
		for ( var own = 0; own < ownoptions.length; own++) {
			if(value == $(ownoptions[own]).val()){
				isAdd = false;
				break;
			}
		}
		var option = $(options[int]).clone(true);
		if(!typeof($("#"+id2+" option[value='"+$(options[int]).val()+"']").val())!='undefined' && isAdd == true){
			$("#"+id2).append(option);
		}
		//$("#"+id2+" option:last").attr("selected", "selected");
	}
};

/**
 * 移除id中的选中的选项
 * @param id 列表框的id
 */
FlowDefine.prototype.removeOption = function(id){
	var options = $("#"+id+" option:selected");
	for ( var int = 0; int < options.length; int++) {
		options.remove(int);
	}
};

/**
 * 移动id中选中的选项
 * @param id 列表框的id
 * @param connt 移动的量 上移为- 下移为+
 */
FlowDefine.prototype.moveOption = function(id,connt){
	var selIndex = $("#"+id).get(0).selectedIndex;
	var options = $("#"+id+" option");
	if(connt < 0 && selIndex <= 0){
		return;
	}
	if(connt > 0 && (selIndex < 0 || selIndex==options.length-1)){
		return;
	}
	var text = $(options[selIndex]).text();
	var value = $(options[selIndex]).val();
	var lastValue = $(options[selIndex+connt]).val();
	var lastText = $(options[selIndex+connt]).text();
	$(options[selIndex]).text(lastText);
	$(options[selIndex]).val(lastValue);
	$(options[selIndex+connt]).val(value);
	$(options[selIndex+connt]).text(text);
	$("#"+id).get(0).selectedIndex = $("#"+id).get(0).selectedIndex+connt;
};

/**
 * 根据流程页面生成页面元素配置页
 */
FlowDefine.prototype.next = function(){
	var tabs = $('#pageEles').tabs('tabs');
	var size = tabs.length;
	for ( var i = 0; i < size; i++) {
		$('#pageEles').tabs('close',0);
	}
	var owerpagedefines = $("#owerpagedefines option");
	for ( var int = 0; int < owerpagedefines.length; int++) {
		$('#pageEles').tabs('add',{
			title: $(owerpagedefines[int]).text(),
			selected: false,
			href: this.ctx+'/system/product/elementPage?pageno='+$(owerpagedefines[int]).val()
		});
	}
	$('#pageEles').tabs('select',0);
	$('#user_operate').tabs('select',1);
};

/**
 * 添加或更新流程
 */
FlowDefine.prototype.addUpdateFlow = function(){
	var operate = $("#operate").val();
	var operator = $("#operator").val();
	var productflowname = $("#productflowname").val();
	var ownPages = $("#owerpagedefines option");
	
	var data = "operate="+operate+
			   "&geProductflowdefine.operator="+operator+
			   "&geProductflowdefine.productflowname="+productflowname;
	/*if(operate=='update'){
		data = data + "&geProductflowdefine.productflowdefineno="+$("#productflowdefineno").val();
	}*/
	var pageAndElement = "";
	var selectCommon=$('select[id^=ownele]');
	for(var i=0;i<selectCommon.length;i++){
		var selectId = $(selectCommon[i]).attr("id");
		var elements = $("#"+selectId+" option");
		pageAndElement = pageAndElement+selectId.replace("ownele","");
		for(var j=0;j<elements.length;j++){
			pageAndElement = pageAndElement+"_"+$(elements[j]).val();
		}
		if(i != selectCommon.length -1){
			pageAndElement = pageAndElement+"-";
		}
	}
	data = data + "&config="+pageAndElement;
	$.ajax({
		type:"POST",
		url:this.ctx+"/system/product/addOrUpdateFlow",
		data:data,
		success:function(data){
			$('#operate_window').window('close');
			$('#flowData').datagrid('reload'); 
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
};

var flowDefine = new FlowDefine();