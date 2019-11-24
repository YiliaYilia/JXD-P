function check(){
	var policyCode = $("#policyCode").val();//保险单号
	var name = $("#name").val();//申请人
	//var insrelationApp = $("#insrelationApp").val();//与被保险人关系
	var claimManagementType = $("#claimManagementType").val();//索赔类别
	
	var reCode = /^[a-zA-Z0-9]+$/; //检验保险单号
	
	if(policyCode==""||policyCode.length==0){
		alert("请输入保险单号");
		return false;
	}else if(!reCode.test(policyCode)){
		alert("保险单号格式不正确");
		return false;
	}else if(policyCode.length>15){
		alert("保险单号长度最长为15位");
		return false;
	}
	if(name==""||name.length==0){
		alert("请输入申请人");
		return false;
	}else if(name.length>7){
		alert("申请人长度最长为7位");
		return false;
	}
	if(claimManagementType==""||claimManagementType.length==0){
		alert("请选择索赔类别");
		return false;
	}
	return true;
}