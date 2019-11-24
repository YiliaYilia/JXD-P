var pop_ani_list = 
[{
	name:'ani-pop-in2',
	list:['ani-pop-in2-pop6','ani-pop-in2-pop7','ani-pop-in2-pop8','ani-pop-in2-pop9']
},{
	name:'ani-pop-out2',
	list:['ani-pop-out2-pop6','ani-pop-out2-pop7','ani-pop-out2-pop8','ani-pop-out2-pop9']
}];

$(document).ready(function(){
	
	doAnimation(0);
	
	setTimeout(function(){
		doAnimation(1);
		$('.pop-container').addClass('slide');
	},2000);
});

function doAnimation(step){
	var pops = $('.pop-item');
	
	pops.each(function(){
		var $this = $(this);
		var pop = $this.find('a');
		var ani = pop_ani_list[step];
		var index = $this.attr('data-index');
		pop.removeClass().addClass(ani.name).addClass(ani.list[index]);
	});
}

function clearAnimation(){
	var pops = $('.pop-item');
	
	pops.find('a').removeClass();
}


var InterValObj; //timer变量，控制时间
var count = 60; //间隔函数，1秒执行
var curCount;//当前剩余秒数
var firstCheck = true ; //是否是第一次点击
var canSend = true;
function insuredBinding(el){
	
	if($(el).hasClass('disable')){
		return;
	}
	
	var code = $('#validateCode').val();
	var name = $('#clientName').val();
	var id = $('#idNo').val();
	var idtype = $('#idType').val();
	var reg = new RegExp("^[0-9]*$" ); 
	if(name == "" || name.length <2){
		modal_alert({content:'请输入正确的名字',btn:'确定'});
		return;
	}
	if(id == "" || !/^[0-9a-zA-Z]*$/g.test(id)){
		modal_alert({content:'请输入正确的证件号',btn:'确定'});
		return ;
	}
	if(idtype == ""){
		modal_alert({content:'请选择证件类型',btn:'确定'});
		return ;
	}
	dosubmit();
	modal_loading();
	
//	$.ajax({
//		url:contentRootPath+"/bindingIdentity",
//		data:{"inputValidateCode":$('#validateCode').val(),
//			},
//		type:"POST",
//		dataType:"json",
//		async:true,
//		error:function(data){
//			modal_alert({content:'系统繁忙：9001',
//						 btn:'确定',
//						callback:function(){
//									
//						}});
//			
//		},
//		success:function(data){
//			if(data.resultCode == 2008){
//				modal_alert({content:'长时间未进行操作，请重新进入',btn:'确定'});
//				return;
//			}
//			if(data.resultCode == 9000){
//				modal_alert({content:'系统繁忙：9000',btn:'确定'});
//				return;
//			}
//			if(data.resultCode==2001){
//				modal_alert({content:'验证码输入有误，请重新输入',btn:'返回修改'});
//				return;
//			}
//			if(data.resultCode==2002){
//				modal_dialog('客户身份已经绑定，重新绑定将解除之前已绑定关系，是否继续操作？',function(){
//					$.ajax({
//			    		 url:contentRootPath+"/unbindIdentity",
//			    		 data:{},
//			    		 type:"POST",
//			    		 dataType:"json",
//			    		 async:true,
//			    		 error:function(){
//			    			 modal_alert({content:'系统繁忙：9001',
//			    				 		  btn:'确定',
//			    				 		  callback:function(){
//			    				 			  		
//			    				}});
//			    		 },
//			    		 success:function(data){
//			    			 if(data.resultCode == 2008){
//			 					modal_alert({content:'长时间未进行操作，请重新进入',btn:'确定'});
//			 					return;
//			 				 }
//			    			 if(data.resultCode == 9000){
//			    					modal_alert({content:'系统繁忙：9000',btn:'确定'});
//			    					return;
//			    			 }
//			    			 if(data.resultCode == 1000){
//			    				modal_alert({content:'重新绑定成功，欢迎您随时随地体验保单微服务',btn:'确定',callback:function(){
//				 					window.location.href = contentRootPath+"/service";
//			    				}});
//			    			 }if(data.resultCode == 2002){
//			    				 modal_dialog('客户身份已经绑定，重新绑定将解除之前已绑定关系，是否继续操作？',function(){
//			    						$.ajax({
//			    				    		 url:contentRootPath+"/unbindIdentity",
//			    				    		 data:{},
//			    				    		 type:"POST",
//			    				    		 dataType:"json",
//			    				    		 async:true,
//			    				    		 error:function(){
//			    				    			 modal_alert({content:'系统繁忙：9001',
//			    				    				 		  btn:'确定',
//			    				    				 		  callback:function(){
//			    				    				 			  		
//			    				    				}});
//			    				    		 },
//			    				    		 success:function(data){
//			    				    			 if(data.resultCode == 2008){
//			    				 					modal_alert({content:'长时间未进行操作，请重新进入',btn:'确定'});
//			    				 					return;
//			    				 				 }
//			    				    			 if(data.resultCode == 9000){
//			    				    					modal_alert({content:'系统繁忙：9000',btn:'确定'});
//			    				    					return;
//			    				    			 }
//			    				    			 if(data.resultCode == 1000){
//			    				    				modal_alert({content:'重新绑定成功，欢迎您随时随地体验保单微服务',btn:'确定',callback:function(){
//			    					 					window.location.href = contentRootPath+"/service";
//			    				    				}});
//			    				    			 }    			 
//			    				    		 }
//			    				    	 });
//			    		 			},function(){return;
//			    		 		});
//			    			 }	    			 
//			    		 }
//			    	 });
//	 			},function(){return;
//	 			});
//			}
//			if(data.resultCode==1000){
//				modal_alert({
//					content:'微绑定已成功，欢迎您随时随地体验保单微服务',
//					btn:'确定',
//					callback:function(){
//						window.location.href = contentRootPath+"/service";
//					}
//				});
//			}
//			modal_loading('hide');
//		}
//	});
}


function sendMessage(el){
	var mobile = "";
	var retcont = "";
	if(!checkNameAndNO()){
		return ;
	}else{
	  	var clientName = $("#clientName").val();
	  	var idNo = $("#idNo").val();
	  	var OpenID = $("#OpenID").val();
	  	var idType = $("#idType").val();
	  	var path = $("#path").val();
		$.ajax({
			type : "post",
			url :path+'/action/findPhone',
			dataType : "json",
			async : false,
			data : {
				"clientName" : clientName,
				"idNo" : idNo,
				"OpenID" : OpenID,
				"idType" : idType
			},
			success:function(data) {
				if(data.flag == "0"){
					mobile = data.content;
				}else{
					retcont = data.content;
				}
			}
		});
	}
	if(retcont != ""){
		modal_alert({content:retcont,btn:'确定'});
		return ;
	}
	var reg = new RegExp("^[0-9]*$"); 
	//|| !/^0?1[3|4|5|8][0-9]\d{8}$/.test(mobile)
	if(mobile.length!=11){
		if(mobile == "NON"){
			modal_alert({content:'很抱歉，您输入的投保人姓名或证件号码有误，请核实后再次输入。',btn:'确定'});
		} else {
			modal_alert({content:'您的证件号码或姓名输入有误，请核对后重新输入。',btn:'确定'});
		}
		return ;
	}
	
	if(!canSend){
		return;
	}
	
	 curCount = count;
	 //设置button效果，开始计时
     $("#btnSendCode").attr("disabled", "true");
     $("#btnSendCode").text(curCount+"秒后重新发送");
	 modal_loading();
     if(firstCheck == false){
    	 $.ajax({
  			type : "post",
  			url :path+'/action/sendRandomVcode',
  			dataType : "json",
  			async : false,
  			data : {
  				"mobile" : mobile
  			},
  			error:function(data){
  				modal_alert({content:'系统繁忙',btn:'确定',callback:function(){}});
 			},
  			success : function(data) {
  				if(data.resultCode == 2002){
  					modal_alert({content:'重新发送短信成功',btn:'确定'});
  					$("#hiddenvaldate").val(data.Vcode);
 					sendSms();
  				}else{
  					modal_alert({content:'系统繁忙',btn:'确定'});
  					return;
  				}
  			}
  		});	    
     } else{
    	 $.ajax({
 			type : "post",
 			url :path+'/action/sendRandomVcode',
 			dataType : "json",
 			async : false,
 			data : {
 				"mobile" : mobile
 			},
 			error:function(data){
				modal_alert({content:'系统繁忙',btn:'确定',callback:function(){}});
			},
 			success : function(data) {
 				if(data.resultCode == 2002){
 					 modal_alert({content:'身份认证成功，短信已经发送到号码'+mobile.substr(0,3)+'****'+mobile.substr(7,4)+'的手机,请注意查收。若60秒内没有收到，请点击重新发送。如有问题，可以拨打客服电话:4008109339 。',btn:'确定'});
					 $("#clientName").attr("disabled", "true");
					 $("#idNo").attr("disabled", "true");
					 $("#btnSendCode").attr("disabled", "true");
				     $("#btnSendCode").text(curCount+"秒后重新发送");
				     $("#hiddenvaldate").val(data.Vcode);
					 firstCheck = false ;
					 sendSms();
 				}else{
 					 modal_alert({content:'系统繁忙',btn:'确定'});
 					 return;
 				}
 			}
 		});
	} 
    
}
function SetRemainTime() {
    if (curCount == 0) {                
        window.clearInterval(InterValObj);//停止计时器
        $("#btnSendCode").text("重新发送验证码");
        $("#btnSendCode").removeClass('disable');
        canSend = true;
    }
    else {
        curCount--;
        $("#btnSendCode").text(curCount+"秒后重新发送");
    }
}

function sendSms(){
	canSend = false;
	$("#btnSendCode").addClass('disable');
	$("#bindBtn").removeClass('disable');
	InterValObj = window.setInterval(SetRemainTime, 1000);
}
