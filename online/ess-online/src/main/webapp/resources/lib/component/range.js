+function($) {
	
	var Range = function(element, options){
		this.options = options;
		this.$element = $(element);
		this.init();
	};
	Range.DEFAULTS = {
		
	};
	
	Range.prototype.init = function(){
		
		var that = this;
		that.$options = that.$element.find('option');
		that.size = that.$options.length;
		that.py = 0;
		that.lastX = 0;
		
		//初始化控件
		that.$range = $('<div class="range">'+
				'<div class="range-mark"></div>'+
				'<div class="range-bar"><p><b></b></p></div>'+
				'<div class="range-ruler"></div>'+
			'</div>');
		
		that.$rangeRuler = that.$range.find('.range-ruler');
		that.$rangeBody = that.$range.find('.range-bar');
		that.$rangeBar = that.$range.find('.range-bar p');
		that.$rangeRadio = that.$range.find('.range-bar b');
		that.$rangeMark = that.$range.find('.range-mark');
		
		that.$element.before(that.$range);
		that.$element.hide();
		
		that.initPosition();
		that.initBar();
		that.initRuler();
		that.initMark();
		
//		that.$rangeRadio.on('movestart',function(e){
//			that.startMove();
//		}).on('move',function(e){
//			
//			var x = e.distX;
//			
//			var width = that.$rangeBar.width() + (x - that.lastX);
//			console.log('fx : ' + (x - that.lastX));
//			console.log('width : ' + (width));
//			var totalWidth = that.$rangeBody.width();
//			that.py = (width / totalWidth ) * 100;
//			console.log('py : ' + that.py);
//			that.$rangeBar.css('width',that.py + '%');
//			that.$rangeBar[0].offsetWidth;
//			console.log('cwidth : ' + that.$rangeBar.width());
//			that.lastX = x;
//			
//		}).on('moveend',function(){
//			that.endMove();
//		});
		
		that.$rangeBody.on('click',function(e){
			
			if(that.size == 1){
				return;
			}
			
			var x = e.offsetX;
			var width =  x;
			var totalWidth = that.$rangeBody.width();
			that.py = (width / totalWidth ) * 100;
			that.$rangeBar.css('width',that.py + '%');
			that.$rangeBar.offsetWidth;
			
			that.autoMatch();
		});
	};
	Range.prototype.initPosition = function(){
		var that = this;
		
		that.posList = [];
		
		if(that.size == 1){
			that.posList.push(50);
			return;
		}
		
		that.posList.push(0);
		
		for(var i = 1 ; i < that.size - 1 ; i ++){
			that.posList.push(100 * i /  (that.size - 1));
		}
		
		that.posList.push(100);
	};
	
	//初始化进度条
	Range.prototype.initBar = function(){
		var that = this;
		var selectIndex = that.$element.find(':selected').index();
		that.py = that.posList[selectIndex];
		that.$rangeBar.css('width',that.py + '%');
	};
	
	//初始化下标
	Range.prototype.initRuler = function(){
		var that = this;
		that.$rangeRuler.empty();
		that.$options.each(function(index){
			var $r = $('<span>'+this.innerText+'</span>');
			
			if(index == that.size - 1 && that.size > 1){
				$r.css('right',0);
			}else{
				$r.css('left',that.posList[index] + '%');
			}
			that.$rangeRuler.append($r);
		});
		
		that.$rangeRuler[0].offsetWidth;
		
		var start = that.size > 1 ? 1 : 0;
		var end = that.size > 1 ? that.size - 1 : 1;
		
		for(var i = start ; i < end ; i ++){
			var $r = that.$rangeRuler.find('span:eq('+i+')');
			$r.css('margin-left','-' +$r.width()/2 + 'px');
		}
	};
	
	//初始化标尺
	Range.prototype.initMark = function(){
		var that = this;
		that.$rangeMark.empty();
		for(var i = 0 ; i < that.size ; i ++){
			var $i = $('<i></i>');
			
			if(i == that.size - 1 && that.size > 1){
				$i.css('right',0);
			}else{
				$i.css('left',that.posList[i] + '%');
			}
			
			that.$rangeMark.append($i);
		}
	};
	
	
	Range.prototype.startMove = function(){
		var that = this;
		that.$rangeBar.addClass('linear');
		that.lastX = 0;
	};
	
	Range.prototype.endMove = function(){
		var that = this;
		that.$rangeBar.removeClass('linear');
		that.lastX = 0;
		
		that.autoMatch();
	};
	
	Range.prototype.autoMatch = function(){
		var that = this;
		var start = 0,end = 0,index = 0;
		
		for(var i = 0 ; i < that.size ; i ++){
			var pos = that.posList[i];
			if(that.py < pos){
				start = that.posList[i - 1];
				end = pos;
				index = i;
				break;
			}
		}
		
		var left = Math.abs(start - that.py);
		var right = Math.abs(end - that.py);
		
		if(left < right){
			that.py = start;
			index = index - 1;
		}else{
			that.py = end;
		}
		that.$rangeBar.removeClass().addClass('ease');
		
		that.$rangeBar.css('width',that.py + '%');
		
		that.$element[0].selectedIndex = index;
	};
	
	Range.prototype.update = function(){
		
		var that = this;
		
		that.$options = that.$element.find('option');
		that.size = that.$options.length;
		that.py = 0;
		that.lastX = 0;
		
		that.initPosition();
		that.initBar();
		that.initRuler();
		that.initMark();
	};
	
	// RANGE PLUGIN DEFINITION
	// =======================

	var old = $.fn.range;

	$.fn.range = function(option, _relatedTarget) {
		
		return this.each(function() {
			var $this = $(this);
			var data = $this.data('range');
			var options = $.extend({}, Range.DEFAULTS, $this.data(), typeof option == 'object' && option);

			if (!data){
				$this.data('range', (data = new Range(this, options)));
			}else{
				data.update();
			}
			
//			if (typeof option == 'string') {
//				data[option](_relatedTarget);
//			} 
		});
	};
	
	$.fn.range.Constructor = Range;
	

	$.fn.range.noConflict = function() {
		$.fn.range = old;
		return this;
	};
	
}(jQuery);