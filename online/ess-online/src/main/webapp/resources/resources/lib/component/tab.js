+function ($) { "use strict";
  $(document).ready(function(){
    $('[data-toggle=tab]').on('click',function(){
      var target = $(this).attr('data-target');
      
      $(this).addClass('active');
      $(this).siblings().removeClass('active');
      
      $(target).addClass('active');
      $(target).siblings().removeClass('active');
      return false;
    });
  });
}(jQuery);