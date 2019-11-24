function radioChange(){
		var type=$("input[name='radioPayType']:checked").val();
		if("10" == type){
			$('#payInfoImg').attr('src',contentRootPath+'/resources/image/common/icon-wechat.png');
			$('#payInfoSpan').text("微信客户端支付");
		}else if("11" == type){
			$('#payInfoImg').attr('src',contentRootPath+'/resources/image/common/icon-wechat.png');
			$('#payInfoSpan').text("微信客户端支付");
		}else if("20" == type){
			$('#payInfoImg').attr('src',contentRootPath+'/resources/image/common/icon-alipay.png');
			$('#payInfoSpan').text("支付宝");
		}else if("21" == type){
			$('#payInfoImg').attr('src',contentRootPath+'/resources/image/common/icon-alipay.png');
			$('#payInfoSpan').text("支付宝");
		}else if("22" == type){
			$('#payInfoImg').attr('src',contentRootPath+'/resources/image/common/icon-bank.png');
			$('#payInfoSpan').text("网银快捷支付");
		}
	}
$(document).ready(function(){
	if("2022"== resultCode){
		$('#payResult').modal();
	}
	
	//完成支付
	$('#finishPay').on('click.dismiss.modal',function(){
		modal_loading();
		$.ajax({
		   type:"POST",
		   url:contentRootPath+"/msl/sales/paySuccess",
		   dataType:"json",
		   success:function(data){
			  if("success" != data.succeed){
				  modal_alert('您还未成功支付，请选择其他支付方式进行支付',function(){
			 			$.ajax({
						   type:"POST",
						   url:contentRootPath+"/msl/sales/payOthers",
						   dataType:"json",
						   success:function(data){
							   modal_loading('hide');
								   window.location.href =contentRootPath+'/sales/paymentOptions';
							}
						});
		 			});
				  return;
			    }
			 //承保成功
			  window.location.href =contentRootPath+'/sales/waiting';
		   }
		});
	});
	
	//选择其他支付方式
	$('#changePayType').on('click.dismiss.modal',function(){
		modal_loading();
		$.ajax({
		   type:"POST",
		   url:contentRootPath+"/msl/sales/payOthers",
		   dataType:"json",
		   success:function(data){
			   modal_loading('hide');
			   if("2023"==data.resultCode){
				   modal_alert('您已支付成功',function(){
					   window.location.href =contentRootPath+'/sales/waiting';
		 			});
				   return;
			   }
				   window.location.href =contentRootPath+'/sales/paymentOptions';
			}
		});
	});
	
	//二维码支付
	$('#finishPayQRCode').on('click.dismiss.modal',function(){
		$('#finishPay').trigger('click');
	});
	
	$('#changePayTypeQRCode').on('click.dismiss.modal',function(){
		$('#changePayType').trigger('click');
	});
	
	//网银支付
	$('#bankConfirmPay').on('click.dismiss.modal',function(){
		var bankCode=$("input[name='paybank']:checked").val();
		$("#hiddenbankCode").val(bankCode);
		$('#payResult').modal();
		$('#insureForm').submit();
		
	});
	
	$('#changePayTypeBank').on('click.dismiss.modal',function(){
	});
	
	//确认支付
	$('#insureButton').on(tap,function(){
		modal_loading();
		var payType=$("input[name='radioPayType']:checked").val();
		
		if(payType==""  ||  null==payType){
			modal_alert('请选择支付方式');
			return;
		}
		$("#hiddenPayType").val(payType);
		if("11"==payType){
			//扫码支付
			$('#qrcodeImg').attr('src',contentRootPath+'/sales/QRCodeInit');
			$('#QRCode').modal();
			return;
		}else if("21"==payType){
			//支付宝手机网页支付
			$('#insureForm').removeAttr("target");
			modal_loading('hide');
			$('#insureForm').submit();
			return;
		}else if("22"==payType){
			modal_loading('hide');
			$('#bankChoose').modal()
		}else{
			$('#payResult').modal();
			modal_loading('hide');
			$('#insureForm').submit();
			return;
		}
		
	});
}); 