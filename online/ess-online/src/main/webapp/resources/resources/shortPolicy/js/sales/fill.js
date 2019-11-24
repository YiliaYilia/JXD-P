var d;
var start;

function changeinputPeriodNum(){
	
	var policyterm = $("#inputPeriodNum").val();
	var policytermList = policyterm.split('_');
	var policyterm1 = policytermList[0];
	var policytermtype = policytermList[1];
	var sumpremium = $("#sumpremium").val();
	var productCode = $("#productCode").val();
	
	changestart();
	modal_loading();
	$.ajax({
	   type:"POST",
	   url:contentRootPath+"/msl/sales/calculate",
	   data:{
		   "policy.prodoctcode":productCode,
		   "policy.policyterm":policyterm1,
		   "policy.policytermtype":policytermtype,
		   "policy.sumamount":sumpremium
	   },
	   dataType:"json",
	   success:function(data){
			var inputAmnt=Number(data.policy.sumbasepremium).toFixed(2);
		    var amntFormat=outputmoney(inputAmnt);
		    $("#sumbasepremium").text(amntFormat);
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

function toConfirm(){
	var productCode = $("#productCode").val();//
	var name = $("#name").val();//投保人姓名
	var relation = $("#relation").val();//与被保人关系
	var idTye = $("#idType option:selected").text();//证件类型
	var identifynumber = $("#indentifynumber").val();//证件号码
	var gender = $("#gender").val();
	var brithday = $("#brithiday").val();
	var mobile = $("#mobile").val();
	var email = $("#email").val();
	var citycode = $("#city option:selected").text();//默认第一行省对应第一行市
	var zipcode = $("#zipcode");
	$('#fillForm').validSubmit(function(valid){
		//校验不通过返回
		if(!valid){
			return;
		}
		
		modal_loading();
		//校验通过后提交
		
		$.ajax({
			type:"POST",
			url:contentRootPath+"/msl/sales/insureInput",
			data:{
				"policy.productCode":					productCode,
				"applicantInsured.name":				name,
				"applicantInsured.relation":				relation,
				"applicantInsured.idTye":					idTye,
				"applicantInsured.identifynumber":			identifynumber,
				"applicantInsured.gender":					gender,
				"applicantInsured.brithday":				brithday,
				"applicantInsured.mobile":					mobile,
				"applicantInsured.email":					email,
				"applicantInsured.citycode":				citycode,
				"applicantInsured.zipcode":					zipcode,
			},
			dataType:"json",
			success:function(data){
				 if(data.resultSuccess){
					 modal_loading('hide');
					 window.location.href =contentRootPath+'/msl/sales/insureConfirm';
				 }if(data.resultCode == '9000'){
					 modal_loading('hide');
				 		modal_alert({
				 			content:data.resultDescription,
				 			btn:'确定'
				 			});
				 		modal_loading('hide');
					  return;
					}
				
			}
		});
			modal_loading('hide');
		
	});
}

//录入页返回到产品介绍页
function back(){
	var effDate = $("#effDate").val();
	var periodStart = $("#periodStart").val();
	var periodEnd = $("#periodEnd").val();
	var period = $("#period").val();
	var copies = $("#copies").val();
	var premSum = $("#premSum").val();
	
	var isBack = 1;
	$.ajax({
		type:"POST",
		url:contentRootPath+"/msl/sales/insureInput",
		data:{
			"policy.effDate":					effDate,
			"policy.periodStart":				periodStart,
			"policy.periodEnd":					periodEnd,
			"policy.period":					period,
			"policy.copies":					copies,
			"policy.premSum":					premSum,
			"isBack":                           isBack
		},
		dataType:"json",
		success:function(data){
			
		}
	});
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