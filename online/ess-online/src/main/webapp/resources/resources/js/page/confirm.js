
$(document).ready(function split(){
	
	$('#toInsureSubmit').on('click',function(){
		
		modal_loading();
		//校验通过后提交
		$.ajax({
			type:"POST",
			url:contentRootPath+"/msl/sales/insureShortPolicySubmit",
			data:{
				"policy.prodoctcode":"TATIANB02"
			},
			dataType:"json",
			success:function(data){
				 if(data.resultSuccess){
					 modal_loading('hide');
					//支付
					 window.location.href =contentRootPath+'/msl/sales/pay';
				 }else{
					 if(data.resultCode == 2000){
						 	if(data.resultDescription == null || data.resultDescription ==''){
						 		alert('核保异常');
						 	}else{
						 		alert(data.resultDescription);
						 	}
						   modal_loading('hide');
							return;
						}else{
							alert("系统繁忙：" + data.resultCode);
							modal_loading('hide');
							return;
						}
					   modal_loading('hide');
				 }
			}
		});
			modal_loading('hide');
		
	});

});