var d;
var start;

$(document).ready(function split(){
	
	window.fillForm = new Form($('#fillForm'));
	
	$('#fillForm').validator({
		timely:false,
		stopOnError :true,
		rules:{
			name:function(el){
				var name = el.value;
				
				if(name.length < 2||name.length>40){
					return false;
				}
				
				return this.test(el, 'cn_en');
			},
			indentifynumber:function(el){
				var id = el.value;
				if(id == '111111111111111'){
					return '请输入正确的身份证号码';
				}
				var isCard = validateCard(id);//身份证
				if(isCard === 'true'){
					return true;
				}else{
					return '请输入正确的身份证号码';
				}
			},
			select:function(el,params,field){
				var value = $(el).val();
				
				if(value == "-1"){
					return false;
				}
			},
			agree:function(el){
				return $(el).is(':checked');
			}
		},
		messages: {
			en_cn:'请输入正确的姓名',
			name:'请输入正确的姓名',
			select:'请选择{0}',
			date:'日期格式错误',
			mobile:'请输入正确的手机号码',
			agree:'请接受阅读告知'
		},
		fields:{
			'#name':					'投保人姓名:required,name',
			'#indentifynumber':	'身份证号码:required,indentifynumber',
			'#mobile':				'手机号码:required,mobile',
			'#email':					'电子邮件:required,email',
			'#areacodepro':		{display:'被保险人常住地',		must:true,		rule:'select'},
			'#sumpremium':		{display:'保险金额',				must:true,		rule:'select'},
			'#inputPeriodNum':		{display:'保险期间',				must:true,		rule:'select'},
			'#start':					'合同生效日:required,date',
			'#agree':					{display:'条款',					must:true,		rule:'agree'},
		},
		msgMaker:function(){
			return "";
		}
	}).on('valid.field', function(e, result, me){
//		校验通过后的处理
//		var $input = $(result.element);
//		$input.parents('.form-control').removeClass('has-error').addClass('has-success');
	}).on('invalid.field', function(e, result, me){
//		校验不通过后的处理
//		var $input = $(result.element);
//		$input.parents('.form-control').removeClass('has-success').addClass('has-error');
		modal_alert(result.msg);
	});
	
	$('#indentifynumber').on('blur',function(){
		echoCustomer();
	});
	$('#name').on('blur',function(){
		echoCustomer();
	});
	$('#toConfirm').on('click',function(){
		if(useragent.isWechat){
		echoCustomer(function(){
			toConfirm();
		});
		}else{
			toConfirm();
		}
			
//		toConfirm();
	});
	$('#inputPeriodNum').on('change',function(){
		changeinputPeriodNum();
	});
	$('#sumpremium').on('change',function(){
		changeinputPeriodNum();
	});
	$('#back').on('click',function(){
		back();
		$("#product-from").submit();
	});
	$('#topback').on('click',function(){
		back();
		$("#topproduct-from").submit();
	});

//	$('#start').on('change',function(){
//		changestart();
//	});
	
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
    	minDate: date.addDate('d',1),
    	maxDate: date.addDate('d',180),
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
	var productCode = $("#productCode").val();
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
		}
	});
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
	var productCode = $("#productCode").val();
	var name = $("#name").val();
	var identifynumber = $("#indentifynumber").val();
	var mobile = $("#mobile").val();
	var email = $("#email").val();
	var areacodepro = $("#areacodepro").val();
	var province = $("#areacodepro option:selected").text();
	var sumpremium = $("#sumpremium").val();
	var takeeffecttime = $("#start").val();
	
	var policyterm = $("#inputPeriodNum").val();
	var policytermList = policyterm.split('_');
	var policyterm1 = policytermList[0];
	var policytermtype = policytermList[1];
	
	var deadlinetime = $("#endtime").text();
	//var sumpremium1=sumpremium.substring(0,sumpremium.length-1);
	
	var sumbasepremium =  $("#sumbasepremium").text();
	
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
				"policy.policytermtype":					policytermtype,
				"applicantInsured.province":			province,
				"applicantInsured.name":				name,
				"applicantInsured.identifynumber":	identifynumber,
				"applicantInsured.mobile":				mobile,
				"applicantInsured.email":				email,
				"policy.sumamount":						sumpremium,
				"policy.takeeffecttime":					takeeffecttime,
				"policy.policyterm":						policyterm1,
				"policy.deadlinetime":					deadlinetime,
				"policy.areacodepro":					areacodepro,
				"policy.prodoctcode":					productCode,
				"policy.sumbasepremium":				sumbasepremium
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
	var productCode = $("#productCode").val();
	var name = $("#name").val();
	var identifynumber = $("#indentifynumber").val();
	var mobile = $("#mobile").val();
	var email = $("#email").val();
	var areacodepro = $("#areacodepro").val();
	var province = $("#areacodepro option:selected").text();
	var sumpremium = $("#sumpremium").val();
	var takeeffecttime = $("#start").val();
	
	var policyterm = $("#inputPeriodNum").val();
	var policytermList = policyterm.split('_');
	var policyterm1 = policytermList[0];
	var policytermtype = policytermList[1];
	
	var deadlinetime = $("#endtime").text();
//	var sumpremium1;
//	if(sumpremium==""){
//		sumpremium1="";
//	}else{sumpremium1=sumpremium.substring(0,sumpremium.length-1);}
	var sumbasepremium =  $("#sumbasepremium").text();
	var isBack = 1;
	$.ajax({
		type:"POST",
		url:contentRootPath+"/msl/sales/insureInput",
		data:{
			"policy.policytermtype":					policytermtype,
			"applicantInsured.province":			province,
			"applicantInsured.name":				name,
			"applicantInsured.identifynumber":	identifynumber,
			"applicantInsured.mobile":				mobile,
			"applicantInsured.email":				email,
			"policy.sumamount":						sumpremium,
			"policy.takeeffecttime":					takeeffecttime,
			"policy.policyterm":						policyterm1,
			"policy.deadlinetime":					deadlinetime,
			"policy.areacodepro":					areacodepro,
			"policy.prodoctcode":					productCode,
			"policy.sumbasepremium":				sumbasepremium,
			"isBack":                               isBack
		},
		dataType:"json",
		success:function(data){
			
		}
	});
}

//客户信息带出
function echoCustomer(callback){
	if(useragent.isWechat){
		var name = $('#name').val();
		var indentifynumber= $('#indentifynumber').val();
		if(indentifynumber==""){
				//alert("请填写身份证信息");
			   return;
		}
		if(name==""){
				//alert("请填写身份证信息");
			   return;
		}
		modal_loading();
		$.ajax({
		   type: "POST",
		   url: contentRootPath+"/msl/sales/echoCustomer",
		   data: "applicantInsured.name="+name+"&applicantInsured.identifynumber="+indentifynumber,
		   dataType:"json",
		   success:function(data){	
			   if(data.resultSuccess){
					var mobile = data.applicantInsured.mobile;
				    var email = data.applicantInsured.email;
				    $("#mobile").val(mobile);
					$("#email").val(email);
					modal_loading('hide');
					
					if(callback){
						callback();
					}
				   // alert("您的姓名与身份证号码与在本公司留存的信息不一致，请修改后继续投保");
					return;
			    } 
			   if(data.resultCode == '2101'){
		 		modal_alert({
	 			content:data.resultDescription,
	 			btn:'确定'
	 			});
		 		modal_loading('hide');
				    return;
				}
			    if(data.resultCode == '2012'){
			    	modal_loading('hide');
			    	if(callback){
						callback();
					}
			    	return;
				}
			    if(data.resultCode == '9000'){
			 		modal_alert({
			 			content:data.resultDescription,
			 			btn:'确定'
			 			});
			 		modal_loading('hide');
				  return;
				}
			    modal_loading('hide');
			    
			    return;
			}
		});
	};
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