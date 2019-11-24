$(document).ready(function(){
	
	if(window.applicationCache){
		return;
	}
	
	$('.form-checkbox label').on('click',function(){
		var $this = $(this);
		if($this.hasClass('checked')){
			$this.removeClass('checked');
		}else{
			$this.addClass('checked');
		}
	});
});