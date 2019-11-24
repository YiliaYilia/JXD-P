/**指定受益人显示*/ 	
function changeBnf(){
	var $bnfFlag = $("#bnfFlag").val();
	if($bnfFlag == "3"){
		$("#beneficiaryId").show();
	}else{
		$("#beneficiaryId").hide();
	}
}
/**根据指定受益人数显示输入框*/
function changeBnfNum(){
	var $bnfNum = $("#bnfNum").val();
	if($bnfNum == "2"){
		$("#tb2").show();
		$("#tb3").hide();
	}else if($bnfNum == "3"){
		$("#tb2").show();
		$("#tb3").show();
	}else{
		$("#tb2").hide();
		$("#tb3").hide();
	}
}	
/**受益人1姓名校验*/
function changeBnfName1(){
	var $bnfName1 = $("#bnfName1").val();
	if($bnfName1=="" || $bnfName1.length==0 || $bnfName1 == null){
		alert("请输入指定受益人姓名");
		return false;
	}else if(!/^[a-zA-Z]{3,20}$/.test($bnfName1)&&!/^[\u4e00-\u9fa5]{2,10}$/.test($bnfName1)){
		$("#bnfName1").val("");
		$("#bnfName1").focus();
		alert("请输入正确的指定受益人姓名");
		return false;
	}
}
/**受益人2姓名校验*/
function changeBnfName2(){
	var $bnfName2 = $("#bnfName2").val();
	if($bnfName2=="" || $bnfName2.length==0 || $bnfName2 == null){
		alert("请输入指定受益人姓名");
		return false;
	}else if(!/^[a-zA-Z]{3,20}$/.test($bnfName2)&&!/^[\u4e00-\u9fa5]{2,10}$/.test($bnfName2)){
		$("#bnfName2").val("");
		$("#bnfName2").focus();
		alert("请输入正确的指定受益人姓名");
		return false;
	}
}
/**受益人3姓名校验*/
function changeBnfName3(){
	var $bnfName3 = $("#bnfName3").val();
	if($bnfName3=="" || $bnfName3.length==0 || $bnfName3 == null){
		alert("请输入指定受益人姓名");
		return false;
	}else if(!/^[a-zA-Z]{3,20}$/.test($bnfName3)&&!/^[\u4e00-\u9fa5]{2,10}$/.test($bnfName3)){
		$("#bnfName3").val("");
		$("#bnfName3").focus();
		alert("请输入正确的指定受益人姓名");
		return false;
	}
}


/**受益人1身份证号校验*/
function changeBnfIDNo1(){
	var $bnfIDNo1 = $("#bnfIDNo1").val().toUpperCase();
	if($bnfIDNo1=="" || $bnfIDNo1.length==0 || $bnfIDNo1 == null){
		alert("请输入指定受益人身份证号");
		return false;
	}else if($bnfIDNo1.length !=15 && $bnfIDNo1.length !=18){
		$("#bnfIDNo1").val("");
		$("#bnfIDNo1").focus();
		alert("请输入正确的指定受益人身份证号！"); 
		return false;
	}else if(IdentityCodeValid($bnfIDNo1,true)==false){
		$("#bnfIDNo1").val("");
		$("#bnfIDNo1").focus();
		return false;
	}else if(bnfidentifynumber==$bnfIDNo1){
		$("#bnfIDNo1").val("");
		$("#bnfIDNo1").focus();
		alert("受益人和投保人不能为同一人");
		return false;
	}
	$("#bnfIDNo1").val($bnfIDNo1);
	$("#bnfBirthday1").val(getBirth($bnfIDNo1));
	$("#bnfSex1").val(getSex($bnfIDNo1)=="M" ? "男" : "女");
}
/**受益人2身份证号校验*/
function changeBnfIDNo2(){
	var $bnfIDNo2 = $("#bnfIDNo2").val().toUpperCase();
	if($bnfIDNo2=="" || $bnfIDNo2.length==0 || $bnfIDNo2 == null){
		alert("请输入指定受益人身份证号");
		return false;
	}else if($bnfIDNo2.length !=15 && $bnfIDNo2.length !=18){
		$("#bnfIDNo2").val("");
		$("#bnfIDNo2").focus();
		alert("请输入正确的指定受益人身份证号！"); 
		return false;
	}else if(IdentityCodeValid($bnfIDNo2,true)==false){
		$("#bnfIDNo2").val("");
		$("#bnfIDNo2").focus();
		return false;
	}else if(bnfidentifynumber==$bnfIDNo2){
		$("#bnfIDNo2").val("");
		$("#bnfIDNo2").focus();
		alert("受益人和投保人不能为同一人");
		return false;
	}
	$("#bnfIDNo2").val($bnfIDNo2);
	$("#bnfBirthday2").val(getBirth($bnfIDNo2));
	$("#bnfSex2").val(getSex($bnfIDNo2)=="M" ? "男" : "女");
}
/**受益人3身份证号校验*/
function changeBnfIDNo3(){
	var $bnfIDNo3 = $("#bnfIDNo3").val().toUpperCase();
	if($bnfIDNo3=="" || $bnfIDNo3.length==0 || $bnfIDNo3 == null){
		alert("请输入指定受益人身份证号");
		return false;
	}else if($bnfIDNo3.length !=15 && $bnfIDNo3.length !=18){
		$("#bnfIDNo3").val("");
		$("#bnfIDNo3").focus();
		alert("请输入正确的指定受益人身份证号！"); 
		return false;
	}else if(IdentityCodeValid($bnfIDNo3,true)==false){
		$("#bnfIDNo3").val("");
		$("#bnfIDNo3").focus();
		return false;
	}else if(bnfidentifynumber==$bnfIDNo3){
		$("#bnfIDNo3").val("");
		$("#bnfIDNo3").focus();
		alert("受益人和投保人不能为同一人");
		return false;
	}
	$("#bnfIDNo3").val($bnfIDNo3);
	$("#bnfBirthday3").val(getBirth($bnfIDNo3));
	$("#bnfSex3").val(getSex($bnfIDNo3)=="M" ? "男" : "女");
}

var regBnfLot = /^\d{1,2}$/;
/**受益人1收益比例校验*/
function changeBnfLot1(){
	var $bnfLot1 = $("#bnfLot1").val();
	if(!regBnfLot.test($bnfLot1) && $bnfLot1 != 100){
		$("#bnfLot1").val("");
		$("#bnfLot1").focus();
		alert("请输入正确的受益比例");
		return false;
	}
}
/**受益人2收益比例校验*/
function changeBnfLot2(){
	var $bnfLot2 = $("#bnfLot2").val();
	if(!regBnfLot.test($bnfLot2) && $bnfLot2 != 100){
		$("#bnfLot2").val("");
		$("#bnfLot2").focus();
		alert("请输入正确的受益比例");
		return false;
	}
}
/**受益人3收益比例校验*/
function changeBnfLot3(){
	var $bnfLot3 = $("#bnfLot3").val();
	if(!regBnfLot.test($bnfLot3) && $bnfLot3 != 100){
		$("#bnfLot3").val("");
		$("#bnfLot3").focus();
		alert("请输入正确的受益比例");
		return false;
	}
}
/**受益人1收益关系校验*/
function changeGX1(){
	var RelationToInsured1 = $("#RelationToInsured1").val();
	if(RelationToInsured1=="" || RelationToInsured1.length==0 || RelationToInsured1 == null){
		alert("请选择受益人与被保险人关系");
		return false;
	}
}
/**受益人2收益关系校验*/
function changeGX2(){
	var RelationToInsured2 = $("#RelationToInsured2").val();
	if(RelationToInsured2=="" || RelationToInsured2.length==0 || RelationToInsured2 == null){
		alert("请选择受益人与被保险人关系");
		return false;
	}
}
/**受益人3收益关系校验*/
function changeGX3(){
	var RelationToInsured3 = $("#RelationToInsured3").val();
	if(RelationToInsured3=="" || RelationToInsured3.length==0 || RelationToInsured3 == null){
		alert("请选择受益人与被保险人关系");
		return false;
	}
}


/**身份证校验*/
function IdentityCodeValid(code,type){var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};var tip="";var pass=true;if(!code||!/(^\d{15}$)|(^\d{17}(\d|X)$)/.test(code)){if(type){tip="投保人身份证号格式错误"}else{tip="被保险人身份证号格式错误"}pass=false}if(!city[code.substr(0,2)]){if(type){tip="投保人身份证地址编码错误"}else{tip="被保人身份证地址编码错误"}pass=false}else{if(code.length==18){code=code.split('');var factor=[7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2];var parity=[1,0,'X',9,8,7,6,5,4,3,2];var sum=0;var ai=0;var wi=0;for(var i=0;i<17;i++){ai=code[i];wi=factor[i];sum+=ai*wi}var last=parity[sum%11];if(parity[sum%11]!=code[17]){if(type){tip="投保人身份证校验位错误"}else{tip="被保人身份证校验位错误"}pass=false}}}if(!pass)alert(tip);return pass}
/**根据身份证获取性别*/
function getSex(value){
	if (parseInt(value.substr(16, 1)) % 2 == 1) {
		return "M";
	} else {
		return "F"; 
	} 
}
/**根据身份证获取出生年月*/
function getBirth(value) {
    var year = "1900";
    var month = "1";
    var day = "1";
    if (value.length == 15) {
        year = "19" + value.substr(6, 2);
        month = value.substr(8, 2);
        day = value.substr(10, 2);
    } else if (value.length == 18) {
        year = value.substr(6, 4);
        month = value.substr(10, 2);
        day = value.substr(12, 2);
    } else {
        return "";
    }
    newDate = new Date(year, month - 1, day);
    if (newDate.toString() == "NaN") {
        return "";
    }
    else {
        var start =  year + "-" + month + "-" + day;
        return start;
    } 
}