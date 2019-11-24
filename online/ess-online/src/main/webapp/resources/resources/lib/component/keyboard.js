//处理软键盘打开后的输入框居中，之后要把代码移动位置
$('body').on('focus','input[type=text],input[type=number]',function(){
	
	var $this = $(this);
	var $content = $this.parents('.content');
	
	//iOS需要特殊处理
	if(sino.os.name == 'iOS'){
		
		if(sino.keyboard.closeToggle){
			clearTimeout(sino.keyboard.closeToggle); 
		}
		
		//如果软键盘已经开启，则不执行后续操作
		if(sino.keyboard.open){
			return;
		}
		
		
		sino.keyboard.open = true;
		
		setTimeout(function(){
			
			var top = $this.offset().top;
			var height = document.documentElement.clientHeight;
			var scrollTop = $('body').scrollTop();
			var keyboardHeight = 216*2; //ios软键盘高度，不包含选字条
			var afterHeight = height-keyboardHeight;
			var center = (afterHeight)/2 - $this.height()/2;
			
			var offset = 20;
			
			if(top + scrollTop  < center + offset  && top + scrollTop  > center - offset ){
				return;
			}else{
				$('body').scrollTop(top + scrollTop - center);
			}
		},500);
	}else{
		setTimeout(function(){
			var top = $this.position().top;
			var height = document.documentElement.clientHeight;
			$content.scrollTop(top - height/2);
		},500);
	}
}).on('blur','input[type=text],input[type=number]',function(){
	if(sino.os.name == 'iOS'){
		sino.keyboard.closeToggle = setTimeout(function(){
			sino.keyboard.open = false;
		},500);
	}
});

function keyboardStatusChange(){
	
	if(sino.os.name == 'Android'){
		var height = document.documentElement.clientHeight;
		
		if(height < 600){
			sino.keyboard.open = true;
		}else{
			sino.keyboard.open = false;
		}
	}
}
