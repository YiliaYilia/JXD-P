var d;
var start;

function getObj(id){
	return document.getElementById(id);
}

//投保人必填项验证
function policyHolderNullCheck(){
	if(getObj("name").value == ""){
		alert("投保人姓名为空!");
		getObj("name").focus();
		return false;
	}
	if(!checkName("name","投保人")){
		return false;
	}
	if(getObj("idtype").value == ""){
		alert("投保人证件类型为空!");
		getObj("idtype").focus();
		return false;
	}
	if(getObj("identifynumber").value == ""){
		alert("投保人证件号码为空!");
		getObj("identifynumber").focus();
		return false;
	}
	if(getObj("idtype").value == "A"){
		if(!checkIdno("identifynumber","idtype","birthday","age","sex","投保人","true")){
			return false;
		}
	}
	if(getObj("sex").value == ""){
		alert("投保人性别为空!");
		getObj("sex").focus();
		return false;
	}
	if(getObj("birthday").value == ""){
		alert("投保人出生日期为空!");
		getObj("birthday").focus();
		return false;
	}
	if(getObj("mobile").value == ""){
		alert("投保人手机号码为空!");
		getObj("mobile").focus();
		return false;
	}
	if(!checkCellphone("mobile","投保人")){
		return false;
	}
	if(getObj("email").value == ""){
		alert("投保人邮箱为空!");
		getObj("email").focus();
		return false;
	}
	if(!checkEmail("email","投保人")){
		return false;
	}
	if(getObj("zipcode").value == ""){
		alert("投保人邮编为空!");
		getObj("zipcode").focus();
		return false;
	}
	if(!checkZipcode("zipcode","投保人")){
		return false;
	}
	return true;
}

//姓名验证
function checkName(nameId,info){
	var name=getObj(nameId).value;
	var re = /(^([A-Za-z]+(\s*[A-Za-z]+)*)+$)|(^[\u4e00-\u9fa5]{1,10}$)/;
	if(!re.test(name)){
		alert(info+"姓名有误,请输入您的真实姓名!");
		getObj(nameId).focus();
		return false;
	}
	return true;
}

//证件号验证
function checkIdno(idnoId,idtypeId,birthdayId,age,sexName,info,tag){
	var idno=getObj(idnoId).value;
	var l=idno.length;
	var idtypeValue=getObj(idtypeId).value;
	if(l>50){
		alert(info+"证件号码不能大于50位,请重新填写!");
		getObj(idnoId).focus();
		return false;
	}
	if(idtypeValue != "" && idtypeValue == "A"){
		return checkIDNO(idnoId,idtypeId,birthdayId,age,sexName,info,tag);
	}else{
		getObj(idnoId).focus();
		return false;
	}
	return true;
}

//身份证号验证
function checkIDNO(idnoId,idtypeId,birthdayId,age,sexName,info,tag){
	var idno=getObj(idnoId).value;
	var IDbirthday = "";
	var IDsex = "";
	if(idno.length<=15){
		alert("请您准确填写有效二代身份证件号码（18位）");
		getObj(idnoId).focus();
		return false;
	}else {
		var month = idno.substring(10,12);
		var day =idno.substring(12,14);
		if(idno.substring(10,11)=='0'){
			month = idno.substring(11,12) ;
		}
		if(idno.substring(12,13)=='0'){
			day = idno.substring(13,14);
		}
		IDbirthday = idno.substring(6,10)+"年"+month+"月"+day+"日";
		IDsex = (parseInt(idno.substring(16,17))%2);
		if(IDsex == 1){
			IDsex = 'M';
		}else{
			IDsex = 'F';
		}
		IDage =  parseInt(new Date().getFullYear()) - parseInt(idno.substring(6,10));
	}
	
	var re = /^\d{15}(\d{2}(x|X|\d))?$/;
	if(tag == "true"){
		if(!re.test(idno)){
			alert("请输入正确的身份证件号码");
		    getObj(idnoId).focus();
		    return false;
		}else{
			if(checkAge(IDage,'投保人')){
				getObj(sexName).value=IDsex;
				getObj(birthdayId).value=IDbirthday;
				getObj(age).value= String(IDage);
			}
		}
	}if(tag == "sex"){
		if(getObj(sexName).value != IDsex){
			getObj(idnoId).value = "";
		}
	}if(tag == "birthday"){
		if(getObj(birthdayId).value != IDbirthday){
			getObj(idnoId).value = "";
		}
	}
 	return true;
}


function checkAge(age,info){
	value = parseInt(age);
	if(value<18 || value>65){
		alert(info+"须在18-65周岁，否则不能投保!");
		return false;
	}else{
		return true;
	}
}

//手机号码验证
function checkCellphone(cellphoneId,info){
	 var phone=getObj(cellphoneId).value;
	 var re1 = /^1[0-9]{10}$/;
  	 if(re1.test(phone)){
 		 return true;
 	 }else{
 		 alert("请输入正确的手机号码");
 		 getObj(cellphoneId).focus();
		 return false;
 	 }
}

//电子邮箱验证
function checkEmail(emailId,info){
  	var email=getObj(emailId).value;
	var re = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	if(re.test(email)){
		return true;
	}else{
		alert("电子邮箱有误,请核对后输入!");
		getObj(emailId).focus();
		return false;
	}
}

//邮政编码验证
function checkZipcode(zipCode,info){
  	var zipcode=getObj(zipCode).value;
  	var re= /^[1-9][0-9]{5}$/;
	if(re.test(zipcode)){
		return true;
	}else{
		alert("邮政编码有误,请核对后输入!");
		getObj(zipCode).focus();
		return false;
	}
}
//日期合法性验证
function checkDate(dateId,info){
	var dateValue=getObj(dateId).value;
	var r=/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;
	var date = dateValue.match(r);
	if(date==null){
		alert(info+"出生日期不合法!");
		getObj(dateId).focus();
		return false;
	}
	var birthday= new Date(date[1], date[3]-1, date[4]);
	if(!(birthday.getFullYear()==date[1]&&(birthday.getMonth()+1)==date[3]&&birthday.getDate()==date[4])){
		alert(info+"出生日期不合法!");
		getObj(dateId).focus();
		return false;
	}
	if(birthday>new Date()){
		alert(info+"出生日期大于当前日期!");
		getObj(dateId).focus();
		return false;
	}
	return true;
}

$(document).ready(function split(){
	
	$('#identifynumber').on('change',function(){
		if(getObj("idtype").value == "A"){
			if(!checkIdno("identifynumber","idtype","birthday","age","sex","投保人","true")){
				return false;
			}
		}
	});
	
	$('#sex').on('change',function(){
		if(getObj("idtype").value == "A"){
			if(!checkIDNO("identifynumber","idtype","birthday","age","sex","投保人","sex")){
				return false;
			}
		}
	});
	
	$('#birthday').on('change',function(){
		if(getObj("idtype").value == "A"){
			if(!checkIDNO("identifynumber","idtype","birthday","age","sex","投保人","birthday")){
				return false;
			}
		}
	});
	
	$('#toConfirm').on('click',function(){
		if(!policyHolderNullCheck()){
			return false;
		}else{
			var name = $("#name").val();
			var relationship = $("#relationship").val();
			var idtype = $("#idtype").val();
			var identifynumber = $("#identifynumber").val();
			var sex = $("#sex").val();
			var birthday = $("#birthday").val();
			var mobile = $("#mobile").val();
			var email = $("#email").val();
			var province = $("#province").val();
			var city = $("#city").val();
			var zipcode = $("#zipcode").val();
			var advisorcode = $("#advisorcode").val();
			var advisorname = $("#advisorname").val();
				modal_loading();
				//校验通过后提交
				$.ajax({
					type:"POST",
					url:contentRootPath+"/msl/sales/insureShortPolicyConfirm",
					data:{
						"applicantInsured.name":				name,
						"applicantInsured.insrelationapp":      relationship,
						"applicantInsured.identifytype":        idtype,
						"applicantInsured.identifynumber":		identifynumber,
						"applicantInsured.sex":					sex,
						"applicantInsured.birthday":			birthday,
						"applicantInsured.mobile":				mobile,
						"applicantInsured.email":				email,
						"applicantInsured.province":			"110100",
						"applicantInsured.city":			"110100",
						"applicantInsured.zipcode":			zipcode,
						"policy.agentcode":			advisorcode,
						"policy.agentname":		    advisorname
					},
					dataType:"json",
					success:function(data){
						 if(data.resultSuccess){
							 modal_loading('hide');
							 window.location.href =contentRootPath+'/msl/sales/insureShortPolicyNotice';
						 }else{
							 modal_loading('hide');
						 }
					}
				});
					modal_loading('hide');
		}
	});
	
	var date = new Date();
	var systemTime = $("#systemTime").val();
	var start1 = $("#start1").val();
	$('#start').scroller({
    	preset: 'date',
    	headerText: '请选择日期',
    	theme: 'android',
    	display: 'modal',
    	"width": 130,
		"height": 90,
    	mode: 'scroller',
    	dateOrder: 'yy mm dd',
    	setText: '确定',
    	cancelText: '取消',
    	minDate: date.addDate('d',-100*365),
    	maxDate: date.addDate('d',0),
    	formatResult: function(d){
    		$('#start').data('rdate',d);
    		return dateFormat(d);
    	},
    	onSelect:function(){
    		changestart();
		}
    });
	initDate1 = date.parseDate(systemTime);
	start1 = date.parseDate(start1);
	var initDate;
    var isBack = $("#isBack").val();
    if(isBack==0){
    	initDate = initDate1.addDate('d',1);
    }else{
    	initDate = start1;
    }
    $('#start').val(initDate.formatDate('yyyy年MM月dd日'));
    var dateList = [];
    dateList.push(initDate.getFullYear());
    dateList.push(initDate.getMonth());
    dateList.push(initDate.getDate());
    $('#start').data('rdate',dateList);
    changestart();

	var payPeriodNumber = $("#inputPeriodNum").val().split('_');
	var policyterm1=payPeriodNumber[0];
	var policytermtype = payPeriodNumber[1];
	var sumpremium = $("#sumpremium").val();
	var str;
	if(policytermtype=='年'){
		str = (d.getFullYear()+parseInt(policyterm1))+"年"+(d.getMonth()+1)+"月"+(d.getDate())+"日";
		$("#endtime").text(str);
	}
	if(policytermtype=='天'){
		d = +d + policyterm1*(1000*60*60*24);
		d = new Date(d);
		var month = d.getMonth()+1;
		var day = d.getDate();
		str = (d.getFullYear())+"年"+month+"月"+day+"日";
		$("#endtime").text(str);
	}

});

function changestart(){
	var startDate = $('#start').data('rdate');
	
	var policyterm = $("#inputPeriodNum").val();
	var policytermList = policyterm.split('_');
	var policyterm1 = policytermList[0];
	var policytermtype = policytermList[1];
	
	var endDate = new Date(startDate[0],startDate[1],startDate[2]);
	
	if(policytermtype === 'Y'){
		endDate = endDate.addDate('y',policyterm1);
	}
	if(policytermtype === 'M'){
		endDate = endDate.addDate('m',policyterm1);
	}
	if(policytermtype === 'D'){
		endDate = endDate.addDate('d',policyterm1);
	}
	
	$("#endtime").text(dateFormatNum(endDate.getFullYear(),endDate.getMonth() + 1,endDate.getDate()));
}


var dateFm = ['年','月','日'];

function dateFormat(d){
	var out = '';
	for (var i = 0; i < d.length; i++) {
		var n = d[i];
		if(i == 1 || i == 2){
			if(i == 1){
				n++;
			}
			if(n < 10){
				n = '0'+n;
			}
		}
		out += n + dateFm[i];
	}
	return out;
}
function dateFormatNum(y,m,d){
	var out = '';
	out += y + dateFm[0];
	out += m + dateFm[1];
	out += d + dateFm[2];
	return out;
}

