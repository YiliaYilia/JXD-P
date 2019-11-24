$(document).ready(function(){
    $('.product-d-lb').on(tap,function(){
      var $this 				= $(this);
      var $parent 			= $this.parent();
      var $con 				= $this.next();
      
      if($this.hasClass('active')){
    	  $this.removeClass('active');
          $con.removeClass('active');
          resizeContent($con);
    	  return;
      }
      $this.addClass('active');
      $con.addClass('active');
      resizeContent($con);
      
      var $prevParent 	= $parent.siblings();
     
      $prevParent.find('.product-d-con').removeClass('active');
      $prevParent.find('.product-d-lb').removeClass('active');
      
      $('.banner')[0].offsetWidth;
      
      return false;
    });
    
    $("#buyNow-top").on("click",function(){
    	$("#buyNow").submit();
    });
    
    $("#buyNow-bottom").on("click",function(){
    	$("#buyNow-2").submit();
    });
    
});

function resizeContent($con){
	
	if($con.css('position') != 'absolute'){
		return;
	}
	
	var height = $con.height();
	var minHeight = $('.product-d-lb').outerHeight()*6;
	
	if(height < minHeight){
		height = minHeight;
	}
	
	$('.product-detail').css('height',height);
}

$(document).ready(function(){
	var productCode = $("#productCode").val();
	var isBack = $("#isBack").val();
	$.ajax({
		   type:"POST",
		   url: contentRootPath+"/msl/sales/dealCount",
		   data: {"policy.prodoctcode":productCode},
		   dataType:"json",
		   success:function(data){
			   var num = data.orderList.length;
			   $("#count").text(num);
			}
		});
});

//
//var funTransitionHeight = function(element, time) { // time, 数值，可缺省
//    if (typeof window.getComputedStyle == "undefined") return;
//    
//    var height = window.getComputedStyle(element).height;
//    element.style.height = "auto";
//    var targetHeight = window.getComputedStyle(element).height;
//    element.style.height = height;
//    setTimeout(function() {
//        if (time) element.style.transition = "height "+ time +"ms";
//        element.style.height = targetHeight;
//    }, 15);
//};
//
//var closeContent = function($el){
//	if(!$el){
//		return;
//	}
//	$el[0].style.transition = "height 500ms";
//	
//	$el.css('height',0);
//	
//	setTimeout(function(){
//		$el.removeClass('active');
//	},500);
//};