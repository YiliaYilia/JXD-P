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
var count = 120; //间隔函数，1秒执行
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
		modal_alert({content:'请输入正确的名字',btn:'返回修改'});
		return;
	}
	if(id == "" || !/^[0-9a-zA-Z]*$/g.test(id)){
		modal_alert({content:'请输入正确的证件号',btn:'返回修改'});
		return ;
	}
	if(idtype == ""){
		modal_alert({content:'请选择证件类型',btn:'返回修改'});
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












//本项目用不到


//function sendMessage(el){
//	
//	if(!canSend){
//		return;
//	}
//	var name = $('#customerName').val();
//	var id = $('#idNo').val();
//	var mobile = $('#mobile').val();
//	var reg = new RegExp("^[0-9]*$"); 
//	if(name == "" || name.length <2){
//		modal_alert({content:'请输入正确的名字',btn:'返回修改'});
//		return;
//	}
//	if(id == "" || !/^[0-9a-zA-Z]*$/g.test(id)){
//		modal_alert({content:'请输入正确的证件号',btn:'返回修改'});
//		return ;
//	}
//	if(mobile == "" || !/^0?1[3|4|5|8][0-9]\d{8}$/.test(mobile)){
//		modal_alert({content:'请输入正确的手机',btn:'返回修改'});
//		return ;
//	}
//	 curCount = count;
//	 //设置button效果，开始计时
////     $("#btnSendCode").attr("disabled", "true");
////     $("#btnSendCode").text(curCount+"秒后重新发送");
//	 modal_loading();
//     if(firstCheck == false){
//    	 $.ajax({
//    		 url:contentRootPath+"/repeatInvokeSMS",
//    		 data:{},
//    		 type:"POST",
//    		 dataType:"json",
//    		 async:true,
//    		 error:function(){
//    			 modal_alert({content:'系统繁忙：9001',
//    				 		  btn:'确定',
//    				 		  callback:function(){
//    				 			  	
//    				 		  }});
//    		 },
//    		 success:function(data){
//    			 if(data.resultCode == 2008){
// 					modal_alert({content:'长时间未进行操作，请重新进入',btn:'确定'});
// 					return;
// 				 }
//    			 if(data.resultCode == 9000){
//    				modal_alert({content:'系统繁忙：9000',btn:'确定'});
//    				return;
//    			 }
//    			 if(data.resultCode == 2102){
// 					modal_alert({content:'重新发送短信成功',btn:'确定'});
// 					sendSms();
//    			 }
//    			 modal_loading('hide');
//    		 }
//    	 });
//    	    
//     } else{
//    	 var mobile = $('#mobile').val().substr(7, 4);
//		$.ajax({
//			url:contentRootPath+"/authentication",
//			data:{"customer.customerName":$('#customerName').val(),
//				  "customer.idNo":$('#idNo').val(),
//				  "customer.mobile":$('#mobile').val()
//			},
//			type:"POST",
//			dataType:"json",
//			async:true,
//			error:function(data){
//				
//				modal_alert({content:'系统繁忙：9001',btn:'确定',
//			 		  		 callback:function(){
//			 			  	 
//			 		       }});
//			},
//			success:function(data){
//				if(data.resultCode == 9000){
//					modal_alert({content:'系统繁忙：9000',
//						 btn:'确定',
//					});
//					return;
//				}
//				if(data.resultCode == 2008){
//					modal_alert({content:'长时间未进行操作，请重新进入',btn:'确定'});
//					return;
//				}
//				if(data.resultCode == 9000){
//					modal_alert({content:'系统繁忙：9000',btn:'确定'});
//					return;
//				}
//				if(data.resultCode == 2009){
//					modal_alert({content:'系统繁忙：2009',btn:'确定'});
//					return;
//				}
//				if(data.resultCode == 2101){
//					var descriprtion = data.resultDescription;
//					var destript = descriprtion.replace("400-818-8888","<br/><a href='tel:4008188888'>400-818-8888</a>");
//					modal_alert({content:destript,btn:'确定'});
//					return;
//				}if(data.resultCode == 2002){
//					modal_alert({content:'身份认证成功，短信已经发送到尾号'+mobile+'的手机,请注意查收。若120秒内没有收到，请点击重新发送。',btn:'确定'});
//					 $("#customerName").attr("disabled", "true");
//					 $("#idNo").attr("disabled", "true");
//					 $("#mobile").attr("disabled", "true");
//					 $("#btnSendCode").attr("disabled", "true");
//				     $("#btnSendCode").text(curCount+"秒后重新发送");
//					firstCheck = false ;
//					sendSms();
//				}		
//				modal_loading('hide');
//			}
//		});
//	} 
//    
//}
//function SetRemainTime() {
//    if (curCount == 0) {                
//        window.clearInterval(InterValObj);//停止计时器
//        $("#btnSendCode").text("重新发送验证码");
//        $("#btnSendCode").removeClass('disable');
//        canSend = true;
//    }
//    else {
//        curCount--;
//        $("#btnSendCode").text(curCount+"秒后重新发送");
//    }
//}
//
//function sendSms(){
//	canSend = false;
//	$("#btnSendCode").addClass('disable');
//	$("#bindBtn").removeClass('disable');
//	InterValObj = window.setInterval(SetRemainTime, 1000);
//}
