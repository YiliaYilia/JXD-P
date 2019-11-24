$(document).ready(function (){
	calculatePrem(false);
	$('#inputPeriodTerm').on('change',function(){
		calculatePrem(true);
	});
	$('#inputPeriodNum').on('change',function(){
		calculatePrem(true);
	});
	$('#toInsure').on('click',function(){
		if(calculateFlag){
			$("#from").submit();
		}else{
			alert('保费试算不成功！');
		}
	});
});
var calculateFlag = false;
var reg = /^(?:[1-9]\d*|0)$/;
function validatePolicyTerm(policyTerm){
	if(!reg.test(policyTerm)){
		alert('保险期间输入有误！');
		return false;
	}else{
		if(policyTerm < 1 || policyTerm>30){
			alert('保险期间不得少于1天不得多于30天！');
			return false;
		}else{
			return true;
		}
	}
}

function validatePolicyNum(policyNum){
	if(!reg.test(policyNum)){
		alert('投保份数输入有误！');
		return false;
	}else{
		if(policyNum < 1 || policyNum>10){
			alert('投保份数不得少于1份不得多于10份！');
			return false;
		}else{
			return true;
		}
	}
}

function calculatePrem(isHide){
	var policyTerm = $("#inputPeriodTerm").val();
	var policyNum = $("#inputPeriodNum").val();
	if(policyTerm==''){
		alert('保险期间不得为空！');
	}if(policyNum==''){
		alert('投保份数不得为空！');
	}else{
		policyTerm = parseInt(policyTerm);
		policyNum = parseInt(policyNum);
		var policytermType = "D";
		if(validatePolicyTerm(policyTerm)&&validatePolicyNum(policyNum)){
			if(isHide){
				modal_loading();
			}
			$.ajax({
			   type:"POST",
			   url:contentRootPath+"/msl/sales/shortCalculate",
			   data:{
				   "policy.prodoctcode":"TATIANB02",
				   "policy.policyterm":policyTerm,
				   "policy.policytermtype":policytermType,
				   "policy.unitcount":policyNum,
				   "policy.sumamount":"350000"
			   },
			   dataType:"json",
			   success:function(data){
					var inputAmnt=Number(data.policy.sumbasepremium).toFixed(2);
				    var amntFormat=outputmoney(inputAmnt);
				    $("#sumbasepremium").text(amntFormat);
				    calculateFlag = true;
				    modal_loading('hide');
				}
			});
		}
	}
}

function outputmoney(number) {
	number = number.replace(/\,/g, "");
	if(isNaN(number) || number == ""){
		return "";
	}
	number = Math.round(number * 100) / 100;
    if (number < 0){
    	return '-' + outputdollars(Math.floor(Math.abs(number) - 0) + '') + outputcents(Math.abs(number) - 0);
    }
    else{
    	return outputdollars(Math.floor(number - 0) + '') + outputcents(number - 0);
    }
}

//格式化金额
function outputdollars(number) {
    if (number.length <= 3){
    	return (number == '' ? '0' : number);
    }else {
        var mod = number.length % 3;
        var output = (mod == 0 ? '' : (number.substring(0, mod)));
        for (var i = 0; i < Math.floor(number.length / 3); i++) {
            if ((mod == 0) && (i == 0)){
            	output += number.substring(mod + 3 * i, mod + 3 * i + 3);
            }
            else{
            	output += ',' + number.substring(mod + 3 * i, mod + 3 * i + 3);
            }
        }
        return (output);
    }
}

function outputcents(amount) {
    amount = Math.round(((amount) - Math.floor(amount)) * 100);
    return (amount < 10 ? '.0' + amount : '.' + amount);
}

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