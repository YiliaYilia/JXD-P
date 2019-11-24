$(document).ready(function(){
	
	$('.confirm-list li:nth-child(2n)').addClass('even');
	
	$('#insureSubmit').on('click',function(){
		insureSubmit();
	});
	
	$('#back').on('click',function(){
		$("#back-from").submit();
	});
	
});

function insureSubmit(){
	modal_loading();
	$.ajax({
		   type:"POST",
		   url:contentRootPath+"/msl/sales/insureSubmit",
		   success:function(data){
			   console.log(data.resultCode);
			   var code=data.resultCode.trim();
			   if(code=="2011"){
				   modal_alert("姓名有误，请核实");
				   return;
			   }
			   if(code=="2012"){
				   modal_alert("被保人年龄小于18周岁");
				   return;
			   }
			   if(code=="2013"){
				   modal_alert("被保人年龄大于70周岁");
				   return;
			   }
			   if(code=="2014"){
				   modal_alert("请输入正确的手机号码");
				   return;
			   }
			   if(code=="2015"){
				   modal_alert("请输入正确的电子邮件地址");
				   return;
			   }
			   if(code=="2016"){
				   modal_alert("请输入正确的身份证号");
				   return;
			   }
			   if(code=="2017"){
				   modal_alert("请输入正确的保障起始日");
				   return;
			   }
		   		if(data.resultSuccess){
		   			window.location.href =contentRootPath+'/msl/sales/paymentOptions';
		   			modal_loading('hide');
					return;
			    }
			   if(data.resultCode == 2101){
				   modal_alert(data.resultDescription);
				   modal_loading('hide');
					return;
				}else{
					alert("系统繁忙：" + data.resultCode);
					modal_loading('hide');
					return;
				}
			   modal_loading('hide');
			}
		});
};