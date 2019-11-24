$(function(){
	cur = 1;
	setTimeout('init()',3000);
})
function init(){
	var page_wrap=$('#page-wrap');
	var pages = page_wrap.find('>.page');
	var total = pages.length;
	//当前页
	for(var i=1;i<=pages.length;i++){
		$(".page"+i).swipe({
			swipe:function(event,direction){
				if("up" == direction && cur < 3){
					cur +=1;
					$(this).removeClass("active");
					$(".page"+cur).addClass("active");
				}
				if("down" == direction && cur > 1){
					cur -=1;
					$(this).removeClass("active");
					$(".page"+cur).addClass("active");
				}
			}
		});
	};
}
function join(){
	cur +=1;
	$(".page2").removeClass("active");
    $(".page3").addClass("active");
}
function show_code(){
	$(".code_cover").show();
	$(".code_div").show();
}
function check(){
	var name = $("#name").val();//姓名
	var address = $("#address").val();//地址
	var phone = $("#phone").val();//地址
	var re1 = /^0?1[3|7|5|8][0-9]\d{8}$/;
	
	if(name==""||name.length==0){
		alert("请输入姓名");
		return false;
	}else if(name.length>5){
		alert("姓名长度最长为5位");
		return false;
	}
	if(address==""||address.length==0){
		alert("请输入地址");
		return false;
	}else if(address.length>50){
		alert("地址长度最长为50位");
		return false;
	}
			
	if(phone==""||phone.length==0){
		alert("请输入手机号！");
		return false;
	}else if(!re1.test(phone)){
  		alert("请输入正确的手机号码");
		return false;
 	}
	return true;
}