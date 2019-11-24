//取值计算对应的保障金
$(document).ready(function(){
	
	$('#saleMan').on('change',function(){
		var check = $(this).prop('checked');
		
		if(check){
			$('#saleManInfo').slideDown(400);
			$('#code').removeAttr('readonly');
		}else{
			$('#saleManInfo').slideUp(400);
			$('#code').attr('readonly','readonly');
			$('#code').val("");
		    $('#name').val("");
		    $('#address').val("");
		}
	});
	
	//查询营销员
	$('#code').on('blur',function(){
		findSaleMan();
	});
	
	//更新阅读告知状态
	$('#agree').on('click',function(){
		check() ;
	});
	//choose更新阅读告知修改订单中营销员编号
	$('#choose').on('click',function(){
		reservateSubmit() ;
	});
	//加载完毕默认勾选阅读告知
	$('#agree').trigger('click');
	
});

function reservateSubmit(){
	//阅读告知校验
	var check = $('#agree').prop('checked');
	if(check){
		var  code =$('#code').val();
		$('#inputcode').val(code) ;
		$('#formChoose').submit() ;
	}else{
		modal_alert("请接受阅读告知。") ;
		return ;
	}
}


function findSaleMan(){
	console.log("into  findSaleman");

    $('#name').val("");
    $('#address').val("");
	
	var code = $('#code').val();
	    code = code.replace(/\s/g,"");
	    
	    if(code==""||code==null){
	    	return ;
	    }
	 modal_loading();
	$.ajax({
		 url:contentRootPath + "/reservation/salesMan",
		 data:{"salesMan.code":code},
		 type:"POST",
		 async:true,
		 error:function(){
			modal_loading('hide');
		 },
		 success:function(data){
		   		if(data.resultSuccess){
				     $('#name').val(data.salesMan.name);
				     $('#address').val(data.salesMan.deptName);		   			
		   			console.log("查询营销员成功");
		   			modal_loading('hide');
					return;
			    }
			   if(data.resultCode == 2101){
				    modal_loading('hide');
//					校验不通过后的处理
					modal_alert(data.resultDescription);
					return;
				}
			        modal_loading('hide');
			        modal_alert("系统繁忙：" + data.resultCode);
			        return;		     
		 }
	 });
}
function check(){
	$.ajax({
		 url: contentRootPath + "/reservation/readConfirm",
		 data:{},
		 type:"POST",
		 async:true,
		 error:function(){

		 },
		 success:function(data){
		   		if(data.resultSuccess){
		   			console.log("修改阅读告知状态成功");
					//alert("修改阅读告知状态成功");
					return;
			    }
			   if(data.resultCode == 2101){
				   modal_alert(data.resultDescription);
					return;
				}
			   modal_alert("系统繁忙：" + data.resultCode);
			       return;		 
		 }
	 });
}  
