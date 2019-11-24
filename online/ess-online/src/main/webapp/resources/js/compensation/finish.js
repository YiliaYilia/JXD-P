$(".radio_img").click(function(){
	if($(this).prev().prop("checked")==false){
		$(".radio_img").css("background-position-y","-18px");
		$(".radio_img").prev().prop("checked",false);
		$(this).css("background-position-y","0");
		$(this).prev().prop("checked",true);
	}
});
function backshow(){
	$(":radio:not(checked)").next().css("background-position-y","-18px");
	$(":radio:checked").next().css("background-position-y","0");
}
