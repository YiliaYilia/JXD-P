$(function () {
	function init() {
		var year = new Date().getFullYear();
		$(".date_input").mobiscroll().date({
			theme: theme,     
			mode: mode,      
			display: display, 
			lang: lang,   
			"height": 50,
			dateFormat:dateFormat,
			startYear:1900,
			endYear : year
		});
		
		
	}    
	var demo, theme, mode, display, lang,dateFormat,endtime;
		demo = 'date';
		theme = 'android',
		mode = 'scroller',
		display = 'modal',
		dateFormat= 'yy-mm-dd',
		
		lang = 'zh';

		$('.demo-cont').hide();
		$("#demo_cont_" + demo).show();
		init();
});
function transdate(time){
	var date=new Date();
	date.setFullYear(time.substring(0,4));
	date.setMonth(time.substring(5,7)-1);
	date.setDate(time.substring(8,10));
	return date.getTime();
}
function check(){
	document.getElementById("geClaimManagement.startDate").value = $("#startDate").val();//为隐藏出险日期赋值
	var startDate = document.getElementById("geClaimManagement.startDate").value;//出险日期
	var startCause = $("#startCause").val();//出险原因
	var phone = $("#phone").val();//联系电话
	var occupation = $("#occupation").val();//现职业
	var isInsure = $("#isInsure").val();//是否在其它公司有人身保险
	var corporationName = $("#corporationName").val();//公司名称
	document.getElementById("geClaimManagement.insureDate").value = $("#insureDate").val();//为隐藏投保日期赋值
	var insureDate = document.getElementById("geClaimManagement.insureDate").value;//投保日期
	var insuranceInfo = $("#insuranceInfo").val();//购买险种名称及保额

	var rePhone=/^0?1[3|7|5|8][0-9]\d{8}$/;
	
	if(startDate==""||startDate.length==0){
		alert("请选择出险日期");
		return false;
	}else if(transdate(startDate) > new Date().getTime()){
		alert("出险日期需早于或等于当前日期");
		return false;
	}
	if(startCause==""||startCause.length==0){
		alert("请填写出险原因");
		return false;
	}else if(startCause.length>50){
		alert("出险原因长度最长为50位");
		return false;
	}
	if(phone==""||phone.length==0){
		alert("请填写联系电话");
		return false;
	}else if(!rePhone.test(phone)){
		alert("联系电话格式不正确");
		return false;
	}
	if(occupation==""||occupation.length==0){
		alert("请填写现职业");
		return false;
	}else if(occupation.length>15){
		alert("现职业长度最长为15位");
		return false;
	}
	if(isInsure==""||isInsure.length==0){
		alert("请选择是否在其它公司有人身保险");
		return false;
	}else if(isInsure == "Y"){
		if(corporationName==""||corporationName.length==0){
			alert("请填写公司名称");
			return false;
		}else if(corporationName.length>25){
			alert("公司名称长度最长为25位");
			return false;
		}
		if(insureDate==""||insureDate.length==0){
			alert("请选择投保日期");
			return false;
		}else if(transdate(insureDate) > transdate(startDate)){
			alert("投保日期需早于或等于出险日期");
			return false;
		}
		if(insuranceInfo==""||insuranceInfo.length==0){
			alert("请填写购买险种名称及保额");
			return false;
		}else if(insuranceInfo.length>75){
			alert("公司名称长度最长为75位");
			return false;
		}
	}
	return true;
}
function choose(){
	var isInsure = $("#isInsure").val();
	if(isInsure=="Y"){
		$(".isInsureOrNo").show();
	}else if(isInsure=="N"){
		$(".isInsureOrNo").hide();
	}
}
function backshow(){
	choose();
	var sd = document.getElementById("geClaimManagement.startDate").value;//出险日期
	var id = document.getElementById("geClaimManagement.insureDate").value;//投保日期
	$("#startDate").val(sd);
	$("#insureDate").val(id);
	
}