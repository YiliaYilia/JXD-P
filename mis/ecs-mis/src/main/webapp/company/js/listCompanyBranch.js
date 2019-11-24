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
					name : "comBranchName" ,

				},
				simpleData : {
					enable : true,
					idKey : "comBranchId",
					pIdKey : "comParentBranchNo",
					rootPId : 0
				},

			},
			callback: {
				onRightClick: OnRightClick,
				onClick: zTreeOnClick
			}

		}
	};
function OnRightClick(event, treeId, treeNode){
	if (treeNode && !treeNode.noR) {
		treeObj.selectNode(treeNode);
		tNode=treeNode;
		showRMenu(tNode, event.clientX, event.clientY);
	}
}
function zTreeOnClick(event, treeId, treeNode){
	treeObj.reAsyncChildNodes(treeNode, "refresh");
	$.ajax({
		type:"POST",
		url:ctx+"/company/queryCompanyBranch",
		data:{
			"companyBranch.comBranchId":treeNode.comBranchId,
			"province.code":treeNode.provinceCode,
			"city.code":treeNode.cityCode,
			"area.code":treeNode.areaCode
		},
		success:function(data){
			$("#companyBranchDetail").show();
			$("#comBranchId1").text(data[0].comBranchId);
			$("#comBranchName1").text(data[0].comBranchName);
			$("#comBranchNo1").text(data[0].comBranchNo);
			$("#level1").text(data[0].comBranchId.split("|").length+"级");
			$("#comBranchDesc1").text(data[0].comBranchDesc);
			$("#area").text(data[1].name+" "+data[2].name+" "+data[3].name);
		}
	});
}
function showRMenu(tNode, x, y) {
	$("#rMenu ul").show();
	$("#updateCompanyBranch").show();
	if(tNode.isParent){
		$("#deleteCompanyBranch").hide();
	}else{
		$("#deleteCompanyBranch").show();
	}
	
	rMenu.css({"top":y+"px", "left":x+"px", "visibility":"visible"});
	$("body").bind("mousedown", onBodyMouseDown);
}
function onBodyMouseDown(event){
	if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length>0)) {
		rMenu.css({"visibility" : "hidden"});
	}
}
function updateCompanyBranch(){
	$('#addCompanyBranchData_add_window').show();
	$('#addCompanyBranchData_add_window').window({
		width : 370,
		height : 270,
		modal : true,
		collapsible : false,
		minimizable : false,
		maximizable : false,
		resizable : false,
		iconCls : 'icon-edit',
		//href : "${ctx}/company/selectCompanyBranchTree",

	});
	resert();
	
}
function resert() {
	var comParentBranchNo=tNode.comParentBranchNo;
	$("#comParentBranchNo").val(comParentBranchNo);
	$("#comBranchId").text(tNode.comBranchId);
	$("#comParentBranchNo").val(comParentBranchNo);
	$("#comBranchNo").val(tNode.comBranchNo);
	$("#comBranchName").val(tNode.comBranchName);
	$("#level").text(tNode.comBranchId.split("|").length+"级");
	$("#comBranchDesc").val(tNode.comBranchDesc);
	$.ajax({
		type:'POST',
		url:ctx+'/company/getAllProvince',
		success:function(data){
			for(var i=0;i<data.length;i++){
				$('#province').append("<option id="+data[i].code+" onmousedown=changeCity('"+data[i].code+"') value="+data[i].code+">"+data[i].name+"</option>");
				$("#"+tNode.provinceCode).prop("selected",true);
				
			}
			
		}
	});
	$.ajax({
		type:"POST",
		url:ctx+"/company/getAllCityByProvincecode",
		data:{
			"city.provincecode":tNode.provinceCode
		},
		success:function(data){
			for(var i=0;i<data.length;i++){
				$('#city').append("<option id="+data[i].code+" onmousedown=changeArea('"+data[i].code+"') value="+data[i].code+">"+data[i].name+"</option>");
				$("#"+tNode.cityCode).prop("selected",true);
			}
		}
	});
	$.ajax({
		type:"POST",
		url:ctx+"/company/getAllAreaByCitycode",
		data:{
			"area.citycode":tNode.cityCode
		},
		success:function(data){
			for(var i=0;i<data.length;i++){
				$('#area').append("<option id="+data[i].code+" onmousedown=changeArea('"+data[i].code+"') value="+data[i].code+">"+data[i].name+"</option>");
				$("#"+tNode.areaCode).prop("selected",true);
			}
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
function deleteCompanyBranch(){
	var node = tNode.getParentNode();
	if(node!=null){
		var children=node.children;
		deleteComBranch(children);
	}else{
		var children=treeObj.getNodes();
		deleteComBranch(children);
	}
}
function deleteComBranch(children) {
	var length=children.length;
	var comBranchIds=tNode.comBranchId;
	var ids=comBranchIds.split("|");
	var id=parseInt(ids[ids.length-1]);
	if(id==length){
		$.ajax({
			type:"POST",
			url:ctx+"/company/deleteCompanyBranch",
			data:{
				"companyBranch.comBranchId":comBranchIds
			},
			success:function(data){
				treeObj.removeNode(tNode);
				$.messager.show({  	
					  title:'消息提示',  	
					  msg:'删除企业机构成功',  	
					  timeout:5000,  	
					  showType:'slide'  
					}); 
			},
			error:function (XMLHttpRequest, textStatus, errorThrown) {
			    alert(textStatus);
			}
		});
	}else{
		for(var i=(id-1);i<(length-1);i++){
			$.ajax({
				type:"POST",
				url:ctx+"/company/updateCompanyBranch",
				data:{
					"companyBranch.comBranchNo" : children[i+1].comBranchNo,
					"companyBranch.comParentBranchNo" : children[i+1].comParentBranchNo,
					"companyBranch.comBranchName" : children[i+1].comBranchName,
					"companyBranch.comBranchDesc":children[i+1].comBranchDesc,
					"companyBranch.comBranchId":children[i].comBranchId,
					"companyBranch.provinceCode":children[i+1].provinceCode,
					"companyBranch.cityCode":children[i+1].cityCode,
					"companyBranch.areaCode":children[i+1].areaCode
				},
				success:function(data){
					
					$.messager.show({  	
						  title:'消息提示',  	
						  msg:'修改企业机构成功',  	
						  timeout:5000,  	
						  showType:'slide'  
						}); 
				},
				error:function (XMLHttpRequest, textStatus, errorThrown) {
				    alert(textStatus);
				}
			});
			children[i].comBranchName=children[i+1].comBranchName;
			children[i].comBranchNo=children[i+1].comBranchNo;
			children[i].comBranchParentNo=children[i+1].comBranchParentNo;
			children[i].provinceCode=children[i+1].provinceCode;
			children[i].cityCode=children[i+1].cityCode;
			children[i].areaCode=children[i+1].areaCode;
			treeObj.updateNode(children[i]);
		}
		$.ajax({
			type:"POST",
			url:ctx+"/company/deleteCompanyBranch",
			data:{
				"companyBranch.comBranchId":children[length-1].comBranchId
			},
			success:function(data){
				treeObj.removeNode(children[length-1]);
				treeObj.refresh();
				$.messager.show({  	
					  title:'消息提示',  	
					  msg:'修改企业机构成功',  	
					  timeout:5000,  	
					  showType:'slide'  
					}); 
			},
			error:function (XMLHttpRequest, textStatus, errorThrown) {
			    alert(textStatus);
			}
		});
	}
}
function updateCompanyBranch_1(){
	tNode.comBranchName=$("#comBranchName").val();
	tNode.comBranchNo=$("#comBranchNo").val();
	tNode.comBranchDesc=$("#comBranchDesc").val();
	tNode.provinceCode=$("#province").val();
	tNode.cityCode=$("#city").val();
	tNode.areaCode=$("#area").val();
	treeObj.editName(tNode);
	treeObj.refresh();
	$.ajax({
		type:"POST",
		url:ctx+"/company/updateCompanyBranch",
		data:{
			"companyBranch.comBranchNo" : $("#comBranchNo").val(),
			"companyBranch.comParentBranchNo" : tNode.comParentBranchNo,
			"companyBranch.comBranchName" : $("#comBranchName").val(),
			"companyBranch.comBranchDesc":$("#comBranchDesc").val(),
			"companyBranch.comBranchId":$("#comBranchId").text(),
			"companyBranch.provinceCode":$("#province").val(),
			"companyBranch.cityCode":$("#city").val(),
			"companyBranch.areaCode":$("#area").val()
		},
		success:function(data){
			$("#addCompanyBranchData_add_window").window("close");
			$.messager.show({  	
				  title:'消息提示',  	
				  msg:'修改企业成功',  	
				  timeout:5000,  	
				  showType:'slide'  
				}); 
		}
	});
}
var treeObj,rMenu,tNode,operateParentNode;
$(document).ready(function(){
	$.fn.zTree.init($("#tree"), tree.setting, data);
	treeObj = $.fn.zTree.getZTreeObj("tree");
	rMenu = $("#rMenu");
});