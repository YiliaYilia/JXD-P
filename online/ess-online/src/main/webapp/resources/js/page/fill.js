var d;
var start;

function getObj(id){
	return document.getElementById(id);
}

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
var idCardFlag=false;
//身份证格式校验
function validationIdCard(idnoId){
	var idno=getObj(idnoId).value;
	 $.ajax({
		   type:"POST",
		   async:false,
		   url:contentRootPath+"/action/validationIdCard",
		   data:"idNum="+idno,
		   dataType:"json",
		   success:function(data){
//			   alert(data.resultFlag);
			   if(data.resultFlag=="1"){
				   idCardFlag=true;
			   }else{
				   idCardFlag=false;
			   }
			},
			error:function(data){
				 idCardFlag=false;
			}
		});   
}

//根据身份证号获取性别
function getSexFromCard(idnumber){
	if (idnumber.length == 18) {
		sex = idnumber.charAt(16);
		if (sex % 2 == 0) {
			return  "F";
		} else {
			return "M";
		}
	} else {
		sex = idnumber.charAt(14);
		if (sex % 2 == 0) {
			return "F";
		} else {
			return "M";
		}
	}

}
var birthDateStr;
//根据身份证号获取出生日期
function  getBirthDateByIdCard(idno){
	$.ajax({
		   type:"POST",
		   async:false,
		   url:contentRootPath+"/action/getBirthDateByIdCard",
		   data:"idNum="+idno,
		   dataType:"json",
		   success:function(data){
			   if(data.resultFlag=="1"){
				   birthDateStr=data.birthDateStr;
			   }
			   else{
				   birthDateStr="";
			   }
			},
			error:function(data){
//				 alert("data.resultFlag error=="+data.resultFlag);
				 birthDateStr="";
			}
		});  
	
}

//校验性别与 身份证是否相符
function validationIdCardSex(idnoId,sexName){
   var idno=getObj(idnoId).value;
   if(getObj(sexName).value!=getSexFromCard(idno)){
	   return false;
   }
   return true;
   
} 

//校验出生日期是否与身份证相符
var validIdCardFlag=false;
function  validationIdCardBirthDate(idnoId,birthDate){
   var _idno=getObj(idnoId).value;
//   alert("birthDate=="+birthDate);
   $.ajax({
	   type:"POST",
	   async:false,
	   url:contentRootPath+"/action/validationIdCardBirthDate",
	   data:{
		   "idNum":_idno,
		   "birthDate":birthDate
	   },
	   dataType:"json",
	   success:function(data){
//		   alert("birthDate=="+data.resultFlag);
		   if(data.resultFlag=="1"){
			   validIdCardFlag=true;
		   }
		   else{
			   validIdCardFlag=false;
		   }
		},
		error:function(data){
			validIdCardFlag=false;
		}
	});  
}


//投保人必填项验证
function policyHolderNullCheck(){
	if(getObj("name").value == ""){
		alert("投保人姓名为空!");
		getObj("name").focus();
		return false;
	}else if(getObj("name").value.length<2||getObj("name").value.length>10){
		alert("请输入有效的投保人姓名");
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
//		if(!validationIdCard("identifynumber","idtype","birthday","age","sex","投保人","true")){
//			return false;
//		}else{
//			var idNo = getObj("identifynumber").value;
			var birthday = $("#year").val()+"-"+$("#mon").val()+"-"+$("#day").val();
//			var idBr =  getBirth(idNo);
//			if(idBr!=birthday){
//				alert("身份证与出生日期不符");
//				return false;
//			}
//		}
		
		validationIdCard("identifynumber");
		if(!idCardFlag){
			alert("投保人身份证录入错误");
			return false;
		}
		else{
			if(!validationIdCardSex("identifynumber","sex")){
		    	alert("投保人性别与身份证不符");
		    	return false;
		    }
			validationIdCardBirthDate("identifynumber",birthday);
//			alert(validIdCardFlag);
			if(!validIdCardFlag){
		    	alert("投保人出生日期与身份证不符");
		    	return false;
		    }
		}
		
	}
	if(getObj("sex").value == ""){
		alert("投保人性别为空");
		getObj("sex").focus();
		return false;
	}
	var birthday = $("#year").val();
	var age =  parseInt(new Date().getFullYear()) - parseInt(birthday);
	if(birthday == ""){
		alert("投保人出生日期为空");
		return false;
	}else if(age<18||age>65){
		alert("投保人年龄须在18-65周岁，否则不能投保");
		return false;
	}
	var br = $("#year").val()+"-"+$("#mon").val()+"-"+$("#day").val();
	var deadlinetime = '${deadlinetime}';
	age = getage(br,deadlinetime);
	if(age<18||age>65){
		alert("投保人截止日时投保人的年龄须在65周岁以内，否则不能投保");
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
	if(!checkAdvisorcode("advisorcode","推荐人编码")){
		return false;
	}
	var re3 = /^([\u4e00-\u9fa5]|[a-zA-Z0-9])+$/;
//	var province = document.getElementById("province").value;
//	var address = document.getElementById("showAaddress").value;
//	if(address.length==0||address==""){
//		alert("请输入您的通讯地址");
//		return false;
//	}else if(address.length<3||address.length>30){
//		alert("请输入有效的通讯地址"); 
//		return false;
//	}else if(!re3.test(address)){
//		alert("请输入有效的通讯地址");
//		return false;
//	}else if(province=="省/市"){
//		alert("请输入有效的通讯地址");
//		return false;
//	}
//	
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

//其它证件类型验证
function check(value,type){
	var result="";
	var length=value.length;
	if(type=="B"){
		if(length <3){
			alert('护照号码不得小于3个字符');
			return false;
		}
	}
	if(type=="Q"){
		if(length <8){
			alert('港澳回乡证号码不得小于8个字符');
			return false;
		}
	}
	if(type=="K"){
		if(length <8){
			alert('台胞证号码不得小于8个字符');
			return false;
		}
	}
	if(type=="H"){
		if(length <3){
			alert('出生证号码不得小于3个字符');
			return false;
		}
	}
	if(type=="C"||type=="L"){
		if(length <10||length >18){
			alert('军官证或士兵证号码应在10到18个字符之间');
			return false;
		}
	}
	return true;
}

	//证件号格式校验及根据正确的身份证号赋值性别,出生日期
	function checkIdNoAndSetValue(idnoId,idtypeId,birthdayId,sexName,flag){
		var idno=getObj(idnoId).value;
		var l=idno.length;
		var idtypeValue=getObj(idtypeId).value;
		if(l>50){
			alert(info+"证件号码不能大于50位,请重新填写!");
			getObj(idnoId).focus();
			return false;
		}
		if(idtypeValue != "" && idtypeValue == "A"){
			  //身份证格式正确,赋值出日期 和性别
			validationIdCard(idnoId);
			if(idCardFlag){
			    getObj(sexName).value=getSexFromCard(idno);
			    //设置出生日期
			    getBirthDateByIdCard(idno);
			    getObj(birthdayId).value=birthDateStr;
			    return true;
			}
			else{
				alert(flag+"身份证录入错误");
				getObj(idnoId).focus();
				return false;
			}
		}
	}

    
	
	
//身份证号验证
function checkIdNumber(idnoId,idtypeId,birthdayId,age,sexName,info,tag){/*
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
*/}


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
	 var re1 = /^(13|14|15|17|18)[0-9]{9}$/;
  	 if(re1.test(phone)){
 		 return true;
 	 }else{
 		 alert("请输入正确的手机号码");
 		 getObj(cellphoneId).focus();
		 return false;
 	 }
}

//电子邮箱验证
function checkEmail(emailId){
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

//推荐人编码校验
function checkAdvisorcode(advisorcodeId){
	var agentCode = getObj(advisorcodeId).value;
	var reg = /^[a-zA-Z0-9]+$/;
	if(agentCode!="" || agentCode.length!=0){
		if(!reg.test(agentCode)){
			alert("推荐人编码为5~15位的字母和数字，请重新输入！");
			return false;
		}else if(agentCode.length>15||agentCode.length<5){
			alert("推荐人编码为5~15位的字母和数字，请重新输入！");
			return false;
		}else{
			checkDepart();
			var deptidFlag = $("#deptidFlag").val();
			if(deptidFlag=='1'){
				return false;
			}else{
				return true;
			}
		}
	}else
	{return true;}
}
//根据投保人的出生日期与投保的截止日期计算投保人在截止日期的时候的年龄
function getage(br,last)   
{   
      var r = br.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);     
      if(r==null)return   false;     
      var d = new Date(r[1],r[3]-1,r[4]);
      if(d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]){   
    	  var Y  = new Date(Date.parse(last)).getFullYear();   
    	  return (Y-r[1]);
      }else{
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
//			if(!validationIdCard("identifynumber","idtype","birthday","age","sex","投保人","true")){
//				return false;
//			}
			if(!checkIdNoAndSetValue("identifynumber","idtype","birthday","sex","投保人")){
				return false;
			}
		}
	});
	
	$('#sex').on('change',function(){
		if(getObj("idtype").value == "A"){
//			if(!("identifynumber","idtype","birthday","age","sex","投保人","sex")){
//				return false;
//			}
//			if(!checkIdNumber("identifynumber","idtype","birthday","age","sex","投保人","sex")){
//				return false;
//			}
			//性别修改后与身份证校验
		    if(!validationIdCardSex("identifynumber","sex")){
		    	alert("投保人性别与身份证不符");
		    	return false;
		    }
		}
	});
	
	$('#birthday').on('change',function(){
		if(getObj("idtype").value == "A"){
//			if(!checkIdNumber("identifynumber","idtype","birthday","age","sex","投保人","birthday")){
//				return false;
//			}
			//出生日期修改后与身份证校验
			var _birthday = $("#year").val()+"-"+$("#mon").val()+"-"+$("#day").val();
			validationIdCardBirthDate("identifynumber",_birthday);
			alert(validIdCardFlag);
			if(!validIdCardFlag){
		    	alert("投保人出生日期与身份证不符");
		    	return false;
		    }
		}
	});
	
	
	//投保方法
	$('#toConfirm').on('click',function(){
		if(!policyHolderNullCheck()){
			return;
		}else{
			var name = $("#name").val();
			var relationship = $("#relationship").val();
			var idtype = $("#idtype").val();
			var identifynumber = $("#identifynumber").val();
			var sex = $("#sex").val();
			var birthday = $("#year").val()+"-"+$("#mon").val()+"-"+$("#day").val();
			var mobile = $("#mobile").val();
			var email = $("#email").val();
//			var province = $("#province").val();
//			var city = $("#city").val();
			var zipcode = $("#zipcode").val();
			var advisorcode = $("#advisorcode").val();
			var advisorname = $("#advisorname").val();
//			var showAddress = $("#address").html();
//			var address = document.getElementById("showAaddress").value;
			var deptid = $("#deptid").val();
//			address=showAddress+address;
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
//						"applicantInsured.province":			"110100",
//						"applicantInsured.city":			"110100",
						"applicantInsured.zipcode":			zipcode,
//						"applicantInsured.address":			address,
						"policy.agentcode":			advisorcode,
						"policy.deptid":              deptid,
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
	
	$('#toGratisConfirm').on('click',function(){
		
		if(!policyHolderNullCheck()){
			return false;
		}else{
			var name = $("#name").val();
			var relationship = $("#relationship").val();
			var idtype = $("#idtype").val();
			var identifynumber = $("#identifynumber").val();
			var sex = $("#sex").val();
			var birthday = $("#year").val()+"-"+$("#mon").val()+"-"+$("#day").val();
			var mobile = $("#mobile").val();
			var email = $("#email").val();
			//var province = $("#province").val();
			//var city = $("#city").val();
			var zipcode = $("#zipcode").val();
			var advisorcode = $("#advisorcode").val();
			var advisorname = $("#advisorname").val();
			var deptid = $("#deptid").val();
				modal_loading();
				//校验通过后提交
				$.ajax({
					type:"POST",
					url:contentRootPath+"/msl/sales/insureGratisPolicyConfirm",
					data:{
						"applicantInsured.name":				name,
						"applicantInsured.insrelationapp":      relationship,
						"applicantInsured.identifytype":        idtype,
						"applicantInsured.identifynumber":		identifynumber,
						"applicantInsured.sex":					sex,
						"applicantInsured.birthday":			birthday,
						"applicantInsured.mobile":				mobile,
						"applicantInsured.email":				email,
//						"applicantInsured.province":			"110100",
//						"applicantInsured.city":			"110100",
						"applicantInsured.zipcode":			zipcode,
//						"applicantInsured.address":			"",
						"policy.agentcode":			advisorcode,
						"policy.deptid":              deptid,
						"policy.agentname":		    advisorname
					},
					dataType:"json",
					success:function(data){
						 if(data.resultSuccess){
							 modal_loading('hide');
							 window.location.href =contentRootPath+'/msl/sales/insureGratisPolicyNotice';
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

function checkDepart(){
	var agentCode = document.getElementById("advisorcode").value;
	if(agentCode!=null&&agentCode.length>0){
		 $.ajax({
			   type:"POST",
			   url:contentRootPath+"/msl/sales/existDepart",
			   data:"agentCode="+agentCode,
			   dataType:"json",
			   async:false,
			   success:function(data){
				   if(data.flag=="0"){
					   document.getElementById("deptid").value=data.content;
					   document.getElementById("deptidFlag").value="0";
				   }else if(data.flag=="1"){
				   document.getElementById("deptidFlag").value="1";
				   alert(data.content);
				   }
				}
			});   
	}
	
}

