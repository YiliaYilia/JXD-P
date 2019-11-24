var tree = {
	setting : {
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

			},
			simpleData : {
				enable : true,
				idKey : "comBranchId",
				pIdKey : "comParentBranchNo",
				rootPId : 0
			},

		},
		callback : {
			onRightClick : OnRightClick
		}

	}
};
function OnRightClick(event, treeId, treeNode) {
	if (treeNode && !treeNode.noR) {
		treeObj.selectNode(treeNode);
		tNode = treeNode;
		showRMenu("node", event.clientX, event.clientY);
	}
}
function showRMenu(type, x, y) {
	$("#rMenu ul").show();
	$("#addSameLevelMenu").show();
	$("#addLowerLevelMenu").show();
	
	rMenu.css({
		"top" : y + "px",
		"left" : x + "px",
		"visibility" : "visible"
	});
	$("body").bind("mousedown", onBodyMouseDown);
}
function onBodyMouseDown(event) {
	if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length > 0)) {
		rMenu.css({
			"visibility" : "hidden"
		});
	}
}
/**
 * 添加同级企业机构
 */
function addSameLevelMenu() {
	operateParentNode=true;
	clearArea();
	comParentBranchNo= tNode.comParentBranchNo;
	var id;
	if(comParentBranchNo=="0"){
		
		var nodes=treeObj.getNodes();
		id=parseInt(nodes.length)+1;
		id = addZero(id);
		$("#comBranchId").text(id);
		$("#level").text(1+"级");
	}else{
		var parentTId=tNode.parentTId;
		var node = treeObj.getNodeByTId(parentTId);
		var comBranchId=node.comBranchId;
		var children=node.children;
		var length=children.length;
		id=length+1;
		id = addZero(id);
		$("#comBranchId").text(comBranchId+"|"+id);
		var level=$("#comBranchId").text().split("|");
		$("#level").text(level.length+"级");
	}
	operateParentNode = true;
	$.ajax({
		type:'POST',
		url:ctx+'/company/getAllProvince',
		success:function(data){
			for(var i=0;i<data.length;i++){
				$('#province').append("<option onmousedown=changeCity('"+data[i].code+"') value="+data[i].code+">"+data[i].name+"</option>");
			}
			 
		}
	});
	$('#addCompanyBranchData_add_window').show();
	$('#addCompanyBranchData_add_window').window({
		width : 570,
		height : 340,
		modal : true,
		collapsible : false,
		minimizable : false,
		maximizable : false,
		resizable : false,
		iconCls : 'icon-add',
		title:'新建同级菜单',

	});

}
/**
 * 清除省市区
 */
function clearArea() {
	var province=$("#province").children();
	for(var i=1;i<province.length;i++){
		province[i].remove();
	}
	var city=$("#city").children();
	for(var i=1;i<city.length;i++){
		city[i].remove();
	}
	var area=$("#area").children();
	for(var i=1;i<area.length;i++){
		area[i].remove();
	}
}
function addZero(id) {
	if(id<10){
		id="000"+id;
	}else if(id>=10&&id<100){
		id="00"+id;
	}else if(id>=100&&id<1000){
		id="0"+id;
	}
	return id;
}
function addLowerLevelMenu() {
	operateParentNode=false;
	clearArea();
	var children=tNode.children;
	var comBranchId=tNode.comBranchId;
	comParentBranchNo=comBranchId;
	if(children==undefined){
		id="0001";
	}else{
		var length=children.length;
		var id=length+1;
		id=addZero(id);
	}
	$("#comBranchId").text(comBranchId+"|"+id);
	var level=$("#comBranchId").text().split("|");
	$("#level").text(level.length);
	$.ajax({
		type:'POST',
		url:ctx+'/company/getAllProvince',
		success:function(data){
			for(var i=0;i<data.length;i++){
				$('#province').append("<option onmousedown=changeCity('"+data[i].code+"') value="+data[i].code+">"+data[i].name+"</option>");
			}
			
		}
	});
	$('#addCompanyBranchData_add_window').show();
	$('#addCompanyBranchData_add_window').window({
		width : 370,
		height : 340,
		modal : true,
		collapsible : false,
		minimizable : false,
		maximizable : false,
		resizable : false,
		iconCls : 'icon-add',
		title:'新建下级菜单'
	// href : "${ctx}/company/selectCompanyBranchTree",

	});
}
function addCompanyBranch() {
	var newNodes = [ {
		comBranchName : $("#comBranchName").val(),
		comBranchNo : $("#comBranchNo").val(),
		comParentBranchNo : $("#comParentBranchNo").val()
	} ];
	var node = null;
	if (operateParentNode) {
		var parentTId = tNode.parentTId;
		node = treeObj.getNodeByTId(parentTId);
	} else {
		var tId = tNode.tId;
		node = treeObj.getNodeByTId(tId);
	}
	newNodes = treeObj.addNodes(node, newNodes);
	treeObj.refresh();
	$.ajax({
		type : "POST",
		url : ctx + "/company/addCompanyBranch",
		data : {
			"companyBranch.comBranchNo" : $("#comBranchNo").val(),
			"companyBranch.comParentBranchNo" : comParentBranchNo,
			"companyBranch.comBranchName" : $("#comBranchName").val(),
			"companyBranch.comBranchDesc":$("#comBranchDesc").val(),
			"companyBranch.comBranchId":$("#comBranchId").text(),
			"companyBranch.provinceCode":$("#province").val(),
			"companyBranch.cityCode":$("#city").val(),
			"companyBranch.areaCode":$("#area").val()
		},
		success : function(data) {
			$("#addCompanyBranchData_add_window").window("close");
			$.messager.show({  	
				  title:'消息提示',  	
				  msg:'保存企业机构成功',  	
				  timeout:5000,  	
				  showType:'slide'  
				}); 
			$("#comBranchNo").val("");
			$("#comBranchName").val("");
			$("#comBranchDesc").val("");
			$("#companyNature").val("");
			$("#comBranchId").val("");
			clearArea();
		}
	});
}

function changeCity(code){
	var city=$("#city").children();
	for(var i=1;i<city.length;i++){
		city[i].remove();
	}
	var area=$("#area").children();
	for(var i=1;i<area.length;i++){
		area[i].remove();
	}
	$.ajax({
		type:"POST",
		url:ctx+"/company/getAllCityByProvincecode",
		data:{
			"city.provincecode":code
		},
		success:function(data){
			for(var i=0;i<data.length;i++){
				$('#city').append("<option onmousedown=changeArea('"+data[i].code+"') value="+data[i].code+">"+data[i].name+"</option>");
			}
		}
	});
}
function changeArea(code){
	var area=$("#area").children();
	for(var i=1;i<area.length;i++){
		area[i].remove();
	}
	$.ajax({
		type:"POST",
		url:ctx+"/company/getAllAreaByCitycode",
		data:{
			"area.citycode":code
		},
		success:function(data){
			for(var i=0;i<data.length;i++){
				$('#area').append("<option value="+data[i].code+">"+data[i].name+"</option>");
			}
		}
	});
}
var treeObj, rMenu, tNode, operateParentNode,comParentBranchNo;
$(document).ready(function() {
	$.fn.zTree.init($("#tree"), tree.setting, data);
	treeObj = $.fn.zTree.getZTreeObj("tree");
	rMenu = $("#rMenu");
});