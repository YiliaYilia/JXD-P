$(document).ready(function (){
//	calculatePrem(false);
//	$('#inputPeriodTerm').on('change',function(){
//		calculatePrem(true);
//	});
	$('#inputPeriodNum').on('change',function(){
		calculatePrem(true);
	});
	
	$('#toInsure').on('click',function(){
		if(compute()){
			$("#form").submit();
		}
		
	});
});
var calculateFlag = false;
var reg = /^(?:[1-9]\d*|0)$/;


//试算保费
function calculatePrem(isHide){
	var policyTerm = $("#inputPeriodTerm").val();
	var policyNum = $("#inputPeriodNum").val();
//	var takeeffecttime = $("#year").val()+"-"+$("#mon").val()+"-"+$("#day").val();//取得开始日期
//	var deadlinetime = $("#year1").val()+"-"+$("#mon1").val()+"-"+$("#day1").val();//取得结束日期
	var takeeffecttime = $("#start").val().replace("年","-").replace("月","-").replace("日","");//取得开始日期
	var deadlinetime = $("#end").val().replace("年","-").replace("月","-").replace("日","");//取得结束日期
	//alert(takeeffecttime);
	//alert(deadlinetime);
	policyTerm = parseInt(policyTerm);
	policyNum = parseInt(policyNum);
	var policytermType = "D";
		if(isHide){
			modal_loading();
		}
	$.ajax({
	   type:"POST",
	   url:contentRootPath+"/msl/sales/shortCalculate",
	   data:{
		   "policy.prodoctcode":"TATIANB02",
		   "policy.policyterm":policyTerm,
		   "policy.takeeffecttime":takeeffecttime,
		   "policy.deadlinetime":deadlinetime,
		   "policy.policytermtype":policytermType,
		   "policy.unitcount":policyNum,
		   "policy.sumamount":350000*policyNum
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