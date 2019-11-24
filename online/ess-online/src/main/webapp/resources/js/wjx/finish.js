$(".radio_img").click(function(){
	if($(this).prev().prop("checked")==false){
		$(".radio_img").css("background-position-y","-18px");
		$(this).css("background-position-y","0");
		$(this).prev().prop("checked",true);
	}
});